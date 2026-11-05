package org.apache.xmlbeans.impl.schema;

import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaLocalElementImpl extends SchemaParticleImpl implements SchemaLocalElement, SchemaWSDLArrayType {
    protected boolean _abs;
    private SchemaAnnotation _annotation;
    private boolean _blockExt;
    private boolean _blockRest;
    private boolean _blockSubst;
    private SchemaIdentityConstraint.Ref[] _constraints = new SchemaIdentityConstraint.Ref[0];
    private SOAPArrayType _wsdlArrayType;

    public SchemaLocalElementImpl() {
        setParticleType(4);
    }

    public boolean blockExtension() {
        return this._blockExt;
    }

    public boolean blockRestriction() {
        return this._blockRest;
    }

    public boolean blockSubstitution() {
        return this._blockSubst;
    }

    public boolean isAbstract() {
        return this._abs;
    }

    public void setAbstract(boolean z) {
        this._abs = z;
    }

    public void setBlock(boolean z, boolean z2, boolean z3) {
        mutate();
        this._blockExt = z;
        this._blockRest = z2;
        this._blockSubst = z3;
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    public void setWsdlArrayType(SOAPArrayType sOAPArrayType) {
        this._wsdlArrayType = sOAPArrayType;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    @Override // org.apache.xmlbeans.soap.SchemaWSDLArrayType
    public SOAPArrayType getWSDLArrayType() {
        return this._wsdlArrayType;
    }

    public void setIdentityConstraints(SchemaIdentityConstraint.Ref[] refArr) {
        mutate();
        this._constraints = refArr;
    }

    public SchemaIdentityConstraint[] getIdentityConstraints() {
        int length = this._constraints.length;
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[length];
        for (int i = 0; i < length; i++) {
            schemaIdentityConstraintArr[i] = this._constraints[i].get();
        }
        return schemaIdentityConstraintArr;
    }

    public SchemaIdentityConstraint.Ref[] getIdentityConstraintRefs() {
        SchemaIdentityConstraint.Ref[] refArr = this._constraints;
        int length = refArr.length;
        SchemaIdentityConstraint.Ref[] refArr2 = new SchemaIdentityConstraint.Ref[length];
        System.arraycopy(refArr, 0, refArr2, 0, length);
        return refArr2;
    }
}
