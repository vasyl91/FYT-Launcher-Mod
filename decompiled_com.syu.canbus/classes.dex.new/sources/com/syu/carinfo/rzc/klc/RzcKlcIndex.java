package com.syu.carinfo.rzc.klc;

import android.app.Activity;
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
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.andra.GmAndraTireAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcKlcIndex extends Activity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcIndex.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    int value = DataCanbus.DATA[132];
                    if (value == 1) {
                        RzcKlcIndex.this.findViewById(R.id.layout_view1).setVisibility(0);
                    } else {
                        RzcKlcIndex.this.findViewById(R.id.layout_view1).setVisibility(8);
                    }
                    break;
                case 350:
                    RzcKlcIndex.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_index);
        setUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage6, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.klc.RzcKlcIndex.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RzcKlcIndex.this.language_set = position;
                if (RzcKlcIndex.this.language_set >= 0 && RzcKlcIndex.this.language_set <= RzcKlcIndex.this.mLauStylelist.size() && RzcKlcIndex.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{129, RzcKlcIndex.this.send_lang[RzcKlcIndex.this.language_set]}, null, null);
                }
                RzcKlcIndex.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[350];
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

    private void setUI() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.klc_pannel_select7_str));
        this.mLauStylelist.add("2015 GL8 2.4L");
        this.mLauStylelist.add("2020-2024 Regal/LaCrosse");
        this.mLauStylelist.add("2017-2024 Equinox");
        this.mLauStylelist.add("2015 LaCrosse High");
        this.mLauStylelist.add("2011 Meriva B");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.klc.RzcKlcIndex.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcKlcIndex.this.mLauStyle == null) {
                    RzcKlcIndex.this.initLauStyle();
                }
                if (RzcKlcIndex.this.mLauStyle != null && RzcKlcIndex.this.mPopShowView != null) {
                    RzcKlcIndex.this.mLauStyle.showAtLocation(RzcKlcIndex.this.mPopShowView, 17, 0, 0);
                    RzcKlcIndex.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnClickListener(this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_EV /* 7274557 */:
            case FinalCanbus.CAR_RZC_ALL_GM_22VELITE6_PHEV /* 7340093 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view7).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_ALL_GM_HUMMER_09_H2 /* 5308477 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban /* 7471165 */:
            case FinalCanbus.CAR_RZC_ALL_GM_10_23Suburban_H /* 7536701 */:
            case FinalCanbus.CAR_RZC_ALL_GM_HUMMER_09_H3 /* 8912957 */:
            case FinalCanbus.CAR_RZC_ALL_GM_Escalade /* 10092605 */:
                findViewById(R.id.layout_view9).setVisibility(0);
                return;
            default:
                findViewById(R.id.layout_view9).setVisibility(8);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCKlcEVCarInfo.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, RzcKlcAirAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, RzcKlcComfortAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, RZCKlcCarSet2.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                try {
                    Intent intent5 = new Intent();
                    intent5.setClass(this, RzcKlcCarSetAct.class);
                    startActivity(intent5);
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent6 = new Intent();
                    intent6.setClass(this, RzcKlcOnStarAct.class);
                    startActivity(intent6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                try {
                    Intent intent7 = new Intent();
                    intent7.setClass(this, RZCChargeIndexAct.class);
                    startActivity(intent7);
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                try {
                    Intent intent8 = new Intent();
                    intent8.setClass(this, GmAndraTireAct.class);
                    startActivity(intent8);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                try {
                    Intent intent9 = new Intent();
                    intent9.setClass(this, RZCKlcCarAmpSet.class);
                    startActivity(intent9);
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                try {
                    Intent intent10 = new Intent();
                    intent10.setClass(this, RZCGMAHDActi.class);
                    startActivity(intent10);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{67}, null, null);
        DataCanbus.PROXY.cmd(8, new int[]{6}, null, null);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
    }
}
