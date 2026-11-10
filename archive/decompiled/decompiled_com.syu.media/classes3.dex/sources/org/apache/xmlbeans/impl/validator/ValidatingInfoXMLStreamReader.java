package org.apache.xmlbeans.impl.validator;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ValidatingInfoXMLStreamReader extends ValidatingXMLStreamReader implements XMLStreamReader {
    private int _attCount = -1;
    private int _attIndex = 0;

    public int nextWithAttributes() throws XMLStreamException {
        int i = this._attIndex;
        if (i < this._attCount) {
            validate_attribute(i);
            this._attIndex++;
            return 10;
        }
        return next();
    }

    @Override // org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader
    protected void validate_attributes(int i) {
        this._attCount = i;
        this._attIndex = 0;
    }

    public SchemaType getCurrentElementSchemaType() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getCurrentElementSchemaType();
    }

    public SchemaLocalElement getCurrentElement() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getCurrentElement();
    }

    public SchemaParticle getCurrentWildcardElement() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getCurrentWildcardElement();
    }

    public SchemaLocalAttribute getCurrentAttribute() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getCurrentAttribute();
    }

    public SchemaAttributeModel getCurrentWildcardAttribute() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getCurrentWildcardAttribute();
    }

    public String getStringValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getStringValue();
    }

    public BigDecimal getDecimalValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getDecimalValue();
    }

    public boolean getBooleanValue() {
        if (this._validator == null) {
            return false;
        }
        return this._validator.getBooleanValue();
    }

    public float getFloatValue() {
        if (this._validator == null) {
            return 0.0f;
        }
        return this._validator.getFloatValue();
    }

    public double getDoubleValue() {
        if (this._validator == null) {
            return 0.0d;
        }
        return this._validator.getDoubleValue();
    }

    public QName getQNameValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getQNameValue();
    }

    public GDate getGDateValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getGDateValue();
    }

    public GDuration getGDurationValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getGDurationValue();
    }

    public byte[] getByteArrayValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getByteArrayValue();
    }

    public List getListValue() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getListValue();
    }

    public List getListTypes() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getListTypes();
    }

    public SchemaType getUnionType() {
        if (this._validator == null) {
            return null;
        }
        return this._validator.getUnionType();
    }
}
