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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class LZHondaSceenCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int[] send_lvdsmode;
    int cmdtype = 0;
    int language_set = 255;
    int lvdsmode_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    switch (val) {
                        case 0:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("800*480_1");
                            break;
                        case 1:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("800*480_2");
                            break;
                        case 2:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("800*480_3");
                            break;
                        case 3:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("800*480_4");
                            break;
                        case 4:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("1280*720_1");
                            break;
                        case 5:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("1280*720_2");
                            break;
                        case 6:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("1280*720_3");
                            break;
                        case 7:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text1)).setText("1280*720_4");
                            break;
                    }
                    LZHondaSceenCarSet.this.language_set = val;
                    break;
                case 100:
                    switch (val) {
                        case 0:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text2)).setText("2024 CRV");
                            break;
                        case 1:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text2)).setText("2017-2023 CRV");
                            break;
                        case 2:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text2)).setText("8 inches Accord10");
                            break;
                        case 3:
                            ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text2)).setText("7 inches Accord10");
                            break;
                    }
                    LZHondaSceenCarSet.this.lvdsmode_set = val;
                    break;
                case 101:
                    LZHondaSceenCarSet.this.setCheck((CheckedTextView) LZHondaSceenCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    LZHondaSceenCarSet.this.setCheck((CheckedTextView) LZHondaSceenCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 106:
                    ((TextView) LZHondaSceenCarSet.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_lz_hondascreen_carset);
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
        View layout = inflater.inflate(R.layout.layout_lauguage4, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (LZHondaSceenCarSet.this.cmdtype) {
                    case 1:
                        LZHondaSceenCarSet.this.language_set = position;
                        if (LZHondaSceenCarSet.this.language_set >= 0 && LZHondaSceenCarSet.this.language_set <= LZHondaSceenCarSet.this.mLauStylelist.size() && LZHondaSceenCarSet.this.send_lang != null) {
                            DataCanbus.PROXY.cmd(0, new int[]{255, LZHondaSceenCarSet.this.send_lang[LZHondaSceenCarSet.this.language_set]}, null, null);
                        }
                        break;
                    case 2:
                        LZHondaSceenCarSet.this.lvdsmode_set = position;
                        if (LZHondaSceenCarSet.this.lvdsmode_set >= 0 && LZHondaSceenCarSet.this.lvdsmode_set <= LZHondaSceenCarSet.this.mLauStylelist.size() && LZHondaSceenCarSet.this.send_lvdsmode != null) {
                            DataCanbus.PROXY.cmd(0, new int[]{254, LZHondaSceenCarSet.this.send_lvdsmode[LZHondaSceenCarSet.this.lvdsmode_set]}, null, null);
                        }
                        break;
                }
                LZHondaSceenCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet(int value) {
        if (value >= 0 && value < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(value, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("800*480_1");
        this.mLauStylelist.add("800*480_2");
        this.mLauStylelist.add("800*480_3");
        this.mLauStylelist.add("800*480_4");
        this.mLauStylelist.add("1280*720_1");
        this.mLauStylelist.add("1280*720_2");
        this.mLauStylelist.add("1280*720_3");
        this.mLauStylelist.add("1280*720_4");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLvdsStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("2024 CRV");
        this.mLauStylelist.add("2017-2023 CRV");
        this.mLauStylelist.add("8 inches Accord10");
        this.mLauStylelist.add("7 inches Accord10");
        this.send_lvdsmode = new int[]{0, 1, 2, 3};
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (!readFile("/sys/fytver/fyt_bin_version").contains("Ls18")) {
            readFile("/sys/fytver/fyt_bin_version").contains("Lt18");
        }
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LZHondaSceenCarSet.this.initmLauStylelist();
                LZHondaSceenCarSet.this.cmdtype = 1;
                if (LZHondaSceenCarSet.this.mLauStyle == null) {
                    LZHondaSceenCarSet.this.initLauStyle();
                }
                if (LZHondaSceenCarSet.this.mLauStyle != null && LZHondaSceenCarSet.this.mPopShowView != null) {
                    LZHondaSceenCarSet.this.mLauStyle.showAtLocation(LZHondaSceenCarSet.this.mPopShowView, 17, 0, 0);
                    LZHondaSceenCarSet.this.updateLauguageSet(LZHondaSceenCarSet.this.language_set);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LZHondaSceenCarSet.this.initmLvdsStylelist();
                LZHondaSceenCarSet.this.cmdtype = 2;
                if (LZHondaSceenCarSet.this.mLauStyle == null) {
                    LZHondaSceenCarSet.this.initLauStyle();
                }
                if (LZHondaSceenCarSet.this.mLauStyle != null && LZHondaSceenCarSet.this.mPopShowView != null) {
                    LZHondaSceenCarSet.this.mLauStyle.showAtLocation(LZHondaSceenCarSet.this.mPopShowView, 17, 0, 0);
                    LZHondaSceenCarSet.this.updateLauguageSet(LZHondaSceenCarSet.this.lvdsmode_set);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[101];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZHondaSceenCarSet.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[102];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{247, value}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        if (DataCanbus.DATA[1000] == 13631944) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus12 /* 2131427436 */:
                int value = DataCanbus.DATA[105];
                if (value < 36) {
                    value++;
                }
                setCarInfo(253, value);
                break;
            case R.id.btn_plus14 /* 2131427438 */:
                int value2 = DataCanbus.DATA[106];
                if (value2 < 36) {
                    value2++;
                }
                setCarInfo(252, value2);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value3 = DataCanbus.DATA[105];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(253, value3);
                break;
            case R.id.btn_minus14 /* 2131427492 */:
                int value4 = DataCanbus.DATA[106];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(252, value4);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
