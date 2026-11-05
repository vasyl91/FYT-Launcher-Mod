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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface RestrictionDocument extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(RestrictionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restriction0049doctype");

    Restriction addNewRestriction();

    Restriction getRestriction();

    void setRestriction(Restriction restriction);

    public interface Restriction extends Annotated {
        public static final SchemaType type = XmlBeans.typeSystemForClassLoader(Restriction.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLSCHEMA").resolveHandle("restrictionad11elemtype");

        NoFixedFacet addNewEnumeration();

        NumFacet addNewFractionDigits();

        NumFacet addNewLength();

        Facet addNewMaxExclusive();

        Facet addNewMaxInclusive();

        NumFacet addNewMaxLength();

        Facet addNewMinExclusive();

        Facet addNewMinInclusive();

        NumFacet addNewMinLength();

        PatternDocument.Pattern addNewPattern();

        LocalSimpleType addNewSimpleType();

        TotalDigitsDocument.TotalDigits addNewTotalDigits();

        WhiteSpaceDocument.WhiteSpace addNewWhiteSpace();

        QName getBase();

        NoFixedFacet getEnumerationArray(int i);

        NoFixedFacet[] getEnumerationArray();

        NumFacet getFractionDigitsArray(int i);

        NumFacet[] getFractionDigitsArray();

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

        LocalSimpleType getSimpleType();

        TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i);

        TotalDigitsDocument.TotalDigits[] getTotalDigitsArray();

        WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i);

        WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray();

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

        boolean isSetBase();

        boolean isSetSimpleType();

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

        void setBase(QName qName);

        void setEnumerationArray(int i, NoFixedFacet noFixedFacet);

        void setEnumerationArray(NoFixedFacet[] noFixedFacetArr);

        void setFractionDigitsArray(int i, NumFacet numFacet);

        void setFractionDigitsArray(NumFacet[] numFacetArr);

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

        void setSimpleType(LocalSimpleType localSimpleType);

        void setTotalDigitsArray(int i, TotalDigitsDocument.TotalDigits totalDigits);

        void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr);

        void setWhiteSpaceArray(int i, WhiteSpaceDocument.WhiteSpace whiteSpace);

        void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr);

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

        void unsetBase();

        void unsetSimpleType();

        XmlQName xgetBase();

        void xsetBase(XmlQName xmlQName);

        public static final class Factory {
            public static Restriction newInstance() {
                return (Restriction) XmlBeans.getContextTypeLoader().newInstance(Restriction.type, (XmlOptions) null);
            }

            public static Restriction newInstance(XmlOptions xmlOptions) {
                return (Restriction) XmlBeans.getContextTypeLoader().newInstance(Restriction.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static RestrictionDocument newInstance() {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument newInstance(XmlOptions xmlOptions) {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().newInstance(RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(String str) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(str, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(str, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(File file) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(file, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(file, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(URL url) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(url, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(url, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(InputStream inputStream) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(inputStream, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(Reader reader) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(reader, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(reader, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(Node node) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(node, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(node, RestrictionDocument.type, xmlOptions);
        }

        public static RestrictionDocument parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RestrictionDocument.type, (XmlOptions) null);
        }

        public static RestrictionDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (RestrictionDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, RestrictionDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RestrictionDocument.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, RestrictionDocument.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
