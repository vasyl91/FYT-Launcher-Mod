package com.android.launcher66;

import android.util.Log;
import android.view.MotionEvent;

import java.lang.reflect.Method;

/**
 * Injects a touch on a given display, for the edge handle (see EdgePassRoute). The calls are hidden:
 * MotionEvent.setDisplayId (API 29) and InputManager.injectInputEvent. The system uid, which this
 * path is meant for, may call both; anything else fails and the caller falls back, with one log line.
 */
final class EdgeInject {

    private static final String TAG = "EdgeInject";
    private static final int INJECT_INPUT_EVENT_MODE_ASYNC = 0;

    private static boolean sResolved;
    private static Method sSetDisplayId;
    private static Object sInputManager;
    private static Method sInject;
    private static boolean sFailureLogged;

    private EdgeInject() {
    }

    /** @return whether the event was injected */
    static synchronized boolean inject(MotionEvent event, int displayId) {
        try {
            if (!sResolved) {
                sResolved = true;
                sSetDisplayId = MotionEvent.class.getMethod("setDisplayId", int.class);
                Class<?> im = Class.forName("android.hardware.input.InputManager");
                sInputManager = im.getMethod("getInstance").invoke(null);
                sInject = im.getMethod("injectInputEvent", android.view.InputEvent.class, int.class);
            }
            if (sSetDisplayId == null || sInputManager == null || sInject == null) {
                return false;
            }
            sSetDisplayId.invoke(event, displayId);
            Object ok = sInject.invoke(sInputManager, event, INJECT_INPUT_EVENT_MODE_ASYNC);
            return !(ok instanceof Boolean) || (Boolean) ok;
        } catch (Throwable t) {
            if (!sFailureLogged) {
                sFailureLogged = true;
                Log.w(TAG, "Touch injection on display " + displayId + " failed, the view tree is used", t);
            }
            sSetDisplayId = null;
            return false;
        }
    }
}
