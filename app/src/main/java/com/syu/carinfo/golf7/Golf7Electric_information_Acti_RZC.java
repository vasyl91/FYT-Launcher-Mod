package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7Electric_information_Acti_RZC extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 365:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 366:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 370:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "/100");
                    break;
                case 371:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 372:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "km");
                    break;
                case 373:
                    ((TextView) Golf7Electric_information_Acti_RZC.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0160_rzc_mqb_electric_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[365].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[366].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[367].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[368].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[369].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[370].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[373].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[365].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[366].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[367].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[368].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[369].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[370].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[373].removeNotify(this.mNotifyCanbus);
    }
}
