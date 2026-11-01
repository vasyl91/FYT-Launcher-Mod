package com.syu.carinfo.golf7;

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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Golf7FunctionalEscSystemActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 73:
                    Golf7FunctionalEscSystemActi.this.mUpdaterAir();
                    break;
                case 143:
                    Golf7FunctionalEscSystemActi.this.mUpdaterInstrument();
                    break;
                case 162:
                    Golf7FunctionalEscSystemActi.this.updateLauguageSet();
                    Golf7FunctionalEscSystemActi.this.mUpdaterEscSystem();
                    break;
                case 180:
                    Golf7FunctionalEscSystemActi.this.mUpdaterDistance();
                    break;
                case 388:
                    Golf7FunctionalEscSystemActi.this.setCheck((CheckedTextView) Golf7FunctionalEscSystemActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_functional_state_esc_system);
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
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Golf7FunctionalEscSystemActi.this.language_set = position;
                if (Golf7FunctionalEscSystemActi.this.language_set >= 0 && Golf7FunctionalEscSystemActi.this.language_set <= Golf7FunctionalEscSystemActi.this.mLauStylelist.size() && Golf7FunctionalEscSystemActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(86, new int[]{Golf7FunctionalEscSystemActi.this.send_lang[Golf7FunctionalEscSystemActi.this.language_set]}, null, null);
                }
                Golf7FunctionalEscSystemActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[162];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(i, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.ESC_asr));
        this.mLauStylelist.add(getResources().getString(R.string.ESC_act));
        this.mLauStylelist.add(getResources().getString(R.string.Eesc_sport));
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Golf7FunctionalEscSystemActi.this.mLauStyle == null) {
                    Golf7FunctionalEscSystemActi.this.initLauStyle();
                }
                if (Golf7FunctionalEscSystemActi.this.mLauStyle != null && Golf7FunctionalEscSystemActi.this.mPopShowView != null) {
                    Golf7FunctionalEscSystemActi.this.mLauStyle.showAtLocation(Golf7FunctionalEscSystemActi.this.mPopShowView, 17, 0, 0);
                    Golf7FunctionalEscSystemActi.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[388] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 17;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(160, iArr, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_air_con_profile_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[73] & 255;
                if (switchOn == 2) {
                    DataCanbus.PROXY.cmd(101, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(101, new int[1], null, null);
                } else {
                    DataCanbus.PROXY.cmd(101, new int[]{2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_air_con_profile_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[73] & 255;
                if (switchOn == 0) {
                    DataCanbus.PROXY.cmd(101, new int[]{1}, null, null);
                } else if (switchOn == 1) {
                    DataCanbus.PROXY.cmd(101, new int[]{2}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(101, new int[]{3}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lindu_btn_functional_light_instrument_switch_lighting_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) - 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.lindu_btn_functional_light_instrument_switch_lighting_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int switchOn = (DataCanbus.DATA[143] & 255) + 10;
                if (switchOn < 0) {
                    switchOn = 0;
                } else if (switchOn > 100) {
                    switchOn = 100;
                }
                DataCanbus.PROXY.cmd(62, new int[]{switchOn}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_unit_distance_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[180] & 255;
                if (DataCanbus.DATA[1000] == 270) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_unit_distance_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7FunctionalEscSystemActi.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[180] & 255;
                if (DataCanbus.DATA[1000] == 270) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value == 0 ? 0 : 1;
                    remoteModuleProxy.cmd(1, iArr, null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 279) {
            setViewVisible(findViewById(R.id.glf7_view_air_con_profile), true);
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), true);
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), false);
        } else {
            if (DataCanbus.DATA[1000] == 270) {
                setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), true);
            } else {
                setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), false);
            }
            setViewVisible(findViewById(R.id.glf7_view_air_con_profile), false);
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), false);
        }
        if (ConstGolf.isRZCGolf()) {
            setViewVisible(findViewById(R.id.layout_view1), true);
        } else {
            setViewVisible(findViewById(R.id.layout_view1), false);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[388].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[388].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEscSystem() {
        int value = DataCanbus.DATA[162];
        int enable = (65280 & value) >> 8;
        int switchOn = value & 255;
        if (ConstGolf.isWcGolf()) {
            if (enable == 0) {
                setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), false);
                return;
            }
            if (switchOn == 2) {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
            }
            setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), true);
            return;
        }
        if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.Eesc_sport);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_act);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_esc_system_minus)).setText(R.string.ESC_asr);
        }
        setViewVisible(findViewById(R.id.glf7_view_functional_esc_system), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAir() {
        int value = DataCanbus.DATA[73];
        if (((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)) != null) {
            if (value == 2) {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_2);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_1);
            } else {
                ((TextView) findViewById(R.id.glf7_tv_air_con_profile_minus)).setText(R.string.lingdu_air_con_profile_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInstrument() {
        int value = DataCanbus.DATA[143];
        if (ConstGolf.isWcGolf()) {
            int enable = (65280 & value) >> 8;
            int switchOn = value & 255;
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), enable != 0);
            if (switchOn > -1 && switchOn < 101) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
                    return;
                } else {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(switchOn) + "%");
                    return;
                }
            }
            return;
        }
        if (DataCanbus.DATA[1000] != 437) {
            setViewVisible(findViewById(R.id.lindu_view_functional_light_instrument_switch_lighting), true);
            if (value > -1 && value < 101) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(R.string.least);
                } else {
                    ((TextView) findViewById(R.id.lindu_tv_functional_light_instrument_switch_lighting)).setText(String.valueOf(value) + "%");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDistance() {
        int value = DataCanbus.DATA[180];
        if (DataCanbus.DATA[1000] == 270) {
            setViewVisible(findViewById(R.id.glf7_view_functional_unit_distance), true);
            if (value == 0) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[1]);
            } else if (value == 1) {
                ((TextView) findViewById(R.id.glf7_tv_functional_unit_distance)).setText(Golf7Data.mDistanceUnitXp[0]);
            }
        }
    }
}
