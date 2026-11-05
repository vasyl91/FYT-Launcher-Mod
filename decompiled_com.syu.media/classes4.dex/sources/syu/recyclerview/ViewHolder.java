package syu.recyclerview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u000f\u0012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J!\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006-"}, d2 = {"Lsyu/recyclerview/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lsyu/recyclerview/ViewHolder$OnItemClick;", "itemClick", "", "setOnItemClick", "Landroid/view/View;", "V", "", "id", "findViewById", "(I)Landroid/view/View;", "resId", "setBackground", "visibility", "setVisibility", "setTextView", "", "msg", "Landroid/text/TextUtils$TruncateAt;", "ellipsize", "setImageView", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "bitmap", "setImageViewWithBimap", "", "checked", "setChecked", "selected", "setSelected", "a", "Lsyu/recyclerview/ViewHolder$OnItemClick;", "getMItemClick", "()Lsyu/recyclerview/ViewHolder$OnItemClick;", "setMItemClick", "(Lsyu/recyclerview/ViewHolder$OnItemClick;)V", "mItemClick", "itemView", "<init>", "(Landroid/view/View;)V", "Companion", "OnItemClick", "OnItemLongClick", "Library_release"}, k = 1, mv = {1, 7, 1})
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public OnItemClick mItemClick;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lsyu/recyclerview/ViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "parent", "", "layoutId", "Lsyu/recyclerview/ViewHolder;", "createViewHolder", "Library_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewHolder createViewHolder(ViewGroup parent, int layoutId) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "it");
            return new ViewHolder(viewInflate);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lsyu/recyclerview/ViewHolder$OnItemClick;", "", "onClick", "", "holder", "Lsyu/recyclerview/ViewHolder;", "position", "", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnItemClick {
        void onClick(ViewHolder holder, int position);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lsyu/recyclerview/ViewHolder$OnItemLongClick;", "D", "", "onClick", "", "holder", "Lsyu/recyclerview/ViewHolder;", "position", "", "Library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnItemLongClick<D> {
        boolean onClick(ViewHolder holder, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public static final void a(OnItemClick onItemClick, ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "this$0");
        if (onItemClick != null) {
            onItemClick.onClick(viewHolder, viewHolder.getLayoutPosition());
        }
    }

    public static /* synthetic */ void setOnItemClick$default(ViewHolder viewHolder, OnItemClick onItemClick, int i, Object obj) {
        if ((i & 1) != 0) {
            onItemClick = null;
        }
        viewHolder.setOnItemClick(onItemClick);
    }

    public final <V extends View> V findViewById(int id) {
        return (V) ((RecyclerView.ViewHolder) this).itemView.findViewById(id);
    }

    public final OnItemClick getMItemClick() {
        return this.mItemClick;
    }

    public final void setBackground(int id, int resId) {
        View viewFindViewById = findViewById(id);
        if (!(viewFindViewById instanceof View)) {
            viewFindViewById = null;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(resId);
        }
    }

    public final void setChecked(int id, boolean checked) {
        KeyEvent.Callback callbackFindViewById = findViewById(id);
        if (!(callbackFindViewById instanceof View)) {
            callbackFindViewById = null;
        }
        if (callbackFindViewById == null || !(callbackFindViewById instanceof Checkable)) {
            return;
        }
        ((Checkable) callbackFindViewById).setChecked(checked);
    }

    public final void setImageView(int id, int resId) {
        View viewFindViewById = findViewById(id);
        ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
    }

    public final void setImageViewWithBimap(int id, Bitmap bitmap) {
        View viewFindViewById = findViewById(id);
        ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public final void setMItemClick(OnItemClick onItemClick) {
        this.mItemClick = onItemClick;
    }

    public final void setOnItemClick(final OnItemClick itemClick) {
        if (itemClick != null && !((RecyclerView.ViewHolder) this).itemView.hasOnClickListeners()) {
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new View.OnClickListener() { // from class: syu.recyclerview.ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewHolder.a(itemClick, this, view);
                }
            });
        }
        if (itemClick == null) {
            this.mItemClick = null;
        }
    }

    public final void setSelected(int id, boolean selected) {
        View viewFindViewById = findViewById(id);
        if (!(viewFindViewById instanceof View)) {
            viewFindViewById = null;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setSelected(selected);
        }
    }

    public final void setTextView(int id, int resId) {
        View viewFindViewById = findViewById(id);
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView != null) {
            textView.setText(resId);
        }
    }

    public final void setVisibility(int id, int visibility) {
        View viewFindViewById = findViewById(id);
        if (!(viewFindViewById instanceof View)) {
            viewFindViewById = null;
        }
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(visibility);
    }

    public final void setImageView(int id, Drawable drawable) {
        View viewFindViewById = findViewById(id);
        ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setTextView(int id, TextUtils.TruncateAt ellipsize) {
        Intrinsics.checkNotNullParameter(ellipsize, "ellipsize");
        View viewFindViewById = findViewById(id);
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView == null) {
            return;
        }
        textView.setEllipsize(ellipsize);
    }

    public final void setTextView(int id, String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        View viewFindViewById = findViewById(id);
        TextView textView = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
        if (textView == null) {
            return;
        }
        textView.setText(msg);
    }
}
