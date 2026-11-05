package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@Deprecated
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String input) {
        this(input, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String input, ParserConfig mapping) {
        super(input, mapping);
    }

    public DefaultExtJSONParser(String input, ParserConfig mapping, int features) {
        super(input, mapping, features);
    }

    public DefaultExtJSONParser(char[] input, int length, ParserConfig mapping, int features) {
        super(input, length, mapping, features);
    }
}
