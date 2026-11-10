package com.syu.media.online.item;

import chip.FinalChip;
import com.syu.media.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnlineItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/syu/media/online/item/OnlineItem;", "Lcom/syu/media/online/item/OnlineDetailItem;", "()V", "getViewType", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnlineItem extends OnlineDetailItem {
    public static final String TAG = "OnlineItem";

    @Override // com.syu.media.online.item.OnlineDetailItem
    public int getViewType() {
        return R.layout.online_main_list_item;
    }
}
