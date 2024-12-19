package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0077_XP1_ACCORD9_H;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WarnRZCMQBTire {
    private static WarnRZCMQBTire mInstance;
    Context context;
    int ecode = 0;
    int etype = 0;
    private TextView mTextWarn1;
    private TextView mTextWarn2;
    private TextView mTextWarn3;
    private TextView mTextWarn4;
    private View sWarnContent;

    public static WarnRZCMQBTire getInstance() {
        if (mInstance == null) {
            mInstance = new WarnRZCMQBTire();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        if (value == 0 && updateCode == 386) {
            this.ecode = 0;
            if (window.isShowing()) {
                window.dismiss();
                return;
            }
            return;
        }
        if (value == 0 && updateCode == 387) {
            this.etype = 0;
            if (window.isShowing()) {
                window.dismiss();
                return;
            }
            return;
        }
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(Callback_0077_XP1_ACCORD9_H.Band_Am);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0160_mqb_tire_warn, (ViewGroup) null, false);
            this.mTextWarn1 = (TextView) this.sWarnContent.findViewById(R.id.tv_text1);
            this.mTextWarn2 = (TextView) this.sWarnContent.findViewById(R.id.tv_text2);
            this.mTextWarn3 = (TextView) this.sWarnContent.findViewById(R.id.tv_text3);
            this.mTextWarn4 = (TextView) this.sWarnContent.findViewById(R.id.tv_text4);
        }
        if (updateCode == 386) {
            this.ecode = value;
        }
        if (updateCode == 387) {
            this.etype = value;
        }
        this.mTextWarn1.setTextColor(-1);
        this.mTextWarn2.setTextColor(-1);
        this.mTextWarn3.setTextColor(-1);
        this.mTextWarn4.setTextColor(-1);
        switch (this.ecode) {
            case 1:
                this.mTextWarn2.setText(R.string.tireflnormal);
                this.mTextWarn3.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        break;
                }
            case 2:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn3.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                }
            case 3:
                this.mTextWarn3.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        break;
                }
            case 4:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn2.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                }
            case 5:
                this.mTextWarn2.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                }
            case 6:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                }
            case 7:
                this.mTextWarn4.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        break;
                }
            case 8:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn2.setText(R.string.tireflnormal);
                this.mTextWarn3.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 9:
                this.mTextWarn2.setText(R.string.tireflnormal);
                this.mTextWarn3.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 10:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn3.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 11:
                this.mTextWarn3.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 12:
                this.mTextWarn1.setText(R.string.tireflnormal);
                this.mTextWarn2.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 13:
                this.mTextWarn2.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 14:
                this.mTextWarn1.setText(R.string.tireflnormal);
                switch (this.etype) {
                    case 0:
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
            case 15:
                switch (this.etype) {
                    case 0:
                        this.mTextWarn1.setText(R.string.tireflnormal);
                        this.mTextWarn2.setText(R.string.tireflnormal);
                        this.mTextWarn3.setText(R.string.tireflnormal);
                        this.mTextWarn4.setText(R.string.tireflnormal);
                        break;
                    case 2:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_2);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 3:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_3);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                    case 4:
                        this.mTextWarn1.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn2.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn3.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn4.setText(R.string.str_40_od_tire_4);
                        this.mTextWarn1.setTextColor(-65536);
                        this.mTextWarn2.setTextColor(-65536);
                        this.mTextWarn3.setTextColor(-65536);
                        this.mTextWarn4.setTextColor(-65536);
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
