package com.example.commontask1_pjj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AFragment : Fragment() {
    private val dataArray = ArrayList<ListItem>()
    lateinit var recyclerView1: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_a, container, false)
        dataArray.add(ListItem("홍길동", "010-1234-5678"))
        dataArray.add(ListItem("이름", "010-0987-6543"))

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = ViewAdapter(requireContext(), dataArray)

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