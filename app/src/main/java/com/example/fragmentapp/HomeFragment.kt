package com.example.fragmentapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class HomeFragment : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_home, container, false)

        val list = view.findViewById<ListView>(R.id.studentlistview)
        val studentlist = arrayListOf("Azim Raza","Ahamad","Rashid","Naushad","Mustufa","Rahul","Pradeep","Sohail","Sana")
        val studentArrayAdapterList = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1 , studentlist)

        list.adapter = studentArrayAdapterList

        // Inflate the layout for this fragment
        return view
    }


}