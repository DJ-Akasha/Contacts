package com.powjunkie.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDetailsDatabaseDAO {

    @Insert
    fun insert(details: ContactDetails)

    @Update
    fun update(details: ContactDetails)

    @Query("SELECT * FROM individual_contact_details_table WHERE individualContactId = :key")
    fun get(key: PrimaryKey): ContactDetails?

    @Query("DELETE FROM individual_contact_details_table")
    fun clear()

    @Query("SELECT * FROM individual_contact_details_table ORDER BY first_Name ASC")
    fun getAllContacts(): LiveData<List<ContactDetails>>

    @Query("SELECT * FROM individual_contact_details_table ORDER BY first_Name ASC LIMIT 1")
    fun getContact(): ContactDetails?

}