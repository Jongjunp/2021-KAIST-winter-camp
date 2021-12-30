package com.example.commontask1_pjj

import android.content.res.AssetManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
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

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = ViewAdapter(requireContext(), dataArray)
        recyclerView1.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        return rootView
    }

}