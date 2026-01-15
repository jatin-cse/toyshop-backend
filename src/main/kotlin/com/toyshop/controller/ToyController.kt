package com.toyshop.controller

import com.toyshop.model.Toy
import com.toyshop.repository.ToyRepository
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/toys")
class ToyController(
    private val toyRepository: ToyRepository
) {

    // ✅ GET all toys
    @GetMapping
    fun getAllToys(): List<Toy> =
        toyRepository.findAll()

    // ✅ ADD new toy
    @PostMapping
    fun addToy(@Valid @RequestBody toy: Toy): Toy =
        toyRepository.save(toy)

    // ✅ UPDATE toy
    @PutMapping("/{id}")
    fun updateToy(
        @PathVariable id: Long,
        @Valid @RequestBody toy: Toy
    ): Toy {

        val existingToy = toyRepository.findById(id)
            .orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND, "Toy not found")
            }

        val updatedToy = existingToy.copy(
            name = toy.name,
            price = toy.price,
            category = toy.category
        )

        return toyRepository.save(updatedToy)
    }

    // ✅ DELETE toy
    @DeleteMapping("/{id}")
    fun deleteToy(@PathVariable id: Long) {

        if (!toyRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Toy not found")
        }

        toyRepository.deleteById(id)
    }
}
