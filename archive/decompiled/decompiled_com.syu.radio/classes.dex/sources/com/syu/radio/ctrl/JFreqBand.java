package com.syu.radio.ctrl;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.util.FuncUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JFreqBand extends View {
    Drawable[] icoDrawables;
    String[] iconName;
    String mCurrentBand;
    Drawable[] numDrawables;
    private JPage page;

    public JFreqBand(JPage page) {
        super(page.ui.mContext);
        this.numDrawables = new Drawable[6];
        this.icoDrawables = null;
        this.page = page;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable d;
        super.onDraw(canvas);
        if (this.mCurrentBand != null) {
            int width = getRight() - getLeft();
            int height = getBottom() - getTop();
            int w = 0;
            if (this.numDrawables != null && this.numDrawables.length > 0 && (d = this.numDrawables[0]) != null) {
                int h = (int) (d.getIntrinsicHeight() * this.page.ui.mScale);
                for (int i = 0; i < 4; i++) {
                    w += (int) (this.numDrawables[i].getIntrinsicWidth() * this.page.ui.mScale);
                }
                int x = (width - w) / 2;
                int y = (height - h) / 2;
                int left = x;
                int i2 = 0;
                while (true) {
                    int left2 = left;
                    if (i2 < 4) {
                        Drawable sd = this.numDrawables[i2];
                        if (sd != null) {
                            left = (int) (left2 + (sd.getIntrinsicWidth() * this.page.ui.mScale));
                            sd.setBounds(left2, y, left, y + h);
                            sd.draw(canvas);
                        } else {
                            left = left2;
                        }
                        i2++;
                    } else {
                        return;
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

    public void setCurrenBand(String band) {
        if (band != null && !FuncUtils.isEquals(this.mCurrentBand, band)) {
            this.mCurrentBand = band;
            checkDrawableFromFreq();
            invalidate();
        }
    }

    private void checkDrawableFromFreq() {
        int iIndexNum;
        if (!TextUtils.isEmpty(this.mCurrentBand) && this.icoDrawables != null) {
            if (this.mCurrentBand.contains("AM")) {
                int iIndexNum2 = 0 + 1;
                this.numDrawables[0] = this.icoDrawables[11];
                iIndexNum = iIndexNum2;
            } else {
                int iIndexNum3 = 0 + 1;
                this.numDrawables[0] = this.icoDrawables[10];
                iIndexNum = iIndexNum3;
            }
            char[] chars = this.mCurrentBand.toCharArray();
            for (int index = 3; index < chars.length; index++) {
                char val = chars[index];
                if (val == '-') {
                    this.numDrawables[iIndexNum] = this.icoDrawables[0];
                    iIndexNum++;
                } else {
                    try {
                        int num = Integer.valueOf(new String(new char[]{val})).intValue();
                        this.numDrawables[iIndexNum] = this.icoDrawables[num];
                        iIndexNum++;
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
