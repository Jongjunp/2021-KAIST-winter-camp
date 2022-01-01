package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
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
import com.google.gson.Gson
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

        //val genre = arrayOf("액션/범죄", "드라마/멜로", "SF/판타지", "코미디", "공포/스릴러", "기타")
        //val cnt = Array<Int>(6) {_ -> 0}

        /*val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        while(i.hasNext()){
            var nextKey = i.next()
            var json = appSharedPrefs.getString(nextKey.toString(), "")
            var obj = gson.fromJson(json, ReviewData::class.java)

            for(j: Int in 0..5){
                if(obj.movieGenre == genre[j])
                {
                    cnt[j]+=1
                }
            }
        }*/
        /*
        dataArray.add(genreItem("액션/범죄", cnt[0].toString()))
        dataArray.add(genreItem("드라마/멜로", cnt[1].toString()))
        dataArray.add(genreItem("SF/판타지", cnt[2].toString()))
        dataArray.add(genreItem("코미디", cnt[3].toString()))
        dataArray.add(genreItem("공포/스릴러", cnt[4].toString()))
        dataArray.add(genreItem("기타", cnt[5].toString()))*/

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