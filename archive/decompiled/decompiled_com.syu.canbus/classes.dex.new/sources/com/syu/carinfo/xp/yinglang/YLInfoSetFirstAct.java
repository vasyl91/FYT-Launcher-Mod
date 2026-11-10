package com.syu.carinfo.xp.yinglang;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class YLInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (value == 0) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text2)).setText("℃");
                    } else {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text2)).setText("℉");
                    }
                    break;
                case 104:
                    YLInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 105:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 106:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 107:
                    YLInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 108:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 109:
                    YLInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 110:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 111:
                    YLInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 112:
                    YLInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 113:
                    YLInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 131:
                    YLInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 164:
                    YLInfoSetFirstAct.this.updaterreversWipersStartAble();
                    break;
                case 171:
                    YLInfoSetFirstAct.this.updaterlightsParkingAble();
                    break;
                case 172:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelayAble();
                    break;
                case 173:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLockAble();
                    break;
                case 174:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlockAble();
                    break;
                case 175:
                    YLInfoSetFirstAct.this.updaterdoorAutoLockAble();
                    break;
                case 176:
                    YLInfoSetFirstAct.this.updaterlaterLockAble();
                    break;
                case 177:
                    YLInfoSetFirstAct.this.updaterremoteLockDoorAble();
                    break;
                case 178:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLightAble();
                    break;
                case 179:
                    YLInfoSetFirstAct.this.updaterremoteUnlockAble();
                    break;
                case 184:
                    YLInfoSetFirstAct.this.updaterRadarSwitch();
                    break;
                case 187:
                    YLInfoSetFirstAct.this.updateAutoDriverStartTip();
                    break;
                case 189:
                case 192:
                    YLInfoSetFirstAct.this.updaterRampAssist();
                    break;
                case 195:
                    if (value == 0) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                        break;
                    } else if (value >= 1 && value <= 6) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("蓝色" + value);
                        break;
                    } else if (value >= 7 && value <= 12) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("紫色" + (value - 6));
                        break;
                    } else if (value >= 13 && value <= 18) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("金色" + (value - 12));
                        break;
                    }
                    break;
                case 197:
                    ((CheckedTextView) YLInfoSetFirstAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_first_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                YLInfoSetFirstAct.this.language_set = position;
                YLFunc.C_CAR_LANGUAGE_SETUP(position);
                YLInfoSetFirstAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < 16) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(this.language_set));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(this.language_set, true);
            }
        }
    }

    private boolean IsRzcGl8() {
        return DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 393479;
    }

    private boolean IsXPGM() {
        return (DataCanbus.DATA[1000] & 65535) == 25;
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493 || IsRzcGl8()) {
            findViewById(R.id.layout_view12).setVisibility(0);
        } else {
            findViewById(R.id.layout_view12).setVisibility(8);
        }
        if (IsXPGM()) {
            findViewById(R.id.layout_view16).setVisibility(0);
        } else {
            findViewById(R.id.layout_view16).setVisibility(8);
        }
        findViewById(R.id.layout_view13).setVisibility(IsRzcGl8() ? 0 : 8);
        findViewById(R.id.layout_view1).setVisibility(IsRzcGl8() ? 0 : 8);
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (YLInfoSetFirstAct.this.mLauStyle == null) {
                    YLInfoSetFirstAct.this.initLauStyle();
                }
                if (YLInfoSetFirstAct.this.mLauStyle != null && YLInfoSetFirstAct.this.mPopShowView != null) {
                    YLInfoSetFirstAct.this.mLauStyle.showAtLocation(YLInfoSetFirstAct.this.mPopShowView, 17, 0, 0);
                    YLInfoSetFirstAct.this.updateLauguageSet();
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[195] - 1;
                if (value < 0) {
                    value = 18;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[195] + 1;
                if (value2 > 18) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[37] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[37] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int valLasuoDelayPre = DataCanbus.DATA[105];
                if (valLasuoDelayPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                } else if (valLasuoDelayPre == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayPre == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int valLasuoDelayNext = DataCanbus.DATA[105];
                if (valLasuoDelayNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                } else if (valLasuoDelayNext == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayNext == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value7 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                } else if (value7 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                } else if (value8 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value8 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[111];
                if (value9 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value9 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                } else if (value9 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value9 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[111];
                if (value10 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value10 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                } else if (value10 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value10 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                }
                break;
            case R.id.btn_minus7 /* 2131427474 */:
            case R.id.btn_plus7 /* 2131427476 */:
                int value13 = DataCanbus.DATA[189];
                if (IsRzcGl8()) {
                    value13 = DataCanbus.DATA[192];
                }
                YLFunc.CAR_COMM_CONTROL(81, value13 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int valLightPark = DataCanbus.DATA[104];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value5 = DataCanbus.DATA[109];
                YLFunc.CAR_COMM_CONTROL(5, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value6 = DataCanbus.DATA[110];
                YLFunc.CAR_COMM_CONTROL(6, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value1 = DataCanbus.DATA[106];
                YLFunc.CAR_COMM_CONTROL(2, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value14 = DataCanbus.DATA[107];
                YLFunc.CAR_COMM_CONTROL(3, value14 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int value15 = DataCanbus.DATA[112];
                YLFunc.CAR_COMM_CONTROL(8, value15 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value16 = DataCanbus.DATA[113];
                YLFunc.CAR_COMM_CONTROL(9, value16 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                YLFunc.CAR_COMM_CONTROL(82, DataCanbus.DATA[187] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value17 = DataCanbus.DATA[184];
                YLFunc.CAR_ON_RADAR_CTL(value17 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value18 = DataCanbus.DATA[197];
                YLFunc.CAR_AIR_CONTROL(10, value18 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), 1);
        if (DataCanbus.DATA[1000] == 2359321) {
            setViewVisible(findViewById(R.id.layout_view14), 0);
            setViewVisible(findViewById(R.id.layout_view11), 0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            setViewVisible(findViewById(R.id.layout_view14), 0);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        if (IsRzcGl8()) {
            DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        }
        if (IsXPGM()) {
            DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 9044029 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || DataCanbus.DATA[1000] == 8978493) {
            DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        }
        if (IsRzcGl8()) {
            DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        if (IsXPGM()) {
            DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParkingAble() {
        int enable = DataCanbus.DATA[171];
        if (enable == 0) {
            findViewById(R.id.layout_view15).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view15).setVisibility(0);
        }
    }

    protected void updateAutoDriverStartTip() {
        int enable = DataCanbus.DATA[187];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(enable != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelayAble() {
        int enable = DataCanbus.DATA[172];
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLockAble() {
        int enable = DataCanbus.DATA[173];
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLockAble() {
        int enable = DataCanbus.DATA[175];
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlockAble() {
        int enable = DataCanbus.DATA[174];
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLockAble() {
        int enable = DataCanbus.DATA[176];
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLightAble() {
        int enable = DataCanbus.DATA[178];
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoorAble() {
        int enable = DataCanbus.DATA[177];
        if (enable == 0) {
            findViewById(R.id.layout_view8).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockAble() {
        int enable = DataCanbus.DATA[179];
        if (enable == 0) {
            findViewById(R.id.layout_view9).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStartAble() {
        int enable = DataCanbus.DATA[164];
        if (enable == 0) {
            findViewById(R.id.layout_view10).setVisibility(0);
        } else if (enable == 1) {
            findViewById(R.id.layout_view10).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[105];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        if (IsRzcGl8()) {
            if (switchOn == 0) {
                findViewById(R.id.layout_view5).setVisibility(0);
            } else if (switchOn == 1) {
                findViewById(R.id.layout_view5).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[108];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[111];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[112];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text6)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadarSwitch() {
        int switchOn = DataCanbus.DATA[184];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.tv_text7)).setText(new StringBuilder().append(switchOn).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRampAssist() {
        int switchOn = DataCanbus.DATA[189];
        if (IsRzcGl8()) {
            switchOn = DataCanbus.DATA[192];
        }
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_yl_lane_assist_str1);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_yl_lane_assist_str2);
        }
    }
}
