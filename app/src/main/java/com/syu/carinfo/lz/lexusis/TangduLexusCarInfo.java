package com.syu.carinfo.lz.lexusis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class TangduLexusCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 151:
                    ((TextView) TangduLexusCarInfo.this.findViewById(R.id.tv_text1)).setText(value * 0.1f + " L/100km");
                    break;
                case 152:
                    ((TextView) TangduLexusCarInfo.this.findViewById(R.id.tv_text2)).setText(value * 0.1f + " L/100km");
                    break;
                case 153:
                    ((TextView) TangduLexusCarInfo.this.findViewById(R.id.tv_text3)).setText(value + " km");
                    break;
                case 154:
                    ((TextView) TangduLexusCarInfo.this.findViewById(R.id.tv_text5)).setText(value + " km");
                    break;
                case 155:
                    ((TextView) TangduLexusCarInfo.this.findViewById(R.id.tv_text4)).setText(value + " km/h");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_toyota_reiz_carinfo);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{112}, null, null);
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
                dialog(R.string.trip_info, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirm_reset) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(5, new int[]{i}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
    }
}
