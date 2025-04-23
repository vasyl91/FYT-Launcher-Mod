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

public class LZPsaAllCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZPsaAllCarCD mInit;
    int carid = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 188:
                case 198:
                    LZPsaAllCarCD.this.carid = DataCanbus.DATA[188];
                    if (3 == DataCanbus.DATA[188]) {
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[198]);
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
                case 194:
                case 195:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int track = DataCanbus.DATA[194];
                        int Totaltrack = DataCanbus.DATA[195];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                        break;
                    }
                case 196:
                case 197:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int min = DataCanbus.DATA[196];
                        int sec = DataCanbus.DATA[197];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                        break;
                    }
                case 199:
                case 200:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int track2 = DataCanbus.DATA[199];
                        int Totaltrack2 = DataCanbus.DATA[200];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track2 + "/" + Totaltrack2);
                        break;
                    }
                case 201:
                case 202:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int min2 = DataCanbus.DATA[201];
                        int sec2 = DataCanbus.DATA[202];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min2 / 10) + (min2 % 10) + ":" + (sec2 / 10) + (sec2 % 10));
                        break;
                    }
                case 203:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRepeat();
                        break;
                    }
                case 204:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataScan();
                        break;
                    }
                case 205:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRandom();
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[205];
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
        int value = DataCanbus.DATA[204];
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
        int value = DataCanbus.DATA[203];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: On");
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
