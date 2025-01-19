package com.syu.carinfo.psa_all;

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

public class PSAFactorySetActivity extends BaseActivity {
    public static PSAFactorySetActivity mist;
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
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_0));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_1));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_2));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_3));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_4));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_5));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_6));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_7));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_8));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_9));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_10));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_11));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_12));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_13));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_14));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_15));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_16));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_17));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_18));
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_19));
        this.mModelslist.add("DS5_High");
        this.mModelslist.add("DS5L_High");
        this.mModelslist.add(getResources().getString(R.string.wc_psa_all_factory_settings_select_models_22));
        this.mModelslist.add("DS6_High");
        this.mModelslist.add("DS4_High");
        this.mModelslist.add("301(2019)");
        this.mModelslist.add("Rifter_H(2019)");
        this.mModelslist.add("Rifter_L(2019)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //setContentView(R.layout.layout_psa_all_factory);
        mist = this;
        initObject();
        ((CheckedTextView) findViewById(R.id.btn_factory_select_models)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (PSAFactorySetActivity.this.mPopModels == null) {
                    PSAFactorySetActivity.this.initPop();
                }
                if (PSAFactorySetActivity.this.mPopModels != null && PSAFactorySetActivity.this.mPopShowView != null) {
                    PSAFactorySetActivity.this.mPopModels.showAtLocation(PSAFactorySetActivity.this.mPopShowView, 17, 0, 0);
                    int modelValue = PSAFactorySetActivity.this.sp.getInt("model_value", 0);
                    PSAFactorySetActivity.this.updateModelValue(modelValue);
                }
            }
        });
        findViewById(R.id.factory_passview).setVisibility(0);
        findViewById(R.id.scrollview_setting).setVisibility(8);
    }

    @Override
    public void onResume() {
        super.onResume();
        int modelValue = this.sp.getInt("model_value", 0);
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

    
    public void initPop() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
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
        this.mModelslv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                DataCanbus.PROXY.cmd(27, new int[]{position}, null, null);
                PSAFactorySetActivity.this.editor.putInt("model_value", position);
                PSAFactorySetActivity.this.editor.apply();
                PSAFactorySetActivity.this.updateModelValue(position);
                PSAFactorySetActivity.this.mPopModels.dismiss();
            }
        });
    }

    private class mNum0Listener implements View.OnClickListener {
        private mNum0Listener() {
        }

        /* synthetic */ mNum0Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum0Listener mnum0listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('0');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum1Listener implements View.OnClickListener {
        private mNum1Listener() {
        }

        /* synthetic */ mNum1Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum1Listener mnum1listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('1');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum2Listener implements View.OnClickListener {
        private mNum2Listener() {
        }

        /* synthetic */ mNum2Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum2Listener mnum2listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('2');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum3Listener implements View.OnClickListener {
        private mNum3Listener() {
        }

        /* synthetic */ mNum3Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum3Listener mnum3listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('3');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum4Listener implements View.OnClickListener {
        private mNum4Listener() {
        }

        /* synthetic */ mNum4Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum4Listener mnum4listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('4');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum5Listener implements View.OnClickListener {
        private mNum5Listener() {
        }

        /* synthetic */ mNum5Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum5Listener mnum5listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('5');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum6Listener implements View.OnClickListener {
        private mNum6Listener() {
        }

        /* synthetic */ mNum6Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum6Listener mnum6listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('6');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum7Listener implements View.OnClickListener {
        private mNum7Listener() {
        }

        /* synthetic */ mNum7Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum7Listener mnum7listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('7');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum8Listener implements View.OnClickListener {
        private mNum8Listener() {
        }

        /* synthetic */ mNum8Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum8Listener mnum8listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('8');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum9Listener implements View.OnClickListener {
        private mNum9Listener() {
        }

        /* synthetic */ mNum9Listener(PSAFactorySetActivity pSAFactorySetActivity, mNum9Listener mnum9listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.append('9');
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mDeleteListener implements View.OnClickListener {
        private mDeleteListener() {
        }

        /* synthetic */ mDeleteListener(PSAFactorySetActivity pSAFactorySetActivity, mDeleteListener mdeletelistener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() > 0) {
                PSAFactorySetActivity.this.mTvCurrPasswordBuffer.deleteCharAt(PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length() - 1);
                ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(PSAFactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mConfirmListener implements View.OnClickListener {
        private mConfirmListener() {
        }

        /* synthetic */ mConfirmListener(PSAFactorySetActivity pSAFactorySetActivity, mConfirmListener mconfirmlistener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if ("3368".equals(((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString())) {
                PSAFactorySetActivity.this.findViewById(R.id.factory_passview).setVisibility(8);
                PSAFactorySetActivity.this.findViewById(R.id.scrollview_setting).setVisibility(0);
            } else if (((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString().equals("")) {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_null, 0).show();
            } else {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_wrong, 0).show();
            }
            PSAFactorySetActivity.this.mTvCurrPasswordBuffer.delete(0, PSAFactorySetActivity.this.mTvCurrPasswordBuffer.length());
            ((TextView) PSAFactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText("");
        }
    }
}
