package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0112_RZC_XP1_Carmy;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class CamryPM25HistoryAct extends BaseActivity {
    public static CamryPM25HistoryAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryPM25HistoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 288:
                    int value = DataCanbus.DATA[288];
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.camry_progressbar_trip_current)).setProgress(value);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.camry_progressbar_trip_current)).invalidate();
                    break;
                case 289:
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view1)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[0]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view1)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view2)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[1]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view2)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view3)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[2]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view3)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view4)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[3]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view4)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view5)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[4]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view5)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view6)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[5]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view6)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view7)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[6]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view7)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view8)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[7]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view8)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view9)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[8]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view9)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view10)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[9]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view10)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view11)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[10]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view11)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view12)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[11]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view12)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view13)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[12]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view13)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view14)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[13]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view14)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view15)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[14]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view15)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view16)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[15]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view16)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view17)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[16]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view17)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view18)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[17]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view18)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view19)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[18]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view19)).invalidate();
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view20)).setProgress(Callback_0112_RZC_XP1_Carmy.mMinutePm25expend[19]);
                    ((VerticalProgressbar) CamryPM25HistoryAct.this.findViewById(R.id.layout_view20)).invalidate();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_pm25_history);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{75, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[288].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[289].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[288].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[289].removeNotify(this.mNotifyCanbus);
    }
}
