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
public class UIRZCXiandaiBack {
    private static UIRZCXiandaiBack mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;

    public static UIRZCXiandaiBack getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCXiandaiBack();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null && ((updateCode == 195 && value != 0) || (updateCode == 222 && value != 0))) {
            WarnUtils.showWindow();
            if (updateCode == 195 && DataCanbus.DATA[222] == 0) {
                WarnUtils.postDimiss(5000);
                return;
            }
            return;
        }
        if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0447_car_mode_backcar, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCXiandaiBack.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(11, new int[]{9, 5}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCXiandaiBack.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(11, new int[]{9, 3}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCXiandaiBack.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(11, new int[]{9, 4}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCXiandaiBack.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(11, new int[]{9, 1}, null, null);
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.canbus.warn.UIRZCXiandaiBack.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(11, new int[]{9, 2}, null, null);
                }
            });
        }
        switch (updateCode) {
            case 195:
                switch (value) {
                    case 1:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode1);
                        break;
                    case 2:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode2);
                        break;
                    case 3:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode3);
                        break;
                    case 6:
                        this.mLayoutImage.setBackgroundResource(R.drawable.ic_xiandai_mode6);
                        break;
                }
                break;
            case 222:
                if (value == 0) {
                    this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(8);
                    this.sWarnContent.findViewById(R.id.iv_ax5_warn).setVisibility(0);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view1).setVisibility(0);
                    this.sWarnContent.findViewById(R.id.iv_ax5_warn).setVisibility(8);
                }
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
