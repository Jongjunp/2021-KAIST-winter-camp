package com.example.commontask1_pjj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AFragment : Fragment() {

    val item_list : ArrayList<ItemData> = ArrayList()
    lateinit var recyclerView1 : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_a, container, false)
        item_list.add(ItemData("PJJ",22))

        recyclerView1 = rootView.findViewById(R.id.)

    }
}