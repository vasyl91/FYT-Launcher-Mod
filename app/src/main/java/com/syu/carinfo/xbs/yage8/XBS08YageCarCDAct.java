package com.syu.carinfo.xbs.yage8;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_XBS_08Yage;
import com.syu.module.canbus.DataCanbus;

public class XBS08YageCarCDAct extends Activity implements View.OnTouchListener {
    public static XBS08YageCarCDAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                case 100:
                    XBS08YageCarCDAct.this.mUpdaterCdTime();
                    break;
                case 101:
                    XBS08YageCarCDAct.this.mUpdaterCdTrack();
                    break;
                case 102:
                    XBS08YageCarCDAct.this.mUpdaterCdRepeatState(value);
                    break;
                case 103:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_title)).setText(Callback_0439_XBS_08Yage.Title);
                    break;
                case 104:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_album)).setText(Callback_0439_XBS_08Yage.Album);
                    break;
                case 105:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_artist)).setText(Callback_0439_XBS_08Yage.Artist);
                    break;
                case 114:
                    XBS08YageCarCDAct.this.mUpdaterCdState(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_xbs_yage8_carcd);
        mInstance = this;
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, 1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_prev /* 2131427918 */:
                this.cmdId = 3;
                break;
            case R.id.cd_next /* 2131427923 */:
                this.cmdId = 4;
                break;
        }
        if (this.cmdId != -1) {
            switch (event.getAction()) {
                case 0:
                    setCdControl(this.cmdId, 1);
                    break;
                case 1:
                    setCdControl(this.cmdId, 0);
                    break;
            }
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterCdRepeatState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode1);
                break;
            case 1:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.str_388_rep_one);
                break;
            case 2:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.str_388_all_disc_rep);
                break;
            case 3:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.xp_380_playmode4);
                break;
            case 4:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.str_sbd_x80_scan);
                break;
            case 5:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.str_420_disc_scan);
                break;
            case 6:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.crv_playstate_2);
                break;
            case 7:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.crv_playstate_3);
                break;
            case 8:
                ((TextView) findViewById(R.id.huiteng_cd_repeat)).setText(R.string.crv_state_ScanFld);
                break;
        }
    }

    
    public void mUpdaterCdState(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate2);
                break;
            case 1:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_sbd_x80_media_state_10);
                break;
            case 3:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate3);
                break;
            case 4:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate4);
                break;
            case 5:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate5);
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_car_cd_ff);
                break;
            case 7:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.str_car_cd_fb);
                break;
            case 8:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate9);
                break;
            case 9:
                ((TextView) findViewById(R.id.cd_state)).setText("No Data");
                break;
            case 10:
                ((TextView) findViewById(R.id.cd_state)).setText("No Song");
                break;
            case 12:
                ((TextView) findViewById(R.id.cd_state)).setText(R.string.jeep_playstate11);
                break;
        }
    }

    
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[101];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + (value / 16) + (value % 16));
    }

    
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[99];
        int value2 = DataCanbus.DATA[100];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1 / 16) + (value1 % 16) + ":" + (value2 / 16) + (value2 % 16));
    }
}
