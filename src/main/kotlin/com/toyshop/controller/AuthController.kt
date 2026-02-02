package com.toyshop.controller

import com.toyshop.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val userRepository: UserRepository
) {

    data class LoginRequest(
        val email: String,
        val password: String
    )

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): Map<String, String> {
        val user = userRepository.findByEmail(request.email)
            ?: throw RuntimeException("User not found")

        if (user.password != request.password) {
            throw RuntimeException("Invalid password")
        }

        return mapOf("message" to "Login successful")
    }
}
