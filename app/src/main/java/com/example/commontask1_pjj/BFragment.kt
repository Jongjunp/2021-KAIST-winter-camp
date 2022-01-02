package com.example.commontask1_pjj

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.ArrayList

class BFragment : Fragment() {
    private var dataArray = ArrayList<DataVo>()
    lateinit var recyclerView1: RecyclerView
    lateinit var fabButton: FloatingActionButton
    lateinit var noImageView: ImageView
    private lateinit var rootView: View

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val FILE_NAME = "com.example.commontask1_pjj_preferences.xml"
        rootView = inflater.inflate(R.layout.fragment_b, container, false)

        fabButton = rootView.findViewById(R.id.fab) as FloatingActionButton
        fabButton.setOnClickListener {
            val intent = Intent(activity, ReviewActivity::class.java)
            activity?.startActivity(intent)
        }

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView1.adapter = ViewAdapterB(requireContext(), dataArray)


        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        noImageView = rootView.findViewById(R.id.no_image_default) as ImageView

        if (keys.isNotEmpty()) {
            noImageView.setVisibility(View.INVISIBLE)
            recyclerView1.setVisibility(View.VISIBLE)
        }

        while(i.hasNext()){
            val nextKey = i.next()
            val json = appSharedPrefs.getString(nextKey.toString(), "")
            val obj = gson.fromJson(json, ReviewData::class.java)
            dataArray.add(DataVo(obj.movieImage!!,obj.movieTitle!!,obj.movieRating!!))
        }
        return rootView
    }

    override fun onResume() {
        super.onResume()

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView1.adapter = ViewAdapterB(requireContext(), dataArray)

        val appSharedPrefs2 = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val gson2 = Gson()
        val keys2 = appSharedPrefs2.all.map { it.key }
        val i2 = keys2.iterator()

        noImageView = rootView.findViewById(R.id.no_image_default) as ImageView

        if (keys2.isNotEmpty()) {
            noImageView.setVisibility(View.INVISIBLE)
            recyclerView1.setVisibility(View.VISIBLE)
        }
        //나중에 최적화하기
        dataArray.clear()

        //var json = appSharedPrefs.getString(i.toString(), "")
        //var obj = gson.fromJson(json, ReviewData::class.java)
        //dataArray.add(DataVo(obj.movieImage!!,obj.movieTitle!!,obj.movieRating!!))

        while(i2.hasNext()){
            val nextKey2 = i2.next()
            val json2 = appSharedPrefs2.getString(nextKey2.toString(), "")
            val obj2 = gson2.fromJson(json2, ReviewData::class.java)
            dataArray.add(DataVo(obj2.movieImage!!,obj2.movieTitle!!,obj2.movieRating!!))
        }
    }

}