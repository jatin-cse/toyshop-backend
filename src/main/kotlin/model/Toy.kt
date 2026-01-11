package com.toyshop.model

import jakarta.persistence.*

@Entity
@Table(name = "toy")
data class Toy(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val price: Double,

    val category: String
)
