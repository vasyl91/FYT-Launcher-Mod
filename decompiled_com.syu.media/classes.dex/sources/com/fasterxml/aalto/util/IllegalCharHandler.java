package com.fasterxml.aalto.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface IllegalCharHandler {
    /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [com.fasterxml.aalto.WFCException] */
    char convertIllegalChar(int i);

    public static class ReplacingIllegalCharHandler implements IllegalCharHandler, XmlConsts {
        private final char replacedChar;

        public ReplacingIllegalCharHandler(char c) {
            this.replacedChar = c;
        }

        /* JADX WARN: Byte code manipulation detected: skipped illegal throws declarations: [com.fasterxml.aalto.WFCException] */
        @Override // com.fasterxml.aalto.util.IllegalCharHandler
        public char convertIllegalChar(int i) {
            return this.replacedChar;
        }
    }
}
