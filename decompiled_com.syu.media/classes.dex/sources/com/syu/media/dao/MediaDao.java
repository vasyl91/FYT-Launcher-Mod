package com.syu.media.dao;

import chip.FinalChip;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.PlayList;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.entities.PlayListWithRadios;
import com.syu.media.entities.PlaylistAudioCrossRef;
import com.syu.media.entities.PlaylistRadioCrossRef;
import com.syu.media.entities.PlaylistVideoCrossRef;
import com.syu.media.entities.RadioSource;
import com.syu.media.entities.VideoSource;
import com.syu.media.provider.Media;
import com.syu.radio.Radio;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H'¢\u0006\u0004\b\t\u0010\u0007J#\u0010\n\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H'¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H'J\u0016\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0018\u00010\u0012H'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0014\u001a\u00020\u000bH'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0016\u001a\u00020\u000bH'J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH'J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH'J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H'J\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0018\u00010\u0012J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H'J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010\f\u001a\u00020\u000bH'J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010\f\u001a\u00020\u000bH'J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u001c\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010\f\u001a\u00020\u000bH'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010'\u001a\u00020\u000bH'J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010+\u001a\u00020\u000bH'J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH'J\u0014\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u0012H'J\u001c\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u00101\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H'J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH'J\u001c\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010+\u001a\u00020\u000bH'J\u001c\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010'\u001a\u00020\u000bH'J\u001c\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0016\u001a\u00020\u000bH'J\u001c\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0016\u001a\u00020\u000bH'J$\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH'J$\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH'J\u001c\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010+\u001a\u00020\u000bH'J\u001c\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010'\u001a\u00020\u000bH'J\u001c\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u00122\u0006\u0010\u0016\u001a\u00020\u000bH'J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0\u0002\"\u00020<H'¢\u0006\u0004\b\u0006\u0010>J#\u0010\t\u001a\u00020\u00052\u0012\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020<0\u0002\"\u00020<H'¢\u0006\u0004\b\t\u0010>J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010=\u001a\u00020<H'J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00122\u0006\u0010?\u001a\u00020\u000bH'J\u0018\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0\u00122\u0006\u0010B\u001a\u00020\u000eH'J\u0018\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u00122\u0006\u0010B\u001a\u00020\u000eH'J\u0012\u0010F\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020\u000eH'J\u0012\u0010G\u001a\u0004\u0018\u00010D2\u0006\u0010B\u001a\u00020\u000eH'J\u0014\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00100\u0012H'J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020I0\u0002\"\u00020IH'¢\u0006\u0004\b\u0006\u0010KJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020L0\u0002\"\u00020LH'¢\u0006\u0004\b\u0006\u0010MJ\u0012\u0010N\u001a\u0004\u0018\u00010<2\u0006\u0010B\u001a\u00020\u000eH'J\u0010\u0010O\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000bH'J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020P0\u0002\"\u00020PH'¢\u0006\u0004\b\u0006\u0010QJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010R\u001a\u00020PH'J#\u0010\t\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020P0\u0002\"\u00020PH'¢\u0006\u0004\b\t\u0010QJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH'J\u0012\u0010T\u001a\u0004\u0018\u00010P2\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010U\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH'J\u0010\u0010V\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010\u0010H'J\u0016\u0010W\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u0010\u0018\u00010\u0012H'J\u0014\u0010X\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u0010\u0018\u00010\u0012J\u0014\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u001c\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u00100\u00122\u0006\u0010\u0014\u001a\u00020\u000bH'J\u001c\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010\f\u001a\u00020\u000bH'J\u001e\u0010\\\u001a\b\u0012\u0004\u0012\u00020P0\u00102\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH'J\u0016\u0010]\u001a\b\u0012\u0004\u0012\u00020P0\u00102\u0006\u0010\u0016\u001a\u00020\u000bH'J\u0014\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u0014\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0\u00100\u0012H'J\u0010\u0010`\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH'J\u0014\u0010b\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030aJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020c0\u0002\"\u00020cH'¢\u0006\u0004\b\u0006\u0010dJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010R\u001a\u00020cH'J#\u0010\t\u001a\u00020\u00052\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020c0\u0002\"\u00020cH'¢\u0006\u0004\b\t\u0010dJ\u0010\u0010e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH'J\u0016\u0010f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u0010\u0018\u00010\u0012H'J\u0014\u0010g\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u0010\u0018\u00010\u0012J\u0012\u0010h\u001a\u0004\u0018\u00010c2\u0006\u0010\f\u001a\u00020\u000bH'J\u0014\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u0012H'J\u001c\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u00122\u0006\u0010j\u001a\u00020\u000bH'J\u0016\u0010l\u001a\b\u0012\u0004\u0012\u00020c0\u00102\u0006\u0010j\u001a\u00020\u000bH'J$\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u00122\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH'J\u001e\u0010o\u001a\b\u0012\u0004\u0012\u00020c0\u00102\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH'J\u001c\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u00122\u0006\u0010m\u001a\u00020\u000bH'J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020c0\u00102\u0006\u0010m\u001a\u00020\u000bH'J\u001c\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u00122\u0006\u0010r\u001a\u00020\u000bH'J\u0016\u0010t\u001a\b\u0012\u0004\u0012\u00020c0\u00102\u0006\u0010r\u001a\u00020\u000bH'J$\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00100\u00122\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH'J\u001e\u0010v\u001a\b\u0012\u0004\u0012\u00020c0\u00102\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH'J\u0014\u0010w\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H'J\u001c\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010j\u001a\u00020\u000bH'J\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010j\u001a\u00020\u000bH'J\u001c\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010r\u001a\u00020\u000bH'J\u0016\u0010|\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010r\u001a\u00020\u000bH'J\u0014\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H'J\u001c\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u00122\u0006\u0010j\u001a\u00020\u000bH'J\u0017\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010j\u001a\u00020\u000bH'J\u0015\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u0012H'J\u000f\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H'J\u0015\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00100\u0012H'J&\u0010\u0006\u001a\u00020\u00052\u0014\u0010J\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u0084\u00010\u0002\"\u00030\u0084\u0001H'¢\u0006\u0005\b\u0006\u0010\u0085\u0001J\u0015\u0010\u0086\u0001\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020c0a¨\u0006\u0089\u0001"}, d2 = {"Lcom/syu/media/dao/MediaDao;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;", "audioSource", FinalChip.BSP_PLATFORM_Null, "insert", "([Lcom/syu/media/entities/AudioSource;)V", "sources", "delete", "update", FinalChip.BSP_PLATFORM_Null, Media.PATH, "getExistsAudioSource", FinalChip.BSP_PLATFORM_Null, "getAudioSourceId", FinalChip.BSP_PLATFORM_Null, "historicalAudio", "Lkotlinx/coroutines/flow/Flow;", "getAllAudioSources", "filter", "getAudioSourcesFlowWithFilter", Media.FOLDER, "getAudioSourcesWithFolder", "parent", "getAudioSourcesWithFolderAndParent", "getAudioSourcesWithFolderAndFavorite", "listOfAllAudio", "allAudioSources", "getFoldersFlow", "getFolders", "getFoldersWithFavorite", "getFoldersByPath", "getArtists", "getArtistsWithFavorite", "getArtistsByPath", "getAlbums", "getAlbumsWithFavorite", "getAlbumsByPath", Media.ARTIST, "getAudioSourcesOfArtist", "getAudioSourcesByArtistAndPath", "getAudioSourcesByArtistAndPathAndFavorite", Media.ALBUM, "getAudioSourcesOfAlbum", "getAudioSourcesByAlbumAndPath", "getAudioSourcesByAlbumAndPathAndFavorite", "getFavorites", "getFavoritesByPath", "listOfFavorite", "deleteAudioSource", "audiosByAlum", "audiosByArtist", "audiosByFolder", "audiosByRootFolder", "audiosByRootFolderAndArtist", "audiosByRootFolderAndAlbum", "favoritesByAlbum", "favoritesByArtist", "favoritesByFolder", "Lcom/syu/media/entities/PlayList;", Media.LIST_TABLE, "([Lcom/syu/media/entities/PlayList;)V", "name", "Lcom/syu/media/entities/PlayListWithAudios;", "getPlayListByName", "id", "getPlayListById", "Lcom/syu/media/entities/PlayListWithRadios;", "getOnlinePlayListById", "playListById", "onlinePlayListById", "getPlayListWithAudios", "Lcom/syu/media/entities/PlaylistAudioCrossRef;", "ref", "([Lcom/syu/media/entities/PlaylistAudioCrossRef;)V", "Lcom/syu/media/entities/PlaylistVideoCrossRef;", "([Lcom/syu/media/entities/PlaylistVideoCrossRef;)V", "getExistsPlaylist", "getPlayListId", "Lcom/syu/media/entities/VideoSource;", "([Lcom/syu/media/entities/VideoSource;)V", "source", "deleteVideoSource", "getExistsVideoSource", "getVideoSource", "historicalVideo", "getAllVideos", "allVideos", "getFoldersOfVideo", "getVideosByPath", "getFoldersOfVideoWithFolder", "getVideosWithFolderAndParent", "getVideosWithFolder", "getFoldersOfVideoWithFavorite", "getVideoFavorites", "getVideoSourceId", FinalChip.BSP_PLATFORM_Null, "updateAudioPlayList", "Lcom/syu/media/entities/RadioSource;", "([Lcom/syu/media/entities/RadioSource;)V", "deleteRadioSource", "getAllRadios", "allRadios", "getExistsRadioSource", "getRadioFavorites", Media.COUNTRY, "getRadiosByCountryFlow", "getRadiosByCountry", Media.TYPE, "getRadiosByCountryAndTypeFlow", "getRadiosByCountryAndType", "getRadiosByTypeFlow", "getRadiosByType", Media.LOCAL, "getRadiosByLocalFlow", "getRadiosByLocal", "getRadiosByLocalAndTypeFlow", "getRadiosByLocalAndType", "typesFlow", "types", "typesByCountryFlow", "typesByCountry", "typesByLocalFlow", "typesByLocal", "localsFlow", "locals", "localsByCountryFlow", "localsByCountry", "countriesFlow", "countries", "getPlayListWithRadios", "Lcom/syu/media/entities/PlaylistRadioCrossRef;", "([Lcom/syu/media/entities/PlaylistRadioCrossRef;)V", "updateRadioPlayList", "<init>", "()V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public abstract class MediaDao {

    /* JADX INFO: renamed from: com.syu.media.dao.MediaDao$updateAudioPlayList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.media.dao.MediaDao$updateAudioPlayList$1", f = "MediaDao.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, Continuation continuation) {
            super(2, continuation);
            this.b = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaDao.this.new AnonymousClass1(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            MediaDao.access$insertPlayList(MediaDao.this, new PlayList(0, null, false, new Date(Calendar.getInstance(TimeZone.getDefault()).getTimeInMillis()), 0, 3, null), this.b);
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.syu.media.dao.MediaDao$updateRadioPlayList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", FinalChip.BSP_PLATFORM_Null, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.syu.media.dao.MediaDao$updateRadioPlayList$1", f = "MediaDao.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00491(List list, Continuation continuation) {
            super(2, continuation);
            this.b = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MediaDao.this.new C00491(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            MediaDao.access$insertRadioList(MediaDao.this, new PlayList(8, Radio.ONLINE, false, new Date(Calendar.getInstance(TimeZone.getDefault()).getTimeInMillis()), 0), this.b);
            return Unit.INSTANCE;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final void access$insertPlayList(MediaDao mediaDao, PlayList playList, List list) {
        mediaDao.getClass();
        mediaDao.insert(playList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioSource audioSource = (AudioSource) it.next();
            try {
                if (mediaDao.getAudioSourceId(audioSource.getCom.syu.media.provider.Media.PATH java.lang.String()) >= 0) {
                    int playListId = mediaDao.getPlayListId(playList.getTitle());
                    Integer id = audioSource.getId();
                    Intrinsics.checkNotNull(id);
                    mediaDao.insert(new PlaylistAudioCrossRef(playListId, id.intValue()));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final void access$insertRadioList(MediaDao mediaDao, PlayList playList, List list) {
        mediaDao.getClass();
        mediaDao.insert(playList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                RadioSource existsRadioSource = mediaDao.getExistsRadioSource(((RadioSource) it.next()).getCom.syu.media.provider.Media.PATH java.lang.String());
                if (existsRadioSource != null) {
                    int playListId = mediaDao.getPlayListId(playList.getTitle());
                    Integer id = existsRadioSource.getId();
                    Intrinsics.checkNotNull(id);
                    mediaDao.insert(new PlaylistRadioCrossRef(playListId, id.intValue()));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final Flow<List<AudioSource>> allAudioSources() {
        Flow<List<AudioSource>> allAudioSources = getAllAudioSources();
        if (allAudioSources != null) {
            return FlowKt.distinctUntilChanged(allAudioSources);
        }
        return null;
    }

    public final Flow<List<RadioSource>> allRadios() {
        Flow<List<RadioSource>> allRadios = getAllRadios();
        if (allRadios != null) {
            return FlowKt.distinctUntilChanged(allRadios);
        }
        return null;
    }

    public final Flow<List<VideoSource>> allVideos() {
        Flow<List<VideoSource>> allVideos = getAllVideos();
        if (allVideos != null) {
            return FlowKt.distinctUntilChanged(allVideos);
        }
        return null;
    }

    public abstract Flow<List<AudioSource>> audiosByAlum(String album);

    public abstract Flow<List<AudioSource>> audiosByArtist(String artist);

    public abstract Flow<List<AudioSource>> audiosByFolder(String folder);

    public abstract Flow<List<AudioSource>> audiosByRootFolder(String folder);

    public abstract Flow<List<AudioSource>> audiosByRootFolderAndAlbum(String folder, String album);

    public abstract Flow<List<AudioSource>> audiosByRootFolderAndArtist(String folder, String artist);

    public abstract List<String> countries();

    public abstract Flow<List<String>> countriesFlow();

    public abstract void delete(AudioSource... sources);

    public abstract void delete(PlayList... list);

    public abstract void delete(RadioSource... sources);

    public abstract void delete(VideoSource... sources);

    public abstract void deleteAudioSource(String path);

    public abstract void deleteRadioSource(String path);

    public abstract void deleteVideoSource(String path);

    public abstract Flow<List<AudioSource>> favoritesByAlbum(String album);

    public abstract Flow<List<AudioSource>> favoritesByArtist(String artist);

    public abstract Flow<List<AudioSource>> favoritesByFolder(String folder);

    public abstract Flow<List<String>> getAlbums();

    public abstract Flow<List<String>> getAlbumsByPath(String path);

    public abstract Flow<List<String>> getAlbumsWithFavorite();

    public abstract Flow<List<AudioSource>> getAllAudioSources();

    public abstract Flow<List<RadioSource>> getAllRadios();

    public abstract Flow<List<VideoSource>> getAllVideos();

    public abstract Flow<List<String>> getArtists();

    public abstract Flow<List<String>> getArtistsByPath(String path);

    public abstract Flow<List<String>> getArtistsWithFavorite();

    public abstract int getAudioSourceId(String path);

    public abstract List<AudioSource> getAudioSourcesByAlbumAndPath(String album, String path);

    public abstract List<AudioSource> getAudioSourcesByAlbumAndPathAndFavorite(String album, String path);

    public abstract List<AudioSource> getAudioSourcesByArtistAndPath(String artist, String path);

    public abstract List<AudioSource> getAudioSourcesByArtistAndPathAndFavorite(String artist, String path);

    public abstract Flow<List<AudioSource>> getAudioSourcesFlowWithFilter(String filter);

    public abstract List<AudioSource> getAudioSourcesOfAlbum(String album);

    public abstract List<AudioSource> getAudioSourcesOfArtist(String artist);

    public abstract List<AudioSource> getAudioSourcesWithFolder(String folder);

    public abstract List<AudioSource> getAudioSourcesWithFolderAndFavorite(String folder, String parent);

    public abstract List<AudioSource> getAudioSourcesWithFolderAndParent(String folder, String parent);

    public abstract AudioSource getExistsAudioSource(String path);

    public abstract PlayList getExistsPlaylist(int id);

    public abstract RadioSource getExistsRadioSource(String path);

    public abstract VideoSource getExistsVideoSource(String path);

    public abstract Flow<List<AudioSource>> getFavorites();

    public abstract Flow<List<AudioSource>> getFavoritesByPath(String path);

    public abstract List<String> getFolders();

    public abstract Flow<List<String>> getFoldersByPath(String path);

    public abstract Flow<List<String>> getFoldersFlow();

    public abstract Flow<List<String>> getFoldersOfVideo();

    public abstract Flow<List<String>> getFoldersOfVideoWithFavorite();

    public abstract Flow<List<String>> getFoldersOfVideoWithFolder(String path);

    public abstract Flow<List<String>> getFoldersWithFavorite();

    public abstract Flow<PlayListWithRadios> getOnlinePlayListById(int id);

    public abstract Flow<PlayListWithAudios> getPlayListById(int id);

    public abstract Flow<PlayListWithAudios> getPlayListByName(String name);

    public abstract int getPlayListId(String name);

    public abstract Flow<List<PlayListWithAudios>> getPlayListWithAudios();

    public abstract Flow<List<PlayListWithRadios>> getPlayListWithRadios();

    public abstract Flow<List<RadioSource>> getRadioFavorites();

    public abstract List<RadioSource> getRadiosByCountry(String country);

    public abstract List<RadioSource> getRadiosByCountryAndType(String country, String type);

    public abstract Flow<List<RadioSource>> getRadiosByCountryAndTypeFlow(String country, String type);

    public abstract Flow<List<RadioSource>> getRadiosByCountryFlow(String country);

    public abstract List<RadioSource> getRadiosByLocal(String local);

    public abstract List<RadioSource> getRadiosByLocalAndType(String local, String type);

    public abstract Flow<List<RadioSource>> getRadiosByLocalAndTypeFlow(String local, String type);

    public abstract Flow<List<RadioSource>> getRadiosByLocalFlow(String local);

    public abstract List<RadioSource> getRadiosByType(String type);

    public abstract Flow<List<RadioSource>> getRadiosByTypeFlow(String type);

    public abstract Flow<List<VideoSource>> getVideoFavorites();

    public abstract int getVideoSource(String path);

    public abstract int getVideoSourceId(String path);

    public abstract Flow<List<VideoSource>> getVideosByPath(String filter);

    public abstract List<VideoSource> getVideosWithFolder(String folder);

    public abstract List<VideoSource> getVideosWithFolderAndParent(String folder, String parent);

    public abstract List<AudioSource> historicalAudio();

    public abstract List<VideoSource> historicalVideo();

    public abstract void insert(AudioSource... audioSource);

    public abstract void insert(PlayList... list);

    public abstract void insert(PlaylistAudioCrossRef... ref);

    public abstract void insert(PlaylistRadioCrossRef... ref);

    public abstract void insert(PlaylistVideoCrossRef... ref);

    public abstract void insert(RadioSource... sources);

    public abstract void insert(VideoSource... sources);

    public abstract List<AudioSource> listOfAllAudio();

    public abstract List<AudioSource> listOfFavorite();

    public abstract List<String> locals();

    public abstract List<String> localsByCountry(String country);

    public abstract Flow<List<String>> localsByCountryFlow(String country);

    public abstract Flow<List<String>> localsFlow();

    public abstract PlayListWithRadios onlinePlayListById(int id);

    public abstract PlayListWithAudios playListById(int id);

    public abstract List<String> types();

    public abstract List<String> typesByCountry(String country);

    public abstract Flow<List<String>> typesByCountryFlow(String country);

    public abstract List<String> typesByLocal(String local);

    public abstract Flow<List<String>> typesByLocalFlow(String local);

    public abstract Flow<List<String>> typesFlow();

    public abstract void update(PlayList list);

    public abstract void update(RadioSource source);

    public abstract void update(VideoSource source);

    public abstract void update(AudioSource... sources);

    public final void updateAudioPlayList(List<AudioSource> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(sources, null), 3, (Object) null);
    }

    public final void updateRadioPlayList(List<RadioSource> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00491(sources, null), 3, (Object) null);
    }
}
