package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaPropertyImpl implements SchemaProperty {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Set _acceptedNames;
    private SchemaType.Ref _containerTypeRef;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private boolean _extendsArray;
    private boolean _extendsOption;
    private boolean _extendsSingleton;
    private int _hasDefault;
    private int _hasFixed;
    private int _hasNillable;
    private boolean _isAttribute;
    private boolean _isImmutable;
    private SchemaType.Ref _javaBasedOnTypeRef;
    private String _javaPropertyName;
    private QNameSet _javaSetterDelimiter;
    private int _javaTypeCode;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    private QName _name;
    private SchemaType.Ref _typeref;

    public boolean isReadOnly() {
        return false;
    }

    private void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public SchemaType getContainerType() {
        return this._containerTypeRef.get();
    }

    public void setContainerTypeRef(SchemaType.Ref ref) {
        mutate();
        this._containerTypeRef = ref;
    }

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        mutate();
        this._name = qName;
    }

    public String getJavaPropertyName() {
        return this._javaPropertyName;
    }

    public void setJavaPropertyName(String str) {
        mutate();
        this._javaPropertyName = str;
    }

    public boolean isAttribute() {
        return this._isAttribute;
    }

    public void setAttribute(boolean z) {
        mutate();
        this._isAttribute = z;
    }

    public SchemaType getType() {
        return this._typeref.get();
    }

    public void setTypeRef(SchemaType.Ref ref) {
        mutate();
        this._typeref = ref;
    }

    public SchemaType javaBasedOnType() {
        SchemaType.Ref ref = this._javaBasedOnTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public boolean extendsJavaSingleton() {
        return this._extendsSingleton;
    }

    public boolean extendsJavaArray() {
        return this._extendsArray;
    }

    public boolean extendsJavaOption() {
        return this._extendsOption;
    }

    public void setExtendsJava(SchemaType.Ref ref, boolean z, boolean z2, boolean z3) {
        mutate();
        this._javaBasedOnTypeRef = ref;
        this._extendsSingleton = z;
        this._extendsOption = z2;
        this._extendsArray = z3;
    }

    public QNameSet getJavaSetterDelimiter() {
        if (this._isAttribute) {
            return QNameSet.EMPTY;
        }
        if (this._javaSetterDelimiter == null) {
            ((SchemaTypeImpl) getContainerType()).assignJavaElementSetterModel();
        }
        return this._javaSetterDelimiter;
    }

    void setJavaSetterDelimiter(QNameSet qNameSet) {
        this._javaSetterDelimiter = qNameSet;
    }

    public QName[] acceptedNames() {
        Set set = this._acceptedNames;
        return set == null ? new QName[]{this._name} : (QName[]) set.toArray(new QName[set.size()]);
    }

    public void setAcceptedNames(Set set) {
        mutate();
        this._acceptedNames = set;
    }

    public void setAcceptedNames(QNameSet qNameSet) {
        mutate();
        this._acceptedNames = qNameSet.includedQNamesInExcludedURIs();
    }

    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
    }

    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
    }

    public int hasNillable() {
        return this._hasNillable;
    }

    public void setNillable(int i) {
        mutate();
        this._hasNillable = i;
    }

    public int hasDefault() {
        return this._hasDefault;
    }

    public void setDefault(int i) {
        mutate();
        this._hasDefault = i;
    }

    public int hasFixed() {
        return this._hasFixed;
    }

    public void setFixed(int i) {
        mutate();
        this._hasFixed = i;
    }

    public String getDefaultText() {
        return this._defaultText;
    }

    public void setDefaultText(String str) {
        mutate();
        this._defaultText = str;
    }

    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        return null;
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        mutate();
        this._defaultValue = xmlValueRef;
    }

    public int getJavaTypeCode() {
        return this._javaTypeCode;
    }

    public void setJavaTypeCode(int i) {
        mutate();
        this._javaTypeCode = i;
    }
}
