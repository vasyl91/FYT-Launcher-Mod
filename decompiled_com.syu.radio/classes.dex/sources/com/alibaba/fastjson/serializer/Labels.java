package com.alibaba.fastjson.serializer;

import java.util.Arrays;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Labels {

    private static class DefaultLabelFilter implements LabelFilter {
        private String[] excludes;
        private String[] includes;

        public DefaultLabelFilter(String[] includes, String[] excludes) {
            if (includes != null) {
                this.includes = new String[includes.length];
                System.arraycopy(includes, 0, this.includes, 0, includes.length);
                Arrays.sort(this.includes);
            }
            if (excludes != null) {
                this.excludes = new String[excludes.length];
                System.arraycopy(excludes, 0, this.excludes, 0, excludes.length);
                Arrays.sort(this.excludes);
            }
        }

        @Override // com.alibaba.fastjson.serializer.LabelFilter
        public boolean apply(String label) {
            if (this.excludes == null || Arrays.binarySearch(this.excludes, label) < 0) {
                return this.includes == null || Arrays.binarySearch(this.includes, label) >= 0;
            }
            return false;
        }
    }

    public static LabelFilter includes(String... views) {
        return new DefaultLabelFilter(views, null);
    }

    public static LabelFilter excludes(String... views) {
        return new DefaultLabelFilter(null, views);
    }
}
