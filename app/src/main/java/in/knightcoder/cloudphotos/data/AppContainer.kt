package `in`.knightcoder.cloudphotos.data

import `in`.knightcoder.cloudphotos.network.CloudApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val cloudPhotosRepository: CloudPhotosRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val retrofitService: CloudApiService by lazy {
        retrofit.create(CloudApiService::class.java)
    }

    override val cloudPhotosRepository: CloudPhotosRepository by lazy {
        NetworkCloudPhotosRepository(retrofitService)
    }

}