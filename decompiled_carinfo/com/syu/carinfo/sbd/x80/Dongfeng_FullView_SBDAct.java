package com.syu.carinfo.sbd.x80;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Dongfeng_FullView_SBDAct extends BaseActivity implements View.OnClickListener {
    private int f;
    private int l;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 40:
                    Dongfeng_FullView_SBDAct.this.uLeft(val);
                    break;
                case 41:
                    Dongfeng_FullView_SBDAct.this.yRight(val);
                    break;
                case 42:
                    Dongfeng_FullView_SBDAct.this.uSteer(val);
                    break;
                case 43:
                    Dongfeng_FullView_SBDAct.this.uForward(val);
                    break;
                case 44:
                    Dongfeng_FullView_SBDAct.this.uAnimate(val);
                    break;
            }
        }
    };
    private int r;
    private int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_sbd_dongfeng_fullview_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
    }

    
    public void uLeft(int val) {
        this.l = val;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(val == 1);
        }
    }

    
    public void yRight(int val) {
        this.r = val;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(val != 0);
        }
    }

    
    public void uForward(int val) {
        this.f = val;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
        }
    }

    
    public void uAnimate(int val) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(val != 0);
        }
    }

    
    public void uSteer(int val) {
        this.s = val;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(val != 0);
        }
    }

    @Override
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 40;
                iArr[1] = DataCanbus.DATA[44] != 1 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                this.l = this.l != 0 ? 0 : 1;
                sendCMD();
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                this.r = this.r != 0 ? 0 : 1;
                sendCMD();
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                this.s = this.s != 0 ? 0 : 1;
                sendCMD();
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                this.f = this.f != 0 ? 0 : 1;
                sendCMD();
                break;
        }
    }

    private void sendCMD() {
        int value = this.l == 1 ? 1 : 0;
        DataCanbus.PROXY.cmd(1, new int[]{39, value | (this.r == 1 ? 2 : 0) | (this.s == 1 ? 4 : 0) | (this.f == 1 ? 8 : 0)}, null, null);
    }
}
