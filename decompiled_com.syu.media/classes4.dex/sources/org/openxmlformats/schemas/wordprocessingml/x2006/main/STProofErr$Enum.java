package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public final class STProofErr$Enum extends StringEnumAbstractBase {
    static final int INT_GRAM_END = 4;
    static final int INT_GRAM_START = 3;
    static final int INT_SPELL_END = 2;
    static final int INT_SPELL_START = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STProofErr$Enum[]{new STProofErr$Enum("spellStart", 1), new STProofErr$Enum("spellEnd", 2), new STProofErr$Enum("gramStart", 3), new STProofErr$Enum("gramEnd", 4)});

    private STProofErr$Enum(String str, int i) {
        super(str, i);
    }

    public static STProofErr$Enum forInt(int i) {
        return (STProofErr$Enum) table.forInt(i);
    }

    public static STProofErr$Enum forString(String str) {
        return (STProofErr$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
