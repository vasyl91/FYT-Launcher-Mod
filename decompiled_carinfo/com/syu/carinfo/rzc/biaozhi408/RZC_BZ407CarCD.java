package com.syu.carinfo.rzc.biaozhi408;

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
public class RZC_BZ407CarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static RZC_BZ407CarCD mInit;
    int rpt = 0;
    int INT = 0;
    int rand = 0;
    int value = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 210:
                case 217:
                    if (3 == DataCanbus.DATA[210]) {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[217]);
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("");
                        break;
                    }
                case 218:
                case 219:
                    int track = DataCanbus.DATA[218];
                    int Totaltrack = DataCanbus.DATA[219];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                    break;
                case 220:
                case 221:
                    int min = DataCanbus.DATA[220];
                    int sec = DataCanbus.DATA[221];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 222:
                    RZC_BZ407CarCD.this.UpdataRepeat();
                    break;
                case 223:
                    RZC_BZ407CarCD.this.UpdataScan();
                    break;
                case 224:
                    RZC_BZ407CarCD.this.UpdataRandom();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
        findViewById(R.id.tv_text4).setOnTouchListener(this);
        findViewById(R.id.tv_text5).setOnTouchListener(this);
        findViewById(R.id.tv_text6).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_text4 /* 2131427465 */:
                if (this.rpt == 1) {
                    this.rpt = 0;
                    break;
                } else {
                    this.rpt = 1;
                    break;
                }
            case R.id.tv_text5 /* 2131427468 */:
                if (this.INT == 1) {
                    this.INT = 0;
                    break;
                } else {
                    this.INT = 1;
                    break;
                }
            case R.id.tv_text6 /* 2131427471 */:
                if (this.rand == 1) {
                    this.rand = 0;
                    break;
                } else {
                    this.rand = 1;
                    break;
                }
        }
        this.value = ((this.rpt << 2) & 4) | ((this.INT << 1) & 2) | (this.rand & 1);
        if (event.getAction() == 0) {
            sendCmd(DataCanbus.DATA[210], this.value);
        }
        return false;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(90, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[210] != 2 && DataCanbus.DATA[210] != 3) {
            sendCmd(2, this.value);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.notifyCanbus, 1);
        this.rpt = DataCanbus.DATA[222];
        this.INT = DataCanbus.DATA[223];
        this.rand = DataCanbus.DATA[224];
        this.value = ((this.rpt << 2) & 4) | ((this.INT << 1) & 2) | (this.rand & 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[224];
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
        int value = DataCanbus.DATA[223];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText("INT: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText("INT: On");
                break;
        }
    }

    public void UpdataRepeat() {
        int value = DataCanbus.DATA[222];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: On");
                break;
        }
    }
}
