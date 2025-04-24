package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0255_RZC_XP1_FengShenAX7;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCFengshenEX1CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    int value2 = value - 80;
                    if (value2 >= 0) {
                        ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text1)).setText("电池->车轮  " + value2 + "kw");
                        break;
                    } else {
                        ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text1)).setText("车轮->电池  " + value2 + "kw");
                        break;
                    }
                case 148:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "kw");
                    break;
                case 149:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kwh/100km");
                    break;
                case 150:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "km");
                    break;
                case 151:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    break;
                case 152:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                    break;
                case 153:
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 154:
                    String[] str = new String[31];
                    for (int i = 0; i < 31; i++) {
                        str[i] = "20" + (Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][0] / 10) + (Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][0] % 10);
                        str[i] = String.valueOf(str[i]) + "." + Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][1];
                        str[i] = String.valueOf(str[i]) + "." + Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][2];
                        str[i] = String.valueOf(str[i]) + "." + Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][3];
                        str[i] = String.valueOf(str[i]) + "." + Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][4];
                        str[i] = String.valueOf(str[i]) + " - 节能等级 " + Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][5];
                        int mile = ((Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][6] << 8) & 65280) | (Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][7] & 255);
                        str[i] = String.valueOf(str[i]) + " - 里程 " + (mile / 10) + "." + (mile % 10) + "km";
                        int en = ((Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][8] << 8) & 65280) | (Callback_0255_RZC_XP1_FengShenAX7.LIST_EX1_EN[i][9] & 255);
                        str[i] = String.valueOf(str[i]) + " - 能耗" + (en / 10) + "." + (en % 10) + "kwh/100km";
                    }
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text8)).setText(str[0]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text9)).setText(str[1]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text10)).setText(str[2]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text11)).setText(str[3]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text12)).setText(str[4]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text13)).setText(str[5]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text14)).setText(str[6]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text15)).setText(str[7]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text16)).setText(str[8]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text17)).setText(str[9]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text18)).setText(str[10]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text19)).setText(str[11]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text20)).setText(str[12]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text21)).setText(str[13]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text22)).setText(str[14]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text23)).setText(str[15]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text24)).setText(str[16]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text25)).setText(str[17]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text26)).setText(str[18]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text27)).setText(str[19]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text28)).setText(str[20]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text29)).setText(str[21]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text30)).setText(str[22]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text31)).setText(str[23]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text32)).setText(str[24]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text33)).setText(str[25]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text34)).setText(str[26]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text35)).setText(str[27]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text36)).setText(str[28]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text37)).setText(str[29]);
                    ((TextView) RZCFengshenEX1CarInfo.this.findViewById(R.id.tv_text38)).setText(str[30]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0255_rzc_fengshen_ex1_carinfo);
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
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
