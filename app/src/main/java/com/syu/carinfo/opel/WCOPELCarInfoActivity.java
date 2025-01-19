package com.syu.carinfo.opel;

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

public class WCOPELCarInfoActivity extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    if (value == 65535) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + "  L/100km");
                        break;
                    }
                case 102:
                    if (value == 65535) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "  km");
                        break;
                    }
                case 103:
                    if (value == 65535) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "  km");
                        break;
                    }
                case 104:
                    if (value == 65535) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + "  L");
                        break;
                    }
                case 105:
                    if (value == 255) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + "  km/h");
                        break;
                    }
                case 106:
                    if (value == 65535) {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else {
                        ((TextView) WCOPELCarInfoActivity.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "  L/100km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_opel_old_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog(R.string.str_bogoo_bmw_car_computer_log, 6);
                break;
        }
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
                        DataCanbus.PROXY.cmd(1, new int[]{i}, null, null);
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
