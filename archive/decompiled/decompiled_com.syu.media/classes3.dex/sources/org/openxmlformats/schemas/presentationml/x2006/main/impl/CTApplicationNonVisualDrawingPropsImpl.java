package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CTApplicationNonVisualDrawingPropsImpl extends XmlComplexContentImpl implements CTApplicationNonVisualDrawingProps {
    private static final QName PH$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "ph");
    private static final QName AUDIOCD$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "audioCd");
    private static final QName WAVAUDIOFILE$4 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "wavAudioFile");
    private static final QName AUDIOFILE$6 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "audioFile");
    private static final QName VIDEOFILE$8 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "videoFile");
    private static final QName QUICKTIMEFILE$10 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "quickTimeFile");
    private static final QName CUSTDATALST$12 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
    private static final QName EXTLST$14 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName ISPHOTO$16 = new QName("", "isPhoto");
    private static final QName USERDRAWN$18 = new QName("", "userDrawn");

    public CTApplicationNonVisualDrawingPropsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTAudioCD addNewAudioCd() {
        CTAudioCD cTAudioCDAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAudioCDAdd_element_user = get_store().add_element_user(AUDIOCD$2);
        }
        return cTAudioCDAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTAudioFile addNewAudioFile() {
        CTAudioFile cTAudioFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAudioFileAdd_element_user = get_store().add_element_user(AUDIOFILE$6);
        }
        return cTAudioFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTCustomerDataList addNewCustDataLst() {
        CTCustomerDataList cTCustomerDataList;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataList = (CTCustomerDataList) get_store().add_element_user(CUSTDATALST$12);
        }
        return cTCustomerDataList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListAdd_element_user = get_store().add_element_user(EXTLST$14);
        }
        return cTExtensionListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTPlaceholder addNewPh() {
        CTPlaceholder cTPlaceholder;
        synchronized (monitor()) {
            check_orphaned();
            cTPlaceholder = (CTPlaceholder) get_store().add_element_user(PH$0);
        }
        return cTPlaceholder;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTQuickTimeFile addNewQuickTimeFile() {
        CTQuickTimeFile cTQuickTimeFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTQuickTimeFileAdd_element_user = get_store().add_element_user(QUICKTIMEFILE$10);
        }
        return cTQuickTimeFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTVideoFile addNewVideoFile() {
        CTVideoFile cTVideoFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTVideoFileAdd_element_user = get_store().add_element_user(VIDEOFILE$8);
        }
        return cTVideoFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTEmbeddedWAVAudioFile addNewWavAudioFile() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileAdd_element_user = get_store().add_element_user(WAVAUDIOFILE$4);
        }
        return cTEmbeddedWAVAudioFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTAudioCD getAudioCd() {
        synchronized (monitor()) {
            check_orphaned();
            CTAudioCD cTAudioCDFind_element_user = get_store().find_element_user(AUDIOCD$2, 0);
            if (cTAudioCDFind_element_user == null) {
                return null;
            }
            return cTAudioCDFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTAudioFile getAudioFile() {
        synchronized (monitor()) {
            check_orphaned();
            CTAudioFile cTAudioFileFind_element_user = get_store().find_element_user(AUDIOFILE$6, 0);
            if (cTAudioFileFind_element_user == null) {
                return null;
            }
            return cTAudioFileFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTCustomerDataList getCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTCustomerDataList cTCustomerDataList = (CTCustomerDataList) get_store().find_element_user(CUSTDATALST$12, 0);
            if (cTCustomerDataList == null) {
                return null;
            }
            return cTCustomerDataList;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList cTExtensionListFind_element_user = get_store().find_element_user(EXTLST$14, 0);
            if (cTExtensionListFind_element_user == null) {
                return null;
            }
            return cTExtensionListFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean getIsPhoto() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISPHOTO$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTPlaceholder getPh() {
        synchronized (monitor()) {
            check_orphaned();
            CTPlaceholder cTPlaceholder = (CTPlaceholder) get_store().find_element_user(PH$0, 0);
            if (cTPlaceholder == null) {
                return null;
            }
            return cTPlaceholder;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTQuickTimeFile getQuickTimeFile() {
        synchronized (monitor()) {
            check_orphaned();
            CTQuickTimeFile cTQuickTimeFileFind_element_user = get_store().find_element_user(QUICKTIMEFILE$10, 0);
            if (cTQuickTimeFileFind_element_user == null) {
                return null;
            }
            return cTQuickTimeFileFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean getUserDrawn() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$18;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTVideoFile getVideoFile() {
        synchronized (monitor()) {
            check_orphaned();
            CTVideoFile cTVideoFileFind_element_user = get_store().find_element_user(VIDEOFILE$8, 0);
            if (cTVideoFileFind_element_user == null) {
                return null;
            }
            return cTVideoFileFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public CTEmbeddedWAVAudioFile getWavAudioFile() {
        synchronized (monitor()) {
            check_orphaned();
            CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user = get_store().find_element_user(WAVAUDIOFILE$4, 0);
            if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                return null;
            }
            return cTEmbeddedWAVAudioFileFind_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetAudioCd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUDIOCD$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetAudioFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(AUDIOFILE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetCustDataLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTDATALST$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetIsPhoto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISPHOTO$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetPh() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PH$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetQuickTimeFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(QUICKTIMEFILE$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetUserDrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetVideoFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VIDEOFILE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public boolean isSetWavAudioFile() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(WAVAUDIOFILE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setAudioCd(CTAudioCD cTAudioCD) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUDIOCD$2;
            CTAudioCD cTAudioCDFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAudioCDFind_element_user == null) {
                cTAudioCDFind_element_user = (CTAudioCD) get_store().add_element_user(qName);
            }
            cTAudioCDFind_element_user.set(cTAudioCD);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setAudioFile(CTAudioFile cTAudioFile) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = AUDIOFILE$6;
            CTAudioFile cTAudioFileFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTAudioFileFind_element_user == null) {
                cTAudioFileFind_element_user = (CTAudioFile) get_store().add_element_user(qName);
            }
            cTAudioFileFind_element_user.set(cTAudioFile);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setCustDataLst(CTCustomerDataList cTCustomerDataList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CUSTDATALST$12;
            CTCustomerDataList cTCustomerDataList2 = (CTCustomerDataList) typeStore.find_element_user(qName, 0);
            if (cTCustomerDataList2 == null) {
                cTCustomerDataList2 = (CTCustomerDataList) get_store().add_element_user(qName);
            }
            cTCustomerDataList2.set(cTCustomerDataList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$14;
            CTExtensionList cTExtensionListFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTExtensionListFind_element_user == null) {
                cTExtensionListFind_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            cTExtensionListFind_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setIsPhoto(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISPHOTO$16;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setPh(CTPlaceholder cTPlaceholder) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PH$0;
            CTPlaceholder cTPlaceholder2 = (CTPlaceholder) typeStore.find_element_user(qName, 0);
            if (cTPlaceholder2 == null) {
                cTPlaceholder2 = (CTPlaceholder) get_store().add_element_user(qName);
            }
            cTPlaceholder2.set(cTPlaceholder);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setQuickTimeFile(CTQuickTimeFile cTQuickTimeFile) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUICKTIMEFILE$10;
            CTQuickTimeFile cTQuickTimeFileFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTQuickTimeFileFind_element_user == null) {
                cTQuickTimeFileFind_element_user = (CTQuickTimeFile) get_store().add_element_user(qName);
            }
            cTQuickTimeFileFind_element_user.set(cTQuickTimeFile);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setUserDrawn(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$18;
            SimpleValue simpleValueFind_attribute_user = typeStore.find_attribute_user(qName);
            if (simpleValueFind_attribute_user == null) {
                simpleValueFind_attribute_user = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValueFind_attribute_user.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setVideoFile(CTVideoFile cTVideoFile) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VIDEOFILE$8;
            CTVideoFile cTVideoFileFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTVideoFileFind_element_user == null) {
                cTVideoFileFind_element_user = (CTVideoFile) get_store().add_element_user(qName);
            }
            cTVideoFileFind_element_user.set(cTVideoFile);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void setWavAudioFile(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = WAVAUDIOFILE$4;
            CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user = typeStore.find_element_user(qName, 0);
            if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                cTEmbeddedWAVAudioFileFind_element_user = (CTEmbeddedWAVAudioFile) get_store().add_element_user(qName);
            }
            cTEmbeddedWAVAudioFileFind_element_user.set(cTEmbeddedWAVAudioFile);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetAudioCd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUDIOCD$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetAudioFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUDIOFILE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDATALST$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetIsPhoto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISPHOTO$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetPh() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PH$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetQuickTimeFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(QUICKTIMEFILE$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetUserDrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetVideoFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VIDEOFILE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void unsetWavAudioFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(WAVAUDIOFILE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public XmlBoolean xgetIsPhoto() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISPHOTO$16;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public XmlBoolean xgetUserDrawn() {
        XmlBoolean xmlBooleanFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$18;
            xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBooleanFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void xsetIsPhoto(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISPHOTO$16;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps
    public void xsetUserDrawn(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = USERDRAWN$18;
            XmlBoolean xmlBooleanFind_attribute_user = typeStore.find_attribute_user(qName);
            if (xmlBooleanFind_attribute_user == null) {
                xmlBooleanFind_attribute_user = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBooleanFind_attribute_user.set(xmlBoolean);
        }
    }
}
