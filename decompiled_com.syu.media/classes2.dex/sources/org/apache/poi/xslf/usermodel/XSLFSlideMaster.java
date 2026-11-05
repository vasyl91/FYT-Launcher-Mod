package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFSlideMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private Map<String, XSLFSlideLayout> _layouts;
    private CTSlideMaster _slide;
    private XSLFTheme _theme;

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFSlideMaster getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "sldMaster";
    }

    XSLFSlideMaster() {
        this._slide = CTSlideMaster.Factory.newInstance();
    }

    protected XSLFSlideMaster(PackagePart packagePart) throws XmlException, IOException {
        super(packagePart);
        CTSlideMaster sldMaster = SldMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldMaster();
        this._slide = sldMaster;
        setCommonSlideData(sldMaster.getCSld());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlideMaster getXmlObject() {
        return this._slide;
    }

    private Map<String, XSLFSlideLayout> getLayouts() {
        if (this._layouts == null) {
            this._layouts = new HashMap();
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout) pOIXMLDocumentPart;
                    this._layouts.put(xSLFSlideLayout.getName().toLowerCase(Locale.ROOT), xSLFSlideLayout);
                }
            }
        }
        return this._layouts;
    }

    public XSLFSlideLayout[] getSlideLayouts() {
        return (XSLFSlideLayout[]) getLayouts().values().toArray(new XSLFSlideLayout[this._layouts.size()]);
    }

    public XSLFSlideLayout getLayout(SlideLayout slideLayout) {
        for (XSLFSlideLayout xSLFSlideLayout : getLayouts().values()) {
            if (xSLFSlideLayout.getType() == slideLayout) {
                return xSLFSlideLayout;
            }
        }
        return null;
    }

    public XSLFSlideLayout getLayout(String str) {
        return getLayouts().get(str.toLowerCase(Locale.ROOT));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) pOIXMLDocumentPart;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap == null) {
                        break;
                    }
                    this._theme.initColorMap(clrMap);
                    break;
                }
            }
        }
        return this._theme;
    }

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFSlideMaster$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CENTERED_TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.SUBTITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected CTTextListStyle getTextProperties(Placeholder placeholder) {
        CTSlideMasterTextStyles txStyles = getXmlObject().getTxStyles();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[placeholder.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return txStyles.getTitleStyle();
        }
        if (i == 4) {
            return txStyles.getBodyStyle();
        }
        return txStyles.getOtherStyle();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected boolean canDraw(XSLFShape xSLFShape) {
        return !(xSLFShape instanceof XSLFSimpleShape) || ((XSLFSimpleShape) xSLFShape).getCTPlaceholder() == null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return null;
    }
}
