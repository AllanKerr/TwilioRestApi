package com.kerr.twilio.availablephonenumbers;

/**
 * Created by allankerr on 2017-01-06.
 */
public class TollFreeRequest extends PhoneNumberRequest {

    public TollFreeRequest(String accountSid, String authToken, String countryCode) {
        super(accountSid, authToken, countryCode, PhoneNumberType.TOLL_FREE);
    }
}
