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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Acti_Xima_Xfy extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.Acti_Xima_Xfy.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.xyf_xima_sound_high_m /* 2131429885 */:
                    Acti_Xima_Xfy.this.sendCMD(5, 0);
                    break;
                case R.id.xyf_xima_sound_high_p /* 2131429887 */:
                    Acti_Xima_Xfy.this.sendCMD(5, 1);
                    break;
                case R.id.xyf_xima_sound_low_m /* 2131429888 */:
                    Acti_Xima_Xfy.this.sendCMD(4, 0);
                    break;
                case R.id.xyf_xima_sound_low_p /* 2131429890 */:
                    Acti_Xima_Xfy.this.sendCMD(4, 1);
                    break;
                case R.id.xyf_xima_lr_balance_m /* 2131429891 */:
                    Acti_Xima_Xfy.this.sendCMD(12, 0);
                    break;
                case R.id.xyf_xima_lr_balance_p /* 2131429893 */:
                    Acti_Xima_Xfy.this.sendCMD(12, 1);
                    break;
                case R.id.xyf_xima_fb_balance_m /* 2131429894 */:
                    Acti_Xima_Xfy.this.sendCMD(13, 1);
                    break;
                case R.id.xyf_xima_fb_balance_p /* 2131429896 */:
                    Acti_Xima_Xfy.this.sendCMD(13, 0);
                    break;
                case R.id.xyf_xima_speed_vol_m /* 2131429897 */:
                    Acti_Xima_Xfy.this.sendCMD(14, 0);
                    break;
                case R.id.xyf_xima_speed_vol_p /* 2131429899 */:
                    Acti_Xima_Xfy.this.sendCMD(14, 1);
                    break;
                case R.id.xyf_xima_round_vol_m /* 2131429900 */:
                    Acti_Xima_Xfy.this.sendCMD(17, 0);
                    break;
                case R.id.xyf_xima_round_vol_p /* 2131429902 */:
                    Acti_Xima_Xfy.this.sendCMD(17, 1);
                    break;
                case R.id.xyf_xima_driver_field /* 2131429903 */:
                    Acti_Xima_Xfy.this.sendCMD(15, DataCanbus.DATA[32] != 0 ? 0 : 1);
                    break;
                case R.id.xyf_xima_bose /* 2131429904 */:
                    Acti_Xima_Xfy.this.sendCMD(16, DataCanbus.DATA[34] != 0 ? 0 : 1);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.Acti_Xima_Xfy.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    Acti_Xima_Xfy.this.uCarSoundH(val);
                    break;
                case 28:
                    Acti_Xima_Xfy.this.uCarSoundL(val);
                    break;
                case 29:
                    Acti_Xima_Xfy.this.uCarFieldFB(val);
                    break;
                case 30:
                    Acti_Xima_Xfy.this.uCarFieldLR(val);
                    break;
                case 31:
                    Acti_Xima_Xfy.this.uCarSpeedLink(val);
                    break;
                case 32:
                    Acti_Xima_Xfy.this.uCarFieldDriver(val);
                    break;
                case 33:
                    Acti_Xima_Xfy.this.uCarRoundVol(val);
                    break;
                case 34:
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
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
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
