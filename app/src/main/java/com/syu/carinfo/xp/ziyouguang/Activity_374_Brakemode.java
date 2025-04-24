package com.syu.carinfo.xp.ziyouguang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_374_Brakemode extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 145:
                    Activity_374_Brakemode.this.setCheck((CheckedTextView) Activity_374_Brakemode.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 146:
                    Activity_374_Brakemode.this.setCheck((CheckedTextView) Activity_374_Brakemode.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 223:
                    if (((TextView) Activity_374_Brakemode.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) Activity_374_Brakemode.this.findViewById(R.id.tv_text1)).setText("Store");
                                break;
                            default:
                                ((TextView) Activity_374_Brakemode.this.findViewById(R.id.tv_text1)).setText("Auto");
                                break;
                        }
                    }
                    break;
                case 371:
                    Activity_374_Brakemode.this.setCheck((CheckedTextView) Activity_374_Brakemode.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_brakemode);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Activity_374_Brakemode.this.dialog("Would you like to retract park brake to allow for brake system service", 192);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[145];
                if (value != 1 && value == 0) {
                }
                DataCanbus.PROXY.cmd(0, new int[]{192, 1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[146];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{193, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[371];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{191, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[223];
                if (value - 1 < 0) {
                }
                DataCanbus.PROXY.cmd(0, new int[]{196, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[223];
                if (value + 1 > 1) {
                }
                DataCanbus.PROXY.cmd(0, new int[]{196, 1}, null, null);
            }
        });
        if (DataCanbus.DATA[1000] == 1376630 || DataCanbus.DATA[1000] == 1442166 || DataCanbus.DATA[1000] == 1507702 || DataCanbus.DATA[1000] == 1573238 || DataCanbus.DATA[1000] == 1638774 || DataCanbus.DATA[1000] == 1704310 || DataCanbus.DATA[1000] == 2621814 || DataCanbus.DATA[1000] == 2687350 || DataCanbus.DATA[1000] == 2752886 || DataCanbus.DATA[1000] == 2818422 || DataCanbus.DATA[1000] == 1835382 || DataCanbus.DATA[1000] == 1900918 || DataCanbus.DATA[1000] == 2097526 || DataCanbus.DATA[1000] == 2163062 || DataCanbus.DATA[1000] == 5177718 || DataCanbus.DATA[1000] == 5243254 || DataCanbus.DATA[1000] == 5308790 || DataCanbus.DATA[1000] == 5374326 || DataCanbus.DATA[1000] == 5439862) {
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            return;
        }
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    protected void dialog(String stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(stringId);
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
    }
}
