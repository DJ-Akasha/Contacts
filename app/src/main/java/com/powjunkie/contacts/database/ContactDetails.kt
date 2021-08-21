package com.powjunkie.contacts.database

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class is used by Room to create a Table
 */
@Entity(tableName = "individual_contact_details_table")
data class ContactDetails (

    @PrimaryKey(autoGenerate = true)
    val individualContactId: Long = 0L,

    @ColumnInfo(name = "first_Name")
    var firstName: String?,

    @ColumnInfo(name = "last_name")
    var LastName: String?,

    @ColumnInfo(name = "nickname")
    var nickname: String?,

    @ColumnInfo(name = "phone_number")
    var phone: ContactsContract.CommonDataKinds.Phone?,

    @ColumnInfo(name = "email_address")
    var email: ContactsContract.CommonDataKinds.Email?,

    @ColumnInfo(name = "twitter_tag")
    var twitter: String?
        )