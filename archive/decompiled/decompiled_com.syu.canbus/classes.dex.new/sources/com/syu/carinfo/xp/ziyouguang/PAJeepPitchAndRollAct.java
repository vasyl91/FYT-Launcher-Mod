package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class PAJeepPitchAndRollAct extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepPitchAndRollAct.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepPitchAndRollAct.this.num++;
            if (PAJeepPitchAndRollAct.this.num == 5) {
                DataCanbus.PROXY.cmd(10, new int[]{2, 0}, null, null);
                ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_calibration);
            }
            HandlerUI.getInstance().removeCallbacks(PAJeepPitchAndRollAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(PAJeepPitchAndRollAct.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepPitchAndRollAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 281:
                    if ((value & 32768) != 0) {
                        int value2 = value - 65536;
                        ((PaJeepPitchView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value2);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value2) + "°");
                    } else {
                        ((PaJeepPitchView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 282:
                    if ((value & 32768) != 0) {
                        int value3 = value - 65536;
                        ((PaJeepRollView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value3) + "°");
                    } else {
                        ((PaJeepRollView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 285:
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                    break;
                case 286:
                    int a = value / 10000;
                    int b = ((value % 10000) * 60) / 10000;
                    int c = (((value % 10000) * 3600) / 10000) % 60;
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a) + "°" + b + "'" + c);
                    break;
                case 287:
                    int a2 = value / 10000;
                    int b2 = ((value % 10000) * 60) / 10000;
                    int c2 = (((value % 10000) * 3600) / 10000) % 60;
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a2) + "°" + b2 + "'" + c2);
                    break;
                case 288:
                    ((PaJeepAngleView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_angle)).setSpeed(-value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_pitch_roll);
        init();
    }

    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000f A[FALL_THROUGH, RETURN] */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427458 */:
                case R.id.btn_plus2 /* 2131427461 */:
                    this.num = 0;
                    mUpdatermCalTime(true);
                case R.id.btn_minus2 /* 2131427459 */:
                case R.id.tv_text2 /* 2131427460 */:
                default:
                    return false;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427458 */:
                case R.id.btn_plus2 /* 2131427461 */:
                    mUpdatermCalTime(false);
                    ((TextView) findViewById(R.id.tv_text6)).setText("");
                    this.num = 0;
                case R.id.btn_minus2 /* 2131427459 */:
                case R.id.tv_text2 /* 2131427460 */:
                default:
                    return false;
            }
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
    }
}
