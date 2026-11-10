package org.apache.xmlbeans.impl.store;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.XPath;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Path {
    public static final String PATH_DELEGATE_INTERFACE = "PATH_DELEGATE_INTERFACE";
    private static final int USE_DELEGATE = 4;
    private static final int USE_XBEAN = 1;
    private static final int USE_XDK = 16;
    private static final int USE_XQRL = 2;
    private static final int USE_XQRL2002 = 8;
    private static final String _delIntfName;
    public static String _forceXqrl2002ForXpathXQuery = "use xqrl-2002 for xpath";
    public static String _useDelegateForXpath = "use delegate for xpath";
    public static String _useXbeanForXpath = "use xbean for xpath";
    public static String _useXdkForXpath = "use xdk for xpath";
    public static String _useXqrlForXpath = "use xqrl for xpath";
    private static Method _xdkCompilePath;
    private static Method _xqrl2002CompilePath;
    private static Method _xqrlCompilePath;
    protected final String _pathKey;
    private static Map _xbeanPathCache = new WeakHashMap();
    private static Map _xdkPathCache = new WeakHashMap();
    private static Map _xqrlPathCache = new WeakHashMap();
    private static Map _xqrl2002PathCache = new WeakHashMap();
    private static boolean _xdkAvailable = true;
    private static boolean _xqrlAvailable = true;
    private static boolean _xqrl2002Available = true;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    interface PathEngine {
        boolean next(Cur cur);

        void release();
    }

    abstract PathEngine execute(Cur cur, XmlOptions xmlOptions);

    static {
        InputStream resourceAsStream = new DefaultClassLoaderResourceLoader().getResourceAsStream("META-INF/services/org.apache.xmlbeans.impl.store.PathDelegate.SelectPathInterface");
        String strTrim = null;
        if (resourceAsStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
                strTrim = bufferedReader.readLine().trim();
                bufferedReader.close();
            } catch (Exception unused) {
            }
        }
        _delIntfName = strTrim;
    }

    Path(String str) {
        this._pathKey = str;
    }

    static String getCurrentNodeVar(XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (!xmlOptionsMaskNull.hasOption("XQUERY_CURRENT_NODE_VAR")) {
            return "this";
        }
        String str = (String) xmlOptionsMaskNull.get("XQUERY_CURRENT_NODE_VAR");
        if (str.startsWith("$")) {
            throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
        }
        return str;
    }

    public static Path getCompiledPath(String str, XmlOptions xmlOptions) {
        int i;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        if (xmlOptionsMaskNull.hasOption(_useDelegateForXpath)) {
            i = 4;
        } else if (xmlOptionsMaskNull.hasOption(_useXqrlForXpath)) {
            i = 2;
        } else if (xmlOptionsMaskNull.hasOption(_useXdkForXpath)) {
            i = 16;
        } else if (xmlOptionsMaskNull.hasOption(_useXbeanForXpath)) {
            i = 1;
        } else {
            i = xmlOptionsMaskNull.hasOption(_forceXqrl2002ForXpathXQuery) ? 8 : 23;
        }
        return getCompiledPath(str, i, getCurrentNodeVar(xmlOptionsMaskNull), xmlOptionsMaskNull.hasOption(PATH_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(PATH_DELEGATE_INTERFACE) : _delIntfName);
    }

    static Path getCompiledPath(String str, int i, String str2, String str3) {
        WeakReference weakReference;
        int i2 = i & 4;
        HashMap map = i2 != 0 ? new HashMap() : null;
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.readLock().lock();
        int i3 = i & 1;
        if (i3 != 0) {
            try {
                weakReference = (WeakReference) _xbeanPathCache.get(str);
            } catch (Throwable th) {
                lock.readLock().unlock();
                throw th;
            }
        } else {
            weakReference = null;
        }
        if (weakReference == null && (i & 2) != 0) {
            weakReference = (WeakReference) _xqrlPathCache.get(str);
        }
        if (weakReference == null && (i & 16) != 0) {
            weakReference = (WeakReference) _xdkPathCache.get(str);
        }
        if (weakReference == null && (i & 8) != 0) {
            weakReference = (WeakReference) _xqrl2002PathCache.get(str);
        }
        Path compiledPathXbean = weakReference != null ? (Path) weakReference.get() : null;
        if (compiledPathXbean != null) {
            reentrantReadWriteLock.readLock().unlock();
            return compiledPathXbean;
        }
        reentrantReadWriteLock.readLock().unlock();
        reentrantReadWriteLock.writeLock().lock();
        if (i3 != 0) {
            try {
                WeakReference weakReference2 = (WeakReference) _xbeanPathCache.get(str);
                if (weakReference2 != null) {
                    compiledPathXbean = (Path) weakReference2.get();
                }
                if (compiledPathXbean == null) {
                    compiledPathXbean = getCompiledPathXbean(str, str2, map);
                }
            } catch (Throwable th2) {
                lock.writeLock().unlock();
                throw th2;
            }
        }
        if (compiledPathXbean == null && (i & 2) != 0) {
            WeakReference weakReference3 = (WeakReference) _xqrlPathCache.get(str);
            if (weakReference3 != null) {
                compiledPathXbean = (Path) weakReference3.get();
            }
            if (compiledPathXbean == null) {
                compiledPathXbean = getCompiledPathXqrl(str, str2);
            }
        }
        if (compiledPathXbean == null && (i & 16) != 0) {
            WeakReference weakReference4 = (WeakReference) _xdkPathCache.get(str);
            if (weakReference4 != null) {
                compiledPathXbean = (Path) weakReference4.get();
            }
            if (compiledPathXbean == null) {
                compiledPathXbean = getCompiledPathXdk(str, str2);
            }
        }
        if (compiledPathXbean == null && i2 != 0) {
            compiledPathXbean = getCompiledPathDelegate(str, str2, map, str3);
        }
        if (compiledPathXbean == null && (i & 8) != 0) {
            WeakReference weakReference5 = (WeakReference) _xqrl2002PathCache.get(str);
            if (weakReference5 != null) {
                compiledPathXbean = (Path) weakReference5.get();
            }
            if (compiledPathXbean == null) {
                compiledPathXbean = getCompiledPathXqrl2002(str, str2);
            }
        }
        if (compiledPathXbean != null) {
            reentrantReadWriteLock.writeLock().unlock();
            return compiledPathXbean;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (i3 != 0) {
            stringBuffer.append(" Trying XBeans path engine...");
        }
        if ((i & 2) != 0) {
            stringBuffer.append(" Trying XQRL...");
        }
        if ((i & 16) != 0) {
            stringBuffer.append(" Trying XDK...");
        }
        if (i2 != 0) {
            stringBuffer.append(" Trying delegated path engine...");
        }
        if ((i & 8) != 0) {
            stringBuffer.append(" Trying XQRL2002...");
        }
        throw new RuntimeException(stringBuffer.toString() + " FAILED on " + str);
    }

    private static Path getCompiledPathXdk(String str, String str2) {
        Path pathCreateXdkCompiledPath = createXdkCompiledPath(str, str2);
        if (pathCreateXdkCompiledPath != null) {
            _xdkPathCache.put(pathCreateXdkCompiledPath._pathKey, new WeakReference(pathCreateXdkCompiledPath));
        }
        return pathCreateXdkCompiledPath;
    }

    private static Path getCompiledPathXqrl(String str, String str2) {
        Path pathCreateXqrlCompiledPath = createXqrlCompiledPath(str, str2);
        if (pathCreateXqrlCompiledPath != null) {
            _xqrlPathCache.put(pathCreateXqrlCompiledPath._pathKey, new WeakReference(pathCreateXqrlCompiledPath));
        }
        return pathCreateXqrlCompiledPath;
    }

    private static Path getCompiledPathXqrl2002(String str, String str2) {
        Path pathCreateXqrl2002CompiledPath = createXqrl2002CompiledPath(str, str2);
        if (pathCreateXqrl2002CompiledPath != null) {
            _xqrl2002PathCache.put(pathCreateXqrl2002CompiledPath._pathKey, new WeakReference(pathCreateXqrl2002CompiledPath));
        }
        return pathCreateXqrl2002CompiledPath;
    }

    private static Path getCompiledPathXbean(String str, String str2, Map map) {
        Path pathCreate = XbeanPath.create(str, str2, map);
        if (pathCreate != null) {
            _xbeanPathCache.put(pathCreate._pathKey, new WeakReference(pathCreate));
        }
        return pathCreate;
    }

    private static Path getCompiledPathDelegate(String str, String str2, Map map, String str3) {
        if (map == null) {
            map = new HashMap();
        }
        try {
            XPath.compileXPath(str, str2, map);
        } catch (XPath.XPathCompileException unused) {
        }
        int iIntValue = map.get(XPath._NS_BOUNDARY) == null ? 0 : ((Integer) map.get(XPath._NS_BOUNDARY)).intValue();
        map.remove(XPath._NS_BOUNDARY);
        return DelegatePathImpl.create(str3, str.substring(iIntValue), str2, map);
    }

    public static String compilePath(String str, XmlOptions xmlOptions) {
        return getCompiledPath(str, xmlOptions)._pathKey;
    }

    private static final class XbeanPath extends Path {
        private final XPath _compiledPath;
        private final String _currentVar;
        public Map namespaces;

        static Path create(String str, String str2, Map map) {
            try {
                return new XbeanPath(str, str2, XPath.compileXPath(str, str2, map));
            } catch (XPath.XPathCompileException unused) {
                return null;
            }
        }

        private XbeanPath(String str, String str2, XPath xPath) {
            super(str);
            this._currentVar = str2;
            this._compiledPath = xPath;
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            String str = xmlOptionsMaskNull.hasOption(Path.PATH_DELEGATE_INTERFACE) ? (String) xmlOptionsMaskNull.get(Path.PATH_DELEGATE_INTERFACE) : Path._delIntfName;
            if (!cur.isContainer() || this._compiledPath.sawDeepDot()) {
                return getCompiledPath(this._pathKey, 22, this._currentVar, str).execute(cur, xmlOptionsMaskNull);
            }
            return new XbeanPathEngine(this._compiledPath, cur);
        }
    }

    private static Path createXdkCompiledPath(String str, String str2) {
        if (!_xdkAvailable) {
            return null;
        }
        if (_xdkCompilePath == null) {
            try {
                _xdkCompilePath = Class.forName("org.apache.xmlbeans.impl.store.OXQXBXqrlImpl").getDeclaredMethod("compilePath", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xdkAvailable = false;
                return null;
            } catch (Exception e) {
                _xdkAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xdkCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrlCompiledPath(String str, String str2) {
        if (!_xqrlAvailable) {
            return null;
        }
        if (_xqrlCompilePath == null) {
            try {
                _xqrlCompilePath = Class.forName("org.apache.xmlbeans.impl.store.XqrlImpl").getDeclaredMethod("compilePath", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xqrlAvailable = false;
                return null;
            } catch (Exception e) {
                _xqrlAvailable = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrlCompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static Path createXqrl2002CompiledPath(String str, String str2) {
        if (!_xqrl2002Available) {
            return null;
        }
        if (_xqrl2002CompilePath == null) {
            try {
                _xqrl2002CompilePath = Class.forName("org.apache.xmlbeans.impl.store.Xqrl2002Impl").getDeclaredMethod("compilePath", String.class, String.class, Boolean.class);
            } catch (ClassNotFoundException unused) {
                _xqrl2002Available = false;
                return null;
            } catch (Exception e) {
                _xqrl2002Available = false;
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        try {
            return (Path) _xqrl2002CompilePath.invoke(null, str, str2, new Boolean(true));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }

    private static final class XbeanPathEngine extends XPath.ExecutionContext implements PathEngine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur _cur;
        private final long _version;

        XbeanPathEngine(XPath xPath, Cur cur) {
            this._version = cur._locale.version();
            Cur curWeakCur = cur.weakCur(this);
            this._cur = curWeakCur;
            curWeakCur.push();
            init(xPath);
            int iStart = start();
            if ((iStart & 1) != 0) {
                cur.addToSelection();
            }
            doAttrs(iStart, cur);
            if ((iStart & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                release();
            }
        }

        private void advance(Cur cur) {
            if (this._cur.isFinish()) {
                if (this._cur.isAtEndOfLastPush()) {
                    release();
                    return;
                } else {
                    end();
                    this._cur.next();
                    return;
                }
            }
            if (this._cur.isElem()) {
                int iElement = element(this._cur.getName());
                if ((iElement & 1) != 0) {
                    cur.addToSelection(this._cur);
                }
                doAttrs(iElement, cur);
                if ((iElement & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
                    end();
                    this._cur.skip();
                    return;
                }
                return;
            }
            do {
                this._cur.next();
            } while (!this._cur.isContainerOrFinish());
        }

        private void doAttrs(int i, Cur cur) {
            if ((i & 4) == 0 || !this._cur.toFirstAttr()) {
                return;
            }
            do {
                if (attr(this._cur.getName())) {
                    cur.addToSelection(this._cur);
                }
            } while (this._cur.toNextAttr());
            this._cur.toParent();
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public boolean next(Cur cur) {
            Cur cur2 = this._cur;
            if (cur2 != null && this._version != cur2._locale.version()) {
                throw new ConcurrentModificationException("Document changed during select");
            }
            int iSelectionCount = cur.selectionCount();
            while (this._cur != null) {
                advance(cur);
                if (iSelectionCount != cur.selectionCount()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
        public void release() {
            Cur cur = this._cur;
            if (cur != null) {
                cur.release();
                this._cur = null;
            }
        }
    }

    private static final class DelegatePathImpl extends Path {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private PathDelegate.SelectPathInterface _xpathImpl;

        static Path create(String str, String str2, String str3, Map map) {
            PathDelegate.SelectPathInterface selectPathInterfaceCreateInstance = PathDelegate.createInstance(str, str2, str3, map);
            if (selectPathInterfaceCreateInstance == null) {
                return null;
            }
            return new DelegatePathImpl(selectPathInterfaceCreateInstance, str2);
        }

        private DelegatePathImpl(PathDelegate.SelectPathInterface selectPathInterface, String str) {
            super(str);
            this._xpathImpl = selectPathInterface;
        }

        @Override // org.apache.xmlbeans.impl.store.Path
        protected PathEngine execute(Cur cur, XmlOptions xmlOptions) {
            return new DelegatePathEngine(this._xpathImpl, cur);
        }

        private static class DelegatePathEngine extends XPath.ExecutionContext implements PathEngine {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private Cur _cur;
            private PathDelegate.SelectPathInterface _engine;
            private long _version;
            private final DateFormat xmlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            private boolean _firstCall = true;

            DelegatePathEngine(PathDelegate.SelectPathInterface selectPathInterface, Cur cur) {
                this._engine = selectPathInterface;
                this._version = cur._locale.version();
                this._cur = cur.weakCur(this);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public boolean next(Cur cur) throws XmlException {
                Cur curTempCur;
                String string;
                if (!this._firstCall) {
                    return false;
                }
                this._firstCall = false;
                Cur cur2 = this._cur;
                if (cur2 != null && this._version != cur2._locale.version()) {
                    throw new ConcurrentModificationException("Document changed during select");
                }
                List listSelectPath = this._engine.selectPath(this._cur.getDom());
                for (int i = 0; i < listSelectPath.size(); i++) {
                    Object obj = listSelectPath.get(i);
                    if (!(obj instanceof Node)) {
                        Object obj2 = listSelectPath.get(i);
                        if (obj2 instanceof Date) {
                            string = this.xmlDateFormat.format((Date) obj2);
                        } else if (obj2 instanceof BigDecimal) {
                            string = ((BigDecimal) obj2).toPlainString();
                        } else {
                            string = obj2.toString();
                        }
                        try {
                            curTempCur = cur._locale.load("<xml-fragment/>").tempCur();
                            curTempCur.setValue(string);
                            Locale.autoTypeDocument(curTempCur, getType(obj), null);
                            curTempCur.next();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        curTempCur = ((DomImpl.Dom) obj).tempCur();
                    }
                    cur.addToSelection(curTempCur);
                    curTempCur.release();
                }
                release();
                this._engine = null;
                return true;
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

            @Override // org.apache.xmlbeans.impl.store.Path.PathEngine
            public void release() {
                Cur cur = this._cur;
                if (cur != null) {
                    cur.release();
                    this._cur = null;
                }
            }
        }
    }
}
