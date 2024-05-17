package `in`.knightcoder.cloudphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CloudPhoto(
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
