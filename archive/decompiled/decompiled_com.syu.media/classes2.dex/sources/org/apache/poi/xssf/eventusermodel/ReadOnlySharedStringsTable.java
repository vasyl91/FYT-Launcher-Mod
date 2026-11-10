package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ReadOnlySharedStringsTable extends DefaultHandler {
    private StringBuffer characters;
    private int count;
    private boolean inRPh;
    private final boolean includePhoneticRuns;
    private Map<Integer, String> phoneticStrings;
    private List<String> strings;
    private boolean tIsOpen;
    private int uniqueCount;

    public ReadOnlySharedStringsTable(OPCPackage oPCPackage) throws SAXException, IOException {
        this(oPCPackage, true);
    }

    public ReadOnlySharedStringsTable(OPCPackage oPCPackage, boolean z) throws SAXException, IOException {
        this.includePhoneticRuns = z;
        ArrayList<PackagePart> partsByContentType = oPCPackage.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        if (partsByContentType.size() > 0) {
            readFrom(partsByContentType.get(0).getInputStream());
        }
    }

    public ReadOnlySharedStringsTable(PackagePart packagePart) throws SAXException, IOException {
        this(packagePart, true);
    }

    public ReadOnlySharedStringsTable(PackagePart packagePart, boolean z) throws SAXException, IOException {
        this.includePhoneticRuns = z;
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws SAXException, IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 1);
        int i = pushbackInputStream.read();
        if (i > -1) {
            pushbackInputStream.unread(i);
            InputSource inputSource = new InputSource(pushbackInputStream);
            try {
                XMLReader xMLReaderNewXMLReader = SAXHelper.newXMLReader();
                xMLReaderNewXMLReader.setContentHandler(this);
                xMLReaderNewXMLReader.parse(inputSource);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException("SAX parser appears to be broken - " + e.getMessage());
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    public int getUniqueCount() {
        return this.uniqueCount;
    }

    public String getEntryAt(int i) {
        return this.strings.get(i);
    }

    public List<String> getItems() {
        return this.strings;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if ("sst".equals(str2)) {
                String value = attributes.getValue("count");
                if (value != null) {
                    this.count = Integer.parseInt(value);
                }
                String value2 = attributes.getValue("uniqueCount");
                if (value2 != null) {
                    this.uniqueCount = Integer.parseInt(value2);
                }
                this.strings = new ArrayList(this.uniqueCount);
                this.phoneticStrings = new HashMap();
                this.characters = new StringBuffer();
                return;
            }
            if ("si".equals(str2)) {
                this.characters.setLength(0);
                return;
            }
            if ("t".equals(str2)) {
                this.tIsOpen = true;
                return;
            }
            if ("rPh".equals(str2)) {
                this.inRPh = true;
                if (!this.includePhoneticRuns || this.characters.length() <= 0) {
                    return;
                }
                this.characters.append(" ");
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (str == null || str.equals(XSSFRelation.NS_SPREADSHEETML)) {
            if ("si".equals(str2)) {
                this.strings.add(this.characters.toString());
            } else if ("t".equals(str2)) {
                this.tIsOpen = false;
            } else if ("rPh".equals(str2)) {
                this.inRPh = false;
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.tIsOpen) {
            boolean z = this.inRPh;
            if (z && this.includePhoneticRuns) {
                this.characters.append(cArr, i, i2);
            } else {
                if (z) {
                    return;
                }
                this.characters.append(cArr, i, i2);
            }
        }
    }
}
