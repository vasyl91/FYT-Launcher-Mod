package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class PAJeepPitchAndRollAct extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 281:
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
                case 282:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_pitch_roll);
        init();
    }

    public void init() {
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{82}, null, null);
        addNotify();
    }

    @Override
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
    @Override
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
                case 2131427457: goto L10;
                case 2131427458: goto Lf;
                case 2131427459: goto Lf;
                case 2131427460: goto L10;
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
                case 2131427457: goto L24;
                case 2131427458: goto L23;
                case 2131427459: goto L23;
                case 2131427460: goto L24;
                default: goto L23;
            }
        L23:
            goto Lf
        L24:
            r3.mUpdatermCalTime(r2)
            r0 = 2131427471(0x7f0b008f, float:1.847656E38)
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
