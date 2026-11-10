package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;

    public SimplePropertyPreFilter(String... properties) {
        this(null, properties);
    }

    public SimplePropertyPreFilter(Class<?> clazz, String... properties) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        this.clazz = clazz;
        for (String item : properties) {
            if (item != null) {
                this.includes.add(item);
            }
        }
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        if (source == null) {
            return true;
        }
        if (this.clazz != null && !this.clazz.isInstance(source)) {
            return true;
        }
        if (this.excludes.contains(name)) {
            return false;
        }
        return this.includes.size() == 0 || this.includes.contains(name);
    }
}
