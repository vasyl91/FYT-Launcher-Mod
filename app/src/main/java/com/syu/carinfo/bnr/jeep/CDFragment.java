package com.syu.carinfo.bnr.jeep;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class CDFragment extends BaseFragment implements View.OnClickListener {
    int currentindex;
    String currenttime;
    private int cycle;
    int[] ids = {180, 181, 182, 183, 184, 185};
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            CDFragment.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 180:
                    CDFragment.this.uCDState(CDFragment.this.value);
                    break;
                case 181:
                    CDFragment.this.uCDPlayMode(CDFragment.this.value);
                    break;
                case 182:
                    CDFragment.this.uCDCurrentIndex(CDFragment.this.value);
                    break;
                case 183:
                    CDFragment.this.uCDPlayTime(CDFragment.this.value);
                    break;
                case 184:
                    CDFragment.this.uCDPlayTotalTime(CDFragment.this.value);
                    break;
                case 185:
                    CDFragment.this.uCDTotalIndex(CDFragment.this.value);
                    break;
            }
        }
    };
    private int random;
    int totalindex;
    String totaltime;
    private int value;

    @Override
    public void initView() {
        bindViewOnClick(R.id.jeep_btn_prev, this);
        bindViewOnClick(R.id.jeep_btn_play, this);
        bindViewOnClick(R.id.jeep_btn_pause, this);
        bindViewOnClick(R.id.jeep_btn_next, this);
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_0117_bnr_ziyouguang_cd;
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    void setcmd(int cmd) {
        DataCanbus.PROXY.cmd(2, new int[]{cmd}, null, null);
    }

    protected void uCDState(int val) {
        int resid = R.string.jeep_playstate1;
        switch (val) {
            case 1:
                resid = R.string.jeep_playstate3;
                break;
            case 2:
                resid = R.string.jeep_playstate4;
                break;
            case 3:
                resid = R.string.jeep_playstate2;
                break;
            case 4:
                resid = R.string.jeep_playstate6;
                break;
            case 5:
                resid = R.string.jeep_playstate5;
                break;
            case 6:
                resid = R.string.jeep_playstate9;
                break;
        }
        setText((TextView) findView(R.id.file_num_tv), resid);
    }

    protected void uCDPlayTotalTime(int val) {
        this.currenttime = String.format("%02d:%02d:%02d", Integer.valueOf(val & 255), Integer.valueOf((val >> 8) & 255), Integer.valueOf((val >> 16) & 255));
        setText((TextView) findView(R.id.time_tv), String.valueOf(this.currenttime) + "/" + this.totaltime);
    }

    protected void uCDPlayTime(int val) {
        this.totaltime = String.format("%02d:%02d:%02d", Integer.valueOf(val & 255), Integer.valueOf((val >> 8) & 255), Integer.valueOf((val >> 16) & 255));
        setText((TextView) findView(R.id.time_tv), String.valueOf(this.currenttime) + "/" + this.totaltime);
    }

    protected void uCDCurrentIndex(int val) {
        this.currentindex = val;
        setText((TextView) findView(R.id.track_num_tv), String.valueOf(this.currentindex) + "/" + this.totalindex);
    }

    protected void uCDTotalIndex(int val) {
        this.totalindex = val;
        setText((TextView) findView(R.id.track_num_tv), String.valueOf(this.currentindex) + "/" + this.totalindex);
    }

    protected void uCDPlayMode(int val) {
        this.cycle = val & 1;
        this.random = (val >> 1) & 1;
        setText((TextView) bindViewOnClick(R.id.jeep_cycle_info, this), this.cycle == 1 ? R.string.jeep_loop_on : R.string.jeep_loop_off);
        setText((TextView) bindViewOnClick(R.id.jeep_random_info, this), this.random == 1 ? R.string.jeep_random_on : R.string.jeep_random_off);
    }

    void setText(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    void setText(TextView v, int id) {
        if (v != null) {
            v.setText(id);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jeep_cycle_info /* 2131427582 */:
                setcmd(this.cycle == 0 ? 14 : 15);
                break;
            case R.id.jeep_random_info /* 2131427583 */:
                setcmd(this.random == 0 ? 9 : 10);
                break;
            case R.id.jeep_btn_prev /* 2131427584 */:
                setcmd(3);
                break;
            case R.id.jeep_btn_play /* 2131427585 */:
                setcmd(2);
                break;
            case R.id.jeep_btn_pause /* 2131427586 */:
                setcmd(1);
                break;
            case R.id.jeep_btn_next /* 2131427587 */:
                setcmd(4);
                break;
        }
    }
}
