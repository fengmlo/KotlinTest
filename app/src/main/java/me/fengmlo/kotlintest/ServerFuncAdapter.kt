package me.fengmlo.kotlintest

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by fengmlo on 2017/6/20.
 */
class ServerFuncAdapter(private val context: Context, fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val titles = arrayOf(
            "主机信息",
            "切换机房",
            "重置ROOT密码",
            "安装新系统",
            "执行SHELL")

    override fun getItem(position: Int): Fragment {
        return ServerInfoFragment()
    }

    override fun getCount(): Int {
        return 1
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return titles[0]
            else -> return titles[position]
        }
    }

}