package com.syu.carinfo.honda;

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
public class Wc_16Civic_FunctionalActi extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_321_civic_functional_state);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_LightActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_RemoteActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_DoorActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_SaftyActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, Wc_16Civic_Pannel.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_FunctionalActi.this.dialog(R.string.str_321_tireclean, 108);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_FunctionalActi.this.dialog(R.string.str_321_repair_reset, 105);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Wc_16Civic_FunctionalActi.this.dialog(R.string.rzc_klc_default_set_str, 105);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, WCCommpassActi.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Wc_16Civic_FunctionalActi.this, ActivityBatteryDoor.class);
                    Wc_16Civic_FunctionalActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void dialog(final int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = stringId;
                final int i2 = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i == 2131298952) {
                            DataCanbus.PROXY.cmd(i2, new int[]{6, 1}, null, null);
                        } else if (i == 2131297427) {
                            DataCanbus.PROXY.cmd(i2, new int[]{5, 1}, null, null);
                        } else {
                            DataCanbus.PROXY.cmd(i2, new int[]{1}, null, null);
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Wc_16Civic_FunctionalActi.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (stringId == 2131298347) {
                    DataCanbus.PROXY.cmd(cmd, new int[1], null, null);
                }
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 328001 || DataCanbus.DATA[1000] == 393537 || DataCanbus.DATA[1000] == 1179969 || DataCanbus.DATA[1000] == 1245505 || DataCanbus.DATA[1000] == 1311041 || DataCanbus.DATA[1000] == 524609 || DataCanbus.DATA[1000] == 590145 || DataCanbus.DATA[1000] == 459073) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }
}
