package com.syu.carinfo.rzc.keleijia;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class KeleiaoCarCD extends Activity implements View.OnTouchListener {
    public static KeleiaoCarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 157:
                    int value = DataCanbus.DATA[updateCode] & 127;
                    if (((DataCanbus.DATA[updateCode] >> 7) & 1) == 1) {
                        ((TextView) KeleiaoCarCD.this.findViewById(R.id.cd_title)).setText("Car Vol: " + (value / 16) + (value % 16));
                        break;
                    } else {
                        ((TextView) KeleiaoCarCD.this.findViewById(R.id.cd_title)).setText("");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0402_keleiao_carcd);
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }
}
