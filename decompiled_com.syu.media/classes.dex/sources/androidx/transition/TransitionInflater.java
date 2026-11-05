package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class TransitionInflater {
    private final Context mContext;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap<>();

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                Transition transitionCreateTransitionFromXml = createTransitionFromXml(xml, Xml.asAttributeSet(xml), null);
                xml.close();
                return transitionCreateTransitionFromXml;
            } catch (IOException e) {
                throw new InflateException(xml.getPositionDescription() + ": " + e.getMessage(), e);
            } catch (XmlPullParserException e2) {
                throw new InflateException(e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                TransitionManager transitionManagerCreateTransitionManagerFromXml = createTransitionManagerFromXml(xml, Xml.asAttributeSet(xml), viewGroup);
                xml.close();
                return transitionManagerCreateTransitionManagerFromXml;
            } catch (IOException e) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                inflateException.initCause(e);
                throw inflateException;
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private Transition createTransitionFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transitionSet;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet2 = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0: while (true) {
            transitionSet = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                    break loop0;
                }
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("fade".equals(name)) {
                        transitionSet = new Fade(this.mContext, attributeSet);
                    } else if ("changeBounds".equals(name)) {
                        transitionSet = new ChangeBounds(this.mContext, attributeSet);
                    } else if ("slide".equals(name)) {
                        transitionSet = new Slide(this.mContext, attributeSet);
                    } else if ("explode".equals(name)) {
                        transitionSet = new Explode(this.mContext, attributeSet);
                    } else if ("changeImageTransform".equals(name)) {
                        transitionSet = new ChangeImageTransform(this.mContext, attributeSet);
                    } else if ("changeTransform".equals(name)) {
                        transitionSet = new ChangeTransform(this.mContext, attributeSet);
                    } else if ("changeClipBounds".equals(name)) {
                        transitionSet = new ChangeClipBounds(this.mContext, attributeSet);
                    } else if ("autoTransition".equals(name)) {
                        transitionSet = new AutoTransition(this.mContext, attributeSet);
                    } else if ("changeScroll".equals(name)) {
                        transitionSet = new ChangeScroll(this.mContext, attributeSet);
                    } else if ("transitionSet".equals(name)) {
                        transitionSet = new TransitionSet(this.mContext, attributeSet);
                    } else if ("transition".equals(name)) {
                        transitionSet = (Transition) createCustom(attributeSet, Transition.class, "transition");
                    } else if ("targets".equals(name)) {
                        getTargetIds(xmlPullParser, attributeSet, transition);
                    } else if ("arcMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of arcMotion element");
                        }
                        transition.setPathMotion(new ArcMotion(this.mContext, attributeSet));
                    } else if ("pathMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of pathMotion element");
                        }
                        transition.setPathMotion((PathMotion) createCustom(attributeSet, PathMotion.class, "pathMotion"));
                    } else {
                        if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        }
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        transition.setPathMotion(new PatternPathMotion(this.mContext, attributeSet));
                    }
                    if (transitionSet == null) {
                        continue;
                    } else {
                        if (!xmlPullParser.isEmptyElementTag()) {
                            createTransitionFromXml(xmlPullParser, attributeSet, transitionSet);
                        }
                        if (transitionSet2 != null) {
                            break;
                        }
                        if (transition != null) {
                            throw new InflateException("Could not add transition to another transition.");
                        }
                    }
                }
            }
            transitionSet2.addTransition(transitionSet);
        }
        return transitionSet;
    }

    private Object createCustom(AttributeSet attributeSet, Class<?> cls, String str) {
        Object objNewInstance;
        Class<? extends U> clsAsSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            ArrayMap<String, Constructor<?>> arrayMap = CONSTRUCTORS;
            synchronized (arrayMap) {
                Constructor<?> constructor = arrayMap.get(attributeValue);
                if (constructor == null && (clsAsSubclass = Class.forName(attributeValue, false, this.mContext.getClassLoader()).asSubclass(cls)) != 0) {
                    constructor = clsAsSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                    constructor.setAccessible(true);
                    arrayMap.put(attributeValue, constructor);
                }
                objNewInstance = constructor.newInstance(this.mContext, attributeSet);
            }
            return objNewInstance;
        } catch (Exception e) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
        }
    }

    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_TARGET);
                    int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                    if (namedResourceId != 0) {
                        transition.addTarget(namedResourceId);
                    } else {
                        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                        if (namedResourceId2 != 0) {
                            transition.excludeTarget(namedResourceId2, true);
                        } else {
                            String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (namedString != null) {
                                transition.addTarget(namedString);
                            } else {
                                String namedString2 = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (namedString2 != null) {
                                    transition.excludeTarget(namedString2, true);
                                } else {
                                    String namedString3 = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (namedString3 != null) {
                                        try {
                                            transition.excludeTarget(Class.forName(namedString3), true);
                                        } catch (ClassNotFoundException e) {
                                            typedArrayObtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create " + namedString3, e);
                                        }
                                    } else {
                                        String namedString4 = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (namedString4 != null) {
                                            transition.addTarget(Class.forName(namedString4));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, ViewGroup viewGroup) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        TransitionManager transitionManager = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("transitionManager")) {
                    transitionManager = new TransitionManager();
                } else if (name.equals("transition") && transitionManager != null) {
                    loadTransition(attributeSet, xmlPullParser, viewGroup, transitionManager);
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
        return transitionManager;
    }

    private void loadTransition(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Transition transitionInflateTransition;
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_MANAGER);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene sceneForLayout = namedResourceId2 < 0 ? null : Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        int namedResourceId3 = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        Scene sceneForLayout2 = namedResourceId3 >= 0 ? Scene.getSceneForLayout(viewGroup, namedResourceId3, this.mContext) : null;
        if (namedResourceId >= 0 && (transitionInflateTransition = inflateTransition(namedResourceId)) != null) {
            if (sceneForLayout2 == null) {
                throw new RuntimeException("No toScene for transition ID " + namedResourceId);
            }
            if (sceneForLayout == null) {
                transitionManager.setTransition(sceneForLayout2, transitionInflateTransition);
            } else {
                transitionManager.setTransition(sceneForLayout, sceneForLayout2, transitionInflateTransition);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
