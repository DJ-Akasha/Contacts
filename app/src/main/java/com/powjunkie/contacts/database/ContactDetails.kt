package com.powjunkie.contacts.database

import android.media.Image
import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class is used by Room to create a Table
 */
@Entity(tableName = "contacts_details_table")
data class ContactDetails (

    @PrimaryKey(autoGenerate = true)
    val individualContactId: Long = 0L,

    @ColumnInfo(name = "first_Name")
    var firstName: String?,

    @ColumnInfo(name = "last_name")
    var lastName: String?,

    @ColumnInfo(name = "nickname")
    var nickname: String?,

    @ColumnInfo(name = "phone_number")
    var phone: ContactsContract.CommonDataKinds.Phone?,

    @ColumnInfo(name = "email_address")
    var email: ContactsContract.CommonDataKinds.Email?,

    @ColumnInfo(name = "twitter_tag")
    var twitter: String?,

    @ColumnInfo(name = "contact_image")
    var contactImage: Image?
        )

