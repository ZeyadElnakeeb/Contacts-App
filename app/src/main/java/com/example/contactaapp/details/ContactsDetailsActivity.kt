package com.example.contactaapp.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactaapp.R
import com.example.contactaapp.adapter.ContactsAdapter
import com.example.contactaapp.dataModel.ContactData
import com.example.contactaapp.databinding.ActivityContactsDetailsBinding
import com.example.contactaapp.databinding.ActivityMainBinding

class ContactsDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactsDetailsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var bundel:Bundle?=intent.extras

        var name = bundel?.getString("name")
        var phone= bundel?.getString("phone")
        var description= bundel?.getString("description")

        binding.userName.text=name
        binding.showName.text=name
        binding.showPhone.text=phone
        binding.showDescription.text=description




    }
}