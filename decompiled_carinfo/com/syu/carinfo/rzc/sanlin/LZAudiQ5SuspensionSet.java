package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZAudiQ5SuspensionSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 163:
                    int mode = DataCanbus.DATA[163];
                    int B3 = DataCanbus.DATA[158];
                    int B4 = DataCanbus.DATA[157];
                    int B5 = DataCanbus.DATA[156];
                    int B6 = DataCanbus.DATA[155];
                    int B7 = DataCanbus.DATA[154];
                    ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text5)).setTextColor(B3 == 1 ? -65536 : -7829368);
                    ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text4)).setTextColor(B4 == 1 ? -65536 : -7829368);
                    ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text3)).setTextColor(B5 == 1 ? -65536 : -7829368);
                    ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text2)).setTextColor(B6 == 1 ? -65536 : -7829368);
                    ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text1)).setTextColor(B7 == 1 ? -65536 : -7829368);
                    ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.icon_car_null);
                    ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.icon_car_null);
                    ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view5)).setBackgroundResource(R.drawable.icon_car_null);
                    ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view6)).setBackgroundResource(R.drawable.icon_car_null);
                    ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view7)).setBackgroundResource(R.drawable.icon_car_null);
                    switch (mode) {
                        case 0:
                            ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text3)).setTextColor(-1);
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view5)).setBackgroundResource(R.drawable.ic_audi_suspension_b5);
                            break;
                        case 1:
                            ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text4)).setTextColor(-1);
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view6)).setBackgroundResource(R.drawable.ic_audi_suspension_b4);
                            break;
                        case 2:
                            ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text5)).setTextColor(-1);
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view7)).setBackgroundResource(R.drawable.ic_audi_suspension_b3);
                            break;
                        case 3:
                            ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text2)).setTextColor(-1);
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_audi_suspension_b6);
                            break;
                        case 4:
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_audi_suspension_b7);
                            ((TextView) LZAudiQ5SuspensionSet.this.findViewById(R.id.tv_text1)).setTextColor(-1);
                            break;
                    }
                case 159:
                    if (value == 1) {
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus1)).setTextColor(-65536);
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_audi_suspension_button_p);
                        break;
                    } else {
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_audi_suspension_button_n);
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus1)).setTextColor(-7829368);
                        break;
                    }
                case 160:
                    if (value == 1) {
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus2)).setTextColor(-65536);
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_audi_suspension_button_p);
                        break;
                    } else {
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_audi_suspension_button_n);
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus2)).setTextColor(-7829368);
                        break;
                    }
                case 161:
                    if (value == 1) {
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus3)).setTextColor(-65536);
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_audi_suspension_button_p);
                        break;
                    } else {
                        LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_audi_suspension_button_n);
                        ((Button) LZAudiQ5SuspensionSet.this.findViewById(R.id.btn_plus3)).setTextColor(-7829368);
                        break;
                    }
                case 162:
                    switch (value) {
                        case 0:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev0);
                            break;
                        case 1:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev1);
                            break;
                        case 2:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev2);
                            break;
                        case 3:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev3);
                            break;
                        case 4:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev4);
                            break;
                        case 5:
                            LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_audi_suspension_lev5);
                            break;
                    }
                case 164:
                    if (value == 1) {
                        ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.ic_audi_suspension_up);
                        break;
                    } else {
                        ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view8)).setBackgroundResource(R.drawable.icon_car_null);
                        break;
                    }
                case 165:
                    if (value == 1) {
                        ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.ic_audi_suspension_down);
                        break;
                    } else {
                        ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.icon_car_null);
                        break;
                    }
                case 166:
                    switch (value) {
                        case 0:
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_audi_suspension_car3);
                            break;
                        case 1:
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_audi_suspension_car2);
                            break;
                        case 2:
                            ((ImageView) LZAudiQ5SuspensionSet.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_audi_suspension_car1);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_audi_q5_suspension_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((TextView) findViewById(R.id.tv_text1), this);
        setSelfClick((TextView) findViewById(R.id.tv_text2), this);
        setSelfClick((TextView) findViewById(R.id.tv_text3), this);
        setSelfClick((TextView) findViewById(R.id.tv_text4), this);
        setSelfClick((TextView) findViewById(R.id.tv_text5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text1 /* 2131427456 */:
                setCarInfo(57, 4);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value = DataCanbus.DATA[159];
                setCarInfo(56, value != 1 ? 1 : 0);
                break;
            case R.id.tv_text2 /* 2131427459 */:
                setCarInfo(57, 3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value2 = DataCanbus.DATA[160];
                setCarInfo(54, value2 != 1 ? 1 : 0);
                break;
            case R.id.tv_text3 /* 2131427462 */:
                setCarInfo(57, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value3 = DataCanbus.DATA[161];
                setCarInfo(55, value3 != 1 ? 1 : 0);
                break;
            case R.id.tv_text4 /* 2131427465 */:
                setCarInfo(57, 1);
                break;
            case R.id.tv_text5 /* 2131427468 */:
                setCarInfo(57, 2);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{16}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
    }
}
