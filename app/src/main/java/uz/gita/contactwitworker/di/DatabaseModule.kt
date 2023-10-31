package uz.gita.contactwitworker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.contactwitworker.data.source.local.Database
import uz.gita.contactwitworker.data.source.local.dao.AppDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun databaseProvider(@ApplicationContext context: Context): Database = Room
        .databaseBuilder(context, Database::class.java, "contacts.db")
        .build()

    @Provides
    fun daoProvider(database: Database): AppDao = database.provideDao()
}