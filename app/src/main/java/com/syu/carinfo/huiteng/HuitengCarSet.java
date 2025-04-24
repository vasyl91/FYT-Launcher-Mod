package com.syu.carinfo.huiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class HuitengCarSet extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int val = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            HuitengCarSet.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    HuitengCarSet.this.updateCarLevel();
                    break;
                case 114:
                    HuitengCarSet.this.updateVibrationlesslevel();
                    break;
                case 116:
                    HuitengCarSet.this.updateCarVollevel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_huiteng_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[113] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[114] - 1;
                if (value3 < 1) {
                    value3 = 4;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[114] + 1;
                if (value4 > 4) {
                    value4 = 1;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[116] - 1;
                if (value5 < 0) {
                    value5 = 30;
                }
                DataCanbus.PROXY.cmd(6, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[116] + 1;
                if (value6 > 30) {
                    value6 = 0;
                }
                DataCanbus.PROXY.cmd(6, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, value1, value2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarVollevel() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void updateCarLevel() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_klc_nomal);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_advanced_set);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_klc_nomal);
                    break;
            }
        }
    }

    
    public void updateVibrationlesslevel() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sbd_x80_one_leavel_soft);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sbd_x80_two_leavel);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sbd_x80_three_leavel);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sbd_x80_four_leavel_sport);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_sbd_x80_one_leavel_soft);
                    break;
            }
        }
    }
}
