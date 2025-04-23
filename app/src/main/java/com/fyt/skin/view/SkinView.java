package com.fyt.skin.view;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.Utilities;
import com.fyt.skin.SkinManager;
import com.fyt.skin.SkinResources;
import com.fyt.skin.SkinUtils;

import java.util.List;

public class SkinView {
    List<SkinAttrParms> parms;
    View view;

    public List<SkinAttrParms> getParms() {
        return this.parms;
    }

    public SkinView(View view, List<SkinAttrParms> parms) {
        this.view = view;
        this.parms = parms;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void applySkin() {
        SkinResources skinResources = SkinUtils.getSkinResources();
        Resources res = LauncherApplication.sApp.getResources();
        for (SkinAttrParms parms : this.parms) {
            Drawable left = null;
            Drawable top = null;
            Drawable right = null;
            Drawable bottom = null;
            String attrName = parms.getAttrName();
            switch (attrName.hashCode()) {
                case -2056911842:
                    if (attrName.equals("drawableRight")) {
                        right = skinResources.getDrawable(parms.getId());
                        break;
                    }
                    break;
                case -1332194002:
                    if (attrName.equals("background")) {
                        Object background = skinResources.getBackground(parms.getId());
                        if (background instanceof Integer) {
                            this.view.setBackgroundColor(((Integer) background).intValue());
                            break;
                        } else {
                            this.view.setBackground((Drawable) background);
                            break;
                        }
                    }
                    break;
                case -1063571914:
                    if (attrName.equals("textColor")) {
                        ((TextView) this.view).setTextColor(skinResources.getColorStateList(parms.getId()));
                        break;
                    }
                    break;
                case 114148:
                    if (attrName.equals("src")) {
                        Object src = skinResources.getBackground(parms.getId());
                        if (src instanceof Integer) {
                            ((ImageView) this.view).setImageDrawable(new ColorDrawable(((Integer) src).intValue()));
                            break;
                        } else {
                            ((ImageView) this.view).setImageDrawable((Drawable) src);
                            break;
                        }
                    }
                    break;
                case 208115817:
                    if (attrName.equals("drawableBottom")) {
                        bottom = skinResources.getDrawable(parms.getId());
                        break;
                    }
                    break;
                case 574397399:
                    if (attrName.equals("drawableTop")) {
                        Bitmap bitmap = null;
                        if (parms.getId() != 0) {
                            top = new BitmapDrawable(res, Utilities.createIconBitmap_enlarge(skinResources.getDrawable(parms.getId())));
                            break;
                        } else {
                            PackageManager pm = SkinManager.getContext().getPackageManager();
                            try {
                                String packageName = (String) this.view.getTag(R.id.str_tag);
                                if (packageName != null) {
                                    bitmap = Utilities.createIconBitmap_minify(pm.getApplicationIcon(packageName));
                                }
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                            }
                            top = new BitmapDrawable(res, bitmap);
                            break;
                        }
                    }
                    break;
                case 626202053:
                    if (attrName.equals("drawableLeft")) {
                        left = skinResources.getDrawable(parms.getId());
                        break;
                    }
                    break;
            }
            if (left != null || right != null || top != null || bottom != null) {
                ((TextView) this.view).setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
            }
        }
    }
}
