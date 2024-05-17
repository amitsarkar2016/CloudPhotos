package `in`.knightcoder.cloudphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import `in`.knightcoder.cloudphotos.CloudPhotosApplication
import `in`.knightcoder.cloudphotos.data.CloudPhotosRepository
import `in`.knightcoder.cloudphotos.model.CloudPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CloudUiState {
    data class Success(val photos: List<CloudPhoto>) : CloudUiState
    object Error : CloudUiState
    object Loading : CloudUiState
}

class CloudViewModel(private val cloudPhotosRepository: CloudPhotosRepository) : ViewModel() {
    var cloudUiState: CloudUiState by mutableStateOf(CloudUiState.Loading)
        private set


    init {
        getCloudPhotos()
    }

    private fun getCloudPhotos() {
        viewModelScope.launch {
            cloudUiState = CloudUiState.Loading
            cloudUiState = try {
                val listResult = cloudPhotosRepository.getCloudPhotos()
                CloudUiState.Success(listResult)
            } catch (e: IOException) {
                CloudUiState.Error
            } catch (e: HttpException) {
                CloudUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CloudPhotosApplication)
                val cloudPhotosRepository = application.container.cloudPhotosRepository
                CloudViewModel(cloudPhotosRepository = cloudPhotosRepository)
            }
        }
    }
}
