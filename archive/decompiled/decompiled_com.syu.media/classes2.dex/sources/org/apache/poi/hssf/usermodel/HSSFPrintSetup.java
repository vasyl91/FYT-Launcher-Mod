package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.ss.usermodel.PrintSetup;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFPrintSetup implements PrintSetup {
    PrintSetupRecord printSetupRecord;

    protected HSSFPrintSetup(PrintSetupRecord printSetupRecord) {
        this.printSetupRecord = printSetupRecord;
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPaperSize(short s) {
        this.printSetupRecord.setPaperSize(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setScale(short s) {
        this.printSetupRecord.setScale(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setPageStart(short s) {
        this.printSetupRecord.setPageStart(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitWidth(short s) {
        this.printSetupRecord.setFitWidth(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFitHeight(short s) {
        this.printSetupRecord.setFitHeight(s);
    }

    public void setOptions(short s) {
        this.printSetupRecord.setOptions(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLeftToRight(boolean z) {
        this.printSetupRecord.setLeftToRight(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setLandscape(boolean z) {
        this.printSetupRecord.setLandscape(!z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setValidSettings(boolean z) {
        this.printSetupRecord.setValidSettings(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoColor(boolean z) {
        this.printSetupRecord.setNoColor(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setDraft(boolean z) {
        this.printSetupRecord.setDraft(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNotes(boolean z) {
        this.printSetupRecord.setNotes(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setNoOrientation(boolean z) {
        this.printSetupRecord.setNoOrientation(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setUsePage(boolean z) {
        this.printSetupRecord.setUsePage(z);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHResolution(short s) {
        this.printSetupRecord.setHResolution(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setVResolution(short s) {
        this.printSetupRecord.setVResolution(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setHeaderMargin(double d) {
        this.printSetupRecord.setHeaderMargin(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setFooterMargin(double d) {
        this.printSetupRecord.setFooterMargin(d);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public void setCopies(short s) {
        this.printSetupRecord.setCopies(s);
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPaperSize() {
        return this.printSetupRecord.getPaperSize();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getScale() {
        return this.printSetupRecord.getScale();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getPageStart() {
        return this.printSetupRecord.getPageStart();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitWidth() {
        return this.printSetupRecord.getFitWidth();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getFitHeight() {
        return this.printSetupRecord.getFitHeight();
    }

    public short getOptions() {
        return this.printSetupRecord.getOptions();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLeftToRight() {
        return this.printSetupRecord.getLeftToRight();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getLandscape() {
        return !this.printSetupRecord.getLandscape();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getValidSettings() {
        return this.printSetupRecord.getValidSettings();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoColor() {
        return this.printSetupRecord.getNoColor();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getDraft() {
        return this.printSetupRecord.getDraft();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNotes() {
        return this.printSetupRecord.getNotes();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getNoOrientation() {
        return this.printSetupRecord.getNoOrientation();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public boolean getUsePage() {
        return this.printSetupRecord.getUsePage();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getHResolution() {
        return this.printSetupRecord.getHResolution();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getVResolution() {
        return this.printSetupRecord.getVResolution();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getHeaderMargin() {
        return this.printSetupRecord.getHeaderMargin();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public double getFooterMargin() {
        return this.printSetupRecord.getFooterMargin();
    }

    @Override // org.apache.poi.ss.usermodel.PrintSetup
    public short getCopies() {
        return this.printSetupRecord.getCopies();
    }
}
