package com.syu.app.ipc;

import android.util.Log;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.App_Radio;
import com.syu.radio.ctrl.JFreqBand;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.page.Page_Radio;
import com.syu.radio.page.Page_Set;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Radio_Ipc_NewNotifyPage {
    public int mSearchState = 0;

    public int getTAOn_Visibility() {
        int mcurBand;
        int rdsEnable = RadioM.DATA[15];
        if (rdsEnable != 1) {
            return 8;
        }
        int value = RadioM.DATA[9];
        if (value != 1 || (mcurBand = RadioM.DATA[0]) < 65536 || mcurBand > 65538) {
            return 8;
        }
        return 0;
    }

    public int getAFOn_Visibility() {
        int mcurBand;
        int rdsEnable = RadioM.DATA[15];
        if (rdsEnable != 1) {
            return 8;
        }
        int value = RadioM.DATA[6];
        if (value != 1 || (mcurBand = RadioM.DATA[0]) < 65536 || mcurBand > 65538) {
            return 8;
        }
        return 0;
    }

    public void getSTSCAN_Visibility(int[] visibility) {
        int mSt = RadioM.DATA[21];
        int mcurBand = RadioM.DATA[0];
        int mScan = RadioM.DATA[20];
        if (mSt != 0) {
            if (mScan != 0) {
                visibility[0] = 0;
            } else if (mcurBand >= 65536 && mcurBand <= 65538) {
                visibility[1] = 0;
            }
        }
    }

    public int getLoc_Visibility() {
        int mcurBand = RadioM.DATA[0];
        int mSearchState = RadioM.DATA[22];
        int mLoc = RadioM.DATA[23];
        if (mcurBand < 65536 || mcurBand > 65538 || mSearchState == 1 || mLoc == 0) {
            return 8;
        }
        return 0;
    }

    public int getTA_Visibility() {
        int mcurBand;
        int rdsEnable = RadioM.DATA[15];
        if (rdsEnable != 1) {
            return 8;
        }
        int value = RadioM.DATA[7];
        if (value != 1 || (mcurBand = RadioM.DATA[0]) < 65536 || mcurBand > 65538) {
            return 8;
        }
        return 0;
    }

    public int getTP_Visibility() {
        int mcurBand;
        int rdsEnable = RadioM.DATA[15];
        if (rdsEnable != 1) {
            return 8;
        }
        int value = RadioM.DATA[8];
        if (value != 1 || (mcurBand = RadioM.DATA[0]) < 65536 || mcurBand > 65538) {
            return 8;
        }
        return 0;
    }

    public boolean getRdsDisplay() {
        int rdsenable = RadioM.DATA[15];
        int band = RadioM.DATA[0];
        if (rdsenable != 1 || band < 65536 || band > 65538) {
            return false;
        }
        return true;
    }

    public boolean updateHiLightBtn(JButton btn, JView view, int freq, int indexSelect) {
        boolean bHiLight = true;
        if (indexSelect >= 18) {
            if (freq != RadioM.FREQ_AM[indexSelect - 18]) {
                bHiLight = false;
            }
        } else if (freq != RadioM.FREQ_FM[indexSelect]) {
            bHiLight = false;
        }
        if (btn.bPartnerDependent) {
            btn.setPartnerFocus(bHiLight);
        } else {
            btn.setFocus(bHiLight);
            if (view != null) {
                if (bHiLight) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(4);
                }
            }
        }
        return bHiLight;
    }

    public int getFocusCheckBoxId() {
        switch (RadioM.DATA[2]) {
            case 0:
                return FinalRadioCtrl.Set_CheckBox_AreaUSA;
            case 1:
                return FinalRadioCtrl.Set_CheckBox_AreaLatin;
            case 2:
                return FinalRadioCtrl.Set_CheckBox_AreaEurope;
            case 3:
                return FinalRadioCtrl.Set_CheckBox_AreaOirt;
            case 4:
                return FinalRadioCtrl.Set_CheckBox_AreaJapan;
            default:
                return -1;
        }
    }

    public int updateChannelText(JText txtChannel, JFreqBand bandChannel) {
        String strChannel;
        String strChannel2;
        int index = -1;
        int value = RadioM.DATA[3];
        String strExtra = FinalChip.BSP_PLATFORM_Null;
        if (App_Radio.bChannelAddP) {
            strExtra = "P";
        }
        if (value >= 0 && value < 12) {
            index = value + 18 + 0;
            int value2 = value + 0;
            if (App_Radio.bChangeChannelText) {
                strChannel2 = "AM";
            } else {
                strChannel2 = String.format(Locale.US, "AM %d-" + strExtra + "%d", Integer.valueOf((value2 / 6) + 1), Integer.valueOf((value2 % 6) + 1));
            }
            if (txtChannel != null) {
                txtChannel.setText(strChannel2);
            } else if (bandChannel != null) {
                bandChannel.setCurrenBand(strChannel2);
            }
        } else if (value >= 65536 && value < 65554) {
            index = value - 65536;
            int value3 = value - 65536;
            if (App_Radio.bChangeChannelText) {
                strChannel = "FM";
            } else {
                strChannel = String.format(Locale.US, "FM %d-" + strExtra + "%d", Integer.valueOf((value3 / 6) + 1), Integer.valueOf((value3 % 6) + 1));
            }
            if (txtChannel != null) {
                txtChannel.setText(strChannel);
            } else if (bandChannel != null) {
                bandChannel.setCurrenBand(strChannel);
            }
        }
        return index;
    }

    public void updatePtyText(JText txtPty) {
        int visibility = 8;
        int flagPty = RadioM.DATA[5];
        int rdsEnable = RadioM.DATA[15];
        int band = RadioM.DATA[0];
        if (flagPty < 0 || flagPty > 40) {
            flagPty = 0;
        }
        if (rdsEnable == 1 && band >= 65536 && band <= 65538) {
            visibility = 0;
            txtPty.setText(RadioM.PTY_Display[flagPty]);
        }
        txtPty.setVisibility(visibility);
    }

    public void onNotify(Page_Radio radioPage_Radio, int updateCode, int[] ints, float[] flts, String[] strs) {
        switch (updateCode) {
            case 0:
                radioPage_Radio.updateDispInfo();
                radioPage_Radio.band(true);
                radioPage_Radio.showSTSCAN();
                radioPage_Radio.showRds();
                break;
            case 1:
                int value = RadioM.DATA[1];
                int band = RadioM.DATA[0];
                Log.d("gdy11", " 11 radio FinalRadio.U_FREQ value = " + value);
                if (band >= 65536 && band <= 65538) {
                    if (value <= 5000 || value > 10800) {
                        value = 8750;
                    }
                } else if (band >= 0) {
                }
                radioPage_Radio.updateCurrentFreq(value, true);
                break;
            case 2:
                radioPage_Radio.actRadio.initlist(false, false, true);
                break;
            case 3:
                radioPage_Radio.channel();
                break;
            case 4:
                if (IpcUtil.intsOk(ints, 2)) {
                    radioPage_Radio.updateChannelFreq(ints[0], ints[1]);
                }
                break;
            case 5:
                radioPage_Radio.showPTY();
                break;
            case 6:
                radioPage_Radio.showAFON();
                break;
            case 7:
                radioPage_Radio.showTA();
                break;
            case 8:
                radioPage_Radio.showTP();
                break;
            case 9:
                radioPage_Radio.showTAON();
                break;
            case 13:
                radioPage_Radio.showRds();
                break;
            case 14:
                if (IpcUtil.intsOk(ints, 1)) {
                    int channel = ints[0];
                    if (channel >= 65536 && channel <= 131072) {
                        int _channel = channel - 65536;
                        radioPage_Radio.updateChannelName(_channel % 6);
                        break;
                    } else if (channel >= 0 && channel <= 65536) {
                        int _channel2 = channel + 0;
                        radioPage_Radio.updateChannelName(_channel2 % 6);
                        break;
                    }
                }
                break;
            case 15:
                radioPage_Radio.rdsEnable();
                break;
            case 16:
                radioPage_Radio.handleExtraFreqInfo();
                break;
            case 20:
                radioPage_Radio.showSTSCAN();
                break;
            case 21:
                radioPage_Radio.showSTSCAN();
                break;
            case 22:
                radioPage_Radio.showLOC();
                if (this.mSearchState != RadioM.DATA[22]) {
                    if (this.mSearchState == 1) {
                        radioPage_Radio.band(true);
                    }
                    this.mSearchState = RadioM.DATA[22];
                }
                break;
            case 23:
                radioPage_Radio.showLOC();
                break;
            case 26:
                radioPage_Radio.showPS();
                break;
        }
    }

    public void onNotify(Page_Set radioPage_Set, int updateCode, int[] ints, float[] flts, String[] strs) {
        switch (updateCode) {
            case 2:
                radioPage_Set.updateCurrentArea();
                break;
            case 15:
                radioPage_Set.updateFlagRds();
                break;
            case 17:
                JText textAmSens = (JText) radioPage_Set.getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_AmSensVal);
                if (textAmSens != null) {
                    textAmSens.setText(new StringBuilder().append(RadioM.DATA[updateCode]).toString());
                }
                break;
            case 18:
                JText textFmSens = (JText) radioPage_Set.getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_FmSensVal);
                if (textFmSens != null) {
                    textFmSens.setText(new StringBuilder().append(RadioM.DATA[updateCode]).toString());
                }
                break;
            case 19:
                radioPage_Set.updateSensAuto();
                break;
        }
    }
}
