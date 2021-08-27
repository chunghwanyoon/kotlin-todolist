package com.backend.todolist.entities

import java.time.OffsetDateTime
import javax.persistence.*

import com.backend.todolist.dto.ReadProductDTO
import com.backend.todolist.dto.CreateProductDTO

enum class Category {
    Phone, Laptop, Keyboard
}

@Entity
data class Product (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    @Enumerated(EnumType.STRING)
    val category: Category,

    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime? = null
) {
    fun toReadProductDTO(): ReadProductDTO {
        return ReadProductDTO(
            id = id,
            name = name,
            category = category
        )
    }

    fun toCreateProductDTO(): CreateProductDTO {
        return CreateProductDTO(
            name = name,
            category = category
        )
    }
}
