package uz.gita.contactwitworker.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import uz.gita.contactwitworker.data.source.local.entites.ContactEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContacts(contactEntity: ContactEntity)

    @Delete
    fun deleteContacts(contactEntity: ContactEntity)

    @Update
    fun updateContacts(contactEntity: ContactEntity)

    @Query("select * from contact where isAddedToApi = 0")
    fun getNotUploadedContacts(): Flow<List<ContactEntity>>

    @Query("select * from contact where isDeleted = 1")
    fun getDeletedContacts(): Flow<List<ContactEntity>>

    @Query("select * from contact where isUpdated = 0")
    fun getUpdatedContacts(): Flow<List<ContactEntity>>

    @Query("select * from contact where isDeleted = 0")
    fun getAllContacts(): Flow<List<ContactEntity>>
}