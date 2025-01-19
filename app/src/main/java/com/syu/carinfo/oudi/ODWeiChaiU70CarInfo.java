package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODWeiChaiU70CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    ODWeiChaiU70CarInfo.this.updateCarinfo1();
                    break;
                case 105:
                    ODWeiChaiU70CarInfo.this.updateCarinfo2();
                    break;
                case 106:
                    ODWeiChaiU70CarInfo.this.updateCarinfo3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_weichai_carinfo);
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
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[102];
        if ((value & 128) != 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText("-" + (255 - value) + " ℃");
            return;
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " ℃");
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[105];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[106];
        ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
    }
}
