package com.syu.manger;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import chip.FinalChip;
import com.syu.manger.module.record.RecordModel;
import com.syu.manger.module.record.RecordObserver;
import com.syu.manger.module.vehicle.VehicleModel;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qin.x_core.client.java.XCore;
import qin.x_core.client.java.XCoreRemote;
import syu.base.BaseApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001:\u0002ijB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\bg\u0010hJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010,\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\"\u0010E\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010,\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R\"\u0010I\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010M\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010$\u001a\u0004\bK\u0010&\"\u0004\bL\u0010(R\"\u0010Q\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010$\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R\"\u0010U\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010$\u001a\u0004\bS\u0010&\"\u0004\bT\u0010(R2\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\"0Vj\b\u0012\u0004\u0012\u00020\"`W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R2\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\"0Vj\b\u0012\u0004\u0012\u00020\"`W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010Y\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R\"\u0010f\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010$\u001a\u0004\bd\u0010&\"\u0004\be\u0010(¨\u0006k"}, d2 = {"Lcom/syu/manger/TripManager;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/manger/TripManager$OnTripListener;", "listener", FinalChip.BSP_PLATFORM_Null, "addOnTripListener", "removeOnTripListener", "Lsyu/base/BaseApp;", "a", "Lsyu/base/BaseApp;", "getMApp", "()Lsyu/base/BaseApp;", "mApp", "Lqin/x_core/client/java/XCore;", "c", "Lkotlin/Lazy;", "getXCore", "()Lqin/x_core/client/java/XCore;", "xCore", "Lcom/syu/manger/module/record/RecordModel;", "d", "getMRecordModel", "()Lcom/syu/manger/module/record/RecordModel;", "mRecordModel", "Lcom/syu/manger/module/vehicle/VehicleModel;", "e", "getVehicleModel", "()Lcom/syu/manger/module/vehicle/VehicleModel;", "vehicleModel", "Lcom/syu/manger/module/record/RecordObserver;", "f", "getMRecordObserver", "()Lcom/syu/manger/module/record/RecordObserver;", "mRecordObserver", FinalChip.BSP_PLATFORM_Null, "g", "I", "getMAltitude", "()I", "setMAltitude", "(I)V", "mAltitude", FinalChip.BSP_PLATFORM_Null, "h", "F", "getMileage", "()F", "setMileage", "(F)V", "mileage", "i", "getMBearing", "setMBearing", "mBearing", FinalChip.BSP_PLATFORM_Null, "j", "J", "getMDrivingTime", "()J", "setMDrivingTime", "(J)V", "mDrivingTime", "k", "getMSlope", "setMSlope", "mSlope", "l", "getTotalMileage", "setTotalMileage", "totalMileage", "m", "getTotalDrivingTime", "setTotalDrivingTime", "totalDrivingTime", "n", "getAverageSpeed", "setAverageSpeed", "averageSpeed", "o", "getSpeed", "setSpeed", "speed", "p", "getMaxSpeed", "setMaxSpeed", "maxSpeed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "q", "Ljava/util/ArrayList;", "getMSpeedList", "()Ljava/util/ArrayList;", "setMSpeedList", "(Ljava/util/ArrayList;)V", "mSpeedList", "r", "getMAltitudeList", "setMAltitudeList", "mAltitudeList", "s", "getMUnit", "setMUnit", "mUnit", "<init>", "(Lsyu/base/BaseApp;)V", "OnTripListener", "SimpleTripListener", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class TripManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final BaseApp mApp;
    public final ArrayList b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy xCore;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Lazy mRecordModel;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy vehicleModel;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Lazy mRecordObserver;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public int mAltitude;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public float mileage;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public int mBearing;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public long mDrivingTime;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public float mSlope;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public float totalMileage;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public long totalDrivingTime;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int averageSpeed;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int speed;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int maxSpeed;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public ArrayList mSpeedList;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public ArrayList mAltitudeList;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public int mUnit;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J \u0010\u001c\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\tH&¨\u0006!"}, d2 = {"Lcom/syu/manger/TripManager$OnTripListener;", FinalChip.BSP_PLATFORM_Null, "onAltitudeChanged", FinalChip.BSP_PLATFORM_Null, "altitude", FinalChip.BSP_PLATFORM_Null, "onAltitudeListChanged", Media.LIST_TABLE, "Ljava/util/ArrayList;", FinalChip.BSP_PLATFORM_Null, "Lkotlin/collections/ArrayList;", "onAverageSpeedChanged", "float", "onBearingChanged", "bearing", "onDurationChanged", Media.DURATION, FinalChip.BSP_PLATFORM_Null, "onLocationChanged", "latitude", "longitude", "onMaxSpeedChanged", "onMileageChanged", "mileage", FinalChip.BSP_PLATFORM_Null, "onSlopeChanged", "slope", "onSpeedChanged", "onSpeedListChanged", "onTotalDurationChanged", "onTotalMileageChanged", "onUnitChanged", "unit", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnTripListener {
        void onAltitudeChanged(double altitude);

        void onAltitudeListChanged(ArrayList<Integer> list);

        void onAverageSpeedChanged(int i);

        void onBearingChanged(int bearing);

        void onDurationChanged(long duration);

        void onLocationChanged(double latitude, double longitude);

        void onMaxSpeedChanged(int i);

        void onMileageChanged(float mileage);

        void onSlopeChanged(float slope);

        void onSpeedChanged(int i);

        void onSpeedListChanged(ArrayList<Integer> list);

        void onTotalDurationChanged(long duration);

        void onTotalMileageChanged(float mileage);

        void onUnitChanged(int unit);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0016J \u0010\u001e\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\nH\u0016¨\u0006#"}, d2 = {"Lcom/syu/manger/TripManager$SimpleTripListener;", "Lcom/syu/manger/TripManager$OnTripListener;", "()V", "onAltitudeChanged", FinalChip.BSP_PLATFORM_Null, "altitude", FinalChip.BSP_PLATFORM_Null, "onAltitudeListChanged", Media.LIST_TABLE, "Ljava/util/ArrayList;", FinalChip.BSP_PLATFORM_Null, "Lkotlin/collections/ArrayList;", "onAverageSpeedChanged", "speed", "onBearingChanged", "bearing", "onDurationChanged", Media.DURATION, FinalChip.BSP_PLATFORM_Null, "onLocationChanged", "latitude", "longitude", "onMaxSpeedChanged", "float", "onMileageChanged", "mileage", FinalChip.BSP_PLATFORM_Null, "onSlopeChanged", "slope", "onSpeedChanged", "onSpeedListChanged", "onTotalDurationChanged", "onTotalMileageChanged", "onUnitChanged", "unit", "AutoManger_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class SimpleTripListener implements OnTripListener {
        @Override // com.syu.manger.TripManager.OnTripListener
        public void onAltitudeChanged(double altitude) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onAltitudeListChanged(ArrayList<Integer> list) {
            Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onAverageSpeedChanged(int speed) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onBearingChanged(int bearing) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onDurationChanged(long duration) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onLocationChanged(double latitude, double longitude) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onMaxSpeedChanged(int i) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onMileageChanged(float mileage) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onSlopeChanged(float slope) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onSpeedChanged(int speed) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onSpeedListChanged(ArrayList<Integer> list) {
            Intrinsics.checkNotNullParameter(list, Media.LIST_TABLE);
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onTotalDurationChanged(long duration) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onTotalMileageChanged(float mileage) {
        }

        @Override // com.syu.manger.TripManager.OnTripListener
        public void onUnitChanged(int unit) {
        }
    }

    public TripManager(BaseApp baseApp) {
        Intrinsics.checkNotNullParameter(baseApp, "mApp");
        this.mApp = baseApp;
        this.b = new ArrayList();
        this.xCore = LazyKt.lazy(new Function0<XCore>() { // from class: com.syu.manger.TripManager$xCore$2
            {
                super(0);
            }

            public final XCore invoke() {
                return new XCore(this.a.getMApp(), RecordObserver.ServicePkg, RecordObserver.ServiceAction, "appId", new XCoreRemote.OnInitListener() { // from class: com.syu.manger.TripManager$xCore$2.1
                    public void onConnected(String p0, Boolean p1) {
                    }

                    public void onLicensed(String p0, Boolean p1) {
                    }
                });
            }
        });
        this.mRecordModel = LazyKt.lazy(new Function0<RecordModel>() { // from class: com.syu.manger.TripManager$mRecordModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecordModel m66invoke() {
                ViewModel viewModel = BaseApp.getViewModelProvider$default(this.a.getMApp(), (ViewModelProvider.Factory) null, 1, (Object) null).get(RecordModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider().get(VM::class.java)");
                return (RecordModel) viewModel;
            }
        });
        this.vehicleModel = LazyKt.lazy(new Function0<VehicleModel>() { // from class: com.syu.manger.TripManager$vehicleModel$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final VehicleModel m68invoke() {
                ViewModel viewModel = BaseApp.getViewModelProvider$default(this.a.getMApp(), (ViewModelProvider.Factory) null, 1, (Object) null).get(VehicleModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModelProvider().get(VM::class.java)");
                return (VehicleModel) viewModel;
            }
        });
        this.mRecordObserver = LazyKt.lazy(new Function0<RecordObserver>() { // from class: com.syu.manger.TripManager$mRecordObserver$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final RecordObserver m67invoke() {
                return new RecordObserver(this.a.getMRecordModel());
            }
        });
        this.mSpeedList = CollectionsKt.arrayListOf(new Integer[]{0, 0});
        this.mAltitudeList = CollectionsKt.arrayListOf(new Integer[]{0, 0});
        getXCore().observeModule(0, new int[]{40, 0, 2, 3, 4, 7, 10, 11, 25, 26, 15, 16});
        getXCore().addObserver(getMRecordObserver());
        a();
    }

    public static final void b(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void c(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void d(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void e(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void f(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void g(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void h(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void i(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void j(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void k(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void l(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void m(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void a() {
        MutableLiveData<Integer> mBearing = getVehicleModel().getMBearing();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.syu.manger.TripManager$setup$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(num, "bearing");
                tripManager.setMBearing(num.intValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onBearingChanged(tripManager2.getMBearing());
                }
            }
        };
        mBearing.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.a(function1, obj);
            }
        });
        MutableLiveData<Integer> mUnit = getMRecordModel().getMUnit();
        final Function1<Integer, Unit> function2 = new Function1<Integer, Unit>() { // from class: com.syu.manger.TripManager$setup$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(num, "unit");
                tripManager.setMUnit(num.intValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onUnitChanged(tripManager2.getMUnit());
                }
            }
        };
        mUnit.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.b(function2, obj);
            }
        });
        MutableLiveData<Integer> mSpeed = getMRecordModel().getMSpeed();
        final Function1<Integer, Unit> function3 = new Function1<Integer, Unit>() { // from class: com.syu.manger.TripManager$setup$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(num, "value");
                tripManager.setSpeed(num.intValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onSpeedChanged(tripManager2.getSpeed());
                }
            }
        };
        mSpeed.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.f(function3, obj);
            }
        });
        MutableLiveData<Integer> mMaxSpeed = getMRecordModel().getMMaxSpeed();
        final Function1<Integer, Unit> function4 = new Function1<Integer, Unit>() { // from class: com.syu.manger.TripManager$setup$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(num, "value");
                tripManager.setMaxSpeed(num.intValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onMaxSpeedChanged(tripManager2.getMaxSpeed());
                }
            }
        };
        mMaxSpeed.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.g(function4, obj);
            }
        });
        MutableLiveData<Float> mAltitude = getMRecordModel().getMAltitude();
        final Function1<Float, Unit> function5 = new Function1<Float, Unit>() { // from class: com.syu.manger.TripManager$setup$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Float) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Float f) {
                this.a.setMAltitude((int) f.floatValue());
                List list = this.a.b;
                TripManager tripManager = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onAltitudeChanged(tripManager.getMAltitude());
                }
            }
        };
        mAltitude.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.h(function5, obj);
            }
        });
        MutableLiveData<Float> mSlope = getMRecordModel().getMSlope();
        final Function1<Float, Unit> function6 = new Function1<Float, Unit>() { // from class: com.syu.manger.TripManager$setup$6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Float) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Float f) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(f, "it");
                tripManager.setMSlope(f.floatValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onSlopeChanged(tripManager2.getMSlope());
                }
            }
        };
        mSlope.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda11
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.i(function6, obj);
            }
        });
        MutableLiveData<Float> mDrivingMileage = getMRecordModel().getMDrivingMileage();
        final Function1<Float, Unit> function7 = new Function1<Float, Unit>() { // from class: com.syu.manger.TripManager$setup$7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Float) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Float f) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(f, "it");
                tripManager.setMileage(f.floatValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onMileageChanged(tripManager2.getMileage());
                }
            }
        };
        mDrivingMileage.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda12
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.j(function7, obj);
            }
        });
        MutableLiveData<Float> mTotalMileage = getMRecordModel().getMTotalMileage();
        final Function1<Float, Unit> function8 = new Function1<Float, Unit>() { // from class: com.syu.manger.TripManager$setup$8
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Float) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Float f) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(f, "it");
                tripManager.setTotalMileage(f.floatValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onTotalMileageChanged(tripManager2.getTotalMileage());
                }
            }
        };
        mTotalMileage.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.k(function8, obj);
            }
        });
        MutableLiveData<Long> mDrivingTime = getMRecordModel().getMDrivingTime();
        final Function1<Long, Unit> function9 = new Function1<Long, Unit>() { // from class: com.syu.manger.TripManager$setup$9
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                this.a.setMDrivingTime(l.longValue() * ((long) 1000));
                List list = this.a.b;
                TripManager tripManager = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onDurationChanged(tripManager.getMDrivingTime());
                }
            }
        };
        mDrivingTime.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.l(function9, obj);
            }
        });
        MutableLiveData<Long> mTotalDrivingTime = getMRecordModel().getMTotalDrivingTime();
        final Function1<Long, Unit> function10 = new Function1<Long, Unit>() { // from class: com.syu.manger.TripManager$setup$10
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                this.a.setTotalDrivingTime(l.longValue() * ((long) 1000));
                List list = this.a.b;
                TripManager tripManager = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onTotalDurationChanged(tripManager.getTotalDrivingTime());
                }
            }
        };
        mTotalDrivingTime.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.m(function10, obj);
            }
        });
        MutableLiveData<ArrayList<Integer>> mSpeedList = getMRecordModel().getMSpeedList();
        final Function1<ArrayList<Integer>, Unit> function11 = new Function1<ArrayList<Integer>, Unit>() { // from class: com.syu.manger.TripManager$setup$11
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ArrayList<Integer>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ArrayList<Integer> arrayList) {
                this.a.setMSpeedList(arrayList.size() > 0 ? new ArrayList<>(arrayList) : CollectionsKt.arrayListOf(new Integer[]{0, 0}));
                List list = this.a.b;
                TripManager tripManager = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onSpeedListChanged(new ArrayList<>(tripManager.getMSpeedList()));
                }
            }
        };
        mSpeedList.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.c(function11, obj);
            }
        });
        MutableLiveData<ArrayList<Integer>> mAltitudeList = getMRecordModel().getMAltitudeList();
        final Function1<ArrayList<Integer>, Unit> function12 = new Function1<ArrayList<Integer>, Unit>() { // from class: com.syu.manger.TripManager$setup$12
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ArrayList<Integer>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ArrayList<Integer> arrayList) {
                this.a.setMAltitudeList(arrayList.size() > 0 ? new ArrayList<>(arrayList) : CollectionsKt.arrayListOf(new Integer[]{0, 0}));
                List list = this.a.b;
                TripManager tripManager = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onAltitudeListChanged(new ArrayList<>(tripManager.getMAltitudeList()));
                }
            }
        };
        mAltitudeList.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.d(function12, obj);
            }
        });
        MutableLiveData<Integer> mAverageSpeed = getMRecordModel().getMAverageSpeed();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.syu.manger.TripManager$setup$13
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                TripManager tripManager = this.a;
                Intrinsics.checkNotNullExpressionValue(num, "it");
                tripManager.setAverageSpeed(num.intValue());
                List list = this.a.b;
                TripManager tripManager2 = this.a;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((TripManager.OnTripListener) it.next()).onAverageSpeedChanged(tripManager2.getAverageSpeed());
                }
            }
        };
        mAverageSpeed.observeForever(new Observer() { // from class: com.syu.manger.TripManager$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TripManager.e(function13, obj);
            }
        });
    }

    public final void addOnTripListener(OnTripListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.b.contains(listener)) {
            return;
        }
        this.b.add(listener);
        listener.onMileageChanged(this.mileage);
        listener.onAltitudeChanged(this.mAltitude);
        listener.onSpeedChanged(this.speed);
        listener.onAverageSpeedChanged(this.averageSpeed);
        listener.onDurationChanged(this.mDrivingTime);
        listener.onAltitudeListChanged(new ArrayList<>(this.mAltitudeList));
        listener.onSpeedListChanged(new ArrayList<>(this.mSpeedList));
        listener.onTotalDurationChanged(this.totalDrivingTime);
        listener.onTotalMileageChanged(this.totalMileage);
        listener.onMaxSpeedChanged(this.maxSpeed);
        listener.onUnitChanged(this.mUnit);
        listener.onSlopeChanged(this.mSlope);
        listener.onBearingChanged(this.mBearing);
    }

    public final int getAverageSpeed() {
        return this.averageSpeed;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final ArrayList<Integer> getMAltitudeList() {
        return this.mAltitudeList;
    }

    public final BaseApp getMApp() {
        return this.mApp;
    }

    public final int getMBearing() {
        return this.mBearing;
    }

    public final long getMDrivingTime() {
        return this.mDrivingTime;
    }

    public final RecordModel getMRecordModel() {
        return (RecordModel) this.mRecordModel.getValue();
    }

    public final RecordObserver getMRecordObserver() {
        return (RecordObserver) this.mRecordObserver.getValue();
    }

    public final float getMSlope() {
        return this.mSlope;
    }

    public final ArrayList<Integer> getMSpeedList() {
        return this.mSpeedList;
    }

    public final int getMUnit() {
        return this.mUnit;
    }

    public final int getMaxSpeed() {
        return this.maxSpeed;
    }

    public final float getMileage() {
        return this.mileage;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final long getTotalDrivingTime() {
        return this.totalDrivingTime;
    }

    public final float getTotalMileage() {
        return this.totalMileage;
    }

    public final VehicleModel getVehicleModel() {
        return (VehicleModel) this.vehicleModel.getValue();
    }

    public final XCore getXCore() {
        return (XCore) this.xCore.getValue();
    }

    public final void removeOnTripListener(OnTripListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.b.contains(listener)) {
            this.b.remove(listener);
        }
    }

    public final void setAverageSpeed(int i) {
        this.averageSpeed = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMAltitudeList(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mAltitudeList = arrayList;
    }

    public final void setMBearing(int i) {
        this.mBearing = i;
    }

    public final void setMDrivingTime(long j) {
        this.mDrivingTime = j;
    }

    public final void setMSlope(float f) {
        this.mSlope = f;
    }

    public final void setMSpeedList(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mSpeedList = arrayList;
    }

    public final void setMUnit(int i) {
        this.mUnit = i;
    }

    public final void setMaxSpeed(int i) {
        this.maxSpeed = i;
    }

    public final void setMileage(float f) {
        this.mileage = f;
    }

    public final void setSpeed(int i) {
        this.speed = i;
    }

    public final void setTotalDrivingTime(long j) {
        this.totalDrivingTime = j;
    }

    public final void setTotalMileage(float f) {
        this.totalMileage = f;
    }

    public static final void a(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }
}
