package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class PascalNameFilter implements NameFilter {
    @Override // com.alibaba.fastjson.serializer.NameFilter
    public String process(Object source, String name, Object value) {
        if (name == null || name.length() == 0) {
            return name;
        }
        char[] chars = name.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }
}
