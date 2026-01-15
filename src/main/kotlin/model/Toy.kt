package com.toyshop.model

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

@Entity
data class Toy(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:Min(value = 1, message = "Price must be greater than 0")
    val price: Double,

    @field:NotBlank(message = "Category is required")
    val category: String
)
