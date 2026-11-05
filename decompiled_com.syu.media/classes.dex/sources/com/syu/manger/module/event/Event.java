package com.syu.manger.module.event;

import androidx.core.app.NotificationCompat;
import chip.FinalChip;
import com.syu.media.provider.Media;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/syu/manger/module/event/Event;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "component1", "component2", Media.TYPE, NotificationCompat.CATEGORY_EVENT, "copy", FinalChip.BSP_PLATFORM_Null, "toString", "hashCode", "other", FinalChip.BSP_PLATFORM_Null, "equals", "a", "I", "getType", "()I", "b", "getEvent", "<init>", "(II)V", "Companion", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class Event {
    public static final int TYPE_ONCLICK = 1;
    public static final int TYPE_PLAY_CMD = 0;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final int type;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int event;

    public Event(int i, int i2) {
        this.type = i;
        this.event = i2;
    }

    public static /* synthetic */ Event copy$default(Event event, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = event.type;
        }
        if ((i3 & 2) != 0) {
            i2 = event.event;
        }
        return event.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEvent() {
        return this.event;
    }

    public final Event copy(int type, int event) {
        return new Event(type, event);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return this.type == event.type && this.event == event.event;
    }

    public final int getEvent() {
        return this.event;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.event) + (Integer.hashCode(this.type) * 31);
    }

    public String toString() {
        return "Event(type=" + this.type + ", event=" + this.event + ')';
    }
}
