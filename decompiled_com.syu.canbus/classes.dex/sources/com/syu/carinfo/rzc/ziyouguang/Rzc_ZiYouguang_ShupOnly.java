package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_ShupOnly extends Activity implements View.OnTouchListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_ShupOnly.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)).setChecked(value == 1);
                    }
                    break;
                case 104:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)).setChecked(value == 1);
                    }
                    break;
                case 105:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)).setChecked(value == 1);
                    }
                    break;
                case 106:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)).setChecked(value == 1);
                    }
                    break;
                case 107:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)).setChecked(value == 1);
                    }
                    break;
                case 108:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)).setChecked(value == 1);
                    }
                    break;
                case 109:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)).setChecked(value == 1);
                    }
                    break;
                case 110:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)).setChecked(value == 1);
                    }
                    break;
            }
        }
    };
    int value;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_shup_only);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_373_front_anticollision)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_lanewar)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_steer_maintain)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_non_slip)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_sport_mode)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_eco_mode)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_auto_stop_start)).setOnTouchListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_373_radar_onoff)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.ctv_373_front_anticollision /* 2131431748 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{8, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{8, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_lanewar /* 2131431749 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{7, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{7, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_steer_maintain /* 2131431750 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{6, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{6, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_non_slip /* 2131431751 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{5, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{5, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_sport_mode /* 2131431752 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{4, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{4, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_eco_mode /* 2131431753 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{3, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{3, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_auto_stop_start /* 2131431754 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{2, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{2, 1}, null, null);
                }
                return false;
            case R.id.ctv_373_radar_onoff /* 2131431755 */:
                if (event.getAction() == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{1, 0}, null, null);
                }
                if (event.getAction() == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1, 1}, null, null);
                }
                return false;
            default:
                return false;
        }
    }
}
