package com.syu.carinfo.xincheng.infiniti;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Infiniti_XinCheng_CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    Infiniti_XinCheng_CarInfo.this.updateCarinfo1();
                    break;
                case 106:
                    Infiniti_XinCheng_CarInfo.this.updateCarinfo2();
                    break;
                case 107:
                    Infiniti_XinCheng_CarInfo.this.updateCarinfo3();
                    break;
                case 108:
                case 109:
                    Infiniti_XinCheng_CarInfo.this.updateCarinfo4();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xincheng_infiniti_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{113}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCarinfo4() {
        int value = DataCanbus.DATA[108];
        int unit = DataCanbus.DATA[109];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
        switch (unit) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/H");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                break;
        }
    }

    
    public void updateCarinfo3() {
        int value = DataCanbus.DATA[107];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
        }
    }

    
    public void updateCarinfo2() {
        int value = DataCanbus.DATA[106];
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void updateCarinfo1() {
        int value = DataCanbus.DATA[105];
        if (value > 2000) {
            ((TextView) findViewById(R.id.tv_text1)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
        }
    }
}
