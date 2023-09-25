package com.example.fragmentapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class TeacherDetails(val context: Context, val item:ArrayList<MyData>, val onclick: UserOnclick): BaseAdapter() {
    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(p0: Int): Any {
        return item[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//        val layout = LayoutInflater.from(context).inflate(R.layout)

        val layout = LayoutInflater.from(context).inflate(R.layout.teacher_list_view,p2,false)

        val nametext = layout.findViewById<TextView>(R.id.Textview)
        val agetext = layout.findViewById<TextView>(R.id.ageView)
        val imagetext = layout.findViewById<ImageView>(R.id.imageview)

        nametext.text = item[p0].name
        agetext.text = item[p0].age.toString()

        imagetext.setImageResource(item[p0].image)

        val deleteBtn = layout.findViewById<TextView>(R.id.delete)

        deleteBtn.setOnClickListener(){

            val alertBuilder = AlertDialog.Builder(context)
            alertBuilder.setPositiveButton("delete",DialogInterface.OnClickListener(){ DialogInterface,i ->
                onclick.onclick(p0)
            })
            alertBuilder.setNegativeButton("profile",DialogInterface.OnClickListener(){ DialogInterface, i ->

            })

            val builder = alertBuilder.create()
            builder.setTitle("Delete")
            builder.setMessage("Are you sure")
            builder.show()
        }
        return layout
    }


}