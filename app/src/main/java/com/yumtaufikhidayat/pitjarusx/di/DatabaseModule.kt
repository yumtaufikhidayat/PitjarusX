package com.yumtaufikhidayat.pitjarusx.di

import android.content.Context
import androidx.room.Room
import com.yumtaufikhidayat.pitjarusx.data.local.PitjarusXDatabase
import com.yumtaufikhidayat.pitjarusx.utils.Common
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, PitjarusXDatabase::class.java, Common.DB_NAME
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideDao(db: PitjarusXDatabase) = db.getLoginDao()
}