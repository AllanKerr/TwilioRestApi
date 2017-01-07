package com.kerr.twilio.availablephonenumbers;

import com.google.gson.Gson;
import com.kerr.request.RequestMethod;
import com.kerr.twilio.TwilioRequest;

import java.io.IOException;
import java.util.List;

/**
 * Created by allankerr on 2017-01-06.
 */
public class LocalRequest extends TwilioRequest<List<AvailablePhoneNumber>> {

    protected String getEndPointURL() {
        return "Local.json";
    }

    protected RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    public LocalRequest(String accountSid, String authToken, String countryCode) {
        super(accountSid, authToken, "AvailablePhoneNumbers/" + countryCode + "/Local.json");
    }

    public LocalRequest setAreaCode(Integer areaCode) {
        builder.parameter("AreaCode", areaCode.toString());
        return this;
    }

    public LocalRequest setContains(String contains) {
        builder.parameter("Contains", contains);
        return this;
    }

    public LocalRequest setSmsEnabled(Boolean smsEnabled) {
        builder.parameter("SmsEnabled", smsEnabled.toString());
        return this;
    }

    public LocalRequest setMmsEnabled(Boolean mmsEnabled) {
        builder.parameter("MmsEnabled", mmsEnabled.toString());
        return this;
    }

    public LocalRequest setVoiceEnabled(Boolean voiceEnabled) {
        builder.parameter("VoiceEnabled", voiceEnabled.toString());
        return this;
    }

    public LocalRequest setExcludeAllAddressRequired(Boolean excludeAllAddressRequired) {
        builder.parameter("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        return this;
    }

    public LocalRequest setExcludeLocalAddressRequired(Boolean excludeLocalAddressRequired) {
        builder.parameter("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        return this;
    }

    public LocalRequest setExcludeForeignAddressRequired(Boolean excludeForeignAddressRequired) {
        builder.parameter("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        return this;
    }

    public LocalRequest setBeta(Boolean beta) {
        builder.parameter("Beta", beta.toString());
        return this;
    }

    public List<AvailablePhoneNumber> fetchResponse() throws IOException {
        Gson gson = new Gson();
        String responseString = fetchRawResponse().toString();
        LocalResponse response = gson.fromJson(responseString, LocalResponse.class);
        return response.getAvailablePhoneNumbers();
    }
}
