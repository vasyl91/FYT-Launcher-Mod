package com.syu.carinfo.psa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class PsaC4LsettingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa.PsaC4LsettingActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    PsaC4LsettingActi.this.mUpdaterValue3();
                    break;
                case 112:
                    PsaC4LsettingActi.this.mUpdaterValue4();
                    break;
                case 113:
                    PsaC4LsettingActi.this.mUpdaterValue5();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psac4l_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.psac4l_parking_assist)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC4LsettingActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psac4l_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC4LsettingActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(4, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.psac4l_with_me_home_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC4LsettingActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.psac4l_with_me_home_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa.PsaC4LsettingActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value < 0) {
                    value = 0;
                } else if (value > 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.psac4l_parking_assist)) != null) {
            ((CheckedTextView) findViewById(R.id.psac4l_parking_assist)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.psac4l_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.psac4l_daytime_running_lights)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.psac4l_with_me_home_lighting)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.psac4l_with_me_home_lighting)).setText("15s");
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.psac4l_with_me_home_lighting)).setText("30s");
            } else if (value == 3) {
                ((TextView) findViewById(R.id.psac4l_with_me_home_lighting)).setText("60s");
            } else {
                ((TextView) findViewById(R.id.psac4l_with_me_home_lighting)).setText(R.string.off);
            }
        }
    }
}
