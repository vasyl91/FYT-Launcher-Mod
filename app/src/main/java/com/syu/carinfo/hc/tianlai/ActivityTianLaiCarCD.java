package com.syu.carinfo.hc.tianlai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityTianLaiCarCD extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    ActivityTianLaiCarCD.this.updateDiscId(value);
                    break;
                case 101:
                    ActivityTianLaiCarCD.this.updateDiscTrack(value);
                    break;
                case 102:
                    ActivityTianLaiCarCD.this.updatePlayTime(value);
                    break;
                case 103:
                    ActivityTianLaiCarCD.this.updateWorkState(value);
                    break;
                case 104:
                    ActivityTianLaiCarCD.this.updateRepeateState(value);
                    break;
                case 105:
                    ActivityTianLaiCarCD.this.updateRandomState(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_327_hc_tianlai_carcd);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
        findViewById(R.id.btn_plus5).setOnClickListener(this);
        findViewById(R.id.btn_plus6).setOnClickListener(this);
        findViewById(R.id.btn_plus7).setOnClickListener(this);
        findViewById(R.id.btn_plus8).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        setCmdKey(9);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                setCmdKey(1);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCmdKey(4);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCmdKey(2);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCmdKey(5);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCmdKey(6);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCmdKey(3);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCmdKey(8);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCmdKey(7);
                break;
        }
    }

    private void setCmdKey(int cmd) {
        DataCanbus.PROXY.cmd(0, cmd);
    }

    protected void updateDiscId(int value) {
        if (findViewById(R.id.tv_text1) != null) {
            if (value > 0 && value < 6) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value));
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("--");
            }
        }
    }

    protected void updateDiscTrack(int value) {
        if (findViewById(R.id.tv_text2) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value));
        }
    }

    protected void updatePlayTime(int value) {
        if (findViewById(R.id.tv_text3) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.format("%02d:%02d", Integer.valueOf(value / 60), Integer.valueOf(value % 60)));
        }
    }

    protected void updateWorkState(int value) {
        if (findViewById(R.id.tv_text4) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.crv_state_stop);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.crv_state_play);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_media_state_10);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_327_change_disc);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_327_change_music);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_car_cd_fb);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_car_cd_ff);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_car_cd_eject);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_car_cd_work_state_2);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_327_insert_disc);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_327_wait_disc);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("--");
                    break;
            }
        }
    }

    protected void updateRepeateState(int value) {
        if (findViewById(R.id.tv_text5) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_327_one_disc_rep);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_car_cd_repeattrack);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_327_all_disc_rep);
                    break;
            }
        }
    }

    protected void updateRandomState(int value) {
        if (findViewById(R.id.tv_text6) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_327_all_disc_random);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_327_one_disc_random);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.jeep_random_off);
                    break;
            }
        }
    }
}
