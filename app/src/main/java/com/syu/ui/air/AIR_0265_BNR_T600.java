package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;

@SuppressWarnings({"deprecation", "unchecked"})
public class AIR_0265_BNR_T600 extends AirBase {
    public AIR_0265_BNR_T600(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0265_RZC_ZhongTaiDaMaiX5/bnt_t600.webp";
        this.mPathHighlight = "0265_RZC_ZhongTaiDaMaiX5/bnt_t600_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //
    }
}
