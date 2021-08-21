package com.powjunkie.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactDetails::class], version = 1, exportSchema = false)
abstract class ContactDetailsDatabase : RoomDatabase() {
    abstract val contactDetailsDatabaseDAO: ContactDetailsDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDetailsDatabase? = null

        fun getInstance(context: Context): ContactDetailsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDetailsDatabase::class.java,
                        "contact_details_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}