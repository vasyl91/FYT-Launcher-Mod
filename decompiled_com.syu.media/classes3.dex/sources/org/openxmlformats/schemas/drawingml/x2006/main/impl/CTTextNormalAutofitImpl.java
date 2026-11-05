package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontScalePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTTextNormalAutofitImpl extends XmlComplexContentImpl implements CTTextNormalAutofit {
    private static final QName FONTSCALE$0 = new QName("", "fontScale");
    private static final QName LNSPCREDUCTION$2 = new QName("", "lnSpcReduction");

    public CTTextNormalAutofitImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public int getFontScale() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTSCALE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public int getLnSpcReduction() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNSPCREDUCTION$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValueFind_attribute_user == null) {
                return 0;
            }
            return simpleValueFind_attribute_user.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public boolean isSetFontScale() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FONTSCALE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public boolean isSetLnSpcReduction() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LNSPCREDUCTION$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void setFontScale(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTSCALE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void setLnSpcReduction(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNSPCREDUCTION$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void unsetFontScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FONTSCALE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void unsetLnSpcReduction() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LNSPCREDUCTION$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public STTextFontScalePercent xgetFontScale() {
        STTextFontScalePercent sTTextFontScalePercent;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTSCALE$0;
            sTTextFontScalePercent = (STTextFontScalePercent) typeStore.find_attribute_user(qName);
            if (sTTextFontScalePercent == null) {
                sTTextFontScalePercent = (STTextFontScalePercent) get_default_attribute_value(qName);
            }
        }
        return sTTextFontScalePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public STTextSpacingPercent xgetLnSpcReduction() {
        STTextSpacingPercent sTTextSpacingPercent;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNSPCREDUCTION$2;
            sTTextSpacingPercent = (STTextSpacingPercent) typeStore.find_attribute_user(qName);
            if (sTTextSpacingPercent == null) {
                sTTextSpacingPercent = (STTextSpacingPercent) get_default_attribute_value(qName);
            }
        }
        return sTTextSpacingPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void xsetFontScale(STTextFontScalePercent sTTextFontScalePercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTSCALE$0;
            STTextFontScalePercent sTTextFontScalePercent2 = (STTextFontScalePercent) typeStore.find_attribute_user(qName);
            if (sTTextFontScalePercent2 == null) {
                sTTextFontScalePercent2 = (STTextFontScalePercent) get_store().add_attribute_user(qName);
            }
            sTTextFontScalePercent2.set(sTTextFontScalePercent);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void xsetLnSpcReduction(STTextSpacingPercent sTTextSpacingPercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LNSPCREDUCTION$2;
            STTextSpacingPercent sTTextSpacingPercent2 = (STTextSpacingPercent) typeStore.find_attribute_user(qName);
            if (sTTextSpacingPercent2 == null) {
                sTTextSpacingPercent2 = (STTextSpacingPercent) get_store().add_attribute_user(qName);
            }
            sTTextSpacingPercent2.set(sTTextSpacingPercent);
        }
    }
}
