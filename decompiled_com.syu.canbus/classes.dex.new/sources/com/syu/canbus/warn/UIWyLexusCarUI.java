package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.Callback_0443_WY_BBA_All;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWyLexusCarUI {
    private static UIWyLexusCarUI mInstance;
    Context context;
    private View sWarnContent;
    int num = 0;
    Runnable mShowTurnLeftLight = new Runnable() { // from class: com.syu.canbus.warn.UIWyLexusCarUI.1
        @Override // java.lang.Runnable
        public void run() {
            UIWyLexusCarUI.this.num++;
            if (UIWyLexusCarUI.this.num > 1) {
                UIWyLexusCarUI.this.num = 0;
            }
            ((TextView) UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.tv_text12)).setText(UIWyLexusCarUI.this.num == 1 ? Callback_0443_WY_BBA_All.D0FCarUIStr1 : "");
            HandlerUI.getInstance().removeCallbacks(UIWyLexusCarUI.this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(UIWyLexusCarUI.this.mShowTurnLeftLight, 800L);
        }
    };
    int numdisc = 0;
    Runnable mShowDisctime = new Runnable() { // from class: com.syu.canbus.warn.UIWyLexusCarUI.2
        @Override // java.lang.Runnable
        public void run() {
            int i = R.drawable.ic_sbd_kelu;
            UIWyLexusCarUI.this.numdisc++;
            if (UIWyLexusCarUI.this.numdisc > 1) {
                UIWyLexusCarUI.this.numdisc = 0;
            }
            if (DataCanbus.DATA[124] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view9).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? R.drawable.ic_sbd_discin_kelu : R.drawable.ic_sbd_discin_gray);
            } else if (DataCanbus.DATA[124] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_sbd_discin_gray);
            } else if (DataCanbus.DATA[124] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_sbd_discin_kelu);
            }
            if (DataCanbus.DATA[125] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? 2130842404 : 2130842403);
            } else if (DataCanbus.DATA[125] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[125] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            if (DataCanbus.DATA[126] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? 2130842404 : 2130842403);
            } else if (DataCanbus.DATA[126] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[126] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            if (DataCanbus.DATA[127] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? 2130842404 : 2130842403);
            } else if (DataCanbus.DATA[127] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[127] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            if (DataCanbus.DATA[128] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? 2130842404 : 2130842403);
            } else if (DataCanbus.DATA[128] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[128] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            if (DataCanbus.DATA[129] == 1) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(UIWyLexusCarUI.this.numdisc == 1 ? 2130842404 : 2130842403);
            } else if (DataCanbus.DATA[129] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[129] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            if (DataCanbus.DATA[130] == 1) {
                View viewFindViewById = UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view6);
                if (UIWyLexusCarUI.this.numdisc != 1) {
                    i = 2130842403;
                }
                viewFindViewById.setBackgroundResource(i);
            } else if (DataCanbus.DATA[130] == 0) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_sbd_gray);
            } else if (DataCanbus.DATA[130] == 3) {
                UIWyLexusCarUI.this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_sbd_kelu);
            }
            HandlerUI.getInstance().removeCallbacks(UIWyLexusCarUI.this.mShowDisctime);
            HandlerUI.getInstance().postDelayed(UIWyLexusCarUI.this.mShowDisctime, 800L);
        }
    };

    public static UIWyLexusCarUI getInstance() {
        if (mInstance == null) {
            mInstance = new UIWyLexusCarUI();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && DataCanbus.DATA[163] == 1 && DataCanbus.DATA[165] == 0) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(10000);
        }
    }

    private void updadateAllInfo() {
        String strusb;
        String strusb2;
        String strusb3;
        String strusb4;
        String strbtav;
        String strbtav2;
        String strbtav3;
        String strcd;
        String strcd2;
        String strcd3;
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(8);
        ((TextView) this.sWarnContent.findViewById(R.id.tv_text14)).setVisibility(8);
        if (DataCanbus.DATA[137] > 63) {
            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Vol: MAX");
        } else {
            ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Vol: " + DataCanbus.DATA[137]);
        }
        mUpdaterTurnleftLight(0);
        switch (DataCanbus.DATA[121]) {
            case 0:
                switch (DataCanbus.DATA[120]) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("POWER OFF");
                        break;
                    case 1:
                        String str = "";
                        if (DataCanbus.DATA[149] != 0) {
                            str = "CH" + DataCanbus.DATA[149] + "  ";
                        }
                        if (DataCanbus.DATA[122] == 1) {
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("FM1");
                            str = String.valueOf(str) + (DataCanbus.DATA[150] / 100) + "." + (DataCanbus.DATA[150] % 100) + " MHz";
                        } else if (DataCanbus.DATA[122] == 2) {
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("FM2");
                            str = String.valueOf(str) + (DataCanbus.DATA[150] / 100) + "." + (DataCanbus.DATA[150] % 100) + " MHz";
                        } else if (DataCanbus.DATA[122] == 16) {
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("AM");
                            str = String.valueOf(str) + DataCanbus.DATA[150] + " KHz";
                        }
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText(str);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text14)).setVisibility(0);
                        if (DataCanbus.DATA[151] == 1) {
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text14)).setText("ST");
                        } else {
                            ((TextView) this.sWarnContent.findViewById(R.id.tv_text14)).setText("");
                        }
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("CD");
                        String strcd4 = "DISC" + DataCanbus.DATA[152] + "  ";
                        if (DataCanbus.DATA[153] > 240) {
                            strcd = String.valueOf(strcd4) + "TRK -  ";
                        } else {
                            strcd = String.valueOf(strcd4) + "TRK " + DataCanbus.DATA[153] + "  ";
                        }
                        int min = DataCanbus.DATA[154];
                        int sec = DataCanbus.DATA[155];
                        if (min > 240) {
                            strcd2 = String.valueOf(strcd) + "--";
                        } else {
                            strcd2 = String.valueOf(strcd) + min;
                        }
                        if (sec > 59) {
                            strcd3 = String.valueOf(strcd2) + "--";
                        } else {
                            strcd3 = String.valueOf(strcd2) + ":" + (sec / 10) + (sec % 10);
                        }
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText(strcd3);
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("AUX");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("AUX");
                        break;
                    case 4:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("BTAV");
                        if (DataCanbus.DATA[156] > 240) {
                            strbtav = String.valueOf("BTAV  ") + "TRK -  ";
                        } else {
                            strbtav = String.valueOf("BTAV  ") + "TRK " + DataCanbus.DATA[156] + "  ";
                        }
                        int min2 = DataCanbus.DATA[157];
                        int sec2 = DataCanbus.DATA[158];
                        if (min2 > 240) {
                            strbtav2 = String.valueOf(strbtav) + "--";
                        } else {
                            strbtav2 = String.valueOf(strbtav) + min2;
                        }
                        if (sec2 > 59) {
                            strbtav3 = String.valueOf(strbtav2) + "--";
                        } else {
                            strbtav3 = String.valueOf(strbtav2) + ":" + (sec2 / 10) + (sec2 % 10);
                        }
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText(strbtav3);
                        break;
                    case 5:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("USB");
                        if (DataCanbus.DATA[159] > 240) {
                            strusb = String.valueOf("") + "File-  ";
                        } else {
                            strusb = "File" + DataCanbus.DATA[159] + "  ";
                        }
                        if (DataCanbus.DATA[160] > 240) {
                            strusb2 = String.valueOf(strusb) + "TRK -  ";
                        } else {
                            strusb2 = String.valueOf(strusb) + "TRK " + DataCanbus.DATA[160] + "  ";
                        }
                        int min3 = DataCanbus.DATA[161];
                        int sec3 = DataCanbus.DATA[162];
                        if (min3 > 240) {
                            strusb3 = String.valueOf(strusb2) + "--";
                        } else {
                            strusb3 = String.valueOf(strusb2) + min3;
                        }
                        if (sec3 > 59) {
                            strusb4 = String.valueOf(strusb3) + "--";
                        } else {
                            strusb4 = String.valueOf(strusb3) + ":" + (sec3 / 10) + (sec3 % 10);
                        }
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText(strusb4);
                        break;
                    case 6:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("BT");
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("PHONE");
                        break;
                }
                break;
            case 1:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                if (DataCanbus.DATA[137] > 63) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("Vol: MAX");
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("Vol: " + DataCanbus.DATA[137]);
                }
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("MENU");
                break;
            case 2:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText("MUTE");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text2)).setText("Vol: 0");
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("MENU");
                break;
            case 3:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setVisibility(0);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setTextColor(-1);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setTextColor(-1);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setTextColor(-1);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setTextColor(-1);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setTextColor(-1);
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setTextColor(-1);
                switch (DataCanbus.DATA[139]) {
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setTextColor(-256);
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setTextColor(-256);
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setTextColor(-256);
                        break;
                    case 4:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setTextColor(-256);
                        break;
                    case 5:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setTextColor(-256);
                        break;
                    case 6:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setTextColor(-256);
                        break;
                }
                int bass = DataCanbus.DATA[140];
                int mid = DataCanbus.DATA[141];
                int treb = DataCanbus.DATA[142];
                int fad = DataCanbus.DATA[143];
                int bal = DataCanbus.DATA[144];
                int asl = DataCanbus.DATA[145];
                if (bass > 16) {
                    int bass2 = bass - 16;
                    if (bass2 > 5) {
                        bass2 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText("BAS                 +" + bass2);
                } else if (bass < 16) {
                    int bass3 = 16 - bass;
                    if (bass3 > 5) {
                        bass3 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText("BAS                 -" + bass3);
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text6)).setText("BAS                 0");
                }
                if (mid > 16) {
                    int mid2 = mid - 16;
                    if (mid2 > 5) {
                        mid2 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setText("MID                 +" + mid2);
                } else if (mid < 16) {
                    int mid3 = 16 - mid;
                    if (mid3 > 5) {
                        mid3 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setText("MID                 -" + mid3);
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text7)).setText("MID                 0");
                }
                if (treb > 16) {
                    int treb2 = treb - 16;
                    if (treb2 > 5) {
                        treb2 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setText("TRE                 +" + treb2);
                } else if (treb < 16) {
                    int treb3 = 16 - treb;
                    if (treb3 > 5) {
                        treb3 = 5;
                    }
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setText("TRE                 -" + treb3);
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text8)).setText("TRE                 0");
                }
                if (fad > 16) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setText("FAD                 R" + (fad - 16));
                } else if (fad < 16) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setText("FAD                 F" + (16 - fad));
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text9)).setText("FAD                 0");
                }
                if (bal > 16) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setText("BAL                 L" + (bal - 16));
                } else if (bal < 16) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setText("BAL                 R" + (16 - bal));
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text10)).setText("BAL                 0");
                }
                if (asl == 1) {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setText("ASL                 ON");
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text11)).setText("ASL                 OFF");
                }
                break;
            case 15:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setVisibility(0);
                if (DataCanbus.DATA[147] == 1) {
                    mUpdaterTurnleftLight(1);
                } else {
                    ((TextView) this.sWarnContent.findViewById(R.id.tv_text12)).setText(Callback_0443_WY_BBA_All.D0FCarUIStr1);
                }
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("MENU");
                break;
        }
    }

    private void mUpdaterTurnleftLight(int value) {
        if (value == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
            HandlerUI.getInstance().postDelayed(this.mShowTurnLeftLight, 800L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowTurnLeftLight);
        }
    }

    private void mUpdaterDisctime() {
        if (DataCanbus.DATA[124] == 1 || DataCanbus.DATA[125] == 1 || DataCanbus.DATA[126] == 1 || DataCanbus.DATA[127] == 1 || DataCanbus.DATA[128] == 1 || DataCanbus.DATA[129] == 1 || DataCanbus.DATA[130] == 1) {
            HandlerUI.getInstance().removeCallbacks(this.mShowDisctime);
            HandlerUI.getInstance().postDelayed(this.mShowDisctime, 800L);
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mShowDisctime);
        if (DataCanbus.DATA[124] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_sbd_discin_gray);
        } else if (DataCanbus.DATA[124] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view9).setBackgroundResource(R.drawable.ic_sbd_discin_kelu);
        }
        if (DataCanbus.DATA[125] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[125] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
        if (DataCanbus.DATA[126] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[126] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
        if (DataCanbus.DATA[127] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[127] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
        if (DataCanbus.DATA[128] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[128] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
        if (DataCanbus.DATA[129] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[129] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
        if (DataCanbus.DATA[130] == 0) {
            this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_sbd_gray);
        } else if (DataCanbus.DATA[130] == 3) {
            this.sWarnContent.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_sbd_kelu);
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0443_wy_lexus_carui, (ViewGroup) null, false);
        }
        switch (updateCode) {
            case 123:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text13)).setText("");
                        break;
                    case 128:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text13)).setText("ASL");
                        break;
                }
                break;
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
                mUpdaterDisctime();
                break;
            case 131:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_pa_ford_car_bt_p);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view7).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                }
                break;
            case 132:
                if (value == 1) {
                    this.sWarnContent.findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_sbd_phone_p);
                } else {
                    this.sWarnContent.findViewById(R.id.layout_view10).setBackgroundResource(R.drawable.ic_sbd_phone);
                }
                break;
            case 133:
                switch (value) {
                    case 0:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                        break;
                    case 1:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_camry_sens_level_0);
                        break;
                    case 2:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_camry_sens_level_1);
                        break;
                    case 3:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_camry_sens_level_2);
                        break;
                    case 4:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_camry_sens_level_3);
                        break;
                    case 5:
                        this.sWarnContent.findViewById(R.id.layout_view8).setBackgroundResource(R.drawable.ic_camry_sens_level_4);
                        break;
                }
                break;
            case 134:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("A SCAN");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("SCAN");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text3)).setText("----");
                        break;
                }
                break;
            case 135:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("S RPT");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("RPT");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text4)).setText("----");
                        break;
                }
                break;
            case 136:
                switch (value) {
                    case 0:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("");
                        break;
                    case 1:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("A RAND");
                        break;
                    case 2:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("RAND");
                        break;
                    case 3:
                        ((TextView) this.sWarnContent.findViewById(R.id.tv_text5)).setText("----");
                        break;
                }
                break;
            default:
                updadateAllInfo();
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
