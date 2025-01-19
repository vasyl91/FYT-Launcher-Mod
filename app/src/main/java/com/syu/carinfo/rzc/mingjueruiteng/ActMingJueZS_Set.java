package com.syu.carinfo.rzc.mingjueruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActMingJueZS_Set extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    ActMingJueZS_Set.this.uSteerFeel(DataCanbus.DATA[updateCode]);
                    break;
                case 115:
                    ActMingJueZS_Set.this.uSearchCar(DataCanbus.DATA[updateCode]);
                    break;
                case 116:
                    ActMingJueZS_Set.this.uComeHome(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private View.OnClickListener mClick = new View.OnClickListener() { 
        @Override
        public void onClick(View v) {
            int val;
            switch (v.getId()) {
                case R.id.mingjue_steerfeel_m /* 2131432716 */:
                    int val2 = DataCanbus.DATA[114] & 15;
                    if (val2 == 0) {
                        val = 2;
                    } else {
                        val = val2 - 1;
                    }
                    ActMingJueZS_Set.this.sendCmd(3, val);
                    break;
                case R.id.mingjue_steerfeel_p /* 2131432718 */:
                    ActMingJueZS_Set.this.sendCmd(3, ((DataCanbus.DATA[114] & 15) + 1) % 3);
                    break;
                case R.id.mingjue_searchcar_indicator /* 2131432720 */:
                    ActMingJueZS_Set.this.sendCmd(2, (DataCanbus.DATA[115] & 15) != 1 ? 1 : 0);
                    break;
                case R.id.mingjue_comehomewithme /* 2131432723 */:
                    ActMingJueZS_Set.this.sendCmd(1, (DataCanbus.DATA[116] & 15) != 1 ? 1 : 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_mingjuezs_set);
        init();
    }

    @Override
    public void init() {
        setClick((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator));
        setClick((CheckedTextView) findViewById(R.id.mingjue_comehomewithme));
        setClick((Button) findViewById(R.id.mingjue_steerfeel_m));
        setClick((Button) findViewById(R.id.mingjue_steerfeel_p));
    }

    @Override
    public void setClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    
    public void sendCmd(int cmd, int para) {
        DataCanbus.PROXY.cmd(3, new int[]{3, cmd, para}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    protected void uSteerFeel(int i) {
        int val = i & 3;
        if (((TextView) findViewById(R.id.mingjue_steerfeel_txt)) != null) {
            int resId = R.string.rzc_klc_nomal;
            if (val == 1) {
                resId = R.string.str_driving_comfort;
            } else if (val == 2) {
                resId = R.string.str_driving_sport;
            }
            ((TextView) findViewById(R.id.mingjue_steerfeel_txt)).setText(resId);
        }
    }

    protected void uComeHome(int i) {
        int val = i & 3;
        if (((CheckedTextView) findViewById(R.id.mingjue_comehomewithme)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_comehomewithme)).setChecked(val == 1);
        }
    }

    protected void uSearchCar(int i) {
        int val = i & 3;
        if (((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator)) != null) {
            ((CheckedTextView) findViewById(R.id.mingjue_searchcar_indicator)).setChecked(val == 1);
            if (((TextView) findViewById(R.id.mingjue_searchcar_indicator_txt)) != null) {
                int resId = R.string.klc_remote_Remote_control_latch_only_light;
                if (val == 1) {
                    resId = R.string.klc_remote_Remote_control_latch_light_Speaker;
                }
                ((TextView) findViewById(R.id.mingjue_searchcar_indicator_txt)).setText(resId);
            }
        }
    }
}
