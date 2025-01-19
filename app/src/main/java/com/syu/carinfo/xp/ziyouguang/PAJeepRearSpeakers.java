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

public class PAJeepRearSpeakers extends BaseActivity implements View.OnTouchListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int language_set = 255;
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
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
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 181:
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
                case 182:
                    if (value == 1) {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                    int hour = DataCanbus.DATA[184];
                    int min = DataCanbus.DATA[185];
                    int sec = DataCanbus.DATA[186];
                    int hour_t = DataCanbus.DATA[187];
                    int min_t = DataCanbus.DATA[188];
                    int sec_t = DataCanbus.DATA[189];
                    int tr = DataCanbus.DATA[190];
                    int totaltr = DataCanbus.DATA[191];
                    PAJeepRearSpeakers.this.totaltrack = DataCanbus.DATA[191];
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
                case 192:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text5)).setText(Callback_0374_XP1_ZiYouGuang.Title);
                    break;
                case 193:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text7)).setText(Callback_0374_XP1_ZiYouGuang.Album);
                    break;
                case 194:
                    ((TextView) PAJeepRearSpeakers.this.findViewById(R.id.tv_text6)).setText(Callback_0374_XP1_ZiYouGuang.Artist);
                    break;
                case 352:
                    if (value == 1) {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_p);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#666666"));
                        break;
                    } else {
                        PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_carcd_button_n);
                        ((Button) PAJeepRearSpeakers.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#ffffff"));
                        break;
                    }
                case 353:
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
                case 355:
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
                case 356:
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_jeep_rear_speakers);
        init();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
        int value = DataCanbus.DATA[190];
        if (value < this.mLauStylelist.size() && value > 0 && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(value - 1, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{21}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{22}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{23}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{24}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{25}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{19}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[353];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{20}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[353];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{20}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{18}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(5, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{14}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{17}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus14)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[181];
                if (value == 3) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{2}, null, null);
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (event.getAction() == 0) {
            switch (id) {
                case R.id.btn_plus12 /* 2131427490 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_plus14 /* 2131427496 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
            }
        } else {
            switch (v.getId()) {
                case R.id.btn_plus12 /* 2131427490 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(5, new int[]{3}, null, null);
                        break;
                    }
                case R.id.btn_plus14 /* 2131427496 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(5, new int[]{4}, null, null);
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

    
    public void mSetCurFrq(int value) {
        this.flag = true;
        if (value == 1) {
            DataCanbus.PROXY.cmd(5, new int[]{6}, null, null);
        } else if (value == 2) {
            DataCanbus.PROXY.cmd(5, new int[]{5}, null, null);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
    }
}
