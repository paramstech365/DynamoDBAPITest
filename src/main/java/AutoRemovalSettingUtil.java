/**
 * Created by jinruiz on 7/18/17.
 */
public class AutoRemovalSettingUtil {

    public static final String DDB_TABLE_NAME = "MAR_OPTIONS";
    public static final String DDB_TABLE_HASH_KEY_NAME = "MCID_MPID_ARTYPE";
    public static final String DDB_TABLE_RANGE_KEY_NAME = "EFFECTIVE_FROM_DATE";
    public static final String DDB_ATTR_EFFECTIVE_THROUGH_DATE_NAME = "EFFECTIVE_THROUGH_DATE";
    public static final String DDB_ATTR_EFFECTIVE_THROUGH_DATE_NULL_VALUE_STRING = "-1";

    public static String generateMCIdMPIdARType(long merchantCustomerId, long marketplaceId, String autoRemovalType){
        StringBuilder mcIdMPIdARType = new StringBuilder();
        return mcIdMPIdARType.append(merchantCustomerId)
                             .append("_")
                             .append(marketplaceId)
                             .append("_")
                             .append(autoRemovalType)
                             .toString();
    }
}
