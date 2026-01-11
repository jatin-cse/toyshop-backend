package com.toyshop.controller

import com.toyshop.model.Toy
import com.toyshop.repository.ToyRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/toys")
class ToyController(
    private val toyRepository: ToyRepository
) {

    @GetMapping
    fun getAllToys(): List<Toy> =
        toyRepository.findAll()

    @PostMapping
    fun addToy(@RequestBody toy: Toy): Toy =
        toyRepository.save(toy)
}
