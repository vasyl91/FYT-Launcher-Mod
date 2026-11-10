package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.SldLayoutDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFSlideLayout extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private CTSlideLayout _layout;
    private XSLFSlideMaster _master;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "sldLayout";
    }

    XSLFSlideLayout() {
        this._layout = CTSlideLayout.Factory.newInstance();
    }

    public XSLFSlideLayout(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        CTSlideLayout sldLayout = SldLayoutDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldLayout();
        this._layout = sldLayout;
        setCommonSlideData(sldLayout.getCSld());
    }

    public String getName() {
        return this._layout.getCSld().getName();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    @Internal
    public CTSlideLayout getXmlObject() {
        return this._layout;
    }

    public XSLFSlideMaster getSlideMaster() {
        if (this._master == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideMaster) {
                    this._master = (XSLFSlideMaster) pOIXMLDocumentPart;
                }
            }
        }
        XSLFSlideMaster xSLFSlideMaster = this._master;
        if (xSLFSlideMaster != null) {
            return xSLFSlideMaster;
        }
        throw new IllegalStateException("SlideMaster was not found for " + this);
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFSlideMaster getMasterSheet() {
        return getSlideMaster();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getSlideMaster().getTheme();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return this._layout.getShowMasterSp();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected boolean canDraw(XSLFShape xSLFShape) {
        return !(xSLFShape instanceof XSLFSimpleShape) || ((XSLFSimpleShape) xSLFShape).getCTPlaceholder() == null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._layout.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return getMasterSheet().getBackground();
    }

    public void copyLayout(XSLFSlide xSLFSlide) {
        XSLFTextShape xSLFTextShape;
        Placeholder textType;
        int i;
        for (XSLFShape xSLFShape : getShapes()) {
            if ((xSLFShape instanceof XSLFTextShape) && (textType = (xSLFTextShape = (XSLFTextShape) xSLFShape).getTextType()) != null && (i = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[textType.ordinal()]) != 1 && i != 2 && i != 3) {
                xSLFSlide.getSpTree().addNewSp().set(xSLFTextShape.getXmlObject().copy());
            }
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFSlideLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.DATETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SLIDE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.FOOTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SlideLayout getType() {
        return SlideLayout.values()[this._layout.getType().intValue() - 1];
    }
}
