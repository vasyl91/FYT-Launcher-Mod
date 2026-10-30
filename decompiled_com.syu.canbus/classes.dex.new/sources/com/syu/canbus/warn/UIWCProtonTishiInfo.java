package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCProtonTishiInfo {
    private static UIWCProtonTishiInfo mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIWCProtonTishiInfo getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCProtonTishiInfo();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[164] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 162:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText("Auto light have been turn on");
                        break;
                    default:
                        this.mTextWarn.setText("Auto light have been turn off");
                        break;
                }
                break;
            case 163:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText("Autowiper is on");
                        break;
                    default:
                        this.mTextWarn.setText("Autowiper is off");
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
