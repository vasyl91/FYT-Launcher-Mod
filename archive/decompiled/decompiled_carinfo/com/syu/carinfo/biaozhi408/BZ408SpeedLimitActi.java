package com.syu.carinfo.biaozhi408;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BZ408SpeedLimitActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    BZ408SpeedLimitActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi408_speed_limit);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_btn_speed_limit)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(16, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_btn_speed_limit_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(BZ408SpeedLimitActi.this, BZ408SpeedLimitSetActi.class);
                    BZ408SpeedLimitActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.bz408_speed_limit_btn_factory_data_reset)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                BZ408SpeedLimitActi.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.factory_data_reset)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(50, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185 || DataCanbus.DATA[1000] == 65817 || DataCanbus.DATA[1000] == 262425 || DataCanbus.DATA[1000] == 281) {
            DataCanbus.PROXY.cmd(53, new int[]{61}, null, null);
            findViewById(R.id.bz408_speed_limit_view_speed_limit).setVisibility(8);
            findViewById(R.id.bz408_speed_limit_view_factory_data_reset).setVisibility(0);
        } else {
            findViewById(R.id.bz408_speed_limit_view_speed_limit).setVisibility(0);
            findViewById(R.id.bz408_speed_limit_view_factory_data_reset).setVisibility(8);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[132];
        if (((CheckedTextView) findViewById(R.id.bz408_speed_limit_btn_speed_limit)) != null) {
            ((CheckedTextView) findViewById(R.id.bz408_speed_limit_btn_speed_limit)).setChecked(value != 0);
        }
    }
}
