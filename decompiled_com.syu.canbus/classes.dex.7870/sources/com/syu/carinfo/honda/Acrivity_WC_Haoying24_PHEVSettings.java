package com.syu.carinfo.honda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Acrivity_WC_Haoying24_PHEVSettings extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.Acrivity_WC_Haoying24_PHEVSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 340:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext65), value == 1);
                    break;
                case 341:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 342:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 343:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 344:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 345:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext2), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext3), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext4), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext5), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext6), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext7), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext8), ((value >> 5) & 1) == 1);
                    break;
                case 346:
                    switch (value) {
                        case 0:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text7)).setText("任何地点");
                            break;
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text7)).setText("在家");
                            break;
                    }
                    break;
                case 347:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext67), value == 1);
                    break;
                case 348:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 349:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 350:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 351:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text12)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 352:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext9), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext10), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext11), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext12), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext13), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext14), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext15), ((value >> 5) & 1) == 1);
                    break;
                case 353:
                    switch (value) {
                        case 0:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text14)).setText("任何地点");
                            break;
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text14)).setText("在家");
                            break;
                    }
                    break;
                case 354:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("80%");
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("85%");
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("90%");
                            break;
                        case 4:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("95%");
                            break;
                        case 5:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("100%");
                            break;
                        default:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text15)).setText("----");
                            break;
                    }
                    break;
                case 355:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("80%");
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("85%");
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("90%");
                            break;
                        case 4:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("95%");
                            break;
                        case 5:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("100%");
                            break;
                        default:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text16)).setText("----");
                            break;
                    }
                    break;
                case 356:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text17)).setText("----");
                            break;
                    }
                    break;
                case 357:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText(R.string.klc_air_high);
                            break;
                        default:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text18)).setText("----");
                            break;
                    }
                    break;
                case 358:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext69), value == 1);
                    break;
                case 359:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text20)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 360:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text21)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 361:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text22)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 362:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text23)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 363:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext16), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext17), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext18), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext19), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext20), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext21), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext22), ((value >> 5) & 1) == 1);
                    break;
                case 364:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext71), value == 1);
                    break;
                case 365:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text26)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 366:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text27)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 367:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text28)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 368:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text29)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 369:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext23), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext24), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext25), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext26), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext27), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext28), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext29), ((value >> 5) & 1) == 1);
                    break;
                case 370:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext73), value == 1);
                    break;
                case 371:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text32)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 372:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text33)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 373:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text34)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 374:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text35)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 375:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext30), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext31), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext32), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext33), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext34), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext35), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext36), ((value >> 5) & 1) == 1);
                    break;
                case 376:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext75), value == 1);
                    break;
                case 377:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text38)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 378:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text39)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 379:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text40)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 380:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text41)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 381:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext37), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext38), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext39), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext40), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext41), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext42), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext43), ((value >> 5) & 1) == 1);
                    break;
                case 382:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext77), value == 1);
                    break;
                case 383:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text44)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 384:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text45)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 385:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text46)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 386:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text47)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 387:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext44), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext45), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext46), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext47), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext48), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext49), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext50), ((value >> 5) & 1) == 1);
                    break;
                case 388:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext79), value == 1);
                    break;
                case 389:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text50)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 390:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text51)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 391:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text52)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 392:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text53)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 393:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext51), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext52), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext53), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext54), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext55), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext56), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext57), ((value >> 5) & 1) == 1);
                    break;
                case 394:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext81), value == 1);
                    break;
                case 395:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text56)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 396:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text57)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 397:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text58)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 398:
                    ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text59)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 399:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext58), ((value >> 6) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext59), ((value >> 0) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext60), ((value >> 1) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext61), ((value >> 2) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext62), ((value >> 3) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext63), ((value >> 4) & 1) == 1);
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext64), ((value >> 5) & 1) == 1);
                    break;
                case 400:
                    switch (value) {
                        case 254:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText("LO");
                            break;
                        case 255:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText("HI");
                            break;
                        default:
                            int value2 = value * 5;
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text61)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                            break;
                    }
                    break;
                case 401:
                    switch (value) {
                        case 1:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("10min");
                            break;
                        case 2:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("20min");
                            break;
                        case 3:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("30min");
                            break;
                        default:
                            ((TextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.tv_text62)).setText("----");
                            break;
                    }
                    break;
                case 402:
                    Acrivity_WC_Haoying24_PHEVSettings.this.setCheck((CheckedTextView) Acrivity_WC_Haoying24_PHEVSettings.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0321_wc_haoying24_phevsettings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext65), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext66), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext67), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext68), this);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext69), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext70), this);
        setSelfClick((Button) findViewById(R.id.btn_minus20), this);
        setSelfClick((Button) findViewById(R.id.btn_plus20), this);
        setSelfClick((Button) findViewById(R.id.btn_minus21), this);
        setSelfClick((Button) findViewById(R.id.btn_plus21), this);
        setSelfClick((Button) findViewById(R.id.btn_minus22), this);
        setSelfClick((Button) findViewById(R.id.btn_plus22), this);
        setSelfClick((Button) findViewById(R.id.btn_minus23), this);
        setSelfClick((Button) findViewById(R.id.btn_plus23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext71), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext72), this);
        setSelfClick((Button) findViewById(R.id.btn_minus26), this);
        setSelfClick((Button) findViewById(R.id.btn_plus26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus27), this);
        setSelfClick((Button) findViewById(R.id.btn_plus27), this);
        setSelfClick((Button) findViewById(R.id.btn_minus28), this);
        setSelfClick((Button) findViewById(R.id.btn_plus28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus29), this);
        setSelfClick((Button) findViewById(R.id.btn_plus29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext73), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext74), this);
        setSelfClick((Button) findViewById(R.id.btn_minus32), this);
        setSelfClick((Button) findViewById(R.id.btn_plus32), this);
        setSelfClick((Button) findViewById(R.id.btn_minus33), this);
        setSelfClick((Button) findViewById(R.id.btn_plus33), this);
        setSelfClick((Button) findViewById(R.id.btn_minus34), this);
        setSelfClick((Button) findViewById(R.id.btn_plus34), this);
        setSelfClick((Button) findViewById(R.id.btn_minus35), this);
        setSelfClick((Button) findViewById(R.id.btn_plus35), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext75), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext76), this);
        setSelfClick((Button) findViewById(R.id.btn_minus38), this);
        setSelfClick((Button) findViewById(R.id.btn_plus38), this);
        setSelfClick((Button) findViewById(R.id.btn_minus39), this);
        setSelfClick((Button) findViewById(R.id.btn_plus39), this);
        setSelfClick((Button) findViewById(R.id.btn_minus40), this);
        setSelfClick((Button) findViewById(R.id.btn_plus40), this);
        setSelfClick((Button) findViewById(R.id.btn_minus41), this);
        setSelfClick((Button) findViewById(R.id.btn_plus41), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext77), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext78), this);
        setSelfClick((Button) findViewById(R.id.btn_minus44), this);
        setSelfClick((Button) findViewById(R.id.btn_plus44), this);
        setSelfClick((Button) findViewById(R.id.btn_minus45), this);
        setSelfClick((Button) findViewById(R.id.btn_plus45), this);
        setSelfClick((Button) findViewById(R.id.btn_minus46), this);
        setSelfClick((Button) findViewById(R.id.btn_plus46), this);
        setSelfClick((Button) findViewById(R.id.btn_minus47), this);
        setSelfClick((Button) findViewById(R.id.btn_plus47), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext79), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext80), this);
        setSelfClick((Button) findViewById(R.id.btn_minus50), this);
        setSelfClick((Button) findViewById(R.id.btn_plus50), this);
        setSelfClick((Button) findViewById(R.id.btn_minus51), this);
        setSelfClick((Button) findViewById(R.id.btn_plus51), this);
        setSelfClick((Button) findViewById(R.id.btn_minus52), this);
        setSelfClick((Button) findViewById(R.id.btn_plus52), this);
        setSelfClick((Button) findViewById(R.id.btn_minus53), this);
        setSelfClick((Button) findViewById(R.id.btn_plus53), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext81), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext82), this);
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

    protected void dialog(String stringId, final int cmd0, final int cmd1, final int cmd2, final int cmd3, final int cmd4, final int cmd5) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.delete)) + " " + stringId + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Acrivity_WC_Haoying24_PHEVSettings.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd0;
                final int i2 = cmd1;
                final int i3 = cmd2;
                final int i4 = cmd3;
                final int i5 = cmd4;
                final int i6 = cmd5;
                new Thread(new Runnable() { // from class: com.syu.carinfo.honda.Acrivity_WC_Haoying24_PHEVSettings.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(109, new int[]{i, i2, i3, i4, i5, i6}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.honda.Acrivity_WC_Haoying24_PHEVSettings.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data3;
        int data1;
        int data2;
        int data6;
        int data7;
        int data8;
        int data9;
        int data10;
        int data11;
        int data12;
        int data4;
        int data13;
        int data14;
        int data15;
        int data16;
        int data17;
        int data18;
        int data19;
        int data5;
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
        int data69;
        int data70;
        int data71;
        int data72;
        int data73;
        int data74;
        int data75;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427421 */:
                int data76 = DataCanbus.DATA[340];
                int data77 = DataCanbus.DATA[341];
                int data78 = DataCanbus.DATA[342];
                int data79 = DataCanbus.DATA[343];
                int data80 = DataCanbus.DATA[344];
                int data81 = DataCanbus.DATA[345];
                int data82 = DataCanbus.DATA[346];
                int data83 = data77 - 1;
                if (data83 < 0) {
                    data83 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data82 << 2) & 4) | (data76 & 1), ((data83 << 3) & 248) | (data78 & 7), ((data79 << 3) & 248) | (data80 & 7), data81}, null, null);
                return;
            case R.id.btn_plus2 /* 2131427423 */:
                int data84 = DataCanbus.DATA[340];
                int data85 = DataCanbus.DATA[341];
                int data86 = DataCanbus.DATA[342];
                int data87 = DataCanbus.DATA[343];
                int data88 = DataCanbus.DATA[344];
                int data89 = DataCanbus.DATA[345];
                int data90 = DataCanbus.DATA[346];
                int data91 = data85 + 1;
                if (data91 > 23) {
                    data91 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data90 << 2) & 4) | (data84 & 1), ((data91 << 3) & 248) | (data86 & 7), ((data87 << 3) & 248) | (data88 & 7), data89}, null, null);
                return;
            case R.id.btn_minus3 /* 2131427425 */:
                int data92 = DataCanbus.DATA[340];
                int data93 = DataCanbus.DATA[341];
                int data94 = DataCanbus.DATA[342];
                int data95 = DataCanbus.DATA[343];
                int data96 = DataCanbus.DATA[344];
                int data97 = DataCanbus.DATA[345];
                int data98 = DataCanbus.DATA[346];
                int data99 = data94 - 1;
                if (data99 < 0) {
                    data99 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data98 << 2) & 4) | (data92 & 1), ((data93 << 3) & 248) | (data99 & 7), ((data95 << 3) & 248) | (data96 & 7), data97}, null, null);
                return;
            case R.id.btn_plus3 /* 2131427427 */:
                int data100 = DataCanbus.DATA[340];
                int data101 = DataCanbus.DATA[341];
                int data102 = DataCanbus.DATA[342];
                int data103 = DataCanbus.DATA[343];
                int data104 = DataCanbus.DATA[344];
                int data105 = DataCanbus.DATA[345];
                int data106 = DataCanbus.DATA[346];
                int data107 = data102 + 1;
                if (data107 > 59) {
                    data107 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data106 << 2) & 4) | (data100 & 1), ((data101 << 3) & 248) | (data107 & 7), ((data103 << 3) & 248) | (data104 & 7), data105}, null, null);
                return;
            case R.id.btn_plus4 /* 2131427428 */:
                int data108 = DataCanbus.DATA[340];
                int data109 = DataCanbus.DATA[341];
                int data110 = DataCanbus.DATA[342];
                int data111 = DataCanbus.DATA[343];
                int data112 = DataCanbus.DATA[344];
                int data113 = DataCanbus.DATA[345];
                int data114 = DataCanbus.DATA[346];
                int data115 = data111 + 1;
                if (data115 > 23) {
                    data115 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data114 << 2) & 4) | (data108 & 1), ((data109 << 3) & 248) | (data110 & 7), ((data115 << 3) & 248) | (data112 & 7), data113}, null, null);
                return;
            case R.id.btn_plus5 /* 2131427429 */:
                int data116 = DataCanbus.DATA[340];
                int data117 = DataCanbus.DATA[341];
                int data118 = DataCanbus.DATA[342];
                int data119 = DataCanbus.DATA[343];
                int data120 = DataCanbus.DATA[344];
                int data121 = DataCanbus.DATA[345];
                int data122 = DataCanbus.DATA[346];
                int data123 = data120 + 1;
                if (data123 > 59) {
                    data123 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data122 << 2) & 4) | (data116 & 1), ((data117 << 3) & 248) | (data118 & 7), ((data119 << 3) & 248) | (data123 & 7), data121}, null, null);
                return;
            case R.id.btn_plus7 /* 2131427431 */:
                int data124 = DataCanbus.DATA[340];
                int data125 = DataCanbus.DATA[341];
                int data126 = DataCanbus.DATA[342];
                int data127 = DataCanbus.DATA[343];
                int data128 = DataCanbus.DATA[344];
                int data129 = DataCanbus.DATA[345];
                int data130 = DataCanbus.DATA[346] + 1;
                if (data130 > 1) {
                    data130 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data130 << 2) & 4) | (data124 & 1), ((data125 << 3) & 248) | (data126 & 7), ((data127 << 3) & 248) | (data128 & 7), data129}, null, null);
                return;
            case R.id.btn_plus9 /* 2131427433 */:
                int data131 = DataCanbus.DATA[347];
                int data132 = DataCanbus.DATA[348];
                int data133 = DataCanbus.DATA[349];
                int data134 = DataCanbus.DATA[350];
                int data135 = DataCanbus.DATA[351];
                int data136 = DataCanbus.DATA[352];
                int data137 = DataCanbus.DATA[353];
                int data138 = data132 + 1;
                if (data138 > 23) {
                    data138 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 2, ((data137 << 2) & 4) | (data131 & 1), ((data138 << 3) & 248) | (data133 & 7), ((data134 << 3) & 248) | (data135 & 7), data136}, null, null);
                return;
            case R.id.btn_plus10 /* 2131427434 */:
                int data139 = DataCanbus.DATA[347];
                int data140 = DataCanbus.DATA[348];
                int data141 = DataCanbus.DATA[349];
                int data142 = DataCanbus.DATA[350];
                int data143 = DataCanbus.DATA[351];
                int data144 = DataCanbus.DATA[352];
                int data145 = DataCanbus.DATA[353];
                int data146 = data141 + 1;
                if (data146 > 59) {
                    data146 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data145 << 2) & 4) | (data139 & 1), ((data140 << 3) & 248) | (data146 & 7), ((data142 << 3) & 248) | (data143 & 7), data144}, null, null);
                return;
            case R.id.btn_plus11 /* 2131427435 */:
                int data147 = DataCanbus.DATA[347];
                int data148 = DataCanbus.DATA[348];
                int data149 = DataCanbus.DATA[349];
                int data150 = DataCanbus.DATA[350];
                int data151 = DataCanbus.DATA[351];
                int data152 = DataCanbus.DATA[352];
                int data153 = DataCanbus.DATA[353];
                int data154 = data150 + 1;
                if (data154 > 23) {
                    data154 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data153 << 2) & 4) | (data147 & 1), ((data148 << 3) & 248) | (data149 & 7), ((data154 << 3) & 248) | (data151 & 7), data152}, null, null);
                return;
            case R.id.btn_plus12 /* 2131427436 */:
                int data155 = DataCanbus.DATA[347];
                int data156 = DataCanbus.DATA[348];
                int data157 = DataCanbus.DATA[349];
                int data158 = DataCanbus.DATA[350];
                int data159 = DataCanbus.DATA[351];
                int data160 = DataCanbus.DATA[352];
                int data161 = DataCanbus.DATA[353];
                int data162 = data159 + 1;
                if (data162 > 59) {
                    data162 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data161 << 2) & 4) | (data155 & 1), ((data156 << 3) & 248) | (data157 & 7), ((data158 << 3) & 248) | (data162 & 7), data160}, null, null);
                return;
            case R.id.btn_plus14 /* 2131427438 */:
                int data163 = DataCanbus.DATA[347];
                int data164 = DataCanbus.DATA[348];
                int data165 = DataCanbus.DATA[349];
                int data166 = DataCanbus.DATA[350];
                int data167 = DataCanbus.DATA[351];
                int data168 = DataCanbus.DATA[352];
                int data169 = DataCanbus.DATA[353] + 1;
                if (data169 > 1) {
                    data169 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data169 << 2) & 4) | (data163 & 1), ((data164 << 3) & 248) | (data165 & 7), ((data166 << 3) & 248) | (data167 & 7), data168}, null, null);
                return;
            case R.id.btn_plus15 /* 2131427439 */:
                int data170 = DataCanbus.DATA[354] + 1;
                if (data170 > 5) {
                    data170 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{1, data170}, null, null);
                return;
            case R.id.btn_plus16 /* 2131427440 */:
                int data171 = DataCanbus.DATA[355] + 1;
                if (data171 > 5) {
                    data171 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{2, data171}, null, null);
                return;
            case R.id.btn_minus4 /* 2131427473 */:
                int data172 = DataCanbus.DATA[340];
                int data173 = DataCanbus.DATA[341];
                int data174 = DataCanbus.DATA[342];
                int data175 = DataCanbus.DATA[343];
                int data176 = DataCanbus.DATA[344];
                int data177 = DataCanbus.DATA[345];
                int data178 = DataCanbus.DATA[346];
                int data179 = data175 - 1;
                if (data179 < 0) {
                    data179 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data178 << 2) & 4) | (data172 & 1), ((data173 << 3) & 248) | (data174 & 7), ((data179 << 3) & 248) | (data176 & 7), data177}, null, null);
                return;
            case R.id.btn_minus5 /* 2131427474 */:
                int data180 = DataCanbus.DATA[340];
                int data181 = DataCanbus.DATA[341];
                int data182 = DataCanbus.DATA[342];
                int data183 = DataCanbus.DATA[343];
                int data184 = DataCanbus.DATA[344];
                int data185 = DataCanbus.DATA[345];
                int data186 = DataCanbus.DATA[346];
                int data187 = data184 - 1;
                if (data187 < 0) {
                    data187 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data186 << 2) & 4) | (data180 & 1), ((data181 << 3) & 248) | (data182 & 7), ((data183 << 3) & 248) | (data187 & 7), data185}, null, null);
                return;
            case R.id.btn_minus7 /* 2131427478 */:
                int data188 = DataCanbus.DATA[340];
                int data189 = DataCanbus.DATA[341];
                int data190 = DataCanbus.DATA[342];
                int data191 = DataCanbus.DATA[343];
                int data192 = DataCanbus.DATA[344];
                int data193 = DataCanbus.DATA[345];
                int data194 = DataCanbus.DATA[346] - 1;
                if (data194 < 0) {
                    data194 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data194 << 2) & 4) | (data188 & 1), ((data189 << 3) & 248) | (data190 & 7), ((data191 << 3) & 248) | (data192 & 7), data193}, null, null);
                return;
            case R.id.btn_minus9 /* 2131427482 */:
                int data195 = DataCanbus.DATA[347];
                int data196 = DataCanbus.DATA[348];
                int data197 = DataCanbus.DATA[349];
                int data198 = DataCanbus.DATA[350];
                int data199 = DataCanbus.DATA[351];
                int data200 = DataCanbus.DATA[352];
                int data201 = DataCanbus.DATA[353];
                int data202 = data196 - 1;
                if (data202 < 0) {
                    data202 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data201 << 2) & 4) | (data195 & 1), ((data202 << 3) & 248) | (data197 & 7), ((data198 << 3) & 248) | (data199 & 7), data200}, null, null);
                return;
            case R.id.btn_minus10 /* 2131427484 */:
                int data203 = DataCanbus.DATA[347];
                int data204 = DataCanbus.DATA[348];
                int data205 = DataCanbus.DATA[349];
                int data206 = DataCanbus.DATA[350];
                int data207 = DataCanbus.DATA[351];
                int data208 = DataCanbus.DATA[352];
                int data209 = DataCanbus.DATA[353];
                int data210 = data205 - 1;
                if (data210 < 0) {
                    data210 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data209 << 2) & 4) | (data203 & 1), ((data204 << 3) & 248) | (data210 & 7), ((data206 << 3) & 248) | (data207 & 7), data208}, null, null);
                return;
            case R.id.btn_minus11 /* 2131427486 */:
                int data211 = DataCanbus.DATA[347];
                int data212 = DataCanbus.DATA[348];
                int data213 = DataCanbus.DATA[349];
                int data214 = DataCanbus.DATA[350];
                int data215 = DataCanbus.DATA[351];
                int data216 = DataCanbus.DATA[352];
                int data217 = DataCanbus.DATA[353];
                int data218 = data214 - 1;
                if (data218 < 0) {
                    data218 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 2, ((data217 << 2) & 4) | (data211 & 1), ((data212 << 3) & 248) | (data213 & 7), ((data218 << 3) & 248) | (data215 & 7), data216}, null, null);
                return;
            case R.id.btn_minus12 /* 2131427488 */:
                int data219 = DataCanbus.DATA[347];
                int data220 = DataCanbus.DATA[348];
                int data221 = DataCanbus.DATA[349];
                int data222 = DataCanbus.DATA[350];
                int data223 = DataCanbus.DATA[351];
                int data224 = DataCanbus.DATA[352];
                int data225 = DataCanbus.DATA[353];
                int data226 = data223 - 1;
                if (data226 < 0) {
                    data226 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data225 << 2) & 4) | (data219 & 1), ((data220 << 3) & 248) | (data221 & 7), ((data222 << 3) & 248) | (data226 & 7), data224}, null, null);
                return;
            case R.id.btn_minus14 /* 2131427492 */:
                int data227 = DataCanbus.DATA[347];
                int data228 = DataCanbus.DATA[348];
                int data229 = DataCanbus.DATA[349];
                int data230 = DataCanbus.DATA[350];
                int data231 = DataCanbus.DATA[351];
                int data232 = DataCanbus.DATA[352];
                int data233 = DataCanbus.DATA[353] - 1;
                if (data233 < 0) {
                    data233 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data233 << 2) & 4) | (data227 & 1), ((data228 << 3) & 248) | (data229 & 7), ((data230 << 3) & 248) | (data231 & 7), data232}, null, null);
                return;
            case R.id.btn_minus15 /* 2131427494 */:
                int data234 = DataCanbus.DATA[354] - 1;
                if (data234 < 1) {
                    data234 = 5;
                }
                DataCanbus.PROXY.cmd(113, new int[]{1, data234}, null, null);
                return;
            case R.id.btn_minus16 /* 2131427496 */:
                int data235 = DataCanbus.DATA[355] - 1;
                if (data235 < 1) {
                    data235 = 5;
                }
                DataCanbus.PROXY.cmd(113, new int[]{2, data235}, null, null);
                return;
            case R.id.btn_minus17 /* 2131427498 */:
                int data236 = DataCanbus.DATA[356] - 1;
                if (data236 < 1) {
                    data236 = 3;
                }
                DataCanbus.PROXY.cmd(113, new int[]{3, data236}, null, null);
                return;
            case R.id.btn_plus17 /* 2131427500 */:
                int data237 = DataCanbus.DATA[356] + 1;
                if (data237 > 3) {
                    data237 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{3, data237}, null, null);
                return;
            case R.id.btn_minus18 /* 2131427501 */:
                int data238 = DataCanbus.DATA[357] - 1;
                if (data238 < 1) {
                    data238 = 3;
                }
                DataCanbus.PROXY.cmd(113, new int[]{4, data238}, null, null);
                return;
            case R.id.btn_plus18 /* 2131427503 */:
                int data239 = DataCanbus.DATA[357] + 1;
                if (data239 > 3) {
                    data239 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{4, data239}, null, null);
                return;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int data240 = DataCanbus.DATA[402];
                if (data240 == 1) {
                    data3 = 0;
                } else {
                    data3 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{7, data3}, null, null);
                return;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int data241 = DataCanbus.DATA[340];
                int data242 = DataCanbus.DATA[341];
                int data243 = DataCanbus.DATA[342];
                int data244 = DataCanbus.DATA[343];
                int data245 = DataCanbus.DATA[344];
                int data246 = DataCanbus.DATA[345];
                int data247 = DataCanbus.DATA[346];
                if ((data246 & 2) != 0) {
                    data72 = data246 & 253;
                } else {
                    data72 = data246 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data247 << 2) & 4) | (data241 & 1), ((data242 << 3) & 248) | (data243 & 7), ((data244 << 3) & 248) | (data245 & 7), data72}, null, null);
                return;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int data248 = DataCanbus.DATA[340];
                int data249 = DataCanbus.DATA[341];
                int data250 = DataCanbus.DATA[342];
                int data251 = DataCanbus.DATA[343];
                int data252 = DataCanbus.DATA[344];
                int data253 = DataCanbus.DATA[345];
                int data254 = DataCanbus.DATA[346];
                if ((data253 & 4) != 0) {
                    data71 = data253 & 251;
                } else {
                    data71 = data253 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data254 << 2) & 4) | (data248 & 1), ((data249 << 3) & 248) | (data250 & 7), ((data251 << 3) & 248) | (data252 & 7), data71}, null, null);
                return;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int data255 = DataCanbus.DATA[340];
                int data256 = DataCanbus.DATA[341];
                int data257 = DataCanbus.DATA[342];
                int data258 = DataCanbus.DATA[343];
                int data259 = DataCanbus.DATA[344];
                int data260 = DataCanbus.DATA[345];
                int data261 = DataCanbus.DATA[346];
                if ((data260 & 64) != 0) {
                    data74 = data260 & 191;
                } else {
                    data74 = data260 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data261 << 2) & 4) | (data255 & 1), ((data256 << 3) & 248) | (data257 & 7), ((data258 << 3) & 248) | (data259 & 7), data74}, null, null);
                return;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int data262 = DataCanbus.DATA[340];
                int data263 = DataCanbus.DATA[341];
                int data264 = DataCanbus.DATA[342];
                int data265 = DataCanbus.DATA[343];
                int data266 = DataCanbus.DATA[344];
                int data267 = DataCanbus.DATA[345];
                int data268 = DataCanbus.DATA[346];
                if ((data267 & 1) != 0) {
                    data73 = data267 & 254;
                } else {
                    data73 = data267 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data268 << 2) & 4) | (data262 & 1), ((data263 << 3) & 248) | (data264 & 7), ((data265 << 3) & 248) | (data266 & 7), data73}, null, null);
                return;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int data269 = DataCanbus.DATA[340];
                int data270 = DataCanbus.DATA[341];
                int data271 = DataCanbus.DATA[342];
                int data272 = DataCanbus.DATA[343];
                int data273 = DataCanbus.DATA[344];
                int data274 = DataCanbus.DATA[345];
                int data275 = DataCanbus.DATA[346];
                if ((data274 & 8) != 0) {
                    data70 = data274 & 247;
                } else {
                    data70 = data274 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data275 << 2) & 4) | (data269 & 1), ((data270 << 3) & 248) | (data271 & 7), ((data272 << 3) & 248) | (data273 & 7), data70}, null, null);
                return;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int data276 = DataCanbus.DATA[340];
                int data277 = DataCanbus.DATA[341];
                int data278 = DataCanbus.DATA[342];
                int data279 = DataCanbus.DATA[343];
                int data280 = DataCanbus.DATA[344];
                int data281 = DataCanbus.DATA[345];
                int data282 = DataCanbus.DATA[346];
                if ((data281 & 16) != 0) {
                    data69 = data281 & 239;
                } else {
                    data69 = data281 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data282 << 2) & 4) | (data276 & 1), ((data277 << 3) & 248) | (data278 & 7), ((data279 << 3) & 248) | (data280 & 7), data69}, null, null);
                return;
            case R.id.btn_minus20 /* 2131427579 */:
                int data283 = DataCanbus.DATA[358];
                int data284 = DataCanbus.DATA[359];
                int data285 = DataCanbus.DATA[360];
                int data286 = DataCanbus.DATA[361];
                int data287 = DataCanbus.DATA[362];
                int data288 = DataCanbus.DATA[363];
                int data289 = data284 - 1;
                if (data289 < 0) {
                    data289 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data283 & 1, ((data289 << 3) & 248) | (data285 & 7), ((data286 << 3) & 248) | (data287 & 7), data288}, null, null);
                return;
            case R.id.btn_plus20 /* 2131427581 */:
                int data290 = DataCanbus.DATA[358];
                int data291 = DataCanbus.DATA[359];
                int data292 = DataCanbus.DATA[360];
                int data293 = DataCanbus.DATA[361];
                int data294 = DataCanbus.DATA[362];
                int data295 = DataCanbus.DATA[363];
                int data296 = data291 + 1;
                if (data296 > 23) {
                    data296 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data290 & 1, ((data296 << 3) & 248) | (data292 & 7), ((data293 << 3) & 248) | (data294 & 7), data295}, null, null);
                return;
            case R.id.btn_minus21 /* 2131427582 */:
                int data297 = DataCanbus.DATA[358];
                int data298 = DataCanbus.DATA[359];
                int data299 = DataCanbus.DATA[360];
                int data300 = DataCanbus.DATA[361];
                int data301 = DataCanbus.DATA[362];
                int data302 = DataCanbus.DATA[363];
                int data303 = data299 - 1;
                if (data303 < 0) {
                    data303 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data297 & 1, ((data298 << 3) & 248) | (data303 & 7), ((data300 << 3) & 248) | (data301 & 7), data302}, null, null);
                return;
            case R.id.btn_plus21 /* 2131427584 */:
                int data304 = DataCanbus.DATA[358];
                int data305 = DataCanbus.DATA[359];
                int data306 = DataCanbus.DATA[360];
                int data307 = DataCanbus.DATA[361];
                int data308 = DataCanbus.DATA[362];
                int data309 = DataCanbus.DATA[363];
                int data310 = data306 + 1;
                if (data310 > 59) {
                    data310 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data304 & 1, ((data305 << 3) & 248) | (data310 & 7), ((data307 << 3) & 248) | (data308 & 7), data309}, null, null);
                return;
            case R.id.btn_minus22 /* 2131427585 */:
                int data311 = DataCanbus.DATA[358];
                int data312 = DataCanbus.DATA[359];
                int data313 = DataCanbus.DATA[360];
                int data314 = DataCanbus.DATA[361];
                int data315 = DataCanbus.DATA[362];
                int data316 = DataCanbus.DATA[363];
                int data317 = data314 - 1;
                if (data317 < 0) {
                    data317 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data311 & 1, ((data312 << 3) & 248) | (data313 & 7), ((data317 << 3) & 248) | (data315 & 7), data316}, null, null);
                return;
            case R.id.btn_plus22 /* 2131427587 */:
                int data318 = DataCanbus.DATA[358];
                int data319 = DataCanbus.DATA[359];
                int data320 = DataCanbus.DATA[360];
                int data321 = DataCanbus.DATA[361];
                int data322 = DataCanbus.DATA[362];
                int data323 = DataCanbus.DATA[363];
                int data324 = data321 + 1;
                if (data324 > 23) {
                    data324 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data318 & 1, ((data319 << 3) & 248) | (data320 & 7), ((data324 << 3) & 248) | (data322 & 7), data323}, null, null);
                return;
            case R.id.btn_minus23 /* 2131427589 */:
                int data325 = DataCanbus.DATA[358];
                int data326 = DataCanbus.DATA[359];
                int data327 = DataCanbus.DATA[360];
                int data328 = DataCanbus.DATA[361];
                int data329 = DataCanbus.DATA[362];
                int data330 = DataCanbus.DATA[363];
                int data331 = data329 - 1;
                if (data331 < 0) {
                    data331 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data325 & 1, ((data326 << 3) & 248) | (data327 & 7), ((data328 << 3) & 248) | (data331 & 7), data330}, null, null);
                return;
            case R.id.btn_plus23 /* 2131427591 */:
                int data332 = DataCanbus.DATA[358];
                int data333 = DataCanbus.DATA[359];
                int data334 = DataCanbus.DATA[360];
                int data335 = DataCanbus.DATA[361];
                int data336 = DataCanbus.DATA[362];
                int data337 = DataCanbus.DATA[363];
                int data338 = data336 + 1;
                if (data338 > 59) {
                    data338 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data332 & 1, ((data333 << 3) & 248) | (data334 & 7), ((data335 << 3) & 248) | (data338 & 7), data337}, null, null);
                return;
            case R.id.btn_minus26 /* 2131427599 */:
                int data339 = DataCanbus.DATA[364];
                int data340 = DataCanbus.DATA[365];
                int data341 = DataCanbus.DATA[366];
                int data342 = DataCanbus.DATA[367];
                int data343 = DataCanbus.DATA[368];
                int data344 = DataCanbus.DATA[369];
                int data345 = data340 - 1;
                if (data345 < 0) {
                    data345 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data339 & 1, ((data345 << 3) & 248) | (data341 & 7), ((data342 << 3) & 248) | (data343 & 7), data344}, null, null);
                return;
            case R.id.btn_plus26 /* 2131427601 */:
                int data346 = DataCanbus.DATA[364];
                int data347 = DataCanbus.DATA[365];
                int data348 = DataCanbus.DATA[366];
                int data349 = DataCanbus.DATA[367];
                int data350 = DataCanbus.DATA[368];
                int data351 = DataCanbus.DATA[369];
                int data352 = data347 + 1;
                if (data352 > 23) {
                    data352 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data346 & 1, ((data352 << 3) & 248) | (data348 & 7), ((data349 << 3) & 248) | (data350 & 7), data351}, null, null);
                return;
            case R.id.btn_minus27 /* 2131427602 */:
                int data353 = DataCanbus.DATA[364];
                int data354 = DataCanbus.DATA[365];
                int data355 = DataCanbus.DATA[366];
                int data356 = DataCanbus.DATA[367];
                int data357 = DataCanbus.DATA[368];
                int data358 = DataCanbus.DATA[369];
                int data359 = data355 - 1;
                if (data359 < 0) {
                    data359 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data353 & 1, ((data354 << 3) & 248) | (data359 & 7), ((data356 << 3) & 248) | (data357 & 7), data358}, null, null);
                return;
            case R.id.btn_plus27 /* 2131427604 */:
                int data360 = DataCanbus.DATA[364];
                int data361 = DataCanbus.DATA[365];
                int data362 = DataCanbus.DATA[366];
                int data363 = DataCanbus.DATA[367];
                int data364 = DataCanbus.DATA[368];
                int data365 = DataCanbus.DATA[369];
                int data366 = data362 + 1;
                if (data366 > 59) {
                    data366 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data360 & 1, ((data361 << 3) & 248) | (data366 & 7), ((data363 << 3) & 248) | (data364 & 7), data365}, null, null);
                return;
            case R.id.btn_minus28 /* 2131427605 */:
                int data367 = DataCanbus.DATA[364];
                int data368 = DataCanbus.DATA[365];
                int data369 = DataCanbus.DATA[366];
                int data370 = DataCanbus.DATA[367];
                int data371 = DataCanbus.DATA[368];
                int data372 = DataCanbus.DATA[369];
                int data373 = data370 - 1;
                if (data373 < 0) {
                    data373 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data367 & 1, ((data368 << 3) & 248) | (data369 & 7), ((data373 << 3) & 248) | (data371 & 7), data372}, null, null);
                return;
            case R.id.btn_plus28 /* 2131427607 */:
                int data374 = DataCanbus.DATA[364];
                int data375 = DataCanbus.DATA[365];
                int data376 = DataCanbus.DATA[366];
                int data377 = DataCanbus.DATA[367];
                int data378 = DataCanbus.DATA[368];
                int data379 = DataCanbus.DATA[369];
                int data380 = data377 + 1;
                if (data380 > 23) {
                    data380 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data374 & 1, ((data375 << 3) & 248) | (data376 & 7), ((data380 << 3) & 248) | (data378 & 7), data379}, null, null);
                return;
            case R.id.btn_minus29 /* 2131427609 */:
                int data381 = DataCanbus.DATA[364];
                int data382 = DataCanbus.DATA[365];
                int data383 = DataCanbus.DATA[366];
                int data384 = DataCanbus.DATA[367];
                int data385 = DataCanbus.DATA[368];
                int data386 = DataCanbus.DATA[369];
                int data387 = data385 - 1;
                if (data387 < 0) {
                    data387 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data381 & 1, ((data382 << 3) & 248) | (data383 & 7), ((data384 << 3) & 248) | (data387 & 7), data386}, null, null);
                return;
            case R.id.btn_plus29 /* 2131427611 */:
                int data388 = DataCanbus.DATA[364];
                int data389 = DataCanbus.DATA[365];
                int data390 = DataCanbus.DATA[366];
                int data391 = DataCanbus.DATA[367];
                int data392 = DataCanbus.DATA[368];
                int data393 = DataCanbus.DATA[369];
                int data394 = data392 + 1;
                if (data394 > 59) {
                    data394 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data388 & 1, ((data389 << 3) & 248) | (data390 & 7), ((data391 << 3) & 248) | (data394 & 7), data393}, null, null);
                return;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int data395 = DataCanbus.DATA[340];
                int data396 = DataCanbus.DATA[341];
                int data397 = DataCanbus.DATA[342];
                int data398 = DataCanbus.DATA[343];
                int data399 = DataCanbus.DATA[344];
                int data400 = DataCanbus.DATA[345];
                int data401 = DataCanbus.DATA[346];
                if ((data400 & 32) != 0) {
                    data68 = data400 & 223;
                } else {
                    data68 = data400 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data401 << 2) & 4) | (data395 & 1), ((data396 << 3) & 248) | (data397 & 7), ((data398 << 3) & 248) | (data399 & 7), data68}, null, null);
                return;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int data402 = DataCanbus.DATA[347];
                int data403 = DataCanbus.DATA[348];
                int data404 = DataCanbus.DATA[349];
                int data405 = DataCanbus.DATA[350];
                int data406 = DataCanbus.DATA[351];
                int data407 = DataCanbus.DATA[352];
                int data408 = DataCanbus.DATA[353];
                if ((data407 & 64) != 0) {
                    data66 = data407 & 191;
                } else {
                    data66 = data407 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data408 << 2) & 4) | (data402 & 1), ((data403 << 3) & 248) | (data404 & 7), ((data405 << 3) & 248) | (data406 & 7), data66}, null, null);
                return;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                int data409 = DataCanbus.DATA[347];
                int data410 = DataCanbus.DATA[348];
                int data411 = DataCanbus.DATA[349];
                int data412 = DataCanbus.DATA[350];
                int data413 = DataCanbus.DATA[351];
                int data414 = DataCanbus.DATA[352];
                int data415 = DataCanbus.DATA[353];
                if ((data414 & 1) != 0) {
                    data65 = data414 & 254;
                } else {
                    data65 = data414 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data415 << 2) & 4) | (data409 & 1), ((data410 << 3) & 248) | (data411 & 7), ((data412 << 3) & 248) | (data413 & 7), data65}, null, null);
                return;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int data416 = DataCanbus.DATA[347];
                int data417 = DataCanbus.DATA[348];
                int data418 = DataCanbus.DATA[349];
                int data419 = DataCanbus.DATA[350];
                int data420 = DataCanbus.DATA[351];
                int data421 = DataCanbus.DATA[352];
                int data422 = DataCanbus.DATA[353];
                if ((data421 & 2) != 0) {
                    data64 = data421 & 253;
                } else {
                    data64 = data421 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data422 << 2) & 4) | (data416 & 1), ((data417 << 3) & 248) | (data418 & 7), ((data419 << 3) & 248) | (data420 & 7), data64}, null, null);
                return;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int data423 = DataCanbus.DATA[347];
                int data424 = DataCanbus.DATA[348];
                int data425 = DataCanbus.DATA[349];
                int data426 = DataCanbus.DATA[350];
                int data427 = DataCanbus.DATA[351];
                int data428 = DataCanbus.DATA[352];
                int data429 = DataCanbus.DATA[353];
                if ((data428 & 4) != 0) {
                    data63 = data428 & 251;
                } else {
                    data63 = data428 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data429 << 2) & 4) | (data423 & 1), ((data424 << 3) & 248) | (data425 & 7), ((data426 << 3) & 248) | (data427 & 7), data63}, null, null);
                return;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                int data430 = DataCanbus.DATA[347];
                int data431 = DataCanbus.DATA[348];
                int data432 = DataCanbus.DATA[349];
                int data433 = DataCanbus.DATA[350];
                int data434 = DataCanbus.DATA[351];
                int data435 = DataCanbus.DATA[352];
                int data436 = DataCanbus.DATA[353];
                if ((data435 & 8) != 0) {
                    data62 = data435 & 247;
                } else {
                    data62 = data435 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data436 << 2) & 4) | (data430 & 1), ((data431 << 3) & 248) | (data432 & 7), ((data433 << 3) & 248) | (data434 & 7), data62}, null, null);
                return;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                int data437 = DataCanbus.DATA[347];
                int data438 = DataCanbus.DATA[348];
                int data439 = DataCanbus.DATA[349];
                int data440 = DataCanbus.DATA[350];
                int data441 = DataCanbus.DATA[351];
                int data442 = DataCanbus.DATA[352];
                int data443 = DataCanbus.DATA[353];
                if ((data442 & 16) != 0) {
                    data61 = data442 & 239;
                } else {
                    data61 = data442 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data443 << 2) & 4) | (data437 & 1), ((data438 << 3) & 248) | (data439 & 7), ((data440 << 3) & 248) | (data441 & 7), data61}, null, null);
                return;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                int data444 = DataCanbus.DATA[347];
                int data445 = DataCanbus.DATA[348];
                int data446 = DataCanbus.DATA[349];
                int data447 = DataCanbus.DATA[350];
                int data448 = DataCanbus.DATA[351];
                int data449 = DataCanbus.DATA[352];
                int data450 = DataCanbus.DATA[353];
                if ((data449 & 32) != 0) {
                    data60 = data449 & 223;
                } else {
                    data60 = data449 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data450 << 2) & 4) | (data444 & 1), ((data445 << 3) & 248) | (data446 & 7), ((data447 << 3) & 248) | (data448 & 7), data60}, null, null);
                return;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int data451 = DataCanbus.DATA[358];
                int data452 = DataCanbus.DATA[359];
                int data453 = DataCanbus.DATA[360];
                int data454 = DataCanbus.DATA[361];
                int data455 = DataCanbus.DATA[362];
                int data456 = DataCanbus.DATA[363];
                if ((data456 & 128) != 0) {
                    data58 = data456 & 191;
                } else {
                    data58 = data456 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data451 & 1, ((data452 << 3) & 248) | (data453 & 7), ((data454 << 3) & 248) | (data455 & 7), data58}, null, null);
                return;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                int data457 = DataCanbus.DATA[358];
                int data458 = DataCanbus.DATA[359];
                int data459 = DataCanbus.DATA[360];
                int data460 = DataCanbus.DATA[361];
                int data461 = DataCanbus.DATA[362];
                int data462 = DataCanbus.DATA[363];
                if ((data462 & 1) != 0) {
                    data57 = data462 & 254;
                } else {
                    data57 = data462 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data457 & 1, ((data458 << 3) & 248) | (data459 & 7), ((data460 << 3) & 248) | (data461 & 7), data57}, null, null);
                return;
            case R.id.ctv_checkedtext26 /* 2131427715 */:
                int data463 = DataCanbus.DATA[364];
                int data464 = DataCanbus.DATA[365];
                int data465 = DataCanbus.DATA[366];
                int data466 = DataCanbus.DATA[367];
                int data467 = DataCanbus.DATA[368];
                int data468 = DataCanbus.DATA[369];
                if ((data468 & 4) != 0) {
                    data47 = data468 & 251;
                } else {
                    data47 = data468 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data463 & 1, ((data464 << 3) & 248) | (data465 & 7), ((data466 << 3) & 248) | (data467 & 7), data47}, null, null);
                return;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                int data469 = DataCanbus.DATA[358];
                int data470 = DataCanbus.DATA[359];
                int data471 = DataCanbus.DATA[360];
                int data472 = DataCanbus.DATA[361];
                int data473 = DataCanbus.DATA[362];
                int data474 = DataCanbus.DATA[363];
                if ((data474 & 2) != 0) {
                    data56 = data474 & 253;
                } else {
                    data56 = data474 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data469 & 1, ((data470 << 3) & 248) | (data471 & 7), ((data472 << 3) & 248) | (data473 & 7), data56}, null, null);
                return;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                int data475 = DataCanbus.DATA[358];
                int data476 = DataCanbus.DATA[359];
                int data477 = DataCanbus.DATA[360];
                int data478 = DataCanbus.DATA[361];
                int data479 = DataCanbus.DATA[362];
                int data480 = DataCanbus.DATA[363];
                if ((data480 & 4) != 0) {
                    data55 = data480 & 251;
                } else {
                    data55 = data480 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data475 & 1, ((data476 << 3) & 248) | (data477 & 7), ((data478 << 3) & 248) | (data479 & 7), data55}, null, null);
                return;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                int data481 = DataCanbus.DATA[358];
                int data482 = DataCanbus.DATA[359];
                int data483 = DataCanbus.DATA[360];
                int data484 = DataCanbus.DATA[361];
                int data485 = DataCanbus.DATA[362];
                int data486 = DataCanbus.DATA[363];
                if ((data486 & 8) != 0) {
                    data54 = data486 & 247;
                } else {
                    data54 = data486 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data481 & 1, ((data482 << 3) & 248) | (data483 & 7), ((data484 << 3) & 248) | (data485 & 7), data54}, null, null);
                return;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                int data487 = DataCanbus.DATA[358];
                int data488 = DataCanbus.DATA[359];
                int data489 = DataCanbus.DATA[360];
                int data490 = DataCanbus.DATA[361];
                int data491 = DataCanbus.DATA[362];
                int data492 = DataCanbus.DATA[363];
                if ((data492 & 16) != 0) {
                    data53 = data492 & 239;
                } else {
                    data53 = data492 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data487 & 1, ((data488 << 3) & 248) | (data489 & 7), ((data490 << 3) & 248) | (data491 & 7), data53}, null, null);
                return;
            case R.id.ctv_checkedtext22 /* 2131427736 */:
                int data493 = DataCanbus.DATA[358];
                int data494 = DataCanbus.DATA[359];
                int data495 = DataCanbus.DATA[360];
                int data496 = DataCanbus.DATA[361];
                int data497 = DataCanbus.DATA[362];
                int data498 = DataCanbus.DATA[363];
                if ((data498 & 32) != 0) {
                    data52 = data498 & 223;
                } else {
                    data52 = data498 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data493 & 1, ((data494 << 3) & 248) | (data495 & 7), ((data496 << 3) & 248) | (data497 & 7), data52}, null, null);
                return;
            case R.id.ctv_checkedtext23 /* 2131427739 */:
                int data499 = DataCanbus.DATA[364];
                int data500 = DataCanbus.DATA[365];
                int data501 = DataCanbus.DATA[366];
                int data502 = DataCanbus.DATA[367];
                int data503 = DataCanbus.DATA[368];
                int data504 = DataCanbus.DATA[369];
                if ((data504 & 64) != 0) {
                    data50 = data504 & 191;
                } else {
                    data50 = data504 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data499 & 1, ((data500 << 3) & 248) | (data501 & 7), ((data502 << 3) & 248) | (data503 & 7), data50}, null, null);
                return;
            case R.id.ctv_checkedtext24 /* 2131427744 */:
                int data505 = DataCanbus.DATA[364];
                int data506 = DataCanbus.DATA[365];
                int data507 = DataCanbus.DATA[366];
                int data508 = DataCanbus.DATA[367];
                int data509 = DataCanbus.DATA[368];
                int data510 = DataCanbus.DATA[369];
                if ((data510 & 1) != 0) {
                    data49 = data510 & 254;
                } else {
                    data49 = data510 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data505 & 1, ((data506 << 3) & 248) | (data507 & 7), ((data508 << 3) & 248) | (data509 & 7), data49}, null, null);
                return;
            case R.id.ctv_checkedtext25 /* 2131427746 */:
                int data511 = DataCanbus.DATA[364];
                int data512 = DataCanbus.DATA[365];
                int data513 = DataCanbus.DATA[366];
                int data514 = DataCanbus.DATA[367];
                int data515 = DataCanbus.DATA[368];
                int data516 = DataCanbus.DATA[369];
                if ((data516 & 2) != 0) {
                    data48 = data516 & 253;
                } else {
                    data48 = data516 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data511 & 1, ((data512 << 3) & 248) | (data513 & 7), ((data514 << 3) & 248) | (data515 & 7), data48}, null, null);
                return;
            case R.id.ctv_checkedtext27 /* 2131427748 */:
                int data517 = DataCanbus.DATA[364];
                int data518 = DataCanbus.DATA[365];
                int data519 = DataCanbus.DATA[366];
                int data520 = DataCanbus.DATA[367];
                int data521 = DataCanbus.DATA[368];
                int data522 = DataCanbus.DATA[369];
                if ((data522 & 8) != 0) {
                    data46 = data522 & 247;
                } else {
                    data46 = data522 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data517 & 1, ((data518 << 3) & 248) | (data519 & 7), ((data520 << 3) & 248) | (data521 & 7), data46}, null, null);
                return;
            case R.id.ctv_checkedtext28 /* 2131427750 */:
                int data523 = DataCanbus.DATA[364];
                int data524 = DataCanbus.DATA[365];
                int data525 = DataCanbus.DATA[366];
                int data526 = DataCanbus.DATA[367];
                int data527 = DataCanbus.DATA[368];
                int data528 = DataCanbus.DATA[369];
                if ((data528 & 16) != 0) {
                    data45 = data528 & 239;
                } else {
                    data45 = data528 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data523 & 1, ((data524 << 3) & 248) | (data525 & 7), ((data526 << 3) & 248) | (data527 & 7), data45}, null, null);
                return;
            case R.id.ctv_checkedtext29 /* 2131427753 */:
                int data529 = DataCanbus.DATA[364];
                int data530 = DataCanbus.DATA[365];
                int data531 = DataCanbus.DATA[366];
                int data532 = DataCanbus.DATA[367];
                int data533 = DataCanbus.DATA[368];
                int data534 = DataCanbus.DATA[369];
                if ((data534 & 32) != 0) {
                    data44 = data534 & 223;
                } else {
                    data44 = data534 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data529 & 1, ((data530 << 3) & 248) | (data531 & 7), ((data532 << 3) & 248) | (data533 & 7), data44}, null, null);
                return;
            case R.id.ctv_checkedtext30 /* 2131427756 */:
                int data535 = DataCanbus.DATA[370];
                int data536 = DataCanbus.DATA[371];
                int data537 = DataCanbus.DATA[372];
                int data538 = DataCanbus.DATA[373];
                int data539 = DataCanbus.DATA[374];
                int data540 = DataCanbus.DATA[375];
                if ((data540 & 64) != 0) {
                    data42 = data540 & 191;
                } else {
                    data42 = data540 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data535 & 1, ((data536 << 3) & 248) | (data537 & 7), ((data538 << 3) & 248) | (data539 & 7), data42}, null, null);
                return;
            case R.id.ctv_checkedtext31 /* 2131427758 */:
                int data541 = DataCanbus.DATA[370];
                int data542 = DataCanbus.DATA[371];
                int data543 = DataCanbus.DATA[372];
                int data544 = DataCanbus.DATA[373];
                int data545 = DataCanbus.DATA[374];
                int data546 = DataCanbus.DATA[375];
                if ((data546 & 1) != 0) {
                    data41 = data546 & 254;
                } else {
                    data41 = data546 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data541 & 1, ((data542 << 3) & 248) | (data543 & 7), ((data544 << 3) & 248) | (data545 & 7), data41}, null, null);
                return;
            case R.id.ctv_checkedtext32 /* 2131427761 */:
                int data547 = DataCanbus.DATA[370];
                int data548 = DataCanbus.DATA[371];
                int data549 = DataCanbus.DATA[372];
                int data550 = DataCanbus.DATA[373];
                int data551 = DataCanbus.DATA[374];
                int data552 = DataCanbus.DATA[375];
                if ((data552 & 2) != 0) {
                    data40 = data552 & 253;
                } else {
                    data40 = data552 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data547 & 1, ((data548 << 3) & 248) | (data549 & 7), ((data550 << 3) & 248) | (data551 & 7), data40}, null, null);
                return;
            case R.id.ctv_checkedtext33 /* 2131427763 */:
                int data553 = DataCanbus.DATA[370];
                int data554 = DataCanbus.DATA[371];
                int data555 = DataCanbus.DATA[372];
                int data556 = DataCanbus.DATA[373];
                int data557 = DataCanbus.DATA[374];
                int data558 = DataCanbus.DATA[375];
                if ((data558 & 4) != 0) {
                    data39 = data558 & 251;
                } else {
                    data39 = data558 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data553 & 1, ((data554 << 3) & 248) | (data555 & 7), ((data556 << 3) & 248) | (data557 & 7), data39}, null, null);
                return;
            case R.id.btn_minus32 /* 2131427809 */:
                int data559 = DataCanbus.DATA[370];
                int data560 = DataCanbus.DATA[371];
                int data561 = DataCanbus.DATA[372];
                int data562 = DataCanbus.DATA[373];
                int data563 = DataCanbus.DATA[374];
                int data564 = DataCanbus.DATA[375];
                int data565 = data560 - 1;
                if (data565 < 0) {
                    data565 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data559 & 1, ((data565 << 3) & 248) | (data561 & 7), ((data562 << 3) & 248) | (data563 & 7), data564}, null, null);
                return;
            case R.id.btn_plus32 /* 2131427810 */:
                int data566 = DataCanbus.DATA[370];
                int data567 = DataCanbus.DATA[371];
                int data568 = DataCanbus.DATA[372];
                int data569 = DataCanbus.DATA[373];
                int data570 = DataCanbus.DATA[374];
                int data571 = DataCanbus.DATA[375];
                int data572 = data567 + 1;
                if (data572 > 23) {
                    data572 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data566 & 1, ((data572 << 3) & 248) | (data568 & 7), ((data569 << 3) & 248) | (data570 & 7), data571}, null, null);
                return;
            case R.id.btn_minus33 /* 2131427811 */:
                int data573 = DataCanbus.DATA[370];
                int data574 = DataCanbus.DATA[371];
                int data575 = DataCanbus.DATA[372];
                int data576 = DataCanbus.DATA[373];
                int data577 = DataCanbus.DATA[374];
                int data578 = DataCanbus.DATA[375];
                int data579 = data575 - 1;
                if (data579 < 0) {
                    data579 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data573 & 1, ((data574 << 3) & 248) | (data579 & 7), ((data576 << 3) & 248) | (data577 & 7), data578}, null, null);
                return;
            case R.id.btn_plus33 /* 2131427812 */:
                int data580 = DataCanbus.DATA[370];
                int data581 = DataCanbus.DATA[371];
                int data582 = DataCanbus.DATA[372];
                int data583 = DataCanbus.DATA[373];
                int data584 = DataCanbus.DATA[374];
                int data585 = DataCanbus.DATA[375];
                int data586 = data582 + 1;
                if (data586 > 59) {
                    data586 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data580 & 1, ((data581 << 3) & 248) | (data586 & 7), ((data583 << 3) & 248) | (data584 & 7), data585}, null, null);
                return;
            case R.id.btn_minus34 /* 2131427813 */:
                int data587 = DataCanbus.DATA[370];
                int data588 = DataCanbus.DATA[371];
                int data589 = DataCanbus.DATA[372];
                int data590 = DataCanbus.DATA[373];
                int data591 = DataCanbus.DATA[374];
                int data592 = DataCanbus.DATA[375];
                int data593 = data590 - 1;
                if (data593 < 0) {
                    data593 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data587 & 1, ((data588 << 3) & 248) | (data589 & 7), ((data593 << 3) & 248) | (data591 & 7), data592}, null, null);
                return;
            case R.id.btn_plus34 /* 2131427814 */:
                int data594 = DataCanbus.DATA[370];
                int data595 = DataCanbus.DATA[371];
                int data596 = DataCanbus.DATA[372];
                int data597 = DataCanbus.DATA[373];
                int data598 = DataCanbus.DATA[374];
                int data599 = DataCanbus.DATA[375];
                int data600 = data597 + 1;
                if (data600 > 23) {
                    data600 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data594 & 1, ((data595 << 3) & 248) | (data596 & 7), ((data600 << 3) & 248) | (data598 & 7), data599}, null, null);
                return;
            case R.id.btn_minus35 /* 2131427815 */:
                int data601 = DataCanbus.DATA[370];
                int data602 = DataCanbus.DATA[371];
                int data603 = DataCanbus.DATA[372];
                int data604 = DataCanbus.DATA[373];
                int data605 = DataCanbus.DATA[374];
                int data606 = DataCanbus.DATA[375];
                int data607 = data605 - 1;
                if (data607 < 0) {
                    data607 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data601 & 1, ((data602 << 3) & 248) | (data603 & 7), ((data604 << 3) & 248) | (data607 & 7), data606}, null, null);
                return;
            case R.id.btn_plus35 /* 2131427816 */:
                int data608 = DataCanbus.DATA[370];
                int data609 = DataCanbus.DATA[371];
                int data610 = DataCanbus.DATA[372];
                int data611 = DataCanbus.DATA[373];
                int data612 = DataCanbus.DATA[374];
                int data613 = DataCanbus.DATA[375];
                int data614 = data612 + 1;
                if (data614 > 59) {
                    data614 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data608 & 1, ((data609 << 3) & 248) | (data610 & 7), ((data611 << 3) & 248) | (data614 & 7), data613}, null, null);
                return;
            case R.id.ctv_checkedtext34 /* 2131427817 */:
                int data615 = DataCanbus.DATA[370];
                int data616 = DataCanbus.DATA[371];
                int data617 = DataCanbus.DATA[372];
                int data618 = DataCanbus.DATA[373];
                int data619 = DataCanbus.DATA[374];
                int data620 = DataCanbus.DATA[375];
                if ((data620 & 8) != 0) {
                    data38 = data620 & 247;
                } else {
                    data38 = data620 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data615 & 1, ((data616 << 3) & 248) | (data617 & 7), ((data618 << 3) & 248) | (data619 & 7), data38}, null, null);
                return;
            case R.id.ctv_checkedtext35 /* 2131427818 */:
                int data621 = DataCanbus.DATA[370];
                int data622 = DataCanbus.DATA[371];
                int data623 = DataCanbus.DATA[372];
                int data624 = DataCanbus.DATA[373];
                int data625 = DataCanbus.DATA[374];
                int data626 = DataCanbus.DATA[375];
                if ((data626 & 16) != 0) {
                    data37 = data626 & 239;
                } else {
                    data37 = data626 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data621 & 1, ((data622 << 3) & 248) | (data623 & 7), ((data624 << 3) & 248) | (data625 & 7), data37}, null, null);
                return;
            case R.id.ctv_checkedtext36 /* 2131427819 */:
                int data627 = DataCanbus.DATA[370];
                int data628 = DataCanbus.DATA[371];
                int data629 = DataCanbus.DATA[372];
                int data630 = DataCanbus.DATA[373];
                int data631 = DataCanbus.DATA[374];
                int data632 = DataCanbus.DATA[375];
                if ((data632 & 32) != 0) {
                    data36 = data632 & 223;
                } else {
                    data36 = data632 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data627 & 1, ((data628 << 3) & 248) | (data629 & 7), ((data630 << 3) & 248) | (data631 & 7), data36}, null, null);
                return;
            case R.id.btn_minus38 /* 2131427822 */:
                int data633 = DataCanbus.DATA[376];
                int data634 = DataCanbus.DATA[377];
                int data635 = DataCanbus.DATA[378];
                int data636 = DataCanbus.DATA[379];
                int data637 = DataCanbus.DATA[380];
                int data638 = DataCanbus.DATA[381];
                int data639 = data634 - 1;
                if (data639 < 0) {
                    data639 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data633 & 1, ((data639 << 3) & 248) | (data635 & 7), ((data636 << 3) & 248) | (data637 & 7), data638}, null, null);
                return;
            case R.id.btn_plus38 /* 2131427823 */:
                int data640 = DataCanbus.DATA[376];
                int data641 = DataCanbus.DATA[377];
                int data642 = DataCanbus.DATA[378];
                int data643 = DataCanbus.DATA[379];
                int data644 = DataCanbus.DATA[380];
                int data645 = DataCanbus.DATA[381];
                int data646 = data641 + 1;
                if (data646 > 23) {
                    data646 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data640 & 1, ((data646 << 3) & 248) | (data642 & 7), ((data643 << 3) & 248) | (data644 & 7), data645}, null, null);
                return;
            case R.id.btn_minus39 /* 2131427824 */:
                int data647 = DataCanbus.DATA[376];
                int data648 = DataCanbus.DATA[377];
                int data649 = DataCanbus.DATA[378];
                int data650 = DataCanbus.DATA[379];
                int data651 = DataCanbus.DATA[380];
                int data652 = DataCanbus.DATA[381];
                int data653 = data649 - 1;
                if (data653 < 0) {
                    data653 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data647 & 1, ((data648 << 3) & 248) | (data653 & 7), ((data650 << 3) & 248) | (data651 & 7), data652}, null, null);
                return;
            case R.id.btn_plus39 /* 2131427825 */:
                int data654 = DataCanbus.DATA[376];
                int data655 = DataCanbus.DATA[377];
                int data656 = DataCanbus.DATA[378];
                int data657 = DataCanbus.DATA[379];
                int data658 = DataCanbus.DATA[380];
                int data659 = DataCanbus.DATA[381];
                int data660 = data656 + 1;
                if (data660 > 59) {
                    data660 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data654 & 1, ((data655 << 3) & 248) | (data660 & 7), ((data657 << 3) & 248) | (data658 & 7), data659}, null, null);
                return;
            case R.id.btn_minus40 /* 2131427826 */:
                int data661 = DataCanbus.DATA[376];
                int data662 = DataCanbus.DATA[377];
                int data663 = DataCanbus.DATA[378];
                int data664 = DataCanbus.DATA[379];
                int data665 = DataCanbus.DATA[380];
                int data666 = DataCanbus.DATA[381];
                int data667 = data664 - 1;
                if (data667 < 0) {
                    data667 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data661 & 1, ((data662 << 3) & 248) | (data663 & 7), ((data667 << 3) & 248) | (data665 & 7), data666}, null, null);
                return;
            case R.id.btn_plus40 /* 2131427827 */:
                int data668 = DataCanbus.DATA[376];
                int data669 = DataCanbus.DATA[377];
                int data670 = DataCanbus.DATA[378];
                int data671 = DataCanbus.DATA[379];
                int data672 = DataCanbus.DATA[380];
                int data673 = DataCanbus.DATA[381];
                int data674 = data671 + 1;
                if (data674 > 23) {
                    data674 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data668 & 1, ((data669 << 3) & 248) | (data670 & 7), ((data674 << 3) & 248) | (data672 & 7), data673}, null, null);
                return;
            case R.id.btn_minus41 /* 2131427828 */:
                int data675 = DataCanbus.DATA[376];
                int data676 = DataCanbus.DATA[377];
                int data677 = DataCanbus.DATA[378];
                int data678 = DataCanbus.DATA[379];
                int data679 = DataCanbus.DATA[380];
                int data680 = DataCanbus.DATA[381];
                int data681 = data679 - 1;
                if (data681 < 0) {
                    data681 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data675 & 1, ((data676 << 3) & 248) | (data677 & 7), ((data678 << 3) & 248) | (data681 & 7), data680}, null, null);
                return;
            case R.id.btn_plus41 /* 2131427829 */:
                int data682 = DataCanbus.DATA[376];
                int data683 = DataCanbus.DATA[377];
                int data684 = DataCanbus.DATA[378];
                int data685 = DataCanbus.DATA[379];
                int data686 = DataCanbus.DATA[380];
                int data687 = DataCanbus.DATA[381];
                int data688 = data686 + 1;
                if (data688 > 59) {
                    data688 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data682 & 1, ((data683 << 3) & 248) | (data684 & 7), ((data685 << 3) & 248) | (data688 & 7), data687}, null, null);
                break;
            case R.id.ctv_checkedtext37 /* 2131427830 */:
                break;
            case R.id.ctv_checkedtext38 /* 2131427831 */:
                int data689 = DataCanbus.DATA[376];
                int data690 = DataCanbus.DATA[377];
                int data691 = DataCanbus.DATA[378];
                int data692 = DataCanbus.DATA[379];
                int data693 = DataCanbus.DATA[380];
                int data694 = DataCanbus.DATA[381];
                if ((data694 & 1) != 0) {
                    data33 = data694 & 254;
                } else {
                    data33 = data694 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data689 & 1, ((data690 << 3) & 248) | (data691 & 7), ((data692 << 3) & 248) | (data693 & 7), data33}, null, null);
                return;
            case R.id.ctv_checkedtext39 /* 2131427832 */:
                int data695 = DataCanbus.DATA[376];
                int data696 = DataCanbus.DATA[377];
                int data697 = DataCanbus.DATA[378];
                int data698 = DataCanbus.DATA[379];
                int data699 = DataCanbus.DATA[380];
                int data700 = DataCanbus.DATA[381];
                if ((data700 & 2) != 0) {
                    data32 = data700 & 253;
                } else {
                    data32 = data700 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data695 & 1, ((data696 << 3) & 248) | (data697 & 7), ((data698 << 3) & 248) | (data699 & 7), data32}, null, null);
                return;
            case R.id.ctv_checkedtext40 /* 2131427833 */:
                int data701 = DataCanbus.DATA[376];
                int data702 = DataCanbus.DATA[377];
                int data703 = DataCanbus.DATA[378];
                int data704 = DataCanbus.DATA[379];
                int data705 = DataCanbus.DATA[380];
                int data706 = DataCanbus.DATA[381];
                if ((data706 & 4) != 0) {
                    data31 = data706 & 251;
                } else {
                    data31 = data706 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data701 & 1, ((data702 << 3) & 248) | (data703 & 7), ((data704 << 3) & 248) | (data705 & 7), data31}, null, null);
                return;
            case R.id.ctv_checkedtext41 /* 2131427834 */:
                int data707 = DataCanbus.DATA[376];
                int data708 = DataCanbus.DATA[377];
                int data709 = DataCanbus.DATA[378];
                int data710 = DataCanbus.DATA[379];
                int data711 = DataCanbus.DATA[380];
                int data712 = DataCanbus.DATA[381];
                if ((data712 & 8) != 0) {
                    data30 = data712 & 247;
                } else {
                    data30 = data712 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data707 & 1, ((data708 << 3) & 248) | (data709 & 7), ((data710 << 3) & 248) | (data711 & 7), data30}, null, null);
                return;
            case R.id.ctv_checkedtext42 /* 2131427835 */:
                int data713 = DataCanbus.DATA[376];
                int data714 = DataCanbus.DATA[377];
                int data715 = DataCanbus.DATA[378];
                int data716 = DataCanbus.DATA[379];
                int data717 = DataCanbus.DATA[380];
                int data718 = DataCanbus.DATA[381];
                if ((data718 & 16) != 0) {
                    data29 = data718 & 239;
                } else {
                    data29 = data718 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data713 & 1, ((data714 << 3) & 248) | (data715 & 7), ((data716 << 3) & 248) | (data717 & 7), data29}, null, null);
                return;
            case R.id.ctv_checkedtext43 /* 2131427836 */:
                int data719 = DataCanbus.DATA[376];
                int data720 = DataCanbus.DATA[377];
                int data721 = DataCanbus.DATA[378];
                int data722 = DataCanbus.DATA[379];
                int data723 = DataCanbus.DATA[380];
                int data724 = DataCanbus.DATA[381];
                if ((data724 & 32) != 0) {
                    data28 = data724 & 223;
                } else {
                    data28 = data724 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data719 & 1, ((data720 << 3) & 248) | (data721 & 7), ((data722 << 3) & 248) | (data723 & 7), data28}, null, null);
                return;
            case R.id.btn_minus44 /* 2131427839 */:
                int data725 = DataCanbus.DATA[382];
                int data726 = DataCanbus.DATA[383];
                int data727 = DataCanbus.DATA[384];
                int data728 = DataCanbus.DATA[385];
                int data729 = DataCanbus.DATA[386];
                int data730 = DataCanbus.DATA[387];
                int data731 = data726 - 1;
                if (data731 < 0) {
                    data731 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data725 & 1, ((data731 << 3) & 248) | (data727 & 7), ((data728 << 3) & 248) | (data729 & 7), data730}, null, null);
                return;
            case R.id.btn_plus44 /* 2131427840 */:
                int data732 = DataCanbus.DATA[382];
                int data733 = DataCanbus.DATA[383];
                int data734 = DataCanbus.DATA[384];
                int data735 = DataCanbus.DATA[385];
                int data736 = DataCanbus.DATA[386];
                int data737 = DataCanbus.DATA[387];
                int data738 = data733 + 1;
                if (data738 > 23) {
                    data738 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data732 & 1, ((data738 << 3) & 248) | (data734 & 7), ((data735 << 3) & 248) | (data736 & 7), data737}, null, null);
                return;
            case R.id.btn_minus45 /* 2131427841 */:
                int data739 = DataCanbus.DATA[382];
                int data740 = DataCanbus.DATA[383];
                int data741 = DataCanbus.DATA[384];
                int data742 = DataCanbus.DATA[385];
                int data743 = DataCanbus.DATA[386];
                int data744 = DataCanbus.DATA[387];
                int data745 = data741 - 1;
                if (data745 < 0) {
                    data745 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data739 & 1, ((data740 << 3) & 248) | (data745 & 7), ((data742 << 3) & 248) | (data743 & 7), data744}, null, null);
                return;
            case R.id.btn_plus45 /* 2131427843 */:
                int data746 = DataCanbus.DATA[382];
                int data747 = DataCanbus.DATA[383];
                int data748 = DataCanbus.DATA[384];
                int data749 = DataCanbus.DATA[385];
                int data750 = DataCanbus.DATA[386];
                int data751 = DataCanbus.DATA[387];
                int data752 = data748 + 1;
                if (data752 > 59) {
                    data752 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data746 & 1, ((data747 << 3) & 248) | (data752 & 7), ((data749 << 3) & 248) | (data750 & 7), data751}, null, null);
                return;
            case R.id.btn_minus46 /* 2131427844 */:
                int data753 = DataCanbus.DATA[382];
                int data754 = DataCanbus.DATA[383];
                int data755 = DataCanbus.DATA[384];
                int data756 = DataCanbus.DATA[385];
                int data757 = DataCanbus.DATA[386];
                int data758 = DataCanbus.DATA[387];
                int data759 = data756 - 1;
                if (data759 < 0) {
                    data759 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data753 & 1, ((data754 << 3) & 248) | (data755 & 7), ((data759 << 3) & 248) | (data757 & 7), data758}, null, null);
                return;
            case R.id.btn_plus46 /* 2131427846 */:
                int data760 = DataCanbus.DATA[382];
                int data761 = DataCanbus.DATA[383];
                int data762 = DataCanbus.DATA[384];
                int data763 = DataCanbus.DATA[385];
                int data764 = DataCanbus.DATA[386];
                int data765 = DataCanbus.DATA[387];
                int data766 = data763 + 1;
                if (data766 > 23) {
                    data766 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data760 & 1, ((data761 << 3) & 248) | (data762 & 7), ((data766 << 3) & 248) | (data764 & 7), data765}, null, null);
                return;
            case R.id.btn_minus47 /* 2131427847 */:
                int data767 = DataCanbus.DATA[382];
                int data768 = DataCanbus.DATA[383];
                int data769 = DataCanbus.DATA[384];
                int data770 = DataCanbus.DATA[385];
                int data771 = DataCanbus.DATA[386];
                int data772 = DataCanbus.DATA[387];
                int data773 = data771 - 1;
                if (data773 < 0) {
                    data773 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data767 & 1, ((data768 << 3) & 248) | (data769 & 7), ((data770 << 3) & 248) | (data773 & 7), data772}, null, null);
                return;
            case R.id.btn_plus47 /* 2131427849 */:
                int data774 = DataCanbus.DATA[382];
                int data775 = DataCanbus.DATA[383];
                int data776 = DataCanbus.DATA[384];
                int data777 = DataCanbus.DATA[385];
                int data778 = DataCanbus.DATA[386];
                int data779 = DataCanbus.DATA[387];
                int data780 = data778 + 1;
                if (data780 > 59) {
                    data780 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data774 & 1, ((data775 << 3) & 248) | (data776 & 7), ((data777 << 3) & 248) | (data780 & 7), data779}, null, null);
                return;
            case R.id.ctv_checkedtext44 /* 2131427850 */:
                int data781 = DataCanbus.DATA[382];
                int data782 = DataCanbus.DATA[383];
                int data783 = DataCanbus.DATA[384];
                int data784 = DataCanbus.DATA[385];
                int data785 = DataCanbus.DATA[386];
                int data786 = DataCanbus.DATA[387];
                if ((data786 & 64) != 0) {
                    data26 = data786 & 191;
                } else {
                    data26 = data786 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data781 & 1, ((data782 << 3) & 248) | (data783 & 7), ((data784 << 3) & 248) | (data785 & 7), data26}, null, null);
                return;
            case R.id.ctv_checkedtext45 /* 2131427851 */:
                int data787 = DataCanbus.DATA[382];
                int data788 = DataCanbus.DATA[383];
                int data789 = DataCanbus.DATA[384];
                int data790 = DataCanbus.DATA[385];
                int data791 = DataCanbus.DATA[386];
                int data792 = DataCanbus.DATA[387];
                if ((data792 & 1) != 0) {
                    data25 = data792 & 254;
                } else {
                    data25 = data792 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data787 & 1, ((data788 << 3) & 248) | (data789 & 7), ((data790 << 3) & 248) | (data791 & 7), data25}, null, null);
                return;
            case R.id.ctv_checkedtext46 /* 2131427852 */:
                int data793 = DataCanbus.DATA[382];
                int data794 = DataCanbus.DATA[383];
                int data795 = DataCanbus.DATA[384];
                int data796 = DataCanbus.DATA[385];
                int data797 = DataCanbus.DATA[386];
                int data798 = DataCanbus.DATA[387];
                if ((data798 & 2) != 0) {
                    data24 = data798 & 253;
                } else {
                    data24 = data798 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data793 & 1, ((data794 << 3) & 248) | (data795 & 7), ((data796 << 3) & 248) | (data797 & 7), data24}, null, null);
                return;
            case R.id.ctv_checkedtext47 /* 2131427853 */:
                int data799 = DataCanbus.DATA[382];
                int data800 = DataCanbus.DATA[383];
                int data801 = DataCanbus.DATA[384];
                int data802 = DataCanbus.DATA[385];
                int data803 = DataCanbus.DATA[386];
                int data804 = DataCanbus.DATA[387];
                if ((data804 & 4) != 0) {
                    data23 = data804 & 251;
                } else {
                    data23 = data804 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data799 & 1, ((data800 << 3) & 248) | (data801 & 7), ((data802 << 3) & 248) | (data803 & 7), data23}, null, null);
                return;
            case R.id.ctv_checkedtext48 /* 2131427854 */:
                int data805 = DataCanbus.DATA[382];
                int data806 = DataCanbus.DATA[383];
                int data807 = DataCanbus.DATA[384];
                int data808 = DataCanbus.DATA[385];
                int data809 = DataCanbus.DATA[386];
                int data810 = DataCanbus.DATA[387];
                if ((data810 & 8) != 0) {
                    data22 = data810 & 247;
                } else {
                    data22 = data810 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data805 & 1, ((data806 << 3) & 248) | (data807 & 7), ((data808 << 3) & 248) | (data809 & 7), data22}, null, null);
                return;
            case R.id.ctv_checkedtext49 /* 2131427855 */:
                int data811 = DataCanbus.DATA[382];
                int data812 = DataCanbus.DATA[383];
                int data813 = DataCanbus.DATA[384];
                int data814 = DataCanbus.DATA[385];
                int data815 = DataCanbus.DATA[386];
                int data816 = DataCanbus.DATA[387];
                if ((data816 & 16) != 0) {
                    data21 = data816 & 239;
                } else {
                    data21 = data816 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data811 & 1, ((data812 << 3) & 248) | (data813 & 7), ((data814 << 3) & 248) | (data815 & 7), data21}, null, null);
                return;
            case R.id.ctv_checkedtext50 /* 2131427856 */:
                int data817 = DataCanbus.DATA[382];
                int data818 = DataCanbus.DATA[383];
                int data819 = DataCanbus.DATA[384];
                int data820 = DataCanbus.DATA[385];
                int data821 = DataCanbus.DATA[386];
                int data822 = DataCanbus.DATA[387];
                if ((data822 & 32) != 0) {
                    data20 = data822 & 223;
                } else {
                    data20 = data822 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data817 & 1, ((data818 << 3) & 248) | (data819 & 7), ((data820 << 3) & 248) | (data821 & 7), data20}, null, null);
                return;
            case R.id.btn_minus50 /* 2131427860 */:
                int data823 = DataCanbus.DATA[388];
                int data824 = DataCanbus.DATA[389];
                int data825 = DataCanbus.DATA[390];
                int data826 = DataCanbus.DATA[391];
                int data827 = DataCanbus.DATA[392];
                int data828 = DataCanbus.DATA[393];
                int data829 = data824 - 1;
                if (data829 < 0) {
                    data829 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data823 & 1, ((data829 << 3) & 248) | (data825 & 7), ((data826 << 3) & 248) | (data827 & 7), data828}, null, null);
                return;
            case R.id.btn_plus50 /* 2131427862 */:
                int data830 = DataCanbus.DATA[388];
                int data831 = DataCanbus.DATA[389];
                int data832 = DataCanbus.DATA[390];
                int data833 = DataCanbus.DATA[391];
                int data834 = DataCanbus.DATA[392];
                int data835 = DataCanbus.DATA[393];
                int data836 = data831 + 1;
                if (data836 > 23) {
                    data836 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data830 & 1, ((data836 << 3) & 248) | (data832 & 7), ((data833 << 3) & 248) | (data834 & 7), data835}, null, null);
                return;
            case R.id.btn_minus51 /* 2131427863 */:
                int data837 = DataCanbus.DATA[388];
                int data838 = DataCanbus.DATA[389];
                int data839 = DataCanbus.DATA[390];
                int data840 = DataCanbus.DATA[391];
                int data841 = DataCanbus.DATA[392];
                int data842 = DataCanbus.DATA[393];
                int data843 = data839 - 1;
                if (data843 < 0) {
                    data843 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data837 & 1, ((data838 << 3) & 248) | (data843 & 7), ((data840 << 3) & 248) | (data841 & 7), data842}, null, null);
                return;
            case R.id.btn_plus51 /* 2131427865 */:
                int data844 = DataCanbus.DATA[388];
                int data845 = DataCanbus.DATA[389];
                int data846 = DataCanbus.DATA[390];
                int data847 = DataCanbus.DATA[391];
                int data848 = DataCanbus.DATA[392];
                int data849 = DataCanbus.DATA[393];
                int data850 = data846 + 1;
                if (data850 > 59) {
                    data850 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data844 & 1, ((data845 << 3) & 248) | (data850 & 7), ((data847 << 3) & 248) | (data848 & 7), data849}, null, null);
                return;
            case R.id.btn_minus52 /* 2131427866 */:
                int data851 = DataCanbus.DATA[388];
                int data852 = DataCanbus.DATA[389];
                int data853 = DataCanbus.DATA[390];
                int data854 = DataCanbus.DATA[391];
                int data855 = DataCanbus.DATA[392];
                int data856 = DataCanbus.DATA[393];
                int data857 = data854 - 1;
                if (data857 < 0) {
                    data857 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data851 & 1, ((data852 << 3) & 248) | (data853 & 7), ((data857 << 3) & 248) | (data855 & 7), data856}, null, null);
                return;
            case R.id.btn_plus52 /* 2131427868 */:
                int data858 = DataCanbus.DATA[388];
                int data859 = DataCanbus.DATA[389];
                int data860 = DataCanbus.DATA[390];
                int data861 = DataCanbus.DATA[391];
                int data862 = DataCanbus.DATA[392];
                int data863 = DataCanbus.DATA[393];
                int data864 = data861 + 1;
                if (data864 > 23) {
                    data864 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data858 & 1, ((data859 << 3) & 248) | (data860 & 7), ((data864 << 3) & 248) | (data862 & 7), data863}, null, null);
                return;
            case R.id.btn_minus53 /* 2131427869 */:
                int data865 = DataCanbus.DATA[388];
                int data866 = DataCanbus.DATA[389];
                int data867 = DataCanbus.DATA[390];
                int data868 = DataCanbus.DATA[391];
                int data869 = DataCanbus.DATA[392];
                int data870 = DataCanbus.DATA[393];
                int data871 = data869 - 1;
                if (data871 < 0) {
                    data871 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data865 & 1, ((data866 << 3) & 248) | (data867 & 7), ((data868 << 3) & 248) | (data871 & 7), data870}, null, null);
                return;
            case R.id.btn_plus53 /* 2131427871 */:
                int data872 = DataCanbus.DATA[388];
                int data873 = DataCanbus.DATA[389];
                int data874 = DataCanbus.DATA[390];
                int data875 = DataCanbus.DATA[391];
                int data876 = DataCanbus.DATA[392];
                int data877 = DataCanbus.DATA[393];
                int data878 = data876 + 1;
                if (data878 > 59) {
                    data878 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data872 & 1, ((data873 << 3) & 248) | (data874 & 7), ((data875 << 3) & 248) | (data878 & 7), data877}, null, null);
                return;
            case R.id.ctv_checkedtext51 /* 2131427872 */:
                int data879 = DataCanbus.DATA[388];
                int data880 = DataCanbus.DATA[389];
                int data881 = DataCanbus.DATA[390];
                int data882 = DataCanbus.DATA[391];
                int data883 = DataCanbus.DATA[392];
                int data884 = DataCanbus.DATA[393];
                if ((data884 & 64) != 0) {
                    data19 = data884 & 191;
                } else {
                    data19 = data884 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data879 & 1, ((data880 << 3) & 248) | (data881 & 7), ((data882 << 3) & 248) | (data883 & 7), data19}, null, null);
                return;
            case R.id.ctv_checkedtext52 /* 2131427873 */:
                int data885 = DataCanbus.DATA[388];
                int data886 = DataCanbus.DATA[389];
                int data887 = DataCanbus.DATA[390];
                int data888 = DataCanbus.DATA[391];
                int data889 = DataCanbus.DATA[392];
                int data890 = DataCanbus.DATA[393];
                if ((data890 & 1) != 0) {
                    data18 = data890 & 254;
                } else {
                    data18 = data890 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data885 & 1, ((data886 << 3) & 248) | (data887 & 7), ((data888 << 3) & 248) | (data889 & 7), data18}, null, null);
                return;
            case R.id.ctv_checkedtext53 /* 2131427874 */:
                int data891 = DataCanbus.DATA[388];
                int data892 = DataCanbus.DATA[389];
                int data893 = DataCanbus.DATA[390];
                int data894 = DataCanbus.DATA[391];
                int data895 = DataCanbus.DATA[392];
                int data896 = DataCanbus.DATA[393];
                if ((data896 & 2) != 0) {
                    data17 = data896 & 253;
                } else {
                    data17 = data896 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data891 & 1, ((data892 << 3) & 248) | (data893 & 7), ((data894 << 3) & 248) | (data895 & 7), data17}, null, null);
                return;
            case R.id.ctv_checkedtext54 /* 2131427875 */:
                int data897 = DataCanbus.DATA[388];
                int data898 = DataCanbus.DATA[389];
                int data899 = DataCanbus.DATA[390];
                int data900 = DataCanbus.DATA[391];
                int data901 = DataCanbus.DATA[392];
                int data902 = DataCanbus.DATA[393];
                if ((data902 & 4) != 0) {
                    data16 = data902 & 251;
                } else {
                    data16 = data902 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data897 & 1, ((data898 << 3) & 248) | (data899 & 7), ((data900 << 3) & 248) | (data901 & 7), data16}, null, null);
                return;
            case R.id.ctv_checkedtext55 /* 2131427876 */:
                int data903 = DataCanbus.DATA[388];
                int data904 = DataCanbus.DATA[389];
                int data905 = DataCanbus.DATA[390];
                int data906 = DataCanbus.DATA[391];
                int data907 = DataCanbus.DATA[392];
                int data908 = DataCanbus.DATA[393];
                if ((data908 & 8) != 0) {
                    data15 = data908 & 247;
                } else {
                    data15 = data908 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data903 & 1, ((data904 << 3) & 248) | (data905 & 7), ((data906 << 3) & 248) | (data907 & 7), data15}, null, null);
                return;
            case R.id.ctv_checkedtext56 /* 2131427877 */:
                int data909 = DataCanbus.DATA[388];
                int data910 = DataCanbus.DATA[389];
                int data911 = DataCanbus.DATA[390];
                int data912 = DataCanbus.DATA[391];
                int data913 = DataCanbus.DATA[392];
                int data914 = DataCanbus.DATA[393];
                if ((data914 & 16) != 0) {
                    data14 = data914 & 239;
                } else {
                    data14 = data914 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data909 & 1, ((data910 << 3) & 248) | (data911 & 7), ((data912 << 3) & 248) | (data913 & 7), data14}, null, null);
                return;
            case R.id.ctv_checkedtext57 /* 2131427878 */:
                int data915 = DataCanbus.DATA[388];
                int data916 = DataCanbus.DATA[389];
                int data917 = DataCanbus.DATA[390];
                int data918 = DataCanbus.DATA[391];
                int data919 = DataCanbus.DATA[392];
                int data920 = DataCanbus.DATA[393];
                if ((data920 & 32) != 0) {
                    data13 = data920 & 223;
                } else {
                    data13 = data920 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data915 & 1, ((data916 << 3) & 248) | (data917 & 7), ((data918 << 3) & 248) | (data919 & 7), data13}, null, null);
                return;
            case R.id.btn_minus56 /* 2131427882 */:
                int data921 = DataCanbus.DATA[394];
                int data922 = DataCanbus.DATA[395];
                int data923 = DataCanbus.DATA[396];
                int data924 = DataCanbus.DATA[397];
                int data925 = DataCanbus.DATA[398];
                int data926 = DataCanbus.DATA[399];
                int data927 = data922 - 1;
                if (data927 < 0) {
                    data927 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data921 & 1, ((data927 << 3) & 248) | (data923 & 7), ((data924 << 3) & 248) | (data925 & 7), data926}, null, null);
                return;
            case R.id.btn_plus56 /* 2131427884 */:
                int data928 = DataCanbus.DATA[394];
                int data929 = DataCanbus.DATA[395];
                int data930 = DataCanbus.DATA[396];
                int data931 = DataCanbus.DATA[397];
                int data932 = DataCanbus.DATA[398];
                int data933 = DataCanbus.DATA[399];
                int data934 = data929 + 1;
                if (data934 > 23) {
                    data934 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data928 & 1, ((data934 << 3) & 248) | (data930 & 7), ((data931 << 3) & 248) | (data932 & 7), data933}, null, null);
                return;
            case R.id.btn_minus57 /* 2131427885 */:
                int data935 = DataCanbus.DATA[394];
                int data936 = DataCanbus.DATA[395];
                int data937 = DataCanbus.DATA[396];
                int data938 = DataCanbus.DATA[397];
                int data939 = DataCanbus.DATA[398];
                int data940 = DataCanbus.DATA[399];
                int data941 = data937 - 1;
                if (data941 < 0) {
                    data941 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data935 & 1, ((data936 << 3) & 248) | (data941 & 7), ((data938 << 3) & 248) | (data939 & 7), data940}, null, null);
                return;
            case R.id.btn_plus57 /* 2131427887 */:
                int data942 = DataCanbus.DATA[394];
                int data943 = DataCanbus.DATA[395];
                int data944 = DataCanbus.DATA[396];
                int data945 = DataCanbus.DATA[397];
                int data946 = DataCanbus.DATA[398];
                int data947 = DataCanbus.DATA[399];
                int data948 = data944 + 1;
                if (data948 > 59) {
                    data948 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data942 & 1, ((data943 << 3) & 248) | (data948 & 7), ((data945 << 3) & 248) | (data946 & 7), data947}, null, null);
                return;
            case R.id.btn_minus58 /* 2131427888 */:
                int data949 = DataCanbus.DATA[394];
                int data950 = DataCanbus.DATA[395];
                int data951 = DataCanbus.DATA[396];
                int data952 = DataCanbus.DATA[397];
                int data953 = DataCanbus.DATA[398];
                int data954 = DataCanbus.DATA[399];
                int data955 = data952 - 1;
                if (data955 < 0) {
                    data955 = 23;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data949 & 1, ((data950 << 3) & 248) | (data951 & 7), ((data955 << 3) & 248) | (data953 & 7), data954}, null, null);
                return;
            case R.id.btn_plus58 /* 2131427890 */:
                int data956 = DataCanbus.DATA[394];
                int data957 = DataCanbus.DATA[395];
                int data958 = DataCanbus.DATA[396];
                int data959 = DataCanbus.DATA[397];
                int data960 = DataCanbus.DATA[398];
                int data961 = DataCanbus.DATA[399];
                int data962 = data959 + 1;
                if (data962 > 23) {
                    data962 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data956 & 1, ((data957 << 3) & 248) | (data958 & 7), ((data962 << 3) & 248) | (data960 & 7), data961}, null, null);
                return;
            case R.id.btn_minus59 /* 2131427891 */:
                int data963 = DataCanbus.DATA[394];
                int data964 = DataCanbus.DATA[395];
                int data965 = DataCanbus.DATA[396];
                int data966 = DataCanbus.DATA[397];
                int data967 = DataCanbus.DATA[398];
                int data968 = DataCanbus.DATA[399];
                int data969 = data967 - 1;
                if (data969 < 0) {
                    data969 = 59;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data963 & 1, ((data964 << 3) & 248) | (data965 & 7), ((data966 << 3) & 248) | (data969 & 7), data968}, null, null);
                return;
            case R.id.btn_plus59 /* 2131427893 */:
                int data970 = DataCanbus.DATA[394];
                int data971 = DataCanbus.DATA[395];
                int data972 = DataCanbus.DATA[396];
                int data973 = DataCanbus.DATA[397];
                int data974 = DataCanbus.DATA[398];
                int data975 = DataCanbus.DATA[399];
                int data976 = data974 + 1;
                if (data976 > 59) {
                    data976 = 0;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data970 & 1, ((data971 << 3) & 248) | (data972 & 7), ((data973 << 3) & 248) | (data976 & 7), data975}, null, null);
                return;
            case R.id.ctv_checkedtext58 /* 2131427894 */:
                int data977 = DataCanbus.DATA[394];
                int data978 = DataCanbus.DATA[395];
                int data979 = DataCanbus.DATA[396];
                int data980 = DataCanbus.DATA[397];
                int data981 = DataCanbus.DATA[398];
                int data982 = DataCanbus.DATA[399];
                if ((data982 & 64) != 0) {
                    data12 = data982 & 191;
                } else {
                    data12 = data982 | 64;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data977 & 1, ((data978 << 3) & 248) | (data979 & 7), ((data980 << 3) & 248) | (data981 & 7), data12}, null, null);
                return;
            case R.id.ctv_checkedtext59 /* 2131427895 */:
                int data983 = DataCanbus.DATA[394];
                int data984 = DataCanbus.DATA[395];
                int data985 = DataCanbus.DATA[396];
                int data986 = DataCanbus.DATA[397];
                int data987 = DataCanbus.DATA[398];
                int data988 = DataCanbus.DATA[399];
                if ((data988 & 1) != 0) {
                    data11 = data988 & 254;
                } else {
                    data11 = data988 | 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data983 & 1, ((data984 << 3) & 248) | (data985 & 7), ((data986 << 3) & 248) | (data987 & 7), data11}, null, null);
                return;
            case R.id.ctv_checkedtext60 /* 2131427896 */:
                int data989 = DataCanbus.DATA[394];
                int data990 = DataCanbus.DATA[395];
                int data991 = DataCanbus.DATA[396];
                int data992 = DataCanbus.DATA[397];
                int data993 = DataCanbus.DATA[398];
                int data994 = DataCanbus.DATA[399];
                if ((data994 & 2) != 0) {
                    data10 = data994 & 253;
                } else {
                    data10 = data994 | 2;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data989 & 1, ((data990 << 3) & 248) | (data991 & 7), ((data992 << 3) & 248) | (data993 & 7), data10}, null, null);
                return;
            case R.id.ctv_checkedtext61 /* 2131427897 */:
                int data995 = DataCanbus.DATA[394];
                int data996 = DataCanbus.DATA[395];
                int data997 = DataCanbus.DATA[396];
                int data998 = DataCanbus.DATA[397];
                int data999 = DataCanbus.DATA[398];
                int data1000 = DataCanbus.DATA[399];
                if ((data1000 & 4) != 0) {
                    data9 = data1000 & 251;
                } else {
                    data9 = data1000 | 4;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data995 & 1, ((data996 << 3) & 248) | (data997 & 7), ((data998 << 3) & 248) | (data999 & 7), data9}, null, null);
                return;
            case R.id.ctv_checkedtext62 /* 2131427898 */:
                int data1001 = DataCanbus.DATA[394];
                int data1002 = DataCanbus.DATA[395];
                int data1003 = DataCanbus.DATA[396];
                int data1004 = DataCanbus.DATA[397];
                int data1005 = DataCanbus.DATA[398];
                int data1006 = DataCanbus.DATA[399];
                if ((data1006 & 8) != 0) {
                    data8 = data1006 & 247;
                } else {
                    data8 = data1006 | 8;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data1001 & 1, ((data1002 << 3) & 248) | (data1003 & 7), ((data1004 << 3) & 248) | (data1005 & 7), data8}, null, null);
                return;
            case R.id.ctv_checkedtext63 /* 2131427899 */:
                int data1007 = DataCanbus.DATA[394];
                int data1008 = DataCanbus.DATA[395];
                int data1009 = DataCanbus.DATA[396];
                int data1010 = DataCanbus.DATA[397];
                int data1011 = DataCanbus.DATA[398];
                int data1012 = DataCanbus.DATA[399];
                if ((data1012 & 16) != 0) {
                    data7 = data1012 & 239;
                } else {
                    data7 = data1012 | 16;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data1007 & 1, ((data1008 << 3) & 248) | (data1009 & 7), ((data1010 << 3) & 248) | (data1011 & 7), data7}, null, null);
                return;
            case R.id.ctv_checkedtext64 /* 2131427900 */:
                int data1013 = DataCanbus.DATA[394];
                int data1014 = DataCanbus.DATA[395];
                int data1015 = DataCanbus.DATA[396];
                int data1016 = DataCanbus.DATA[397];
                int data1017 = DataCanbus.DATA[398];
                int data1018 = DataCanbus.DATA[399];
                if ((data1018 & 32) != 0) {
                    data6 = data1018 & 223;
                } else {
                    data6 = data1018 | 32;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data1013 & 1, ((data1014 << 3) & 248) | (data1015 & 7), ((data1016 << 3) & 248) | (data1017 & 7), data6}, null, null);
                return;
            case R.id.btn_minus61 /* 2131427901 */:
                int data1019 = DataCanbus.DATA[400];
                if (data1019 <= 37) {
                    data2 = 254;
                } else if (data1019 == 254) {
                    data2 = 255;
                } else {
                    data2 = data1019 - 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{5, data2}, null, null);
                return;
            case R.id.btn_plus61 /* 2131427903 */:
                int data1020 = DataCanbus.DATA[400];
                if (data1020 >= 63) {
                    data1 = 255;
                } else if (data1020 == 255) {
                    data1 = 254;
                } else {
                    data1 = data1020 + 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{5, data1}, null, null);
                return;
            case R.id.btn_minus62 /* 2131427904 */:
                int data1021 = DataCanbus.DATA[401] - 1;
                if (data1021 < 1) {
                    data1021 = 3;
                }
                DataCanbus.PROXY.cmd(113, new int[]{6, data1021}, null, null);
                return;
            case R.id.btn_plus62 /* 2131427906 */:
                int data1022 = DataCanbus.DATA[401] + 1;
                if (data1022 > 3) {
                    data1022 = 1;
                }
                DataCanbus.PROXY.cmd(113, new int[]{6, data1022}, null, null);
                return;
            case R.id.ctv_checkedtext65 /* 2131427922 */:
                int data1023 = DataCanbus.DATA[340];
                int data1024 = DataCanbus.DATA[341];
                int data1025 = DataCanbus.DATA[342];
                int data1026 = DataCanbus.DATA[343];
                int data1027 = DataCanbus.DATA[344];
                int data1028 = DataCanbus.DATA[345];
                int data1029 = DataCanbus.DATA[346];
                if (data1023 == 1) {
                    data75 = 0;
                } else {
                    data75 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{1, 1, ((data1029 << 2) & 4) | (data75 & 1), ((data1024 << 3) & 248) | (data1025 & 7), ((data1026 << 3) & 248) | (data1027 & 7), data1028}, null, null);
                return;
            case R.id.ctv_checkedtext66 /* 2131427923 */:
                int data1030 = DataCanbus.DATA[340];
                int data1031 = DataCanbus.DATA[341];
                int data1032 = DataCanbus.DATA[342];
                int data1033 = DataCanbus.DATA[343];
                int data1034 = DataCanbus.DATA[344];
                dialog("充电限制时间表1", 1, 2, (data1030 & 1) | ((DataCanbus.DATA[346] << 2) & 4), (data1032 & 7) | ((data1031 << 3) & 248), (data1034 & 7) | ((data1033 << 3) & 248), DataCanbus.DATA[345]);
                return;
            case R.id.ctv_checkedtext67 /* 2131427924 */:
                int data1035 = DataCanbus.DATA[347];
                int data1036 = DataCanbus.DATA[348];
                int data1037 = DataCanbus.DATA[349];
                int data1038 = DataCanbus.DATA[350];
                int data1039 = DataCanbus.DATA[351];
                int data1040 = DataCanbus.DATA[352];
                int data1041 = DataCanbus.DATA[353];
                if (data1035 == 1) {
                    data67 = 0;
                } else {
                    data67 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{2, 1, ((data1041 << 2) & 4) | (data67 & 1), ((data1036 << 3) & 248) | (data1037 & 7), ((data1038 << 3) & 248) | (data1039 & 7), data1040}, null, null);
                return;
            case R.id.ctv_checkedtext68 /* 2131427925 */:
                int data1042 = DataCanbus.DATA[347];
                int data1043 = DataCanbus.DATA[348];
                int data1044 = DataCanbus.DATA[349];
                int data1045 = DataCanbus.DATA[350];
                int data1046 = DataCanbus.DATA[351];
                dialog("充电限制时间表2", 2, 2, (data1042 & 1) | ((DataCanbus.DATA[353] << 2) & 4), (data1044 & 7) | ((data1043 << 3) & 248), (data1046 & 7) | ((data1045 << 3) & 248), DataCanbus.DATA[352]);
                return;
            case R.id.ctv_checkedtext69 /* 2131427926 */:
                int data1047 = DataCanbus.DATA[358];
                int data1048 = DataCanbus.DATA[359];
                int data1049 = DataCanbus.DATA[360];
                int data1050 = DataCanbus.DATA[361];
                int data1051 = DataCanbus.DATA[362];
                int data1052 = DataCanbus.DATA[363];
                if (data1047 == 1) {
                    data59 = 0;
                } else {
                    data59 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{3, 1, data59 & 1, ((data1048 << 3) & 248) | (data1049 & 7), ((data1050 << 3) & 248) | (data1051 & 7), data1052}, null, null);
                return;
            case R.id.ctv_checkedtext70 /* 2131427927 */:
                int data1053 = DataCanbus.DATA[358];
                int data1054 = DataCanbus.DATA[359];
                int data1055 = DataCanbus.DATA[360];
                int data1056 = DataCanbus.DATA[361];
                int data1057 = DataCanbus.DATA[362];
                dialog("空调预调节时间表1", 3, 2, data1053 & 1, (data1055 & 7) | ((data1054 << 3) & 248), (data1057 & 7) | ((data1056 << 3) & 248), DataCanbus.DATA[363]);
                return;
            case R.id.ctv_checkedtext71 /* 2131427928 */:
                int data1058 = DataCanbus.DATA[364];
                int data1059 = DataCanbus.DATA[365];
                int data1060 = DataCanbus.DATA[366];
                int data1061 = DataCanbus.DATA[367];
                int data1062 = DataCanbus.DATA[368];
                int data1063 = DataCanbus.DATA[369];
                if (data1058 == 1) {
                    data51 = 0;
                } else {
                    data51 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{4, 1, data51 & 1, ((data1059 << 3) & 248) | (data1060 & 7), ((data1061 << 3) & 248) | (data1062 & 7), data1063}, null, null);
                return;
            case R.id.ctv_checkedtext72 /* 2131427929 */:
                int data1064 = DataCanbus.DATA[364];
                int data1065 = DataCanbus.DATA[365];
                int data1066 = DataCanbus.DATA[366];
                int data1067 = DataCanbus.DATA[367];
                int data1068 = DataCanbus.DATA[368];
                dialog("空调预调节时间表2", 4, 2, data1064 & 1, (data1066 & 7) | ((data1065 << 3) & 248), (data1068 & 7) | ((data1067 << 3) & 248), DataCanbus.DATA[369]);
                return;
            case R.id.ctv_checkedtext73 /* 2131427930 */:
                int data1069 = DataCanbus.DATA[370];
                int data1070 = DataCanbus.DATA[371];
                int data1071 = DataCanbus.DATA[372];
                int data1072 = DataCanbus.DATA[373];
                int data1073 = DataCanbus.DATA[374];
                int data1074 = DataCanbus.DATA[375];
                if (data1069 == 1) {
                    data43 = 0;
                } else {
                    data43 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{5, 1, data43 & 1, ((data1070 << 3) & 248) | (data1071 & 7), ((data1072 << 3) & 248) | (data1073 & 7), data1074}, null, null);
                return;
            case R.id.ctv_checkedtext74 /* 2131427931 */:
                int data1075 = DataCanbus.DATA[370];
                int data1076 = DataCanbus.DATA[371];
                int data1077 = DataCanbus.DATA[372];
                int data1078 = DataCanbus.DATA[373];
                int data1079 = DataCanbus.DATA[374];
                dialog("空调预调节时间表3", 5, 2, data1075 & 1, (data1077 & 7) | ((data1076 << 3) & 248), (data1079 & 7) | ((data1078 << 3) & 248), DataCanbus.DATA[375]);
                return;
            case R.id.ctv_checkedtext75 /* 2131427932 */:
                int data1080 = DataCanbus.DATA[376];
                int data1081 = DataCanbus.DATA[377];
                int data1082 = DataCanbus.DATA[378];
                int data1083 = DataCanbus.DATA[379];
                int data1084 = DataCanbus.DATA[380];
                int data1085 = DataCanbus.DATA[381];
                if (data1080 == 1) {
                    data35 = 0;
                } else {
                    data35 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{6, 1, data35 & 1, ((data1081 << 3) & 248) | (data1082 & 7), ((data1083 << 3) & 248) | (data1084 & 7), data1085}, null, null);
                return;
            case R.id.ctv_checkedtext76 /* 2131427933 */:
                int data1086 = DataCanbus.DATA[376];
                int data1087 = DataCanbus.DATA[377];
                int data1088 = DataCanbus.DATA[378];
                int data1089 = DataCanbus.DATA[379];
                int data1090 = DataCanbus.DATA[380];
                dialog("空调预调节时间表4", 6, 2, data1086 & 1, (data1088 & 7) | ((data1087 << 3) & 248), (data1090 & 7) | ((data1089 << 3) & 248), DataCanbus.DATA[381]);
                return;
            case R.id.ctv_checkedtext77 /* 2131427934 */:
                int data1091 = DataCanbus.DATA[382];
                int data1092 = DataCanbus.DATA[383];
                int data1093 = DataCanbus.DATA[384];
                int data1094 = DataCanbus.DATA[385];
                int data1095 = DataCanbus.DATA[386];
                int data1096 = DataCanbus.DATA[387];
                if (data1091 == 1) {
                    data27 = 0;
                } else {
                    data27 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{7, 1, data27 & 1, ((data1092 << 3) & 248) | (data1093 & 7), ((data1094 << 3) & 248) | (data1095 & 7), data1096}, null, null);
                return;
            case R.id.ctv_checkedtext78 /* 2131427935 */:
                int data1097 = DataCanbus.DATA[382];
                int data1098 = DataCanbus.DATA[383];
                int data1099 = DataCanbus.DATA[384];
                int data1100 = DataCanbus.DATA[385];
                int data1101 = DataCanbus.DATA[386];
                dialog("空调预调节时间表5", 7, 2, data1097 & 1, (data1099 & 7) | ((data1098 << 3) & 248), (data1101 & 7) | ((data1100 << 3) & 248), DataCanbus.DATA[387]);
                return;
            case R.id.ctv_checkedtext79 /* 2131427936 */:
                int data1102 = DataCanbus.DATA[388];
                int data1103 = DataCanbus.DATA[389];
                int data1104 = DataCanbus.DATA[390];
                int data1105 = DataCanbus.DATA[391];
                int data1106 = DataCanbus.DATA[392];
                int data1107 = DataCanbus.DATA[393];
                if (data1102 == 1) {
                    data5 = 0;
                } else {
                    data5 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{8, 1, data5 & 1, ((data1103 << 3) & 248) | (data1104 & 7), ((data1105 << 3) & 248) | (data1106 & 7), data1107}, null, null);
                return;
            case R.id.ctv_checkedtext80 /* 2131427937 */:
                int data1108 = DataCanbus.DATA[388];
                int data1109 = DataCanbus.DATA[389];
                int data1110 = DataCanbus.DATA[390];
                int data1111 = DataCanbus.DATA[391];
                int data1112 = DataCanbus.DATA[392];
                dialog("空调预调节时间表6", 8, 2, data1108 & 1, (data1110 & 7) | ((data1109 << 3) & 248), (data1112 & 7) | ((data1111 << 3) & 248), DataCanbus.DATA[393]);
                return;
            case R.id.ctv_checkedtext81 /* 2131427938 */:
                int data1113 = DataCanbus.DATA[394];
                int data1114 = DataCanbus.DATA[395];
                int data1115 = DataCanbus.DATA[396];
                int data1116 = DataCanbus.DATA[397];
                int data1117 = DataCanbus.DATA[398];
                int data1118 = DataCanbus.DATA[399];
                if (data1113 == 1) {
                    data4 = 0;
                } else {
                    data4 = 1;
                }
                DataCanbus.PROXY.cmd(109, new int[]{9, 1, data4 & 1, ((data1114 << 3) & 248) | (data1115 & 7), ((data1116 << 3) & 248) | (data1117 & 7), data1118}, null, null);
                return;
            case R.id.ctv_checkedtext82 /* 2131427939 */:
                int data1119 = DataCanbus.DATA[394];
                int data1120 = DataCanbus.DATA[395];
                int data1121 = DataCanbus.DATA[396];
                int data1122 = DataCanbus.DATA[397];
                int data1123 = DataCanbus.DATA[398];
                dialog("空调预调节时间表7", 9, 2, data1119 & 1, (data1121 & 7) | ((data1120 << 3) & 248), (data1123 & 7) | ((data1122 << 3) & 248), DataCanbus.DATA[399]);
                return;
            default:
                return;
        }
        int data1124 = DataCanbus.DATA[376];
        int data1125 = DataCanbus.DATA[377];
        int data1126 = DataCanbus.DATA[378];
        int data1127 = DataCanbus.DATA[379];
        int data1128 = DataCanbus.DATA[380];
        int data1129 = DataCanbus.DATA[381];
        if ((data1129 & 64) != 0) {
            data34 = data1129 & 191;
        } else {
            data34 = data1129 | 4;
        }
        DataCanbus.PROXY.cmd(109, new int[]{6, 1, data1124 & 1, ((data1125 << 3) & 248) | (data1126 & 7), ((data1127 << 3) & 248) | (data1128 & 7), data34}, null, null);
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
