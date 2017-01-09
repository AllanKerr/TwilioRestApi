package com.kerr.twilio.calls;

import com.google.gson.Gson;
import com.kerr.request.RequestMethod;
import com.kerr.twilio.TwilioRequest;

import java.io.IOException;

/**
 * Created by allankerr on 2017-01-09.
 */
public class CallRequest extends TwilioRequest<Call> {

    protected RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    protected CallRequest(String accountSid, String authToken, String callSid) {
        super(accountSid, authToken, "Calls/" + callSid + ".json");
    }

    public Call fetchResponse() throws IOException {
        Gson gson = new Gson();
        String responseString = fetchRawResponse().toString();
        return gson.fromJson(responseString, Call.class);
    }
}
