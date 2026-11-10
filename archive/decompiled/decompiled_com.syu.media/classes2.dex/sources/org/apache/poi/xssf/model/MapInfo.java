package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSchema;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class MapInfo extends POIXMLDocumentPart {
    private CTMapInfo mapInfo;
    private Map<Integer, XSSFMap> maps;

    public MapInfo() {
        this.mapInfo = CTMapInfo.Factory.newInstance();
    }

    public MapInfo(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.mapInfo = MapInfoDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getMapInfo();
            this.maps = new HashMap();
            for (CTMap cTMap : this.mapInfo.getMapArray()) {
                this.maps.put(Integer.valueOf((int) cTMap.getID()), new XSSFMap(cTMap, this));
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) getParent();
    }

    public CTMapInfo getCTMapInfo() {
        return this.mapInfo;
    }

    public CTSchema getCTSchemaById(String str) {
        for (CTSchema cTSchema : this.mapInfo.getSchemaArray()) {
            if (cTSchema.getID().equals(str)) {
                return cTSchema;
            }
        }
        return null;
    }

    public XSSFMap getXSSFMapById(int i) {
        return this.maps.get(Integer.valueOf(i));
    }

    public XSSFMap getXSSFMapByName(String str) {
        XSSFMap xSSFMap = null;
        for (XSSFMap xSSFMap2 : this.maps.values()) {
            if (xSSFMap2.getCtMap().getName() != null && xSSFMap2.getCtMap().getName().equals(str)) {
                xSSFMap = xSSFMap2;
            }
        }
        return xSSFMap;
    }

    public Collection<XSSFMap> getAllXSSFMaps() {
        return this.maps.values();
    }

    protected void writeTo(OutputStream outputStream) throws IOException {
        MapInfoDocument mapInfoDocumentNewInstance = MapInfoDocument.Factory.newInstance();
        mapInfoDocumentNewInstance.setMapInfo(this.mapInfo);
        mapInfoDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }
}
