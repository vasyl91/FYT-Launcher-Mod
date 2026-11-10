package org.apache.poi.xssf.usermodel;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFHyperlink implements Hyperlink {
    private final CTHyperlink _ctHyperlink;
    private final PackageRelationship _externalRel;
    private String _location;
    private final HyperlinkType _type;

    protected XSSFHyperlink(HyperlinkType hyperlinkType) {
        this._type = hyperlinkType;
        this._ctHyperlink = CTHyperlink.Factory.newInstance();
        this._externalRel = null;
    }

    protected XSSFHyperlink(CTHyperlink cTHyperlink, PackageRelationship packageRelationship) {
        this._ctHyperlink = cTHyperlink;
        this._externalRel = packageRelationship;
        if (packageRelationship == null) {
            if (cTHyperlink.getLocation() != null) {
                this._type = HyperlinkType.DOCUMENT;
                this._location = cTHyperlink.getLocation();
                return;
            } else {
                if (cTHyperlink.getId() != null) {
                    throw new IllegalStateException("The hyperlink for cell " + cTHyperlink.getRef() + " references relation " + cTHyperlink.getId() + ", but that didn't exist!");
                }
                this._type = HyperlinkType.DOCUMENT;
                return;
            }
        }
        this._location = packageRelationship.getTargetURI().toString();
        if (cTHyperlink.getLocation() != null) {
            this._location += "#" + cTHyperlink.getLocation();
        }
        if (this._location.startsWith("http://") || this._location.startsWith("https://") || this._location.startsWith("ftp://")) {
            this._type = HyperlinkType.URL;
        } else if (this._location.startsWith("mailto:")) {
            this._type = HyperlinkType.EMAIL;
        } else {
            this._type = HyperlinkType.FILE;
        }
    }

    @Internal
    public XSSFHyperlink(Hyperlink hyperlink) {
        if (hyperlink instanceof XSSFHyperlink) {
            XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
            this._type = xSSFHyperlink.getTypeEnum();
            this._location = xSSFHyperlink._location;
            this._externalRel = xSSFHyperlink._externalRel;
            this._ctHyperlink = xSSFHyperlink._ctHyperlink.copy();
            return;
        }
        this._type = hyperlink.getTypeEnum();
        this._location = hyperlink.getAddress();
        this._externalRel = null;
        this._ctHyperlink = CTHyperlink.Factory.newInstance();
        setCellReference(new CellReference(hyperlink.getFirstRow(), hyperlink.getFirstColumn()));
    }

    @Internal
    public CTHyperlink getCTHyperlink() {
        return this._ctHyperlink;
    }

    public boolean needsRelationToo() {
        return this._type != HyperlinkType.DOCUMENT;
    }

    protected void generateRelationIfNeeded(PackagePart packagePart) {
        if (this._externalRel == null && needsRelationToo()) {
            this._ctHyperlink.setId(packagePart.addExternalRelationship(this._location, XSSFRelation.SHEET_HYPERLINKS.getRelation()).getId());
        }
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public int getType() {
        return this._type.getCode();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public HyperlinkType getTypeEnum() {
        return this._type;
    }

    public String getCellRef() {
        return this._ctHyperlink.getRef();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        return this._location;
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this._ctHyperlink.getDisplay();
    }

    public String getLocation() {
        return this._ctHyperlink.getLocation();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this._ctHyperlink.setDisplay(str);
    }

    public void setLocation(String str) {
        this._ctHyperlink.setLocation(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        validate(str);
        this._location = str;
        if (this._type == HyperlinkType.DOCUMENT) {
            setLocation(str);
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFHyperlink$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType;

        static {
            int[] iArr = new int[HyperlinkType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = iArr;
            try {
                iArr[HyperlinkType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void validate(String str) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[this._type.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                throw new IllegalStateException("Invalid Hyperlink type: " + this._type);
            }
        } else {
            try {
                new URI(str);
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Address of hyperlink must be a valid URI", e);
            }
        }
    }

    @Internal
    public void setCellReference(String str) {
        this._ctHyperlink.setRef(str);
    }

    @Internal
    public void setCellReference(CellReference cellReference) {
        setCellReference(cellReference.formatAsString());
    }

    private CellReference buildCellReference() {
        String ref = this._ctHyperlink.getRef();
        if (ref == null) {
            ref = "A1";
        }
        return new CellReference(ref);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstColumn() {
        return buildCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastColumn() {
        return buildCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstRow() {
        return buildCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastRow() {
        return buildCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstColumn(int i) {
        setCellReference(new CellReference(getFirstRow(), i));
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastColumn(int i) {
        setFirstColumn(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstRow(int i) {
        setCellReference(new CellReference(i, getFirstColumn()));
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastRow(int i) {
        setFirstRow(i);
    }

    public String getTooltip() {
        return this._ctHyperlink.getTooltip();
    }

    public void setTooltip(String str) {
        this._ctHyperlink.setTooltip(str);
    }
}
