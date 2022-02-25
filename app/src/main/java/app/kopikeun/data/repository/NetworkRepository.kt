package app.kopikeun.data.repository

import android.content.Context
import app.kopikeun.common.Constant
import app.kopikeun.data.remote.KopikeunApi
import coil.ImageLoader
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkRepository(
    context: Context,
    okHttpClient: OkHttpClient,
) {
    val api: KopikeunApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(KopikeunApi::class.java)

    val imageLoader = ImageLoader.Builder(context)
        .okHttpClient(okHttpClient)
        .build()
}