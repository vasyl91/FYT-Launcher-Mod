package org.apache.xmlbeans.impl.values;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.codehaus.stax2.validation.XMLValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class NamespaceContext implements PrefixResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAP = 3;
    private static final int RESOLVER = 5;
    private static final int START_ELEMENT = 4;
    private static final int TYPE_STORE = 1;
    private static final int XML_OBJECT = 2;
    private static ThreadLocal tl_namespaceContextStack = new ThreadLocal();
    private int _code = 3;
    private Object _obj;

    public NamespaceContext(Map map) {
        this._obj = map;
    }

    public NamespaceContext(TypeStore typeStore) {
        this._obj = typeStore;
    }

    public NamespaceContext(XmlObject xmlObject) {
        this._obj = xmlObject;
    }

    public NamespaceContext(StartElement startElement) {
        this._obj = startElement;
    }

    public NamespaceContext(PrefixResolver prefixResolver) {
        this._obj = prefixResolver;
    }

    private static final class NamespaceContextStack {
        NamespaceContext current;
        ArrayList stack;

        private NamespaceContextStack() {
            this.stack = new ArrayList();
        }

        final void push(NamespaceContext namespaceContext) {
            this.stack.add(this.current);
            this.current = namespaceContext;
        }

        final void pop() {
            ArrayList arrayList = this.stack;
            this.current = (NamespaceContext) arrayList.get(arrayList.size() - 1);
            ArrayList arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
    }

    public static void clearThreadLocals() {
        tl_namespaceContextStack.remove();
    }

    private static NamespaceContextStack getNamespaceContextStack() {
        NamespaceContextStack namespaceContextStack = (NamespaceContextStack) tl_namespaceContextStack.get();
        if (namespaceContextStack != null) {
            return namespaceContextStack;
        }
        NamespaceContextStack namespaceContextStack2 = new NamespaceContextStack();
        tl_namespaceContextStack.set(namespaceContextStack2);
        return namespaceContextStack2;
    }

    public static void push(NamespaceContext namespaceContext) {
        getNamespaceContextStack().push(namespaceContext);
    }

    public static void pop() {
        NamespaceContextStack namespaceContextStack = getNamespaceContextStack();
        namespaceContextStack.pop();
        if (namespaceContextStack.stack.size() == 0) {
            tl_namespaceContextStack.set(null);
        }
    }

    public static PrefixResolver getCurrent() {
        return getNamespaceContextStack().current;
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        if (str != null && str.equals(Sax2Dom.XML_PREFIX)) {
            return XMLValidationSchema.SCHEMA_ID_DTD;
        }
        int i = this._code;
        if (i != 1) {
            if (i == 2) {
                Object invocationHandler = this._obj;
                if (Proxy.isProxyClass(invocationHandler.getClass())) {
                    invocationHandler = Proxy.getInvocationHandler(invocationHandler);
                }
                if (invocationHandler instanceof TypeStoreUser) {
                    return ((TypeStoreUser) invocationHandler).get_store().getNamespaceForPrefix(str);
                }
                XmlCursor xmlCursorNewCursor = ((XmlObject) this._obj).newCursor();
                if (xmlCursorNewCursor != null) {
                    if (xmlCursorNewCursor.currentTokenType() == XmlCursor.TokenType.ATTR) {
                        xmlCursorNewCursor.toParent();
                    }
                    try {
                        return xmlCursorNewCursor.namespaceForPrefix(str);
                    } finally {
                        xmlCursorNewCursor.dispose();
                    }
                }
            } else if (i != 3) {
                if (i == 4) {
                    return ((StartElement) this._obj).getNamespaceUri(str);
                }
                if (i != 5) {
                    return null;
                }
                return ((PrefixResolver) this._obj).getNamespaceForPrefix(str);
            }
            return (String) ((Map) this._obj).get(str);
        }
        return ((TypeStore) this._obj).getNamespaceForPrefix(str);
    }
}
