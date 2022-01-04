package com.example.commontask1_pjj

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class AFragment : Fragment() {
    private val dataArray = ArrayList<ListItem>()
    lateinit var recyclerView1: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_a, container, false)
        
        //저장된 json file 받아오기
        val assetManager = resources.assets
        val inputStream = assetManager.open("phoneData.json")
        val jsonString = inputStream.bufferedReader().use {it.readText()}

        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("phoneData")

        for(i in 0 until jArray.length()){

            val obj = jArray.getJSONObject(i)

            val jName = obj.getString("name")
            val jPhone = obj.getString("phone")

            dataArray.add(ListItem(jName, jPhone))
        }

        //recyclerView에 item 추가
        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())

        var adapter = ViewAdapterA(requireContext(), dataArray)
        recyclerView1.adapter = adapter

        //item 클릭 시 기기 dial로 연결
        adapter.setOnItemClickListener(object: ViewAdapterA.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:"+dataArray[position].phone)
                activity?.startActivity(intent)
            }
        })

        recyclerView1.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        return rootView
    }

}