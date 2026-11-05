package com.syu.radio.page;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.MyPage;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.db.Radio_Info;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_CityInfo extends MyPage {
    Act_Radio actRadio;
    public String str_city;

    public Page_CityInfo(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.str_city = null;
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() {
        EditText editCity = (EditText) getPage().getChildViewByid(FinalRadioCtrl.CityInfo_Edit_City);
        if (editCity != null) {
            if (App_Radio.mCity == null) {
                if (!TextUtils.isEmpty("radio_info_city")) {
                    editCity.setText(getString("radio_info_city"));
                    return;
                }
                return;
            }
            editCity.setText(App_Radio.mCity);
        }
    }

    public void doAfterDel() {
        this.actRadio.initlist(false, false, true);
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.CityInfo_Btn_Ok /* 130326 */:
                EditText editCity = (EditText) getPage().getChildViewByid(FinalRadioCtrl.CityInfo_Edit_City);
                if (editCity != null) {
                    this.str_city = editCity.getText().toString().trim();
                }
                if (this.str_city.equals("1234")) {
                    this.str_city = "深圳市";
                }
                String strLocale = Locale.getDefault().toString();
                if (strLocale.indexOf("zh_CN") >= 0 && this.str_city.indexOf("市") < 0 && this.str_city.indexOf("盟") < 0 && this.str_city.indexOf("旗") < 0) {
                    this.str_city = String.valueOf(this.str_city) + "市";
                }
                Log.d(Radio_Info.CITY, " 000 str_city = " + this.str_city + " App_Radio.mCity = " + App_Radio.mCity);
                if (this.str_city != null && !this.str_city.equals(App_Radio.mCity)) {
                    Log.d(Radio_Info.CITY, " 111 str_city = " + this.str_city);
                    App_Radio.mCity = this.str_city;
                    for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                        interfaceRadio.initlist(false, false, true);
                    }
                    Page_Info.cityName.setText(App_Radio.mCity);
                }
                getPage().getDialog().dismiss();
                break;
            case FinalRadioCtrl.CityInfo_Btn_Cancel /* 130327 */:
                getPage().getDialog().dismiss();
                break;
        }
    }
}
