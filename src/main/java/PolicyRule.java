import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * PolicyRule interface
 * 
 * A policyRule contains Decision,level and enable at least.
 * 
 * @author gefei
 * 
 * */
@DynamoDBDocument
public interface PolicyRule extends Comparable<PolicyRule>
{
    
    public static final String RULE_TYPE_ASP_BAND = "ASP_BAND"; 

    public int getLevel();

    public String getRuleDecision();

    public boolean isEnable();
    
    public void setEnable(boolean enable);
}
