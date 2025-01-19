package com.syu.carinfo.rzc.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Rzc_ZiYouguang_ShupOnly extends Activity implements View.OnTouchListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 170:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_front_anticollision)).setChecked(value == 1);
                        break;
                    }
                case 171:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_lanewar)).setChecked(value == 1);
                        break;
                    }
                case 172:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_steer_maintain)).setChecked(value == 1);
                        break;
                    }
                case 173:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_non_slip)).setChecked(value == 1);
                        break;
                    }
                case 174:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_sport_mode)).setChecked(value == 1);
                        break;
                    }
                case 175:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_eco_mode)).setChecked(value == 1);
                        break;
                    }
                case 176:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_auto_stop_start)).setChecked(value == 1);
                        break;
                    }
                case 177:
                    if (((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)) != null) {
                        ((CheckedTextView) Rzc_ZiYouguang_ShupOnly.this.findViewById(R.id.ctv_373_radar_onoff)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_shup_only);
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mCanbusNotify);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        return false;
     */
    @Override
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
