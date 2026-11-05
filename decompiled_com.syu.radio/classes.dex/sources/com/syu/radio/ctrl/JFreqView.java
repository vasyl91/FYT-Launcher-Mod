package com.syu.radio.ctrl;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.util.FuncUtils;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JFreqView extends View {
    Drawable[] icoDrawables;
    String[] iconName;
    String mCurrentFreq;
    Drawable[] numDrawables;
    private JPage page;

    public JFreqView(JPage page) {
        super(page.ui.mContext);
        this.numDrawables = new Drawable[6];
        this.icoDrawables = null;
        this.page = page;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable d;
        int left;
        super.onDraw(canvas);
        if (this.mCurrentFreq != null) {
            int len = this.mCurrentFreq.length();
            if (len > 6) {
                len = 6;
            }
            int width = getRight() - getLeft();
            int height = getBottom() - getTop();
            int w = 0;
            if (this.numDrawables != null && this.numDrawables.length > 0 && (d = this.numDrawables[0]) != null) {
                int h = (int) (d.getIntrinsicHeight() * App_Radio.RulerScale * this.page.ui.mScale);
                for (int i = 0; i < len; i++) {
                    w += (int) (this.numDrawables[i].getIntrinsicWidth() * App_Radio.RulerScale * this.page.ui.mScale);
                }
                int x = (width - w) / 2;
                int y = (height - h) / 2;
                int i2 = 0;
                int left2 = x;
                while (i2 < len) {
                    Drawable sd = this.numDrawables[i2];
                    if (sd != null) {
                        left = (int) (left2 + (sd.getIntrinsicWidth() * App_Radio.RulerScale * this.page.ui.mScale));
                        sd.setBounds(left2, y, left, y + h);
                        sd.draw(canvas);
                    } else {
                        left = left2;
                    }
                    i2++;
                    left2 = left;
                }
                if (this.icoDrawables != null && this.icoDrawables.length > 12) {
                    Drawable sd2 = null;
                    if (!TextUtils.isEmpty(this.mCurrentFreq)) {
                        if (this.mCurrentFreq.contains(".")) {
                            sd2 = this.icoDrawables[12];
                        } else {
                            sd2 = this.icoDrawables[11];
                        }
                    }
                    if (sd2 != null) {
                        sd2.setBounds(left2, (int) ((y + h) - ((sd2.getIntrinsicHeight() * App_Radio.RulerScale) * this.page.ui.mScale)), (int) (left2 + (sd2.getIntrinsicWidth() * App_Radio.RulerScale * this.page.ui.mScale)), y + h);
                        sd2.draw(canvas);
                    }
                }
            }
        }
    }

    public void setIconName(String... strs) {
        this.iconName = strs;
        if (this.iconName.length > 0) {
            this.icoDrawables = new Drawable[this.iconName.length];
            for (int t = 0; t < this.iconName.length; t++) {
                this.icoDrawables[t] = this.page.getDrawableFromPath(this.iconName[t], this.page.mDrawables, null);
            }
        }
    }

    public void setCurrenFreq(String freq) {
        if (freq != null && !FuncUtils.isEquals(this.mCurrentFreq, freq)) {
            this.mCurrentFreq = freq;
            checkDrawableFromFreq();
            invalidate();
        }
    }

    private void checkDrawableFromFreq() {
        if (!TextUtils.isEmpty(this.mCurrentFreq) && this.icoDrawables != null) {
            char[] chars = this.mCurrentFreq.toCharArray();
            for (int index = 0; index < chars.length && index < 6; index++) {
                char val = chars[index];
                if (val == '.') {
                    this.numDrawables[index] = this.icoDrawables[10];
                } else if (val >= '0' && val <= '9') {
                    int num = Integer.valueOf(new String(new char[]{val})).intValue();
                    this.numDrawables[index] = this.icoDrawables[num];
                }
            }
        }
    }
}
