package org.apache.xmlbeans.impl.config;

import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class PrePostExtensionImpl implements PrePostExtension {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static JClass[] PARAMTYPES_PREPOST;
    private static final String[] PARAMTYPES_STRING = {"int", "org.apache.xmlbeans.XmlObject", "javax.xml.namespace.QName", "boolean", "int"};
    private static final String SIGNATURE;
    private JClass _delegateToClass;
    private String _delegateToClassName;
    private JMethod _postSet;
    private JMethod _preSet;
    private NameSet _xbeanSet;

    static {
        String str = "(";
        int i = 0;
        while (true) {
            String[] strArr = PARAMTYPES_STRING;
            if (i < strArr.length) {
                String str2 = strArr[i];
                if (i != 0) {
                    str = str + ", ";
                }
                str = str + str2;
                i++;
            } else {
                SIGNATURE = str + ")";
                return;
            }
        }
    }

    static PrePostExtensionImpl newInstance(JamClassLoader jamClassLoader, NameSet nameSet, Extensionconfig.PrePostSet prePostSet) {
        if (prePostSet == null) {
            return null;
        }
        PrePostExtensionImpl prePostExtensionImpl = new PrePostExtensionImpl();
        prePostExtensionImpl._xbeanSet = nameSet;
        String staticHandler = prePostSet.getStaticHandler();
        prePostExtensionImpl._delegateToClassName = staticHandler;
        JClass jClassValidateClass = InterfaceExtensionImpl.validateClass(jamClassLoader, staticHandler, prePostSet);
        prePostExtensionImpl._delegateToClass = jClassValidateClass;
        if (jClassValidateClass == null) {
            BindingConfigImpl.warning("Handler class '" + prePostSet.getStaticHandler() + "' not found on classpath, skip validation.", prePostSet);
            return prePostExtensionImpl;
        }
        if (prePostExtensionImpl.lookAfterPreAndPost(jamClassLoader, prePostSet)) {
            return prePostExtensionImpl;
        }
        return null;
    }

    private boolean lookAfterPreAndPost(JamClassLoader jamClassLoader, XmlObject xmlObject) {
        initParamPrePost(jamClassLoader);
        JMethod method = InterfaceExtensionImpl.getMethod(this._delegateToClass, "preSet", PARAMTYPES_PREPOST);
        this._preSet = method;
        if (method != null && !method.getReturnType().equals(jamClassLoader.loadClass("boolean"))) {
            BindingConfigImpl.warning("Method '" + this._delegateToClass.getSimpleName() + ".preSet" + SIGNATURE + "' should return boolean to be considered for a preSet handler.", xmlObject);
            this._preSet = null;
        }
        JMethod method2 = InterfaceExtensionImpl.getMethod(this._delegateToClass, "postSet", PARAMTYPES_PREPOST);
        this._postSet = method2;
        if (this._preSet != null || method2 != null) {
            return true;
        }
        StringBuilder sbAppend = new StringBuilder("prePostSet handler specified '").append(this._delegateToClass.getSimpleName()).append("' but no preSet");
        String str = SIGNATURE;
        BindingConfigImpl.error(sbAppend.append(str).append(" or postSet").append(str).append(" methods found.").toString(), xmlObject);
        return false;
    }

    private void initParamPrePost(JamClassLoader jamClassLoader) {
        if (PARAMTYPES_PREPOST != null) {
            return;
        }
        PARAMTYPES_PREPOST = new JClass[PARAMTYPES_STRING.length];
        int i = 0;
        while (true) {
            JClass[] jClassArr = PARAMTYPES_PREPOST;
            if (i >= jClassArr.length) {
                return;
            }
            jClassArr[i] = jamClassLoader.loadClass(PARAMTYPES_STRING[i]);
            if (PARAMTYPES_PREPOST[i] == null) {
                throw new IllegalStateException("JAM should have access to the following types " + SIGNATURE);
            }
            i++;
        }
    }

    public NameSet getNameSet() {
        return this._xbeanSet;
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    public boolean hasPreCall() {
        return this._preSet != null;
    }

    public boolean hasPostCall() {
        return this._postSet != null;
    }

    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public String getHandlerNameForJavaSource() {
        JClass jClass = this._delegateToClass;
        if (jClass == null) {
            return null;
        }
        return InterfaceExtensionImpl.emitType(jClass);
    }

    boolean hasNameSetIntersection(PrePostExtensionImpl prePostExtensionImpl) {
        return !NameSet.EMPTY.equals(this._xbeanSet.intersect(prePostExtensionImpl._xbeanSet));
    }
}
