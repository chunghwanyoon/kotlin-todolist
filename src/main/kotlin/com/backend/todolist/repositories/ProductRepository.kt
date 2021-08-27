package com.backend.todolist.repositories

import org.springframework.data.repository.CrudRepository

import com.backend.todolist.entities.Product

interface ProductRepository: CrudRepository<Product, Long> {
  fun findAllBy(): List<Product>
}