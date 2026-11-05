package com.lsec.core.frame.ctrl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.widget.TextView;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.util.FuncUtils;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JCheckBox extends TextView {
    boolean bAttached;
    boolean bWillSetIconName;
    boolean bWillUpdateBackground;
    Drawable[] drawable;
    int flag;
    int iState;
    String[] iconNames;
    boolean isCheck;
    public HashMap<String, Drawable> mDrawables;
    String mStrDrawable;
    String mStrDrawableFix;
    String mStrLanguage;
    String mStrTextBak;
    private JPage page;
    Paint paint;
    String text;
    float textSize;

    public JCheckBox(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.bWillSetIconName = false;
        this.iState = -1;
        this.isCheck = false;
        this.textSize = 18.0f;
        this.mDrawables = new HashMap<>();
        this.page = page;
        this.paint = new Paint();
        this.paint.setColor(-256);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(4.0f);
    }

    public JPage getPage() {
        return this.page;
    }

    public void setIconName(String[] iconNames) {
        this.iconNames = iconNames;
        if (iconNames != null) {
            if (this.bAttached) {
                this.drawable = new Drawable[2];
                int i = 0;
                for (String icon : iconNames) {
                    if (i > 1) {
                        break;
                    }
                    this.drawable[i] = this.page.getDrawableFromPath(icon, this.page.mDrawables, null);
                    i++;
                }
                invalidate();
                return;
            }
            this.bWillSetIconName = true;
        }
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
        if (isPressed()) {
            this.iState = 1;
        } else {
            this.iState = 0;
        }
        if (iStateBak != this.iState && this.mStrDrawable != null) {
            this.mStrDrawableFix = this.mStrDrawable;
            switch (this.iState) {
                case 1:
                    this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_p";
                    break;
            }
            setBackground(this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        updateBackground();
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
        if (this.drawable != null && this.drawable.length > 0) {
            Drawable d = this.drawable[this.isCheck ? (char) 1 : (char) 0];
            if (d != null) {
                int w = d.getIntrinsicWidth();
                int h = d.getIntrinsicHeight();
                d.setBounds(0, 0, w, h);
                Rect[] rec = ((MyUiItem) getTag()).getRect();
                if (rec != null && rec.length >= 1) {
                    super.onDraw(canvas);
                    canvas.save();
                    canvas.translate(rec[0].left, (getHeight() - this.page.ui.getFixValue(h, true)) / 2);
                    canvas.scale(this.page.ui.mScale, this.page.ui.mScale);
                    d.draw(canvas);
                    canvas.restore();
                } else {
                    canvas.save();
                    canvas.translate(this.page.ui.getFixValue(w + 5, true), 0.0f);
                    super.onDraw(canvas);
                    canvas.restore();
                    canvas.save();
                    canvas.translate(0.0f, (getHeight() - this.page.ui.getFixValue(h, true)) / 2);
                    canvas.scale(this.page.ui.mScale, this.page.ui.mScale);
                    d.draw(canvas);
                    canvas.restore();
                }
                if (isFocused()) {
                    canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
                }
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(float textSize) {
        this.textSize = textSize;
        super.setTextSize(textSize);
    }

    public void setText(String text) {
        if (text != null) {
            super.setText((CharSequence) text);
        }
    }

    public boolean isChecked() {
        return this.isCheck;
    }

    public void setChecked(boolean checked) {
        this.isCheck = checked;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillSetIconName) {
            this.bWillSetIconName = false;
            setIconName(this.iconNames);
        }
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
