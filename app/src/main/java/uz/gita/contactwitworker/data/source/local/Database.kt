package uz.gita.contactwitworker.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.contactwitworker.data.source.local.dao.AppDao
import uz.gita.contactwitworker.data.source.local.entites.ContactEntity

@Database([ContactEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun provideDao(): AppDao
}