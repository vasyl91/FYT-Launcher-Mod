package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalCarCamera extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalCarCamera.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.golf_camera_bright_m /* 2131431094 */:
                    int data = DataCanbus.DATA[147] - 1;
                    if (data >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{71, data}, null, null);
                        break;
                    }
                case R.id.golf_camera_bright_p /* 2131431096 */:
                    int data2 = DataCanbus.DATA[147] + 1;
                    if (data2 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{71, data2}, null, null);
                        break;
                    }
                case R.id.golf_camera_contrast_m /* 2131431097 */:
                    int data3 = DataCanbus.DATA[148] - 1;
                    if (data3 >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{72, data3}, null, null);
                        break;
                    }
                case R.id.golf_camera_contrast_p /* 2131431099 */:
                    int data4 = DataCanbus.DATA[148] + 1;
                    if (data4 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{72, data4}, null, null);
                        break;
                    }
                case R.id.golf_camera_color_m /* 2131431100 */:
                    int data5 = DataCanbus.DATA[149] - 1;
                    if (data5 >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{73, data5}, null, null);
                        break;
                    }
                case R.id.golf_camera_color_p /* 2131431102 */:
                    int data6 = DataCanbus.DATA[149] + 1;
                    if (data6 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{73, data6}, null, null);
                        break;
                    }
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalCarCamera.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    Golf7_XP_FunctionalCarCamera.this.uBright(val);
                    break;
                case 148:
                    Golf7_XP_FunctionalCarCamera.this.uContrast(val);
                    break;
                case 149:
                    Golf7_XP_FunctionalCarCamera.this.uColor(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_carcamera_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.golf_camera_bright_m));
        setonClick((Button) findViewById(R.id.golf_camera_bright_p));
        setonClick((Button) findViewById(R.id.golf_camera_contrast_m));
        setonClick((Button) findViewById(R.id.golf_camera_contrast_p));
        setonClick((Button) findViewById(R.id.golf_camera_color_m));
        setonClick((Button) findViewById(R.id.golf_camera_color_p));
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
    }

    protected void uBright(int val) {
        if (val >= 30 && val <= 70 && ((TextView) findViewById(R.id.golf_camera_bright_txt)) != null) {
            ((TextView) findViewById(R.id.golf_camera_bright_txt)).setText(new StringBuilder().append(val).toString());
        }
    }

    protected void uColor(int val) {
        if (val >= 30 && val <= 70 && ((TextView) findViewById(R.id.golf_camera_color_txt)) != null) {
            ((TextView) findViewById(R.id.golf_camera_color_txt)).setText(new StringBuilder().append(val).toString());
        }
    }

    protected void uContrast(int val) {
        if (val >= 30 && val <= 70 && ((TextView) findViewById(R.id.golf_camera_contrast_txt)) != null) {
            ((TextView) findViewById(R.id.golf_camera_contrast_txt)).setText(new StringBuilder().append(val).toString());
        }
    }
}
