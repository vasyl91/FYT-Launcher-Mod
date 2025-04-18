package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class UIPAFordF150Vol {
    private static UIPAFordF150Vol mInstance;
    Context context;
    private View sWarnContent;

    public static UIPAFordF150Vol getInstance() {
        if (mInstance == null) {
            mInstance = new UIPAFordF150Vol();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        if (this.sWarnContent != null) {
            WarnUtils.setLocation(0, -350);
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        }
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0452_pa_carvol_warn, null, false);
        }
        ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(String.valueOf(value));
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
