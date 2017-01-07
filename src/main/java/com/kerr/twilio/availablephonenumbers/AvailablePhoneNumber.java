
package com.kerr.twilio.availablephonenumbers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailablePhoneNumber {

    @SerializedName("friendly_name")
    @Expose
    private String friendlyName;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("lata")
    @Expose
    private String lata;
    @SerializedName("rate_center")
    @Expose
    private String rateCenter;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("iso_country")
    @Expose
    private String isoCountry;
    @SerializedName("address_requirements")
    @Expose
    private String addressRequirements;
    @SerializedName("beta")
    @Expose
    private Boolean beta;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLata() {
        return lata;
    }

    public String getRateCenter() {
        return rateCenter;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public String getAddressRequirements() {
        return addressRequirements;
    }

    public Boolean getBeta() {
        return beta;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

}
