package com.syu.radio.page;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.android.fmradio.FmService;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JScrollViewHorizontal;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Menu extends MyPage {
    Act_Radio actRadio;
    JScrollViewHorizontal mRadio_ScrollView_Menu;
    private int[] nightBtn;

    public Page_Menu(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.nightBtn = new int[]{FinalRadioCtrl.Radio_Btn_Band, FinalRadioCtrl.Radio_Btn_Scan, FinalRadioCtrl.Radio_Btn_Loc, FinalRadioCtrl.Radio_Btn_ST, FinalRadioCtrl.Radio_Btn_Pty, FinalRadioCtrl.Radio_Btn_Ta, FinalRadioCtrl.Radio_Btn_Af, FinalRadioCtrl.Radio_Btn_Set, FinalRadioCtrl.Radio_Btn_Yun};
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.actRadio.mListPageMenus.add(this);
        rdsEnable();
        this.mRadio_ScrollView_Menu = (JScrollViewHorizontal) getPage().getChildViewByid(FinalRadioCtrl.Radio_ScrollView_Menu);
    }

    public void rdsEnable() {
        boolean bRdsDisplay = false;
        if (FmUtils.mBand >= 1 && FmUtils.mBand <= 3) {
            switch (App_Radio.iRadioType_Arm) {
                case 1:
                case 2:
                    bRdsDisplay = App_Radio.isSupportRds6025() && FmService.getRdsOnOff() == 1;
                    break;
                case 3:
                    bRdsDisplay = App_Radio.isSupportRds() && FmService.getRdsOnOff() == 1;
                    break;
                default:
                    bRdsDisplay = App_Radio.getInstance().mIpcObj.getRdsDisplay();
                    break;
            }
        }
        View view = getPage().getChildViewByid(FinalRadioCtrl.Menu_Rds);
        if (view != null) {
            view.setVisibility(bRdsDisplay ? 0 : 8);
            return;
        }
        JButton btnPty = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_Pty);
        JButton btnTA = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta);
        JButton btnAF = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_Af);
        if (btnPty != null) {
            btnPty.setTextColor(bRdsDisplay ? -1 : -7829368);
            btnPty.setEnabled(bRdsDisplay);
        }
        if (btnAF != null) {
            btnAF.setTextColor(bRdsDisplay ? -1 : -7829368);
            btnAF.setEnabled(bRdsDisplay);
        }
        if (btnTA != null) {
            btnTA.setTextColor(bRdsDisplay ? -1 : -7829368);
            btnTA.setEnabled(bRdsDisplay);
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        if (this.actRadio.mInterfacePageRadio != null) {
            boolean bIsFmBak = FmUtils.mBand >= 1 && FmUtils.mBand <= 3;
            if (this.actRadio.mInterfacePageRadio.ResponseClick_Menu(id)) {
                if (App_Radio.iRadioType_Arm != 0) {
                    boolean bIsFm = FmUtils.mBand >= 1 && FmUtils.mBand <= 3;
                    if (bIsFm != bIsFmBak) {
                        rdsEnable();
                    }
                    return;
                }
                return;
            }
        }
        switch (id) {
            case FinalRadioCtrl.Radio_Btn_Eq /* 130104 */:
                Log.d("eqq", " Radio_Btn_Eq **** 000 ");
                if (!FuncUtils.isFastDoubleClick()) {
                    Log.d("eqq", " Radio_Btn_Eq **** 111 ");
                    Intent intent = new Intent();
                    intent.setAction("com.syu.eq");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setFlags(268435456);
                    this.actRadio.myActivity.startActivity(intent);
                    Log.d("eqq", " Radio_Btn_Eq **** 222 ");
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Edit /* 130116 */:
                Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_Info, "pop_add_contacts_anim", true);
                if (popDlg != null) {
                    JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Info);
                    if (page != null) {
                        page.resume();
                    }
                    popDlg.show();
                }
                break;
            case FinalRadioCtrl.Radio_Menu_Next /* 130117 */:
                if (this.mRadio_ScrollView_Menu != null) {
                    Log.d("menu", " Menu  getNextFocusDownId = " + this.mRadio_ScrollView_Menu.getNextFocusDownId() + " getScrollX = " + this.mRadio_ScrollView_Menu.getScrollX());
                    if (this.mRadio_ScrollView_Menu.getScrollX() > 610) {
                        this.mRadio_ScrollView_Menu.fullScroll(17);
                    } else {
                        this.mRadio_ScrollView_Menu.fullScroll(66);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Set /* 130135 */:
                this.actRadio.goPage(FinalRadioCtrl.Page_Set);
                break;
            case FinalRadioCtrl.Radio_Btn_Yun /* 130136 */:
                App_Radio.bFmbdDlgShow = true;
                App_Radio.getInstance().Send_FmbdDlgIntent("show");
                break;
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public boolean ResponseLongClick(View v) {
        int id = v.getId();
        if (this.actRadio.mInterfacePageRadio != null) {
            return this.actRadio.mInterfacePageRadio.ResponseLongClick_Menu(id);
        }
        return false;
    }

    public void setDayOrNight(int value) {
        Log.d("ui7", "  Page Menu  setDayOrNight value = " + value);
        if (App_Radio.bUI_NightColour) {
            String str = value > 0 ? "night_" : FinalChip.BSP_PLATFORM_Null;
            for (int i = 0; i < this.nightBtn.length; i++) {
                JButton button = (JButton) getPage().getChildViewByid(this.nightBtn[i]);
                if (button != null) {
                    String drawableName = button.getStrDrawable();
                    if (TextUtils.isEmpty(str)) {
                        if (drawableName.startsWith("night_")) {
                            button.setStrDrawable(drawableName.replace("night_", FinalChip.BSP_PLATFORM_Null), true);
                        }
                    } else if (!drawableName.startsWith("night_")) {
                        button.setStrDrawable("night_" + drawableName, true);
                    }
                }
            }
        }
    }
}
