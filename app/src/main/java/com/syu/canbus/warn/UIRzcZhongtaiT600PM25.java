package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UIRzcZhongtaiT600PM25 {
    private static UIRzcZhongtaiT600PM25 mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;

    public static UIRzcZhongtaiT600PM25 getInstance() {
        if (mInstance == null) {
            mInstance = new UIRzcZhongtaiT600PM25();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[81] != 0) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_265_rzc_t600_pm25, (ViewGroup) null, false);
        }
        int invalue = DataCanbus.DATA[82];
        int outvalue = DataCanbus.DATA[83];
        ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside)).setText(String.valueOf(invalue) + " ug/μg/m³");
        ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside)).setText(String.valueOf(outvalue) + " ug/μg/m³");
        if (outvalue >= 0 && outvalue <= 35) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_2);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-1);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-16711936);
        } else if (outvalue >= 36 && outvalue <= 75) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_3);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-16776961);
        } else if (outvalue >= 76 && outvalue <= 115) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_4);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-256);
        } else if (outvalue >= 116 && outvalue <= 150) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_5);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-65536);
        } else if (outvalue >= 151 && outvalue <= 250) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_6);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-65536);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-7829368);
        } else if (outvalue >= 251) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setText(R.string.str_265_7);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_outside_type)).setBackgroundColor(-65536);
        }
        if (invalue >= 0 && invalue <= 35) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_2);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-1);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-16711936);
        } else if (invalue >= 36 && invalue <= 75) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_3);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-16776961);
        } else if (invalue >= 76 && invalue <= 115) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_4);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-256);
        } else if (invalue >= 116 && invalue <= 150) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_5);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-65536);
        } else if (invalue >= 151 && invalue <= 250) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_6);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-65536);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-7829368);
        } else if (invalue >= 251) {
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setText(R.string.str_265_7);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setTextColor(-16777216);
            ((TextView) this.sWarnContent.findViewById(R.id.id_pm_inside_type)).setBackgroundColor(-65536);
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
