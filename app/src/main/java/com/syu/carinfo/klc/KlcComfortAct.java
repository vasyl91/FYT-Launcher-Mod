package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KlcComfortAct extends Activity implements View.OnClickListener {
    CheckedTextView AutoFoldCheck;
    View AutoFoldView;
    Button LaneAssistNext;
    Button LaneAssistPre;
    TextView LaneAssistTV;
    CheckedTextView MirrorReveAutoCheck;
    View MirrorReveAutoView;
    CheckedTextView PreferSetCheck;
    View PreferSetView;
    CheckedTextView ReverseAutoRearWindowCheck;
    View ReverseAutoRearWindowView;
    CheckedTextView SeatParkSetCheck;
    View SeatParkSetView;
    Button SteerColumnShiftNext;
    Button SteerColumnShiftPre;
    TextView SteerColumnShiftTV;
    View SteerColumnShiftView;
    CheckedTextView TiltTeerColumnCheck;
    View TiltTeerColumnView;
    CheckedTextView mAutoYuGuaCheck;
    View mAutoYuGuaView;
    View mLaneAssistView;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcComfortAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 20:
                    KlcComfortAct.this.updateDriverSeatYiwei();
                    break;
                case 21:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuYiwei();
                    break;
                case 22:
                    KlcComfortAct.this.updateAutoMirrorQingxie();
                    break;
                case 23:
                    KlcComfortAct.this.updateAutoMirrorFold();
                    break;
                case 24:
                    KlcComfortAct.this.updateDriverPersonalSet();
                    break;
                case 25:
                    KlcComfortAct.this.updateAutoYushuaSheading();
                    break;
                case 26:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuQingxie();
                    break;
                case 69:
                    KlcComfortAct.this.updateAutoYugua();
                    break;
                case 108:
                case 111:
                    KlcComfortAct.this.updatelaneassist();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_comfort_set);
        init();
        setUI();
    }

    private void init() {
        this.SeatParkSetCheck = (CheckedTextView) findViewById(R.id.klc_btn_Seat_parking_shift_settings_check);
        this.MirrorReveAutoCheck = (CheckedTextView) findViewById(R.id.klc_btn_Mirror_reversing_automatic_tilt_check);
        this.AutoFoldCheck = (CheckedTextView) findViewById(R.id.klc_btn_Automatic_folding_mirrors_check);
        this.PreferSetCheck = (CheckedTextView) findViewById(R.id.klc_btn_Preferences_set_check);
        this.ReverseAutoRearWindowCheck = (CheckedTextView) findViewById(R.id.klc_btn_Reverse_Auto_Rear_Window_Wiper_check);
        this.TiltTeerColumnCheck = (CheckedTextView) findViewById(R.id.klc_btn_Tilt_teering_column_away_check);
        this.mAutoYuGuaCheck = (CheckedTextView) findViewById(R.id.wc_weilang_auto_yugua_check);
        this.SteerColumnShiftPre = (Button) findViewById(R.id.klc_btn_Steering_column_shift_away_pre);
        this.SteerColumnShiftNext = (Button) findViewById(R.id.klc_btn_Steering_column_shift_away_next);
        this.LaneAssistPre = (Button) findViewById(R.id.wc_lane_assist_pre);
        this.LaneAssistNext = (Button) findViewById(R.id.wc_lane_assist_next);
        this.SteerColumnShiftTV = (TextView) findViewById(R.id.klc_btn_Steering_column_shift_away_Tv);
        this.LaneAssistTV = (TextView) findViewById(R.id.wc_lane_assist_view);
        this.SeatParkSetView = findViewById(R.id.klc_btn_Seat_parking_shift_settings_view);
        this.MirrorReveAutoView = findViewById(R.id.klc_btn_Mirror_reversing_automatic_tilt_view);
        this.AutoFoldView = findViewById(R.id.klc_btn_Automatic_folding_mirrors_view);
        this.PreferSetView = findViewById(R.id.klc_btn_Preferences_set_view);
        this.ReverseAutoRearWindowView = findViewById(R.id.klc_btn_Reverse_Auto_Rear_Window_Wiper_view);
        this.TiltTeerColumnView = findViewById(R.id.klc_btn_Tilt_teering_column_away_view);
        this.SteerColumnShiftView = findViewById(R.id.klc_comfort_Steering_column_shift_away_view);
        this.mAutoYuGuaView = findViewById(R.id.wc_weilang_auto_yugua_view);
        this.mLaneAssistView = findViewById(R.id.wc_lane_assist);
    }

    private void setUI() {
        this.SeatParkSetCheck.setOnClickListener(this);
        this.MirrorReveAutoCheck.setOnClickListener(this);
        this.AutoFoldCheck.setOnClickListener(this);
        this.PreferSetCheck.setOnClickListener(this);
        this.ReverseAutoRearWindowCheck.setOnClickListener(this);
        this.TiltTeerColumnCheck.setOnClickListener(this);
        this.SteerColumnShiftPre.setOnClickListener(this);
        this.SteerColumnShiftNext.setOnClickListener(this);
        this.LaneAssistPre.setOnClickListener(this);
        this.LaneAssistNext.setOnClickListener(this);
        this.mAutoYuGuaCheck.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int id = v.getId();
        switch (id) {
            case R.id.klc_btn_Seat_parking_shift_settings_check /* 2131431869 */:
                int valseatPark = DataCanbus.DATA[20] & 255;
                KlcFunc.C_CAR_COMFORT(1, valseatPark == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Steering_column_shift_away_pre /* 2131431871 */:
                int valSteerColPre = DataCanbus.DATA[21] & 255;
                if (valSteerColPre == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                    break;
                } else if (valSteerColPre == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                    break;
                } else if (valSteerColPre == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                    break;
                } else if (valSteerColPre == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                    break;
                }
            case R.id.klc_btn_Steering_column_shift_away_next /* 2131431873 */:
                int valSteerColNext = DataCanbus.DATA[21] & 255;
                if (valSteerColNext == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                    break;
                } else if (valSteerColNext == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                    break;
                } else if (valSteerColNext == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                    break;
                } else if (valSteerColNext == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                    break;
                }
            case R.id.klc_btn_Mirror_reversing_automatic_tilt_check /* 2131431875 */:
                int valMirrAuto = DataCanbus.DATA[22] & 255;
                KlcFunc.C_CAR_COMFORT(2, valMirrAuto == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Automatic_folding_mirrors_check /* 2131431877 */:
                int valAutoFlod = DataCanbus.DATA[23] & 255;
                KlcFunc.C_CAR_COMFORT(4, valAutoFlod == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Preferences_set_check /* 2131431879 */:
                int valPrefre = DataCanbus.DATA[24] & 255;
                KlcFunc.C_CAR_COMFORT(5, valPrefre == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Reverse_Auto_Rear_Window_Wiper_check /* 2131431881 */:
                int valRever = DataCanbus.DATA[25] & 255;
                KlcFunc.C_CAR_COMFORT(6, valRever == 0 ? 1 : 0);
                break;
            case R.id.klc_btn_Tilt_teering_column_away_check /* 2131431883 */:
                int valTitlTeer = DataCanbus.DATA[26] & 255;
                KlcFunc.C_CAR_COMFORT(7, valTitlTeer == 0 ? 1 : 0);
                break;
            case R.id.wc_weilang_auto_yugua_check /* 2131431885 */:
                int value3 = DataCanbus.DATA[69] & 255;
                KlcFunc.C_CAR_COMFORT(8, value3 == 0 ? 1 : 0);
                break;
            case R.id.wc_lane_assist_pre /* 2131431887 */:
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value2 = DataCanbus.DATA[111] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value2 = DataCanbus.DATA[108] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value2 = DataCanbus.DATA[111] & 255;
                } else {
                    value2 = DataCanbus.DATA[111] & 255;
                }
                KlcFunc.C_CAR_COMFORT(9, value2 == 0 ? 1 : 0);
                break;
            case R.id.wc_lane_assist_next /* 2131431889 */:
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value = DataCanbus.DATA[111] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value = DataCanbus.DATA[108] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value = DataCanbus.DATA[111] & 255;
                } else {
                    value = DataCanbus.DATA[111] & 255;
                }
                KlcFunc.C_CAR_CRASH(8, value == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 357) {
            findViewById(R.id.wc_weilang_auto_yugua_view).setVisibility(0);
        } else {
            findViewById(R.id.wc_weilang_auto_yugua_view).setVisibility(8);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDriverSeatYiwei() {
        int val = DataCanbus.DATA[20];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.SeatParkSetView.setVisibility(8);
        } else if (enable == 1) {
            this.SeatParkSetView.setVisibility(0);
            this.SeatParkSetCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZhuangxiangGuanzhuYiwei() {
        int val = DataCanbus.DATA[21];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.SteerColumnShiftView.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.SteerColumnShiftView.setVisibility(0);
            if (switchOn == 0) {
                this.SteerColumnShiftTV.setText(R.string.klc_Parking_with_trailer_Off);
                return;
            }
            if (switchOn == 1) {
                this.SteerColumnShiftTV.setText(R.string.klc_comfort_Steering_column_contraction_str);
            } else if (switchOn == 2) {
                this.SteerColumnShiftTV.setText(R.string.klc_comfort_Steering_column_upgrade_str);
            } else if (switchOn == 3) {
                this.SteerColumnShiftTV.setText(R.string.klc_comfort_Steering_column_enhance_steering_column);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoMirrorQingxie() {
        int val = DataCanbus.DATA[22];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.MirrorReveAutoView.setVisibility(8);
        } else if (enable == 1) {
            this.MirrorReveAutoView.setVisibility(0);
            this.MirrorReveAutoCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoMirrorFold() {
        int val = DataCanbus.DATA[23];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.AutoFoldView.setVisibility(8);
        } else if (enable == 1) {
            this.AutoFoldView.setVisibility(0);
            this.AutoFoldCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDriverPersonalSet() {
        int val = DataCanbus.DATA[24];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.PreferSetView.setVisibility(8);
        } else if (enable == 1) {
            this.PreferSetView.setVisibility(0);
            this.PreferSetCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoYushuaSheading() {
        int val = DataCanbus.DATA[25];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.ReverseAutoRearWindowView.setVisibility(8);
        } else if (enable == 1) {
            this.ReverseAutoRearWindowView.setVisibility(0);
            this.ReverseAutoRearWindowCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZhuangxiangGuanzhuQingxie() {
        int val = DataCanbus.DATA[26];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.TiltTeerColumnView.setVisibility(8);
        } else if (enable == 1) {
            this.TiltTeerColumnView.setVisibility(0);
            this.TiltTeerColumnCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoYugua() {
        int val = DataCanbus.DATA[69];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.mAutoYuGuaView.setVisibility(8);
        } else if (enable == 1) {
            this.mAutoYuGuaView.setVisibility(0);
            this.mAutoYuGuaCheck.setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatelaneassist() {
        int val;
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            val = DataCanbus.DATA[111];
        } else if (DataCanbus.DATA[1000] == 357) {
            val = DataCanbus.DATA[108];
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            val = DataCanbus.DATA[111];
        } else {
            val = DataCanbus.DATA[111];
        }
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            this.mLaneAssistView.setVisibility(8);
            return;
        }
        if (enable == 1) {
            this.mLaneAssistView.setVisibility(0);
            if (this.LaneAssistTV != null) {
                if (switchOn == 0) {
                    this.LaneAssistTV.setText(R.string.str_stand_parking);
                } else if (switchOn == 1) {
                    this.LaneAssistTV.setText(R.string.str_incre_parking);
                }
            }
        }
    }
}
