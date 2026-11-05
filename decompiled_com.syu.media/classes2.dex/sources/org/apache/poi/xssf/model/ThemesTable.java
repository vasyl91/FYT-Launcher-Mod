package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ThemesTable extends POIXMLDocumentPart {
    private IndexedColorMap colorMap;
    private ThemeDocument theme;

    public enum ThemeElement {
        LT1(0, "Lt1"),
        DK1(1, "Dk1"),
        LT2(2, "Lt2"),
        DK2(3, "Dk2"),
        ACCENT1(4, "Accent1"),
        ACCENT2(5, "Accent2"),
        ACCENT3(6, "Accent3"),
        ACCENT4(7, "Accent4"),
        ACCENT5(8, "Accent5"),
        ACCENT6(9, "Accent6"),
        HLINK(10, "Hlink"),
        FOLHLINK(11, "FolHlink"),
        UNKNOWN(-1, null);

        public final int idx;
        public final String name;

        public static ThemeElement byId(int i) {
            if (i >= values().length || i < 0) {
                return UNKNOWN;
            }
            return values()[i];
        }

        ThemeElement(int i, String str) {
            this.idx = i;
            this.name = str;
        }
    }

    public ThemesTable() {
        ThemeDocument themeDocumentNewInstance = ThemeDocument.Factory.newInstance();
        this.theme = themeDocumentNewInstance;
        themeDocumentNewInstance.addNewTheme().addNewThemeElements();
    }

    public ThemesTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        try {
            this.theme = ThemeDocument.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    public ThemesTable(ThemeDocument themeDocument) {
        this.theme = themeDocument;
    }

    protected void setColorMap(IndexedColorMap indexedColorMap) {
        this.colorMap = indexedColorMap;
    }

    public XSSFColor getThemeColor(int i) {
        CTColor lt1;
        byte[] lastClr;
        CTColorScheme clrScheme = this.theme.getTheme().getThemeElements().getClrScheme();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.byId(i).ordinal()]) {
            case 1:
                lt1 = clrScheme.getLt1();
                break;
            case 2:
                lt1 = clrScheme.getDk1();
                break;
            case 3:
                lt1 = clrScheme.getLt2();
                break;
            case 4:
                lt1 = clrScheme.getDk2();
                break;
            case 5:
                lt1 = clrScheme.getAccent1();
                break;
            case 6:
                lt1 = clrScheme.getAccent2();
                break;
            case 7:
                lt1 = clrScheme.getAccent3();
                break;
            case 8:
                lt1 = clrScheme.getAccent4();
                break;
            case 9:
                lt1 = clrScheme.getAccent5();
                break;
            case 10:
                lt1 = clrScheme.getAccent6();
                break;
            case 11:
                lt1 = clrScheme.getHlink();
                break;
            case 12:
                lt1 = clrScheme.getFolHlink();
                break;
            default:
                return null;
        }
        if (lt1.isSetSrgbClr()) {
            lastClr = lt1.getSrgbClr().getVal();
        } else {
            if (!lt1.isSetSysClr()) {
                return null;
            }
            lastClr = lt1.getSysClr().getLastClr();
        }
        return new XSSFColor(lastClr, this.colorMap);
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.model.ThemesTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement;

        static {
            int[] iArr = new int[ThemeElement.values().length];
            $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement = iArr;
            try {
                iArr[ThemeElement.LT1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.DK1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.LT2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.DK2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT3.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT4.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT5.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.ACCENT6.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.HLINK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$model$ThemesTable$ThemeElement[ThemeElement.FOLHLINK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public void inheritFromThemeAsRequired(XSSFColor xSSFColor) {
        if (xSSFColor != null && xSSFColor.getCTColor().isSetTheme()) {
            xSSFColor.getCTColor().setRgb(getThemeColor(xSSFColor.getTheme()).getCTColor().getRgb());
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.theme.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }
}
