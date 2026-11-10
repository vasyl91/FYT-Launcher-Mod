package org.apache.xmlbeans.impl.validator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.IdentityConstraint;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.JavaBooleanHolder;
import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class Validator implements ValidatorListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean _booleanValue;
    private byte[] _byteArrayValue;
    private IdentityConstraint _constraintEngine;
    private BigDecimal _decimalValue;
    private double _doubleValue;
    private int _eatContent;
    private Collection _errorListener;
    private int _errorState;
    private float _floatValue;
    private GDate _gdateValue;
    private GDuration _gdurationValue;
    private SchemaTypeLoader _globalTypes;
    private boolean _invalid;
    private List _listTypes;
    private List _listValue;
    private SchemaLocalAttribute _localAttribute;
    private SchemaLocalElement _localElement;
    private QName _qnameValue;
    private SchemaField _rootField;
    private SchemaType _rootType;
    private State _stateStack;
    private boolean _strict;
    private String _stringValue;
    private int _suspendErrors;
    private boolean _treatLaxAsSkip;
    private SchemaType _unionType;
    private ValidatorVC _vc;
    private LinkedList _visitorPool = new LinkedList();
    private SchemaAttributeModel _wildcardAttribute;
    private SchemaParticle _wildcardElement;

    public Validator(SchemaType schemaType, SchemaField schemaField, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection collection) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._errorListener = (Collection) xmlOptionsMaskNull.get("ERROR_LISTENER");
        this._treatLaxAsSkip = xmlOptionsMaskNull.hasOption("VALIDATE_TREAT_LAX_AS_SKIP");
        this._strict = xmlOptionsMaskNull.hasOption("VALIDATE_STRICT");
        if (this._errorListener == null) {
            this._errorListener = collection;
        }
        this._constraintEngine = new IdentityConstraint(this._errorListener, schemaType.isDocumentType());
        this._globalTypes = schemaTypeLoader;
        this._rootType = schemaType;
        this._rootField = schemaField;
        this._vc = new ValidatorVC();
    }

    private class ValidatorVC implements ValidationContext {
        ValidatorListener.Event _event;

        private ValidatorVC() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            Validator.this.emitError(this._event, str, null, null, null, 1001, null);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            Validator.this.emitError(this._event, str, objArr, null, null, null, 1001, null);
        }
    }

    public boolean isValid() {
        return !this._invalid && this._constraintEngine.isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitError(event, str, null, null, 0, null, qName, schemaType, list, i, schemaType2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitError(event, null, str, objArr, 0, null, qName, schemaType, list, i, schemaType2);
    }

    private void emitError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i, QName qName, QName qName2, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        XmlValidationError xmlValidationErrorForLocationWithDetails;
        this._errorState++;
        if (this._suspendErrors == 0) {
            if (i == 0) {
                this._invalid = true;
            }
            if (this._errorListener != null) {
                XmlCursor locationAsCursor = event.getLocationAsCursor();
                if (locationAsCursor != null) {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forCursorWithDetails(str, str2, objArr, i, locationAsCursor, qName, qName2, schemaType, list, i2, schemaType2);
                } else {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forLocationWithDetails(str, str2, objArr, i, event.getLocation(), qName, qName2, schemaType, list, i2, schemaType2);
                }
                this._errorListener.add(xmlValidationErrorForLocationWithDetails);
            }
        }
    }

    private void emitFieldError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List list, int i, SchemaType schemaType2) {
        emitFieldError(event, null, str, objArr, 0, qName, schemaType, list, i, schemaType2);
    }

    private void emitFieldError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i, QName qName, SchemaType schemaType, List list, int i2, SchemaType schemaType2) {
        State state = this._stateStack;
        emitError(event, str, str2, objArr, i, (state == null || state._field == null) ? null : this._stateStack._field.getName(), qName, schemaType, list, i2, schemaType2);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener
    public void nextEvent(int i, ValidatorListener.Event event) {
        resetValues();
        int i2 = this._eatContent;
        if (i2 > 0) {
            if (i == 1) {
                this._eatContent = i2 + 1;
                return;
            } else {
                if (i != 2) {
                    return;
                }
                this._eatContent = i2 - 1;
                return;
            }
        }
        if (i == 1) {
            beginEvent(event);
            return;
        }
        if (i == 2) {
            endEvent(event);
            return;
        }
        if (i == 3) {
            textEvent(event);
        } else if (i == 4) {
            attrEvent(event);
        } else {
            if (i != 5) {
                return;
            }
            endAttrsEvent(event);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void beginEvent(ValidatorListener.Event event) {
        SchemaField schemaFieldFindElement;
        SchemaField schemaFieldFindElement2;
        SchemaType type;
        SchemaType schemaType;
        SchemaType schemaType2;
        boolean zValidateLexical;
        boolean z;
        int i;
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        boolean z2 = false;
        if (state == null) {
            type = this._rootType;
            schemaFieldFindElement2 = this._rootField;
        } else {
            QName name = event.getName();
            state._isEmpty = false;
            if (state._isNil) {
                emitFieldError(event, "cvc-elt.3.2.1", null, state._field.getName(), state._type, null, 4, state._type);
                this._eatContent = 1;
                return;
            }
            if (!state._isNil && state._field != null && state._field.isFixed()) {
                emitFieldError(event, "cvc-elt.5.2.2.1", new Object[]{QNameHelper.pretty(state._field.getName())}, state._field.getName(), state._type, null, 2, state._type);
            }
            if (!state.visit(name)) {
                findDetailedErrorBegin(event, state, name);
                this._eatContent = 1;
                return;
            }
            SchemaParticle schemaParticleCurrentParticle = state.currentParticle();
            this._wildcardElement = schemaParticleCurrentParticle;
            if (schemaParticleCurrentParticle.getParticleType() == 5) {
                if (!schemaParticleCurrentParticle.getWildcardSet().contains(name)) {
                    emitFieldError(event, "cvc-particle.1.3", new Object[]{QNameHelper.pretty(name)}, name, null, null, 2, state._type);
                    this._eatContent = 1;
                    return;
                }
                int wildcardProcess = schemaParticleCurrentParticle.getWildcardProcess();
                if (wildcardProcess == 3 || (wildcardProcess == 2 && this._treatLaxAsSkip)) {
                    this._eatContent = 1;
                    return;
                }
                schemaFieldFindElement2 = this._globalTypes.findElement(name);
                this._localElement = schemaFieldFindElement2;
                if (schemaFieldFindElement2 == null) {
                    if (wildcardProcess == 1) {
                        emitFieldError(event, "cvc-assess-elt.1.1.1.3.2", new Object[]{QNameHelper.pretty(name)}, name, state._type, null, 2, state._type);
                    }
                    this._eatContent = 1;
                    return;
                }
            } else {
                if (!schemaParticleCurrentParticle.getName().equals(name)) {
                    if (((SchemaLocalElement) schemaParticleCurrentParticle).blockSubstitution()) {
                        emitFieldError(event, "cvc-particle.2.3.3a", new Object[]{QNameHelper.pretty(name)}, name, state._type, null, 2, state._type);
                        this._eatContent = 1;
                        return;
                    } else {
                        schemaFieldFindElement = this._globalTypes.findElement(name);
                        if (schemaFieldFindElement != null) {
                            this._localElement = schemaFieldFindElement;
                        } else {
                            schemaFieldFindElement = null;
                        }
                    }
                } else {
                    schemaFieldFindElement = (SchemaField) schemaParticleCurrentParticle;
                }
                schemaFieldFindElement2 = schemaFieldFindElement;
            }
            type = schemaFieldFindElement2.getType();
        }
        SchemaType schemaType3 = type;
        SchemaField schemaField = schemaFieldFindElement2;
        if (schemaType3.isNoType()) {
            emitFieldError(event, "cvc-elt.1", null, event.getName(), null, null, 3, null);
            this._eatContent = 1;
        }
        String xsiType = event.getXsiType();
        if (xsiType != null) {
            int i2 = this._errorState;
            this._suspendErrors++;
            try {
                schemaType = null;
                try {
                    this._vc._event = null;
                    SchemaType schemaTypeFindType = this._globalTypes.findType(XmlQNameImpl.validateLexical(xsiType, this._vc, event));
                    this._suspendErrors--;
                    schemaType2 = schemaTypeFindType;
                } catch (Throwable unused) {
                    try {
                        this._errorState++;
                        this._suspendErrors--;
                        schemaType2 = schemaType;
                    } catch (Throwable th) {
                        this._suspendErrors--;
                        throw th;
                    }
                }
            } catch (Throwable unused2) {
                schemaType = null;
            }
            if (i2 != this._errorState) {
                emitFieldError(event, "cvc-elt.4.1", new Object[]{xsiType}, event.getName(), schemaType2, null, 3, state._type);
                this._eatContent = 1;
                return;
            } else if (schemaType2 == null) {
                emitFieldError(event, "cvc-elt.4.2", new Object[]{xsiType}, event.getName(), null, null, 3, null);
                this._eatContent = 1;
                return;
            }
        } else {
            schemaType = null;
            schemaType2 = null;
        }
        if (schemaType2 != null && !schemaType2.equals(schemaType3)) {
            if (!schemaType3.isAssignableFrom(schemaType2)) {
                Object[] objArr = {schemaType2, schemaType3};
                QName name2 = event.getName();
                if (state != null) {
                    schemaType = state._type;
                }
                emitFieldError(event, "cvc-elt.4.3a", objArr, name2, schemaType3, null, 3, schemaType);
                this._eatContent = 1;
                return;
            }
            if (schemaType3.blockExtension()) {
                for (SchemaType baseType = schemaType2; !baseType.equals(schemaType3); baseType = baseType.getBaseType()) {
                    if (baseType.getDerivationType() == 2) {
                        Object[] objArr2 = {schemaType2, schemaType3};
                        QName name3 = event.getName();
                        if (state != null) {
                            schemaType = state._type;
                        }
                        emitFieldError(event, "cvc-elt.4.3b", objArr2, name3, schemaType3, null, 3, schemaType);
                        this._eatContent = 1;
                        return;
                    }
                }
            }
            if (schemaType3.blockRestriction()) {
                for (SchemaType baseType2 = schemaType2; !baseType2.equals(schemaType3); baseType2 = baseType2.getBaseType()) {
                    if (baseType2.getDerivationType() == 1) {
                        Object[] objArr3 = {schemaType2, schemaType3};
                        QName name4 = event.getName();
                        if (state != null) {
                            schemaType = state._type;
                        }
                        emitFieldError(event, "cvc-elt.4.3c", objArr3, name4, schemaType3, null, 3, schemaType);
                        this._eatContent = 1;
                        return;
                    }
                }
            }
            if (schemaField instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField;
                this._localElement = schemaLocalElement;
                if (schemaLocalElement.blockExtension() || schemaLocalElement.blockRestriction()) {
                    for (SchemaType baseType3 = schemaType2; !baseType3.equals(schemaType3); baseType3 = baseType3.getBaseType()) {
                        if (baseType3.getDerivationType() == 1 && schemaLocalElement.blockRestriction()) {
                            i = 2;
                        } else {
                            i = 2;
                            if (baseType3.getDerivationType() != 2 || !schemaLocalElement.blockExtension()) {
                            }
                        }
                        Object[] objArr4 = new Object[i];
                        objArr4[0] = schemaType2;
                        objArr4[1] = QNameHelper.pretty(schemaLocalElement.getName());
                        emitFieldError(event, "cvc-elt.4.3d", objArr4, schemaLocalElement.getName(), null, null, 3, null);
                        this._eatContent = 1;
                        return;
                    }
                }
            }
            schemaType3 = schemaType2;
        }
        boolean z3 = schemaField instanceof SchemaLocalElement;
        if (z3) {
            SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaField;
            this._localElement = schemaLocalElement2;
            if (schemaLocalElement2.isAbstract()) {
                emitError(event, "cvc-elt.2", new Object[]{QNameHelper.pretty(schemaLocalElement2.getName())}, schemaLocalElement2.getName(), null, null, 3, null);
                this._eatContent = 1;
                return;
            }
        }
        if (schemaType3 != null && schemaType3.isAbstract()) {
            Object[] objArr5 = {schemaType3};
            QName name5 = event.getName();
            if (state != null) {
                schemaType = state._type;
            }
            emitError(event, "cvc-elt.2", objArr5, name5, schemaType3, null, 3, schemaType);
            this._eatContent = 1;
            return;
        }
        String xsiNil = event.getXsiNil();
        if (xsiNil != null) {
            this._vc._event = event;
            zValidateLexical = JavaBooleanHolder.validateLexical(xsiNil, this._vc);
            z2 = true;
        } else {
            zValidateLexical = false;
        }
        if (z2 && (schemaField == null || !schemaField.isNillable())) {
            SchemaType name6 = schemaField == null ? schemaType : schemaField.getName();
            if (state != null) {
                schemaType = state._type;
            }
            emitFieldError(event, "cvc-elt.3.1", null, name6, schemaType3, null, 3, schemaType);
            this._eatContent = 1;
            return;
        }
        if (zValidateLexical && schemaField != null && schemaField.isFixed()) {
            emitFieldError(event, "cvc-elt.3.2.2", null, schemaField == null ? schemaType : schemaField.getName(), schemaType3, null, 3, state == null ? schemaType : state._type);
            z = zValidateLexical;
        } else {
            z = zValidateLexical;
        }
        newState(schemaType3, schemaField, z);
        this._constraintEngine.element(event, schemaType3, z3 ? ((SchemaLocalElement) schemaField).getIdentityConstraints() : schemaType);
    }

    private void attrEvent(ValidatorListener.Event event) {
        QName name = event.getName();
        State state = topState();
        if (state._attrs == null) {
            state._attrs = new HashSet();
        }
        if (state._attrs.contains(name)) {
            emitFieldError(event, "uniqattspec", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        state._attrs.add(name);
        if (!state._canHaveAttrs) {
            emitFieldError(event, "cvc-complex-type.3.2.1", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        SchemaLocalAttribute attribute = state._attrModel == null ? null : state._attrModel.getAttribute(name);
        if (attribute != null) {
            this._localAttribute = attribute;
            if (attribute.getUse() == 1) {
                emitFieldError(event, "cvc-complex-type.prohibited-attribute", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
                return;
            } else {
                this._constraintEngine.attr(event, name, attribute.getType(), validateSimpleType(attribute.getType(), attribute, event, false, false));
                return;
            }
        }
        int wildcardProcess = state._attrModel.getWildcardProcess();
        this._wildcardAttribute = state._attrModel;
        if (wildcardProcess == 0) {
            emitFieldError(event, "cvc-complex-type.3.2.1", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (!state._attrModel.getWildcardSet().contains(name)) {
            emitFieldError(event, "cvc-complex-type.3.2.2", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            return;
        }
        if (wildcardProcess != 3) {
            if (wildcardProcess == 2 && this._treatLaxAsSkip) {
                return;
            }
            SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = this._globalTypes.findAttribute(name);
            this._localAttribute = schemaGlobalAttributeFindAttribute;
            if (schemaGlobalAttributeFindAttribute != null) {
                this._constraintEngine.attr(event, name, schemaGlobalAttributeFindAttribute.getType(), validateSimpleType(schemaGlobalAttributeFindAttribute.getType(), schemaGlobalAttributeFindAttribute, event, false, false));
            } else {
                if (wildcardProcess == 2) {
                    return;
                }
                emitFieldError(event, "cvc-assess-attr.1.2", new Object[]{QNameHelper.pretty(name)}, name, null, null, 1000, state._type);
            }
        }
    }

    private void endAttrsEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._attrModel != null) {
            for (SchemaLocalAttribute schemaLocalAttribute : state._attrModel.getAttributes()) {
                if (state._attrs == null || !state._attrs.contains(schemaLocalAttribute.getName())) {
                    if (schemaLocalAttribute.getUse() == 3) {
                        emitFieldError(event, "cvc-complex-type.4", new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName())}, schemaLocalAttribute.getName(), null, null, 1000, state._type);
                    } else if (schemaLocalAttribute.isDefault() || schemaLocalAttribute.isFixed()) {
                        this._constraintEngine.attr(event, schemaLocalAttribute.getName(), schemaLocalAttribute.getType(), schemaLocalAttribute.getDefaultText());
                    }
                }
            }
        }
    }

    private void endEvent(ValidatorListener.Event event) {
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        if (!state._isNil) {
            if (!state.end()) {
                findDetailedErrorEnd(event, state);
            }
            if (state._isEmpty) {
                handleText(event, true, state._field);
            }
        }
        popState(event);
        this._constraintEngine.endElement(event);
    }

    private void textEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._isNil) {
            emitFieldError(event, "cvc-elt.3.2.1", null, state._field.getName(), state._type, null, 4, state._type);
        } else {
            handleText(event, false, state._field);
        }
        state._isEmpty = false;
    }

    private void handleText(ValidatorListener.Event event, boolean z, SchemaField schemaField) {
        State state = topState();
        if (!state._sawText) {
            if (state._hasSimpleContent) {
                this._constraintEngine.text(event, state._type, validateSimpleType(state._type, schemaField, event, z, true), false);
            } else if (state._canHaveMixedContent) {
                this._constraintEngine.text(event, XmlString.type, validateSimpleType(XmlString.type, schemaField, event, z, true), false);
            } else if (z) {
                this._constraintEngine.text(event, state._type, null, true);
            } else {
                this._constraintEngine.text(event, state._type, "", false);
            }
        }
        if (!z && !state._canHaveMixedContent && !event.textIsWhitespace() && !state._hasSimpleContent) {
            if (schemaField instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField;
                emitError(event, state._type.getContentType() == 1 ? "cvc-complex-type.2.1" : "cvc-complex-type.2.3", new Object[]{QNameHelper.pretty(schemaLocalElement.getName())}, schemaLocalElement.getName(), schemaField.getType(), null, 3, null);
            } else {
                emitError(event, "Can't have mixed content", event.getName(), state._type, null, 3, null);
            }
        }
        if (z) {
            return;
        }
        state._sawText = true;
    }

    private void findDetailedErrorBegin(ValidatorListener.Event event, State state, QName qName) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : state._type.getElementProperties()) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        List list = arrayList.size() > 0 ? arrayList : arrayList2;
        if (list.size() <= 0) {
            emitFieldError(event, "cvc-complex-type.2.4b", new Object[]{QNameHelper.pretty(qName)}, qName, null, null, 1, state._type);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(QNameHelper.pretty((QName) it.next()));
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        emitFieldError(event, "cvc-complex-type.2.4a", new Object[]{new Integer(list.size()), stringBuffer.toString(), QNameHelper.pretty(qName)}, qName, null, list, 1, state._type);
    }

    private void findDetailedErrorEnd(ValidatorListener.Event event, State state) {
        SchemaProperty[] elementProperties = state._type.getElementProperties();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : elementProperties) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        List list = arrayList.size() > 0 ? arrayList : arrayList2;
        if (list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(QNameHelper.pretty((QName) it.next()));
                if (it.hasNext()) {
                    stringBuffer.append(" ");
                }
            }
            emitFieldError(event, "cvc-complex-type.2.4c", new Object[]{new Integer(list.size()), stringBuffer.toString()}, null, null, list, 1, state._type);
            return;
        }
        emitFieldError(event, "cvc-complex-type.2.4d", null, null, null, null, 2, state._type);
    }

    private final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        SchemaAttributeModel _attrModel;
        HashSet _attrs;
        boolean _canHaveAttrs;
        boolean _canHaveElements;
        boolean _canHaveMixedContent;
        SchemaField _field;
        boolean _hasSimpleContent;
        boolean _isEmpty;
        boolean _isNil;
        State _next;
        boolean _sawText;
        SchemaType _type;
        SchemaTypeVisitorImpl _visitor;

        private State() {
        }

        boolean visit(QName qName) {
            return this._canHaveElements && this._visitor.visit(qName);
        }

        boolean test(QName qName) {
            return this._canHaveElements && this._visitor.testValid(qName);
        }

        boolean end() {
            return !this._canHaveElements || this._visitor.visit(null);
        }

        SchemaParticle currentParticle() {
            return this._visitor.currentParticle();
        }
    }

    private boolean derivedFromInteger(SchemaType schemaType) {
        int builtinTypeCode = schemaType.getBuiltinTypeCode();
        while (builtinTypeCode == 0) {
            schemaType = schemaType.getBaseType();
            builtinTypeCode = schemaType.getBuiltinTypeCode();
        }
        return builtinTypeCode >= 22 && builtinTypeCode <= 34;
    }

    private void newState(SchemaType schemaType, SchemaField schemaField, boolean z) {
        State state = new State();
        state._type = schemaType;
        state._field = schemaField;
        state._isEmpty = true;
        state._isNil = z;
        if (schemaType.isSimpleType()) {
            state._hasSimpleContent = true;
        } else {
            state._canHaveAttrs = true;
            state._attrModel = schemaType.getAttributeModel();
            int contentType = schemaType.getContentType();
            if (contentType != 1) {
                if (contentType == 2) {
                    state._hasSimpleContent = true;
                } else {
                    if (contentType != 3) {
                        if (contentType == 4) {
                            state._canHaveMixedContent = true;
                        } else {
                            throw new RuntimeException("Unexpected content type");
                        }
                    }
                    SchemaParticle contentModel = schemaType.getContentModel();
                    state._canHaveElements = contentModel != null;
                    if (state._canHaveElements) {
                        state._visitor = initVisitor(contentModel);
                    }
                }
            }
        }
        pushState(state);
    }

    private void popState(ValidatorListener.Event event) {
        if (this._stateStack._visitor != null) {
            poolVisitor(this._stateStack._visitor);
            this._stateStack._visitor = null;
        }
        this._stateStack = this._stateStack._next;
    }

    private void pushState(State state) {
        state._next = this._stateStack;
        this._stateStack = state;
    }

    private void poolVisitor(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
        this._visitorPool.add(schemaTypeVisitorImpl);
    }

    private SchemaTypeVisitorImpl initVisitor(SchemaParticle schemaParticle) {
        if (this._visitorPool.isEmpty()) {
            return new SchemaTypeVisitorImpl(schemaParticle);
        }
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = (SchemaTypeVisitorImpl) this._visitorPool.removeLast();
        schemaTypeVisitorImpl.init(schemaParticle);
        return schemaTypeVisitorImpl;
    }

    private State topState() {
        return this._stateStack;
    }

    private String validateSimpleType(SchemaType schemaType, SchemaField schemaField, ValidatorListener.Event event, boolean z, boolean z2) {
        String text;
        String str;
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            return null;
        }
        if (schemaType.isNoType()) {
            emitError(event, schemaField.isAttribute() ? "cvc-attribute.1" : "cvc-elt.1", null, schemaField.getName(), schemaType, null, 3, null);
            return null;
        }
        if (z) {
            text = "";
        } else {
            int whiteSpaceRule = schemaType.getWhiteSpaceRule();
            text = whiteSpaceRule == 1 ? event.getText() : event.getText(whiteSpaceRule);
        }
        if (text.length() == 0 && z2 && schemaField != null && (schemaField.isDefault() || schemaField.isFixed())) {
            if (XmlQName.type.isAssignableFrom(schemaType)) {
                emitError(event, "Default QName values are unsupported for " + QNameHelper.readable(schemaType) + " - ignoring.", null, null, 2, schemaField.getName(), null, schemaType, null, 3, null);
                return null;
            }
            String strCollapse = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (validateSimpleType(schemaType, strCollapse, event)) {
                return strCollapse;
            }
            return null;
        }
        if (!validateSimpleType(schemaType, text, event)) {
            return null;
        }
        if (schemaField != null && schemaField.isFixed()) {
            String strCollapse2 = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (!validateSimpleType(schemaType, strCollapse2, event)) {
                return null;
            }
            if (!schemaType.newValue(text).valueEquals(schemaType.newValue(strCollapse2))) {
                if (schemaField.isAttribute()) {
                    emitError(event, "cvc-attribute.4", new Object[]{text, strCollapse2, QNameHelper.pretty(event.getName())}, null, schemaField.getType(), null, 3, null);
                } else {
                    if (schemaField.getType().getContentType() == 4) {
                        str = "cvc-elt.5.2.2.2.1";
                    } else {
                        str = schemaType.isSimpleType() ? "cvc-elt.5.2.2.2.2" : null;
                    }
                    emitError(event, str, new Object[]{text, strCollapse2}, schemaField.getName(), schemaField.getType(), null, 3, null);
                }
                return null;
            }
        }
        return text;
    }

    private boolean validateSimpleType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            throw new RuntimeException("Not a simple type");
        }
        int i = this._errorState;
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 1) {
            validateAtomicType(schemaType, str, event);
        } else if (simpleVariety == 2) {
            validateUnionType(schemaType, str, event);
        } else if (simpleVariety == 3) {
            validateListType(schemaType, str, event);
        } else {
            throw new RuntimeException("Unexpected simple variety");
        }
        return i == this._errorState;
    }

    private void validateAtomicType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int i = this._errorState;
        this._vc._event = event;
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                this._stringValue = str;
                return;
            case 3:
                this._booleanValue = JavaBooleanHolderEx.validateLexical(str, schemaType, this._vc);
                return;
            case 4:
                byte[] bArrValidateLexical = JavaBase64HolderEx.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical != null) {
                    JavaBase64HolderEx.validateValue(bArrValidateLexical, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical;
                return;
            case 5:
                byte[] bArrValidateLexical2 = JavaHexBinaryHolderEx.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical2 != null) {
                    JavaHexBinaryHolderEx.validateValue(bArrValidateLexical2, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical2;
                return;
            case 6:
                JavaUriHolderEx.validateLexical(str, schemaType, this._vc);
                if (this._strict) {
                    try {
                        XsTypeConverter.lexAnyURI(str);
                    } catch (InvalidLexicalValueException unused) {
                        this._vc.invalid("anyURI", new Object[]{str});
                    }
                    break;
                }
                this._stringValue = str;
                return;
            case 7:
                QName qNameValidateLexical = JavaQNameHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i == this._errorState) {
                    JavaQNameHolderEx.validateValue(qNameValidateLexical, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical;
                return;
            case 8:
                QName qNameValidateLexical2 = JavaNotationHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i == this._errorState) {
                    JavaNotationHolderEx.validateValue(qNameValidateLexical2, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical2;
                return;
            case 9:
                float fValidateLexical = JavaFloatHolderEx.validateLexical(str, schemaType, this._vc);
                if (i == this._errorState) {
                    JavaFloatHolderEx.validateValue(fValidateLexical, schemaType, this._vc);
                }
                this._floatValue = fValidateLexical;
                return;
            case 10:
                double dValidateLexical = JavaDoubleHolderEx.validateLexical(str, schemaType, this._vc);
                if (i == this._errorState) {
                    JavaDoubleHolderEx.validateValue(dValidateLexical, schemaType, this._vc);
                }
                this._doubleValue = dValidateLexical;
                return;
            case 11:
                JavaDecimalHolderEx.validateLexical(str, schemaType, this._vc);
                if (derivedFromInteger(schemaType) && str.lastIndexOf(46) >= 0) {
                    this._vc.invalid("integer", new Object[]{str});
                }
                if (i == this._errorState) {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    this._decimalValue = bigDecimal;
                    JavaDecimalHolderEx.validateValue(bigDecimal, schemaType, this._vc);
                    return;
                }
                return;
            case 12:
                JavaStringEnumerationHolderEx.validateLexical(str, schemaType, this._vc);
                this._stringValue = str;
                return;
            case 13:
                GDuration gDurationValidateLexical = XmlDurationImpl.validateLexical(str, schemaType, this._vc);
                if (gDurationValidateLexical != null) {
                    XmlDurationImpl.validateValue(gDurationValidateLexical, schemaType, this._vc);
                }
                this._gdurationValue = gDurationValidateLexical;
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                break;
            case 21:
                if (this._strict && str.length() == 6 && str.charAt(4) == '-' && str.charAt(5) == '-') {
                    this._vc.invalid("date", new Object[]{str});
                }
                break;
            default:
                throw new RuntimeException("Unexpected primitive type code");
        }
        GDate gDateValidateLexical = XmlDateImpl.validateLexical(str, schemaType, this._vc);
        if (gDateValidateLexical != null) {
            XmlDateImpl.validateValue(gDateValidateLexical, schemaType, this._vc);
        }
        this._gdateValue = gDateValidateLexical;
    }

    private void validateListType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int i;
        String[] strArr;
        int i2;
        String[] strArr2;
        int intValue;
        int intValue2;
        int i3 = this._errorState;
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, "cvc-datatype-valid.1.1", new Object[]{"list", str, QNameHelper.readable(schemaType)}, null, schemaType, null, 2000, null);
        }
        String[] strArrSplit_list = XmlListImpl.split_list(str);
        SimpleValue facet = schemaType.getFacet((int) r7);
        if (facet == null || (intValue2 = facet.getIntValue()) == strArrSplit_list.length) {
            i = 1;
        } else {
            i = 1;
            emitError(event, "cvc-length-valid.2", new Object[]{str, new Integer(strArrSplit_list.length), new Integer(intValue2), QNameHelper.readable(schemaType)}, null, schemaType, null, 2000, null);
        }
        SimpleValue facet2 = schemaType.getFacet(i);
        if (facet2 == null || (intValue = facet2.getIntValue()) <= strArrSplit_list.length) {
            strArr = strArrSplit_list;
            i2 = 2;
        } else {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[i] = new Integer(strArrSplit_list.length);
            objArr[2] = new Integer(intValue);
            objArr[3] = QNameHelper.readable(schemaType);
            i2 = 2;
            strArr = strArrSplit_list;
            emitError(event, "cvc-length-valid.2", objArr, null, schemaType, null, 2000, null);
        }
        SimpleValue facet3 = schemaType.getFacet(i2);
        if (facet3 != null) {
            int intValue3 = facet3.getIntValue();
            String[] strArr3 = strArr;
            if (intValue3 < strArr3.length) {
                Object[] objArr2 = new Object[4];
                objArr2[0] = str;
                objArr2[1] = new Integer(strArr3.length);
                objArr2[i2] = new Integer(intValue3);
                objArr2[3] = QNameHelper.readable(schemaType);
                strArr2 = strArr3;
                emitError(event, "cvc-length-valid.2", objArr2, null, schemaType, null, 2000, null);
            } else {
                strArr2 = strArr3;
            }
        } else {
            strArr2 = strArr;
        }
        SchemaType listItemType = schemaType.getListItemType();
        this._listValue = new ArrayList();
        this._listTypes = new ArrayList();
        for (String str2 : strArr2) {
            validateSimpleType(listItemType, str2, event);
            addToList(listItemType);
        }
        if (i3 != this._errorState || schemaType.getEnumerationValues() == null) {
            return;
        }
        NamespaceContext.push(new NamespaceContext(event));
        try {
            try {
                ((SchemaTypeImpl) schemaType).newValidatingValue(str);
            } catch (XmlValueOutOfRangeException unused) {
                emitError(event, "cvc-enumeration-valid", new Object[]{"list", str, QNameHelper.readable(schemaType)}, null, schemaType, null, 2000, null);
            }
        } finally {
            NamespaceContext.pop();
        }
    }

    private void validateUnionType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, "cvc-datatype-valid.1.1", new Object[]{"union", str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
        }
        SchemaType[] unionMemberTypes = schemaType.getUnionMemberTypes();
        int i = this._errorState;
        String strCollapse = str;
        int i2 = 0;
        int i3 = 1;
        while (i2 < unionMemberTypes.length) {
            int whiteSpaceRule = unionMemberTypes[i2].getWhiteSpaceRule();
            if (whiteSpaceRule == 0) {
                whiteSpaceRule = 1;
            }
            if (whiteSpaceRule != i3) {
                strCollapse = XmlWhitespace.collapse(str, whiteSpaceRule);
                i3 = whiteSpaceRule;
            }
            int i4 = this._errorState;
            this._suspendErrors++;
            try {
                validateSimpleType(unionMemberTypes[i2], strCollapse, event);
                this._suspendErrors--;
                if (i4 == this._errorState) {
                    this._unionType = unionMemberTypes[i2];
                    break;
                }
                i2++;
            } catch (Throwable th) {
                this._suspendErrors--;
                throw th;
            }
        }
        this._errorState = i;
        if (i2 >= unionMemberTypes.length) {
            emitError(event, "cvc-datatype-valid.1.2.3", new Object[]{str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
            return;
        }
        XmlObject[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            NamespaceContext.push(new NamespaceContext(event));
            try {
                try {
                    XmlAnySimpleType xmlAnySimpleTypeNewValue = schemaType.newValue(str);
                    int i5 = 0;
                    while (i5 < enumerationValues.length && !xmlAnySimpleTypeNewValue.valueEquals(enumerationValues[i5])) {
                        i5++;
                    }
                    if (i5 >= enumerationValues.length) {
                        emitError(event, "cvc-enumeration-valid", new Object[]{"union", str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
                    }
                } catch (XmlValueOutOfRangeException unused) {
                    emitError(event, "cvc-enumeration-valid", new Object[]{"union", str, QNameHelper.readable(schemaType)}, null, schemaType, null, 3000, null);
                }
            } finally {
                NamespaceContext.pop();
            }
        }
    }

    private void addToList(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() == 1 || schemaType.getSimpleVariety() == 2) {
            if (schemaType.getUnionMemberTypes().length > 0 && getUnionType() != null) {
                schemaType = getUnionType();
                this._unionType = null;
            }
            this._listTypes.add(schemaType);
            if (schemaType.getPrimitiveType() == null) {
                this._listValue.add(null);
                return;
            }
            switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                case 2:
                    this._listValue.add(this._stringValue);
                    return;
                case 3:
                    this._listValue.add(this._booleanValue ? Boolean.TRUE : Boolean.FALSE);
                    this._booleanValue = false;
                    return;
                case 4:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 5:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 6:
                    this._listTypes.add(this._stringValue);
                    return;
                case 7:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 8:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 9:
                    this._listValue.add(new Float(this._floatValue));
                    this._floatValue = 0.0f;
                    return;
                case 10:
                    this._listValue.add(new Double(this._doubleValue));
                    this._doubleValue = 0.0d;
                    return;
                case 11:
                    this._listValue.add(this._decimalValue);
                    this._decimalValue = null;
                    return;
                case 12:
                    this._listValue.add(this._stringValue);
                    this._stringValue = null;
                    return;
                case 13:
                    this._listValue.add(this._gdurationValue);
                    this._gdurationValue = null;
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    this._listValue.add(this._gdateValue);
                    this._gdateValue = null;
                    return;
                default:
                    throw new RuntimeException("Unexpected primitive type code");
            }
        }
    }

    private void resetValues() {
        this._wildcardAttribute = null;
        this._stringValue = null;
        this._decimalValue = null;
        this._booleanValue = false;
        this._floatValue = 0.0f;
        this._doubleValue = 0.0d;
        this._qnameValue = null;
        this._gdateValue = null;
        this._gdurationValue = null;
        this._byteArrayValue = null;
        this._listValue = null;
        this._listTypes = null;
        this._unionType = null;
        this._localAttribute = null;
    }

    public SchemaType getCurrentElementSchemaType() {
        State state = topState();
        if (state != null) {
            return state._type;
        }
        return null;
    }

    public SchemaLocalElement getCurrentElement() {
        State state;
        SchemaLocalElement schemaLocalElement = this._localElement;
        if (schemaLocalElement != null) {
            return schemaLocalElement;
        }
        if (this._eatContent <= 0 && (state = this._stateStack) != null && (state._field instanceof SchemaLocalElement)) {
            return this._stateStack._field;
        }
        return null;
    }

    public SchemaParticle getCurrentWildcardElement() {
        return this._wildcardElement;
    }

    public SchemaLocalAttribute getCurrentAttribute() {
        return this._localAttribute;
    }

    public SchemaAttributeModel getCurrentWildcardAttribute() {
        return this._wildcardAttribute;
    }

    public String getStringValue() {
        return this._stringValue;
    }

    public BigDecimal getDecimalValue() {
        return this._decimalValue;
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public float getFloatValue() {
        return this._floatValue;
    }

    public double getDoubleValue() {
        return this._doubleValue;
    }

    public QName getQNameValue() {
        return this._qnameValue;
    }

    public GDate getGDateValue() {
        return this._gdateValue;
    }

    public GDuration getGDurationValue() {
        return this._gdurationValue;
    }

    public byte[] getByteArrayValue() {
        return this._byteArrayValue;
    }

    public List getListValue() {
        return this._listValue;
    }

    public List getListTypes() {
        return this._listTypes;
    }

    public SchemaType getUnionType() {
        return this._unionType;
    }
}
