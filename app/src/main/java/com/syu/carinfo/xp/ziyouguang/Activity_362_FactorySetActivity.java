package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Activity_362_FactorySetActivity extends BaseActivity {
    public static Activity_362_FactorySetActivity mist;
    private StringBuffer mTvCurrPasswordBuffer = new StringBuffer();
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_362_FactorySetActivity.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 30:
                    Activity_362_FactorySetActivity.this.setCheck((CheckedTextView) Activity_362_FactorySetActivity.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_xiandai_fista_factory);
        mist = this;
        //((Button) findViewById(R.id.clear_card_password_num0)).setOnClickListener(new mNum0Listener(this, null));
        //((Button) findViewById(R.id.clear_card_password_num1)).setOnClickListener(new mNum1Listener(this, mist == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num2)).setOnClickListener(new mNum2Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num3)).setOnClickListener(new mNum3Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num4)).setOnClickListener(new mNum4Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num5)).setOnClickListener(new mNum5Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num6)).setOnClickListener(new mNum6Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num7)).setOnClickListener(new mNum7Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num8)).setOnClickListener(new mNum8Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_num9)).setOnClickListener(new mNum9Listener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_confirm)).setOnClickListener(new mConfirmListener(this, 0 == true ? 1 : 0));
        //((Button) findViewById(R.id.clear_card_password_del)).setOnClickListener(new mDeleteListener(this, 0 == true ? 1 : 0));
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_362_FactorySetActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[30];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
            }
        });
        findViewById(R.id.factory_passview).setVisibility(View.VISIBLE);
        findViewById(R.id.scrollview_setting).setVisibility(View.GONE);
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
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    private class mNum0Listener implements View.OnClickListener {
        private mNum0Listener() {
        }

        /* synthetic */ mNum0Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum0Listener mnum0listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('0');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum1Listener implements View.OnClickListener {
        private mNum1Listener() {
        }

        /* synthetic */ mNum1Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum1Listener mnum1listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('1');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum2Listener implements View.OnClickListener {
        private mNum2Listener() {
        }

        /* synthetic */ mNum2Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum2Listener mnum2listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('2');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum3Listener implements View.OnClickListener {
        private mNum3Listener() {
        }

        /* synthetic */ mNum3Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum3Listener mnum3listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('3');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum4Listener implements View.OnClickListener {
        private mNum4Listener() {
        }

        /* synthetic */ mNum4Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum4Listener mnum4listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('4');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum5Listener implements View.OnClickListener {
        private mNum5Listener() {
        }

        /* synthetic */ mNum5Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum5Listener mnum5listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('5');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum6Listener implements View.OnClickListener {
        private mNum6Listener() {
        }

        /* synthetic */ mNum6Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum6Listener mnum6listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('6');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum7Listener implements View.OnClickListener {
        private mNum7Listener() {
        }

        /* synthetic */ mNum7Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum7Listener mnum7listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('7');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum8Listener implements View.OnClickListener {
        private mNum8Listener() {
        }

        /* synthetic */ mNum8Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum8Listener mnum8listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('8');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum9Listener implements View.OnClickListener {
        private mNum9Listener() {
        }

        /* synthetic */ mNum9Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum9Listener mnum9listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 8) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.append('9');
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mDeleteListener implements View.OnClickListener {
        private mDeleteListener() {
        }

        /* synthetic */ mDeleteListener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mDeleteListener mdeletelistener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() > 0) {
                Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.deleteCharAt(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length() - 1);
                ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mConfirmListener implements View.OnClickListener {
        private mConfirmListener() {
        }

        /* synthetic */ mConfirmListener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mConfirmListener mconfirmlistener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            String mCurrPassword = ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString();
            if ("12040310".equals(mCurrPassword)) {
                Activity_362_FactorySetActivity.this.findViewById(R.id.factory_passview).setVisibility(View.GONE);
                Activity_362_FactorySetActivity.this.findViewById(R.id.scrollview_setting).setVisibility(View.VISIBLE);
            } else if (mCurrPassword.equals("")) {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_null, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_wrong, Toast.LENGTH_SHORT).show();
            }
            Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.delete(0, Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length());
            ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText("");
        }
    }
}
