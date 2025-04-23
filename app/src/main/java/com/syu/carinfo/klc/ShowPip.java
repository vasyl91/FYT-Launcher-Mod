package com.syu.carinfo.klc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ShowPip {
    static StringBuffer buffer;
    static WindowManager manager;
    static TextView showNumTv;
    static View v = null;
    public static boolean IsShowPip = false;
    static int OnStarState = -1;
    private static IUiNotify updaterOnStarState = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 148) {
                ShowPip.OnStarState = DataCanbus.DATA[148];
                if (ShowPip.OnStarState == 0) {
                    ShowPip.CancelWindow();
                }
            }
        }
    };
    static View.OnClickListener PipClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v2) {
            int id = v2.getId();
            switch (id) {
                case R.id.pipbtn1 /* 2131431913 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(1);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn2 /* 2131431914 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(2);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn3 /* 2131431915 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(3);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn4 /* 2131431916 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(4);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn5 /* 2131431917 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(5);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn11 /* 2131431918 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append('*');
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn6 /* 2131431919 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(6);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn7 /* 2131431920 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(7);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn8 /* 2131431921 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(8);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn9 /* 2131431922 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(9);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn0 /* 2131431923 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append(0);
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn10 /* 2131431924 */:
                    if (ShowPip.buffer != null) {
                        ShowPip.buffer.append('#');
                    }
                    ShowPip.showNumTv.setText(ShowPip.buffer.toString());
                    break;
                case R.id.pipcallanswer /* 2131431925 */:
                    KlcFunc.C_CAR_ONSTAR_CMD(1, 0);
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        DataCanbus.NOTIFY_EVENTS[148].addNotify(updaterOnStarState, 1);
        LayoutInflater inflater = (LayoutInflater) LauncherApplication.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        showNumTv = (TextView) v.findViewById(R.id.showNumPip);
        v.findViewById(R.id.pipcallhang).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                KlcFunc.C_CAR_ONSTAR_CMD(3, 0);
                ShowPip.CancelWindow();
            }
        });
        v.findViewById(R.id.pipbtn0).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn1).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn2).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn3).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn4).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn5).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn6).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn7).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn8).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn9).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn10).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn11).setOnClickListener(PipClick);
        v.findViewById(R.id.pipcallanswer).setOnClickListener(PipClick);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = 2007;
        params.flags = 40;
        params.format = 1;
        params.width = -1;
        params.height = -1;
        params.gravity = 51;
        manager = (WindowManager) LauncherApplication.getInstance().getSystemService("window");
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
