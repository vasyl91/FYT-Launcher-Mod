package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Acti_Xima_Xfy extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.Acti_Xima_Xfy.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.xyf_xima_sound_high_m /* 2131429363 */:
                    Acti_Xima_Xfy.this.sendCMD(5, 0);
                    break;
                case R.id.xyf_xima_sound_high_p /* 2131429365 */:
                    Acti_Xima_Xfy.this.sendCMD(5, 1);
                    break;
                case R.id.xyf_xima_sound_low_m /* 2131429366 */:
                    Acti_Xima_Xfy.this.sendCMD(4, 0);
                    break;
                case R.id.xyf_xima_sound_low_p /* 2131429368 */:
                    Acti_Xima_Xfy.this.sendCMD(4, 1);
                    break;
                case R.id.xyf_xima_lr_balance_m /* 2131429369 */:
                    Acti_Xima_Xfy.this.sendCMD(12, 0);
                    break;
                case R.id.xyf_xima_lr_balance_p /* 2131429371 */:
                    Acti_Xima_Xfy.this.sendCMD(12, 1);
                    break;
                case R.id.xyf_xima_fb_balance_m /* 2131429372 */:
                    Acti_Xima_Xfy.this.sendCMD(13, 1);
                    break;
                case R.id.xyf_xima_fb_balance_p /* 2131429374 */:
                    Acti_Xima_Xfy.this.sendCMD(13, 0);
                    break;
                case R.id.xyf_xima_speed_vol_m /* 2131429375 */:
                    Acti_Xima_Xfy.this.sendCMD(14, 0);
                    break;
                case R.id.xyf_xima_speed_vol_p /* 2131429377 */:
                    Acti_Xima_Xfy.this.sendCMD(14, 1);
                    break;
                case R.id.xyf_xima_round_vol_m /* 2131429378 */:
                    Acti_Xima_Xfy.this.sendCMD(17, 0);
                    break;
                case R.id.xyf_xima_round_vol_p /* 2131429380 */:
                    Acti_Xima_Xfy.this.sendCMD(17, 1);
                    break;
                case R.id.xyf_xima_driver_field /* 2131429381 */:
                    Acti_Xima_Xfy.this.sendCMD(15, DataCanbus.DATA[104] != 0 ? 0 : 1);
                    break;
                case R.id.xyf_xima_bose /* 2131429382 */:
                    Acti_Xima_Xfy.this.sendCMD(16, DataCanbus.DATA[106] != 0 ? 0 : 1);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.Acti_Xima_Xfy.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    Acti_Xima_Xfy.this.uCarSoundH(val);
                    break;
                case 100:
                    Acti_Xima_Xfy.this.uCarSoundL(val);
                    break;
                case 101:
                    Acti_Xima_Xfy.this.uCarFieldFB(val);
                    break;
                case 102:
                    Acti_Xima_Xfy.this.uCarFieldLR(val);
                    break;
                case 103:
                    Acti_Xima_Xfy.this.uCarSpeedLink(val);
                    break;
                case 104:
                    Acti_Xima_Xfy.this.uCarFieldDriver(val);
                    break;
                case 105:
                    Acti_Xima_Xfy.this.uCarRoundVol(val);
                    break;
                case 106:
                    Acti_Xima_Xfy.this.uCarBose(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_414_xfy_xima);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setonClick((Button) findViewById(R.id.xyf_xima_sound_low_m));
        setonClick((Button) findViewById(R.id.xyf_xima_sound_low_p));
        setonClick((Button) findViewById(R.id.xyf_xima_sound_high_m));
        setonClick((Button) findViewById(R.id.xyf_xima_sound_high_p));
        setonClick((Button) findViewById(R.id.xyf_xima_lr_balance_m));
        setonClick((Button) findViewById(R.id.xyf_xima_lr_balance_p));
        setonClick((Button) findViewById(R.id.xyf_xima_fb_balance_m));
        setonClick((Button) findViewById(R.id.xyf_xima_fb_balance_p));
        setonClick((Button) findViewById(R.id.xyf_xima_speed_vol_m));
        setonClick((Button) findViewById(R.id.xyf_xima_speed_vol_p));
        setonClick((Button) findViewById(R.id.xyf_xima_round_vol_m));
        setonClick((Button) findViewById(R.id.xyf_xima_round_vol_p));
        setonClick((CheckedTextView) findViewById(R.id.xyf_xima_driver_field));
        setonClick((CheckedTextView) findViewById(R.id.xyf_xima_bose));
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    protected void uCarSoundL(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_sound_low_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_sound_low_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSoundH(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_sound_high_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_sound_high_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarRoundVol(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_round_vol_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_round_vol_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarSpeedLink(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_speed_vol_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_speed_vol_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldLR(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_lr_balance_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_lr_balance_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarFieldFB(int val) {
        if (((TextView) findViewById(R.id.xyf_xima_fb_balance_txt)) != null) {
            ((TextView) findViewById(R.id.xyf_xima_fb_balance_txt)).setText(new StringBuilder(String.valueOf(val)).toString());
        }
    }

    protected void uCarBose(int val) {
        if (((CheckedTextView) findViewById(R.id.xyf_xima_bose)) != null) {
            ((CheckedTextView) findViewById(R.id.xyf_xima_bose)).setChecked(val == 1);
        }
    }

    protected void uCarFieldDriver(int val) {
        if (((CheckedTextView) findViewById(R.id.xyf_xima_driver_field)) != null) {
            ((CheckedTextView) findViewById(R.id.xyf_xima_driver_field)).setChecked(val == 1);
        }
    }
}
