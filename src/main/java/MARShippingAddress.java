public class MARShippingAddress extends BaseAddress
{

    /**
     * 
     */
    private static final long serialVersionUID = 5147020425163147819L;

    private Long removalAddressId;
    private long merchantCustomerId;
    private String autoRemovalType;
    private String addressLabel;

    public Long getRemovalAddressId()
    {
        return removalAddressId;
    }

    public void setRemovalAddressId(Long removalAddressId)
    {
        this.removalAddressId = removalAddressId;
    }

    public long getMerchantCustomerId()
    {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(long merchantCustomerId)
    {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getAutoRemovalType()
    {
        return autoRemovalType;
    }

    public void setAutoRemovalType(String autoRemovalType)
    {
        this.autoRemovalType = autoRemovalType;
    }

    public String getAddressLabel()
    {
        return addressLabel;
    }

    public void setAddressLabel(String addresLabel)
    {
        this.addressLabel = addresLabel;
    }

    @Override
    protected Object[] getBusinessProperties()
    {
        return new Object[]
        { merchantCustomerId, autoRemovalType, addressLabel, super.getCountryCode() };
    }

    @Override
    public String getSimpleClassName()
    {
        return this.getClass().getSimpleName();
    }
}
