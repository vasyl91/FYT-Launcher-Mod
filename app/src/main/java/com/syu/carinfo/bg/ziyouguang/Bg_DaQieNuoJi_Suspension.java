package com.syu.carinfo.bg.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bg_DaQieNuoJi_Suspension extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.bg.ziyouguang.Bg_DaQieNuoJi_Suspension.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    Bg_DaQieNuoJi_Suspension.this.updateAutoAdjustSuspension(value);
                    break;
                case 87:
                    Bg_DaQieNuoJi_Suspension.this.updateDisplaySuspensionInfo(value);
                    break;
                case 88:
                    Bg_DaQieNuoJi_Suspension.this.updateTireJacks(value);
                    break;
                case 89:
                    Bg_DaQieNuoJi_Suspension.this.updateTransportMode(value);
                    break;
                case 90:
                    Bg_DaQieNuoJi_Suspension.this.updateWheelAlignmentMode(value);
                    break;
            }
        }
    };
    int[] ids = {86, 87, 88, 89, 90};

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jeep_suspension);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mCanbusNotify);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoAdjustSuspension(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    protected void updateDisplaySuspensionInfo(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }

    protected void updateTireJacks(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
        }
    }

    protected void updateTransportMode(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
        }
    }

    protected void updateWheelAlignmentMode(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[86];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 65;
                iArr[1] = value == 1 ? 1 : 2;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value2 = DataCanbus.DATA[87];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 66;
                iArr2[1] = value2 == 1 ? 1 : 2;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value3 = DataCanbus.DATA[88];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 67;
                iArr3[1] = value3 == 1 ? 1 : 2;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value4 = DataCanbus.DATA[89];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 68;
                iArr4[1] = value4 == 1 ? 1 : 2;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value5 = DataCanbus.DATA[90];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 69;
                iArr5[1] = value5 == 1 ? 1 : 2;
                remoteModuleProxy5.cmd(1, iArr5, null, null);
                break;
        }
    }
}
