package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bg_DaQieNuoJi_Other extends BaseActivity {
    int[] ids = {155, 161, 162, 163};
    int val = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 155:
                    Bg_DaQieNuoJi_Other.this.u5(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 161:
                    Bg_DaQieNuoJi_Other.this.u7(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 162:
                    Bg_DaQieNuoJi_Other.this.u6(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 163:
                    Bg_DaQieNuoJi_Other.this.u65(Bg_DaQieNuoJi_Other.this.val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_other);
        init();
    }

    @Override
    public void init() {
        View v = findViewById(R.id.layout_view1);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view2);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view3);
        setGone(v3, false);
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v4) {
                switch (v4.getId()) {
                    case R.id.btn_minus2 /* 2131427458 */:
                    case R.id.btn_plus2 /* 2131427460 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[162];
                        Bg_DaQieNuoJi_Other.this.setCmd(82, Bg_DaQieNuoJi_Other.this.val == 1 ? 0 : 1);
                        break;
                    case R.id.btn_minus3 /* 2131427461 */:
                    case R.id.btn_plus3 /* 2131427463 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[163];
                        Bg_DaQieNuoJi_Other.this.setCmd(83, Bg_DaQieNuoJi_Other.this.val != 1 ? 9 : 1);
                        break;
                    case R.id.btn_minus4 /* 2131427464 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[155] - 1;
                        if (Bg_DaQieNuoJi_Other.this.val < 0) {
                            Bg_DaQieNuoJi_Other.this.val = 3;
                        }
                        switch (Bg_DaQieNuoJi_Other.this.val) {
                            case 0:
                                Bg_DaQieNuoJi_Other.this.val = 0;
                                break;
                            case 1:
                                Bg_DaQieNuoJi_Other.this.val = 3;
                                break;
                            case 2:
                                Bg_DaQieNuoJi_Other.this.val = 20;
                                break;
                            case 3:
                                Bg_DaQieNuoJi_Other.this.val = 40;
                                break;
                        }
                        Bg_DaQieNuoJi_Other.this.setCmd(50, Bg_DaQieNuoJi_Other.this.val);
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[155] + 1;
                        Bg_DaQieNuoJi_Other.this.val %= 4;
                        switch (Bg_DaQieNuoJi_Other.this.val) {
                            case 0:
                                Bg_DaQieNuoJi_Other.this.val = 0;
                                break;
                            case 1:
                                Bg_DaQieNuoJi_Other.this.val = 3;
                                break;
                            case 2:
                                Bg_DaQieNuoJi_Other.this.val = 20;
                                break;
                            case 3:
                                Bg_DaQieNuoJi_Other.this.val = 40;
                                break;
                        }
                        Bg_DaQieNuoJi_Other.this.setCmd(50, Bg_DaQieNuoJi_Other.this.val);
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[161];
                        Bg_DaQieNuoJi_Other.this.setCmd(81, Bg_DaQieNuoJi_Other.this.val != 1 ? 2 : 1);
                        break;
                }
            }
        };
        setClick(findViewById(R.id.ctv_checkedtext2));
        setClick(findViewById(R.id.btn_minus2));
        setClick(findViewById(R.id.btn_plus2));
        setClick(findViewById(R.id.btn_minus3));
        setClick(findViewById(R.id.btn_plus3));
        setClick(findViewById(R.id.btn_minus4));
        setClick(findViewById(R.id.btn_plus4));
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

    
    public void u5(int val) {
        TextView v = findViewById(R.id.tv_text4);
        if (v != null) {
            String str = "0s";
            switch (val) {
                case 0:
                    str = "0s";
                    break;
                case 1:
                    str = "45s";
                    break;
                case 2:
                    str = "5min";
                    break;
                case 3:
                    str = "10min";
                    break;
            }
            v.setText(str);
        }
    }

    
    public void u7(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    
    public void u6(int val) {
        TextView v = findViewById(R.id.tv_text2);
        if (v != null) {
            int id = R.string.str_unit_us_imperial;
            if (val == 1) {
                id = R.string.str_unit_metric;
            }
            v.setText(id);
        }
    }

    
    public void u65(int val) {
        TextView v = findViewById(R.id.tv_text3);
        if (v != null) {
            int id = R.string.jeep_language_set0;
            if (val == 1) {
                id = R.string.jeep_language_set1;
            }
            v.setText(id);
        }
    }
}
