package com.syu.carinfo.xfy.guandao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.accord9.wc.AccordConfig;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GuandaoSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    GuandaoSettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 103:
                    GuandaoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 104:
                    GuandaoSettingsAct.this.mUpdaterD2B07();
                    break;
                case 105:
                    GuandaoSettingsAct.this.mUpdaterD2B06();
                    break;
                case 106:
                    GuandaoSettingsAct.this.mUpdaterD2B04();
                    break;
                case 107:
                    GuandaoSettingsAct.this.mUpdaterD2B02();
                    break;
                case 108:
                    GuandaoSettingsAct.this.mUpdaterD2B00();
                    break;
                case 109:
                    GuandaoSettingsAct.this.mUpdaterD3B07();
                    break;
                case 110:
                    GuandaoSettingsAct.this.mUpdaterD3B06();
                    break;
                case 111:
                    GuandaoSettingsAct.this.mUpdaterD3B05();
                    break;
                case 112:
                    GuandaoSettingsAct.this.mUpdaterD3B04();
                    break;
                case 113:
                    GuandaoSettingsAct.this.mUpdaterD4B07();
                    break;
                case 114:
                    GuandaoSettingsAct.this.mUpdaterD4B06();
                    break;
                case 115:
                    GuandaoSettingsAct.this.mUpdaterLoud();
                    break;
                case 116:
                    GuandaoSettingsAct.this.mUpdaterSpeedvol();
                    break;
                case 117:
                    GuandaoSettingsAct.this.mUpdaterDts();
                    break;
                case 118:
                    GuandaoSettingsAct.this.mUpdaterD0B02();
                    break;
                case 119:
                    GuandaoSettingsAct.this.mUpdaterD0B00();
                    break;
                case 120:
                    GuandaoSettingsAct.this.mUpdaterD5B06();
                    break;
                case 121:
                    GuandaoSettingsAct.this.mUpdaterD5B05();
                    break;
                case 122:
                    GuandaoSettingsAct.this.mUpdaterD5B04();
                    break;
                case 123:
                    GuandaoSettingsAct.this.mUpdaterD5B03();
                    break;
                case 124:
                    GuandaoSettingsAct.this.mUpdaterD5B02();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xfy_guandao);
        initView();
        setListener();
    }

    private void initView() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GuandaoSettingsAct.this.dialog(R.string.str_other_set_TPMS_Calibration, 19);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GuandaoSettingsAct.this.dialog(R.string.str_other_set_Maintenance_Reset, 18);
            }
        });
        if (DataCanbus.DATA[1000] == 425) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            return;
        }
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(0);
        findViewById(R.id.layout_view3).setVisibility(0);
        findViewById(R.id.layout_view4).setVisibility(0);
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(" " + getResources().getString(stringId));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.xfy.guandao.GuandaoSettingsAct.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD0B02() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD0B00() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B06() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B05() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B04() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B03() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD5B02() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoud() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value >= 0 && value < 13) {
            ((TextView) findViewById(R.id.tv_text6)).setText(AccordConfig.mStrLoud[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSpeedvol() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_middle);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
            } else {
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.str_right_camera_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDts() {
        int value = DataCanbus.DATA[117];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD4B07() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_right_camera_open);
            } else {
                ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_right_camera_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD4B06() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_guandao_remote_open2);
            } else {
                ((TextView) findViewById(R.id.tv_text10)).setText(R.string.str_guandao_remote_open1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B07() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.distance_far);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.distance_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B06() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B05() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD3B04() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B07() {
        int mReceiverRemoteLatchShow = DataCanbus.DATA[104];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mReceiverRemoteLatchShow != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B06() {
        int mGuanDaoLockShow = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mGuanDaoLockShow != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B04() {
        String[] mStrLockSetAutoTime = {"30s", "60s", "90s"};
        int mReceiverAutoRelockTime = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.tv_text1)) != null && mReceiverAutoRelockTime > -1 && mReceiverAutoRelockTime < 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(mStrLockSetAutoTime[mReceiverAutoRelockTime]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B00() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.guandao_lock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.guandao_lock2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.guandao_lock3);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.rzc_c4l_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterD2B02() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.guandao_unlock1);
                return;
            }
            if (value == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.guandao_unlock2);
            } else if (value == 3) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.guandao_lock3);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.rzc_c4l_close);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsAutoOffTimer() {
        String[] mStrLightOffAutoTime = {"0", "15s", "30s", "60s"};
        int mReceiverTurnOffTime = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text4)) != null && mReceiverTurnOffTime > -1 && mReceiverTurnOffTime < 4) {
            ((TextView) findViewById(R.id.tv_text4)).setText(mStrLightOffAutoTime[mReceiverTurnOffTime]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        String[] mStrLightOffAutoTime = {"15s", "30s", "60s"};
        int mReceiverCytoreductiveTime = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text5)) != null && mReceiverCytoreductiveTime > -1 && mReceiverCytoreductiveTime < 3) {
            ((TextView) findViewById(R.id.tv_text5)).setText(mStrLightOffAutoTime[mReceiverCytoreductiveTime]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int mReceiverAutoRelockTime = DataCanbus.DATA[106] - 1;
                if (mReceiverAutoRelockTime < 0) {
                    mReceiverAutoRelockTime = 2;
                } else if (mReceiverAutoRelockTime > 2) {
                    mReceiverAutoRelockTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, mReceiverAutoRelockTime}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int mReceiverAutoRelockTime2 = DataCanbus.DATA[106] + 1;
                if (mReceiverAutoRelockTime2 < 0) {
                    mReceiverAutoRelockTime2 = 2;
                } else if (mReceiverAutoRelockTime2 > 2) {
                    mReceiverAutoRelockTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{11, mReceiverAutoRelockTime2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value = DataCanbus.DATA[108] - 1;
                if (value > 2) {
                    value = 0;
                } else if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value2 = DataCanbus.DATA[108] + 1;
                if (value2 > 2) {
                    value2 = 0;
                } else if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value2}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 > 2) {
                    value3 = 0;
                }
                if (value3 < 0) {
                    value3 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value3}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 2) {
                    value4 = 0;
                } else if (value4 < 0) {
                    value4 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value4}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int mSendTurnOffTime = DataCanbus.DATA[102] - 1;
                if (mSendTurnOffTime < 0) {
                    mSendTurnOffTime = 3;
                } else if (mSendTurnOffTime > 3) {
                    mSendTurnOffTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, mSendTurnOffTime}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int mSendTurnOffTime2 = DataCanbus.DATA[102] + 1;
                if (mSendTurnOffTime2 < 0) {
                    mSendTurnOffTime2 = 3;
                } else if (mSendTurnOffTime2 > 3) {
                    mSendTurnOffTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{5, mSendTurnOffTime2}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int mSendCytoreductiveTime = DataCanbus.DATA[103] - 1;
                if (mSendCytoreductiveTime < 0) {
                    mSendCytoreductiveTime = 2;
                } else if (mSendCytoreductiveTime > 2) {
                    mSendCytoreductiveTime = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, mSendCytoreductiveTime}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int mSendCytoreductiveTime2 = DataCanbus.DATA[103] + 1;
                if (mSendCytoreductiveTime2 < 0) {
                    mSendCytoreductiveTime2 = 2;
                } else if (mSendCytoreductiveTime2 > 2) {
                    mSendCytoreductiveTime2 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, mSendCytoreductiveTime2}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value5 = DataCanbus.DATA[115] - 1;
                if (value5 > 12) {
                    value5 = 0;
                } else if (value5 < 0) {
                    value5 = 12;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value5}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value6 = DataCanbus.DATA[115] + 1;
                if (value6 > 12) {
                    value6 = 0;
                } else if (value6 < 0) {
                    value6 = 12;
                }
                DataCanbus.PROXY.cmd(2, new int[]{12, value6}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value7 = DataCanbus.DATA[116] - 1;
                if (value7 > 3) {
                    value7 = 0;
                } else if (value7 < 0) {
                    value7 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value7}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value8 = DataCanbus.DATA[116] + 1;
                if (value8 > 3) {
                    value8 = 0;
                } else if (value8 < 0) {
                    value8 = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{14, value8}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value9 = DataCanbus.DATA[109];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value9}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{12, value10}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value11 = DataCanbus.DATA[113];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value11}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value12 = DataCanbus.DATA[113];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{16, value12}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value13 = DataCanbus.DATA[114];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value13}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value14 = DataCanbus.DATA[114];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{17, value14}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int mSendRemoteLatchShow = (DataCanbus.DATA[104] + 1) % 2;
                DataCanbus.PROXY.cmd(1, new int[]{10, mSendRemoteLatchShow}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(1, new int[]{13, (DataCanbus.DATA[110] + 1) % 2}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(1, new int[]{14, (DataCanbus.DATA[111] + 1) % 2}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int mGuanDaoLockShow = (DataCanbus.DATA[105] + 1) % 2;
                DataCanbus.PROXY.cmd(1, new int[]{9, mGuanDaoLockShow}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(2, new int[]{13, (DataCanbus.DATA[117] + 1) % 2}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                DataCanbus.PROXY.cmd(1, new int[]{15, (DataCanbus.DATA[112] + 1) % 2}, null, null);
                break;
        }
    }
}
