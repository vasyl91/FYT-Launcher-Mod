package org.apache.xmlbeans.impl.xb.xsdschema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface RestrictionType extends Annotated {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RestrictionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restrictiontype939ftype");

    All addNewAll();

    Wildcard addNewAnyAttribute();

    Attribute addNewAttribute();

    AttributeGroupRef addNewAttributeGroup();

    ExplicitGroup addNewChoice();

    NoFixedFacet addNewEnumeration();

    NumFacet addNewFractionDigits();

    GroupRef addNewGroup();

    NumFacet addNewLength();

    Facet addNewMaxExclusive();

    Facet addNewMaxInclusive();

    NumFacet addNewMaxLength();

    Facet addNewMinExclusive();

    Facet addNewMinInclusive();

    NumFacet addNewMinLength();

    PatternDocument.Pattern addNewPattern();

    ExplicitGroup addNewSequence();

    LocalSimpleType addNewSimpleType();

    TotalDigitsDocument.TotalDigits addNewTotalDigits();

    WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();

    All getAll();

    Wildcard getAnyAttribute();

    Attribute getAttributeArray(int i);

    Attribute[] getAttributeArray();

    AttributeGroupRef getAttributeGroupArray(int i);

    AttributeGroupRef[] getAttributeGroupArray();

    QName getBase();

    ExplicitGroup getChoice();

    NoFixedFacet getEnumerationArray(int i);

    NoFixedFacet[] getEnumerationArray();

    NumFacet getFractionDigitsArray(int i);

    NumFacet[] getFractionDigitsArray();

    GroupRef getGroup();

    NumFacet getLengthArray(int i);

    NumFacet[] getLengthArray();

    Facet getMaxExclusiveArray(int i);

    Facet[] getMaxExclusiveArray();

    Facet getMaxInclusiveArray(int i);

    Facet[] getMaxInclusiveArray();

    NumFacet getMaxLengthArray(int i);

    NumFacet[] getMaxLengthArray();

    Facet getMinExclusiveArray(int i);

    Facet[] getMinExclusiveArray();

    Facet getMinInclusiveArray(int i);

    Facet[] getMinInclusiveArray();

    NumFacet getMinLengthArray(int i);

    NumFacet[] getMinLengthArray();

    PatternDocument.Pattern getPatternArray(int i);

    PatternDocument.Pattern[] getPatternArray();

    ExplicitGroup getSequence();

    LocalSimpleType getSimpleType();

    TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i);

    TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();

    WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i);

    WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();

    Attribute insertNewAttribute(int i);

    AttributeGroupRef insertNewAttributeGroup(int i);

    NoFixedFacet insertNewEnumeration(int i);

    NumFacet insertNewFractionDigits(int i);

    NumFacet insertNewLength(int i);

    Facet insertNewMaxExclusive(int i);

    Facet insertNewMaxInclusive(int i);

    NumFacet insertNewMaxLength(int i);

    Facet insertNewMinExclusive(int i);

    Facet insertNewMinInclusive(int i);

    NumFacet insertNewMinLength(int i);

    PatternDocument.Pattern insertNewPattern(int i);

    TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i);

    WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i);

    boolean isSetAll();

    boolean isSetAnyAttribute();

    boolean isSetChoice();

    boolean isSetGroup();

    boolean isSetSequence();

    boolean isSetSimpleType();

    void removeAttribute(int i);

    void removeAttributeGroup(int i);

    void removeEnumeration(int i);

    void removeFractionDigits(int i);

    void removeLength(int i);

    void removeMaxExclusive(int i);

    void removeMaxInclusive(int i);

    void removeMaxLength(int i);

    void removeMinExclusive(int i);

    void removeMinInclusive(int i);

    void removeMinLength(int i);

    void removePattern(int i);

    void removeTotalDigits(int i);

    void removeWhiteSpace(int i);

    void setAll(All all);

    void setAnyAttribute(Wildcard wildcard);

    void setAttributeArray(int i, Attribute attribute);

    void setAttributeArray(Attribute[] attributeArr);

    void setAttributeGroupArray(int i, AttributeGroupRef attributeGroupRef);

    void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr);

    void setBase(QName qName);

    void setChoice(ExplicitGroup explicitGroup);

    void setEnumerationArray(int i, NoFixedFacet noFixedFacet);

    void setEnumerationArray(NoFixedFacet[] noFixedFacetArr);

    void setFractionDigitsArray(int i, NumFacet numFacet);

    void setFractionDigitsArray(NumFacet[] numFacetArr);

    void setGroup(GroupRef groupRef);

    void setLengthArray(int i, NumFacet numFacet);

    void setLengthArray(NumFacet[] numFacetArr);

    void setMaxExclusiveArray(int i, Facet facet);

    void setMaxExclusiveArray(Facet[] facetArr);

    void setMaxInclusiveArray(int i, Facet facet);

    void setMaxInclusiveArray(Facet[] facetArr);

    void setMaxLengthArray(int i, NumFacet numFacet);

    void setMaxLengthArray(NumFacet[] numFacetArr);

    void setMinExclusiveArray(int i, Facet facet);

    void setMinExclusiveArray(Facet[] facetArr);

    void setMinInclusiveArray(int i, Facet facet);

    void setMinInclusiveArray(Facet[] facetArr);

    void setMinLengthArray(int i, NumFacet numFacet);

    void setMinLengthArray(NumFacet[] numFacetArr);

    void setPatternArray(int i, PatternDocument.Pattern pattern);

    void setPatternArray(PatternDocument.Pattern[] patternArr);

    void setSequence(ExplicitGroup explicitGroup);

    void setSimpleType(LocalSimpleType localSimpleType);

    void setTotalDigitsArray(int i, TotalDigitsDocument.TotalDigits totalDigits);

    void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr);

    void setWhiteSpaceArray(int i, WhiteSpaceDocument.WhiteSpace whiteSpace);

    void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr);

    int sizeOfAttributeArray();

    int sizeOfAttributeGroupArray();

    int sizeOfEnumerationArray();

    int sizeOfFractionDigitsArray();

    int sizeOfLengthArray();

    int sizeOfMaxExclusiveArray();

    int sizeOfMaxInclusiveArray();

    int sizeOfMaxLengthArray();

    int sizeOfMinExclusiveArray();

    int sizeOfMinInclusiveArray();

    int sizeOfMinLengthArray();

    int sizeOfPatternArray();

    int sizeOfTotalDigitsArray();

    int sizeOfWhiteSpaceArray();

    void unsetAll();

    void unsetAnyAttribute();

    void unsetChoice();

    void unsetGroup();

    void unsetSequence();

    void unsetSimpleType();

    XmlQName xgetBase();

    void xsetBase(XmlQName xmlQName);

    public static final class Factory {
        public static RestrictionType newInstance() {
            return (RestrictionType) XmlBeans.getContextTypeLoader().newInstance(RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType newInstance(XmlOptions xmlOptions) {
            return (RestrictionType) XmlBeans.getContextTypeLoader().newInstance(RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(String str) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(str, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(str, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(File file) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(file, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(file, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(URL url) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(url, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(url, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(InputStream inputStream) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(inputStream, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(Reader reader) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(reader, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(reader, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(Node node) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(node, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(node, RestrictionType.type, xmlOptions);
        }

        public static RestrictionType parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RestrictionType.type, (XmlOptions) null);
        }

        public static RestrictionType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RestrictionType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RestrictionType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RestrictionType.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RestrictionType.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
