package org.apache.xmlbeans.impl.jam.internal;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.internal.elements.ArrayClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.internal.elements.PackageImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.UnresolvedClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
import org.apache.xmlbeans.impl.jam.visitor.TraversingMVisitor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamClassLoaderImpl implements JamClassLoader {
    private JamClassBuilder mBuilder;
    private ElementContext mContext;
    private MVisitor mInitializer;
    private Map mName2Package = new HashMap();
    private Map mFd2ClassCache = new HashMap();
    private Stack mInitializeStack = new Stack();
    private boolean mAlreadyInitializing = false;

    public JamClassLoaderImpl(ElementContext elementContext, JamClassBuilder jamClassBuilder, MVisitor mVisitor) {
        this.mInitializer = null;
        if (jamClassBuilder == null) {
            throw new IllegalArgumentException("null builder");
        }
        if (elementContext == null) {
            throw new IllegalArgumentException("null builder");
        }
        this.mBuilder = jamClassBuilder;
        this.mInitializer = mVisitor != null ? new TraversingMVisitor(mVisitor) : null;
        this.mContext = elementContext;
        initCache();
    }

    @Override // org.apache.xmlbeans.impl.jam.JamClassLoader
    public final JClass loadClass(String str) {
        String strSubstring;
        String strSubstring2;
        String strTrim = str.trim();
        JClass jClassCacheGet = cacheGet(strTrim);
        if (jClassCacheGet != null) {
            return jClassCacheGet;
        }
        if (strTrim.indexOf(91) != -1) {
            String strNormalizeArrayName = ArrayClassImpl.normalizeArrayName(strTrim);
            JClass jClassCacheGet2 = cacheGet(strNormalizeArrayName);
            if (jClassCacheGet2 == null) {
                jClassCacheGet2 = ArrayClassImpl.createClassForFD(strNormalizeArrayName, this);
                cachePut(jClassCacheGet2, strNormalizeArrayName);
            }
            cachePut(jClassCacheGet2, strTrim);
            return jClassCacheGet2;
        }
        int iIndexOf = strTrim.indexOf(36);
        String strSubstring3 = "";
        if (iIndexOf != -1) {
            ((ClassImpl) loadClass(strTrim.substring(0, iIndexOf))).ensureLoaded();
            JClass jClassCacheGet3 = cacheGet(strTrim);
            int iLastIndexOf = strTrim.lastIndexOf(46);
            if (jClassCacheGet3 != null) {
                return jClassCacheGet3;
            }
            if (iLastIndexOf == -1) {
                strSubstring2 = strTrim;
            } else {
                strSubstring3 = strTrim.substring(0, iLastIndexOf);
                strSubstring2 = strTrim.substring(iLastIndexOf + 1);
            }
            UnresolvedClassImpl unresolvedClassImpl = new UnresolvedClassImpl(strSubstring3, strSubstring2, this.mContext);
            this.mContext.warning("failed to resolve class " + strTrim);
            cachePut(unresolvedClassImpl);
            return unresolvedClassImpl;
        }
        int iLastIndexOf2 = strTrim.lastIndexOf(46);
        if (iLastIndexOf2 == -1) {
            strSubstring = strTrim;
        } else {
            strSubstring3 = strTrim.substring(0, iLastIndexOf2);
            strSubstring = strTrim.substring(iLastIndexOf2 + 1);
        }
        MClass mClassBuild = this.mBuilder.build(strSubstring3, strSubstring);
        if (mClassBuild == null) {
            UnresolvedClassImpl unresolvedClassImpl2 = new UnresolvedClassImpl(strSubstring3, strSubstring, this.mContext);
            this.mContext.warning("failed to resolve class " + strTrim);
            cachePut(unresolvedClassImpl2);
            return unresolvedClassImpl2;
        }
        cachePut(mClassBuild);
        return mClassBuild;
    }

    @Override // org.apache.xmlbeans.impl.jam.JamClassLoader
    public JPackage getPackage(String str) {
        JPackage jPackage = (JPackage) this.mName2Package.get(str);
        if (jPackage != null) {
            return jPackage;
        }
        PackageImpl packageImpl = new PackageImpl(this.mContext, str);
        this.mName2Package.put(str, packageImpl);
        return packageImpl;
    }

    private void initCache() {
        PrimitiveClassImpl.mapNameToPrimitive(this.mContext, this.mFd2ClassCache);
        this.mFd2ClassCache.put("void", new VoidClassImpl(this.mContext));
    }

    private void cachePut(JClass jClass) {
        this.mFd2ClassCache.put(jClass.getFieldDescriptor().trim(), new WeakReference(jClass));
    }

    private void cachePut(JClass jClass, String str) {
        this.mFd2ClassCache.put(str, new WeakReference(jClass));
    }

    private JClass cacheGet(String str) {
        Object obj = this.mFd2ClassCache.get(str.trim());
        if (obj == null) {
            return null;
        }
        if (obj instanceof JClass) {
            return (JClass) obj;
        }
        if (obj instanceof WeakReference) {
            Object obj2 = ((WeakReference) obj).get();
            if (obj2 == null) {
                this.mFd2ClassCache.remove(str.trim());
                return null;
            }
            return (JClass) obj2;
        }
        throw new IllegalStateException();
    }

    public void initialize(ClassImpl classImpl) {
        MVisitor mVisitor = this.mInitializer;
        if (mVisitor != null) {
            if (this.mAlreadyInitializing) {
                this.mInitializeStack.push(classImpl);
                return;
            }
            classImpl.accept(mVisitor);
            while (!this.mInitializeStack.isEmpty()) {
                ((ClassImpl) this.mInitializeStack.pop()).accept(this.mInitializer);
            }
            this.mAlreadyInitializing = false;
        }
    }

    public Collection getResolvedClasses() {
        return Collections.unmodifiableCollection(this.mFd2ClassCache.values());
    }

    public void addToCache(JClass jClass) {
        cachePut((MClass) jClass);
    }
}
