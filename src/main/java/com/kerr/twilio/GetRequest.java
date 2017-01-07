package com.kerr.twilio;

import com.google.common.base.Joiner;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public StringBuffer fetch() throws IOException {
        HttpURLConnection connection = super.openConnection(url);
        System.out.println(url);
        try {
            connection.setRequestMethod(RequestMethod.GET.name());
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        connection.setDoOutput(true);

        int respCode = connection.getResponseCode();
        if (respCode == HttpURLConnection.HTTP_OK) {

            StringBuffer response = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response;
        } else {
            throw new HTTPException(respCode);
        }
    }
}
