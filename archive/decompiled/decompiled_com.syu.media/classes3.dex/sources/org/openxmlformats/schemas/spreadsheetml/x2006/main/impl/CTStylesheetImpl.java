package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorders;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellXfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxfs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFills;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFonts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmts;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyles;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTStylesheetImpl extends XmlComplexContentImpl implements CTStylesheet {
    private static final QName NUMFMTS$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "numFmts");
    private static final QName FONTS$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fonts");
    private static final QName FILLS$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fills");
    private static final QName BORDERS$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "borders");
    private static final QName CELLSTYLEXFS$8 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyleXfs");
    private static final QName CELLXFS$10 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellXfs");
    private static final QName CELLSTYLES$12 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cellStyles");
    private static final QName DXFS$14 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dxfs");
    private static final QName TABLESTYLES$16 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tableStyles");
    private static final QName COLORS$18 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "colors");
    private static final QName EXTLST$20 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTStylesheetImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTBorders addNewBorders() {
        CTBorders cTBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTBorders = (CTBorders) get_store().add_element_user(BORDERS$6);
        }
        return cTBorders;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyleXfs addNewCellStyleXfs() {
        CTCellStyleXfs cTCellStyleXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStyleXfs = (CTCellStyleXfs) get_store().add_element_user(CELLSTYLEXFS$8);
        }
        return cTCellStyleXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyles addNewCellStyles() {
        CTCellStyles cTCellStylesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCellStylesAdd_element_user = get_store().add_element_user(CELLSTYLES$12);
        }
        return cTCellStylesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellXfs addNewCellXfs() {
        CTCellXfs cTCellXfs;
        synchronized (monitor()) {
            check_orphaned();
            cTCellXfs = (CTCellXfs) get_store().add_element_user(CELLXFS$10);
        }
        return cTCellXfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTColors addNewColors() {
        CTColors cTColors;
        synchronized (monitor()) {
            check_orphaned();
            cTColors = (CTColors) get_store().add_element_user(COLORS$18);
        }
        return cTColors;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTDxfs addNewDxfs() {
        CTDxfs cTDxfs;
        synchronized (monitor()) {
            check_orphaned();
            cTDxfs = (CTDxfs) get_store().add_element_user(DXFS$14);
        }
        return cTDxfs;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$20);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFills addNewFills() {
        CTFills cTFills;
        synchronized (monitor()) {
            check_orphaned();
            cTFills = (CTFills) get_store().add_element_user(FILLS$4);
        }
        return cTFills;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFonts addNewFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().add_element_user(FONTS$2);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTNumFmts addNewNumFmts() {
        CTNumFmts cTNumFmts;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmts = (CTNumFmts) get_store().add_element_user(NUMFMTS$0);
        }
        return cTNumFmts;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTTableStyles addNewTableStyles() {
        CTTableStyles cTTableStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyles = (CTTableStyles) get_store().add_element_user(TABLESTYLES$16);
        }
        return cTTableStyles;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTBorders getBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTBorders cTBorders = (CTBorders) get_store().find_element_user(BORDERS$6, 0);
            if (cTBorders == null) {
                return null;
            }
            return cTBorders;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyleXfs getCellStyleXfs() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellStyleXfs cTCellStyleXfs = (CTCellStyleXfs) get_store().find_element_user(CELLSTYLEXFS$8, 0);
            if (cTCellStyleXfs == null) {
                return null;
            }
            return cTCellStyleXfs;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellStyles getCellStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellStyles cTCellStylesFind_element_user = get_store().find_element_user(CELLSTYLES$12, 0);
            if (cTCellStylesFind_element_user == null) {
                return null;
            }
            return cTCellStylesFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTCellXfs getCellXfs() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellXfs cTCellXfs = (CTCellXfs) get_store().find_element_user(CELLXFS$10, 0);
            if (cTCellXfs == null) {
                return null;
            }
            return cTCellXfs;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTColors getColors() {
        synchronized (monitor()) {
            check_orphaned();
            CTColors cTColors = (CTColors) get_store().find_element_user(COLORS$18, 0);
            if (cTColors == null) {
                return null;
            }
            return cTColors;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTDxfs getDxfs() {
        synchronized (monitor()) {
            check_orphaned();
            CTDxfs cTDxfs = (CTDxfs) get_store().find_element_user(DXFS$14, 0);
            if (cTDxfs == null) {
                return null;
            }
            return cTDxfs;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$20, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFills getFills() {
        synchronized (monitor()) {
            check_orphaned();
            CTFills cTFills = (CTFills) get_store().find_element_user(FILLS$4, 0);
            if (cTFills == null) {
                return null;
            }
            return cTFills;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTFonts getFonts() {
        synchronized (monitor()) {
            check_orphaned();
            CTFonts cTFonts = (CTFonts) get_store().find_element_user(FONTS$2, 0);
            if (cTFonts == null) {
                return null;
            }
            return cTFonts;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTNumFmts getNumFmts() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmts cTNumFmts = (CTNumFmts) get_store().find_element_user(NUMFMTS$0, 0);
            if (cTNumFmts == null) {
                return null;
            }
            return cTNumFmts;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public CTTableStyles getTableStyles() {
        synchronized (monitor()) {
            check_orphaned();
            CTTableStyles cTTableStyles = (CTTableStyles) get_store().find_element_user(TABLESTYLES$16, 0);
            if (cTTableStyles == null) {
                return null;
            }
            return cTTableStyles;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BORDERS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellStyleXfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLSTYLEXFS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLSTYLES$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetCellXfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CELLXFS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetColors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(COLORS$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetDxfs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DXFS$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetFills() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILLS$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetFonts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FONTS$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetNumFmts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMTS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public boolean isSetTableStyles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABLESTYLES$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setBorders(CTBorders cTBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERS$6;
            CTBorders cTBorders2 = (CTBorders) typeStore.find_element_user(qName, 0);
            if (cTBorders2 == null) {
                cTBorders2 = (CTBorders) get_store().add_element_user(qName);
            }
            cTBorders2.set(cTBorders);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellStyleXfs(CTCellStyleXfs cTCellStyleXfs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLSTYLEXFS$8;
            CTCellStyleXfs cTCellStyleXfs2 = (CTCellStyleXfs) typeStore.find_element_user(qName, 0);
            if (cTCellStyleXfs2 == null) {
                cTCellStyleXfs2 = (CTCellStyleXfs) get_store().add_element_user(qName);
            }
            cTCellStyleXfs2.set(cTCellStyleXfs);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellStyles(CTCellStyles cTCellStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLSTYLES$12;
            CTCellStyles cTCellStylesFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTCellStylesFind_element_user == null) {
                cTCellStylesFind_element_user = (CTCellStyles) get_store().add_element_user(qName);
            }
            cTCellStylesFind_element_user.set(cTCellStyles);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setCellXfs(CTCellXfs cTCellXfs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLXFS$10;
            CTCellXfs cTCellXfs2 = (CTCellXfs) typeStore.find_element_user(qName, 0);
            if (cTCellXfs2 == null) {
                cTCellXfs2 = (CTCellXfs) get_store().add_element_user(qName);
            }
            cTCellXfs2.set(cTCellXfs);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setColors(CTColors cTColors) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLORS$18;
            CTColors cTColors2 = (CTColors) typeStore.find_element_user(qName, 0);
            if (cTColors2 == null) {
                cTColors2 = (CTColors) get_store().add_element_user(qName);
            }
            cTColors2.set(cTColors);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setDxfs(CTDxfs cTDxfs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DXFS$14;
            CTDxfs cTDxfs2 = (CTDxfs) typeStore.find_element_user(qName, 0);
            if (cTDxfs2 == null) {
                cTDxfs2 = (CTDxfs) get_store().add_element_user(qName);
            }
            cTDxfs2.set(cTDxfs);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$20;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setFills(CTFills cTFills) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLS$4;
            CTFills cTFills2 = (CTFills) typeStore.find_element_user(qName, 0);
            if (cTFills2 == null) {
                cTFills2 = (CTFills) get_store().add_element_user(qName);
            }
            cTFills2.set(cTFills);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setFonts(CTFonts cTFonts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTS$2;
            CTFonts cTFonts2 = (CTFonts) typeStore.find_element_user(qName, 0);
            if (cTFonts2 == null) {
                cTFonts2 = (CTFonts) get_store().add_element_user(qName);
            }
            cTFonts2.set(cTFonts);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setNumFmts(CTNumFmts cTNumFmts) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMTS$0;
            CTNumFmts cTNumFmts2 = (CTNumFmts) typeStore.find_element_user(qName, 0);
            if (cTNumFmts2 == null) {
                cTNumFmts2 = (CTNumFmts) get_store().add_element_user(qName);
            }
            cTNumFmts2.set(cTNumFmts);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void setTableStyles(CTTableStyles cTTableStyles) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TABLESTYLES$16;
            CTTableStyles cTTableStyles2 = (CTTableStyles) typeStore.find_element_user(qName, 0);
            if (cTTableStyles2 == null) {
                cTTableStyles2 = (CTTableStyles) get_store().add_element_user(qName);
            }
            cTTableStyles2.set(cTTableStyles);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellStyleXfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLSTYLEXFS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLSTYLES$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetCellXfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CELLXFS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetColors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COLORS$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetDxfs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DXFS$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetFills() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILLS$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetFonts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FONTS$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetNumFmts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMTS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet
    public void unsetTableStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLESTYLES$16, 0);
        }
    }
}
