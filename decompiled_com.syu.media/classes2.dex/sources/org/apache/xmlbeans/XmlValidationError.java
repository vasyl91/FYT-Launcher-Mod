package org.apache.xmlbeans;

import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlValidationError extends XmlError {
    public static final int ATTRIBUTE_TYPE_INVALID = 1001;
    public static final int ELEMENT_NOT_ALLOWED = 2;
    public static final int ELEMENT_TYPE_INVALID = 3;
    public static final int INCORRECT_ATTRIBUTE = 1000;
    public static final int INCORRECT_ELEMENT = 1;
    public static final int LIST_INVALID = 2000;
    public static final int NIL_ELEMENT = 4;
    public static final int UNDEFINED = 10000;
    public static final int UNION_INVALID = 3000;
    private SchemaType _badSchemaType;
    private int _errorType;
    private List _expectedQNames;
    private SchemaType _expectedSchemaType;
    private QName _fieldQName;
    private QName _offendingQName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private XmlValidationError(String str, int i, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        super(str, (String) null, i, xmlCursor);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i2);
        setBadSchemaType(schemaType2);
    }

    private XmlValidationError(String str, Object[] objArr, int i, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        super(str, objArr, i, xmlCursor);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i2);
        setBadSchemaType(schemaType2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private XmlValidationError(String str, int i, Location location, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        super(str, (String) null, i, location);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i2);
        setBadSchemaType(schemaType2);
    }

    private XmlValidationError(String str, Object[] objArr, int i, Location location, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        super(str, objArr, i, location);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i2);
        setBadSchemaType(schemaType2);
    }

    public static XmlValidationError forCursorWithDetails(String str, String str2, Object[] objArr, int i, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        if (str2 == null) {
            return new XmlValidationError(str, i, xmlCursor, qName, qName2, schemaType, list, i2, schemaType2);
        }
        return new XmlValidationError(str2, objArr, i, xmlCursor, qName, qName2, schemaType, list, i2, schemaType2);
    }

    public static XmlValidationError forLocationWithDetails(String str, String str2, Object[] objArr, int i, Location location, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        if (str2 == null) {
            return new XmlValidationError(str, i, location, qName, qName2, schemaType, list, i2, schemaType2);
        }
        return new XmlValidationError(str2, objArr, i, location, qName, qName2, schemaType, list, i2, schemaType2);
    }

    @Override // org.apache.xmlbeans.XmlError
    public String getMessage() {
        if (this._fieldQName != null) {
            String message = super.getMessage();
            StringBuffer stringBuffer = new StringBuffer(message.length() + 100);
            stringBuffer.append(message);
            stringBuffer.append(" in element ");
            stringBuffer.append(this._fieldQName.getLocalPart());
            if (this._fieldQName.getNamespaceURI() != null && this._fieldQName.getNamespaceURI().length() != 0) {
                stringBuffer.append('@').append(this._fieldQName.getNamespaceURI());
            }
            return stringBuffer.toString();
        }
        return super.getMessage();
    }

    public SchemaType getBadSchemaType() {
        return this._badSchemaType;
    }

    public void setBadSchemaType(SchemaType schemaType) {
        this._badSchemaType = schemaType;
    }

    public int getErrorType() {
        return this._errorType;
    }

    public void setErrorType(int i) {
        this._errorType = i;
    }

    public List getExpectedQNames() {
        return this._expectedQNames;
    }

    public void setExpectedQNames(List list) {
        this._expectedQNames = list;
    }

    public QName getFieldQName() {
        return this._fieldQName;
    }

    public void setFieldQName(QName qName) {
        this._fieldQName = qName;
    }

    public QName getOffendingQName() {
        return this._offendingQName;
    }

    public void setOffendingQName(QName qName) {
        this._offendingQName = qName;
    }

    public SchemaType getExpectedSchemaType() {
        return this._expectedSchemaType;
    }

    public void setExpectedSchemaType(SchemaType schemaType) {
        this._expectedSchemaType = schemaType;
    }
}
