package me.fengmlo.kotlintest.net

import me.fengmlo.kotlintest.model.net.ServerInfo
import me.fengmlo.kotlintest.model.net.ServiceLiveInfo
import okhttp3.ResponseBody
import retrofit2.http.GET
import rx.Observable

/**
 * Created by fengmlo on 2017/5/26.
 */
interface ServerApi {

    @GET("getServiceInfo")
    fun getServiceInfo(): Observable<ServerInfo>

    @GET("getRawUsageStats")
    fun getRawUsageStats(): Observable<ResponseBody>

    @GET("getLiveServiceInfo")
    fun getLiveServiceInfo(): Observable<ServiceLiveInfo>
}