package org.apache.poi.ss.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CreationHelper {
    AreaReference createAreaReference(String str);

    AreaReference createAreaReference(CellReference cellReference, CellReference cellReference2);

    ClientAnchor createClientAnchor();

    DataFormat createDataFormat();

    ExtendedColor createExtendedColor();

    FormulaEvaluator createFormulaEvaluator();

    Hyperlink createHyperlink(HyperlinkType hyperlinkType);

    RichTextString createRichTextString(String str);
}
