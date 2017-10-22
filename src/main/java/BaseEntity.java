import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

/**
 * BaseEntity implements basic methods for a mapping entity.
 * 
 * @author gefei
 * 
 */
@DynamoDBDocument
public abstract class BaseEntity implements Serializable
{

    private static final long serialVersionUID = 4625407583511323254L;

    protected abstract Object[] getBusinessProperties();

    public abstract String getSimpleClassName();

}
