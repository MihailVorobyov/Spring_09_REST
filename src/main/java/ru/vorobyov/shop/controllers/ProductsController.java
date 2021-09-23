package ru.vorobyov.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import ru.vorobyov.shop.entities.Product;
import ru.vorobyov.shop.service.ProductService;
import java.util.List;


@RestController
@RequestMapping
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	private List<Product> getAll() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").ascending());
		return productService.findAll(pageable).getContent();
	}
	
	//получение всех товаров
	@GetMapping("/product/{id}")
	private Product findById(@PathVariable(name = "id") String id) {
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").ascending());
		return productService.findById(Long.parseLong(id), pageable).getContent().get(0);
	}
}
