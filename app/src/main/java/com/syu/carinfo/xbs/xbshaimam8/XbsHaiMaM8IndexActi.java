package com.syu.carinfo.xbs.xbshaimam8;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class XbsHaiMaM8IndexActi extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    XbsHaiMaM8IndexActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_haimam8);
        init();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.tv_xbscomehome)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[98];
                DataCanbus.PROXY.cmd(0, value == 1 ? 0 : 1);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[98];
        if (((CheckedTextView) findViewById(R.id.tv_xbscomehome)) != null) {
            ((CheckedTextView) findViewById(R.id.tv_xbscomehome)).setChecked(value != 0);
        }
    }
}
