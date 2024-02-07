package com.example.contactaapp.adapter

import android.annotation.SuppressLint
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactaapp.R
import com.example.contactaapp.dataModel.ContactData

class ContactsAdapter(val contactsItemsList: List<ContactData>):RecyclerView.Adapter<ContactsAdapter.MyViewHloder>() {




    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHloder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_contact_rv,parent,false)


                return MyViewHloder(view)
    }

    override fun getItemCount(): Int =contactsItemsList.size


    override fun onBindViewHolder(holder: MyViewHloder, position: Int) {
        var contacts=contactsItemsList[position]

         holder.nameTv.text=contacts.name
        holder.phoneTv.text=contacts.phone
        holder.itemView.setOnClickListener {

            onItemClickListener?.onClick(position,contacts)
        }

    }

    var onItemClickListener:SetOnItemClickListener?=null

    interface SetOnItemClickListener{
        fun onClick(position:Int, item: ContactData)
    }




    class MyViewHloder(itemView: View):RecyclerView.ViewHolder(itemView){

        var nameTv:TextView=itemView.findViewById(R.id.itemName)
        var phoneTv:TextView=itemView.findViewById(R.id.itemPhone)


        }

    }
