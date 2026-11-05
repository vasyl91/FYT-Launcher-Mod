package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlEnum
@XmlType(name = "ST_RectAlignment", namespace = XSSFRelation.NS_DRAWINGML)
public enum STRectAlignment {
    TL("tl"),
    T("t"),
    TR("tr"),
    L("l"),
    CTR("ctr"),
    R("r"),
    BL("bl"),
    B("b"),
    BR("br");

    private final String value;

    STRectAlignment(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static STRectAlignment fromValue(String str) {
        for (STRectAlignment sTRectAlignment : values()) {
            if (sTRectAlignment.value.equals(str)) {
                return sTRectAlignment;
            }
        }
        throw new IllegalArgumentException(str);
    }
}
