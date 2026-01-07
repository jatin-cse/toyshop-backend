package com.toyshop.controller

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
}