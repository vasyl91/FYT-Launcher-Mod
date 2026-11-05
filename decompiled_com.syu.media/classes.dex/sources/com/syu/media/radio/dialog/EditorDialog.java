package com.syu.media.radio.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import chip.FinalChip;
import com.syu.manger.AutoManager;
import com.syu.manger.module.main.MainModel;
import com.syu.manger.module.radio.RadioController;
import com.syu.manger.module.radio.RadioUtils;
import com.syu.media.MediaApp;
import com.syu.media.R;
import com.syu.media.companion.decoration.SimpleItemDecoration;
import com.syu.media.companion.utils.HiLog;
import com.syu.media.companion.utils.StringUtils;
import com.syu.media.radio.fragment.RadioStationsFragment;
import com.syu.radio.Radio;
import com.syu.radio.dao.RadioDao;
import com.syu.radio.entities.RadioStation;
import com.syu.radio.entities.Station;
import com.syu.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import syu.recyclerview.NodeAdapter;

/* JADX INFO: compiled from: EditorDialog.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u000202H\u0002J \u00105\u001a\u0002022\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\f2\b\b\u0002\u00108\u001a\u00020\fJ\b\u00109\u001a\u000202H\u0002J\u0012\u0010:\u001a\u0002022\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u000202H\u0016J\u001a\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u000e\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\n\u001a\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/syu/media/radio/dialog/EditorDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "addChannelView", "Landroid/view/View;", "app", "Lcom/syu/media/MediaApp;", "getApp", "()Lcom/syu/media/MediaApp;", "app$delegate", "Lkotlin/Lazy;", "editState", FinalChip.BSP_PLATFORM_Null, "editorRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "freqTv", "Landroid/widget/TextView;", "iCity", FinalChip.BSP_PLATFORM_Null, "job", "Lkotlinx/coroutines/Job;", "mAdapter", "Lsyu/recyclerview/NodeAdapter;", "mChannels", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/radio/entities/Station;", "mainModel", "Lcom/syu/manger/module/main/MainModel;", "getMainModel", "()Lcom/syu/manger/module/main/MainModel;", "mainModel$delegate", "nameTv", "nextBtn", "Landroid/widget/ImageView;", "objectStaion", "Lcom/syu/radio/entities/RadioStation;", "prevBtn", "radioController", "Lcom/syu/manger/module/radio/RadioController;", "getRadioController", "()Lcom/syu/manger/module/radio/RadioController;", "radioController$delegate", "radioDao", "Lcom/syu/radio/dao/RadioDao;", "getRadioDao", "()Lcom/syu/radio/dao/RadioDao;", "radioDao$delegate", "removeAllTv", "titleTv", "addClickListener", FinalChip.BSP_PLATFORM_Null, "addObserver", "doSomething", "editChannel", "station", "titleId", "state", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "text2Freq", "freq", "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EditorDialog extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String TAG;
    private static final Lazy<EditorDialog> me$delegate;
    private View addChannelView;

    /* JADX INFO: renamed from: app$delegate, reason: from kotlin metadata */
    private final Lazy app;
    private int editState;
    private RecyclerView editorRecycler;
    private TextView freqTv;
    private String iCity;
    private Job job;
    private final NodeAdapter mAdapter;
    private final List<Station> mChannels;

    /* JADX INFO: renamed from: mainModel$delegate, reason: from kotlin metadata */
    private final Lazy mainModel;
    private TextView nameTv;
    private ImageView nextBtn;
    private RadioStation objectStaion;
    private ImageView prevBtn;

    /* JADX INFO: renamed from: radioController$delegate, reason: from kotlin metadata */
    private final Lazy radioController;

    /* JADX INFO: renamed from: radioDao$delegate, reason: from kotlin metadata */
    private final Lazy radioDao;
    private TextView removeAllTv;
    private TextView titleTv;

    /* JADX INFO: compiled from: EditorDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/syu/media/radio/dialog/EditorDialog$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "TAG", FinalChip.BSP_PLATFORM_Null, "getTAG", "()Ljava/lang/String;", "me", "Lcom/syu/media/radio/dialog/EditorDialog;", "getMe", "()Lcom/syu/media/radio/dialog/EditorDialog;", "me$delegate", "Lkotlin/Lazy;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditorDialog getMe() {
            return (EditorDialog) EditorDialog.me$delegate.getValue();
        }

        public final String getTAG() {
            return EditorDialog.TAG;
        }
    }

    public EditorDialog() {
        super(R.layout.radio_dialog_editor);
        this.mAdapter = new NodeAdapter(false, 1, (DefaultConstructorMarker) null);
        this.mChannels = new ArrayList();
        this.radioController = LazyKt.lazy(new Function0<RadioController>() { // from class: com.syu.media.radio.dialog.EditorDialog$radioController$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioController m233invoke() {
                return AutoManager.INSTANCE.requestInstance().getRadioController();
            }
        });
        this.app = LazyKt.lazy(new Function0<MediaApp>() { // from class: com.syu.media.radio.dialog.EditorDialog$app$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaApp m231invoke() {
                return MediaApp.INSTANCE.getMe();
            }
        });
        this.radioDao = LazyKt.lazy(new Function0<RadioDao>() { // from class: com.syu.media.radio.dialog.EditorDialog$radioDao$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RadioDao m234invoke() {
                return this.this$0.getApp().getRadioDaoModel().getRadioDao();
            }
        });
        this.mainModel = LazyKt.lazy(new Function0<MainModel>() { // from class: com.syu.media.radio.dialog.EditorDialog$mainModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MainModel m232invoke() {
                return this.this$0.getApp().getMainModel();
            }
        });
        this.editState = 1;
        this.objectStaion = new RadioStation();
        this.iCity = Radio.DEF_STR;
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        me$delegate = LazyKt.lazy(new Function0<EditorDialog>() { // from class: com.syu.media.radio.dialog.EditorDialog$Companion$me$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final EditorDialog m230invoke() {
                return new EditorDialog();
            }
        });
        String simpleName = Reflection.getOrCreateKotlinClass(companion.getMe().getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        TAG = simpleName;
    }

    private final RadioController getRadioController() {
        return (RadioController) this.radioController.getValue();
    }

    public final MediaApp getApp() {
        return (MediaApp) this.app.getValue();
    }

    public final RadioDao getRadioDao() {
        return (RadioDao) this.radioDao.getValue();
    }

    public final MainModel getMainModel() {
        return (MainModel) this.mainModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews();
        addClickListener();
        addObserver();
        doSomething();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        setStyle(2, R.style.RadioEditorDialog);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.RadioEditorDialog);
        }
        super.onStart();
    }

    private final void initViews() {
        this.addChannelView = requireView().findViewById(R.id.radio_dialog_editor_add_channel);
        this.editorRecycler = (RecyclerView) requireView().findViewById(R.id.radio_dialog_editor_recycler);
        this.freqTv = (TextView) requireView().findViewById(R.id.radio_dialog_channel_curr_freq);
        this.nameTv = (TextView) requireView().findViewById(R.id.radio_dialog_channel_curr_name);
        this.titleTv = (TextView) requireView().findViewById(R.id.radio_dialog_editor_channel_title);
        this.prevBtn = (ImageView) requireView().findViewById(R.id.radio_dialog_channel_prev_view);
        this.nextBtn = (ImageView) requireView().findViewById(R.id.radio_dialog_channel_next_view);
        this.removeAllTv = (TextView) requireView().findViewById(R.id.radio_dialog_editor_channel_remove);
        RecyclerView recyclerView = this.editorRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
            recyclerView.setAdapter((RecyclerView.Adapter) this.mAdapter);
            recyclerView.addItemDecoration(new SimpleItemDecoration(Integer.valueOf((int) recyclerView.getResources().getDimension(R.dimen.radio_dialog_item_space)), null, null, null, null, 30, null));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    private final void addObserver() {
        getApp().getRadioModel().getMFreq().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditorDialog.m228addObserver$lambda2$lambda1(this.f$0, (Integer) obj);
            }
        });
        getMainModel().getCity().observe(getViewLifecycleOwner(), new Observer() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditorDialog.m229addObserver$lambda3(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-2$lambda-1, reason: not valid java name */
    public static final void m228addObserver$lambda2$lambda1(EditorDialog editorDialog, Integer num) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        HiLog.INSTANCE.d(TAG, "freq:" + num);
        TextView textView = editorDialog.freqTv;
        if (textView == null) {
            return;
        }
        RadioUtils radioUtils = RadioUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(num, "freq");
        textView.setText(radioUtils.freq2Text(num.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addObserver$lambda-3, reason: not valid java name */
    public static final void m229addObserver$lambda3(EditorDialog editorDialog, String str) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        HiLog.INSTANCE.d(RadioStationsFragment.INSTANCE.getTAG(), "mainModel.city.observe:  " + str);
        boolean propForBoolean = Utils.getPropForBoolean("ro.client.foreign", false);
        StringUtils stringUtils = StringUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        boolean zIsChineseByReg = stringUtils.isChineseByReg(str);
        if (propForBoolean && zIsChineseByReg) {
            return;
        }
        editorDialog.iCity = str;
    }

    /* JADX INFO: renamed from: com.syu.media.radio.dialog.EditorDialog$doSomething$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditorDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", FinalChip.BSP_PLATFORM_Null, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.syu.media.radio.dialog.EditorDialog$doSomething$1", f = "EditorDialog.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditorDialog.this.new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = EditorDialog.this.iCity;
                EditorDialog editorDialog = EditorDialog.this;
                List<RadioStation> stationsByCity = editorDialog.getRadioDao().getStationsByCity(str);
                if (stationsByCity != null) {
                    CoroutineContext main = Dispatchers.getMain();
                    EditorDialog$doSomething$1$1$1$1 editorDialog$doSomething$1$1$1$1 = new EditorDialog$doSomething$1$1$1$1(stationsByCity, editorDialog, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, editorDialog$doSomething$1$1$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void doSomething() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        HiLog.INSTANCE.d(TAG, "onDismiss");
    }

    private final void addClickListener() {
        ImageView imageView = this.prevBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m223addClickListener$lambda4(this.f$0, view);
                }
            });
        }
        ImageView imageView2 = this.nextBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m224addClickListener$lambda5(this.f$0, view);
                }
            });
        }
        ImageView imageView3 = (ImageView) requireView().findViewById(R.id.radio_dialog_editor_back);
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m225addClickListener$lambda6(this.f$0, view);
                }
            });
        }
        Button button = (Button) requireView().findViewById(R.id.radio_dialog_editor_remove);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m226addClickListener$lambda7(this.f$0, view);
                }
            });
        }
        Button button2 = (Button) requireView().findViewById(R.id.radio_dialog_editor_add);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m227addClickListener$lambda9(this.f$0, view);
                }
            });
        }
        Button button3 = (Button) requireView().findViewById(R.id.radio_dialog_editor_ok);
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m220addClickListener$lambda10(this.f$0, view);
                }
            });
        }
        ImageView imageView4 = (ImageView) requireView().findViewById(R.id.radio_dialog_editor_add_back);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m221addClickListener$lambda11(this.f$0, view);
                }
            });
        }
        Button button4 = (Button) requireView().findViewById(R.id.radio_dialog_editor_cancel);
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener() { // from class: com.syu.media.radio.dialog.EditorDialog$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditorDialog.m222addClickListener$lambda12(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-4, reason: not valid java name */
    public static final void m223addClickListener$lambda4(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        HiLog.INSTANCE.d(TAG, "prevStation");
        RadioController radioController = editorDialog.getRadioController();
        if (radioController != null) {
            radioController.freqDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-5, reason: not valid java name */
    public static final void m224addClickListener$lambda5(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        HiLog.INSTANCE.d(TAG, "nextStation");
        RadioController radioController = editorDialog.getRadioController();
        if (radioController != null) {
            radioController.freqUp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-6, reason: not valid java name */
    public static final void m225addClickListener$lambda6(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        editorDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-7, reason: not valid java name */
    public static final void m226addClickListener$lambda7(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        editorDialog.editChannel(new RadioStation(), R.string.radio_dialog_editor_remove, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-9, reason: not valid java name */
    public static final void m227addClickListener$lambda9(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        View view2 = editorDialog.addChannelView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        RadioStation radioStation = new RadioStation();
        radioStation.setCity(editorDialog.iCity);
        TextView textView = editorDialog.freqTv;
        radioStation.setFreq(Integer.valueOf(editorDialog.text2Freq(String.valueOf(textView != null ? textView.getText() : null))));
        editChannel$default(editorDialog, radioStation, R.string.radio_dialog_editor_add, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-10, reason: not valid java name */
    public static final void m220addClickListener$lambda10(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        HiLog.INSTANCE.d(TAG, "EditorDialog freq:" + editorDialog.objectStaion);
        View view2 = editorDialog.addChannelView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new EditorDialog$addClickListener$6$1(editorDialog, new Ref.ObjectRef(), null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-11, reason: not valid java name */
    public static final void m221addClickListener$lambda11(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        View view2 = editorDialog.addChannelView;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addClickListener$lambda-12, reason: not valid java name */
    public static final void m222addClickListener$lambda12(EditorDialog editorDialog, View view) {
        Intrinsics.checkNotNullParameter(editorDialog, "this$0");
        View view2 = editorDialog.addChannelView;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public static /* synthetic */ void editChannel$default(EditorDialog editorDialog, RadioStation radioStation, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        editorDialog.editChannel(radioStation, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    public final void editChannel(RadioStation station, int titleId, int state) {
        TextView textView;
        CharSequence text;
        String strValueOf;
        Intrinsics.checkNotNullParameter(station, "station");
        HiLog hiLog = HiLog.INSTANCE;
        String str = TAG;
        hiLog.d(str, "editChannel");
        this.editState = state;
        this.objectStaion = station;
        TextView textView2 = this.nameTv;
        if (textView2 != null) {
            textView2.setText(station.getTitle());
        }
        TextView textView3 = this.titleTv;
        if (textView3 != null) {
            textView3.setText(titleId);
        }
        TextView textView4 = this.freqTv;
        if (textView4 != null) {
            Integer freq = station.getFreq();
            if (freq != null) {
                strValueOf = RadioUtils.INSTANCE.freq2Text(freq.intValue());
                if (strValueOf == null) {
                    textView = this.freqTv;
                    if (textView != null) {
                        text = textView.getText();
                    } else {
                        text = null;
                    }
                    strValueOf = String.valueOf(text);
                }
            } else {
                textView = this.freqTv;
                if (textView != null) {
                    text = textView.getText();
                } else {
                    text = null;
                }
                strValueOf = String.valueOf(text);
            }
            textView4.setText(strValueOf);
        }
        HiLog hiLog2 = HiLog.INSTANCE;
        StringBuilder sb = new StringBuilder("editChannel11:");
        TextView textView5 = this.freqTv;
        hiLog2.d(str, sb.append((Object) (textView5 != null ? textView5.getText() : null)).toString());
        View view = this.addChannelView;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.prevBtn;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        ImageView imageView2 = this.nextBtn;
        if (imageView2 != null) {
            imageView2.setEnabled(true);
        }
        if (state == 1) {
            ImageView imageView3 = this.prevBtn;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.nextBtn;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            TextView textView6 = this.freqTv;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            TextView textView7 = this.nameTv;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
            TextView textView8 = this.removeAllTv;
            if (textView8 == null) {
                return;
            }
            textView8.setVisibility(4);
            return;
        }
        if (state == 2) {
            ImageView imageView5 = this.prevBtn;
            if (imageView5 != null) {
                imageView5.setEnabled(false);
            }
            ImageView imageView6 = this.nextBtn;
            if (imageView6 != null) {
                imageView6.setEnabled(false);
            }
            ImageView imageView7 = this.prevBtn;
            if (imageView7 != null) {
                imageView7.setVisibility(0);
            }
            ImageView imageView8 = this.nextBtn;
            if (imageView8 != null) {
                imageView8.setVisibility(0);
            }
            TextView textView9 = this.freqTv;
            if (textView9 != null) {
                textView9.setVisibility(0);
            }
            TextView textView10 = this.nameTv;
            if (textView10 != null) {
                textView10.setVisibility(0);
            }
            TextView textView11 = this.removeAllTv;
            if (textView11 == null) {
                return;
            }
            textView11.setVisibility(4);
            return;
        }
        if (state == 3) {
            ImageView imageView9 = this.prevBtn;
            if (imageView9 != null) {
                imageView9.setVisibility(4);
            }
            ImageView imageView10 = this.nextBtn;
            if (imageView10 != null) {
                imageView10.setVisibility(4);
            }
            TextView textView12 = this.freqTv;
            if (textView12 != null) {
                textView12.setVisibility(4);
            }
            TextView textView13 = this.nameTv;
            if (textView13 != null) {
                textView13.setVisibility(4);
            }
            TextView textView14 = this.removeAllTv;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
            TextView textView15 = this.removeAllTv;
            if (textView15 != null) {
                textView15.setText(R.string.radio_dialog_editor_remove_text);
                return;
            }
            return;
        }
        if (state != 4) {
            return;
        }
        ImageView imageView11 = this.prevBtn;
        if (imageView11 != null) {
            imageView11.setVisibility(4);
        }
        ImageView imageView12 = this.nextBtn;
        if (imageView12 != null) {
            imageView12.setVisibility(4);
        }
        TextView textView16 = this.freqTv;
        if (textView16 != null) {
            textView16.setVisibility(4);
        }
        TextView textView17 = this.nameTv;
        if (textView17 != null) {
            textView17.setVisibility(4);
        }
        TextView textView18 = this.removeAllTv;
        if (textView18 != null) {
            textView18.setVisibility(0);
        }
        TextView textView19 = this.removeAllTv;
        if (textView19 != null) {
            textView19.setText(R.string.radio_dialog_editor_remove_all);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int text2Freq(String freq) {
        if (freq.length() > 0) {
            return Integer.parseInt(StringsKt.replace$default(freq, ".", FinalChip.BSP_PLATFORM_Null, false, 4, (Object) null));
        }
        return -1;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (isAdded()) {
            return;
        }
        show(manager, FinalChip.BSP_PLATFORM_Null);
    }
}
