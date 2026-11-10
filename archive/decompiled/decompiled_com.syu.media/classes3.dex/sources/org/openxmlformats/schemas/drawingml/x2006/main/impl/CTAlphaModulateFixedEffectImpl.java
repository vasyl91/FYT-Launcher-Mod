package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositivePercentage;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTAlphaModulateFixedEffectImpl extends XmlComplexContentImpl implements CTAlphaModulateFixedEffect {
    private static final QName AMT$0 = new QName("", "amt");

    public CTAlphaModulateFixedEffectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public int getAmt() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AMT$0;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public boolean isSetAmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AMT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public void setAmt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AMT$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public void unsetAmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AMT$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public STPositivePercentage xgetAmt() {
        STPositivePercentage sTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AMT$0;
            sTPositivePercentage = (STPositivePercentage) typeStore.find_attribute_user(qName);
            if (sTPositivePercentage == null) {
                sTPositivePercentage = (STPositivePercentage) get_default_attribute_value(qName);
            }
        }
        return sTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect
    public void xsetAmt(STPositivePercentage sTPositivePercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AMT$0;
            STPositivePercentage sTPositivePercentage2 = (STPositivePercentage) typeStore.find_attribute_user(qName);
            if (sTPositivePercentage2 == null) {
                sTPositivePercentage2 = (STPositivePercentage) get_store().add_attribute_user(qName);
            }
            sTPositivePercentage2.set(sTPositivePercentage);
        }
    }
}
