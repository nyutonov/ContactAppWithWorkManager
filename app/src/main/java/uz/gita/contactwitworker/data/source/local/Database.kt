package uz.gita.contactwitworker.data.source.local

import androidx.room.RoomDatabase
import uz.gita.contactwitworker.data.source.local.dao.AppDao

abstract class Database : RoomDatabase() {
    abstract fun provideDao(): AppDao
}