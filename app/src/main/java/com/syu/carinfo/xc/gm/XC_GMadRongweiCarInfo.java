package com.syu.carinfo.xc.gm;

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

public class XC_GMadRongweiCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    if (value == 65535) {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100km");
                        break;
                    }
                case 136:
                    ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10.0f) + " Krpm");
                    break;
                case 137:
                    ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                    break;
                case 138:
                    if (value == 65535) {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10.0f) + " KWh/100km");
                        break;
                    }
                case 139:
                    ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " Krpm");
                    break;
                case 140:
                    ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                    break;
                case 141:
                    ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " V");
                    break;
                case 142:
                    if ((32768 & value) != 0) {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text8)).setText("-" + (65536 - value) + " A");
                        break;
                    } else {
                        ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " A");
                        break;
                    }
                case 143:
                    switch (value) {
                        case 2:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("怠速充电模式");
                            break;
                        case 3:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("行车充电模式");
                            break;
                        case 4:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("纯电动驱动模式");
                            break;
                        case 5:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("发动机驱动模式");
                            break;
                        case 6:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("串联驱动模式");
                            break;
                        case 7:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("并联驱动模式");
                            break;
                        case 8:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("能量回收模式");
                            break;
                        case 9:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("外接充电模式");
                            break;
                        default:
                            ((TextView) XC_GMadRongweiCarInfo.this.findViewById(R.id.tv_text9)).setText("默认模式");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_rongwei_gm_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
                dialog(R.string.bmw_cleanoil, 192);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog(R.string.str_clean_electricl, 193);
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
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
    }
}
