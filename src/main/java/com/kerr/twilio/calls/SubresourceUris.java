
package com.kerr.twilio.calls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubresourceUris {

    @SerializedName("notifications")
    @Expose
    private String notifications;
    @SerializedName("recordings")
    @Expose
    private String recordings;

    public String getNotifications() {
        return notifications;
    }

    public String getRecordings() {
        return recordings;
    }

}
