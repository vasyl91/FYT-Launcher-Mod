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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Hc_385_CarCdAct extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.accord8.Hc_385_CarCdAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 21:
                    Hc_385_CarCdAct.this.updateCurDiscNo();
                    break;
                case 22:
                    Hc_385_CarCdAct.this.updateCurTrack();
                    break;
                case 24:
                    Hc_385_CarCdAct.this.updatePlayMode();
                    break;
                case 25:
                    Hc_385_CarCdAct.this.updateWorkState();
                    break;
                case 27:
                    Hc_385_CarCdAct.this.updateFolderNo();
                    break;
                case 28:
                    Hc_385_CarCdAct.this.updaterCdTextType();
                    break;
                case 29:
                    Hc_385_CarCdAct.this.updaterCdTextInfo(strs);
                    break;
                case 31:
                    Hc_385_CarCdAct.this.updateCdUsbList1(strs);
                    break;
                case 34:
                    Hc_385_CarCdAct.this.updateDisc1Info();
                    break;
                case 35:
                    Hc_385_CarCdAct.this.updateDisc2Info();
                    break;
                case 36:
                    Hc_385_CarCdAct.this.updateDisc3Info();
                    break;
                case 37:
                    Hc_385_CarCdAct.this.updateDisc4Info();
                    break;
                case 38:
                    Hc_385_CarCdAct.this.updateDisc5Info();
                    break;
                case 39:
                    Hc_385_CarCdAct.this.updateDisc6Info();
                    break;
                case 40:
                    Hc_385_CarCdAct.this.updateMenuListType();
                    break;
                case 41:
                    Hc_385_CarCdAct.this.updateMenuList1Text(strs);
                    break;
                case 47:
                    Hc_385_CarCdAct.this.updaterShowPage();
                    break;
                case 48:
                    Hc_385_CarCdAct.this.updatePhone(strs);
                    break;
                case 49:
                    Hc_385_CarCdAct.this.updatePhoneEnable();
                    break;
                case 50:
                    Hc_385_CarCdAct.this.updateVol();
                    break;
                case 51:
                    Hc_385_CarCdAct.this.updateIcon();
                    break;
                case 52:
                case 53:
                    Hc_385_CarCdAct.this.updateCurPlayTime();
                    break;
                case 60:
                case 61:
                    Hc_385_CarCdAct.this.updateRadioCurBand();
                    Hc_385_CarCdAct.this.updateRadioFreq();
                    break;
                case 70:
                    Hc_385_CarCdAct.this.updateRadioSt();
                    break;
                case 71:
                    Hc_385_CarCdAct.this.updateRadioChannel();
                    break;
                case 72:
                    Hc_385_CarCdAct.this.updateRadioState();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_385_hc_accord8_cdinfo);
        setUI();
    }

    public void setUI() {
        for (int i = 34; i <= 39; i++) {
            DataCanbus.DATA[i] = -1;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurDiscNo() {
        int discno = DataCanbus.DATA[21] & 255;
        if (((TextView) findViewById(R.id.tv_text26)) != null) {
            if (discno == 255) {
                ((TextView) findViewById(R.id.tv_text26)).setText(R.string.str_385_carcdinfo7);
            } else {
                ((TextView) findViewById(R.id.tv_text26)).setText(String.valueOf(discno));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurTrack() {
        int trackshiwei = (DataCanbus.DATA[22] >> 8) & 255;
        int trackgewei = DataCanbus.DATA[22] & 255;
        if (((TextView) findViewById(R.id.tv_text28)) != null) {
            ((TextView) findViewById(R.id.tv_text28)).setText(String.format("%d%d", Integer.valueOf(trackshiwei), Integer.valueOf(trackgewei)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurPlayTime() {
        int playminute = DataCanbus.DATA[52] & 255;
        int playsecond = DataCanbus.DATA[53] & 255;
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
        if (((TextView) findViewById(R.id.tv_text30)) != null) {
            ((TextView) findViewById(R.id.tv_text30)).setText(String.valueOf(playminute) + ":" + playsecond);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayMode() {
        String str;
        int playmode = DataCanbus.DATA[24] & 255;
        if (((TextView) findViewById(R.id.tv_text32)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWorkState() {
        String string;
        int workstate = DataCanbus.DATA[25] & 255;
        if (((TextView) findViewById(R.id.tv_text34)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFolderNo() {
        int folder = DataCanbus.DATA[27] & 255;
        if (((TextView) findViewById(R.id.tv_text36)) != null) {
            ((TextView) findViewById(R.id.tv_text36)).setText(String.valueOf(folder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextType() {
        int cdTextType = Callback_0385_HC_XP1_PartComHonda.CdTextType;
        String strType = "";
        if (((TextView) findViewById(R.id.tv_text37)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCdTextInfo(String[] strs) {
        updaterCdTextType();
        String cdtextinfo = Callback_0385_HC_XP1_PartComHonda.CdTextInfo;
        if (cdtextinfo != null && ((TextView) findViewById(R.id.tv_text38)) != null) {
            ((TextView) findViewById(R.id.tv_text38)).setText(cdtextinfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            if (((TextView) findViewById(R.id.tv_text39)) != null) {
                ((TextView) findViewById(R.id.tv_text39)).setText(str1);
            }
            if (((TextView) findViewById(R.id.tv_text40)) != null) {
                ((TextView) findViewById(R.id.tv_text40)).setText(str2);
            }
            if (((TextView) findViewById(R.id.tv_text41)) != null) {
                ((TextView) findViewById(R.id.tv_text41)).setText(str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMenuListType() {
        int menulisttype = Callback_0385_HC_XP1_PartComHonda.MenuListType;
        String strMenuType = "";
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
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
            if (((TextView) findViewById(R.id.tv_text12)) != null) {
                ((TextView) findViewById(R.id.tv_text12)).setText(str1);
            }
            if (((TextView) findViewById(R.id.tv_text13)) != null) {
                ((TextView) findViewById(R.id.tv_text13)).setText(str2);
            }
            if (((TextView) findViewById(R.id.tv_text14)) != null) {
                ((TextView) findViewById(R.id.tv_text14)).setText(str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc1Info() {
        int disc1info = DataCanbus.DATA[34] & 255;
        if (((TextView) findViewById(R.id.tv_text42)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc2Info() {
        int disc2info = DataCanbus.DATA[35] & 255;
        if (((TextView) findViewById(R.id.tv_text43)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc3Info() {
        int disc3info = DataCanbus.DATA[36] & 255;
        if (((TextView) findViewById(R.id.tv_text44)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc4Info() {
        int disc4info = DataCanbus.DATA[37] & 255;
        if (((TextView) findViewById(R.id.tv_text45)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc5Info() {
        int disc5info = DataCanbus.DATA[38] & 255;
        if (((TextView) findViewById(R.id.tv_text46)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisc6Info() {
        int disc6info = DataCanbus.DATA[39] & 255;
        if (((TextView) findViewById(R.id.tv_text47)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterShowPage() {
        int menuEnable = (DataCanbus.DATA[47] >> 6) & 1;
        int iPageIndex = DataCanbus.DATA[47] & 15;
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
                if (((TextView) findViewById(R.id.tv_text1)) != null) {
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
                if (iPageIndex == 1 && ((TextView) findViewById(R.id.tv_text1)) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("CD");
                }
                if (iPageIndex == 3 && ((TextView) findViewById(R.id.tv_text1)) != null) {
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
                if (((TextView) findViewById(R.id.tv_text1)) != null) {
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
                if (((TextView) findViewById(R.id.tv_text1)) != null) {
                    ((TextView) findViewById(R.id.tv_text1)).setText("MENU");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVol() {
        int volEnable = (DataCanbus.DATA[50] >> 7) & 1;
        int volValue = DataCanbus.DATA[50] & 127;
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            if (volEnable == 1) {
                ((TextView) findViewById(R.id.tv_text8)).setVisibility(0);
            } else {
                ((TextView) findViewById(R.id.tv_text8)).setVisibility(8);
            }
            ((TextView) findViewById(R.id.tv_text8)).setText(String.valueOf(volValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioCurBand() {
        int iRadioBand = DataCanbus.DATA[61] & 255;
        String strBand = "";
        if (((TextView) findViewById(R.id.tv_text16)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioFreq() {
        int iRadioFreq = DataCanbus.DATA[60];
        int iRadioBand = DataCanbus.DATA[61] & 255;
        if (((TextView) findViewById(R.id.tv_text18)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioChannel() {
        int iRadioChannel = DataCanbus.DATA[71];
        if (((TextView) findViewById(R.id.tv_text20)) != null) {
            if (iRadioChannel > 0 && iRadioChannel <= 6) {
                ((TextView) findViewById(R.id.tv_text20)).setText(String.valueOf(iRadioChannel));
            } else {
                ((TextView) findViewById(R.id.tv_text20)).setText(R.string.str_385_carradioinfo6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioSt() {
        int radiost = DataCanbus.DATA[70] & 255;
        String strSt = "";
        if (((TextView) findViewById(R.id.tv_text22)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioState() {
        int radiostate = DataCanbus.DATA[72] & 255;
        String strState = "";
        if (((TextView) findViewById(R.id.tv_text24)) != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePhone(String[] strs) {
        updatePhoneEnable();
        String telTextInfo = Callback_0385_HC_XP1_PartComHonda.TelTextInfo;
        if (telTextInfo != null && ((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(telTextInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIcon() {
        int usbDis = DataCanbus.DATA[51] & 1;
        int wmaDis = (DataCanbus.DATA[51] >> 1) & 1;
        int mp3Dis = (DataCanbus.DATA[51] >> 2) & 1;
        int telDis = (DataCanbus.DATA[51] >> 3) & 1;
        int taDis = (DataCanbus.DATA[51] >> 4) & 1;
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (usbDis == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text2)).setText("USB");
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setVisibility(8);
            }
        }
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (wmaDis == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text3)).setText("WMA");
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setVisibility(8);
            }
        }
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (mp3Dis == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text4)).setText("MP3");
            } else {
                ((TextView) findViewById(R.id.tv_text4)).setVisibility(8);
            }
        }
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (telDis == 1) {
                ((TextView) findViewById(R.id.tv_text5)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text5)).setText("TEL");
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setVisibility(8);
            }
        }
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (taDis == 1) {
                ((TextView) findViewById(R.id.tv_text6)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text6)).setText("TA");
            } else {
                ((TextView) findViewById(R.id.tv_text6)).setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View arg0) {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
    }
}
