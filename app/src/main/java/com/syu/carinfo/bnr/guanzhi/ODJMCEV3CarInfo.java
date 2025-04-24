package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ODJMCEV3CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 128:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 129:
                case 130:
                    int msb = DataCanbus.DATA[129];
                    int lsb = DataCanbus.DATA[130];
                    int value2 = ((msb << 8) & 65280) | (lsb & 255);
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value2 / 1000) + "." + ((value2 % 1000) / 100) + ((value2 % 100) / 10) + (value2 % 10) + " V");
                    break;
                case 131:
                case 132:
                    int msb2 = DataCanbus.DATA[131];
                    int lsb2 = DataCanbus.DATA[132];
                    int value3 = ((msb2 << 8) & 65280) | (lsb2 & 255);
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value3 / 1000) + "." + ((value3 % 1000) / 100) + ((value3 % 100) / 10) + (value3 % 10) + " V");
                    break;
                case 133:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 134:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 135:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 136:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 137:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 138:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 139:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
                case 140:
                    switch (value) {
                        case 1:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("放电中");
                            break;
                        case 2:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("快充中");
                            break;
                        case 3:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("慢充中");
                            break;
                        default:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("----");
                            break;
                    }
                case 141:
                    switch (value) {
                        case 1:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("停车充电");
                            break;
                        case 2:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("行驶充电");
                            break;
                        case 3:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("未充电");
                            break;
                        case 4:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("充电完成");
                            break;
                        default:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("----");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_jmc_ev3_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{39, 1}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{39, 2}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{39, 3}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }
}
