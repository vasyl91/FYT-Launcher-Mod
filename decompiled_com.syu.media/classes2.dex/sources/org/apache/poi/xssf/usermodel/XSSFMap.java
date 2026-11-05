package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SingleXmlCells;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFMap {
    private CTMap ctMap;
    private MapInfo mapInfo;

    public XSSFMap(CTMap cTMap, MapInfo mapInfo) {
        this.ctMap = cTMap;
        this.mapInfo = mapInfo;
    }

    @Internal
    public CTMap getCtMap() {
        return this.ctMap;
    }

    @Internal
    public CTSchema getCTSchema() {
        return this.mapInfo.getCTSchemaById(this.ctMap.getSchemaID());
    }

    public Node getSchema() {
        return getCTSchema().getDomNode().getFirstChild();
    }

    public List<XSSFSingleXmlCell> getRelatedSingleXMLCell() {
        ArrayList arrayList = new ArrayList();
        int numberOfSheets = this.mapInfo.getWorkbook().getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : this.mapInfo.getWorkbook().getSheetAt(i).getRelations()) {
                if (pOIXMLDocumentPart instanceof SingleXmlCells) {
                    for (XSSFSingleXmlCell xSSFSingleXmlCell : ((SingleXmlCells) pOIXMLDocumentPart).getAllSimpleXmlCell()) {
                        if (xSSFSingleXmlCell.getMapId() == this.ctMap.getID()) {
                            arrayList.add(xSSFSingleXmlCell);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public List<XSSFTable> getRelatedTables() {
        ArrayList arrayList = new ArrayList();
        Iterator<Sheet> it = this.mapInfo.getWorkbook().iterator();
        while (it.hasNext()) {
            for (POIXMLDocumentPart.RelationPart relationPart : ((XSSFSheet) it.next()).getRelationParts()) {
                if (relationPart.getRelationship().getRelationshipType().equals(XSSFRelation.TABLE.getRelation())) {
                    XSSFTable xSSFTable = (XSSFTable) relationPart.getDocumentPart();
                    if (xSSFTable.mapsTo(this.ctMap.getID())) {
                        arrayList.add(xSSFTable);
                    }
                }
            }
        }
        return arrayList;
    }
}
