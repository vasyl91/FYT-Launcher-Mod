package com.lsec.core.frame.ctrl;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.lsec.core.frame.app.MyUi;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.data.FinalChip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JPage extends FrameLayout {
    boolean bAttached;
    boolean bWillUpdateBackground;
    private Dialog dlg;
    public boolean focus;
    public JGridView gridView;
    int iChildTag;
    int iGroupTag;
    int iKeyChildView;
    int iState;
    public JListApp listApp;
    public JListViewEx listViewEx;
    public SparseArray<View> mChildView;
    public HashMap<String, Drawable> mDrawables;
    public String mLanguage;
    public List<Integer> mListChildPageId;
    public List<Integer> mListParseViewId;
    IPageNotify mNotify;
    String mStrDrawable;
    String mStrDrawableFix;
    public String mStrHeadXml;
    public MyUi ui;

    public JPage(Context context, MyUi ui) {
        super(context);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mListChildPageId = new ArrayList();
        this.mListParseViewId = new ArrayList();
        this.mChildView = new SparseArray<>();
        this.iKeyChildView = 1073741823;
        this.iState = -1;
        this.iChildTag = -1;
        this.iGroupTag = -1;
        this.focus = false;
        this.mLanguage = FinalChip.BSP_PLATFORM_Null;
        this.mStrHeadXml = FinalChip.BSP_PLATFORM_Null;
        this.mDrawables = new HashMap<>();
        this.ui = ui;
    }

    public void setListApp(JListApp listApp) {
        this.listApp = listApp;
    }

    public void setGridView(JGridView gridView) {
        this.gridView = gridView;
    }

    public void setListViewEx(JListViewEx listViewEx) {
        this.listViewEx = listViewEx;
    }

    public void setNotify(IPageNotify page) {
        this.mNotify = page;
    }

    public IPageNotify getNotify() {
        return this.mNotify;
    }

    public void setDialog(Dialog dlg) {
        this.dlg = dlg;
    }

    public Dialog getDialog() {
        return this.dlg;
    }

    public int getState() {
        return this.iState;
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

    @SuppressLint({"NewApi"})
    public void addChildView(View view, MyUiItem item) {
        int iType = item.getType();
        switch (iType) {
            case 7:
                String[] strPara = item.getParaStr();
                if (strPara != null) {
                    for (String strTmp : strPara) {
                        if (strTmp.contains("click")) {
                            view.setOnClickListener(new View.OnClickListener() { // from class: com.lsec.core.frame.ctrl.JPage.5
                                @Override // android.view.View.OnClickListener
                                public void onClick(View v) {
                                    if (JPage.this.mNotify != null) {
                                        JPage.this.mNotify.ResponseClick(v);
                                    }
                                }
                            });
                        }
                    }
                }
                break;
            case 11:
                view.setOnClickListener(new View.OnClickListener() { // from class: com.lsec.core.frame.ctrl.JPage.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (JPage.this.mNotify != null) {
                            JPage.this.mNotify.ResponseClick(v);
                        }
                    }
                });
                if (item.isLongClick()) {
                    view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lsec.core.frame.ctrl.JPage.2
                        @Override // android.view.View.OnLongClickListener
                        public boolean onLongClick(View v) {
                            if (JPage.this.mNotify != null) {
                                JPage.this.mNotify.ResponseLongClick(v);
                                return true;
                            }
                            return true;
                        }
                    });
                }
                break;
            case 19:
                JSwitchButton switchButton = (JSwitchButton) view;
                if (switchButton.bIsCheckBox) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.lsec.core.frame.ctrl.JPage.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            JSwitchButton switchButton2 = (JSwitchButton) v;
                            switchButton2.setChecked(!switchButton2.isChecked());
                            if (JPage.this.mNotify != null) {
                                JPage.this.mNotify.ResponseClick(v);
                            }
                        }
                    });
                }
                break;
            case 20:
                view.setOnClickListener(new View.OnClickListener() { // from class: com.lsec.core.frame.ctrl.JPage.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (JPage.this.mNotify != null) {
                            JPage.this.mNotify.ResponseClick(v);
                        }
                    }
                });
                break;
        }
        view.setTag(item);
        if (-1 != view.getId()) {
            this.mChildView.put(view.getId(), view);
        } else {
            this.mChildView.put(this.iKeyChildView, view);
        }
        if (view instanceof JPage) {
            this.mListChildPageId.add(Integer.valueOf(view.getId()));
        }
        this.mListParseViewId.add(Integer.valueOf(view.getId()));
        this.iKeyChildView++;
    }

    public View getChildViewByid(int id) {
        View view = this.mChildView.get(id);
        return view;
    }

    public void setChildTag(int iTag) {
        this.iChildTag = iTag;
    }

    public int getChildTag() {
        return this.iChildTag;
    }

    public void setGroupTag(int iTag) {
        this.iGroupTag = iTag;
    }

    public int getGroupTag() {
        return this.iGroupTag;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        updateBackground();
    }

    public void onPress(boolean pressed) {
        if (this.listApp != null) {
            if (pressed) {
                this.listApp.viewAppSelect = this;
            }
            IPageNotify pageNotify = this.listApp.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.listAppPressed(this.listApp, this, pressed);
                return;
            }
            return;
        }
        if (this.gridView != null) {
            this.gridView.setPosition(getChildTag());
            IPageNotify pageNotify2 = this.gridView.getPage().getNotify();
            if (pageNotify2 != null) {
                pageNotify2.GridPressed(this.gridView, this, pressed);
                return;
            }
            return;
        }
        if (this.listViewEx != null) {
            this.listViewEx.setPositionGroup(getGroupTag());
            this.listViewEx.setPositionChild(getChildTag());
            IPageNotify pageNotify3 = this.listViewEx.getPage().getNotify();
            if (pageNotify3 != null) {
                pageNotify3.ItemExPressed(this.listViewEx, this, pressed);
            }
        }
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        updateBackground();
        onPress(pressed);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        updateBackground();
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.ui != null) {
            int iStateBak = this.iState;
            if (this.focus) {
                this.iState = 1;
            } else if (!isEnabled()) {
                this.iState = 2;
            } else if (isPressed()) {
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
                    case 2:
                        this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_u";
                        break;
                }
                Drawable drawable = getDrawableFromPath(this.mStrDrawableFix, this.mDrawables, this.mDrawables);
                setBackground(drawable);
            }
        }
    }

    public Drawable getDrawableFromPath(String resName, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        return this.ui.getDrawableFromPath(resName, mapDrawables, tmpMapDrawables);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        IPageNotify pageNotify = getNotify();
        if (pageNotify != null) {
            pageNotify.dispatchTouchEvent(ev);
        }
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        IPageNotify pageNotify = getNotify();
        if (pageNotify != null) {
            pageNotify.onSizeChanged(w, h, oldw, oldh);
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void resume() {
        IPageNotify pageNotify = getNotify();
        if (pageNotify != null) {
            pageNotify.resume();
        }
    }

    public void pause() {
        IPageNotify pageNotify = getNotify();
        if (pageNotify != null) {
            pageNotify.pause();
        }
    }

    public void removeFromUiPages() {
        for (Integer integer : this.mListChildPageId) {
            this.ui.removePage(integer.intValue());
        }
        this.ui.removePage(getId());
        this.mListChildPageId.clear();
    }

    public boolean isNeedReload() {
        return (MyUi.getCurrentLang().equals(this.mLanguage) && MyUi.mStrHeadXml.equals(this.mStrHeadXml)) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        IPageNotify pageNotify = getNotify();
        if (pageNotify != null) {
            pageNotify.touchEvent(event);
        }
        return super.onTouchEvent(event);
    }
}
