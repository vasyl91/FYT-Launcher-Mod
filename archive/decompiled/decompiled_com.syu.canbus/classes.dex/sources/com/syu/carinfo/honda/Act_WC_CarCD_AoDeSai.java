package com.syu.carinfo.honda;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0443_WC2_12ELYSION;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Act_WC_CarCD_AoDeSai extends Activity {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Act_WC_CarCD_AoDeSai.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 30:
                case 32:
                    int Index = DataCanbus.DATA[30];
                    int flag = DataCanbus.DATA[32];
                    ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)).setTextColor(Color.parseColor("#ffffff"));
                    if (flag == 1) {
                        switch (Index) {
                            case 1:
                                ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)).setTextColor(Color.parseColor("#057cf0"));
                                break;
                            case 2:
                                ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)).setTextColor(Color.parseColor("#057cf0"));
                                break;
                            case 3:
                                ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)).setTextColor(Color.parseColor("#057cf0"));
                                break;
                            case 4:
                                ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)).setTextColor(Color.parseColor("#057cf0"));
                                break;
                        }
                    }
                    break;
                case 33:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW1);
                    }
                    break;
                case 34:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW2);
                    }
                    break;
                case 35:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW3);
                    }
                    break;
                case 36:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW4);
                    }
                    break;
                case 37:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)).setText("Auto select");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)).setText("");
                        }
                    }
                    break;
                case 38:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)).setText("ST");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)).setText("");
                        }
                    }
                    break;
                case 39:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)).setText("SCAN");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)).setText("");
                        }
                    }
                    break;
                case 40:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("Rpt: one");
                        } else if (value == 2) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("Random");
                        } else if (value == 3) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("SCAN");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("");
                        }
                    }
                    break;
                case 41:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)).setText("USB");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)).setText("");
                        }
                    }
                    break;
                case 42:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rpt: one");
                        } else if (value == 2) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rpt: folder");
                        } else if (value == 3) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rdm: folder");
                        } else if (value == 4) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rdm: All");
                        } else if (value == 5) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Scan: All");
                        } else if (value == 6) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Scan: folder");
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("");
                        }
                    }
                    break;
                case 43:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_aodesai_bt_bk);
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_btn_null);
                    }
                    break;
                case 44:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single1);
                    } else if (value == 2) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single2);
                    } else if (value == 3) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single3);
                    } else if (value == 4) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single4);
                    } else if (value == 5) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single5);
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_btn_null);
                    }
                    break;
                case 45:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery1);
                    } else if (value == 2) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery2);
                    } else if (value == 3) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery3);
                    } else if (value == 4) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery4);
                    } else if (value == 5) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery5);
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_btn_null);
                    }
                    break;
                case 46:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text5)).setText("Vol: " + value);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_09aodesai_carcd);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }
}
