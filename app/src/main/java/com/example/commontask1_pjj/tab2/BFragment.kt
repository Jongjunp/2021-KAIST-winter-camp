package com.example.commontask1_pjj.tab2

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.io.IOException
import com.example.commontask1_pjj.R

class BFragment : Fragment() {

    private var userList = arrayListOf<dataVo>(
        dataVo("")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = customAdapter(this, userList)
        recycler_view.adapter = mAdapter

        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        recycler_view.layoutManager =
            staggeredGridLayoutManager

    }

}