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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BNRActivityHavaH8SeatSetAct extends BaseActivity {
    public static BNRActivityHavaH8SeatSetAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    ((TextView) BNRActivityHavaH8SeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    break;
                case 54:
                    ((TextView) BNRActivityHavaH8SeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_bnr_havalh8_seat_set);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                    HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DataCanbus.PROXY.cmd(2, new int[]{11}, null, null);
                        }
                    }, 100L);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    DataCanbus.PROXY.cmd(2, new int[]{13, 1}, null, null);
                    HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.hava.BNRActivityHavaH8SeatSetAct.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
                        }
                    }, 100L);
                }
            });
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
    }
}
