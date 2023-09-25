package com.example.fragmentapp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast


class SettingFragment : Fragment() , UserOnclick{

    private lateinit var myData: ArrayList<MyData>
    private lateinit var adapter : TeacherDetails

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_setting, container, false)
        myData = arrayListOf(
            MyData("Azim Raza",18,R.drawable.baseline_person_24,) ,
            MyData("Naushad Alam",22,R.drawable.baseline_person_24,),
            MyData("Rashid Ikbal",24,R.drawable.baseline_person_24,),
            MyData("Vinay kumar",28,R.drawable.baseline_person_24,),
            MyData("Ahmad Raza",26,R.drawable.baseline_person_24,),
            MyData("Bipul Gupta",25,R.drawable.baseline_person_24,),
            MyData("Sana Khan",23,R.drawable.baseline_person_24,)
        )

        val userlist =view.findViewById<ListView>(R.id.userList)
        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
        val ageEditText = view.findViewById<EditText>(R.id.ageEditText)
        val add = view.findViewById<Button>(R.id.Add)
        adapter = TeacherDetails(requireActivity(),myData,this)

        userlist.adapter = adapter

        add.setOnClickListener{
            if (nameEditText.text.isEmpty()){
                return@setOnClickListener
            }
            if (ageEditText.text.isEmpty()){
                return@setOnClickListener
            }
            myData.add(MyData("${nameEditText.text}",ageEditText.text.toString().toInt(),R.drawable.img))
            adapter.notifyDataSetChanged()
        }

        return view

    }

    override fun onclick(position: Int) {

        myData.removeAt(position)
        adapter.notifyDataSetChanged()

    }

//    override fun onProfileClick(name: String, position: Int) {
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
//        myData.removeAt(position)
//        adapter.notifyDataSetChanged()
//    }
//        // Inflate the layout for this fragment
//        return view
//    }


}