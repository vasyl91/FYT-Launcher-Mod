package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7_XP_FunctionalDriverAssistanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 126:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDriverSystem();
                    break;
                case 127:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterLastDistance();
                    break;
                case 128:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDistance();
                    break;
                case 129:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterFrontAssist();
                    break;
                case 130:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterAdvanceWarning();
                    break;
                case 131:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayDistanceWarning();
                    break;
                case 132:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist();
                    break;
                case 134:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDriverAlertSystem();
                    break;
                case 206:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.mUpdaterDisplayLaneAssist_JH();
                    break;
                case 230:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext1), value != 0);
                    break;
                case 233:
                    ((TextView) Golf7_XP_FunctionalDriverAssistanceActi.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value + 1).toString());
                    break;
                case 234:
                    Golf7_XP_FunctionalDriverAssistanceActi.this.setCheck((CheckedTextView) Golf7_XP_FunctionalDriverAssistanceActi.this.findViewById(R.id.ctv_checkedtext2), value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_state_driver_assistance_xp);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[129] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 51;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[130] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 52;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[131] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 53;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[132] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 48;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[206] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 54;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[134] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 49;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[126] & 255;
                if (mValue > 1) {
                    mValue--;
                }
                DataCanbus.PROXY.cmd(107, new int[]{55, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_system_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = DataCanbus.DATA[126] & 255;
                if (mValue < 3) {
                    mValue++;
                }
                DataCanbus.PROXY.cmd(107, new int[]{55, mValue}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[230] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 57;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[234] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 58;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[127] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 50;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(107, iArr, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[128] & 255) - 1;
                if (mValue < 0) {
                    mValue = 4;
                }
                DataCanbus.PROXY.cmd(107, new int[]{56, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.glf7_btn_functional_driver_assistance_distance_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[128] & 255) + 1;
                if (mValue > 4) {
                    mValue = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{56, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[233] & 255) - 1;
                if (mValue < 0) {
                    mValue = 4;
                }
                DataCanbus.PROXY.cmd(107, new int[]{59, mValue}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int mValue = (DataCanbus.DATA[233] & 255) + 1;
                if (mValue > 4) {
                    mValue = 0;
                }
                DataCanbus.PROXY.cmd(107, new int[]{59, mValue}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterFrontAssist() {
        int switchOn = DataCanbus.DATA[129] & 255;
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_advance_warning), switchOn != 0);
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_distance_warning), switchOn != 0);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_front_assist), switchOn != 0);
    }

    
    public void mUpdaterAdvanceWarning() {
        int switchOn = DataCanbus.DATA[130] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_advance_warning), switchOn != 0);
    }

    
    public void mUpdaterDisplayDistanceWarning() {
        int switchOn = DataCanbus.DATA[131] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_distance_warning), switchOn != 0);
    }

    
    public void mUpdaterDisplayLaneAssist() {
        int switchOn = DataCanbus.DATA[132] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist), switchOn != 0);
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
    }

    
    public void mUpdaterDisplayLaneAssist_JH() {
        int switchOn = DataCanbus.DATA[206] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_display_lane_Assist_JH), switchOn != 0);
    }

    
    public void mUpdaterDriverAlertSystem() {
        int switchOn = DataCanbus.DATA[134] & 255;
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_driver_alert_system), switchOn != 0);
    }

    
    public void mUpdaterDriverSystem() {
        int switchOn = DataCanbus.DATA[126] & 255;
        if (switchOn == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_economics);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_sports);
        } else {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_driver_system)).setText(R.string.driver_system_standard);
        }
    }

    
    public void mUpdaterLastDistance() {
        int value = DataCanbus.DATA[127] & 255;
        setViewVisible(findViewById(R.id.glf7_view_functional_driver_assistance_distance), value == 0);
        setCheck((CheckedTextView) findViewById(R.id.glf7_btn_functional_driver_assistance_last_distance_selected), value != 0);
    }

    
    public void mUpdaterDistance() {
        int mValue = DataCanbus.DATA[128] & 255;
        if (mValue == 0) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_very_close);
            return;
        }
        if (mValue == 1) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_close);
            return;
        }
        if (mValue == 2) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_medium);
        } else if (mValue == 3) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_far);
        } else if (mValue == 4) {
            ((TextView) findViewById(R.id.glf7_tv_functional_driver_assistance_distance)).setText(R.string.distance_very_far);
        }
    }
}
