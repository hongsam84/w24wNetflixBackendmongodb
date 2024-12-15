package kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "netflixlist")
data class NetflixList(
    @Id
    val id: String? = null,
    val name: String,
    val rating: Int,
    val story: String,
    val image_url: String
)
