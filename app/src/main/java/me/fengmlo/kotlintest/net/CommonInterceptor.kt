package me.fengmlo.kotlintest.net

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val USER_ID: String = "veid"
private const val API_KEY: String = "api_key"

/**
 * Created by fengmlo on 2017/5/26.
 */
class CommonInterceptor(private val id: String, private val key: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest: Request = chain.request()
        val urlBuilder: HttpUrl.Builder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())
                .addQueryParameter(USER_ID, id)
                .addQueryParameter(API_KEY, key)
        val newRequest: Request = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(urlBuilder.build())
                .build()
        return chain.proceed(newRequest)
    }

}