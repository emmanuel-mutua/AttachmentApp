package com.emmutua.attachmentapp.di

import android.content.Context
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.emmutua.attachmentapp.connectivity.NetworkConnectivityObserver
import com.emmutua.attachmentapp.data.repository.AuthAuthRepositoryImpl
import com.emmutua.attachmentapp.data.repository.AuthRepository
import com.emmutua.attachmentapp.data.repository.StorageService
import com.emmutua.attachmentapp.data.repository.StorageServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    @Singleton
    @Provides
    fun provideAuthRepo(): AuthRepository = AuthAuthRepositoryImpl(auth = Firebase.auth)

    @Provides
    @Singleton
    fun provideFirebaseFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideStorageService(db: FirebaseFirestore): StorageService = StorageServiceImpl(db)

    @Singleton
    @Provides
    fun provideNetworkConnectivityObserver(
        @ApplicationContext context: Context
    ) = NetworkConnectivityObserver(context = context)
}
