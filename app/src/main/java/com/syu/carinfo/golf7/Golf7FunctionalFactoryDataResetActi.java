package com.syu.carinfo.golf7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalFactoryDataResetActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            //setContentView(R.layout.layout_golf7_functional_state_factory_reset_od);
        } else {
            //setContentView(R.layout.layout_golf7_functional_state_factory_reset);
        }
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((Button) findViewById(R.id.glf7_btn_car_back_od)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7FunctionalFactoryDataResetActi.this, Golf7FunctionalActiOD.class);
                        Golf7FunctionalFactoryDataResetActi.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_all_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.all_settings, 31);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_driver_assistance)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.driver_assistance, 32);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_parking_and_Manoeurvring)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.parking_and_Manoeurvring, 33);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_light)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.light, 34);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_mirrors_and_wipers)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.mirrors_and_wipers, 35);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_opening_and_closing)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.opening_and_closing, 36);
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_functional_factory_multifunction_display)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.multifunction_display, 37);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog2(R.string.door_background_lighting, 207);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog2(R.string.str_electric_driving_charging, 202);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Golf7FunctionalFactoryDataResetActi.this.dialog2(R.string.wc_gs4_seat_set, 206);
            }
        });
        if (DataCanbus.DATA[1000] != 655520 && DataCanbus.DATA[1000] != 3801248) {
            findViewById(R.id.layout_text_view2).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            ((CheckedTextView) findViewById(R.id.glf7_btn_functional_cartime_set)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    Golf7FunctionalFactoryDataResetActi.this.dialog(R.string.str_cartime_sync, 140);
                }
            });
        }
    }

    protected void dialog2(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(160, new int[]{i, 1}, null, null);
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

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{1}, null, null);
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
}
