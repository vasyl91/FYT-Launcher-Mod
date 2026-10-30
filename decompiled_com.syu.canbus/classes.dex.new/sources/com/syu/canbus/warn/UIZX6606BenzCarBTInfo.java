package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0448_LZ_BWM_CarUi;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIZX6606BenzCarBTInfo {
    private static UIZX6606BenzCarBTInfo mInstance;
    Context context;
    private View sWarnContent;

    public static UIZX6606BenzCarBTInfo getInstance() {
        if (mInstance == null) {
            mInstance = new UIZX6606BenzCarBTInfo();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[135] != 0 && DataCanbus.DATA[134] == 0) {
            this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_benz_24viro_phone_n);
            this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_benz_24viro_hang_n);
            WarnUtils.showWindow();
        } else if (window.isShowing()) {
            window.dismiss();
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0448_zx_benz_carbtinfo, (ViewGroup) null, false);
            if (this.sWarnContent.findViewById(R.id.btn_plus1) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIZX6606BenzCarBTInfo.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = event.getAction();
                        if (action == 0) {
                            UIZX6606BenzCarBTInfo.this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_benz_24viro_phone_p);
                            DataCanbus.PROXY.cmd(40, new int[]{1, 1}, null, null);
                        } else if (action == 1) {
                            UIZX6606BenzCarBTInfo.this.sWarnContent.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_benz_24viro_phone_n);
                            DataCanbus.PROXY.cmd(40, new int[]{1, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
            if (this.sWarnContent.findViewById(R.id.btn_plus2) != null) {
                this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIZX6606BenzCarBTInfo.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = event.getAction();
                        if (action == 0) {
                            UIZX6606BenzCarBTInfo.this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_benz_24viro_hang_p);
                            DataCanbus.PROXY.cmd(40, new int[]{2, 1}, null, null);
                        } else if (action == 1) {
                            UIZX6606BenzCarBTInfo.this.sWarnContent.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_benz_24viro_hang_n);
                            DataCanbus.PROXY.cmd(40, new int[]{2, 0}, null, null);
                        }
                        return true;
                    }
                });
            }
        }
        switch (updateCode) {
            case 135:
                switch (value) {
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("来电");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("已连接");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("正在呼叫");
                        break;
                }
                break;
            case 136:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText(Callback_0448_LZ_BWM_CarUi.CarBTInfo);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
