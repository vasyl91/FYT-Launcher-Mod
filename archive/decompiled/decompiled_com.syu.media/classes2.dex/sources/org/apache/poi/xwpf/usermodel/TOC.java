package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TOC {
    CTSdtBlock block;

    public TOC() {
        this(CTSdtBlock.Factory.newInstance());
    }

    public TOC(CTSdtBlock cTSdtBlock) {
        this.block = cTSdtBlock;
        CTSdtPr cTSdtPrAddNewSdtPr = cTSdtBlock.addNewSdtPr();
        cTSdtPrAddNewSdtPr.addNewId().setVal(new BigInteger("4844945"));
        cTSdtPrAddNewSdtPr.addNewDocPartObj().addNewDocPartGallery().setVal("Table of contents");
        CTRPr cTRPrAddNewRPr = cTSdtBlock.addNewSdtEndPr().addNewRPr();
        CTFonts cTFontsAddNewRFonts = cTRPrAddNewRPr.addNewRFonts();
        cTFontsAddNewRFonts.setAsciiTheme(STTheme.MINOR_H_ANSI);
        cTFontsAddNewRFonts.setEastAsiaTheme(STTheme.MINOR_H_ANSI);
        cTFontsAddNewRFonts.setHAnsiTheme(STTheme.MINOR_H_ANSI);
        cTFontsAddNewRFonts.setCstheme(STTheme.MINOR_BIDI);
        cTRPrAddNewRPr.addNewB().setVal(STOnOff.OFF);
        cTRPrAddNewRPr.addNewBCs().setVal(STOnOff.OFF);
        cTRPrAddNewRPr.addNewColor().setVal(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        cTRPrAddNewRPr.addNewSz().setVal(new BigInteger("24"));
        cTRPrAddNewRPr.addNewSzCs().setVal(new BigInteger("24"));
        CTP ctpAddNewP = cTSdtBlock.addNewSdtContent().addNewP();
        ctpAddNewP.setRsidR("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
        ctpAddNewP.setRsidRDefault("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
        ctpAddNewP.addNewPPr().addNewPStyle().setVal("TOCHeading");
        ctpAddNewP.addNewR().addNewT().setStringValue("Table of Contents");
    }

    @Internal
    public CTSdtBlock getBlock() {
        return this.block;
    }

    public void addRow(int i, String str, int i2, String str2) {
        CTP ctpAddNewP = this.block.getSdtContent().addNewP();
        ctpAddNewP.setRsidR("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
        ctpAddNewP.setRsidRDefault("00EF7E24".getBytes(LocaleUtil.CHARSET_1252));
        CTPPr cTPPrAddNewPPr = ctpAddNewP.addNewPPr();
        cTPPrAddNewPPr.addNewPStyle().setVal("TOC" + i);
        CTTabStop cTTabStopAddNewTab = cTPPrAddNewPPr.addNewTabs().addNewTab();
        cTTabStopAddNewTab.setVal(STTabJc.RIGHT);
        cTTabStopAddNewTab.setLeader(STTabTlc.DOT);
        cTTabStopAddNewTab.setPos(new BigInteger("8290"));
        cTPPrAddNewPPr.addNewRPr().addNewNoProof();
        CTR ctrAddNewR = ctpAddNewP.addNewR();
        ctrAddNewR.addNewRPr().addNewNoProof();
        ctrAddNewR.addNewT().setStringValue(str);
        CTR ctrAddNewR2 = ctpAddNewP.addNewR();
        ctrAddNewR2.addNewRPr().addNewNoProof();
        ctrAddNewR2.addNewTab();
        CTR ctrAddNewR3 = ctpAddNewP.addNewR();
        ctrAddNewR3.addNewRPr().addNewNoProof();
        ctrAddNewR3.addNewFldChar().setFldCharType(STFldCharType.BEGIN);
        CTR ctrAddNewR4 = ctpAddNewP.addNewR();
        ctrAddNewR4.addNewRPr().addNewNoProof();
        CTText cTTextAddNewInstrText = ctrAddNewR4.addNewInstrText();
        cTTextAddNewInstrText.setSpace(SpaceAttribute.Space.PRESERVE);
        cTTextAddNewInstrText.setStringValue(" PAGEREF _Toc" + str2 + " \\h ");
        ctpAddNewP.addNewR().addNewRPr().addNewNoProof();
        CTR ctrAddNewR5 = ctpAddNewP.addNewR();
        ctrAddNewR5.addNewRPr().addNewNoProof();
        ctrAddNewR5.addNewFldChar().setFldCharType(STFldCharType.SEPARATE);
        CTR ctrAddNewR6 = ctpAddNewP.addNewR();
        ctrAddNewR6.addNewRPr().addNewNoProof();
        ctrAddNewR6.addNewT().setStringValue(Integer.toString(i2));
        CTR ctrAddNewR7 = ctpAddNewP.addNewR();
        ctrAddNewR7.addNewRPr().addNewNoProof();
        ctrAddNewR7.addNewFldChar().setFldCharType(STFldCharType.END);
    }
}
