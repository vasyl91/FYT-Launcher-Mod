package com.syu.carinfo.daojun.bydm6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class DaojunBydM6SetFunc extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    DaojunBydM6SetFunc.this.uCheckedtext1(DataCanbus.DATA[updateCode]);
                    break;
                case 99:
                    DaojunBydM6SetFunc.this.uCheckedtext2(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_0439_daojun_bydm6);
        setupView();
    }

    private void setupView() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[98] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 1;
                    iArr[1] = value == 1 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[99] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[2];
                    iArr[0] = 2;
                    iArr[1] = value == 1 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }

    protected void uCheckedtext2(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(i == 1);
        }
    }

    protected void uCheckedtext1(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(i == 1);
        }
    }
}
