package org.apache.xmlbeans.impl.schema;

import java.util.Collections;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.XPath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaIdentityConstraintImpl implements SchemaIdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private SchemaContainer _container;
    private volatile XPath[] _fieldPaths;
    private String[] _fields;
    private String _filename;
    private SchemaIdentityConstraint.Ref _key;
    private QName _name;
    private XmlObject _parse;
    private String _parseTNS;
    private String _selector;
    private volatile XPath _selectorPath;
    private int _type;
    private Object _userData;
    private Map _nsMap = Collections.EMPTY_MAP;
    private SchemaIdentityConstraint.Ref _selfref = new SchemaIdentityConstraint.Ref(this);

    public int getComponentType() {
        return 5;
    }

    public SchemaIdentityConstraintImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public String getSourceName() {
        return this._filename;
    }

    public String getSelector() {
        return this._selector;
    }

    public Object getSelectorPath() {
        XPath xPath = this._selectorPath;
        if (xPath != null) {
            return xPath;
        }
        try {
            buildPaths();
            return this._selectorPath;
        } catch (XPath.XPathCompileException unused) {
            return null;
        }
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public void setNSMap(Map map) {
        this._nsMap = map;
    }

    public Map getNSMap() {
        return Collections.unmodifiableMap(this._nsMap);
    }

    public void setSelector(String str) {
        this._selector = str;
    }

    public void setFields(String[] strArr) {
        this._fields = strArr;
    }

    public String[] getFields() {
        String[] strArr = this._fields;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    public Object getFieldPath(int i) {
        XPath[] xPathArr = this._fieldPaths;
        if (xPathArr == null) {
            try {
                buildPaths();
                xPathArr = this._fieldPaths;
            } catch (XPath.XPathCompileException unused) {
                return null;
            }
        }
        return xPathArr[i];
    }

    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [org.apache.xmlbeans.impl.common.XPath$XPathCompileException] */
    public void buildPaths() {
        this._selectorPath = XPath.compileXPath(this._selector, this._nsMap);
        this._fieldPaths = new XPath[this._fields.length];
        for (int i = 0; i < this._fieldPaths.length; i++) {
            this._fieldPaths[i] = XPath.compileXPath(this._fields[i], this._nsMap);
        }
    }

    public void setReferencedKey(SchemaIdentityConstraint.Ref ref) {
        this._key = ref;
    }

    public SchemaIdentityConstraint getReferencedKey() {
        return this._key.get();
    }

    public void setConstraintCategory(int i) {
        this._type = i;
    }

    public int getConstraintCategory() {
        return this._type;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public QName getName() {
        return this._name;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parse = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
    }

    public XmlObject getParseObject() {
        return this._parse;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public boolean isResolved() {
        return (getConstraintCategory() == 2 && this._key == null) ? false : true;
    }

    public SchemaIdentityConstraint.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }
}
