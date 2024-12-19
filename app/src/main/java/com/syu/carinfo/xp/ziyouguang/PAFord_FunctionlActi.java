package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAFord_FunctionlActi extends Activity {
    List<CarInfo> mList = new ArrayList();
    int[] titles = {R.string.rzc_others_language_setting, R.string.wc_273_unit, R.string.wc_372_amblight, R.string.str_mic_set, R.string.str_guandao_amp, R.string.str_pitch_and_roll};
    Class[] clsess = {Activity_0452_PA_Ford_Language.class, Activity_0452_PA_Ford_Unit.class, Activity_0452_PA_Ford_AmbientLightSet.class, Activity_0452_PA_Ford_MICtype.class, Activity_0452_PA_Ford_AmpSet.class, Activity_0452_PA_Ford_PitchAndRoll.class};

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        initValue();
        AdapterCarInfo adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.wc_jianianhua_settings_title);
    }

    private void initValue() {
        for (int i = 0; i < this.titles.length; i++) {
            CarInfo carInfo = new CarInfo(4, 0, getString(this.titles[i]));
            carInfo.setCls(this.clsess[i]);
            this.mList.add(carInfo);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
