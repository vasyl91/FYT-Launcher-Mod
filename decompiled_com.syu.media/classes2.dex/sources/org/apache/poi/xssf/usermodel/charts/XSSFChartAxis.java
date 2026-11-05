package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisOrientation;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.AxisTickMark;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class XSSFChartAxis implements ChartAxis {
    private static final double MAX_LOG_BASE = 1000.0d;
    private static final double MIN_LOG_BASE = 2.0d;
    protected XSSFChart chart;

    protected abstract CTAxPos getCTAxPos();

    protected abstract CTCrosses getCTCrosses();

    protected abstract CTNumFmt getCTNumFmt();

    protected abstract CTScaling getCTScaling();

    protected abstract CTBoolean getDelete();

    @Internal
    public abstract CTShapeProperties getLine();

    protected abstract CTTickMark getMajorCTTickMark();

    @Internal
    public abstract CTChartLines getMajorGridLines();

    protected abstract CTTickMark getMinorCTTickMark();

    protected XSSFChartAxis(XSSFChart xSSFChart) {
        this.chart = xSSFChart;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public AxisPosition getPosition() {
        return toAxisPosition(getCTAxPos());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setPosition(AxisPosition axisPosition) {
        getCTAxPos().setVal(fromAxisPosition(axisPosition));
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setNumberFormat(String str) {
        getCTNumFmt().setFormatCode(str);
        getCTNumFmt().setSourceLinked(true);
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public String getNumberFormat() {
        return getCTNumFmt().getFormatCode();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean isSetLogBase() {
        return getCTScaling().isSetLogBase();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setLogBase(double d) {
        if (d < MIN_LOG_BASE || MAX_LOG_BASE < d) {
            throw new IllegalArgumentException("Axis log base must be between 2 and 1000 (inclusive), got: " + d);
        }
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetLogBase()) {
            cTScaling.getLogBase().setVal(d);
        } else {
            cTScaling.addNewLogBase().setVal(d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public double getLogBase() {
        CTLogBase logBase = getCTScaling().getLogBase();
        if (logBase != null) {
            return logBase.getVal();
        }
        return 0.0d;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean isSetMinimum() {
        return getCTScaling().isSetMin();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setMinimum(double d) {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMin()) {
            cTScaling.getMin().setVal(d);
        } else {
            cTScaling.addNewMin().setVal(d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public double getMinimum() {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMin()) {
            return cTScaling.getMin().getVal();
        }
        return 0.0d;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean isSetMaximum() {
        return getCTScaling().isSetMax();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setMaximum(double d) {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMax()) {
            cTScaling.getMax().setVal(d);
        } else {
            cTScaling.addNewMax().setVal(d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public double getMaximum() {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMax()) {
            return cTScaling.getMax().getVal();
        }
        return 0.0d;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public AxisOrientation getOrientation() {
        return toAxisOrientation(getCTScaling().getOrientation());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setOrientation(AxisOrientation axisOrientation) {
        CTScaling cTScaling = getCTScaling();
        STOrientation.Enum enumFromAxisOrientation = fromAxisOrientation(axisOrientation);
        if (cTScaling.isSetOrientation()) {
            cTScaling.getOrientation().setVal(enumFromAxisOrientation);
        } else {
            getCTScaling().addNewOrientation().setVal(enumFromAxisOrientation);
        }
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public AxisCrosses getCrosses() {
        return toAxisCrosses(getCTCrosses());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setCrosses(AxisCrosses axisCrosses) {
        getCTCrosses().setVal(fromAxisCrosses(axisCrosses));
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public boolean isVisible() {
        return !getDelete().getVal();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setVisible(boolean z) {
        getDelete().setVal(!z);
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public AxisTickMark getMajorTickMark() {
        return toAxisTickMark(getMajorCTTickMark());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setMajorTickMark(AxisTickMark axisTickMark) {
        getMajorCTTickMark().setVal(fromAxisTickMark(axisTickMark));
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public AxisTickMark getMinorTickMark() {
        return toAxisTickMark(getMinorCTTickMark());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartAxis
    public void setMinorTickMark(AxisTickMark axisTickMark) {
        getMinorCTTickMark().setVal(fromAxisTickMark(axisTickMark));
    }

    private static STOrientation.Enum fromAxisOrientation(AxisOrientation axisOrientation) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$AxisOrientation[axisOrientation.ordinal()];
        if (i == 1) {
            return STOrientation.MIN_MAX;
        }
        if (i == 2) {
            return STOrientation.MAX_MIN;
        }
        throw new IllegalArgumentException();
    }

    private static AxisOrientation toAxisOrientation(CTOrientation cTOrientation) {
        int iIntValue = cTOrientation.getVal().intValue();
        if (iIntValue == 1) {
            return AxisOrientation.MAX_MIN;
        }
        if (iIntValue == 2) {
            return AxisOrientation.MIN_MAX;
        }
        throw new IllegalArgumentException();
    }

    private static STCrosses.Enum fromAxisCrosses(AxisCrosses axisCrosses) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrosses[axisCrosses.ordinal()];
        if (i == 1) {
            return STCrosses.AUTO_ZERO;
        }
        if (i == 2) {
            return STCrosses.MIN;
        }
        if (i == 3) {
            return STCrosses.MAX;
        }
        throw new IllegalArgumentException();
    }

    private static AxisCrosses toAxisCrosses(CTCrosses cTCrosses) {
        int iIntValue = cTCrosses.getVal().intValue();
        if (iIntValue == 1) {
            return AxisCrosses.AUTO_ZERO;
        }
        if (iIntValue == 2) {
            return AxisCrosses.MAX;
        }
        if (iIntValue == 3) {
            return AxisCrosses.MIN;
        }
        throw new IllegalArgumentException();
    }

    private static STAxPos.Enum fromAxisPosition(AxisPosition axisPosition) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition[axisPosition.ordinal()];
        if (i == 1) {
            return STAxPos.B;
        }
        if (i == 2) {
            return STAxPos.L;
        }
        if (i == 3) {
            return STAxPos.R;
        }
        if (i == 4) {
            return STAxPos.T;
        }
        throw new IllegalArgumentException();
    }

    private static AxisPosition toAxisPosition(CTAxPos cTAxPos) {
        int iIntValue = cTAxPos.getVal().intValue();
        if (iIntValue == 1) {
            return AxisPosition.BOTTOM;
        }
        if (iIntValue == 2) {
            return AxisPosition.LEFT;
        }
        if (iIntValue == 3) {
            return AxisPosition.RIGHT;
        }
        if (iIntValue == 4) {
            return AxisPosition.TOP;
        }
        return AxisPosition.BOTTOM;
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.charts.XSSFChartAxis$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrosses;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisOrientation;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark;

        static {
            int[] iArr = new int[AxisTickMark.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark = iArr;
            try {
                iArr[AxisTickMark.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark[AxisTickMark.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark[AxisTickMark.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark[AxisTickMark.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[AxisPosition.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition = iArr2;
            try {
                iArr2[AxisPosition.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition[AxisPosition.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition[AxisPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisPosition[AxisPosition.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[AxisCrosses.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrosses = iArr3;
            try {
                iArr3[AxisCrosses.AUTO_ZERO.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrosses[AxisCrosses.MIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisCrosses[AxisCrosses.MAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[AxisOrientation.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisOrientation = iArr4;
            try {
                iArr4[AxisOrientation.MIN_MAX.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$AxisOrientation[AxisOrientation.MAX_MIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static STTickMark.Enum fromAxisTickMark(AxisTickMark axisTickMark) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$AxisTickMark[axisTickMark.ordinal()];
        if (i == 1) {
            return STTickMark.NONE;
        }
        if (i == 2) {
            return STTickMark.IN;
        }
        if (i == 3) {
            return STTickMark.OUT;
        }
        if (i == 4) {
            return STTickMark.CROSS;
        }
        throw new IllegalArgumentException("Unknown AxisTickMark: " + axisTickMark);
    }

    private static AxisTickMark toAxisTickMark(CTTickMark cTTickMark) {
        int iIntValue = cTTickMark.getVal().intValue();
        if (iIntValue == 1) {
            return AxisTickMark.CROSS;
        }
        if (iIntValue == 2) {
            return AxisTickMark.IN;
        }
        if (iIntValue == 3) {
            return AxisTickMark.NONE;
        }
        if (iIntValue == 4) {
            return AxisTickMark.OUT;
        }
        return AxisTickMark.CROSS;
    }
}
