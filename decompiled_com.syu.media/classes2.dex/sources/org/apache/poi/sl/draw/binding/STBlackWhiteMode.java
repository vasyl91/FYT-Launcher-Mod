package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlEnum
@XmlType(name = "ST_BlackWhiteMode", namespace = XSSFRelation.NS_DRAWINGML)
public enum STBlackWhiteMode {
    CLR("clr"),
    AUTO(DebugKt.DEBUG_PROPERTY_VALUE_AUTO),
    GRAY("gray"),
    LT_GRAY("ltGray"),
    INV_GRAY("invGray"),
    GRAY_WHITE("grayWhite"),
    BLACK_GRAY("blackGray"),
    BLACK_WHITE("blackWhite"),
    BLACK("black"),
    WHITE("white"),
    HIDDEN(CellUtil.HIDDEN);

    private final String value;

    STBlackWhiteMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static STBlackWhiteMode fromValue(String str) {
        for (STBlackWhiteMode sTBlackWhiteMode : values()) {
            if (sTBlackWhiteMode.value.equals(str)) {
                return sTBlackWhiteMode;
            }
        }
        throw new IllegalArgumentException(str);
    }
}
