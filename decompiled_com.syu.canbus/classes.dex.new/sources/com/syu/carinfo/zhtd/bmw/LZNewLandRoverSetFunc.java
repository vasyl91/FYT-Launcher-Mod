package com.syu.carinfo.zhtd.bmw;

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
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_LandRover_KeepCD;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LZNewLandRoverSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_LandRover_KeepCD.modevalue = ints[2];
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 111:
                case 112:
                    int w = DataCanbus.DATA[111];
                    int h = DataCanbus.DATA[112];
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                    break;
                case 113:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 114:
                    ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 121:
                    LZNewLandRoverSetFunc.this.updateLauguageSet();
                    break;
                case 122:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("13-16 Range Rover");
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("13-15 EVOQUE");
                            break;
                        case 2:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text1)).setText("12 EVOQUE");
                            break;
                    }
                    break;
                case 125:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                    break;
                case 126:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                    break;
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                    break;
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_currency);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_dedicated);
                            break;
                    }
                    break;
                case 131:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_currency);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text8)).setText("XJL");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_landrover_setfunc);
        init();
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
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewLandRoverSetFunc.this.language_set = position;
                if (LZNewLandRoverSetFunc.this.language_set >= 0 && LZNewLandRoverSetFunc.this.language_set <= LZNewLandRoverSetFunc.this.mLauStylelist.size() && LZNewLandRoverSetFunc.this.send_lang != null) {
                    LZNewLandRoverSetFunc.this.setCarInfo(250, LZNewLandRoverSetFunc.this.language_set);
                    if (LZNewLandRoverSetFunc.this.readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || LZNewLandRoverSetFunc.this.readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
                        switch (LZNewLandRoverSetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 4, 0, 0}, null, null);
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 5, 0, 0}, null, null);
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 6, 0, 0}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 16, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                if (Callback_0453_LZ_LandRover_KeepCD.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 11, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1, 0, 0}, null, null);
                                if (Callback_0453_LZ_LandRover_KeepCD.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                        }
                    }
                }
                LZNewLandRoverSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[121];
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
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            this.mLauStylelist.add("LR-Bose 800x480 G100");
            this.mLauStylelist.add("LR-Bose 800x480-1 G100");
            this.mLauStylelist.add("LR-Bose 800x480-2 G100");
            this.mLauStylelist.add("LR-Haman 1280x540  I300");
            this.mLauStylelist.add("LR-Haman 800x480  I300");
            this.send_lang = new int[]{0, 1, 2, 3, 4};
        } else {
            this.mLauStylelist.add("LR-Bose 800x480-1");
            this.mLauStylelist.add("LR-Bose 800x480-2");
            this.mLauStylelist.add("LR-Bose 800x480-3");
            this.mLauStylelist.add("LR-Bose 800x480-4");
            this.mLauStylelist.add("LR-Haman 800x480-1");
            this.mLauStylelist.add("LR-Haman 800x480-2");
            this.mLauStylelist.add("LR-Haman 800x480-3");
            this.mLauStylelist.add("LR-Haman 800x480-4");
            this.mLauStylelist.add("LR-Haman 1280x540-1");
            this.mLauStylelist.add("LR-Haman 1280x540-2");
            this.mLauStylelist.add("Other");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewLandRoverSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewLandRoverSetFunc.this.mLauStyle == null) {
                    LZNewLandRoverSetFunc.this.initLauStyle();
                }
                if (LZNewLandRoverSetFunc.this.mLauStyle != null && LZNewLandRoverSetFunc.this.mPopShowView != null) {
                    LZNewLandRoverSetFunc.this.mLauStyle.showAtLocation(LZNewLandRoverSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewLandRoverSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[122] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(249, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[122] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(249, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
            case R.id.btn_plus2 /* 2131427461 */:
                int bit7 = DataCanbus.DATA[125];
                int bit6 = DataCanbus.DATA[126];
                int bit5 = DataCanbus.DATA[127];
                int bit4 = DataCanbus.DATA[128];
                int bit3 = DataCanbus.DATA[129];
                int bit2 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit2 = 1;
                }
                int bit1 = DataCanbus.DATA[130];
                int bit0 = DataCanbus.DATA[131];
                if (bit7 == 1) {
                    bit7 = 0;
                } else if (bit7 == 0) {
                    bit7 = 1;
                }
                setCarInfo(248, ((bit7 << 7) & 128) | ((bit6 << 6) & 64) | ((bit5 << 5) & 32) | ((bit4 << 4) & 16) | ((bit3 << 3) & 8) | ((bit2 << 2) & 64) | ((bit1 << 1) & 2) | (bit0 & 1));
                break;
            case R.id.btn_minus3 /* 2131427462 */:
            case R.id.btn_plus3 /* 2131427464 */:
                int bit8 = DataCanbus.DATA[125];
                int bit9 = DataCanbus.DATA[126];
                int bit10 = DataCanbus.DATA[127];
                int bit11 = DataCanbus.DATA[128];
                int bit12 = DataCanbus.DATA[129];
                int bit13 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit13 = 1;
                }
                int bit14 = DataCanbus.DATA[130];
                int bit15 = DataCanbus.DATA[131];
                if (bit9 == 1) {
                    bit9 = 0;
                } else if (bit9 == 0) {
                    bit9 = 1;
                }
                setCarInfo(248, ((bit8 << 7) & 128) | ((bit9 << 6) & 64) | ((bit10 << 5) & 32) | ((bit11 << 4) & 16) | ((bit12 << 3) & 8) | ((bit13 << 2) & 64) | ((bit14 << 1) & 2) | (bit15 & 1));
                break;
            case R.id.btn_minus4 /* 2131427465 */:
            case R.id.btn_plus4 /* 2131427467 */:
                int bit16 = DataCanbus.DATA[125];
                int bit17 = DataCanbus.DATA[126];
                int bit18 = DataCanbus.DATA[127];
                int bit19 = DataCanbus.DATA[128];
                int bit20 = DataCanbus.DATA[129];
                int bit21 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit21 = 1;
                }
                int bit22 = DataCanbus.DATA[130];
                int bit23 = DataCanbus.DATA[131];
                if (bit18 == 1) {
                    bit18 = 0;
                } else if (bit18 == 0) {
                    bit18 = 1;
                }
                setCarInfo(248, ((bit16 << 7) & 128) | ((bit17 << 6) & 64) | ((bit18 << 5) & 32) | ((bit19 << 4) & 16) | ((bit20 << 3) & 8) | ((bit21 << 2) & 64) | ((bit22 << 1) & 2) | (bit23 & 1));
                break;
            case R.id.btn_minus5 /* 2131427468 */:
            case R.id.btn_plus5 /* 2131427470 */:
                int bit24 = DataCanbus.DATA[125];
                int bit25 = DataCanbus.DATA[126];
                int bit26 = DataCanbus.DATA[127];
                int bit27 = DataCanbus.DATA[128];
                int bit28 = DataCanbus.DATA[129];
                int bit29 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit29 = 1;
                }
                int bit30 = DataCanbus.DATA[130];
                int bit31 = DataCanbus.DATA[131];
                if (bit27 == 1) {
                    bit27 = 0;
                } else if (bit27 == 0) {
                    bit27 = 1;
                }
                setCarInfo(248, ((bit24 << 7) & 128) | ((bit25 << 6) & 64) | ((bit26 << 5) & 32) | ((bit27 << 4) & 16) | ((bit28 << 3) & 8) | ((bit29 << 2) & 64) | ((bit30 << 1) & 2) | (bit31 & 1));
                break;
            case R.id.btn_minus6 /* 2131427471 */:
            case R.id.btn_plus6 /* 2131427473 */:
                int bit32 = DataCanbus.DATA[125];
                int bit33 = DataCanbus.DATA[126];
                int bit34 = DataCanbus.DATA[127];
                int bit35 = DataCanbus.DATA[128];
                int bit36 = DataCanbus.DATA[129];
                int bit37 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit37 = 1;
                }
                int bit38 = DataCanbus.DATA[130];
                int bit39 = DataCanbus.DATA[131];
                if (bit36 == 1) {
                    bit36 = 0;
                } else if (bit36 == 0) {
                    bit36 = 1;
                }
                setCarInfo(248, ((bit32 << 7) & 128) | ((bit33 << 6) & 64) | ((bit34 << 5) & 32) | ((bit35 << 4) & 16) | ((bit36 << 3) & 8) | ((bit37 << 2) & 64) | ((bit38 << 1) & 2) | (bit39 & 1));
                break;
            case R.id.btn_minus7 /* 2131427474 */:
            case R.id.btn_plus7 /* 2131427476 */:
                int bit40 = DataCanbus.DATA[125];
                int bit41 = DataCanbus.DATA[126];
                int bit42 = DataCanbus.DATA[127];
                int bit43 = DataCanbus.DATA[128];
                int bit44 = DataCanbus.DATA[129];
                int bit45 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit45 = 1;
                }
                int bit46 = DataCanbus.DATA[130];
                int bit47 = DataCanbus.DATA[131];
                if (bit46 == 1) {
                    bit46 = 0;
                } else if (bit46 == 0) {
                    bit46 = 1;
                }
                setCarInfo(248, ((bit40 << 7) & 128) | ((bit41 << 6) & 64) | ((bit42 << 5) & 32) | ((bit43 << 4) & 16) | ((bit44 << 3) & 8) | ((bit45 << 2) & 64) | ((bit46 << 1) & 2) | (bit47 & 1));
                break;
            case R.id.btn_minus8 /* 2131427477 */:
            case R.id.btn_plus8 /* 2131427479 */:
                int bit48 = DataCanbus.DATA[125];
                int bit49 = DataCanbus.DATA[126];
                int bit50 = DataCanbus.DATA[127];
                int bit51 = DataCanbus.DATA[128];
                int bit52 = DataCanbus.DATA[129];
                int bit53 = 0;
                if (TheApp.getConfiguration() == 1) {
                    bit53 = 1;
                }
                int bit54 = DataCanbus.DATA[130];
                int bit55 = DataCanbus.DATA[131];
                if (bit55 == 1) {
                    bit55 = 0;
                } else if (bit55 == 0) {
                    bit55 = 1;
                }
                setCarInfo(248, ((bit48 << 7) & 128) | ((bit49 << 6) & 64) | ((bit50 << 5) & 32) | ((bit51 << 4) & 16) | ((bit52 << 3) & 8) | ((bit53 << 2) & 64) | ((bit54 << 1) & 2) | (bit55 & 1));
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value3 = DataCanbus.DATA[110] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(254, value3);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value4 = DataCanbus.DATA[110] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(254, value4);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value5 = DataCanbus.DATA[113];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(253, value5);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value6 = DataCanbus.DATA[113];
                if (value6 < 36) {
                    value6++;
                }
                setCarInfo(253, value6);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value7 = DataCanbus.DATA[114];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(252, value7);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value8 = DataCanbus.DATA[114];
                if (value8 < 36) {
                    value8++;
                }
                setCarInfo(252, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZNewLandRoverCarinfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                DataCanbus.PROXY.cmd(3, new int[]{91, 1}, null, null);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                DataCanbus.PROXY.cmd(3, new int[]{91, 0}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
    }
}
