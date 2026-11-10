package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOrientation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPageOrder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPrintError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPrintError$Enum;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPageSetupImpl extends XmlComplexContentImpl implements CTPageSetup {
    private static final QName PAPERSIZE$0 = new QName("", "paperSize");
    private static final QName SCALE$2 = new QName("", "scale");
    private static final QName FIRSTPAGENUMBER$4 = new QName("", "firstPageNumber");
    private static final QName FITTOWIDTH$6 = new QName("", "fitToWidth");
    private static final QName FITTOHEIGHT$8 = new QName("", "fitToHeight");
    private static final QName PAGEORDER$10 = new QName("", "pageOrder");
    private static final QName ORIENTATION$12 = new QName("", "orientation");
    private static final QName USEPRINTERDEFAULTS$14 = new QName("", "usePrinterDefaults");
    private static final QName BLACKANDWHITE$16 = new QName("", "blackAndWhite");
    private static final QName DRAFT$18 = new QName("", "draft");
    private static final QName CELLCOMMENTS$20 = new QName("", "cellComments");
    private static final QName USEFIRSTPAGENUMBER$22 = new QName("", "useFirstPageNumber");
    private static final QName ERRORS$24 = new QName("", "errors");
    private static final QName HORIZONTALDPI$26 = new QName("", "horizontalDpi");
    private static final QName VERTICALDPI$28 = new QName("", "verticalDpi");
    private static final QName COPIES$30 = new QName("", "copies");
    private static final QName ID$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public CTPageSetupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean getBlackAndWhite() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLACKANDWHITE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STCellComments.Enum getCellComments() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLCOMMENTS$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STCellComments.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getCopies() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COPIES$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean getDraft() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAFT$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STPrintError$Enum getErrors() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORS$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPrintError$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getFirstPageNumber() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTPAGENUMBER$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getFitToHeight() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOHEIGHT$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getFitToWidth() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOWIDTH$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getHorizontalDpi() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALDPI$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(ID$32);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STOrientation.Enum getOrientation() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENTATION$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STOrientation.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STPageOrder.Enum getPageOrder() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEORDER$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPageOrder.Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getPaperSize() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAPERSIZE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getScale() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean getUseFirstPageNumber() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEFIRSTPAGENUMBER$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean getUsePrinterDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEPRINTERDEFAULTS$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public long getVerticalDpi() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALDPI$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0L;
            }
            return simpleValueFind_attribute_user.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetBlackAndWhite() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLACKANDWHITE$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetCellComments() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CELLCOMMENTS$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetCopies() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COPIES$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetDraft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DRAFT$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetErrors() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ERRORS$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetFirstPageNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTPAGENUMBER$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetFitToHeight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITTOHEIGHT$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetFitToWidth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FITTOWIDTH$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetHorizontalDpi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HORIZONTALDPI$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetOrientation() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIENTATION$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetPageOrder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PAGEORDER$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetPaperSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PAPERSIZE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SCALE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetUseFirstPageNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USEFIRSTPAGENUMBER$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetUsePrinterDefaults() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USEPRINTERDEFAULTS$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public boolean isSetVerticalDpi() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VERTICALDPI$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setBlackAndWhite(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLACKANDWHITE$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setCellComments(STCellComments.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLCOMMENTS$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setCopies(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COPIES$30;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setDraft(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAFT$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setErrors(STPrintError$Enum sTPrintError$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORS$24;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPrintError$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setFirstPageNumber(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTPAGENUMBER$4;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setFitToHeight(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOHEIGHT$8;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setFitToWidth(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOWIDTH$6;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setHorizontalDpi(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALDPI$26;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$32;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setOrientation(STOrientation.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENTATION$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setPageOrder(STPageOrder.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEORDER$10;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setPaperSize(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAPERSIZE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setScale(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALE$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setUseFirstPageNumber(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEFIRSTPAGENUMBER$22;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setUsePrinterDefaults(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEPRINTERDEFAULTS$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void setVerticalDpi(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALDPI$28;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetBlackAndWhite() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLACKANDWHITE$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetCellComments() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CELLCOMMENTS$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetCopies() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COPIES$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetDraft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DRAFT$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetErrors() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ERRORS$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetFirstPageNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTPAGENUMBER$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetFitToHeight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITTOHEIGHT$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetFitToWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FITTOWIDTH$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetHorizontalDpi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HORIZONTALDPI$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$32);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetOrientation() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIENTATION$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetPageOrder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PAGEORDER$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetPaperSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PAPERSIZE$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SCALE$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetUseFirstPageNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USEFIRSTPAGENUMBER$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetUsePrinterDefaults() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USEPRINTERDEFAULTS$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void unsetVerticalDpi() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VERTICALDPI$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlBoolean xgetBlackAndWhite() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLACKANDWHITE$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STCellComments xgetCellComments() {
        STCellComments sTCellComments;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLCOMMENTS$20;
            sTCellComments = (STCellComments) typeStore.find_attribute_user(qName);
            if (sTCellComments == null) {
                sTCellComments = (STCellComments) get_default_attribute_value(qName);
            }
        }
        return sTCellComments;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetCopies() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COPIES$30;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlBoolean xgetDraft() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAFT$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STPrintError xgetErrors() {
        STPrintError sTPrintErrorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORS$24;
            sTPrintErrorFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPrintErrorFind_attribute_user == null) {
                sTPrintErrorFind_attribute_user = (STPrintError) get_default_attribute_value(qName);
            }
        }
        return sTPrintErrorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetFirstPageNumber() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTPAGENUMBER$4;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetFitToHeight() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOHEIGHT$8;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetFitToWidth() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOWIDTH$6;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetHorizontalDpi() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALDPI$26;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID$32);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STOrientation xgetOrientation() {
        STOrientation sTOrientation;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENTATION$12;
            sTOrientation = (STOrientation) typeStore.find_attribute_user(qName);
            if (sTOrientation == null) {
                sTOrientation = (STOrientation) get_default_attribute_value(qName);
            }
        }
        return sTOrientation;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public STPageOrder xgetPageOrder() {
        STPageOrder sTPageOrder;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEORDER$10;
            sTPageOrder = (STPageOrder) typeStore.find_attribute_user(qName);
            if (sTPageOrder == null) {
                sTPageOrder = (STPageOrder) get_default_attribute_value(qName);
            }
        }
        return sTPageOrder;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetPaperSize() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAPERSIZE$0;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetScale() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALE$2;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlBoolean xgetUseFirstPageNumber() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEFIRSTPAGENUMBER$22;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlBoolean xgetUsePrinterDefaults() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEPRINTERDEFAULTS$14;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public XmlUnsignedInt xgetVerticalDpi() {
        XmlUnsignedInt xmlUnsignedIntFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALDPI$28;
            xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_default_attribute_value(qName);
            }
        }
        return xmlUnsignedIntFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetBlackAndWhite(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLACKANDWHITE$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetCellComments(STCellComments sTCellComments) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CELLCOMMENTS$20;
            STCellComments sTCellComments2 = (STCellComments) typeStore.find_attribute_user(qName);
            if (sTCellComments2 == null) {
                sTCellComments2 = (STCellComments) get_store().add_attribute_user(qName);
            }
            sTCellComments2.set((XmlObject) sTCellComments);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetCopies(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COPIES$30;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetDraft(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DRAFT$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetErrors(STPrintError sTPrintError) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ERRORS$24;
            STPrintError sTPrintErrorFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPrintErrorFind_attribute_user == null) {
                sTPrintErrorFind_attribute_user = (STPrintError) get_store().add_attribute_user(qName);
            }
            sTPrintErrorFind_attribute_user.set(sTPrintError);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetFirstPageNumber(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTPAGENUMBER$4;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetFitToHeight(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOHEIGHT$8;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetFitToWidth(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FITTOWIDTH$6;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetHorizontalDpi(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HORIZONTALDPI$26;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$32;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetOrientation(STOrientation sTOrientation) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ORIENTATION$12;
            STOrientation sTOrientation2 = (STOrientation) typeStore.find_attribute_user(qName);
            if (sTOrientation2 == null) {
                sTOrientation2 = (STOrientation) get_store().add_attribute_user(qName);
            }
            sTOrientation2.set((XmlObject) sTOrientation);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetPageOrder(STPageOrder sTPageOrder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAGEORDER$10;
            STPageOrder sTPageOrder2 = (STPageOrder) typeStore.find_attribute_user(qName);
            if (sTPageOrder2 == null) {
                sTPageOrder2 = (STPageOrder) get_store().add_attribute_user(qName);
            }
            sTPageOrder2.set((XmlObject) sTPageOrder);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetPaperSize(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PAPERSIZE$0;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetScale(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SCALE$2;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetUseFirstPageNumber(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEFIRSTPAGENUMBER$22;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetUsePrinterDefaults(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USEPRINTERDEFAULTS$14;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup
    public void xsetVerticalDpi(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VERTICALDPI$28;
            XmlUnsignedInt xmlUnsignedIntFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlUnsignedIntFind_attribute_user == null) {
                xmlUnsignedIntFind_attribute_user = (XmlUnsignedInt) get_store().add_attribute_user(qName);
            }
            xmlUnsignedIntFind_attribute_user.set(xmlUnsignedInt);
        }
    }
}
