package com.syu.carinfo.bg.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bg_DaQieNuoJi_Safety extends BaseActivity {
    int[] ids = {65, 66, 67, 68, 69, 70, 71, 84};
    int val = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Safety.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 65:
                    Bg_DaQieNuoJi_Safety.this.u1(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 66:
                    Bg_DaQieNuoJi_Safety.this.u2(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 67:
                    Bg_DaQieNuoJi_Safety.this.u3(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 68:
                    Bg_DaQieNuoJi_Safety.this.u4(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 69:
                    Bg_DaQieNuoJi_Safety.this.u5(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 70:
                    Bg_DaQieNuoJi_Safety.this.u6(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 71:
                    Bg_DaQieNuoJi_Safety.this.u7(Bg_DaQieNuoJi_Safety.this.val);
                    break;
                case 84:
                    Bg_DaQieNuoJi_Safety.this.u8(Bg_DaQieNuoJi_Safety.this.val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_safety);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Safety.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v11) {
                switch (v11.getId()) {
                    case R.id.btn_minus1 /* 2131427480 */:
                    case R.id.btn_plus1 /* 2131427482 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[65];
                        Bg_DaQieNuoJi_Safety.this.setCmd(1, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.btn_minus2 /* 2131427484 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[66] - 1;
                        if (Bg_DaQieNuoJi_Safety.this.val < 0) {
                            Bg_DaQieNuoJi_Safety.this.val = 2;
                        }
                        Bg_DaQieNuoJi_Safety.this.setCmd(2, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_plus2 /* 2131427486 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[66] + 1;
                        Bg_DaQieNuoJi_Safety.this.val %= 3;
                        Bg_DaQieNuoJi_Safety.this.setCmd(2, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_minus3 /* 2131427488 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[67] - 1;
                        if (Bg_DaQieNuoJi_Safety.this.val < 0) {
                            Bg_DaQieNuoJi_Safety.this.val = 2;
                        }
                        Bg_DaQieNuoJi_Safety.this.setCmd(3, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.btn_plus3 /* 2131427490 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[67] + 1;
                        Bg_DaQieNuoJi_Safety.this.val %= 3;
                        Bg_DaQieNuoJi_Safety.this.setCmd(3, Bg_DaQieNuoJi_Safety.this.val);
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427531 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[71];
                        Bg_DaQieNuoJi_Safety.this.setCmd(7, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.ctv_checkedtext5 /* 2131427537 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[69];
                        Bg_DaQieNuoJi_Safety.this.setCmd(5, Bg_DaQieNuoJi_Safety.this.val != 0 ? 0 : 1);
                        break;
                    case R.id.ctv_checkedtext7 /* 2131427539 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[70];
                        Bg_DaQieNuoJi_Safety.this.setCmd(6, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.ctv_checkedtext11 /* 2131427543 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[68];
                        Bg_DaQieNuoJi_Safety.this.setCmd(4, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                    case R.id.layout_view20 /* 2131427641 */:
                        Bg_DaQieNuoJi_Safety.this.val = DataCanbus.DATA[84];
                        Bg_DaQieNuoJi_Safety.this.setCmd(49, Bg_DaQieNuoJi_Safety.this.val != 0 ? 1 : 2);
                        break;
                }
            }
        };
        setClick((Button) findViewById(R.id.btn_minus1));
        setClick((Button) findViewById(R.id.btn_plus1));
        setClick((Button) findViewById(R.id.btn_minus2));
        setClick((Button) findViewById(R.id.btn_plus2));
        setClick((Button) findViewById(R.id.btn_minus3));
        setClick((Button) findViewById(R.id.btn_plus3));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12));
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text3);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext11), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u5(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext5), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u6(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext7), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u7(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u8(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext12), val != 0);
    }
}
