package me.fengmlo.kotlintest.net

import me.fengmlo.kotlintest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val server_address: String = "https://api.64clouds.com/v1/"

/**
 * Created by fengmlo on 2017/5/26.
 */
class Net {

    private var retrofit: Retrofit
    private var serverApi: ServerApi
    private var net: Net? = null

    private constructor(id: String, key: String) {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        val client: OkHttpClient = builder
                .addInterceptor(HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE))
                .addInterceptor(CommonInterceptor(id, key))
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(server_address)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        serverApi = retrofit.create(ServerApi::class.java)
    }

    fun init(id: String, key: String) {
        net = Net(id, key)
    }

    fun getInstance(): ServerApi {
        return net!!.serverApi
    }

    companion object {
        private var net: Net? = null

        fun init(id: String, key: String) {
            net = Net(id, key)
        }

        fun instance(): ServerApi {
            return net!!.serverApi
        }
    }

}