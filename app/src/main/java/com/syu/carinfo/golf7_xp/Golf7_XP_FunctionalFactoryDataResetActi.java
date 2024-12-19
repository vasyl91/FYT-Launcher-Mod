package com.syu.carinfo.golf7_xp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_FunctionalFactoryDataResetActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_factory_reset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_all_settings)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.all_settings, 199);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_driver_assistance)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.driver_assistance, 193);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_parking_and_Manoeurvring)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.parking_and_Manoeurvring, 194);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_light)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.light, 195);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_mirrors_and_wipers)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.mirrors_and_wipers, 196);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_opening_and_closing)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.opening_and_closing, 197);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_multifunction_display)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Golf7_XP_FunctionalFactoryDataResetActi.this.dialog(R.string.multifunction_display, 198);
            }
        });
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(107, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalFactoryDataResetActi.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
