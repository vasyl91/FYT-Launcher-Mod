package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCFordFocus {
    private static UIWCFordFocus mInstance;
    Context context;
    private View sWarnContent;

    public static UIWCFordFocus getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCFordFocus();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[114] != 0 && DataCanbus.DATA[114] != 1) {
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0443_wc_focus_autopark, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 114:
                switch (value) {
                    case 2:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark02);
                        break;
                    case 4:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark04);
                        break;
                    case 5:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark05);
                        break;
                    case 6:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark06);
                        break;
                    case 7:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark07);
                        break;
                    case 8:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark08);
                        break;
                    case 9:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark09);
                        break;
                    case 10:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0a);
                        break;
                    case 11:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0b);
                        break;
                    case 12:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0c);
                        break;
                    case 13:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0d);
                        break;
                    case 14:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0e);
                        break;
                    case 15:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark0f);
                        break;
                    case 16:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark10);
                        break;
                    case 17:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark11);
                        break;
                    case 18:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark12);
                        break;
                    case 19:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark13);
                        break;
                    case 20:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark14);
                        break;
                    case 21:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark15);
                        break;
                    case 22:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark16);
                        break;
                    case 23:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark17);
                        break;
                    case 24:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark18);
                        break;
                    case 25:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark19);
                        break;
                    case 26:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1a);
                        break;
                    case 27:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1b);
                        break;
                    case 28:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1c);
                        break;
                    case 29:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1d);
                        break;
                    case 30:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1e);
                        break;
                    case 31:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark1f);
                        break;
                    case 32:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark20);
                        break;
                    case 33:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark21);
                        break;
                    case 34:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark22);
                        break;
                    case 35:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark23);
                        break;
                    case 36:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark24);
                        break;
                    case 37:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark25);
                        break;
                    case 38:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark26);
                        break;
                    case 39:
                        ((ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn)).setBackgroundResource(R.drawable.ic_focus_autopark27);
                        break;
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
