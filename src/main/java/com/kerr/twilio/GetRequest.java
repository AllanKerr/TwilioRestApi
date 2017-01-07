package com.kerr.twilio;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
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

        // Create the connection
        HttpURLConnection connection = super.openConnection(url);
        try {
            connection.setRequestMethod(RequestMethod.GET.name());
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        connection.setDoOutput(true);

        // Retrieve and parse the response
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
