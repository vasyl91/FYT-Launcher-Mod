package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode$Enum;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTPath2DImpl extends XmlComplexContentImpl implements CTPath2D {
    private static final QName CLOSE$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "close");
    private static final QName MOVETO$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "moveTo");
    private static final QName LNTO$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lnTo");
    private static final QName ARCTO$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "arcTo");
    private static final QName QUADBEZTO$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "quadBezTo");
    private static final QName CUBICBEZTO$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cubicBezTo");
    private static final QName W$12 = new QName("", "w");
    private static final QName H$14 = new QName("", "h");
    private static final QName FILL$16 = new QName("", "fill");
    private static final QName STROKE$18 = new QName("", "stroke");
    private static final QName EXTRUSIONOK$20 = new QName("", "extrusionOk");

    public CTPath2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo addNewArcTo() {
        CTPath2DArcTo cTPath2DArcToAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcToAdd_element_user = get_store().add_element_user(ARCTO$6);
        }
        return cTPath2DArcToAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose addNewClose() {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().add_element_user(CLOSE$0);
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo addNewCubicBezTo() {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().add_element_user(CUBICBEZTO$10);
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo addNewLnTo() {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().add_element_user(LNTO$4);
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo addNewMoveTo() {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().add_element_user(MOVETO$2);
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo addNewQuadBezTo() {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().add_element_user(QUADBEZTO$8);
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo getArcToArray(int i) {
        CTPath2DArcTo cTPath2DArcToFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcToFind_element_user = get_store().find_element_user(ARCTO$6, i);
            if (cTPath2DArcToFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DArcToFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo[] getArcToArray() {
        CTPath2DArcTo[] cTPath2DArcToArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ARCTO$6, arrayList);
            cTPath2DArcToArr = new CTPath2DArcTo[arrayList.size()];
            arrayList.toArray(cTPath2DArcToArr);
        }
        return cTPath2DArcToArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DArcTo> getArcToList() {
        1ArcToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ArcToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose getCloseArray(int i) {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().find_element_user(CLOSE$0, i);
            if (cTPath2DClose == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose[] getCloseArray() {
        CTPath2DClose[] cTPath2DCloseArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CLOSE$0, arrayList);
            cTPath2DCloseArr = new CTPath2DClose[arrayList.size()];
            arrayList.toArray(cTPath2DCloseArr);
        }
        return cTPath2DCloseArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DClose> getCloseList() {
        1CloseList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CloseList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo getCubicBezToArray(int i) {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().find_element_user(CUBICBEZTO$10, i);
            if (cTPath2DCubicBezierTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo[] getCubicBezToArray() {
        CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUBICBEZTO$10, arrayList);
            cTPath2DCubicBezierToArr = new CTPath2DCubicBezierTo[arrayList.size()];
            arrayList.toArray(cTPath2DCubicBezierToArr);
        }
        return cTPath2DCubicBezierToArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DCubicBezierTo> getCubicBezToList() {
        1CubicBezToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CubicBezToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean getExtrusionOk() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTRUSIONOK$20;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPathFillMode$Enum getFill() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return (STPathFillMode$Enum) simpleValueFind_attribute_user.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public long getH() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = H$14;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo getLnToArray(int i) {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().find_element_user(LNTO$4, i);
            if (cTPath2DLineTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo[] getLnToArray() {
        CTPath2DLineTo[] cTPath2DLineToArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LNTO$4, arrayList);
            cTPath2DLineToArr = new CTPath2DLineTo[arrayList.size()];
            arrayList.toArray(cTPath2DLineToArr);
        }
        return cTPath2DLineToArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DLineTo> getLnToList() {
        1LnToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LnToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo getMoveToArray(int i) {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().find_element_user(MOVETO$2, i);
            if (cTPath2DMoveTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo[] getMoveToArray() {
        CTPath2DMoveTo[] cTPath2DMoveToArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$2, arrayList);
            cTPath2DMoveToArr = new CTPath2DMoveTo[arrayList.size()];
            arrayList.toArray(cTPath2DMoveToArr);
        }
        return cTPath2DMoveToArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DMoveTo> getMoveToList() {
        1MoveToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1MoveToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo getQuadBezToArray(int i) {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().find_element_user(QUADBEZTO$8, i);
            if (cTPath2DQuadBezierTo == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo[] getQuadBezToArray() {
        CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(QUADBEZTO$8, arrayList);
            cTPath2DQuadBezierToArr = new CTPath2DQuadBezierTo[arrayList.size()];
            arrayList.toArray(cTPath2DQuadBezierToArr);
        }
        return cTPath2DQuadBezierToArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public List<CTPath2DQuadBezierTo> getQuadBezToList() {
        1QuadBezToList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1QuadBezToList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean getStroke() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKE$18;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public long getW() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DArcTo insertNewArcTo(int i) {
        CTPath2DArcTo cTPath2DArcToInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DArcToInsert_element_user = get_store().insert_element_user(ARCTO$6, i);
        }
        return cTPath2DArcToInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DClose insertNewClose(int i) {
        CTPath2DClose cTPath2DClose;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DClose = (CTPath2DClose) get_store().insert_element_user(CLOSE$0, i);
        }
        return cTPath2DClose;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DCubicBezierTo insertNewCubicBezTo(int i) {
        CTPath2DCubicBezierTo cTPath2DCubicBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) get_store().insert_element_user(CUBICBEZTO$10, i);
        }
        return cTPath2DCubicBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DLineTo insertNewLnTo(int i) {
        CTPath2DLineTo cTPath2DLineTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DLineTo = (CTPath2DLineTo) get_store().insert_element_user(LNTO$4, i);
        }
        return cTPath2DLineTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DMoveTo insertNewMoveTo(int i) {
        CTPath2DMoveTo cTPath2DMoveTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DMoveTo = (CTPath2DMoveTo) get_store().insert_element_user(MOVETO$2, i);
        }
        return cTPath2DMoveTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public CTPath2DQuadBezierTo insertNewQuadBezTo(int i) {
        CTPath2DQuadBezierTo cTPath2DQuadBezierTo;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) get_store().insert_element_user(QUADBEZTO$8, i);
        }
        return cTPath2DQuadBezierTo;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetExtrusionOk() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXTRUSIONOK$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILL$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetH() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(H$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetStroke() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(W$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeArcTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARCTO$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeClose(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLOSE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeCubicBezTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUBICBEZTO$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeLnTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LNTO$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void removeQuadBezTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(QUADBEZTO$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setArcToArray(int i, CTPath2DArcTo cTPath2DArcTo) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DArcTo cTPath2DArcToFind_element_user = get_store().find_element_user(ARCTO$6, i);
            if (cTPath2DArcToFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DArcToFind_element_user.set(cTPath2DArcTo);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setArcToArray(CTPath2DArcTo[] cTPath2DArcToArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPath2DArcToArr, ARCTO$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCloseArray(int i, CTPath2DClose cTPath2DClose) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DClose cTPath2DClose2 = (CTPath2DClose) get_store().find_element_user(CLOSE$0, i);
            if (cTPath2DClose2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DClose2.set(cTPath2DClose);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCloseArray(CTPath2DClose[] cTPath2DCloseArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DCloseArr, CLOSE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCubicBezToArray(int i, CTPath2DCubicBezierTo cTPath2DCubicBezierTo) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DCubicBezierTo cTPath2DCubicBezierTo2 = (CTPath2DCubicBezierTo) get_store().find_element_user(CUBICBEZTO$10, i);
            if (cTPath2DCubicBezierTo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DCubicBezierTo2.set(cTPath2DCubicBezierTo);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setCubicBezToArray(CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DCubicBezierToArr, CUBICBEZTO$10);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setExtrusionOk(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTRUSIONOK$20;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setFill(STPathFillMode$Enum sTPathFillMode$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setEnumValue(sTPathFillMode$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setH(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = H$14;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setLnToArray(int i, CTPath2DLineTo cTPath2DLineTo) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DLineTo cTPath2DLineTo2 = (CTPath2DLineTo) get_store().find_element_user(LNTO$4, i);
            if (cTPath2DLineTo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DLineTo2.set(cTPath2DLineTo);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setLnToArray(CTPath2DLineTo[] cTPath2DLineToArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DLineToArr, LNTO$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setMoveToArray(int i, CTPath2DMoveTo cTPath2DMoveTo) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DMoveTo cTPath2DMoveTo2 = (CTPath2DMoveTo) get_store().find_element_user(MOVETO$2, i);
            if (cTPath2DMoveTo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DMoveTo2.set(cTPath2DMoveTo);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setMoveToArray(CTPath2DMoveTo[] cTPath2DMoveToArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DMoveToArr, MOVETO$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setQuadBezToArray(int i, CTPath2DQuadBezierTo cTPath2DQuadBezierTo) {
        synchronized (monitor()) {
            check_orphaned();
            CTPath2DQuadBezierTo cTPath2DQuadBezierTo2 = (CTPath2DQuadBezierTo) get_store().find_element_user(QUADBEZTO$8, i);
            if (cTPath2DQuadBezierTo2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTPath2DQuadBezierTo2.set(cTPath2DQuadBezierTo);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setQuadBezToArray(CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DQuadBezierToArr, QUADBEZTO$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setStroke(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKE$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void setW(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$12;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfArcToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ARCTO$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfCloseArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CLOSE$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfCubicBezToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUBICBEZTO$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfLnToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LNTO$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public int sizeOfQuadBezToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(QUADBEZTO$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetExtrusionOk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXTRUSIONOK$20);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILL$16);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetH() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(H$14);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetStroke() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKE$18);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(W$12);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public XmlBoolean xgetExtrusionOk() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTRUSIONOK$20;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPathFillMode xgetFill() {
        STPathFillMode sTPathFillModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$16;
            sTPathFillModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPathFillModeFind_attribute_user == null) {
                sTPathFillModeFind_attribute_user = (STPathFillMode) get_default_attribute_value(qName);
            }
        }
        return sTPathFillModeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPositiveCoordinate xgetH() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = H$14;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qName);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public XmlBoolean xgetStroke() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKE$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public STPositiveCoordinate xgetW() {
        STPositiveCoordinate sTPositiveCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$12;
            sTPositiveCoordinate = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate == null) {
                sTPositiveCoordinate = (STPositiveCoordinate) get_default_attribute_value(qName);
            }
        }
        return sTPositiveCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetExtrusionOk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTRUSIONOK$20;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetFill(STPathFillMode sTPathFillMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILL$16;
            STPathFillMode sTPathFillModeFind_attribute_user = typeStore.find_attribute_user(qName);
            if (sTPathFillModeFind_attribute_user == null) {
                sTPathFillModeFind_attribute_user = (STPathFillMode) get_store().add_attribute_user(qName);
            }
            sTPathFillModeFind_attribute_user.set(sTPathFillMode);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetH(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = H$14;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetStroke(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STROKE$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D
    public void xsetW(STPositiveCoordinate sTPositiveCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$12;
            STPositiveCoordinate sTPositiveCoordinate2 = (STPositiveCoordinate) typeStore.find_attribute_user(qName);
            if (sTPositiveCoordinate2 == null) {
                sTPositiveCoordinate2 = (STPositiveCoordinate) get_store().add_attribute_user(qName);
            }
            sTPositiveCoordinate2.set(sTPositiveCoordinate);
        }
    }
}
