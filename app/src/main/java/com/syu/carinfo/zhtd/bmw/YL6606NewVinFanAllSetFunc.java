package com.syu.carinfo.zhtd.bmw;

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
import java.util.ArrayList;

public class YL6606NewVinFanAllSetFunc extends BaseActivity implements View.OnClickListener {
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
                case 123:
                    ((TextView) YL6606NewVinFanAllSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 124:
                    ((TextView) YL6606NewVinFanAllSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 125:
                    ((CheckedTextView) YL6606NewVinFanAllSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 126:
                    YL6606NewVinFanAllSetFunc.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_mazda_screen_setfunc);
        init();
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
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
                YL6606NewVinFanAllSetFunc.this.language_set = position;
                if (YL6606NewVinFanAllSetFunc.this.language_set >= 0 && YL6606NewVinFanAllSetFunc.this.language_set <= YL6606NewVinFanAllSetFunc.this.mLauStylelist.size() && YL6606NewVinFanAllSetFunc.this.send_lang != null) {
                    YL6606NewVinFanAllSetFunc.this.setCarInfo(249, YL6606NewVinFanAllSetFunc.this.send_lang[YL6606NewVinFanAllSetFunc.this.language_set]);
                    switch (YL6606NewVinFanAllSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 16}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                            if (Callback_0453_LZ_BBA_All.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                break;
                            }
                    }
                }
                YL6606NewVinFanAllSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[126];
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

    private void updatemLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("Type 1");
        this.send_lang = new int[1];
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
                if (YL6606NewVinFanAllSetFunc.this.mLauStyle == null) {
                    YL6606NewVinFanAllSetFunc.this.initLauStyle();
                }
                if (YL6606NewVinFanAllSetFunc.this.mLauStyle != null && YL6606NewVinFanAllSetFunc.this.mPopShowView != null) {
                    YL6606NewVinFanAllSetFunc.this.mLauStyle.showAtLocation(YL6606NewVinFanAllSetFunc.this.mPopShowView, 17, 0, 0);
                    YL6606NewVinFanAllSetFunc.this.updateLauguageSet();
                }
            }
        });
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
        switch (v.getId()) {
            case R.id.btn_minus12 /* 2131427488 */:
                int value2 = DataCanbus.DATA[123];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(253, value2);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value3 = DataCanbus.DATA[123];
                if (value3 < 36) {
                    value3++;
                }
                setCarInfo(253, value3);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value4 = DataCanbus.DATA[124];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(252, value4);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value5 = DataCanbus.DATA[124];
                if (value5 < 36) {
                    value5++;
                }
                setCarInfo(252, value5);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[125] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
    }
}
