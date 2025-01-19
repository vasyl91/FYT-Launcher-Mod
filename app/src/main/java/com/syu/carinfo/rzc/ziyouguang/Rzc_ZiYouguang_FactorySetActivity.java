package com.syu.carinfo.rzc.ziyouguang;

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

public class Rzc_ZiYouguang_FactorySetActivity extends BaseActivity {
    public static Rzc_ZiYouguang_FactorySetActivity mist;
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
        this.mModelslist.add("Type1");
        this.mModelslist.add("Type2");
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
                if (Rzc_ZiYouguang_FactorySetActivity.this.mPopModels == null) {
                    Rzc_ZiYouguang_FactorySetActivity.this.initPop();
                }
                if (Rzc_ZiYouguang_FactorySetActivity.this.mPopModels != null && Rzc_ZiYouguang_FactorySetActivity.this.mPopShowView != null) {
                    Rzc_ZiYouguang_FactorySetActivity.this.mPopModels.showAtLocation(Rzc_ZiYouguang_FactorySetActivity.this.mPopShowView, 17, 0, 0);
                    int modelValue = Rzc_ZiYouguang_FactorySetActivity.this.sp.getInt("cartype_value_rzc", 0);
                    Rzc_ZiYouguang_FactorySetActivity.this.updateModelValue(modelValue);
                }
            }
        });
        findViewById(R.id.factory_passview).setVisibility(0);
        findViewById(R.id.scrollview_setting).setVisibility(8);
    }

    @Override
    public void onResume() {
        super.onResume();
        int modelValue = this.sp.getInt("cartype_value_rzc", 0);
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
                DataCanbus.PROXY.cmd(7, new int[]{position}, null, null);
                Rzc_ZiYouguang_FactorySetActivity.this.editor.putInt("cartype_value_rzc", position);
                Rzc_ZiYouguang_FactorySetActivity.this.editor.apply();
                Rzc_ZiYouguang_FactorySetActivity.this.updateModelValue(position);
                Rzc_ZiYouguang_FactorySetActivity.this.mPopModels.dismiss();
            }
        });
    }

    private class mNum0Listener implements View.OnClickListener {
        private mNum0Listener() {
        }

        /* synthetic */ mNum0Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum0Listener mnum0listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('0');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum1Listener implements View.OnClickListener {
        private mNum1Listener() {
        }

        /* synthetic */ mNum1Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum1Listener mnum1listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('1');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum2Listener implements View.OnClickListener {
        private mNum2Listener() {
        }

        /* synthetic */ mNum2Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum2Listener mnum2listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('2');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum3Listener implements View.OnClickListener {
        private mNum3Listener() {
        }

        /* synthetic */ mNum3Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum3Listener mnum3listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('3');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum4Listener implements View.OnClickListener {
        private mNum4Listener() {
        }

        /* synthetic */ mNum4Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum4Listener mnum4listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('4');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum5Listener implements View.OnClickListener {
        private mNum5Listener() {
        }

        /* synthetic */ mNum5Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum5Listener mnum5listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('5');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum6Listener implements View.OnClickListener {
        private mNum6Listener() {
        }

        /* synthetic */ mNum6Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum6Listener mnum6listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('6');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum7Listener implements View.OnClickListener {
        private mNum7Listener() {
        }

        /* synthetic */ mNum7Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum7Listener mnum7listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('7');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum8Listener implements View.OnClickListener {
        private mNum8Listener() {
        }

        /* synthetic */ mNum8Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum8Listener mnum8listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('8');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mNum9Listener implements View.OnClickListener {
        private mNum9Listener() {
        }

        /* synthetic */ mNum9Listener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mNum9Listener mnum9listener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() < 4) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.append('9');
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mDeleteListener implements View.OnClickListener {
        private mDeleteListener() {
        }

        /* synthetic */ mDeleteListener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mDeleteListener mdeletelistener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)) != null && Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() > 0) {
                Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.deleteCharAt(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length() - 1);
                ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText(Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer);
            }
        }
    }

    private class mConfirmListener implements View.OnClickListener {
        private mConfirmListener() {
        }

        /* synthetic */ mConfirmListener(Rzc_ZiYouguang_FactorySetActivity rzc_ZiYouguang_FactorySetActivity, mConfirmListener mconfirmlistener) {
            this();
        }

        @Override
        public void onClick(View v) {
            if ("3368".equals(((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString())) {
                Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.factory_passview).setVisibility(8);
                Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.scrollview_setting).setVisibility(0);
            } else if (((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).getText().toString().equals("")) {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_null, 0).show();
            } else {
                Toast.makeText(LauncherApplication.getInstance(), R.string.wc_psa_all_factory_settings_password_wrong, 0).show();
            }
            Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.delete(0, Rzc_ZiYouguang_FactorySetActivity.this.mTvCurrPasswordBuffer.length());
            ((TextView) Rzc_ZiYouguang_FactorySetActivity.this.findViewById(R.id.clear_card_currpassword)).setText("");
        }
    }
}
