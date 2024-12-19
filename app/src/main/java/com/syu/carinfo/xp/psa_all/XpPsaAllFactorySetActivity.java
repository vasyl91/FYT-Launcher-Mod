package com.syu.carinfo.xp.psa_all;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XpPsaAllFactorySetActivity extends BaseActivity {
    public static XpPsaAllFactorySetActivity mist;
    private SharedPreferences.Editor editor;
    public ArrayList<String> mModelslist;
    public ListView mModelslv;
    private PopupWindow mPopModels;
    private View mPopShowView;
    private StringBuffer mTvCurrPasswordBuffer = new StringBuffer();
    private SharedPreferences sp;

    public void initObject() {
        this.sp = getSharedPreferences("SP", 0);
        this.editor = this.sp.edit();
        this.mPopShowView = getWindow().getDecorView();
        this.mModelslist = new ArrayList<>();
        this.mModelslist.add("Auto");
        this.mModelslist.add("2016-308");
        this.mModelslist.add("2017-4008");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_psa_all_factory);
        mist = this;
        initObject();
        //((Button) findViewById(R.id.clear_card_password_num0)).setOnClickListener(new mNum0Listener(this, null));
        //((Button) findViewById(R.id.clear_card_password_num1)).setOnClickListener(new mNum1Listener(this, 0 == true ? 1 : 0));
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
        ((CheckedTextView) findViewById(R.id.btn_factory_select_models)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFactorySetActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (XpPsaAllFactorySetActivity.this.mPopModels == null) {
                    XpPsaAllFactorySetActivity.this.initPop();
                }
                if (XpPsaAllFactorySetActivity.this.mPopModels != null && XpPsaAllFactorySetActivity.this.mPopShowView != null) {
                    XpPsaAllFactorySetActivity.this.mPopModels.showAtLocation(XpPsaAllFactorySetActivity.this.mPopShowView, 17, 0, 0);
                    int modelValue = XpPsaAllFactorySetActivity.this.sp.getInt("cartype_value", 0);
                    XpPsaAllFactorySetActivity.this.updateModelValue(modelValue);
                }
            }
        });
        findViewById(R.id.factory_passview).setVisibility(View.VISIBLE);
        findViewById(R.id.scrollview_setting).setVisibility(View.GONE);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int modelValue = this.sp.getInt("cartype_value", 0);
        updateModelValue(modelValue);
    }

    public void updateModelValue(int value) {
        if (((TextView) findViewById(R.id.tv_curr_models)) != null) {
            ((TextView) findViewById(R.id.tv_curr_models)).setText(this.mModelslist.get(value));
        }
        if (this.mModelslv != null) {
            this.mModelslv.setItemChecked(value, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPop() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_models, (ViewGroup) null);
        this.mPopModels = new PopupWindow(layout, 548, 408);
        this.mPopModels.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mPopModels.setFocusable(true);
        this.mPopModels.setTouchable(true);
        this.mPopModels.setOutsideTouchable(true);
        this.mPopModels.setAnimationStyle(R.style.popAnimationFade);
        this.mModelslv = (ListView) layout.findViewById(R.id.modelsListview);
        this.mModelslv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mModelslist));
        this.mModelslv.setItemsCanFocus(false);
        this.mModelslv.setChoiceMode(1);
        this.mModelslv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.psa_all.XpPsaAllFactorySetActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                DataCanbus.PROXY.cmd(65, new int[]{position}, null, null);
                XpPsaAllFactorySetActivity.this.editor.putInt("cartype_value", position);
                XpPsaAllFactorySetActivity.this.editor.commit();
                XpPsaAllFactorySetActivity.this.updateModelValue(position);
                XpPsaAllFactorySetActivity.this.mPopModels.dismiss();
            }
        });
    }

    private class mNum0Listener implements View.OnClickListener {
        private mNum0Listener() {
        }

        /* synthetic */ mNum0Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum0Listener mnum0listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('0');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum1Listener implements View.OnClickListener {
        private mNum1Listener() {
        }

        /* synthetic */ mNum1Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum1Listener mnum1listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('1');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum2Listener implements View.OnClickListener {
        private mNum2Listener() {
        }

        /* synthetic */ mNum2Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum2Listener mnum2listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('2');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum3Listener implements View.OnClickListener {
        private mNum3Listener() {
        }

        /* synthetic */ mNum3Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum3Listener mnum3listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('3');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum4Listener implements View.OnClickListener {
        private mNum4Listener() {
        }

        /* synthetic */ mNum4Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum4Listener mnum4listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('4');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum5Listener implements View.OnClickListener {
        private mNum5Listener() {
        }

        /* synthetic */ mNum5Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum5Listener mnum5listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('5');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum6Listener implements View.OnClickListener {
        private mNum6Listener() {
        }

        /* synthetic */ mNum6Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum6Listener mnum6listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('6');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum7Listener implements View.OnClickListener {
        private mNum7Listener() {
        }

        /* synthetic */ mNum7Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum7Listener mnum7listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('7');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum8Listener implements View.OnClickListener {
        private mNum8Listener() {
        }

        /* synthetic */ mNum8Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum8Listener mnum8listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('8');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum9Listener implements View.OnClickListener {
        private mNum9Listener() {
        }

        /* synthetic */ mNum9Listener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mNum9Listener mnum9listener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.append('9');
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mDeleteListener implements View.OnClickListener {
        private mDeleteListener() {
        }

        /* synthetic */ mDeleteListener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mDeleteListener mdeletelistener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() > 0) {
                XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.deleteCharAt(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length() - 1);
                ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mConfirmListener implements View.OnClickListener {
        private mConfirmListener() {
        }

        /* synthetic */ mConfirmListener(XpPsaAllFactorySetActivity xpPsaAllFactorySetActivity, mConfirmListener mconfirmlistener) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if ("3368".equals(((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString())) {
                XpPsaAllFactorySetActivity.this.findViewById(R.id.factory_passview).setVisibility(View.GONE);
                XpPsaAllFactorySetActivity.this.findViewById(R.id.scrollview_setting).setVisibility(View.VISIBLE);
            } else if (((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString().equals("")) {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_null, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_wrong, Toast.LENGTH_SHORT).show();
            }
            XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.delete(0, XpPsaAllFactorySetActivity.this.mTvCurrPasswordBuffer.length());
            ((TextView) XpPsaAllFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText("");
        }
    }
}
