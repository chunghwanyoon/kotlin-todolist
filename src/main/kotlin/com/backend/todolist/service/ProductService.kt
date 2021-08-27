package com.backend.todolist.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

import com.backend.todolist.dto.CreateProductDTO
import com.backend.todolist.dto.ReadProductDTO
import com.backend.todolist.repositories.ProductRepository

@Component
class ProductService {

  @Autowired
  lateinit var productRepository: ProductRepository

  fun getProducts(): List<ReadProductDTO> {
    val products = productRepository.findAll()
    return products.map { it.toReadProductDTO() }
  }

  @Transactional
  fun createProduct(createProductDTO: CreateProductDTO): CreateProductDTO {
    val product = productRepository.save(createProductDTO.toEntity())
    return product.toCreateProductDTO()
  }
}
