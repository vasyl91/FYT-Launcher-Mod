package com.syu.carinfo.wc.jingyix5;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JYCarLockSet extends BaseActivity implements View.OnClickListener {
    static int[] strIds = {R.string.klc_Parking_with_trailer_Off, R.string.klc_Parking_with_trailer_ON};
    int id66d0b0;
    int id66d0b1;
    int[] eventIds = {87, 88};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.jingyix5.JYCarLockSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 87:
                    JYCarLockSet.this.u_66d0b1(updateCode);
                    break;
                case 88:
                    JYCarLockSet.this.u_66d0b0(updateCode);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_wc_jyx5_lock);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_speed_lock)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_auto_relock)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_speed_lock /* 2131433090 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 2;
                iArr[1] = this.id66d0b1 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(0, iArr, null, null);
                break;
            case R.id.ctv_auto_relock /* 2131433093 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 1;
                iArr2[1] = this.id66d0b0 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(0, iArr2, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void u_66d0b1(int updateCode) {
        this.id66d0b1 = DataCanbus.DATA[updateCode];
        if (findViewById(R.id.ctv_speed_lock_view) != null) {
            findViewById(R.id.ctv_speed_lock_view).setVisibility(((this.id66d0b1 >> 4) & 1) == 0 ? 8 : 0);
        }
        this.id66d0b1 = DataCanbus.DATA[updateCode] & 15;
        if (((CheckedTextView) findViewById(R.id.ctv_speed_lock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_speed_lock)).setChecked((this.id66d0b1 & 1) != 0);
        }
        if (((TextView) findViewById(R.id.ctv_speed_lock_dec)) != null) {
            ((TextView) findViewById(R.id.ctv_speed_lock_dec)).setText(strIds[this.id66d0b1 & 1]);
        }
    }

    protected void u_66d0b0(int updateCode) {
        this.id66d0b0 = DataCanbus.DATA[updateCode];
        if (findViewById(R.id.ctv_auto_relock_view) != null) {
            findViewById(R.id.ctv_auto_relock_view).setVisibility(((this.id66d0b0 >> 4) & 1) == 0 ? 8 : 0);
        }
        this.id66d0b0 = DataCanbus.DATA[updateCode] & 15;
        if (((CheckedTextView) findViewById(R.id.ctv_auto_relock)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_auto_relock)).setChecked((this.id66d0b0 & 1) != 0);
        }
        if (((TextView) findViewById(R.id.ctv_auto_relock_dec)) != null) {
            ((TextView) findViewById(R.id.ctv_auto_relock_dec)).setText(strIds[this.id66d0b0 & 1]);
        }
    }
}
