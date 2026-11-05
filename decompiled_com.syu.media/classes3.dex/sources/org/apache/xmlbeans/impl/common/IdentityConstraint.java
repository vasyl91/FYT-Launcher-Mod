package org.apache.xmlbeans.impl.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlIDREF;
import org.apache.xmlbeans.XmlIDREFS;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class IdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ConstraintState _constraintStack;
    private ElementState _elementStack;
    private Collection _errorListener;
    private boolean _invalid;
    private boolean _trackIdrefs;

    public IdentityConstraint(Collection collection, boolean z) {
        this._errorListener = collection;
        this._trackIdrefs = z;
    }

    public void element(ValidatorListener.Event event, SchemaType schemaType, SchemaIdentityConstraint[] schemaIdentityConstraintArr) {
        newState();
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.element(event, schemaType);
        }
        for (int i = 0; schemaIdentityConstraintArr != null && i < schemaIdentityConstraintArr.length; i++) {
            newConstraintState(schemaIdentityConstraintArr[i], event, schemaType);
        }
    }

    public void endElement(ValidatorListener.Event event) {
        if (this._elementStack._hasConstraints) {
            for (ConstraintState constraintState = this._constraintStack; constraintState != null && constraintState != this._elementStack._savePoint; constraintState = constraintState._next) {
                constraintState.remove(event);
            }
            this._constraintStack = this._elementStack._savePoint;
        }
        this._elementStack = this._elementStack._next;
        for (ConstraintState constraintState2 = this._constraintStack; constraintState2 != null; constraintState2 = constraintState2._next) {
            constraintState2.endElement(event);
        }
    }

    public void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.attr(event, qName, schemaType, str);
        }
    }

    public void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z) {
        for (ConstraintState constraintState = this._constraintStack; constraintState != null; constraintState = constraintState._next) {
            constraintState.text(event, schemaType, str, z);
        }
    }

    public boolean isValid() {
        return !this._invalid;
    }

    private void newConstraintState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
        if (schemaIdentityConstraint.getConstraintCategory() == 2) {
            new KeyrefState(schemaIdentityConstraint, event, schemaType);
        } else {
            new SelectorState(schemaIdentityConstraint, event, schemaType);
        }
    }

    private void buildIdStates() {
        IdState idState = new IdState();
        if (this._trackIdrefs) {
            new IdRefState(idState);
        }
    }

    private void newState() {
        boolean z = this._elementStack == null;
        ElementState elementState = new ElementState();
        elementState._next = this._elementStack;
        this._elementStack = elementState;
        if (z) {
            buildIdStates();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr) {
        this._invalid = true;
        Collection collection = this._errorListener;
        if (collection != null) {
            collection.add(errorForEvent(str, objArr, 0, event));
        }
    }

    public static XmlError errorForEvent(String str, Object[] objArr, int i, ValidatorListener.Event event) {
        XmlCursor locationAsCursor = event.getLocationAsCursor();
        if (locationAsCursor != null) {
            return XmlError.forCursor(str, objArr, i, locationAsCursor);
        }
        Location location = event.getLocation();
        if (location != null) {
            return XmlError.forLocation(str, objArr, i, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
        return XmlError.forMessage(str, objArr, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str) {
        this._invalid = true;
        Collection collection = this._errorListener;
        if (collection != null) {
            collection.add(errorForEvent(str, 0, event));
        }
    }

    public static XmlError errorForEvent(String str, int i, ValidatorListener.Event event) {
        XmlCursor locationAsCursor = event.getLocationAsCursor();
        if (locationAsCursor != null) {
            return XmlError.forCursor(str, i, locationAsCursor);
        }
        Location location = event.getLocation();
        if (location != null) {
            return XmlError.forLocation(str, i, location.getSystemId(), location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
        return XmlError.forMessage(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSavePoint(ConstraintState constraintState) {
        if (!this._elementStack._hasConstraints) {
            this._elementStack._savePoint = constraintState;
        }
        this._elementStack._hasConstraints = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static XmlObject newValue(SchemaType schemaType, String str) {
        try {
            return schemaType.newValue(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static SchemaType getSimpleType(SchemaType schemaType) {
        while (!schemaType.isSimpleType()) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    static boolean hasSimpleContent(SchemaType schemaType) {
        return schemaType.isSimpleType() || schemaType.getContentType() == 2;
    }

    public abstract class ConstraintState {
        ConstraintState _next;

        abstract void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str);

        abstract void element(ValidatorListener.Event event, SchemaType schemaType);

        abstract void endElement(ValidatorListener.Event event);

        abstract void remove(ValidatorListener.Event event);

        abstract void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z);

        ConstraintState() {
            IdentityConstraint.this.setSavePoint(IdentityConstraint.this._constraintStack);
            this._next = IdentityConstraint.this._constraintStack;
            IdentityConstraint.this._constraintStack = this;
        }
    }

    public class SelectorState extends ConstraintState {
        SchemaIdentityConstraint _constraint;
        XPath.ExecutionContext _context;
        Set _values;

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z) {
        }

        SelectorState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
            super();
            this._values = new LinkedHashSet();
            this._constraint = schemaIdentityConstraint;
            XPath.ExecutionContext executionContext = new XPath.ExecutionContext();
            this._context = executionContext;
            executionContext.init((XPath) this._constraint.getSelectorPath());
            if ((this._context.start() & 1) != 0) {
                createFieldState(event, schemaType);
            }
        }

        void addFields(XmlObjectList xmlObjectList, ValidatorListener.Event event) {
            if (this._constraint.getConstraintCategory() == 2) {
                this._values.add(xmlObjectList);
                return;
            }
            if (this._values.contains(xmlObjectList)) {
                if (this._constraint.getConstraintCategory() == 3) {
                    IdentityConstraint.this.emitError(event, "cvc-identity-constraint.4.1", new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
                    return;
                } else {
                    IdentityConstraint.this.emitError(event, "cvc-identity-constraint.4.2.2", new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
                    return;
                }
            }
            this._values.add(xmlObjectList);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event event, SchemaType schemaType) {
            if ((this._context.element(event.getName()) & 1) != 0) {
                createFieldState(event, schemaType);
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event event) {
            this._context.end();
        }

        void createFieldState(ValidatorListener.Event event, SchemaType schemaType) {
            IdentityConstraint.this.new FieldState(this, event, schemaType);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event event) {
            for (ConstraintState constraintState = this._next; constraintState != null; constraintState = constraintState._next) {
                if (constraintState instanceof KeyrefState) {
                    KeyrefState keyrefState = (KeyrefState) constraintState;
                    if (keyrefState._constraint.getReferencedKey() == this._constraint) {
                        keyrefState.addKeyValues(this._values, true);
                    }
                }
            }
        }
    }

    public class KeyrefState extends SelectorState {
        private Object CHILD_ADDED;
        private Object CHILD_REMOVED;
        private Object SELF_ADDED;
        Map _keyValues;

        KeyrefState(SchemaIdentityConstraint schemaIdentityConstraint, ValidatorListener.Event event, SchemaType schemaType) {
            super(schemaIdentityConstraint, event, schemaType);
            this._keyValues = new HashMap();
            this.CHILD_ADDED = new Object();
            this.CHILD_REMOVED = new Object();
            this.SELF_ADDED = new Object();
        }

        void addKeyValues(Set set, boolean z) {
            for (Object obj : set) {
                Object obj2 = this._keyValues.get(obj);
                if (obj2 == null) {
                    this._keyValues.put(obj, z ? this.CHILD_ADDED : this.SELF_ADDED);
                } else if (obj2 == this.CHILD_ADDED) {
                    if (z) {
                        this._keyValues.put(obj, this.CHILD_REMOVED);
                    } else {
                        this._keyValues.put(obj, this.SELF_ADDED);
                    }
                } else if (obj2 == this.CHILD_REMOVED && !z) {
                    this._keyValues.put(obj, this.SELF_ADDED);
                }
            }
        }

        private boolean hasKeyValue(Object obj) {
            Object obj2 = this._keyValues.get(obj);
            return (obj2 == null || obj2 == this.CHILD_REMOVED) ? false : true;
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.SelectorState, org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event event) {
            for (ConstraintState constraintState = this._next; constraintState != null && constraintState != IdentityConstraint.this._elementStack._savePoint; constraintState = constraintState._next) {
                if (constraintState instanceof SelectorState) {
                    SelectorState selectorState = (SelectorState) constraintState;
                    if (selectorState._constraint == this._constraint.getReferencedKey()) {
                        addKeyValues(selectorState._values, false);
                    }
                }
            }
            for (XmlObjectList xmlObjectList : this._values) {
                if (xmlObjectList.unfilled() < 0 && !hasKeyValue(xmlObjectList)) {
                    IdentityConstraint.this.emitError(event, "cvc-identity-constraint.4.3", new Object[]{xmlObjectList, QNameHelper.pretty(this._constraint.getName())});
                    return;
                }
            }
        }
    }

    public class FieldState extends ConstraintState {
        XPath.ExecutionContext[] _contexts;
        boolean[] _needsValue;
        SelectorState _selector;
        XmlObjectList _value;

        FieldState(SelectorState selectorState, ValidatorListener.Event event, SchemaType schemaType) {
            super();
            this._selector = selectorState;
            SchemaIdentityConstraint schemaIdentityConstraint = selectorState._constraint;
            int length = schemaIdentityConstraint.getFields().length;
            this._contexts = new XPath.ExecutionContext[length];
            this._needsValue = new boolean[length];
            this._value = new XmlObjectList(length);
            for (int i = 0; i < length; i++) {
                this._contexts[i] = new XPath.ExecutionContext();
                this._contexts[i].init((XPath) schemaIdentityConstraint.getFieldPath(i));
                if ((this._contexts[i].start() & 1) != 0) {
                    if (!IdentityConstraint.hasSimpleContent(schemaType)) {
                        IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    } else {
                        this._needsValue[i] = true;
                    }
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event event, SchemaType schemaType) {
            int i = 0;
            for (int i2 = 0; i2 < this._contexts.length; i2++) {
                if (this._needsValue[i2]) {
                    IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    this._needsValue[i2] = false;
                }
            }
            while (true) {
                XPath.ExecutionContext[] executionContextArr = this._contexts;
                if (i >= executionContextArr.length) {
                    return;
                }
                if ((executionContextArr[i].element(event.getName()) & 1) != 0) {
                    if (!IdentityConstraint.hasSimpleContent(schemaType)) {
                        IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                    } else {
                        this._needsValue[i] = true;
                    }
                }
                i++;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            if (str == null) {
                return;
            }
            int i = 0;
            while (true) {
                XPath.ExecutionContext[] executionContextArr = this._contexts;
                if (i >= executionContextArr.length) {
                    return;
                }
                if (executionContextArr[i].attr(qName)) {
                    XmlObject xmlObjectNewValue = IdentityConstraint.newValue(schemaType, str);
                    if (xmlObjectNewValue == null) {
                        return;
                    }
                    if (!this._value.set(xmlObjectNewValue, i)) {
                        IdentityConstraint.this.emitError(event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[i] + "' for a selector");
                    }
                }
                i++;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z) {
            if (str != null || z) {
                for (int i = 0; i < this._contexts.length; i++) {
                    if (this._needsValue[i]) {
                        if (z || !IdentityConstraint.hasSimpleContent(schemaType)) {
                            IdentityConstraint.this.emitError(event, "Identity constraint field must have simple content");
                            return;
                        }
                        XmlObject xmlObjectNewValue = IdentityConstraint.newValue(IdentityConstraint.getSimpleType(schemaType), str);
                        if (xmlObjectNewValue == null) {
                            return;
                        }
                        if (!this._value.set(xmlObjectNewValue, i)) {
                            IdentityConstraint.this.emitError(event, "Multiple instances of field with xpath: '" + this._selector._constraint.getFields()[i] + "' for a selector");
                        }
                    }
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event event) {
            for (int i = 0; i < this._needsValue.length; i++) {
                this._contexts[i].end();
                this._needsValue[i] = false;
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event event) {
            if (this._selector._constraint.getConstraintCategory() == 1 && this._value.unfilled() >= 0) {
                IdentityConstraint.this.emitError(event, "Key " + QNameHelper.pretty(this._selector._constraint.getName()) + " is missing field with xpath: '" + this._selector._constraint.getFields()[this._value.unfilled()] + "'");
            } else {
                this._selector.addFields(this._value, event);
            }
        }
    }

    public class IdState extends ConstraintState {
        Set _values;

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event event, SchemaType schemaType) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event event) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event event) {
        }

        IdState() {
            super();
            this._values = new LinkedHashSet();
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z) {
            if (z) {
                return;
            }
            handleValue(event, schemaType, str);
        }

        private void handleValue(ValidatorListener.Event event, SchemaType schemaType, String str) {
            if (str == null || schemaType == null || schemaType.isNoType() || !XmlID.type.isAssignableFrom(schemaType)) {
                return;
            }
            XmlObjectList xmlObjectList = new XmlObjectList(1);
            XmlObject xmlObjectNewValue = IdentityConstraint.newValue(XmlID.type, str);
            if (xmlObjectNewValue == null) {
                return;
            }
            xmlObjectList.set(xmlObjectNewValue, 0);
            if (this._values.contains(xmlObjectList)) {
                IdentityConstraint.this.emitError(event, "cvc-id.2", new Object[]{str});
            } else {
                this._values.add(xmlObjectList);
            }
        }
    }

    public class IdRefState extends ConstraintState {
        IdState _ids;
        List _values;

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void element(ValidatorListener.Event event, SchemaType schemaType) {
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void endElement(ValidatorListener.Event event) {
        }

        IdRefState(IdState idState) {
            super();
            this._ids = idState;
            this._values = new ArrayList();
        }

        private void handleValue(ValidatorListener.Event event, SchemaType schemaType, String str) {
            if (str == null || schemaType == null || schemaType.isNoType()) {
                return;
            }
            if (XmlIDREFS.type.isAssignableFrom(schemaType)) {
                XmlIDREFS xmlIDREFSNewValue = IdentityConstraint.newValue(XmlIDREFS.type, str);
                if (xmlIDREFSNewValue == null) {
                    return;
                }
                List listXgetListValue = xmlIDREFSNewValue.xgetListValue();
                for (int i = 0; i < listXgetListValue.size(); i++) {
                    XmlObjectList xmlObjectList = new XmlObjectList(1);
                    xmlObjectList.set((XmlIDREF) listXgetListValue.get(i), 0);
                    this._values.add(xmlObjectList);
                }
                return;
            }
            if (XmlIDREF.type.isAssignableFrom(schemaType)) {
                XmlObjectList xmlObjectList2 = new XmlObjectList(1);
                XmlIDREF xmlIDREFNewValue = schemaType.newValue(str);
                if (xmlIDREFNewValue == null) {
                    return;
                }
                xmlObjectList2.set(xmlIDREFNewValue, 0);
                this._values.add(xmlObjectList2);
            }
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void attr(ValidatorListener.Event event, QName qName, SchemaType schemaType, String str) {
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void text(ValidatorListener.Event event, SchemaType schemaType, String str, boolean z) {
            if (z) {
                return;
            }
            handleValue(event, schemaType, str);
        }

        @Override // org.apache.xmlbeans.impl.common.IdentityConstraint.ConstraintState
        void remove(ValidatorListener.Event event) {
            for (Object obj : this._values) {
                if (!this._ids._values.contains(obj)) {
                    IdentityConstraint.this.emitError(event, "ID not found for IDRef value '" + obj + "'");
                }
            }
        }
    }

    private static class ElementState {
        boolean _hasConstraints;
        ElementState _next;
        ConstraintState _savePoint;

        private ElementState() {
        }
    }
}
