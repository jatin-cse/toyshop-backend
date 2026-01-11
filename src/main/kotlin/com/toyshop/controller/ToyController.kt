package com.toyshop.controller

import com.toyshop.model.Toy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ToyController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Toy Shop Backend is running 🚀"
    }

    @GetMapping("/toys")
    fun getToys(): List<Toy> {
        return listOf(
            Toy(1, "Teddy Bear", 499.0, "Soft Toy"),
            Toy(2, "Toy Car", 299.0, "Vehicle"),
            Toy(3, "Lego Set", 1299.0, "Blocks")
        )
    }
}
