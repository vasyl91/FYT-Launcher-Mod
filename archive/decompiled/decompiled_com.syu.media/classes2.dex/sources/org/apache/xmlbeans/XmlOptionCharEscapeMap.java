package org.apache.xmlbeans;

import java.util.HashMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlOptionCharEscapeMap {
    public static final int DECIMAL = 1;
    public static final int HEXADECIMAL = 2;
    public static final int PREDEF_ENTITY = 0;
    private static final HashMap _predefEntities;
    private HashMap _charMap = new HashMap();

    static {
        HashMap map = new HashMap();
        _predefEntities = map;
        map.put(new Character(Typography.less), "&lt;");
        map.put(new Character(Typography.greater), "&gt;");
        map.put(new Character(Typography.amp), "&amp;");
        map.put(new Character('\''), "&apos;");
        map.put(new Character(Typography.quote), "&quot;");
    }

    public boolean containsChar(char c) {
        return this._charMap.containsKey(new Character(c));
    }

    public void addMapping(char c, int i) throws XmlException {
        Character ch = new Character(c);
        if (i == 0) {
            String str = (String) _predefEntities.get(ch);
            if (str == null) {
                throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
            }
            this._charMap.put(ch, str);
            return;
        }
        if (i == 1) {
            this._charMap.put(ch, "&#" + ((int) c) + ";");
        } else {
            if (i == 2) {
                this._charMap.put(ch, "&#x" + Integer.toHexString(c) + ";");
                return;
            }
            throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
        }
    }

    public void addMappings(char c, char c2, int i) throws XmlException {
        if (c > c2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
        }
        while (c <= c2) {
            addMapping(c, i);
            c = (char) (c + 1);
        }
    }

    public String getEscapedString(char c) {
        return (String) this._charMap.get(new Character(c));
    }
}
