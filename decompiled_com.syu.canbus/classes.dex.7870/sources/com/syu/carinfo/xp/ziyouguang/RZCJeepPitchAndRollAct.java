package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZCJeepPitchAndRollAct extends Activity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.RZCJeepPitchAndRollAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 266:
                    if (value >= 254) {
                        ((PaJeepRollView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(0);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText("--");
                    } else if (value >= 90) {
                        int value2 = value - 90;
                        ((PaJeepRollView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value2);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value2) + "°");
                    } else {
                        int value3 = value - 90;
                        ((PaJeepRollView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_roll)).setSpeed(value3);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text5)).setText("-" + value3 + "°");
                    }
                    break;
                case 267:
                    if (value >= 254) {
                        ((PaJeepPitchView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(0);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText("--");
                    } else if (value >= 90) {
                        int value4 = value - 90;
                        ((PaJeepPitchView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value4);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value4) + "°");
                    } else {
                        int value5 = value - 90;
                        ((PaJeepPitchView) RZCJeepPitchAndRollAct.this.findViewById(R.id.infoView_pitch)).setSpeed(value5);
                        ((TextView) RZCJeepPitchAndRollAct.this.findViewById(R.id.tv_text4)).setText("-" + value5 + "°");
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_pitch_roll);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{52}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
    }
}
