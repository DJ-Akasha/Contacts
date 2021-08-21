package com.powjunkie.contacts

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class AddContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_contacts)
        /**
         * TODO - Store the user's input when they press the Submit button and return to MainActivity
         *
         */
        val ivPhoto: ImageView = findViewById(R.id.avatarImage)
        val fab: View = findViewById(R.id.fabAddPhoto)

        // Sets the image the user chose to the avatarImage ImageView
        val getContent = registerForActivityResult(ActivityResultContracts.GetContent())  { uri: Uri? ->
            ivPhoto.setImageURI(uri)
        }

        // Floating Action Button that opens the gallery app so user can select a photo
        fab.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}