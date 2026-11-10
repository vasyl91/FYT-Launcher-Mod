package com.syu.media.player;

import chip.FinalChip;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/syu/media/player/PlayMode;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "a", "I", "getValue", "()I", "value", "Companion", "LOOP", "LIST", "SINGLE", "SHUFFLE", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public enum PlayMode {
    LOOP(0),
    LIST(1),
    SINGLE(2),
    SHUFFLE(3);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/syu/media/player/PlayMode$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/player/PlayMode;", "mode", "nextMode", FinalChip.BSP_PLATFORM_Null, "value", "modeOfValue", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PlayMode.values().length];
                try {
                    iArr[PlayMode.LIST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PlayMode.LOOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PlayMode.SINGLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PlayMode.SHUFFLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayMode modeOfValue(int value) {
            PlayMode playMode = PlayMode.LIST;
            if (value == playMode.getValue()) {
                return playMode;
            }
            PlayMode playMode2 = PlayMode.SINGLE;
            if (value == playMode2.getValue()) {
                return playMode2;
            }
            PlayMode playMode3 = PlayMode.SHUFFLE;
            return value == playMode3.getValue() ? playMode3 : PlayMode.LOOP;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final PlayMode nextMode(PlayMode mode) throws NoWhenBranchMatchedException {
            Intrinsics.checkNotNullParameter(mode, "mode");
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                return PlayMode.LOOP;
            }
            if (i == 2) {
                return PlayMode.SINGLE;
            }
            if (i == 3) {
                return PlayMode.SHUFFLE;
            }
            if (i == 4) {
                return PlayMode.LIST;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    PlayMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
