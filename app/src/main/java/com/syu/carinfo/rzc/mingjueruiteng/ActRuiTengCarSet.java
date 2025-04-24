package com.syu.carinfo.rzc.mingjueruiteng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActRuiTengCarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    ActRuiTengCarSet.this.mUpdaterValue0();
                    break;
                case 100:
                    ActRuiTengCarSet.this.mUpdaterValue1();
                    break;
                case 101:
                    ActRuiTengCarSet.this.mUpdaterValue2();
                    break;
                case 102:
                    ActRuiTengCarSet.this.mUpdaterValue3();
                    break;
                case 103:
                    ActRuiTengCarSet.this.mUpdaterValue4();
                    break;
                case 104:
                    ActRuiTengCarSet.this.mUpdaterValue5();
                    break;
                case 105:
                    ActRuiTengCarSet.this.mUpdaterValue6();
                    break;
                case 106:
                    ActRuiTengCarSet.this.mUpdaterValue7();
                    break;
                case 107:
                    ActRuiTengCarSet.this.mUpdaterValue8();
                    break;
                case 108:
                    ActRuiTengCarSet.this.mUpdaterValue9();
                    break;
                case 109:
                    ActRuiTengCarSet.this.mUpdaterValue10();
                    break;
                case 110:
                    ActRuiTengCarSet.this.mUpdaterValue11();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_rzc_ruiteng_car_set);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backlight)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_back_foglight)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_home_light_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_home_light_time_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_backcar)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_light)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_fog_light)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_find_light_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.rzc_ruiteng_find_light_time_next)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rzc_ruiteng_speed_lock /* 2131429002 */:
                int[] iArr = new int[3];
                iArr[0] = 1;
                iArr[1] = 1;
                iArr[2] = DataCanbus.DATA[99] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr);
                break;
            case R.id.rzc_ruiteng_auto_unlock /* 2131429003 */:
                int[] iArr2 = new int[3];
                iArr2[0] = 1;
                iArr2[1] = 2;
                iArr2[2] = DataCanbus.DATA[100] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr2);
                break;
            case R.id.rzc_ruiteng_unlock_mode /* 2131429005 */:
                int[] iArr3 = new int[3];
                iArr3[0] = 1;
                iArr3[1] = 3;
                iArr3[2] = DataCanbus.DATA[101] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr3);
                break;
            case R.id.rzc_ruiteng_unlock_nearcar /* 2131429007 */:
                int[] iArr4 = new int[3];
                iArr4[0] = 1;
                iArr4[1] = 4;
                iArr4[2] = DataCanbus.DATA[102] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr4);
                break;
            case R.id.rzc_ruiteng_home_light_backcar /* 2131429016 */:
                int[] iArr5 = new int[4];
                iArr5[0] = 2;
                iArr5[1] = 1;
                iArr5[2] = 1;
                iArr5[3] = DataCanbus.DATA[103] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr5);
                break;
            case R.id.rzc_ruiteng_home_light_backlight /* 2131432738 */:
                int[] iArr6 = new int[4];
                iArr6[0] = 2;
                iArr6[1] = 1;
                iArr6[2] = 2;
                iArr6[3] = DataCanbus.DATA[104] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr6);
                break;
            case R.id.rzc_ruiteng_home_light_back_foglight /* 2131432739 */:
                int[] iArr7 = new int[4];
                iArr7[0] = 2;
                iArr7[1] = 1;
                iArr7[2] = 3;
                iArr7[3] = DataCanbus.DATA[105] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr7);
                break;
            case R.id.rzc_ruiteng_home_light_time_pre /* 2131432740 */:
                int value = DataCanbus.DATA[106] - 1;
                FunRuiTeng.C_CARINFO_SET(2, 2, value);
                break;
            case R.id.rzc_ruiteng_home_light_time_next /* 2131432742 */:
                int value2 = DataCanbus.DATA[106] + 1;
                FunRuiTeng.C_CARINFO_SET(2, 2, value2);
                break;
            case R.id.rzc_ruiteng_find_light_backcar /* 2131432743 */:
                int[] iArr8 = new int[4];
                iArr8[0] = 2;
                iArr8[1] = 3;
                iArr8[2] = 1;
                iArr8[3] = DataCanbus.DATA[107] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr8);
                break;
            case R.id.rzc_ruiteng_find_light_back_light /* 2131432744 */:
                int[] iArr9 = new int[4];
                iArr9[0] = 2;
                iArr9[1] = 3;
                iArr9[2] = 2;
                iArr9[3] = DataCanbus.DATA[108] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr9);
                break;
            case R.id.rzc_ruiteng_find_light_back_fog_light /* 2131432745 */:
                int[] iArr10 = new int[4];
                iArr10[0] = 2;
                iArr10[1] = 3;
                iArr10[2] = 3;
                iArr10[3] = DataCanbus.DATA[109] != 0 ? 0 : 1;
                FunRuiTeng.C_CARINFO_SET(iArr10);
                break;
            case R.id.rzc_ruiteng_find_light_time_pre /* 2131432746 */:
                int value3 = DataCanbus.DATA[110] - 1;
                FunRuiTeng.C_CARINFO_SET(2, 4, value3);
                break;
            case R.id.rzc_ruiteng_find_light_time_next /* 2131432748 */:
                int value4 = DataCanbus.DATA[110] + 1;
                FunRuiTeng.C_CARINFO_SET(2, 4, value4);
                break;
        }
    }

    
    public void mUpdaterValue0() {
        int value = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_speed_lock)).setChecked(value == 1);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_auto_unlock)).setChecked(value == 1);
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_mode)).setChecked(value == 1);
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_unlock_mode_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_0));
            }
        }
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_unlock_nearcar)).setChecked(value == 1);
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_1));
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_intelligent_unlock_tv)).setText(getResources().getString(R.string.wc_ruiteng_string_unlock_mode_0));
            }
        }
    }

    
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backcar)).setChecked(value == 1);
    }

    
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_backlight)).setChecked(value == 1);
    }

    
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_home_light_back_foglight)).setChecked(value == 1);
    }

    
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[106];
        ((TextView) findViewById(R.id.rzc_ruiteng_home_light_time)).setText(getTimeString(value));
    }

    
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_backcar)).setChecked(value == 1);
    }

    
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_light)).setChecked(value == 1);
    }

    
    public void mUpdaterValue10() {
        int value = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.rzc_ruiteng_find_light_back_fog_light)).setChecked(value == 1);
    }

    
    public void mUpdaterValue11() {
        int value = DataCanbus.DATA[110];
        ((TextView) findViewById(R.id.rzc_ruiteng_find_light_time)).setText(getTimeString(value));
    }

    public String getTimeString(int value) {
        switch (value) {
            case 0:
                String str = getString(R.string.wc_ruiteng_string_time_0);
                return str;
            case 1:
                String str2 = getString(R.string.wc_ruiteng_string_time_1);
                return str2;
            case 2:
                String str3 = getString(R.string.wc_ruiteng_string_time_2);
                return str3;
            case 3:
                String str4 = getString(R.string.wc_ruiteng_string_time_3);
                return str4;
            case 4:
                String str5 = getString(R.string.wc_ruiteng_string_time_4);
                return str5;
            case 5:
                String str6 = getString(R.string.wc_ruiteng_string_time_5);
                return str6;
            case 6:
                String str7 = getString(R.string.wc_ruiteng_string_time_6);
                return str7;
            case 7:
                String str8 = getString(R.string.wc_ruiteng_string_time_7);
                return str8;
            case 8:
                String str9 = getString(R.string.wc_ruiteng_string_time_8);
                return str9;
            case 9:
                String str10 = getString(R.string.wc_ruiteng_string_time_9);
                return str10;
            default:
                return "";
        }
    }
}
