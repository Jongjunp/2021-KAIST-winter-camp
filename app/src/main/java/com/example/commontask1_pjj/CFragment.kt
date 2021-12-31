package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.commontask1_pjj.R
import org.json.JSONObject

class CFragment : Fragment() {
    private val dataArray = ArrayList<genreItem>()
    lateinit var recyclerView1: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_c, container, false)

        dataArray.add(genreItem("액션/범죄"))
        dataArray.add(genreItem("드라마/멜로"))
        dataArray.add(genreItem("SF/판타지"))
        dataArray.add(genreItem("코미디"))
        dataArray.add(genreItem("공포/스릴러"))
        dataArray.add(genreItem("기타"))


        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())

        var adapter = ViewAdapterC(requireContext(), dataArray)
        recyclerView1.adapter = adapter
        adapter.setOnItemClickListener(object: ViewAdapterC.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(activity, GenreActivity::class.java)
                intent.putExtra("Genre", dataArray[position].genre)
                activity?.startActivity(intent)
            }
        })
        recyclerView1.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


        return rootView
    }

}