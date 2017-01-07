
package com.kerr.twilio.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("account_sid")
    @Expose
    private String accountSid;
    @SerializedName("api_version")
    @Expose
    private String apiVersion;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("error_code")
    @Expose
    private Object errorCode;
    @SerializedName("error_message")
    @Expose
    private Object errorMessage;
    @SerializedName("num_segments")
    @Expose
    private String numSegments;
    @SerializedName("num_media")
    @Expose
    private String numMedia;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_sent")
    @Expose
    private String dateSent;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getAccountSid() {
        return accountSid;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getBody() {
        return body;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public String getNumSegments() {
        return numSegments;
    }

    public String getNumMedia() {
        return numMedia;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateSent() {
        return dateSent;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public String getDirection() {
        return direction;
    }

    public String getFrom() {
        return from;
    }

    public String getPrice() {
        return price;
    }

    public String getSid() {
        return sid;
    }

    public String getStatus() {
        return status;
    }

    public String getTo() {
        return to;
    }

    public String getUri() {
        return uri;
    }

}
