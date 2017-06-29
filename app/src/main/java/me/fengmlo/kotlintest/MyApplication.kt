package me.fengmlo.kotlintest

import android.app.Application
import org.litepal.LitePal

/**
 * Created by fengmlo on 2017/5/26.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
    }
}