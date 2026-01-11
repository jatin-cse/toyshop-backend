package com.toyshop.service

import com.toyshop.model.Toy
import com.toyshop.repository.ToyRepository
import org.springframework.stereotype.Service

@Service
class ToyService(
    private val toyRepository: ToyRepository
) {

    fun getAllToys(): List<Toy> {
        return toyRepository.findAll()
    }

    fun addToy(toy: Toy): Toy {
        return toyRepository.save(toy)
    }
}
