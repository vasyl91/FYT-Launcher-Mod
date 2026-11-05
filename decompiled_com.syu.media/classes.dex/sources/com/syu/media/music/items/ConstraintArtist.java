package com.syu.media.music.items;

import com.syu.media.Constraint;
import com.syu.media.api.ArtistInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintArtist.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/syu/media/music/items/ConstraintArtist;", "Lcom/syu/media/api/ArtistInfo;", "constraint", "Lcom/syu/media/Constraint;", "(Lcom/syu/media/Constraint;)V", "getConstraint", "()Lcom/syu/media/Constraint;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConstraintArtist extends ArtistInfo {
    private final Constraint constraint;

    public ConstraintArtist(Constraint constraint) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        this.constraint = constraint;
    }

    public final Constraint getConstraint() {
        return this.constraint;
    }
}
