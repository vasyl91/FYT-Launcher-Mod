package com.syu.carinfo.xfl.chuangku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
                case R.id.pipbtn1 /* 2131431963 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(1);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn2 /* 2131431964 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(2);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn3 /* 2131431965 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(3);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn4 /* 2131431966 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(4);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn5 /* 2131431967 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(5);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn11 /* 2131431968 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append('*');
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn6 /* 2131431969 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(6);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn7 /* 2131431970 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(7);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn8 /* 2131431971 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(8);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn9 /* 2131431972 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(9);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn0 /* 2131431973 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append(0);
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipbtn10 /* 2131431974 */:
                    if (XflCkShowPip.buffer != null) {
                        XflCkShowPip.buffer.append('#');
                    }
                    ((TextView) v2.findViewById(R.id.showNumPip)).setText(XflCkShowPip.buffer.toString());
                    break;
                case R.id.pipcallanswer /* 2131431975 */:
                    XflCkFunc.CAR_ON_START_CTL(2);
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        LayoutInflater inflater = (LayoutInflater) LauncherApplication.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        v.findViewById(R.id.pipcallhang).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfl.chuangku.XflCkShowPip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                XflCkFunc.CAR_ON_START_CTL(3);
                XflCkShowPip.CancelWindow();
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
