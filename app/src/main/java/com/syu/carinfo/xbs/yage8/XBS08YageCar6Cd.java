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
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XBS08YageCar6Cd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XBS08YageCar6Cd mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                case 100:
                    XBS08YageCar6Cd.this.updatecdTime();
                    break;
                case 101:
                    XBS08YageCar6Cd.this.updatecdTrack();
                    break;
                case 102:
                    XBS08YageCar6Cd.this.mUpdateCdRpt();
                    break;
                case 106:
                    XBS08YageCar6Cd.this.mUpdateCd1State();
                    break;
                case 107:
                    XBS08YageCar6Cd.this.mUpdateCd2State();
                    break;
                case 108:
                    XBS08YageCar6Cd.this.mUpdateCd3State();
                    break;
                case 109:
                    XBS08YageCar6Cd.this.mUpdateCd4State();
                    break;
                case 110:
                    XBS08YageCar6Cd.this.mUpdateCd5State();
                    break;
                case 111:
                    XBS08YageCar6Cd.this.mUpdateCd6State();
                    break;
                case 113:
                    XBS08YageCar6Cd.this.updateDiscNum(value);
                    break;
            }
        }
    };
    int cmdId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xbs_yage8_carcd);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[106];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[107];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[108];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[109];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[110];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[111];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate10);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate2);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate3);
                break;
        }
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[102];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
        findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_n);
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_n);
        switch (On) {
            case 1:
            case 6:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt1_n);
                break;
            case 2:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rptall_n);
                break;
            case 3:
            case 7:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_random_p);
                break;
            case 4:
            case 5:
            case 8:
                findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_p);
                break;
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[101];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d", Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[100];
        int value1 = DataCanbus.DATA[99];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d", Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-65536);
                break;
        }
    }

    public void init() {
        ((Button) findViewById(R.id.cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.cd_next)).setOnTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(1, 1);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
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
}
