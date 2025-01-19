package com.syu.carinfo.hava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

public class BNRActivityHavaH8SeatSetAct extends BaseActivity {
    public static BNRActivityHavaH8SeatSetAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 127:
                    ((TextView) BNRActivityHavaH8SeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 131:
                    ((TextView) BNRActivityHavaH8SeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_bnr_havalh8_seat_set);
        init();
        mInstance = this;
    }

    @Override
    public void init() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                    HandlerUI.getInstance().postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(2, new int[]{11}, null, null);
                        }
                    }, 100L);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{13, 1}, null, null);
                    HandlerUI.getInstance().postDelayed(new Runnable() { 
                        @Override
                        public void run() {
                            DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                        }
                    }, 100L);
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
