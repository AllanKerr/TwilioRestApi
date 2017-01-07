package com.kerr.twilio.availablephonenumbers;

/**
 * Created by allankerr on 2017-01-06.
 */
public class MobileRequest extends PhoneNumberRequest {

    public MobileRequest(String accountSid, String authToken, String countryCode) {
        super(accountSid, authToken, countryCode, PhoneNumberType.MOBILE);
    }
}
