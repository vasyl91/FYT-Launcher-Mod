package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaLocalAttributeImpl implements SchemaLocalAttribute, SchemaWSDLArrayType {
    private SchemaAnnotation _annotation;
    private String _defaultText;
    XmlValueRef _defaultValue;
    private boolean _isDefault;
    private boolean _isFixed;
    protected XmlObject _parseObject;
    private SchemaType.Ref _typeref;
    private int _use;
    private Object _userData;
    private SOAPArrayType _wsdlArrayType;
    private QName _xmlName;

    public boolean isAttribute() {
        return true;
    }

    public boolean isNillable() {
        return false;
    }

    public void init(QName qName, SchemaType.Ref ref, int i, String str, XmlObject xmlObject, XmlValueRef xmlValueRef, boolean z, SOAPArrayType sOAPArrayType, SchemaAnnotation schemaAnnotation, Object obj) {
        if (this._xmlName != null || this._typeref != null) {
            throw new IllegalStateException("Already initialized");
        }
        this._use = i;
        this._typeref = ref;
        this._defaultText = str;
        this._parseObject = xmlObject;
        this._defaultValue = xmlValueRef;
        this._isDefault = str != null;
        this._isFixed = z;
        this._xmlName = qName;
        this._wsdlArrayType = sOAPArrayType;
        this._annotation = schemaAnnotation;
        this._userData = obj;
    }

    public boolean isTypeResolved() {
        return this._typeref != null;
    }

    public void resolveTypeRef(SchemaType.Ref ref) {
        if (this._typeref != null) {
            throw new IllegalStateException();
        }
        this._typeref = ref;
    }

    public int getUse() {
        return this._use;
    }

    public QName getName() {
        return this._xmlName;
    }

    public String getDefaultText() {
        return this._defaultText;
    }

    public boolean isDefault() {
        return this._isDefault;
    }

    public boolean isFixed() {
        return this._isFixed;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaType getType() {
        return this._typeref.get();
    }

    public SchemaType.Ref getTypeRef() {
        return this._typeref;
    }

    public BigInteger getMinOccurs() {
        return this._use == 3 ? BigInteger.ONE : BigInteger.ZERO;
    }

    public BigInteger getMaxOccurs() {
        return this._use == 1 ? BigInteger.ZERO : BigInteger.ONE;
    }

    @Override // org.apache.xmlbeans.soap.SchemaWSDLArrayType
    public SOAPArrayType getWSDLArrayType() {
        return this._wsdlArrayType;
    }

    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        if (this._defaultText == null || !XmlAnySimpleType.type.isAssignableFrom(getType())) {
            return null;
        }
        if (this._parseObject != null) {
            try {
                NamespaceContext.push(new NamespaceContext(this._parseObject));
                return getType().newValue(this._defaultText);
            } finally {
                NamespaceContext.pop();
            }
        }
        return getType().newValue(this._defaultText);
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        this._defaultValue = xmlValueRef;
    }

    public Object getUserData() {
        return this._userData;
    }
}
