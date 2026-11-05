package com.syu.media.network.api;

import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.network.response.BaseResponse;
import com.syu.media.online.model.OnlineJson;
import com.syu.radio.Radio;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: compiled from: ApiInterface.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/syu/media/network/api/ApiInterface;", FinalChip.BSP_PLATFORM_Null, "downloadOnlineData", "Lcom/syu/media/network/response/BaseResponse;", "Lcom/syu/media/online/model/OnlineJson;", Radio.URL, FinalChip.BSP_PLATFORM_Null, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRadioList", XmlConsts.XML_DECL_KW_VERSION, "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApiInterface {
    @GET
    Object downloadOnlineData(@Url String str, Continuation<? super BaseResponse<OnlineJson>> continuation);

    @FormUrlEncoded
    @POST("/cj/carRadio/queryUpdateRadioList")
    Object updateRadioList(@Field("radioVersion") String str, Continuation<? super BaseResponse<OnlineJson>> continuation);
}
