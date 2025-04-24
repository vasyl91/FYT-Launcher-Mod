package com.syu.carinfo.jili;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 153, 154, 155, 156, 157};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_langset), value == 1);
                    if (((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_langset_txt)) != null) {
                        ((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_langset_txt)).setText(value == 1 ? R.string.jeep_language_set0 : R.string.jeep_language_set1);
                        break;
                    }
                case 123:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_lockautoclosewindow), value == 1);
                    break;
                case 124:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_lock_turnoff_positionstate), value == 1);
                    break;
                case 125:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_shutdown_unlock), value == 1);
                    break;
                case 126:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_remotelock_recall), value == 1);
                    if (((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_remotelock_recall_txt)) != null) {
                        ((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_remotelock_recall_txt)).setText(value == 1 ? R.string.str_boyue_str13 : R.string.str_boyue_str14);
                        break;
                    }
                case 127:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_elec_assistmode), value == 1);
                    if (((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_elec_assistmode_txt)) != null) {
                        ((TextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_elec_assistmode_txt)).setText(value == 1 ? R.string.str_driving_sport : R.string.str_driving_comfort);
                        break;
                    }
                case 128:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_static_railline), value == 1);
                    break;
                case 129:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_dynamic_railline), value == 1);
                    break;
                case 130:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_fisheye), value == 1);
                    break;
                case 131:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_rmode_5sdelay), value == 1);
                    break;
                case 132:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_singlebackcar_video), value == 1);
                    break;
                case 133:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_turnbymove), value == 1);
                    break;
                case 134:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.boyue_all_open), value == 1);
                    break;
                case 153:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.bnr_boyue_intelligent_light), value == 1);
                    break;
                case 154:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.bnr_boyue_active_yaw), value == 1);
                    break;
                case 155:
                    BoyueCarSettingsAct.this.updaterAlarmDistance(value);
                    break;
                case 156:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.bnr_boyue_auto_brak), value == 1);
                    break;
                case 157:
                    BoyueCarSettingsAct.this.setCheckView((CheckedTextView) BoyueCarSettingsAct.this.findViewById(R.id.bnr_boyue_warning), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_265_rzc_boyue);
        init();
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.bnr_boyue_alarm_distance_pre), this);
        setSelfClick((Button) findViewById(R.id.bnr_boyue_alarm_distance_next), this);
        if (DataCanbus.DATA[1000] == 459017 || DataCanbus.DATA[1000] == 786697) {
            setViewVisible(findViewById(R.id.bnr_boyue_intelligent_light_view), true);
            setViewVisible(findViewById(R.id.bnr_boyue_active_yaw_view), true);
            setViewVisible(findViewById(R.id.bnr_boyue_alarm_distance_view), true);
            setViewVisible(findViewById(R.id.bnr_boyue_auto_brak_view), true);
            setViewVisible(findViewById(R.id.bnr_boyue_warning_view), true);
        }
        sendClick((CheckedTextView) findViewById(R.id.boyue_langset), 0, 122);
        sendClick((CheckedTextView) findViewById(R.id.boyue_remotelock_recall), 4, 126);
        sendClick((CheckedTextView) findViewById(R.id.boyue_lockautoclosewindow), 1, 123);
        sendClick((CheckedTextView) findViewById(R.id.boyue_lock_turnoff_positionstate), 2, 124);
        sendClick((CheckedTextView) findViewById(R.id.boyue_shutdown_unlock), 3, 125);
        sendClick((CheckedTextView) findViewById(R.id.boyue_elec_assistmode), 5, 127);
        sendClick((CheckedTextView) findViewById(R.id.boyue_static_railline), 6, 128);
        sendClick((CheckedTextView) findViewById(R.id.boyue_dynamic_railline), 7, 129);
        sendClick((CheckedTextView) findViewById(R.id.boyue_fisheye), 8, 130);
        sendClick((CheckedTextView) findViewById(R.id.boyue_rmode_5sdelay), 9, 131);
        sendClick((CheckedTextView) findViewById(R.id.boyue_singlebackcar_video), 10, 132);
        sendClick((CheckedTextView) findViewById(R.id.boyue_turnbymove), 11, 133);
        sendClick((CheckedTextView) findViewById(R.id.boyue_all_open), 12, 134);
        sendClick((CheckedTextView) findViewById(R.id.bnr_boyue_intelligent_light), 16, 153);
        sendClick((CheckedTextView) findViewById(R.id.bnr_boyue_active_yaw), 17, 154);
        sendClick((CheckedTextView) findViewById(R.id.bnr_boyue_auto_brak), 14, 156);
        sendClick((CheckedTextView) findViewById(R.id.bnr_boyue_warning), 15, 157);
    }

    
    public void updaterAlarmDistance(int value) {
        if (((TextView) findViewById(R.id.bnr_boyue_alarm_distance_TV)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.bnr_boyue_alarm_distance_TV)).setText(R.string.jeep_forwardcollisionwarn_0);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.bnr_boyue_alarm_distance_TV)).setText(R.string.jeep_lanesensewarn_1);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.bnr_boyue_alarm_distance_TV)).setText(R.string.jeep_forwardcollisionwarn_1);
            }
        }
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    BoyueCarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    
    public void sendCmd(int cmd, int value) {
        Log.i("LG", "send cmd:" + Integer.toHexString(cmd));
        DataCanbus.PROXY.cmd(1, new int[]{cmd, value}, null, null);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        int mAlarm = DataCanbus.DATA[155];
        switch (id) {
            case R.id.bnr_boyue_alarm_distance_pre /* 2131428991 */:
                if (mAlarm == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{18, 2}, null, null);
                    break;
                } else if (mAlarm == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{18}, null, null);
                    break;
                } else if (mAlarm == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{18, 1}, null, null);
                    break;
                }
            case R.id.bnr_boyue_alarm_distance_next /* 2131428993 */:
                if (mAlarm == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{18, 1}, null, null);
                    break;
                } else if (mAlarm == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{18, 2}, null, null);
                    break;
                } else if (mAlarm == 2) {
                    DataCanbus.PROXY.cmd(1, new int[]{18}, null, null);
                    break;
                }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
