package com.syu.radio.items;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.syu.manger.AutoManager;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioModel;
import com.syu.media.MediaApp;
import com.syu.media.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: PtyItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/syu/radio/items/PtyItem;", "Lsyu/recyclerview/Node;", "", "()V", "mHolder", "Lsyu/recyclerview/ViewHolder;", "getMHolder", "()Lsyu/recyclerview/ViewHolder;", "setMHolder", "(Lsyu/recyclerview/ViewHolder;)V", "observer", "Landroidx/lifecycle/Observer;", "", "getObserver", "()Landroidx/lifecycle/Observer;", "radioModel", "Lcom/syu/manger/module/radio/RadioModel;", "getRadioModel", "()Lcom/syu/manger/module/radio/RadioModel;", "radioModel$delegate", "Lkotlin/Lazy;", "getViewType", "onBindViewHolder", "", "holder", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "spanSize", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PtyItem extends Node<String> {
    private ViewHolder mHolder;
    private final Observer<Integer> observer;

    /* JADX INFO: renamed from: radioModel$delegate, reason: from kotlin metadata */
    private final Lazy radioModel = LazyKt.lazy(new Function0<RadioModel>() { // from class: com.syu.radio.items.PtyItem$radioModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RadioModel invoke() {
            RadioModel radioModel = MediaApp.Companion.getMe().getViewModelProvider().get(RadioModel.class);
            Intrinsics.checkNotNullExpressionValue(radioModel, "viewModelProvider.get(VM::class.java)");
            return radioModel;
        }
    });

    public int spanSize() {
        return 3;
    }

    public PtyItem() {
        Observer<Integer> observer = new Observer() { // from class: com.syu.radio.items.PtyItem$$ExternalSyntheticLambda0
            public final void onChanged(Object obj) {
                PtyItem.m50observer$lambda1(this.f$0, (Integer) obj);
            }
        };
        this.observer = observer;
        getRadioModel().getPtyId().observeForever(observer);
    }

    public final RadioModel getRadioModel() {
        return (RadioModel) this.radioModel.getValue();
    }

    public final ViewHolder getMHolder() {
        return this.mHolder;
    }

    public final void setMHolder(ViewHolder viewHolder) {
        this.mHolder = viewHolder;
    }

    public final Observer<Integer> getObserver() {
        return this.observer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: observer$lambda-1, reason: not valid java name */
    public static final void m50observer$lambda1(PtyItem this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewHolder viewHolder = this$0.mHolder;
        if (viewHolder != null) {
            viewHolder.itemView.setSelected(num != null && num.intValue() == viewHolder.getLayoutPosition());
        }
    }

    public int getViewType() {
        return R.layout.rds_pty_item;
    }

    public void onBindViewHolder(ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder);
        this.mHolder = holder;
        String str = (String) getData();
        if (str != null) {
            holder.setTextView(R.id.pty_title, str);
        }
        View view = holder.itemView;
        Integer num = (Integer) getRadioModel().getPtyId().getValue();
        view.setSelected(num != null && num.intValue() == holder.getLayoutPosition());
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onClick(holder, position);
        RadioController radioController = AutoManager.Companion.requestInstance().getRadioController();
        if (radioController != null) {
            radioController.ptySeekStation(position + 3);
        }
    }
}
