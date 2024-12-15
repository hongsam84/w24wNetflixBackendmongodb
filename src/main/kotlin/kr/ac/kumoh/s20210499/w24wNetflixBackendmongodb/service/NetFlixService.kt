package kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.service

import kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.model.NetflixList
import kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.repository.NetFlixRepository
import org.springframework.stereotype.Service

@Service
class NetFlixService(private val repository: NetFlixRepository) {
    fun addSong(Netflixlist: NetflixList): NetflixList = repository.save(Netflixlist)

    fun getAllList(): List<NetflixList> = repository.findAll()
    fun getNetflixById(id: String): NetflixList? = repository.findById(id).orElse(null)
    fun getNetflixByName(name: String): List<NetflixList> = repository.findByName(name)

    fun updateSong(id: String, netflixList: NetflixList): NetflixList? {
        val NetflixListTarget = repository.findById(id)

        return if (NetflixListTarget.isPresent) {
            val oldSong = NetflixListTarget.get()
            val updatedSong = oldSong.copy(
                name = netflixList.name ,
                rating = netflixList.rating,
                story = netflixList.story,
                image_url = netflixList.image_url
            )
            repository.save(updatedSong)
        } else {
            null
        }
    }

    fun deleteList(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}