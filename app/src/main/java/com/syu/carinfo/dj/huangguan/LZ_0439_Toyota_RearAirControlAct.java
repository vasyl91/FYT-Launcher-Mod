package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZ_0439_Toyota_RearAirControlAct extends Activity implements View.OnTouchListener {
    public static LZ_0439_Toyota_RearAirControlAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_RearAirControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 74:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirTempLeft();
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirTempRight();
                    break;
                case 110:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirTempLeft();
                    break;
                case 111:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirPower();
                    break;
                case 113:
                case 114:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdateAirBlow();
                    break;
                case 115:
                    LZ_0439_Toyota_RearAirControlAct.this.findViewById(R.id.air_xts_auto).setBackgroundResource(value == 0 ? R.drawable.ic_xts_auto_n : R.drawable.ic_xts_auto_p);
                    break;
                case 116:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirWindLevel();
                    break;
                case 118:
                    LZ_0439_Toyota_RearAirControlAct.this.mUpdaterAirTempRight();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_toyota_rear_carairset);
        init();
        mInstance = this;
    }

    private void init() {
        findViewById(R.id.air_xts_auto).setOnTouchListener(this);
        findViewById(R.id.air_xts_frontpage).setOnTouchListener(this);
        findViewById(R.id.air_xts_mode).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_plus).setOnTouchListener(this);
        findViewById(R.id.btn_air_temp_right_minus).setOnTouchListener(this);
        findViewById(R.id.air_xts_power).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(this);
        findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        mIsFront = true;
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        mIsFront = false;
        removeUpdater();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        return false;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            r9 = 22
            r8 = 2
            r7 = 1
            r6 = 0
            r5 = 0
            int r2 = r11.getId()
            r0 = 0
            switch(r2) {
                case 2131427425: goto L19;
                case 2131427427: goto L1c;
                case 2131427428: goto L16;
                case 2131427429: goto L25;
                case 2131427431: goto L28;
                case 2131427432: goto L31;
                case 2131427434: goto L2e;
                case 2131427436: goto L2b;
                case 2131427449: goto L1f;
                case 2131427451: goto L22;
                default: goto Le;
            }
        Le:
            int r3 = r12.getAction()
            switch(r3) {
                case 0: goto L41;
                case 1: goto L4d;
                default: goto L15;
            }
        L15:
            return r6
        L16:
            r0 = 44
            goto Le
        L19:
            r0 = 39
            goto Le
        L1c:
            r0 = 38
            goto Le
        L1f:
            r0 = 47
            goto Le
        L22:
            r0 = 46
            goto Le
        L25:
            r0 = 40
            goto Le
        L28:
            r0 = 41
            goto Le
        L2b:
            r0 = 45
            goto Le
        L2e:
            r0 = 43
            goto Le
        L31:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Exception -> L3c
            java.lang.Class<com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct> r4 = com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_AirControlAct.class
            r3.<init>(r10, r4)     // Catch: java.lang.Exception -> L3c
            r10.startActivity(r3)     // Catch: java.lang.Exception -> L3c
            goto Le
        L3c:
            r1 = move-exception
            r1.printStackTrace()
            goto Le
        L41:
            com.syu.ipc.RemoteModuleProxy r3 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r4 = new int[r8]
            r4[r6] = r0
            r4[r7] = r7
            r3.cmd(r9, r4, r5, r5)
            goto L15
        L4d:
            com.syu.ipc.RemoteModuleProxy r3 = com.syu.module.canbus.DataCanbus.PROXY
            int[] r4 = new int[r8]
            r4[r6] = r0
            r3.cmd(r9, r4, r5, r5)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.dj.huangguan.LZ_0439_Toyota_RearAirControlAct.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempLeft() {
        int temp = DataCanbus.DATA[110];
        int unit = DataCanbus.DATA[74];
        if (((TextView) findViewById(R.id.tv_air_temp_left)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_left)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_left)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirTempRight() {
        int temp = DataCanbus.DATA[118];
        int unit = DataCanbus.DATA[74];
        if (((TextView) findViewById(R.id.tv_air_temp_right)) != null) {
            switch (temp) {
                case -3:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("HI");
                    break;
                case -2:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("LOW");
                    break;
                case -1:
                    ((TextView) findViewById(R.id.tv_air_temp_right)).setText("--");
                    break;
                default:
                    if (unit == 1) {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℉");
                        break;
                    } else {
                        ((TextView) findViewById(R.id.tv_air_temp_right)).setText((temp / 10.0f) + "℃");
                        break;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirWindLevel() {
        int level = DataCanbus.DATA[116];
        if (level >= 0 && level <= 7) {
            ((TextView) findViewById(R.id.dj_xts_air_winlevel)).setText(new StringBuilder().append(level).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirPower() {
        int value = DataCanbus.DATA[111];
        findViewById(R.id.air_xts_power).setBackgroundResource(value == 0 ? R.drawable.ic_xts_power_n : R.drawable.ic_xts_power_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateAirBlow() {
        int mode;
        int mode2;
        int body = DataCanbus.DATA[113];
        int foot = DataCanbus.DATA[114];
        if (body == 1) {
            mode = 0 | 2;
        } else {
            mode = 0 & 253;
        }
        if (foot == 1) {
            mode2 = mode | 1;
        } else {
            mode2 = mode & 254;
        }
        if (mode2 == 1) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_rear_foot);
            return;
        }
        if (mode2 == 2) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_rear_body);
        } else if (mode2 == 3) {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_rear_foot_body);
        } else {
            findViewById(R.id.air_xts_mode).setBackgroundResource(R.drawable.ic_xts_mode_rear_null);
        }
    }
}
