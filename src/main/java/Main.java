import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchema;
import com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@DynamoDBTable(tableName = "Main")
public class Main {

    private static final String EFFECTIVE_FROM_DATE_TIMESTAMP_KEY = ":effectiveFromDateTimestamp";
    private static final String EFFECTIVE_THROUGH_DATE_NULL_TIMESTAMP_KEY = ":effectiveThroughDateNullTimestamp";
    private static final String OPERATOR_GT = " > ";
    private static final String OPERATOR_OR = " OR ";
    private static final String OPERATOR_EQ = " = ";

    @DynamoDBHashKey(attributeName = "Id")
    private Integer id;
    private String title;
    private String ISBN;
    private Set<String> bookAuthors;
    private String someProp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "ISBN")
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @DynamoDBAttribute(attributeName = "Authors")
    public Set<String> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<String> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    @DynamoDBIgnore
    public String getSomeProp() {
        return someProp;
    }

    public void setSomeProp(String someProp) {
        this.someProp = someProp;
    }

    public static void main(String args[]) throws ParseException {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .build();

        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder().withConversionSchema(ConversionSchemas.V2).build();
        DynamoDBMapper mapper = new DynamoDBMapper(client, new DynamoDBMapperConfig(ConversionSchemas.V2));

//        createTable(client, mapper);
        insert(mapper);

//        AutoRemovalSetting nar = mapper.load(AutoRemovalSetting.class, "1234_1234_AR3", generateTime());
//        System.out.println(nar.getEffectiveFromDate());
        query(mapper);

    }

    public static void createTable(AmazonDynamoDB client, DynamoDBMapper mapper){
        CreateTableRequest req = mapper.generateCreateTableRequest(AutoRemovalSetting.class);
        System.out.println(req.getKeySchema());

        req.setProvisionedThroughput(new ProvisionedThroughput(2l, 2l));
        client.createTable(req);
        System.out.println("create table successfully");
    }

    public static void insert(DynamoDBMapper mapper){

        AutoRemovalSetting ar = new AutoRemovalSetting();
        ar.setMCIdMPIdARType("1234_1234_AR3");
        ar.setEffectiveFromDate(generateTime());
        GLASPRule rule = new GLASPRule();
        rule.setEnable(true);
        rule.setMinPrice(12);
        rule.setMaxPrice(1);
        rule.setCurrency("USD");
        ar.setPolicyRules(new HashSet<GLASPRule>());
        ar.getPolicyRules().add(rule);

        mapper.save(ar);
        System.out.println("insert done");
    }

    public static Date generateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2017-01-01");
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void query(DynamoDBMapper mapper){
        Date effectiveFromDate = new Date();
        System.out.println(effectiveFromDate);
        AutoRemovalSetting hashKey = new AutoRemovalSetting();
        String hashKeyStrValue = "1234_1234_AR3";
        hashKey.setMCIdMPIdARType(hashKeyStrValue);

//        DateUtils.formatISO8601Date(effectiveFromDate);

        Condition rangeKeyCondition = new Condition()
                .withComparisonOperator(ComparisonOperator.LE.toString())
                .withAttributeValueList(new AttributeValue().withS(DateUtils.formatISO8601Date(effectiveFromDate)));

        System.out.println(rangeKeyCondition);

        StringBuilder filterExpression = new StringBuilder();
        filterExpression.append(AutoRemovalSettingUtil.DDB_ATTR_EFFECTIVE_THROUGH_DATE_NAME)
                .append(OPERATOR_GT)
                .append(EFFECTIVE_FROM_DATE_TIMESTAMP_KEY)
                .append(OPERATOR_OR)
                .append("attribute_not_exists(EFFECTIVE_THROUGH_DATE)");
//                .append(AutoRemovalSettingUtil.DDB_ATTR_EFFECTIVE_THROUGH_DATE_NAME)
//                .append(OPERATOR_EQ)
//                .append(EFFECTIVE_THROUGH_DATE_NULL_TIMESTAMP_KEY);

        HashMap<String, AttributeValue> filterExpressionArgs = new HashMap<String, AttributeValue>();
        filterExpressionArgs.put(EFFECTIVE_FROM_DATE_TIMESTAMP_KEY,
                new AttributeValue().withN(Long.toString(effectiveFromDate.getTime())));
//        filterExpressionArgs.put(EFFECTIVE_THROUGH_DATE_NULL_TIMESTAMP_KEY,
//                new AttributeValue().withN(AutoRemovalSettingUtil.DDB_ATTR_EFFECTIVE_THROUGH_DATE_NULL_VALUE_STRING));

        //TODO just for test
        System.out.println("==FEXP: " + filterExpression);

        DynamoDBQueryExpression<AutoRemovalSetting> queryExpression = new DynamoDBQueryExpression<AutoRemovalSetting>()
                .withHashKeyValues(hashKey)
                .withRangeKeyCondition(AutoRemovalSettingUtil.DDB_TABLE_RANGE_KEY_NAME, rangeKeyCondition)
                .withFilterExpression(filterExpression.toString())
                .withExpressionAttributeValues(filterExpressionArgs);

        List<AutoRemovalSetting> queryResult = mapper.query(AutoRemovalSetting.class, queryExpression);
        System.out.println(queryResult.size());
        System.out.println(queryResult.get(0));
        System.out.println();

        Iterator<GLASPRule> it = queryResult.get(0).getPolicyRules().iterator();
        while(it.hasNext()){
            GLASPRule pr = it.next();
            System.out.println(pr.getMaxPrice());
        }
    }
}