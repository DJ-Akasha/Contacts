package com.powjunkie.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDetailsDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateContact(details: ContactDetails)

    @Update
    fun updateContact(details: ContactDetails)

    @Query("SELECT * FROM contacts_details_table WHERE individualContactId = :key")
    fun getContactById(key: PrimaryKey): ContactDetails?

    @Delete
    fun deleteSingleUser(details: ContactDetails)

    /*@Query("DELETE FROM contacts_details_table WHERE individualContactId = :key")
     fun deleteSingleUser(key: PrimaryKey)
*/

    @Query("SELECT * FROM contacts_details_table ORDER BY first_Name ASC")
    fun getAllContacts(): List<ContactDetails>

    /*@Query("SELECT * FROM contacts_details_table ORDER BY first_Name ASC")
     fun getAllContacts(): LiveData<List<ContactDetails>>*/


}

/* FROM THE DOCS...
@Insert
fun insertAll(vararg users: User)


//method that attempts to delete one or more User objects from the database:
@Delete
fun deleteUsers(vararg users: User)


//Room allows you to return a simple object from any of your queries as long as you can map the
//set of result columns onto the returned object. For example, you can define the following
//object to hold a user's first and last name:
data class NameTuple(
@ColumnInfo(name = "first_name") val firstName: String?,
@ColumnInfo(name = "last_name") val lastName: String?
)
//Then, you can return that simple object from your query method:
@Query("SELECT first_name, last_name FROM user")
fun loadFullName(): List<NameTuple>


@Query("SELECT * FROM user WHERE first_name LIKE :search " +
       "OR last_name LIKE :search")
fun findUserWithName(search: String): List<User>


//For instance, your User class can include a field of type Address, which represents a composition
//of fields named street, city, state, and postCode. To store the composed columns separately in the
//table, include an Address field in the User class that is annotated with @Embedded, as shown in the
//following code snippet:
data class Address(
    val street: String?,
    val state: String?,
    val city: String?,
    @ColumnInfo(name = "post_code") val postCode: Int
)

@Entity
data class User(
    @PrimaryKey val id: Int,
    val firstName: String?,
    @Embedded val address: Address?
)
//The table representing a User object then contains columns with the following names: id,
firstName, street, state, city, and post_code.

//Finally, add a method to the DAO class that returns all instances of the data class that pairs the
//parent entity and the child entity. This method requires Room to run two queries, so add the
//@Transaction annotation to this method to ensure that the whole operation is performed atomically.
@Transaction
@Query("SELECT * FROM User")
fun getUsersAndLibraries(): List<UserAndLibrary>
 */
