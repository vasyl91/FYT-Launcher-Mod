package com.syu.carinfo.xfl.chuangku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XflCkShowPip {
    static StringBuffer buffer;
    static WindowManager manager;
    static View v = null;
    public static boolean IsShowPip = false;
    static View.OnClickListener PipClick = new View.OnClickListener() { // from class: com.syu.carinfo.xfl.chuangku.XflCkShowPip.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            int id = v2.getId();
            switch (id) {
                case R.id.btn_plus1 /* 2131427458 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(1);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(2);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(3);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(4);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(5);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(6);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(7);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(8);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus9 /* 2131427482 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(9);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus10 /* 2131427485 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(0);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus11 /* 2131427488 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append('*');
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus12 /* 2131427491 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append('#');
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.btn_plus13 /* 2131427494 */:
                    XflCkFunc.CAR_ON_START_CTL(2);
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        LayoutInflater inflater = (LayoutInflater) TheApp.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        v.findViewById(R.id.btn_plus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfl.chuangku.XflCkShowPip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                XflCkFunc.CAR_ON_START_CTL(3);
                XflCkShowPip.CancelWindow();
            }
        });
        v.findViewById(R.id.btn_plus10).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus1).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus2).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus3).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus4).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus5).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus6).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus7).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus8).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus9).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus12).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus11).setOnClickListener(PipClick);
        v.findViewById(R.id.btn_plus13).setOnClickListener(PipClick);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = 2007;
        params.flags = 40;
        params.format = 1;
        params.width = -1;
        params.height = -1;
        params.gravity = 51;
        manager = (WindowManager) TheApp.getInstance().getSystemService("window");
        manager.addView(v, params);
    }

    public static void CancelWindow() {
        if (manager != null) {
            manager.removeView(v);
            manager = null;
        }
        IsShowPip = false;
    }
}
