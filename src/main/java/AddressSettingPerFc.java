import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MerchantAddressPerFc POJO
 *
 * To store different fields required by DynamoDb table.
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressSettingPerFc {
    private BaseAddress address;
    private String externalAddressId;
    private String fcId;
}
