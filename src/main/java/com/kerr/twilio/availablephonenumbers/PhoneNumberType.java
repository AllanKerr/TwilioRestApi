package com.kerr.twilio.availablephonenumbers;

/**
 * Created by allankerr on 2017-01-06.
 */
enum PhoneNumberType {
    LOCAL("Local"),
    TOLL_FREE("TollFree"),
    MOBILE("Mobile");

    private String pathComponent;

    String getPathComponent() {
        return pathComponent;
    }

    private PhoneNumberType(String pathComponent) {
        this.pathComponent = pathComponent;
    }

}
