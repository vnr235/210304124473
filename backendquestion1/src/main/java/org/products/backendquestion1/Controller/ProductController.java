package org.products.backendquestion1.Controller;

import org.products.backendquestion1.Model.Product;
import org.products.backendquestion1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories/{categoryName}/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getSortedProducts(
            @PathVariable String categoryName,
            @RequestParam(required = false, defaultValue = "price") String sortBy,
            @RequestParam(required = false, defaultValue = "10") int top,
            @RequestParam(required = false, defaultValue = "1") int minPrice,
            @RequestParam(required = false, defaultValue = "10000") int maxPrice) {
        return productService.getSortedProducts(categoryName, sortBy, top, minPrice, maxPrice);
    }

    @GetMapping("/{productId}")
    public Product getProductDetails(
            @PathVariable String categoryName,
            @PathVariable String productId) {
        return productService.getProductDetails(categoryName, productId);
    }
}
