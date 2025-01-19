package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_FunctionalCarCamera extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.golf_camera_bright_m /* 2131431070 */:
                    int data = DataCanbus.DATA[201] - 1;
                    if (data >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{71, data}, null, null);
                        break;
                    }
                case R.id.golf_camera_bright_p /* 2131431072 */:
                    int data2 = DataCanbus.DATA[201] + 1;
                    if (data2 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{71, data2}, null, null);
                        break;
                    }
                case R.id.golf_camera_contrast_m /* 2131431073 */:
                    int data3 = DataCanbus.DATA[202] - 1;
                    if (data3 >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{72, data3}, null, null);
                        break;
                    }
                case R.id.golf_camera_contrast_p /* 2131431075 */:
                    int data4 = DataCanbus.DATA[202] + 1;
                    if (data4 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{72, data4}, null, null);
                        break;
                    }
                case R.id.golf_camera_color_m /* 2131431076 */:
                    int data5 = DataCanbus.DATA[203] - 1;
                    if (data5 >= 30) {
                        DataCanbus.PROXY.cmd(107, new int[]{73, data5}, null, null);
                        break;
                    }
                case R.id.golf_camera_color_p /* 2131431078 */:
                    int data6 = DataCanbus.DATA[203] + 1;
                    if (data6 <= 70) {
                        DataCanbus.PROXY.cmd(107, new int[]{73, data6}, null, null);
                        break;
                    }
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 201:
                    Golf7_XP_FunctionalCarCamera.this.uBright(val);
                    break;
                case 202:
                    Golf7_XP_FunctionalCarCamera.this.uContrast(val);
                    break;
                case 203:
                    Golf7_XP_FunctionalCarCamera.this.uColor(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_carcamera_set);
        init();
    }

    @Override
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

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
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
