package me.fengmlo.kotlintest.model.net

/**
 * Created by fengmlo on 2017/5/27.
 */

class ServerInfo {

    /**
     * vm_type : ovz
     * hostname : localhost.localdomain
     * node_ip : 98.142.136.13
     * node_alias : v1103
     * node_location : US, California
     * location_ipv6_ready : true
     * plan : wagonv2-10g
     * plan_monthly_data : 590558003200
     * plan_disk : 12884901888
     * plan_ram : 268435456
     * plan_swap : 134217728
     * plan_max_ipv6s : 5
     * os : centos-7-x86_64
     * email : fengmlo@qq.com
     * data_counter : 25262595733
     * data_next_reset : 1495944000
     * ip_addresses : ["98.142.139.176"]
     * rdns_api_available : true
     * ptr : {"98.142.139.176":null}
     * suspended : false
     * error : 0
     */

    var vm_type: String? = null
    var hostname: String? = null
    var node_ip: String? = null
    var node_alias: String? = null
    var node_location: String? = null
    var isLocation_ipv6_ready: Boolean = false
    var plan: String? = null
    var plan_monthly_data: Long = 0
    var plan_disk: Long = 0
    var plan_ram: Int = 0
    var plan_swap: Int = 0
    var plan_max_ipv6s: Int = 0
    var os: String? = null
    var email: String? = null
    var data_counter: Long = 0
    var data_next_reset: Int = 0
    var isRdns_api_available: Boolean = false
    var ptr: Map<String, String>? = null
    var isSuspended: Boolean = false
    var error: Int = 0
    var ip_addresses: List<String>? = null
    var message: String? = null

}
