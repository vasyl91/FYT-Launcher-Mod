package com.syu.carinfo.wc2.ford;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC2FordLincoinCarRadioAct extends BaseActivity implements View.OnLongClickListener, View.OnClickListener {
    public static boolean WC2FordLincoinCarRadioAct = false;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private int frq;
    private int frq1;
    private int frq10;
    private int frq11;
    private int frq12;
    private int frq13;
    private int frq14;
    private int frq15;
    private int frq16;
    private int frq17;
    private int frq18;
    private int frq2;
    private int frq3;
    private int frq4;
    private int frq5;
    private int frq6;
    private int frq7;
    private int frq8;
    private int frq9;
    private int mAmFm = 1;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 60:
                case 86:
                    WC2FordLincoinCarRadioAct.this.updaterRadioBand();
                    break;
                case 61:
                    WC2FordLincoinCarRadioAct.this.updaterRadioFreq(val);
                    break;
                case 62:
                    WC2FordLincoinCarRadioAct.this.frq1 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 63:
                    WC2FordLincoinCarRadioAct.this.frq2 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 64:
                    WC2FordLincoinCarRadioAct.this.frq3 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 65:
                    WC2FordLincoinCarRadioAct.this.frq4 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 66:
                    WC2FordLincoinCarRadioAct.this.frq5 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 67:
                    WC2FordLincoinCarRadioAct.this.frq6 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 68:
                    WC2FordLincoinCarRadioAct.this.frq7 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 69:
                    WC2FordLincoinCarRadioAct.this.frq8 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 70:
                    WC2FordLincoinCarRadioAct.this.frq9 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 71:
                    WC2FordLincoinCarRadioAct.this.frq10 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 72:
                    WC2FordLincoinCarRadioAct.this.frq11 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 73:
                    WC2FordLincoinCarRadioAct.this.frq12 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 74:
                    WC2FordLincoinCarRadioAct.this.frq13 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 75:
                    WC2FordLincoinCarRadioAct.this.frq14 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 76:
                    WC2FordLincoinCarRadioAct.this.frq15 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 77:
                    WC2FordLincoinCarRadioAct.this.frq16 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 78:
                    WC2FordLincoinCarRadioAct.this.frq17 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 79:
                    WC2FordLincoinCarRadioAct.this.frq18 = val;
                    WC2FordLincoinCarRadioAct.this.updateBand();
                    break;
                case 81:
                    WC2FordLincoinCarRadioAct.this.updaterRadioSCANOnOff(val);
                    break;
            }
        }
    };
    int radioband = 0;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            if (LauncherApplication.getConfiguration() == 1) {
                setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_radio_act_9853);
            } else {
                setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_radio_act);
            }
        } else {
            setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_radio_act);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.lexus_radio_am).setOnClickListener(this);
        findViewById(R.id.lexus_radio_fm).setOnClickListener(this);
        findViewById(R.id.lexus_radio_prev).setOnClickListener(this);
        findViewById(R.id.lexus_radio_next).setOnClickListener(this);
        findViewById(R.id.btn_lexus_freq_adj).setOnClickListener(this);
        findViewById(R.id.lexus_radio_scan_plus).setOnClickListener(this);
        findViewById(R.id.lexus_radio_scan_minu).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq1).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq2).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq3).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq4).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq5).setOnClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq6).setOnClickListener(this);
        findViewById(R.id.lexus_radio_prev).setOnLongClickListener(this);
        findViewById(R.id.lexus_radio_next).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq1).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq2).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq3).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq4).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq5).setOnLongClickListener(this);
        findViewById(R.id.btn_lexus_radio_frq6).setOnLongClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lexus_radio_prev /* 2131427850 */:
                sendCmd(1, 1);
                break;
            case R.id.lexus_radio_next /* 2131427851 */:
                sendCmd(1, 0);
                break;
            case R.id.lexus_radio_scan_plus /* 2131427853 */:
                sendCmd(5, 0);
                break;
            case R.id.lexus_radio_scan_minu /* 2131427854 */:
                sendCmd(5, 1);
                break;
            case R.id.lexus_radio_fm /* 2131427855 */:
                this.radioband = 2;
                if (this.mAmFm >= 1 && this.mAmFm < 3) {
                    this.mAmFm++;
                } else {
                    this.mAmFm = 1;
                }
                sendCmd(3, 1);
                updaterRadioBand();
                break;
            case R.id.lexus_radio_am /* 2131427856 */:
                this.radioband = 1;
                this.mAmFm = this.mAmFm != 1 ? 1 : 2;
                sendCmd(3, 0);
                updaterRadioBand();
                break;
            case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                int data0 = (this.mAmFm * 6) - 5;
                sendCmd(4, data0);
                break;
            case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                int data02 = (this.mAmFm * 6) - 4;
                sendCmd(4, data02);
                break;
            case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                int data03 = (this.mAmFm * 6) - 3;
                sendCmd(4, data03);
                break;
            case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                int data04 = (this.mAmFm * 6) - 2;
                sendCmd(4, data04);
                break;
            case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                int data05 = (this.mAmFm * 6) - 1;
                sendCmd(4, data05);
                break;
            case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                int data06 = this.mAmFm * 6;
                sendCmd(4, data06);
                break;
            case R.id.btn_lexus_freq_adj /* 2131428528 */:
                showPwd("调谐", "确认");
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        return true;
     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r6) {
        /*
            r5 = this;
            r4 = 2
            r3 = 1
            r2 = 8
            int r1 = r6.getId()
            switch(r1) {
                case 2131427850: goto Lc;
                case 2131427851: goto L10;
                case 2131427852: goto Lb;
                case 2131427853: goto Lb;
                case 2131427854: goto Lb;
                case 2131427855: goto Lb;
                case 2131427856: goto Lb;
                case 2131427857: goto Lb;
                case 2131427858: goto L15;
                case 2131427859: goto Lb;
                case 2131427860: goto L1f;
                case 2131427861: goto Lb;
                case 2131427862: goto L29;
                case 2131427863: goto Lb;
                case 2131427864: goto L33;
                case 2131427865: goto Lb;
                case 2131427866: goto L3d;
                case 2131427867: goto Lb;
                case 2131427868: goto L47;
                default: goto Lb;
            }
        Lb:
            return r3
        Lc:
            r5.sendCmd(r4, r3)
            goto Lb
        L10:
            r1 = 0
            r5.sendCmd(r4, r1)
            goto Lb
        L15:
            int r1 = r5.mAmFm
            int r1 = r1 * 6
            int r0 = r1 + (-5)
            r5.sendCmd(r2, r0)
            goto Lb
        L1f:
            int r1 = r5.mAmFm
            int r1 = r1 * 6
            int r0 = r1 + (-4)
            r5.sendCmd(r2, r0)
            goto Lb
        L29:
            int r1 = r5.mAmFm
            int r1 = r1 * 6
            int r0 = r1 + (-3)
            r5.sendCmd(r2, r0)
            goto Lb
        L33:
            int r1 = r5.mAmFm
            int r1 = r1 * 6
            int r0 = r1 + (-2)
            r5.sendCmd(r2, r0)
            goto Lb
        L3d:
            int r1 = r5.mAmFm
            int r1 = r1 * 6
            int r0 = r1 + (-1)
            r5.sendCmd(r2, r0)
            goto Lb
        L47:
            int r1 = r5.mAmFm
            int r0 = r1 * 6
            r5.sendCmd(r2, r0)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.wc2.ford.WC2FordLincoinCarRadioAct.onLongClick(android.view.View):boolean");
    }

    private void showPwd(String s1, String s2) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.parseColor("#44ffffff"));
        linearLayout.setGravity(1);
        linearLayout.setHorizontalGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(310, 50);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setPadding(0, 10, 0, 10);
        textView.setText(s1);
        final EditText editText = new EditText(this);
        editText.setInputType(2);
        editText.setBackgroundColor(-1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
        params.topMargin = 12;
        button.setLayoutParams(params);
        button.setText(s2);
        textView.setGravity(17);
        button.setTextSize(20.0f);
        button.setTextColor(-16777216);
        button.setPadding(30, 10, 30, 10);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinCarRadioAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WC2FordLincoinCarRadioAct.this.jumpFreq(editText.getText().toString());
                WC2FordLincoinCarRadioAct.this.dialog.dismiss();
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(button);
        this.builder = new AlertDialog.Builder(this).setView(linearLayout);
        this.dialog = this.builder.create();
        this.dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpFreq(String str) {
        if (!TextUtils.isEmpty(str)) {
            int temp = Integer.parseInt(str.replace(".", "").replace(" mhz", "").replace(" Khz", ""));
            int data0 = (temp >> 0) & 255;
            int data1 = (temp >> 8) & 255;
            sendCmd(10, data0, data1);
        }
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(6, new int[]{data0, data1}, null, null);
    }

    private void sendCmd(int data0, int data1, int data2) {
        DataCanbus.PROXY.cmd(6, new int[]{data0, data1, data2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        WC2FordLincoinCarRadioAct = true;
        addNotify();
        FuncMain.setChannel(11);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        WC2FordLincoinCarRadioAct = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBand() {
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int b4 = 0;
        int b5 = 0;
        int b6 = 0;
        switch (this.mAmFm) {
            case 1:
                b1 = this.frq1;
                b2 = this.frq2;
                b3 = this.frq3;
                b4 = this.frq4;
                b5 = this.frq5;
                b6 = this.frq6;
                break;
            case 2:
                b1 = this.frq7;
                b2 = this.frq8;
                b3 = this.frq9;
                b4 = this.frq10;
                b5 = this.frq11;
                b6 = this.frq12;
                break;
            case 3:
                b1 = this.frq13;
                b2 = this.frq14;
                b3 = this.frq15;
                b4 = this.frq16;
                b5 = this.frq17;
                b6 = this.frq18;
                break;
        }
        updaterRadioFreq1(b1);
        updaterRadioFreq2(b2);
        updaterRadioFreq3(b3);
        updaterRadioFreq4(b4);
        updaterRadioFreq5(b5);
        updaterRadioFreq6(b6);
    }

    private void updaterRadioFreq6(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    private void updaterRadioFreq5(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    private void updaterRadioFreq4(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    private void updaterRadioFreq3(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    private void updaterRadioFreq2(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    private void updaterRadioFreq1(int value) {
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq(int value) {
        int type = DataCanbus.DATA[60];
        switch (type) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        int type = DataCanbus.DATA[60];
        if (type != this.radioband) {
            this.mAmFm = 1;
            this.radioband = type;
        }
        switch (type) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM" + this.mAmFm);
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM" + this.mAmFm);
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
        }
        updateBand();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioSCANOnOff(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_radio_scan)).setText("空闲");
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_scan)).setText("扫描中");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_scan)).setText("刷新中");
                break;
        }
    }
}
