package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Connection", namespace = XSSFRelation.NS_DRAWINGML)
public class CTConnection {

    @XmlAttribute(required = true)
    protected long id;

    @XmlSchemaType(name = "unsignedInt")
    @XmlAttribute(required = true)
    protected long idx;

    public boolean isSetId() {
        return true;
    }

    public boolean isSetIdx() {
        return true;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getIdx() {
        return this.idx;
    }

    public void setIdx(long j) {
        this.idx = j;
    }
}
