package me.fengmlo.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.dialog_add_server.view.*
import me.fengmlo.kotlintest.model.Server
import me.fengmlo.kotlintest.net.Net
import org.litepal.crud.DataSupport

class MainActivity : AppCompatActivity() {

    private val serversMap = ArrayList<Map<String, String>>()
    private val servers = ArrayList<Server>()
    private var adapter: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        adapter = SimpleAdapter(this, serversMap, R.layout.item_server, arrayOf("title"), kotlin.intArrayOf(R.id.tv_title))
        listView.adapter = adapter!!
        listView.setOnItemClickListener { parent, view, position, id ->
            val server: Server = servers[position]
            Net.init(server.serverId!!, server.key!!)
//            Net.instance().getServiceInfo()
//                    .subscribeOn(Schedulers.io())
//                    .subscribe({ }, { })
            val intent: Intent = Intent(this, ServerActivity::class.java)
            startActivity(intent)
        }
        refreshList()

        val addServerDialog: View = layoutInflater.inflate(R.layout.dialog_add_server, LinearLayout(this), false)
        addServerDialog.et_id.setText("521538")
        addServerDialog.et_key.setText("private_aFWOWpetzEgIIfZOgdfNQ1mj")
        val dialog = AlertDialog.Builder(this)
                .setTitle("添加主机")
                .setView(addServerDialog)
                .setPositiveButton("确定", { dialog, which ->
                    val server = Server()
                    server.title = addServerDialog.et_title.text.toString()
                    server.serverId = addServerDialog.et_id.text.toString()
                    server.key = addServerDialog.et_key.text.toString()
                    server.save()
                    refreshList()
                })
                .setNegativeButton("取消", { dialog, which -> dialog.dismiss() })
                .create()
        fab.setOnClickListener { dialog.show() }
    }

    private fun refreshList() {
        serversMap.clear()
        servers.clear()
        servers.addAll(DataSupport.findAll(Server::class.java))
        for (server in servers) {
            val map = HashMap<String, String>()
            map.put("title", server.title.toString())
            map.put("id", server.serverId.toString())
            map.put("key", server.key.toString())
            println(server.serverId)
            serversMap.add(map)
        }
        adapter?.notifyDataSetChanged()
    }

}
