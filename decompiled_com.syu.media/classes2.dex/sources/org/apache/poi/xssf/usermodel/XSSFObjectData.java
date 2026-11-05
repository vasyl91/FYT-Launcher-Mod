package org.apache.poi.xssf.usermodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.ObjectData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFObjectData extends XSSFSimpleShape implements ObjectData {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSSFObjectData.class);
    private static CTShape prototype = null;
    private CTOleObject oleObject;

    protected XSSFObjectData(XSSFDrawing xSSFDrawing, CTShape cTShape) {
        super(xSSFDrawing, cTShape);
    }

    protected static CTShape prototype() {
        if (prototype == null) {
            CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
            CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Shape 1");
            CTOfficeArtExtension cTOfficeArtExtensionAddNewExt = cTNonVisualDrawingPropsAddNewCNvPr.addNewExtLst().addNewExt();
            cTOfficeArtExtensionAddNewExt.setUri("{63B3BB69-23CF-44E3-9099-C40C66FF867C}");
            XmlCursor xmlCursorNewCursor = cTOfficeArtExtensionAddNewExt.newCursor();
            xmlCursorNewCursor.toEndToken();
            xmlCursorNewCursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2010/main", "compatExt", "a14"));
            xmlCursorNewCursor.insertNamespace("a14", "http://schemas.microsoft.com/office/drawing/2010/main");
            xmlCursorNewCursor.insertAttributeWithValue("spid", "_x0000_s1");
            xmlCursorNewCursor.dispose();
            cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTShapeNewInstance.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            prototype = cTShapeNewInstance;
        }
        return prototype;
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public String getOLE2ClassName() {
        return getOleObject().getProgId();
    }

    public CTOleObject getOleObject() {
        if (this.oleObject == null) {
            CTOleObject oleObject = getSheet().readOleObject(getCTShape().getNvSpPr().getCNvPr().getId());
            this.oleObject = oleObject;
            if (oleObject == null) {
                throw new POIXMLException("Ole object not found in sheet container - it's probably a control element");
            }
        }
        return this.oleObject;
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public byte[] getObjectData() throws IOException {
        InputStream inputStream = getObjectPart().getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, byteArrayOutputStream);
        inputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public PackagePart getObjectPart() {
        if (!getOleObject().isSetId()) {
            throw new POIXMLException("Invalid ole object found in sheet container");
        }
        POIXMLDocumentPart relationById = getSheet().getRelationById(getOleObject().getId());
        if (relationById == null) {
            return null;
        }
        return relationById.getPackagePart();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public boolean hasDirectoryEntry() {
        InputStream inputStreamPrepareToCheckMagic = null;
        try {
            inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(getObjectPart().getInputStream());
            return FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2;
        } catch (IOException e) {
            LOG.log(5, "can't determine if directory entry exists", e);
            return false;
        } finally {
            IOUtils.closeQuietly(inputStreamPrepareToCheckMagic);
        }
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public DirectoryEntry getDirectory() throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = getObjectPart().getInputStream();
            return new POIFSFileSystem(inputStream).getRoot();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public String getFileName() {
        return getObjectPart().getPartName().getName();
    }

    protected XSSFSheet getSheet() {
        return (XSSFSheet) getDrawing().getParent();
    }

    @Override // org.apache.poi.ss.usermodel.ObjectData
    public XSSFPictureData getPictureData() {
        XmlCursor xmlCursorNewCursor = getOleObject().newCursor();
        try {
            if (!xmlCursorNewCursor.toChild(XSSFRelation.NS_SPREADSHEETML, "objectPr")) {
                return null;
            }
            return (XSSFPictureData) getSheet().getRelationById(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id")));
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }
}
