package com.kerr.twilio;

import com.google.common.base.Joiner;

import java.io.IOException;
import java.net.*;
import java.util.Map;

/**
 * Created by allankerr on 2017-01-06.
 */
class GetRequest extends Request {

    GetRequest(Request.Builder builder) {
        super(builder);

        if (this.parameters.size() > 0) {
            String parameters = buildParameters(this.parameters);
            try {
                this.url = new URL(this.url + "?" + parameters);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String buildParameters(Map<String,String> components) {
        return Joiner.on('&').withKeyValueSeparator("=").join(components);
    }

    public void connect() throws IOException {
        HttpURLConnection conn = super.openConnection(url);
        System.out.println(url);
        try {
            conn.setRequestMethod(RequestMethod.GET.name());
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        conn.setDoOutput(true);
    }
}
