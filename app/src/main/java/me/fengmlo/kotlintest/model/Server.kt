package me.fengmlo.kotlintest.model

import org.litepal.crud.DataSupport

/**
 * Created by fengmlo on 2017/5/26.
 */
class Server : DataSupport() {
    var title: String? = null
    var serverId: String? = null
    var key: String? = null
}