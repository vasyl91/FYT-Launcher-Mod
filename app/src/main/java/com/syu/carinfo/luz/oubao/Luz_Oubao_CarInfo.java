package com.syu.carinfo.luz.oubao;

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

public class Luz_Oubao_CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    if (value > 715) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
                        break;
                    }
                case 105:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 106:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text11)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 107:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text12)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 108:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text13)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 109:
                    if (value > 102) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text14)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10.0f) + " bar");
                        break;
                    }
                case 110:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " Km");
                        break;
                    }
                case 111:
                    if (value > 250) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Km/h");
                        break;
                    }
                case 112:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " L");
                        break;
                    }
                case 113:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
                case 114:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " Km");
                        break;
                    }
                case 115:
                    if (value > 250) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " Km/h");
                        break;
                    }
                case 116:
                    if (value == -1) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10.0f) + " L");
                        break;
                    }
                case 117:
                    if (value > 398) {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text10)).setText("----");
                        break;
                    } else {
                        ((TextView) Luz_Oubao_CarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value / 10.0f) + " L/100Km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_luz_oubao_andela_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{18}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{19}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{20}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                dialog("BC1", 3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog("BC2", 4);
                break;
        }
    }

    protected void dialog(String str, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + str + " " + getResources().getString(R.string.data));
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }
}
