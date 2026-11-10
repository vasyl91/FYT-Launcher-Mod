package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.STXstring;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTNumFmtImpl extends XmlComplexContentImpl implements CTNumFmt {
    private static final QName FORMATCODE$0 = new QName("", "formatCode");
    private static final QName SOURCELINKED$2 = new QName("", "sourceLinked");

    public CTNumFmtImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public String getFormatCode() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(FORMATCODE$0);
            if (simpleValueFind_attribute_user == null) {
                return null;
            }
            return simpleValueFind_attribute_user.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public boolean getSourceLinked() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValueFind_attribute_user = get_store().find_attribute_user(SOURCELINKED$2);
            if (simpleValueFind_attribute_user == null) {
                return false;
            }
            return simpleValueFind_attribute_user.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public boolean isSetSourceLinked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SOURCELINKED$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public void setFormatCode(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$0;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public void setSourceLinked(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOURCELINKED$2;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public void unsetSourceLinked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SOURCELINKED$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public STXstring xgetFormatCode() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(FORMATCODE$0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public XmlBoolean xgetSourceLinked() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            xmlBooleanFind_attribute_user = get_store().find_attribute_user(SOURCELINKED$2);
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public void xsetFormatCode(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FORMATCODE$0;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qName);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qName);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt
    public void xsetSourceLinked(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SOURCELINKED$2;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
