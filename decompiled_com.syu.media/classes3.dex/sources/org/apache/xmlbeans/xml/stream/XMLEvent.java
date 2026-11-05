package org.apache.xmlbeans.xml.stream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLEvent {
    public static final int CHANGE_PREFIX_MAPPING = 4096;
    public static final int CHARACTER_DATA = 16;
    public static final int COMMENT = 32;
    public static final int END_DOCUMENT = 512;
    public static final int END_ELEMENT = 4;
    public static final int END_PREFIX_MAPPING = 2048;
    public static final int ENTITY_REFERENCE = 8192;
    public static final int NULL_ELEMENT = 128;
    public static final int PROCESSING_INSTRUCTION = 8;
    public static final int SPACE = 64;
    public static final int START_DOCUMENT = 256;
    public static final int START_ELEMENT = 2;
    public static final int START_PREFIX_MAPPING = 1024;
    public static final int XML_EVENT = 1;

    Location getLocation();

    XMLName getName();

    XMLName getSchemaType();

    int getType();

    String getTypeAsString();

    boolean hasName();

    boolean isChangePrefixMapping();

    boolean isCharacterData();

    boolean isEndDocument();

    boolean isEndElement();

    boolean isEndPrefixMapping();

    boolean isEntityReference();

    boolean isNull();

    boolean isProcessingInstruction();

    boolean isSpace();

    boolean isStartDocument();

    boolean isStartElement();

    boolean isStartPrefixMapping();
}
