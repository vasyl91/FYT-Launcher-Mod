package com.syu.carinfo.wc.infeinidi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WcInfinitCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    WcInfinitCarInfo.this.mUpdateTx1(value);
                    break;
                case 100:
                    WcInfinitCarInfo.this.mUpdateTx2(value);
                    break;
                case 101:
                    WcInfinitCarInfo.this.mUpdateTx3(value);
                    break;
                case 102:
                    WcInfinitCarInfo.this.mUpdateTx4(value);
                    break;
                case 103:
                    WcInfinitCarInfo.this.mUpdateTx5(value);
                    break;
                case 104:
                    WcInfinitCarInfo.this.mUpdateTx6(value);
                    break;
                case 105:
                    WcInfinitCarInfo.this.mUpdateTx7(value);
                    break;
                case 106:
                    WcInfinitCarInfo.this.mUpdateTx8(value);
                    break;
                case 107:
                    WcInfinitCarInfo.this.mUpdateTx9(value);
                    break;
                case 108:
                    WcInfinitCarInfo.this.mUpdateTx10(value);
                    break;
                case 109:
                    WcInfinitCarInfo.this.mUpdateTx11(value);
                    break;
                case 110:
                    WcInfinitCarInfo.this.mUpdateTx12(value);
                    break;
                case 111:
                    WcInfinitCarInfo.this.mUpdateTx13(value);
                    break;
                case 112:
                    WcInfinitCarInfo.this.mUpdateTx14(value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_infeinidi_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                showResetDlg();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void showResetDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.bmw_cleanoil)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 1, 255, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(2, new int[]{12, 0, 255, 255}, null, null);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdateTx14(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text14)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx13(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text13)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx12(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text12)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx11(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text11)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx10(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text10)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx9(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text9)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx8(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text8)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx7(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text7)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx6(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text6)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx5(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text5)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx4(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
        }
    }

    
    public void mUpdateTx3(int value) {
        if (value == 16777215) {
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
        }
    }

    
    public void mUpdateTx2(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text2)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }

    
    public void mUpdateTx1(int value) {
        if (value == 65535) {
            ((TextView) findViewById(R.id.tv_text1)).setText("--.--");
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
        }
    }
}
