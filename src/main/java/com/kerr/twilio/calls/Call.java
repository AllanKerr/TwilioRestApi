
package com.kerr.twilio.calls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Call {

    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("parent_call_sid")
    @Expose
    private Object parentCallSid;
    @SerializedName("account_sid")
    @Expose
    private String accountSid;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("phone_number_sid")
    @Expose
    private Object phoneNumberSid;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("answered_by")
    @Expose
    private Object answeredBy;
    @SerializedName("api_version")
    @Expose
    private String apiVersion;
    @SerializedName("forwarded_from")
    @Expose
    private Object forwardedFrom;
    @SerializedName("caller_name")
    @Expose
    private Object callerName;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("subresource_uris")
    @Expose
    private SubresourceUris subresourceUris;

    public String getSid() {
        return sid;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public Object getParentCallSid() {
        return parentCallSid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Object getPhoneNumberSid() {
        return phoneNumberSid;
    }

    public String getStatus() {
        return status;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getPrice() {
        return price;
    }

    public String getDirection() {
        return direction;
    }

    public Object getAnsweredBy() {
        return answeredBy;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public Object getForwardedFrom() {
        return forwardedFrom;
    }

    public Object getCallerName() {
        return callerName;
    }

    public String getUri() {
        return uri;
    }

    public SubresourceUris getSubresourceUris() {
        return subresourceUris;
    }

}
