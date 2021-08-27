package com.backend.todolist.controller

import com.backend.todolist.dto.CreateProductDTO
import com.backend.todolist.service.ProductService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductController {
  @Autowired
  private lateinit var productService: ProductService

  @GetMapping("/products", produces = ["application/json"])
  fun getProducts(): ResponseEntity<Any> {
    val products = productService.getProducts()
    return ResponseEntity.ok().body(products)
  }

  @PostMapping("/product")
  fun createProduct(@RequestBody params: CreateProductDTO): ResponseEntity<Any> {
    val product = productService.createProduct(params)
    return ResponseEntity.ok().body(product)
  }
}
