package com.kerr.twilio;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allankerr on 2017-01-06.
 */
public abstract class Request {
    public class Builder {

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

        public Builder header(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder parameter(String key, String value) {
            parameters.put(key, value);
            return this;
        }

        public Builder basicAuth(String username, String password) {
            try {
                byte[] message = (username + ":" + password).getBytes("UTF-8");
                String encoded = DatatypeConverter.printBase64Binary(message);
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

    protected Request(Builder builder) {

    }
}
