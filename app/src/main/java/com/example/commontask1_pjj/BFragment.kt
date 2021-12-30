package com.example.commontask1_pjj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BFragment : Fragment() {
    private val dataArray = ArrayList<dataVo>()
    lateinit var recyclerView1: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_b, container, false)
        dataArray.add(dataVo("홍길동", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))
        dataArray.add(dataVo("이름", ContextCompat.getDrawable(context!!, R.drawable.image01)!!))

        recyclerView1 = rootView.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = ViewAdapterB(requireContext(), dataArray)
        recyclerView1.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

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