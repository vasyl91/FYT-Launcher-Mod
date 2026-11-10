package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import chip.FinalChip;
import com.syu.radar.RadarView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class EmojiCompat {
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;
    private static volatile boolean sHasDoneDefaultConfigLookup;
    private static volatile EmojiCompat sInstance;
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;
    private final CompatInternal mHelper;
    private final Set<InitCallback> mInitCallbacks;
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();
    private volatile int mLoadState = 3;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final int mMetadataLoadStrategy;
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;
    private static final Object INSTANCE_LOCK = new Object();
    private static final Object CONFIG_LOCK = new Object();

    public interface GlyphChecker {
        boolean hasGlyph(CharSequence charSequence, int i, int i2, int i3);
    }

    public static abstract class InitCallback {
        public void onFailed(Throwable th) {
        }

        public void onInitialized() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(Throwable th);

        public abstract void onLoaded(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReplaceStrategy {
    }

    private EmojiCompat(Config config) {
        this.mReplaceAll = config.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = config.mMetadataLoader;
        this.mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        this.mGlyphChecker = config.mGlyphChecker;
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        if (config.mInitCallbacks != null && !config.mInitCallbacks.isEmpty()) {
            arraySet.addAll(config.mInitCallbacks);
        }
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
    }

    public static EmojiCompat init(Context context) {
        return init(context, null);
    }

    public static EmojiCompat init(Context context, DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        Config configCreate = defaultEmojiCompatConfigFactory.create(context);
        synchronized (CONFIG_LOCK) {
            if (!sHasDoneDefaultConfigLookup) {
                if (configCreate != null) {
                    init(configCreate);
                }
                sHasDoneDefaultConfigLookup = true;
            }
            emojiCompat = sInstance;
        }
        return emojiCompat;
    }

    public static EmojiCompat init(Config config) {
        EmojiCompat emojiCompat = sInstance;
        if (emojiCompat == null) {
            synchronized (INSTANCE_LOCK) {
                emojiCompat = sInstance;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    sInstance = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    public static EmojiCompat reset(Config config) {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = new EmojiCompat(config);
            sInstance = emojiCompat;
        }
        return emojiCompat;
    }

    public static EmojiCompat reset(EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (INSTANCE_LOCK) {
            sInstance = emojiCompat;
            emojiCompat2 = sInstance;
        }
        return emojiCompat2;
    }

    public static void skipDefaultConfigurationLookup(boolean z) {
        synchronized (CONFIG_LOCK) {
            sHasDoneDefaultConfigLookup = z;
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            Preconditions.checkState(emojiCompat != null, NOT_INITIALIZED_ERROR_TEXT);
        }
        return emojiCompat;
    }

    public void load() {
        Preconditions.checkState(this.mMetadataLoadStrategy == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized()) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState != 0) {
                this.mLoadState = 0;
                this.mInitLock.writeLock().unlock();
                this.mHelper.loadMetadata();
                return;
            }
            this.mInitLock.writeLock().unlock();
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            this.mInitLock.writeLock().unlock();
            if (getLoadState() == 0) {
                this.mHelper.loadMetadata();
            }
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public void registerInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new ListenerDispatcher(initCallback, this.mLoadState));
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public void unregisterInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    private boolean isInitialized() {
        return getLoadState() == 1;
    }

    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public static boolean handleOnKeyDown(Editable editable, int i, KeyEvent keyEvent) {
        return EmojiProcessor.handleOnKeyDown(editable, i, keyEvent);
    }

    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        return EmojiProcessor.handleDeleteSurroundingText(inputConnection, editable, i, i2, z);
    }

    public boolean hasEmojiGlyph(CharSequence charSequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence);
    }

    public boolean hasEmojiGlyph(CharSequence charSequence, int i) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence, i);
    }

    public CharSequence process(CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence process(CharSequence charSequence, int i, int i2) {
        return process(charSequence, i, i2, Integer.MAX_VALUE);
    }

    public CharSequence process(CharSequence charSequence, int i, int i2, int i3) {
        return process(charSequence, i, i2, i3, 0);
    }

    public CharSequence process(CharSequence charSequence, int i, int i2, int i3, int i4) {
        boolean z;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i2, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i3, "maxEmojiCount cannot be negative");
        Preconditions.checkArgument(i <= i2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.mReplaceAll : false;
        } else {
            z = true;
        }
        return this.mHelper.process(charSequence, i, i2, i3, z);
    }

    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public void updateEditorInfo(EditorInfo editorInfo) {
        if (!isInitialized() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.mHelper.updateEditorInfoAttrs(editorInfo);
    }

    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    public static abstract class Config {
        int[] mEmojiAsDefaultStyleExceptions;
        boolean mEmojiSpanIndicatorEnabled;
        Set<InitCallback> mInitCallbacks;
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;
        int mEmojiSpanIndicatorColor = RadarView.END_COLOR;
        int mMetadataLoadStrategy = 0;
        GlyphChecker mGlyphChecker = new EmojiProcessor.DefaultGlyphChecker();

        protected Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataRepoLoader;
        }

        public Config registerInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet();
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        public Config unregisterInitCallback(InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.mInitCallbacks;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }

        public Config setReplaceAll(boolean z) {
            this.mReplaceAll = z;
            return this;
        }

        public Config setUseEmojiAsDefaultStyle(boolean z) {
            return setUseEmojiAsDefaultStyle(z, null);
        }

        public Config setUseEmojiAsDefaultStyle(boolean z, List<Integer> list) {
            this.mUseEmojiAsDefaultStyle = z;
            if (z && list != null) {
                this.mEmojiAsDefaultStyleExceptions = new int[list.size()];
                Iterator<Integer> it = list.iterator();
                int i = 0;
                while (it.hasNext()) {
                    this.mEmojiAsDefaultStyleExceptions[i] = it.next().intValue();
                    i++;
                }
                Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
            } else {
                this.mEmojiAsDefaultStyleExceptions = null;
            }
            return this;
        }

        public Config setEmojiSpanIndicatorEnabled(boolean z) {
            this.mEmojiSpanIndicatorEnabled = z;
            return this;
        }

        public Config setEmojiSpanIndicatorColor(int i) {
            this.mEmojiSpanIndicatorColor = i;
            return this;
        }

        public Config setMetadataLoadStrategy(int i) {
            this.mMetadataLoadStrategy = i;
            return this;
        }

        public Config setGlyphChecker(GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(InitCallback initCallback, int i) {
            this(Arrays.asList((InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i) {
            this(collection, i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i, Throwable th) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i;
            this.mThrowable = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i = 0;
            if (this.mLoadState != 1) {
                while (i < size) {
                    this.mInitCallbacks.get(i).onFailed(this.mThrowable);
                    i++;
                }
            } else {
                while (i < size) {
                    this.mInitCallbacks.get(i).onInitialized();
                    i++;
                }
            }
        }
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        String getAssetSignature() {
            return FinalChip.BSP_PLATFORM_Null;
        }

        boolean hasEmojiGlyph(CharSequence charSequence) {
            return false;
        }

        boolean hasEmojiGlyph(CharSequence charSequence, int i) {
            return false;
        }

        CharSequence process(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        void updateEditorInfoAttrs(EditorInfo editorInfo) {
        }

        CompatInternal(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }
    }

    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            try {
                this.mEmojiCompat.mMetadataLoader.load(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(MetadataRepo metadataRepo) {
                        CompatInternal19.this.onMetadataLoadSuccess(metadataRepo);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(Throwable th) {
                        CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
                    }
                });
            } catch (Throwable th) {
                this.mEmojiCompat.onMetadataLoadFailed(th);
            }
        }

        void onMetadataLoadSuccess(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.mMetadataRepo = metadataRepo;
            this.mProcessor = new EmojiProcessor(this.mMetadataRepo, new SpanFactory(), this.mEmojiCompat.mGlyphChecker, this.mEmojiCompat.mUseEmojiAsDefaultStyle, this.mEmojiCompat.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence charSequence) {
            return this.mProcessor.getEmojiMetadata(charSequence) != null;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(CharSequence charSequence, int i) {
            EmojiMetadata emojiMetadata = this.mProcessor.getEmojiMetadata(charSequence);
            return emojiMetadata != null && emojiMetadata.getCompatAdded() <= i;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.mProcessor.process(charSequence, i, i2, i3, z);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String strSourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
            return strSourceSha == null ? FinalChip.BSP_PLATFORM_Null : strSourceSha;
        }
    }
}
