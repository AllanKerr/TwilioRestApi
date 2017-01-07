package com.kerr.twilio.messages;

import com.google.gson.Gson;
import com.kerr.request.RequestMethod;
import com.kerr.twilio.TwilioRequest;

import java.io.IOException;

/**
 * Created by allankerr on 2017-01-07.
 */
public class MessageRequest extends TwilioRequest<Message> {

    protected RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }

    public MessageRequest(String accountSid, String authToken, String messageSid) {
        super(accountSid, authToken, "Messages/" + messageSid + ".json");
    }

    public Message fetchResponse() throws IOException {
        Gson gson = new Gson();
        String responseString = fetchRawResponse().toString();
        return gson.fromJson(responseString, Message.class);
    }
}
