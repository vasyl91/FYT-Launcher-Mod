package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

public class UIODFordPro {
    private static UIODFordPro mInstance;
    Context context;
    private View sWarnContent;

    public static UIODFordPro getInstance() {
        if (mInstance == null) {
            mInstance = new UIODFordPro();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null && value != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
        }
        switch (value) {
            case 1:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText(R.string.str_244_frontlight1);
                break;
            case 2:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText(R.string.str_grass_gravel_snow);
                break;
            case 3:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText(R.string.klc_air_Manual);
                break;
            case 4:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText(R.string.klc_sport_mode_Engine_sport);
                break;
            case 5:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText(R.string.str_397_eco_mode);
                break;
            case 6:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text)).setText("4L mode");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
