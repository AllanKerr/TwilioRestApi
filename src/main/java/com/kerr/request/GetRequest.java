package com.kerr.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by allankerr on 2017-01-06.
 */
class GetRequest extends Request {

    GetRequest(Request.Builder builder) {
        super(builder);

        if (this.parameters.size() > 0) {
            String parameters = buildParameterList();
            try {
                this.url = new URL(this.url + "?" + parameters);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public StringBuffer fetch() throws IOException {
        HttpURLConnection connection = openConnection(url);
        return parseResponse(connection);
    }
}

https://api.twilio.com/2010-04-01/Accounts/AC4633c3f57d62274bb751ad1eed4c1158/IncomingPhoneNumbers