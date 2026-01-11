package com.toyshop.model

import jakarta.persistence.*

@Entity
@Table(name = "toy")
data class Toy(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String = "",

    var price: Double = 0.0,

    var category: String = ""
)
