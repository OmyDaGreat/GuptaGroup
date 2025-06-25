package xyz.malefic.gupta

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
@JsonIgnoreUnknownKeys
@OptIn(ExperimentalSerializationApi::class)
data class BlogPost(
    val id: String,
    val title: String,
    val date: String,
    val image: String,
    val summary: String,
    val text: String,
)
