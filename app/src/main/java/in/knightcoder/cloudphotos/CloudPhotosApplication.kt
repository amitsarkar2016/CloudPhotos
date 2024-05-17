package `in`.knightcoder.cloudphotos

import android.app.Application
import `in`.knightcoder.cloudphotos.data.AppContainer
import `in`.knightcoder.cloudphotos.data.DefaultAppContainer

class CloudPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()

    }
}