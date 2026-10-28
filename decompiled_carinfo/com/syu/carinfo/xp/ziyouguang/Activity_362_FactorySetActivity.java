package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Activity_362_FactorySetActivity extends BaseActivity {
    public static Activity_362_FactorySetActivity mist;
    private StringBuffer mTvCurrPasswordBuffer = new StringBuffer();
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    Activity_362_FactorySetActivity.this.setCheck((CheckedTextView) Activity_362_FactorySetActivity.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //setContentView(R.layout.layout_xiandai_fista_factory);
        mist = this;
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[105];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{value}, null, null);
            }
        });
        findViewById(R.id.factory_passview).setVisibility(0);
        findViewById(R.id.scrollview_setting).setVisibility(8);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    private class mNum0Listener implements View.OnClickListener {
        private mNum0Listener() {
        }

        /* synthetic */ mNum0Listener(Activity_362_FactorySetActivity activity_362_FactorySetActivity, mNum0Listener mnum0listener) {
            this();
        }

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
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

        @Override
        public void onClick(View v) {
            String mCurrPassword = ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString();
            if ("12040310".equals(mCurrPassword)) {
                Activity_362_FactorySetActivity.this.findViewById(R.id.factory_passview).setVisibility(8);
                Activity_362_FactorySetActivity.this.findViewById(R.id.scrollview_setting).setVisibility(0);
            } else if (mCurrPassword.equals("")) {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_null, 0).show();
            } else {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_wrong, 0).show();
            }
            Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.delete(0, Activity_362_FactorySetActivity.this.mTvCurrPasswordBuffer.length());
            ((TextView) Activity_362_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText("");
        }
    }
}
