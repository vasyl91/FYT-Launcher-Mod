package com.syu.carinfo.rzc.haima;

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
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HaimaS5SetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 26:
                    HaimaS5SetFunc.this.updateLighHome(value);
                    break;
                case 27:
                    HaimaS5SetFunc.this.mUpdaterLighHomeTime(value);
                    break;
                case 28:
                    HaimaS5SetFunc.this.mUpdaterRoadAway(value);
                    break;
                case 29:
                    HaimaS5SetFunc.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haima19s5_setfunc);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27] & 127;
                int value1 = DataCanbus.DATA[26];
                int value3 = value2 - 1;
                if (value3 < 0) {
                    value3 = 60;
                }
                if (value1 == 1) {
                    value = value3 | 128;
                } else {
                    value = value3 & 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[27] & 127;
                int value1 = DataCanbus.DATA[26];
                int value3 = value2 + 1;
                if (value3 > 60) {
                    value3 = 0;
                }
                if (value1 == 1) {
                    value = value3 | 128;
                } else {
                    value = value3 & 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[26];
                int value1 = DataCanbus.DATA[27] & 127;
                if (value2 == 0) {
                    value = value1 | 128;
                } else {
                    value = value1 & 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[28];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
            }
        });
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (HaimaS5SetFunc.this.mLauStyle == null) {
                    HaimaS5SetFunc.this.initLauStyle();
                }
                if (HaimaS5SetFunc.this.mLauStyle == null || HaimaS5SetFunc.this.mPopShowView == null) {
                    return;
                }
                HaimaS5SetFunc.this.mLauStyle.showAtLocation(HaimaS5SetFunc.this.mPopShowView, 17, 0, 0);
                HaimaS5SetFunc.this.updateLauguageSet();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.haima.HaimaS5SetFunc.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                HaimaS5SetFunc.this.language_set = position;
                if (HaimaS5SetFunc.this.language_set >= 0 && HaimaS5SetFunc.this.language_set <= HaimaS5SetFunc.this.mLauStylelist.size() && HaimaS5SetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{3, HaimaS5SetFunc.this.send_lang[HaimaS5SetFunc.this.language_set]}, null, null);
                }
                HaimaS5SetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[29];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLighHomeTime(int value) {
        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLighHome(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRoadAway(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }
}
