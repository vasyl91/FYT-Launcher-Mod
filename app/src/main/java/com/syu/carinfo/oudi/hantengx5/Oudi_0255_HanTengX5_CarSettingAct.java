package com.syu.carinfo.oudi.hantengx5;

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

@SuppressWarnings({"deprecation", "unchecked"})
public class Oudi_0255_HanTengX5_CarSettingAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 121:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBrightLevel();
                    break;
                case 122:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateAmbientLightSwitch();
                    break;
                case 123:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateSeatCourtesySwitch();
                    break;
                case 124:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateControlMethod();
                    break;
                case 125:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateStaticSet();
                    break;
                case 126:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBlueGreenRed();
                    break;
                case 127:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateBluePurpleRed();
                    break;
                case 128:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSetting();
                    break;
                case 129:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSampling();
                    break;
                case 130:
                    Oudi_0255_HanTengX5_CarSettingAct.this.updateDynamicSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0255_oudi_hantentx5_carsetting);
        init();
    }

    @Override
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[121] & 255;
                if (brightlevel2 <= 1) {
                    brightlevel = 7;
                } else {
                    brightlevel = brightlevel2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int brightlevel;
                int brightlevel2 = DataCanbus.DATA[121] & 255;
                if (brightlevel2 >= 6) {
                    brightlevel = 1;
                } else {
                    brightlevel = brightlevel2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, brightlevel}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[124] & 255;
                if (controlmethod2 <= 0) {
                    controlmethod = 2;
                } else {
                    controlmethod = controlmethod2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int controlmethod;
                int controlmethod2 = DataCanbus.DATA[124] & 255;
                if (controlmethod2 > 1) {
                    controlmethod = 2;
                } else {
                    controlmethod = controlmethod2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, controlmethod}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicset;
                int dynamicset2 = DataCanbus.DATA[128] & 255;
                if (dynamicset2 <= 0) {
                    dynamicset = 2;
                } else {
                    dynamicset = dynamicset2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, dynamicset}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicset;
                int dynamicset2 = DataCanbus.DATA[128] & 255;
                if (dynamicset2 >= 2) {
                    dynamicset = 0;
                } else {
                    dynamicset = dynamicset2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, dynamicset}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int bluegreenred;
                int bluegreenred2 = DataCanbus.DATA[126] & 255;
                if (bluegreenred2 <= 0) {
                    bluegreenred = 255;
                } else {
                    bluegreenred = bluegreenred2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, bluegreenred}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus4), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int bluegreenred;
                int bluegreenred2 = DataCanbus.DATA[126] & 255;
                if (bluegreenred2 >= 255) {
                    bluegreenred = 0;
                } else {
                    bluegreenred = bluegreenred2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, bluegreenred}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int bluepurplered;
                int bluepurplered2 = DataCanbus.DATA[127] & 255;
                if (bluepurplered2 <= 0) {
                    bluepurplered = 255;
                } else {
                    bluepurplered = bluepurplered2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, bluepurplered}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus5), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int bluepurplered;
                int bluepurplered2 = DataCanbus.DATA[127] & 255;
                if (bluepurplered2 >= 255) {
                    bluepurplered = 0;
                } else {
                    bluepurplered = bluepurplered2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{153, bluepurplered}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicsampling;
                int dynamicsampling2 = DataCanbus.DATA[129] & 255;
                if (dynamicsampling2 == 0) {
                    dynamicsampling = 1;
                } else {
                    dynamicsampling = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, dynamicsampling}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus6), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicsampling;
                int dynamicsampling2 = DataCanbus.DATA[129] & 255;
                if (dynamicsampling2 == 0) {
                    dynamicsampling = 1;
                } else {
                    dynamicsampling = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{155, dynamicsampling}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_minus7), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicspeed;
                int dynamicspeed2 = DataCanbus.DATA[130] & 255;
                if (dynamicspeed2 <= 0) {
                    dynamicspeed = 255;
                } else {
                    dynamicspeed = dynamicspeed2 - 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{156, dynamicspeed}, null, null);
            }
        });
        setSelfClick((Button) findViewById(R.id.btn_plus7), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int dynamicspeed;
                int dynamicspeed2 = DataCanbus.DATA[130] & 255;
                if (dynamicspeed2 >= 255) {
                    dynamicspeed = 0;
                } else {
                    dynamicspeed = dynamicspeed2 + 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{156, dynamicspeed}, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[122] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 148;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[123] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 147;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int switchOn = DataCanbus.DATA[128] & 255;
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 154;
                iArr[1] = switchOn == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateBrightLevel() {
        int brightlevel = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text1)) != null && brightlevel > 0 && brightlevel <= 7) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("%d", Integer.valueOf(brightlevel))) + "level");
        }
    }

    
    public void updateControlMethod() {
        int controlmethod = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (controlmethod == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_255_hantengx5_11);
            } else if (controlmethod == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_255_hantengx5_12);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
            }
        }
    }

    
    public void updateStaticSet() {
        int staticset = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (staticset == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_14);
            } else if (staticset == 2) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_15);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_255_hantengx5_13);
            }
        }
    }

    
    public void updateDynamicSampling() {
        int dynamicsampling = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (dynamicsampling == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_17);
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setText(R.string.str_255_hantengx5_16);
            }
        }
    }

    
    public void updateBlueGreenRed() {
        int bluegreenred = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.tv_text4)) != null && bluegreenred > 0 && bluegreenred <= 255) {
            ((TextView) findViewById(R.id.tv_text4)).setText(String.format("%d", Integer.valueOf(bluegreenred)));
        }
    }

    
    public void updateBluePurpleRed() {
        int bluepurplered = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.tv_text5)) != null && bluepurplered > 0 && bluepurplered <= 255) {
            ((TextView) findViewById(R.id.tv_text5)).setText(String.format("%d", Integer.valueOf(bluepurplered)));
        }
    }

    
    public void updateDynamicSpeed() {
        int dynamicspeed = DataCanbus.DATA[130];
        if (((TextView) findViewById(R.id.tv_text7)) != null && dynamicspeed > 0 && dynamicspeed <= 255) {
            ((TextView) findViewById(R.id.tv_text7)).setText(String.format("%d", Integer.valueOf(dynamicspeed)));
        }
    }

    
    public void updateAmbientLightSwitch() {
        int ambientlight = DataCanbus.DATA[122];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext1), ambientlight != 0);
    }

    
    public void updateSeatCourtesySwitch() {
        int seatcourtesy = DataCanbus.DATA[123];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext2), seatcourtesy != 0);
    }

    
    public void updateDynamicSetting() {
        int dynamicsetting = DataCanbus.DATA[128];
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext3), dynamicsetting != 0);
    }
}
