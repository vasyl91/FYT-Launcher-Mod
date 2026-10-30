package com.syu.carinfo.klc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ShowPip {
    static StringBuffer buffer;
    static WindowManager manager;
    static View v = null;
    public static boolean IsShowPip = false;
    static int OnStarState = -1;
    private static IUiNotify updaterOnStarState = new IUiNotify() { // from class: com.syu.carinfo.klc.ShowPip.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 148) {
                ShowPip.OnStarState = DataCanbus.DATA[148];
                if (ShowPip.OnStarState == 0) {
                    ShowPip.CancelWindow();
                }
            }
        }
    };
    static View.OnClickListener PipClick = new View.OnClickListener() { // from class: com.syu.carinfo.klc.ShowPip.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            int id = v2.getId();
            switch (id) {
                case R.id.btn_plus1 /* 2131427458 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(1);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(2);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(3);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(4);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(5);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus6 /* 2131427473 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(6);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus7 /* 2131427476 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(7);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus8 /* 2131427479 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(8);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus9 /* 2131427482 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(9);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus10 /* 2131427485 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(0);
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus11 /* 2131427488 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append('*');
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus12 /* 2131427491 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append('#');
                    }
                    ((TextView) v2.findViewById(R.id.tv_text1)).setText(ShowPip.buffer.toString());
                    break;
                case R.id.btn_plus13 /* 2131427494 */:
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        DataCanbus.NOTIFY_EVENTS[148].addNotify(updaterOnStarState, 1);
        LayoutInflater inflater = (LayoutInflater) TheApp.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        v.findViewById(R.id.btn_plus14).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.klc.ShowPip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                ShowPip.CancelWindow();
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
        v.findViewById(R.id.btn_plus11).setOnClickListener(PipClick);
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
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(updaterOnStarState);
        if (manager != null) {
            manager.removeView(v);
            manager = null;
        }
        IsShowPip = false;
    }
}
