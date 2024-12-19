package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepDrivingHistroyAct extends BaseActivity {
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDrivingHistroyAct.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepDrivingHistroyAct.this.mUpdateDayNews();
            HandlerUI.getInstance().removeCallbacks(PAJeepDrivingHistroyAct.this.mCalTime);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDrivingHistroyAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 232:
                case 233:
                case 234:
                case 235:
                case 236:
                case 237:
                case 238:
                case 239:
                case 240:
                case 241:
                case 242:
                case 243:
                case 244:
                case 245:
                case 246:
                case 247:
                case 248:
                case 249:
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                case 255:
                case 256:
                case 257:
                case 258:
                case 259:
                    PAJeepDrivingHistroyAct.this.mUpdateDayNews();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_driving_histroy);
        init();
        mUpdatermCalTime();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{84}, null, null);
        DataCanbus.PROXY.cmd(4, new int[]{85}, null, null);
        addNotify();
        mUpdatermCalTime();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void mUpdatermCalTime() {
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        HandlerUI.getInstance().postDelayed(this.mCalTime, 50L);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[258].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[259].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[258].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[259].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateDayNews() {
        int engine = DataCanbus.DATA[232];
        int battery = DataCanbus.DATA[233];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_0)).setProgress(engine);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_0)).setLeftTopRightBottom(15, ((-battery) * 345) / 100, 29, 345 - ((battery * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_0)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_0)).setProgress(battery);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_0)).invalidate();
        int engine1 = DataCanbus.DATA[234];
        int battery1 = DataCanbus.DATA[235];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_1)).setProgress(engine1);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_1)).setLeftTopRightBottom(56, ((-battery1) * 345) / 100, 70, 345 - ((battery1 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_1)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_1)).setProgress(battery1);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_1)).invalidate();
        int engine2 = DataCanbus.DATA[236];
        int battery2 = DataCanbus.DATA[237];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_2)).setProgress(engine2);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_2)).setLeftTopRightBottom(97, ((-battery2) * 345) / 100, 111, 345 - ((battery2 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_2)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_2)).setProgress(battery2);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_2)).invalidate();
        int engine3 = DataCanbus.DATA[238];
        int battery3 = DataCanbus.DATA[239];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_3)).setProgress(engine3);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_3)).setLeftTopRightBottom(138, ((-battery3) * 345) / 100, 152, 345 - ((battery3 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_3)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_3)).setProgress(battery3);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_3)).invalidate();
        int engine4 = DataCanbus.DATA[240];
        int battery4 = DataCanbus.DATA[241];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_4)).setProgress(engine4);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_4)).setLeftTopRightBottom(179, ((-battery4) * 345) / 100, 193, 345 - ((battery4 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_4)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_4)).setProgress(battery4);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_4)).invalidate();
        int engine5 = DataCanbus.DATA[242];
        int battery5 = DataCanbus.DATA[243];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_5)).setProgress(engine5);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_5)).setLeftTopRightBottom(220, ((-battery5) * 345) / 100, 234, 345 - ((battery5 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_5)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_5)).setProgress(battery5);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_5)).invalidate();
        int engine6 = DataCanbus.DATA[244];
        int battery6 = DataCanbus.DATA[245];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_6)).setProgress(engine6);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_6)).setLeftTopRightBottom(261, ((-battery6) * 345) / 100, 275, 345 - ((battery6 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_6)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_6)).setProgress(battery6);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_6)).invalidate();
        int engine7 = DataCanbus.DATA[246];
        int battery7 = DataCanbus.DATA[247];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_7)).setProgress(engine7);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_7)).setLeftTopRightBottom(302, ((-battery7) * 345) / 100, 316, 345 - ((battery7 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_7)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_7)).setProgress(battery7);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_7)).invalidate();
        int engine8 = DataCanbus.DATA[248];
        int battery8 = DataCanbus.DATA[249];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_8)).setProgress(engine8);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_8)).setLeftTopRightBottom(343, ((-battery8) * 345) / 100, 357, 345 - ((battery8 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_8)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_8)).setProgress(battery8);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_8)).invalidate();
        int engine9 = DataCanbus.DATA[250];
        int battery9 = DataCanbus.DATA[251];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_9)).setProgress(engine9);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_9)).setLeftTopRightBottom(384, ((-battery9) * 345) / 100, 398, 345 - ((battery9 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_9)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_9)).setProgress(battery9);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_9)).invalidate();
        int engine10 = DataCanbus.DATA[252];
        int battery10 = DataCanbus.DATA[253];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_10)).setProgress(engine10);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_10)).setLeftTopRightBottom(425, ((-battery10) * 345) / 100, 439, 345 - ((battery10 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_10)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_10)).setProgress(battery10);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_10)).invalidate();
        int engine11 = DataCanbus.DATA[254];
        int battery11 = DataCanbus.DATA[255];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_11)).setProgress(engine11);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_11)).setLeftTopRightBottom(Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74, ((-battery11) * 345) / 100, Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B4, 345 - ((battery11 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_11)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_11)).setProgress(battery11);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_11)).invalidate();
        int engine12 = DataCanbus.DATA[256];
        int battery12 = DataCanbus.DATA[257];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_12)).setProgress(engine12);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_12)).setLeftTopRightBottom(ConstRzcAddData.U_CAR_LIGHT_FRONT, ((-battery12) * 345) / 100, ConstRzcAddData.U_CAR_AVG_FUEL, 345 - ((battery12 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_12)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_12)).setProgress(battery12);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_12)).invalidate();
        int engine13 = DataCanbus.DATA[258];
        int battery13 = DataCanbus.DATA[259];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_13)).setProgress(engine13);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_13)).setLeftTopRightBottom(548, ((-battery13) * 345) / 100, 562, 345 - ((battery13 * 345) / 100));
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_13)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_13)).setProgress(battery13);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_13)).invalidate();
    }
}
