package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface DataValidation {

    public static final class ErrorStyle {
        public static final int INFO = 2;
        public static final int STOP = 0;
        public static final int WARNING = 1;
    }

    void createErrorBox(String str, String str2);

    void createPromptBox(String str, String str2);

    boolean getEmptyCellAllowed();

    String getErrorBoxText();

    String getErrorBoxTitle();

    int getErrorStyle();

    String getPromptBoxText();

    String getPromptBoxTitle();

    CellRangeAddressList getRegions();

    boolean getShowErrorBox();

    boolean getShowPromptBox();

    boolean getSuppressDropDownArrow();

    DataValidationConstraint getValidationConstraint();

    void setEmptyCellAllowed(boolean z);

    void setErrorStyle(int i);

    void setShowErrorBox(boolean z);

    void setShowPromptBox(boolean z);

    void setSuppressDropDownArrow(boolean z);
}
