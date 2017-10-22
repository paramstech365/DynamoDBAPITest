public class Address extends BaseAddress
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -1877944545837178360L;
    
    private long merchantCustomerId;
    
    private String addressLabel;
    
    private Long addressId;

    
    public long getMerchantCustomerId()
    {
        return merchantCustomerId;
    }

    public void setMerchantCustomerId(long merchantCustomerId)
    {
        this.merchantCustomerId = merchantCustomerId;
    }

    public String getAddressLabel()
    {
        return addressLabel;
    }

    public void setAddressLabel(String addressLabel)
    {
        this.addressLabel = addressLabel;
    }

    public Long getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    @Override
    protected Object[] getBusinessProperties()
    {
        return new Object[]
        { merchantCustomerId,addressLabel};
    }

    @Override
    public String getSimpleClassName()
    {
        return Address.class.getSimpleName();
    }

}
