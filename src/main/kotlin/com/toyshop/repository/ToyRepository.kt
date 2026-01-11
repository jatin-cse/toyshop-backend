package com.toyshop.repository

import com.toyshop.model.Toy
import org.springframework.data.jpa.repository.JpaRepository

interface ToyRepository : JpaRepository<Toy, Long>
