package com.kerr.twilio.incomingphonenumbers;

import com.google.gson.Gson;
import com.kerr.request.RequestMethod;
import com.kerr.twilio.TwilioRequest;

import java.io.IOException;

/**
 * Created by allankerr on 2017-01-06.
 */
public class BuyPhoneNumberRequest extends TwilioRequest<IncomingPhoneNumber> {

    protected RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }

    public BuyPhoneNumberRequest(String accountSid, String authToken, String phoneNumber) {
        super(accountSid, authToken, "IncomingPhoneNumbers.json");
        builder.parameter("PhoneNumber", phoneNumber);
    }

    public BuyPhoneNumberRequest setFriendlyName(String friendlyName) {
        builder.parameter("FriendlyName", friendlyName);
        return this;
    }

    public BuyPhoneNumberRequest setSmsApplicationSid(String smsApplicationSid) {
        builder.parameter("SmsApplicationSid", smsApplicationSid);
        return this;
    }

    public BuyPhoneNumberRequest setVoiceApplicationSid(String voiceApplicationSid) {
        builder.parameter("VoiceApplicationSid", voiceApplicationSid);
        return this;
    }

    public IncomingPhoneNumber fetchResponse() throws IOException {
        Gson gson = new Gson();
        String responseString = fetchRawResponse().toString();
        return gson.fromJson(responseString, IncomingPhoneNumber.class);
    }
}
