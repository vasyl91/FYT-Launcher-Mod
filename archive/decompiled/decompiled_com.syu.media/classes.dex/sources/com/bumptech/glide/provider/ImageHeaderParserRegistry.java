package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers = new ArrayList();

    public synchronized List<ImageHeaderParser> getParsers() {
        return this.parsers;
    }

    public synchronized void add(ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }
}
