package com.syu.carinfo.accord9.wc;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Accord9LowBackCarSet extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.wc.Accord9LowBackCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 130:
                    Accord9LowBackCarSet.this.mUpdateCarBright();
                    break;
                case 131:
                    Accord9LowBackCarSet.this.mUpdateCarColor();
                    break;
                case 132:
                    Accord9LowBackCarSet.this.mUpdateCarContrast();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_low_backcar);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 42 || DataCanbus.DATA[1000] == 65578 || DataCanbus.DATA[1000] == 131114) {
            ((ViewGroup) findViewById(R.id.layout_view1)).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 59) {
            ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
            ((TextView) findViewById(R.id.tv_text3)).setVisibility(8);
            ((TextView) findViewById(R.id.tv_text2)).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                setBright(-2);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                setBright(-1);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                setColor(-2);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                setColor(-1);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                setConstrast(-2);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                setConstrast(-1);
                break;
        }
    }

    private void setBright(int value) {
    }

    private void setColor(int value) {
        DataCanbus.PROXY.cmd(12, value);
    }

    private void setConstrast(int value) {
        DataCanbus.PROXY.cmd(13, value);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarBright() {
        int value = DataCanbus.DATA[130];
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarColor() {
        int value = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value - 5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarContrast() {
        int value = DataCanbus.DATA[132];
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 5).toString());
    }
}
