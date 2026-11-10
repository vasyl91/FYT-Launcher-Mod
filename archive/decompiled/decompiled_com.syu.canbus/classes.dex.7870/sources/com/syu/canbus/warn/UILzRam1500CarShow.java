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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class UILzRam1500CarShow {
    private static UILzRam1500CarShow mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UILzRam1500CarShow getInstance() {
        if (mInstance == null) {
            mInstance = new UILzRam1500CarShow();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[161] != 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(15000);
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0455_lz_ram1500_warn, (ViewGroup) null, false);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 161:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText(R.string.str_lz_ram_1);
                        break;
                    case 2:
                        this.mTextWarn.setText(R.string.str_lz_ram_2);
                        break;
                    case 3:
                        this.mTextWarn.setText(R.string.str_lz_ram_3);
                        break;
                    case 4:
                        this.mTextWarn.setText(R.string.str_lz_ram_4);
                        break;
                    case 5:
                        this.mTextWarn.setText(R.string.str_lz_ram_5);
                        break;
                    case 6:
                        this.mTextWarn.setText(R.string.str_lz_ram_6);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
