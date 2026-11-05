package com.lsec.core.frame.app;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.MySize;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyUiItem {
    public static final int FORWORD_Down = -4;
    public static final int FORWORD_Left = -1;
    public static final int FORWORD_Right = -3;
    public static final int FORWORD_Up = -2;
    int[] mColor;
    int[] mColorBk;
    MyUiItem mItemParent;
    public FrameLayout.LayoutParams mLayoutParams;
    int[] mPadding;
    int[] mPara;
    int[] mPos;
    int[] mPosIcon;
    Point mPtConfig;
    int[] mRecMark;
    public Rect[] mRect;
    public MySize[] mSize;
    public String mStrAnim;
    String mStrDrawable;
    String[] mStrDrawableExtra;
    String mStrIcon;
    String[] mStrPara;
    String mStrText;
    String mStrTextConf;
    int mType;
    SparseArray<MyUiItem> mUiItems;
    MyUi ui;
    int mId = -1;
    int mWeight = -1;
    int mVisible = 0;
    MySize mSizeCurrent = new MySize(100, 18);
    boolean mLongClick = false;
    public int[] mIntDirs = new int[4];
    public int[] mIntPrevNext = new int[2];
    public int mPlusPadding = 0;

    public MyUiItem(MyUi ui, int type) {
        this.mType = 0;
        this.ui = ui;
        this.mType = type;
    }

    public void setParentItem(MyUiItem item) {
        this.mItemParent = item;
    }

    public MyUiItem getParentItem() {
        return this.mItemParent;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void setWeight(int weight) {
        this.mWeight = weight;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public int getType() {
        return this.mType;
    }

    public void setLongClick(boolean bLongClick) {
        this.mLongClick = bLongClick;
    }

    public boolean isLongClick() {
        return this.mLongClick;
    }

    public boolean isPadding() {
        String[] strPara = getParaStr();
        if (strPara == null) {
            return false;
        }
        for (String strTmp : strPara) {
            if (strTmp.contains("setPadding")) {
                return true;
            }
        }
        return false;
    }

    public void setSize(int... params) {
        if (params != null && params.length == 2) {
            this.mSizeCurrent.width = this.ui.getFixValue(params[0], true);
            this.mSizeCurrent.height = this.ui.getFixValue(params[1], true);
        }
    }

    public int getWidth() {
        return this.mSizeCurrent.width;
    }

    public int getHeight() {
        return this.mSizeCurrent.height;
    }

    public void setHeight(int h) {
        this.mSizeCurrent.height = h;
    }

    public void setPara(int... params) {
        if (params != null && params.length > 0) {
            if (this.mPara == null) {
                this.mPara = new int[params.length];
            }
            int length = params.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int val = params[i];
                this.mPara[i2] = val;
                i++;
                i2++;
            }
        }
    }

    public int[] getPara() {
        return this.mPara;
    }

    public int[] getPos() {
        return this.mPos;
    }

    public void setRecMark(int... params) {
        if (params != null && params.length > 0) {
            if (this.mRecMark == null) {
                this.mRecMark = new int[params.length];
            }
            int length = params.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int val = params[i];
                this.mRecMark[i2] = Math.round(this.ui.getFixValue(val, false));
                i++;
                i2++;
            }
        }
    }

    public int[] getRecMark() {
        return this.mRecMark;
    }

    public Rect[] getRect() {
        return this.mRect;
    }

    public MySize[] getSize() {
        return this.mSize;
    }

    public void setPadding(int... params) {
        int i;
        if (params != null && params.length == 4) {
            if (this.mPadding == null) {
                this.mPadding = new int[4];
            }
            int length = params.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int val = params[i2];
                if (i3 < this.mPadding.length) {
                    i = i3 + 1;
                    this.mPadding[i3] = Math.round(this.ui.getFixValue(val, false));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    public int[] getPadding() {
        return this.mPadding;
    }

    public void setPos(int... params) {
        int i;
        if (params != null && params.length == 2) {
            if (this.mPos == null) {
                this.mPos = new int[2];
            }
            int length = params.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int val = params[i2];
                if (i3 < this.mPos.length) {
                    i = i3 + 1;
                    this.mPos[i3] = Math.round(this.ui.getFixValue(val, false));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
    }

    public void setPosIcon(int... params) {
        int i;
        if (params != null && params.length == 4) {
            if (this.mPosIcon == null) {
                this.mPosIcon = new int[4];
            }
            int length = params.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int val = params[i2];
                if (i3 < this.mPosIcon.length) {
                    i = i3 + 1;
                    this.mPosIcon[i3] = Math.round(this.ui.getFixValue(val, false));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            int[] iArr = this.mPosIcon;
            iArr[2] = this.mPosIcon[0] + iArr[2];
            int[] iArr2 = this.mPosIcon;
            iArr2[3] = iArr2[3] + this.mPosIcon[1];
        }
    }

    public int[] getPosIcon() {
        return this.mPosIcon;
    }

    public void setRect(Rect rec, int... params) {
        int i;
        if (rec != null && params != null && params.length != 0) {
            int[] iData = new int[4];
            int length = params.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int val = params[i2];
                if (i3 < iData.length) {
                    i = i3 + 1;
                    iData[i3] = Math.round(this.ui.getFixValue(val, false));
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            rec.left = iData[0];
            rec.top = this.mPlusPadding + iData[1];
            rec.right = iData[2] + rec.left;
            rec.bottom = iData[3] + rec.top;
            if (this.ui.mScale < 0.999999d) {
                if (rec.right <= rec.left) {
                    rec.right = rec.left + 1;
                }
                if (rec.bottom <= rec.top) {
                    rec.bottom = rec.top + 1;
                }
            }
        }
    }

    public void setRect(Point ptBase, int... params) {
        int i;
        if (params != null && params.length != 0) {
            int[] iData = new int[4];
            int length = params.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int val = params[i2];
                if (i3 < iData.length) {
                    i = i3 + 1;
                    iData[i3] = Math.round(val * this.ui.mScale);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            this.mPtConfig = new Point(iData[0], iData[1]);
            if (ptBase != null) {
                iData[0] = iData[0] - ptBase.x;
                iData[1] = iData[1] - ptBase.y;
            }
            iData[1] = iData[1] + this.mPlusPadding;
            if ((this.mType == 16 || this.mType == 15) && getHeight() > 0) {
                iData[3] = (iData[3] / getHeight()) * getHeight();
            }
            this.mLayoutParams = new FrameLayout.LayoutParams(iData[2], iData[3]);
            this.mLayoutParams.leftMargin = iData[0];
            this.mLayoutParams.topMargin = iData[1];
        }
    }

    public FrameLayout.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    public Point getPtConfig() {
        return this.mPtConfig;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public int getId() {
        return this.mId;
    }

    public void setColorBk(String... colorBk) {
        int i;
        if (colorBk != null && colorBk.length != 0) {
            int[] values = new int[colorBk.length <= 3 ? colorBk.length : 3];
            int length = colorBk.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = colorBk[i2];
                if (i3 < values.length) {
                    i = i3 + 1;
                    values[i3] = FuncUtils.myParseColor(str);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            this.mColorBk = values;
        }
    }

    public int[] getColorBk() {
        return this.mColorBk;
    }

    public void setParaStr(String... strPara) {
        this.mStrPara = strPara;
    }

    public void setDirStr(MyUi myUi, String... strDirs) {
        if (myUi.mCtrlId != null && strDirs != null && strDirs.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (myUi.mCtrlId.containsKey(strDirs[i])) {
                    this.mIntDirs[i] = myUi.mCtrlId.get(strDirs[i]).intValue();
                }
            }
        }
    }

    public void setPrevNextStr(MyUi myUi, String... strPrevNexts) {
        if (myUi.mCtrlId != null && strPrevNexts != null && strPrevNexts.length == 2) {
            for (int i = 0; i < 2; i++) {
                if ("Left".equals(strPrevNexts[i])) {
                    this.mIntPrevNext[i] = -1;
                } else if ("Up".equals(strPrevNexts[i])) {
                    this.mIntPrevNext[i] = -2;
                } else if ("Right".equals(strPrevNexts[i])) {
                    this.mIntPrevNext[i] = -3;
                } else if ("Down".equals(strPrevNexts[i])) {
                    this.mIntPrevNext[i] = -4;
                } else if (myUi.mCtrlId.containsKey(strPrevNexts[i])) {
                    this.mIntPrevNext[i] = myUi.mCtrlId.get(strPrevNexts[i]).intValue();
                }
            }
        }
    }

    public String[] getParaStr() {
        return this.mStrPara;
    }

    public void setStrDrawable(String drawable) {
        this.mStrDrawable = drawable;
    }

    public String getStrDrawable() {
        return this.mStrDrawable;
    }

    public void setStrDrawableExtra(String... drawableExtra) {
        this.mStrDrawableExtra = drawableExtra;
    }

    public String[] getStrDrawableExtra() {
        return this.mStrDrawableExtra;
    }

    public void setIcon(String icon) {
        this.mStrIcon = icon;
    }

    public String getIcon() {
        return this.mStrIcon;
    }

    public void setColor(String... color) {
        int i;
        if (color != null && color.length != 0) {
            int[] values = new int[color.length <= 3 ? color.length : 3];
            int length = color.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = color[i2];
                if (i3 < values.length) {
                    i = i3 + 1;
                    values[i3] = FuncUtils.myParseColor(str);
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
            this.mColor = values;
        }
    }

    public void setColor(int[] values) {
        if (values != null) {
            this.mColor = values;
        }
    }

    public int[] getColor() {
        return this.mColor;
    }

    public void setText(String text) {
        this.mStrText = text;
    }

    public String getText() {
        return this.mStrText;
    }

    public void setTextConf(String text) {
        this.mStrTextConf = text;
    }

    public String getTextConf() {
        return this.mStrTextConf;
    }

    public int getChildCount() {
        if (this.mUiItems == null) {
            return 0;
        }
        int iCnt = this.mUiItems.size();
        return iCnt;
    }

    public void setUiItems(SparseArray<MyUiItem> items) {
        if (items != null && items.size() > 0) {
            this.mUiItems = items;
        }
    }

    public MyUiItem getChildAt(int index) {
        if (this.mUiItems == null || index < 0 || index >= getChildCount()) {
            return null;
        }
        MyUiItem item = this.mUiItems.get(this.mUiItems.keyAt(index));
        return item;
    }

    public void setVisible(int visible) {
        this.mVisible = visible;
    }

    public int getVisible() {
        return this.mVisible;
    }

    public void setAnim(String anim) {
        this.mStrAnim = anim;
    }

    public String getAnim() {
        return this.mStrAnim;
    }
}
