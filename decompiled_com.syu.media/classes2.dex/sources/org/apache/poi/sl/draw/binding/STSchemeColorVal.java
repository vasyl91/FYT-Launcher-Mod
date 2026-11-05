package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlEnum
@XmlType(name = "ST_SchemeColorVal", namespace = XSSFRelation.NS_DRAWINGML)
public enum STSchemeColorVal {
    BG_1("bg1"),
    TX_1("tx1"),
    BG_2("bg2"),
    TX_2("tx2"),
    ACCENT_1("accent1"),
    ACCENT_2("accent2"),
    ACCENT_3("accent3"),
    ACCENT_4("accent4"),
    ACCENT_5("accent5"),
    ACCENT_6("accent6"),
    HLINK("hlink"),
    FOL_HLINK("folHlink"),
    PH_CLR("phClr"),
    DK_1("dk1"),
    LT_1("lt1"),
    DK_2("dk2"),
    LT_2("lt2");

    private final String value;

    STSchemeColorVal(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static STSchemeColorVal fromValue(String str) {
        for (STSchemeColorVal sTSchemeColorVal : values()) {
            if (sTSchemeColorVal.value.equals(str)) {
                return sTSchemeColorVal;
            }
        }
        throw new IllegalArgumentException(str);
    }
}
