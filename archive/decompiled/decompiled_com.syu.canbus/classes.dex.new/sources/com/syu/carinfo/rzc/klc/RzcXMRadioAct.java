package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0061_RZC_XP1_GM;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcXMRadioAct extends BaseActivity implements View.OnTouchListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcXMRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 342:
                    RzcXMRadioAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(value == 0 ? R.drawable.ic_sp_power_n : R.drawable.ic_sp_power_p);
                    break;
                case 343:
                    ((TextView) RzcXMRadioAct.this.findViewById(R.id.tv_text5)).setText("N." + value);
                    break;
                case 344:
                    ((TextView) RzcXMRadioAct.this.findViewById(R.id.tv_text1)).setText(Callback_0061_RZC_XP1_GM.XMRadio_RDS1);
                    break;
                case 345:
                    ((TextView) RzcXMRadioAct.this.findViewById(R.id.tv_text2)).setText(Callback_0061_RZC_XP1_GM.XMRadio_RDS2);
                    break;
                case 346:
                    ((TextView) RzcXMRadioAct.this.findViewById(R.id.tv_text3)).setText(Callback_0061_RZC_XP1_GM.XMRadio_RDS3);
                    break;
                case 347:
                    ((TextView) RzcXMRadioAct.this.findViewById(R.id.tv_text4)).setText(Callback_0061_RZC_XP1_GM.XMRadio_RDS4);
                    break;
                case 348:
                case 349:
                    RzcXMRadioAct.this.mLauStylelist.clear();
                    for (int i = 0; i < 255; i++) {
                        if (Callback_0061_RZC_XP1_GM.D4D_LIST80_DATA[i] != null || Callback_0061_RZC_XP1_GM.D4D_LIST90_DATA[i] != null) {
                            RzcXMRadioAct.this.mLauStylelist.add(String.valueOf(i + 1) + ". " + Callback_0061_RZC_XP1_GM.D4D_LIST80_DATA[i] + ". " + Callback_0061_RZC_XP1_GM.D4D_LIST90_DATA[i]);
                        } else {
                            RzcXMRadioAct.this.mLauStylelist.add(String.valueOf(i + 1) + ". -----unkown");
                        }
                    }
                    RzcXMRadioAct.this.mLauStylelist.clone();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_xmradio);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_cd_list, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.klc.RzcXMRadioAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RzcXMRadioAct.this.language_set = position;
                if (RzcXMRadioAct.this.language_set >= 0 && RzcXMRadioAct.this.language_set <= RzcXMRadioAct.this.mLauStylelist.size()) {
                    DataCanbus.PROXY.cmd(14, new int[]{4, RzcXMRadioAct.this.language_set + 1}, null, null);
                }
                RzcXMRadioAct.this.mLauStyle.dismiss();
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.klc.RzcXMRadioAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcXMRadioAct.this.mLauStyle == null) {
                    RzcXMRadioAct.this.initLauStyle();
                }
                if (RzcXMRadioAct.this.mLauStyle != null && RzcXMRadioAct.this.mPopShowView != null) {
                    RzcXMRadioAct.this.mLauStyle.showAtLocation(RzcXMRadioAct.this.mPopShowView, 17, 0, 0);
                }
            }
        });
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        int data1 = 0;
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_plus1 /* 2131427458 */:
                    data0 = 1;
                    data1 = DataCanbus.DATA[342] == 1 ? 0 : 1;
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    data0 = 2;
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    data0 = 3;
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    data0 = 5;
                    break;
                case R.id.btn_plus5 /* 2131427470 */:
                    data0 = 6;
                    break;
            }
            DataCanbus.PROXY.cmd(14, new int[]{data0, data1}, null, null);
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[344].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[345].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[346].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[348].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[349].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[344].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[345].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[346].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[348].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[349].removeNotify(this.mNotifyCanbus);
    }
}
