package org.apache.xmlbeans.impl.inst2xsd.util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TypeSystemHolder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Map _globalElements = new LinkedHashMap();
    Map _globalAttributes = new LinkedHashMap();
    Map _globalTypes = new LinkedHashMap();

    public void addGlobalElement(Element element) {
        this._globalElements.put(element.getName(), element);
    }

    public Element getGlobalElement(QName qName) {
        return (Element) this._globalElements.get(qName);
    }

    public Element[] getGlobalElements() {
        Collection collectionValues = this._globalElements.values();
        return (Element[]) collectionValues.toArray(new Element[collectionValues.size()]);
    }

    public void addGlobalAttribute(Attribute attribute) {
        this._globalAttributes.put(attribute.getName(), attribute);
    }

    public Attribute getGlobalAttribute(QName qName) {
        return (Attribute) this._globalAttributes.get(qName);
    }

    public Attribute[] getGlobalAttributes() {
        Collection collectionValues = this._globalAttributes.values();
        return (Attribute[]) collectionValues.toArray(new Attribute[collectionValues.size()]);
    }

    public void addGlobalType(Type type) {
        this._globalTypes.put(type.getName(), type);
    }

    public Type getGlobalType(QName qName) {
        return (Type) this._globalTypes.get(qName);
    }

    public Type[] getGlobalTypes() {
        Collection collectionValues = this._globalTypes.values();
        return (Type[]) collectionValues.toArray(new Type[collectionValues.size()]);
    }

    public SchemaDocument[] getSchemaDocuments() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (QName qName : this._globalElements.keySet()) {
            String namespaceURI = qName.getNamespaceURI();
            fillUpGlobalElement((Element) this._globalElements.get(qName), getSchemaDocumentForTNS(linkedHashMap, namespaceURI), namespaceURI);
        }
        for (QName qName2 : this._globalAttributes.keySet()) {
            String namespaceURI2 = qName2.getNamespaceURI();
            fillUpGlobalAttribute((Attribute) this._globalAttributes.get(qName2), getSchemaDocumentForTNS(linkedHashMap, namespaceURI2), namespaceURI2);
        }
        for (QName qName3 : this._globalTypes.keySet()) {
            String namespaceURI3 = qName3.getNamespaceURI();
            fillUpGlobalType((Type) this._globalTypes.get(qName3), getSchemaDocumentForTNS(linkedHashMap, namespaceURI3), namespaceURI3);
        }
        Collection collectionValues = linkedHashMap.values();
        return (SchemaDocument[]) collectionValues.toArray(new SchemaDocument[collectionValues.size()]);
    }

    private static SchemaDocument getSchemaDocumentForTNS(Map map, String str) {
        SchemaDocument schemaDocument = (SchemaDocument) map.get(str);
        if (schemaDocument != null) {
            return schemaDocument;
        }
        SchemaDocument schemaDocumentNewInstance = SchemaDocument.Factory.newInstance();
        map.put(str, schemaDocumentNewInstance);
        return schemaDocumentNewInstance;
    }

    private static SchemaDocument.Schema getTopLevelSchemaElement(SchemaDocument schemaDocument, String str) {
        SchemaDocument.Schema schema = schemaDocument.getSchema();
        if (schema == null) {
            schema = schemaDocument.addNewSchema();
            schema.setAttributeFormDefault(FormChoice.Enum.forString("unqualified"));
            schema.setElementFormDefault(FormChoice.Enum.forString("qualified"));
            if (!str.equals("")) {
                schema.setTargetNamespace(str);
            }
        }
        return schema;
    }

    private void fillUpGlobalElement(Element element, SchemaDocument schemaDocument, String str) {
        TopLevelElement topLevelElementAddNewElement = getTopLevelSchemaElement(schemaDocument, str).addNewElement();
        topLevelElementAddNewElement.setName(element.getName().getLocalPart());
        if (element.isNillable()) {
            topLevelElementAddNewElement.setNillable(element.isNillable());
        }
        fillUpElementDocumentation(topLevelElementAddNewElement, element.getComment());
        fillUpTypeOnElement(element.getType(), topLevelElementAddNewElement, str);
    }

    protected void fillUpLocalElement(Element element, LocalElement localElement, String str) {
        fillUpElementDocumentation(localElement, element.getComment());
        if (!element.isRef()) {
            fillUpTypeOnElement(element.getType(), localElement, str);
            localElement.setName(element.getName().getLocalPart());
        } else {
            localElement.setRef(element.getName());
        }
        if (element.getMaxOccurs() == -1) {
            localElement.setMaxOccurs("unbounded");
        }
        if (element.getMinOccurs() != 1) {
            localElement.setMinOccurs(new BigInteger("" + element.getMinOccurs()));
        }
        if (element.isNillable()) {
            localElement.setNillable(element.isNillable());
        }
    }

    private void fillUpTypeOnElement(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (type.isGlobal()) {
            element.setType(type.getName());
            return;
        }
        if (type.getContentType() == 1) {
            if (type.isEnumeration()) {
                fillUpEnumeration(type, element);
                return;
            } else {
                element.setType(type.getName());
                return;
            }
        }
        fillUpContentForComplexType(type, element.addNewComplexType(), str);
    }

    private void fillUpEnumeration(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element) {
        RestrictionDocument.Restriction restrictionAddNewRestriction = element.addNewSimpleType().addNewRestriction();
        restrictionAddNewRestriction.setBase(type.getName());
        int i = 0;
        if (type.isQNameEnumeration()) {
            while (i < type.getEnumerationQNames().size()) {
                QName qName = (QName) type.getEnumerationQNames().get(i);
                XmlQName.Factory.newValue(qName);
                NoFixedFacet noFixedFacetAddNewEnumeration = restrictionAddNewRestriction.addNewEnumeration();
                XmlCursor xmlCursorNewCursor = noFixedFacetAddNewEnumeration.newCursor();
                String strPrefixForNamespace = xmlCursorNewCursor.prefixForNamespace(qName.getNamespaceURI());
                xmlCursorNewCursor.dispose();
                noFixedFacetAddNewEnumeration.setValue(XmlQName.Factory.newValue(new QName(qName.getNamespaceURI(), qName.getLocalPart(), strPrefixForNamespace)));
                i++;
            }
            return;
        }
        while (i < type.getEnumerationValues().size()) {
            restrictionAddNewRestriction.addNewEnumeration().setValue(XmlString.Factory.newValue((String) type.getEnumerationValues().get(i)));
            i++;
        }
    }

    private void fillUpAttributesInComplexTypesSimpleContent(Type type, SimpleExtensionType simpleExtensionType, String str) {
        for (int i = 0; i < type.getAttributes().size(); i++) {
            fillUpLocalAttribute((Attribute) type.getAttributes().get(i), simpleExtensionType.addNewAttribute(), str);
        }
    }

    private void fillUpAttributesInComplexTypesComplexContent(Type type, ComplexType complexType, String str) {
        for (int i = 0; i < type.getAttributes().size(); i++) {
            fillUpLocalAttribute((Attribute) type.getAttributes().get(i), complexType.addNewAttribute(), str);
        }
    }

    protected void fillUpLocalAttribute(Attribute attribute, org.apache.xmlbeans.impl.xb.xsdschema.Attribute attribute2, String str) {
        if (attribute.isRef()) {
            attribute2.setRef(attribute.getRef().getName());
            return;
        }
        attribute2.setType(attribute.getType().getName());
        attribute2.setName(attribute.getName().getLocalPart());
        if (attribute.isOptional()) {
            attribute2.setUse(org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use.OPTIONAL);
        }
    }

    protected void fillUpContentForComplexType(Type type, ComplexType complexType, String str) {
        ExplicitGroup explicitGroupAddNewChoice;
        if (type.getContentType() == 2) {
            SimpleExtensionType simpleExtensionTypeAddNewExtension = complexType.addNewSimpleContent().addNewExtension();
            simpleExtensionTypeAddNewExtension.setBase(type.getExtensionType().getName());
            fillUpAttributesInComplexTypesSimpleContent(type, simpleExtensionTypeAddNewExtension, str);
            return;
        }
        if (type.getContentType() == 4) {
            complexType.setMixed(true);
        }
        if (type.getContentType() == 5) {
            explicitGroupAddNewChoice = null;
        } else if (type.getTopParticleForComplexOrMixedContent() == 1) {
            explicitGroupAddNewChoice = complexType.addNewSequence();
        } else if (type.getTopParticleForComplexOrMixedContent() == 2) {
            explicitGroupAddNewChoice = complexType.addNewChoice();
            explicitGroupAddNewChoice.setMaxOccurs("unbounded");
            explicitGroupAddNewChoice.setMinOccurs(new BigInteger("0"));
        } else {
            throw new IllegalStateException("Unknown particle type in complex and mixed content");
        }
        for (int i = 0; i < type.getElements().size(); i++) {
            fillUpLocalElement((Element) type.getElements().get(i), explicitGroupAddNewChoice.addNewElement(), str);
        }
        fillUpAttributesInComplexTypesComplexContent(type, complexType, str);
    }

    private void fillUpGlobalAttribute(Attribute attribute, SchemaDocument schemaDocument, String str) {
        TopLevelAttribute topLevelAttributeAddNewAttribute = getTopLevelSchemaElement(schemaDocument, str).addNewAttribute();
        topLevelAttributeAddNewAttribute.setName(attribute.getName().getLocalPart());
        Type type = attribute.getType();
        if (type.getContentType() == 1) {
            topLevelAttributeAddNewAttribute.setType(type.getName());
            return;
        }
        throw new IllegalStateException();
    }

    private static void fillUpElementDocumentation(org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        element.addNewAnnotation().addNewDocumentation().set(XmlString.Factory.newValue(str));
    }

    private void fillUpGlobalType(Type type, SchemaDocument schemaDocument, String str) {
        TopLevelComplexType topLevelComplexTypeAddNewComplexType = getTopLevelSchemaElement(schemaDocument, str).addNewComplexType();
        topLevelComplexTypeAddNewComplexType.setName(type.getName().getLocalPart());
        fillUpContentForComplexType(type, topLevelComplexTypeAddNewComplexType, str);
    }

    public String toString() {
        return "TypeSystemHolder{\n\n_globalElements=" + this._globalElements + "\n\n_globalAttributes=" + this._globalAttributes + "\n\n_globalTypes=" + this._globalTypes + "\n}";
    }
}
