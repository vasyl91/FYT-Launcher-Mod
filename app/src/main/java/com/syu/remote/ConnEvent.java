package com.syu.remote;

public class ConnEvent {
    public boolean success;
    public String type;

    public ConnEvent(String type, boolean success) {
        this.type = type;
        this.success = success;
    }
}
