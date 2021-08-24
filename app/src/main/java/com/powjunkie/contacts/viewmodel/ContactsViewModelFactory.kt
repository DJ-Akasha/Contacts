package com.powjunkie.contacts.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.powjunkie.contacts.database.ContactDetailsDatabaseDAO

class ContactsViewModelFactory (
    private val dataSource: ContactDetailsDatabaseDAO,
    private val application: Application) :ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
            return ContactsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}