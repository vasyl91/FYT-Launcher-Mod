package org.apache.poi.xslf.usermodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.util.Removal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class XSLFCommonSlideData {
    private final CTCommonSlideData data;

    public XSLFCommonSlideData(CTCommonSlideData cTCommonSlideData) {
        this.data = cTCommonSlideData;
    }

    public List<DrawingTextBody> getDrawingText() {
        CTGroupShape spTree = this.data.getSpTree();
        ArrayList arrayList = new ArrayList();
        processShape(spTree, arrayList);
        for (CTGroupShape cTGroupShape : spTree.getGrpSpArray()) {
            processShape(cTGroupShape, arrayList);
        }
        for (CTGraphicalObjectFrame cTGraphicalObjectFrame : spTree.getGraphicFrameArray()) {
            XmlCursor xmlCursorNewCursor = cTGraphicalObjectFrame.getGraphic().getGraphicData().newCursor();
            xmlCursorNewCursor.selectPath("declare namespace pic='" + CTTable.type.getName().getNamespaceURI() + "' .//pic:tbl");
            while (xmlCursorNewCursor.toNextSelection()) {
                CTTable object = xmlCursorNewCursor.getObject();
                if (object instanceof XmlAnyTypeImpl) {
                    try {
                        object = CTTable.Factory.parse(object.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                    } catch (XmlException e) {
                        throw new POIXMLException(e);
                    }
                }
                if (object instanceof CTTable) {
                    for (DrawingTableRow drawingTableRow : new DrawingTable(object).getRows()) {
                        for (DrawingTableCell drawingTableCell : drawingTableRow.getCells()) {
                            arrayList.add(drawingTableCell.getTextBody());
                        }
                    }
                }
            }
            xmlCursorNewCursor.dispose();
        }
        return arrayList;
    }

    public List<DrawingParagraph> getText() {
        ArrayList arrayList = new ArrayList();
        Iterator<DrawingTextBody> it = getDrawingText().iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(it.next().getParagraphs()));
        }
        return arrayList;
    }

    private void processShape(CTGroupShape cTGroupShape, List<DrawingTextBody> list) {
        DrawingTextBody drawingTextBody;
        for (CTShape cTShape : cTGroupShape.getSpArray()) {
            CTTextBody txBody = cTShape.getTxBody();
            if (txBody != null) {
                CTApplicationNonVisualDrawingProps nvPr = cTShape.getNvSpPr().getNvPr();
                if (nvPr.isSetPh()) {
                    drawingTextBody = new DrawingTextPlaceholder(txBody, nvPr.getPh());
                } else {
                    drawingTextBody = new DrawingTextBody(txBody);
                }
                list.add(drawingTextBody);
            }
        }
    }
}
