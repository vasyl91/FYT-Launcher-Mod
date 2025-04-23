package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

public class Xp_374_CarCD extends Activity implements View.OnTouchListener {
    public static Xp_374_CarCD mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 181:
                    Xp_374_CarCD.this.mUpdaterCdState(value);
                    break;
                case 182:
                    Xp_374_CarCD.this.mUpdaterCdRepeat(value);
                    break;
                case 183:
                    Xp_374_CarCD.this.mUpdaterCdRandom(value);
                    break;
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                    Xp_374_CarCD.this.mUpdaterCdTime();
                    break;
                case 190:
                case 191:
                    Xp_374_CarCD.this.mUpdaterCdTrack();
                    break;
                case 192:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_title)).setText(Callback_0374_XP1_ZiYouGuang.Title);
                    break;
                case 193:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_album)).setText(Callback_0374_XP1_ZiYouGuang.Album);
                    break;
                case 194:
                    ((TextView) Xp_374_CarCD.this.findViewById(R.id.cd_artist)).setText(Callback_0374_XP1_ZiYouGuang.Artist);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_daqienuoji_carcd);
        mInstance = this;
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_repeat)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ramdom)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(5, cmdId, 0);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_repeat /* 2131427916 */:
                if (DataCanbus.DATA[182] == 1) {
                    this.cmdId = 15;
                    break;
                } else {
                    this.cmdId = 14;
                    break;
                }
            case R.id.cd_ramdom /* 2131427917 */:
                if (DataCanbus.DATA[183] == 1) {
                    this.cmdId = 10;
                    break;
                } else {
                    this.cmdId = 9;
                    break;
                }
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 3;
                break;
            case R.id.cd_fb /* 2131427919 */:
                this.cmdId = 6;
                break;
            case R.id.cd_play /* 2131427920 */:
                this.cmdId = 2;
                break;
            case R.id.cd_pause /* 2131427921 */:
                this.cmdId = 1;
                break;
            case R.id.cd_ff /* 2131427922 */:
                this.cmdId = 5;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 4;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(this.cmdId, 0);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdRandom(int value) {
        ((Button) findViewById(R.id.cd_ramdom)).setSelected(value == 1);
    }

    
    public void mUpdaterCdRepeat(int value) {
        ((Button) findViewById(R.id.cd_repeat)).setSelected(value == 1);
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_327_insert_disc);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.crv_playstate_0);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.crv_state_pause);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_car_cd_eject);
                break;
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[190];
        int value1 = DataCanbus.DATA[191];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + " / " + value1);
    }

    
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[184];
        int value1 = DataCanbus.DATA[185];
        int value2 = DataCanbus.DATA[186];
        int value3 = DataCanbus.DATA[187];
        int value4 = DataCanbus.DATA[188];
        int value5 = DataCanbus.DATA[189];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value) + ":" + value1 + ":" + value2 + " / " + value3 + ":" + value4 + ":" + value5);
    }
}
