package com.syu.carinfo.psa_all;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0244_RZC_XP1_HavalH2;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PSA407CarSingleCD extends Activity implements View.OnTouchListener {
    public static PSA407CarSingleCD mInstance;
    public static boolean mIsFront = false;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    PSA407CarSingleCD.this.mUpdaterCdRepeat(value);
                    PSA407CarSingleCD.this.mUpdaterCdRandom(value);
                    break;
                case 148:
                    PSA407CarSingleCD.this.mUpdaterCdState(value);
                    break;
                case 149:
                case 150:
                    PSA407CarSingleCD.this.mUpdaterCdTrack();
                    break;
                case 151:
                case 152:
                    PSA407CarSingleCD.this.mUpdaterCdTime();
                    break;
                case 153:
                    ((TextView) PSA407CarSingleCD.this.findViewById(R.id.cd_title)).setText(Callback_0244_RZC_XP1_HavalH2.Title);
                    break;
                case 154:
                    ((TextView) PSA407CarSingleCD.this.findViewById(R.id.cd_album)).setText(Callback_0244_RZC_XP1_HavalH2.Album);
                    break;
                case 155:
                    ((TextView) PSA407CarSingleCD.this.findViewById(R.id.cd_artist)).setText(Callback_0244_RZC_XP1_HavalH2.Artist);
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

    private void setCdControl(int cmdId) {
        DataCanbus.PROXY.cmd(7, new int[]{cmdId}, null, null);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_repeat /* 2131427916 */:
                this.cmdId = 17;
                break;
            case R.id.cd_ramdom /* 2131427917 */:
                this.cmdId = 8;
                break;
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 2;
                break;
            case R.id.cd_fb /* 2131427919 */:
                this.cmdId = 3;
                break;
            case R.id.cd_play /* 2131427920 */:
                this.cmdId = 19;
                break;
            case R.id.cd_pause /* 2131427921 */:
                this.cmdId = 20;
                break;
            case R.id.cd_ff /* 2131427922 */:
                this.cmdId = 4;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 1;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(this.cmdId);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdRandom(int value) {
        ((Button) findViewById(R.id.cd_ramdom)).setSelected(value == 1);
    }

    
    public void mUpdaterCdRepeat(int value) {
        ((Button) findViewById(R.id.cd_repeat)).setSelected(value == 2);
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate3);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate5);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate6);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate7);
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate8);
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate9);
                break;
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[150];
        int value1 = DataCanbus.DATA[149];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + " / " + value1);
    }

    
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[152] / 3600;
        int value1 = (DataCanbus.DATA[152] % 3600) / 60;
        int value2 = DataCanbus.DATA[152] % 60;
        int value3 = DataCanbus.DATA[151] / 3600;
        int value4 = (DataCanbus.DATA[151] % 3600) / 60;
        int value5 = DataCanbus.DATA[151] % 60;
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value) + ":" + value1 + ":" + value2 + " / " + value3 + ":" + value4 + ":" + value5);
    }
}
