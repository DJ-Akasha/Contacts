package com.powjunkie.contacts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.powjunkie.contacts.database.ContactDetailsDatabaseDAO

class ContactsViewModel(
    val database: ContactDetailsDatabaseDAO,
    application: Application) : AndroidViewModel(application) {
}