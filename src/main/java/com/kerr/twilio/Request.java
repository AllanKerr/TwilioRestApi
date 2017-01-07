package com.kerr.twilio;

import javax.xml.bind.DatatypeConverter;
import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allankerr on 2017-01-06.
 */
public abstract class Request {

    /**
     * The method used to send the request
     */
    private RequestMethod method;

    /**
     * The url used for the request without any parameters
     */
    URL url;

    /**
     * The headers to be added to the request
     */
    Map<String, String> headers = new HashMap<String, String>();

    /**
     * The parameters to be added to the URL or body depending on the request method.
     */
    Map<String, String> parameters = new HashMap<String, String>();

    public static class Builder {

        /**
         * The method used to send the request
         */
        private RequestMethod method;

        /**
         * The url used for the request without any parameters
         */
        private URL url;

        /**
         * The headers to be added to the request
         */
        private Map<String, String> headers = new HashMap<String, String>();

        /**
         * The parameters to be added to the URL or body depending on the request method.
         */
        private Map<String, String> parameters = new HashMap<String, String>();

        public Builder(RequestMethod method, URL url) {
            this.method = method;
            this.url = url;
        }

        public Request.Builder header(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Request.Builder parameter(String key, String value) {
            parameters.put(key, value);
            return this;
        }

        public Request.Builder basicAuth(String username, String password) {
            try {
                byte[] message = (username + ":" + password).getBytes("UTF-8");
                String encoded = DatatypeConverter.printBase64Binary(message);
                System.out.println(encoded);
                return header("Authorization", "Basic " + encoded);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        public Request build() {
            switch (method) {
                case GET:
                    return new GetRequest(this);
                case POST:
                    return new PostRequest(this);
                default:
                    throw new RuntimeException("Unhandled request method " + method);
            }
        }
    }

    Request(Builder builder) {
        this.url = builder.url;
        this.headers = builder.headers;
        this.parameters = builder.parameters;
    }

    HttpURLConnection openConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        try {
            connection.setRequestMethod(RequestMethod.GET.name());
        } catch (ProtocolException e) {
            // This SHOULD never be thrown.
            throw new RuntimeException(e);
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return connection;
    }

    String buildParameterList() {
        StringBuilder parameterList = new StringBuilder();
        try {
            for (Map.Entry<String,String> param : parameters.entrySet()) {
                if (parameterList.length() != 0) {
                    parameterList.append('&');
                }
                parameterList.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                parameterList.append('=');
                parameterList.append(URLEncoder.encode(param.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            // If any iteration throws it, all will.
            // This SHOULD never be thrown.
            throw new RuntimeException(e);
        }
        return parameterList.toString();
    }

    StringBuffer parseResponse(HttpURLConnection connection) throws IOException {
        int respCode = connection.getResponseCode();
        if (respCode >= 200 && respCode < 300) {

            StringBuffer response = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.println(response);
            return response;
        } else {
            System.out.println(respCode);
            throw new HTTPException(respCode);
        }
    }

    public abstract StringBuffer fetch() throws IOException;
}
