package com.syu.carinfo.xbs.yage8;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCYage8CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 140:
                    ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "L/100kw");
                    break;
                case 141:
                    if (value == 65535) {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100kw");
                        break;
                    }
                case 142:
                    if (value == 65535) {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "L/100kw");
                        break;
                    }
                case 143:
                case 144:
                    int hour = DataCanbus.DATA[143];
                    int min = DataCanbus.DATA[144];
                    ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf((hour / 10) + (hour % 10)) + ":" + (min / 10) + (min % 10));
                    break;
                case 145:
                    if (value == 255) {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 146:
                    if (value == 65535) {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 147:
                    if (value == 16777215) {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        ((TextView) WCYage8CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_wc_yage8_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
    }
}
