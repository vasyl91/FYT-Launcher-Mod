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
public class Bg_DaQieNuoJi_Light extends BaseActivity {
    int[] ids = {72, 73, 74, 75, 76};
    int val = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Light.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Bg_DaQieNuoJi_Light.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 72:
                    Bg_DaQieNuoJi_Light.this.u6(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 73:
                    Bg_DaQieNuoJi_Light.this.u4(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 74:
                    Bg_DaQieNuoJi_Light.this.u3(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 75:
                    Bg_DaQieNuoJi_Light.this.u2(Bg_DaQieNuoJi_Light.this.val);
                    break;
                case 76:
                    Bg_DaQieNuoJi_Light.this.u1(Bg_DaQieNuoJi_Light.this.val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_light);
        init();
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

    @Override // com.syu.canbus.BaseActivity
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
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 19, 74);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 20, 75);
        setCmdClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 21, 76);
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Light.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v7) {
                switch (v7.getId()) {
                    case R.id.btn_minus1 /* 2131427480 */:
                        int val = DataCanbus.DATA[72] - 1;
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
                    case R.id.btn_plus1 /* 2131427482 */:
                        int vals2 = 0;
                        switch ((DataCanbus.DATA[72] + 1) % 4) {
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
                    case R.id.btn_minus2 /* 2131427484 */:
                        int val2 = DataCanbus.DATA[73] - 1;
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
                    case R.id.btn_plus2 /* 2131427486 */:
                        int vals4 = 0;
                        switch ((DataCanbus.DATA[73] + 1) % 4) {
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
        setClick((Button) findViewById(R.id.btn_minus1));
        setClick((Button) findViewById(R.id.btn_plus1));
        setClick((Button) findViewById(R.id.btn_minus2));
        setClick((Button) findViewById(R.id.btn_plus2));
    }

    private void setCmdClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Light.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    int val = DataCanbus.DATA[id];
                    Bg_DaQieNuoJi_Light.this.setCmd(cmd, val == 0 ? 2 : 1);
                }
            });
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u6(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u4(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext3), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext1), val != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int val) {
        setChecked((CheckedTextView) findViewById(R.id.ctv_checkedtext2), val != 0);
    }
}
