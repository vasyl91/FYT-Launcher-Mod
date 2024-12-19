package com.syu.carinfo.bnr;

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
public class Acti_Nissan_Bnr extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bnr.Acti_Nissan_Bnr.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ctv_checkedtext1 /* 2131427478 */:
                    Acti_Nissan_Bnr.this.sendCMD(41, DataCanbus.DATA[38] == 0 ? 1 : 0);
                    break;
                case R.id.btn_minus1 /* 2131427480 */:
                    Acti_Nissan_Bnr.this.sendCMD(33, 49);
                    break;
                case R.id.btn_plus1 /* 2131427482 */:
                    Acti_Nissan_Bnr.this.sendCMD(33, 33);
                    break;
                case R.id.btn_minus2 /* 2131427484 */:
                    Acti_Nissan_Bnr.this.sendCMD(35, 49);
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    Acti_Nissan_Bnr.this.sendCMD(35, 33);
                    break;
                case R.id.btn_minus3 /* 2131427488 */:
                    Acti_Nissan_Bnr.this.sendCMD(34, 49);
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    Acti_Nissan_Bnr.this.sendCMD(34, 33);
                    break;
                case R.id.btn_minus4 /* 2131427492 */:
                    Acti_Nissan_Bnr.this.sendCMD(36, 49);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    Acti_Nissan_Bnr.this.sendCMD(36, 33);
                    break;
                case R.id.btn_minus5 /* 2131427496 */:
                    Acti_Nissan_Bnr.this.sendCMD(37, 49);
                    break;
                case R.id.btn_plus5 /* 2131427498 */:
                    Acti_Nissan_Bnr.this.sendCMD(37, 33);
                    break;
                case R.id.btn_minus6 /* 2131427501 */:
                    Acti_Nissan_Bnr.this.sendCMD(38, 49);
                    break;
                case R.id.btn_plus6 /* 2131427503 */:
                    Acti_Nissan_Bnr.this.sendCMD(38, 33);
                    break;
                case R.id.btn_minus7 /* 2131427505 */:
                    Acti_Nissan_Bnr.this.sendCMD(40, 49);
                    break;
                case R.id.btn_plus7 /* 2131427507 */:
                    Acti_Nissan_Bnr.this.sendCMD(40, 33);
                    break;
                case R.id.ctv_checkedtext2 /* 2131427531 */:
                    Acti_Nissan_Bnr.this.sendCMD(39, DataCanbus.DATA[36] == 0 ? 1 : 0);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.Acti_Nissan_Bnr.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 30:
                    Acti_Nissan_Bnr.this.uCarSound(val);
                    break;
                case 31:
                    Acti_Nissan_Bnr.this.uCarSoundL(val);
                    break;
                case 32:
                    Acti_Nissan_Bnr.this.uCarSoundH(val);
                    break;
                case 33:
                    Acti_Nissan_Bnr.this.uCarFieldLR(val);
                    break;
                case 34:
                    Acti_Nissan_Bnr.this.uCarFieldFB(val);
                    break;
                case 35:
                    Acti_Nissan_Bnr.this.uCarSpeedLink(val);
                    break;
                case 36:
                    Acti_Nissan_Bnr.this.uCarBose(val);
                    break;
                case 37:
                    Acti_Nissan_Bnr.this.uCarRoundVol(val);
                    break;
                case 38:
                    Acti_Nissan_Bnr.this.uCarFieldDriver(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_324_bnr_nissan);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
        setonClick((Button) findViewById(R.id.btn_minus5));
        setonClick((Button) findViewById(R.id.btn_plus5));
        setonClick((Button) findViewById(R.id.btn_minus6));
        setonClick((Button) findViewById(R.id.btn_plus6));
        setonClick((Button) findViewById(R.id.btn_minus7));
        setonClick((Button) findViewById(R.id.btn_plus7));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1));
        setonClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
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
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
    }

    protected void uCarSoundL(int val) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSound(int val) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSoundH(int val) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarRoundVol(int val) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSpeedLink(int val) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldLR(int val) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldFB(int val) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarBose(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
        }
    }

    protected void uCarFieldDriver(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(val == 1);
        }
    }
}
