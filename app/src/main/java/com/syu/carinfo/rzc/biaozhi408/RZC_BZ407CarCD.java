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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ407CarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static RZC_BZ407CarCD mInit;
    int rpt = 0;
    int INT = 0;
    int rand = 0;
    int value = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 199:
                case 206:
                    if (3 == DataCanbus.DATA[199]) {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[206]);
                        break;
                    } else {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("");
                        break;
                    }
                case 207:
                case 208:
                    int track = DataCanbus.DATA[207];
                    int Totaltrack = DataCanbus.DATA[208];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                    break;
                case 209:
                case 210:
                    int min = DataCanbus.DATA[209];
                    int sec = DataCanbus.DATA[210];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 211:
                    RZC_BZ407CarCD.this.UpdataRepeat();
                    break;
                case 212:
                    RZC_BZ407CarCD.this.UpdataScan();
                    break;
                case 213:
                    RZC_BZ407CarCD.this.UpdataRandom();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
        findViewById(R.id.tv_text4).setOnTouchListener(this);
        findViewById(R.id.tv_text5).setOnTouchListener(this);
        findViewById(R.id.tv_text6).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_text4 /* 2131427493 */:
                if (this.rpt == 1) {
                    this.rpt = 0;
                    break;
                } else {
                    this.rpt = 1;
                    break;
                }
            case R.id.tv_text5 /* 2131427497 */:
                if (this.INT == 1) {
                    this.INT = 0;
                    break;
                } else {
                    this.INT = 1;
                    break;
                }
            case R.id.tv_text6 /* 2131427502 */:
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
            sendCmd(DataCanbus.DATA[199], this.value);
        }
        return false;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(90, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[199] != 2 && DataCanbus.DATA[199] != 3) {
            sendCmd(2, this.value);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.notifyCanbus, 1);
        this.rpt = DataCanbus.DATA[211];
        this.INT = DataCanbus.DATA[212];
        this.rand = DataCanbus.DATA[213];
        this.value = ((this.rpt << 2) & 4) | ((this.INT << 1) & 2) | (this.rand & 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[213];
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
        int value = DataCanbus.DATA[212];
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
        int value = DataCanbus.DATA[211];
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
