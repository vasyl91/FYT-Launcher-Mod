package com.syu.carinfo.xp.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class Xp_374_AegeaIndexActi extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_geshitu_wc_index);
        findViewById(R.id.wc_geshitu_btn_trip).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.sCanbusId) {
                        case FinalCanbus.CAR_XP_Renault_17Captur /* 65960 */:
                        case FinalCanbus.CAR_XP_Renault_17Clio /* 131496 */:
                        case FinalCanbus.CAR_XP_Renault_17Symbol /* 197032 */:
                        case FinalCanbus.CAR_XP_Renault_17Kwid /* 262568 */:
                        case FinalCanbus.CAR_XP_Dacia_16Duster /* 328104 */:
                        case FinalCanbus.CAR_XP_Dacia_17Lodgy /* 393640 */:
                        case FinalCanbus.CAR_XP_Dacia_17Logan /* 459176 */:
                        case FinalCanbus.CAR_XP_Dacia_17Dokker /* 524712 */:
                        case FinalCanbus.CAR_XP_Dacia_10_15Duster /* 590248 */:
                        case FinalCanbus.CAR_XP_Dacia_16Sandero /* 655784 */:
                        case FinalCanbus.CAR_XP_Dacia_17Sandero /* 721320 */:
                        case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
                        case FinalCanbus.CAR_XP_Renault_20Clio_M /* 1049000 */:
                        case FinalCanbus.CAR_XP_Renault_20Clio_H /* 1114536 */:
                        case FinalCanbus.CAR_XP_Renault_05_17Duster /* 1180072 */:
                        case FinalCanbus.CAR_XP_Renault_20ARKANA /* 1245608 */:
                        case FinalCanbus.CAR_XP_Renault_15KOLEOS /* 1376680 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                            intent.setClass(Xp_374_AegeaIndexActi.this, Xp_424_OilDisplayActi.class);
                            break;
                        default:
                            intent.setClass(Xp_374_AegeaIndexActi.this, Xp_374_OilDisplayActi.class);
                            break;
                    }
                    Xp_374_AegeaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.wc_geshitu_btn_setting).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    switch (DataCanbus.sCanbusId) {
                        case FinalCanbus.CAR_XP_Renault_17Captur /* 65960 */:
                        case FinalCanbus.CAR_XP_Renault_17Clio /* 131496 */:
                        case FinalCanbus.CAR_XP_Renault_17Symbol /* 197032 */:
                        case FinalCanbus.CAR_XP_Renault_17Kwid /* 262568 */:
                        case FinalCanbus.CAR_XP_Dacia_16Duster /* 328104 */:
                        case FinalCanbus.CAR_XP_Dacia_17Lodgy /* 393640 */:
                        case FinalCanbus.CAR_XP_Dacia_17Logan /* 459176 */:
                        case FinalCanbus.CAR_XP_Dacia_17Dokker /* 524712 */:
                        case FinalCanbus.CAR_XP_Dacia_10_15Duster /* 590248 */:
                        case FinalCanbus.CAR_XP_Dacia_16Sandero /* 655784 */:
                        case FinalCanbus.CAR_XP_Dacia_17Sandero /* 721320 */:
                        case FinalCanbus.CAR_XP_Renault_05_17Duster /* 1180072 */:
                        case FinalCanbus.CAR_XP_Renault_20ARKANA /* 1245608 */:
                        case FinalCanbus.CAR_XP_Renault_15KOLEOS /* 1376680 */:
                            intent.setClass(Xp_374_AegeaIndexActi.this, Activity_424_FuncSet.class);
                            break;
                        case FinalCanbus.CAR_XP_Renault_20Clio_Low /* 786856 */:
                        case FinalCanbus.CAR_XP_Renault_20Clio_M /* 1049000 */:
                        case FinalCanbus.CAR_XP_Renault_20Clio_H /* 1114536 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Auto /* 1442216 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_L_Hand /* 1507752 */:
                        case FinalCanbus.CAR_XP_Renault_23KOLEOS_H_Auto /* 1573288 */:
                            intent.setClass(Xp_374_AegeaIndexActi.this, Activity_424_ClioFuncSet.class);
                            break;
                        default:
                            intent.setClass(Xp_374_AegeaIndexActi.this, Xp_374_FunctionlActi.class);
                            break;
                    }
                    Xp_374_AegeaIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
