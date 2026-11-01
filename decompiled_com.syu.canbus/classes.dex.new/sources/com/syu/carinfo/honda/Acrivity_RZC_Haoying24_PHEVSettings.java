package com.syu.carinfo.honda;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Acrivity_RZC_Haoying24_PHEVSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_RZC_Haoying24_PHEVSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 340:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text1)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text1)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                    }
                    break;
                case 341:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 342:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 343:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 344:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 345:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext2), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext3), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext4), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext5), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext6), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext7), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext8), ((value >> 1) & 1) == 1);
                    break;
                case 346:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text7)).setText("在家");
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text7)).setText("任何地点");
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text7)).setText("----");
                            break;
                    }
                    break;
                case 347:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text8)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text8)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text8)).setText("----");
                            break;
                    }
                    break;
                case 348:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 349:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 350:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 351:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 352:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext9), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext10), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext11), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext12), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext13), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext14), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext15), ((value >> 1) & 1) == 1);
                    break;
                case 353:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text14)).setText("在家");
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text14)).setText("任何地点");
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text14)).setText("----");
                            break;
                    }
                    break;
                case 354:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("80%");
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("85%");
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("90%");
                            break;
                        case 4:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("95%");
                            break;
                        case 5:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("100%");
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("----");
                            break;
                    }
                    break;
                case 355:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("80%");
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("85%");
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("90%");
                            break;
                        case 4:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("95%");
                            break;
                        case 5:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("100%");
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("----");
                            break;
                    }
                    break;
                case 356:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText("----");
                            break;
                    }
                    break;
                case 357:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText("----");
                            break;
                    }
                    break;
                case 358:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text19)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text19)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text19)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text19)).setText("----");
                            break;
                    }
                    break;
                case 359:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 360:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text21)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 361:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 362:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 363:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext16), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext17), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext18), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext19), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext20), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext21), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext22), ((value >> 1) & 1) == 1);
                    break;
                case 364:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text25)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text25)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text25)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text25)).setText("----");
                            break;
                    }
                    break;
                case 365:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text26)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 366:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text27)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 367:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text28)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 368:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text29)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 369:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext23), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext24), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext25), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext26), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext27), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext28), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext29), ((value >> 1) & 1) == 1);
                    break;
                case 370:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text31)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text31)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text31)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text31)).setText("----");
                            break;
                    }
                    break;
                case 371:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text32)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 372:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text33)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 373:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text34)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 374:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text35)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 375:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext30), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext31), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext32), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext33), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext34), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext35), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext36), ((value >> 1) & 1) == 1);
                    break;
                case 376:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text37)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text37)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text37)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text37)).setText("----");
                            break;
                    }
                    break;
                case 377:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text38)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 378:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text39)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 379:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text40)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 380:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text41)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 381:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext37), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext38), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext39), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext40), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext41), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext42), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext43), ((value >> 1) & 1) == 1);
                    break;
                case 382:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text43)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text43)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text43)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text43)).setText("----");
                            break;
                    }
                    break;
                case 383:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text44)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 384:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text45)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 385:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text46)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 386:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text47)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 387:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext44), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext45), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext46), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext47), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext48), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext49), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext50), ((value >> 1) & 1) == 1);
                    break;
                case 388:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text49)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text49)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text49)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text49)).setText("----");
                            break;
                    }
                    break;
                case 389:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text50)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 390:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text51)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 391:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text52)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 392:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text53)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 393:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext51), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext52), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext53), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext54), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext55), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext56), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext57), ((value >> 1) & 1) == 1);
                    break;
                case 394:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text55)).setText(R.string.off);
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text55)).setText(R.string.rzc_c4l_open);
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text55)).setText(R.string.delete);
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text55)).setText("----");
                            break;
                    }
                    break;
                case 395:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text56)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 396:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text57)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 397:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text58)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 398:
                    ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text59)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 399:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext58), ((value >> 7) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext59), ((value >> 6) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext60), ((value >> 5) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext61), ((value >> 4) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext62), ((value >> 3) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext63), ((value >> 2) & 1) == 1);
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext64), ((value >> 1) & 1) == 1);
                    break;
                case 400:
                    switch (value) {
                        case 0:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText("LO");
                            break;
                        case 255:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText("HI");
                            break;
                        default:
                            int value2 = value * 5;
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                            break;
                    }
                    break;
                case 401:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("10min");
                            break;
                        case 2:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("20min");
                            break;
                        case 3:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("30min");
                            break;
                        default:
                            ((TextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("----");
                            break;
                    }
                    break;
                case 402:
                    Acrivity_RZC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_RZC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0298_rzc_haoying24_phevsettings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext39), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext40), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext41), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext42), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext43), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext44), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext45), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext46), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext47), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext48), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext49), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext50), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext51), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext52), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext53), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext54), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext55), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext56), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext57), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext58), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext59), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext60), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext61), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext62), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext63), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext64), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick((Button) findViewById(R.id.btn_minus15), this);
        setSelfClick((Button) findViewById(R.id.btn_plus15), this);
        setSelfClick((Button) findViewById(R.id.btn_minus16), this);
        setSelfClick((Button) findViewById(R.id.btn_plus16), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
        setSelfClick((Button) findViewById(R.id.btn_minus18), this);
        setSelfClick((Button) findViewById(R.id.btn_plus18), this);
        setSelfClick((Button) findViewById(R.id.btn_minus19), this);
        setSelfClick((Button) findViewById(R.id.btn_plus19), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((Button) findViewById(R.id.btn_minus25), this);
        setSelfClick((Button) findViewById(R.id.btn_plus25), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((Button) findViewById(R.id.btn_minus31), this);
        setSelfClick((Button) findViewById(R.id.btn_plus31), this);
        setSelfClick((Button) findViewById(R.id.btn_minus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        setSelfClick((Button) findViewById(R.id.btn_minus33), this);
        setSelfClick((Button) findViewById(R.id.btn_plus33), this);
        setSelfClick((Button) findViewById(R.id.btn_minus34), this);
        setSelfClick((Button) findViewById(R.id.btn_plus34), this);
        setSelfClick((Button) findViewById(R.id.btn_minus35), this);
        setSelfClick((Button) findViewById(R.id.btn_plus35), this);
        setSelfClick((Button) findViewById(R.id.btn_minus37), this);
        setSelfClick((Button) findViewById(R.id.btn_plus37), this);
        setSelfClick((Button) findViewById(R.id.btn_minus38), this);
        setSelfClick((Button) findViewById(R.id.btn_plus38), this);
        setSelfClick((Button) findViewById(R.id.btn_minus39), this);
        setSelfClick((Button) findViewById(R.id.btn_plus39), this);
        setSelfClick((Button) findViewById(R.id.btn_minus40), this);
        setSelfClick((Button) findViewById(R.id.btn_plus40), this);
        setSelfClick((Button) findViewById(R.id.btn_minus41), this);
        setSelfClick((Button) findViewById(R.id.btn_plus41), this);
        setSelfClick((Button) findViewById(R.id.btn_minus43), this);
        setSelfClick((Button) findViewById(R.id.btn_plus43), this);
        setSelfClick((Button) findViewById(R.id.btn_minus44), this);
        setSelfClick((Button) findViewById(R.id.btn_plus44), this);
        setSelfClick((Button) findViewById(R.id.btn_minus45), this);
        setSelfClick((Button) findViewById(R.id.btn_plus45), this);
        setSelfClick((Button) findViewById(R.id.btn_minus46), this);
        setSelfClick((Button) findViewById(R.id.btn_plus46), this);
        setSelfClick((Button) findViewById(R.id.btn_minus47), this);
        setSelfClick((Button) findViewById(R.id.btn_plus47), this);
        setSelfClick((Button) findViewById(R.id.btn_minus49), this);
        setSelfClick((Button) findViewById(R.id.btn_plus49), this);
        setSelfClick((Button) findViewById(R.id.btn_minus50), this);
        setSelfClick((Button) findViewById(R.id.btn_plus50), this);
        setSelfClick((Button) findViewById(R.id.btn_minus51), this);
        setSelfClick((Button) findViewById(R.id.btn_plus51), this);
        setSelfClick((Button) findViewById(R.id.btn_minus52), this);
        setSelfClick((Button) findViewById(R.id.btn_plus52), this);
        setSelfClick((Button) findViewById(R.id.btn_minus53), this);
        setSelfClick((Button) findViewById(R.id.btn_plus53), this);
        setSelfClick((Button) findViewById(R.id.btn_minus55), this);
        setSelfClick((Button) findViewById(R.id.btn_plus55), this);
        setSelfClick((Button) findViewById(R.id.btn_minus56), this);
        setSelfClick((Button) findViewById(R.id.btn_plus56), this);
        setSelfClick((Button) findViewById(R.id.btn_minus57), this);
        setSelfClick((Button) findViewById(R.id.btn_plus57), this);
        setSelfClick((Button) findViewById(R.id.btn_minus58), this);
        setSelfClick((Button) findViewById(R.id.btn_plus58), this);
        setSelfClick((Button) findViewById(R.id.btn_minus59), this);
        setSelfClick((Button) findViewById(R.id.btn_plus59), this);
        setSelfClick((Button) findViewById(R.id.btn_minus61), this);
        setSelfClick((Button) findViewById(R.id.btn_plus61), this);
        setSelfClick((Button) findViewById(R.id.btn_minus62), this);
        setSelfClick((Button) findViewById(R.id.btn_plus62), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data3;
        int data6;
        int data7;
        int data8;
        int data9;
        int data10;
        int data11;
        int data12;
        int data13;
        int data14;
        int data15;
        int data16;
        int data17;
        int data18;
        int data19;
        int data20;
        int data21;
        int data22;
        int data23;
        int data24;
        int data25;
        int data26;
        int data27;
        int data28;
        int data29;
        int data30;
        int data31;
        int data32;
        int data33;
        int data34;
        int data35;
        int data36;
        int data37;
        int data38;
        int data39;
        int data40;
        int data41;
        int data42;
        int data43;
        int data44;
        int data45;
        int data46;
        int data47;
        int data48;
        int data49;
        int data50;
        int data51;
        int data52;
        int data53;
        int data54;
        int data55;
        int data56;
        int data57;
        int data58;
        int data59;
        int data60;
        int data61;
        int data62;
        int data63;
        int data64;
        int data65;
        int data66;
        int data67;
        int data68;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int data1 = DataCanbus.DATA[340];
                int data2 = DataCanbus.DATA[341];
                int data4 = DataCanbus.DATA[342];
                int data5 = DataCanbus.DATA[343];
                int data69 = DataCanbus.DATA[344];
                int data70 = DataCanbus.DATA[345];
                int data71 = DataCanbus.DATA[346];
                int data72 = data1 - 1;
                if (data72 < 1) {
                    data72 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data72, data2, data4, data5, data69, data70, data71}, null, null);
                return;
            case R.id.btn_plus1 /* 2131427458 */:
                int data73 = DataCanbus.DATA[340];
                int data74 = DataCanbus.DATA[341];
                int data75 = DataCanbus.DATA[342];
                int data76 = DataCanbus.DATA[343];
                int data77 = DataCanbus.DATA[344];
                int data78 = DataCanbus.DATA[345];
                int data79 = DataCanbus.DATA[346];
                int data80 = data73 + 1;
                if (data80 > 3) {
                    data80 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data80, data74, data75, data76, data77, data78, data79}, null, null);
                return;
            case R.id.btn_minus2 /* 2131427459 */:
                int data81 = DataCanbus.DATA[340];
                int data82 = DataCanbus.DATA[341];
                int data83 = DataCanbus.DATA[342];
                int data84 = DataCanbus.DATA[343];
                int data85 = DataCanbus.DATA[344];
                int data86 = DataCanbus.DATA[345];
                int data87 = DataCanbus.DATA[346];
                int data88 = data82 - 1;
                if (data88 < 0) {
                    data88 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data81, data88, data83, data84, data85, data86, data87}, null, null);
                return;
            case R.id.btn_plus2 /* 2131427461 */:
                int data89 = DataCanbus.DATA[340];
                int data90 = DataCanbus.DATA[341];
                int data91 = DataCanbus.DATA[342];
                int data92 = DataCanbus.DATA[343];
                int data93 = DataCanbus.DATA[344];
                int data94 = DataCanbus.DATA[345];
                int data95 = DataCanbus.DATA[346];
                int data96 = data90 + 1;
                if (data96 > 23) {
                    data96 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data89, data96, data91, data92, data93, data94, data95}, null, null);
                return;
            case R.id.btn_minus3 /* 2131427462 */:
                int data97 = DataCanbus.DATA[340];
                int data98 = DataCanbus.DATA[341];
                int data99 = DataCanbus.DATA[342];
                int data100 = DataCanbus.DATA[343];
                int data101 = DataCanbus.DATA[344];
                int data102 = DataCanbus.DATA[345];
                int data103 = DataCanbus.DATA[346];
                int data104 = data99 - 1;
                if (data104 < 0) {
                    data104 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data97, data98, data104, data100, data101, data102, data103}, null, null);
                return;
            case R.id.btn_plus3 /* 2131427464 */:
                int data105 = DataCanbus.DATA[340];
                int data106 = DataCanbus.DATA[341];
                int data107 = DataCanbus.DATA[342];
                int data108 = DataCanbus.DATA[343];
                int data109 = DataCanbus.DATA[344];
                int data110 = DataCanbus.DATA[345];
                int data111 = DataCanbus.DATA[346];
                int data112 = data107 + 1;
                if (data112 > 59) {
                    data112 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data105, data106, data112, data108, data109, data110, data111}, null, null);
                return;
            case R.id.btn_minus4 /* 2131427465 */:
                int data113 = DataCanbus.DATA[340];
                int data114 = DataCanbus.DATA[341];
                int data115 = DataCanbus.DATA[342];
                int data116 = DataCanbus.DATA[343];
                int data117 = DataCanbus.DATA[344];
                int data118 = DataCanbus.DATA[345];
                int data119 = DataCanbus.DATA[346];
                int data120 = data116 - 1;
                if (data120 < 0) {
                    data120 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data113, data114, data115, data120, data117, data118, data119}, null, null);
                return;
            case R.id.btn_plus4 /* 2131427467 */:
                int data121 = DataCanbus.DATA[340];
                int data122 = DataCanbus.DATA[341];
                int data123 = DataCanbus.DATA[342];
                int data124 = DataCanbus.DATA[343];
                int data125 = DataCanbus.DATA[344];
                int data126 = DataCanbus.DATA[345];
                int data127 = DataCanbus.DATA[346];
                int data128 = data124 + 1;
                if (data128 > 23) {
                    data128 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data121, data122, data123, data128, data125, data126, data127}, null, null);
                return;
            case R.id.btn_minus5 /* 2131427468 */:
                int data129 = DataCanbus.DATA[340];
                int data130 = DataCanbus.DATA[341];
                int data131 = DataCanbus.DATA[342];
                int data132 = DataCanbus.DATA[343];
                int data133 = DataCanbus.DATA[344];
                int data134 = DataCanbus.DATA[345];
                int data135 = DataCanbus.DATA[346];
                int data136 = data133 - 1;
                if (data136 < 0) {
                    data136 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data129, data130, data131, data132, data136, data134, data135}, null, null);
                return;
            case R.id.btn_plus5 /* 2131427470 */:
                int data137 = DataCanbus.DATA[340];
                int data138 = DataCanbus.DATA[341];
                int data139 = DataCanbus.DATA[342];
                int data140 = DataCanbus.DATA[343];
                int data141 = DataCanbus.DATA[344];
                int data142 = DataCanbus.DATA[345];
                int data143 = DataCanbus.DATA[346];
                int data144 = data141 + 1;
                if (data144 > 59) {
                    data144 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data137, data138, data139, data140, data144, data142, data143}, null, null);
                return;
            case R.id.btn_minus7 /* 2131427474 */:
                int data145 = DataCanbus.DATA[340];
                int data146 = DataCanbus.DATA[341];
                int data147 = DataCanbus.DATA[342];
                int data148 = DataCanbus.DATA[343];
                int data149 = DataCanbus.DATA[344];
                int data150 = DataCanbus.DATA[345];
                int data151 = DataCanbus.DATA[346] - 1;
                if (data151 < 1) {
                    data151 = 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data145, data146, data147, data148, data149, data150, data151}, null, null);
                return;
            case R.id.btn_plus7 /* 2131427476 */:
                int data152 = DataCanbus.DATA[340];
                int data153 = DataCanbus.DATA[341];
                int data154 = DataCanbus.DATA[342];
                int data155 = DataCanbus.DATA[343];
                int data156 = DataCanbus.DATA[344];
                int data157 = DataCanbus.DATA[345];
                int data158 = DataCanbus.DATA[346] + 1;
                if (data158 > 2) {
                    data158 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data152, data153, data154, data155, data156, data157, data158}, null, null);
                return;
            case R.id.btn_minus8 /* 2131427477 */:
                int data159 = DataCanbus.DATA[347];
                int data160 = DataCanbus.DATA[348];
                int data161 = DataCanbus.DATA[349];
                int data162 = DataCanbus.DATA[350];
                int data163 = DataCanbus.DATA[351];
                int data164 = DataCanbus.DATA[352];
                int data165 = DataCanbus.DATA[353];
                int data166 = data159 - 1;
                if (data166 < 1) {
                    data166 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data166, data160, data161, data162, data163, data164, data165}, null, null);
                return;
            case R.id.btn_plus8 /* 2131427479 */:
                int data167 = DataCanbus.DATA[347];
                int data168 = DataCanbus.DATA[348];
                int data169 = DataCanbus.DATA[349];
                int data170 = DataCanbus.DATA[350];
                int data171 = DataCanbus.DATA[351];
                int data172 = DataCanbus.DATA[352];
                int data173 = DataCanbus.DATA[353];
                int data174 = data167 + 1;
                if (data174 > 3) {
                    data174 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data174, data168, data169, data170, data171, data172, data173}, null, null);
                return;
            case R.id.btn_minus9 /* 2131427480 */:
                int data175 = DataCanbus.DATA[347];
                int data176 = DataCanbus.DATA[348];
                int data177 = DataCanbus.DATA[349];
                int data178 = DataCanbus.DATA[350];
                int data179 = DataCanbus.DATA[351];
                int data180 = DataCanbus.DATA[352];
                int data181 = DataCanbus.DATA[353];
                int data182 = data176 - 1;
                if (data182 < 0) {
                    data182 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data175, data182, data177, data178, data179, data180, data181}, null, null);
                return;
            case R.id.btn_plus9 /* 2131427482 */:
                int data183 = DataCanbus.DATA[347];
                int data184 = DataCanbus.DATA[348];
                int data185 = DataCanbus.DATA[349];
                int data186 = DataCanbus.DATA[350];
                int data187 = DataCanbus.DATA[351];
                int data188 = DataCanbus.DATA[352];
                int data189 = DataCanbus.DATA[353];
                int data190 = data184 + 1;
                if (data190 > 23) {
                    data190 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data183, data190, data185, data186, data187, data188, data189}, null, null);
                return;
            case R.id.btn_minus10 /* 2131427483 */:
                int data191 = DataCanbus.DATA[347];
                int data192 = DataCanbus.DATA[348];
                int data193 = DataCanbus.DATA[349];
                int data194 = DataCanbus.DATA[350];
                int data195 = DataCanbus.DATA[351];
                int data196 = DataCanbus.DATA[352];
                int data197 = DataCanbus.DATA[353];
                int data198 = data193 - 1;
                if (data198 < 0) {
                    data198 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data191, data192, data198, data194, data195, data196, data197}, null, null);
                return;
            case R.id.btn_plus10 /* 2131427485 */:
                int data199 = DataCanbus.DATA[347];
                int data200 = DataCanbus.DATA[348];
                int data201 = DataCanbus.DATA[349];
                int data202 = DataCanbus.DATA[350];
                int data203 = DataCanbus.DATA[351];
                int data204 = DataCanbus.DATA[352];
                int data205 = DataCanbus.DATA[353];
                int data206 = data201 + 1;
                if (data206 > 59) {
                    data206 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data199, data200, data206, data202, data203, data204, data205}, null, null);
                return;
            case R.id.btn_minus11 /* 2131427486 */:
                int data207 = DataCanbus.DATA[347];
                int data208 = DataCanbus.DATA[348];
                int data209 = DataCanbus.DATA[349];
                int data210 = DataCanbus.DATA[350];
                int data211 = DataCanbus.DATA[351];
                int data212 = DataCanbus.DATA[352];
                int data213 = DataCanbus.DATA[353];
                int data214 = data210 - 1;
                if (data214 < 0) {
                    data214 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data207, data208, data209, data214, data211, data212, data213}, null, null);
                return;
            case R.id.btn_plus11 /* 2131427488 */:
                int data215 = DataCanbus.DATA[347];
                int data216 = DataCanbus.DATA[348];
                int data217 = DataCanbus.DATA[349];
                int data218 = DataCanbus.DATA[350];
                int data219 = DataCanbus.DATA[351];
                int data220 = DataCanbus.DATA[352];
                int data221 = DataCanbus.DATA[353];
                int data222 = data218 + 1;
                if (data222 > 23) {
                    data222 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data215, data216, data217, data222, data219, data220, data221}, null, null);
                return;
            case R.id.btn_minus12 /* 2131427489 */:
                int data223 = DataCanbus.DATA[347];
                int data224 = DataCanbus.DATA[348];
                int data225 = DataCanbus.DATA[349];
                int data226 = DataCanbus.DATA[350];
                int data227 = DataCanbus.DATA[351];
                int data228 = DataCanbus.DATA[352];
                int data229 = DataCanbus.DATA[353];
                int data230 = data227 - 1;
                if (data230 < 0) {
                    data230 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data223, data224, data225, data226, data230, data228, data229}, null, null);
                return;
            case R.id.btn_plus12 /* 2131427491 */:
                int data231 = DataCanbus.DATA[347];
                int data232 = DataCanbus.DATA[348];
                int data233 = DataCanbus.DATA[349];
                int data234 = DataCanbus.DATA[350];
                int data235 = DataCanbus.DATA[351];
                int data236 = DataCanbus.DATA[352];
                int data237 = DataCanbus.DATA[353];
                int data238 = data235 + 1;
                if (data238 > 59) {
                    data238 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data231, data232, data233, data234, data238, data236, data237}, null, null);
                return;
            case R.id.btn_minus14 /* 2131427495 */:
                int data239 = DataCanbus.DATA[347];
                int data240 = DataCanbus.DATA[348];
                int data241 = DataCanbus.DATA[349];
                int data242 = DataCanbus.DATA[350];
                int data243 = DataCanbus.DATA[351];
                int data244 = DataCanbus.DATA[352];
                int data245 = DataCanbus.DATA[353] - 1;
                if (data245 < 1) {
                    data245 = 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data239, data240, data241, data242, data243, data244, data245}, null, null);
                return;
            case R.id.btn_plus14 /* 2131427497 */:
                int data246 = DataCanbus.DATA[347];
                int data247 = DataCanbus.DATA[348];
                int data248 = DataCanbus.DATA[349];
                int data249 = DataCanbus.DATA[350];
                int data250 = DataCanbus.DATA[351];
                int data251 = DataCanbus.DATA[352];
                int data252 = DataCanbus.DATA[353] + 1;
                if (data252 > 2) {
                    data252 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data246, data247, data248, data249, data250, data251, data252}, null, null);
                return;
            case R.id.btn_minus15 /* 2131427498 */:
                int data253 = DataCanbus.DATA[354];
                int data254 = DataCanbus.DATA[355];
                int data255 = data253 - 1;
                if (data255 < 1) {
                    data255 = 5;
                }
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[8];
                iArr[0] = 3;
                iArr[1] = data255;
                iArr[2] = data254;
                remoteModuleProxy.cmd(124, iArr, null, null);
                return;
            case R.id.btn_plus15 /* 2131427500 */:
                int data256 = DataCanbus.DATA[354];
                int data257 = DataCanbus.DATA[355];
                int data258 = data256 + 1;
                if (data258 > 5) {
                    data258 = 1;
                }
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[8];
                iArr2[0] = 3;
                iArr2[1] = data258;
                iArr2[2] = data257;
                remoteModuleProxy2.cmd(124, iArr2, null, null);
                return;
            case R.id.btn_minus16 /* 2131427501 */:
                int data259 = DataCanbus.DATA[354];
                int data260 = DataCanbus.DATA[355];
                int data261 = data260 - 1;
                if (data261 < 1) {
                    data261 = 5;
                }
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[8];
                iArr3[0] = 3;
                iArr3[1] = data259;
                iArr3[2] = data261;
                remoteModuleProxy3.cmd(124, iArr3, null, null);
                return;
            case R.id.btn_plus16 /* 2131427503 */:
                int data262 = DataCanbus.DATA[354];
                int data263 = DataCanbus.DATA[355];
                int data264 = data263 + 1;
                if (data264 > 5) {
                    data264 = 1;
                }
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[8];
                iArr4[0] = 3;
                iArr4[1] = data262;
                iArr4[2] = data264;
                remoteModuleProxy4.cmd(124, iArr4, null, null);
                return;
            case R.id.btn_minus17 /* 2131427504 */:
                int data265 = DataCanbus.DATA[356];
                int data266 = DataCanbus.DATA[357];
                int data267 = data265 - 1;
                if (data267 < 1) {
                    data267 = 3;
                }
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[8];
                iArr5[0] = 4;
                iArr5[1] = data267;
                iArr5[2] = data266;
                remoteModuleProxy5.cmd(124, iArr5, null, null);
                return;
            case R.id.btn_plus17 /* 2131427506 */:
                int data268 = DataCanbus.DATA[356];
                int data269 = DataCanbus.DATA[357];
                int data270 = data268 + 1;
                if (data270 > 3) {
                    data270 = 1;
                }
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[8];
                iArr6[0] = 4;
                iArr6[1] = data270;
                iArr6[2] = data269;
                remoteModuleProxy6.cmd(124, iArr6, null, null);
                return;
            case R.id.btn_minus18 /* 2131427507 */:
                int data271 = DataCanbus.DATA[356];
                int data272 = DataCanbus.DATA[357];
                int data273 = data272 - 1;
                if (data273 < 1) {
                    data273 = 3;
                }
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[8];
                iArr7[0] = 4;
                iArr7[1] = data271;
                iArr7[2] = data273;
                remoteModuleProxy7.cmd(124, iArr7, null, null);
                return;
            case R.id.btn_plus18 /* 2131427509 */:
                int data274 = DataCanbus.DATA[356];
                int data275 = DataCanbus.DATA[357];
                int data276 = data275 + 1;
                if (data276 > 3) {
                    data276 = 1;
                }
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[8];
                iArr8[0] = 4;
                iArr8[1] = data274;
                iArr8[2] = data276;
                remoteModuleProxy8.cmd(124, iArr8, null, null);
                return;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int data277 = DataCanbus.DATA[400];
                int data278 = DataCanbus.DATA[401];
                int data279 = DataCanbus.DATA[402];
                if (data279 == 1) {
                    data3 = 2;
                } else {
                    data3 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{12, data277, data278, data3, 0, 0, 0, 0}, null, null);
                return;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int data280 = DataCanbus.DATA[340];
                int data281 = DataCanbus.DATA[341];
                int data282 = DataCanbus.DATA[342];
                int data283 = DataCanbus.DATA[343];
                int data284 = DataCanbus.DATA[344];
                int data285 = DataCanbus.DATA[345];
                int data286 = DataCanbus.DATA[346];
                if ((data285 & 32) != 0) {
                    data66 = data285 & 223;
                } else {
                    data66 = data285 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data280, data281, data282, data283, data284, data66, data286}, null, null);
                return;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int data287 = DataCanbus.DATA[340];
                int data288 = DataCanbus.DATA[341];
                int data289 = DataCanbus.DATA[342];
                int data290 = DataCanbus.DATA[343];
                int data291 = DataCanbus.DATA[344];
                int data292 = DataCanbus.DATA[345];
                int data293 = DataCanbus.DATA[346];
                if ((data292 & 16) != 0) {
                    data65 = data292 & 239;
                } else {
                    data65 = data292 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data287, data288, data289, data290, data291, data65, data293}, null, null);
                return;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int data294 = DataCanbus.DATA[340];
                int data295 = DataCanbus.DATA[341];
                int data296 = DataCanbus.DATA[342];
                int data297 = DataCanbus.DATA[343];
                int data298 = DataCanbus.DATA[344];
                int data299 = DataCanbus.DATA[345];
                int data300 = DataCanbus.DATA[346];
                if ((data299 & 128) != 0) {
                    data68 = data299 & 127;
                } else {
                    data68 = data299 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data294, data295, data296, data297, data298, data68, data300}, null, null);
                return;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int data301 = DataCanbus.DATA[340];
                int data302 = DataCanbus.DATA[341];
                int data303 = DataCanbus.DATA[342];
                int data304 = DataCanbus.DATA[343];
                int data305 = DataCanbus.DATA[344];
                int data306 = DataCanbus.DATA[345];
                int data307 = DataCanbus.DATA[346];
                if ((data306 & 64) != 0) {
                    data67 = data306 & 191;
                } else {
                    data67 = data306 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data301, data302, data303, data304, data305, data67, data307}, null, null);
                return;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                int data308 = DataCanbus.DATA[340];
                int data309 = DataCanbus.DATA[341];
                int data310 = DataCanbus.DATA[342];
                int data311 = DataCanbus.DATA[343];
                int data312 = DataCanbus.DATA[344];
                int data313 = DataCanbus.DATA[345];
                int data314 = DataCanbus.DATA[346];
                if ((data313 & 8) != 0) {
                    data64 = data313 & 247;
                } else {
                    data64 = data313 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data308, data309, data310, data311, data312, data64, data314}, null, null);
                return;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int data315 = DataCanbus.DATA[340];
                int data316 = DataCanbus.DATA[341];
                int data317 = DataCanbus.DATA[342];
                int data318 = DataCanbus.DATA[343];
                int data319 = DataCanbus.DATA[344];
                int data320 = DataCanbus.DATA[345];
                int data321 = DataCanbus.DATA[346];
                if ((data320 & 4) != 0) {
                    data63 = data320 & 251;
                } else {
                    data63 = data320 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data315, data316, data317, data318, data319, data63, data321}, null, null);
                return;
            case R.id.btn_minus19 /* 2131427593 */:
                int data322 = DataCanbus.DATA[358];
                int data323 = DataCanbus.DATA[359];
                int data324 = DataCanbus.DATA[360];
                int data325 = DataCanbus.DATA[361];
                int data326 = DataCanbus.DATA[362];
                int data327 = DataCanbus.DATA[363];
                int data328 = data322 - 1;
                if (data328 < 1) {
                    data328 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data328, data323, data324, data325, data326, data327, 0}, null, null);
                return;
            case R.id.btn_plus19 /* 2131427595 */:
                int data329 = DataCanbus.DATA[358];
                int data330 = DataCanbus.DATA[359];
                int data331 = DataCanbus.DATA[360];
                int data332 = DataCanbus.DATA[361];
                int data333 = DataCanbus.DATA[362];
                int data334 = DataCanbus.DATA[363];
                int data335 = data329 + 1;
                if (data335 > 3) {
                    data335 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data335, data330, data331, data332, data333, data334, 0}, null, null);
                return;
            case R.id.btn_minus20 /* 2131427597 */:
                int data336 = DataCanbus.DATA[358];
                int data337 = DataCanbus.DATA[359];
                int data338 = DataCanbus.DATA[360];
                int data339 = DataCanbus.DATA[361];
                int data340 = DataCanbus.DATA[362];
                int data341 = DataCanbus.DATA[363];
                int data342 = data337 - 1;
                if (data342 < 0) {
                    data342 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data336, data342, data338, data339, data340, data341, 0}, null, null);
                return;
            case R.id.btn_plus20 /* 2131427599 */:
                int data343 = DataCanbus.DATA[358];
                int data344 = DataCanbus.DATA[359];
                int data345 = DataCanbus.DATA[360];
                int data346 = DataCanbus.DATA[361];
                int data347 = DataCanbus.DATA[362];
                int data348 = DataCanbus.DATA[363];
                int data349 = data344 + 1;
                if (data349 > 23) {
                    data349 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data343, data349, data345, data346, data347, data348, 0}, null, null);
                return;
            case R.id.btn_minus21 /* 2131427600 */:
                int data350 = DataCanbus.DATA[358];
                int data351 = DataCanbus.DATA[359];
                int data352 = DataCanbus.DATA[360];
                int data353 = DataCanbus.DATA[361];
                int data354 = DataCanbus.DATA[362];
                int data355 = DataCanbus.DATA[363];
                int data356 = data352 - 1;
                if (data356 < 0) {
                    data356 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data350, data351, data356, data353, data354, data355, 0}, null, null);
                return;
            case R.id.btn_plus21 /* 2131427602 */:
                int data357 = DataCanbus.DATA[358];
                int data358 = DataCanbus.DATA[359];
                int data359 = DataCanbus.DATA[360];
                int data360 = DataCanbus.DATA[361];
                int data361 = DataCanbus.DATA[362];
                int data362 = DataCanbus.DATA[363];
                int data363 = data359 + 1;
                if (data363 > 59) {
                    data363 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data357, data358, data363, data360, data361, data362, 0}, null, null);
                return;
            case R.id.btn_minus22 /* 2131427603 */:
                int data364 = DataCanbus.DATA[358];
                int data365 = DataCanbus.DATA[359];
                int data366 = DataCanbus.DATA[360];
                int data367 = DataCanbus.DATA[361];
                int data368 = DataCanbus.DATA[362];
                int data369 = DataCanbus.DATA[363];
                int data370 = data367 - 1;
                if (data370 < 0) {
                    data370 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data364, data365, data366, data370, data368, data369, 0}, null, null);
                return;
            case R.id.btn_plus22 /* 2131427605 */:
                int data371 = DataCanbus.DATA[358];
                int data372 = DataCanbus.DATA[359];
                int data373 = DataCanbus.DATA[360];
                int data374 = DataCanbus.DATA[361];
                int data375 = DataCanbus.DATA[362];
                int data376 = DataCanbus.DATA[363];
                int data377 = data374 + 1;
                if (data377 > 23) {
                    data377 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data371, data372, data373, data377, data375, data376, 0}, null, null);
                return;
            case R.id.btn_minus23 /* 2131427607 */:
                int data378 = DataCanbus.DATA[358];
                int data379 = DataCanbus.DATA[359];
                int data380 = DataCanbus.DATA[360];
                int data381 = DataCanbus.DATA[361];
                int data382 = DataCanbus.DATA[362];
                int data383 = DataCanbus.DATA[363];
                int data384 = data382 - 1;
                if (data384 < 0) {
                    data384 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data378, data379, data380, data381, data384, data383, 0}, null, null);
                return;
            case R.id.btn_plus23 /* 2131427609 */:
                int data385 = DataCanbus.DATA[358];
                int data386 = DataCanbus.DATA[359];
                int data387 = DataCanbus.DATA[360];
                int data388 = DataCanbus.DATA[361];
                int data389 = DataCanbus.DATA[362];
                int data390 = DataCanbus.DATA[363];
                int data391 = data389 + 1;
                if (data391 > 59) {
                    data391 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data385, data386, data387, data388, data391, data390, 0}, null, null);
                return;
            case R.id.btn_minus25 /* 2131427613 */:
                int data392 = DataCanbus.DATA[364];
                int data393 = DataCanbus.DATA[365];
                int data394 = DataCanbus.DATA[366];
                int data395 = DataCanbus.DATA[367];
                int data396 = DataCanbus.DATA[368];
                int data397 = DataCanbus.DATA[369];
                int data398 = data392 - 1;
                if (data398 < 1) {
                    data398 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data398, data393, data394, data395, data396, data397, 0}, null, null);
                return;
            case R.id.btn_plus25 /* 2131427615 */:
                int data399 = DataCanbus.DATA[364];
                int data400 = DataCanbus.DATA[365];
                int data401 = DataCanbus.DATA[366];
                int data402 = DataCanbus.DATA[367];
                int data403 = DataCanbus.DATA[368];
                int data404 = DataCanbus.DATA[369];
                int data405 = data399 + 1;
                if (data405 > 3) {
                    data405 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data405, data400, data401, data402, data403, data404, 0}, null, null);
                return;
            case R.id.btn_minus26 /* 2131427617 */:
                int data406 = DataCanbus.DATA[364];
                int data407 = DataCanbus.DATA[365];
                int data408 = DataCanbus.DATA[366];
                int data409 = DataCanbus.DATA[367];
                int data410 = DataCanbus.DATA[368];
                int data411 = DataCanbus.DATA[369];
                int data412 = data407 - 1;
                if (data412 < 0) {
                    data412 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data406, data412, data408, data409, data410, data411, 0}, null, null);
                return;
            case R.id.btn_plus26 /* 2131427619 */:
                int data413 = DataCanbus.DATA[364];
                int data414 = DataCanbus.DATA[365];
                int data415 = DataCanbus.DATA[366];
                int data416 = DataCanbus.DATA[367];
                int data417 = DataCanbus.DATA[368];
                int data418 = DataCanbus.DATA[369];
                int data419 = data414 + 1;
                if (data419 > 23) {
                    data419 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data413, data419, data415, data416, data417, data418, 0}, null, null);
                return;
            case R.id.btn_minus27 /* 2131427620 */:
                int data420 = DataCanbus.DATA[364];
                int data421 = DataCanbus.DATA[365];
                int data422 = DataCanbus.DATA[366];
                int data423 = DataCanbus.DATA[367];
                int data424 = DataCanbus.DATA[368];
                int data425 = DataCanbus.DATA[369];
                int data426 = data422 - 1;
                if (data426 < 0) {
                    data426 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data420, data421, data426, data423, data424, data425, 0}, null, null);
                return;
            case R.id.btn_plus27 /* 2131427622 */:
                int data427 = DataCanbus.DATA[364];
                int data428 = DataCanbus.DATA[365];
                int data429 = DataCanbus.DATA[366];
                int data430 = DataCanbus.DATA[367];
                int data431 = DataCanbus.DATA[368];
                int data432 = DataCanbus.DATA[369];
                int data433 = data429 + 1;
                if (data433 > 59) {
                    data433 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data427, data428, data433, data430, data431, data432, 0}, null, null);
                return;
            case R.id.btn_minus28 /* 2131427623 */:
                int data434 = DataCanbus.DATA[364];
                int data435 = DataCanbus.DATA[365];
                int data436 = DataCanbus.DATA[366];
                int data437 = DataCanbus.DATA[367];
                int data438 = DataCanbus.DATA[368];
                int data439 = DataCanbus.DATA[369];
                int data440 = data437 - 1;
                if (data440 < 0) {
                    data440 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data434, data435, data436, data440, data438, data439, 0}, null, null);
                return;
            case R.id.btn_plus28 /* 2131427625 */:
                int data441 = DataCanbus.DATA[364];
                int data442 = DataCanbus.DATA[365];
                int data443 = DataCanbus.DATA[366];
                int data444 = DataCanbus.DATA[367];
                int data445 = DataCanbus.DATA[368];
                int data446 = DataCanbus.DATA[369];
                int data447 = data444 + 1;
                if (data447 > 23) {
                    data447 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data441, data442, data443, data447, data445, data446, 0}, null, null);
                return;
            case R.id.btn_minus29 /* 2131427627 */:
                int data448 = DataCanbus.DATA[364];
                int data449 = DataCanbus.DATA[365];
                int data450 = DataCanbus.DATA[366];
                int data451 = DataCanbus.DATA[367];
                int data452 = DataCanbus.DATA[368];
                int data453 = DataCanbus.DATA[369];
                int data454 = data452 - 1;
                if (data454 < 0) {
                    data454 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data448, data449, data450, data451, data454, data453, 0}, null, null);
                return;
            case R.id.btn_plus29 /* 2131427629 */:
                int data455 = DataCanbus.DATA[364];
                int data456 = DataCanbus.DATA[365];
                int data457 = DataCanbus.DATA[366];
                int data458 = DataCanbus.DATA[367];
                int data459 = DataCanbus.DATA[368];
                int data460 = DataCanbus.DATA[369];
                int data461 = data459 + 1;
                if (data461 > 59) {
                    data461 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data455, data456, data457, data458, data461, data460, 0}, null, null);
                return;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int data462 = DataCanbus.DATA[340];
                int data463 = DataCanbus.DATA[341];
                int data464 = DataCanbus.DATA[342];
                int data465 = DataCanbus.DATA[343];
                int data466 = DataCanbus.DATA[344];
                int data467 = DataCanbus.DATA[345];
                int data468 = DataCanbus.DATA[346];
                if ((data467 & 2) != 0) {
                    data62 = data467 & 253;
                } else {
                    data62 = data467 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{1, data462, data463, data464, data465, data466, data62, data468}, null, null);
                return;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int data469 = DataCanbus.DATA[347];
                int data470 = DataCanbus.DATA[348];
                int data471 = DataCanbus.DATA[349];
                int data472 = DataCanbus.DATA[350];
                int data473 = DataCanbus.DATA[351];
                int data474 = DataCanbus.DATA[352];
                int data475 = DataCanbus.DATA[353];
                if ((data474 & 128) != 0) {
                    data61 = data474 & 127;
                } else {
                    data61 = data474 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data469, data470, data471, data472, data473, data61, data475}, null, null);
                return;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int data476 = DataCanbus.DATA[347];
                int data477 = DataCanbus.DATA[348];
                int data478 = DataCanbus.DATA[349];
                int data479 = DataCanbus.DATA[350];
                int data480 = DataCanbus.DATA[351];
                int data481 = DataCanbus.DATA[352];
                int data482 = DataCanbus.DATA[353];
                if ((data481 & 64) != 0) {
                    data60 = data481 & 191;
                } else {
                    data60 = data481 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data476, data477, data478, data479, data480, data60, data482}, null, null);
                return;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int data483 = DataCanbus.DATA[347];
                int data484 = DataCanbus.DATA[348];
                int data485 = DataCanbus.DATA[349];
                int data486 = DataCanbus.DATA[350];
                int data487 = DataCanbus.DATA[351];
                int data488 = DataCanbus.DATA[352];
                int data489 = DataCanbus.DATA[353];
                if ((data488 & 32) != 0) {
                    data59 = data488 & 223;
                } else {
                    data59 = data488 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data483, data484, data485, data486, data487, data59, data489}, null, null);
                return;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int data490 = DataCanbus.DATA[347];
                int data491 = DataCanbus.DATA[348];
                int data492 = DataCanbus.DATA[349];
                int data493 = DataCanbus.DATA[350];
                int data494 = DataCanbus.DATA[351];
                int data495 = DataCanbus.DATA[352];
                int data496 = DataCanbus.DATA[353];
                if ((data495 & 16) != 0) {
                    data58 = data495 & 239;
                } else {
                    data58 = data495 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data490, data491, data492, data493, data494, data58, data496}, null, null);
                return;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                int data497 = DataCanbus.DATA[347];
                int data498 = DataCanbus.DATA[348];
                int data499 = DataCanbus.DATA[349];
                int data500 = DataCanbus.DATA[350];
                int data501 = DataCanbus.DATA[351];
                int data502 = DataCanbus.DATA[352];
                int data503 = DataCanbus.DATA[353];
                if ((data502 & 8) != 0) {
                    data57 = data502 & 247;
                } else {
                    data57 = data502 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data497, data498, data499, data500, data501, data57, data503}, null, null);
                return;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                int data504 = DataCanbus.DATA[347];
                int data505 = DataCanbus.DATA[348];
                int data506 = DataCanbus.DATA[349];
                int data507 = DataCanbus.DATA[350];
                int data508 = DataCanbus.DATA[351];
                int data509 = DataCanbus.DATA[352];
                int data510 = DataCanbus.DATA[353];
                if ((data509 & 4) != 0) {
                    data56 = data509 & 251;
                } else {
                    data56 = data509 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data504, data505, data506, data507, data508, data56, data510}, null, null);
                return;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                int data511 = DataCanbus.DATA[347];
                int data512 = DataCanbus.DATA[348];
                int data513 = DataCanbus.DATA[349];
                int data514 = DataCanbus.DATA[350];
                int data515 = DataCanbus.DATA[351];
                int data516 = DataCanbus.DATA[352];
                int data517 = DataCanbus.DATA[353];
                if ((data516 & 2) != 0) {
                    data55 = data516 & 253;
                } else {
                    data55 = data516 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{2, data511, data512, data513, data514, data515, data55, data517}, null, null);
                return;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                int data518 = DataCanbus.DATA[358];
                int data519 = DataCanbus.DATA[359];
                int data520 = DataCanbus.DATA[360];
                int data521 = DataCanbus.DATA[361];
                int data522 = DataCanbus.DATA[362];
                int data523 = DataCanbus.DATA[363];
                if ((data523 & 128) != 0) {
                    data54 = data523 & 127;
                } else {
                    data54 = data523 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data518, data519, data520, data521, data522, data54, 0}, null, null);
                return;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                int data524 = DataCanbus.DATA[358];
                int data525 = DataCanbus.DATA[359];
                int data526 = DataCanbus.DATA[360];
                int data527 = DataCanbus.DATA[361];
                int data528 = DataCanbus.DATA[362];
                int data529 = DataCanbus.DATA[363];
                if ((data529 & 64) != 0) {
                    data53 = data529 & 191;
                } else {
                    data53 = data529 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data524, data525, data526, data527, data528, data53, 0}, null, null);
                return;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                int data530 = DataCanbus.DATA[358];
                int data531 = DataCanbus.DATA[359];
                int data532 = DataCanbus.DATA[360];
                int data533 = DataCanbus.DATA[361];
                int data534 = DataCanbus.DATA[362];
                int data535 = DataCanbus.DATA[363];
                if ((data535 & 32) != 0) {
                    data52 = data535 & 223;
                } else {
                    data52 = data535 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data530, data531, data532, data533, data534, data52, 0}, null, null);
                return;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int data536 = DataCanbus.DATA[358];
                int data537 = DataCanbus.DATA[359];
                int data538 = DataCanbus.DATA[360];
                int data539 = DataCanbus.DATA[361];
                int data540 = DataCanbus.DATA[362];
                int data541 = DataCanbus.DATA[363];
                if ((data541 & 16) != 0) {
                    data51 = data541 & 239;
                } else {
                    data51 = data541 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data536, data537, data538, data539, data540, data51, 0}, null, null);
                return;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int data542 = DataCanbus.DATA[358];
                int data543 = DataCanbus.DATA[359];
                int data544 = DataCanbus.DATA[360];
                int data545 = DataCanbus.DATA[361];
                int data546 = DataCanbus.DATA[362];
                int data547 = DataCanbus.DATA[363];
                if ((data547 & 8) != 0) {
                    data50 = data547 & 247;
                } else {
                    data50 = data547 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data542, data543, data544, data545, data546, data50, 0}, null, null);
                return;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int data548 = DataCanbus.DATA[358];
                int data549 = DataCanbus.DATA[359];
                int data550 = DataCanbus.DATA[360];
                int data551 = DataCanbus.DATA[361];
                int data552 = DataCanbus.DATA[362];
                int data553 = DataCanbus.DATA[363];
                if ((data553 & 4) != 0) {
                    data49 = data553 & 251;
                } else {
                    data49 = data553 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data548, data549, data550, data551, data552, data49, 0}, null, null);
                return;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int data554 = DataCanbus.DATA[358];
                int data555 = DataCanbus.DATA[359];
                int data556 = DataCanbus.DATA[360];
                int data557 = DataCanbus.DATA[361];
                int data558 = DataCanbus.DATA[362];
                int data559 = DataCanbus.DATA[363];
                if ((data559 & 2) != 0) {
                    data48 = data559 & 253;
                } else {
                    data48 = data559 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data554, data555, data556, data557, data558, data48, 0}, null, null);
                return;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int data560 = DataCanbus.DATA[364];
                int data561 = DataCanbus.DATA[365];
                int data562 = DataCanbus.DATA[366];
                int data563 = DataCanbus.DATA[367];
                int data564 = DataCanbus.DATA[368];
                int data565 = DataCanbus.DATA[369];
                if ((data565 & 128) != 0) {
                    data47 = data565 & 127;
                } else {
                    data47 = data565 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data560, data561, data562, data563, data564, data47, 0}, null, null);
                return;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int data566 = DataCanbus.DATA[364];
                int data567 = DataCanbus.DATA[365];
                int data568 = DataCanbus.DATA[366];
                int data569 = DataCanbus.DATA[367];
                int data570 = DataCanbus.DATA[368];
                int data571 = DataCanbus.DATA[369];
                if ((data571 & 64) != 0) {
                    data46 = data571 & 191;
                } else {
                    data46 = data571 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data566, data567, data568, data569, data570, data46, 0}, null, null);
                return;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int data572 = DataCanbus.DATA[364];
                int data573 = DataCanbus.DATA[365];
                int data574 = DataCanbus.DATA[366];
                int data575 = DataCanbus.DATA[367];
                int data576 = DataCanbus.DATA[368];
                int data577 = DataCanbus.DATA[369];
                if ((data577 & 32) != 0) {
                    data45 = data577 & 223;
                } else {
                    data45 = data577 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data572, data573, data574, data575, data576, data45, 0}, null, null);
                return;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int data578 = DataCanbus.DATA[364];
                int data579 = DataCanbus.DATA[365];
                int data580 = DataCanbus.DATA[366];
                int data581 = DataCanbus.DATA[367];
                int data582 = DataCanbus.DATA[368];
                int data583 = DataCanbus.DATA[369];
                if ((data583 & 16) != 0) {
                    data44 = data583 & 239;
                } else {
                    data44 = data583 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data578, data579, data580, data581, data582, data44, 0}, null, null);
                return;
            case R.id.ctv_checkedtext27 /* 2131427825 */:
                int data584 = DataCanbus.DATA[364];
                int data585 = DataCanbus.DATA[365];
                int data586 = DataCanbus.DATA[366];
                int data587 = DataCanbus.DATA[367];
                int data588 = DataCanbus.DATA[368];
                int data589 = DataCanbus.DATA[369];
                if ((data589 & 8) != 0) {
                    data43 = data589 & 247;
                } else {
                    data43 = data589 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data584, data585, data586, data587, data588, data43, 0}, null, null);
                return;
            case R.id.ctv_checkedtext28 /* 2131427826 */:
                int data590 = DataCanbus.DATA[364];
                int data591 = DataCanbus.DATA[365];
                int data592 = DataCanbus.DATA[366];
                int data593 = DataCanbus.DATA[367];
                int data594 = DataCanbus.DATA[368];
                int data595 = DataCanbus.DATA[369];
                if ((data595 & 4) != 0) {
                    data42 = data595 & 251;
                } else {
                    data42 = data595 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data590, data591, data592, data593, data594, data42, 0}, null, null);
                return;
            case R.id.ctv_checkedtext29 /* 2131427827 */:
                int data596 = DataCanbus.DATA[364];
                int data597 = DataCanbus.DATA[365];
                int data598 = DataCanbus.DATA[366];
                int data599 = DataCanbus.DATA[367];
                int data600 = DataCanbus.DATA[368];
                int data601 = DataCanbus.DATA[369];
                if ((data601 & 2) != 0) {
                    data41 = data601 & 253;
                } else {
                    data41 = data601 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{6, data596, data597, data598, data599, data600, data41, 0}, null, null);
                return;
            case R.id.btn_minus31 /* 2131427828 */:
                int data602 = DataCanbus.DATA[370];
                int data603 = DataCanbus.DATA[371];
                int data604 = DataCanbus.DATA[372];
                int data605 = DataCanbus.DATA[373];
                int data606 = DataCanbus.DATA[374];
                int data607 = DataCanbus.DATA[375];
                int data608 = data602 - 1;
                if (data608 < 1) {
                    data608 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data608, data603, data604, data605, data606, data607, 0}, null, null);
                return;
            case R.id.btn_plus31 /* 2131427829 */:
                int data609 = DataCanbus.DATA[370];
                int data610 = DataCanbus.DATA[371];
                int data611 = DataCanbus.DATA[372];
                int data612 = DataCanbus.DATA[373];
                int data613 = DataCanbus.DATA[374];
                int data614 = DataCanbus.DATA[375];
                int data615 = data609 + 1;
                if (data615 > 3) {
                    data615 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data615, data610, data611, data612, data613, data614, 0}, null, null);
                return;
            case R.id.btn_minus32 /* 2131427830 */:
                int data616 = DataCanbus.DATA[370];
                int data617 = DataCanbus.DATA[371];
                int data618 = DataCanbus.DATA[372];
                int data619 = DataCanbus.DATA[373];
                int data620 = DataCanbus.DATA[374];
                int data621 = DataCanbus.DATA[375];
                int data622 = data617 - 1;
                if (data622 < 0) {
                    data622 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data616, data622, data618, data619, data620, data621, 0}, null, null);
                return;
            case R.id.btn_plus32 /* 2131427831 */:
                int data623 = DataCanbus.DATA[370];
                int data624 = DataCanbus.DATA[371];
                int data625 = DataCanbus.DATA[372];
                int data626 = DataCanbus.DATA[373];
                int data627 = DataCanbus.DATA[374];
                int data628 = DataCanbus.DATA[375];
                int data629 = data624 + 1;
                if (data629 > 23) {
                    data629 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data623, data629, data625, data626, data627, data628, 0}, null, null);
                return;
            case R.id.btn_minus33 /* 2131427832 */:
                int data630 = DataCanbus.DATA[370];
                int data631 = DataCanbus.DATA[371];
                int data632 = DataCanbus.DATA[372];
                int data633 = DataCanbus.DATA[373];
                int data634 = DataCanbus.DATA[374];
                int data635 = DataCanbus.DATA[375];
                int data636 = data632 - 1;
                if (data636 < 0) {
                    data636 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data630, data631, data636, data633, data634, data635, 0}, null, null);
                return;
            case R.id.btn_plus33 /* 2131427833 */:
                int data637 = DataCanbus.DATA[370];
                int data638 = DataCanbus.DATA[371];
                int data639 = DataCanbus.DATA[372];
                int data640 = DataCanbus.DATA[373];
                int data641 = DataCanbus.DATA[374];
                int data642 = DataCanbus.DATA[375];
                int data643 = data639 + 1;
                if (data643 > 59) {
                    data643 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data637, data638, data643, data640, data641, data642, 0}, null, null);
                return;
            case R.id.btn_minus34 /* 2131427834 */:
                int data644 = DataCanbus.DATA[370];
                int data645 = DataCanbus.DATA[371];
                int data646 = DataCanbus.DATA[372];
                int data647 = DataCanbus.DATA[373];
                int data648 = DataCanbus.DATA[374];
                int data649 = DataCanbus.DATA[375];
                int data650 = data647 - 1;
                if (data650 < 0) {
                    data650 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data644, data645, data646, data650, data648, data649, 0}, null, null);
                return;
            case R.id.btn_plus34 /* 2131427835 */:
                int data651 = DataCanbus.DATA[370];
                int data652 = DataCanbus.DATA[371];
                int data653 = DataCanbus.DATA[372];
                int data654 = DataCanbus.DATA[373];
                int data655 = DataCanbus.DATA[374];
                int data656 = DataCanbus.DATA[375];
                int data657 = data654 + 1;
                if (data657 > 23) {
                    data657 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data651, data652, data653, data657, data655, data656, 0}, null, null);
                return;
            case R.id.btn_minus35 /* 2131427836 */:
                int data658 = DataCanbus.DATA[370];
                int data659 = DataCanbus.DATA[371];
                int data660 = DataCanbus.DATA[372];
                int data661 = DataCanbus.DATA[373];
                int data662 = DataCanbus.DATA[374];
                int data663 = DataCanbus.DATA[375];
                int data664 = data662 - 1;
                if (data664 < 0) {
                    data664 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data658, data659, data660, data661, data664, data663, 0}, null, null);
                return;
            case R.id.btn_plus35 /* 2131427837 */:
                int data665 = DataCanbus.DATA[370];
                int data666 = DataCanbus.DATA[371];
                int data667 = DataCanbus.DATA[372];
                int data668 = DataCanbus.DATA[373];
                int data669 = DataCanbus.DATA[374];
                int data670 = DataCanbus.DATA[375];
                int data671 = data669 + 1;
                if (data671 > 59) {
                    data671 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data665, data666, data667, data668, data671, data670, 0}, null, null);
                return;
            case R.id.ctv_checkedtext30 /* 2131427838 */:
                int data672 = DataCanbus.DATA[370];
                int data673 = DataCanbus.DATA[371];
                int data674 = DataCanbus.DATA[372];
                int data675 = DataCanbus.DATA[373];
                int data676 = DataCanbus.DATA[374];
                int data677 = DataCanbus.DATA[375];
                if ((data677 & 128) != 0) {
                    data40 = data677 & 127;
                } else {
                    data40 = data677 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data672, data673, data674, data675, data676, data40, 0}, null, null);
                return;
            case R.id.ctv_checkedtext31 /* 2131427839 */:
                int data678 = DataCanbus.DATA[370];
                int data679 = DataCanbus.DATA[371];
                int data680 = DataCanbus.DATA[372];
                int data681 = DataCanbus.DATA[373];
                int data682 = DataCanbus.DATA[374];
                int data683 = DataCanbus.DATA[375];
                if ((data683 & 64) != 0) {
                    data39 = data683 & 191;
                } else {
                    data39 = data683 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data678, data679, data680, data681, data682, data39, 0}, null, null);
                return;
            case R.id.ctv_checkedtext32 /* 2131427840 */:
                int data684 = DataCanbus.DATA[370];
                int data685 = DataCanbus.DATA[371];
                int data686 = DataCanbus.DATA[372];
                int data687 = DataCanbus.DATA[373];
                int data688 = DataCanbus.DATA[374];
                int data689 = DataCanbus.DATA[375];
                if ((data689 & 32) != 0) {
                    data38 = data689 & 223;
                } else {
                    data38 = data689 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data684, data685, data686, data687, data688, data38, 0}, null, null);
                return;
            case R.id.ctv_checkedtext33 /* 2131427841 */:
                int data690 = DataCanbus.DATA[370];
                int data691 = DataCanbus.DATA[371];
                int data692 = DataCanbus.DATA[372];
                int data693 = DataCanbus.DATA[373];
                int data694 = DataCanbus.DATA[374];
                int data695 = DataCanbus.DATA[375];
                if ((data695 & 16) != 0) {
                    data37 = data695 & 239;
                } else {
                    data37 = data695 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data690, data691, data692, data693, data694, data37, 0}, null, null);
                return;
            case R.id.ctv_checkedtext34 /* 2131427842 */:
                int data696 = DataCanbus.DATA[370];
                int data697 = DataCanbus.DATA[371];
                int data698 = DataCanbus.DATA[372];
                int data699 = DataCanbus.DATA[373];
                int data700 = DataCanbus.DATA[374];
                int data701 = DataCanbus.DATA[375];
                if ((data701 & 8) != 0) {
                    data36 = data701 & 247;
                } else {
                    data36 = data701 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data696, data697, data698, data699, data700, data36, 0}, null, null);
                return;
            case R.id.ctv_checkedtext35 /* 2131427843 */:
                int data702 = DataCanbus.DATA[370];
                int data703 = DataCanbus.DATA[371];
                int data704 = DataCanbus.DATA[372];
                int data705 = DataCanbus.DATA[373];
                int data706 = DataCanbus.DATA[374];
                int data707 = DataCanbus.DATA[375];
                if ((data707 & 4) != 0) {
                    data35 = data707 & 251;
                } else {
                    data35 = data707 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data702, data703, data704, data705, data706, data35, 0}, null, null);
                return;
            case R.id.ctv_checkedtext36 /* 2131427844 */:
                int data708 = DataCanbus.DATA[370];
                int data709 = DataCanbus.DATA[371];
                int data710 = DataCanbus.DATA[372];
                int data711 = DataCanbus.DATA[373];
                int data712 = DataCanbus.DATA[374];
                int data713 = DataCanbus.DATA[375];
                if ((data713 & 2) != 0) {
                    data34 = data713 & 253;
                } else {
                    data34 = data713 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{7, data708, data709, data710, data711, data712, data34, 0}, null, null);
                return;
            case R.id.btn_minus37 /* 2131427845 */:
                int data714 = DataCanbus.DATA[376];
                int data715 = DataCanbus.DATA[377];
                int data716 = DataCanbus.DATA[378];
                int data717 = DataCanbus.DATA[379];
                int data718 = DataCanbus.DATA[380];
                int data719 = DataCanbus.DATA[381];
                int data720 = data714 - 1;
                if (data720 < 1) {
                    data720 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data720, data715, data716, data717, data718, data719, 0}, null, null);
                return;
            case R.id.btn_plus37 /* 2131427846 */:
                int data721 = DataCanbus.DATA[376];
                int data722 = DataCanbus.DATA[377];
                int data723 = DataCanbus.DATA[378];
                int data724 = DataCanbus.DATA[379];
                int data725 = DataCanbus.DATA[380];
                int data726 = DataCanbus.DATA[381];
                int data727 = data721 + 1;
                if (data727 > 3) {
                    data727 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data727, data722, data723, data724, data725, data726, 0}, null, null);
                return;
            case R.id.btn_minus38 /* 2131427847 */:
                int data728 = DataCanbus.DATA[376];
                int data729 = DataCanbus.DATA[377];
                int data730 = DataCanbus.DATA[378];
                int data731 = DataCanbus.DATA[379];
                int data732 = DataCanbus.DATA[380];
                int data733 = DataCanbus.DATA[381];
                int data734 = data729 - 1;
                if (data734 < 0) {
                    data734 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data728, data734, data730, data731, data732, data733, 0}, null, null);
                return;
            case R.id.btn_plus38 /* 2131427848 */:
                int data735 = DataCanbus.DATA[376];
                int data736 = DataCanbus.DATA[377];
                int data737 = DataCanbus.DATA[378];
                int data738 = DataCanbus.DATA[379];
                int data739 = DataCanbus.DATA[380];
                int data740 = DataCanbus.DATA[381];
                int data741 = data736 + 1;
                if (data741 > 23) {
                    data741 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data735, data741, data737, data738, data739, data740, 0}, null, null);
                return;
            case R.id.btn_minus39 /* 2131427849 */:
                int data742 = DataCanbus.DATA[376];
                int data743 = DataCanbus.DATA[377];
                int data744 = DataCanbus.DATA[378];
                int data745 = DataCanbus.DATA[379];
                int data746 = DataCanbus.DATA[380];
                int data747 = DataCanbus.DATA[381];
                int data748 = data744 - 1;
                if (data748 < 0) {
                    data748 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data742, data743, data748, data745, data746, data747, 0}, null, null);
                return;
            case R.id.btn_plus39 /* 2131427850 */:
                int data749 = DataCanbus.DATA[376];
                int data750 = DataCanbus.DATA[377];
                int data751 = DataCanbus.DATA[378];
                int data752 = DataCanbus.DATA[379];
                int data753 = DataCanbus.DATA[380];
                int data754 = DataCanbus.DATA[381];
                int data755 = data751 + 1;
                if (data755 > 59) {
                    data755 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data749, data750, data755, data752, data753, data754, 0}, null, null);
                return;
            case R.id.btn_minus40 /* 2131427851 */:
                int data756 = DataCanbus.DATA[376];
                int data757 = DataCanbus.DATA[377];
                int data758 = DataCanbus.DATA[378];
                int data759 = DataCanbus.DATA[379];
                int data760 = DataCanbus.DATA[380];
                int data761 = DataCanbus.DATA[381];
                int data762 = data759 - 1;
                if (data762 < 0) {
                    data762 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data756, data757, data758, data762, data760, data761, 0}, null, null);
                return;
            case R.id.btn_plus40 /* 2131427852 */:
                int data763 = DataCanbus.DATA[376];
                int data764 = DataCanbus.DATA[377];
                int data765 = DataCanbus.DATA[378];
                int data766 = DataCanbus.DATA[379];
                int data767 = DataCanbus.DATA[380];
                int data768 = DataCanbus.DATA[381];
                int data769 = data766 + 1;
                if (data769 > 23) {
                    data769 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data763, data764, data765, data769, data767, data768, 0}, null, null);
                return;
            case R.id.btn_minus41 /* 2131427853 */:
                int data770 = DataCanbus.DATA[376];
                int data771 = DataCanbus.DATA[377];
                int data772 = DataCanbus.DATA[378];
                int data773 = DataCanbus.DATA[379];
                int data774 = DataCanbus.DATA[380];
                int data775 = DataCanbus.DATA[381];
                int data776 = data774 - 1;
                if (data776 < 0) {
                    data776 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data770, data771, data772, data773, data776, data775, 0}, null, null);
                return;
            case R.id.btn_plus41 /* 2131427854 */:
                int data777 = DataCanbus.DATA[376];
                int data778 = DataCanbus.DATA[377];
                int data779 = DataCanbus.DATA[378];
                int data780 = DataCanbus.DATA[379];
                int data781 = DataCanbus.DATA[380];
                int data782 = DataCanbus.DATA[381];
                int data783 = data781 + 1;
                if (data783 > 59) {
                    data783 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data777, data778, data779, data780, data783, data782, 0}, null, null);
                break;
            case R.id.ctv_checkedtext37 /* 2131427855 */:
                break;
            case R.id.ctv_checkedtext38 /* 2131427856 */:
                int data784 = DataCanbus.DATA[376];
                int data785 = DataCanbus.DATA[377];
                int data786 = DataCanbus.DATA[378];
                int data787 = DataCanbus.DATA[379];
                int data788 = DataCanbus.DATA[380];
                int data789 = DataCanbus.DATA[381];
                if ((data789 & 64) != 0) {
                    data32 = data789 & 191;
                } else {
                    data32 = data789 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data784, data785, data786, data787, data788, data32, 0}, null, null);
                return;
            case R.id.ctv_checkedtext39 /* 2131427857 */:
                int data790 = DataCanbus.DATA[376];
                int data791 = DataCanbus.DATA[377];
                int data792 = DataCanbus.DATA[378];
                int data793 = DataCanbus.DATA[379];
                int data794 = DataCanbus.DATA[380];
                int data795 = DataCanbus.DATA[381];
                if ((data795 & 32) != 0) {
                    data31 = data795 & 223;
                } else {
                    data31 = data795 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data790, data791, data792, data793, data794, data31, 0}, null, null);
                return;
            case R.id.ctv_checkedtext40 /* 2131427858 */:
                int data796 = DataCanbus.DATA[376];
                int data797 = DataCanbus.DATA[377];
                int data798 = DataCanbus.DATA[378];
                int data799 = DataCanbus.DATA[379];
                int data800 = DataCanbus.DATA[380];
                int data801 = DataCanbus.DATA[381];
                if ((data801 & 16) != 0) {
                    data30 = data801 & 239;
                } else {
                    data30 = data801 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data796, data797, data798, data799, data800, data30, 0}, null, null);
                return;
            case R.id.ctv_checkedtext41 /* 2131427859 */:
                int data802 = DataCanbus.DATA[376];
                int data803 = DataCanbus.DATA[377];
                int data804 = DataCanbus.DATA[378];
                int data805 = DataCanbus.DATA[379];
                int data806 = DataCanbus.DATA[380];
                int data807 = DataCanbus.DATA[381];
                if ((data807 & 8) != 0) {
                    data29 = data807 & 247;
                } else {
                    data29 = data807 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data802, data803, data804, data805, data806, data29, 0}, null, null);
                return;
            case R.id.ctv_checkedtext42 /* 2131427860 */:
                int data808 = DataCanbus.DATA[376];
                int data809 = DataCanbus.DATA[377];
                int data810 = DataCanbus.DATA[378];
                int data811 = DataCanbus.DATA[379];
                int data812 = DataCanbus.DATA[380];
                int data813 = DataCanbus.DATA[381];
                if ((data813 & 4) != 0) {
                    data28 = data813 & 251;
                } else {
                    data28 = data813 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data808, data809, data810, data811, data812, data28, 0}, null, null);
                return;
            case R.id.ctv_checkedtext43 /* 2131427861 */:
                int data814 = DataCanbus.DATA[376];
                int data815 = DataCanbus.DATA[377];
                int data816 = DataCanbus.DATA[378];
                int data817 = DataCanbus.DATA[379];
                int data818 = DataCanbus.DATA[380];
                int data819 = DataCanbus.DATA[381];
                if ((data819 & 2) != 0) {
                    data27 = data819 & 253;
                } else {
                    data27 = data819 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{8, data814, data815, data816, data817, data818, data27, 0}, null, null);
                return;
            case R.id.btn_minus43 /* 2131427862 */:
                int data820 = DataCanbus.DATA[382];
                int data821 = DataCanbus.DATA[383];
                int data822 = DataCanbus.DATA[384];
                int data823 = DataCanbus.DATA[385];
                int data824 = DataCanbus.DATA[386];
                int data825 = DataCanbus.DATA[387];
                int data826 = data820 - 1;
                if (data826 < 1) {
                    data826 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data826, data821, data822, data823, data824, data825, 0}, null, null);
                return;
            case R.id.btn_plus43 /* 2131427863 */:
                int data827 = DataCanbus.DATA[382];
                int data828 = DataCanbus.DATA[383];
                int data829 = DataCanbus.DATA[384];
                int data830 = DataCanbus.DATA[385];
                int data831 = DataCanbus.DATA[386];
                int data832 = DataCanbus.DATA[387];
                int data833 = data827 + 1;
                if (data833 > 3) {
                    data833 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data833, data828, data829, data830, data831, data832, 0}, null, null);
                return;
            case R.id.btn_minus44 /* 2131427864 */:
                int data834 = DataCanbus.DATA[382];
                int data835 = DataCanbus.DATA[383];
                int data836 = DataCanbus.DATA[384];
                int data837 = DataCanbus.DATA[385];
                int data838 = DataCanbus.DATA[386];
                int data839 = DataCanbus.DATA[387];
                int data840 = data835 - 1;
                if (data840 < 0) {
                    data840 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data834, data840, data836, data837, data838, data839, 0}, null, null);
                return;
            case R.id.btn_plus44 /* 2131427865 */:
                int data841 = DataCanbus.DATA[382];
                int data842 = DataCanbus.DATA[383];
                int data843 = DataCanbus.DATA[384];
                int data844 = DataCanbus.DATA[385];
                int data845 = DataCanbus.DATA[386];
                int data846 = DataCanbus.DATA[387];
                int data847 = data842 + 1;
                if (data847 > 23) {
                    data847 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data841, data847, data843, data844, data845, data846, 0}, null, null);
                return;
            case R.id.btn_minus45 /* 2131427866 */:
                int data848 = DataCanbus.DATA[382];
                int data849 = DataCanbus.DATA[383];
                int data850 = DataCanbus.DATA[384];
                int data851 = DataCanbus.DATA[385];
                int data852 = DataCanbus.DATA[386];
                int data853 = DataCanbus.DATA[387];
                int data854 = data850 - 1;
                if (data854 < 0) {
                    data854 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data848, data849, data854, data851, data852, data853, 0}, null, null);
                return;
            case R.id.btn_plus45 /* 2131427868 */:
                int data855 = DataCanbus.DATA[382];
                int data856 = DataCanbus.DATA[383];
                int data857 = DataCanbus.DATA[384];
                int data858 = DataCanbus.DATA[385];
                int data859 = DataCanbus.DATA[386];
                int data860 = DataCanbus.DATA[387];
                int data861 = data857 + 1;
                if (data861 > 59) {
                    data861 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data855, data856, data861, data858, data859, data860, 0}, null, null);
                return;
            case R.id.btn_minus46 /* 2131427869 */:
                int data862 = DataCanbus.DATA[382];
                int data863 = DataCanbus.DATA[383];
                int data864 = DataCanbus.DATA[384];
                int data865 = DataCanbus.DATA[385];
                int data866 = DataCanbus.DATA[386];
                int data867 = DataCanbus.DATA[387];
                int data868 = data865 - 1;
                if (data868 < 0) {
                    data868 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data862, data863, data864, data868, data866, data867, 0}, null, null);
                return;
            case R.id.btn_plus46 /* 2131427871 */:
                int data869 = DataCanbus.DATA[382];
                int data870 = DataCanbus.DATA[383];
                int data871 = DataCanbus.DATA[384];
                int data872 = DataCanbus.DATA[385];
                int data873 = DataCanbus.DATA[386];
                int data874 = DataCanbus.DATA[387];
                int data875 = data872 + 1;
                if (data875 > 23) {
                    data875 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data869, data870, data871, data875, data873, data874, 0}, null, null);
                return;
            case R.id.btn_minus47 /* 2131427872 */:
                int data876 = DataCanbus.DATA[382];
                int data877 = DataCanbus.DATA[383];
                int data878 = DataCanbus.DATA[384];
                int data879 = DataCanbus.DATA[385];
                int data880 = DataCanbus.DATA[386];
                int data881 = DataCanbus.DATA[387];
                int data882 = data880 - 1;
                if (data882 < 0) {
                    data882 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data876, data877, data878, data879, data882, data881, 0}, null, null);
                return;
            case R.id.btn_plus47 /* 2131427874 */:
                int data883 = DataCanbus.DATA[382];
                int data884 = DataCanbus.DATA[383];
                int data885 = DataCanbus.DATA[384];
                int data886 = DataCanbus.DATA[385];
                int data887 = DataCanbus.DATA[386];
                int data888 = DataCanbus.DATA[387];
                int data889 = data887 + 1;
                if (data889 > 59) {
                    data889 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data883, data884, data885, data886, data889, data888, 0}, null, null);
                return;
            case R.id.ctv_checkedtext44 /* 2131427875 */:
                int data890 = DataCanbus.DATA[382];
                int data891 = DataCanbus.DATA[383];
                int data892 = DataCanbus.DATA[384];
                int data893 = DataCanbus.DATA[385];
                int data894 = DataCanbus.DATA[386];
                int data895 = DataCanbus.DATA[387];
                if ((data895 & 128) != 0) {
                    data26 = data895 & 127;
                } else {
                    data26 = data895 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data890, data891, data892, data893, data894, data26, 0}, null, null);
                return;
            case R.id.ctv_checkedtext45 /* 2131427876 */:
                int data896 = DataCanbus.DATA[382];
                int data897 = DataCanbus.DATA[383];
                int data898 = DataCanbus.DATA[384];
                int data899 = DataCanbus.DATA[385];
                int data900 = DataCanbus.DATA[386];
                int data901 = DataCanbus.DATA[387];
                if ((data901 & 64) != 0) {
                    data25 = data901 & 191;
                } else {
                    data25 = data901 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data896, data897, data898, data899, data900, data25, 0}, null, null);
                return;
            case R.id.ctv_checkedtext46 /* 2131427877 */:
                int data902 = DataCanbus.DATA[382];
                int data903 = DataCanbus.DATA[383];
                int data904 = DataCanbus.DATA[384];
                int data905 = DataCanbus.DATA[385];
                int data906 = DataCanbus.DATA[386];
                int data907 = DataCanbus.DATA[387];
                if ((data907 & 32) != 0) {
                    data24 = data907 & 223;
                } else {
                    data24 = data907 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data902, data903, data904, data905, data906, data24, 0}, null, null);
                return;
            case R.id.ctv_checkedtext47 /* 2131427878 */:
                int data908 = DataCanbus.DATA[382];
                int data909 = DataCanbus.DATA[383];
                int data910 = DataCanbus.DATA[384];
                int data911 = DataCanbus.DATA[385];
                int data912 = DataCanbus.DATA[386];
                int data913 = DataCanbus.DATA[387];
                if ((data913 & 16) != 0) {
                    data23 = data913 & 239;
                } else {
                    data23 = data913 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data908, data909, data910, data911, data912, data23, 0}, null, null);
                return;
            case R.id.ctv_checkedtext48 /* 2131427879 */:
                int data914 = DataCanbus.DATA[382];
                int data915 = DataCanbus.DATA[383];
                int data916 = DataCanbus.DATA[384];
                int data917 = DataCanbus.DATA[385];
                int data918 = DataCanbus.DATA[386];
                int data919 = DataCanbus.DATA[387];
                if ((data919 & 8) != 0) {
                    data22 = data919 & 247;
                } else {
                    data22 = data919 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data914, data915, data916, data917, data918, data22, 0}, null, null);
                return;
            case R.id.ctv_checkedtext49 /* 2131427880 */:
                int data920 = DataCanbus.DATA[382];
                int data921 = DataCanbus.DATA[383];
                int data922 = DataCanbus.DATA[384];
                int data923 = DataCanbus.DATA[385];
                int data924 = DataCanbus.DATA[386];
                int data925 = DataCanbus.DATA[387];
                if ((data925 & 4) != 0) {
                    data21 = data925 & 251;
                } else {
                    data21 = data925 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data920, data921, data922, data923, data924, data21, 0}, null, null);
                return;
            case R.id.ctv_checkedtext50 /* 2131427881 */:
                int data926 = DataCanbus.DATA[382];
                int data927 = DataCanbus.DATA[383];
                int data928 = DataCanbus.DATA[384];
                int data929 = DataCanbus.DATA[385];
                int data930 = DataCanbus.DATA[386];
                int data931 = DataCanbus.DATA[387];
                if ((data931 & 2) != 0) {
                    data20 = data931 & 253;
                } else {
                    data20 = data931 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{9, data926, data927, data928, data929, data930, data20, 0}, null, null);
                return;
            case R.id.btn_minus49 /* 2131427882 */:
                int data932 = DataCanbus.DATA[388];
                int data933 = DataCanbus.DATA[389];
                int data934 = DataCanbus.DATA[390];
                int data935 = DataCanbus.DATA[391];
                int data936 = DataCanbus.DATA[392];
                int data937 = DataCanbus.DATA[393];
                int data938 = data932 - 1;
                if (data938 < 1) {
                    data938 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data938, data933, data934, data935, data936, data937, 0}, null, null);
                return;
            case R.id.btn_plus49 /* 2131427884 */:
                int data939 = DataCanbus.DATA[388];
                int data940 = DataCanbus.DATA[389];
                int data941 = DataCanbus.DATA[390];
                int data942 = DataCanbus.DATA[391];
                int data943 = DataCanbus.DATA[392];
                int data944 = DataCanbus.DATA[393];
                int data945 = data939 + 1;
                if (data945 > 3) {
                    data945 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data945, data940, data941, data942, data943, data944, 0}, null, null);
                return;
            case R.id.btn_minus50 /* 2131427885 */:
                int data946 = DataCanbus.DATA[388];
                int data947 = DataCanbus.DATA[389];
                int data948 = DataCanbus.DATA[390];
                int data949 = DataCanbus.DATA[391];
                int data950 = DataCanbus.DATA[392];
                int data951 = DataCanbus.DATA[393];
                int data952 = data947 - 1;
                if (data952 < 0) {
                    data952 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data946, data952, data948, data949, data950, data951, 0}, null, null);
                return;
            case R.id.btn_plus50 /* 2131427887 */:
                int data953 = DataCanbus.DATA[388];
                int data954 = DataCanbus.DATA[389];
                int data955 = DataCanbus.DATA[390];
                int data956 = DataCanbus.DATA[391];
                int data957 = DataCanbus.DATA[392];
                int data958 = DataCanbus.DATA[393];
                int data959 = data954 + 1;
                if (data959 > 23) {
                    data959 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data953, data959, data955, data956, data957, data958, 0}, null, null);
                return;
            case R.id.btn_minus51 /* 2131427888 */:
                int data960 = DataCanbus.DATA[388];
                int data961 = DataCanbus.DATA[389];
                int data962 = DataCanbus.DATA[390];
                int data963 = DataCanbus.DATA[391];
                int data964 = DataCanbus.DATA[392];
                int data965 = DataCanbus.DATA[393];
                int data966 = data962 - 1;
                if (data966 < 0) {
                    data966 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data960, data961, data966, data963, data964, data965, 0}, null, null);
                return;
            case R.id.btn_plus51 /* 2131427890 */:
                int data967 = DataCanbus.DATA[388];
                int data968 = DataCanbus.DATA[389];
                int data969 = DataCanbus.DATA[390];
                int data970 = DataCanbus.DATA[391];
                int data971 = DataCanbus.DATA[392];
                int data972 = DataCanbus.DATA[393];
                int data973 = data969 + 1;
                if (data973 > 59) {
                    data973 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data967, data968, data973, data970, data971, data972, 0}, null, null);
                return;
            case R.id.btn_minus52 /* 2131427891 */:
                int data974 = DataCanbus.DATA[388];
                int data975 = DataCanbus.DATA[389];
                int data976 = DataCanbus.DATA[390];
                int data977 = DataCanbus.DATA[391];
                int data978 = DataCanbus.DATA[392];
                int data979 = DataCanbus.DATA[393];
                int data980 = data977 - 1;
                if (data980 < 0) {
                    data980 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data974, data975, data976, data980, data978, data979, 0}, null, null);
                return;
            case R.id.btn_plus52 /* 2131427893 */:
                int data981 = DataCanbus.DATA[388];
                int data982 = DataCanbus.DATA[389];
                int data983 = DataCanbus.DATA[390];
                int data984 = DataCanbus.DATA[391];
                int data985 = DataCanbus.DATA[392];
                int data986 = DataCanbus.DATA[393];
                int data987 = data984 + 1;
                if (data987 > 23) {
                    data987 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data981, data982, data983, data987, data985, data986, 0}, null, null);
                return;
            case R.id.btn_minus53 /* 2131427894 */:
                int data988 = DataCanbus.DATA[388];
                int data989 = DataCanbus.DATA[389];
                int data990 = DataCanbus.DATA[390];
                int data991 = DataCanbus.DATA[391];
                int data992 = DataCanbus.DATA[392];
                int data993 = DataCanbus.DATA[393];
                int data994 = data992 - 1;
                if (data994 < 0) {
                    data994 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data988, data989, data990, data991, data994, data993, 0}, null, null);
                return;
            case R.id.btn_plus53 /* 2131427896 */:
                int data995 = DataCanbus.DATA[388];
                int data996 = DataCanbus.DATA[389];
                int data997 = DataCanbus.DATA[390];
                int data998 = DataCanbus.DATA[391];
                int data999 = DataCanbus.DATA[392];
                int data1000 = DataCanbus.DATA[393];
                int data1001 = data999 + 1;
                if (data1001 > 59) {
                    data1001 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data995, data996, data997, data998, data1001, data1000, 0}, null, null);
                return;
            case R.id.ctv_checkedtext51 /* 2131427897 */:
                int data1002 = DataCanbus.DATA[388];
                int data1003 = DataCanbus.DATA[389];
                int data1004 = DataCanbus.DATA[390];
                int data1005 = DataCanbus.DATA[391];
                int data1006 = DataCanbus.DATA[392];
                int data1007 = DataCanbus.DATA[393];
                if ((data1007 & 128) != 0) {
                    data19 = data1007 & 127;
                } else {
                    data19 = data1007 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1002, data1003, data1004, data1005, data1006, data19, 0}, null, null);
                return;
            case R.id.ctv_checkedtext52 /* 2131427898 */:
                int data1008 = DataCanbus.DATA[388];
                int data1009 = DataCanbus.DATA[389];
                int data1010 = DataCanbus.DATA[390];
                int data1011 = DataCanbus.DATA[391];
                int data1012 = DataCanbus.DATA[392];
                int data1013 = DataCanbus.DATA[393];
                if ((data1013 & 64) != 0) {
                    data18 = data1013 & 191;
                } else {
                    data18 = data1013 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1008, data1009, data1010, data1011, data1012, data18, 0}, null, null);
                return;
            case R.id.ctv_checkedtext53 /* 2131427899 */:
                int data1014 = DataCanbus.DATA[388];
                int data1015 = DataCanbus.DATA[389];
                int data1016 = DataCanbus.DATA[390];
                int data1017 = DataCanbus.DATA[391];
                int data1018 = DataCanbus.DATA[392];
                int data1019 = DataCanbus.DATA[393];
                if ((data1019 & 32) != 0) {
                    data17 = data1019 & 223;
                } else {
                    data17 = data1019 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1014, data1015, data1016, data1017, data1018, data17, 0}, null, null);
                return;
            case R.id.ctv_checkedtext54 /* 2131427900 */:
                int data1020 = DataCanbus.DATA[388];
                int data1021 = DataCanbus.DATA[389];
                int data1022 = DataCanbus.DATA[390];
                int data1023 = DataCanbus.DATA[391];
                int data1024 = DataCanbus.DATA[392];
                int data1025 = DataCanbus.DATA[393];
                if ((data1025 & 16) != 0) {
                    data16 = data1025 & 239;
                } else {
                    data16 = data1025 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1020, data1021, data1022, data1023, data1024, data16, 0}, null, null);
                return;
            case R.id.ctv_checkedtext55 /* 2131427901 */:
                int data1026 = DataCanbus.DATA[388];
                int data1027 = DataCanbus.DATA[389];
                int data1028 = DataCanbus.DATA[390];
                int data1029 = DataCanbus.DATA[391];
                int data1030 = DataCanbus.DATA[392];
                int data1031 = DataCanbus.DATA[393];
                if ((data1031 & 8) != 0) {
                    data15 = data1031 & 247;
                } else {
                    data15 = data1031 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1026, data1027, data1028, data1029, data1030, data15, 0}, null, null);
                return;
            case R.id.ctv_checkedtext56 /* 2131427902 */:
                int data1032 = DataCanbus.DATA[388];
                int data1033 = DataCanbus.DATA[389];
                int data1034 = DataCanbus.DATA[390];
                int data1035 = DataCanbus.DATA[391];
                int data1036 = DataCanbus.DATA[392];
                int data1037 = DataCanbus.DATA[393];
                if ((data1037 & 4) != 0) {
                    data14 = data1037 & 251;
                } else {
                    data14 = data1037 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1032, data1033, data1034, data1035, data1036, data14, 0}, null, null);
                return;
            case R.id.ctv_checkedtext57 /* 2131427903 */:
                int data1038 = DataCanbus.DATA[388];
                int data1039 = DataCanbus.DATA[389];
                int data1040 = DataCanbus.DATA[390];
                int data1041 = DataCanbus.DATA[391];
                int data1042 = DataCanbus.DATA[392];
                int data1043 = DataCanbus.DATA[393];
                if ((data1043 & 2) != 0) {
                    data13 = data1043 & 253;
                } else {
                    data13 = data1043 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{10, data1038, data1039, data1040, data1041, data1042, data13, 0}, null, null);
                return;
            case R.id.btn_minus55 /* 2131427904 */:
                int data1044 = DataCanbus.DATA[394];
                int data1045 = DataCanbus.DATA[395];
                int data1046 = DataCanbus.DATA[396];
                int data1047 = DataCanbus.DATA[397];
                int data1048 = DataCanbus.DATA[398];
                int data1049 = DataCanbus.DATA[399];
                int data1050 = data1044 - 1;
                if (data1050 < 1) {
                    data1050 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data1050, data1045, data1046, data1047, data1048, data1049, 0}, null, null);
                return;
            case R.id.btn_plus55 /* 2131427906 */:
                int data1051 = DataCanbus.DATA[394];
                int data1052 = DataCanbus.DATA[395];
                int data1053 = DataCanbus.DATA[396];
                int data1054 = DataCanbus.DATA[397];
                int data1055 = DataCanbus.DATA[398];
                int data1056 = DataCanbus.DATA[399];
                int data1057 = data1051 + 1;
                if (data1057 > 3) {
                    data1057 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1057, data1052, data1053, data1054, data1055, data1056, 0}, null, null);
                return;
            case R.id.btn_minus56 /* 2131427907 */:
                int data1058 = DataCanbus.DATA[394];
                int data1059 = DataCanbus.DATA[395];
                int data1060 = DataCanbus.DATA[396];
                int data1061 = DataCanbus.DATA[397];
                int data1062 = DataCanbus.DATA[398];
                int data1063 = DataCanbus.DATA[399];
                int data1064 = data1059 - 1;
                if (data1064 < 0) {
                    data1064 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1058, data1064, data1060, data1061, data1062, data1063, 0}, null, null);
                return;
            case R.id.btn_plus56 /* 2131427909 */:
                int data1065 = DataCanbus.DATA[394];
                int data1066 = DataCanbus.DATA[395];
                int data1067 = DataCanbus.DATA[396];
                int data1068 = DataCanbus.DATA[397];
                int data1069 = DataCanbus.DATA[398];
                int data1070 = DataCanbus.DATA[399];
                int data1071 = data1066 + 1;
                if (data1071 > 23) {
                    data1071 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1065, data1071, data1067, data1068, data1069, data1070, 0}, null, null);
                return;
            case R.id.btn_minus57 /* 2131427910 */:
                int data1072 = DataCanbus.DATA[394];
                int data1073 = DataCanbus.DATA[395];
                int data1074 = DataCanbus.DATA[396];
                int data1075 = DataCanbus.DATA[397];
                int data1076 = DataCanbus.DATA[398];
                int data1077 = DataCanbus.DATA[399];
                int data1078 = data1074 - 1;
                if (data1078 < 0) {
                    data1078 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1072, data1073, data1078, data1075, data1076, data1077, 0}, null, null);
                return;
            case R.id.btn_plus57 /* 2131427912 */:
                int data1079 = DataCanbus.DATA[394];
                int data1080 = DataCanbus.DATA[395];
                int data1081 = DataCanbus.DATA[396];
                int data1082 = DataCanbus.DATA[397];
                int data1083 = DataCanbus.DATA[398];
                int data1084 = DataCanbus.DATA[399];
                int data1085 = data1081 + 1;
                if (data1085 > 59) {
                    data1085 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1079, data1080, data1085, data1082, data1083, data1084, 0}, null, null);
                return;
            case R.id.btn_minus58 /* 2131427913 */:
                int data1086 = DataCanbus.DATA[394];
                int data1087 = DataCanbus.DATA[395];
                int data1088 = DataCanbus.DATA[396];
                int data1089 = DataCanbus.DATA[397];
                int data1090 = DataCanbus.DATA[398];
                int data1091 = DataCanbus.DATA[399];
                int data1092 = data1089 - 1;
                if (data1092 < 0) {
                    data1092 = 23;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1086, data1087, data1088, data1092, data1090, data1091, 0}, null, null);
                return;
            case R.id.btn_plus58 /* 2131427915 */:
                int data1093 = DataCanbus.DATA[394];
                int data1094 = DataCanbus.DATA[395];
                int data1095 = DataCanbus.DATA[396];
                int data1096 = DataCanbus.DATA[397];
                int data1097 = DataCanbus.DATA[398];
                int data1098 = DataCanbus.DATA[399];
                int data1099 = data1096 + 1;
                if (data1099 > 23) {
                    data1099 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1093, data1094, data1095, data1099, data1097, data1098, 0}, null, null);
                return;
            case R.id.btn_minus59 /* 2131427916 */:
                int data1100 = DataCanbus.DATA[394];
                int data1101 = DataCanbus.DATA[395];
                int data1102 = DataCanbus.DATA[396];
                int data1103 = DataCanbus.DATA[397];
                int data1104 = DataCanbus.DATA[398];
                int data1105 = DataCanbus.DATA[399];
                int data1106 = data1104 - 1;
                if (data1106 < 0) {
                    data1106 = 59;
                }
                DataCanbus.PROXY.cmd(124, new int[]{5, data1100, data1101, data1102, data1103, data1106, data1105, 0}, null, null);
                return;
            case R.id.btn_plus59 /* 2131427918 */:
                int data1107 = DataCanbus.DATA[394];
                int data1108 = DataCanbus.DATA[395];
                int data1109 = DataCanbus.DATA[396];
                int data1110 = DataCanbus.DATA[397];
                int data1111 = DataCanbus.DATA[398];
                int data1112 = DataCanbus.DATA[399];
                int data1113 = data1111 + 1;
                if (data1113 > 59) {
                    data1113 = 0;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1107, data1108, data1109, data1110, data1113, data1112, 0}, null, null);
                return;
            case R.id.ctv_checkedtext58 /* 2131427919 */:
                int data1114 = DataCanbus.DATA[394];
                int data1115 = DataCanbus.DATA[395];
                int data1116 = DataCanbus.DATA[396];
                int data1117 = DataCanbus.DATA[397];
                int data1118 = DataCanbus.DATA[398];
                int data1119 = DataCanbus.DATA[399];
                if ((data1119 & 128) != 0) {
                    data12 = data1119 & 127;
                } else {
                    data12 = data1119 | 128;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1114, data1115, data1116, data1117, data1118, data12, 0}, null, null);
                return;
            case R.id.ctv_checkedtext59 /* 2131427920 */:
                int data1120 = DataCanbus.DATA[394];
                int data1121 = DataCanbus.DATA[395];
                int data1122 = DataCanbus.DATA[396];
                int data1123 = DataCanbus.DATA[397];
                int data1124 = DataCanbus.DATA[398];
                int data1125 = DataCanbus.DATA[399];
                if ((data1125 & 64) != 0) {
                    data11 = data1125 & 191;
                } else {
                    data11 = data1125 | 64;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1120, data1121, data1122, data1123, data1124, data11, 0}, null, null);
                return;
            case R.id.ctv_checkedtext60 /* 2131427921 */:
                int data1126 = DataCanbus.DATA[394];
                int data1127 = DataCanbus.DATA[395];
                int data1128 = DataCanbus.DATA[396];
                int data1129 = DataCanbus.DATA[397];
                int data1130 = DataCanbus.DATA[398];
                int data1131 = DataCanbus.DATA[399];
                if ((data1131 & 32) != 0) {
                    data10 = data1131 & 223;
                } else {
                    data10 = data1131 | 32;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1126, data1127, data1128, data1129, data1130, data10, 0}, null, null);
                return;
            case R.id.ctv_checkedtext61 /* 2131427922 */:
                int data1132 = DataCanbus.DATA[394];
                int data1133 = DataCanbus.DATA[395];
                int data1134 = DataCanbus.DATA[396];
                int data1135 = DataCanbus.DATA[397];
                int data1136 = DataCanbus.DATA[398];
                int data1137 = DataCanbus.DATA[399];
                if ((data1137 & 16) != 0) {
                    data9 = data1137 & 239;
                } else {
                    data9 = data1137 | 16;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1132, data1133, data1134, data1135, data1136, data9, 0}, null, null);
                return;
            case R.id.ctv_checkedtext62 /* 2131427923 */:
                int data1138 = DataCanbus.DATA[394];
                int data1139 = DataCanbus.DATA[395];
                int data1140 = DataCanbus.DATA[396];
                int data1141 = DataCanbus.DATA[397];
                int data1142 = DataCanbus.DATA[398];
                int data1143 = DataCanbus.DATA[399];
                if ((data1143 & 8) != 0) {
                    data8 = data1143 & 247;
                } else {
                    data8 = data1143 | 8;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1138, data1139, data1140, data1141, data1142, data8, 0}, null, null);
                return;
            case R.id.ctv_checkedtext63 /* 2131427924 */:
                int data1144 = DataCanbus.DATA[394];
                int data1145 = DataCanbus.DATA[395];
                int data1146 = DataCanbus.DATA[396];
                int data1147 = DataCanbus.DATA[397];
                int data1148 = DataCanbus.DATA[398];
                int data1149 = DataCanbus.DATA[399];
                if ((data1149 & 4) != 0) {
                    data7 = data1149 & 251;
                } else {
                    data7 = data1149 | 4;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1144, data1145, data1146, data1147, data1148, data7, 0}, null, null);
                return;
            case R.id.ctv_checkedtext64 /* 2131427925 */:
                int data1150 = DataCanbus.DATA[394];
                int data1151 = DataCanbus.DATA[395];
                int data1152 = DataCanbus.DATA[396];
                int data1153 = DataCanbus.DATA[397];
                int data1154 = DataCanbus.DATA[398];
                int data1155 = DataCanbus.DATA[399];
                if ((data1155 & 2) != 0) {
                    data6 = data1155 & 253;
                } else {
                    data6 = data1155 | 2;
                }
                DataCanbus.PROXY.cmd(124, new int[]{11, data1150, data1151, data1152, data1153, data1154, data6, 0}, null, null);
                return;
            case R.id.btn_minus61 /* 2131427926 */:
                int data1156 = DataCanbus.DATA[400];
                int data1157 = DataCanbus.DATA[401];
                int data1158 = DataCanbus.DATA[402];
                if (data1156 > 0) {
                    data1156--;
                }
                DataCanbus.PROXY.cmd(124, new int[]{12, data1156, data1157, data1158, 0, 0, 0, 0}, null, null);
                return;
            case R.id.btn_plus61 /* 2131427928 */:
                int data1159 = DataCanbus.DATA[400];
                int data1160 = DataCanbus.DATA[401];
                int data1161 = DataCanbus.DATA[402];
                if (data1159 < 255) {
                    data1159++;
                }
                DataCanbus.PROXY.cmd(124, new int[]{12, data1159, data1160, data1161, 0, 0, 0, 0}, null, null);
                return;
            case R.id.btn_minus62 /* 2131427929 */:
                int data1162 = DataCanbus.DATA[400];
                int data1163 = DataCanbus.DATA[401];
                int data1164 = DataCanbus.DATA[402];
                int data1165 = data1163 - 1;
                if (data1165 < 1) {
                    data1165 = 3;
                }
                DataCanbus.PROXY.cmd(124, new int[]{12, data1162, data1165, data1164, 0, 0, 0, 0}, null, null);
                return;
            case R.id.btn_plus62 /* 2131427931 */:
                int data1166 = DataCanbus.DATA[400];
                int data1167 = DataCanbus.DATA[401];
                int data1168 = DataCanbus.DATA[402];
                int data1169 = data1167 + 1;
                if (data1169 > 3) {
                    data1169 = 1;
                }
                DataCanbus.PROXY.cmd(124, new int[]{12, data1166, data1169, data1168, 0, 0, 0, 0}, null, null);
                return;
            default:
                return;
        }
        int data1170 = DataCanbus.DATA[376];
        int data1171 = DataCanbus.DATA[377];
        int data1172 = DataCanbus.DATA[378];
        int data1173 = DataCanbus.DATA[379];
        int data1174 = DataCanbus.DATA[380];
        int data1175 = DataCanbus.DATA[381];
        if ((data1175 & 128) != 0) {
            data33 = data1175 & 127;
        } else {
            data33 = data1175 | 128;
        }
        DataCanbus.PROXY.cmd(124, new int[]{8, data1170, data1171, data1172, data1173, data1174, data33, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(97, new int[]{52, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[344].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[345].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[346].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[347].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[348].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[349].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[350].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[351].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[352].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[353].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[354].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[355].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[356].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[357].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[358].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[359].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[361].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[362].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[363].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[364].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[365].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[366].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[367].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[368].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[369].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[370].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[372].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[373].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[374].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[375].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[376].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[377].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[378].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[379].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[380].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[381].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[382].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[383].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[384].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[385].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[386].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[387].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[388].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[389].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[390].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[391].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[392].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[393].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[394].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[395].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[396].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[397].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[398].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[399].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[400].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[401].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[402].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[344].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[345].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[346].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[347].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[348].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[349].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[350].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[351].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[352].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[353].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[354].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[355].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[356].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[357].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[358].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[359].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[361].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[362].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[363].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[364].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[365].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[366].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[367].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[368].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[369].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[370].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[372].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[373].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[374].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[375].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[376].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[377].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[378].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[379].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[380].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[381].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[382].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[383].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[384].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[385].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[386].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[387].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[388].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[389].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[390].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[391].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[392].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[393].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[394].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[395].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[396].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[397].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[398].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[399].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[400].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[401].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[402].removeNotify(this.mNotifyCanbus);
    }
}
