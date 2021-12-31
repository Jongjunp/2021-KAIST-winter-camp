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
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
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
    private val dataArray = ArrayList<dataVo>()
    lateinit var recyclerView1: RecyclerView
    lateinit var fabButton: FloatingActionButton

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val FILE_NAME = "com.example.commontask1_pjj_preferences.xml"
        var rootView = inflater.inflate(R.layout.fragment_b, container, false)

        val appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val gson = Gson()
        val keys = appSharedPrefs.all.map { it.key }
        val i = keys.iterator()

        /*var nextKey = i.next()
        var json = appSharedPrefs.getString(nextKey.toString(), "")
        var obj = gson.fromJson(json, ReviewData::class.java)*/

        //default for no image
        //drawable to bitmap
        if (!i.hasNext()) {
            val drawable = ContextCompat.getDrawable(context!!, R.drawable.no_image)!!
            val bitmapDrawable = drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            //bitmap to string
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val bytes = stream.toByteArray()
            dataArray.add(dataVo(Base64.getEncoder().encodeToString(bytes)))
        }
        while(i.hasNext()){
            val nextKey = i.next()
            val json = appSharedPrefs.getString(nextKey.toString(), "")
            val obj = gson.fromJson(json, ReviewData::class.java)
            dataArray.add(dataVo(obj.movieImage!!))
        }

        fabButton = rootView.findViewById(R.id.fab) as FloatingActionButton
        fabButton.setOnClickListener {
            val intent = Intent(activity, ReviewActivity::class.java)
            activity?.startActivity(intent)
        }

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView1.adapter = ViewAdapterB(requireContext(), dataArray)

        return rootView
    }
    /*
    private lateinit var rv: RecyclerView
    private lateinit var myAdapter: ViewAdapter
    private val repository = innerData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = ViewAdapter(this)
        //rv.adapter = myAdapter
        myAdapter.data = repository.getRepoList()

    }*/
}