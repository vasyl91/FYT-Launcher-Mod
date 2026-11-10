package org.apache.xmlbeans.impl.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.XPath;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Query {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String QUERY_DELEGATE_INTERFACE = "QUERY_DELEGATE_INTERFACE";
    private static String _delIntfName = null;
    public static String _useDelegateForXQuery = "use delegate for xquery";
    public static String _useXdkForXQuery = "use xdk for xquery";
    private static Method _xdkCompileQuery;
    private static Method _xqrl2002CompileQuery;
    private static Method _xqrlCompileQuery;
    private static HashMap _xdkQueryCache = new HashMap();
    private static boolean _xdkAvailable = true;
    private static HashMap _xqrlQueryCache = new HashMap();
    private static boolean _xqrlAvailable = true;
    private static HashMap _xqrl2002QueryCache = new HashMap();
    private static boolean _xqrl2002Available = true;

    abstract XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions);

    abstract XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions);

    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DefaultClassLoaderResourceLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.QueryDelegate.QueryInterface")));
            _delIntfName = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (Exception unused) {
            _delIntfName = null;
        }
    }

    static XmlObject[] objectExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).objectExecute(cur, xmlOptions);
    }

    static XmlCursor cursorExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).cursorExecute(cur, xmlOptions);
    }

    public static synchronized Query getCompiledQuery(String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, Path.getCurrentNodeVar(xmlOptions), xmlOptions);
    }

    static synchronized Query getCompiledQuery(String str, String str2, XmlOptions xmlOptions) {
        Integer num;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (xmlOptionsMaskNull.hasOption(Path._forceXqrl2002ForXpathXQuery)) {
            Query query = (Query) _xqrl2002QueryCache.get(str);
            if (query != null) {
                return query;
            }
            Query xqrl2002CompiledQuery = getXqrl2002CompiledQuery(str, str2);
            if (xqrl2002CompiledQuery != null) {
                _xqrl2002QueryCache.put(str, xqrl2002CompiledQuery);
                return xqrl2002CompiledQuery;
            }
            throw new RuntimeException("No 2002 query engine found.");
        }
        HashMap map = new HashMap();
        int iIntValue = 0;
        try {
            XPath.compileXPath(str, str2, map);
            if (map.get(XPath._NS_BOUNDARY) != null) {
                num = (Integer) map.get(XPath._NS_BOUNDARY);
                iIntValue = num.intValue();
            }
        } catch (XPath.XPathCompileException unused) {
            if (map.get(XPath._NS_BOUNDARY) != null) {
                num = (Integer) map.get(XPath._NS_BOUNDARY);
                iIntValue = num.intValue();
            }
        } catch (Throwable th) {
            if (map.get(XPath._NS_BOUNDARY) != null) {
                ((Integer) map.get(XPath._NS_BOUNDARY)).intValue();
            }
            throw th;
        }
        if (xmlOptionsMaskNull.hasOption(_useXdkForXQuery)) {
            Query query2 = (Query) _xdkQueryCache.get(str);
            if (query2 != null) {
                return query2;
            }
            Query queryCreateXdkCompiledQuery = createXdkCompiledQuery(str, str2);
            if (queryCreateXdkCompiledQuery != null) {
                _xdkQueryCache.put(str, queryCreateXdkCompiledQuery);
                return queryCreateXdkCompiledQuery;
            }
        }
        if (!xmlOptionsMaskNull.hasOption(_useDelegateForXQuery)) {
            Query query3 = (Query) _xqrlQueryCache.get(str);
            if (query3 != null) {
                return query3;
            }
            Query queryCreateXqrlCompiledQuery = createXqrlCompiledQuery(str, str2);
            if (queryCreateXqrlCompiledQuery != null) {
                _xqrlQueryCache.put(str, queryCreateXqrlCompiledQuery);
                return queryCreateXqrlCompiledQuery;
            }
        }
        Query queryCreateDelegateCompiledQuery = DelegateQueryImpl.createDelegateCompiledQuery(xmlOptionsMaskNull.hasOption(QUERY_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(QUERY_DELEGATE_INTERFACE) : _delIntfName, str, str2, iIntValue, xmlOptionsMaskNull);
        if (queryCreateDelegateCompiledQuery != null) {
            return queryCreateDelegateCompiledQuery;
        }
        throw new RuntimeException("No query engine found");
    }

    public static synchronized String compileQuery(String str, XmlOptions xmlOptions) {
        getCompiledQuery(str, xmlOptions);
        return str;
    }

    private static Query createXdkCompiledQuery(String str, String str2) {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompileQuery == null) {
            try {
                _xdkCompileQuery = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl").getDeclaredMethod("compileQuery", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = $assertionsDisabled;
                return null;
            } catch (Exception e) {
                _xdkAvailable = $assertionsDisabled;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xdkCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Query createXqrlCompiledQuery(String str, String str2) {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompileQuery == null) {
            try {
                _xqrlCompileQuery = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl").getDeclaredMethod("compileQuery", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = $assertionsDisabled;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = $assertionsDisabled;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrlCompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Query getXqrl2002CompiledQuery(String str, String str2) {
        if (_xqrl2002Available && _xqrl2002CompileQuery == null) {
            try {
                _xqrl2002CompileQuery = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl").getDeclaredMethod("compileQuery", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = $assertionsDisabled;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = $assertionsDisabled;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Query) _xqrl2002CompileQuery.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static final class DelegateQueryImpl extends Query {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private QueryDelegate.QueryInterface _xqueryImpl;

        private DelegateQueryImpl(QueryDelegate.QueryInterface queryInterface) {
            this._xqueryImpl = queryInterface;
        }

        static Query createDelegateCompiledQuery(String str, String str2, String str3, int i, XmlOptions xmlOptions) {
            QueryDelegate.QueryInterface queryInterfaceCreateInstance = QueryDelegate.createInstance(str, str2, str3, i, xmlOptions);
            if (queryInterfaceCreateInstance == null) {
                return null;
            }
            return new DelegateQueryImpl(queryInterfaceCreateInstance);
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).objectExecute();
        }

        @Override // org.apache.xmlbeans.impl.store.Query
        XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions) {
            return new DelegateQueryEngine(this._xqueryImpl, cur, xmlOptions).cursorExecute();
        }

        private static class DelegateQueryEngine {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private Cur _cur;
            private QueryDelegate.QueryInterface _engine;
            private XmlOptions _options;
            private long _version;

            public DelegateQueryEngine(QueryDelegate.QueryInterface queryInterface, Cur cur, XmlOptions xmlOptions) {
                this._engine = queryInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
                this._options = xmlOptions;
            }

            public XmlObject[] objectExecute() {
                Cur curLoadNode;
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List listExecQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get("XQUERY_VARIABLE_MAP"));
                XmlObject[] xmlObjectArr = new XmlObject[listExecQuery.size()];
                for (int i = 0; i < listExecQuery.size(); i++) {
                    Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                    locale.enter();
                    Object obj = listExecQuery.get(i);
                    try {
                        try {
                            if (!(obj instanceof Node)) {
                                curLoadNode = locale.load("<xml-fragment/>").tempCur();
                                curLoadNode.setValue(obj.toString());
                                Locale.autoTypeDocument(curLoadNode, getType(obj), null);
                                xmlObjectArr[i] = curLoadNode.getObject();
                            } else {
                                curLoadNode = loadNode(locale, (Node) obj);
                            }
                            xmlObjectArr[i] = curLoadNode.getObject();
                            locale.exit();
                            curLoadNode.release();
                        } catch (XmlException e) {
                            throw new RuntimeException((Throwable) e);
                        }
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                release();
                this._engine = null;
                return xmlObjectArr;
            }

            private SchemaType getType(Object obj) {
                if (obj instanceof Integer) {
                    return XmlInteger.type;
                }
                if (obj instanceof Double) {
                    return XmlDouble.type;
                }
                if (obj instanceof Long) {
                    return XmlLong.type;
                }
                if (obj instanceof Float) {
                    return XmlFloat.type;
                }
                if (obj instanceof BigDecimal) {
                    return XmlDecimal.type;
                }
                if (obj instanceof Boolean) {
                    return XmlBoolean.type;
                }
                if (obj instanceof String) {
                    return XmlString.type;
                }
                if (obj instanceof Date) {
                    return XmlDate.type;
                }
                return XmlAnySimpleType.type;
            }

            public XmlCursor cursorExecute() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur._locale.version();
                }
                List listExecQuery = this._engine.execQuery(this._cur.getDom(), (Map) XmlOptions.maskNull(this._options).get("XQUERY_VARIABLE_MAP"));
                Cursor cursor = null;
                this._engine = null;
                Locale locale = Locale.getLocale(this._cur._locale._schemaTypeLoader, this._options);
                locale.enter();
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                for (int i = 0; i < listExecQuery.size(); i++) {
                    try {
                        loadNodeHelper(locale, (Node) listExecQuery.get(i), curLoadContext);
                    } catch (Exception unused) {
                        locale.exit();
                    } catch (Throwable th) {
                        locale.exit();
                        throw th;
                    }
                }
                Cur curFinish = curLoadContext.finish();
                Locale.associateSourceName(curFinish, this._options);
                Locale.autoTypeDocument(curFinish, null, this._options);
                Cursor cursor2 = new Cursor(curFinish);
                locale.exit();
                cursor = cursor2;
                release();
                return cursor;
            }

            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
            /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlRuntimeException */
            private Cur loadNode(Locale locale, Node node) throws XmlRuntimeException, XmlException {
                Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
                try {
                    loadNodeHelper(locale, node, curLoadContext);
                    Cur curFinish = curLoadContext.finish();
                    Locale.associateSourceName(curFinish, this._options);
                    Locale.autoTypeDocument(curFinish, null, this._options);
                    return curFinish;
                } catch (Exception e) {
                    throw new XmlRuntimeException(e.getMessage(), e);
                }
            }

            private void loadNodeHelper(Locale locale, Node node, Locale.LoadContext loadContext) {
                if (node.getNodeType() == 2) {
                    loadContext.attr(new QName(node.getNamespaceURI(), node.getLocalName(), node.getPrefix()), node.getNodeValue());
                } else {
                    locale.loadNode(node, loadContext);
                }
            }
        }
    }
}
