package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class GenericSection extends XDGFSection {
    @Override // org.apache.poi.xdgf.usermodel.section.XDGFSection
    public void setupMaster(XDGFSection xDGFSection) {
    }

    public GenericSection(SectionType sectionType, XDGFSheet xDGFSheet) {
        super(sectionType, xDGFSheet);
    }
}
