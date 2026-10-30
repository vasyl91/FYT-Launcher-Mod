package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIRZCDakache {
    private static UIRZCDakache mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRZCDakache getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCDakache();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && (DataCanbus.DATA[157] != 0 || DataCanbus.DATA[158] != 0 || DataCanbus.DATA[159] != 0 || DataCanbus.DATA[160] != 0)) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(10000);
        } else if (this.sWarnContent != null && window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_td_lexus_warn, (ViewGroup) null, false);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        if (DataCanbus.DATA[157] == 1) {
            this.mTextWarn.setText("Alert Right");
        } else if (DataCanbus.DATA[158] == 1) {
            this.mTextWarn.setText("Alert Left");
        } else if (DataCanbus.DATA[159] == 1) {
            this.mTextWarn.setText("Alert Front");
        } else if (DataCanbus.DATA[160] == 1) {
            this.mTextWarn.setText("Alert");
        } else {
            this.mTextWarn.setText("");
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
