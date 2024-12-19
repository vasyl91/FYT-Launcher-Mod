package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepRearSpeakers extends BaseActivity implements View.OnTouchListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int language_set = 255;
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.1
        @Override // java.lang.Runnable
        public void run() {
            PAJeepRearSpeakers.this.num++;
            if (PAJeepRearSpeakers.this.num >= 3 && PAJeepRearSpeakers.this.curnum != 0) {
                PAJeepRearSpeakers.this.mSetCurFrq(PAJeepRearSpeakers.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(PAJeepRearSpeakers.this.mCalTime);
            HandlerUI.getInstance().postDelayed(PAJeepRearSpeakers.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;
    int totaltrack = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_pause_n);
                    if (((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate1);
                                break;
                            case 1:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate3);
                                break;
                            case 2:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate4);
                                break;
                            case 3:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate2);
                                break;
                            case 4:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate6);
                                PAJeepRearSpeakers.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_play_n);
                                break;
                            case 5:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate5);
                                break;
                            case 6:
                                ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_playstate9);
                                break;
                        }
                    }
                    break;
                case 170:
                    if (value == 1) {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 178:
                case 179:
                    int hour = DataCanbus.DATA[172];
                    int min = DataCanbus.DATA[173];
                    int sec = DataCanbus.DATA[174];
                    int hour_t = DataCanbus.DATA[175];
                    int min_t = DataCanbus.DATA[176];
                    int sec_t = DataCanbus.DATA[177];
                    int tr = DataCanbus.DATA[178];
                    int totaltr = DataCanbus.DATA[179];
                    PAJeepRearSpeakers.this.totaltrack = DataCanbus.DATA[179];
                    PAJeepRearSpeakers.this.updateLauguageSet();
                    if (tr == 65535) {
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text1)).setText("----");
                        ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setMax(0);
                        ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(0);
                        ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text3)).setText("------");
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text2)).setText("------");
                        break;
                    } else {
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text1)).setText(String.valueOf(tr) + "/" + totaltr);
                        if (hour_t != 0 || min_t != 0 || sec_t != 0) {
                            int totaltime = (hour_t * 3600) + (min_t * 60) + sec_t;
                            int time = (hour * 3600) + (min * 60) + sec;
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setMax(totaltime);
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(time);
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        } else {
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setMax(0);
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(0);
                            ((ProgressBar) PAJeepRearSpeakers.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        }
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour_t / 10) + (hour_t % 10) + ":" + (min_t / 10) + (min_t % 10) + ":" + (sec_t / 10) + (sec_t % 10));
                        ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text2)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                        break;
                    }
                case 180:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text5)).setText(Callback_0374_XP1_ZiYouGuang.Title);
                    break;
                case 181:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text7)).setText(Callback_0374_XP1_ZiYouGuang.Album);
                    break;
                case 182:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text6)).setText(Callback_0374_XP1_ZiYouGuang.Artist);
                    break;
                case 340:
                    if (value == 1) {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 341:
                    if (value == 0) {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#666666"));
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    } else {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#666666"));
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 343:
                    PAJeepRearSpeakers.this.mLauStylelist.clear();
                    for (int i = 0; i < PAJeepRearSpeakers.this.totaltrack; i++) {
                        if (Callback_0374_XP1_ZiYouGuang.CD_LIST_DATA[i] != null) {
                            PAJeepRearSpeakers.this.mLauStylelist.add(String.valueOf(i + 1) + ". " + Callback_0374_XP1_ZiYouGuang.CD_LIST_DATA[i]);
                        } else {
                            PAJeepRearSpeakers.this.mLauStylelist.add(String.valueOf(i + 1) + ". -----unkown list");
                        }
                    }
                    PAJeepRearSpeakers.this.mLauStylelist.clone();
                    break;
                case 344:
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_disc_n);
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_av1_n);
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_av2_n);
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_hdmi1_n);
                    PAJeepRearSpeakers.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_hdmi2_n);
                    switch (value) {
                        case 0:
                            PAJeepRearSpeakers.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_disc_p);
                            break;
                        case 1:
                            PAJeepRearSpeakers.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_av1_p);
                            break;
                        case 2:
                            PAJeepRearSpeakers.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_av2_p);
                            break;
                        case 3:
                            PAJeepRearSpeakers.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_hdmi1_p);
                            break;
                        case 4:
                            PAJeepRearSpeakers.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_hdmi2_p);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_rear_speakers);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                PAJeepRearSpeakers.this.language_set = position;
                if (PAJeepRearSpeakers.this.language_set >= 0 && PAJeepRearSpeakers.this.language_set <= PAJeepRearSpeakers.this.mLauStylelist.size()) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, PAJeepRearSpeakers.this.language_set + 1}, null, null);
                }
                PAJeepRearSpeakers.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[178];
        if (value < this.mLauStylelist.size() && value > 0 && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(value - 1, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PAJeepRearSpeakers.this.mLauStyle == null) {
                    PAJeepRearSpeakers.this.initLauStyle();
                }
                if (PAJeepRearSpeakers.this.mLauStyle != null && PAJeepRearSpeakers.this.mPopShowView != null) {
                    PAJeepRearSpeakers.this.mLauStyle.showAtLocation(PAJeepRearSpeakers.this.mPopShowView, 17, 0, 0);
                    PAJeepRearSpeakers.this.updateLauguageSet();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{21}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{22}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{23}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{24}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{25}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{19}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[341];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{20}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[341];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{20}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{18}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{14}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{17}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepRearSpeakers.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169];
                if (value == 3) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{2}, null, null);
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_plus14 /* 2131427473 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_plus12 /* 2131427527 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.btn_plus14 /* 2131427473 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(5, new int[]{4}, null, null);
                        break;
                    }
                case R.id.btn_plus12 /* 2131427527 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(5, new int[]{3}, null, null);
                        break;
                    }
            }
        }
        return false;
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.num = 0;
            this.flag = false;
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetCurFrq(int value) {
        this.flag = true;
        if (value == 1) {
            DataCanbus.PROXY.cmd(5, new int[]{6}, null, null);
        } else if (value == 2) {
            DataCanbus.PROXY.cmd(5, new int[]{5}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[344].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[344].removeNotify(this.mNotifyCanbus);
    }
}
