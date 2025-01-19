package com.syu.module.sound;

public class HandlerSound {
    public static void update(int updateCode, int value) {
        if (DataSound.DATA[updateCode] != value) {
            DataSound.DATA[updateCode] = value;
            DataSound.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }
}
