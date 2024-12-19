package com.syu.canbus.warn;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.util.TimeLocker;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UIWarn {
    private static final int COLOR_RED = -65536;
    private static final int COLOR_WHITE = -1;
    private static final int COLOR_YELLOW = -256;
    private static final int TIME_LONG = 10000;
    private static final int TIME_MORE = 1;
    private static final int TIME_NO = -1;
    private static final int TIME_NORMAL = 0;
    private static TextView mTextWarn;
    public static View sPackContent;
    public static View sWarnContent;
    public static View sWarnView;
    public static final TimeLocker LOCK_SHOW_UI = new TimeLocker();
    private static int sWarnUIID = -1;
    private static int[] ResID = {R.layout.layout_wc_ruijie15_warn_1, R.layout.layout_wc_ruijie15_warn_1, R.layout.layout_wc_ruijie15_warn_2, R.layout.layout_wc_ruijie15_warn_3, R.layout.layout_wc_ruijie15_warn_4, R.layout.layout_wc_ruijie15_warn_5, R.layout.layout_wc_ruijie15_warn_6, R.layout.layout_wc_ruijie15_warn_7, R.layout.layout_wc_ruijie15_warn_8, R.layout.layout_wc_ruijie15_warn_9, R.layout.layout_wc_ruijie15_warn_10, R.layout.layout_wc_ruijie15_warn_11, R.layout.layout_wc_ruijie15_warn_12, R.layout.layout_wc_ruijie15_warn_13, R.layout.layout_wc_ruijie15_warn_14, R.layout.layout_wc_ruijie15_warn_15, R.layout.layout_wc_ruijie15_warn_16, R.layout.layout_wc_ruijie15_warn_17, R.layout.layout_wc_ruijie15_warn_18, R.layout.layout_wc_ruijie15_warn_19, R.layout.layout_wc_ruijie15_warn_20, R.layout.layout_wc_ruijie15_warn_21, R.layout.layout_wc_ruijie15_warn_22, R.layout.layout_wc_ruijie15_warn_23, R.layout.layout_wc_ruijie15_warn_24, R.layout.layout_wc_ruijie15_warn_25, R.layout.layout_wc_ruijie15_warn_26, R.layout.layout_wc_ruijie15_warn_27, R.layout.layout_wc_ruijie15_warn_28, R.layout.layout_wc_ruijie15_warn_29, R.layout.layout_wc_ruijie15_warn_30, R.layout.layout_wc_ruijie15_warn_31, R.layout.layout_wc_ruijie15_warn_32, R.layout.layout_wc_ruijie15_warn_33, R.layout.layout_wc_ruijie15_warn_34, R.layout.layout_wc_ruijie15_warn_35, R.layout.layout_wc_ruijie15_warn_36, R.layout.layout_wc_ruijie15_warn_37, R.layout.layout_wc_ruijie15_warn_38, R.layout.layout_wc_ruijie15_warn_39, R.layout.layout_wc_ruijie15_warn_40, R.layout.layout_wc_ruijie15_warn_41, R.layout.layout_wc_ruijie15_warn_42, R.layout.layout_wc_ruijie15_warn_43, R.layout.layout_wc_ruijie15_warn_44, R.layout.layout_wc_ruijie15_warn_45, R.layout.layout_wc_ruijie15_warn_46, R.layout.layout_wc_ruijie15_warn_47, R.layout.layout_wc_ruijie15_warn_48, R.layout.layout_wc_ruijie15_warn_49, R.layout.layout_wc_ruijie15_warn_50, R.layout.layout_wc_ruijie15_warn_51, R.layout.layout_wc_ruijie15_warn_52, R.layout.layout_wc_ruijie15_warn_53, R.layout.layout_wc_ruijie15_warn_54, R.layout.layout_wc_ruijie15_warn_55, R.layout.layout_wc_ruijie15_warn_56};
    static int textColor = -1;
    static int time = 0;
    private static int sPackUI = -1;

    public static void refreshWarnUI() {
        if (!LOCK_SHOW_UI.isLocked()) {
            PopupWindow window = WarnUtils.getWindow();
            if (sWarnUIID != DataPack.sWCRuijieWarnIndex) {
                sWarnUIID = DataPack.sWCRuijieWarnIndex;
                if (DataPack.sWCRuijieWarnStatus == 1) {
                    if (window.isShowing()) {
                        window.dismiss();
                    }
                    initUI(sWarnUIID);
                    if (sWarnContent != null) {
                        WarnUtils.showWindow();
                        WarnUtils.postDimiss(5000);
                        return;
                    }
                    return;
                }
                return;
            }
            if (sWarnUIID == DataPack.sWCRuijieWarnIndex) {
                if (DataPack.sWCRuijieWarnStatus == 1) {
                    if (window.isShowing()) {
                        window.dismiss();
                    }
                    initUI(sWarnUIID);
                    if (sWarnContent != null) {
                        WarnUtils.showWindow();
                        WarnUtils.postDimiss(5000);
                        return;
                    }
                    return;
                }
                if (DataPack.sWCRuijieWarnStatus == 0 && window.isShowing()) {
                    window.dismiss();
                }
            }
        }
    }

    public static void showWindowTip(int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (value == 1) {
            if (window.isShowing()) {
                window.dismiss();
            }
            initTip();
            if (sWarnContent != null) {
                WarnUtils.setLocation(0, -100);
                WarnUtils.showWindow();
                return;
            }
            return;
        }
        if (window.isShowing()) {
            window.dismiss();
        }
    }

    private static void initTip() {
        Context context = LauncherApplication.getInstance();
        View view = new ImageView(context);
        view.setBackgroundResource(R.drawable.ic_408_bus_microphone);
        if (view != null) {
            WarnUtils.getWindow().setContentView(view);
        }
        sWarnContent = view;
    }

    private static void initUI(int type) {
        Context context = LauncherApplication.getInstance();
        View view = new WarnView(context, ResID[type]).getView();
        if (view != null) {
            WarnUtils.getWindow().setContentView(view);
        }
        sWarnContent = view;
    }

    public static void refreshFocusWarnUI() {
        if (!LOCK_SHOW_UI.isLocked()) {
            PopupWindow window = WarnUtils.getWindow();
            if (window.isShowing()) {
                window.dismiss();
            }
            int time2 = initUi();
            if (time2 >= 0 && sWarnView != null) {
                WarnUtils.showWindow();
                switch (time2) {
                    case 0:
                        WarnUtils.postDimiss(3000);
                        break;
                    case 1:
                        WarnUtils.postDimiss(5000);
                        break;
                }
            }
        }
    }

    private static int initUi() {
        Context context = LauncherApplication.getInstance();
        String str = "";
        time = 0;
        if (sWarnView == null) {
            sWarnView = new WarnView(context, R.layout.layout_focus_warn).getView();
            mTextWarn = (TextView) sWarnView.findViewById(R.id.tv_focus_warn);
        }
        if (sWarnView != null) {
            WarnUtils.getWindow().setContentView(sWarnView);
        }
        switch (DataPack.sWCRuijieWarnIndex) {
            case 0:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 1:
                        str = context.getString(R.string.str_focus_warm_0_1);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_0_2);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_0_3);
                        textColor = COLOR_YELLOW;
                        time = 10000;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_0_4);
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_0_5);
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_0_6);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_0_7);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 1:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_1_0);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_1_1);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_1_2);
                        textColor = COLOR_RED;
                        time = 1;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_1_3);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_1_4);
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_1_5);
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_1_6);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 2:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_2_0);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_2_1);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_2_2);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_2_3);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_2_4);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_2_5);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_2_7);
                        break;
                }
            case 3:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_3_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_3_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_3_2);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_3_3);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_3_4);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_3_5);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_3_6);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_3_7);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                }
            case 4:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_4_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_4_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_4_2);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_4_3);
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_4_4);
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_4_5);
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_4_6);
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_4_7);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 5:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_5_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_5_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_5_2);
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_5_3);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_5_4);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_5_5);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_5_6);
                        textColor = COLOR_YELLOW;
                        time = 10000;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_5_7);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 6:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_6_0);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_6_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_6_2);
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_6_3);
                        time = 10000;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_6_4);
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_6_5);
                        time = 10000;
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_6_6);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_6_7);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                }
            case 7:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_7_0);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_7_1);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_7_2);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_7_3);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_7_4);
                        time = 10000;
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_7_5);
                        time = 10000;
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_7_6);
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_7_7);
                        time = 10000;
                        break;
                }
            case 8:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_8_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_8_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_8_2);
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_8_3);
                        break;
                    case 4:
                        str = context.getString(R.string.str_focus_warm_8_4);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 5:
                        str = context.getString(R.string.str_focus_warm_8_5);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_8_6);
                        textColor = COLOR_YELLOW;
                        time = 10000;
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_8_7);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 9:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_9_0);
                        textColor = COLOR_YELLOW;
                        time = 10000;
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_9_1);
                        break;
                    case 2:
                        str = context.getString(R.string.str_focus_warm_9_2);
                        break;
                    case 3:
                        str = context.getString(R.string.str_focus_warm_9_3);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 10:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_10_0);
                        break;
                }
            case 11:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_11_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_11_1);
                        break;
                }
            case 12:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_12_0);
                        break;
                    case 1:
                        str = context.getString(R.string.str_focus_warm_12_1);
                        break;
                }
            case 13:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 3:
                        str = context.getString(R.string.str_focus_warm_13_3);
                        break;
                    case 6:
                        str = context.getString(R.string.str_focus_warm_13_6);
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_13_7);
                        break;
                }
            case 14:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 0:
                        str = context.getString(R.string.str_focus_warm_14_0);
                        textColor = COLOR_YELLOW;
                        time = 1;
                        break;
                }
            case 15:
                switch (DataPack.sWCRuijieWarnStatus) {
                    case 5:
                        str = context.getString(R.string.str_focus_warm_15_5);
                        break;
                    case 7:
                        str = context.getString(R.string.str_focus_warm_15_7);
                        textColor = COLOR_RED;
                        time = 10000;
                        break;
                }
        }
        mTextWarn.setText(str);
        mTextWarn.setTextColor(textColor);
        if (str.equals("")) {
            time = -1;
        }
        return time;
    }

    public static void refreshPack() {
        if (!LOCK_SHOW_UI.isLocked()) {
            PopupWindow window = WarnUtils.getWindow();
            if (sPackUI != DataPack.sPackWarm) {
                sPackUI = DataPack.sPackWarm;
                if (window.isShowing()) {
                    window.dismiss();
                }
                initPackUI(sPackUI);
            }
            if (sPackContent != null) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
            }
        }
    }

    private static void initPackUI(int type) {
        View view = null;
        Context context = LauncherApplication.getInstance();
        switch (type) {
            case 2:
                view = new PackView(context, R.layout.layout_pack_warm_0x02).getView();
                break;
            case 4:
                view = new PackView(context, R.layout.layout_pack_warm_0x04).getView();
                break;
            case 5:
                view = new PackView(context, R.layout.layout_pack_warm_0x05).getView();
                break;
            case 6:
                view = new PackView(context, R.layout.layout_pack_warm_0x06).getView();
                break;
            case 7:
                view = new PackView(context, R.layout.layout_pack_warm_0x07).getView();
                break;
            case 8:
                view = new PackView(context, R.layout.layout_pack_warm_0x08).getView();
                break;
            case 9:
                view = new PackView(context, R.layout.layout_pack_warm_0x09).getView();
                break;
            case 10:
                view = new PackView(context, R.layout.layout_pack_warm_0x0a).getView();
                break;
            case 11:
                view = new PackView(context, R.layout.layout_pack_warm_0x0b).getView();
                break;
            case 12:
                view = new PackView(context, R.layout.layout_pack_warm_0x0c).getView();
                break;
            case 13:
                view = new PackView(context, R.layout.layout_pack_warm_0x0d).getView();
                break;
            case 14:
                view = new PackView(context, R.layout.layout_pack_warm_0x0e).getView();
                break;
            case 15:
                view = new PackView(context, R.layout.layout_pack_warm_0x0f).getView();
                break;
            case 16:
                view = new PackView(context, R.layout.layout_pack_warm_0x10).getView();
                break;
            case 17:
                view = new PackView(context, R.layout.layout_pack_warm_0x11).getView();
                break;
            case 18:
                view = new PackView(context, R.layout.layout_pack_warm_0x12).getView();
                break;
            case 19:
                view = new PackView(context, R.layout.layout_pack_warm_0x13).getView();
                break;
            case 20:
                view = new PackView(context, R.layout.layout_pack_warm_0x14).getView();
                break;
            case 21:
                view = new PackView(context, R.layout.layout_pack_warm_0x15).getView();
                break;
            case 22:
                view = new PackView(context, R.layout.layout_pack_warm_0x16).getView();
                break;
            case 23:
                view = new PackView(context, R.layout.layout_pack_warm_0x17).getView();
                break;
            case 24:
                view = new PackView(context, R.layout.layout_pack_warm_0x18).getView();
                break;
            case 25:
                view = new PackView(context, R.layout.layout_pack_warm_0x19).getView();
                break;
            case 26:
                view = new PackView(context, R.layout.layout_pack_warm_0x1a).getView();
                break;
            case 27:
                view = new PackView(context, R.layout.layout_pack_warm_0x1b).getView();
                break;
            case 28:
                view = new PackView(context, R.layout.layout_pack_warm_0x1c).getView();
                break;
            case 29:
                view = new PackView(context, R.layout.layout_pack_warm_0x1d).getView();
                break;
            case 30:
                view = new PackView(context, R.layout.layout_pack_warm_0x1e).getView();
                break;
            case 31:
                view = new PackView(context, R.layout.layout_pack_warm_0x1f).getView();
                break;
            case 32:
                view = new PackView(context, R.layout.layout_pack_warm_0x20).getView();
                break;
            case 33:
                view = new PackView(context, R.layout.layout_pack_warm_0x21).getView();
                break;
            case 34:
                view = new PackView(context, R.layout.layout_pack_warm_0x22).getView();
                break;
            case 35:
                view = new PackView(context, R.layout.layout_pack_warm_0x23).getView();
                break;
            case 36:
                view = new PackView(context, R.layout.layout_pack_warm_0x24).getView();
                break;
            case 37:
                view = new PackView(context, R.layout.layout_pack_warm_0x25).getView();
                break;
            case 38:
                view = new PackView(context, R.layout.layout_pack_warm_0x26).getView();
                break;
            case 39:
                view = new PackView(context, R.layout.layout_pack_warm_0x27).getView();
                break;
        }
        if (view != null) {
            WarnUtils.getWindow().setContentView(view);
        }
        sPackContent = view;
    }
}
