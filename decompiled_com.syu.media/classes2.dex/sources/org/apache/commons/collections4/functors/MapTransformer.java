package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MapTransformer<I, O> implements Transformer<I, O>, Serializable {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map<? super I, ? extends O> iMap;

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> map) {
        if (map == null) {
            return ConstantTransformer.nullTransformer();
        }
        return new MapTransformer(map);
    }

    private MapTransformer(Map<? super I, ? extends O> map) {
        this.iMap = map;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I i) {
        return this.iMap.get(i);
    }

    public Map<? super I, ? extends O> getMap() {
        return this.iMap;
    }
}
