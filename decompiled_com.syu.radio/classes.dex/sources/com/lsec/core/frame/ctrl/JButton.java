package com.lsec.core.frame.ctrl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.FuncUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JButton extends TextView {
    boolean bAttached;
    public boolean bEnablePressState;
    public boolean bPartnerDependent;
    public boolean bUpdateBkOnPress;
    boolean bWillUpdateBackground;
    public boolean focus;
    int iState;
    int[] mColor;
    int[] mColorBk;
    public HashMap<String, Drawable> mDrawables;
    public Drawable mIcon;
    public List<View> mPartnerViews;
    public int[] mPosIcon;
    String mStrDrawable;
    String mStrDrawableFix;
    String mStrIcon;
    String mStrIconFix;
    String mStrLanguage;
    String mStrTextBak;
    public JPage page;
    public JPage pagePress;

    public JButton(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.iState = -1;
        this.focus = false;
        this.bUpdateBkOnPress = true;
        this.bPartnerDependent = false;
        this.bEnablePressState = true;
        this.mDrawables = new HashMap<>();
        this.page = page;
    }

    public int getState() {
        return this.iState;
    }

    public void setUpdateBkOnPress(boolean bUpdateOnPress) {
        this.bUpdateBkOnPress = bUpdateOnPress;
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

    public String getStrDrawable() {
        return this.mStrDrawable;
    }

    public void setIcon(int[] iPosIcon, String icon) {
        if (iPosIcon != null && iPosIcon.length == 4) {
            if (this.mPosIcon == null) {
                this.mPosIcon = new int[4];
            }
            this.mPosIcon[0] = iPosIcon[0];
            this.mPosIcon[1] = iPosIcon[1];
            this.mPosIcon[2] = iPosIcon[2];
            this.mPosIcon[3] = iPosIcon[3];
        }
        this.mStrIcon = icon;
    }

    public void setColor(int... color) {
        this.mColor = color;
        updateBackground();
    }

    public void setColorBk(int... colorBk) {
        this.mColorBk = colorBk;
        updateBackground();
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        updateBackground();
        IPageNotify pageNotify = this.page.getNotify();
        if (pageNotify != null) {
            pageNotify.setPressed(this, pressed);
        }
        if (this.pagePress != null) {
            this.pagePress.onPress(pressed);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setFocusable(true);
        } else {
            setFocusable(false);
        }
        updateBackground();
    }

    public void setPartnerFocus(boolean bFocus) {
        if (this.mPartnerViews != null) {
            for (View view : this.mPartnerViews) {
                MyUiItem item = (MyUiItem) view.getTag();
                switch (item.getType()) {
                    case 7:
                        ((JView) view).setFocus(bFocus);
                        break;
                    case 12:
                        ((JText) view).setFocus(bFocus);
                        break;
                }
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
        } else if (isFocused()) {
            this.iState = 3;
        } else if (!isEnabled()) {
            this.iState = 2;
        } else if (this.bEnablePressState && isPressed()) {
            this.iState = 1;
        } else {
            this.iState = 0;
        }
        if (!this.bPartnerDependent) {
            setPartnerFocus(this.iState == 1);
        }
        if (iStateBak != this.iState) {
            if (this.mColor != null && this.mColor.length > this.iState) {
                setTextColor(this.mColor[this.iState]);
            }
            if (this.bUpdateBkOnPress) {
                if (this.mStrDrawable != null) {
                    this.mStrDrawableFix = this.mStrDrawable;
                    Drawable drawable = null;
                    switch (this.iState) {
                        case 1:
                            this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_p";
                            break;
                        case 2:
                            this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_u";
                            break;
                        case 3:
                            this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_f";
                            Drawable drawableFocus = this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables);
                            if (drawableFocus == null) {
                                this.mStrDrawableFix = String.valueOf(this.mStrDrawable) + "_p";
                            } else {
                                drawable = drawableFocus;
                            }
                            break;
                    }
                    if (drawable == null) {
                        drawable = this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables);
                    }
                    setBackground(drawable);
                } else if (this.mColorBk != null && this.mColorBk.length > this.iState) {
                    ColorDrawable colorDrawable = new ColorDrawable(this.mColorBk[this.iState]);
                    setBackground(colorDrawable);
                }
            }
            if (this.mStrIcon != null && this.mPosIcon != null) {
                this.mStrIconFix = this.mStrIcon;
                Drawable drawable2 = null;
                switch (this.iState) {
                    case 1:
                        this.mStrIconFix = String.valueOf(this.mStrIconFix) + "_p";
                        break;
                    case 2:
                        this.mStrIconFix = String.valueOf(this.mStrIconFix) + "_u";
                        break;
                    case 3:
                        this.mStrIconFix = String.valueOf(this.mStrIconFix) + "_f";
                        Drawable drawableFocus2 = this.page.getDrawableFromPath(this.mStrIconFix, this.page.mDrawables, this.mDrawables);
                        if (drawableFocus2 == null) {
                            this.mStrIconFix = String.valueOf(this.mStrIcon) + "_p";
                        } else {
                            drawable2 = drawableFocus2;
                        }
                        break;
                }
                if (drawable2 == null) {
                    drawable2 = this.page.getDrawableFromPath(this.mStrIconFix, this.page.mDrawables, this.mDrawables);
                }
                this.mIcon = drawable2;
                invalidate();
            }
        }
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
        super.onDraw(canvas);
        if (this.mIcon != null) {
            this.mIcon.setBounds(this.mPosIcon[0], this.mPosIcon[1], this.mPosIcon[2], this.mPosIcon[3]);
            this.mIcon.draw(canvas);
            this.mIcon.setBounds(0, 0, this.mIcon.getIntrinsicWidth(), this.mIcon.getIntrinsicHeight());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        setFocus(focused);
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
