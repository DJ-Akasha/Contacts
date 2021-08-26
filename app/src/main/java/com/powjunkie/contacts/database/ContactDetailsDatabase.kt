package com.powjunkie.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE = "crm"

/**
 * If I decide to actually release this I'd need to add a migration object, so that when a user
 * updates the app to a newer version they will still retain their data.
 */
@Database(entities = [ContactDetails::class], version = 1, exportSchema = false)
abstract class ContactDetailsDatabase : RoomDatabase() {
    abstract val contactDetailsDatabaseDAO: ContactDetailsDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDetailsDatabase? = null


        fun getInstance(context: Context): ContactDetailsDatabase {
            // The code is wrapped in a synchronized block to avoid multiple initialisations of
            // the database object.
            synchronized(this) {
                // Copy the current value of instance to a local variable to utilize smart cast.
                var instance = INSTANCE

                // Check if there's already a database.
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

/* ERRORS FIXED BY ADDING kotlin-kapt to gradle app file
TRIED THIS AS WELL BUT STILL GOT ERRORS
        fun getInstance(context: Context): ContactDetailsDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDetailsDatabase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext,
                        ContactDetailsDatabase::class.java,
                            "contact_details_history_database")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }*/