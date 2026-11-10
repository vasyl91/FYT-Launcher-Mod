package org.apache.poi.xssf.usermodel.helpers;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.poi.ss.usermodel.IgnoredErrorType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFIgnoredErrorHelper {

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.helpers.XSSFIgnoredErrorHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType;

        static {
            int[] iArr = new int[IgnoredErrorType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType = iArr;
            try {
                iArr[IgnoredErrorType.CALCULATED_COLUMN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.EMPTY_CELL_REFERENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.EVALUATION_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.FORMULA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.FORMULA_RANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.LIST_DATA_VALIDATION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.NUMBER_STORED_AS_TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.TWO_DIGIT_TEXT_YEAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[IgnoredErrorType.UNLOCKED_FORMULA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static boolean isSet(IgnoredErrorType ignoredErrorType, CTIgnoredError cTIgnoredError) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[ignoredErrorType.ordinal()]) {
            case 1:
                return cTIgnoredError.isSetCalculatedColumn();
            case 2:
                return cTIgnoredError.isSetEmptyCellReference();
            case 3:
                return cTIgnoredError.isSetEvalError();
            case 4:
                return cTIgnoredError.isSetFormula();
            case 5:
                return cTIgnoredError.isSetFormulaRange();
            case 6:
                return cTIgnoredError.isSetListDataValidation();
            case 7:
                return cTIgnoredError.isSetNumberStoredAsText();
            case 8:
                return cTIgnoredError.isSetTwoDigitTextYear();
            case 9:
                return cTIgnoredError.isSetUnlockedFormula();
            default:
                throw new IllegalStateException();
        }
    }

    public static void set(IgnoredErrorType ignoredErrorType, CTIgnoredError cTIgnoredError) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$IgnoredErrorType[ignoredErrorType.ordinal()]) {
            case 1:
                cTIgnoredError.setCalculatedColumn(true);
                return;
            case 2:
                cTIgnoredError.setEmptyCellReference(true);
                return;
            case 3:
                cTIgnoredError.setEvalError(true);
                return;
            case 4:
                cTIgnoredError.setFormula(true);
                return;
            case 5:
                cTIgnoredError.setFormulaRange(true);
                return;
            case 6:
                cTIgnoredError.setListDataValidation(true);
                return;
            case 7:
                cTIgnoredError.setNumberStoredAsText(true);
                return;
            case 8:
                cTIgnoredError.setTwoDigitTextYear(true);
                return;
            case 9:
                cTIgnoredError.setUnlockedFormula(true);
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public static void addIgnoredErrors(CTIgnoredError cTIgnoredError, String str, IgnoredErrorType... ignoredErrorTypeArr) {
        cTIgnoredError.setSqref(Arrays.asList(str));
        for (IgnoredErrorType ignoredErrorType : ignoredErrorTypeArr) {
            set(ignoredErrorType, cTIgnoredError);
        }
    }

    public static Set<IgnoredErrorType> getErrorTypes(CTIgnoredError cTIgnoredError) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (IgnoredErrorType ignoredErrorType : IgnoredErrorType.values()) {
            if (isSet(ignoredErrorType, cTIgnoredError)) {
                linkedHashSet.add(ignoredErrorType);
            }
        }
        return linkedHashSet;
    }
}
