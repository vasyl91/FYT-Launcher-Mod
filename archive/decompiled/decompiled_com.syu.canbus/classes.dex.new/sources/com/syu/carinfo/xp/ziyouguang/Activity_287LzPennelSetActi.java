package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Activity_287LzPennelSetActi extends Activity implements View.OnTouchListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_287LzPennelSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if ((value & 8) != 0) {
                        int value2 = 16 - value;
                        Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                        switch (value2) {
                            case 1:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_hp_seatblow_left_1);
                                break;
                            case 2:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_hp_seatblow_left_2);
                                break;
                            case 3:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_hp_seatblow_left_3);
                                break;
                        }
                    } else {
                        Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_hp_seatblow_left_0);
                        switch (value) {
                            case 0:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_hp_seathot_left_0);
                                break;
                            case 1:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_hp_seathot_left_1);
                                break;
                            case 2:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_hp_seathot_left_2);
                                break;
                            case 3:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_hp_seathot_left_3);
                                break;
                        }
                    }
                    break;
                case 30:
                    if ((value & 8) != 0) {
                        int value3 = 16 - value;
                        Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                        switch (value3) {
                            case 1:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_hp_seatblow_right_1);
                                break;
                            case 2:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_hp_seatblow_right_2);
                                break;
                            case 3:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_hp_seatblow_right_3);
                                break;
                        }
                    } else {
                        Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_hp_seatblow_right_0);
                        switch (value) {
                            case 0:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_hp_seathot_right_0);
                                break;
                            case 1:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_hp_seathot_right_1);
                                break;
                            case 2:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_hp_seathot_right_2);
                                break;
                            case 3:
                                Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_hp_seathot_right_3);
                                break;
                        }
                    }
                    break;
                case 66:
                    switch (value) {
                        case 0:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_hp_steerhot_n);
                            break;
                        case 1:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_hp_steerhot_p);
                            break;
                    }
                    break;
                case 106:
                    switch (value) {
                        case 0:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_jeep_button4_n);
                            break;
                        case 1:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_lz_jeep_button4_p);
                            break;
                    }
                    break;
                case 107:
                    switch (value) {
                        case 0:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_jeep_button5_n);
                            break;
                        case 1:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_lz_jeep_button5_p);
                            break;
                    }
                    break;
                case 108:
                    switch (value) {
                        case 0:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_lz_jeep_button6_n);
                            break;
                        case 1:
                            Activity_287LzPennelSetActi.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_lz_jeep_button6_p);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0287_lz_jeep_button);
        setListener();
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_plus1)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
        finish();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int data0 = 255;
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427458 */:
                data0 = 1;
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                data0 = 5;
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                data0 = 3;
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                data0 = 2;
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                data0 = 6;
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                data0 = 4;
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                data0 = 7;
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                data0 = 8;
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                data0 = 9;
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                data0 = 10;
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                data0 = 11;
                break;
        }
        if (data0 != 255) {
            if (event.getAction() == 0) {
                sendCmd(data0);
            } else if (event.getAction() == 1) {
                sendCmd(0);
            }
        }
        return false;
    }

    public void sendCmd(int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value1}, null, null);
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
    }
}
