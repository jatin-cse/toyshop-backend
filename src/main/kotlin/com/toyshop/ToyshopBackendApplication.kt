package com.toyshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyshopBackendApplication

fun main(args: Array<String>) {
    runApplication<ToyshopBackendApplication>(*args)
}
