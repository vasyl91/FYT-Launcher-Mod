package com.syu.carinfo.hc.accord8;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0385_HC_XP1_PartComHonda;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Hc_385_CarCdAct extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 99:
                    Hc_385_CarCdAct.this.updateCurDiscNo();
                    break;
                case 100:
                    Hc_385_CarCdAct.this.updateCurTrack();
                    break;
                case 102:
                    Hc_385_CarCdAct.this.updatePlayMode();
                    break;
                case 103:
                    Hc_385_CarCdAct.this.updateWorkState();
                    break;
                case 105:
                    Hc_385_CarCdAct.this.updateFolderNo();
                    break;
                case 106:
                    Hc_385_CarCdAct.this.updaterCdTextType();
                    break;
                case 107:
                    Hc_385_CarCdAct.this.updaterCdTextInfo(strs);
                    break;
                case 109:
                    Hc_385_CarCdAct.this.updateCdUsbList1(strs);
                    break;
                case 112:
                    Hc_385_CarCdAct.this.updateDisc1Info();
                    break;
                case 113:
                    Hc_385_CarCdAct.this.updateDisc2Info();
                    break;
                case 114:
                    Hc_385_CarCdAct.this.updateDisc3Info();
                    break;
                case 115:
                    Hc_385_CarCdAct.this.updateDisc4Info();
                    break;
                case 116:
                    Hc_385_CarCdAct.this.updateDisc5Info();
                    break;
                case 117:
                    Hc_385_CarCdAct.this.updateDisc6Info();
                    break;
                case 118:
                    Hc_385_CarCdAct.this.updateMenuListType();
                    break;
                case 119:
                    Hc_385_CarCdAct.this.updateMenuList1Text(strs);
                    break;
                case 125:
                    Hc_385_CarCdAct.this.updaterShowPage();
                    break;
                case 126:
                    Hc_385_CarCdAct.this.updatePhone(strs);
                    break;
                case 127:
                    Hc_385_CarCdAct.this.updatePhoneEnable();
                    break;
                case 128:
                    Hc_385_CarCdAct.this.updateVol();
                    break;
                case 129:
                    Hc_385_CarCdAct.this.updateIcon();
                    break;
                case 130:
                case 131:
                    Hc_385_CarCdAct.this.updateCurPlayTime();
                    break;
                case 133:
                case 134:
                    Hc_385_CarCdAct.this.updateRadioCurBand();
                    Hc_385_CarCdAct.this.updateRadioFreq();
                    break;
                case 136:
                    Hc_385_CarCdAct.this.updateRadioSt();
                    break;
                case 137:
                    Hc_385_CarCdAct.this.updateRadioChannel();
                    break;
                case 138:
                    Hc_385_CarCdAct.this.updateRadioState();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_385_hc_accord8_cdinfo);
        setUI();
    }

    public void setUI() {
        for (int i = 112; i <= 117; i++) {
            DataCanbus.DATA[i] = -1;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateCurDiscNo() {
        int discno = DataCanbus.DATA[99] & 255;
        if (findViewById(R.id.tv_text26) != null) {
            if (discno == 255) {
                ((TextView) findViewById(R.id.tv_text26)).setText(R.string.str_385_carcdinfo7);
            } else {
                ((TextView) findViewById(R.id.tv_text26)).setText(String.valueOf(discno));
            }
        }
    }

    
    public void updateCurTrack() {
        int trackshiwei = (DataCanbus.DATA[100] >> 8) & 255;
        int trackgewei = DataCanbus.DATA[100] & 255;
        if (findViewById(R.id.tv_text28) != null) {
            ((TextView) findViewById(R.id.tv_text28)).setText(String.format("%d%d", Integer.valueOf(trackshiwei), Integer.valueOf(trackgewei)));
        }
    }

    
    public void updateCurPlayTime() {
        int playminute = DataCanbus.DATA[130] & 255;
        int playsecond = DataCanbus.DATA[131] & 255;
        if (playminute > 59) {
            playminute = 59;
        }
        if (playminute < 0) {
            playminute = 0;
        }
        if (playsecond > 59) {
            playsecond = 59;
        }
        if (playsecond < 0) {
            playsecond = 0;
        }
        if (findViewById(R.id.tv_text30) != null) {
            ((TextView) findViewById(R.id.tv_text30)).setText(playminute + ":" + playsecond);
        }
    }

    
    public void updatePlayMode() {
        String str;
        int playmode = DataCanbus.DATA[102] & 255;
        if (findViewById(R.id.tv_text32) != null) {
            switch (playmode) {
                case 1:
                    str = "Repeat one track";
                    break;
                case 2:
                    str = "Repeat all";
                    break;
                case 3:
                    str = "Random";
                    break;
                case 4:
                    str = "Scan";
                    break;
                case 5:
                    str = "D-Scan";
                    break;
                case 6:
                    str = "Repeat one fld";
                    break;
                case 7:
                    str = "random in fld";
                    break;
                case 8:
                    str = "scan fld";
                    break;
                default:
                    str = "Normal play";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text32)).setText(str);
        }
    }

    
    public void updateWorkState() {
        String string;
        int workstate = DataCanbus.DATA[103] & 255;
        if (findViewById(R.id.tv_text34) != null) {
            switch (workstate) {
                case 1:
                    string = "No disc";
                    break;
                case 2:
                    string = "Busy";
                    break;
                case 3:
                    string = "Load";
                    break;
                case 4:
                    string = "Read";
                    break;
                case 5:
                    string = "Eject";
                    break;
                case 6:
                    string = "Fast forward";
                    break;
                case 7:
                    string = "Fast backward";
                    break;
                case 8:
                    string = "Disc error";
                    break;
                case 9:
                    string = "NO DATA";
                    break;
                case 10:
                    string = "NO SONG";
                    break;
                case 11:
                    string = "USB LOAD";
                    break;
                case 12:
                    string = "UNSUPPORTED";
                    break;
                default:
                    string = "Playing";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text34)).setText(string);
        }
    }

    
    public void updateFolderNo() {
        int folder = DataCanbus.DATA[105] & 255;
        if (findViewById(R.id.tv_text36) != null) {
            ((TextView) findViewById(R.id.tv_text36)).setText(String.valueOf(folder));
        }
    }

    
    public void updaterCdTextType() {
        int cdTextType = Callback_0385_HC_XP1_PartComHonda.CdTextType;
        String strType = "";
        if (findViewById(R.id.tv_text37) != null) {
            switch (cdTextType) {
                case 0:
                    strType = "ALBUM NAME";
                    break;
                case 1:
                    strType = "TRACK NAME";
                    break;
                case 3:
                    strType = "ARTIST NAME";
                    break;
                case 4:
                    strType = "FOLDER NAME";
                    break;
                case 5:
                    strType = "FILE NAME";
                    break;
                case 6:
                    strType = "ALBUM";
                    break;
                case 7:
                    strType = "TRACK";
                    break;
                case 8:
                    strType = "ARTIST";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text37)).setText(strType);
        }
    }

    
    public void updaterCdTextInfo(String[] strs) {
        updaterCdTextType();
        String cdtextinfo = Callback_0385_HC_XP1_PartComHonda.CdTextInfo;
        if (cdtextinfo != null && findViewById(R.id.tv_text38) != null) {
            ((TextView) findViewById(R.id.tv_text38)).setText(cdtextinfo);
        }
    }

    
    public void updateCdUsbList1(String[] strs) {
        String cdusblist = Callback_0385_HC_XP1_PartComHonda.CdUsbList;
        if (cdusblist != null) {
            String str1 = "";
            String str2 = "";
            String str3 = "";
            int len = cdusblist.length();
            if (len >= 16) {
                str1 = cdusblist.substring(0, 16);
            }
            if (len >= 32) {
                str2 = cdusblist.substring(16, 32);
            }
            if (len >= 48) {
                str3 = cdusblist.substring(32, 48);
            }
            if (findViewById(R.id.tv_text39) != null) {
                ((TextView) findViewById(R.id.tv_text39)).setText(str1);
            }
            if (findViewById(R.id.tv_text40) != null) {
                ((TextView) findViewById(R.id.tv_text40)).setText(str2);
            }
            if (findViewById(R.id.tv_text41) != null) {
                ((TextView) findViewById(R.id.tv_text41)).setText(str3);
            }
        }
    }

    
    public void updateMenuListType() {
        int menulisttype = Callback_0385_HC_XP1_PartComHonda.MenuListType;
        String strMenuType = "";
        if (findViewById(R.id.tv_text11) != null) {
            switch (menulisttype) {
                case 32:
                    strMenuType = getResources().getString(R.string.str_385_carcdmenutype1);
                    break;
                case 48:
                    strMenuType = getResources().getString(R.string.str_385_carcdmenutype2);
                    break;
                case 64:
                    strMenuType = getResources().getString(R.string.str_385_carcdmenutype3);
                    break;
                case 80:
                    strMenuType = getResources().getString(R.string.str_385_carcdmenutype4);
                    break;
            }
            ((TextView) findViewById(R.id.tv_text11)).setText(strMenuType);
        }
    }

    
    public void updateMenuList1Text(String[] strs) {
        updateMenuListType();
        String menulist = Callback_0385_HC_XP1_PartComHonda.MenuList;
        if (menulist != null) {
            String str1 = "";
            String str2 = "";
            String str3 = "";
            int len = menulist.length();
            if (len >= 16) {
                str1 = menulist.substring(0, 16);
            }
            if (len >= 32) {
                str2 = menulist.substring(16, 32);
            }
            if (len >= 48) {
                str3 = menulist.substring(32, 48);
            }
            if (findViewById(R.id.tv_text12) != null) {
                ((TextView) findViewById(R.id.tv_text12)).setText(str1);
            }
            if (findViewById(R.id.tv_text13) != null) {
                ((TextView) findViewById(R.id.tv_text13)).setText(str2);
            }
            if (findViewById(R.id.tv_text14) != null) {
                ((TextView) findViewById(R.id.tv_text14)).setText(str3);
            }
        }
    }

    
    public void updateDisc1Info() {
        int disc1info = DataCanbus.DATA[112] & 255;
        if (findViewById(R.id.tv_text42) != null) {
            switch (disc1info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text42)).setText("Disc1 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text42)).setText("Disc1 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text42)).setText("Disc1 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text42)).setText("Disc1 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text42)).setText("Disc1 Loading");
                    break;
            }
        }
    }

    
    public void updateDisc2Info() {
        int disc2info = DataCanbus.DATA[113] & 255;
        if (findViewById(R.id.tv_text43) != null) {
            switch (disc2info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text43)).setText("Disc2 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text43)).setText("Disc2 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text43)).setText("Disc2 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text43)).setText("Disc2 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text43)).setText("Disc2 Loading");
                    break;
            }
        }
    }

    
    public void updateDisc3Info() {
        int disc3info = DataCanbus.DATA[114] & 255;
        if (findViewById(R.id.tv_text44) != null) {
            switch (disc3info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text44)).setText("Disc3 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text44)).setText("Disc3 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text44)).setText("Disc3 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text44)).setText("Disc3 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text44)).setText("Disc3 Loading");
                    break;
            }
        }
    }

    
    public void updateDisc4Info() {
        int disc4info = DataCanbus.DATA[115] & 255;
        if (findViewById(R.id.tv_text45) != null) {
            switch (disc4info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text45)).setText("Disc4 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text45)).setText("Disc4 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text45)).setText("Disc4 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text45)).setText("Disc4 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text45)).setText("Disc4 Loading");
                    break;
            }
        }
    }

    
    public void updateDisc5Info() {
        int disc5info = DataCanbus.DATA[116] & 255;
        if (findViewById(R.id.tv_text46) != null) {
            switch (disc5info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text46)).setText("Disc5 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text46)).setText("Disc5 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text46)).setText("Disc5 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text46)).setText("Disc5 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text46)).setText("Disc5 Loading");
                    break;
            }
        }
    }

    
    public void updateDisc6Info() {
        int disc6info = DataCanbus.DATA[117] & 255;
        if (findViewById(R.id.tv_text47) != null) {
            switch (disc6info) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text47)).setText("Disc6 No disc");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text47)).setText("Disc6 Outside");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text47)).setText("Disc6 Inside");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text47)).setText("Disc6 Playing");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text47)).setText("Disc6 Loading");
                    break;
            }
        }
    }

    
    public void updaterShowPage() {
        int menuEnable = (DataCanbus.DATA[125] >> 6) & 1;
        int iPageIndex = DataCanbus.DATA[125] & 15;
        if (menuEnable == 1) {
            iPageIndex = 5;
        }
        if (iPageIndex <= 6) {
            if (iPageIndex == 0) {
                if (findViewById(R.id.layout_view3).getVisibility() == 8 || findViewById(R.id.layout_view3).getVisibility() == 4) {
                    findViewById(R.id.layout_view3).setVisibility(0);
                }
                if (findViewById(R.id.layout_view4).getVisibility() == 0) {
                    findViewById(R.id.layout_view4).setVisibility(4);
                }
                if (findViewById(R.id.layout_view2).getVisibility() == 0) {
                    findViewById(R.id.layout_view2).setVisibility(4);
                }
                if (findViewById(R.id.layout_view1).getVisibility() == 0) {
                    findViewById(R.id.layout_view1).setVisibility(4);
                }
                if (findViewById(R.id.tv_text1) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("Radio");
                    return;
                }
                return;
            }
            if (iPageIndex == 1 || iPageIndex == 3) {
                if (findViewById(R.id.layout_view4).getVisibility() == 8 || findViewById(R.id.layout_view4).getVisibility() == 4) {
                    findViewById(R.id.layout_view4).setVisibility(0);
                }
                if (findViewById(R.id.layout_view3).getVisibility() == 0) {
                    findViewById(R.id.layout_view3).setVisibility(4);
                }
                if (findViewById(R.id.layout_view2).getVisibility() == 0) {
                    findViewById(R.id.layout_view2).setVisibility(4);
                }
                if (findViewById(R.id.layout_view1).getVisibility() == 0) {
                    findViewById(R.id.layout_view1).setVisibility(4);
                }
                if (iPageIndex == 1 && findViewById(R.id.tv_text1) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("CD");
                }
                if (iPageIndex == 3 && findViewById(R.id.tv_text1) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("USB");
                    return;
                }
                return;
            }
            if (iPageIndex == 4) {
                if (findViewById(R.id.layout_view1).getVisibility() == 8 || findViewById(R.id.layout_view1).getVisibility() == 4) {
                    findViewById(R.id.layout_view1).setVisibility(0);
                }
                if (findViewById(R.id.layout_view3).getVisibility() == 0) {
                    findViewById(R.id.layout_view3).setVisibility(8);
                }
                if (findViewById(R.id.layout_view4).getVisibility() == 0) {
                    findViewById(R.id.layout_view4).setVisibility(8);
                }
                if (findViewById(R.id.layout_view2).getVisibility() == 0) {
                    findViewById(R.id.layout_view2).setVisibility(4);
                }
                if (findViewById(R.id.tv_text1) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("TEL");
                    return;
                }
                return;
            }
            if (iPageIndex == 5) {
                if (findViewById(R.id.layout_view2).getVisibility() == 8 || findViewById(R.id.layout_view2).getVisibility() == 4) {
                    findViewById(R.id.layout_view2).setVisibility(0);
                }
                if (findViewById(R.id.layout_view3).getVisibility() == 0) {
                    findViewById(R.id.layout_view3).setVisibility(8);
                }
                if (findViewById(R.id.layout_view4).getVisibility() == 0) {
                    findViewById(R.id.layout_view4).setVisibility(8);
                }
                if (findViewById(R.id.layout_view1).getVisibility() == 0) {
                    findViewById(R.id.layout_view1).setVisibility(4);
                }
                if (findViewById(R.id.tv_text1) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("MENU");
                }
            }
        }
    }

    
    public void updateVol() {
        int volEnable = (DataCanbus.DATA[128] >> 7) & 1;
        int volValue = DataCanbus.DATA[128] & 127;
        if (findViewById(R.id.tv_text8) != null) {
            if (volEnable == 1) {
                findViewById(R.id.tv_text8).setVisibility(0);
            } else {
                findViewById(R.id.tv_text8).setVisibility(8);
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(volValue));
        }
    }

    
    public void updateRadioCurBand() {
        int iRadioBand = DataCanbus.DATA[134] & 255;
        String strBand = "";
        if (findViewById(R.id.tv_text16) != null) {
            switch (iRadioBand) {
                case 0:
                    strBand = "FM";
                    break;
                case 1:
                    strBand = "FM1";
                    break;
                case 2:
                    strBand = "FM2";
                    break;
                case 3:
                    strBand = "AM";
                    break;
                case 4:
                    strBand = "LW";
                    break;
                case 5:
                    strBand = "MW";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text16)).setText(strBand);
        }
    }

    
    public void updateRadioFreq() {
        int iRadioFreq = DataCanbus.DATA[133];
        int iRadioBand = DataCanbus.DATA[134] & 255;
        if (findViewById(R.id.tv_text18) != null) {
            if (iRadioBand >= 0 && iRadioBand <= 2) {
                int tempfreq = ((iRadioFreq - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.tv_text18)).setText(String.format("%d.%d", Integer.valueOf(tempfreq / 100), Integer.valueOf(tempfreq % 100)));
            } else if (iRadioBand == 3) {
                int tempfreq2 = ((iRadioFreq - 1) * 9) + 531;
                ((TextView) findViewById(R.id.tv_text18)).setText(String.valueOf(tempfreq2));
            } else if (iRadioBand == 4 || iRadioBand == 5) {
                int tempfreq3 = ((iRadioFreq - 1) * 3) + 153;
                ((TextView) findViewById(R.id.tv_text18)).setText(String.valueOf(tempfreq3));
            }
        }
    }

    
    public void updateRadioChannel() {
        int iRadioChannel = DataCanbus.DATA[137];
        if (findViewById(R.id.tv_text20) != null) {
            if (iRadioChannel > 0 && iRadioChannel <= 6) {
                ((TextView) findViewById(R.id.tv_text20)).setText(String.valueOf(iRadioChannel));
            } else {
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.str_385_carradioinfo6);
            }
        }
    }

    
    public void updateRadioSt() {
        int radiost = DataCanbus.DATA[136] & 255;
        String strSt = "";
        if (findViewById(R.id.tv_text22) != null) {
            switch (radiost) {
                case 0:
                    strSt = "ST OFF";
                    break;
                case 1:
                    strSt = "ST ON";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text22)).setText(strSt);
        }
    }

    
    public void updateRadioState() {
        int radiostate = DataCanbus.DATA[138] & 255;
        String strState = "";
        if (findViewById(R.id.tv_text24) != null) {
            switch (radiostate) {
                case 1:
                    strState = "Normal";
                    break;
                case 2:
                    strState = "TUNE+";
                    break;
                case 3:
                    strState = "TUNE-";
                    break;
                case 4:
                    strState = "SEEK+";
                    break;
                case 5:
                    strState = "SEEK-";
                    break;
                case 6:
                    strState = "SCAN";
                    break;
                case 7:
                    strState = "A.SEL";
                    break;
            }
            ((TextView) findViewById(R.id.tv_text24)).setText(strState);
        }
    }

    
    public void updatePhone(String[] strs) {
        updatePhoneEnable();
        String telTextInfo = Callback_0385_HC_XP1_PartComHonda.TelTextInfo;
        if (telTextInfo != null && findViewById(R.id.tv_text10) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(telTextInfo);
        }
    }

    
    public void updatePhoneEnable() {
        int telEnable = Callback_0385_HC_XP1_PartComHonda.TelTextType;
        if (findViewById(R.id.layout_view1) != null) {
            if (telEnable == 1) {
                if (findViewById(R.id.layout_view1).getVisibility() == 8 || findViewById(R.id.layout_view1).getVisibility() == 4) {
                    findViewById(R.id.layout_view1).setVisibility(0);
                    return;
                }
                return;
            }
            if (findViewById(R.id.layout_view1).getVisibility() == 0) {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
        }
    }

    
    public void updateIcon() {
        int usbDis = DataCanbus.DATA[129] & 1;
        int wmaDis = (DataCanbus.DATA[129] >> 1) & 1;
        int mp3Dis = (DataCanbus.DATA[129] >> 2) & 1;
        int telDis = (DataCanbus.DATA[129] >> 3) & 1;
        int taDis = (DataCanbus.DATA[129] >> 4) & 1;
        if (findViewById(R.id.tv_text2) != null) {
            if (usbDis == 1) {
                findViewById(R.id.tv_text2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text2)).setText("USB");
            } else {
                findViewById(R.id.tv_text2).setVisibility(8);
            }
        }
        if (findViewById(R.id.tv_text3) != null) {
            if (wmaDis == 1) {
                findViewById(R.id.tv_text3).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text3)).setText("WMA");
            } else {
                findViewById(R.id.tv_text3).setVisibility(8);
            }
        }
        if (findViewById(R.id.tv_text4) != null) {
            if (mp3Dis == 1) {
                findViewById(R.id.tv_text4).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text4)).setText("MP3");
            } else {
                findViewById(R.id.tv_text4).setVisibility(8);
            }
        }
        if (findViewById(R.id.tv_text5) != null) {
            if (telDis == 1) {
                findViewById(R.id.tv_text5).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text5)).setText("TEL");
            } else {
                findViewById(R.id.tv_text5).setVisibility(8);
            }
        }
        if (findViewById(R.id.tv_text6) != null) {
            if (taDis == 1) {
                findViewById(R.id.tv_text6).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text6)).setText("TA");
            } else {
                findViewById(R.id.tv_text6).setVisibility(8);
            }
        }
    }

    @Override
    public boolean onLongClick(View arg0) {
        return false;
    }

    @Override
    public void onClick(View arg0) {
    }
}
