package `in`.knightcoder.cloudphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import `in`.knightcoder.cloudphotos.ui.CloudPhotosApp
import `in`.knightcoder.cloudphotos.ui.theme.CloudPhotosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CloudPhotosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CloudPhotosApp()
                }
            }
        }
    }
}
