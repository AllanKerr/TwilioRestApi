package com.kerr.twilio;

import com.kerr.request.Request;
import com.kerr.request.RequestMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by allankerr on 2017-01-06.
 */
public abstract class TwilioRequest<T> {

    private static final String BASE_URL = "https://api.twilio.com/2010-04-01/Accounts";

    protected Request.Builder builder;

    protected abstract String getEndPointURL();

    protected abstract RequestMethod getRequestMethod();

    /**
     * Creates a new request to the Twilio rest API signed with basic authentication.
     * @param accountSid The account SID used as the username for basic authentication.
     * @param authToken The auth token used as the password for basic authentication.
     * @param endPointUrl The rest API path appended after that account SID in the URL.
     */
    protected TwilioRequest(String accountSid, String authToken, String endPointUrl) {
        try {
            URL url = new URL(BASE_URL + "/" + accountSid + "/" + endPointUrl);
            System.out.println(url);
            this.builder = new Request.Builder(getRequestMethod(), url);
            this.builder.basicAuth(accountSid, authToken);
        } catch (MalformedURLException e) {
            // A runtime exception is being thrown because the components that
            // make up the URL are specified at compile time meaning that correctness
            // can be guaranteed through testing
            throw new RuntimeException(e);
        }
    }

    /**
     * Fetches the response from the request as a string buffer
     * @return The string buffer containing the response.
     * @throws IOException Thrown if getting the response from the url fails.
     */
    protected StringBuffer fetchRawResponse() throws IOException {
        return builder.build().fetch();
    }

    /**
     * Fetch the parsed string buffer to return the response in an
     * easy to use format. All subclasses must implement this method with
     * T being the easy to use format for the response.
     * @return Returns the response in an easy to use format resulting from parsing the string buffer.
     * @throws IOException Thrown if getting the response from the url fails.
     */
    public abstract T fetchResponse() throws IOException;
}
