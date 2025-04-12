package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bg_DaQieNuoJi_Safety extends BaseActivity {
    int[] ids = {135, 136, 137, 138, 139, 140, 141, 154};
    int val = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    Bg_DaQieNuoJi_Safety.this.u1(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 136:
                    Bg_DaQieNuoJi_Safety.this.u2(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 137:
                    Bg_DaQieNuoJi_Safety.this.u3(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 138:
                    Bg_DaQieNuoJi_Safety.this.u4(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 139:
                    Bg_DaQieNuoJi_Safety.this.u5(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 140:
                    Bg_DaQieNuoJi_Safety.this.u6(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 141:
                    Bg_DaQieNuoJi_Safety.this.u7(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 154:
                    Bg_DaQieNuoJi_Safety.this.u8(Bg_DaQieNuoJi_Safety.this.val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_safety);
        init();
    }

    @Override
    public void init() {
        View v = findViewById(R.id.layout_view6);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view7);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view8);
        setGone(v3, true);
        View v4 = findViewById(R.id.layout_view9);
        setGone(v4, true);
        View v5 = findViewById(R.id.layout_view10);
        setGone(v5, true);
        View v6 = findViewById(R.id.layout_view11);
        setGone(v6, true);
        View v7 = findViewById(R.id.layout_view12);
        setGone(v7, true);
        View v8 = findViewById(R.id.layout_view14);
        setGone(v8, true);
        View v9 = findViewById(R.id.layout_view17);
        setGone(v9, true);
        View v10 = findViewById(R.id.layout_view21);
        setGone(v10, true);
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v11) {
                switch (v11.getId()) {
                    case R.id.btn_minus1 /* 2131427455 */:
                    case R.id.btn_plus1 /* 2131427457 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[135];
                        Bg_DaQieNuoJi_Safety.this.setCmd(1, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.btn_minus2 /* 2131427458 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[136] - 1;
                        if (Bg_DaQieNuoJi_Safety.this.val < 0) {
                            Bg_DaQieNuoJi_Safety.this.val = 2;
                        }
                        Bg_DaQieNuoJi_Safety.this.setCmd(2, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[136] + 1;
                        Bg_DaQieNuoJi_Safety.this.val %= 3;
                        Bg_DaQieNuoJi_Safety.this.setCmd(2, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_minus3 /* 2131427461 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[137] - 1;
                        if (Bg_DaQieNuoJi_Safety.this.val < 0) {
                            Bg_DaQieNuoJi_Safety.this.val = 2;
                        }
                        Bg_DaQieNuoJi_Safety.this.setCmd(3, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[137] + 1;
                        Bg_DaQieNuoJi_Safety.this.val %= 3;
                        Bg_DaQieNuoJi_Safety.this.setCmd(3, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[141];
                        Bg_DaQieNuoJi_Safety.this.setCmd(7, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.ctv_checkedtext5 /* 2131427547 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[139];
                        Bg_DaQieNuoJi_Safety.this.setCmd(5, Bg_DaQieNuoJi_Safety.this.val != 0 ? 0 : 1);
                        break;
                    case R.id.ctv_checkedtext7 /* 2131427549 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[140];
                        Bg_DaQieNuoJi_Safety.this.setCmd(6, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.ctv_checkedtext11 /* 2131427553 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[138];
                        Bg_DaQieNuoJi_Safety.this.setCmd(4, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.layout_view20 /* 2131427654 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[154];
                        Bg_DaQieNuoJi_Safety.this.setCmd(49, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                }
            }
        };
        setClick(findViewById(R.id.btn_minus1));
        setClick(findViewById(R.id.btn_plus1));
        setClick(findViewById(R.id.btn_minus2));
        setClick(findViewById(R.id.btn_plus2));
        setClick(findViewById(R.id.btn_minus3));
        setClick(findViewById(R.id.btn_plus3));
        setClick(findViewById(R.id.ctv_checkedtext11));
        setClick(findViewById(R.id.ctv_checkedtext5));
        setClick(findViewById(R.id.ctv_checkedtext7));
        setClick(findViewById(R.id.ctv_checkedtext2));
        setClick(findViewById(R.id.ctv_checkedtext12));
    }

    
    public void setCmd(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setGone(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 8 : 0);
        }
    }

    private void setChecked(CheckedTextView btn, boolean on) {
        if (btn != null) {
            btn.setChecked(on);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
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

    
    public void u1(int val) {
        TextView v = findViewById(R.id.tv_text1);
        if (v != null) {
            int id = R.string.wc_psa_all_factory_settings_select_models_0;
            if (val == 1) {
                id = R.string.jeep_parksense_0;
            }
            if (val == 2) {
                id = R.string.jeep_parksense_1;
            }
            v.setText(id);
        }
    }

    
    public void u2(int val) {
        TextView v = findViewById(R.id.tv_text2);
        if (v != null) {
            int id = R.string.crv_source_null;
            if (val == 1) {
                id = R.string.klc_air_low;
            } else if (val == 2) {
                id = R.string.klc_air_middle;
            } else if (val == 3) {
                id = R.string.klc_air_high;
            }
            v.setText(id);
        }
    }

    
    public void u3(int val) {
        TextView v = findViewById(R.id.tv_text3);
        if (v != null) {
            int id = R.string.crv_source_null;
            if (val == 1) {
                id = R.string.klc_air_low;
            } else if (val == 2) {
                id = R.string.klc_air_middle;
            } else if (val == 3) {
                id = R.string.klc_air_high;
            }
            v.setText(id);
        }
    }

    
    public void u4(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext11), val != 0);
    }

    
    public void u5(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext5), val != 0);
    }

    
    public void u6(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext7), val != 0);
    }

    
    public void u7(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    
    public void u8(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext12), val != 0);
    }
}
