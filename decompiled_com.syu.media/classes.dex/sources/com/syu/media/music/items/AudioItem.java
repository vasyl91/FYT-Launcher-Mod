package com.syu.media.music.items;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.google.android.material.timepicker.TimeModel;
import com.syu.media.Constraint;
import com.syu.media.ConstraintList;
import com.syu.media.MediaFiles;
import com.syu.media.MediaHelper;
import com.syu.media.MediaProxy;
import com.syu.media.PlayState;
import com.syu.media.R;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.TimeUtils;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.MediaSource;
import com.syu.media.service.MediaPresenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import syu.recyclerview.GroupNode;
import syu.recyclerview.Node;
import syu.recyclerview.ViewHolder;

/* JADX INFO: compiled from: AudioItem.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/syu/media/music/items/AudioItem;", "Lsyu/recyclerview/Node;", "Lcom/syu/media/entities/AudioSource;", "()V", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getViewType", FinalChip.BSP_PLATFORM_Null, "onBindViewHolder", FinalChip.BSP_PLATFORM_Null, "holder", "Lsyu/recyclerview/ViewHolder;", "onClick", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AudioItem extends Node<AudioSource> {
    public static final String TAG = "AudioItem";
    private final CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() { // from class: com.syu.media.music.items.AudioItem$$ExternalSyntheticLambda0
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AudioItem.m187listener$lambda1(this.f$0, compoundButton, z);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: listener$lambda-1, reason: not valid java name */
    public static final void m187listener$lambda1(AudioItem audioItem, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(audioItem, "this$0");
        AudioSource audioSource = (AudioSource) audioItem.getData();
        if (audioSource != null) {
            audioSource.setFavorite(z);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AudioItem$listener$1$1$1(audioItem, null), 3, (Object) null);
        }
    }

    public int getViewType() {
        return R.layout.music_track_layout;
    }

    public void onBindViewHolder(ViewHolder holder) {
        PlayState playState;
        MediaSource playingSource;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ImageView imageView = (ImageView) holder.findViewById(R.id.music_iv_bounce);
        CheckBox checkBox = (CheckBox) holder.findViewById(R.id.music_item_favorite);
        TextView textView = (TextView) holder.findViewById(R.id.music_item_index);
        AudioSource audioSource = (AudioSource) getData();
        if (audioSource != null) {
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(null);
            }
            if (checkBox != null) {
                checkBox.setChecked(audioSource.getFavorite());
            }
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(this.listener);
            }
            View view = holder.itemView;
            MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            view.setSelected((audioProxy == null || (playingSource = audioProxy.getPlayingSource()) == null) ? false : Boolean.valueOf(Intrinsics.areEqual(playingSource.getCom.syu.media.provider.Media.PATH java.lang.String(), audioSource.getCom.syu.media.provider.Media.PATH java.lang.String())).booleanValue());
            Log.d(TAG, " itemView.isSelected:" + holder.itemView.isSelected());
            Drawable drawable = imageView != null ? imageView.getDrawable() : null;
            if (drawable instanceof AnimationDrawable) {
                Log.d(TAG, " isSelected:" + holder.itemView.isSelected());
                MediaProxy audioProxy2 = MediaHelper.INSTANCE.getHelper().getAudioProxy();
                if (((audioProxy2 == null || (playState = audioProxy2.getPlayState()) == null || playState.isPlaying()) ? false : true) && holder.itemView.isSelected()) {
                    ((AnimationDrawable) drawable).stop();
                } else if (holder.itemView.isSelected()) {
                    ((AnimationDrawable) drawable).start();
                    if (textView != null) {
                        textView.setVisibility(4);
                    }
                    imageView.setVisibility(0);
                } else if (!holder.itemView.isSelected()) {
                    AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                    if (animationDrawable.isRunning() || imageView.getVisibility() == 0) {
                        animationDrawable.stop();
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        imageView.setVisibility(4);
                    }
                }
            }
            holder.setTextView(R.id.music_item_title, holder.itemView.isSelected() ? TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.END);
            int i = R.id.music_item_title;
            String displayName = audioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String();
            if (displayName == null) {
                displayName = FinalChip.BSP_PLATFORM_Null;
            }
            holder.setTextView(i, displayName);
            holder.setTextView(R.id.music_item_totaltime, TimeUtils.INSTANCE.msecToMinutes(audioSource.getCom.syu.media.provider.Media.DURATION java.lang.String()));
            int iIndex = index();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(iIndex + 1)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            if (textView != null) {
                textView.setText(str);
            }
            if (Intrinsics.areEqual(audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String(), MediaFiles.INSTANCE.getUNKNOWN())) {
                holder.setTextView(R.id.music_item_artist, R.string.artist_unknown);
            } else {
                int i2 = R.id.music_item_artist;
                String artist = audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String();
                Intrinsics.checkNotNull(artist);
                holder.setTextView(i2, artist);
            }
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AudioItem$onBindViewHolder$1$3(audioSource, holder, null), 3, (Object) null);
        }
    }

    public void onClick(RecyclerView.ViewHolder holder, int position) {
        MediaPresenter mPresenter;
        MediaSource playingSource;
        Intrinsics.checkNotNullParameter(holder, "holder");
        GroupNode parent = getParent();
        if (parent != null) {
            final MediaProxy audioProxy = MediaHelper.INSTANCE.getHelper().getAudioProxy();
            String str = null;
            if (parent.getData() instanceof ConstraintAlbum) {
                if (audioProxy != null) {
                    Object data = parent.getData();
                    if (data == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.syu.media.music.items.ConstraintAlbum");
                    }
                    audioProxy.setupPlayList(new ConstraintList(null, ((ConstraintAlbum) data).getConstraint(), 1, null), new Function0<Unit>() { // from class: com.syu.media.music.items.AudioItem$onClick$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m188invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m188invoke() {
                            HiLog.INSTANCE.d(AudioItem.TAG, " audio ----->> ConstraintAlbum");
                            MediaSource playingSource2 = audioProxy.getPlayingSource();
                            String str2 = playingSource2 != null ? playingSource2.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
                            Object data2 = this.getData();
                            Intrinsics.checkNotNull(data2);
                            if (Intrinsics.areEqual(str2, ((AudioSource) data2).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                                return;
                            }
                            MediaPresenter mPresenter2 = audioProxy.getMPresenter();
                            Object data3 = this.getData();
                            Intrinsics.checkNotNull(data3);
                            mPresenter2.playWithPath(((AudioSource) data3).getCom.syu.media.provider.Media.PATH java.lang.String());
                        }
                    });
                    return;
                }
                return;
            }
            if (parent.getData() instanceof ConstraintArtist) {
                if (audioProxy != null) {
                    Object data2 = parent.getData();
                    if (data2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.syu.media.music.items.ConstraintArtist");
                    }
                    audioProxy.setupPlayList(new ConstraintList(null, ((ConstraintArtist) data2).getConstraint(), 1, null), new Function0<Unit>() { // from class: com.syu.media.music.items.AudioItem$onClick$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m189invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m189invoke() {
                            HiLog.INSTANCE.e(AudioItem.TAG, " audio ----->> ConstraintArtist");
                            MediaSource playingSource2 = audioProxy.getPlayingSource();
                            String str2 = playingSource2 != null ? playingSource2.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
                            Object data3 = this.getData();
                            Intrinsics.checkNotNull(data3);
                            if (Intrinsics.areEqual(str2, ((AudioSource) data3).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                                return;
                            }
                            MediaPresenter mPresenter2 = audioProxy.getMPresenter();
                            Object data4 = this.getData();
                            Intrinsics.checkNotNull(data4);
                            mPresenter2.playWithPath(((AudioSource) data4).getCom.syu.media.provider.Media.PATH java.lang.String());
                        }
                    });
                    return;
                }
                return;
            }
            if (parent.getData() instanceof ConstraintFolder) {
                if (audioProxy != null) {
                    Object data3 = parent.getData();
                    if (data3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.syu.media.music.items.ConstraintFolder");
                    }
                    audioProxy.setupPlayList(new ConstraintList(null, ((ConstraintFolder) data3).getConstraint(), 1, null), new Function0<Unit>() { // from class: com.syu.media.music.items.AudioItem$onClick$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m190invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m190invoke() {
                            HiLog.INSTANCE.e(AudioItem.TAG, " audio ----->> ConstraintFolder");
                            MediaSource playingSource2 = audioProxy.getPlayingSource();
                            String str2 = playingSource2 != null ? playingSource2.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
                            Object data4 = this.getData();
                            Intrinsics.checkNotNull(data4);
                            if (Intrinsics.areEqual(str2, ((AudioSource) data4).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                                return;
                            }
                            MediaPresenter mPresenter2 = audioProxy.getMPresenter();
                            Object data5 = this.getData();
                            Intrinsics.checkNotNull(data5);
                            mPresenter2.playWithPath(((AudioSource) data5).getCom.syu.media.provider.Media.PATH java.lang.String());
                        }
                    });
                    return;
                }
                return;
            }
            if (parent.getMTag() instanceof Constraint) {
                Log.e(TAG, " audio ----->> 00");
                if (audioProxy != null) {
                    Object mTag = parent.getMTag();
                    if (mTag == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.syu.media.Constraint");
                    }
                    audioProxy.setupPlayList(new ConstraintList(null, (Constraint) mTag, 1, null), new Function0<Unit>() { // from class: com.syu.media.music.items.AudioItem$onClick$1$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m191invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m191invoke() {
                            HiLog hiLog = HiLog.INSTANCE;
                            StringBuilder sb = new StringBuilder(" audio ----->> 00 data!!.path");
                            Object data4 = this.this$0.getData();
                            Intrinsics.checkNotNull(data4);
                            hiLog.e(AudioItem.TAG, sb.append(((AudioSource) data4).getCom.syu.media.provider.Media.PATH java.lang.String()).toString());
                            MediaSource playingSource2 = audioProxy.getPlayingSource();
                            String str2 = playingSource2 != null ? playingSource2.getCom.syu.media.provider.Media.PATH java.lang.String() : null;
                            Object data5 = this.this$0.getData();
                            Intrinsics.checkNotNull(data5);
                            if (Intrinsics.areEqual(str2, ((AudioSource) data5).getCom.syu.media.provider.Media.PATH java.lang.String())) {
                                return;
                            }
                            MediaPresenter mPresenter2 = audioProxy.getMPresenter();
                            Object data6 = this.this$0.getData();
                            Intrinsics.checkNotNull(data6);
                            mPresenter2.playWithPath(((AudioSource) data6).getCom.syu.media.provider.Media.PATH java.lang.String());
                        }
                    });
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder(" audio ----->> 11 data!!.path");
            Object data4 = getData();
            Intrinsics.checkNotNull(data4);
            Log.e(TAG, sb.append(((AudioSource) data4).getCom.syu.media.provider.Media.PATH java.lang.String()).toString());
            if (audioProxy != null && (playingSource = audioProxy.getPlayingSource()) != null) {
                str = playingSource.getCom.syu.media.provider.Media.PATH java.lang.String();
            }
            Object data5 = getData();
            Intrinsics.checkNotNull(data5);
            if (Intrinsics.areEqual(str, ((AudioSource) data5).getCom.syu.media.provider.Media.PATH java.lang.String()) || audioProxy == null || (mPresenter = audioProxy.getMPresenter()) == null) {
                return;
            }
            Object data6 = getData();
            Intrinsics.checkNotNull(data6);
            mPresenter.playWithPath(((AudioSource) data6).getCom.syu.media.provider.Media.PATH java.lang.String());
        }
    }
}
