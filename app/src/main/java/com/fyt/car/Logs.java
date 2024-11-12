package com.fyt.car;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.ipc.data.FinalCanbus;

public class Logs {
    public static final boolean DEBUG = false;
    public static final String TAG = "Qin_Debug";
    private static Logs mInstance = null;
    private Context mContext;
    private Toast mToast;

    public static Logs getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Logs(context);
        }
        return mInstance;
    }

    public Logs(Context context) {
        this.mToast = null;
        this.mContext = null;
        this.mToast = new Toast(context);
        this.mContext = context;
    }

    public void showToast(String str, int duration) {
        e("show ----------- " + str);
        this.mToast.setGravity(17, 0, FinalCanbus.CAR_FYT_XP1_14Prado_L);
        this.mToast.setDuration(duration);
        TextView view = new TextView(this.mContext);
        view.setBackgroundColor(Color.parseColor("#696969"));
        view.setPadding(3, 2, 3, 2);
        view.setText(str);
        view.setGravity(17);
        view.setTextSize(15.0f);
        this.mToast.setView(view);
        this.mToast.show();
    }

    public void showToast(int str, int duration) {
        e("show ----------- " + this.mContext.getResources().getString(str));
        this.mToast.setGravity(17, 0, FinalCanbus.CAR_FYT_XP1_14Prado_L);
        this.mToast.setDuration(duration);
        TextView view = new TextView(this.mContext);
        view.setBackgroundColor(Color.parseColor("#696969"));
        view.setPadding(3, 2, 3, 2);
        view.setText(str);
        view.setGravity(17);
        view.setTextSize(15.0f);
        this.mToast.setView(view);
        this.mToast.show();
    }

    public static void w(String msg) {
    }

    public static void d(String msg) {
    }

    public static void i(String msg) {
    }

    public static void e(String msg) {
    }

    public static void w(String tag, String msg) {
    }

    public static void d(String tag, String msg) {
    }

    public static void i(String tag, String msg) {
    }

    public static void e(String tag, String msg) {
    }
}
