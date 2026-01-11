package com.toyshop.controller

import com.toyshop.model.Toy
import com.toyshop.repository.ToyRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/toys")
class ToyController(
    private val toyRepository: ToyRepository
) {

    // ✅ GET all toys
    @GetMapping
    fun getAllToys(): List<Toy> {
        return toyRepository.findAll()
    }

    // ✅ ADD new toy
    @PostMapping
    fun addToy(@RequestBody toy: Toy): Toy {
        return toyRepository.save(toy)
    }

    // ✅ UPDATE toy
    @PutMapping("/{id}")
    fun updateToy(
        @PathVariable id: Long,
        @RequestBody toy: Toy
    ): Toy {

        val existingToy = toyRepository.findById(id)
            .orElseThrow { RuntimeException("Toy not found") }

        val updatedToy = existingToy.copy(
            name = toy.name,
            price = toy.price,
            category = toy.category
        )

        return toyRepository.save(updatedToy)
    }

    // ✅ DELETE toy
    @DeleteMapping("/{id}")
    fun deleteToy(@PathVariable id: Long): String {

        if (!toyRepository.existsById(id)) {
            throw RuntimeException("Toy not found")
        }

        toyRepository.deleteById(id)
        return "Toy deleted successfully"
    }
}
