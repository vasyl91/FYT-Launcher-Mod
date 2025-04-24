package com.syu.carinfo.rzc.yingfeinidi_gx50;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Rzc_Infiniti_CarinfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                case 107:
                    int unit = DataCanbus.DATA[104];
                    int value = DataCanbus.DATA[107];
                    switch (unit) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " miles");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                            break;
                    }
                case 105:
                case 106:
                    int unit2 = DataCanbus.DATA[105];
                    int value2 = DataCanbus.DATA[106];
                    switch (unit2) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + " miles");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + " km");
                            break;
                    }
                case 108:
                case 110:
                    int unit3 = DataCanbus.DATA[108];
                    int value3 = DataCanbus.DATA[110];
                    switch (unit3) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " l/100km");
                            break;
                        case 2:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " km/l");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " mpg");
                            break;
                    }
                case 109:
                case 111:
                    int unit4 = DataCanbus.DATA[109];
                    int value4 = DataCanbus.DATA[111];
                    switch (unit4) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " l/100km");
                            break;
                        case 2:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " km/l");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " mpg");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_infiniti_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{39}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{41}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
    }
}
