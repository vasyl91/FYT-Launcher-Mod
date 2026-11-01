package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UITangduLexusRX {
    private static UITangduLexusRX mInstance;
    Context context;
    private View sWarnContent;

    public static UITangduLexusRX getInstance() {
        if (mInstance == null) {
            mInstance = new UITangduLexusRX();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            if ((updateCode == 179 && value != 0) || updateCode == 164) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(4000);
            }
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_td_carvol_stateshow, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 164:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                ((ProgressBar) this.sWarnContent.findViewById(R.id.pa_jeep_seekbar1)).setProgress(value);
                break;
            case 179:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("VOL");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("OFF");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("RADIO");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("CD");
                        break;
                    case 4:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("AUX");
                        break;
                    case 5:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("USB");
                        break;
                    case 6:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("HDD");
                        break;
                    case 7:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("UNKNOW");
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
