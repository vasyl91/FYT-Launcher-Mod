package com.syu.carinfo.xp.psa_all;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0281_XP_PSA_ALL;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZPsaAllCarRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZPsaAllCarRadio mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllCarRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    LZPsaAllCarRadio.this.updateRadioBand();
                    break;
                case 124:
                    if (LZPsaAllCarRadio.this.unit == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 125:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text1)).setText("电台锁定： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text1)).setText("电台锁定： 停用");
                        break;
                    }
                case 126:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text2)).setText("区域模式： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text2)).setText("区域模式： 停用");
                        break;
                    }
                case 127:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text3)).setText("文本显示： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text3)).setText("文本显示： 停用");
                        break;
                    }
                case 140:
                    ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text4)).setText(Callback_0281_XP_PSA_ALL.RadioText);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0281_lz_psa_407_carradio);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[123];
        switch (value) {
            case 1:
            case 2:
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
