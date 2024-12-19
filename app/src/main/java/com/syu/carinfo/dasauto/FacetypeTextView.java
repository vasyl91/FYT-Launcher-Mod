package com.syu.carinfo.dasauto;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FacetypeTextView extends TextView {
    public FacetypeTextView(Context context) {
        this(context, null);
    }

    public FacetypeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FacetypeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.attr_facetype);
        String fontType = typedArray.getString(0);
        if (!TextUtils.isEmpty(fontType)) {
            if (fontType.equals("bold")) {
                Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/bold.otf");
                setTypeface(typeface);
            } else if (fontType.equals("normal")) {
                Typeface typeface2 = Typeface.createFromAsset(getContext().getAssets(), "fonts/normal.otf");
                setTypeface(typeface2);
            } else {
                Typeface typeface3 = Typeface.createFromAsset(getContext().getAssets(), "fonts/small.otf");
                setTypeface(typeface3);
            }
        }
    }
}
