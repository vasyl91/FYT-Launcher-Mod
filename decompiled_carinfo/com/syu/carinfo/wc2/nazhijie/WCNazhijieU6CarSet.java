package com.syu.carinfo.wc2.nazhijie;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class WCNazhijieU6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    WCNazhijieU6CarSet.this.updateSideVideo();
                    break;
                case 99:
                    WCNazhijieU6CarSet.this.updatePrevMile();
                    break;
                case 100:
                    WCNazhijieU6CarSet.this.updateNextMile();
                    break;
                case 101:
                    WCNazhijieU6CarSet.this.updateNextMileDis();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_nazhijie_u6_settings);
        init();
        setListener();
    }

    @Override
    public void init() {
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[98];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                ShoeRestoreCarSetDialog();
                break;
        }
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
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSideVideo() {
        int value = DataCanbus.DATA[98];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    
    public void updatePrevMile() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Km");
        }
    }

    
    public void updateNextMile() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
        }
    }

    
    public void updateNextMileDis() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " Km");
        }
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_update_warranty_notice);
        normalDialog.setMessage(R.string.str_update_warranty_notice);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{10, 1}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(0, new int[]{10}, null, null);
            }
        });
        normalDialog.show();
    }
}
