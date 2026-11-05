package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XWPFRelation extends POIXMLRelation {
    private static final Map<String, XWPFRelation> _table = new HashMap();
    public static final XWPFRelation DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
    public static final XWPFRelation TEMPLATE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
    public static final XWPFRelation MACRO_DOCUMENT = new XWPFRelation("application/vnd.ms-word.document.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
    public static final XWPFRelation MACRO_TEMPLATE_DOCUMENT = new XWPFRelation("application/vnd.ms-word.template.macroEnabledTemplate.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/word/document.xml", null);
    public static final XWPFRelation GLOSSARY_DOCUMENT = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.document.glossary+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/glossaryDocument", "/word/glossary/document.xml", null);
    public static final XWPFRelation NUMBERING = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering", "/word/numbering.xml", XWPFNumbering.class);
    public static final XWPFRelation FONT_TABLE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable", "/word/fontTable.xml", null);
    public static final XWPFRelation SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings", "/word/settings.xml", XWPFSettings.class);
    public static final XWPFRelation STYLES = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", PackageRelationshipTypes.STYLE_PART, "/word/styles.xml", XWPFStyles.class);
    public static final XWPFRelation WEB_SETTINGS = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/webSettings", "/word/webSettings.xml", null);
    public static final XWPFRelation HEADER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.header+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header", "/word/header#.xml", XWPFHeader.class);
    public static final XWPFRelation FOOTER = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer", "/word/footer#.xml", XWPFFooter.class);
    public static final XWPFRelation THEME = new XWPFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/word/theme/theme#.xml", null);
    public static final XWPFRelation HYPERLINK = new XWPFRelation(null, PackageRelationshipTypes.HYPERLINK_PART, null, null);
    public static final XWPFRelation COMMENT = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", null, null);
    public static final XWPFRelation FOOTNOTE = new XWPFRelation("application/vnd.openxmlformats-officedocument.wordprocessingml.footnotes+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footnotes", "/word/footnotes.xml", XWPFFootnotes.class);
    public static final XWPFRelation ENDNOTE = new XWPFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/endnotes", null, null);
    public static final XWPFRelation IMAGE_EMF = new XWPFRelation("image/x-emf", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.emf", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_WMF = new XWPFRelation("image/x-wmf", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.wmf", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_PICT = new XWPFRelation(ContentTypes.IMAGE_PICT, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.pict", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_JPEG = new XWPFRelation(ContentTypes.IMAGE_JPEG, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.jpeg", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_PNG = new XWPFRelation(ContentTypes.IMAGE_PNG, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.png", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_DIB = new XWPFRelation("image/dib", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.dib", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_GIF = new XWPFRelation(ContentTypes.IMAGE_GIF, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.gif", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_TIFF = new XWPFRelation(ContentTypes.IMAGE_TIFF, PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.tiff", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_EPS = new XWPFRelation("image/x-eps", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.eps", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_BMP = new XWPFRelation("image/x-ms-bmp", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.bmp", XWPFPictureData.class);
    public static final XWPFRelation IMAGE_WPG = new XWPFRelation("image/x-wpg", PackageRelationshipTypes.IMAGE_PART, "/word/media/image#.wpg", XWPFPictureData.class);
    public static final XWPFRelation IMAGES = new XWPFRelation(null, PackageRelationshipTypes.IMAGE_PART, null, XWPFPictureData.class);

    private XWPFRelation(String str, String str2, String str3, Class<? extends POIXMLDocumentPart> cls) {
        super(str, str2, str3, cls);
        _table.put(str2, this);
    }

    public static XWPFRelation getInstance(String str) {
        return _table.get(str);
    }
}
