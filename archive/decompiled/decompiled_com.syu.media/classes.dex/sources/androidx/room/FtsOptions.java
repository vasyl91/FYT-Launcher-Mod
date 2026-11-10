package androidx.room;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class FtsOptions {
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public enum MatchInfo {
        FTS3,
        FTS4
    }

    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
