package com.fasterxml.aalto;

import com.fasterxml.aalto.AsyncInputFeeder;
import com.fasterxml.aalto.in.ReaderConfig;
import org.codehaus.stax2.XMLStreamReader2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface AsyncXMLStreamReader<F extends AsyncInputFeeder> extends XMLStreamReader2 {
    public static final int EVENT_INCOMPLETE = 257;

    ReaderConfig getConfig();

    F getInputFeeder();
}
