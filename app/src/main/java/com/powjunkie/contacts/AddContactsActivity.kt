package com.powjunkie.contacts

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class AddContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_contacts)
        /**
         * Create a FAB that opens a camera app
         *
         * val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
        startActivity(Intent(this@MainActivity, AddContactsActivity::class.java))
        }
         */
    }
}