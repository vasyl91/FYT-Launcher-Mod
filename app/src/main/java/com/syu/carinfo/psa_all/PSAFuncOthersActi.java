package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PSAFuncOthersActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    PSAFuncOthersActi.this.mUpdaterValue58();
                    break;
                case 170:
                    PSAFuncOthersActi.this.mUpdaterValue59();
                    break;
                case 171:
                    PSAFuncOthersActi.this.mUpdaterValue57();
                    break;
                case 172:
                    PSAFuncOthersActi.this.mUpdaterValue56();
                    break;
                case 242:
                    if (((TextView) PSAFuncOthersActi.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) PSAFuncOthersActi.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_func_others);
        registerListener();
    }

    public void registerListener() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172] - 1;
                if (value < 1) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(46, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[172] + 1;
                if (value > 3) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(46, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] - 1;
                if (value < 1) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(45, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[171] + 1;
                if (value > 2) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(45, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[242];
                DataCanbus.PROXY.cmd(89, new int[]{value - 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[242];
                DataCanbus.PROXY.cmd(89, new int[]{value + 1}, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue56() {
        int value = DataCanbus.DATA[172];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText("km/l");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText("mpg(us)");
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("l/100km");
            }
        }
    }

    
    public void mUpdaterValue57() {
        int value = DataCanbus.DATA[171];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_tem_settings_value_2);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_psa_all_tem_settings_value_1);
            }
        }
    }

    
    public void mUpdaterValue58() {
        int value = DataCanbus.DATA[169];
        if (findViewById(R.id.layout_view1) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            } else {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
        }
    }

    
    public void mUpdaterValue59() {
        int value = DataCanbus.DATA[170];
        if (findViewById(R.id.layout_view2) != null) {
            if (value == 1) {
                findViewById(R.id.layout_view2).setVisibility(0);
            } else {
                findViewById(R.id.layout_view2).setVisibility(8);
            }
        }
    }
}
