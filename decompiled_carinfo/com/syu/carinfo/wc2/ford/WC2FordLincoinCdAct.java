package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0443_WC2_Ford_Lincoin_All;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinCdAct extends BaseActivity implements View.OnTouchListener {
    public static WC2FordLincoinCdAct mInstance;
    public static boolean mIsFront = false;
    int value;
    boolean bNeedSend = false;
    int cmdId = -1;
    int touchState = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 149:
                    WC2FordLincoinCdAct.this.mUpdaterCdState(value);
                    break;
                case 150:
                    WC2FordLincoinCdAct.this.mUpdaterCdRepeat(value);
                    break;
                case 151:
                    WC2FordLincoinCdAct.this.mUpdaterCdRandom(value);
                    break;
                case 152:
                case 153:
                    WC2FordLincoinCdAct.this.mUpdaterCdTime();
                    break;
                case 154:
                case 155:
                    WC2FordLincoinCdAct.this.mUpdaterCdTrack();
                    break;
                case 156:
                    ((TextView) WC2FordLincoinCdAct.this.findViewById(R.id.cd_title)).setText(Callback_0443_WC2_Ford_Lincoin_All.Title);
                    break;
                case 157:
                    ((TextView) WC2FordLincoinCdAct.this.findViewById(R.id.cd_artist)).setText(Callback_0443_WC2_Ford_Lincoin_All.Artist);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_ford_lincoin_cd_act);
        mInstance = this;
        ((Button) findViewById(R.id.cd_repeat)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ramdom)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_fb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_play)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_pause)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_ff)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
        findViewById(R.id.cd_album).setVisibility(8);
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
        DataCanbus.PROXY.cmd(2, cmdId, touchState);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_repeat /* 2131427916 */:
                this.cmdId = 3;
                this.value = DataCanbus.DATA[150] == 1 ? 0 : 1;
                break;
            case R.id.cd_ramdom /* 2131427917 */:
                this.cmdId = 5;
                this.value = DataCanbus.DATA[151] == 1 ? 0 : 1;
                break;
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 7;
                this.value = 1;
                break;
            case R.id.cd_fb /* 2131427919 */:
                this.cmdId = 8;
                this.value = 1;
                break;
            case R.id.cd_play /* 2131427920 */:
                this.cmdId = 1;
                this.value = 0;
                break;
            case R.id.cd_pause /* 2131427921 */:
                this.cmdId = 2;
                this.value = 0;
                break;
            case R.id.cd_ff /* 2131427922 */:
                this.cmdId = 8;
                this.value = 0;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 7;
                this.value = 0;
                break;
        }
        switch (event.getAction()) {
            case 0:
                setCdControl(this.cmdId, this.value);
                break;
        }
        if (this.cmdId == -1 || this.touchState == -1) {
        }
        return false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
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
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate10);
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
            case 7:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate11);
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
        int value = DataCanbus.DATA[154];
        int value1 = DataCanbus.DATA[155];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + value + " / " + value1);
    }

    
    public void mUpdaterCdTime() {
        int value = DataCanbus.DATA[152];
        int value3 = DataCanbus.DATA[153];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value) + " / " + value3);
    }
}
