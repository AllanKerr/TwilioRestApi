package com.kerr.twilio;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allankerr on 2017-01-06.
 */
public abstract class Request {

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
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return connection;
    }

    public abstract void connect() throws IOException;
}
