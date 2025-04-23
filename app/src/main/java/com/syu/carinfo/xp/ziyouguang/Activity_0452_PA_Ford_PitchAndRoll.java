package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

public class Activity_0452_PA_Ford_PitchAndRoll extends Activity implements View.OnTouchListener {
    int num = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
        public void run() {
            Activity_0452_PA_Ford_PitchAndRoll.this.num++;
            if (Activity_0452_PA_Ford_PitchAndRoll.this.num == 5) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
                    case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
                    case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                        DataCanbus.PROXY.cmd(42, new int[]{2}, null, null);
                        break;
                    default:
                        DataCanbus.PROXY.cmd(10, new int[]{2}, null, null);
                        break;
                }
                ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text6)).setText(R.string.str_calibration);
            }
            HandlerUI.getInstance().removeCallbacks(Activity_0452_PA_Ford_PitchAndRoll.this.mCalTime);
            HandlerUI.getInstance().postDelayed(Activity_0452_PA_Ford_PitchAndRoll.this.mCalTime, 1000L);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 1966454 || DataCanbus.DATA[1000] == 2031990 || DataCanbus.DATA[1000] == 2294134 || DataCanbus.DATA[1000] == 2359670 || DataCanbus.DATA[1000] == 2425206 || DataCanbus.DATA[1000] == 2490742 || DataCanbus.DATA[1000] == 2556278 || DataCanbus.DATA[1000] == 5046646 || DataCanbus.DATA[1000] == 5112182 || DataCanbus.DATA[1000] == 2883958 || DataCanbus.DATA[1000] == 3932534 || DataCanbus.DATA[1000] == 2949494 || DataCanbus.DATA[1000] == 3015030 || DataCanbus.DATA[1000] == 3080566 || DataCanbus.DATA[1000] == 3146102 || DataCanbus.DATA[1000] == 3211638 || DataCanbus.DATA[1000] == 3277174 || DataCanbus.DATA[1000] == 3342710 || DataCanbus.DATA[1000] == 3408246 || DataCanbus.DATA[1000] == 3998070 || DataCanbus.DATA[1000] == 3473782 || DataCanbus.DATA[1000] == 3539318 || DataCanbus.DATA[1000] == 3604854 || DataCanbus.DATA[1000] == 3670390 || DataCanbus.DATA[1000] == 3735926 || DataCanbus.DATA[1000] == 3801462 || DataCanbus.DATA[1000] == 3866998 || DataCanbus.DATA[1000] == 4260214 || DataCanbus.DATA[1000] == 4325750 || DataCanbus.DATA[1000] == 4391286 || DataCanbus.DATA[1000] == 4456822 || DataCanbus.DATA[1000] == 4522358 || DataCanbus.DATA[1000] == 4587894 || DataCanbus.DATA[1000] == 4653430 || DataCanbus.DATA[1000] == 4718966 || DataCanbus.DATA[1000] == 4784502 || DataCanbus.DATA[1000] == 4850038 || DataCanbus.DATA[1000] == 4915574 || DataCanbus.DATA[1000] == 4981110) {
                switch (updateCode) {
                    case 281:
                        if ((value & 32768) != 0) {
                            int value2 = value - 65536;
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value2);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value2) + "°");
                            break;
                        } else {
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                            break;
                        }
                    case 282:
                        if ((value & 32768) != 0) {
                            int value3 = value - 65536;
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value3) + "°");
                            break;
                        } else {
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                            break;
                        }
                    case 285:
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                        break;
                    case 286:
                        int a = value / 10000;
                        int b = ((value % 10000) * 60) / 10000;
                        int c = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a) + "°" + b + "'" + c);
                        break;
                    case 287:
                        int a2 = value / 10000;
                        int b2 = ((value % 10000) * 60) / 10000;
                        int c2 = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a2) + "°" + b2 + "'" + c2);
                        break;
                    case 288:
                        ((PaJeepAngleView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_angle)).setSpeed(-value);
                        break;
                }
            }
            if (DataCanbus.DATA[1000] == 11731396 || DataCanbus.DATA[1000] == 11796932 || DataCanbus.DATA[1000] == 11862468 || DataCanbus.DATA[1000] == 11928004 || DataCanbus.DATA[1000] == 13894084) {
                switch (updateCode) {
                    case 143:
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                        break;
                    case 144:
                        int a3 = value / 10000;
                        int b3 = ((value % 10000) * 60) / 10000;
                        int c3 = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a3) + "°" + b3 + "'" + c3);
                        break;
                    case 145:
                        int a4 = value / 10000;
                        int b4 = ((value % 10000) * 60) / 10000;
                        int c4 = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a4) + "°" + b4 + "'" + c4);
                        break;
                    case 146:
                        ((PaJeepAngleView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_angle)).setSpeed(-value);
                        break;
                    case 147:
                        if ((value & 32768) != 0) {
                            int value4 = value - 65536;
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value4);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value4) + "°");
                            break;
                        } else {
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                            break;
                        }
                    case 148:
                        if ((value & 32768) != 0) {
                            int value5 = value - 65536;
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value5);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value5) + "°");
                            break;
                        } else {
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                            break;
                        }
                }
            }
            if (DataCanbus.DATA[1000] == 5177741 || DataCanbus.DATA[1000] == 5243277 || DataCanbus.DATA[1000] == 6422925 || DataCanbus.DATA[1000] == 6488461 || DataCanbus.DATA[1000] == 6553997 || DataCanbus.DATA[1000] == 6619533 || DataCanbus.DATA[1000] == 6685069 || DataCanbus.DATA[1000] == 6750605 || DataCanbus.DATA[1000] == 6816141 || DataCanbus.DATA[1000] == 6029709 || DataCanbus.DATA[1000] == 6095245 || DataCanbus.DATA[1000] == 6160781 || DataCanbus.DATA[1000] == 6226317 || DataCanbus.DATA[1000] == 6291853 || DataCanbus.DATA[1000] == 6357389 || DataCanbus.DATA[1000] == 5308813 || DataCanbus.DATA[1000] == 5374349 || DataCanbus.DATA[1000] == 5439885 || DataCanbus.DATA[1000] == 5505421 || DataCanbus.DATA[1000] == 5570957 || DataCanbus.DATA[1000] == 5636493 || DataCanbus.DATA[1000] == 5833101 || DataCanbus.DATA[1000] == 5898637 || DataCanbus.DATA[1000] == 5964173) {
                switch (updateCode) {
                    case 207:
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                        break;
                    case 208:
                        int a5 = value / 10000;
                        int b5 = ((value % 10000) * 60) / 10000;
                        int c5 = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a5) + "°" + b5 + "'" + c5);
                        break;
                    case 209:
                        int a6 = value / 10000;
                        int b6 = ((value % 10000) * 60) / 10000;
                        int c6 = (((value % 10000) * 3600) / 10000) % 60;
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a6) + "°" + b6 + "'" + c6);
                        break;
                    case 210:
                        ((PaJeepAngleView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_angle)).setSpeed(-value);
                        break;
                    case 211:
                        if ((value & 32768) != 0) {
                            int value6 = value - 65536;
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value6);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value6) + "°");
                            break;
                        } else {
                            ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                            break;
                        }
                    case 212:
                        if ((value & 32768) != 0) {
                            int value7 = value - 65536;
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value7);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value7) + "°");
                            break;
                        } else {
                            ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                            ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                            break;
                        }
                }
            }
            switch (updateCode) {
                case 111:
                    if ((value & 32768) != 0) {
                        int value8 = value - 65536;
                        ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value8);
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(-value8) + "°");
                        break;
                    } else {
                        ((PaJeepPitchView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_pitch)).setSpeed(value);
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "°");
                        break;
                    }
                case 112:
                    if ((value & 32768) != 0) {
                        int value9 = value - 65536;
                        ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value9);
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(-value9) + "°");
                        break;
                    } else {
                        ((PaJeepRollView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_roll)).setSpeed(value);
                        ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "°");
                        break;
                    }
                case 126:
                    ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "m");
                    break;
                case 127:
                    int a7 = value / 10000;
                    int b7 = ((value % 10000) * 60) / 10000;
                    int c7 = (((value % 10000) * 3600) / 10000) % 60;
                    ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text1)).setText(String.valueOf(a7) + "°" + b7 + "'" + c7);
                    break;
                case 128:
                    int a8 = value / 10000;
                    int b8 = ((value % 10000) * 60) / 10000;
                    int c8 = (((value % 10000) * 3600) / 10000) % 60;
                    ((TextView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.tv_text2)).setText(String.valueOf(a8) + "°" + b8 + "'" + c8);
                    break;
                case 129:
                    ((PaJeepAngleView) Activity_0452_PA_Ford_PitchAndRoll.this.findViewById(R.id.infoView_angle)).setSpeed(-value);
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
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.xp.ziyouguang.Activity_0452_PA_Ford_PitchAndRoll.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void addNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[286].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[287].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
                break;
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[208].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[209].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[210].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[211].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[212].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[213].addNotify(this.mNotifyCanbus, 1);
                break;
            case FinalCanbus.CAR_452_PA_Nissan_XTrail_21 /* 11731396 */:
            case FinalCanbus.CAR_452_PA_Nissan_Loulan_21 /* 11796932 */:
            case FinalCanbus.CAR_452_PA_Nissan_Terra_21 /* 11862468 */:
            case FinalCanbus.CAR_452_PA_Nissan_TITAN /* 11928004 */:
            case FinalCanbus.CAR_452_PA_Infiniti_G37 /* 13894084 */:
                DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    public void removeNotify() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_PA_dorango_10 /* 1966454 */:
            case FinalCanbus.CAR_PA_GMC_13 /* 2031990 */:
            case FinalCanbus.CAR_PA_SONOTEC_13 /* 2294134 */:
            case FinalCanbus.CAR_PA_Escalade_13 /* 2359670 */:
            case FinalCanbus.CAR_PA_Ford_F250 /* 2425206 */:
            case FinalCanbus.CAR_PA_Ford_F450 /* 2490742 */:
            case FinalCanbus.CAR_PA_Ford_F650 /* 2556278 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19 /* 2883958 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22 /* 2949494 */:
            case FinalCanbus.CAR_PA_Ford_F150_14 /* 3015030 */:
            case FinalCanbus.CAR_PA_Ford_F150_20 /* 3080566 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18 /* 3146102 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21 /* 3211638 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17 /* 3277174 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21 /* 3342710 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_CD /* 3408246 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_CD /* 3473782 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_CD /* 3539318 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_CD /* 3604854 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_CD /* 3670390 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_CD /* 3735926 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_CD /* 3801462 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_CD /* 3866998 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15 /* 3932534 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_CD /* 3998070 */:
            case FinalCanbus.CAR_PA_Ford_Explorer_19_Amp /* 4260214 */:
            case FinalCanbus.CAR_PA_Ford_Fusion_22_Amp /* 4325750 */:
            case FinalCanbus.CAR_PA_Ford_F150_14_Amp /* 4391286 */:
            case FinalCanbus.CAR_PA_Ford_F150_20_Amp /* 4456822 */:
            case FinalCanbus.CAR_PA_Ford_Focus_18_Amp /* 4522358 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_21_Amp /* 4587894 */:
            case FinalCanbus.CAR_PA_Ford_Expedition_17_Amp /* 4653430 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_21_Amp /* 4718966 */:
            case FinalCanbus.CAR_PA_Ford_mustang_15_Amp /* 4784502 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16 /* 4850038 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_CD /* 4915574 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Amp /* 4981110 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_08 /* 5046646 */:
            case FinalCanbus.CAR_PA_Ford_F_Super_duty_16_Low /* 5112182 */:
                DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[286].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[287].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
                break;
            case FinalCanbus.CAR_BNR_Toyota_14Tundra /* 5177741 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AUTO /* 5243277 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AUTO /* 5308813 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER /* 5374349 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO /* 5439885 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA /* 5505421 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AUTO_19 /* 5570957 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_19 /* 5636493 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10 /* 5833101 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra /* 5898637 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AUTO /* 5964173 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_22 /* 6029709 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_LS460_06 /* 6095245 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GS_06 /* 6160781 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_IS_06 /* 6226317 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_ES_06 /* 6291853 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_GX460_10 /* 6357389 */:
            case FinalCanbus.CAR_BNR_Toyota_14Tundra_AMP /* 6422925 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_4RUNNER_AMP /* 6488461 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP /* 6553997 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_AMP_19 /* 6619533 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_TACOMA_10_AMP /* 6685069 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_10Tundra_AMP /* 6750605 */:
            case FinalCanbus.CAR_PA_BNR_Toyota_Sequoia_AMP /* 6816141 */:
                DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.mNotifyCanbus);
                break;
            case FinalCanbus.CAR_452_PA_Nissan_XTrail_21 /* 11731396 */:
            case FinalCanbus.CAR_452_PA_Nissan_Loulan_21 /* 11796932 */:
            case FinalCanbus.CAR_452_PA_Nissan_Terra_21 /* 11862468 */:
            case FinalCanbus.CAR_452_PA_Nissan_TITAN /* 11928004 */:
            case FinalCanbus.CAR_452_PA_Infiniti_G37 /* 13894084 */:
                DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
                break;
        }
    }
}
