import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;

/**
 * 
 * BaseRule includes basic properties of Rule instance.
 * 
 * 
 * @author gefei, jinruiz
 * 
 * 
 */
@DynamoDBDocument
public abstract class BaseRule extends BaseEntity implements PolicyRule
{

    public static final int LEVEL_GL_PRICE_BOTH = 100;
    public static final int LEVEL_GL_CARE = 200;
    public static final int LEVEL_PRICE_CARE = 300;
    public static final int LEVEL_CARELESS = 400;

    private static final long serialVersionUID = -5623305550066268894L;

    @DynamoDBAttribute(attributeName = "RULE_LEVEL")
    private int level;

    @DynamoDBAttribute(attributeName = "RULE_TYPE")
    private String ruleType;

    @DynamoDBIgnore
    private long ruleId;

    @DynamoDBAttribute(attributeName = "ACTION")
    private String ruleDecision;

    @DynamoDBAttribute(attributeName = "IS_ENABLED")
    private boolean enable; 

    @Override
    public Object[] getBusinessProperties()
    {
        return new Object[]
        { ruleId };
    }

    public String getRuleDecision()
    {
        return ruleDecision;
    }

    public void setRuleDecision(String ruleDecision)
    {
        this.ruleDecision = ruleDecision;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public String getRuleType()
    {
        return ruleType;
    }

    public void setRuleType(String ruleType)
    {
        this.ruleType = ruleType;
    }

    public long getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(long ruleId)
    {
        this.ruleId = ruleId;
    }

    public boolean isEnable()
    {
        return enable;
    }

    public void setEnable(boolean enable)
    {
        this.enable = enable;
    }


}
