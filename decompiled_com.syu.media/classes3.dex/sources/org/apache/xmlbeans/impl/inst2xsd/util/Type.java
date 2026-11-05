package org.apache.xmlbeans.impl.inst2xsd.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Type {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int COMPLEX_TYPE_COMPLEX_CONTENT = 3;
    public static final int COMPLEX_TYPE_EMPTY_CONTENT = 5;
    public static final int COMPLEX_TYPE_MIXED_CONTENT = 4;
    public static final int COMPLEX_TYPE_SIMPLE_CONTENT = 2;
    public static final int PARTICLE_CHOICE_UNBOUNDED = 2;
    public static final int PARTICLE_SEQUENCE = 1;
    public static final int SIMPLE_TYPE_SIMPLE_CONTENT = 1;
    private List _attributes;
    private List _elements;
    private List _enumerationQNames;
    private List _enumerationValues;
    private Type _extensionType;
    private QName _name;
    private int _kind = 1;
    private int _topParticleForComplexOrMixedContent = 1;
    private boolean _isGlobal = $assertionsDisabled;
    private boolean _acceptsEnumerationValue = true;

    protected Type() {
    }

    public static Type createNamedType(QName qName, int i) {
        Type type = new Type();
        type.setName(qName);
        type.setContentType(i);
        return type;
    }

    public static Type createUnnamedType(int i) {
        Type type = new Type();
        type.setContentType(i);
        return type;
    }

    public QName getName() {
        return this._name;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public int getContentType() {
        return this._kind;
    }

    public void setContentType(int i) {
        this._kind = i;
    }

    public List getElements() {
        ensureElements();
        return this._elements;
    }

    public void addElement(Element element) {
        ensureElements();
        this._elements.add(element);
    }

    public void setElements(List list) {
        ensureElements();
        this._elements.clear();
        this._elements.addAll(list);
    }

    private void ensureElements() {
        if (this._elements == null) {
            this._elements = new ArrayList();
        }
    }

    public List getAttributes() {
        ensureAttributes();
        return this._attributes;
    }

    public void addAttribute(Attribute attribute) {
        ensureAttributes();
        this._attributes.add(attribute);
    }

    public Attribute getAttribute(QName qName) {
        for (int i = 0; i < this._attributes.size(); i++) {
            Attribute attribute = (Attribute) this._attributes.get(i);
            if (attribute.getName().equals(qName)) {
                return attribute;
            }
        }
        return null;
    }

    private void ensureAttributes() {
        if (this._attributes == null) {
            this._attributes = new ArrayList();
        }
    }

    public boolean isComplexType() {
        int i = this._kind;
        if (i == 3 || i == 4 || i == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    public boolean hasSimpleContent() {
        int i = this._kind;
        if (i == 1 || i == 2) {
            return true;
        }
        return $assertionsDisabled;
    }

    public int getTopParticleForComplexOrMixedContent() {
        return this._topParticleForComplexOrMixedContent;
    }

    public void setTopParticleForComplexOrMixedContent(int i) {
        this._topParticleForComplexOrMixedContent = i;
    }

    public boolean isGlobal() {
        return this._isGlobal;
    }

    public void setGlobal(boolean z) {
        this._isGlobal = z;
    }

    public Type getExtensionType() {
        return this._extensionType;
    }

    public void setExtensionType(Type type) {
        this._extensionType = type;
    }

    public List getEnumerationValues() {
        ensureEnumerationValues();
        return this._enumerationValues;
    }

    public List getEnumerationQNames() {
        ensureEnumerationValues();
        return this._enumerationQNames;
    }

    public void addEnumerationValue(String str, final XmlCursor xmlCursor) {
        ensureEnumerationValues();
        if (!this._acceptsEnumerationValue || this._enumerationValues.contains(str)) {
            return;
        }
        this._enumerationValues.add(str);
        if (this._name.equals(XmlQName.type.getName())) {
            this._enumerationQNames.add(XmlQNameImpl.validateLexical(str, null, new PrefixResolver() { // from class: org.apache.xmlbeans.impl.inst2xsd.util.Type.1
                @Override // org.apache.xmlbeans.impl.common.PrefixResolver
                public String getNamespaceForPrefix(String str2) {
                    return xmlCursor.namespaceForPrefix(str2);
                }
            }));
        }
    }

    private void ensureEnumerationValues() {
        if (this._enumerationValues == null) {
            this._enumerationValues = new ArrayList();
            this._enumerationQNames = new ArrayList();
        }
    }

    public boolean isEnumeration() {
        List list;
        if (!this._acceptsEnumerationValue || (list = this._enumerationValues) == null || list.size() <= 1) {
            return $assertionsDisabled;
        }
        return true;
    }

    public boolean isQNameEnumeration() {
        List list;
        if (!isEnumeration() || !this._name.equals(XmlQName.type.getName()) || (list = this._enumerationQNames) == null || list.size() <= 1) {
            return $assertionsDisabled;
        }
        return true;
    }

    public void closeEnumeration() {
        this._acceptsEnumerationValue = $assertionsDisabled;
    }

    public String toString() {
        return "Type{_name = " + this._name + ", _extensionType = " + this._extensionType + ", _kind = " + this._kind + ", _elements = " + this._elements + ", _attributes = " + this._attributes + "}";
    }

    public void addAllEnumerationsFrom(Type type) {
        ensureEnumerationValues();
        int i = 0;
        if (this._name.equals(XmlQName.type.getName()) && type._name.equals(XmlQName.type.getName())) {
            while (i < type.getEnumerationValues().size()) {
                String str = (String) type.getEnumerationValues().get(i);
                QName qName = (QName) type.getEnumerationQNames().get(i);
                if (this._acceptsEnumerationValue && !this._enumerationQNames.contains(qName)) {
                    this._enumerationValues.add(str);
                    this._enumerationQNames.add(qName);
                }
                i++;
            }
            return;
        }
        while (i < type.getEnumerationValues().size()) {
            String str2 = (String) type.getEnumerationValues().get(i);
            if (this._acceptsEnumerationValue && !this._enumerationValues.contains(str2)) {
                this._enumerationValues.add(str2);
            }
            i++;
        }
    }
}
