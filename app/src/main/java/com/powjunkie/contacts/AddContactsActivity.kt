package com.powjunkie.contacts

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.powjunkie.contacts.database.ContactDetailsDatabase
import com.powjunkie.contacts.databinding.AddContactsBinding
import com.powjunkie.contacts.viewmodel.ContactsViewModel
import com.powjunkie.contacts.viewmodel.ContactsViewModelFactory

class AddContactsActivity : AppCompatActivity() {

    private lateinit var binding: AddContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get a reference to the binding object and inflate the views.
        binding = DataBindingUtil.setContentView(this, R.layout.add_contacts)

        /**
         * TODO - Store the user's input when they press the Submit button and return to MainActivity
         *
         */

        // A reference to the data source via a reference to the DAO
        val dataSource = ContactDetailsDatabase.getInstance(application).contactDetailsDatabaseDAO

        // An instance of the ContactsViewModelFactory we pass it the  dataSource and the application
        val viewModelFactory = ContactsViewModelFactory(dataSource, application)

        // We pass in our viewModelFactory and request an instance of the ContactsViewModel.
        val contactsViewModel =
            ViewModelProvider(this, viewModelFactory).get(ContactsViewModel::class.java)

        // We set the variable in our layout add_contacts.xml which we access through the binding
        // object to the ViewModel.
        binding.contactsViewModel = contactsViewModel
        // We specify the current activity as the lifecycle owner of the binding. This is necessary
        // so that the binding can observe LiveData updates.
        binding.lifecycleOwner = this


        // Sets the image the user chose to the avatarImage ImageView
        val getContent = registerForActivityResult(ActivityResultContracts.GetContent())  { uri: Uri? ->
            binding.avatarImage.setImageURI(uri)
        }

        // Floating Action Button that opens the gallery app so user can select a photo
        binding.fabAddPhoto.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}