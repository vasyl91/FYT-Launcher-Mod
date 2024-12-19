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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XBS08YageCarCDAct extends Activity implements View.OnTouchListener {
    public static XBS08YageCarCDAct mInstance;
    public static boolean mIsFront = false;
    int cmdId = -1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.yage8.XBS08YageCarCDAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                case 20:
                    XBS08YageCarCDAct.this.mUpdaterCdTime();
                    break;
                case 21:
                    XBS08YageCarCDAct.this.mUpdaterCdTrack();
                    break;
                case 22:
                    XBS08YageCarCDAct.this.mUpdaterCdRepeatState(value);
                    break;
                case 23:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_title)).setText(Callback_0439_XBS_08Yage.Title);
                    break;
                case 24:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_album)).setText(Callback_0439_XBS_08Yage.Album);
                    break;
                case 25:
                    ((TextView) XBS08YageCarCDAct.this.findViewById(R.id.cd_artist)).setText(Callback_0439_XBS_08Yage.Artist);
                    break;
                case 34:
                    XBS08YageCarCDAct.this.mUpdaterCdState(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xbs_yage8_carcd);
        mInstance = this;
        init();
    }

    private void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    private void setCdControl(int cmdId, int touchState) {
        DataCanbus.PROXY.cmd(0, cmdId, touchState);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.cd_prev /* 2131427915 */:
                this.cmdId = 3;
                break;
            case R.id.cd_next /* 2131427920 */:
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
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTrack() {
        int value = DataCanbus.DATA[21];
        ((TextView) findViewById(R.id.huiteng_cd_track)).setText("Track: " + (value / 16) + (value % 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdTime() {
        int value1 = DataCanbus.DATA[19];
        int value2 = DataCanbus.DATA[20];
        ((TextView) findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(value1 / 16) + (value1 % 16) + ":" + (value2 / 16) + (value2 % 16));
    }
}
