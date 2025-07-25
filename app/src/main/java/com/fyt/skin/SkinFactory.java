package com.fyt.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SkinFactory implements LayoutInflater.Factory2, PropertyChangeListener {

    public final String[] a = {"android.widget.", "android.view.", "android.webkit."};
    SkinAttribute mSkinAttribute = new SkinAttribute();
    private static final ConcurrentHashMap<String, Constructor<? extends View>> sConstructorMap = new ConcurrentHashMap<String, Constructor<? extends View>>(); //= new HashMap<>();
    static final Class<?>[] mConstructorSignature = {Context.class, AttributeSet.class};
    private static final CopyOnWriteArrayList<String> sBadViewConstructorMap = new CopyOnWriteArrayList<>();

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = createViewFromTag(name, context, attrs);
        if (view == null) {
            view = createView(name, context, attrs);
        }
        if (view != null) {
            this.mSkinAttribute.loadView(view, attrs);
        }
        return view;
    }

    public SkinAttribute getSkinAttribute() {
        return this.mSkinAttribute;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.mSkinAttribute.applySkin();
    }

    /*private View createViewFromTag(String name, Context context, AttributeSet attrs) {
        if (-1 != name.indexOf(46)) {
            return null;
        }
        View view = null;
        for (int i = 0; i < this.a.length; i++) {
            view = createView(String.valueOf(this.a[i]) + name, context, attrs);
            if (view != null) {
                return view;
            }
        }
        return view;
    }*/

    private View createViewFromTag(String name, Context context, AttributeSet attrs) {
        if (-1 != name.indexOf('.')) {
            return null;
        }
        View view = null;
        for (int i = 0; i < a.length; i++) {
            view = createView(a[i] + name, context, attrs);
            if (view != null) {
                break;
            }
        }
        return view;
    }

    private View createView(String name, Context context, AttributeSet attrs) {
        Constructor<? extends View> constructor = findConstructor(context, name);
        try {
            return constructor.newInstance(context, attrs);
        } catch (Exception e) {
            return null;
        }
    }

    /*private Constructor<? extends View> findConstructor(Context context, String name) {
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(name).asSubclass(View.class).getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
                return constructor;
            } catch (Exception e) {
                e.printStackTrace();
                return constructor;
            }
        }
        return constructor;
    }*/

    private Constructor<? extends View> findConstructor(Context context, String name) {
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        if (null == constructor && !sBadViewConstructorMap.contains(name) && !name.contains("android.widget.ViewStub") && !name.contains("android.widget.View")) {
            try {
                Class<? extends View> clazz = context.getClassLoader().loadClass(name).asSubclass(View.class);
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } catch (Exception e) {
                sBadViewConstructorMap.add(name);
                e.printStackTrace();
            }
        }
        return constructor;
    }

    @Override
    public View onCreateView(String s, Context context, AttributeSet attributeSet) {
        return null;
    }

    public void clear() {
        if (mSkinAttribute != null) {
            mSkinAttribute.clear();
            mSkinAttribute = null;
        }
    }
}