package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTBlip extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTBlip.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctblip034ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBlip newInstance() {
            return (CTBlip) POIXMLTypeLoader.newInstance(CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip newInstance(XmlOptions xmlOptions) {
            return (CTBlip) POIXMLTypeLoader.newInstance(CTBlip.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlip.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(File file) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(file, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(file, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(InputStream inputStream) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(inputStream, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(inputStream, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(Reader reader) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(reader, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(reader, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(String str) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(str, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(str, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(URL url) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(url, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTBlip) POIXMLTypeLoader.parse(url, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(xMLStreamReader, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(xMLStreamReader, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(xMLInputStream, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(xMLInputStream, CTBlip.type, xmlOptions);
        }

        public static CTBlip parse(Node node) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(node, CTBlip.type, (XmlOptions) null);
        }

        public static CTBlip parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTBlip) POIXMLTypeLoader.parse(node, CTBlip.type, xmlOptions);
        }
    }

    CTAlphaBiLevelEffect addNewAlphaBiLevel();

    CTAlphaCeilingEffect addNewAlphaCeiling();

    CTAlphaFloorEffect addNewAlphaFloor();

    CTAlphaInverseEffect addNewAlphaInv();

    CTAlphaModulateEffect addNewAlphaMod();

    CTAlphaModulateFixedEffect addNewAlphaModFix();

    CTAlphaReplaceEffect addNewAlphaRepl();

    CTBiLevelEffect addNewBiLevel();

    CTBlurEffect addNewBlur();

    CTColorChangeEffect addNewClrChange();

    CTColorReplaceEffect addNewClrRepl();

    CTDuotoneEffect addNewDuotone();

    CTOfficeArtExtensionList addNewExtLst();

    CTFillOverlayEffect addNewFillOverlay();

    CTGrayscaleEffect addNewGrayscl();

    CTHSLEffect addNewHsl();

    CTLuminanceEffect addNewLum();

    CTTintEffect addNewTint();

    CTAlphaBiLevelEffect getAlphaBiLevelArray(int i);

    CTAlphaBiLevelEffect[] getAlphaBiLevelArray();

    List<CTAlphaBiLevelEffect> getAlphaBiLevelList();

    CTAlphaCeilingEffect getAlphaCeilingArray(int i);

    CTAlphaCeilingEffect[] getAlphaCeilingArray();

    List<CTAlphaCeilingEffect> getAlphaCeilingList();

    CTAlphaFloorEffect getAlphaFloorArray(int i);

    CTAlphaFloorEffect[] getAlphaFloorArray();

    List<CTAlphaFloorEffect> getAlphaFloorList();

    CTAlphaInverseEffect getAlphaInvArray(int i);

    CTAlphaInverseEffect[] getAlphaInvArray();

    List<CTAlphaInverseEffect> getAlphaInvList();

    CTAlphaModulateEffect getAlphaModArray(int i);

    CTAlphaModulateEffect[] getAlphaModArray();

    CTAlphaModulateFixedEffect getAlphaModFixArray(int i);

    CTAlphaModulateFixedEffect[] getAlphaModFixArray();

    List<CTAlphaModulateFixedEffect> getAlphaModFixList();

    List<CTAlphaModulateEffect> getAlphaModList();

    CTAlphaReplaceEffect getAlphaReplArray(int i);

    CTAlphaReplaceEffect[] getAlphaReplArray();

    List<CTAlphaReplaceEffect> getAlphaReplList();

    CTBiLevelEffect getBiLevelArray(int i);

    CTBiLevelEffect[] getBiLevelArray();

    List<CTBiLevelEffect> getBiLevelList();

    CTBlurEffect getBlurArray(int i);

    CTBlurEffect[] getBlurArray();

    List<CTBlurEffect> getBlurList();

    CTColorChangeEffect getClrChangeArray(int i);

    CTColorChangeEffect[] getClrChangeArray();

    List<CTColorChangeEffect> getClrChangeList();

    CTColorReplaceEffect getClrReplArray(int i);

    CTColorReplaceEffect[] getClrReplArray();

    List<CTColorReplaceEffect> getClrReplList();

    STBlipCompression$Enum getCstate();

    CTDuotoneEffect getDuotoneArray(int i);

    CTDuotoneEffect[] getDuotoneArray();

    List<CTDuotoneEffect> getDuotoneList();

    String getEmbed();

    CTOfficeArtExtensionList getExtLst();

    CTFillOverlayEffect getFillOverlayArray(int i);

    CTFillOverlayEffect[] getFillOverlayArray();

    List<CTFillOverlayEffect> getFillOverlayList();

    CTGrayscaleEffect getGraysclArray(int i);

    CTGrayscaleEffect[] getGraysclArray();

    List<CTGrayscaleEffect> getGraysclList();

    CTHSLEffect getHslArray(int i);

    CTHSLEffect[] getHslArray();

    List<CTHSLEffect> getHslList();

    String getLink();

    CTLuminanceEffect getLumArray(int i);

    CTLuminanceEffect[] getLumArray();

    List<CTLuminanceEffect> getLumList();

    CTTintEffect getTintArray(int i);

    CTTintEffect[] getTintArray();

    List<CTTintEffect> getTintList();

    CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i);

    CTAlphaCeilingEffect insertNewAlphaCeiling(int i);

    CTAlphaFloorEffect insertNewAlphaFloor(int i);

    CTAlphaInverseEffect insertNewAlphaInv(int i);

    CTAlphaModulateEffect insertNewAlphaMod(int i);

    CTAlphaModulateFixedEffect insertNewAlphaModFix(int i);

    CTAlphaReplaceEffect insertNewAlphaRepl(int i);

    CTBiLevelEffect insertNewBiLevel(int i);

    CTBlurEffect insertNewBlur(int i);

    CTColorChangeEffect insertNewClrChange(int i);

    CTColorReplaceEffect insertNewClrRepl(int i);

    CTDuotoneEffect insertNewDuotone(int i);

    CTFillOverlayEffect insertNewFillOverlay(int i);

    CTGrayscaleEffect insertNewGrayscl(int i);

    CTHSLEffect insertNewHsl(int i);

    CTLuminanceEffect insertNewLum(int i);

    CTTintEffect insertNewTint(int i);

    boolean isSetCstate();

    boolean isSetEmbed();

    boolean isSetExtLst();

    boolean isSetLink();

    void removeAlphaBiLevel(int i);

    void removeAlphaCeiling(int i);

    void removeAlphaFloor(int i);

    void removeAlphaInv(int i);

    void removeAlphaMod(int i);

    void removeAlphaModFix(int i);

    void removeAlphaRepl(int i);

    void removeBiLevel(int i);

    void removeBlur(int i);

    void removeClrChange(int i);

    void removeClrRepl(int i);

    void removeDuotone(int i);

    void removeFillOverlay(int i);

    void removeGrayscl(int i);

    void removeHsl(int i);

    void removeLum(int i);

    void removeTint(int i);

    void setAlphaBiLevelArray(int i, CTAlphaBiLevelEffect cTAlphaBiLevelEffect);

    void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr);

    void setAlphaCeilingArray(int i, CTAlphaCeilingEffect cTAlphaCeilingEffect);

    void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr);

    void setAlphaFloorArray(int i, CTAlphaFloorEffect cTAlphaFloorEffect);

    void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr);

    void setAlphaInvArray(int i, CTAlphaInverseEffect cTAlphaInverseEffect);

    void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr);

    void setAlphaModArray(int i, CTAlphaModulateEffect cTAlphaModulateEffect);

    void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr);

    void setAlphaModFixArray(int i, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect);

    void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr);

    void setAlphaReplArray(int i, CTAlphaReplaceEffect cTAlphaReplaceEffect);

    void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr);

    void setBiLevelArray(int i, CTBiLevelEffect cTBiLevelEffect);

    void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr);

    void setBlurArray(int i, CTBlurEffect cTBlurEffect);

    void setBlurArray(CTBlurEffect[] cTBlurEffectArr);

    void setClrChangeArray(int i, CTColorChangeEffect cTColorChangeEffect);

    void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr);

    void setClrReplArray(int i, CTColorReplaceEffect cTColorReplaceEffect);

    void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr);

    void setCstate(STBlipCompression$Enum sTBlipCompression$Enum);

    void setDuotoneArray(int i, CTDuotoneEffect cTDuotoneEffect);

    void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr);

    void setEmbed(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFillOverlayArray(int i, CTFillOverlayEffect cTFillOverlayEffect);

    void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr);

    void setGraysclArray(int i, CTGrayscaleEffect cTGrayscaleEffect);

    void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr);

    void setHslArray(int i, CTHSLEffect cTHSLEffect);

    void setHslArray(CTHSLEffect[] cTHSLEffectArr);

    void setLink(String str);

    void setLumArray(int i, CTLuminanceEffect cTLuminanceEffect);

    void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr);

    void setTintArray(int i, CTTintEffect cTTintEffect);

    void setTintArray(CTTintEffect[] cTTintEffectArr);

    int sizeOfAlphaBiLevelArray();

    int sizeOfAlphaCeilingArray();

    int sizeOfAlphaFloorArray();

    int sizeOfAlphaInvArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaModFixArray();

    int sizeOfAlphaReplArray();

    int sizeOfBiLevelArray();

    int sizeOfBlurArray();

    int sizeOfClrChangeArray();

    int sizeOfClrReplArray();

    int sizeOfDuotoneArray();

    int sizeOfFillOverlayArray();

    int sizeOfGraysclArray();

    int sizeOfHslArray();

    int sizeOfLumArray();

    int sizeOfTintArray();

    void unsetCstate();

    void unsetEmbed();

    void unsetExtLst();

    void unsetLink();

    STBlipCompression xgetCstate();

    STRelationshipId xgetEmbed();

    STRelationshipId xgetLink();

    void xsetCstate(STBlipCompression sTBlipCompression);

    void xsetEmbed(STRelationshipId sTRelationshipId);

    void xsetLink(STRelationshipId sTRelationshipId);
}
