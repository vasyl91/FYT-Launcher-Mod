package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_ZiYouguang_ShupOnly extends Activity implements View.OnTouchListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_ShupOnly.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)).setChecked(value == 1);
                        break;
                    }
                case 104:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)).setChecked(value == 1);
                        break;
                    }
                case 105:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)).setChecked(value == 1);
                        break;
                    }
                case 106:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)).setChecked(value == 1);
                        break;
                    }
                case 107:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)).setChecked(value == 1);
                        break;
                    }
                case 108:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)).setChecked(value == 1);
                        break;
                    }
                case 109:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)).setChecked(value == 1);
                        break;
                    }
                case 110:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)).setChecked(value == 1);
                        break;
                    }
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
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        return false;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.rzc.ziyouguang.Rzc_ZiYouguang_ShupOnly.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
