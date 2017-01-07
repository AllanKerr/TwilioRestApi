
package com.kerr.twilio.availablephonenumbers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhoneNumberResponse {

    @SerializedName("available_phone_numbers")
    @Expose
    private List<AvailablePhoneNumber> availablePhoneNumbers = null;
    @SerializedName("uri")
    @Expose
    private String uri;

    public List<AvailablePhoneNumber> getAvailablePhoneNumbers() {
        return availablePhoneNumbers;
    }

    public String getUri() {
        return uri;
    }
}
