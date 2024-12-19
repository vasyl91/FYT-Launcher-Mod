package com.syu.carinfo.lz.jaguar;

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
public class JaguarAmbientLightSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.JaguarAmbientLightSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 120:
                    JaguarAmbientLightSet.this.setCheck((CheckedTextView) JaguarAmbientLightSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 121:
                    if (((TextView) JaguarAmbientLightSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) JaguarAmbientLightSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val + 1).toString());
                        break;
                    }
                case 122:
                    JaguarAmbientLightSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_jaguar_ambientlight_settings);
        init();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.lz.jaguar.JaguarAmbientLightSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                JaguarAmbientLightSet.this.language_set = position;
                if (JaguarAmbientLightSet.this.language_set >= 0 && JaguarAmbientLightSet.this.language_set <= JaguarAmbientLightSet.this.mLauStylelist.size() && JaguarAmbientLightSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{30, JaguarAmbientLightSet.this.send_lang[JaguarAmbientLightSet.this.language_set]}, null, null);
                }
                JaguarAmbientLightSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[122];
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
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.str_background_green));
        this.mLauStylelist.add(getResources().getString(R.string.color_blue_green_str));
        this.mLauStylelist.add(getResources().getString(R.string.color_white_str));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_8));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_3));
        this.mLauStylelist.add(getResources().getString(R.string.str_color_orange_red));
        this.mLauStylelist.add(getResources().getString(R.string.str_color_orange_yellow));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_7));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_0));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_2));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_5));
        this.mLauStylelist.add(getResources().getString(R.string.str_403_ambient_6));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.lz.jaguar.JaguarAmbientLightSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (JaguarAmbientLightSet.this.mLauStyle == null) {
                    JaguarAmbientLightSet.this.initLauStyle();
                }
                if (JaguarAmbientLightSet.this.mLauStyle != null && JaguarAmbientLightSet.this.mPopShowView != null) {
                    JaguarAmbientLightSet.this.mLauStyle.showAtLocation(JaguarAmbientLightSet.this.mPopShowView, 17, 0, 0);
                    JaguarAmbientLightSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[120];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{28, value}, null, null);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[121];
                if (value2 > 0) {
                    value2--;
                }
                DataCanbus.PROXY.cmd(0, new int[]{29, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[121];
                if (value3 < 3) {
                    value3++;
                }
                DataCanbus.PROXY.cmd(0, new int[]{29, value3}, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }
}
