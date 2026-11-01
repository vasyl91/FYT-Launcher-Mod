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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepGForceAct extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepGForceAct.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepGForceAct.this.num++;
            if (PAJeepGForceAct.this.num == 5) {
                DataCanbus.PROXY.cmd(10, new int[]{2, 0}, null, null);
                ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_calibration);
            }
            HandlerUI.getInstance().removeCallbacks(PAJeepGForceAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(PAJeepGForceAct.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepGForceAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 215:
                    if ((value & 32768) != 0) {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText("L:" + (65536 - value) + "°");
                    } else if (value == 0) {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "°");
                    } else {
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text6)).setText("R:" + value + "°");
                    }
                    break;
                case 269:
                    if ((value & 32768) != 0) {
                        int value2 = value - 65536;
                        ((PaJeepPitchView) PAJeepGForceAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value2);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(-value2) + "°");
                    } else {
                        ((PaJeepPitchView) PAJeepGForceAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 270:
                    if ((value & 32768) != 0) {
                        int value3 = value - 65536;
                        ((PaJeepRollView) PAJeepGForceAct.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(-value3) + "°");
                    } else {
                        ((PaJeepRollView) PAJeepGForceAct.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                        ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "°");
                    }
                    break;
                case 351:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 352:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 353:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 354:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 355:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 356:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 357:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 363:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
                case 364:
                    ((TextView) PAJeepGForceAct.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + ((value % 100) % 10) + "g");
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_g_force);
        findViewById(R.id.infoView_pitch).setOnTouchListener(this);
        findViewById(R.id.infoView_roll).setOnTouchListener(this);
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
                case R.id.infoView_pitch /* 2131428002 */:
                case R.id.infoView_roll /* 2131428003 */:
                    this.num = 0;
                    mUpdatermCalTime(true);
                default:
                    return false;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.infoView_pitch /* 2131428002 */:
                case R.id.infoView_roll /* 2131428003 */:
                    mUpdatermCalTime(false);
                    ((TextView) findViewById(R.id.tv_text6)).setText("");
                    this.num = 0;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(4, new int[]{96}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[351].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[363].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[364].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[357].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[351].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[363].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[364].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[357].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
    }
}
