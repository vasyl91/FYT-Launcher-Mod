package com.syu.carinfo.jili;

import android.os.Bundle;
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
public class LZJiliBoyueCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {98, 99, 100, 101, 102, 103, 104, 105, 106};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(value == 1 ? R.string.str_driving_sport : R.string.wc_golf_comfort);
                        break;
                    }
                case 99:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 102:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 103:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 104:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 105:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 106:
                    LZJiliBoyueCarSettingsAct.this.setCheckView((CheckedTextView) LZJiliBoyueCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_453_lz_jili_boyue);
        init();
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(1, new int[]{50}, null, null);
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
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 1, 99);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 2, 100);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 12, 101);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 7, 102);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 8, 103);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 9, 104);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 10, 105);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 11, 106);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    LZJiliBoyueCarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
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
        DataCanbus.PROXY.cmd(0, new int[]{cmd, value}, null, null);
    }

    @Override
    public void onClick(View v) {
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
