package `in`.knightcoder.cloudphotos.network

import `in`.knightcoder.cloudphotos.model.CloudPhoto
import retrofit2.http.GET

interface CloudApiService {
    @GET("photos")
    suspend fun getPhotos(): List<CloudPhoto>
}
