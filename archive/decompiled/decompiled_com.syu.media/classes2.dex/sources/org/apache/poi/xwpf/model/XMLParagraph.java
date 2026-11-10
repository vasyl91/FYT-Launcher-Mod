package org.apache.poi.xwpf.model;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
@Deprecated
public class XMLParagraph {
    protected CTP paragraph;

    public XMLParagraph(CTP ctp) {
        this.paragraph = ctp;
    }

    public CTP getCTP() {
        return this.paragraph;
    }
}
