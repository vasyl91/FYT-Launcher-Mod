package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_Guanzhi_CarinfoAct extends BaseActivity implements View.OnClickListener {
    int mileunit = 0;
    int oilunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    RZC_Guanzhi_CarinfoAct.this.mileunit = value;
                    break;
                case 115:
                    RZC_Guanzhi_CarinfoAct.this.oilunit = value;
                    break;
                case 121:
                    if (RZC_Guanzhi_CarinfoAct.this.mileunit == 1) {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 122:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    break;
                case 123:
                    switch (RZC_Guanzhi_CarinfoAct.this.oilunit) {
                        case 0:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                            break;
                        case 1:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 2:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                            break;
                    }
                case 124:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 125:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 126:
                    if (RZC_Guanzhi_CarinfoAct.this.mileunit == 1) {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
                        break;
                    } else {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 127:
                    switch (RZC_Guanzhi_CarinfoAct.this.oilunit) {
                        case 0:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                            break;
                        case 1:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 2:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_rzc_guanzhi_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        v.getId();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }
}
