package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.VerticalProgressbar;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class PAJeepDrivingHistroyAct extends BaseActivity {
    Runnable mCalTime = new Runnable() { 
        @Override
        public void run() {
            PAJeepDrivingHistroyAct.this.mUpdateDayNews();
            HandlerUI.getInstance().removeCallbacks(PAJeepDrivingHistroyAct.this.mCalTime);
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
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
                case 260:
                case 261:
                case 262:
                case 263:
                case 264:
                case 265:
                case 266:
                case 267:
                case 268:
                case 269:
                case 270:
                case 271:
                    PAJeepDrivingHistroyAct.this.mUpdateDayNews();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_driving_histroy);
        init();
        mUpdatermCalTime();
    }

    @Override
    public void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{84}, null, null);
        DataCanbus.PROXY.cmd(4, new int[]{85}, null, null);
        addNotify();
        mUpdatermCalTime();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void mUpdatermCalTime() {
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        HandlerUI.getInstance().postDelayed(this.mCalTime, 50L);
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateDayNews() {
        int engine = DataCanbus.DATA[244];
        int battery = DataCanbus.DATA[245];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_0)).setProgress(engine);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_0)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_0)).setProgress(battery);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_0)).invalidate();
        int engine1 = DataCanbus.DATA[246];
        int battery1 = DataCanbus.DATA[247];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_1)).setProgress(engine1);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_1)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_1)).setProgress(battery1);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_1)).invalidate();
        int engine2 = DataCanbus.DATA[248];
        int battery2 = DataCanbus.DATA[249];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_2)).setProgress(engine2);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_2)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_2)).setProgress(battery2);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_2)).invalidate();
        int engine3 = DataCanbus.DATA[250];
        int battery3 = DataCanbus.DATA[251];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_3)).setProgress(engine3);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_3)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_3)).setProgress(battery3);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_3)).invalidate();
        int engine4 = DataCanbus.DATA[252];
        int battery4 = DataCanbus.DATA[253];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_4)).setProgress(engine4);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_4)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_4)).setProgress(battery4);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_4)).invalidate();
        int engine5 = DataCanbus.DATA[254];
        int battery5 = DataCanbus.DATA[255];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_5)).setProgress(engine5);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_5)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_5)).setProgress(battery5);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_5)).invalidate();
        int engine6 = DataCanbus.DATA[256];
        int battery6 = DataCanbus.DATA[257];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_6)).setProgress(engine6);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_6)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_6)).setProgress(battery6);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_6)).invalidate();
        int engine7 = DataCanbus.DATA[258];
        int battery7 = DataCanbus.DATA[259];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_7)).setProgress(engine7);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_7)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_7)).setProgress(battery7);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_7)).invalidate();
        int engine8 = DataCanbus.DATA[260];
        int battery8 = DataCanbus.DATA[261];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_8)).setProgress(engine8);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_8)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_8)).setProgress(battery8);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_8)).invalidate();
        int engine9 = DataCanbus.DATA[262];
        int battery9 = DataCanbus.DATA[263];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_9)).setProgress(engine9);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_9)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_9)).setProgress(battery9);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_9)).invalidate();
        int engine10 = DataCanbus.DATA[264];
        int battery10 = DataCanbus.DATA[265];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_10)).setProgress(engine10);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_10)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_10)).setProgress(battery10);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_10)).invalidate();
        int engine11 = DataCanbus.DATA[266];
        int battery11 = DataCanbus.DATA[267];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_11)).setProgress(engine11);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_11)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_11)).setProgress(battery11);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_11)).invalidate();
        int engine12 = DataCanbus.DATA[268];
        int battery12 = DataCanbus.DATA[269];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_12)).setProgress(engine12);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_12)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_12)).setProgress(battery12);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_12)).invalidate();
        int engine13 = DataCanbus.DATA[270];
        int battery13 = DataCanbus.DATA[271];
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_13)).setProgress(engine13);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_engine_13)).invalidate();
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_13)).setProgress(battery13);
        ((VerticalProgressbar) findViewById(R.id.pa_jeep_battery_13)).invalidate();
    }
}
