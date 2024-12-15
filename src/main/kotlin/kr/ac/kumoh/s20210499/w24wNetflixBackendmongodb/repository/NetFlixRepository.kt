package kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.repository

import kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.model.NetflixList
import org.springframework.data.mongodb.repository.MongoRepository

interface NetFlixRepository :  MongoRepository<NetflixList, String> {
    fun findByName(name: String): List<NetflixList>
}