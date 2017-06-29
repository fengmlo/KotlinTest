package me.fengmlo.kotlintest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_server_info.*
import me.fengmlo.kotlintest.model.net.ServiceLiveInfo
import me.fengmlo.kotlintest.net.Net
import rx.schedulers.Schedulers


/**
 * Created by fengmlo on 2017/6/20.
 */
class ServerInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_server_info, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        Net.instance().getServiceInfo()
                .subscribeOn(Schedulers.io())
                .subscribe({ /*initView(it)*/ }, { })

        Net.instance().getLiveServiceInfo()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    initView(it)
                    view?.invalidate()
                }, { })
    }

    private fun initView(serverInfo: ServiceLiveInfo) {
        // 内存表
        chart_memory.setOnDragListener({ v, event -> true })
        chart_memory.setDrawSlicesUnderHole(false)
        chart_memory.setDrawEntryLabels(false)
        chart_memory.centerText = formatToMB(serverInfo.plan_ram).toString() + "MB"
        val description1 = Description()
        description1.text = "内存"
        chart_memory.description = description1
        val entries1: ArrayList<PieEntry> = ArrayList()
        val memoryUsed = formatToMB(serverInfo.getMemoryUsed())
        val memoryIdle = formatToMB(serverInfo.plan_ram) - memoryUsed
        entries1.add(PieEntry(memoryUsed, "已用"))
        entries1.add(PieEntry(memoryIdle, "未用"))
        val set1 = PieDataSet(entries1, "")
        val data1 = PieData(set1)
        set1.colors = ColorTemplate.MATERIAL_COLORS.toMutableList()
        chart_memory.data = data1
        data1.notifyDataChanged()
        chart_memory.notifyDataSetChanged()
        chart_memory.invalidate() // refresh

        // 交换表
        chart_swap.centerText = formatToMB(serverInfo.plan_swap).toString() + "MB"
        val description2 = Description()
        description2.text = "交换"
        chart_swap.description = description2
        val entries2: ArrayList<PieEntry> = ArrayList()
        val swapUsed = formatToMB(serverInfo.getSwapUsed())
        val swapIdle = formatToMB(serverInfo.plan_swap) - swapUsed
        entries2.add(PieEntry(swapUsed, "已用"))
        entries2.add(PieEntry(swapIdle, "未用"))
        val set2 = PieDataSet(entries2, "")
        val data2 = PieData(set2)
        set2.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        chart_swap.data = data2
        data2.notifyDataChanged()
        chart_swap.notifyDataSetChanged()
        chart_swap.invalidate() // refresh

        // 磁盘表
        chart_disk.centerText = formatToGB(serverInfo.plan_disk).toString() + "GB"
        val description3 = Description()
        description3.text = "磁盘"
        chart_disk.description = description3
        val entries3: ArrayList<PieEntry> = ArrayList()
        val diskUsed = formatToGB(serverInfo.getDiskUsed())
        val diskIdle = formatToGB(serverInfo.plan_disk) - diskUsed
        entries3.add(PieEntry(diskUsed, "已用"))
        entries3.add(PieEntry(diskIdle, "未用"))
        val set3 = PieDataSet(entries3, "")
        val data3 = PieData(set3)
        set3.colors = ColorTemplate.JOYFUL_COLORS.toMutableList()
        chart_disk.data = data3
        data3.notifyDataChanged()
        chart_disk.notifyDataSetChanged()
        chart_disk.invalidate() // refresh

        // 流量表
        chart_data.centerText = formatToGB(serverInfo.plan_monthly_data).toString() + "GB"
        val description4 = Description()
        description4.text = "流量"
        chart_data.description = description4
        val entries4: ArrayList<PieEntry> = ArrayList()
        val dataUsed = formatToGB(serverInfo.data_counter)
        val dataIdle = formatToGB(serverInfo.plan_monthly_data) - dataUsed
        entries4.add(PieEntry(dataUsed, "已用"))
        entries4.add(PieEntry(dataIdle, "未用"))
        val set4 = PieDataSet(entries4, "")
        val data4 = PieData(set4)
        set4.colors = ColorTemplate.MATERIAL_COLORS.toMutableList()
        chart_data.data = data4
        data4.notifyDataChanged()
        chart_data.notifyDataSetChanged()
        chart_data.invalidate() // refresh

    }

    private fun formatToMB(dataInByte: Int): Float {
        return dataInByte / 1024F / 1024F
    }

    private fun formatToGB(dataInByte: Long): Float {
        return dataInByte / 1024F / 1024F / 1024F
    }
}