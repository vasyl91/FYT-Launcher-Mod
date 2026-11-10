package com.syu.carinfo.rzc.sanlin;

import android.content.Intent;
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
import com.syu.module.canbus.Callback_0453_LZ_BBA_All;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzBenzC200CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_drivemode;
    int[] send_lang;
    int cmdtype = 0;
    int language_set = 255;
    int drivemode_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LuzBenzC200CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    LuzBenzC200CarSet.this.setCheck((CheckedTextView) LuzBenzC200CarSet.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 99:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 100:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 101:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 102:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 103:
                    if (value == 1) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text5)).setText("On");
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text5)).setText("Off");
                    }
                    break;
                case 104:
                    if (value == 1) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text6)).setText("On");
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text6)).setText("Off");
                    }
                    break;
                case 105:
                    switch (value) {
                        case 0:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Auto");
                            break;
                        case 1:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Sport");
                            break;
                        case 2:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Offroad1");
                            break;
                        case 3:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Offroad2");
                            break;
                        case 4:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Snow");
                            break;
                        case 5:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text7)).setText("Trailer");
                            break;
                    }
                    break;
                case 106:
                    switch (value) {
                        case 4:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text8)).setText("-1");
                            break;
                        default:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                    break;
                case 107:
                    switch ((value >> 7) & 1) {
                        case 0:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text18)).setText("L " + (value & 127));
                            break;
                        case 1:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text18)).setText("R " + (value & 127));
                            break;
                    }
                    break;
                case 108:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "°");
                    break;
                case 109:
                    switch ((value >> 7) & 1) {
                        case 0:
                            if (value == 0) {
                                ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text10)).setText("0");
                            } else {
                                ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text10)).setText("-" + (value & 127));
                            }
                            break;
                        case 1:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text10)).setText("+" + (value & 127));
                            break;
                    }
                    break;
                case 110:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
                case 111:
                    switch ((value >> 7) & 1) {
                        case 0:
                            if (value == 0) {
                                ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text12)).setText("0");
                            } else {
                                ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text12)).setText("-" + (value & 127));
                            }
                            break;
                        case 1:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text12)).setText("+" + (value & 127));
                            break;
                    }
                    break;
                case 112:
                    if (value > 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text13)).setText("+" + (value - 128));
                    } else if (value < 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text13)).setText("-" + (128 - value));
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text13)).setText("0");
                    }
                    break;
                case 113:
                    if (value > 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text14)).setText("+" + (value - 128));
                    } else if (value < 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text14)).setText("-" + (128 - value));
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text14)).setText("0");
                    }
                    break;
                case 114:
                    if (value > 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text15)).setText("+" + (value - 128));
                    } else if (value < 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text15)).setText("-" + (128 - value));
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text15)).setText("0");
                    }
                    break;
                case 115:
                    if (value > 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text16)).setText("+" + (value - 128));
                    } else if (value < 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text16)).setText("-" + (128 - value));
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text16)).setText("0");
                    }
                    break;
                case 116:
                    if (value > 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text17)).setText("+" + (value - 128));
                    } else if (value < 128) {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text17)).setText("-" + (128 - value));
                    } else {
                        ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text17)).setText("0");
                    }
                    break;
                case 132:
                case 133:
                    int w = DataCanbus.DATA[132];
                    int h = DataCanbus.DATA[133];
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text20)).setText(String.valueOf(w) + " X " + h);
                    break;
                case 134:
                    ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text21)).setText(new StringBuilder().append(value).toString());
                    break;
                case 135:
                    LuzBenzC200CarSet.this.drivemode_set = value;
                    switch (value) {
                        case 0:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 4.0 576x124 M200");
                            break;
                        case 1:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 4.0 800x480 M200");
                            break;
                        case 2:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 4.5/4.7 800x480 T400");
                            break;
                        case 3:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 5.0/5.1 800x480 M300");
                            break;
                        case 4:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 5.0/5.1 960x540 M300");
                            break;
                        case 5:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 4.5/4.7 400x240 T400");
                            break;
                        case 6:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 5.5 1920x720 M400");
                            break;
                        case 7:
                            ((TextView) LuzBenzC200CarSet.this.findViewById(R.id.tv_text19)).setText("Benz NTG 6.0 1920x720 M400");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_luz_benz_c00_settings);
        init();
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzBenzC200CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (LuzBenzC200CarSet.this.cmdtype) {
                    case 1:
                        LuzBenzC200CarSet.this.language_set = position;
                        if (LuzBenzC200CarSet.this.language_set >= 0 && LuzBenzC200CarSet.this.language_set <= LuzBenzC200CarSet.this.mLauStylelist.size() && LuzBenzC200CarSet.this.send_lang != null) {
                            DataCanbus.PROXY.cmd(1, new int[]{LuzBenzC200CarSet.this.send_lang[LuzBenzC200CarSet.this.language_set]}, null, null);
                        }
                        break;
                    case 2:
                        LuzBenzC200CarSet.this.drivemode_set = position;
                        if (LuzBenzC200CarSet.this.drivemode_set >= 0 && LuzBenzC200CarSet.this.drivemode_set <= LuzBenzC200CarSet.this.mLauStylelist.size() && LuzBenzC200CarSet.this.send_drivemode != null) {
                            LuzBenzC200CarSet.this.setCarInfoNew(249, LuzBenzC200CarSet.this.drivemode_set);
                            switch (LuzBenzC200CarSet.this.drivemode_set) {
                                case 0:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 1, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                    break;
                                case 1:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                    break;
                                case 2:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                    break;
                                case 3:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 12, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                    break;
                                case 4:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 13, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                    break;
                                case 5:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 22, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                    break;
                                case 6:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 28, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                    break;
                                case 7:
                                    DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 2, 28, 0, 0}, null, null);
                                    DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                    break;
                            }
                            if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[134] != 0) {
                                LuzBenzC200CarSet.this.setCarInfoNew(254, 0);
                            }
                        }
                        break;
                }
                LuzBenzC200CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void setCarInfoNew(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    public void updateLauguageModeSet(int index) {
        if (index >= 0 && index < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(index, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmDrivemodeStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("Benz NTG 4.0 576x124 M200");
        this.mLauStylelist.add("Benz NTG 4.0 800x480 M200");
        this.mLauStylelist.add("Benz NTG 4.5/4.7 800x480 T400");
        this.mLauStylelist.add("Benz NTG 5.0/5.1 800x480 M300");
        this.mLauStylelist.add("Benz NTG 5.0/5.1 960x540 M300");
        this.mLauStylelist.add("Benz NTG 4.5/4.7 400x240 T400");
        this.mLauStylelist.add("Benz NTG 5.5 1920x720 M400");
        this.mLauStylelist.add("Benz NTG 6.0 1920x720 M400");
        this.send_drivemode = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzBenzC200CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LuzBenzC200CarSet.this.initmLauStylelist();
                LuzBenzC200CarSet.this.cmdtype = 1;
                if (LuzBenzC200CarSet.this.mLauStyle == null) {
                    LuzBenzC200CarSet.this.initLauStyle();
                }
                if (LuzBenzC200CarSet.this.mLauStyle != null && LuzBenzC200CarSet.this.mPopShowView != null) {
                    LuzBenzC200CarSet.this.mLauStyle.showAtLocation(LuzBenzC200CarSet.this.mPopShowView, 17, 0, 0);
                    LuzBenzC200CarSet.this.updateLauguageModeSet(LuzBenzC200CarSet.this.language_set);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LuzBenzC200CarSet.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LuzBenzC200CarSet.this.initmDrivemodeStylelist();
                LuzBenzC200CarSet.this.cmdtype = 2;
                if (LuzBenzC200CarSet.this.mLauStyle == null) {
                    LuzBenzC200CarSet.this.initLauStyle();
                }
                if (LuzBenzC200CarSet.this.mLauStyle != null && LuzBenzC200CarSet.this.mPopShowView != null) {
                    LuzBenzC200CarSet.this.mLauStyle.showAtLocation(LuzBenzC200CarSet.this.mPopShowView, 17, 0, 0);
                    LuzBenzC200CarSet.this.updateLauguageModeSet(LuzBenzC200CarSet.this.drivemode_set);
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
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        if (DataCanbus.DATA[1000] == 8192455) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            findViewById(R.id.layout_view17).setVisibility(0);
            findViewById(R.id.layout_view18).setVisibility(0);
            findViewById(R.id.layout_view19).setVisibility(0);
        } else {
            findViewById(R.id.layout_view17).setVisibility(8);
            findViewById(R.id.layout_view18).setVisibility(8);
            findViewById(R.id.layout_view19).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 10027463) {
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
            findViewById(R.id.layout_view11).setVisibility(8);
            findViewById(R.id.layout_view12).setVisibility(8);
            findViewById(R.id.layout_view13).setVisibility(8);
            findViewById(R.id.layout_view14).setVisibility(8);
            findViewById(R.id.layout_view15).setVisibility(8);
            findViewById(R.id.layout_view16).setVisibility(8);
            findViewById(R.id.layout_text_view2).setVisibility(8);
            return;
        }
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
        findViewById(R.id.layout_view13).setVisibility(0);
        findViewById(R.id.layout_view14).setVisibility(0);
        findViewById(R.id.layout_view15).setVisibility(0);
        findViewById(R.id.layout_view16).setVisibility(0);
        findViewById(R.id.layout_text_view2).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int d0_b7 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b70 = DataCanbus.DATA[99];
                int d2_b70 = DataCanbus.DATA[100];
                int d3_b70 = DataCanbus.DATA[101];
                int d4_b70 = DataCanbus.DATA[102];
                int d1_b71 = d1_b70 - 5;
                if (d1_b71 < 0) {
                    d1_b71 = 0;
                }
                setCarInfo((d0_b7 << 7) & 128, d1_b71, d2_b70, d3_b70, d4_b70);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int d0_b8 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b72 = DataCanbus.DATA[99];
                int d2_b71 = DataCanbus.DATA[100];
                int d3_b71 = DataCanbus.DATA[101];
                int d4_b71 = DataCanbus.DATA[102];
                int d1_b73 = d1_b72 + 5;
                if (d1_b73 > 100) {
                    d1_b73 = 100;
                }
                setCarInfo((d0_b8 << 7) & 128, d1_b73, d2_b71, d3_b71, d4_b71);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int d0_b9 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b74 = DataCanbus.DATA[99];
                int d2_b72 = DataCanbus.DATA[100];
                int d3_b72 = DataCanbus.DATA[101];
                int d4_b72 = DataCanbus.DATA[102];
                int d2_b73 = d2_b72 - 10;
                if (d2_b73 < 0) {
                    d2_b73 = 0;
                }
                setCarInfo((d0_b9 << 7) & 128, d1_b74, d2_b73, d3_b72, d4_b72);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int d0_b10 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b75 = DataCanbus.DATA[99];
                int d2_b74 = DataCanbus.DATA[100];
                int d3_b73 = DataCanbus.DATA[101];
                int d4_b73 = DataCanbus.DATA[102];
                int d2_b75 = d2_b74 + 10;
                if (d2_b75 > 255) {
                    d2_b75 = 255;
                }
                setCarInfo((d0_b10 << 7) & 128, d1_b75, d2_b75, d3_b73, d4_b73);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int d0_b11 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b76 = DataCanbus.DATA[99];
                int d2_b76 = DataCanbus.DATA[100];
                int d3_b74 = DataCanbus.DATA[101];
                int d4_b74 = DataCanbus.DATA[102];
                int d3_b75 = d3_b74 - 10;
                if (d3_b75 < 0) {
                    d3_b75 = 0;
                }
                setCarInfo((d0_b11 << 7) & 128, d1_b76, d2_b76, d3_b75, d4_b74);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int d0_b12 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b77 = DataCanbus.DATA[99];
                int d2_b77 = DataCanbus.DATA[100];
                int d3_b76 = DataCanbus.DATA[101];
                int d4_b75 = DataCanbus.DATA[102];
                int d3_b77 = d3_b76 + 10;
                if (d3_b77 > 255) {
                    d3_b77 = 255;
                }
                setCarInfo((d0_b12 << 7) & 128, d1_b77, d2_b77, d3_b77, d4_b75);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int d0_b13 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b78 = DataCanbus.DATA[99];
                int d2_b78 = DataCanbus.DATA[100];
                int d3_b78 = DataCanbus.DATA[101];
                int d4_b76 = DataCanbus.DATA[102] - 10;
                if (d4_b76 < 0) {
                    d4_b76 = 0;
                }
                setCarInfo((d0_b13 << 7) & 128, d1_b78, d2_b78, d3_b78, d4_b76);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int d0_b14 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b79 = DataCanbus.DATA[99];
                int d2_b79 = DataCanbus.DATA[100];
                int d3_b79 = DataCanbus.DATA[101];
                int d4_b77 = DataCanbus.DATA[102] + 10;
                if (d4_b77 > 255) {
                    d4_b77 = 255;
                }
                setCarInfo((d0_b14 << 7) & 128, d1_b79, d2_b79, d3_b79, d4_b77);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int d0_b15 = (DataCanbus.DATA[98] >> 7) & 1;
                int d1_b710 = DataCanbus.DATA[99];
                int d2_b710 = DataCanbus.DATA[100];
                int d3_b710 = DataCanbus.DATA[101];
                int d4_b78 = DataCanbus.DATA[102];
                if (d0_b15 == 1) {
                    d0_b15 = 0;
                } else if (d0_b15 == 0) {
                    d0_b15 = 1;
                }
                setCarInfo((d0_b15 << 7) & 128, d1_b710, d2_b710, d3_b710, d4_b78);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZBenzC200NTG5CarSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2, value3, value4, value5}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }
}
