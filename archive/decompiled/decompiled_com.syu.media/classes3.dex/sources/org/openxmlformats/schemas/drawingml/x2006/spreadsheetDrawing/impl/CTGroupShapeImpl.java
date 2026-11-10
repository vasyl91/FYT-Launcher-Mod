package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTGroupShapeImpl extends XmlComplexContentImpl implements CTGroupShape {
    private static final QName NVGRPSPPR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "nvGrpSpPr");
    private static final QName GRPSPPR$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSpPr");
    private static final QName SP$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "sp");
    private static final QName GRPSP$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSp");
    private static final QName GRAPHICFRAME$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "graphicFrame");
    private static final QName CXNSP$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cxnSp");
    private static final QName PIC$12 = new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "pic");

    public CTGroupShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTConnector addNewCxnSp() {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().add_element_user(CXNSP$10);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGraphicalObjectFrame addNewGraphicFrame() {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().add_element_user(GRAPHICFRAME$8);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShape addNewGrpSp() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(GRPSP$6);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShapeProperties addNewGrpSpPr() {
        CTGroupShapeProperties cTGroupShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeProperties = (CTGroupShapeProperties) get_store().add_element_user(GRPSPPR$2);
        }
        return cTGroupShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShapeNonVisual addNewNvGrpSpPr() {
        CTGroupShapeNonVisual cTGroupShapeNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeNonVisual = (CTGroupShapeNonVisual) get_store().add_element_user(NVGRPSPPR$0);
        }
        return cTGroupShapeNonVisual;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTPicture addNewPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PIC$12);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTShape addNewSp() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(SP$4);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTConnector getCxnSpArray(int i) {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().find_element_user(CXNSP$10, i);
            if (cTConnector == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTConnector[] getCxnSpArray() {
        CTConnector[] cTConnectorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CXNSP$10, arrayList);
            cTConnectorArr = new CTConnector[arrayList.size()];
            arrayList.toArray(cTConnectorArr);
        }
        return cTConnectorArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public List<CTConnector> getCxnSpList() {
        1CxnSpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CxnSpList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGraphicalObjectFrame getGraphicFrameArray(int i) {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().find_element_user(GRAPHICFRAME$8, i);
            if (cTGraphicalObjectFrame == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGraphicalObjectFrame[] getGraphicFrameArray() {
        CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRAPHICFRAME$8, arrayList);
            cTGraphicalObjectFrameArr = new CTGraphicalObjectFrame[arrayList.size()];
            arrayList.toArray(cTGraphicalObjectFrameArr);
        }
        return cTGraphicalObjectFrameArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public List<CTGraphicalObjectFrame> getGraphicFrameList() {
        1GraphicFrameList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GraphicFrameList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShape getGrpSpArray(int i) {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().find_element_user(GRPSP$6, i);
            if (cTGroupShape == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShape[] getGrpSpArray() {
        CTGroupShape[] cTGroupShapeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRPSP$6, arrayList);
            cTGroupShapeArr = new CTGroupShape[arrayList.size()];
            arrayList.toArray(cTGroupShapeArr);
        }
        return cTGroupShapeArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public List<CTGroupShape> getGrpSpList() {
        1GrpSpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GrpSpList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShapeProperties getGrpSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupShapeProperties cTGroupShapeProperties = (CTGroupShapeProperties) get_store().find_element_user(GRPSPPR$2, 0);
            if (cTGroupShapeProperties == null) {
                return null;
            }
            return cTGroupShapeProperties;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShapeNonVisual getNvGrpSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupShapeNonVisual cTGroupShapeNonVisual = (CTGroupShapeNonVisual) get_store().find_element_user(NVGRPSPPR$0, 0);
            if (cTGroupShapeNonVisual == null) {
                return null;
            }
            return cTGroupShapeNonVisual;
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTPicture getPicArray(int i) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().find_element_user(PIC$12, i);
            if (cTPicture == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTPicture[] getPicArray() {
        CTPicture[] cTPictureArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PIC$12, arrayList);
            cTPictureArr = new CTPicture[arrayList.size()];
            arrayList.toArray(cTPictureArr);
        }
        return cTPictureArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public List<CTPicture> getPicList() {
        1PicList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1PicList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTShape getSpArray(int i) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().find_element_user(SP$4, i);
            if (cTShape == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTShape[] getSpArray() {
        CTShape[] cTShapeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SP$4, arrayList);
            cTShapeArr = new CTShape[arrayList.size()];
            arrayList.toArray(cTShapeArr);
        }
        return cTShapeArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public List<CTShape> getSpList() {
        1SpList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SpList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTConnector insertNewCxnSp(int i) {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().insert_element_user(CXNSP$10, i);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGraphicalObjectFrame insertNewGraphicFrame(int i) {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().insert_element_user(GRAPHICFRAME$8, i);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTGroupShape insertNewGrpSp(int i) {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().insert_element_user(GRPSP$6, i);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTPicture insertNewPic(int i) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().insert_element_user(PIC$12, i);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public CTShape insertNewSp(int i) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().insert_element_user(SP$4, i);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void removeCxnSp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CXNSP$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void removeGraphicFrame(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAPHICFRAME$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void removeGrpSp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPSP$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void removePic(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PIC$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void removeSp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SP$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setCxnSpArray(int i, CTConnector cTConnector) {
        synchronized (monitor()) {
            check_orphaned();
            CTConnector cTConnector2 = (CTConnector) get_store().find_element_user(CXNSP$10, i);
            if (cTConnector2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTConnector2.set(cTConnector);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setCxnSpArray(CTConnector[] cTConnectorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTConnectorArr, CXNSP$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setGraphicFrameArray(int i, CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        synchronized (monitor()) {
            check_orphaned();
            CTGraphicalObjectFrame cTGraphicalObjectFrame2 = (CTGraphicalObjectFrame) get_store().find_element_user(GRAPHICFRAME$8, i);
            if (cTGraphicalObjectFrame2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGraphicalObjectFrame2.set(cTGraphicalObjectFrame);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setGraphicFrameArray(CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGraphicalObjectFrameArr, GRAPHICFRAME$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setGrpSpArray(int i, CTGroupShape cTGroupShape) {
        synchronized (monitor()) {
            check_orphaned();
            CTGroupShape cTGroupShape2 = (CTGroupShape) get_store().find_element_user(GRPSP$6, i);
            if (cTGroupShape2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTGroupShape2.set(cTGroupShape);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setGrpSpArray(CTGroupShape[] cTGroupShapeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGroupShapeArr, GRPSP$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRPSPPR$2;
            CTGroupShapeProperties cTGroupShapeProperties2 = (CTGroupShapeProperties) typeStore.find_element_user(qName, 0);
            if (cTGroupShapeProperties2 == null) {
                cTGroupShapeProperties2 = (CTGroupShapeProperties) get_store().add_element_user(qName);
            }
            cTGroupShapeProperties2.set(cTGroupShapeProperties);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NVGRPSPPR$0;
            CTGroupShapeNonVisual cTGroupShapeNonVisual2 = (CTGroupShapeNonVisual) typeStore.find_element_user(qName, 0);
            if (cTGroupShapeNonVisual2 == null) {
                cTGroupShapeNonVisual2 = (CTGroupShapeNonVisual) get_store().add_element_user(qName);
            }
            cTGroupShapeNonVisual2.set(cTGroupShapeNonVisual);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setPicArray(int i, CTPicture cTPicture) {
        synchronized (monitor()) {
            check_orphaned();
            CTPicture cTPicture2 = (CTPicture) get_store().find_element_user(PIC$12, i);
            if (cTPicture2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPicture2.set(cTPicture);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setPicArray(CTPicture[] cTPictureArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPictureArr, PIC$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setSpArray(int i, CTShape cTShape) {
        synchronized (monitor()) {
            check_orphaned();
            CTShape cTShape2 = (CTShape) get_store().find_element_user(SP$4, i);
            if (cTShape2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTShape2.set(cTShape);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public void setSpArray(CTShape[] cTShapeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTShapeArr, SP$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public int sizeOfCxnSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CXNSP$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public int sizeOfGraphicFrameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GRAPHICFRAME$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public int sizeOfGrpSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GRPSP$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public int sizeOfPicArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PIC$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape
    public int sizeOfSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SP$4);
        }
        return iCount_elements;
    }
}
