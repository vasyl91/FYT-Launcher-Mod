package org.apache.poi.xssf.usermodel.charts;

import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class XSSFChartLegend implements ChartLegend {
    private CTLegend legend;

    public XSSFChartLegend(XSSFChart xSSFChart) {
        CTChart cTChart = xSSFChart.getCTChart();
        this.legend = cTChart.isSetLegend() ? cTChart.getLegend() : cTChart.addNewLegend();
        setDefaults();
    }

    private void setDefaults() {
        if (!this.legend.isSetOverlay()) {
            this.legend.addNewOverlay();
        }
        this.legend.getOverlay().setVal(false);
    }

    @Internal
    public CTLegend getCTLegend() {
        return this.legend;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartLegend
    public void setPosition(LegendPosition legendPosition) {
        if (!this.legend.isSetLegendPos()) {
            this.legend.addNewLegendPos();
        }
        this.legend.getLegendPos().setVal(fromLegendPosition(legendPosition));
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartLegend
    public LegendPosition getPosition() {
        if (this.legend.isSetLegendPos()) {
            return toLegendPosition(this.legend.getLegendPos());
        }
        return LegendPosition.RIGHT;
    }

    @Override // org.apache.poi.ss.usermodel.charts.ManuallyPositionable
    public XSSFManualLayout getManualLayout() {
        if (!this.legend.isSetLayout()) {
            this.legend.addNewLayout();
        }
        return new XSSFManualLayout(this.legend.getLayout());
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartLegend
    public boolean isOverlay() {
        return this.legend.getOverlay().getVal();
    }

    @Override // org.apache.poi.ss.usermodel.charts.ChartLegend
    public void setOverlay(boolean z) {
        this.legend.getOverlay().setVal(z);
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.charts.XSSFChartLegend$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition;

        static {
            int[] iArr = new int[LegendPosition.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition = iArr;
            try {
                iArr[LegendPosition.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition[LegendPosition.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition[LegendPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition[LegendPosition.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition[LegendPosition.TOP_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private STLegendPos.Enum fromLegendPosition(LegendPosition legendPosition) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$charts$LegendPosition[legendPosition.ordinal()];
        if (i == 1) {
            return STLegendPos.B;
        }
        if (i == 2) {
            return STLegendPos.L;
        }
        if (i == 3) {
            return STLegendPos.R;
        }
        if (i == 4) {
            return STLegendPos.T;
        }
        if (i == 5) {
            return STLegendPos.TR;
        }
        throw new IllegalArgumentException();
    }

    private LegendPosition toLegendPosition(CTLegendPos cTLegendPos) {
        int iIntValue = cTLegendPos.getVal().intValue();
        if (iIntValue == 1) {
            return LegendPosition.BOTTOM;
        }
        if (iIntValue == 2) {
            return LegendPosition.TOP_RIGHT;
        }
        if (iIntValue == 3) {
            return LegendPosition.LEFT;
        }
        if (iIntValue == 4) {
            return LegendPosition.RIGHT;
        }
        if (iIntValue == 5) {
            return LegendPosition.TOP;
        }
        throw new IllegalArgumentException();
    }
}
