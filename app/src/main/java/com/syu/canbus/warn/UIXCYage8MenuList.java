package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.Callback_0439_XBS_08Yage;
import com.syu.module.canbus.DataCanbus;

public class UIXCYage8MenuList {
    private static UIXCYage8MenuList mInstance;
    Context context;
    private TextView mTextWarn1;
    private TextView mTextWarn2;
    private TextView mTextWarn3;
    private View sWarnContent;

    public static UIXCYage8MenuList getInstance() {
        if (mInstance == null) {
            mInstance = new UIXCYage8MenuList();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        WarnUtils.showWindow();
        WarnUtils.postDimiss(5000);
    }

    public void Hideindow() {
        PopupWindow window = WarnUtils.getWindow();
        window.dismiss();
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0439_xc_yage8_menulist, null, false);
            this.mTextWarn1 = this.sWarnContent.findViewById(R.id.tv_text1);
            this.mTextWarn2 = this.sWarnContent.findViewById(R.id.tv_text2);
            this.mTextWarn3 = this.sWarnContent.findViewById(R.id.tv_text3);
        }
        if (updateCode == 132) {
            this.mTextWarn1.setText("");
            this.mTextWarn2.setText("Car Vol :" + DataCanbus.DATA[132]);
            this.mTextWarn3.setText("");
        } else if (Callback_0439_XBS_08Yage.MenuList1 != "" || Callback_0439_XBS_08Yage.MenuList2 != "" || Callback_0439_XBS_08Yage.MenuList3 != "") {
            this.mTextWarn1.setText(Callback_0439_XBS_08Yage.MenuList1);
            this.mTextWarn2.setText(Callback_0439_XBS_08Yage.MenuList2);
            this.mTextWarn3.setText(Callback_0439_XBS_08Yage.MenuList3);
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
