package com.kerr.twilio.availablephonenumbers;

/**
 * Created by allankerr on 2017-01-06.
 */
public class LocalRequest extends PhoneNumberRequest {

    public LocalRequest(String accountSid, String authToken, String countryCode) {
        super(accountSid, authToken, countryCode, PhoneNumberType.LOCAL);
    }
}
