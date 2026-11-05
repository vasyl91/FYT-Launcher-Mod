package com.lsec.core.frame.ctrl;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.util.FuncUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JText extends TextView {
    boolean bAttached;
    private boolean bMarQuee;
    boolean bWillUpdateBackground;
    public boolean focus;
    public int iColor;
    int iState;
    int[] mColor;
    public HashMap<String, Drawable> mDrawables;
    public List<String> mListStrWithColor;
    String mStrDrawable;
    String mStrDrawableFix;
    String mStrLanguage;
    String mStrSpan;
    String mStrTextBak;
    private JPage page;

    public JText(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.iState = -1;
        this.bMarQuee = false;
        this.focus = false;
        this.mListStrWithColor = new ArrayList();
        this.iColor = 255;
        this.mDrawables = new HashMap<>();
        this.page = page;
    }

    public int getState() {
        return this.iState;
    }

    public void setColor(int... color) {
        this.mColor = color;
        updateBackground();
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        updateBackground();
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.iState = -1;
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        int iStateBak = this.iState;
        if (this.focus) {
            this.iState = 1;
        } else if (!isEnabled()) {
            this.iState = 2;
        } else {
            this.iState = 0;
        }
        if (iStateBak != this.iState) {
            if (this.mColor != null && this.mColor.length > this.iState) {
                setTextColor(this.mColor[this.iState]);
            }
            if (this.mStrDrawable != null) {
                this.mStrDrawableFix = this.mStrDrawable;
                switch (this.iState) {
                    case 1:
                        this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_p";
                        break;
                    case 2:
                        this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_u";
                        break;
                }
                Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables);
                setBackground(drawable);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        updateBackground();
    }

    public void setMarQuee(boolean bMarQuee) {
        this.bMarQuee = bMarQuee;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.bMarQuee;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (this.bMarQuee && w > 0 && h > 0) {
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setMarqueeRepeatLimit(-1);
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws Throwable {
        Object tag = getTag();
        if (tag instanceof MyUiItem) {
            MyUiItem item = (MyUiItem) tag;
            String strTextConf = item.getTextConf();
            if (!TextUtils.isEmpty(strTextConf)) {
                Locale localeDefault = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    localeDefault = LocaleList.getDefault().get(0);
                }
                String strLanguage = String.valueOf(localeDefault.getLanguage()) + "-" + localeDefault.getCountry();
                if (!strLanguage.equals(this.mStrLanguage) && getText().toString().equals(this.mStrTextBak)) {
                    String str = this.page.ui.getString(strTextConf);
                    setText(str);
                    setTextBak(str, strLanguage);
                    if (FuncUtils.isLongLang(localeDefault)) {
                        setTextSize(0, item.getHeight() - 2);
                    } else {
                        setTextSize(0, item.getHeight());
                    }
                }
            }
        }
        int iCntWithColor = this.mListStrWithColor.size();
        if (iCntWithColor > 0 && !getText().toString().equals(this.mStrSpan)) {
            this.mStrSpan = getText().toString();
            SpannableStringBuilder style = new SpannableStringBuilder(this.mStrSpan);
            for (String str2 : this.mListStrWithColor) {
                int iStartColor = this.mStrSpan.indexOf(str2);
                if (iStartColor >= 0) {
                    int iEndColor = iStartColor + str2.length();
                    style.setSpan(new ForegroundColorSpan(this.iColor), iStartColor, iEndColor, 33);
                }
            }
            setText(style);
        }
        super.onDraw(canvas);
    }

    public void setTextBak(String text, String strLanguage) {
        this.mStrTextBak = text;
        this.mStrLanguage = strLanguage;
    }

    public void mySetText(String strConf) throws Throwable {
        Object tag = getTag();
        if (tag instanceof MyUiItem) {
            MyUiItem item = (MyUiItem) tag;
            item.setTextConf(strConf);
        }
        Locale localeDefault = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            localeDefault = LocaleList.getDefault().get(0);
        }
        String strLanguage = String.valueOf(localeDefault.getLanguage()) + "-" + localeDefault.getCountry();
        String str = this.page.ui.getString(strConf);
        setText(str);
        setTextBak(str, strLanguage);
    }
}
