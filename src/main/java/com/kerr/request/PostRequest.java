package com.kerr.request;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by allankerr on 2017-01-06.
 */
class PostRequest extends Request {

    PostRequest(Request.Builder builder) {
        super(builder);
    }

    public StringBuffer fetch() throws IOException {

        HttpURLConnection connection = openConnection(url);

        byte[] body = buildParameterList().getBytes();
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", String.valueOf(body.length));
        connection.getOutputStream().write(body);

        return parseResponse(connection);
    }

}
