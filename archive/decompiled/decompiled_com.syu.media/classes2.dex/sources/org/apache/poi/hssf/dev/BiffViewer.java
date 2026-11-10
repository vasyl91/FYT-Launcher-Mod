package org.apache.poi.hssf.dev;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import module.canbus.FinalCanbus;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.AutoFilterInfoRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BackupRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BottomMarginRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.CalcCountRecord;
import org.apache.poi.hssf.record.CalcModeRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.ContinueRecord;
import org.apache.poi.hssf.record.CountryRecord;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DConRefRecord;
import org.apache.poi.hssf.record.DSFRecord;
import org.apache.poi.hssf.record.DVALRecord;
import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.hssf.record.DateWindow1904Record;
import org.apache.poi.hssf.record.DefaultColWidthRecord;
import org.apache.poi.hssf.record.DefaultRowHeightRecord;
import org.apache.poi.hssf.record.DeltaRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.DrawingRecordForBiffViewer;
import org.apache.poi.hssf.record.DrawingSelectionRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.ExtSSTRecord;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.ExternSheetRecord;
import org.apache.poi.hssf.record.ExternalNameRecord;
import org.apache.poi.hssf.record.FeatHdrRecord;
import org.apache.poi.hssf.record.FeatRecord;
import org.apache.poi.hssf.record.FilePassRecord;
import org.apache.poi.hssf.record.FileSharingRecord;
import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.GridsetRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.HCenterRecord;
import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.HideObjRecord;
import org.apache.poi.hssf.record.HorizontalPageBreakRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.IndexRecord;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.apache.poi.hssf.record.IterationRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.LeftMarginRecord;
import org.apache.poi.hssf.record.MMSRecord;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.MulRKRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.PaneRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.PasswordRev4Record;
import org.apache.poi.hssf.record.PrecisionRecord;
import org.apache.poi.hssf.record.PrintGridlinesRecord;
import org.apache.poi.hssf.record.PrintHeadersRecord;
import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.ProtectionRev4Record;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.RecalcIdRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.RefModeRecord;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.apache.poi.hssf.record.RightMarginRecord;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.SaveRecalcRecord;
import org.apache.poi.hssf.record.SelectionRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.SupBookRecord;
import org.apache.poi.hssf.record.TabIdRecord;
import org.apache.poi.hssf.record.TableRecord;
import org.apache.poi.hssf.record.TableStylesRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.hssf.record.TopMarginRecord;
import org.apache.poi.hssf.record.UncalcedRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.UseSelFSRecord;
import org.apache.poi.hssf.record.VCenterRecord;
import org.apache.poi.hssf.record.VerticalPageBreakRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.WindowOneRecord;
import org.apache.poi.hssf.record.WindowProtectRecord;
import org.apache.poi.hssf.record.WindowTwoRecord;
import org.apache.poi.hssf.record.WriteAccessRecord;
import org.apache.poi.hssf.record.WriteProtectRecord;
import org.apache.poi.hssf.record.chart.AreaFormatRecord;
import org.apache.poi.hssf.record.chart.AreaRecord;
import org.apache.poi.hssf.record.chart.AxisLineFormatRecord;
import org.apache.poi.hssf.record.chart.AxisOptionsRecord;
import org.apache.poi.hssf.record.chart.AxisParentRecord;
import org.apache.poi.hssf.record.chart.AxisRecord;
import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.apache.poi.hssf.record.chart.BarRecord;
import org.apache.poi.hssf.record.chart.BeginRecord;
import org.apache.poi.hssf.record.chart.CatLabRecord;
import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
import org.apache.poi.hssf.record.chart.ChartEndBlockRecord;
import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
import org.apache.poi.hssf.record.chart.ChartFRTInfoRecord;
import org.apache.poi.hssf.record.chart.ChartFormatRecord;
import org.apache.poi.hssf.record.chart.ChartRecord;
import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.hssf.record.chart.DefaultDataLabelTextPropertiesRecord;
import org.apache.poi.hssf.record.chart.EndRecord;
import org.apache.poi.hssf.record.chart.FontBasisRecord;
import org.apache.poi.hssf.record.chart.FontIndexRecord;
import org.apache.poi.hssf.record.chart.FrameRecord;
import org.apache.poi.hssf.record.chart.LegendRecord;
import org.apache.poi.hssf.record.chart.LineFormatRecord;
import org.apache.poi.hssf.record.chart.LinkedDataRecord;
import org.apache.poi.hssf.record.chart.ObjectLinkRecord;
import org.apache.poi.hssf.record.chart.PlotAreaRecord;
import org.apache.poi.hssf.record.chart.PlotGrowthRecord;
import org.apache.poi.hssf.record.chart.SeriesIndexRecord;
import org.apache.poi.hssf.record.chart.SeriesListRecord;
import org.apache.poi.hssf.record.chart.SeriesRecord;
import org.apache.poi.hssf.record.chart.SeriesTextRecord;
import org.apache.poi.hssf.record.chart.SeriesToChartGroupRecord;
import org.apache.poi.hssf.record.chart.SheetPropertiesRecord;
import org.apache.poi.hssf.record.chart.TextRecord;
import org.apache.poi.hssf.record.chart.TickRecord;
import org.apache.poi.hssf.record.chart.UnitsRecord;
import org.apache.poi.hssf.record.chart.ValueRangeRecord;
import org.apache.poi.hssf.record.pivottable.DataItemRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.PageItemRecord;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.apache.poi.hssf.record.pivottable.ViewDefinitionRecord;
import org.apache.poi.hssf.record.pivottable.ViewFieldsRecord;
import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class BiffViewer {
    private static final int DUMP_LINE_LEN = 16;
    private static final char[] NEW_LINE_CHARS = System.getProperty("line.separator").toCharArray();
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) BiffViewer.class);
    private static final char[] COLUMN_SEPARATOR = " | ".toCharArray();

    private interface IBiffRecordListener {
        void processRecord(int i, int i2, int i3, int i4, byte[] bArr);
    }

    private static char getPrintableChar(byte b) {
        char c = (char) (b & UByte.MAX_VALUE);
        if (c < ' ' || c > '~') {
            return '.';
        }
        return c;
    }

    private BiffViewer() {
    }

    public static Record[] createRecords(InputStream inputStream, PrintWriter printWriter, BiffRecordListener biffRecordListener, boolean z) throws RecordFormatException {
        boolean zHasNextRecord;
        ArrayList arrayList = new ArrayList();
        RecordInputStream recordInputStream = new RecordInputStream(inputStream);
        while (true) {
            try {
                zHasNextRecord = recordInputStream.hasNextRecord();
            } catch (RecordInputStream.LeftoverDataException e) {
                logger.log(7, "Discarding " + recordInputStream.remaining() + " bytes and continuing", e);
                recordInputStream.readRemainder();
                zHasNextRecord = recordInputStream.hasNextRecord();
            }
            if (zHasNextRecord) {
                recordInputStream.nextRecord();
                if (recordInputStream.getSid() != 0) {
                    if (z) {
                        Record recordCreateRecord = createRecord(recordInputStream);
                        if (recordCreateRecord.getSid() != 60) {
                            arrayList.add(recordCreateRecord);
                            Iterator<String> it = biffRecordListener.getRecentHeaders().iterator();
                            while (it.hasNext()) {
                                printWriter.println(it.next());
                            }
                            printWriter.print(recordCreateRecord);
                        }
                    } else {
                        recordInputStream.readRemainder();
                    }
                    printWriter.println();
                }
            } else {
                Record[] recordArr = new Record[arrayList.size()];
                arrayList.toArray(recordArr);
                return recordArr;
            }
        }
    }

    private static Record createRecord(RecordInputStream recordInputStream) {
        short sid = recordInputStream.getSid();
        if (sid == 34) {
            return new DateWindow1904Record(recordInputStream);
        }
        if (sid == 35) {
            return new ExternalNameRecord(recordInputStream);
        }
        if (sid == 60) {
            return new ContinueRecord(recordInputStream);
        }
        if (sid == 61) {
            return new WindowOneRecord(recordInputStream);
        }
        if (sid == 140) {
            return new CountryRecord(recordInputStream);
        }
        if (sid == 141) {
            return new HideObjRecord(recordInputStream);
        }
        if (sid == 156) {
            return new FnGroupCountRecord(recordInputStream);
        }
        if (sid == 157) {
            return new AutoFilterInfoRecord(recordInputStream);
        }
        switch (sid) {
            case 6:
                return new FormulaRecord(recordInputStream);
            case 10:
                return new EOFRecord(recordInputStream);
            case 12:
                return new CalcCountRecord(recordInputStream);
            case 13:
                return new CalcModeRecord(recordInputStream);
            case 14:
                return new PrecisionRecord(recordInputStream);
            case 15:
                return new RefModeRecord(recordInputStream);
            case 16:
                return new DeltaRecord(recordInputStream);
            case 17:
                return new IterationRecord(recordInputStream);
            case 18:
                return new ProtectRecord(recordInputStream);
            case 19:
                return new PasswordRecord(recordInputStream);
            case 20:
                return new HeaderRecord(recordInputStream);
            case 21:
                return new FooterRecord(recordInputStream);
            case 47:
                return new FilePassRecord(recordInputStream);
            case 49:
                return new FontRecord(recordInputStream);
            case 81:
                return new DConRefRecord(recordInputStream);
            case 85:
                return new DefaultColWidthRecord(recordInputStream);
            case 125:
                return new ColumnInfoRecord(recordInputStream);
            case 146:
                return new PaletteRecord(recordInputStream);
            case 160:
                return new SCLRecord(recordInputStream);
            case 161:
                return new PrintSetupRecord(recordInputStream);
            case 176:
                return new ViewDefinitionRecord(recordInputStream);
            case 177:
                return new ViewFieldsRecord(recordInputStream);
            case 182:
                return new PageItemRecord(recordInputStream);
            case 189:
                return new MulRKRecord(recordInputStream);
            case 190:
                return new MulBlankRecord(recordInputStream);
            case 193:
                return new MMSRecord(recordInputStream);
            case 197:
                return new DataItemRecord(recordInputStream);
            case FinalCanbus.CAR_FYTA_ChangChengC30 /* 213 */:
                return new StreamIDRecord(recordInputStream);
            case FinalCanbus.CAR_RZC4_PSA3008 /* 215 */:
                return new DBCellRecord(recordInputStream);
            case FinalCanbus.CAR_XBS_XP1_13MengDiOu /* 218 */:
                return new BookBoolRecord(recordInputStream);
            case FinalCanbus.CAR_DC_WC1_15YIDONG /* 224 */:
                return new ExtendedFormatRecord(recordInputStream);
            case FinalCanbus.CAR_XP1_SanLinPajero /* 225 */:
                return new InterfaceHdrRecord(recordInputStream);
            case FinalCanbus.CAR_FYTA_ChangAnYueXiangV7 /* 226 */:
                return InterfaceEndRecord.create(recordInputStream);
            case FinalCanbus.CAR_RZC_XP1_ChangAnYueXiangV7 /* 227 */:
                return new ViewSourceRecord(recordInputStream);
            case FinalCanbus.CAR_CYT_FYTA_DongNanV5 /* 229 */:
                return new MergeCellsRecord(recordInputStream);
            case FinalCanbus.CAR_RZC4_DS5LS /* 235 */:
                return new DrawingGroupRecord(recordInputStream);
            case FinalCanbus.CAR_WC2_SAIL3 /* 236 */:
                return new DrawingRecordForBiffViewer(recordInputStream);
            case FinalCanbus.CAR_RZC_XP1_HAIMAM5 /* 237 */:
                return new DrawingSelectionRecord(recordInputStream);
            case FinalCanbus.CAR_WC2_PSAALL_0 /* 252 */:
                return new SSTRecord(recordInputStream);
            case FinalCanbus.CAR_XP1_15YingLang /* 253 */:
                return new LabelSSTRecord(recordInputStream);
            case 255:
                return new ExtSSTRecord(recordInputStream);
            case 256:
                return new ExtendedPivotTableViewFieldsRecord(recordInputStream);
            case FinalCanbus.CAR_WeiChi2_ATS /* 317 */:
                return new TabIdRecord(recordInputStream);
            case FinalCanbus.CAR_WC2_RENAULT_KaBin /* 352 */:
                return new UseSelFSRecord(recordInputStream);
            case FinalCanbus.CAR_HAOZHENG_XP1_PorscheCayenne /* 353 */:
                return new DSFRecord(recordInputStream);
            case FinalCanbus.CAR_WC2_TianLai03_07 /* 430 */:
                return new SupBookRecord(recordInputStream);
            case FinalCanbus.CAR_431_HC_PSAALL /* 431 */:
                return new ProtectionRev4Record(recordInputStream);
            case FinalCanbus.CAR_432_HC_B200 /* 432 */:
                return new CFHeaderRecord(recordInputStream);
            case FinalCanbus.CAR_433_CYT_SBL /* 433 */:
                return new CFRuleRecord(recordInputStream);
            case FinalCanbus.CAR_434_BG_FIAT /* 434 */:
                return new DVALRecord(recordInputStream);
            case FinalCanbus.CAR_438_BNR_DaZhong_L /* 438 */:
                return new TextObjectRecord(recordInputStream);
            case FinalCanbus.CAR_439_XBS_XTL16C4 /* 439 */:
                return new RefreshAllRecord(recordInputStream);
            case FinalCanbus.CAR_440 /* 440 */:
                return new HyperlinkRecord(recordInputStream);
            case 444:
                return new PasswordRev4Record(recordInputStream);
            case FinalCanbus.CAR_446 /* 446 */:
                return new DVRecord(recordInputStream);
            case FinalCanbus.CAR_449_Kequan_Toyota_AVM /* 449 */:
                return new RecalcIdRecord(recordInputStream);
            case 512:
                return new DimensionsRecord(recordInputStream);
            case FinalCanbus.U_CAR_DRIVENABLE_MILEAGE /* 513 */:
                return new BlankRecord(recordInputStream);
            case FinalCanbus.U_CAR_SEAT_BELT_RIGHT /* 515 */:
                return new NumberRecord(recordInputStream);
            case FinalCanbus.U_CAR_ACCON /* 516 */:
                return new LabelRecord(recordInputStream);
            case FinalCanbus.U_CAR_LIGHT /* 517 */:
                return new BoolErrRecord(recordInputStream);
            case FinalCanbus.U_CAR_HANDBRAKE /* 519 */:
                return new StringRecord(recordInputStream);
            case FinalCanbus.U_CAR_CUR_FUEL /* 520 */:
                return new RowRecord(recordInputStream);
            case FinalCanbus.U_CAR_TEMP_MOTOR_OIL /* 523 */:
                return new IndexRecord(recordInputStream);
            case FinalCanbus.U_CAR_AVG_FUEL_ENABLE /* 545 */:
                return new ArrayRecord(recordInputStream);
            case FinalCanbus.U_CAR_VOLTAGE_ENABLE /* 549 */:
                return new DefaultRowHeightRecord(recordInputStream);
            case 566:
                return new TableRecord(recordInputStream);
            case 574:
                return new WindowTwoRecord(recordInputStream);
            case 638:
                return new RKRecord(recordInputStream);
            case 659:
                return new StyleRecord(recordInputStream);
            case 1054:
                return new FormatRecord(recordInputStream);
            case 1212:
                return new SharedFormulaRecord(recordInputStream);
            case 2057:
                return new BOFRecord(recordInputStream);
            case 2128:
                return new ChartFRTInfoRecord(recordInputStream);
            case 2130:
                return new ChartStartBlockRecord(recordInputStream);
            case 2131:
                return new ChartEndBlockRecord(recordInputStream);
            case 2132:
                return new ChartStartObjectRecord(recordInputStream);
            case 2133:
                return new ChartEndObjectRecord(recordInputStream);
            case 2134:
                return new CatLabRecord(recordInputStream);
            case UnknownRecord.SHEETPROTECTION_0867 /* 2151 */:
                return new FeatHdrRecord(recordInputStream);
            case 2152:
                return new FeatRecord(recordInputStream);
            case 2169:
                return new CFHeader12Record(recordInputStream);
            case 2170:
                return new CFRule12Record(recordInputStream);
            case 2190:
                return new TableStylesRecord(recordInputStream);
            case 2196:
                return new NameCommentRecord(recordInputStream);
            case 4097:
                return new UnitsRecord(recordInputStream);
            case 4098:
                return new ChartRecord(recordInputStream);
            case 4099:
                return new SeriesRecord(recordInputStream);
            case 4102:
                return new DataFormatRecord(recordInputStream);
            case 4103:
                return new LineFormatRecord(recordInputStream);
            case 4106:
                return new AreaFormatRecord(recordInputStream);
            case 4109:
                return new SeriesTextRecord(recordInputStream);
            case 4116:
                return new ChartFormatRecord(recordInputStream);
            case 4117:
                return new LegendRecord(recordInputStream);
            case 4118:
                return new SeriesListRecord(recordInputStream);
            case 4119:
                return new BarRecord(recordInputStream);
            case 4122:
                return new AreaRecord(recordInputStream);
            case 4125:
                return new AxisRecord(recordInputStream);
            case 4126:
                return new TickRecord(recordInputStream);
            case 4127:
                return new ValueRangeRecord(recordInputStream);
            case 4128:
                return new CategorySeriesAxisRecord(recordInputStream);
            case 4129:
                return new AxisLineFormatRecord(recordInputStream);
            case 4132:
                return new DefaultDataLabelTextPropertiesRecord(recordInputStream);
            case 4133:
                return new TextRecord(recordInputStream);
            case 4134:
                return new FontIndexRecord(recordInputStream);
            case 4135:
                return new ObjectLinkRecord(recordInputStream);
            case 4146:
                return new FrameRecord(recordInputStream);
            case 4147:
                return new BeginRecord(recordInputStream);
            case 4148:
                return new EndRecord(recordInputStream);
            case 4149:
                return new PlotAreaRecord(recordInputStream);
            case 4161:
                return new AxisParentRecord(recordInputStream);
            case 4164:
                return new SheetPropertiesRecord(recordInputStream);
            case 4165:
                return new SeriesToChartGroupRecord(recordInputStream);
            case 4166:
                return new AxisUsedRecord(recordInputStream);
            case 4177:
                return new LinkedDataRecord(recordInputStream);
            case 4192:
                return new FontBasisRecord(recordInputStream);
            case 4194:
                return new AxisOptionsRecord(recordInputStream);
            case 4195:
                return new DatRecord(recordInputStream);
            case 4196:
                return new PlotGrowthRecord(recordInputStream);
            case 4197:
                return new SeriesIndexRecord(recordInputStream);
            default:
                switch (sid) {
                    case 23:
                        return new ExternSheetRecord(recordInputStream);
                    case 24:
                        return new NameRecord(recordInputStream);
                    case 25:
                        return new WindowProtectRecord(recordInputStream);
                    case 26:
                        return new VerticalPageBreakRecord(recordInputStream);
                    case 27:
                        return new HorizontalPageBreakRecord(recordInputStream);
                    case 28:
                        return new NoteRecord(recordInputStream);
                    case 29:
                        return new SelectionRecord(recordInputStream);
                    default:
                        switch (sid) {
                            case 38:
                                return new LeftMarginRecord(recordInputStream);
                            case 39:
                                return new RightMarginRecord(recordInputStream);
                            case 40:
                                return new TopMarginRecord(recordInputStream);
                            case 41:
                                return new BottomMarginRecord(recordInputStream);
                            case 42:
                                return new PrintHeadersRecord(recordInputStream);
                            case 43:
                                return new PrintGridlinesRecord(recordInputStream);
                            default:
                                switch (sid) {
                                    case 64:
                                        return new BackupRecord(recordInputStream);
                                    case 65:
                                        return new PaneRecord(recordInputStream);
                                    case 66:
                                        return new CodepageRecord(recordInputStream);
                                    default:
                                        switch (sid) {
                                            case 91:
                                                return new FileSharingRecord(recordInputStream);
                                            case 92:
                                                return new WriteAccessRecord(recordInputStream);
                                            case 93:
                                                return new ObjRecord(recordInputStream);
                                            case 94:
                                                return new UncalcedRecord(recordInputStream);
                                            case 95:
                                                return new SaveRecalcRecord(recordInputStream);
                                            default:
                                                switch (sid) {
                                                    case 128:
                                                        return new GutsRecord(recordInputStream);
                                                    case 129:
                                                        return new WSBoolRecord(recordInputStream);
                                                    case 130:
                                                        return new GridsetRecord(recordInputStream);
                                                    case 131:
                                                        return new HCenterRecord(recordInputStream);
                                                    case 132:
                                                        return new VCenterRecord(recordInputStream);
                                                    case 133:
                                                        return new BoundSheetRecord(recordInputStream);
                                                    case 134:
                                                        return new WriteProtectRecord(recordInputStream);
                                                    default:
                                                        return new UnknownRecord(recordInputStream);
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private static final class CommandArgs {
        private final boolean _biffhex;
        private final File _file;
        private final boolean _noHeader;
        private final boolean _noint;
        private final boolean _out;
        private final boolean _rawhex;

        private CommandArgs(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, File file) {
            this._biffhex = z;
            this._noint = z2;
            this._out = z3;
            this._rawhex = z4;
            this._file = file;
            this._noHeader = z5;
        }

        public static CommandArgs parse(String[] strArr) throws CommandParseException {
            int length = strArr.length;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            File file = null;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if (str.startsWith("--")) {
                    if ("--biffhex".equals(str)) {
                        z = true;
                    } else if ("--noint".equals(str)) {
                        z2 = true;
                    } else if ("--out".equals(str)) {
                        z3 = true;
                    } else if ("--escher".equals(str)) {
                        System.setProperty("poi.deserialize.escher", "true");
                    } else if ("--rawhex".equals(str)) {
                        z4 = true;
                    } else {
                        if (!"--noheader".equals(str)) {
                            throw new CommandParseException("Unexpected option '" + str + "'");
                        }
                        z5 = true;
                    }
                } else {
                    file = new File(str);
                    if (!file.exists()) {
                        throw new CommandParseException("Specified file '" + str + "' does not exist");
                    }
                    if (i + 1 < length) {
                        throw new CommandParseException("File name must be the last arg");
                    }
                }
            }
            if (file == null) {
                throw new CommandParseException("Biff viewer needs a filename");
            }
            return new CommandArgs(z, z2, z3, z4, z5, file);
        }

        public boolean shouldDumpBiffHex() {
            return this._biffhex;
        }

        public boolean shouldDumpRecordInterpretations() {
            return !this._noint;
        }

        public boolean shouldOutputToFile() {
            return this._out;
        }

        public boolean shouldOutputRawHexOnly() {
            return this._rawhex;
        }

        public boolean suppressHeader() {
            return this._noHeader;
        }

        public File getFile() {
            return this._file;
        }
    }

    private static final class CommandParseException extends Exception {
        public CommandParseException(String str) {
            super(str);
        }
    }

    public static void main(String[] strArr) throws Throwable {
        PrintWriter printWriter;
        NPOIFSFileSystem nPOIFSFileSystem;
        CommandArgs commandArgs = CommandArgs.parse(strArr);
        if (commandArgs.shouldOutputToFile()) {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(commandArgs.getFile().getAbsolutePath() + ".out"), StringUtil.UTF8));
        } else {
            printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
        }
        try {
            nPOIFSFileSystem = new NPOIFSFileSystem(commandArgs.getFile(), true);
            try {
                InputStream pOIFSInputStream = getPOIFSInputStream(nPOIFSFileSystem);
                if (commandArgs.shouldOutputRawHexOnly()) {
                    HexDump.dump(IOUtils.toByteArray(pOIFSInputStream), 0L, System.out, 0);
                } else {
                    boolean zShouldDumpRecordInterpretations = commandArgs.shouldDumpRecordInterpretations();
                    runBiffViewer(printWriter, pOIFSInputStream, zShouldDumpRecordInterpretations, commandArgs.shouldDumpBiffHex(), zShouldDumpRecordInterpretations, commandArgs.suppressHeader());
                }
                IOUtils.closeQuietly(pOIFSInputStream);
                IOUtils.closeQuietly(nPOIFSFileSystem);
                IOUtils.closeQuietly(printWriter);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(null);
                IOUtils.closeQuietly(nPOIFSFileSystem);
                IOUtils.closeQuietly(printWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            nPOIFSFileSystem = null;
        }
    }

    protected static InputStream getPOIFSInputStream(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        return nPOIFSFileSystem.createDocumentInputStream(HSSFWorkbook.getWorkbookDirEntryName(nPOIFSFileSystem.getRoot()));
    }

    protected static void runBiffViewer(PrintWriter printWriter, InputStream inputStream, boolean z, boolean z2, boolean z3, boolean z4) {
        BiffRecordListener biffRecordListener = new BiffRecordListener(z2 ? printWriter : null, z3, z4);
        createRecords(new BiffDumpingStream(inputStream, biffRecordListener), printWriter, biffRecordListener, z);
    }

    private static final class BiffRecordListener implements IBiffRecordListener {
        private List<String> _headers = new ArrayList();
        private final Writer _hexDumpWriter;
        private final boolean _noHeader;
        private final boolean _zeroAlignEachRecord;

        public BiffRecordListener(Writer writer, boolean z, boolean z2) {
            this._hexDumpWriter = writer;
            this._zeroAlignEachRecord = z;
            this._noHeader = z2;
        }

        @Override // org.apache.poi.hssf.dev.BiffViewer.IBiffRecordListener
        public void processRecord(int i, int i2, int i3, int i4, byte[] bArr) {
            String recordDetails = formatRecordDetails(i, i3, i4, i2);
            if (!this._noHeader) {
                this._headers.add(recordDetails);
            }
            Writer writer = this._hexDumpWriter;
            if (writer != null) {
                try {
                    writer.write(recordDetails);
                    writer.write(BiffViewer.NEW_LINE_CHARS);
                    BiffViewer.hexDumpAligned(writer, bArr, i4 + 4, i, this._zeroAlignEachRecord);
                    writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public List<String> getRecentHeaders() {
            List<String> list = this._headers;
            this._headers = new ArrayList();
            return list;
        }

        private static String formatRecordDetails(int i, int i2, int i3, int i4) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Offset=").append(HexDump.intToHex(i)).append("(").append(i).append(") recno=");
            sb.append(i4);
            sb.append(" sid=").append(HexDump.shortToHex(i2));
            sb.append(" size=").append(HexDump.shortToHex(i3)).append("(").append(i3).append(")");
            return sb.toString();
        }
    }

    private static final class BiffDumpingStream extends InputStream {
        private boolean _innerHasReachedEOF;
        private final DataInputStream _is;
        private final IBiffRecordListener _listener;
        private final byte[] _data = new byte[8228];
        private int _recordCounter = 0;
        private int _overallStreamPos = 0;
        private int _currentSize = 0;
        private int _currentPos = 0;

        public BiffDumpingStream(InputStream inputStream, IBiffRecordListener iBiffRecordListener) {
            this._is = new DataInputStream(inputStream);
            this._listener = iBiffRecordListener;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this._currentPos >= this._currentSize) {
                fillNextBuffer();
            }
            int i = this._currentPos;
            if (i >= this._currentSize) {
                return -1;
            }
            int i2 = this._data[i] & UByte.MAX_VALUE;
            this._currentPos = i + 1;
            this._overallStreamPos++;
            formatBufferIfAtEndOfRec();
            return i2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this._currentPos >= this._currentSize) {
                fillNextBuffer();
            }
            int i3 = this._currentPos;
            int i4 = this._currentSize;
            if (i3 >= i4) {
                return -1;
            }
            int i5 = i4 - i3;
            if (i2 > i5) {
                System.err.println("Unexpected request to read past end of current biff record");
                i2 = i5;
            }
            System.arraycopy(this._data, this._currentPos, bArr, i, i2);
            this._currentPos += i2;
            this._overallStreamPos += i2;
            formatBufferIfAtEndOfRec();
            return i2;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return (this._currentSize - this._currentPos) + this._is.available();
        }

        private void fillNextBuffer() throws IOException {
            if (this._innerHasReachedEOF) {
                return;
            }
            int i = this._is.read();
            if (i == -1) {
                this._innerHasReachedEOF = true;
                return;
            }
            byte[] bArr = this._data;
            bArr[0] = (byte) i;
            this._is.readFully(bArr, 1, 3);
            short s = LittleEndian.getShort(this._data, 2);
            this._is.readFully(this._data, 4, s);
            this._currentPos = 0;
            this._currentSize = s + 4;
            this._recordCounter++;
        }

        private void formatBufferIfAtEndOfRec() {
            int i = this._currentPos;
            int i2 = this._currentSize;
            if (i != i2) {
                return;
            }
            short s = LittleEndian.getShort(this._data, 0);
            this._listener.processRecord(this._overallStreamPos - this._currentSize, this._recordCounter, s, i2 - 4, this._data);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this._is.close();
        }
    }

    static void hexDumpAligned(Writer writer, byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = i2 + 0;
        int i7 = i + i6;
        int i8 = i6 % 16;
        int i9 = i7 % 16;
        if (z) {
            i9 -= i8;
            if (i9 < 0) {
                i9 += 16;
            }
            i3 = 0;
        } else {
            i3 = i8;
        }
        int i10 = i9;
        if (z) {
            i4 = (i7 - i10) - (i6 - i3);
        } else {
            i5 = i6 - i3;
            i4 = i7 - i10;
        }
        int i11 = 0 - i3;
        if (i5 == i4) {
            hexDumpLine(writer, bArr, i5, i11, i3, i10);
            return;
        }
        hexDumpLine(writer, bArr, i5, i11, i3, 16);
        while (true) {
            i5 += 16;
            i11 += 16;
            if (i5 >= i4) {
                break;
            } else {
                hexDumpLine(writer, bArr, i5, i11, 0, 16);
            }
        }
        if (i10 != 0) {
            hexDumpLine(writer, bArr, i5, i11, 0, i10);
        }
    }

    private static void hexDumpLine(Writer writer, byte[] bArr, int i, int i2, int i3, int i4) {
        char[] cArr = COLUMN_SEPARATOR;
        char[] cArr2 = new char[((((cArr.length * 2) + 8) + 48) - 1) + 16 + NEW_LINE_CHARS.length];
        if (i3 >= i4) {
            throw new IllegalArgumentException("Bad start/end delta");
        }
        try {
            writeHex(cArr2, 0, i, 8);
            int iArraycopy = arraycopy(cArr, cArr2, 8);
            for (int i5 = 0; i5 < 16; i5++) {
                if (i5 > 0) {
                    cArr2[iArraycopy] = ' ';
                    iArraycopy++;
                }
                if (i5 >= i3 && i5 < i4) {
                    writeHex(cArr2, iArraycopy, bArr[i2 + i5], 2);
                } else {
                    cArr2[iArraycopy] = ' ';
                    cArr2[iArraycopy + 1] = ' ';
                }
                iArraycopy += 2;
            }
            int iArraycopy2 = arraycopy(COLUMN_SEPARATOR, cArr2, iArraycopy);
            int i6 = 0;
            while (i6 < 16) {
                cArr2[iArraycopy2] = (i6 < i3 || i6 >= i4) ? ' ' : getPrintableChar(bArr[i2 + i6]);
                i6++;
                iArraycopy2++;
            }
            writer.write(cArr2, 0, arraycopy(NEW_LINE_CHARS, cArr2, iArraycopy2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int arraycopy(char[] cArr, char[] cArr2, int i) {
        int length = cArr.length;
        int i2 = 0;
        while (i2 < length) {
            cArr2[i] = cArr[i2];
            i2++;
            i++;
        }
        return i;
    }

    private static void writeHex(char[] cArr, int i, int i2, int i3) throws IOException {
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            int i5 = i2 & 15;
            cArr[i + i4] = (char) (i5 < 10 ? i5 + 48 : (i5 + 65) - 10);
            i2 >>>= 4;
        }
    }
}
