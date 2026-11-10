package com.syu.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSONUtils {
    JSONUtils() {
    }

    public static int[] jsonToIntArray(JSONObject object, String name) {
        int len;
        if (!object.has(name)) {
            return null;
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array == null || (len = array.length()) == 0) {
                return null;
            }
            int[] values = new int[len];
            for (int i = 0; i < len; i++) {
                values[i] = array.getInt(i);
            }
            return values;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] jsonToStrArray(JSONObject object, String name) {
        int len;
        if (!object.has(name)) {
            return null;
        }
        try {
            JSONArray array = object.getJSONArray(name);
            if (array == null || (len = array.length()) == 0) {
                return null;
            }
            String[] values = new String[len];
            for (int i = 0; i < len; i++) {
                values[i] = array.getString(i);
            }
            return values;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getStr(JSONObject object, String name) {
        if (!object.has(name)) {
            return null;
        }
        try {
            return object.getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getInt(JSONObject object, String name) {
        if (!object.has(name)) {
            return -1;
        }
        try {
            return object.getInt(name);
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
