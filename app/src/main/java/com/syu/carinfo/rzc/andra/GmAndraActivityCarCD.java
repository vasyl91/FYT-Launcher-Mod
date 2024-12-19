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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class GmAndraActivityCarCD extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.GmAndraActivityCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 132:
                    if (value == 1) {
                        ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text1)).setText("Powe: On");
                        break;
                    } else {
                        ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text1)).setText("Powe: Off");
                        break;
                    }
                case 133:
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
                case 135:
                    ((TextView) GmAndraActivityCarCD.this.findViewById(R.id.tv_text3)).setText(Callback_0061_RZC_XP1_GM.cdText);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_andra_carcd);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(98, new int[]{1}, null, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }
}
