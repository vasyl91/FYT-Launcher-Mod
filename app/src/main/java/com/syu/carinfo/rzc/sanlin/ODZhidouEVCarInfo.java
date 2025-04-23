package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODZhidouEVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    break;
                case 8:
                    if ((value & 128) != 0) {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text2)).setText("-" + (255 - value) + "℃");
                        break;
                    } else {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "℃");
                        break;
                    }
                case 9:
                    ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "V");
                    break;
                case 10:
                    ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "A");
                    break;
                case 11:
                    if ((value & 128) != 0) {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text5)).setText("-" + (255 - value) + "℃");
                        break;
                    } else {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "℃");
                        break;
                    }
                case 12:
                    ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "V");
                    break;
                case 13:
                    if (value == 1) {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text7)).setText("异常");
                        break;
                    } else {
                        ((TextView) ODZhidouEVCarInfo.this.findViewById(R.id.tv_text7)).setText("正常");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_zhidou_ev_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{49}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
    }
}
