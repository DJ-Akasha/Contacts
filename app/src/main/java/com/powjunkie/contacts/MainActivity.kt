package com.powjunkie.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Floating Action Button that starts the AddContactsActivity
        val fab: View = findViewById(R.id.fabAddContact)
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddContactsActivity::class.java))
        }
    }

}