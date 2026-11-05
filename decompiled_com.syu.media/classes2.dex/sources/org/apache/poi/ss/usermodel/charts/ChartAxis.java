package org.apache.poi.ss.usermodel.charts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface ChartAxis {
    void crossAxis(ChartAxis chartAxis);

    AxisCrosses getCrosses();

    long getId();

    double getLogBase();

    AxisTickMark getMajorTickMark();

    double getMaximum();

    double getMinimum();

    AxisTickMark getMinorTickMark();

    String getNumberFormat();

    AxisOrientation getOrientation();

    AxisPosition getPosition();

    boolean hasNumberFormat();

    boolean isSetLogBase();

    boolean isSetMaximum();

    boolean isSetMinimum();

    boolean isVisible();

    void setCrosses(AxisCrosses axisCrosses);

    void setLogBase(double d);

    void setMajorTickMark(AxisTickMark axisTickMark);

    void setMaximum(double d);

    void setMinimum(double d);

    void setMinorTickMark(AxisTickMark axisTickMark);

    void setNumberFormat(String str);

    void setOrientation(AxisOrientation axisOrientation);

    void setPosition(AxisPosition axisPosition);

    void setVisible(boolean z);
}
