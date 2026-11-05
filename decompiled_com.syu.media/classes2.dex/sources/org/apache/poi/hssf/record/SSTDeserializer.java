package org.apache.poi.hssf.record;

import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.util.IntMapper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class SSTDeserializer {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) SSTDeserializer.class);
    private IntMapper<UnicodeString> strings;

    public SSTDeserializer(IntMapper<UnicodeString> intMapper) {
        this.strings = intMapper;
    }

    public void manufactureStrings(int i, RecordInputStream recordInputStream) {
        UnicodeString unicodeString;
        for (int i2 = 0; i2 < i; i2++) {
            if (recordInputStream.available() == 0 && !recordInputStream.hasNextRecord()) {
                logger.log(7, "Ran out of data before creating all the strings! String at index " + i2 + "");
                unicodeString = new UnicodeString("");
            } else {
                unicodeString = new UnicodeString(recordInputStream);
            }
            addToStringTable(this.strings, unicodeString);
        }
    }

    public static void addToStringTable(IntMapper<UnicodeString> intMapper, UnicodeString unicodeString) {
        intMapper.add(unicodeString);
    }
}
