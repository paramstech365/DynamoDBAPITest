import java.util.Date;

public class BaseAddress extends BaseEntity
{
    /**
     * 
     */
    private static final long serialVersionUID = -4090585042816440670L;

    public static final String AUTO_REMOVAL_ADDRESS_LABEL = "Auto Removal Address";
    public static final String REMOVAL_UI_ADDRESS_LABEL = "Removal UI Address";
    
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String contactName;
    private String countryCode;
    private String countryName;
    private String city;
    private String district;
    private String phone;
    private String postalCode;
    private String region;
    private boolean inActive;
    private String inActiveStr;
    private Date lastUsedDate;
    private String addressServiceId;

    public String getAddressLine1()
    {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }
    public String getAddressLine3()
    {
        return addressLine3;
    }
    public void setAddressLine3(String addressLine3)
    {
        this.addressLine3 = addressLine3;
    }
    public String getContactName()
    {
        return contactName;
    }
    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }
    public String getCountryName()
    {
        return countryName;
    }
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getDistrict()
    {
        return district;
    }
    public void setDistrict(String district)
    {
        this.district = district;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public String getPostalCode()
    {
        return postalCode;
    }
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }
    public String getRegion()
    {
        return region;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }
    public boolean isInActive()
    {
        return inActive;
    }
    public void setInActive(boolean inActive)
    {
        this.inActive = inActive;
    }
    public String getInActiveStr()
    {
        return inActiveStr;
    }
    public void setInActiveStr(String inActiveStr)
    {
        this.inActiveStr = inActiveStr;
    }
    public Date getLastUsedDate()
    {
        return this.lastUsedDate == null ? null
                : (Date) lastUsedDate.clone();
    }
    public void setLastUsedDate(Date lastUsedDate)
    {
        this.lastUsedDate = (lastUsedDate == null ? null
                : (Date) lastUsedDate.clone());
    }
    public String getAddressServiceId()
    {
        return addressServiceId;
    }
    public void setAddressServiceId(String addressServiceId)
    {
        this.addressServiceId = addressServiceId;
    }
    @Override
    protected Object[] getBusinessProperties()
    {
        return new Object[]{
            addressLine1,addressLine2,addressLine3,region,contactName,countryCode
        };
    }
    @Override
    public String getSimpleClassName()
    {
        return this.getClass().getSimpleName();
    }
    
    
}
