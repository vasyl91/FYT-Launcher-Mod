package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIRZCRomeoMode {
    private static UIRZCRomeoMode mInstance;
    Context context;
    private View sWarnContent;

    public static UIRZCRomeoMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCRomeoMode();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[147] == 1) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(8000);
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0039_rzc_romeo_mode, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 141:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("NATRUAL");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("DYNAMIC");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("ALL WEATHER");
                        break;
                }
                break;
            case 142:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("ECO");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("CONTROL");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("PERFORMANCE");
                        break;
                }
                break;
            case 143:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("NORMAL");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("TRACTION");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("SPORT");
                        break;
                }
                break;
            case 144:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("OFF");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("ON");
                        break;
                }
                break;
            case 145:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("COMFORT");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("SPORT");
                        break;
                }
                break;
            case 146:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText("NORMAL");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText("PREFILL");
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
