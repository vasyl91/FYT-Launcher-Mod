package com.syu.media.music.binding;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentContainerView;
import chip.FinalChip;
import com.syu.media.R;
import com.syu.media.companion.view.fons.CompasseTextView;
import com.syu.media.companion.view.fons.FaceMyingheiTextView;
import com.syu.media.companion.view.fons.SemiboldTextView;
import com.syu.media.music.widget.SpinRecyclerView;
import com.syu.media.provider.MediaConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qin.widgets.JRecyclerView;

/* JADX INFO: compiled from: MusicFragmentViewBinding.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u008a\u0001\u001a\u0005\u0018\u0001H\u008b\u0001\"\u000b\b\u0000\u0010\u008b\u0001*\u0004\u0018\u0001012\b\u0010\u0002\u001a\u0004\u0018\u0001012\n\b\u0001\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002¢\u0006\u0003\u0010\u008e\u0001J\u001b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008f\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0090\u0001\u001a\u00020^J\u0011\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u0090\u0001\u001a\u00020^R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001c\u0010-\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\b\"\u0004\b/\u0010\nR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"R\u001c\u0010K\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010 \"\u0004\bM\u0010\"R\u001c\u0010N\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010%\"\u0004\bS\u0010\u0004R\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010E\"\u0004\b\\\u0010GR\u0014\u0010]\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010`R\u0014\u0010c\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010`R\u0014\u0010e\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010`R\u0014\u0010g\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bh\u0010`R\u0014\u0010i\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bj\u0010`R\u0014\u0010k\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bl\u0010`R\u0014\u0010m\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bn\u0010`R\u0014\u0010o\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bp\u0010`R\u0014\u0010q\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\br\u0010`R\u0014\u0010s\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bt\u0010`R\u0014\u0010u\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bv\u0010`R\u0014\u0010w\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bx\u0010`R\u0014\u0010y\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bz\u0010`R\u0014\u0010{\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b|\u0010`R\u0014\u0010}\u001a\u00020^X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b~\u0010`R\u0015\u0010\u007f\u001a\u00020^X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010`R\u0016\u0010\u0081\u0001\u001a\u00020^X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010`R\u0016\u0010\u0083\u0001\u001a\u00020^X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010`R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u0087\u0001\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010%\"\u0005\b\u0089\u0001\u0010\u0004¨\u0006\u0092\u0001"}, d2 = {"Lcom/syu/media/music/binding/MusicFragmentViewBinding;", FinalChip.BSP_PLATFORM_Null, "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "musicArtist", "Lcom/syu/media/companion/view/fons/SemiboldTextView;", "getMusicArtist", "()Lcom/syu/media/companion/view/fons/SemiboldTextView;", "setMusicArtist", "(Lcom/syu/media/companion/view/fons/SemiboldTextView;)V", "musicFavorite", "Landroid/widget/CheckBox;", "getMusicFavorite", "()Landroid/widget/CheckBox;", "setMusicFavorite", "(Landroid/widget/CheckBox;)V", "musicFragBlurImg", "Landroidx/fragment/app/FragmentContainerView;", "getMusicFragBlurImg", "()Landroidx/fragment/app/FragmentContainerView;", "setMusicFragBlurImg", "(Landroidx/fragment/app/FragmentContainerView;)V", "musicList", "Lcom/syu/media/companion/view/fons/FaceMyingheiTextView;", "getMusicList", "()Lcom/syu/media/companion/view/fons/FaceMyingheiTextView;", "setMusicList", "(Lcom/syu/media/companion/view/fons/FaceMyingheiTextView;)V", "musicListUnfoldTransform", "Landroid/widget/ImageView;", "getMusicListUnfoldTransform", "()Landroid/widget/ImageView;", "setMusicListUnfoldTransform", "(Landroid/widget/ImageView;)V", "musicMainContain", "getMusicMainContain", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMusicMainContain", "musicMainListContain", "getMusicMainListContain", "setMusicMainListContain", "musicMode", "getMusicMode", "setMusicMode", "musicName", "getMusicName", "setMusicName", "musicNameLeftMargin", "Landroid/view/View;", "getMusicNameLeftMargin", "()Landroid/view/View;", "setMusicNameLeftMargin", "(Landroid/view/View;)V", "musicPlayListRecycler", "Lqin/widgets/JRecyclerView;", "getMusicPlayListRecycler", "()Lqin/widgets/JRecyclerView;", "setMusicPlayListRecycler", "(Lqin/widgets/JRecyclerView;)V", "musicPlaySeekbar", "Landroid/widget/SeekBar;", "getMusicPlaySeekbar", "()Landroid/widget/SeekBar;", "setMusicPlaySeekbar", "(Landroid/widget/SeekBar;)V", "musicPlayTime", "Lcom/syu/media/companion/view/fons/CompasseTextView;", "getMusicPlayTime", "()Lcom/syu/media/companion/view/fons/CompasseTextView;", "setMusicPlayTime", "(Lcom/syu/media/companion/view/fons/CompasseTextView;)V", "musicPlayerNext", "getMusicPlayerNext", "setMusicPlayerNext", "musicPlayerPlaypause", "getMusicPlayerPlaypause", "setMusicPlayerPlaypause", "musicPlayerPrev", "getMusicPlayerPrev", "setMusicPlayerPrev", "musicSeekbarGroup", "getMusicSeekbarGroup", "setMusicSeekbarGroup", "musicSpinListRecycler", "Lcom/syu/media/music/widget/SpinRecyclerView;", "getMusicSpinListRecycler", "()Lcom/syu/media/music/widget/SpinRecyclerView;", "setMusicSpinListRecycler", "(Lcom/syu/media/music/widget/SpinRecyclerView;)V", "musicTotalTime", "getMusicTotalTime", "setMusicTotalTime", "music_artist", FinalChip.BSP_PLATFORM_Null, "getMusic_artist", "()Ljava/lang/String;", "music_favorite", "getMusic_favorite", "music_frag_blur_img", "getMusic_frag_blur_img", "music_list", "getMusic_list", "music_list_unfold_transform", "getMusic_list_unfold_transform", "music_main_contain", "getMusic_main_contain", "music_main_list_contain", "getMusic_main_list_contain", "music_mode", "getMusic_mode", "music_name", "getMusic_name", "music_name_left_margin", "getMusic_name_left_margin", "music_play_list_recycler", "getMusic_play_list_recycler", "music_play_seekbar", "getMusic_play_seekbar", "music_play_time", "getMusic_play_time", "music_player_next", "getMusic_player_next", "music_player_playpause", "getMusic_player_playpause", "music_player_prev", "getMusic_player_prev", "music_seekbar_group", "getMusic_seekbar_group", "music_spin_list_recycler", "getMusic_spin_list_recycler", "music_total_time", "getMusic_total_time", "resource", "Landroid/content/res/Resources;", "root", "getRoot", "setRoot", "findChildViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", FinalChip.BSP_PLATFORM_Null, "(Landroid/view/View;I)Landroid/view/View;", "res", "name", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MusicFragmentViewBinding {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "MusicFragmentViewBinding";
    private SemiboldTextView musicArtist;
    private CheckBox musicFavorite;
    private FragmentContainerView musicFragBlurImg;
    private FaceMyingheiTextView musicList;
    private ImageView musicListUnfoldTransform;
    private ConstraintLayout musicMainContain;
    private ConstraintLayout musicMainListContain;
    private ImageView musicMode;
    private SemiboldTextView musicName;
    private View musicNameLeftMargin;
    private JRecyclerView musicPlayListRecycler;
    private SeekBar musicPlaySeekbar;
    private CompasseTextView musicPlayTime;
    private ImageView musicPlayerNext;
    private ImageView musicPlayerPlaypause;
    private ImageView musicPlayerPrev;
    private ConstraintLayout musicSeekbarGroup;
    private SpinRecyclerView musicSpinListRecycler;
    private CompasseTextView musicTotalTime;
    private final String music_artist;
    private final String music_favorite;
    private final String music_frag_blur_img;
    private final String music_list;
    private final String music_list_unfold_transform;
    private final String music_main_contain;
    private final String music_main_list_contain;
    private final String music_mode;
    private final String music_name;
    private final String music_name_left_margin;
    private final String music_play_list_recycler;
    private final String music_play_seekbar;
    private final String music_play_time;
    private final String music_player_next;
    private final String music_player_playpause;
    private final String music_player_prev;
    private final String music_seekbar_group;
    private final String music_spin_list_recycler;
    private final String music_total_time;
    private Resources resource;
    private ConstraintLayout root;

    public /* synthetic */ MusicFragmentViewBinding(ConstraintLayout constraintLayout, DefaultConstructorMarker defaultConstructorMarker) {
        this(constraintLayout);
    }

    public final ConstraintLayout getRoot() {
        return this.root;
    }

    public final void setRoot(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.root = constraintLayout;
    }

    public final SemiboldTextView getMusicArtist() {
        return this.musicArtist;
    }

    public final void setMusicArtist(SemiboldTextView semiboldTextView) {
        this.musicArtist = semiboldTextView;
    }

    public final CheckBox getMusicFavorite() {
        return this.musicFavorite;
    }

    public final void setMusicFavorite(CheckBox checkBox) {
        this.musicFavorite = checkBox;
    }

    public final FragmentContainerView getMusicFragBlurImg() {
        return this.musicFragBlurImg;
    }

    public final void setMusicFragBlurImg(FragmentContainerView fragmentContainerView) {
        this.musicFragBlurImg = fragmentContainerView;
    }

    public final FaceMyingheiTextView getMusicList() {
        return this.musicList;
    }

    public final void setMusicList(FaceMyingheiTextView faceMyingheiTextView) {
        this.musicList = faceMyingheiTextView;
    }

    public final ImageView getMusicListUnfoldTransform() {
        return this.musicListUnfoldTransform;
    }

    public final void setMusicListUnfoldTransform(ImageView imageView) {
        this.musicListUnfoldTransform = imageView;
    }

    public final ConstraintLayout getMusicMainContain() {
        return this.musicMainContain;
    }

    public final void setMusicMainContain(ConstraintLayout constraintLayout) {
        this.musicMainContain = constraintLayout;
    }

    public final ConstraintLayout getMusicMainListContain() {
        return this.musicMainListContain;
    }

    public final void setMusicMainListContain(ConstraintLayout constraintLayout) {
        this.musicMainListContain = constraintLayout;
    }

    public final ImageView getMusicMode() {
        return this.musicMode;
    }

    public final void setMusicMode(ImageView imageView) {
        this.musicMode = imageView;
    }

    public final SemiboldTextView getMusicName() {
        return this.musicName;
    }

    public final void setMusicName(SemiboldTextView semiboldTextView) {
        this.musicName = semiboldTextView;
    }

    public final View getMusicNameLeftMargin() {
        return this.musicNameLeftMargin;
    }

    public final void setMusicNameLeftMargin(View view) {
        this.musicNameLeftMargin = view;
    }

    public final JRecyclerView getMusicPlayListRecycler() {
        return this.musicPlayListRecycler;
    }

    public final void setMusicPlayListRecycler(JRecyclerView jRecyclerView) {
        this.musicPlayListRecycler = jRecyclerView;
    }

    public final SeekBar getMusicPlaySeekbar() {
        return this.musicPlaySeekbar;
    }

    public final void setMusicPlaySeekbar(SeekBar seekBar) {
        this.musicPlaySeekbar = seekBar;
    }

    public final CompasseTextView getMusicPlayTime() {
        return this.musicPlayTime;
    }

    public final void setMusicPlayTime(CompasseTextView compasseTextView) {
        this.musicPlayTime = compasseTextView;
    }

    public final ImageView getMusicPlayerNext() {
        return this.musicPlayerNext;
    }

    public final void setMusicPlayerNext(ImageView imageView) {
        this.musicPlayerNext = imageView;
    }

    public final ImageView getMusicPlayerPlaypause() {
        return this.musicPlayerPlaypause;
    }

    public final void setMusicPlayerPlaypause(ImageView imageView) {
        this.musicPlayerPlaypause = imageView;
    }

    public final ImageView getMusicPlayerPrev() {
        return this.musicPlayerPrev;
    }

    public final void setMusicPlayerPrev(ImageView imageView) {
        this.musicPlayerPrev = imageView;
    }

    public final ConstraintLayout getMusicSeekbarGroup() {
        return this.musicSeekbarGroup;
    }

    public final void setMusicSeekbarGroup(ConstraintLayout constraintLayout) {
        this.musicSeekbarGroup = constraintLayout;
    }

    public final SpinRecyclerView getMusicSpinListRecycler() {
        return this.musicSpinListRecycler;
    }

    public final void setMusicSpinListRecycler(SpinRecyclerView spinRecyclerView) {
        this.musicSpinListRecycler = spinRecyclerView;
    }

    public final CompasseTextView getMusicTotalTime() {
        return this.musicTotalTime;
    }

    public final void setMusicTotalTime(CompasseTextView compasseTextView) {
        this.musicTotalTime = compasseTextView;
    }

    public final String getMusic_mode() {
        return this.music_mode;
    }

    public final String getMusic_name() {
        return this.music_name;
    }

    public final String getMusic_list() {
        return this.music_list;
    }

    public final String getMusic_artist() {
        return this.music_artist;
    }

    public final String getMusic_favorite() {
        return this.music_favorite;
    }

    public final String getMusic_frag_blur_img() {
        return this.music_frag_blur_img;
    }

    public final String getMusic_main_contain() {
        return this.music_main_contain;
    }

    public final String getMusic_main_list_contain() {
        return this.music_main_list_contain;
    }

    public final String getMusic_name_left_margin() {
        return this.music_name_left_margin;
    }

    public final String getMusic_play_list_recycler() {
        return this.music_play_list_recycler;
    }

    public final String getMusic_play_seekbar() {
        return this.music_play_seekbar;
    }

    public final String getMusic_play_time() {
        return this.music_play_time;
    }

    public final String getMusic_player_prev() {
        return this.music_player_prev;
    }

    public final String getMusic_player_playpause() {
        return this.music_player_playpause;
    }

    public final String getMusic_player_next() {
        return this.music_player_next;
    }

    public final String getMusic_seekbar_group() {
        return this.music_seekbar_group;
    }

    public final String getMusic_spin_list_recycler() {
        return this.music_spin_list_recycler;
    }

    public final String getMusic_total_time() {
        return this.music_total_time;
    }

    public final String getMusic_list_unfold_transform() {
        return this.music_list_unfold_transform;
    }

    private MusicFragmentViewBinding(ConstraintLayout constraintLayout) {
        this.music_mode = "music_mode";
        this.music_name = "music_name";
        this.music_list = "music_list";
        this.music_artist = "music_artist";
        this.music_favorite = "music_favorite";
        this.music_frag_blur_img = "music_frag_blur_img";
        this.music_main_contain = "music_main_contain";
        this.music_main_list_contain = "music_main_list_contain";
        this.music_name_left_margin = "music_name_left_margin";
        this.music_play_list_recycler = "music_play_list_recycler";
        this.music_play_seekbar = "music_play_seekbar";
        this.music_play_time = "music_play_time";
        this.music_player_prev = "music_player_prev";
        this.music_player_playpause = "music_player_playpause";
        this.music_player_next = "music_player_next";
        this.music_seekbar_group = "music_seekbar_group";
        this.music_spin_list_recycler = "music_spin_list_recycler";
        this.music_total_time = "music_total_time";
        this.music_list_unfold_transform = "music_list_unfold_transform";
        this.root = constraintLayout;
        Resources resources = constraintLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        this.resource = resources;
        ConstraintLayout constraintLayout2 = constraintLayout;
        this.musicMode = (ImageView) findChildViewById(constraintLayout2, id("music_mode"));
        this.musicName = (SemiboldTextView) findChildViewById(constraintLayout2, id("music_name"));
        this.musicList = (FaceMyingheiTextView) findChildViewById(constraintLayout2, id("music_list"));
        this.musicArtist = (SemiboldTextView) findChildViewById(constraintLayout2, id("music_artist"));
        this.musicFavorite = (CheckBox) findChildViewById(constraintLayout2, id("music_favorite"));
        this.musicFragBlurImg = (FragmentContainerView) findChildViewById(constraintLayout2, id("music_frag_blur_img"));
        this.musicMainContain = (ConstraintLayout) findChildViewById(constraintLayout2, id("music_main_contain"));
        this.musicMainListContain = (ConstraintLayout) findChildViewById(constraintLayout2, id("music_main_list_contain"));
        this.musicNameLeftMargin = findChildViewById(constraintLayout2, id("music_name_left_margin"));
        this.musicPlayListRecycler = findChildViewById(constraintLayout2, id("music_play_list_recycler"));
        this.musicPlaySeekbar = (SeekBar) findChildViewById(constraintLayout2, id("music_play_seekbar"));
        this.musicPlayTime = (CompasseTextView) findChildViewById(constraintLayout2, id("music_play_time"));
        this.musicPlayerPrev = (ImageView) findChildViewById(constraintLayout2, id("music_player_prev"));
        this.musicPlayerPlaypause = (ImageView) findChildViewById(constraintLayout2, id("music_player_playpause"));
        this.musicPlayerNext = (ImageView) findChildViewById(constraintLayout2, id("music_player_next"));
        this.musicSeekbarGroup = (ConstraintLayout) findChildViewById(constraintLayout2, id("music_seekbar_group"));
        this.musicSpinListRecycler = (SpinRecyclerView) findChildViewById(constraintLayout2, id("music_spin_list_recycler"));
        this.musicTotalTime = (CompasseTextView) findChildViewById(constraintLayout2, id("music_total_time"));
        this.musicListUnfoldTransform = (ImageView) findChildViewById(constraintLayout2, id("music_list_unfold_transform"));
    }

    /* JADX INFO: compiled from: MusicFragmentViewBinding.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/syu/media/music/binding/MusicFragmentViewBinding$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "bind", "Lcom/syu/media/music/binding/MusicFragmentViewBinding;", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "inflate", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "attachToParent", FinalChip.BSP_PLATFORM_Null, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MusicFragmentViewBinding inflate(LayoutInflater inflater) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            return inflate(inflater, null, false);
        }

        public final MusicFragmentViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View viewInflate = inflater.inflate(R.layout.music_fragment, parent, false);
            if (viewInflate == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
            if (attachToParent && parent != null) {
                parent.addView(constraintLayout);
            }
            return bind(constraintLayout);
        }

        public final MusicFragmentViewBinding bind(ConstraintLayout rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            return new MusicFragmentViewBinding(rootView, null);
        }
    }

    public final int id(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Resources resources = this.resource;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resource");
            resources = null;
        }
        return id(resources, name);
    }

    public final int id(Resources res, String name) {
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(name, "name");
        return res.getIdentifier(name, "id", MediaConstant.AUTHORITY);
    }

    private final <T extends View> T findChildViewById(View rootView, int id) {
        if (!(rootView instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) rootView;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            T t = (T) viewGroup.getChildAt(i).findViewById(id);
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
