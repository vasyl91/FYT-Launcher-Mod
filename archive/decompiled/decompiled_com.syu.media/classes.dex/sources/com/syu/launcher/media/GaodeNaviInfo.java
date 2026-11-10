package com.syu.launcher.media;

import android.content.Intent;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/syu/launcher/media/GaodeNaviInfo;", "Lcom/syu/launcher/media/NaviInfo;", "Landroid/content/Intent;", "extras", FinalChip.BSP_PLATFORM_Null, "parse", FinalChip.BSP_PLATFORM_Null, "toString", FinalChip.BSP_PLATFORM_Null, "k", "I", "getRouteType2", "()I", "setRouteType2", "(I)V", "routeType2", "<init>", "()V", "Companion", "AutoManger_release"}, k = 1, mv = {1, 7, 1})
public final class GaodeNaviInfo extends NaviInfo {
    public static final String CAMERA_DIST = "CAMERA_DIST";
    public static final String CAMERA_INDEX = "CAMERA_INDEX";
    public static final String CAMERA_SPEED = "CAMERA_SPEED";
    public static final String CAMERA_TYPE = "CAMERA_TYPE";
    public static final String CUR_ROAD_NAME = "CUR_ROAD_NAME";
    public static final String CUR_SEG_NUM = "CUR_SEG_NUM";
    public static final String CUR_SPEED = "CUR_SPEED";
    public static final String ETA_TEXT = "ETA_TEXT";
    public static final String EXIT_DIRECTION_INFO = "EXIT_DIRECTION_INFO";
    public static final String EXIT_NAME_INFO = "EXIT_NAME_INFO";
    public static final String ICON = "ICON";
    public static final String NEW_ICON = "NEW_ICON";
    public static final String NEXT_NEXT_ROAD_NAME = "NEXT_NEXT_ROAD_NAME";
    public static final String NEXT_NEXT_TURN_ICON = "NEXT_NEXT_TURN_ICON";
    public static final String NEXT_ROAD_NAME = "NEXT_ROAD_NAME";
    public static final String NEXT_ROAD_PROGRESS_PRECENT = "NEXT_ROAD_PROGRESS_PERCENT";
    public static final String NEXT_SAPA_DIST = "NEXT_SAPA_DIST";
    public static final String NEXT_SAPA_DIST_AUTO = "NEXT_SAPA_DIST_AUTO";
    public static final String NEXT_SAPA_NAME = "NEXT_SAPA_NAME";
    public static final String NEXT_SAPA_TYPE = "NEXT_SAPA_TYPE";
    public static final String NEXT_SEG_REMAIN_DIS = "NEXT_SEG_REMAIN_DIS";
    public static final String NEXT_SEG_REMAIN_TIME = "NEXT_SEG_REMAIN_TIME";
    public static final String ROAD_TYPE = "ROAD_TYPE";
    public static final String ROUNDABOUT_OUT_ANGLE = "ROUNDABOUT_OUT_ANGLE";
    public static final String ROUND_ALL_NUM = "ROUND_ALL_NUM";
    public static final String ROUNG_ABOUT_NUM = "ROUNG_ABOUT_NUM";
    public static final String ROUTE_ALL_DIS = "ROUTE_ALL_DIS";
    public static final String ROUTE_ALL_TIME = "ROUTE_ALL_TIME";
    public static final String ROUTE_REMAIN_DIS = "ROUTE_REMAIN_DIS";
    public static final String ROUTE_REMAIN_DIS_AUTO = "ROUTE_REMAIN_DIS_AUTO";
    public static final String ROUTE_REMAIN_TIME = "ROUTE_REMAIN_TIME";
    public static final String ROUTE_REMAIN_TIME_AUTO = "ROUTE_REMAIN_TIME_AUTO";
    public static final String ROUTE_REMAIN_TIME_STRING = "ROUTE_REMAIN_TIME_STRING";
    public static final String SAPA_DIST = "SAPA_DIST";
    public static final String SAPA_DIST_AUTO = "SAPA_DIST_AUTO";
    public static final String SAPA_NAME = "SAPA_NAME";
    public static final String SAPA_NUM = "SAPA_NUM";
    public static final String SAPA_TYPE = "SAPA_TYPE";
    public static final String SEG_ASSISTANT_ACTION = "SEG_ASSISTANT_ACTION";
    public static final String SEG_REMAIN_DIS = "SEG_REMAIN_DIS";
    public static final String SEG_REMAIN_DIS_AUTO = "SEG_REMAIN_DIS_AUTO";
    public static final String SEG_REMAIN_TIME = "SEG_REMAIN_TIME";
    public static final String TRAFFIC_LIGHT_NUM = "TRAFFIC_LIGHT_NUM";

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int routeType2 = -1;

    public final int getRouteType2() {
        return this.routeType2;
    }

    public final void parse(Intent extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        StringBuilder sb = new StringBuilder();
        String stringExtra = extras.getStringExtra(NEXT_NEXT_ROAD_NAME);
        String str = FinalChip.BSP_PLATFORM_Null;
        if (stringExtra == null) {
            stringExtra = FinalChip.BSP_PLATFORM_Null;
        }
        StringBuilder sbAppend = sb.append(stringExtra).append(XmlConsts.CHAR_SPACE);
        String stringExtra2 = extras.getStringExtra(SEG_REMAIN_DIS_AUTO);
        if (stringExtra2 == null) {
            stringExtra2 = FinalChip.BSP_PLATFORM_Null;
        }
        setCrossing(sbAppend.append(stringExtra2).toString());
        String stringExtra3 = extras.getStringExtra(CUR_ROAD_NAME);
        if (stringExtra3 == null) {
            stringExtra3 = FinalChip.BSP_PLATFORM_Null;
        }
        setLocation(stringExtra3);
        String stringExtra4 = extras.getStringExtra(ROUTE_REMAIN_DIS_AUTO);
        if (stringExtra4 == null) {
            stringExtra4 = FinalChip.BSP_PLATFORM_Null;
        }
        setMileage(stringExtra4);
        String stringExtra5 = extras.getStringExtra(ROUTE_REMAIN_TIME_AUTO);
        if (stringExtra5 == null) {
            stringExtra5 = FinalChip.BSP_PLATFORM_Null;
        }
        setTime(stringExtra5);
        String stringExtra6 = extras.getStringExtra(ETA_TEXT);
        if (stringExtra6 != null) {
            str = stringExtra6;
        }
        setArrival(str);
        setRouteType(extras.getIntExtra(NEW_ICON, -1));
        this.routeType2 = extras.getIntExtra(ICON, -1);
        setMessage(getMileage() + XmlConsts.CHAR_SPACE + getTime() + XmlConsts.CHAR_SPACE + getArrival());
    }

    public final void setRouteType2(int i) {
        this.routeType2 = i;
    }

    @Override // com.syu.launcher.media.NaviInfo
    public String toString() {
        return super.toString() + " routeType: " + getRouteType() + " routeType2: " + this.routeType2;
    }
}
