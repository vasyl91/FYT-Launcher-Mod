package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.NamespaceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaParticleImpl implements SchemaParticle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigInteger _maxint = BigInteger.valueOf(2147483647L);
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private QNameSet _excludeNextSet;
    private int _intMaxOccurs;
    private int _intMinOccurs;
    private boolean _isDefault;
    private boolean _isDeterministic;
    private boolean _isFixed;
    private boolean _isImmutable;
    private boolean _isNillable;
    private boolean _isSkippable;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    protected XmlObject _parseObject;
    private SchemaParticle[] _particleChildren;
    private int _particleType;
    private QName _qName;
    private QNameSet _startSet;
    private SchemaType.Ref _typeref;
    private Object _userData;
    private int _wildcardProcess;
    private QNameSet _wildcardSet;

    public boolean isAttribute() {
        return false;
    }

    protected void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public boolean hasTransitionRules() {
        return this._startSet != null;
    }

    public boolean hasTransitionNotes() {
        return this._excludeNextSet != null;
    }

    public void setTransitionRules(QNameSet qNameSet, boolean z) {
        this._startSet = qNameSet;
        this._isSkippable = z;
    }

    public void setTransitionNotes(QNameSet qNameSet, boolean z) {
        this._excludeNextSet = qNameSet;
        this._isDeterministic = z;
    }

    public boolean canStartWithElement(QName qName) {
        return qName != null && this._startSet.contains(qName);
    }

    public QNameSet acceptedStartNames() {
        return this._startSet;
    }

    public QNameSet getExcludeNextSet() {
        return this._excludeNextSet;
    }

    public boolean isSkippable() {
        return this._isSkippable;
    }

    public boolean isDeterministic() {
        return this._isDeterministic;
    }

    public int getParticleType() {
        return this._particleType;
    }

    public void setParticleType(int i) {
        mutate();
        this._particleType = i;
    }

    public boolean isSingleton() {
        BigInteger bigInteger = this._maxOccurs;
        return bigInteger != null && bigInteger.compareTo(BigInteger.ONE) == 0 && this._minOccurs.compareTo(BigInteger.ONE) == 0;
    }

    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
        this._intMinOccurs = pegBigInteger(bigInteger);
    }

    public int getIntMinOccurs() {
        return this._intMinOccurs;
    }

    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    public int getIntMaxOccurs() {
        return this._intMaxOccurs;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
        this._intMaxOccurs = pegBigInteger(bigInteger);
    }

    public SchemaParticle[] getParticleChildren() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            return null;
        }
        SchemaParticle[] schemaParticleArr2 = new SchemaParticle[schemaParticleArr.length];
        System.arraycopy(schemaParticleArr, 0, schemaParticleArr2, 0, schemaParticleArr.length);
        return schemaParticleArr2;
    }

    public void setParticleChildren(SchemaParticle[] schemaParticleArr) {
        mutate();
        this._particleChildren = schemaParticleArr;
    }

    public SchemaParticle getParticleChild(int i) {
        return this._particleChildren[i];
    }

    public int countOfParticleChild() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            return 0;
        }
        return schemaParticleArr.length;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        mutate();
        this._wildcardSet = qNameSet;
    }

    public QNameSet getWildcardSet() {
        return this._wildcardSet;
    }

    public void setWildcardProcess(int i) {
        mutate();
        this._wildcardProcess = i;
    }

    public int getWildcardProcess() {
        return this._wildcardProcess;
    }

    private static final int pegBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return Integer.MAX_VALUE;
        }
        if (bigInteger.signum() <= 0) {
            return 0;
        }
        if (bigInteger.compareTo(_maxint) >= 0) {
            return Integer.MAX_VALUE;
        }
        return bigInteger.intValue();
    }

    public QName getName() {
        return this._qName;
    }

    public void setNameAndTypeRef(QName qName, SchemaType.Ref ref) {
        mutate();
        this._qName = qName;
        this._typeref = ref;
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

    public SchemaType getType() {
        SchemaType.Ref ref = this._typeref;
        if (ref == null) {
            return null;
        }
        return ref.get();
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

    public void setDefault(String str, boolean z, XmlObject xmlObject) {
        mutate();
        this._defaultText = str;
        this._isDefault = str != null;
        this._isFixed = z;
        this._parseObject = xmlObject;
    }

    public boolean isNillable() {
        return this._isNillable;
    }

    public void setNillable(boolean z) {
        mutate();
        this._isNillable = z;
    }

    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        if (this._defaultText == null || !XmlAnySimpleType.type.isAssignableFrom(getType())) {
            return null;
        }
        if (this._parseObject != null && XmlQName.type.isAssignableFrom(getType())) {
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
        mutate();
        this._defaultValue = xmlValueRef;
    }

    public Object getUserData() {
        return this._userData;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }
}
