import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * Created by jinruiz on 7/18/17.
 */
@DynamoDBDocument
public class PolicyRuleForDDB {

    private int level;
    private String ruleType;
    private double minPrice;
    private double maxPrice;
    private String currency;
    private String glProductGroup;
    private long glProductGroupId;
    private boolean enable;
    private String ruleDecision;

    @DynamoDBAttribute(attributeName = "RULE_LEVEL")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @DynamoDBAttribute(attributeName = "RULE_TYPE")
    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    @DynamoDBAttribute(attributeName = "MIN_PRICE")
    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    @DynamoDBAttribute(attributeName = "MAX_PRICE")
    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @DynamoDBAttribute(attributeName = "CURRENCY_CODE")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @DynamoDBAttribute(attributeName = "GL_PRODUCT_GROUP")
    public String getGlProductGroup() {
        return glProductGroup;
    }

    public void setGlProductGroup(String glProductGroup) {
        this.glProductGroup = glProductGroup;
    }

    @DynamoDBAttribute(attributeName = "GL_PRODUCT_GROUP_ID")
    public long getGlProductGroupId() {
        return glProductGroupId;
    }

    public void setGlProductGroupId(long glProductGroupId) {
        this.glProductGroupId = glProductGroupId;
    }

    @DynamoDBAttribute(attributeName = "IS_ENABLED")
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @DynamoDBAttribute(attributeName = "ACTION")
    public String getRuleDecision() {
        return ruleDecision;
    }

    public void setRuleDecision(String ruleDecision) {
        this.ruleDecision = ruleDecision;
    }
}
