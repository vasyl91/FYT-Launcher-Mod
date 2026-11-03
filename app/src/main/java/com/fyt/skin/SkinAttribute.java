package com.fyt.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.android.launcher66.R;
import com.fyt.skin.util.SkinThemeUitls;
import com.fyt.skin.view.SkinAttrParms;
import com.fyt.skin.view.SkinView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SkinAttribute {
    private static final String TAG = "SkinAttribute";
    private static final Set<String> WARNED = new HashSet<>();
    public static final List<String> list = new ArrayList<>();
    private final ArrayList<SkinView> skinViews = new ArrayList<>();

    static {
        list.add("background");
        list.add("src");
        list.add("textColor");
        list.add("drawableLeft");
        list.add("drawableTop");
        list.add("drawableRight");
        list.add("drawableBottom");
    }

    public ArrayList<SkinView> getSkinViews() {
        return this.skinViews;
    }

    private String ResToString(Context context, int resid) {
        return context.getString(resid);
    }

    /**
     * Collects the skinnable attributes of a freshly inflated view. Anything that is not a numeric
     * resource reference (a literal tag such as {@code boxFit}, a color, {@code @null}) is skipped:
     * a skin must never be able to abort the inflation of a layout.
     */
    public void loadView(View view, AttributeSet attrs) {
        ArrayList<SkinAttrParms> skinAttrParms = new ArrayList<>();
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attributeName = attrs.getAttributeName(i);
            try {
                String attributeValue = attrs.getAttributeValue(i);
                Integer ref = SkinAttrRef.resourceRef(attributeValue);
                if (ref == null) {
                    continue;
                }
                if (attributeName.equals("tag")) {
                    if (ResToString(view.getContext(), ref).equals(view.getContext().getString(R.string.skin_ruleless))) {
                        return;
                    }
                    continue;
                }
                if (!list.contains(attributeName)) {
                    continue;
                }
                int id;
                if (SkinAttrRef.isThemeRef(attributeValue)) {
                    id = SkinThemeUitls.getThemeResid(view.getContext(), new int[]{ref})[0];
                } else {
                    id = ref;
                }
                if (id != 0) {
                    view.getContext().getResources().getResourceEntryName(id);
                    skinAttrParms.add(new SkinAttrParms(attributeName, id));
                }
            } catch (RuntimeException e) {
                // NumberFormatException, Resources.NotFoundException: skip just this attribute.
                warnOnce(view, e);
            }
        }
        if (!skinAttrParms.isEmpty()) {
            SkinView skinView = new SkinView(view, skinAttrParms);
            skinView.applySkin();
            this.skinViews.add(skinView);
        }
    }

    /** One warning per view class and process: inflation is hot and attributes are many. */
    private static void warnOnce(View view, RuntimeException e) {
        String name = view.getClass().getName();
        synchronized (WARNED) {
            if (!WARNED.add(name)) {
                return;
            }
        }
        Log.w(TAG, "Skin attribute skipped on " + name + ": " + e);
    }

    public void loadView(View view, ArrayList<SkinAttrParms> attrParms) {
        if (!attrParms.isEmpty()) {
            SkinView skinView = new SkinView(view, attrParms);
            skinView.applySkin();
            this.skinViews.add(skinView);
        }
    }

    public void applySkin() {
        Iterator<SkinView> it = this.skinViews.iterator();
        while (it.hasNext()) {
            SkinView skinView = it.next();
            if (skinView.getView() == null) {
                it.remove();  
            } else {
                skinView.applySkin();
            }
        }
    }

    public void clear() {
        for (SkinView skinView : skinViews) {
            skinView.clear(); 
        }
        skinViews.clear();
    }
}