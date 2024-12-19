package com.syu.ui.carvol;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CarVolView extends ViewGroup {
    private int i;
    int iLastVal;
    int iVal;
    private TextView mTvCarVol;
    private View mView;

    public CarVolView(Context context) {
        super(context);
        this.iLastVal = -1;
        this.iVal = -1;
        init(context);
    }

    private void init(Context context) {
        this.mView = inflate(context, R.layout.car_vol, null);
        addView(this.mView);
        this.mTvCarVol = (TextView) this.mView.findViewById(R.id.tv_carvol);
    }

    public void setCarVol() {
        this.iVal = DataCanbus.DATA[CarVolHelper.mCarVol_ID];
        if (this.iVal != this.iLastVal && this.mTvCarVol != null) {
            this.mTvCarVol.setText(new StringBuilder().append(this.iVal).toString());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mView.measure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.mView.getMeasuredWidth(), this.mView.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        setCarVol();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            this.mView.layout(l, t, r, b);
        }
    }
}
