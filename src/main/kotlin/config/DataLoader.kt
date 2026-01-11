package com.toyshop.config

import com.toyshop.model.Toy
import com.toyshop.repository.ToyRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader {

    @Bean
    fun loadData(toyRepository: ToyRepository) = CommandLineRunner {

        if (toyRepository.count() == 0L) {
            toyRepository.saveAll(
                listOf(
                    Toy(name = "Teddy Bear", price = 499.0, category = "Soft Toy"),
                    Toy(name = "Toy Car", price = 299.0, category = "Vehicle"),
                    Toy(name = "Lego Set", price = 1299.0, category = "Blocks")
                )
            )
        }
    }
}
