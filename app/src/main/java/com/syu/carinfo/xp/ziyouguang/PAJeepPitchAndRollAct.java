package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0077_XP1_ACCORD9_H;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepPitchAndRollAct extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepPitchAndRollAct.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepPitchAndRollAct.this.num++;
            if (PAJeepPitchAndRollAct.this.num == 5) {
                DataCanbus.PROXY.cmd(10, new int[]{2}, null, null);
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
                case 269:
                    if ((value & 32768) != 0) {
                        int value2 = value - 65536;
                        ((PaJeepPitchView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value2);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value2) + "°");
                        break;
                    } else {
                        ((PaJeepPitchView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                        break;
                    }
                case 270:
                    if ((value & 32768) != 0) {
                        int value3 = value - 65536;
                        ((PaJeepRollView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value3) + "°");
                        break;
                    } else {
                        ((PaJeepRollView) PAJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                        ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                        break;
                    }
                case 273:
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                    break;
                case 274:
                    int a = value / Callback_0077_XP1_ACCORD9_H.Band_Am;
                    int b = ((value % Callback_0077_XP1_ACCORD9_H.Band_Am) * 60) / Callback_0077_XP1_ACCORD9_H.Band_Am;
                    int c = (((value % Callback_0077_XP1_ACCORD9_H.Band_Am) * 3600) / Callback_0077_XP1_ACCORD9_H.Band_Am) % 60;
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a) + "°" + b + "'" + c);
                    break;
                case 275:
                    int a2 = value / Callback_0077_XP1_ACCORD9_H.Band_Am;
                    int b2 = ((value % Callback_0077_XP1_ACCORD9_H.Band_Am) * 60) / Callback_0077_XP1_ACCORD9_H.Band_Am;
                    int c2 = (((value % Callback_0077_XP1_ACCORD9_H.Band_Am) * 3600) / Callback_0077_XP1_ACCORD9_H.Band_Am) % 60;
                    ((TextView) PAJeepPitchAndRollAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a2) + "°" + b2 + "'" + c2);
                    break;
                case 276:
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x000f A[FALL_THROUGH, RETURN] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            r1 = 1
            r2 = 0
            int r0 = r5.getAction()
            if (r0 != 0) goto L16
            int r0 = r4.getId()
            switch(r0) {
                case 2131427482: goto L10;
                case 2131427486: goto L10;
                default: goto Lf;
            }
        Lf:
            return r2
        L10:
            r3.num = r2
            r3.mUpdatermCalTime(r1)
            goto Lf
        L16:
            int r0 = r5.getAction()
            if (r0 != r1) goto Lf
            int r0 = r4.getId()
            switch(r0) {
                case 2131427482: goto L24;
                case 2131427486: goto L24;
                default: goto L23;
            }
        L23:
            goto Lf
        L24:
            r3.mUpdatermCalTime(r2)
            r0 = 2131427502(0x7f0b00ae, float:1.8476622E38)
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = ""
            r0.setText(r1)
            r3.num = r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xp.ziyouguang.PAJeepPitchAndRollAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
    }
}
