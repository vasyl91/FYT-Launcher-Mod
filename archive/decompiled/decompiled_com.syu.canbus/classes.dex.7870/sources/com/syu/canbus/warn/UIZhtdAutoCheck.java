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
public class UIZhtdAutoCheck {
    private static UIZhtdAutoCheck mInstance;
    Context context;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIZhtdAutoCheck getInstance() {
        if (mInstance == null) {
            mInstance = new UIZhtdAutoCheck();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && DataCanbus.DATA[189] != 0) {
            WarnUtils.showWindow();
        }
    }

    public void Hideindow() {
        PopupWindow window = WarnUtils.getWindow();
        window.dismiss();
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0450_zhtd_lexus_lvdsinfo, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 174:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("0:1280*480");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("1:800*480");
                        break;
                    case 8:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("8:1920*720");
                        break;
                    case 9:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("9:1280*720");
                        break;
                    case 12:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("12:480*240");
                        break;
                    case 176:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("B0:LX800*480");
                        break;
                    case 177:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("B1:LX800*480");
                        break;
                    case 188:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("BC:LX480*240");
                        break;
                    default:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("----");
                        break;
                }
                break;
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
                int d5 = DataCanbus.DATA[175];
                int d7 = DataCanbus.DATA[176];
                int d9 = DataCanbus.DATA[177];
                int d11 = DataCanbus.DATA[178];
                int d13 = DataCanbus.DATA[179];
                int d15 = DataCanbus.DATA[180];
                int d17 = DataCanbus.DATA[181];
                int d19 = DataCanbus.DATA[182];
                int d21 = DataCanbus.DATA[183];
                int d23 = DataCanbus.DATA[184];
                int d26 = DataCanbus.DATA[185];
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Hfps: " + d5 + "  Hs: " + d7 + "  Hbp: " + d9 + "  Hact: " + d11 + "  Htotal: " + d13 + "  Vfp: " + d15 + "  Vs: " + d17 + "  Vbp: " + d19 + "  Vact: " + d21 + "  Vtotal: " + d23 + "  Pclk: " + d26);
                break;
            case 186:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("Sync: 0x" + Integer.toHexString(value));
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
