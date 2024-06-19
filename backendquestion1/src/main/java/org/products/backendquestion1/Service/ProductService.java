package org.products.backendquestion1.Service;

import org.products.backendquestion1.Model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final RestTemplate restTemplate;


    @Value("${external.api.url}")
    private String externalApiUrl;

    @Value("${auth.token}")
    private String authToken;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getSortedProducts(String category, String sortBy, int top, int minPrice, int maxPrice) {
        String url = externalApiUrl + "/test/companies/AMZ/categories/" + category + "/products" +
                "?sortBy=" + sortBy +
                "&top=" + top +
                "&minPrice=" + minPrice +
                "&maxPrice=" + maxPrice;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Product[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Product[].class);
        Product[] products = response.getBody();

        if (products != null) {
            return Arrays.asList(products);
        }
        return List.of();
    }

    public Product getProductDetails(String category, String productId) {
        String url = externalApiUrl + "/test/companies/AMZ/categories/" + category + "/products/" + productId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.GET, entity, Product.class);
        return response.getBody();
    }
}
