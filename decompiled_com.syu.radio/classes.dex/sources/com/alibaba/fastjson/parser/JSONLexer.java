package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface JSONLexer {
    public static final int ARRAY = 2;
    public static final int END = 4;
    public static final byte EOI = 26;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int OBJECT = 1;
    public static final int UNKOWN = 0;
    public static final int VALUE = 3;

    byte[] bytesValue();

    void close();

    void config(Feature feature, boolean z);

    Number decimalValue(boolean z);

    BigDecimal decimalValue();

    float floatValue();

    int getBufferPosition();

    char getCurrent();

    int intValue();

    Number integerValue();

    boolean isBlankInput();

    boolean isEnabled(Feature feature);

    boolean isRef();

    long longValue();

    char next();

    void nextToken();

    void nextToken(int i);

    void nextTokenWithColon();

    void nextTokenWithColon(int i);

    String numberString();

    int pos();

    void resetStringPosition();

    Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c);

    int scanInt(char c);

    long scanLong(char c);

    void scanNumber();

    String scanString(char c);

    void scanString();

    Collection<String> scanStringArray(Class<?> cls, char c);

    String scanSymbol(SymbolTable symbolTable);

    String scanSymbol(SymbolTable symbolTable, char c);

    String scanSymbolUnQuoted(SymbolTable symbolTable);

    String scanSymbolWithSeperator(SymbolTable symbolTable, char c);

    void skipWhitespace();

    String stringVal();

    int token();

    String tokenName();
}
