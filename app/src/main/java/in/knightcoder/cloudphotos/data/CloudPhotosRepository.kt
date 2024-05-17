package `in`.knightcoder.cloudphotos.data

import `in`.knightcoder.cloudphotos.model.CloudPhoto
import `in`.knightcoder.cloudphotos.network.CloudApiService

interface CloudPhotosRepository {
    suspend fun getCloudPhotos(): List<CloudPhoto>
}

class NetworkCloudPhotosRepository(
    private val cloudApiService: CloudApiService
) : CloudPhotosRepository {

    override suspend fun getCloudPhotos(): List<CloudPhoto> = cloudApiService.getPhotos()

}