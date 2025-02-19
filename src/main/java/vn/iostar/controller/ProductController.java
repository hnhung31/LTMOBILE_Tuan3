package vn.iostar.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import vn.iostar.entity.Category;
import vn.iostar.entity.Product;
import vn.iostar.repository.CategoryRepo;
import vn.iostar.service.ProductService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

	private final CategoryRepo categoryRepository;
    private final ProductService productService;
    
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @GetMapping("/categories/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    @GetMapping("/products/top-selling")
    public ResponseEntity<List<Product>> getTopSellingProducts() {
        return ResponseEntity.ok(productService.getTop10BestSellingProducts());
    }

    @GetMapping("/products/recent")
    public ResponseEntity<List<Product>> getRecentProducts() {
        return ResponseEntity.ok(productService.getTop10LatestProducts());
    }
}
