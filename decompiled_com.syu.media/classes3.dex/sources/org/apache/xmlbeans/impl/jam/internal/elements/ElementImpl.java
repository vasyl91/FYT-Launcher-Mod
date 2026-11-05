package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.JElement;
import org.apache.xmlbeans.impl.jam.JPackage;
import org.apache.xmlbeans.impl.jam.JProperty;
import org.apache.xmlbeans.impl.jam.JSourcePosition;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
import org.apache.xmlbeans.impl.jam.mutable.MElement;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class ElementImpl implements Comparable, MElement {
    private ElementContext mContext;
    private ElementImpl mParent;
    protected String mSimpleName;
    public static final ElementImpl[] NO_NODE = new ElementImpl[0];
    public static final ClassImpl[] NO_CLASS = new ClassImpl[0];
    public static final FieldImpl[] NO_FIELD = new FieldImpl[0];
    public static final ConstructorImpl[] NO_CONSTRUCTOR = new ConstructorImpl[0];
    public static final MethodImpl[] NO_METHOD = new MethodImpl[0];
    public static final ParameterImpl[] NO_PARAMETER = new ParameterImpl[0];
    public static final JPackage[] NO_PACKAGE = new JPackage[0];
    public static final AnnotationImpl[] NO_ANNOTATION = new AnnotationImpl[0];
    public static final CommentImpl[] NO_COMMENT = new CommentImpl[0];
    public static final JProperty[] NO_PROPERTY = new JProperty[0];
    private MSourcePosition mPosition = null;
    private Object mArtifact = null;

    protected ElementImpl(ElementImpl elementImpl) {
        if (elementImpl == null) {
            throw new IllegalArgumentException("null ctx");
        }
        if (elementImpl == this) {
            throw new IllegalArgumentException("An element cannot be its own parent");
        }
        for (JElement parent = elementImpl.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this) {
                throw new IllegalArgumentException("cycle detected");
            }
        }
        this.mContext = elementImpl.getContext();
        this.mParent = elementImpl;
    }

    protected ElementImpl(ElementContext elementContext) {
        if (elementContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        this.mContext = elementContext;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public final JElement getParent() {
        return this.mParent;
    }

    public String getSimpleName() {
        return this.mSimpleName;
    }

    public JSourcePosition getSourcePosition() {
        return this.mPosition;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public Object getArtifact() {
        return this.mArtifact;
    }

    public void setSimpleName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null name");
        }
        this.mSimpleName = str.trim();
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public MSourcePosition createSourcePosition() {
        SourcePositionImpl sourcePositionImpl = new SourcePositionImpl();
        this.mPosition = sourcePositionImpl;
        return sourcePositionImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void removeSourcePosition() {
        this.mPosition = null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public MSourcePosition getMutableSourcePosition() {
        return this.mPosition;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void setArtifact(Object obj) {
        if (this.mArtifact != null) {
            throw new IllegalStateException("artifact already set");
        }
        this.mArtifact = obj;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public JamClassLoader getClassLoader() {
        return this.mContext.getClassLoader();
    }

    public static String defaultName(int i) {
        return "unnamed_" + i;
    }

    public boolean equals(Object obj) {
        String qualifiedName;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementImpl)) {
            return false;
        }
        ElementImpl elementImpl = (ElementImpl) obj;
        String qualifiedName2 = getQualifiedName();
        if (qualifiedName2 == null || (qualifiedName = elementImpl.getQualifiedName()) == null) {
            return false;
        }
        return qualifiedName2.equals(qualifiedName);
    }

    public int hashCode() {
        String qualifiedName = getQualifiedName();
        if (qualifiedName == null) {
            return 0;
        }
        return qualifiedName.hashCode();
    }

    public ElementContext getContext() {
        return this.mContext;
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String toString() {
        return getQualifiedName();
    }

    protected JamLogger getLogger() {
        return ((JamServiceContextImpl) this.mContext).getLogger();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof JElement) {
            return getQualifiedName().compareTo(((JElement) obj).getQualifiedName());
        }
        return -1;
    }
}
