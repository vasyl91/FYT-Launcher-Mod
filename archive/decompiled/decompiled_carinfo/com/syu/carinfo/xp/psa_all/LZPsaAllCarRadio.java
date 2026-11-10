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

@SuppressWarnings({"deprecation", "unchecked"})
public class LZPsaAllCarRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZPsaAllCarRadio mInit;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 189:
                    LZPsaAllCarRadio.this.updateRadioBand();
                    break;
                case 190:
                    if (LZPsaAllCarRadio.this.unit == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 191:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text1)).setText("电台锁定： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text1)).setText("电台锁定： 停用");
                        break;
                    }
                case 192:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text2)).setText("区域模式： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text2)).setText("区域模式： 停用");
                        break;
                    }
                case 193:
                    if (value == 1) {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text3)).setText("文本显示： 启用");
                        break;
                    } else {
                        ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text3)).setText("文本显示： 停用");
                        break;
                    }
                case 206:
                    ((TextView) LZPsaAllCarRadio.this.findViewById(R.id.tv_text4)).setText(Callback_0281_XP_PSA_ALL.RadioText);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0281_lz_psa_407_carradio);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[189];
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
