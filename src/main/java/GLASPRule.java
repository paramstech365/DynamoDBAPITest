import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;

/**
 * 
 * GLASPRule is a rule with price boundary and gl group information.
 * 
 * */
@DynamoDBDocument
//public class GLASPRule
public class GLASPRule extends BaseRule implements PolicyRule
{

    private static final long serialVersionUID = -1771160684526465482L;

    @DynamoDBAttribute(attributeName = "MIN_PRICE")
    private double minPrice;

    @DynamoDBAttribute(attributeName = "MAX_PRICE")
    private double maxPrice;

    @DynamoDBAttribute(attributeName = "CURRENCY_CODE")
    private String currency;

    @DynamoDBAttribute(attributeName = "GL_PRODUCT_GROUP")
    private String glProductGroup;

    @DynamoDBAttribute(attributeName = "GL_PRODUCT_GROUP_ID")
    private long glProductGroupId;


    public GLASPRule()
    {
        super();
        super.setRuleType(RULE_TYPE_ASP_BAND);
    }
    
    @Override
    @DynamoDBIgnore
    public Object[] getBusinessProperties()
    {
        return new Object[]{getRuleId(),getRuleDecision(),getRuleType(),isEnable(),getLevel(),maxPrice,minPrice};
    }

    public String getSimpleClassName() {
        return null;
    }

    public double getMinPrice()
    {
        return minPrice;
    }

    public void setMinPrice(double minPrice)
    {
        this.minPrice = minPrice;
    }

    public double getMaxPrice()
    {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice)
    {
        this.maxPrice = maxPrice;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getGlProductGroup()
    {
        return glProductGroup;
    }

    public void setGlProductGroup(String glProductGroup)
    {
        this.glProductGroup = glProductGroup;
    }

    public long getGlProductGroupId()
    {
        return glProductGroupId;
    }

    public void setGlProductGroupId(long glProductGroupId)
    {
        this.glProductGroupId = glProductGroupId;
    }

    public int compareTo(PolicyRule o) {
        return 0;
    }
}
