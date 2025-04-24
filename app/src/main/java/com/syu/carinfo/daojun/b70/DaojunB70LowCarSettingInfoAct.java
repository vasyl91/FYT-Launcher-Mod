package com.syu.carinfo.daojun.b70;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DaojunB70LowCarSettingInfoAct extends BaseActivity {
    public static DaojunB70LowCarSettingInfoAct mInit;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                    int B0 = DataCanbus.DATA[116];
                    int B1 = DataCanbus.DATA[117];
                    int B2 = DataCanbus.DATA[118];
                    int B3 = DataCanbus.DATA[119];
                    int B4 = DataCanbus.DATA[120];
                    int B5 = DataCanbus.DATA[121];
                    DaojunB70LowCarSettingInfoAct.this.mUpdaterCarSetInfoNum1(B0, B1, B2, B3, B4, B5);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInit = this;
        //setContentView(R.layout.layout_0439_daojunlow14b70_settinginfo);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    private void mUpdaterCarSetInfoNum2Color(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data2) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
            case 4:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
            case 5:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
            case 6:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setTextColor(-1);
                break;
        }
    }

    private void mUpdaterCarSetInfoValue(int data1, int data2, int data3, int data4, int data5, int data_value) {
        ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("%d", Integer.valueOf(data_value)));
        if (data1 == 4 && data2 == 1 && data3 == 5) {
            if (data_value >= 7) {
                ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("%d", Integer.valueOf(data_value - 7)));
                return;
            } else {
                if (data_value >= 0) {
                    ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("-%d", Integer.valueOf(7 - data_value)));
                    return;
                }
                return;
            }
        }
        if ((data1 == 4 && data2 == 3) || (data1 == 4 && data2 == 4)) {
            if (data_value > 7) {
                ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("R%d", Integer.valueOf(data_value - 7)));
            } else if (data_value == 7) {
                ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("%d", Integer.valueOf(data_value - 7)));
            } else if (data_value >= 0) {
                ((TextView) findViewById(R.id.b70_car_set_value)).setText(String.format("F%d", Integer.valueOf(7 - data_value)));
            }
        }
    }

    private void mUpdaterCarSetInfoNum3BTText(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data2) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("蓝牙匹配触发", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("来电显示关", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("来电显示开", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
        }
    }

    private void mUpdaterCarSetInfoNum3TimeText(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data2) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("增大", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("减小", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("增大", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("减小", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("24小时制", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("12小时制", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
        }
    }

    private void mUpdaterCarSetInfoNum3SoundText(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data2) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("标准", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("爵士", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("流行", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setText(String.format("古典", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setText(String.format("个性", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                mUpdaterCarSetInfoNum4GexingText(data1, data2, data3, data4, data5, data_value);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("标准", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("剧场", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("音乐厅", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setText(String.format("电影院", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setText(String.format("歌舞厅", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
            case 5:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("主驾驶", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("副驾驶", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("后排左", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setText(String.format("后排右", new Object[0]));
                mUpdaterCarSetInfoNum3Color(data1, data2, data3, data4, data5, data_value);
                break;
        }
    }

    private void mUpdaterCarSetInfoNum4GexingText(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data3) {
            case 5:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setText(String.format("高音", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setText(String.format("中音", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setText(String.format("低音", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setText(String.format("返回", new Object[0]));
                break;
        }
        switch (data4) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setTextColor(-1);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setTextColor(-1);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setTextColor(-1);
                break;
            case 4:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.b70_car_set_num4_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num4_4)).setTextColor(-1);
                break;
        }
    }

    private void mUpdaterCarSetInfoNum3Color(int data1, int data2, int data3, int data4, int data5, int data_value) {
        switch (data3) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-1);
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-1);
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-1);
                break;
            case 4:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-1);
                break;
            case 5:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.b70_car_set_num3_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num3_5)).setTextColor(-1);
                break;
        }
    }

    
    public void mUpdaterCarSetInfoNum1(int data1, int data2, int data3, int data4, int data5, int data_value) {
        initSetInfo();
        mUpdaterCarSetInfoValue(data1, data2, data3, data4, data5, data_value);
        switch (data1) {
            case 1:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("关闭", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("一级", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setText(String.format("二级", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setText(String.format("三级", new Object[0]));
                break;
            case 2:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("响度关", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("响度开", new Object[0]));
                break;
            case 3:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("提示音关", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("提示音开", new Object[0]));
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                break;
            case 4:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("EQ模式", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("声场", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setText(String.format("前后", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setText(String.format("左右", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_5)).setText(String.format("最佳听音位", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_6)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                mUpdaterCarSetInfoNum3SoundText(data1, data2, data3, data4, data5, data_value);
                break;
            case 5:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("小时设置", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("分钟设置", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setText(String.format("时间格式", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                mUpdaterCarSetInfoNum3TimeText(data1, data2, data3, data4, data5, data_value);
                break;
            case 6:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-65536);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("蓝牙匹配", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("电话音量", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_3)).setText(String.format("来电显示", new Object[0]));
                ((TextView) findViewById(R.id.b70_car_set_num2_4)).setText(String.format("返回", new Object[0]));
                mUpdaterCarSetInfoNum2Color(data1, data2, data3, data4, data5, data_value);
                mUpdaterCarSetInfoNum3BTText(data1, data2, data3, data4, data5, data_value);
                break;
            case 7:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-65536);
                break;
            default:
                ((TextView) findViewById(R.id.b70_car_set_num1_1)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_2)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_3)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_4)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_5)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_6)).setTextColor(-1);
                ((TextView) findViewById(R.id.b70_car_set_num1_7)).setTextColor(-1);
                break;
        }
    }

    private void initSetInfo() {
        ((TextView) findViewById(R.id.b70_car_set_num2_1)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num2_2)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num2_3)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num2_4)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num2_5)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num2_6)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num3_1)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num3_2)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num3_3)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num3_4)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num3_5)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num4_1)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num4_2)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num4_3)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num4_4)).setText(String.format("--", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_1)).setText(String.format("速度补偿", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_2)).setText(String.format("等响度", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_3)).setText(String.format("提示音", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_4)).setText(String.format("声音设置", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_5)).setText(String.format("时间设置", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_6)).setText(String.format("蓝牙设置", new Object[0]));
        ((TextView) findViewById(R.id.b70_car_set_num1_7)).setText(String.format("返回", new Object[0]));
    }
}
