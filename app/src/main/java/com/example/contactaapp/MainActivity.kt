package com.example.contactaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactaapp.adapter.ContactsAdapter
import com.example.contactaapp.dataModel.ContactData
import com.example.contactaapp.databinding.ActivityMainBinding
import com.example.contactaapp.details.ContactsDetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var name: String
    lateinit var phone: String
    lateinit var description:String
        lateinit var adapter: ContactsAdapter
        var contactsList= mutableListOf<ContactData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
initRecyclerView()
        saveBtn()





    }

    private fun initRecyclerView() {
        adapter=ContactsAdapter(contactsList)

adapter.onItemClickListener=object :ContactsAdapter.SetOnItemClickListener{
    override fun onClick(position: Int, item: ContactData) {
        var intent=Intent(applicationContext,ContactsDetailsActivity::class.java)
        intent.putExtra("name",contactsList[position].name)
        intent.putExtra("phone",contactsList[position].phone)
        intent.putExtra("description",contactsList[position].describtion)
        startActivity(intent)

    }


}



        binding.contactRv.adapter=adapter
    }

    private fun saveBtn() {
        binding.saveBtn.setOnClickListener {

            if (validatTextFiled()) {
                return@setOnClickListener
            }
            // this very important
            name = binding.NameEdt.text?.trim().toString()
            phone = binding.phoneEdt.text?.trim().toString()
            description = binding.descriptionEdt.text?.trim().toString()

            var contact = ContactData(name, phone, description)

contactsList.add(contact)
            adapter.notifyItemInserted(contactsList.size-1)
            binding.NameEdt.text=null
            binding.phoneEdt.text=null
            binding.descriptionEdt.text=null
            //******************************
        }


    }

    private fun validatTextFiled():Boolean {
       name= binding.NameEdt.text?.trim().toString()
        phone = binding.phoneEdt.text?.trim().toString()
        binding.nameTil.error=validatName(name)
        binding.phoneTil.error=validatPhone(phone)
        return !(validatName(name)==null&&validatPhone(phone)==null)


    }


    fun validatName(name:String): String? {

        if (name.isEmpty())
            return "requaird"
        if (name.length<3)
            return "Name can't be less than 3 characters"

        return null

    }
    fun validatPhone(phone:String): String? {

        if (phone.isEmpty())
            return "requaird"
        if (phone.length<11)
            return "Name can't be less than 11 number"
        if (phone.length>11)
            return "Name can't be bigest than 11 number"

        return null

    }



}
