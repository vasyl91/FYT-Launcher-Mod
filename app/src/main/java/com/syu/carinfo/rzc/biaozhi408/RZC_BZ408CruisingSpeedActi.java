package com.syu.carinfo.rzc.biaozhi408;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408CruisingSpeedActi extends BaseActivity {
    private CheckedTextView mBtnCruisingFactory;
    private CheckedTextView mBtnCruisingSet;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_cruising_speed);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mBtnCruisingSet = (CheckedTextView) findViewById(R.id.rzc_bz408_cruising_speed_btn_cruising_speed_setting);
        this.mBtnCruisingSet.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408CruisingSpeedActi.this, RZC_BZ408CruisingSpeedSetActi.class);
                    RZC_BZ408CruisingSpeedActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mBtnCruisingFactory = (CheckedTextView) findViewById(R.id.rzc_bz408_cruising_speed_btn_factory_data_reset);
        this.mBtnCruisingFactory.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                RZC_BZ408CruisingSpeedActi.this.dialog();
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.factory_data_reset)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedActi.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedActi.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(50, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408CruisingSpeedActi.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}