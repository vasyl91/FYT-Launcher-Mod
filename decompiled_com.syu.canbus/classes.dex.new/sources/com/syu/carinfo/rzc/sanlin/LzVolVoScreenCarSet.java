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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LzVolVoScreenCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LzVolVoScreenCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    LzVolVoScreenCarSet.this.updateLauguageSet();
                    break;
                case 100:
                    ((TextView) LzVolVoScreenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 101:
                    ((TextView) LzVolVoScreenCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 102:
                    ((CheckedTextView) LzVolVoScreenCarSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 103:
                    switch (value) {
                        case 0:
                            ((TextView) LzVolVoScreenCarSet.this.findViewById(R.id.tv_text1)).setText("2009~2010");
                            break;
                        case 1:
                            ((TextView) LzVolVoScreenCarSet.this.findViewById(R.id.tv_text1)).setText("2011~2014");
                            break;
                        case 2:
                            ((TextView) LzVolVoScreenCarSet.this.findViewById(R.id.tv_text1)).setText("2015~2017");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_volvo_screen_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LzVolVoScreenCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LzVolVoScreenCarSet.this.language_set = position;
                if (LzVolVoScreenCarSet.this.language_set >= 0 && LzVolVoScreenCarSet.this.language_set <= LzVolVoScreenCarSet.this.mLauStylelist.size() && LzVolVoScreenCarSet.this.send_lang != null) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[5];
                    iArr[0] = LzVolVoScreenCarSet.this.send_lang[LzVolVoScreenCarSet.this.language_set];
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
                LzVolVoScreenCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[99];
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
        this.mLauStylelist.add("Bosch1");
        this.mLauStylelist.add("Bosch2");
        this.mLauStylelist.add("Haman1");
        this.mLauStylelist.add("Haman2");
        this.send_lang = new int[]{0, 1, 2, 3};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LzVolVoScreenCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LzVolVoScreenCarSet.this.mLauStyle == null) {
                    LzVolVoScreenCarSet.this.initLauStyle();
                }
                if (LzVolVoScreenCarSet.this.mLauStyle != null && LzVolVoScreenCarSet.this.mPopShowView != null) {
                    LzVolVoScreenCarSet.this.mLauStyle.showAtLocation(LzVolVoScreenCarSet.this.mPopShowView, 17, 0, 0);
                    LzVolVoScreenCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value2 = DataCanbus.DATA[103] - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                setCarInfo(249, value2);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103] + 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                setCarInfo(249, value3);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value4 = DataCanbus.DATA[100];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(253, value4);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value5 = DataCanbus.DATA[100];
                if (value5 < 36) {
                    value5++;
                }
                setCarInfo(253, value5);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value6 = DataCanbus.DATA[101];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(252, value6);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value7 = DataCanbus.DATA[101];
                if (value7 < 36) {
                    value7++;
                }
                setCarInfo(252, value7);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[102] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(244, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
