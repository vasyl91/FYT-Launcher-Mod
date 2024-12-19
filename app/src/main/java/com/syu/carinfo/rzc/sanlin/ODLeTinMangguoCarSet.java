package com.syu.carinfo.rzc.sanlin;

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
public class ODLeTinMangguoCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODLeTinMangguoCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 19:
                    ((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 20:
                    ODLeTinMangguoCarSet.this.setCheck((CheckedTextView) ODLeTinMangguoCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 21:
                    ODLeTinMangguoCarSet.this.updateLauguageSet();
                    break;
                case 22:
                    if (((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(val)).toString());
                        break;
                    }
                case 23:
                    if (((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text3)).setText("运动模式");
                                break;
                            case 1:
                                ((TextView) ODLeTinMangguoCarSet.this.findViewById(R.id.tv_text3)).setText("长续航模式");
                                break;
                        }
                    }
                    break;
                case 24:
                    ODLeTinMangguoCarSet.this.setCheck((CheckedTextView) ODLeTinMangguoCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_letin_mangguo_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODLeTinMangguoCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ODLeTinMangguoCarSet.this.language_set = position;
                if (ODLeTinMangguoCarSet.this.language_set >= 0 && ODLeTinMangguoCarSet.this.language_set <= ODLeTinMangguoCarSet.this.mLauStylelist.size() && ODLeTinMangguoCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{2, ODLeTinMangguoCarSet.this.send_lang[ODLeTinMangguoCarSet.this.language_set]}, null, null);
                }
                ODLeTinMangguoCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[21];
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
        this.mLauStylelist.add("传统引擎声");
        this.mLauStylelist.add("和弦");
        this.mLauStylelist.add("律动");
        this.mLauStylelist.add("太空声");
        this.mLauStylelist.add("布加迪");
        this.mLauStylelist.add("声浪气音");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.ODLeTinMangguoCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ODLeTinMangguoCarSet.this.mLauStyle == null) {
                    ODLeTinMangguoCarSet.this.initLauStyle();
                }
                if (ODLeTinMangguoCarSet.this.mLauStyle != null && ODLeTinMangguoCarSet.this.mPopShowView != null) {
                    ODLeTinMangguoCarSet.this.mLauStyle.showAtLocation(ODLeTinMangguoCarSet.this.mPopShowView, 17, 0, 0);
                    ODLeTinMangguoCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[20];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                setAirInfo(49, 1);
                setAirInfo(49, 0);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setAirInfo(48, 1);
                setAirInfo(48, 0);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value2 = DataCanbus.DATA[22];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value3 = DataCanbus.DATA[22];
                if (value3 < 100) {
                    value3++;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value4 = DataCanbus.DATA[23] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value5 = DataCanbus.DATA[23] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(4, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value6 = DataCanbus.DATA[24];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(5, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setAirInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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
        setCarInfo(0, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
    }
}
