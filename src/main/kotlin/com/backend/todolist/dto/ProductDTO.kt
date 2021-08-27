package com.backend.todolist.dto

import java.time.OffsetDateTime
import com.backend.todolist.entities.Category
import com.backend.todolist.entities.Product

data class ReadProductDTO (
  val id: Long? = null,
  val name: String,
  val category: Category
  )

data class CreateProductDTO (
  val name: String,
  val category: Category
  ) {
  fun toEntity(): Product {
    return Product(
      name = name,
      category = category
    )
  }
}