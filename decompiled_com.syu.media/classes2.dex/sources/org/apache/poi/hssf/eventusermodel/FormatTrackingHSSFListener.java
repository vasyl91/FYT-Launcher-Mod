package org.apache.poi.hssf.eventusermodel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FormatTrackingHSSFListener implements HSSFListener {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) FormatTrackingHSSFListener.class);
    private final HSSFListener _childListener;
    private final Map<Integer, FormatRecord> _customFormatRecords;
    private final NumberFormat _defaultFormat;
    private final HSSFDataFormatter _formatter;
    private final List<ExtendedFormatRecord> _xfRecords;

    public FormatTrackingHSSFListener(HSSFListener hSSFListener) {
        this(hSSFListener, LocaleUtil.getUserLocale());
    }

    public FormatTrackingHSSFListener(HSSFListener hSSFListener, Locale locale) {
        this._customFormatRecords = new HashMap();
        this._xfRecords = new ArrayList();
        this._childListener = hSSFListener;
        this._formatter = new HSSFDataFormatter(locale);
        this._defaultFormat = NumberFormat.getInstance(locale);
    }

    protected int getNumberOfCustomFormats() {
        return this._customFormatRecords.size();
    }

    protected int getNumberOfExtendedFormats() {
        return this._xfRecords.size();
    }

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
        processRecordInternally(record);
        this._childListener.processRecord(record);
    }

    public void processRecordInternally(Record record) {
        if (record instanceof FormatRecord) {
            FormatRecord formatRecord = (FormatRecord) record;
            this._customFormatRecords.put(Integer.valueOf(formatRecord.getIndexCode()), formatRecord);
        }
        if (record instanceof ExtendedFormatRecord) {
            this._xfRecords.add((ExtendedFormatRecord) record);
        }
    }

    public String formatNumberDateCell(CellValueRecordInterface cellValueRecordInterface) {
        double value;
        if (cellValueRecordInterface instanceof NumberRecord) {
            value = ((NumberRecord) cellValueRecordInterface).getValue();
        } else if (cellValueRecordInterface instanceof FormulaRecord) {
            value = ((FormulaRecord) cellValueRecordInterface).getValue();
        } else {
            throw new IllegalArgumentException("Unsupported CellValue Record passed in " + cellValueRecordInterface);
        }
        int formatIndex = getFormatIndex(cellValueRecordInterface);
        String formatString = getFormatString(cellValueRecordInterface);
        if (formatString == null) {
            return this._defaultFormat.format(value);
        }
        return this._formatter.formatRawCellContents(value, formatIndex, formatString);
    }

    public String getFormatString(int i) {
        if (i >= HSSFDataFormat.getNumberOfBuiltinBuiltinFormats()) {
            FormatRecord formatRecord = this._customFormatRecords.get(Integer.valueOf(i));
            if (formatRecord == null) {
                logger.log(7, "Requested format at index " + i + ", but it wasn't found");
                return null;
            }
            return formatRecord.getFormatString();
        }
        return HSSFDataFormat.getBuiltinFormat((short) i);
    }

    public String getFormatString(CellValueRecordInterface cellValueRecordInterface) {
        int formatIndex = getFormatIndex(cellValueRecordInterface);
        if (formatIndex == -1) {
            return null;
        }
        return getFormatString(formatIndex);
    }

    public int getFormatIndex(CellValueRecordInterface cellValueRecordInterface) {
        ExtendedFormatRecord extendedFormatRecord = this._xfRecords.get(cellValueRecordInterface.getXFIndex());
        if (extendedFormatRecord == null) {
            logger.log(7, "Cell " + cellValueRecordInterface.getRow() + "," + ((int) cellValueRecordInterface.getColumn()) + " uses XF with index " + ((int) cellValueRecordInterface.getXFIndex()) + ", but we don't have that");
            return -1;
        }
        return extendedFormatRecord.getFormatIndex();
    }
}
