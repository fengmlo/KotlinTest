package me.fengmlo.kotlintest.model.net

/**
 * Created by fengmlo on 2017/6/20.
 */

class ServiceLiveInfo {

    /**
     * vm_type : ovz
     * vz_status : {"status":"running","hostname":"localhost.localdomain","load_average":"0.00/0.00/0.00","nproc":"9","nproc_b":"200","kmemsize":"3469046","kmemsize_b":"134217728","privvmpages":"2147","privvmpages_b":"262144","oomguarpages":"1592","oomguarpages_b":"65536","numtcpsock":"11","numtcpsock_b":"1670","numfile":"207","numfile_b":"10240","swappages":"758","swappages_b":"32768","physpages":"6948","physpages_l":"65536"}
     * vz_quota : {"occupied_kb":"1092664","softlimit_kb":"12582912","hardlimit_kb":"13211648","occupied_inodes":"37626","softlimit_inodes":"12288000","hardlimit_inodes":"12902400"}
     * is_cpu_throttled :
     * ssh_port : 26968
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
     * data_counter : 13514421953
     * data_next_reset : 1498622400
     * ip_addresses : ["98.142.139.176"]
     * rdns_api_available : true
     * ptr : {"98.142.139.176":null}
     * suspended : false
     * error : 0
     */

    var vm_type: String? = null
    var vz_status: VzStatusBean? = null
    var vz_quota: VzQuotaBean? = null
    var is_cpu_throttled: String? = null
    var ssh_port: Int = 0
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

    class VzStatusBean {
        /**
         * status : running
         * hostname : localhost.localdomain
         * load_average : 0.00/0.00/0.00
         * nproc : 9
         * nproc_b : 200
         * kmemsize : 3469046
         * kmemsize_b : 134217728
         * privvmpages : 2147
         * privvmpages_b : 262144
         * oomguarpages : 1592
         * oomguarpages_b : 65536
         * numtcpsock : 11
         * numtcpsock_b : 1670
         * numfile : 207
         * numfile_b : 10240
         * swappages : 758
         * swappages_b : 32768
         * physpages : 6948
         * physpages_l : 65536
         */

        var status: String? = null
        var hostname: String? = null
        var load_average: String? = null
        var nproc: Int = 0
        var nproc_b: Int = 0
        var kmemsize: Int = 0
        var kmemsize_b: Int = 0
        var privvmpages: Int = 0
        var privvmpages_b: Int = 0
        var oomguarpages: Int = 0
        var oomguarpages_b: Int = 0
        var numtcpsock: Int = 0
        var numtcpsock_b: Int = 0
        var numfile: Int = 0
        var numfile_b: Int = 0
        var swappages: Int = 0
        var swappages_b: Int = 0
        var physpages: Int = 0
        var physpages_l: Int = 0
    }

    class VzQuotaBean {
        /**
         * occupied_kb : 1092664
         * softlimit_kb : 12582912
         * hardlimit_kb : 13211648
         * occupied_inodes : 37626
         * softlimit_inodes : 12288000
         * hardlimit_inodes : 12902400
         */

        var occupied_kb: Int = 0
        var softlimit_kb: Int = 0
        var hardlimit_kb: Int = 0
        var occupied_inodes: Int = 0
        var softlimit_inodes: Int = 0
        var hardlimit_inodes: Int = 0
    }

    fun getMemoryUsed(): Int {
          return (vz_status!!.oomguarpages.toFloat() / vz_status!!.oomguarpages_b * plan_ram).toInt()
    }

    fun getSwapUsed(): Int {
        return (vz_status!!.swappages.toFloat() / vz_status!!.swappages_b * plan_ram).toInt()
    }

    fun getDiskUsed(): Long {
        return (vz_quota!!.occupied_kb * 1024).toLong()
    }
}
