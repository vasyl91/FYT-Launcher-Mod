package org.apache.poi.ss.formula.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import module.canbus.FinalCanbus;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
final class FunctionMetadataReader {
    private static final String[] DIGIT_ENDING_FUNCTION_NAMES;
    private static final Set<String> DIGIT_ENDING_FUNCTION_NAMES_SET;
    private static final String ELLIPSIS = "...";
    private static final String METADATA_FILE_NAME = "functionMetadata.txt";
    private static final Pattern TAB_DELIM_PATTERN = Pattern.compile("\t");
    private static final Pattern SPACE_DELIM_PATTERN = Pattern.compile(" ");
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    FunctionMetadataReader() {
    }

    static {
        String[] strArr = {"LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2"};
        DIGIT_ENDING_FUNCTION_NAMES = strArr;
        DIGIT_ENDING_FUNCTION_NAMES_SET = new HashSet(Arrays.asList(strArr));
    }

    public static FunctionMetadataRegistry createRegistry() {
        try {
            InputStream resourceAsStream = FunctionMetadataReader.class.getResourceAsStream(METADATA_FILE_NAME);
            try {
                if (resourceAsStream == null) {
                    throw new RuntimeException("resource 'functionMetadata.txt' not found");
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                    try {
                        FunctionDataBuilder functionDataBuilder = new FunctionDataBuilder(FinalCanbus.CAR_FYTA_JILI_XiongMiao);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                if (line.length() >= 1 && line.charAt(0) != '#' && line.trim().length() >= 1) {
                                    processLine(functionDataBuilder, line);
                                }
                            } else {
                                FunctionMetadataRegistry functionMetadataRegistryBuild = functionDataBuilder.build();
                                bufferedReader.close();
                                resourceAsStream.close();
                                return functionMetadataRegistryBuild;
                            }
                        }
                    } catch (Throwable th) {
                        bufferedReader.close();
                        throw th;
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th2) {
                resourceAsStream.close();
                throw th2;
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void processLine(FunctionDataBuilder functionDataBuilder, String str) {
        String[] strArrSplit = TAB_DELIM_PATTERN.split(str, -2);
        if (strArrSplit.length != 8) {
            throw new RuntimeException("Bad line format '" + str + "' - expected 8 data fields");
        }
        int i = parseInt(strArrSplit[0]);
        String str2 = strArrSplit[1];
        int i2 = parseInt(strArrSplit[2]);
        int i3 = parseInt(strArrSplit[3]);
        byte returnTypeCode = parseReturnTypeCode(strArrSplit[4]);
        byte[] operandTypeCodes = parseOperandTypeCodes(strArrSplit[5]);
        boolean z = strArrSplit[7].length() > 0;
        validateFunctionName(str2);
        functionDataBuilder.add(i, str2, i2, i3, returnTypeCode, operandTypeCodes, z);
    }

    private static byte parseReturnTypeCode(String str) {
        if (str.length() == 0) {
            return (byte) 0;
        }
        return parseOperandTypeCode(str);
    }

    private static byte[] parseOperandTypeCodes(String str) {
        if (str.length() < 1) {
            return EMPTY_BYTE_ARRAY;
        }
        if (isDash(str)) {
            return EMPTY_BYTE_ARRAY;
        }
        String[] strArrSplit = SPACE_DELIM_PATTERN.split(str);
        int length = strArrSplit.length;
        if (ELLIPSIS.equals(strArrSplit[length - 1])) {
            length--;
        }
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = parseOperandTypeCode(strArrSplit[i]);
        }
        return bArr;
    }

    private static boolean isDash(String str) {
        return str.length() == 1 && str.charAt(0) == '-';
    }

    private static byte parseOperandTypeCode(String str) {
        if (str.length() != 1) {
            throw new RuntimeException("Bad operand type code format '" + str + "' expected single char");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'A') {
            return Ptg.CLASS_ARRAY;
        }
        if (cCharAt == 'R') {
            return (byte) 0;
        }
        if (cCharAt == 'V') {
            return (byte) 32;
        }
        throw new IllegalArgumentException("Unexpected operand type code '" + str + "' (" + ((int) str.charAt(0)) + ")");
    }

    private static void validateFunctionName(String str) {
        int length = str.length() - 1;
        if (Character.isDigit(str.charAt(length))) {
            while (length >= 0 && Character.isDigit(str.charAt(length))) {
                length--;
            }
            if (!DIGIT_ENDING_FUNCTION_NAMES_SET.contains(str)) {
                throw new RuntimeException("Invalid function name '" + str + "' (is footnote number incorrectly appended)");
            }
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new RuntimeException("Value '" + str + "' could not be parsed as an integer");
        }
    }
}
