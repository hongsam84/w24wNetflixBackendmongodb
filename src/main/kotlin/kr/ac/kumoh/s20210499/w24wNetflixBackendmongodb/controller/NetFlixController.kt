package kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.controller

import kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.model.NetflixList
import kr.ac.kumoh.s20210499.w24wNetflixBackendmongodb.service.NetFlixService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/netflixlist")
@CrossOrigin(origins = ["https://20210499hwnetlist.netlify.app"])
class NetFlixController(private val service: NetFlixService) {
    @PostMapping
    fun addSong(@RequestBody netflix: NetflixList): NetflixList = service.addSong(netflix)

    @GetMapping
    fun getAllList(): List<NetflixList> = service.getAllList();

    @GetMapping("/{id}")
    fun getNetflixById(@PathVariable id: String): NetflixList? = service.getNetflixById(id)

    @GetMapping("/name/{name}")
    fun getNetflixByName(@PathVariable name: String): List<NetflixList> = service.getNetflixByName(name)

    @PutMapping("/{id}")
    fun updateNetflix(@PathVariable id: String, @RequestBody NetflixDetails: NetflixList): NetflixList? =  service.updateSong(id, NetflixDetails)

    @DeleteMapping("/{id}")
    fun deleteSong(@PathVariable id: String): Map<String, String> {
        return if (service.deleteList(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}