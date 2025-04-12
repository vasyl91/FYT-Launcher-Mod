package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bg_DaQieNuoJi_Light extends BaseActivity {
    int[] ids = {142, 143, 144, 145, 146};
    int val = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Light.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    Bg_DaQieNuoJi_Light.this.u6(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 143:
                    Bg_DaQieNuoJi_Light.this.u4(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 144:
                    Bg_DaQieNuoJi_Light.this.u3(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 145:
                    Bg_DaQieNuoJi_Light.this.u2(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 146:
                    Bg_DaQieNuoJi_Light.this.u1(Bg_DaQieNuoJi_Light.this.val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_light);
        init();
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

    @Override
    public void init() {
        View v = findViewById(R.id.layout_view6);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view7);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view8);
        setGone(v3, true);
        View v4 = findViewById(R.id.layout_view10);
        setGone(v4, true);
        View v5 = findViewById(R.id.layout_view11);
        setGone(v5, true);
        View v6 = findViewById(R.id.layout_view12);
        setGone(v6, true);
        setCmdClick(findViewById(R.id.ctv_checkedtext3), 19, 144);
        setCmdClick(findViewById(R.id.ctv_checkedtext1), 20, 145);
        setCmdClick(findViewById(R.id.ctv_checkedtext2), 21, 146);
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v7) {
                switch (v7.getId()) {
                    case R.id.btn_minus1 /* 2131427455 */:
                        int val = DataCanbus.DATA[142] - 1;
                        if (val < 0) {
                            val = 3;
                        }
                        int vals = 0;
                        switch (val) {
                            case 0:
                                vals = 0;
                                break;
                            case 1:
                                vals = 30;
                                break;
                            case 2:
                                vals = 60;
                                break;
                            case 3:
                                vals = 90;
                                break;
                        }
                        Bg_DaQieNuoJi_Light.this.setCmd(17, vals);
                        break;
                    case R.id.btn_plus1 /* 2131427457 */:
                        int vals2 = 0;
                        switch ((DataCanbus.DATA[142] + 1) % 4) {
                            case 0:
                                vals2 = 0;
                                break;
                            case 1:
                                vals2 = 30;
                                break;
                            case 2:
                                vals2 = 60;
                                break;
                            case 3:
                                vals2 = 90;
                                break;
                        }
                        Bg_DaQieNuoJi_Light.this.setCmd(17, vals2);
                        break;
                    case R.id.btn_minus2 /* 2131427458 */:
                        int val2 = DataCanbus.DATA[143] - 1;
                        if (val2 < 0) {
                            val2 = 3;
                        }
                        int vals3 = 0;
                        switch (val2) {
                            case 0:
                                vals3 = 0;
                                break;
                            case 1:
                                vals3 = 30;
                                break;
                            case 2:
                                vals3 = 60;
                                break;
                            case 3:
                                vals3 = 90;
                                break;
                        }
                        Bg_DaQieNuoJi_Light.this.setCmd(18, vals3);
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        int vals4 = 0;
                        switch ((DataCanbus.DATA[143] + 1) % 4) {
                            case 0:
                                vals4 = 0;
                                break;
                            case 1:
                                vals4 = 30;
                                break;
                            case 2:
                                vals4 = 60;
                                break;
                            case 3:
                                vals4 = 90;
                                break;
                        }
                        Bg_DaQieNuoJi_Light.this.setCmd(18, vals4);
                        break;
                }
            }
        };
        setClick(findViewById(R.id.btn_minus1));
        setClick(findViewById(R.id.btn_plus1));
        setClick(findViewById(R.id.btn_minus2));
        setClick(findViewById(R.id.btn_plus2));
    }

    private void setCmdClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int val = DataCanbus.DATA[id];
                    Bg_DaQieNuoJi_Light.this.setCmd(cmd, val == 0 ? 2 : 1);
                }
            });
        }
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

    
    public void u6(int val) {
        TextView v = findViewById(R.id.tv_text1);
        if (v != null) {
            String str = "0s";
            if (val == 1) {
                str = "30s";
            } else if (val == 2) {
                str = "60s";
            } else if (val == 3) {
                str = "90s";
            }
            v.setText(str);
        }
    }

    
    public void u4(int val) {
        TextView v = findViewById(R.id.tv_text2);
        if (v != null) {
            String str = "0s";
            if (val == 1) {
                str = "30s";
            } else if (val == 2) {
                str = "60s";
            } else if (val == 3) {
                str = "90s";
            }
            v.setText(str);
        }
    }

    
    public void u3(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext3), val != 0);
    }

    
    public void u2(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext1), val != 0);
    }

    
    public void u1(int val) {
        setChecked(findViewById(R.id.ctv_checkedtext2), val != 0);
    }
}
