package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCol;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTableGridImpl extends XmlComplexContentImpl implements CTTableGrid {
    private static final QName GRIDCOL$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gridCol");

    public CTTableGridImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol addNewGridCol() {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().add_element_user(GRIDCOL$0);
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol getGridColArray(int i) {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().find_element_user(GRIDCOL$0, i);
            if (cTTableCol == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol[] getGridColArray() {
        CTTableCol[] cTTableColArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GRIDCOL$0, arrayList);
            cTTableColArr = new CTTableCol[arrayList.size()];
            arrayList.toArray(cTTableColArr);
        }
        return cTTableColArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public List<CTTableCol> getGridColList() {
        1GridColList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1GridColList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public CTTableCol insertNewGridCol(int i) {
        CTTableCol cTTableCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCol = (CTTableCol) get_store().insert_element_user(GRIDCOL$0, i);
        }
        return cTTableCol;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void removeGridCol(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRIDCOL$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void setGridColArray(int i, CTTableCol cTTableCol) {
        synchronized (monitor()) {
            check_orphaned();
            CTTableCol cTTableCol2 = (CTTableCol) get_store().find_element_user(GRIDCOL$0, i);
            if (cTTableCol2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTableCol2.set(cTTableCol);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public void setGridColArray(CTTableCol[] cTTableColArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableColArr, GRIDCOL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid
    public int sizeOfGridColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GRIDCOL$0);
        }
        return iCount_elements;
    }
}
