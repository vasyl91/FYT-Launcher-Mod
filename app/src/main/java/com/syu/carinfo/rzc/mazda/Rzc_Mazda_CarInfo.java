package com.syu.carinfo.rzc.mazda;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rzc_Mazda_CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 44:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 45:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 46:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 47:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 48:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 49:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 50:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 51:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text22)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 52:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text21)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text21)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 53:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text20)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text20)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 54:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text19)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text19)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 55:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text18)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text18)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 56:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text17)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text17)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 57:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text16)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text16)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 58:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text15)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 59:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text14)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 60:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text13)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 61:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text12)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 62:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text11)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 63:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 64:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 65:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 66:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text23)).setText("运行中");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text23)).setText("未运行");
                        break;
                    }
                case 67:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text24)).setText("未准备好");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text24)).setText("准备好");
                        break;
                    }
                case 68:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text25)).setText("未就绪");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text25)).setText("就绪");
                        break;
                    }
                case 69:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text26)).setText("未就绪");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text26)).setText("就绪");
                        break;
                    }
                case 70:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text27)).setText("未就绪");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text27)).setText("就绪");
                        break;
                    }
                case 71:
                    switch (value) {
                        case 0:
                            ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text28)).setText("无");
                            break;
                        case 1:
                            ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text28)).setText("i-stop不可用");
                            break;
                        case 2:
                            ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text28)).setText("请应用更多的制动压力");
                            break;
                        case 3:
                            ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text28)).setText("请转换到空挡");
                            break;
                        case 4:
                            ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text28)).setText("无法激活，请将方向盘转到中心");
                            break;
                    }
                case 72:
                    ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text29)).setText(String.valueOf(value / 60) + "m" + (value % 60) + "s");
                    break;
                case 73:
                    ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text30)).setText(String.valueOf(value / 60) + "m" + (value % 60) + "s");
                    break;
                case 74:
                    ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text31)).setText(String.valueOf(value) + "%");
                    break;
                case 75:
                    ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text32)).setText(String.valueOf(value / 10.0f) + " km");
                    break;
                case 76:
                    ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text33)).setText(String.valueOf(value / 60) + "m" + (value % 60) + "s");
                    break;
                case 77:
                    if (value == 0) {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text34)).setText("----");
                        break;
                    } else {
                        ((TextView) Rzc_Mazda_CarInfo.this.findViewById(R.id.tv_text34)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_mazda_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{81}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{82}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
    }
}
