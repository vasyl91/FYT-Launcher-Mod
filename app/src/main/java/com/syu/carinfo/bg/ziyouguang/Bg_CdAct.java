package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0371_BG_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

public class Bg_CdAct extends BaseActivity implements View.OnClickListener {
    int playModeValue;
    int play_state;
    int totalTrackValue;
    int workStateValue;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 129:
                    Bg_CdAct.this.updaterCdTextInfo();
                    break;
                case 130:
                    Bg_CdAct.this.updaterPlayMode();
                    break;
                case 131:
                    Bg_CdAct.this.updaterWorkState();
                    break;
                case 132:
                    Bg_CdAct.this.updaterTrack();
                    break;
                case 133:
                    Bg_CdAct.this.updaterAllTime();
                    break;
                case 134:
                    Bg_CdAct.this.updaterCurTime();
                    break;
            }
        }
    };
    Toast toast = null;
    TextView view = null;

    public static void CD_CONRTROL_CMD(int val1, int val2) {
        DataCanbus.PROXY.cmd(4, new int[]{val1, val2}, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_371_bagoo_ziyouguang_cd11);
        init();
        setUI();
    }

    @Override
    public void init() {
        ((ListView) findViewById(R.id.bagoo_ziyouguang_cd_list_view)).setAdapter(new com.syu.carinfo.wc.ziyouguang.FileAdapter(this, new ArrayList()));
        ((ListView) findViewById(R.id.bagoo_ziyouguang_cd_list_view)).setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Bg_CdAct.CD_CONRTROL_CMD(15, position + 1);
            }
        });
        setUI();
    }

    public void setUI() {
        findViewById(R.id.bagoo_ziyouguang_cd_prev).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_next).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_ff).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_fb).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_repeat).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_repeat_random).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_play).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_pause).setOnClickListener(this);
        findViewById(R.id.bagoo_ziyouguang_cd_list_btn).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterPlayMode() {
        int playModeValue = DataCanbus.DATA[130];
        if (playModeValue == 0) {
            tips(getResources().getString(R.string.str_car_cd_putong_mode));
        } else if (playModeValue == 1) {
            tips(getResources().getString(R.string.str_car_cd_random_mode));
        } else if (playModeValue == 2) {
            tips(getResources().getString(R.string.str_car_cd_cycle_mode));
        }
    }

    
    public void updaterWorkState() {
        int workStateValue = DataCanbus.DATA[131];
        if (workStateValue == 0) {
            tips(getResources().getString(R.string.str_car_cd_work_state_0));
            return;
        }
        if (workStateValue == 1) {
            tips(getResources().getString(R.string.str_car_cd_work_state_1));
            return;
        }
        if (workStateValue == 2) {
            tips(getResources().getString(R.string.str_car_cd_work_state_2));
            return;
        }
        if (workStateValue == 3) {
            tips(getResources().getString(R.string.str_car_cd_work_state_3));
            this.play_state = 1;
            return;
        }
        if (workStateValue == 4) {
            tips(getResources().getString(R.string.str_car_cd_work_state_4));
            return;
        }
        if (workStateValue == 5) {
            tips(getResources().getString(R.string.str_car_cd_work_state_5));
            if (this.play_state == 1) {
                CD_CONRTROL_CMD(19, 0);
                this.play_state = 0;
                return;
            }
            return;
        }
        if (workStateValue == 6) {
            tips(getResources().getString(R.string.str_car_cd_work_state_6));
        } else if (workStateValue == 8) {
            tips(getResources().getString(R.string.str_car_cd_work_state_8));
        } else if (workStateValue == 9) {
            tips(getResources().getString(R.string.str_car_cd_work_state_9));
        }
    }

    
    public void updaterTrack() {
        int value = DataCanbus.DATA[132];
        int curTrack = (value >> 16) & 65535;
        int temp = value & 65535;
        if (this.totalTrackValue != temp) {
            for (int i = 0; i < this.totalTrackValue; i++) {
                new ArrayList().clear();
                new com.syu.carinfo.wc.ziyouguang.FileAdapter(this, new ArrayList()).notifyDataSetChanged();
            }
            this.totalTrackValue = temp;
            for (int i2 = 0; i2 < this.totalTrackValue; i2++) {
                com.syu.carinfo.wc.ziyouguang.CDInfo info = new com.syu.carinfo.wc.ziyouguang.CDInfo(i2, "Track " + (i2 + 1));
                new ArrayList().add(i2, info);
                new com.syu.carinfo.wc.ziyouguang.FileAdapter(this, new ArrayList()).notifyDataSetChanged();
            }
        }
        ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_track)).setText(curTrack + "/" + this.totalTrackValue);
    }

    
    public void updaterAllTime() {
        int alltime = DataCanbus.DATA[133];
        ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_all_time)).setText(alltime / 3600 + ":" + ((alltime % 3600) / 60) + ":" + ((alltime % 3600) % 60));
    }

    
    public void updaterCurTime() {
        if (findViewById(R.id.bagoo_ziyouguang_cd_cur_time) != null) {
            ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_cur_time)).setText(Callback_0371_BG_XP1_ZiYouGuang.current_playtime);
        }
    }

    
    public void updaterCdTextInfo() {
        int infoType = Callback_0371_BG_XP1_ZiYouGuang.infoType;
        int infoIndex = Callback_0371_BG_XP1_ZiYouGuang.infoIndex;
        String strInfo = "";
        if (Callback_0371_BG_XP1_ZiYouGuang.Songname != null) {
            strInfo = Callback_0371_BG_XP1_ZiYouGuang.Songname;
        }
        switch (infoType) {
            case 1:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_title)).setText(strInfo);
                break;
            case 2:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_album)).setText(strInfo);
                break;
            case 3:
                ((TextView) findViewById(R.id.bagoo_ziyouguang_cd_artist)).setText(strInfo);
                break;
            case 128:
                handlerList(infoIndex, strInfo);
                break;
        }
    }

    private void handlerList(int index, String str) {
        if (index < this.totalTrackValue) {
            com.syu.carinfo.wc.ziyouguang.CDInfo cdInfo = new com.syu.carinfo.wc.ziyouguang.CDInfo(index, str);
            new ArrayList().set(index, cdInfo);
            new com.syu.carinfo.wc.ziyouguang.FileAdapter(this, new ArrayList()).notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bagoo_ziyouguang_cd_prev /* 2131429401 */:
                CD_CONRTROL_CMD(2, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_fb /* 2131429402 */:
                CD_CONRTROL_CMD(3, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_repeat /* 2131429403 */:
                CD_CONRTROL_CMD(8, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_repeat_random /* 2131429404 */:
                CD_CONRTROL_CMD(17, 0);
                break;
            case R.id.bagoo_ziyouguang_play /* 2131429405 */:
                CD_CONRTROL_CMD(19, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_pause /* 2131429406 */:
                CD_CONRTROL_CMD(20, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_ff /* 2131429407 */:
                CD_CONRTROL_CMD(4, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_next /* 2131429408 */:
                CD_CONRTROL_CMD(1, 0);
                break;
            case R.id.bagoo_ziyouguang_cd_list_btn /* 2131429409 */:
                for (int i = 1; i <= this.totalTrackValue; i++) {
                    CD_CONRTROL_CMD(130, i);
                }
                break;
        }
    }

    public void tips(String str) {
        if (this.toast != null) {
            this.toast.cancel();
            this.toast = null;
        }
        this.toast = new Toast(this);
        this.toast.setGravity(17, 0, 0);
        this.toast.setDuration(0);
        this.view = new TextView(this);
        this.view.setText(str);
        this.view.setGravity(17);
        this.view.setBackgroundResource(R.drawable.toast_bk);
        this.view.setTextSize(30.0f);
        this.toast.setView(this.view);
        this.toast.show();
    }
}
