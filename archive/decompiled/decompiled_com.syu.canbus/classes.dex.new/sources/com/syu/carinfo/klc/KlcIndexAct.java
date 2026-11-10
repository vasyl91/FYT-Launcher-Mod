package com.syu.carinfo.klc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.xp.yinglang.YLTireAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class KlcIndexAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcIndexAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 188:
                    updateTmpsenable();
                    break;
            }
        }

        private void updateTmpsenable() {
            int val = DataCanbus.DATA[188] >> 7;
            if (val == 1) {
                KlcIndexAct.this.findViewById(R.id.layout_view4).setVisibility(0);
            } else {
                KlcIndexAct.this.findViewById(R.id.layout_view4).setVisibility(8);
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_index);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.klc.KlcIndexAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                KlcIndexAct.this.language_set = position;
                if (KlcIndexAct.this.language_set >= 0 && KlcIndexAct.this.language_set <= KlcIndexAct.this.mLauStylelist.size() && KlcIndexAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(96, new int[]{KlcIndexAct.this.send_lang[KlcIndexAct.this.language_set]}, null, null);
                }
                KlcIndexAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.klc.KlcIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (KlcIndexAct.this.mLauStyle == null) {
                    KlcIndexAct.this.initLauStyle();
                }
                if (KlcIndexAct.this.mLauStyle != null && KlcIndexAct.this.mPopShowView != null) {
                    KlcIndexAct.this.mLauStyle.showAtLocation(KlcIndexAct.this.mPopShowView, 17, 0, 0);
                    KlcIndexAct.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 589860) {
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
        } else if (DataCanbus.DATA[1000] == 4128804) {
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 5963812) {
            findViewById(R.id.layout_view9).setVisibility(0);
        } else {
            findViewById(R.id.layout_view9).setVisibility(8);
        }
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intent intent;
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) KlcCarSettingsAct.class);
                    startActivity(intent2);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) YLTireAct.class);
                    startActivity(intent3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    if (DataCanbus.DATA[1000] == 458788) {
                        intent = new Intent(this, (Class<?>) KlcOnStarGl6Act.class);
                    } else {
                        intent = new Intent(this, (Class<?>) KlcOnStarAct.class);
                    }
                    KlcFunc.C_CAR_ONSTAR_CMD(8, 1);
                    startActivity(intent);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent4 = new Intent(this, (Class<?>) klcAirMessageAct.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent5 = new Intent(this, (Class<?>) KlcComfortAct.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent6 = new Intent(this, (Class<?>) Air_Activity_All_NewAdd_HP.class);
                    startActivity(intent6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                try {
                    Intent intent7 = new Intent(this, (Class<?>) KlcOilMileCarInfo.class);
                    startActivity(intent7);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent8 = new Intent(this, (Class<?>) WcGMBasicInfoAct.class);
                    startActivity(intent8);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                try {
                    Intent intent9 = new Intent(this, (Class<?>) WCGMAMPSetActi.class);
                    startActivity(intent9);
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
                break;
        }
    }
}
