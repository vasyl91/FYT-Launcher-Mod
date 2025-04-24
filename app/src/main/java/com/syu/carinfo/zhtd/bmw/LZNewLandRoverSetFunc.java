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
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0453_LZ_LandRover_KeepCD;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZNewLandRoverSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0453_LZ_LandRover_KeepCD.modevalue = ints[2];
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
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
                case 125:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                case 126:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                case 128:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                case 129:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_weilang_danqu);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_weilang_shuangqu);
                            break;
                    }
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_currency);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_dedicated);
                            break;
                    }
                case 131:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_currency);
                            break;
                        case 1:
                            ((TextView) LZNewLandRoverSetFunc.this.findViewById(R.id.tv_text8)).setText("XJL");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_landrover_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
                LZNewLandRoverSetFunc.this.language_set = position;
                if (LZNewLandRoverSetFunc.this.language_set >= 0 && LZNewLandRoverSetFunc.this.language_set <= LZNewLandRoverSetFunc.this.mLauStylelist.size() && LZNewLandRoverSetFunc.this.send_lang != null) {
                    LZNewLandRoverSetFunc.this.setCarInfo(250, LZNewLandRoverSetFunc.this.language_set);
                    switch (LZNewLandRoverSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 4}, null, null);
                            break;
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 5}, null, null);
                            break;
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, -2, 6}, null, null);
                            break;
                        case 3:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 16}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                            if (Callback_0453_LZ_LandRover_KeepCD.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                break;
                            }
                        case 4:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 11}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                            if (Callback_0453_LZ_LandRover_KeepCD.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                break;
                            }
                    }
                }
                LZNewLandRoverSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("LR-Bose 800x480 G100");
        this.mLauStylelist.add("LR-Bose 800x480-1 G100");
        this.mLauStylelist.add("LR-Bose 800x480-2 G100");
        this.mLauStylelist.add("LR-Haman 1280x540  I300");
        this.mLauStylelist.add("LR-Haman 800x480  I300");
        this.send_lang = new int[]{0, 1, 2, 3, 4};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
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

    @Override
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[122] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(249, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[122] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(249, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
            case R.id.btn_plus2 /* 2131427460 */:
                int bit7 = DataCanbus.DATA[125];
                int bit6 = DataCanbus.DATA[126];
                int bit5 = DataCanbus.DATA[127];
                int bit4 = DataCanbus.DATA[128];
                int bit3 = DataCanbus.DATA[129];
                int bit2 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
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
            case R.id.btn_minus3 /* 2131427461 */:
            case R.id.btn_plus3 /* 2131427463 */:
                int bit72 = DataCanbus.DATA[125];
                int bit62 = DataCanbus.DATA[126];
                int bit52 = DataCanbus.DATA[127];
                int bit42 = DataCanbus.DATA[128];
                int bit32 = DataCanbus.DATA[129];
                int bit22 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit22 = 1;
                }
                int bit12 = DataCanbus.DATA[130];
                int bit02 = DataCanbus.DATA[131];
                if (bit62 == 1) {
                    bit62 = 0;
                } else if (bit62 == 0) {
                    bit62 = 1;
                }
                setCarInfo(248, ((bit72 << 7) & 128) | ((bit62 << 6) & 64) | ((bit52 << 5) & 32) | ((bit42 << 4) & 16) | ((bit32 << 3) & 8) | ((bit22 << 2) & 64) | ((bit12 << 1) & 2) | (bit02 & 1));
                break;
            case R.id.btn_minus4 /* 2131427464 */:
            case R.id.btn_plus4 /* 2131427466 */:
                int bit73 = DataCanbus.DATA[125];
                int bit63 = DataCanbus.DATA[126];
                int bit53 = DataCanbus.DATA[127];
                int bit43 = DataCanbus.DATA[128];
                int bit33 = DataCanbus.DATA[129];
                int bit23 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit23 = 1;
                }
                int bit13 = DataCanbus.DATA[130];
                int bit03 = DataCanbus.DATA[131];
                if (bit53 == 1) {
                    bit53 = 0;
                } else if (bit53 == 0) {
                    bit53 = 1;
                }
                setCarInfo(248, ((bit73 << 7) & 128) | ((bit63 << 6) & 64) | ((bit53 << 5) & 32) | ((bit43 << 4) & 16) | ((bit33 << 3) & 8) | ((bit23 << 2) & 64) | ((bit13 << 1) & 2) | (bit03 & 1));
                break;
            case R.id.btn_minus5 /* 2131427467 */:
            case R.id.btn_plus5 /* 2131427469 */:
                int bit74 = DataCanbus.DATA[125];
                int bit64 = DataCanbus.DATA[126];
                int bit54 = DataCanbus.DATA[127];
                int bit44 = DataCanbus.DATA[128];
                int bit34 = DataCanbus.DATA[129];
                int bit24 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit24 = 1;
                }
                int bit14 = DataCanbus.DATA[130];
                int bit04 = DataCanbus.DATA[131];
                if (bit44 == 1) {
                    bit44 = 0;
                } else if (bit44 == 0) {
                    bit44 = 1;
                }
                setCarInfo(248, ((bit74 << 7) & 128) | ((bit64 << 6) & 64) | ((bit54 << 5) & 32) | ((bit44 << 4) & 16) | ((bit34 << 3) & 8) | ((bit24 << 2) & 64) | ((bit14 << 1) & 2) | (bit04 & 1));
                break;
            case R.id.btn_minus6 /* 2131427470 */:
            case R.id.btn_plus6 /* 2131427472 */:
                int bit75 = DataCanbus.DATA[125];
                int bit65 = DataCanbus.DATA[126];
                int bit55 = DataCanbus.DATA[127];
                int bit45 = DataCanbus.DATA[128];
                int bit35 = DataCanbus.DATA[129];
                int bit25 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit25 = 1;
                }
                int bit15 = DataCanbus.DATA[130];
                int bit05 = DataCanbus.DATA[131];
                if (bit35 == 1) {
                    bit35 = 0;
                } else if (bit35 == 0) {
                    bit35 = 1;
                }
                setCarInfo(248, ((bit75 << 7) & 128) | ((bit65 << 6) & 64) | ((bit55 << 5) & 32) | ((bit45 << 4) & 16) | ((bit35 << 3) & 8) | ((bit25 << 2) & 64) | ((bit15 << 1) & 2) | (bit05 & 1));
                break;
            case R.id.btn_minus7 /* 2131427473 */:
            case R.id.btn_plus7 /* 2131427475 */:
                int bit76 = DataCanbus.DATA[125];
                int bit66 = DataCanbus.DATA[126];
                int bit56 = DataCanbus.DATA[127];
                int bit46 = DataCanbus.DATA[128];
                int bit36 = DataCanbus.DATA[129];
                int bit26 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit26 = 1;
                }
                int bit16 = DataCanbus.DATA[130];
                int bit06 = DataCanbus.DATA[131];
                if (bit16 == 1) {
                    bit16 = 0;
                } else if (bit16 == 0) {
                    bit16 = 1;
                }
                setCarInfo(248, ((bit76 << 7) & 128) | ((bit66 << 6) & 64) | ((bit56 << 5) & 32) | ((bit46 << 4) & 16) | ((bit36 << 3) & 8) | ((bit26 << 2) & 64) | ((bit16 << 1) & 2) | (bit06 & 1));
                break;
            case R.id.btn_minus8 /* 2131427476 */:
            case R.id.btn_plus8 /* 2131427478 */:
                int bit77 = DataCanbus.DATA[125];
                int bit67 = DataCanbus.DATA[126];
                int bit57 = DataCanbus.DATA[127];
                int bit47 = DataCanbus.DATA[128];
                int bit37 = DataCanbus.DATA[129];
                int bit27 = 0;
                if (LauncherApplication.getConfiguration() == 1) {
                    bit27 = 1;
                }
                int bit17 = DataCanbus.DATA[130];
                int bit07 = DataCanbus.DATA[131];
                if (bit07 == 1) {
                    bit07 = 0;
                } else if (bit07 == 0) {
                    bit07 = 1;
                }
                setCarInfo(248, ((bit77 << 7) & 128) | ((bit67 << 6) & 64) | ((bit57 << 5) & 32) | ((bit47 << 4) & 16) | ((bit37 << 3) & 8) | ((bit27 << 2) & 64) | ((bit17 << 1) & 2) | (bit07 & 1));
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value3 = DataCanbus.DATA[110] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(254, value3);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value4 = DataCanbus.DATA[110] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(254, value4);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value5 = DataCanbus.DATA[113];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(253, value5);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value6 = DataCanbus.DATA[113];
                if (value6 < 36) {
                    value6++;
                }
                setCarInfo(253, value6);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value7 = DataCanbus.DATA[114];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(252, value7);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value8 = DataCanbus.DATA[114];
                if (value8 < 36) {
                    value8++;
                }
                setCarInfo(252, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZNewLandRoverCarinfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
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

    @Override
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
