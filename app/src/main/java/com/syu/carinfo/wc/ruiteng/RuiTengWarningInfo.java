package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RuiTengWarningInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 160:
                    RuiTengWarningInfo.this.mUpdaterValue1();
                    break;
                case 161:
                    RuiTengWarningInfo.this.mUpdaterValue2();
                    break;
                case 162:
                    RuiTengWarningInfo.this.mUpdaterValue3();
                    break;
                case 163:
                    RuiTengWarningInfo.this.mUpdaterValue4();
                    break;
                case 164:
                    RuiTengWarningInfo.this.mUpdaterValue5();
                    break;
                case 165:
                    RuiTengWarningInfo.this.mUpdaterValue6();
                    break;
                case 166:
                    RuiTengWarningInfo.this.mUpdaterValue7();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_warning_info);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[160];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_1)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[161];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_2)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[162];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_3)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[163];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_4)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[164];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_5)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[165];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_6)).setText("");
                break;
        }
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[166];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_3);
                break;
            case 4:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_4);
                break;
            case 5:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_5);
                break;
            case 6:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_6);
                break;
            case 7:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText(R.string.wc_ruiteng_string_warning_info_7);
                break;
            default:
                ((TextView) findViewById(R.id.wc_ruiteng_warning_7)).setText("");
                break;
        }
    }
}
