package com.syu.manger.module.event;

import android.util.SparseArray;
import chip.FinalChip;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Lcom/syu/manger/module/event/EventManager;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/manger/module/event/EventManager$EventHandler;", "handler", FinalChip.BSP_PLATFORM_Null, "setEventHandler", FinalChip.BSP_PLATFORM_Null, "keyCode", "removeEventHandler", "Lcom/syu/manger/module/event/EventManager$OnPlayCtrlHandler;", "addOnPlayCtrlHandler", "appId", "removeOnPlayCtrlHandler", "onClick", "cmdId", "onPlayControl", "Companion", "EventHandler", "OnPlayCtrlHandler", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class EventManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Lazy c = LazyKt.lazy(new Function0<EventManager>() { // from class: com.syu.manger.module.event.EventManager$Companion$me$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final EventManager m70invoke() {
            return new EventManager(null);
        }
    });
    public final Lazy a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/syu/manger/module/event/EventManager$Companion;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/manger/module/event/EventManager;", "me$delegate", "Lkotlin/Lazy;", "getMe", "()Lcom/syu/manger/module/event/EventManager;", "me", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventManager getMe() {
            return (EventManager) EventManager.c.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/syu/manger/module/event/EventManager$EventHandler;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "onEvent", FinalChip.BSP_PLATFORM_Null, "a", "I", "getKeyCode", "()I", "keyCode", "<init>", "(I)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class EventHandler {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final int keyCode;

        public EventHandler(int i) {
            this.keyCode = i;
        }

        public final int getKeyCode() {
            return this.keyCode;
        }

        public abstract void onEvent();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/syu/manger/module/event/EventManager$OnPlayCtrlHandler;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "cmdId", FinalChip.BSP_PLATFORM_Null, "onPlayCtrl", "a", "I", "getAppId", "()I", "appId", "<init>", "(I)V", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class OnPlayCtrlHandler {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final int appId;

        public OnPlayCtrlHandler(int i) {
            this.appId = i;
        }

        public final int getAppId() {
            return this.appId;
        }

        public abstract void onPlayCtrl(int cmdId);
    }

    public EventManager() {
        this.a = LazyKt.lazy(new Function0<SparseArray<OnPlayCtrlHandler>>() { // from class: com.syu.manger.module.event.EventManager$playCtrlHandlers$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SparseArray<EventManager.OnPlayCtrlHandler> m72invoke() {
                return new SparseArray<>();
            }
        });
        this.b = LazyKt.lazy(new Function0<SparseArray<EventHandler>>() { // from class: com.syu.manger.module.event.EventManager$eventHandlers$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SparseArray<EventManager.EventHandler> m71invoke() {
                return new SparseArray<>();
            }
        });
    }

    public final void addOnPlayCtrlHandler(OnPlayCtrlHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        ((SparseArray) this.a.getValue()).put(handler.getAppId(), handler);
    }

    public final void onClick(int keyCode) {
        EventHandler eventHandler = (EventHandler) ((SparseArray) this.b.getValue()).get(keyCode);
        if (eventHandler != null) {
            eventHandler.onEvent();
        }
    }

    public final void onPlayControl(int appId, int cmdId) {
        OnPlayCtrlHandler onPlayCtrlHandler = (OnPlayCtrlHandler) ((SparseArray) this.a.getValue()).get(appId);
        if (onPlayCtrlHandler != null) {
            onPlayCtrlHandler.onPlayCtrl(cmdId);
        }
    }

    public final void removeEventHandler(int keyCode) {
        ((SparseArray) this.b.getValue()).remove(keyCode);
    }

    public final void removeOnPlayCtrlHandler(int appId) {
        ((SparseArray) this.a.getValue()).remove(appId);
    }

    public final void setEventHandler(EventHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        ((SparseArray) this.b.getValue()).put(handler.getKeyCode(), handler);
    }

    public /* synthetic */ EventManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
