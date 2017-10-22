import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

/**
 * AutoRemovalSetting POJO
 * <p>
 * Mapping to MAR_OPTIONS table in database.
 *
 * @author gefei, jinruiz
 */
@DynamoDBTable(tableName = "MAR_OPTIONS")
public class AutoRemovalSetting extends BaseEntity {

    public static final String OPTION_TYPE_RETURN = "RETURN";
    public static final String OPTION_TYPE_DESTROY = "DESTROY";
    public static final String OPTION_TYPE_MIX = "MIX_TYPE";
    public static final String STATUS_NEW_CREATED = "NEW_CREATED";
    public static final String STATUS_UPDATED = "UPDATED";
    public static final String TYPE_AUTO_UNSELLABLE = "AUTO_UNSELLABLE";
    public static final String TYPE_AUTO_AGED = "AUTO_AGED";
    public static final String TYPE_REMOVAL_UI_ADDRESS = "REMOVAL_UI_ADDRESS";
    public static final String[] VALID_AUTO_REMOVAL_TYPES = new String[]{TYPE_AUTO_UNSELLABLE, TYPE_AUTO_AGED};
    private static final long serialVersionUID = -1238854540010683145L;

    private String MCIdMPIdARType;

    @DynamoDBAttribute(attributeName = "MERCHANT_CUSTOMER_ID")
    private long merchantCustomerId;

    @DynamoDBAttribute(attributeName = "MR_FULFILLMENT_CHANNEL")
    private String fulfillmentChannel;

    @DynamoDBAttribute(attributeName = "MAR_FREQUENCY")
    private String frequency;

    @DynamoDBAttribute(attributeName = "IS_ENABLED")
    private boolean enable;

    @DynamoDBAttribute(attributeName = "AUTO_REMOVAL_TYPE")
    private String autoRemovalType;

    @DynamoDBRangeKey(attributeName = "EFFECTIVE_FROM_DATE")
    private Date effectiveFromDate;

    @DynamoDBAttribute(attributeName = "EFFECTIVE_THROUGH_DATE")
    private Date effectiveThroughDate;

    @DynamoDBAttribute(attributeName = "EMAIL_CONTACT_ADDRESS")
    private String emailContactAddress;

    @DynamoDBAttribute(attributeName = "STATUS_NAME")
    private String statusName;

    @DynamoDBAttribute(attributeName = "STATUS_CHANGE_DATE")
    private Date statusChangeDate;

    @DynamoDBAttribute(attributeName = "SIGN_UP_DATE")
    private Date signUpDate;

    @DynamoDBIgnore
    private long optionId;

    @DynamoDBAttribute(attributeName = "OPTION_TYPE")
    private String optionType;

    @DynamoDBAttribute(attributeName = "HOME_MARKETPLACE_ID")
    private Long homeMarketplaceId;

    @DynamoDBAttribute(attributeName = "MARKETPLACE_ID")
    private Long marketplaceId;

    @DynamoDBAttribute(attributeName = "EXTERNAL_ADDRESS_ID")
    private String externalAddressId;

//    @DynamoDBIgnore
    @DynamoDBAttribute(attributeName = "MAR_RULE_INSTANCES")
    @DynamoDBTyped
//    private Set<PolicyRule> policyRules = new HashSet<PolicyRule>();
    private Set<GLASPRule> policyRules;

    @DynamoDBAttribute(attributeName = "CREATED_BY")
    private String createdBy;

    @DynamoDBAttribute(attributeName = "CREATION_DATE")
    private Date creationDate;

    @DynamoDBAttribute(attributeName = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @DynamoDBAttribute(attributeName = "LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @DynamoDBIgnore
    private BaseAddress address;
    @DynamoDBIgnore
    private List<AddressSettingPerFc> addressSettingPerFc;
    @DynamoDBIgnore
    private List<String> addressSettingPerFcFailedFcId;

    public List<String> getAddressSettingPerFcFailedFcId() {
        return addressSettingPerFcFailedFcId;
    }

    public void setAddressSettingPerFcFailedFcId(List<String> addressSettingPerFcFailedFcId) {
        this.addressSettingPerFcFailedFcId = addressSettingPerFcFailedFcId;
    }

    public List<AddressSettingPerFc> getAddressSettingPerFc() {
        return addressSettingPerFc;
    }

    public void setAddressSettingPerFc(List<AddressSettingPerFc> addressSettingPerFc) {
        this.addressSettingPerFc = addressSettingPerFc;
    }

    public String getExternalAddressId() {
        return externalAddressId;
    }

    public void setExternalAddressId(String externalAddressId) {
        this.externalAddressId = externalAddressId;
    }

    @DynamoDBHashKey(attributeName = "MCID_MPID_ARTYPE")
    public String getMCIdMPIdARType() {
        return MCIdMPIdARType;
    }

    public void setMCIdMPIdARType(String MCIdMPIdARType) {
        this.MCIdMPIdARType = MCIdMPIdARType;
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public long getMerchantCustomerId() {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(long merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getFulfillmentChannel() {
        return fulfillmentChannel;
    }

    public void setFulfillmentChannel(String fulfillmentChannel) {
        this.fulfillmentChannel = fulfillmentChannel;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getAutoRemovalType() {
        return autoRemovalType;
    }

    public void setAutoRemovalType(String autoRemovalType) {
        this.autoRemovalType = autoRemovalType;
    }

    public Date getEffectiveFromDate() {
        return effectiveFromDate == null ? null : (Date) effectiveFromDate
                .clone();
    }

    public void setEffectiveFromDate(Date effectiveFromDate) {
        this.effectiveFromDate = (effectiveFromDate == null ? null
                : (Date) effectiveFromDate.clone());
    }

    public Date getEffectiveThroughDate() {
        return effectiveThroughDate == null ? null
                : (Date) effectiveThroughDate.clone();
    }

    public void setEffectiveThroughDate(Date effectiveThroughDate) {
        this.effectiveThroughDate = (effectiveThroughDate == null ? null
                : (Date) effectiveThroughDate.clone());
    }

    public String getEmailContactAddress() {
        return emailContactAddress;
    }

    public void setEmailContactAddress(String emailContactAddress) {
        this.emailContactAddress = emailContactAddress;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getStatusChangeDate() {
        return statusChangeDate == null ? null
                : (Date) statusChangeDate.clone();
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = (statusChangeDate == null ? null
                : (Date) statusChangeDate.clone());
    }

    public Date getSignUpDate() {
        return signUpDate == null ? null : (Date) signUpDate.clone();
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = (signUpDate == null ? null
                : (Date) signUpDate.clone());
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public Long getHomeMarketplaceId() {
        return homeMarketplaceId;
    }

    public void setHomeMarketplaceId(Long homeMarketplaceId) {
        this.homeMarketplaceId = homeMarketplaceId;
    }

    public Long getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(Long marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public Set<GLASPRule> getPolicyRules() {
        return policyRules;
    }

    public void setPolicyRules(Set<GLASPRule> policyRules) {
        this.policyRules = policyRules;
    }

    public BaseAddress getAddress() {
        return address;
    }

    public void setAddress(BaseAddress address) {
        this.address = address;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @DynamoDBIgnore
    @Override
    protected Object[] getBusinessProperties() {
        return new Object[]
                {merchantCustomerId, marketplaceId, autoRemovalType};
    }

    @DynamoDBIgnore
    @Override
    public String getSimpleClassName() {
        return AutoRemovalSetting.class.getSimpleName();
    }

    //TODO how much information should be present?
    public String toString(){
        return this.MCIdMPIdARType;
    }

}
