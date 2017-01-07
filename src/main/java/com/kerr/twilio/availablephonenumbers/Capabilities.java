
package com.kerr.twilio.availablephonenumbers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capabilities {

    @SerializedName("voice")
    @Expose
    private Boolean voice;
    @SerializedName("SMS")
    @Expose
    private Boolean sMS;
    @SerializedName("MMS")
    @Expose
    private Boolean mMS;

    public Boolean getVoice() {
        return voice;
    }

    public Boolean getSMS() {
        return sMS;
    }

    public Boolean getMMS() {
        return mMS;
    }
}
