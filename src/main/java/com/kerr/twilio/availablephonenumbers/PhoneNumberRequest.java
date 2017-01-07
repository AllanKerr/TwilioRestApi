package com.kerr.twilio.availablephonenumbers;

import com.google.gson.Gson;
import com.kerr.request.RequestMethod;
import com.kerr.twilio.TwilioRequest;

import java.io.IOException;
import java.util.List;

/**
 * Created by allankerr on 2017-01-06.
 */
public class PhoneNumberRequest extends TwilioRequest<List<AvailablePhoneNumber>> {

    protected String getEndPointURL() {
        return "Local.json";
    }

    protected RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    public PhoneNumberRequest(String accountSid, String authToken, String countryCode, PhoneNumberType type) {
        super(accountSid, authToken, "AvailablePhoneNumbers/" + countryCode + "/" + type.getPathComponent() + ".json");
        System.out.println(type.name());
    }

    public PhoneNumberRequest setAreaCode(Integer areaCode) {
        builder.parameter("AreaCode", areaCode.toString());
        return this;
    }

    public PhoneNumberRequest setContains(String contains) {
        builder.parameter("Contains", contains);
        return this;
    }

    public PhoneNumberRequest setSmsEnabled(Boolean smsEnabled) {
        builder.parameter("SmsEnabled", smsEnabled.toString());
        return this;
    }

    public PhoneNumberRequest setMmsEnabled(Boolean mmsEnabled) {
        builder.parameter("MmsEnabled", mmsEnabled.toString());
        return this;
    }

    public PhoneNumberRequest setVoiceEnabled(Boolean voiceEnabled) {
        builder.parameter("VoiceEnabled", voiceEnabled.toString());
        return this;
    }

    public PhoneNumberRequest setExcludeAllAddressRequired(Boolean excludeAllAddressRequired) {
        builder.parameter("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        return this;
    }

    public PhoneNumberRequest setExcludeLocalAddressRequired(Boolean excludeLocalAddressRequired) {
        builder.parameter("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        return this;
    }

    public PhoneNumberRequest setExcludeForeignAddressRequired(Boolean excludeForeignAddressRequired) {
        builder.parameter("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        return this;
    }

    public PhoneNumberRequest setBeta(Boolean beta) {
        builder.parameter("Beta", beta.toString());
        return this;
    }

    public List<AvailablePhoneNumber> fetchResponse() throws IOException {
        Gson gson = new Gson();
        String responseString = fetchRawResponse().toString();
        System.out.println("Reso: " + responseString);
        PhoneNumberResponse response = gson.fromJson(responseString, PhoneNumberResponse.class);
        return response.getAvailablePhoneNumbers();
    }
}
