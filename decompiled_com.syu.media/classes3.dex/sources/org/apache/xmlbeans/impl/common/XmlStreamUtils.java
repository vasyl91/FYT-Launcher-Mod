package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLStreamReader;
import org.codehaus.stax2.validation.ValidatorPair;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class XmlStreamUtils {
    public static String getName(int i) {
        switch (i) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
                return "ATTRIBUTE";
            case 11:
                return "DTD";
            case 12:
                return ValidatorPair.ATTR_TYPE_DEFAULT;
            case 13:
                return "NAMESPACE";
            default:
                return "UNKNOWN_EVENT_TYPE";
        }
    }

    public static String printEvent(XMLStreamReader xMLStreamReader) {
        StringBuilder sb = new StringBuilder();
        sb.append("EVENT:[" + xMLStreamReader.getLocation().getLineNumber() + "][" + xMLStreamReader.getLocation().getColumnNumber() + "] ");
        sb.append(getName(xMLStreamReader.getEventType()));
        sb.append(" [");
        int eventType = xMLStreamReader.getEventType();
        if (eventType == 9) {
            sb.append(xMLStreamReader.getLocalName() + "=");
            if (xMLStreamReader.hasText()) {
                sb.append("[" + xMLStreamReader.getText() + "]");
            }
        } else if (eventType != 12) {
            int i = 0;
            switch (eventType) {
                case 1:
                    sb.append("<");
                    printName(xMLStreamReader, sb);
                    for (int i2 = 0; i2 < xMLStreamReader.getNamespaceCount(); i2++) {
                        sb.append(" ");
                        String namespacePrefix = xMLStreamReader.getNamespacePrefix(i2);
                        if (Sax2Dom.XMLNS_PREFIX.equals(namespacePrefix)) {
                            sb.append("xmlns=\"" + xMLStreamReader.getNamespaceURI(i2) + "\"");
                        } else {
                            sb.append(Sax2Dom.XMLNS_STRING + namespacePrefix);
                            sb.append("=\"");
                            sb.append(xMLStreamReader.getNamespaceURI(i2));
                            sb.append("\"");
                        }
                    }
                    while (i < xMLStreamReader.getAttributeCount()) {
                        sb.append(" ");
                        printName(xMLStreamReader.getAttributePrefix(i), xMLStreamReader.getAttributeNamespace(i), xMLStreamReader.getAttributeLocalName(i), sb);
                        sb.append("=\"");
                        sb.append(xMLStreamReader.getAttributeValue(i));
                        sb.append("\"");
                        i++;
                    }
                    sb.append(">");
                    break;
                case 2:
                    sb.append("</");
                    printName(xMLStreamReader, sb);
                    while (i < xMLStreamReader.getNamespaceCount()) {
                        sb.append(" ");
                        String namespacePrefix2 = xMLStreamReader.getNamespacePrefix(i);
                        if (Sax2Dom.XMLNS_PREFIX.equals(namespacePrefix2)) {
                            sb.append("xmlns=\"" + xMLStreamReader.getNamespaceURI(i) + "\"");
                        } else {
                            sb.append(Sax2Dom.XMLNS_STRING + namespacePrefix2);
                            sb.append("=\"");
                            sb.append(xMLStreamReader.getNamespaceURI(i));
                            sb.append("\"");
                        }
                        i++;
                    }
                    sb.append(">");
                    break;
                case 3:
                    String pITarget = xMLStreamReader.getPITarget();
                    if (pITarget == null) {
                        pITarget = "";
                    }
                    String pIData = xMLStreamReader.getPIData();
                    String str = pIData != null ? pIData : "";
                    sb.append("<?");
                    sb.append(pITarget + " " + str);
                    sb.append("?>");
                    break;
                case 4:
                case 6:
                    sb.append(new String(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength()));
                    break;
                case 5:
                    sb.append("<!--");
                    if (xMLStreamReader.hasText()) {
                        sb.append(xMLStreamReader.getText());
                    }
                    sb.append("-->");
                    break;
                case 7:
                    sb.append("<?xml");
                    sb.append(" version='" + xMLStreamReader.getVersion() + "'");
                    sb.append(" encoding='" + xMLStreamReader.getCharacterEncodingScheme() + "'");
                    if (xMLStreamReader.isStandalone()) {
                        sb.append(" standalone='yes'");
                    } else {
                        sb.append(" standalone='no'");
                    }
                    sb.append("?>");
                    break;
            }
        } else {
            sb.append("<![CDATA[");
            if (xMLStreamReader.hasText()) {
                sb.append(xMLStreamReader.getText());
            }
            sb.append("]]>");
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printName(String str, String str2, String str3, StringBuilder sb) {
        if (str2 != null && !"".equals(str2)) {
            sb.append("['" + str2 + "']:");
        }
        if (str != null && !"".equals(str)) {
            sb.append(str + ":");
        }
        if (str3 != null) {
            sb.append(str3);
        }
    }

    private static void printName(XMLStreamReader xMLStreamReader, StringBuilder sb) {
        if (xMLStreamReader.hasName()) {
            printName(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), sb);
        }
    }

    public static int getType(String str) {
        if (str.equals("START_ELEMENT")) {
            return 1;
        }
        if (str.equals("SPACE")) {
            return 6;
        }
        if (str.equals("END_ELEMENT")) {
            return 2;
        }
        if (str.equals("PROCESSING_INSTRUCTION")) {
            return 3;
        }
        if (str.equals("CHARACTERS")) {
            return 4;
        }
        if (str.equals("COMMENT")) {
            return 5;
        }
        if (str.equals("START_DOCUMENT")) {
            return 7;
        }
        if (str.equals("END_DOCUMENT")) {
            return 8;
        }
        if (str.equals("ATTRIBUTE")) {
            return 10;
        }
        if (str.equals("DTD")) {
            return 11;
        }
        if (str.equals(ValidatorPair.ATTR_TYPE_DEFAULT)) {
            return 12;
        }
        return str.equals("NAMESPACE") ? 13 : -1;
    }
}
