package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlEnum
@XmlType(name = "ST_PathFillMode", namespace = XSSFRelation.NS_DRAWINGML)
public enum STPathFillMode {
    NONE("none"),
    NORM("norm"),
    LIGHTEN("lighten"),
    LIGHTEN_LESS("lightenLess"),
    DARKEN("darken"),
    DARKEN_LESS("darkenLess");

    private final String value;

    STPathFillMode(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static STPathFillMode fromValue(String str) {
        for (STPathFillMode sTPathFillMode : values()) {
            if (sTPathFillMode.value.equals(str)) {
                return sTPathFillMode;
            }
        }
        throw new IllegalArgumentException(str);
    }
}
