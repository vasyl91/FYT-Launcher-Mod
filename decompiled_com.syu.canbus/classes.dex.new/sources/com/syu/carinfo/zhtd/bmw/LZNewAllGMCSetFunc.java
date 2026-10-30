package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
public class LZNewAllGMCSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        int i = ints[1];
                    }
                    break;
            }
        }
    };
    int mileunit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 99:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 100:
                    ((CheckedTextView) LZNewAllGMCSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 101:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 102:
                case 103:
                    int w = DataCanbus.DATA[102];
                    int h = DataCanbus.DATA[103];
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                    break;
                case 104:
                    if (LZNewAllGMCSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 105:
                    if (LZNewAllGMCSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 106:
                    if (value == 255) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    }
                    break;
                case 108:
                    LZNewAllGMCSetFunc.this.mileunit = value;
                    break;
                case 109:
                    if (value == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("8 inches");
                    } else if (value == 2) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("8 inches-2");
                    } else if (value == 3) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("7 inches-2");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("7 inches");
                    }
                    break;
                case 110:
                    LZNewAllGMCSetFunc.this.updateLauguageSet();
                    break;
                case 111:
                    if (value == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_gmc_screen_setfunc);
        init();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        findViewById(R.id.layout_view14).setVisibility(8);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZNewAllGMCSetFunc.this.language_set = position;
                if (LZNewAllGMCSetFunc.this.language_set >= 0 && LZNewAllGMCSetFunc.this.language_set <= LZNewAllGMCSetFunc.this.mLauStylelist.size() && LZNewAllGMCSetFunc.this.send_lang != null) {
                    LZNewAllGMCSetFunc.this.setCarInfo(250, LZNewAllGMCSetFunc.this.language_set);
                    if (LZNewAllGMCSetFunc.this.readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || LZNewAllGMCSetFunc.this.readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
                        switch (LZNewAllGMCSetFunc.this.language_set) {
                            case 0:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 20, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                                }
                                break;
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 10, 0, 0}, null, null);
                                break;
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 11, 0, 0}, null, null);
                                break;
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 25, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 12, 0, 0}, null, null);
                                break;
                            case 4:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 13, 0, 0}, null, null);
                                break;
                            case 5:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, -2, 13, 0, 0}, null, null);
                                break;
                        }
                    } else {
                        DataCanbus.PROXY.cmd(3, new int[]{LZNewAllGMCSetFunc.this.send_lang[LZNewAllGMCSetFunc.this.language_set]}, null, null);
                    }
                }
                LZNewAllGMCSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[110];
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

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            this.mLauStylelist.add("GM  1280x768 T700");
            this.mLauStylelist.add("GM  800x480 T700");
            this.mLauStylelist.add("GM  800x480 T700-1");
            this.mLauStylelist.add("GM  800x480 T700-2");
            this.mLauStylelist.add("GM  800x480 T700-3");
            this.mLauStylelist.add("GM  NULL");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        } else {
            this.mLauStylelist.add("800x480 1");
            this.mLauStylelist.add("800x480 2");
            this.mLauStylelist.add("800x480 3");
            this.mLauStylelist.add("800x480 4");
            this.mLauStylelist.add("800x480 5");
            this.mLauStylelist.add("800x240 1");
            this.mLauStylelist.add("800x240 2");
            this.mLauStylelist.add("800x240 3");
            this.mLauStylelist.add("800x240 4");
            this.mLauStylelist.add("800x240 5");
            this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZNewAllGMCSetFunc.this.mLauStyle == null) {
                    LZNewAllGMCSetFunc.this.initLauStyle();
                }
                if (LZNewAllGMCSetFunc.this.mLauStyle != null && LZNewAllGMCSetFunc.this.mPopShowView != null) {
                    LZNewAllGMCSetFunc.this.mLauStyle.showAtLocation(LZNewAllGMCSetFunc.this.mPopShowView, 17, 0, 0);
                    LZNewAllGMCSetFunc.this.updateLauguageSet();
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
        int value;
        switch (v.getId()) {
            case R.id.btn_minus4 /* 2131427465 */:
                int value2 = DataCanbus.DATA[109] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value3 = DataCanbus.DATA[109] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value4 = DataCanbus.DATA[111] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(246, value4);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value5 = DataCanbus.DATA[111] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(246, value5);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value6 = DataCanbus.DATA[101] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(254, value6);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value7 = DataCanbus.DATA[101] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(254, value7);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value8 = DataCanbus.DATA[98];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(253, value8);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value9 = DataCanbus.DATA[98];
                if (value9 < 36) {
                    value9++;
                }
                setCarInfo(253, value9);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value10 = DataCanbus.DATA[99];
                if (value10 > 0) {
                    value10--;
                }
                setCarInfo(252, value10);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value11 = DataCanbus.DATA[99];
                if (value11 < 36) {
                    value11++;
                }
                setCarInfo(252, value11);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZNewAllGMCCarinfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[100] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(7, new int[]{53, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
    }
}
