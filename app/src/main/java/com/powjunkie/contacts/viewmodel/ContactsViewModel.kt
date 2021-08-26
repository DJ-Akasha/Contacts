package com.powjunkie.contacts.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.media.Image
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.powjunkie.contacts.database.ContactDetails
import com.powjunkie.contacts.database.ContactDetailsDatabaseDAO
import kotlinx.coroutines.*

class ContactsViewModel(val database: ContactDetailsDatabaseDAO,
                        application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertContactDetails(details: ContactDetails) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                var contact = details
                /*contact.firstName = "name"
                contact.lastName = "lastname"
                contact.nickname = "nickname"
                contact.phone = 1
                contact.email = "email"
                contact.twitter = "twitter"
                //contact.contactImage = Bitmap?
                database.insertOrUpdateContact(contact)*/
                //val contact = database.getContact(individualContactKey)
                //contact.firstName = details
                //database.updateContact(contact)
            }
        }
    }

    /*private val individualContactKey: Long = 0L,
    val database: ContactDetailsDatabaseDAO) : ViewModel() {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMainActivity = MutableLiveData<Boolean?>()

    val navigateToMainActivity: LiveData<Boolean?>
    get() = _navigateToMainActivity

    fun doneNavigating() {
        _navigateToMainActivity.value = null
    }

    fun insertContactDetails(details: ContactDetails) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                var contact = details
                contact.firstName = "name"
                contact.lastName = "lastname"
                contact.nickname = "nickname"
                contact.phone = 1
                contact.email = "email"
                contact.twitter = "twitter"
                contact.contactImage = Image?
                database.insertContact(contact)
            //val contact = database.getContact(individualContactKey)
                //contact.firstName = details
                //database.updateContact(contact)
            }
        }
    }

    private val contacts = database.getAllContacts()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): SleepNight? {
        return withContext(Dispatchers.IO){
            // Stuff
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }*/
}

/*
class ContactsViewModel(
    val database: ContactDetailsDatabaseDAO,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var tonight = MutableLiveData<SleepNight?>()

    private val nights = database.getAllContacts()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): SleepNight? {
        return withContext(Dispatchers.IO){
            // Stuff
        }
    }
}
 */