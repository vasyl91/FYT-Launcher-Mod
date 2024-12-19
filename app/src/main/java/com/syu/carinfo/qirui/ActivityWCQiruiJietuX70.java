package com.syu.carinfo.qirui;

import android.app.Activity;
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
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityWCQiruiJietuX70 extends Activity implements View.OnClickListener {
    int language_set = 255;
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.qirui.ActivityWCQiruiJietuX70.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 86:
                    if (value == 1) {
                        ActivityWCQiruiJietuX70.this.findViewById(R.id.layout_view5).setVisibility(0);
                        ActivityWCQiruiJietuX70.this.findViewById(R.id.layout_view6).setVisibility(0);
                        break;
                    } else {
                        ActivityWCQiruiJietuX70.this.findViewById(R.id.layout_view5).setVisibility(8);
                        ActivityWCQiruiJietuX70.this.findViewById(R.id.layout_view6).setVisibility(8);
                        break;
                    }
                case 87:
                    if (((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 88:
                    if (((TextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 2:
                                ((TextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 89:
                    ActivityWCQiruiJietuX70.this.updateAutoLock(value);
                    break;
                case 90:
                    ActivityWCQiruiJietuX70.this.updateBiglightSleep(value);
                    break;
                case 91:
                    ActivityWCQiruiJietuX70.this.updateDayLight(value);
                    break;
                case 92:
                    ActivityWCQiruiJietuX70.this.updateSteeringAvm(value);
                    break;
                case 93:
                    ActivityWCQiruiJietuX70.this.updateSteeringAnim(value);
                    break;
                case 94:
                    ActivityWCQiruiJietuX70.this.updateVehicleGuides(value);
                    break;
                case 95:
                    ActivityWCQiruiJietuX70.this.updateSpeedAlarm(value);
                    break;
                case 96:
                    ActivityWCQiruiJietuX70.this.updateDashBoardBacklight(value);
                    break;
                case 97:
                    ActivityWCQiruiJietuX70.this.updateRemodeBack(value);
                    break;
                case 98:
                    ActivityWCQiruiJietuX70.this.updateAutoUnlock(value);
                    break;
                case 99:
                    ActivityWCQiruiJietuX70.this.updateAutoFoldRearview(value);
                    break;
                case 101:
                    ActivityWCQiruiJietuX70.this.updateBlidSide(value);
                    break;
                case 102:
                    ActivityWCQiruiJietuX70.this.updateRoadAway(value);
                    break;
                case 103:
                    ActivityWCQiruiJietuX70.this.updateFortificationPrompt(value);
                    break;
                case 104:
                    ActivityWCQiruiJietuX70.this.updateHomeLight(value);
                    break;
                case 105:
                    ActivityWCQiruiJietuX70.this.updateChangeRoad(value);
                    break;
                case 106:
                    ActivityWCQiruiJietuX70.this.updateEpsMode(value);
                    break;
                case 107:
                    ActivityWCQiruiJietuX70.this.updateWelcomeLight(value);
                    break;
                case 108:
                    if (((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 109:
                    if (((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        break;
                    }
                case 110:
                    if (((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityWCQiruiJietuX70.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_qirui_jietu_x70);
        setListener();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.qirui.ActivityWCQiruiJietuX70.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ActivityWCQiruiJietuX70.this.language_set = position;
                if (ActivityWCQiruiJietuX70.this.language_set >= 0 && ActivityWCQiruiJietuX70.this.language_set <= ActivityWCQiruiJietuX70.this.mLauStylelist.size() && ActivityWCQiruiJietuX70.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, ActivityWCQiruiJietuX70.this.send_lang[ActivityWCQiruiJietuX70.this.language_set]}, null, null);
                }
                ActivityWCQiruiJietuX70.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        findViewById(R.id.all_func_btn_lauguage_set).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.qirui.ActivityWCQiruiJietuX70.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityWCQiruiJietuX70.this.mLauStyle == null) {
                    ActivityWCQiruiJietuX70.this.initLauStyle();
                }
                if (ActivityWCQiruiJietuX70.this.mLauStyle != null && ActivityWCQiruiJietuX70.this.mPopShowView != null) {
                    ActivityWCQiruiJietuX70.this.mLauStyle.showAtLocation(ActivityWCQiruiJietuX70.this.mPopShowView, 17, 0, 0);
                    ActivityWCQiruiJietuX70.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
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
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 1966475 || DataCanbus.DATA[1000] == 2359691) {
            findViewById(R.id.layout_view3).setVisibility(0);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfoCmd(19, (DataCanbus.DATA[108] & 255) != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[88] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfoCmd(2, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[88] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfoCmd(2, value2);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value3 = (DataCanbus.DATA[94] & 255) - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfoCmd(11, value3);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value4 = (DataCanbus.DATA[94] & 255) + 1;
                if (value4 > 2) {
                    value4 = 2;
                }
                setCarInfoCmd(11, value4);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value5 = (DataCanbus.DATA[95] & 255) - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfoCmd(7, value5);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value6 = (DataCanbus.DATA[95] & 255) + 1;
                if (value6 > 21) {
                    value6 = 21;
                }
                setCarInfoCmd(7, value6);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value7 = (DataCanbus.DATA[96] & 255) - 1;
                if (value7 < 1) {
                    value7 = 1;
                }
                setCarInfoCmd(8, value7);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value8 = (DataCanbus.DATA[96] & 255) + 1;
                if (value8 > 10) {
                    value8 = 10;
                }
                setCarInfoCmd(8, value8);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value9 = (DataCanbus.DATA[103] & 255) - 1;
                if (value9 < 0) {
                    value9 = 0;
                }
                setCarInfoCmd(17, value9);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value10 = (DataCanbus.DATA[103] & 255) + 1;
                if (value10 > 2) {
                    value10 = 2;
                }
                setCarInfoCmd(17, value10);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value11 = (DataCanbus.DATA[104] & 255) - 1;
                if (value11 < 0) {
                    value11 = 0;
                }
                setCarInfoCmd(21, value11);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value12 = (DataCanbus.DATA[104] & 255) + 1;
                if (value12 > 2) {
                    value12 = 2;
                }
                setCarInfoCmd(21, value12);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value13 = (DataCanbus.DATA[105] & 255) - 1;
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfoCmd(22, value13);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value14 = (DataCanbus.DATA[105] & 255) + 1;
                if (value14 > 3) {
                    value14 = 3;
                }
                setCarInfoCmd(22, value14);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value15 = (DataCanbus.DATA[106] & 255) - 1;
                if (value15 < 0) {
                    value15 = 0;
                }
                setCarInfoCmd(23, value15);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value16 = (DataCanbus.DATA[106] & 255) + 1;
                if (value16 > 1) {
                    value16 = 1;
                }
                setCarInfoCmd(23, value16);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfoCmd(20, (DataCanbus.DATA[109] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfoCmd(170, 254);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfoCmd(26, (DataCanbus.DATA[110] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfoCmd(1, (DataCanbus.DATA[87] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfoCmd(4, (DataCanbus.DATA[89] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setCarInfoCmd(5, (DataCanbus.DATA[90] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                setCarInfoCmd(6, (DataCanbus.DATA[91] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarInfoCmd(9, (DataCanbus.DATA[92] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setCarInfoCmd(10, (DataCanbus.DATA[93] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                setCarInfoCmd(12, (DataCanbus.DATA[97] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfoCmd(13, (DataCanbus.DATA[98] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                setCarInfoCmd(14, (DataCanbus.DATA[99] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                setCarInfoCmd(15, (DataCanbus.DATA[101] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setCarInfoCmd(16, (DataCanbus.DATA[102] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                setCarInfoCmd(24, (DataCanbus.DATA[107] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    protected void updateAutoLock(int value2) {
        if (findViewById(R.id.ctv_checkedtext6) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateBiglightSleep(int value2) {
        if (findViewById(R.id.ctv_checkedtext7) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateDayLight(int value2) {
        if (findViewById(R.id.ctv_checkedtext8) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateSteeringAvm(int value2) {
        if (findViewById(R.id.ctv_checkedtext9) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateSteeringAnim(int value2) {
        if (findViewById(R.id.ctv_checkedtext10) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateVehicleGuides(int value2) {
        if (findViewById(R.id.tv_text3) != null) {
            switch (value2 & 255) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_395_static_state);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_395_static_and_dynamic);
                    break;
            }
        }
    }

    protected void updateEpsMode(int value2) {
        if (findViewById(R.id.tv_text9) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
            }
        }
    }

    protected void updateChangeRoad(int value2) {
        if (findViewById(R.id.tv_text8) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                return;
            }
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_three_times);
            } else if (value == 2) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_five_times);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_seven_times);
            }
        }
    }

    protected void updateHomeLight(int value2) {
        if (findViewById(R.id.tv_text7) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.off);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
            }
        }
    }

    protected void updateFortificationPrompt(int value2) {
        if (findViewById(R.id.tv_text6) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_light);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_sounds);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_lightsounds);
            }
        }
    }

    protected void updateSpeedAlarm(int value2) {
        if (findViewById(R.id.tv_text4) != null) {
            int value = value2 & 255;
            if (value == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append((value * 5) + 25).toString());
            }
        }
    }

    protected void updateRoadAway(int value2) {
        if (findViewById(R.id.ctv_checkedtext15) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateWelcomeLight(int value2) {
        if (findViewById(R.id.ctv_checkedtext16) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateBlidSide(int value2) {
        if (findViewById(R.id.ctv_checkedtext14) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateAutoFoldRearview(int value2) {
        if (findViewById(R.id.ctv_checkedtext13) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateAutoUnlock(int value2) {
        if (findViewById(R.id.ctv_checkedtext12) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateRemodeBack(int value2) {
        if (findViewById(R.id.ctv_checkedtext11) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked((value2 & 255) == 1);
        }
    }

    protected void updateDashBoardBacklight(int value2) {
        if (findViewById(R.id.tv_text5) != null) {
            int value = value2 & 255;
            if (value > 10) {
                value = 10;
            } else if (value <= 0) {
                value = 0;
            }
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    private void setCarInfoCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(2, cmd, value);
    }
}
