package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODZhongtaiE200CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 100:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "A");
                    break;
                case 101:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 102:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    break;
                case 103:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "rpm");
                    break;
                case 104:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "KW");
                    break;
                case 105:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 106:
                    ((TextView) ODZhongtaiE200CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value - 40) + "℃");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_od_zhongtai_e200_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
