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

@SuppressWarnings({"deprecation", "unchecked"})
public class Act_WC_CarCD_AoDeSai extends Activity {
    public static boolean mIsFront = false;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                case 120:
                    int Index = DataCanbus.DATA[118];
                    int flag = DataCanbus.DATA[120];
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
                case 121:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text1)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW1);
                        break;
                    }
                case 122:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text2)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW2);
                        break;
                    }
                case 123:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text3)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW3);
                        break;
                    }
                case 124:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text4)).setText(Callback_0443_WC2_12ELYSION.STR_SHOW4);
                        break;
                    }
                case 125:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)).setText("Auto select");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text6)).setText("");
                            break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)).setText("ST");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text7)).setText("");
                            break;
                        }
                    }
                    break;
                case 127:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)).setText("SCAN");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text8)).setText("");
                            break;
                        }
                    }
                    break;
                case 128:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("Rpt: one");
                            break;
                        } else if (value == 2) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("Random");
                            break;
                        } else if (value == 3) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("SCAN");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text9)).setText("");
                            break;
                        }
                    }
                    break;
                case 129:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)).setText("USB");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text10)).setText("");
                            break;
                        }
                    }
                    break;
                case 130:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)) != null) {
                        if (value == 1) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rpt: one");
                            break;
                        } else if (value == 2) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rpt: folder");
                            break;
                        } else if (value == 3) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rdm: folder");
                            break;
                        } else if (value == 4) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Rdm: All");
                            break;
                        } else if (value == 5) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Scan: All");
                            break;
                        } else if (value == 6) {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("Scan: folder");
                            break;
                        } else {
                            ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text11)).setText("");
                            break;
                        }
                    }
                    break;
                case 131:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_aodesai_bt_bk);
                        break;
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image1).setBackgroundResource(R.drawable.ic_btn_null);
                        break;
                    }
                case 132:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single1);
                        break;
                    } else if (value == 2) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single2);
                        break;
                    } else if (value == 3) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single3);
                        break;
                    } else if (value == 4) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single4);
                        break;
                    } else if (value == 5) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_aodesai_single5);
                        break;
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_btn_null);
                        break;
                    }
                case 133:
                    if (value == 1) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery1);
                        break;
                    } else if (value == 2) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery2);
                        break;
                    } else if (value == 3) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery3);
                        break;
                    } else if (value == 4) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery4);
                        break;
                    } else if (value == 5) {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_aodesai_engery5);
                        break;
                    } else {
                        Act_WC_CarCD_AoDeSai.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_btn_null);
                        break;
                    }
                case 134:
                    if (((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) Act_WC_CarCD_AoDeSai.this.findViewById(R.id.tv_text5)).setText("Vol: " + value);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_09aodesai_carcd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }
}
