package com.lsec.core.frame.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.LocaleList;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JCameraTexture;
import com.lsec.core.frame.ctrl.JCameraTextureView;
import com.lsec.core.frame.ctrl.JCheckBox;
import com.lsec.core.frame.ctrl.JDashLine;
import com.lsec.core.frame.ctrl.JEditText;
import com.lsec.core.frame.ctrl.JFrameLayout;
import com.lsec.core.frame.ctrl.JGridView;
import com.lsec.core.frame.ctrl.JImageView;
import com.lsec.core.frame.ctrl.JIndicator;
import com.lsec.core.frame.ctrl.JLine;
import com.lsec.core.frame.ctrl.JLinearLayout;
import com.lsec.core.frame.ctrl.JListApp;
import com.lsec.core.frame.ctrl.JListViewEx;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JProgressBar;
import com.lsec.core.frame.ctrl.JScrollView;
import com.lsec.core.frame.ctrl.JScrollViewHorizontal;
import com.lsec.core.frame.ctrl.JSeekBar;
import com.lsec.core.frame.ctrl.JSurfaceView;
import com.lsec.core.frame.ctrl.JSwitchButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.ctrl.JViewPager;
import com.lsec.core.frame.ctrl.JViewPagerVertical;
import com.lsec.core.frame.data.FinalType;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.Markup;
import com.lsec.core.util.MySize;
import com.lsec.core.util.ReflectionUtil;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.db.Radio_Info;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyUi {
    public static String mPkgName;
    public static Resources mResources;
    public Activity mActivity;
    public Context mContext;
    private InterfaceUi mInterfaceUi;
    public int mStatusHeight;
    public Zip4jUtilFunc mZip4jUtilFunc;
    public static boolean bEditPaddingZero = false;
    public static String mStrHeadXml = FinalChip.BSP_PLATFORM_Null;
    public static String mStrHeadDrawable = FinalChip.BSP_PLATFORM_Null;
    public static Interface_TintDrawable mInterface_tintDrawable = null;
    public float mMultText = 1.0f;
    public float mScale = 1.0f;
    public SparseArray<MyUiItem> mPageUiItems = new SparseArray<>();
    public SparseArray<JPage> mPages = new SparseArray<>();
    public SparseArray<String> mMapPage = new SparseArray<>();
    public SparseArray<Dialog> mDlgs = new SparseArray<>();
    public HashMap<String, Integer> mCtrlType = new HashMap<>();
    public HashMap<String, Integer> mCtrlId = new HashMap<>();
    public String mStrLangXml = FinalChip.BSP_PLATFORM_Null;
    public HashMap<String, String> mMapString = new HashMap<>();
    public HashMap<String, String> mMapString_Common = new HashMap<>();
    public HashMap<String, String[]> mMapStringArray = new HashMap<>();
    public boolean bIsInListItem = false;
    public String mStrZip = null;

    public interface Interface_TintDrawable {
        void tintDrawable(String str, Drawable drawable);
    }

    public void InitScreen() throws Throwable {
        int screenMax;
        FuncUtils.getDisplayMetrics(this.mContext);
        if (FuncUtils.mDispayMetrics.widthPixels <= FuncUtils.mDispayMetrics.heightPixels) {
            this.mScale = 1.0f;
            return;
        }
        boolean bChangeScale = true;
        int iScreenMax = 1024;
        try {
            String strXml = getRaw("conf_screen");
            Markup xml = new Markup();
            xml.ReadXML(strXml);
            if (xml.IntoItem()) {
                do {
                    String strTemp = xml.GetAttr(Radio_Info.NAME);
                    if (strTemp != null) {
                        if (strTemp.equals("screen_max")) {
                            String strTemp2 = xml.GetAttr("value");
                            if (strTemp2 != null && (screenMax = FuncUtils.myParseInt(strTemp2)) > 0) {
                                iScreenMax = screenMax;
                            }
                        } else if (strTemp.equals("screen_set")) {
                            bChangeScale = false;
                        }
                    }
                } while (xml.NextItem());
                if (bChangeScale) {
                    this.mScale = (FuncUtils.mDispayMetrics.widthPixels * 1.0f) / iScreenMax;
                }
                xml.ExitItem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MyOnChildClickListener implements ExpandableListView.OnChildClickListener {
        private JListViewEx view;

        public MyOnChildClickListener(JListViewEx view) {
            this.view = view;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            IPageNotify pageNotify = this.view.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.ListExChildClick(this.view);
                return false;
            }
            return false;
        }
    }

    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        private JGridView view;

        public MyOnItemClickListener(JGridView view) {
            this.view = view;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            IPageNotify pageNotify = this.view.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.GridClick(this.view);
            }
        }
    }

    public class MyOnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        private JGridView view;

        public MyOnItemLongClickListener(JGridView view) {
            this.view = view;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
            IPageNotify pageNotify = this.view.getPage().getNotify();
            if (pageNotify != null) {
                pageNotify.GridLongClick(this.view);
                return true;
            }
            return true;
        }
    }

    public class MyOnDismissListener implements DialogInterface.OnDismissListener {
        private JPage page;

        public MyOnDismissListener(JPage page) {
            this.page = page;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            IPageNotify pageNotify = this.page.getNotify();
            if (pageNotify != null) {
                pageNotify.onDismiss();
            }
            MyUi.this.removePage(this.page.getId());
            MyUi.this.mDlgs.remove(this.page.getId());
        }
    }

    public int getFixValue(int val, boolean bPositive) {
        if (val == 0) {
            return 0;
        }
        int ret = (int) (val * this.mScale);
        if (bPositive && ret <= 0) {
            return 1;
        }
        return ret;
    }

    public int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = FuncUtils.myParseInt(field.get(obj).toString());
            int sbar = mResources.getDimensionPixelSize(x);
            return sbar;
        } catch (Exception e1) {
            e1.printStackTrace();
            return 60;
        }
    }

    public MyUi(Context context, InterfaceUi interfaceUi, Class<?> cType, Class<?> cId) throws Throwable {
        this.mStatusHeight = 60;
        this.mContext = context;
        this.mInterfaceUi = interfaceUi;
        this.mZip4jUtilFunc = new Zip4jUtilFunc(context);
        if (this.mInterfaceUi != null) {
            this.mInterfaceUi.InitMapPage(this);
        }
        if (this.mContext != null) {
            mResources = this.mContext.getResources();
            mPkgName = this.mContext.getPackageName();
        }
        if (this.mContext instanceof Activity) {
            this.mActivity = (Activity) this.mContext;
        }
        if (cId != null) {
            PutHashMap(this.mCtrlId, cId);
            PutHashMap(this.mCtrlType, FinalType.class);
            if (cType != null) {
                PutHashMap(this.mCtrlType, cType);
            }
        }
        this.mStatusHeight = getStatusBarHeight();
        InitScreen();
    }

    public static <T> void PutHashMap(HashMap<String, Integer> map, Class<T> c) {
        if (map != null) {
            Field[] fs = c.getDeclaredFields();
            for (Field field : fs) {
                try {
                    map.put(field.getName(), Integer.valueOf(field.getInt(c)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public JPage getPage(int id) {
        return this.mPages.get(id);
    }

    public Drawable getDrawableFromPath(String resName, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) throws Throwable {
        Drawable drawable = null;
        if (tmpMapDrawables != null && tmpMapDrawables.containsKey(resName)) {
            Drawable drawable2 = tmpMapDrawables.get(resName);
            drawable = drawable2;
        } else {
            if (mapDrawables != null && mapDrawables.containsKey(resName)) {
                Drawable drawable3 = mapDrawables.get(resName);
                drawable = drawable3;
            } else {
                if (TextUtils.isEmpty(resName)) {
                    return null;
                }
                if (!TextUtils.isEmpty(mStrHeadDrawable)) {
                    resName = String.valueOf(mStrHeadDrawable) + resName;
                }
                int resId = mResources.getIdentifier(resName, "drawable", mPkgName);
                if (resId > 0) {
                    drawable = mResources.getDrawable(resId);
                } else {
                    int resId2 = mResources.getIdentifier(resName, "anim", mPkgName);
                    if (resId2 > 0) {
                        drawable = mResources.getDrawable(resId2);
                    }
                }
                if (this.mZip4jUtilFunc != null && drawable == null) {
                    if (this.mStrZip != null) {
                        drawable = this.mZip4jUtilFunc.getDrawableFromZip(this, this.mStrZip, resName, mapDrawables, tmpMapDrawables);
                    } else {
                        drawable = this.mZip4jUtilFunc.getDrawableFromZip(this, MyApplication.mStrZipFile, resName, mapDrawables, tmpMapDrawables);
                    }
                }
                if (drawable != null && mInterface_tintDrawable != null) {
                    mInterface_tintDrawable.tintDrawable(resName, drawable);
                }
                if (mapDrawables != null) {
                    mapDrawables.put(resName, drawable);
                }
            }
            if (drawable != null) {
                drawable = drawable.getConstantState().newDrawable();
            }
            if (tmpMapDrawables != null) {
                tmpMapDrawables.put(resName, drawable);
            }
        }
        return drawable;
    }

    public MyUiItem getUiItemAt(int idPage) {
        if (this.mPageUiItems == null || this.mPageUiItems.size() <= 0) {
            return null;
        }
        MyUiItem item = this.mPageUiItems.get(idPage);
        return item;
    }

    public static int[] getIntArray(String str) {
        int iLenArray;
        int[] intArray = null;
        String[] strArray = str.split(",");
        if (strArray != null && (iLenArray = strArray.length) > 0) {
            intArray = new int[iLenArray];
            for (int i = 0; i < iLenArray; i++) {
                intArray[i] = FuncUtils.myParseInt(strArray[i]);
            }
        }
        return intArray;
    }

    public Animation loadAnimation(String name) throws Throwable {
        Animation animation = null;
        int id = mResources.getIdentifier(name, "anim", mPkgName);
        if (id > 0) {
            animation = AnimationUtils.loadAnimation(this.mContext, id);
        }
        if (this.mZip4jUtilFunc != null && animation == null) {
            if (this.mStrZip != null) {
                Animation animation2 = this.mZip4jUtilFunc.loadAnimation(this, this.mStrZip, name);
                return animation2;
            }
            Animation animation3 = this.mZip4jUtilFunc.loadAnimation(this, MyApplication.mStrZipFile, name);
            return animation3;
        }
        return animation;
    }

    public String getString(String name) throws Throwable {
        String strRet;
        if (TextUtils.isEmpty(name)) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        int id = mResources.getIdentifier(name, "string", mPkgName);
        if (id == 0) {
            if (this.mZip4jUtilFunc != null) {
                if (this.mStrZip != null) {
                    strRet = this.mZip4jUtilFunc.getStringFromZip(this, this.mStrZip, name);
                } else {
                    strRet = this.mZip4jUtilFunc.getStringFromZip(this, MyApplication.mStrZipFile, name);
                }
                if (!TextUtils.isEmpty(strRet)) {
                    return strRet;
                }
            }
            return name;
        }
        String strRet2 = myString(id);
        return strRet2;
    }

    public String myString(int resId) {
        if (mResources != null) {
            try {
                return mResources.getString(resId);
            } catch (Exception e) {
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public String[] getStringArray(String name) throws Throwable {
        String[] strRet;
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        int id = mResources.getIdentifier(name, "array", mPkgName);
        if (id > 0) {
            return myStringArray(id);
        }
        if (this.mZip4jUtilFunc != null) {
            if (this.mStrZip != null) {
                strRet = this.mZip4jUtilFunc.getStringArrayFromZip(this, this.mStrZip, name);
            } else {
                strRet = this.mZip4jUtilFunc.getStringArrayFromZip(this, MyApplication.mStrZipFile, name);
            }
            if (strRet != null) {
                return strRet;
            }
        }
        return null;
    }

    public String[] myStringArray(int resId) {
        if (mResources != null) {
            try {
                return mResources.getStringArray(resId);
            } catch (Exception e) {
            }
        }
        return null;
    }

    private MyUiItem getItem(Markup xml, String str, MyUiItem itemParent) throws Throwable {
        MyUiItem child;
        String[] strArrayRec;
        int wParam;
        int hParam;
        int[] intArray;
        int idPage;
        int iType = -1;
        if (this.mCtrlType.containsKey(str)) {
            iType = this.mCtrlType.get(str).intValue();
        }
        MyUiItem item = new MyUiItem(this, iType);
        item.setParentItem(itemParent);
        String str2 = xml.GetAttr("id");
        if (str2 != null && this.mCtrlId != null && this.mCtrlId.containsKey(str2)) {
            item.setId(this.mCtrlId.get(str2).intValue());
        }
        if (iType == 1 && (idPage = item.getId()) != -1 && this.mMapPage.indexOfKey(idPage) < 0 && this.mPageUiItems.indexOfKey(idPage) < 0) {
            this.mPageUiItems.put(idPage, item);
        }
        String str3 = xml.GetAttr("visible");
        if (str3 != null && str3.equals("GONE")) {
            item.setVisible(8);
        }
        String str4 = xml.GetAttr("anim");
        if (str4 != null) {
            item.setAnim(str4);
        }
        String str5 = xml.GetAttr("size");
        if (str5 != null) {
            String[] strArraySize = str5.split(";");
            if (strArraySize != null) {
                int iSumSize = strArraySize.length - 1;
                if (iSumSize >= 1) {
                    item.mSize = new MySize[iSumSize];
                    for (int iTmp = 0; iTmp < iSumSize; iTmp++) {
                        int[] intArray2 = getIntArray(strArraySize[iTmp + 1]);
                        item.mSize[iTmp] = new MySize(getFixValue(intArray2[0], true), getFixValue(intArray2[1], true));
                    }
                }
                item.setSize(getIntArray(strArraySize[0]));
            }
            String str6 = xml.GetAttr("pos");
            if (str6 != null) {
                item.setPos(getIntArray(str6));
            }
        } else {
            int h = item.getHeight();
            switch (iType) {
                case 16:
                    h = 0;
                    break;
            }
            String str7 = xml.GetAttr("h");
            if (str7 != null) {
                try {
                    h = Integer.parseInt(str7);
                } catch (Exception e) {
                    if (this.mContext != null) {
                        try {
                            h = this.mContext.getResources().getDimensionPixelOffset(this.mContext.getResources().getIdentifier(str7, "dimen", this.mContext.getPackageName()));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            switch (iType) {
                case 16:
                    break;
                default:
                    h = getFixValue(h, true);
                    break;
            }
            item.setHeight(h);
        }
        Point ptBase = null;
        if (itemParent != null) {
            ptBase = itemParent.getPtConfig();
        }
        String str8 = xml.GetAttr("paraStr");
        if (str8 != null) {
            String[] strArray = str8.split(",");
            item.setParaStr(strArray);
            if (item.isPadding()) {
                item.mPlusPadding = this.mStatusHeight;
            }
        }
        String str9 = xml.GetAttr("dirs");
        if (str9 != null) {
            String[] strArray2 = str9.split(",");
            item.setDirStr(this, strArray2);
        }
        String str10 = xml.GetAttr("prevnext");
        if (str10 != null) {
            String[] strArray3 = str10.split(",");
            item.setPrevNextStr(this, strArray3);
        }
        String str11 = xml.GetAttr("gravity");
        if (str11 != null) {
            String[] strArray4 = str11.split(",");
            if (strArray4.length >= 2) {
                if (strArray4[0].contains("wrap_content")) {
                    wParam = -2;
                } else if (strArray4[0].contains("match_parent")) {
                    wParam = -1;
                } else {
                    wParam = getFixValue(FuncUtils.myParseInt(strArray4[0]), true);
                }
                if (strArray4[1].contains("wrap_content")) {
                    hParam = -2;
                } else if (strArray4[1].contains("match_parent")) {
                    hParam = -1;
                } else {
                    hParam = getFixValue(FuncUtils.myParseInt(strArray4[1]), true);
                }
                item.mLayoutParams = new FrameLayout.LayoutParams(wParam, hParam);
                if (strArray4.length >= 3) {
                    boolean bSetGravity = false;
                    if (strArray4[2].contains("Left")) {
                        bSetGravity = true;
                        if (strArray4[2].contains("Top")) {
                            item.mLayoutParams.gravity = 51;
                        } else if (strArray4[2].contains("Bottom")) {
                            item.mLayoutParams.gravity = 83;
                        } else {
                            item.mLayoutParams.gravity = 19;
                        }
                    } else if (strArray4[2].contains("Right")) {
                        bSetGravity = true;
                        if (strArray4[2].contains("Top")) {
                            item.mLayoutParams.gravity = 53;
                        } else if (strArray4[2].contains("Bottom")) {
                            item.mLayoutParams.gravity = 85;
                        } else {
                            item.mLayoutParams.gravity = 21;
                        }
                    } else if (strArray4[2].contains("Bottom")) {
                        bSetGravity = true;
                        item.mLayoutParams.gravity = 81;
                    } else if (strArray4[2].contains("Top")) {
                        bSetGravity = true;
                        item.mLayoutParams.gravity = 49;
                    } else if (strArray4[2].contains("Center_H")) {
                        bSetGravity = true;
                        item.mLayoutParams.gravity = 1;
                    } else if (strArray4[2].contains("Center_V")) {
                        bSetGravity = true;
                        item.mLayoutParams.gravity = 16;
                    } else if (strArray4[2].contains("Center")) {
                        bSetGravity = true;
                        item.mLayoutParams.gravity = 17;
                    }
                    if (!bSetGravity) {
                        item.mLayoutParams.gravity = 17;
                    }
                }
                String str12 = xml.GetAttr("pos");
                if (str12 != null && (intArray = getIntArray(str12)) != null && intArray.length == 2) {
                    item.mLayoutParams.leftMargin = getFixValue(intArray[0], false);
                    item.mLayoutParams.topMargin = item.mPlusPadding + getFixValue(intArray[1], false);
                }
            }
        }
        String str13 = xml.GetAttr("rect");
        if (str13 != null && (strArrayRec = str13.split(";")) != null) {
            int iSumRec = strArrayRec.length - 1;
            if (iSumRec >= 1) {
                item.mRect = new Rect[iSumRec];
                for (int iTmp2 = 0; iTmp2 < iSumRec; iTmp2++) {
                    item.mRect[iTmp2] = new Rect();
                    item.setRect(item.mRect[iTmp2], getIntArray(strArrayRec[iTmp2 + 1]));
                }
            }
            if (item.mLayoutParams == null) {
                item.setRect(ptBase, getIntArray(strArrayRec[0]));
            }
        }
        String str14 = xml.GetAttr("posIco");
        if (str14 != null) {
            item.setPosIcon(getIntArray(str14));
        }
        String str15 = xml.GetAttr("icon");
        if (str15 != null) {
            item.setIcon(str15);
        }
        String str16 = xml.GetAttr("padding");
        if (str16 != null) {
            item.setPadding(getIntArray(str16));
        }
        String str17 = xml.GetAttr("para");
        if (str17 != null) {
            item.setPara(getIntArray(str17));
        }
        String str18 = xml.GetAttr("weight");
        if (str18 != null) {
            item.setWeight(FuncUtils.myParseInt(str18));
        }
        String str19 = xml.GetAttr("recMark");
        if (str19 != null) {
            item.setRecMark(getIntArray(str19));
        }
        String str20 = xml.GetAttr("drawable");
        if (str20 != null) {
            item.setStrDrawable(str20);
        }
        String str21 = xml.GetAttr("drawableExtra");
        if (str21 != null) {
            String[] strArray5 = str21.split(",");
            item.setStrDrawableExtra(strArray5);
        }
        String str22 = xml.GetAttr("longclick");
        if (str22 != null && str22.charAt(0) == '1') {
            item.setLongClick(true);
        }
        String str23 = xml.GetAttr("text");
        if (str23 != null) {
            String strRes = getString(str23);
            item.setTextConf(str23);
            if (TextUtils.isEmpty(strRes)) {
                strRes = str23;
            }
            item.setText(strRes);
        }
        String str24 = xml.GetAttr("color");
        if (str24 != null) {
            String[] strArray6 = str24.split(",");
            item.setColor(strArray6);
        }
        String str25 = xml.GetAttr("colorBK");
        if (str25 != null) {
            String[] strArray7 = str25.split(",");
            item.setColorBk(strArray7);
        }
        if (xml.IntoItem()) {
            int key = 0;
            SparseArray<MyUiItem> items = new SparseArray<>();
            do {
                String str26 = xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null);
                if (item.getType() == 11) {
                    child = getItem(xml, str26, item.getParentItem());
                } else {
                    child = getItem(xml, str26, item);
                }
                if (child != null) {
                    items.put(key, child);
                    key++;
                }
            } while (xml.NextItem());
            if (item.getType() == 7) {
                item.setType(6);
            }
            item.setUiItems(items);
            xml.ExitItem();
        }
        return item;
    }

    public String getRaw(String strRaw) throws Throwable {
        String strXml = FinalChip.BSP_PLATFORM_Null;
        int id = -1;
        try {
            if (!TextUtils.isEmpty(mStrHeadXml)) {
                id = mResources.getIdentifier(String.valueOf(mStrHeadXml) + strRaw, "raw", mPkgName);
            }
            if (id <= 0 && FuncUtils.mDispayMetrics.widthPixels < FuncUtils.mDispayMetrics.heightPixels) {
                id = mResources.getIdentifier("port_" + strRaw, "raw", mPkgName);
            }
            if (id <= 0) {
                id = mResources.getIdentifier(strRaw, "raw", mPkgName);
            }
            if (id > 0) {
                strXml = FuncUtils.readStrFromStream(mResources.openRawResource(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(strXml) && this.mZip4jUtilFunc != null) {
            if (this.mStrZip != null) {
                return this.mZip4jUtilFunc.getRawFromZip(this.mStrZip, strRaw);
            }
            return this.mZip4jUtilFunc.getRawFromZip(MyApplication.mStrZipFile, strRaw);
        }
        return strXml;
    }

    public JPage getPageFromXml(String strXml) throws Throwable {
        MyUiItem item = null;
        if (!TextUtils.isEmpty(strXml)) {
            try {
                Markup xml = new Markup();
                xml.ReadXML(strXml);
                if (xml.IntoItem()) {
                    do {
                        String strTemp = xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null);
                        if (strTemp.equals("Page")) {
                            item = getItem(xml, strTemp, null);
                        }
                    } while (xml.NextItem());
                    xml.ExitItem();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (item == null) {
            return null;
        }
        JPage page = createPage(item, null);
        return page;
    }

    public void ParseXml(String strRaw) throws Throwable {
        if (!TextUtils.isEmpty(strRaw)) {
            try {
                String strXml = getRaw(strRaw);
                if (!TextUtils.isEmpty(strXml)) {
                    Markup xml = new Markup();
                    xml.ReadXML(strXml);
                    if (xml.IntoItem()) {
                        do {
                            String strTemp = xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null);
                            if (strTemp.equals("Page")) {
                                MyUiItem page = getItem(xml, strTemp, null);
                                if (page.getId() == -1) {
                                    throw new RuntimeException("page id can't be -1!");
                                }
                                this.mPageUiItems.put(page.getId(), page);
                            }
                        } while (xml.NextItem());
                        xml.ExitItem();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void createGroup(JPage page, MyUiItem item, ViewGroup group, ViewGroup groupParent) throws Throwable {
        Animation anim;
        if (group != null) {
            int childCount = item.getChildCount();
            if (item.getType() == 2) {
                for (int i = 0; i < childCount; i++) {
                    CreateViewByItem(page, item.getChildAt(i), ((JScrollView) group).getLayout());
                }
            } else if (item.getType() == 3) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    CreateViewByItem(page, item.getChildAt(i2), ((JScrollViewHorizontal) group).getLayout());
                }
            } else {
                for (int i3 = 0; i3 < childCount; i3++) {
                    CreateViewByItem(page, item.getChildAt(i3), group);
                }
            }
            group.setTag(item);
            if (item.getId() != -1) {
                group.setId(item.getId());
            }
            if (item.getAnim() != null && (anim = loadAnimation(item.getAnim())) != null) {
                group.startAnimation(anim);
            }
            page.addChildView(group, item);
            group.setVisibility(item.getVisible());
            FrameLayout.LayoutParams lp = item.getLayoutParams();
            if (lp != null) {
                if (groupParent instanceof LinearLayout) {
                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(lp.width, lp.height);
                    lp2.gravity = lp.gravity;
                    lp2.leftMargin = lp.leftMargin;
                    lp2.topMargin = lp.topMargin;
                    if (item.getWeight() > 0) {
                        lp2.weight = item.getWeight();
                    }
                    group.setLayoutParams(lp2);
                } else {
                    group.setLayoutParams(lp);
                }
            }
            groupParent.addView(group);
        }
    }

    private void createLayout(JPage page, MyUiItem item, ViewGroup groupParent) {
        if (item.getType() == 4) {
            JLinearLayout group = new JLinearLayout(this.mContext, page);
            if (item.getStrDrawable() != null) {
                group.setStrDrawable(item.getStrDrawable(), false);
            }
            if (item.getParaStr() != null) {
                if (item.getParaStr()[0].contains("horizontal")) {
                    group.setOrientation(0);
                } else {
                    group.setOrientation(1);
                }
            }
            createGroup(page, item, group, groupParent);
            return;
        }
        JFrameLayout group2 = new JFrameLayout(this.mContext, page);
        if (item.getStrDrawable() != null) {
            group2.setStrDrawable(item.getStrDrawable(), false);
        }
        createGroup(page, item, group2, groupParent);
    }

    private void createScrollView(JPage page, MyUiItem item, ViewGroup groupParent) {
        JScrollView group = new JScrollView(this.mContext, page);
        if (item.getStrDrawable() != null) {
            group.setStrDrawable(item.getStrDrawable(), false);
        }
        LinearLayout layout = new LinearLayout(this.mContext);
        group.setLayout(layout);
        layout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        layout.setOrientation(1);
        group.setVerticalScrollBarEnabled(false);
        createGroup(page, item, group, groupParent);
    }

    private void createScrollViewHorizontal(JPage page, MyUiItem item, ViewGroup groupParent) {
        JScrollViewHorizontal group = new JScrollViewHorizontal(this.mContext, page);
        if (item.getStrDrawable() != null) {
            group.setStrDrawable(item.getStrDrawable(), false);
        }
        LinearLayout layout = new LinearLayout(this.mContext);
        group.setLayout(layout);
        layout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        layout.setOrientation(0);
        group.setHorizontalScrollBarEnabled(false);
        createGroup(page, item, group, groupParent);
    }

    @SuppressLint({"NewApi"})
    public View createUiItem(JPage jPage, MyUiItem item, ViewGroup viewGroup) throws Throwable {
        int iLenArray;
        int iLenArray2;
        View child = null;
        if (this.mInterfaceUi != null) {
            child = this.mInterfaceUi.createUiItemOtherWay(jPage, item);
        }
        if (child == null) {
            int type = item.getType();
            switch (type) {
                case 1:
                    if (this.mPages.get(item.getId()) != null) {
                        this.mPages.remove(item.getId());
                    }
                    boolean bAddChild2Parent = false;
                    String[] strPara = item.getParaStr();
                    if (strPara != null) {
                        for (String str : strPara) {
                            if (str.contains("AddChild2Parent")) {
                                bAddChild2Parent = true;
                            }
                        }
                    }
                    View p = null;
                    if (bAddChild2Parent) {
                        loadPage(true, item.getId(), jPage);
                    } else {
                        p = loadPage(true, item.getId());
                    }
                    child = p;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    if (item.getType() == 5) {
                        child = new FrameLayout(this.mContext);
                    } else if (item.getType() == 4) {
                        child = new LinearLayout(this.mContext);
                    } else {
                        JView view = new JView(jPage);
                        if (item.getStrDrawable() != null) {
                            view.setStrDrawable(item.getStrDrawable(), false);
                        }
                        child = view;
                    }
                    break;
                case 8:
                    JSurfaceView view2 = new JSurfaceView(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view2.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = view2;
                    break;
                case 9:
                    boolean bUseCameraTextureView = false;
                    switch (Main.mConf_PlatForm) {
                        case 6:
                        case 7:
                            bUseCameraTextureView = true;
                            break;
                    }
                    if (bUseCameraTextureView) {
                        JCameraTextureView view3 = new JCameraTextureView(this.mContext, jPage);
                        if (item.getStrDrawable() != null) {
                            view3.setStrDrawable(item.getStrDrawable(), false);
                        }
                        child = view3;
                    } else {
                        JCameraTexture view4 = new JCameraTexture(this.mContext, jPage);
                        if (item.getStrDrawable() != null) {
                            view4.setStrDrawable(item.getStrDrawable(), false);
                        }
                        child = view4;
                    }
                    break;
                case 10:
                    JCameraTextureView view5 = new JCameraTextureView(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view5.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = view5;
                    break;
                case 11:
                    JButton btn = new JButton(jPage);
                    btn.setIcon(item.getPosIcon(), item.getIcon());
                    if (item.getStrDrawable() != null) {
                        btn.setStrDrawable(item.getStrDrawable(), false);
                    }
                    btn.setColorBk(item.getColorBk());
                    btn.setText(item.getText());
                    Locale localeDefault = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        localeDefault = LocaleList.getDefault().get(0);
                    }
                    String strLanguage = String.valueOf(localeDefault.getLanguage()) + "-" + localeDefault.getCountry();
                    btn.setTextBak(item.getText(), strLanguage);
                    if (FuncUtils.isLongLang()) {
                        btn.setTextSize(0, item.getHeight() - 2);
                    } else {
                        btn.setTextSize(0, item.getHeight());
                    }
                    if (item.getColor() != null) {
                        int iLen = item.getColor().length;
                        if (iLen >= 1) {
                            btn.setTextColor(item.getColor()[0]);
                        }
                        if (iLen > 1) {
                            btn.setColor(item.getColor());
                        }
                    }
                    int iBoldItalic = 0;
                    boolean bSetGravity = false;
                    String[] strPara2 = item.getParaStr();
                    if (strPara2 != null) {
                        for (String strTmp : strPara2) {
                            if (!bSetGravity) {
                                if (strTmp.contains("Left")) {
                                    bSetGravity = true;
                                    if (strTmp.contains("Top")) {
                                        btn.setGravity(51);
                                    } else if (strTmp.contains("Bottom")) {
                                        btn.setGravity(83);
                                    } else {
                                        btn.setGravity(19);
                                    }
                                } else if (strTmp.contains("Right")) {
                                    bSetGravity = true;
                                    if (strTmp.contains("Top")) {
                                        btn.setGravity(53);
                                    } else if (strTmp.contains("Bottom")) {
                                        btn.setGravity(85);
                                    } else {
                                        btn.setGravity(21);
                                    }
                                } else if (strTmp.contains("Bottom")) {
                                    bSetGravity = true;
                                    btn.setGravity(81);
                                } else if (strTmp.contains("Top")) {
                                    bSetGravity = true;
                                    btn.setGravity(49);
                                }
                            }
                            if (strTmp.contains("TruncateAtEnd")) {
                                btn.setEllipsize(TextUtils.TruncateAt.END);
                            } else if (strTmp.contains("TruncateAtMiddle")) {
                                btn.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                            } else if (strTmp.contains("TruncateAtStart")) {
                                btn.setEllipsize(TextUtils.TruncateAt.START);
                            } else if (strTmp.contains("TruncateAtMarQuee")) {
                                btn.setFocus(true);
                                btn.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                btn.setMarqueeRepeatLimit(-1);
                            } else if (strTmp.contains("Bold")) {
                                iBoldItalic = 1;
                            } else if (strTmp.contains("Italic")) {
                                iBoldItalic |= 16;
                            }
                            if (strTmp.contains("SingleLine")) {
                                btn.setSingleLine(true);
                            }
                            if (strTmp.contains("PartnerDependent")) {
                                btn.bPartnerDependent = true;
                            }
                        }
                    }
                    switch (iBoldItalic) {
                        case 1:
                            btn.setTypeface(Typeface.DEFAULT_BOLD, 1);
                            break;
                        case 16:
                            btn.setTypeface(Typeface.MONOSPACE, 2);
                            break;
                        case 17:
                            btn.setTypeface(Typeface.MONOSPACE, 3);
                            break;
                    }
                    if (!bSetGravity) {
                        btn.setGravity(17);
                    }
                    if (this.bIsInListItem) {
                        btn.setFocusable(false);
                    } else {
                        btn.setFocusable(true);
                    }
                    child = btn;
                    break;
                case 12:
                    JText txt = new JText(jPage);
                    if (item.getStrDrawable() != null) {
                        txt.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = txt;
                    txt.setText(item.getText());
                    txt.setLineSpacing(0.0f, this.mMultText);
                    Locale localeDefault2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        localeDefault2 = LocaleList.getDefault().get(0);
                    }
                    String strLanguage2 = String.valueOf(localeDefault2.getLanguage()) + "-" + localeDefault2.getCountry();
                    txt.setTextBak(item.getText(), strLanguage2);
                    boolean bSingleLine = true;
                    boolean bSetGravity2 = false;
                    int iBoldItalic2 = 0;
                    String[] strPara3 = item.getParaStr();
                    if (strPara3 != null) {
                        for (String strTmp2 : strPara3) {
                            if (!bSetGravity2) {
                                if (strTmp2.contains("Left")) {
                                    bSetGravity2 = true;
                                    if (strTmp2.contains("Top")) {
                                        txt.setGravity(51);
                                    } else if (strTmp2.contains("Bottom")) {
                                        txt.setGravity(83);
                                    } else {
                                        txt.setGravity(19);
                                    }
                                } else if (strTmp2.contains("Right")) {
                                    bSetGravity2 = true;
                                    if (strTmp2.contains("Top")) {
                                        txt.setGravity(53);
                                    } else if (strTmp2.contains("Bottom")) {
                                        txt.setGravity(85);
                                    } else {
                                        txt.setGravity(21);
                                    }
                                } else if (strTmp2.contains("Bottom")) {
                                    bSetGravity2 = true;
                                    txt.setGravity(81);
                                } else if (strTmp2.contains("Top")) {
                                    bSetGravity2 = true;
                                    txt.setGravity(49);
                                }
                            }
                            if (strTmp2.contains("TruncateAtEnd")) {
                                txt.setEllipsize(TextUtils.TruncateAt.END);
                            } else if (strTmp2.contains("TruncateAtMiddle")) {
                                txt.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                            } else if (strTmp2.contains("TruncateAtStart")) {
                                txt.setEllipsize(TextUtils.TruncateAt.START);
                            } else if (strTmp2.contains("TruncateAtMarQuee")) {
                                txt.setMarQuee(true);
                            } else if (strTmp2.contains("Bold")) {
                                iBoldItalic2 = 1;
                            } else if (strTmp2.contains("Italic")) {
                                iBoldItalic2 |= 16;
                            } else if (strTmp2.contains("Multiline")) {
                                bSingleLine = false;
                            }
                        }
                    }
                    switch (iBoldItalic2) {
                        case 1:
                            txt.setTypeface(Typeface.DEFAULT_BOLD, 1);
                            break;
                        case 16:
                            txt.setTypeface(Typeface.MONOSPACE, 2);
                            break;
                        case 17:
                            txt.setTypeface(Typeface.MONOSPACE, 3);
                            break;
                    }
                    if (!bSetGravity2) {
                        txt.setGravity(17);
                    }
                    if (FuncUtils.isLongLang()) {
                        txt.setTextSize(0, item.getHeight() - 2);
                    } else {
                        txt.setTextSize(0, item.getHeight());
                    }
                    if (item.getColor() != null) {
                        int iLen2 = item.getColor().length;
                        if (iLen2 >= 1) {
                            txt.setTextColor(item.getColor()[0]);
                        }
                        if (iLen2 > 1) {
                            txt.setColor(item.getColor());
                        }
                    }
                    if (item.getStrDrawable() == null) {
                        txt.setBackgroundColor(ViewCompat.MEASURED_STATE_TOO_SMALL);
                    }
                    txt.setSingleLine(bSingleLine);
                    break;
                case 13:
                    JViewPager pager = new JViewPager(jPage);
                    if (item.getStrDrawable() != null) {
                        pager.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = pager;
                    String[] strArray = item.getParaStr();
                    if (strArray != null && (iLenArray2 = strArray.length) > 0) {
                        int[] intArray = new int[iLenArray2];
                        if (this.mCtrlId != null) {
                            for (int i = 0; i < iLenArray2; i++) {
                                if (this.mCtrlId.containsKey(strArray[i])) {
                                    intArray[i] = this.mCtrlId.get(strArray[i]).intValue();
                                }
                            }
                        }
                        pager.setUiLoader(intArray);
                    }
                    break;
                case 14:
                    JViewPagerVertical pager2 = new JViewPagerVertical(jPage);
                    if (item.getStrDrawable() != null) {
                        pager2.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = pager2;
                    String[] strArray2 = item.getParaStr();
                    if (strArray2 != null && (iLenArray = strArray2.length) > 0) {
                        int[] intArray2 = new int[iLenArray];
                        if (this.mCtrlId != null) {
                            for (int i2 = 0; i2 < iLenArray; i2++) {
                                if (this.mCtrlId.containsKey(strArray2[i2])) {
                                    intArray2[i2] = this.mCtrlId.get(strArray2[i2]).intValue();
                                }
                            }
                        }
                        pager2.setUiLoader(intArray2);
                    }
                    break;
                case 15:
                    JListViewEx view6 = new JListViewEx(jPage);
                    if (item.getStrDrawable() != null) {
                        view6.setStrDrawable(item.getStrDrawable(), false);
                    }
                    view6.setDividerHeight(0);
                    view6.setDivider(null);
                    view6.setGroupIndicator(null);
                    view6.setCacheColorHint(0);
                    view6.setBackgroundColor(0);
                    view6.setSelector(new ColorDrawable(0));
                    view6.setOnChildClickListener(new MyOnChildClickListener(view6));
                    int[] para = item.getPara();
                    if (para != null) {
                        view6.initSwipePara(getFixValue(para[0], true));
                    }
                    String[] strArray3 = item.getParaStr();
                    if (strArray3 != null) {
                        if (strArray3.length > 0 && this.mCtrlId != null && this.mCtrlId.containsKey(strArray3[0]) && this.mCtrlId.containsKey(strArray3[1])) {
                            view6.setPageRow(this.mCtrlId.get(strArray3[0]).intValue(), this.mCtrlId.get(strArray3[1]).intValue());
                        }
                    }
                    child = view6;
                    break;
                case 16:
                    JGridView view7 = new JGridView(jPage);
                    if (item.getStrDrawable() != null) {
                        view7.setStrDrawable(item.getStrDrawable(), false);
                    }
                    view7.setMaxRowDisp(item.getHeight());
                    view7.setCacheColorHint(0);
                    view7.setSelector(new ColorDrawable(0));
                    int[] para2 = item.getPara();
                    if (para2 != null) {
                        view7.setNumColumns(para2[0]);
                        if (para2.length > 1) {
                            view7.setHorizontalSpacing(getFixValue(para2[1], true));
                        }
                        if (para2.length > 2) {
                            view7.setVerticalSpacing(getFixValue(para2[2], true));
                        }
                        if (para2.length > 3 && para2[3] > 0) {
                            view7.initSwipePara(getFixValue(para2[3], true));
                        }
                    } else {
                        view7.setNumColumns(1);
                    }
                    view7.setOnItemClickListener(new MyOnItemClickListener(view7));
                    if (item.isLongClick()) {
                        view7.setOnItemLongClickListener(new MyOnItemLongClickListener(view7));
                    }
                    String[] strArray4 = item.getParaStr();
                    if (strArray4 != null) {
                        int iLenArray3 = strArray4.length;
                        if (iLenArray3 > 0 && this.mCtrlId != null && this.mCtrlId.containsKey(strArray4[0])) {
                            view7.setPageRow(this.mCtrlId.get(strArray4[0]).intValue());
                        }
                        if (iLenArray3 > 1) {
                            for (int i3 = 1; i3 < iLenArray3; i3++) {
                                if (strArray4[i3].contains("InScrollView")) {
                                    view7.mInScrollView = true;
                                }
                            }
                        }
                    }
                    child = view7;
                    break;
                case 17:
                    JEditText view8 = new JEditText(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view8.setStrDrawable(item.getStrDrawable(), false);
                    }
                    boolean bSetBackground_Null = true;
                    String[] strPara4 = item.getParaStr();
                    if (strPara4 != null) {
                        for (String str2 : strPara4) {
                            if ("KeepBk".equals(str2)) {
                                bSetBackground_Null = false;
                            }
                        }
                    }
                    if (bSetBackground_Null) {
                        view8.setBackground(null);
                    }
                    view8.setFocusable(true);
                    view8.setFocusableInTouchMode(true);
                    view8.setSingleLine();
                    if (FuncUtils.isLongLang()) {
                        view8.setTextSize(0, item.getHeight() - 2);
                    } else {
                        view8.setTextSize(0, item.getHeight());
                    }
                    if (bEditPaddingZero) {
                        view8.setPadding(0, 0, 0, 0);
                    }
                    if (item.getColor() != null) {
                        view8.setTextColor(item.getColor()[0]);
                    }
                    boolean bSetGravity3 = false;
                    if (strPara4 != null) {
                        for (String strTmp3 : strPara4) {
                            if (strTmp3.equals("Left")) {
                                bSetGravity3 = true;
                                view8.setGravity(19);
                            } else if (strTmp3.equals("Right")) {
                                bSetGravity3 = true;
                                view8.setGravity(21);
                            }
                        }
                    }
                    if (!bSetGravity3) {
                        view8.setGravity(17);
                    }
                    child = view8;
                    break;
                case 18:
                    JImageView view9 = new JImageView(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view9.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = view9;
                    break;
                case 19:
                    String[] strDrawableExtra = item.getStrDrawableExtra();
                    int[] paras = item.getPara();
                    boolean bIsCheckBox = false;
                    if (strDrawableExtra != null && strDrawableExtra.length == 2) {
                        bIsCheckBox = true;
                    }
                    JSwitchButton view10 = new JSwitchButton(jPage, bIsCheckBox);
                    if (item.getStrDrawable() != null) {
                        view10.setStrDrawable(item.getStrDrawable(), false);
                    }
                    view10.setIconName(strDrawableExtra);
                    view10.setParas(paras);
                    String[] strPara5 = item.getParaStr();
                    if (strPara5 != null) {
                        for (String str3 : strPara5) {
                            if (str3.contains("condition")) {
                                view10.setCondition(true);
                            }
                        }
                    }
                    if (this.bIsInListItem) {
                        view10.setFocusable(false);
                    } else {
                        view10.setFocusable(true);
                    }
                    child = view10;
                    break;
                case 20:
                    JCheckBox view11 = new JCheckBox(jPage);
                    if (item.getStrDrawable() != null) {
                        view11.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = view11;
                    view11.setText(item.getText());
                    Locale localeDefault3 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        localeDefault3 = LocaleList.getDefault().get(0);
                    }
                    String strLanguage3 = String.valueOf(localeDefault3.getLanguage()) + "-" + localeDefault3.getCountry();
                    view11.setTextBak(item.getText(), strLanguage3);
                    if (FuncUtils.isLongLang()) {
                        view11.setTextSize(0, item.getHeight() - 2);
                    } else {
                        view11.setTextSize(0, item.getHeight());
                    }
                    if (item.getColor() != null) {
                        view11.setTextColor(item.getColor()[0]);
                    }
                    view11.setIconName(item.getStrDrawableExtra());
                    view11.setGravity(19);
                    break;
                case 21:
                    int defStyle = R.attr.progressBarStyle;
                    boolean bProgressDrawable = false;
                    int[] para3 = item.getPara();
                    if (para3 != null) {
                        bProgressDrawable = para3[0] == 1;
                    }
                    if (bProgressDrawable) {
                        defStyle = R.attr.progressBarStyleHorizontal;
                    }
                    JProgressBar view12 = new JProgressBar(this.mContext, null, defStyle, jPage);
                    if (item.getStrDrawable() != null) {
                        view12.setStrDrawable(item.getStrDrawable(), false);
                    }
                    if (bProgressDrawable) {
                        if (item.getStrDrawableExtra() != null) {
                            LayerDrawable drawable = (LayerDrawable) view12.getProgressDrawable();
                            drawable.setDrawableByLayerId(R.id.background, jPage.getDrawableFromPath(item.getStrDrawableExtra()[0], null, null));
                            ClipDrawable cd = new ClipDrawable(jPage.getDrawableFromPath(item.getStrDrawableExtra()[1], null, null), 3, 1);
                            drawable.setDrawableByLayerId(R.id.progress, cd);
                            view12.setIndeterminateDrawable(drawable);
                        }
                    } else {
                        view12.setIndeterminateDrawable(jPage.getDrawableFromPath(item.getStrDrawableExtra()[0], null, null));
                    }
                    child = view12;
                    break;
                case 22:
                    JSeekBar view13 = new JSeekBar(jPage);
                    if (item.getStrDrawable() != null) {
                        view13.setStrDrawable(item.getStrDrawable(), false);
                    }
                    child = view13;
                    view13.setIconName(item.getStrDrawableExtra());
                    if (FuncUtils.isLongLang()) {
                        view13.setTextSize(item.getHeight() - 2);
                    } else {
                        view13.setTextSize(item.getHeight());
                    }
                    if (item.getColor() != null) {
                        view13.setTextColor(item.getColor()[0]);
                    }
                    int[] para4 = item.getPara();
                    String[] strPara6 = item.getParaStr();
                    if (strPara6 != null) {
                        for (String strTmp4 : strPara6) {
                            if (strTmp4.contains("unSeekAble")) {
                                view13.bCanSeekAble = false;
                            } else if (strTmp4.contains("DrawMidTxt")) {
                                view13.bDrawMidTxt = true;
                            }
                        }
                    }
                    Rect[] rec = item.getRect();
                    view13.rec_seekBar = rec[0];
                    if (rec.length > 1) {
                        view13.rec_thumb = rec[1];
                    }
                    boolean bDispTxt = false;
                    if (para4 != null) {
                        if (para4.length >= 1) {
                            view13.setProgressMax(para4[0]);
                        }
                        if (para4.length >= 2) {
                            bDispTxt = para4[1] == 1;
                        }
                        if (para4.length >= 3) {
                            view13.hExtraTxt = getFixValue(para4[2], true);
                        }
                        if (para4.length >= 4) {
                            view13.hExtraTxtBk = getFixValue(para4[3], true);
                        }
                        if (para4.length >= 5) {
                            view13.hLine = getFixValue(para4[4], true);
                        }
                    }
                    if (bDispTxt) {
                        if (rec.length > 2) {
                            view13.rec_txtMin = rec[2];
                        }
                        if (rec.length > 3) {
                            view13.rec_txtMax = rec[3];
                        }
                    }
                    break;
                case 23:
                    JIndicator view14 = new JIndicator(jPage);
                    if (item.getStrDrawable() != null) {
                        view14.setStrDrawable(item.getStrDrawable(), false);
                    }
                    view14.setIconName(item.getStrDrawableExtra());
                    child = view14;
                    break;
                case 24:
                    JListApp view15 = new JListApp(jPage);
                    if (item.getStrDrawable() != null) {
                        view15.setStrDrawable(item.getStrDrawable(), false);
                    }
                    String[] strArray5 = item.getParaStr();
                    if (strArray5 != null && strArray5.length > 0 && this.mCtrlId != null && this.mCtrlId.containsKey(strArray5[0])) {
                        view15.setPageRow(this.mCtrlId.get(strArray5[0]).intValue());
                    }
                    child = view15;
                    break;
                case 25:
                    JDashLine view16 = new JDashLine(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view16.setStrDrawable(item.getStrDrawable(), false);
                    }
                    if (item.getColor() != null) {
                        view16.setColor(item.getColor()[0]);
                    }
                    child = view16;
                    break;
                case 26:
                    JLine view17 = new JLine(this.mContext, jPage);
                    if (item.getStrDrawable() != null) {
                        view17.setStrDrawable(item.getStrDrawable(), false);
                    }
                    if (item.getColor() != null) {
                        view17.setColor(item.getColor()[0]);
                    }
                    child = view17;
                    break;
            }
        }
        if (child != null) {
            if (item.getId() != -1) {
                child.setId(item.getId());
            }
            jPage.addChildView(child, item);
            child.setVisibility(item.getVisible());
            FrameLayout.LayoutParams lp = item.getLayoutParams();
            if (lp != null) {
                if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(lp.width, lp.height);
                    lp2.gravity = lp.gravity;
                    lp2.leftMargin = lp.leftMargin;
                    lp2.topMargin = lp.topMargin;
                    if (item.getWeight() > 0) {
                        lp2.weight = item.getWeight();
                    }
                    child.setLayoutParams(lp2);
                } else {
                    child.setLayoutParams(lp);
                }
            }
            int[] padding = item.getPadding();
            if (padding != null) {
                child.setPadding(padding[0], padding[1], padding[2], padding[3]);
            }
            viewGroup.addView(child);
        }
        if (child != null && this.mInterfaceUi != null) {
            this.mInterfaceUi.setProperty(child);
        }
        return child;
    }

    public void CreateViewByItem(JPage page, MyUiItem item, ViewGroup group) throws Throwable {
        int childCount;
        if (item != null) {
            if (item.getType() == 11) {
                JButton btn = (JButton) createUiItem(page, item, group);
                if (btn != null && (childCount = item.getChildCount()) > 0) {
                    btn.mPartnerViews = new ArrayList();
                    if (btn.mPartnerViews != null) {
                        for (int i = 0; i < childCount; i++) {
                            MyUiItem itemChild = item.getChildAt(i);
                            View child = createUiItem(page, itemChild, group);
                            if (child != null) {
                                btn.mPartnerViews.add(child);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (item.getChildCount() > 0) {
                if (item.getType() == 2) {
                    createScrollView(page, item, group);
                    return;
                } else if (item.getType() == 3) {
                    createScrollViewHorizontal(page, item, group);
                    return;
                } else {
                    createLayout(page, item, group);
                    return;
                }
            }
            if (item.getType() == 2) {
                createScrollView(page, item, group);
                return;
            }
            if (item.getType() == 3) {
                createScrollViewHorizontal(page, item, group);
            } else if (item.getType() == 4) {
                createLayout(page, item, group);
            } else {
                createUiItem(page, item, group);
            }
        }
    }

    private JPage createPage(MyUiItem item, JPage pageExist) throws Throwable {
        Animation anim;
        JPage group = pageExist;
        if (group == null) {
            group = new JPage(this.mContext, this);
            group.setTag(item);
            if (item.getId() != -1) {
                group.setId(item.getId());
            }
        }
        if (group != null) {
            int childCount = item.getChildCount();
            for (int i = 0; i < childCount; i++) {
                MyUiItem child = item.getChildAt(i);
                CreateViewByItem(group, child, group);
            }
            if (item.getAnim() != null && (anim = loadAnimation(item.getAnim())) != null) {
                group.startAnimation(anim);
            }
        }
        return group;
    }

    public JPage loadPage(boolean bNotListItem, int idPage) {
        return loadPage(bNotListItem, idPage, null);
    }

    public static String getCurrentLang() {
        Locale localeDefault = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            localeDefault = LocaleList.getDefault().get(0);
        }
        return String.valueOf(localeDefault.getLanguage()) + "-" + localeDefault.getCountry();
    }

    public JPage loadPage(boolean bNotListItem, int idPage, JPage pageExist) throws Throwable {
        this.bIsInListItem = !bNotListItem;
        JPage page = this.mPages.get(idPage);
        if (page != null && page.isNeedReload()) {
            this.mPageUiItems.remove(page.getId());
            page = null;
        }
        if (page == null) {
            MyUiItem item = getUiItemAt(idPage);
            if (item == null && this.mMapPage.indexOfKey(idPage) >= 0) {
                ParseXml(this.mMapPage.get(idPage));
                item = getUiItemAt(idPage);
            }
            if (item != null && (page = createPage(item, pageExist)) != null) {
                page.mLanguage = getCurrentLang();
                page.mStrHeadXml = mStrHeadXml;
                if (pageExist == null) {
                    page.setPadding(0, item.mPlusPadding, 0, 0);
                    FrameLayout.LayoutParams lp = item.getLayoutParams();
                    if (lp != null) {
                        page.setLayoutParams(lp);
                    }
                    if (bNotListItem) {
                        page.setStrDrawable(item.getStrDrawable(), false);
                        this.mPages.put(idPage, page);
                    }
                    if (this.mInterfaceUi != null) {
                        this.mInterfaceUi.InitPage(page);
                    }
                    IPageNotify pageNotify = page.getNotify();
                    if (pageNotify != null) {
                        pageNotify.init();
                    }
                }
            }
        }
        return page;
    }

    public Dialog getPopDlg(int idPage, String strAnim, boolean bCanelTouchOutSide) {
        return getPopDlg(idPage, strAnim, bCanelTouchOutSide, 0);
    }

    public Dialog getPopDlg(int idPage, String strAnim, boolean bCanelTouchOutSide, int idThemeDlg) {
        int idAnim;
        if (this.mActivity == null) {
            return null;
        }
        Dialog dlg = this.mDlgs.get(idPage);
        if (dlg == null) {
            JPage page = loadPage(true, idPage);
            if (page != null) {
                if (idThemeDlg == 0) {
                    dlg = new Dialog(this.mActivity);
                } else {
                    dlg = new Dialog(this.mActivity, idThemeDlg);
                }
                dlg.requestWindowFeature(1);
                dlg.setContentView(page);
                dlg.setCanceledOnTouchOutside(bCanelTouchOutSide);
                page.setDialog(dlg);
                dlg.setOnDismissListener(new MyOnDismissListener(page));
                MyUiItem item = (MyUiItem) page.getTag();
                Window window = dlg.getWindow();
                WindowManager.LayoutParams p = window.getAttributes();
                p.height = item.getHeight();
                p.width = item.getWidth();
                p.dimAmount = 0.0f;
                window.setBackgroundDrawable(new ColorDrawable(0));
                int[] pos = item.getPos();
                if (IpcUtil.intsOk(pos, 2)) {
                    p.x = pos[0];
                    p.y = pos[1];
                    window.setGravity(51);
                } else {
                    window.setGravity(17);
                }
                window.setAttributes(p);
                if (!TextUtils.isEmpty(strAnim) && (idAnim = mResources.getIdentifier(strAnim, "style", mPkgName)) > 0) {
                    window.setWindowAnimations(idAnim);
                }
            }
            if (dlg != null) {
                this.mDlgs.put(idPage, dlg);
                return dlg;
            }
            return dlg;
        }
        return dlg;
    }

    public void removePage(int idPage) {
        this.mPageUiItems.remove(idPage);
        this.mPages.remove(idPage);
    }

    public static Drawable getXmlStateListDrawable(MyUi ui, Markup xml, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (xml.IntoItem()) {
            do {
                if (!TextUtils.isEmpty(xml.GetAttr("android:drawable"))) {
                    Drawable drawableTmp = null;
                    List<Integer> list = new ArrayList<>();
                    String strTemp = xml.GetAttr("android:state_pressed");
                    if (!TextUtils.isEmpty(strTemp)) {
                        boolean bTmp = Boolean.parseBoolean(strTemp);
                        list.add(Integer.valueOf(bTmp ? R.attr.state_pressed : -16842919));
                    }
                    String strTemp2 = xml.GetAttr("android:state_focused");
                    if (!TextUtils.isEmpty(strTemp2)) {
                        boolean bTmp2 = Boolean.parseBoolean(strTemp2);
                        list.add(Integer.valueOf(bTmp2 ? R.attr.state_focused : -16842908));
                    }
                    String strTemp3 = xml.GetAttr("android:state_selected");
                    if (!TextUtils.isEmpty(strTemp3)) {
                        boolean bTmp3 = Boolean.parseBoolean(strTemp3);
                        list.add(Integer.valueOf(bTmp3 ? R.attr.state_selected : -16842913));
                    }
                    String strTemp4 = xml.GetAttr("android:state_checked");
                    if (!TextUtils.isEmpty(strTemp4)) {
                        boolean bTmp4 = Boolean.parseBoolean(strTemp4);
                        list.add(Integer.valueOf(bTmp4 ? R.attr.state_checked : -16842912));
                    }
                    String strTemp5 = xml.GetAttr("android:state_enabled");
                    if (!TextUtils.isEmpty(strTemp5)) {
                        boolean bTmp5 = Boolean.parseBoolean(strTemp5);
                        list.add(Integer.valueOf(bTmp5 ? R.attr.state_enabled : -16842910));
                    }
                    String strTemp6 = xml.GetAttr("android:state_hovered");
                    if (!TextUtils.isEmpty(strTemp6)) {
                        boolean bTmp6 = Boolean.parseBoolean(strTemp6);
                        list.add(Integer.valueOf(bTmp6 ? R.attr.state_hovered : -16843623));
                    }
                    String strTemp7 = xml.GetAttr("android:state_checkable");
                    if (!TextUtils.isEmpty(strTemp7)) {
                        boolean bTmp7 = Boolean.parseBoolean(strTemp7);
                        list.add(Integer.valueOf(bTmp7 ? R.attr.state_checkable : -16842911));
                    }
                    String strTemp8 = xml.GetAttr("android:state_activated");
                    if (!TextUtils.isEmpty(strTemp8)) {
                        boolean bTmp8 = Boolean.parseBoolean(strTemp8);
                        list.add(Integer.valueOf(bTmp8 ? R.attr.state_activated : -16843518));
                    }
                    String strTemp9 = xml.GetAttr("android:state_window_focused");
                    if (!TextUtils.isEmpty(strTemp9)) {
                        boolean bTmp9 = Boolean.parseBoolean(strTemp9);
                        list.add(Integer.valueOf(bTmp9 ? R.attr.state_window_focused : -16842909));
                    }
                    String strTemp10 = xml.GetAttr("android:drawable");
                    if (!TextUtils.isEmpty(strTemp10)) {
                        int indexLast = strTemp10.lastIndexOf("/");
                        drawableTmp = ui.getDrawableFromPath(strTemp10.substring(indexLast + 1), mapDrawables, tmpMapDrawables);
                    } else {
                        String strTemp11 = xml.GetAttr("android:color");
                        if (strTemp11.startsWith("#")) {
                            drawableTmp = new ColorDrawable(Color.parseColor(strTemp11));
                        }
                    }
                    if (list.size() > 0) {
                        int[] stateSet = new int[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            stateSet[i] = list.get(i).intValue();
                        }
                        stateListDrawable.addState(stateSet, drawableTmp);
                    } else {
                        stateListDrawable.addState(new int[0], drawableTmp);
                    }
                }
            } while (xml.NextItem());
            xml.ExitItem();
        }
        return stateListDrawable;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x006e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Drawable getXmlGradientDrawable(Context context, Markup xml) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        String strTemp = xml.GetAttr("android:shape");
        if (strTemp != null) {
            switch (strTemp) {
                case "line":
                    gradientDrawable.setShape(2);
                    break;
                case "oval":
                    gradientDrawable.setShape(1);
                    break;
                case "ring":
                    gradientDrawable.setShape(3);
                    break;
                case "rectangle":
                    gradientDrawable.setShape(0);
                    break;
                default:
                    gradientDrawable.setShape(0);
                    break;
            }
        } else {
            gradientDrawable.setShape(0);
        }
        if (xml.IntoItem()) {
            do {
                String strTemp2 = xml.FindToken(xml.mItemCur.mStrBuff, xml.mItemCur.mPosEnd - xml.mItemCur.mPosStart, 0, null);
                switch (strTemp2.hashCode()) {
                    case -891980232:
                        if (strTemp2.equals("stroke")) {
                            int width = 0;
                            int color = 0;
                            float dashWidth = 0.0f;
                            float dashGap = 0.0f;
                            String strTemp3 = xml.GetAttr("android:width");
                            if (!TextUtils.isEmpty(strTemp3)) {
                                width = Integer.parseInt(strTemp3.substring(0, strTemp3.length() - 2));
                                if (strTemp3.endsWith("dp")) {
                                    width = FuncUtils.dp2px(context, width);
                                }
                            }
                            String strTemp4 = xml.GetAttr("android:color");
                            if (!TextUtils.isEmpty(strTemp4) && strTemp4.startsWith("#")) {
                                color = Color.parseColor(strTemp4);
                            }
                            String strTemp5 = xml.GetAttr("android:dashWidth");
                            if (!TextUtils.isEmpty(strTemp5)) {
                                dashWidth = Integer.parseInt(strTemp5.substring(0, strTemp5.length() - 2));
                                if (strTemp5.endsWith("dp")) {
                                    dashWidth = FuncUtils.dp2px(context, dashWidth);
                                }
                            }
                            String strTemp6 = xml.GetAttr("android:dashGap");
                            if (!TextUtils.isEmpty(strTemp6)) {
                                dashGap = Integer.parseInt(strTemp6.substring(0, strTemp6.length() - 2));
                                if (strTemp6.endsWith("dp")) {
                                    dashGap = FuncUtils.dp2px(context, dashGap);
                                }
                            }
                            gradientDrawable.setStroke(width, color, dashWidth, dashGap);
                        }
                        break;
                    case -806339567:
                        if (strTemp2.equals("padding")) {
                            int left = 0;
                            int top = 0;
                            int right = 0;
                            int bottom = 0;
                            String strTemp7 = xml.GetAttr("android:left");
                            if (!TextUtils.isEmpty(strTemp7)) {
                                left = Integer.parseInt(strTemp7.substring(0, strTemp7.length() - 2));
                                if (strTemp7.endsWith("dp")) {
                                    left = FuncUtils.dp2px(context, left);
                                }
                            }
                            String strTemp8 = xml.GetAttr("android:top");
                            if (!TextUtils.isEmpty(strTemp8)) {
                                top = Integer.parseInt(strTemp8.substring(0, strTemp8.length() - 2));
                                if (strTemp8.endsWith("dp")) {
                                    top = FuncUtils.dp2px(context, top);
                                }
                            }
                            String strTemp9 = xml.GetAttr("android:right");
                            if (!TextUtils.isEmpty(strTemp9)) {
                                right = Integer.parseInt(strTemp9.substring(0, strTemp9.length() - 2));
                                if (strTemp9.endsWith("dp")) {
                                    right = FuncUtils.dp2px(context, right);
                                }
                            }
                            String strTemp10 = xml.GetAttr("android:bottom");
                            if (!TextUtils.isEmpty(strTemp10)) {
                                bottom = Integer.parseInt(strTemp10.substring(0, strTemp10.length() - 2));
                                if (strTemp10.endsWith("dp")) {
                                    bottom = FuncUtils.dp2px(context, bottom);
                                }
                            }
                            Rect rec = new Rect(left, top, right, bottom);
                            ReflectionUtil.setValue(gradientDrawable, "mPadding", rec);
                            Object obj = ReflectionUtil.getValue(gradientDrawable, "mGradientState");
                            ReflectionUtil.setValue(obj, "mPadding", rec);
                        }
                        break;
                    case 3530753:
                        if (strTemp2.equals("size")) {
                            int width2 = 0;
                            int height = 0;
                            String strTemp11 = xml.GetAttr("android:width");
                            if (!TextUtils.isEmpty(strTemp11)) {
                                width2 = Integer.parseInt(strTemp11.substring(0, strTemp11.length() - 2));
                                if (strTemp11.endsWith("dp")) {
                                    width2 = FuncUtils.dp2px(context, width2);
                                }
                            }
                            String strTemp12 = xml.GetAttr("android:height");
                            if (!TextUtils.isEmpty(strTemp12)) {
                                height = Integer.parseInt(strTemp12.substring(0, strTemp12.length() - 2));
                                if (strTemp12.endsWith("dp")) {
                                    height = FuncUtils.dp2px(context, height);
                                }
                            }
                            if (width2 > 0 && height > 0) {
                                gradientDrawable.setSize(width2, height);
                            }
                        }
                        break;
                    case 89650992:
                        if (strTemp2.equals("gradient")) {
                            String strTemp13 = xml.GetAttr("android:centerX");
                            float x = TextUtils.isEmpty(strTemp13) ? 0.5f : Float.parseFloat(strTemp13);
                            String strTemp14 = xml.GetAttr("android:centerY");
                            float y = TextUtils.isEmpty(strTemp14) ? 0.5f : Float.parseFloat(strTemp14);
                            gradientDrawable.setGradientCenter(x, y);
                            String strTemp15 = xml.GetAttr("android:startColor");
                            int colorStart = TextUtils.isEmpty(strTemp15) ? -1 : Color.parseColor(strTemp15);
                            String strTemp16 = xml.GetAttr("android:endColor");
                            int colorEnd = TextUtils.isEmpty(strTemp16) ? -1 : Color.parseColor(strTemp16);
                            String strTemp17 = xml.GetAttr("android:centerColor");
                            int colorCenter = TextUtils.isEmpty(strTemp17) ? -1 : Color.parseColor(strTemp17);
                            if (colorCenter != -1) {
                                gradientDrawable.setColors(new int[]{colorStart, colorCenter, colorEnd});
                            } else {
                                gradientDrawable.setColors(new int[]{colorStart, colorEnd});
                            }
                            String strTemp18 = xml.GetAttr("android:gradientRadius");
                            if (!TextUtils.isEmpty(strTemp18)) {
                                float gradientRadius = Float.parseFloat(strTemp18.substring(0, strTemp18.length() - 2));
                                if (strTemp18.endsWith("dp")) {
                                    gradientRadius = FuncUtils.dp2px(context, gradientRadius);
                                }
                                gradientDrawable.setGradientRadius(gradientRadius);
                            }
                            String strTemp19 = xml.GetAttr("android:type");
                            if (!TextUtils.isEmpty(strTemp19)) {
                                switch (strTemp19.hashCode()) {
                                    case -1102672091:
                                        if (strTemp19.equals("linear")) {
                                            gradientDrawable.setGradientType(0);
                                        }
                                        break;
                                    case -938579425:
                                        if (strTemp19.equals("radial")) {
                                            gradientDrawable.setGradientType(1);
                                        }
                                        break;
                                    case 109850348:
                                        if (strTemp19.equals("sweep")) {
                                            gradientDrawable.setGradientType(2);
                                        }
                                        break;
                                }
                            }
                            String strTemp20 = xml.GetAttr("android:useLevel");
                            if (!TextUtils.isEmpty(strTemp20)) {
                                switch (strTemp20.hashCode()) {
                                    case 3569038:
                                        if (strTemp20.equals("true")) {
                                            gradientDrawable.setUseLevel(true);
                                        }
                                        break;
                                    case 97196323:
                                        if (strTemp20.equals("false")) {
                                            gradientDrawable.setUseLevel(false);
                                        }
                                        break;
                                }
                            }
                        }
                        break;
                    case 109618859:
                        if (strTemp2.equals("solid")) {
                            String strTemp21 = xml.GetAttr("android:color");
                            if (!TextUtils.isEmpty(strTemp21) && strTemp21.startsWith("#")) {
                                gradientDrawable.setColor(Color.parseColor(strTemp21));
                            }
                        }
                        break;
                    case 955046078:
                        if (strTemp2.equals("corners")) {
                            String strTemp22 = xml.GetAttr("android:radius");
                            if (TextUtils.isEmpty(strTemp22)) {
                                boolean bNeedSetRadius = false;
                                float[] radii = new float[4];
                                String strTemp23 = xml.GetAttr("android:topLeftRadius");
                                if (!TextUtils.isEmpty(strTemp23)) {
                                    bNeedSetRadius = true;
                                    radii[0] = Float.parseFloat(strTemp23.substring(0, strTemp23.length() - 2));
                                    if (strTemp23.endsWith("dp")) {
                                        radii[0] = FuncUtils.dp2px(context, radii[0]);
                                    }
                                }
                                String strTemp24 = xml.GetAttr("android:topRightRadius");
                                if (!TextUtils.isEmpty(strTemp24)) {
                                    bNeedSetRadius = true;
                                    radii[1] = Float.parseFloat(strTemp24.substring(0, strTemp24.length() - 2));
                                    if (strTemp24.endsWith("dp")) {
                                        radii[1] = FuncUtils.dp2px(context, radii[1]);
                                    }
                                }
                                String strTemp25 = xml.GetAttr("android:bottomRightRadius");
                                if (!TextUtils.isEmpty(strTemp25)) {
                                    bNeedSetRadius = true;
                                    radii[2] = Float.parseFloat(strTemp25.substring(0, strTemp25.length() - 2));
                                    if (strTemp25.endsWith("dp")) {
                                        radii[2] = FuncUtils.dp2px(context, radii[2]);
                                    }
                                }
                                String strTemp26 = xml.GetAttr("android:bottomLeftRadiu");
                                if (!TextUtils.isEmpty(strTemp26)) {
                                    bNeedSetRadius = true;
                                    radii[3] = Float.parseFloat(strTemp26.substring(0, strTemp26.length() - 2));
                                    if (strTemp26.endsWith("dp")) {
                                        radii[3] = FuncUtils.dp2px(context, radii[3]);
                                    }
                                }
                                if (bNeedSetRadius) {
                                    gradientDrawable.setCornerRadii(new float[]{radii[0], radii[0], radii[1], radii[1], radii[2], radii[2], radii[3], radii[3]});
                                }
                            } else {
                                float radius = Float.parseFloat(strTemp22.substring(0, strTemp22.length() - 2));
                                if (strTemp22.endsWith("dp")) {
                                    radius = FuncUtils.dp2px(context, radius);
                                }
                                gradientDrawable.setCornerRadius(radius);
                            }
                        }
                        break;
                    default:
                        break;
                }
            } while (xml.NextItem());
            xml.ExitItem();
        }
        return gradientDrawable;
    }

    public static Drawable getXmlAnimationDrawable(MyUi ui, Markup xml, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        if ("false".equals(xml.GetAttr("android:oneshot"))) {
            animationDrawable.setOneShot(false);
        }
        if (xml.IntoItem()) {
            do {
                int duration = 0;
                Drawable frame = null;
                String strTemp = xml.GetAttr("android:duration");
                if (!TextUtils.isEmpty(strTemp)) {
                    duration = Integer.parseInt(strTemp);
                }
                String strTemp2 = xml.GetAttr("android:drawable");
                if (!TextUtils.isEmpty(strTemp2)) {
                    int indexLast = strTemp2.lastIndexOf("/");
                    frame = ui.getDrawableFromPath(strTemp2.substring(indexLast + 1), mapDrawables, tmpMapDrawables);
                } else {
                    String strTemp3 = xml.GetAttr("android:color");
                    if (strTemp3.startsWith("#")) {
                        frame = new ColorDrawable(Color.parseColor(strTemp3));
                    }
                }
                animationDrawable.addFrame(frame, duration);
            } while (xml.NextItem());
            xml.ExitItem();
        }
        return animationDrawable;
    }

    public static Drawable getXmlBitmapDrawable(MyUi ui, Markup xml, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        Drawable drawable = null;
        BitmapDrawable bitmapDrawable = null;
        String strTemp = xml.GetAttr("android:src");
        if (!TextUtils.isEmpty(strTemp)) {
            int indexLast = strTemp.lastIndexOf("/");
            String resName = strTemp.substring(indexLast + 1);
            drawable = ui.getDrawableFromPath(resName, mapDrawables, tmpMapDrawables);
            if (drawable instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) drawable;
            }
        }
        if (bitmapDrawable != null) {
            String strTemp2 = xml.GetAttr("android:antialias");
            if (!TextUtils.isEmpty(strTemp2)) {
                bitmapDrawable.setAntiAlias(Boolean.parseBoolean(strTemp2));
            }
            String strTemp3 = xml.GetAttr("android:dither");
            if (!TextUtils.isEmpty(strTemp3)) {
                bitmapDrawable.setDither(Boolean.parseBoolean(strTemp3));
            }
            String strTemp4 = xml.GetAttr("android:filter");
            if (!TextUtils.isEmpty(strTemp4)) {
                bitmapDrawable.setFilterBitmap(Boolean.parseBoolean(strTemp4));
            }
            String strTemp5 = xml.GetAttr("android:mipMap");
            if (!TextUtils.isEmpty(strTemp5)) {
                bitmapDrawable.setMipMap(Boolean.parseBoolean(strTemp5));
            }
            String strTemp6 = xml.GetAttr("android:gravity");
            if (!TextUtils.isEmpty(strTemp6)) {
                int gravity = 0;
                String[] strArray = strTemp6.trim().split("|");
                if (strArray != null && strArray.length > 0) {
                    for (int i = 0; i < strArray.length; i++) {
                        if (strArray[i].equals("top")) {
                            gravity |= 48;
                        } else if (strArray[i].equals("bottom")) {
                            gravity |= 80;
                        } else if (strArray[i].equals("left")) {
                            gravity |= 3;
                        } else if (strArray[i].equals("right")) {
                            gravity |= 5;
                        } else if (strArray[i].equals("center_vertical")) {
                            gravity |= 16;
                        } else if (strArray[i].equals("fill_vertical")) {
                            gravity |= 112;
                        } else if (strArray[i].equals("center_horizontal")) {
                            gravity |= 1;
                        } else if (strArray[i].equals("fill_horizontal")) {
                            gravity |= 7;
                        } else if (strArray[i].equals("center")) {
                            gravity |= 17;
                        } else if (strArray[i].equals("fill")) {
                            gravity |= 119;
                        } else if (strArray[i].equals("clip_vertical")) {
                            gravity |= 128;
                        } else if (strArray[i].equals("clip_horizontal")) {
                            gravity |= 8;
                        }
                    }
                }
                bitmapDrawable.setGravity(gravity);
            }
            String strTemp7 = xml.GetAttr("android:tileModeX");
            if (!TextUtils.isEmpty(strTemp7)) {
                if (strTemp7.equals("clamp")) {
                    bitmapDrawable.setTileModeX(Shader.TileMode.CLAMP);
                }
                if (strTemp7.equals("repeat")) {
                    bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                }
                if (strTemp7.equals("mirror")) {
                    bitmapDrawable.setTileModeX(Shader.TileMode.MIRROR);
                }
            }
            String strTemp8 = xml.GetAttr("android:tileModeY");
            if (!TextUtils.isEmpty(strTemp8)) {
                if (strTemp8.equals("clamp")) {
                    bitmapDrawable.setTileModeY(Shader.TileMode.CLAMP);
                }
                if (strTemp8.equals("repeat")) {
                    bitmapDrawable.setTileModeY(Shader.TileMode.REPEAT);
                }
                if (strTemp8.equals("mirror")) {
                    bitmapDrawable.setTileModeY(Shader.TileMode.MIRROR);
                }
            }
            String strTemp9 = xml.GetAttr("android:tileMode");
            if (!TextUtils.isEmpty(strTemp9)) {
                if (strTemp9.equals("clamp")) {
                    bitmapDrawable.setTileModeXY(Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                }
                if (strTemp9.equals("repeat")) {
                    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                }
                if (strTemp9.equals("mirror")) {
                    bitmapDrawable.setTileModeXY(Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
                }
            }
        }
        return drawable;
    }

    public static Drawable getXmlLevelListDrawable(MyUi ui, Markup xml, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        if (xml.IntoItem()) {
            do {
                int low = 0;
                int high = 0;
                Drawable drawable = null;
                String strTemp = xml.GetAttr("android:minLevel");
                if (!TextUtils.isEmpty(strTemp)) {
                    low = Integer.parseInt(strTemp);
                }
                String strTemp2 = xml.GetAttr("android:maxLevel");
                if (!TextUtils.isEmpty(strTemp2)) {
                    high = Integer.parseInt(strTemp2);
                }
                String strTemp3 = xml.GetAttr("android:drawable");
                if (!TextUtils.isEmpty(strTemp3)) {
                    int indexLast = strTemp3.lastIndexOf("/");
                    drawable = ui.getDrawableFromPath(strTemp3.substring(indexLast + 1), mapDrawables, tmpMapDrawables);
                } else {
                    String strTemp4 = xml.GetAttr("android:color");
                    if (strTemp4.startsWith("#")) {
                        drawable = new ColorDrawable(Color.parseColor(strTemp4));
                    }
                }
                levelListDrawable.addLevel(low, high, drawable);
            } while (xml.NextItem());
            xml.ExitItem();
        }
        return levelListDrawable;
    }

    public static Drawable getXmlColorDrawable(Markup xml) {
        String strTemp = xml.GetAttr("android:color");
        if (TextUtils.isEmpty(strTemp) || !strTemp.startsWith("#")) {
            return null;
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(strTemp));
        return colorDrawable;
    }

    public static Drawable getXmlRotateDrawable(MyUi ui, Markup xml, HashMap<String, Drawable> mapDrawables, HashMap<String, Drawable> tmpMapDrawables) {
        float pivotY;
        float pivotX;
        RotateDrawable rotateDrawable = new RotateDrawable();
        Drawable drawable = null;
        String strTemp = xml.GetAttr("android:drawable");
        if (!TextUtils.isEmpty(strTemp)) {
            int indexLast = strTemp.lastIndexOf("/");
            drawable = ui.getDrawableFromPath(strTemp.substring(indexLast + 1), mapDrawables, tmpMapDrawables);
        } else {
            String strTemp2 = xml.GetAttr("android:color");
            if (strTemp2.startsWith("#")) {
                drawable = new ColorDrawable(Color.parseColor(strTemp2));
            }
        }
        rotateDrawable.setDrawable(drawable);
        String strTemp3 = xml.GetAttr("android:pivotX");
        if (!TextUtils.isEmpty(strTemp3)) {
            boolean bRelative = false;
            if (strTemp3.contains("%")) {
                bRelative = true;
            }
            int index = strTemp3.lastIndexOf("%");
            if (index >= 0) {
                String strX = strTemp3.substring(0, index);
                pivotX = Float.parseFloat(strX) / 100.0f;
            } else {
                pivotX = Float.parseFloat(strTemp3);
            }
            rotateDrawable.setPivotXRelative(bRelative);
            rotateDrawable.setPivotX(pivotX);
        }
        String strTemp4 = xml.GetAttr("android:pivotY");
        if (!TextUtils.isEmpty(strTemp4)) {
            boolean bRelative2 = false;
            if (strTemp4.contains("%")) {
                bRelative2 = true;
            }
            int index2 = strTemp4.lastIndexOf("%");
            if (index2 >= 0) {
                String strY = strTemp4.substring(0, index2);
                pivotY = Float.parseFloat(strY) / 100.0f;
            } else {
                pivotY = Float.parseFloat(strTemp4);
            }
            rotateDrawable.setPivotYRelative(bRelative2);
            rotateDrawable.setPivotY(pivotY);
        }
        String strTemp5 = xml.GetAttr("android:fromDegrees");
        if (!TextUtils.isEmpty(strTemp5)) {
            float fromDegrees = Float.parseFloat(strTemp5);
            rotateDrawable.setFromDegrees(fromDegrees);
        }
        String strTemp6 = xml.GetAttr("android:toDegrees");
        if (!TextUtils.isEmpty(strTemp6)) {
            float toDegrees = Float.parseFloat(strTemp6);
            rotateDrawable.setToDegrees(toDegrees);
        }
        String strTemp7 = xml.GetAttr("android:visible");
        if (!TextUtils.isEmpty(strTemp7)) {
            boolean bVisible = Boolean.parseBoolean(strTemp7);
            rotateDrawable.setVisible(bVisible, true);
        }
        return rotateDrawable;
    }

    public static Animation createAnimationFromXml(Context c, XmlPullParser parser, AnimationSet parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        Animation anim = null;
        int depth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if ((type == 3 && parser.getDepth() <= depth) || type == 1) {
                break;
            }
            if (type == 2) {
                String strInterpolator = FinalChip.BSP_PLATFORM_Null;
                long durationMillis = 100;
                String name = parser.getName();
                if (name.equals("set")) {
                    anim = new AnimationSet(false);
                    createAnimationFromXml(c, parser, (AnimationSet) anim, attrs);
                } else if (name.equals("alpha")) {
                    float fromAlpha = 1.0f;
                    float toAlpha = 1.0f;
                    int cnt = attrs.getAttributeCount();
                    for (int i = 0; i < cnt; i++) {
                        String strName = attrs.getAttributeName(i);
                        String strVal = attrs.getAttributeValue(i);
                        if (strName.equals("duration")) {
                            durationMillis = Long.parseLong(strVal);
                        } else if (strName.equals("interpolator")) {
                            strInterpolator = strVal;
                        } else if (strName.equals("fromAlpha")) {
                            fromAlpha = Float.parseFloat(strVal);
                        } else if (strName.equals("toAlpha")) {
                            toAlpha = Float.parseFloat(strVal);
                        }
                    }
                    anim = new AlphaAnimation(fromAlpha, toAlpha);
                } else if (name.equals("scale")) {
                    float fromX = 0.0f;
                    float toX = 0.0f;
                    float fromY = 0.0f;
                    float toY = 0.0f;
                    int pivotXType = 0;
                    int pivotYType = 0;
                    float pivotXValue = 0.0f;
                    float pivotYValue = 0.0f;
                    int cnt2 = attrs.getAttributeCount();
                    for (int i2 = 0; i2 < cnt2; i2++) {
                        String strName2 = attrs.getAttributeName(i2);
                        String strVal2 = attrs.getAttributeValue(i2);
                        if (strName2.equals("duration")) {
                            durationMillis = Long.parseLong(strVal2);
                        } else if (strName2.equals("interpolator")) {
                            strInterpolator = strVal2;
                        } else if (strName2.equals("fromXScale")) {
                            int index = strVal2.lastIndexOf("%");
                            if (index >= 0) {
                                String strX = strVal2.substring(0, index);
                                fromX = Float.parseFloat(strX) / 100.0f;
                            }
                        } else if (strName2.equals("toXScale")) {
                            int index2 = strVal2.lastIndexOf("%");
                            if (index2 >= 0) {
                                String strX2 = strVal2.substring(0, index2);
                                toX = Float.parseFloat(strX2) / 100.0f;
                            }
                        } else if (strName2.equals("fromYScale")) {
                            int index3 = strVal2.lastIndexOf("%");
                            if (index3 >= 0) {
                                String strY = strVal2.substring(0, index3);
                                fromY = Float.parseFloat(strY) / 100.0f;
                            }
                        } else if (strName2.equals("toYScale")) {
                            int index4 = strVal2.lastIndexOf("%");
                            if (index4 >= 0) {
                                String strY2 = strVal2.substring(0, index4);
                                toY = Float.parseFloat(strY2) / 100.0f;
                            }
                        } else if (strName2.equals("pivotX")) {
                            if (strVal2.contains("%p")) {
                                pivotXType = 2;
                            } else if (strVal2.contains("%")) {
                                pivotXType = 1;
                            }
                            int index5 = strVal2.lastIndexOf("%");
                            if (index5 >= 0) {
                                String strX3 = strVal2.substring(0, index5);
                                pivotXValue = Float.parseFloat(strX3) / 100.0f;
                            } else {
                                pivotXValue = Float.parseFloat(strVal2);
                            }
                        } else if (strName2.equals("pivotY")) {
                            if (strVal2.contains("%p")) {
                                pivotYType = 2;
                            } else if (strVal2.contains("%")) {
                                pivotYType = 1;
                            }
                            int index6 = strVal2.lastIndexOf("%");
                            if (index6 >= 0) {
                                String strY3 = strVal2.substring(0, index6);
                                pivotYValue = Float.parseFloat(strY3) / 100.0f;
                            } else {
                                pivotYValue = Float.parseFloat(strVal2);
                            }
                        }
                    }
                    anim = new ScaleAnimation(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
                } else if (name.equals("rotate")) {
                    float fromDegrees = 0.0f;
                    float toDegrees = 0.0f;
                    int pivotXType2 = 0;
                    int pivotYType2 = 0;
                    float pivotXValue2 = 0.0f;
                    float pivotYValue2 = 0.0f;
                    int cnt3 = attrs.getAttributeCount();
                    for (int i3 = 0; i3 < cnt3; i3++) {
                        String strName3 = attrs.getAttributeName(i3);
                        String strVal3 = attrs.getAttributeValue(i3);
                        if (strName3.equals("duration")) {
                            durationMillis = Long.parseLong(strVal3);
                        } else if (strName3.equals("interpolator")) {
                            strInterpolator = strVal3;
                        } else if (strName3.equals("fromDegrees")) {
                            fromDegrees = Float.parseFloat(strVal3);
                        } else if (strName3.equals("toDegrees")) {
                            toDegrees = Float.parseFloat(strVal3);
                        } else if (strName3.equals("pivotX")) {
                            if (strVal3.contains("%p")) {
                                pivotXType2 = 2;
                            } else if (strVal3.contains("%")) {
                                pivotXType2 = 1;
                            }
                            int index7 = strVal3.lastIndexOf("%");
                            if (index7 >= 0) {
                                String strX4 = strVal3.substring(0, index7);
                                pivotXValue2 = Float.parseFloat(strX4) / 100.0f;
                            } else {
                                pivotXValue2 = Float.parseFloat(strVal3);
                            }
                        } else if (strName3.equals("pivotY")) {
                            if (strVal3.contains("%p")) {
                                pivotYType2 = 2;
                            } else if (strVal3.contains("%")) {
                                pivotYType2 = 1;
                            }
                            int index8 = strVal3.lastIndexOf("%");
                            if (index8 >= 0) {
                                String strY4 = strVal3.substring(0, index8);
                                pivotYValue2 = Float.parseFloat(strY4) / 100.0f;
                            } else {
                                pivotYValue2 = Float.parseFloat(strVal3);
                            }
                        }
                    }
                    anim = new RotateAnimation(fromDegrees, toDegrees, pivotXType2, pivotXValue2, pivotYType2, pivotYValue2);
                } else if (name.equals("translate")) {
                    int fromXType = 0;
                    int toXType = 0;
                    int fromYType = 0;
                    int toYType = 0;
                    float fromXValue = 0.0f;
                    float toXValue = 0.0f;
                    float fromYValue = 0.0f;
                    float toYValue = 0.0f;
                    int cnt4 = attrs.getAttributeCount();
                    for (int i4 = 0; i4 < cnt4; i4++) {
                        String strName4 = attrs.getAttributeName(i4);
                        String strVal4 = attrs.getAttributeValue(i4);
                        if (strName4.equals("duration")) {
                            durationMillis = Long.parseLong(strVal4);
                        } else if (strName4.equals("interpolator")) {
                            strInterpolator = strVal4;
                        } else if (strName4.equals("fromXDelta")) {
                            if (strVal4.contains("%p")) {
                                fromXType = 2;
                            } else if (strVal4.contains("%")) {
                                fromXType = 1;
                            }
                            int index9 = strVal4.lastIndexOf("%");
                            if (index9 >= 0) {
                                String strX5 = strVal4.substring(0, index9);
                                fromXValue = Float.parseFloat(strX5) / 100.0f;
                            } else {
                                fromXValue = Float.parseFloat(strVal4);
                            }
                        } else if (strName4.equals("toXDelta")) {
                            if (strVal4.contains("%p")) {
                                toXType = 2;
                            } else if (strVal4.contains("%")) {
                                toXType = 1;
                            }
                            int index10 = strVal4.lastIndexOf("%");
                            if (index10 >= 0) {
                                String strX6 = strVal4.substring(0, index10);
                                toXValue = Float.parseFloat(strX6) / 100.0f;
                            } else {
                                toXValue = Float.parseFloat(strVal4);
                            }
                        } else if (strName4.equals("fromYDelta")) {
                            if (strVal4.contains("%p")) {
                                fromYType = 2;
                            } else if (strVal4.contains("%")) {
                                fromYType = 1;
                            }
                            int index11 = strVal4.lastIndexOf("%");
                            if (index11 >= 0) {
                                String strY5 = strVal4.substring(0, index11);
                                fromYValue = Float.parseFloat(strY5) / 100.0f;
                            } else {
                                fromYValue = Float.parseFloat(strVal4);
                            }
                        } else if (strName4.equals("toYDelta")) {
                            if (strVal4.contains("%p")) {
                                toYType = 2;
                            } else if (strVal4.contains("%")) {
                                toYType = 1;
                            }
                            int index12 = strVal4.lastIndexOf("%");
                            if (index12 >= 0) {
                                String strY6 = strVal4.substring(0, index12);
                                toYValue = Float.parseFloat(strY6) / 100.0f;
                            } else {
                                toYValue = Float.parseFloat(strVal4);
                            }
                        }
                    }
                    anim = new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
                } else {
                    throw new RuntimeException("Unknown animation name: " + parser.getName());
                }
                if (anim != null) {
                    anim.setDuration(durationMillis);
                    if (!TextUtils.isEmpty(strInterpolator)) {
                        if (strInterpolator.contains("accelerate_decelerate_interpolator")) {
                            anim.setInterpolator(new AccelerateDecelerateInterpolator());
                        } else if (strInterpolator.contains("accelerate_interpolator")) {
                            anim.setInterpolator(new AccelerateInterpolator());
                        } else if (strInterpolator.contains("anticipate_interpolator")) {
                            anim.setInterpolator(new AnticipateInterpolator());
                        } else if (strInterpolator.contains("anticipate_overshoot_interpolator")) {
                            anim.setInterpolator(new AnticipateOvershootInterpolator());
                        } else if (strInterpolator.contains("bounce_interpolator")) {
                            anim.setInterpolator(new BounceInterpolator());
                        } else if (strInterpolator.contains("cycle_interpolator")) {
                            anim.setInterpolator(new CycleInterpolator(2.0f));
                        } else if (strInterpolator.contains("decelerate_interpolator")) {
                            anim.setInterpolator(new DecelerateInterpolator());
                        } else if (strInterpolator.contains("linear_interpolator")) {
                            anim.setInterpolator(new LinearInterpolator());
                        } else if (strInterpolator.contains("overshoot_interpolator")) {
                            anim.setInterpolator(new OvershootInterpolator());
                        }
                    }
                    if (parent != null) {
                        parent.addAnimation(anim);
                    }
                }
            }
        }
        return anim;
    }
}
