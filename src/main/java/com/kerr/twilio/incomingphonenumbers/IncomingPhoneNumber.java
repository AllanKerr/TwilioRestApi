
package com.kerr.twilio.incomingphonenumbers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kerr.twilio.Capabilities;

public class IncomingPhoneNumber {

    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("account_sid")
    @Expose
    private String accountSid;
    @SerializedName("friendly_name")
    @Expose
    private String friendlyName;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("voice_url")
    @Expose
    private String voiceUrl;
    @SerializedName("voice_method")
    @Expose
    private String voiceMethod;
    @SerializedName("voice_fallback_url")
    @Expose
    private Object voiceFallbackUrl;
    @SerializedName("voice_fallback_method")
    @Expose
    private String voiceFallbackMethod;
    @SerializedName("voice_caller_id_lookup")
    @Expose
    private Object voiceCallerIdLookup;
    @SerializedName("voice_application_sid")
    @Expose
    private Object voiceApplicationSid;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("sms_url")
    @Expose
    private Object smsUrl;
    @SerializedName("sms_method")
    @Expose
    private String smsMethod;
    @SerializedName("sms_fallback_url")
    @Expose
    private Object smsFallbackUrl;
    @SerializedName("sms_fallback_method")
    @Expose
    private String smsFallbackMethod;
    @SerializedName("sms_application_sid")
    @Expose
    private Object smsApplicationSid;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;
    @SerializedName("beta")
    @Expose
    private Boolean beta;
    @SerializedName("status_callback")
    @Expose
    private Object statusCallback;
    @SerializedName("status_callback_method")
    @Expose
    private Object statusCallbackMethod;
    @SerializedName("api_version")
    @Expose
    private String apiVersion;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getSid() {
        return sid;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public String getVoiceMethod() {
        return voiceMethod;
    }

    public Object getVoiceFallbackUrl() {
        return voiceFallbackUrl;
    }

    public String getVoiceFallbackMethod() {
        return voiceFallbackMethod;
    }

    public Object getVoiceCallerIdLookup() {
        return voiceCallerIdLookup;
    }

    public Object getVoiceApplicationSid() {
        return voiceApplicationSid;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public Object getSmsUrl() {
        return smsUrl;
    }

    public String getSmsMethod() {
        return smsMethod;
    }

    public Object getSmsFallbackUrl() {
        return smsFallbackUrl;
    }

    public String getSmsFallbackMethod() {
        return smsFallbackMethod;
    }

    public Object getSmsApplicationSid() {
        return smsApplicationSid;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public Boolean getBeta() {
        return beta;
    }

    public Object getStatusCallback() {
        return statusCallback;
    }

    public Object getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getUri() {
        return uri;
    }

}
