package app.kopikeun.di

import android.content.Context
import app.kopikeun.data.repository.NetworkRepository
import coil.util.CoilUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideNetworkRepository(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient,
    ): NetworkRepository {
        return NetworkRepository(
            context = context,
            okHttpClient = okHttpClient,
        )
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(CoilUtils.createDefaultCache(context))
            .build()
    }
}