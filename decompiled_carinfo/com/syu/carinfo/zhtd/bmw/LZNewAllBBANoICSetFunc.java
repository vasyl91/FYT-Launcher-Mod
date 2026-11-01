package com.syu.carinfo.zhtd.bmw;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewAllBBANoICSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 0);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive A(CCC)");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text1)).setText("IDrive B(CCC)");
                            break;
                    }
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("6.5");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("8.8");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text2)).setText("8.8 H");
                            break;
                    }
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_original_car_mode);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.str_installation_mode);
                            break;
                    }
                case 130:
                    switch (value) {
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state0);
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state1);
                            break;
                        case 3:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_aux_activation_state2);
                            break;
                    }
                case 143:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view1).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view2).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view3).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view4).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view5).setVisibility(8);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view3).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view4).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view5).setVisibility(0);
                            break;
                    }
                case 144:
                    LZNewAllBBANoICSetFunc.this.updatemLauStylelist();
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    switch (value) {
                        case 0:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(0);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("bmw");
                            break;
                        case 1:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(8);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("audi");
                            break;
                        case 2:
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view6).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view7).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view8).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view9).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view10).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view18).setVisibility(0);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view20).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view21).setVisibility(8);
                            LZNewAllBBANoICSetFunc.this.findViewById(R.id.layout_view22).setVisibility(8);
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text6)).setText("benz");
                            break;
                    }
                case 145:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    break;
                case 146:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                            break;
                    }
                case 147:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("BT");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("USB");
                            break;
                        case 2:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("AUX");
                            break;
                        case 3:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text9)).setText("TV");
                            break;
                    }
                case 148:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 152:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 153:
                    ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 154:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.0");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text16)).setText("NTG4.5");
                            break;
                    }
                case 155:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 156:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 157:
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                    break;
                case 158:
                    ((CheckedTextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 160:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text17)).setText("CIC");
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text17)).setText("CCC");
                            break;
                    }
                case 161:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text19)).setText(R.string.str_bmw_shortcut_key_types1);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text19)).setText(R.string.str_bmw_shortcut_key_types2);
                            break;
                    }
                case 162:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text18)).setText(R.string.str_bmw_type1);
                            break;
                        case 1:
                            ((TextView) LZNewAllBBANoICSetFunc.this.findViewById(R.id.tv_text18)).setText(R.string.str_bmw_type2);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_bba_noic_setfunc);
        init();
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(0);
        findViewById(R.id.layout_view3).setVisibility(0);
        findViewById(R.id.layout_view4).setVisibility(0);
        findViewById(R.id.layout_view5).setVisibility(0);
        findViewById(R.id.layout_view6).setVisibility(0);
        findViewById(R.id.layout_view7).setVisibility(0);
        findViewById(R.id.layout_view8).setVisibility(0);
        findViewById(R.id.layout_view9).setVisibility(0);
        findViewById(R.id.layout_view10).setVisibility(0);
        findViewById(R.id.layout_view11).setVisibility(0);
        findViewById(R.id.layout_view12).setVisibility(0);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(0);
        findViewById(R.id.layout_view19).setVisibility(0);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllBBANoICSetFunc.this.language_set = position;
                if (LZNewAllBBANoICSetFunc.this.language_set >= 0 && LZNewAllBBANoICSetFunc.this.language_set <= LZNewAllBBANoICSetFunc.this.mLauStylelist.size() && LZNewAllBBANoICSetFunc.this.send_lang != null) {
                    LZNewAllBBANoICSetFunc.this.setCarInfo(5, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    if (DataCanbus.DATA[144] == 0) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(251, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    } else if (DataCanbus.DATA[144] == 1) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(250, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    } else if (DataCanbus.DATA[144] == 2) {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(249, LZNewAllBBANoICSetFunc.this.send_lang[LZNewAllBBANoICSetFunc.this.language_set]);
                    }
                }
                LZNewAllBBANoICSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[155];
        if (DataCanbus.DATA[144] == 1) {
            value = DataCanbus.DATA[157];
        } else if (DataCanbus.DATA[144] == 2) {
            value = DataCanbus.DATA[156];
        }
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

    
    public void updatemLauStylelist() {
        this.mLauStylelist.clear();
        if (DataCanbus.DATA[144] == 1) {
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-L 400x240");
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-H 400x240");
            this.mLauStylelist.add("Audi 09-16 A4L/Q5-H 800x480");
            this.mLauStylelist.add("Audi 17 A4L 400x240");
            this.mLauStylelist.add("Audi 17 A4L 800x480");
            this.mLauStylelist.add("Audi 17 A4L 1024x480");
            this.mLauStylelist.add("Audi 09-16 Q3-H 400x240");
            this.mLauStylelist.add("Audi Other");
            this.send_lang = new int[]{16, 17, 18, 19, 20, 21, 22, 23};
            return;
        }
        if (DataCanbus.DATA[144] == 2) {
            this.mLauStylelist.add("Benz NTG 4.0 576x124");
            this.mLauStylelist.add("Benz NTG 4.0 800x480");
            this.mLauStylelist.add("Benz NTG 4.5/4.7 800x480");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 800x480");
            this.mLauStylelist.add("Benz NTG 5.0/5.1 960x540");
            this.mLauStylelist.add("Benz NTG 4.5 400x240");
            this.mLauStylelist.add("Benz NTG 5.5 1920x720");
            this.mLauStylelist.add("Benz NTG 6.0 1920x720");
            this.mLauStylelist.add("Benz NTG 4.0 400x240");
            this.mLauStylelist.add("Benz Other");
            this.send_lang = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
            return;
        }
        this.mLauStylelist.add("BMW CCC 1");
        this.mLauStylelist.add("BMW CCC 2");
        this.mLauStylelist.add("BMW CCC 3");
        this.mLauStylelist.add("BMW CCC 4");
        this.mLauStylelist.add("BMW CIC 800x480");
        this.mLauStylelist.add("BMW CIC 1280x480");
        this.mLauStylelist.add("BMW NBT 800x480");
        this.mLauStylelist.add("BMW NBT 1280x480");
        this.mLauStylelist.add("BMW EVO 800x480");
        this.mLauStylelist.add("BMW EVO 1280x480");
        this.mLauStylelist.add("BMW EVO 1440x540 1");
        this.mLauStylelist.add("BMW EVO 1440x540 2");
        this.mLauStylelist.add("BMW Other");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        updatemLauStylelist();
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LZNewAllBBANoICSetFunc.this.mLauStyle == null) {
                    LZNewAllBBANoICSetFunc.this.initLauStyle();
                }
                if (LZNewAllBBANoICSetFunc.this.mLauStyle != null && LZNewAllBBANoICSetFunc.this.mPopShowView != null) {
                    LZNewAllBBANoICSetFunc.this.mLauStyle.showAtLocation(LZNewAllBBANoICSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewAllBBANoICSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_aux_activation_progress1));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        LZNewAllBBANoICSetFunc.this.setCarInfo(9, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[127] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[127] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[128] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value6 = DataCanbus.DATA[128] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value7 = DataCanbus.DATA[129] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value8 = DataCanbus.DATA[129] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[143] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(255, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[143] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(255, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[144] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(248, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[144] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(248, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value0 = DataCanbus.DATA[144];
                int value1 = DataCanbus.DATA[145];
                int value22 = DataCanbus.DATA[146];
                int value32 = DataCanbus.DATA[147];
                int value42 = DataCanbus.DATA[148];
                int value13 = value1 - 1;
                if (value13 < 1) {
                    value13 = 8;
                }
                setCarInfo2(value0, value13, ((value22 << 7) & 128) | ((value32 << 4) & 112), value42);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value02 = DataCanbus.DATA[144];
                int value14 = DataCanbus.DATA[145];
                int value23 = DataCanbus.DATA[146];
                int value33 = DataCanbus.DATA[147];
                int value43 = DataCanbus.DATA[148];
                int value15 = value14 + 1;
                if (value15 > 8) {
                    value15 = 1;
                }
                setCarInfo2(value02, value15, ((value23 << 7) & 128) | ((value33 << 4) & 112), value43);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value03 = DataCanbus.DATA[144];
                int value16 = DataCanbus.DATA[145];
                int value24 = DataCanbus.DATA[146];
                int value34 = DataCanbus.DATA[147];
                int value44 = DataCanbus.DATA[148];
                int value25 = value24 - 1;
                if (value25 < 0) {
                    value25 = 1;
                }
                setCarInfo2(value03, value16, ((value25 << 7) & 128) | ((value34 << 4) & 112), value44);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value04 = DataCanbus.DATA[144];
                int value17 = DataCanbus.DATA[145];
                int value26 = DataCanbus.DATA[146];
                int value35 = DataCanbus.DATA[147];
                int value45 = DataCanbus.DATA[148];
                int value27 = value26 + 1;
                if (value27 > 1) {
                    value27 = 0;
                }
                setCarInfo2(value04, value17, ((value27 << 7) & 128) | ((value35 << 4) & 112), value45);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value05 = DataCanbus.DATA[144];
                int value18 = DataCanbus.DATA[145];
                int value28 = DataCanbus.DATA[146];
                int value36 = DataCanbus.DATA[147];
                int value46 = DataCanbus.DATA[148];
                int value37 = value36 - 1;
                if (value37 < 0) {
                    value37 = 3;
                }
                setCarInfo2(value05, value18, ((value28 << 7) & 128) | ((value37 << 4) & 112), value46);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value06 = DataCanbus.DATA[144];
                int value19 = DataCanbus.DATA[145];
                int value29 = DataCanbus.DATA[146];
                int value38 = DataCanbus.DATA[147];
                int value47 = DataCanbus.DATA[148];
                int value39 = value38 + 1;
                if (value39 > 3) {
                    value39 = 0;
                }
                setCarInfo2(value06, value19, ((value29 << 7) & 128) | ((value39 << 4) & 112), value47);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value07 = DataCanbus.DATA[144];
                int value110 = DataCanbus.DATA[145];
                int value210 = DataCanbus.DATA[146];
                int value310 = DataCanbus.DATA[147];
                int value48 = DataCanbus.DATA[148] - 1;
                if (value48 < 1) {
                    value48 = 15;
                }
                setCarInfo2(value07, value110, ((value210 << 7) & 128) | ((value310 << 4) & 112), value48);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value08 = DataCanbus.DATA[144];
                int value111 = DataCanbus.DATA[145];
                int value211 = DataCanbus.DATA[146];
                int value311 = DataCanbus.DATA[147];
                int value49 = DataCanbus.DATA[148] + 1;
                if (value49 > 15) {
                    value49 = 1;
                }
                setCarInfo2(value08, value111, ((value211 << 7) & 128) | ((value311 << 4) & 112), value49);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value20 = DataCanbus.DATA[152];
                if (value20 > 0) {
                    value20--;
                }
                setCarInfo(253, value20);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value21 = DataCanbus.DATA[152];
                if (value21 < 36) {
                    value21++;
                }
                setCarInfo(253, value21);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value30 = DataCanbus.DATA[144] - 1;
                if (value30 < 0) {
                    value30 = 3;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value30}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value31 = DataCanbus.DATA[144] + 1;
                if (value31 > 3) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(49, new int[]{value31}, null, null);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value40 = DataCanbus.DATA[153];
                if (value40 > 0) {
                    value40--;
                }
                setCarInfo(252, value40);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value41 = DataCanbus.DATA[153];
                if (value41 < 36) {
                    value41++;
                }
                setCarInfo(252, value41);
                break;
            case R.id.btn_minus15 /* 2131427515 */:
                int value50 = DataCanbus.DATA[154] - 1;
                if (value50 < 0) {
                    value50 = 1;
                }
                setCarInfo(10, value50);
                break;
            case R.id.btn_plus15 /* 2131427517 */:
                int value51 = DataCanbus.DATA[154] + 1;
                if (value51 > 1) {
                    value51 = 0;
                }
                setCarInfo(10, value51);
                break;
            case R.id.btn_minus16 /* 2131427518 */:
                int value52 = DataCanbus.DATA[160] - 1;
                if (value52 < 0) {
                    value52 = 1;
                }
                setCarInfo(12, value52);
                break;
            case R.id.btn_plus16 /* 2131427520 */:
                int value53 = DataCanbus.DATA[160] + 1;
                if (value53 > 1) {
                    value53 = 0;
                }
                setCarInfo(12, value53);
                break;
            case R.id.btn_minus17 /* 2131427521 */:
                int value54 = DataCanbus.DATA[162] - 1;
                if (value54 < 0) {
                    value54 = 1;
                }
                setCarInfo(245, value54);
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                int value55 = DataCanbus.DATA[162] + 1;
                if (value55 > 1) {
                    value55 = 0;
                }
                setCarInfo(245, value55);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[126] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                dialog();
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[158] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
            case R.id.btn_minus18 /* 2131427894 */:
                int value56 = DataCanbus.DATA[161] - 1;
                if (value56 < 0) {
                    value56 = 1;
                }
                setCarInfo(246, value56);
                break;
            case R.id.btn_plus18 /* 2131427895 */:
                int value57 = DataCanbus.DATA[161] + 1;
                if (value57 > 1) {
                    value57 = 0;
                }
                setCarInfo(246, value57);
                break;
        }
    }

    public void setCarInfo2(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1, value2, value3}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
    }
}
