package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

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
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0443_wc_focus_autopark, null, false);
        }
        switch (updateCode) {
            case 114:
                switch (value) {
                    case 2:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark02);
                        break;
                    case 4:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark04);
                        break;
                    case 5:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark05);
                        break;
                    case 6:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark06);
                        break;
                    case 7:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark07);
                        break;
                    case 8:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark08);
                        break;
                    case 9:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark09);
                        break;
                    case 10:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0a);
                        break;
                    case 11:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0b);
                        break;
                    case 12:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0c);
                        break;
                    case 13:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0d);
                        break;
                    case 14:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0e);
                        break;
                    case 15:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark0f);
                        break;
                    case 16:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark10);
                        break;
                    case 17:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark11);
                        break;
                    case 18:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark12);
                        break;
                    case 19:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark13);
                        break;
                    case 20:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark14);
                        break;
                    case 21:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark15);
                        break;
                    case 22:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark16);
                        break;
                    case 23:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark17);
                        break;
                    case 24:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark18);
                        break;
                    case 25:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark19);
                        break;
                    case 26:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1a);
                        break;
                    case 27:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1b);
                        break;
                    case 28:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1c);
                        break;
                    case 29:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1d);
                        break;
                    case 30:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1e);
                        break;
                    case 31:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark1f);
                        break;
                    case 32:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark20);
                        break;
                    case 33:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark21);
                        break;
                    case 34:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark22);
                        break;
                    case 35:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark23);
                        break;
                    case 36:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark24);
                        break;
                    case 37:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark25);
                        break;
                    case 38:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark26);
                        break;
                    case 39:
                        this.sWarnContent.findViewById(R.id.iv_ax5_warn).setBackgroundResource(R.drawable.ic_focus_autopark27);
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
