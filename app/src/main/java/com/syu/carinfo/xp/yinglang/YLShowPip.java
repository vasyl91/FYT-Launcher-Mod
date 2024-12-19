package com.syu.carinfo.xp.yinglang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLShowPip {
    static StringBuffer buffer;
    static WindowManager manager;
    static TextView showNumTv;
    static View v = null;
    public static boolean IsShowPip = false;
    static View.OnClickListener PipClick = new View.OnClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLShowPip.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            int id = v2.getId();
            switch (id) {
                case R.id.pipbtn1 /* 2131431963 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(1);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn2 /* 2131431964 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(2);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn3 /* 2131431965 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(3);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn4 /* 2131431966 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(4);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn5 /* 2131431967 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(5);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn11 /* 2131431968 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append('*');
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn6 /* 2131431969 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(6);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn7 /* 2131431970 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(7);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn8 /* 2131431971 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(8);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn9 /* 2131431972 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(9);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn0 /* 2131431973 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append(0);
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipbtn10 /* 2131431974 */:
                    if (YLShowPip.buffer != null) {
                        YLShowPip.buffer.append('#');
                    }
                    YLShowPip.showNumTv.setText(YLShowPip.buffer.toString());
                    break;
                case R.id.pipcallanswer /* 2131431975 */:
                    YLFunc.CAR_ON_START_CTL(2);
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        LayoutInflater inflater = (LayoutInflater) LauncherApplication.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        showNumTv = (TextView) v.findViewById(R.id.showNumPip);
        v.findViewById(R.id.pipcallhang).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLShowPip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                YLFunc.CAR_ON_START_CTL(3);
                YLShowPip.CancelWindow();
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
        if (manager != null) {
            manager.removeView(v);
            manager = null;
        }
        IsShowPip = false;
    }
}
