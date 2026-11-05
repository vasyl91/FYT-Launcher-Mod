package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleType;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFTableStyle implements TableStyle {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFTableStyle.class);
    private final Map<TableStyleType, DifferentialStyleProvider> elementMap = new EnumMap(TableStyleType.class);
    private final int index;
    private final String name;

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public boolean isBuiltin() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c9  */
    public XSSFTableStyle(int i, CTDxfs cTDxfs, CTTableStyle cTTableStyle, IndexedColorMap indexedColorMap) {
        XSSFDxfStyleProvider xSSFDxfStyleProvider;
        CTDxf cTDxf;
        this.name = cTTableStyle.getName();
        this.index = i;
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTDxfs.newCursor();
        xmlCursorNewCursor.selectPath("declare namespace x='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//x:dxf | .//dxf");
        while (xmlCursorNewCursor.toNextSelection()) {
            CTDxf object = xmlCursorNewCursor.getObject();
            String nodeName = object.getDomNode().getParentNode().getNodeName();
            if (nodeName.equals("mc:Fallback") || nodeName.equals("x:dxfs") || nodeName.contentEquals("dxfs")) {
                try {
                    if (object instanceof CTDxf) {
                        cTDxf = object;
                    } else {
                        cTDxf = CTDxf.Factory.parse(object.newXMLStreamReader(), new XmlOptions().setDocumentType(CTDxf.type));
                    }
                    if (cTDxf != null) {
                        arrayList.add(cTDxf);
                    }
                } catch (XmlException e) {
                    logger.log(5, "Error parsing XSSFTableStyle", e);
                }
            }
        }
        for (CTTableStyleElement cTTableStyleElement : cTTableStyle.getTableStyleElementList()) {
            TableStyleType tableStyleTypeValueOf = TableStyleType.valueOf(cTTableStyleElement.getType().toString());
            if (cTTableStyleElement.isSetDxfId()) {
                CTDxf cTDxf2 = (CTDxf) arrayList.get((int) cTTableStyleElement.getDxfId());
                int size = cTTableStyleElement.isSetSize() ? (int) cTTableStyleElement.getSize() : 0;
                if (cTDxf2 != null) {
                    xSSFDxfStyleProvider = new XSSFDxfStyleProvider(cTDxf2, size, indexedColorMap);
                } else {
                    xSSFDxfStyleProvider = null;
                }
            } else {
                xSSFDxfStyleProvider = null;
            }
            this.elementMap.put(tableStyleTypeValueOf, xSSFDxfStyleProvider);
        }
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public int getIndex() {
        return this.index;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyle
    public DifferentialStyleProvider getStyle(TableStyleType tableStyleType) {
        return this.elementMap.get(tableStyleType);
    }
}
