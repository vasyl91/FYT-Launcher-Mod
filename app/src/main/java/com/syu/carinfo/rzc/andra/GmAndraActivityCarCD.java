package com.syu.carinfo.rzc.andra;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0061_RZC_XP1_GM;
import com.syu.module.canbus.DataCanbus;

public class GmAndraActivityCarCD extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 193:
                    if (value == 1) {
                        ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text1)).setText("Powe: On");
                        break;
                    } else {
                        ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text1)).setText("Powe: Off");
                        break;
                    }
                case 194:
                    switch (value) {
                        case 1:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("BC");
                            break;
                        case 2:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Setting");
                            break;
                        case 3:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Sound");
                            break;
                        case 4:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Stations");
                            break;
                        case 5:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Store");
                            break;
                        case 6:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Track");
                            break;
                        case 7:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("Extras");
                            break;
                        default:
                            ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text2)).setText("");
                            break;
                    }
                case 196:
                    ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text3)).setText(Callback_0061_RZC_XP1_GM.cdText);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_andra_carcd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(98, new int[]{1}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
    }
}
