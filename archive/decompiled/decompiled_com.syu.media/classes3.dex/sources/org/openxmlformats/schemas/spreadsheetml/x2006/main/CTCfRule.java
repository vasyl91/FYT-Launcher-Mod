package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTCfRule extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTCfRule.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcfrule3548type");

    public static final class Factory {
        private Factory() {
        }

        public static CTCfRule newInstance() {
            return (CTCfRule) POIXMLTypeLoader.newInstance(CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule newInstance(XmlOptions xmlOptions) {
            return (CTCfRule) POIXMLTypeLoader.newInstance(CTCfRule.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCfRule.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(File file) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(file, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(file, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(InputStream inputStream) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(inputStream, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(inputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(Reader reader) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(reader, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(reader, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(String str) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(str, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(str, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(URL url) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(url, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTCfRule) POIXMLTypeLoader.parse(url, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(xMLStreamReader, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(xMLStreamReader, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(xMLInputStream, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(xMLInputStream, CTCfRule.type, xmlOptions);
        }

        public static CTCfRule parse(Node node) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(node, CTCfRule.type, (XmlOptions) null);
        }

        public static CTCfRule parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTCfRule) POIXMLTypeLoader.parse(node, CTCfRule.type, xmlOptions);
        }
    }

    void addFormula(String str);

    CTColorScale addNewColorScale();

    CTDataBar addNewDataBar();

    CTExtensionList addNewExtLst();

    STFormula addNewFormula();

    CTIconSet addNewIconSet();

    boolean getAboveAverage();

    boolean getBottom();

    CTColorScale getColorScale();

    CTDataBar getDataBar();

    long getDxfId();

    boolean getEqualAverage();

    CTExtensionList getExtLst();

    String getFormulaArray(int i);

    String[] getFormulaArray();

    List<String> getFormulaList();

    CTIconSet getIconSet();

    STConditionalFormattingOperator.Enum getOperator();

    boolean getPercent();

    int getPriority();

    long getRank();

    int getStdDev();

    boolean getStopIfTrue();

    String getText();

    STTimePeriod$Enum getTimePeriod();

    STCfType.Enum getType();

    void insertFormula(int i, String str);

    STFormula insertNewFormula(int i);

    boolean isSetAboveAverage();

    boolean isSetBottom();

    boolean isSetColorScale();

    boolean isSetDataBar();

    boolean isSetDxfId();

    boolean isSetEqualAverage();

    boolean isSetExtLst();

    boolean isSetIconSet();

    boolean isSetOperator();

    boolean isSetPercent();

    boolean isSetRank();

    boolean isSetStdDev();

    boolean isSetStopIfTrue();

    boolean isSetText();

    boolean isSetTimePeriod();

    boolean isSetType();

    void removeFormula(int i);

    void setAboveAverage(boolean z);

    void setBottom(boolean z);

    void setColorScale(CTColorScale cTColorScale);

    void setDataBar(CTDataBar cTDataBar);

    void setDxfId(long j);

    void setEqualAverage(boolean z);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFormulaArray(int i, String str);

    void setFormulaArray(String[] strArr);

    void setIconSet(CTIconSet cTIconSet);

    void setOperator(STConditionalFormattingOperator.Enum r1);

    void setPercent(boolean z);

    void setPriority(int i);

    void setRank(long j);

    void setStdDev(int i);

    void setStopIfTrue(boolean z);

    void setText(String str);

    void setTimePeriod(STTimePeriod$Enum sTTimePeriod$Enum);

    void setType(STCfType.Enum r1);

    int sizeOfFormulaArray();

    void unsetAboveAverage();

    void unsetBottom();

    void unsetColorScale();

    void unsetDataBar();

    void unsetDxfId();

    void unsetEqualAverage();

    void unsetExtLst();

    void unsetIconSet();

    void unsetOperator();

    void unsetPercent();

    void unsetRank();

    void unsetStdDev();

    void unsetStopIfTrue();

    void unsetText();

    void unsetTimePeriod();

    void unsetType();

    XmlBoolean xgetAboveAverage();

    XmlBoolean xgetBottom();

    STDxfId xgetDxfId();

    XmlBoolean xgetEqualAverage();

    STFormula xgetFormulaArray(int i);

    STFormula[] xgetFormulaArray();

    List<STFormula> xgetFormulaList();

    STConditionalFormattingOperator xgetOperator();

    XmlBoolean xgetPercent();

    XmlInt xgetPriority();

    XmlUnsignedInt xgetRank();

    XmlInt xgetStdDev();

    XmlBoolean xgetStopIfTrue();

    XmlString xgetText();

    STTimePeriod xgetTimePeriod();

    STCfType xgetType();

    void xsetAboveAverage(XmlBoolean xmlBoolean);

    void xsetBottom(XmlBoolean xmlBoolean);

    void xsetDxfId(STDxfId sTDxfId);

    void xsetEqualAverage(XmlBoolean xmlBoolean);

    void xsetFormulaArray(int i, STFormula sTFormula);

    void xsetFormulaArray(STFormula[] sTFormulaArr);

    void xsetOperator(STConditionalFormattingOperator sTConditionalFormattingOperator);

    void xsetPercent(XmlBoolean xmlBoolean);

    void xsetPriority(XmlInt xmlInt);

    void xsetRank(XmlUnsignedInt xmlUnsignedInt);

    void xsetStdDev(XmlInt xmlInt);

    void xsetStopIfTrue(XmlBoolean xmlBoolean);

    void xsetText(XmlString xmlString);

    void xsetTimePeriod(STTimePeriod sTTimePeriod);

    void xsetType(STCfType sTCfType);
}
