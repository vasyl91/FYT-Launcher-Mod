package com.syu.carinfo.accord9.wc;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

@SuppressWarnings({"deprecation", "unchecked"})
public class Accord9LowSettingsAct extends BaseActivity implements View.OnClickListener {
    int iEnableBackVideo;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int mSendAreaSet;
    int mSendAutoRelockTime;
    int mSendCytoreductiveTime;
    int mSendMileageSettings;
    int mSendOutsideTempAdjust;
    int mSendRemoteLatchShow;
    int mSendTripAResetTime;
    int mSendTripBResetTime;
    int mSendTurnOffTime;
    int[] send_lang;
    private int[] mInt2 = {0, 1};
    private int[] mInt3 = {1, 2, 3};
    private int[] mInt4 = {0, 1, 2, 3};
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    Accord9LowSettingsAct.this.mUpdaterOil();
                    break;
                case 122:
                    Accord9LowSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 123:
                    Accord9LowSettingsAct.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 124:
                    Accord9LowSettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 125:
                    Accord9LowSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 126:
                    Accord9LowSettingsAct.this.mUpdaterOpenBiglampwiper();
                    break;
                case 127:
                    Accord9LowSettingsAct.this.mUpdaterDayTimeRuningLights();
                    break;
                case 128:
                    Accord9LowSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 135:
                    Accord9LowSettingsAct.this.mUpdaterEnableBackVideo(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_accord9_low_settings);
        initView();
        setListener();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Accord9LowSettingsAct.this.language_set = position;
                if (Accord9LowSettingsAct.this.language_set >= 0 && Accord9LowSettingsAct.this.language_set <= Accord9LowSettingsAct.this.mLauStylelist.size() && Accord9LowSettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(17, new int[]{Accord9LowSettingsAct.this.send_lang[Accord9LowSettingsAct.this.language_set]}, null, null);
                }
                Accord9LowSettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    private void initView() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Accord9LowSettingsAct.this.mLauStyle == null) {
                    Accord9LowSettingsAct.this.initLauStyle();
                }
                if (Accord9LowSettingsAct.this.mLauStyle != null && Accord9LowSettingsAct.this.mPopShowView != null) {
                    Accord9LowSettingsAct.this.mLauStyle.showAtLocation(Accord9LowSettingsAct.this.mPopShowView, 17, 0, 0);
                    Accord9LowSettingsAct.this.updateLauguageSet();
                }
            }
        });
        ((TextView) findViewById(R.id.accord9_low_tv_settings_area)).setText(new StringBuilder().append(this.mSendAreaSet).toString());
        ((CheckedTextView) findViewById(R.id.accord_btn_rest_tire)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                Accord9LowSettingsAct.this.dialog(R.string.str_321_tireclean, 14);
            }
        });
        ((CheckedTextView) findViewById(R.id.accord9_backvideo_enable)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = Accord9LowSettingsAct.this.iEnableBackVideo != 0 ? 0 : 1;
                remoteModuleProxy.cmd(16, iArr, null, null);
            }
        });
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_remote_latch_show)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_mileage_set)).setOnClickListener(this);
        ((TextView) findViewById(R.id.accord9_low_tv_outside_temp_adjust_sets)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_auto_relock_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_turn_off_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_cytoreductive_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_outside_temp_adjust_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_tripB_reset_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_tripA_reset_time_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_auto_relock_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_turn_off_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_cytoreductive_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_outside_temp_adjust_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_tripB_reset_time_add)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_tripA_reset_time_add)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_air_condition_resend)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_other_resend)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_tpms_calibration)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_maintenance_reset)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_default_all)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.accord9_low_ctv_compass_calibration)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_settings_area_sub)).setOnClickListener(this);
        ((Button) findViewById(R.id.accord9_low_btn_settings_area_add)).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 65578 || DataCanbus.DATA[1000] == 131114) {
            setViewVisible(findViewById(R.id.accord9_rest_tire_view), true);
            setViewVisible(findViewById(R.id.accord9_backvideo_enable_view), true);
        } else {
            setViewVisible(findViewById(R.id.accord9_backvideo_enable_view), false);
            setViewVisible(findViewById(R.id.accord9_rest_tire_view), false);
        }
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(cmd, new int[1], null, null);
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int mReceiverRemoteLatchShow = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.accord9_low_ctv_remote_latch_show)) != null) {
            ((CheckedTextView) findViewById(R.id.accord9_low_ctv_remote_latch_show)).setChecked(mReceiverRemoteLatchShow != 0);
        }
    }

    protected void mUpdaterEnableBackVideo(int i) {
        this.iEnableBackVideo = i;
        setCheck((CheckedTextView) findViewById(R.id.accord9_backvideo_enable), i != 0);
    }

    
    public void mUpdaterLockUnlockFeedbackTone() {
        int mReceiverAutoRelockTime = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.accord9_low_tv_auto_relock_time)) != null && mReceiverAutoRelockTime > -1 && mReceiverAutoRelockTime < 4) {
            ((TextView) findViewById(R.id.accord9_low_tv_auto_relock_time)).setText(AccordConfig.mStrLockSetAutoTime[mReceiverAutoRelockTime]);
        }
    }

    
    public void mUpdaterHeadLampsAutoOffTimer() {
        int mReceiverTurnOffTime = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.accord9_low_tv_turn_off_time)) != null && mReceiverTurnOffTime > -1 && mReceiverTurnOffTime < 4) {
            ((TextView) findViewById(R.id.accord9_low_tv_turn_off_time)).setText(AccordConfig.mStrLightOffAutoTime[mReceiverTurnOffTime]);
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int mReceiverCytoreductiveTime = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.accord9_low_tv_cytoreductive_time)) != null && mReceiverCytoreductiveTime > -1 && mReceiverCytoreductiveTime < 4) {
            ((TextView) findViewById(R.id.accord9_low_tv_cytoreductive_time)).setText(AccordConfig.mStrLightOffAutoTime[mReceiverCytoreductiveTime]);
        }
    }

    
    public void mUpdaterOil() {
        int mReceiverOutsideTempAdjust = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.accord9_low_tv_outside_temp_adjust)) != null && mReceiverOutsideTempAdjust >= 0 && mReceiverOutsideTempAdjust < 11) {
            ((TextView) findViewById(R.id.accord9_low_tv_outside_temp_adjust)).setText(AccordConfig.mStrOutSideTemp[mReceiverOutsideTempAdjust]);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int mReceiverMileageSettings = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.accord9_low_ctv_mileage_set)) != null) {
            ((CheckedTextView) findViewById(R.id.accord9_low_ctv_mileage_set)).setChecked(mReceiverMileageSettings != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int mReceiverTripBResetTime = DataCanbus.DATA[128];
        if (((TextView) findViewById(R.id.accord9_low_tv_tripB_reset_time)) != null && mReceiverTripBResetTime > -1 && mReceiverTripBResetTime < 4) {
            ((TextView) findViewById(R.id.accord9_low_tv_tripB_reset_time)).setText(getTrip(mReceiverTripBResetTime));
        }
    }

    
    public void mUpdaterOpenBiglampwiper() {
        int mReceiverTripAResetTime = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.accord9_low_tv_tripA_reset_time)) != null && mReceiverTripAResetTime > -1 && mReceiverTripAResetTime < 4) {
            ((TextView) findViewById(R.id.accord9_low_tv_tripA_reset_time)).setText(getTrip(mReceiverTripAResetTime));
        }
    }

    public String getTrip(int value) {
        switch (value) {
            case 0:
                String str = getString(R.string.invalid_value);
                return str;
            case 1:
                String str2 = getString(R.string.str_with_refuel);
                return str2;
            case 2:
                String str3 = getString(R.string.str_ign_off);
                return str3;
            case 3:
                String str4 = getString(R.string.str_manually_reset);
                return str4;
            default:
                return "";
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accord9_low_ctv_remote_latch_show /* 2131430141 */:
                this.mSendRemoteLatchShow = (this.mSendRemoteLatchShow + 1) % 2;
                DataCanbus.PROXY.cmd(2, new int[]{this.mInt2[this.mSendRemoteLatchShow]}, null, null);
                break;
            case R.id.accord9_low_btn_auto_relock_time_sub /* 2131430142 */:
                this.mSendAutoRelockTime--;
                if (this.mSendAutoRelockTime < 0) {
                    this.mSendAutoRelockTime = 2;
                } else if (this.mSendAutoRelockTime > 2) {
                    this.mSendAutoRelockTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{this.mInt3[this.mSendAutoRelockTime]}, null, null);
                break;
            case R.id.accord9_low_btn_auto_relock_time_add /* 2131430144 */:
                this.mSendAutoRelockTime++;
                if (this.mSendAutoRelockTime < 0) {
                    this.mSendAutoRelockTime = 2;
                } else if (this.mSendAutoRelockTime > 2) {
                    this.mSendAutoRelockTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{this.mInt3[this.mSendAutoRelockTime]}, null, null);
                break;
            case R.id.accord9_low_btn_turn_off_time_sub /* 2131430145 */:
                this.mSendTurnOffTime--;
                if (this.mSendTurnOffTime < 0) {
                    this.mSendTurnOffTime = 3;
                } else if (this.mSendTurnOffTime > 3) {
                    this.mSendTurnOffTime = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{this.mInt4[this.mSendTurnOffTime]}, null, null);
                break;
            case R.id.accord9_low_btn_turn_off_time_add /* 2131430147 */:
                this.mSendTurnOffTime++;
                if (this.mSendTurnOffTime < 0) {
                    this.mSendTurnOffTime = 3;
                } else if (this.mSendTurnOffTime > 3) {
                    this.mSendTurnOffTime = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{this.mInt4[this.mSendTurnOffTime]}, null, null);
                break;
            case R.id.accord9_low_btn_cytoreductive_time_sub /* 2131430148 */:
                this.mSendCytoreductiveTime--;
                if (this.mSendCytoreductiveTime < 0) {
                    this.mSendCytoreductiveTime = 2;
                } else if (this.mSendCytoreductiveTime > 2) {
                    this.mSendCytoreductiveTime = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{this.mInt3[this.mSendCytoreductiveTime]}, null, null);
                break;
            case R.id.accord9_low_btn_cytoreductive_time_add /* 2131430150 */:
                this.mSendCytoreductiveTime++;
                if (this.mSendCytoreductiveTime < 0) {
                    this.mSendCytoreductiveTime = 2;
                } else if (this.mSendCytoreductiveTime > 2) {
                    this.mSendCytoreductiveTime = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{this.mInt3[this.mSendCytoreductiveTime]}, null, null);
                break;
            case R.id.accord9_low_btn_outside_temp_adjust_sub /* 2131430152 */:
                this.mSendOutsideTempAdjust--;
                if (this.mSendOutsideTempAdjust < 0) {
                    this.mSendOutsideTempAdjust = 10;
                } else if (this.mSendOutsideTempAdjust > 10) {
                    this.mSendOutsideTempAdjust = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{this.mSendOutsideTempAdjust}, null, null);
                break;
            case R.id.accord9_low_btn_outside_temp_adjust_add /* 2131430154 */:
                this.mSendOutsideTempAdjust++;
                if (this.mSendOutsideTempAdjust < 0) {
                    this.mSendOutsideTempAdjust = 10;
                } else if (this.mSendOutsideTempAdjust > 10) {
                    this.mSendOutsideTempAdjust = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{this.mSendOutsideTempAdjust}, null, null);
                break;
            case R.id.accord9_low_ctv_mileage_set /* 2131430155 */:
                this.mSendMileageSettings = (this.mSendMileageSettings + 1) % 2;
                DataCanbus.PROXY.cmd(8, new int[]{this.mInt2[this.mSendMileageSettings]}, null, null);
                break;
            case R.id.accord9_low_btn_tripB_reset_time_sub /* 2131430156 */:
                this.mSendTripBResetTime--;
                if (this.mSendTripBResetTime < 0) {
                    this.mSendTripBResetTime = 2;
                } else if (this.mSendTripBResetTime > 2) {
                    this.mSendTripBResetTime = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{this.mInt3[this.mSendTripBResetTime]}, null, null);
                break;
            case R.id.accord9_low_btn_tripB_reset_time_add /* 2131430158 */:
                this.mSendTripBResetTime++;
                if (this.mSendTripBResetTime < 0) {
                    this.mSendTripBResetTime = 2;
                } else if (this.mSendTripBResetTime > 2) {
                    this.mSendTripBResetTime = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{this.mInt3[this.mSendTripBResetTime]}, null, null);
                break;
            case R.id.accord9_low_btn_tripA_reset_time_sub /* 2131430159 */:
                this.mSendTripAResetTime--;
                if (this.mSendTripAResetTime < 0) {
                    this.mSendTripAResetTime = 2;
                } else if (this.mSendTripAResetTime > 2) {
                    this.mSendTripAResetTime = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{this.mInt3[this.mSendTripAResetTime]}, null, null);
                break;
            case R.id.accord9_low_btn_tripA_reset_time_add /* 2131430161 */:
                this.mSendTripAResetTime++;
                if (this.mSendTripAResetTime < 0) {
                    this.mSendTripAResetTime = 2;
                } else if (this.mSendTripAResetTime > 2) {
                    this.mSendTripAResetTime = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{this.mInt3[this.mSendTripAResetTime]}, null, null);
                break;
            case R.id.accord9_low_ctv_air_condition_resend /* 2131430162 */:
                DataCanbus.PROXY.cmd(9, new int[]{305}, null, null);
                break;
            case R.id.accord9_low_ctv_other_resend /* 2131430163 */:
                DataCanbus.PROXY.cmd(9, new int[]{273}, null, null);
                break;
            case R.id.accord9_low_ctv_tpms_calibration /* 2131430166 */:
                DataCanbus.PROXY.cmd(10, new int[]{256}, null, null);
                break;
            case R.id.accord9_low_ctv_maintenance_reset /* 2131430167 */:
                DataCanbus.PROXY.cmd(10, new int[]{512}, null, null);
                break;
            case R.id.accord9_low_ctv_default_all /* 2131430168 */:
                DataCanbus.PROXY.cmd(10, new int[]{768}, null, null);
                break;
            case R.id.accord9_low_ctv_compass_calibration /* 2131430171 */:
                DataCanbus.PROXY.cmd(10, new int[]{1024}, null, null);
                break;
            case R.id.accord9_low_btn_settings_area_sub /* 2131430172 */:
                this.mSendAreaSet--;
                if (this.mSendAreaSet < 0) {
                    this.mSendAreaSet = 15;
                } else if (this.mSendAreaSet > 15) {
                    this.mSendAreaSet = 0;
                }
                ((TextView) findViewById(R.id.accord9_low_tv_settings_area)).setText(new StringBuilder().append(this.mSendAreaSet).toString());
                DataCanbus.PROXY.cmd(10, new int[]{1280}, null, null);
                break;
            case R.id.accord9_low_btn_settings_area_add /* 2131430174 */:
                this.mSendAreaSet++;
                if (this.mSendAreaSet < 0) {
                    this.mSendAreaSet = 15;
                } else if (this.mSendAreaSet > 15) {
                    this.mSendAreaSet = 0;
                }
                ((TextView) findViewById(R.id.accord9_low_tv_settings_area)).setText(new StringBuilder().append(this.mSendAreaSet).toString());
                DataCanbus.PROXY.cmd(10, new int[]{this.mSendAreaSet | 1280}, null, null);
                break;
        }
    }
}
