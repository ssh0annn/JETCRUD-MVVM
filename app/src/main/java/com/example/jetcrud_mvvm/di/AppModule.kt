package com.example.jetcrud_mvvm.di

import android.app.Application
import androidx.room.Room
import com.example.jetcrud_mvvm.feature_user.data.data_source.local.UserDatabase
import com.example.jetcrud_mvvm.feature_user.data.repository.UserRepositoryImpl
import com.example.jetcrud_mvvm.feature_user.domain.repository.UserRepository

import com.example.jetcrud_mvvm.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db:UserDatabase):UserRepository{
        return UserRepositoryImpl(db.usedao)
    }

}