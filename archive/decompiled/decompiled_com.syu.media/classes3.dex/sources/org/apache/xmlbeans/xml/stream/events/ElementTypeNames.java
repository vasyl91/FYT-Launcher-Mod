package org.apache.xmlbeans.xml.stream.events;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class ElementTypeNames {
    public static String getName(int i) {
        if (i == 1) {
            return "XML_EVENT";
        }
        if (i == 2) {
            return "START_ELEMENT";
        }
        switch (i) {
            case 4:
                return "END_ELEMENT";
            case 8:
                return "PROCESSING_INSTRUCTION";
            case 16:
                return "CHARACTER_DATA";
            case 32:
                return "COMMENT";
            case 64:
                return "SPACE";
            case 128:
                return "NULL_ELEMENT";
            case 256:
                return "START_DOCUMENT";
            case 512:
                return "END_DOCUMENT";
            case XMLEvent.START_PREFIX_MAPPING /* 1024 */:
                return "START_PREFIX_MAPPING";
            case XMLEvent.END_PREFIX_MAPPING /* 2048 */:
                return "END_PREFIX_MAPPING";
            case XMLEvent.CHANGE_PREFIX_MAPPING /* 4096 */:
                return "CHANGE_PREFIX_MAPPING";
            case XMLEvent.ENTITY_REFERENCE /* 8192 */:
                return "ENTITY_REFERENCE";
            default:
                return "";
        }
    }

    public static int getType(String str) {
        if (str.equals("XML_EVENT")) {
            return 1;
        }
        if (str.equals("START_ELEMENT")) {
            return 2;
        }
        if (str.equals("END_ELEMENT")) {
            return 4;
        }
        if (str.equals("PROCESSING_INSTRUCTION")) {
            return 8;
        }
        if (str.equals("CHARACTER_DATA")) {
            return 16;
        }
        if (str.equals("COMMENT")) {
            return 32;
        }
        if (str.equals("SPACE")) {
            return 64;
        }
        if (str.equals("NULL_ELEMENT")) {
            return 128;
        }
        if (str.equals("START_DOCUMENT")) {
            return 256;
        }
        if (str.equals("END_DOCUMENT")) {
            return 512;
        }
        if (str.equals("START_PREFIX_MAPPING")) {
            return XMLEvent.START_PREFIX_MAPPING;
        }
        if (str.equals("CHANGE_PREFIX_MAPPING")) {
            return XMLEvent.CHANGE_PREFIX_MAPPING;
        }
        if (str.equals("ENTITY_REFERENCE")) {
            return XMLEvent.ENTITY_REFERENCE;
        }
        if (str.equals("END_PREFIX_MAPPING")) {
            return XMLEvent.END_PREFIX_MAPPING;
        }
        return 128;
    }
}
