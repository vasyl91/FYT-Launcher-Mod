package com.syu.carinfo.biaozhi408;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XpPsa301settingActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    XpPsa301settingActi.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa301_setting_xp);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.psa301_parking_assist_xp)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                XpPsa301settingActi.this.dialog();
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.psa301_parking_assist_xp)) != null) {
            ((CheckedTextView) findViewById(R.id.psa301_parking_assist_xp)).setChecked(value != 0);
        }
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(13, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
