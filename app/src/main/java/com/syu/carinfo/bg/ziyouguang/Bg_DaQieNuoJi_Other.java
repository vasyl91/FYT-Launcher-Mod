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
public class Bg_DaQieNuoJi_Other extends BaseActivity {
    int[] ids = {85, 91, 92, 93};
    int val = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Other.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 85:
                    Bg_DaQieNuoJi_Other.this.u5(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 91:
                    Bg_DaQieNuoJi_Other.this.u7(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 92:
                    Bg_DaQieNuoJi_Other.this.u6(Bg_DaQieNuoJi_Other.this.val);
                    break;
                case 93:
                    Bg_DaQieNuoJi_Other.this.u65(Bg_DaQieNuoJi_Other.this.val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_other);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        View v = findViewById(R.id.layout_view1);
        setGone(v, true);
        View v2 = findViewById(R.id.layout_view2);
        setGone(v2, true);
        View v3 = findViewById(R.id.layout_view3);
        setGone(v3, false);
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Other.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v4) {
                switch (v4.getId()) {
                    case R.id.btn_minus2 /* 2131427484 */:
                    case R.id.btn_plus2 /* 2131427486 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[92];
                        Bg_DaQieNuoJi_Other.this.setCmd(82, Bg_DaQieNuoJi_Other.this.val == 1 ? 0 : 1);
                        break;
                    case R.id.btn_minus3 /* 2131427488 */:
                    case R.id.btn_plus3 /* 2131427490 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[93];
                        Bg_DaQieNuoJi_Other.this.setCmd(83, Bg_DaQieNuoJi_Other.this.val != 1 ? 9 : 1);
                        break;
                    case R.id.btn_minus4 /* 2131427492 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[85] - 1;
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
                    case R.id.btn_plus4 /* 2131427494 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[85] + 1;
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
                    case R.id.ctv_checkedtext2 /* 2131427531 */:
                        Bg_DaQieNuoJi_Other.this.val = DataCanbus.DATA[91];
                        Bg_DaQieNuoJi_Other.this.setCmd(81, Bg_DaQieNuoJi_Other.this.val != 1 ? 2 : 1);
                        break;
                }
            }
        };
        setClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
        setClick((Button) findViewById(R.id.btn_minus2));
        setClick((Button) findViewById(R.id.btn_plus2));
        setClick((Button) findViewById(R.id.btn_minus3));
        setClick((Button) findViewById(R.id.btn_plus3));
        setClick((Button) findViewById(R.id.btn_minus4));
        setClick((Button) findViewById(R.id.btn_plus4));
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
    public void u5(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text4);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u7(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext2), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u6(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text2);
        if (v != null) {
            int id = R.string.str_unit_us_imperial;
            if (val == 1) {
                id = R.string.str_unit_metric;
            }
            v.setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u65(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text3);
        if (v != null) {
            int id = R.string.jeep_language_set0;
            if (val == 1) {
                id = R.string.jeep_language_set1;
            }
            v.setText(id);
        }
    }
}
