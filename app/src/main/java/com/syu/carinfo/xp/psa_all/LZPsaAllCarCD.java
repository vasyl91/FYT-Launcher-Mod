package com.syu.carinfo.xp.psa_all;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZPsaAllCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZPsaAllCarCD mInit;
    int carid = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 122:
                case 132:
                    LZPsaAllCarCD.this.carid = DataCanbus.DATA[122];
                    if (3 == DataCanbus.DATA[122]) {
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[132]);
                        LZPsaAllCarCD.this.UpdataRepeat();
                        LZPsaAllCarCD.this.UpdataScan();
                        LZPsaAllCarCD.this.UpdataRandom();
                        break;
                    } else {
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text1)).setText("Car CD");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text4)).setText("");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text5)).setText("");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text6)).setText("");
                        break;
                    }
                case 128:
                case 129:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int track = DataCanbus.DATA[128];
                        int Totaltrack = DataCanbus.DATA[129];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                        break;
                    }
                case 130:
                case 131:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int min = DataCanbus.DATA[130];
                        int sec = DataCanbus.DATA[131];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                        break;
                    }
                case 133:
                case 134:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int track2 = DataCanbus.DATA[133];
                        int Totaltrack2 = DataCanbus.DATA[134];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track2 + "/" + Totaltrack2);
                        break;
                    }
                case 135:
                case 136:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int min2 = DataCanbus.DATA[135];
                        int sec2 = DataCanbus.DATA[136];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min2 / 10) + (min2 % 10) + ":" + (sec2 / 10) + (sec2 % 10));
                        break;
                    }
                case 137:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRepeat();
                        break;
                    }
                case 138:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataScan();
                        break;
                    }
                case 139:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRandom();
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[139];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText("Random: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText("Random: On");
                break;
        }
    }

    public void UpdataScan() {
        int value = DataCanbus.DATA[138];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText("Scan: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText("Scan: On");
                break;
        }
    }

    public void UpdataRepeat() {
        int value = DataCanbus.DATA[137];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: On");
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
