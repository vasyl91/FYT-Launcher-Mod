package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class LZAudiQ5CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit_juli = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 26:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 0 || value == 255) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value * 0.1f) + "V");
                            break;
                        }
                    }
                    break;
                case 27:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 28:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                            break;
                        }
                    }
                    break;
                case 29:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 30:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("10s");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("20s");
                                break;
                            case 3:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("30s");
                                break;
                            case 4:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("40s");
                                break;
                            case 5:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("50s");
                                break;
                            case 6:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text8)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 31:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 32:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 33:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 34:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 35:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 36:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 37:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 38:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 39:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 40:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 41:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 42:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 43:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 44:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 45:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 46:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 47:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 48:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)).setText("℃");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text14)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 49:
                    LZAudiQ5CarSet.this.unit_juli = value;
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)) != null) {
                        if (value == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)).setText("mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text15)).setText("km");
                            break;
                        }
                    }
                    break;
                case 50:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)).setText("bar");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text16)).setText("psi");
                                break;
                        }
                    }
                    break;
                case 51:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)).setText("km/h");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text17)).setText("mph");
                                break;
                        }
                    }
                    break;
                case 52:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("mpg(uk)");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("mpg(us)");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("L/100km");
                                break;
                            case 3:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text18)).setText("km/L");
                                break;
                        }
                    }
                    break;
                case 53:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("L");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("gal(uk)");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text19)).setText("gal(us)");
                                break;
                        }
                    }
                    break;
                case 54:
                    LZAudiQ5CarSet.this.updateLauguageSet();
                    break;
                case 55:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        int value2 = value * 100;
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + "km");
                            break;
                        }
                    }
                    break;
                case 56:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "Days");
                        break;
                    }
                case 57:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        int value3 = value * 100;
                        if (LZAudiQ5CarSet.this.unit_juli == 1) {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value3) + "mil");
                            break;
                        } else {
                            ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value3) + "km");
                            break;
                        }
                    }
                    break;
                case 58:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "Days");
                        break;
                    }
                case 60:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text22)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text22)).setText(String.valueOf(value) + "/8");
                        break;
                    }
                case 61:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Front");
                                break;
                            case 1:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Middle");
                                break;
                            case 2:
                                ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text20)).setText("Rear");
                                break;
                        }
                    }
                    break;
                case 62:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 63:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 64:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 65:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 66:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 67:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 68:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 69:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 70:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 71:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text21)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text21)).setText(String.valueOf((value * 10) + 30) + "km/h");
                        break;
                    }
                case 72:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 73:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 74:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 75:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 76:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 77:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 78:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 79:
                    LZAudiQ5CarSet.this.setCheck((CheckedTextView) LZAudiQ5CarSet.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 80:
                    if (((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text23)) != null) {
                        ((TextView) LZAudiQ5CarSet.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_audi_q5_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZAudiQ5CarSet.this.language_set = position;
                if (LZAudiQ5CarSet.this.language_set >= 0 && LZAudiQ5CarSet.this.language_set <= LZAudiQ5CarSet.this.mLauStylelist.size() && LZAudiQ5CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{20, LZAudiQ5CarSet.this.send_lang[LZAudiQ5CarSet.this.language_set]}, null, null);
                }
                LZAudiQ5CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[54];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.send_lang = new int[]{0, 1, 2, 3, 4};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZAudiQ5CarSet.this.mLauStyle == null) {
                    LZAudiQ5CarSet.this.initLauStyle();
                }
                if (LZAudiQ5CarSet.this.mLauStyle != null && LZAudiQ5CarSet.this.mPopShowView != null) {
                    LZAudiQ5CarSet.this.mLauStyle.showAtLocation(LZAudiQ5CarSet.this.mPopShowView, 17, 0, 0);
                    LZAudiQ5CarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    protected void dialog2(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{52, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZAudiQ5CarSet.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value = DataCanbus.DATA[61] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(33, value);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value2 = DataCanbus.DATA[61] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(33, value2);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value3 = DataCanbus.DATA[71] - 1;
                if (value3 < 0) {
                    value3 = 21;
                }
                setCarInfo(43, value3);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value4 = DataCanbus.DATA[71] + 1;
                if (value4 > 21) {
                    value4 = 0;
                }
                setCarInfo(43, value4);
                break;
            case R.id.btn_minus15 /* 2131427474 */:
                int value5 = DataCanbus.DATA[80] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(53, value5);
                break;
            case R.id.btn_plus15 /* 2131427476 */:
                int value6 = DataCanbus.DATA[80] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(53, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                dialog(R.string.str_other_set_Maintenance_Reset, 24);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value7 = DataCanbus.DATA[30] - 1;
                if (value7 < 0) {
                    value7 = 6;
                }
                setCarInfo(1, value7);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value8 = DataCanbus.DATA[30] + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                setCarInfo(1, value8);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value9 = DataCanbus.DATA[43];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(14, value9);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value10 = DataCanbus.DATA[43];
                if (value10 < 100) {
                    value10++;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value11 = DataCanbus.DATA[44];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(15, value11);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value12 = DataCanbus.DATA[44];
                if (value12 < 9) {
                    value12++;
                }
                setCarInfo(15, value12);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value13 = DataCanbus.DATA[45];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(16, value13);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value14 = DataCanbus.DATA[45];
                if (value14 < 9) {
                    value14++;
                }
                setCarInfo(16, value14);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value15 = DataCanbus.DATA[46];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(17, value15);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value16 = DataCanbus.DATA[46];
                if (value16 < 9) {
                    value16++;
                }
                setCarInfo(17, value16);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value17 = DataCanbus.DATA[47];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo(18, value17);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value18 = DataCanbus.DATA[47];
                if (value18 < 9) {
                    value18++;
                }
                setCarInfo(18, value18);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value19 = DataCanbus.DATA[48] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(19, value19);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value20 = DataCanbus.DATA[48] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(19, value20);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value21 = DataCanbus.DATA[49] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(31, value21);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value22 = DataCanbus.DATA[49] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(31, value22);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value23 = DataCanbus.DATA[50] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(21, value23);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value24 = DataCanbus.DATA[50] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(21, value24);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value25 = DataCanbus.DATA[51] - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo(32, value25);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value26 = DataCanbus.DATA[51] + 1;
                if (value26 > 1) {
                    value26 = 0;
                }
                setCarInfo(32, value26);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value27 = DataCanbus.DATA[52] - 1;
                if (value27 < 0) {
                    value27 = 3;
                }
                setCarInfo(22, value27);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value28 = DataCanbus.DATA[52] + 1;
                if (value28 > 3) {
                    value28 = 0;
                }
                setCarInfo(22, value28);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value29 = DataCanbus.DATA[53] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(23, value29);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value30 = DataCanbus.DATA[53] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(23, value30);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value31 = DataCanbus.DATA[29];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(0, value31);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value32 = DataCanbus.DATA[31];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(2, value32);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value33 = DataCanbus.DATA[32];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(3, value33);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value34 = DataCanbus.DATA[33];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(4, value34);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value35 = DataCanbus.DATA[34];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(5, value35);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value36 = DataCanbus.DATA[35];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(6, value36);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value37 = DataCanbus.DATA[36];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(7, value37);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value38 = DataCanbus.DATA[37];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(8, value38);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value39 = DataCanbus.DATA[38];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(9, value39);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value40 = DataCanbus.DATA[39];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(10, value40);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value41 = DataCanbus.DATA[40];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(11, value41);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value42 = DataCanbus.DATA[41];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(12, value42);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value43 = DataCanbus.DATA[42];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(13, value43);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                dialog(R.string.str_store_tire_pressures, 29);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                dialog(R.string.str_initialize_tires, 30);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value44 = DataCanbus.DATA[62];
                if (value44 == 1) {
                    value44 = 0;
                } else if (value44 == 0) {
                    value44 = 1;
                }
                setCarInfo(34, value44);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value45 = DataCanbus.DATA[63];
                if (value45 == 1) {
                    value45 = 0;
                } else if (value45 == 0) {
                    value45 = 1;
                }
                setCarInfo(35, value45);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value46 = DataCanbus.DATA[64];
                if (value46 == 1) {
                    value46 = 0;
                } else if (value46 == 0) {
                    value46 = 1;
                }
                setCarInfo(36, value46);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value47 = DataCanbus.DATA[65];
                if (value47 == 1) {
                    value47 = 0;
                } else if (value47 == 0) {
                    value47 = 1;
                }
                setCarInfo(37, value47);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value48 = DataCanbus.DATA[66];
                if (value48 == 1) {
                    value48 = 0;
                } else if (value48 == 0) {
                    value48 = 1;
                }
                setCarInfo(38, value48);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value49 = DataCanbus.DATA[67];
                if (value49 == 1) {
                    value49 = 0;
                } else if (value49 == 0) {
                    value49 = 1;
                }
                setCarInfo(39, value49);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value50 = DataCanbus.DATA[68];
                if (value50 == 1) {
                    value50 = 0;
                } else if (value50 == 0) {
                    value50 = 1;
                }
                setCarInfo(40, value50);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                int value51 = DataCanbus.DATA[69];
                if (value51 == 1) {
                    value51 = 0;
                } else if (value51 == 0) {
                    value51 = 1;
                }
                setCarInfo(41, value51);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                int value52 = DataCanbus.DATA[70];
                if (value52 == 1) {
                    value52 = 0;
                } else if (value52 == 0) {
                    value52 = 1;
                }
                setCarInfo(42, value52);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                int value53 = DataCanbus.DATA[72];
                if (value53 == 1) {
                    value53 = 0;
                } else if (value53 == 0) {
                    value53 = 1;
                }
                setCarInfo(44, value53);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                int value54 = DataCanbus.DATA[73];
                if (value54 == 1) {
                    value54 = 0;
                } else if (value54 == 0) {
                    value54 = 1;
                }
                setCarInfo(45, value54);
                break;
            case R.id.ctv_checkedtext32 /* 2131427876 */:
                int value55 = DataCanbus.DATA[77];
                if (value55 == 1) {
                    value55 = 0;
                } else if (value55 == 0) {
                    value55 = 1;
                }
                setCarInfo(49, value55);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                int value56 = DataCanbus.DATA[74];
                if (value56 == 1) {
                    value56 = 0;
                } else if (value56 == 0) {
                    value56 = 1;
                }
                setCarInfo(46, value56);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                int value57 = DataCanbus.DATA[75];
                if (value57 == 1) {
                    value57 = 0;
                } else if (value57 == 0) {
                    value57 = 1;
                }
                setCarInfo(47, value57);
                break;
            case R.id.ctv_checkedtext31 /* 2131427887 */:
                int value58 = DataCanbus.DATA[76];
                if (value58 == 1) {
                    value58 = 0;
                } else if (value58 == 0) {
                    value58 = 1;
                }
                setCarInfo(48, value58);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                dialog2(R.string.str_car_computer_5, 0);
                break;
            case R.id.ctv_checkedtext33 /* 2131428103 */:
                int value59 = DataCanbus.DATA[78];
                if (value59 == 1) {
                    value59 = 0;
                } else if (value59 == 0) {
                    value59 = 1;
                }
                setCarInfo(50, value59);
                break;
            case R.id.ctv_checkedtext34 /* 2131428383 */:
                int value60 = DataCanbus.DATA[79];
                if (value60 == 1) {
                    value60 = 0;
                } else if (value60 == 0) {
                    value60 = 1;
                }
                setCarInfo(51, value60);
                break;
            case R.id.ctv_checkedtext35 /* 2131428385 */:
                dialog2(R.string.str_car_computer_10, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{13}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{14}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{15}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{125}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{126}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
    }
}
