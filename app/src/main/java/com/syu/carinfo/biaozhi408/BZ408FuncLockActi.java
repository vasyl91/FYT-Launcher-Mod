package com.syu.carinfo.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class BZ408FuncLockActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 111:
                    BZ408FuncLockActi.this.mUpdaterValue1();
                    break;
                case 126:
                    BZ408FuncLockActi.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_biaozhi408_func_lock);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(11, iArr, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int i = R.string.lock_set_unlock_intelligent_door_driver;
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
        if (DataCanbus.DATA[1000] == 118 || DataCanbus.DATA[1000] == 185) {
            if (((TextView) findViewById(R.id.tv_text1)) != null) {
                ((TextView) findViewById(R.id.tv_text1)).setText(value != 0 ? 2131296340 : 2131296339);
            }
        } else if (((TextView) findViewById(R.id.tv_text1)) != null) {
            TextView textView = (TextView) findViewById(R.id.tv_text1);
            if (value == 0) {
                i = 2131296340;
            }
            textView.setText(i);
        }
    }

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }
}
