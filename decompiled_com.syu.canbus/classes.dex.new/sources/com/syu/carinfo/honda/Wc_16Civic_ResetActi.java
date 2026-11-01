package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Wc_16Civic_ResetActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_reset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog(Wc_16Civic_ResetActi.this.getResources().getString(R.string.maintenance_information), 1);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Oil and Filter", 1);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Chassic Inspection", 3);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("TireRotation", 4);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Dust And Pollen Filter", 5);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Transmission Oil", 6);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Spark Plugs", 7);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Engine Collant", 8);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Brake Fulid", 10);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_ResetActi.this.dialog("Air Cleaner Element", 11);
            }
        });
    }

    protected void dialog(final String stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + stringId + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final String str = stringId;
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (str.equals(Wc_16Civic_ResetActi.this.getResources().getString(R.string.maintenance_information))) {
                            DataCanbus.PROXY.cmd(105, new int[]{6, 1}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(105, new int[]{12, i}, null, null);
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_ResetActi.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
    }
}
