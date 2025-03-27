package com.dhivya.eshop.rest.api.service.impl;

import com.dhivya.eshop.rest.api.entity.Category;
import com.dhivya.eshop.rest.api.entity.Product;
import com.dhivya.eshop.rest.api.repository.CategoryRepository;
import com.dhivya.eshop.rest.api.repository.ProductRepository;
import com.dhivya.eshop.rest.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product;
    }

    @Override
    public Product saveProduct(Long categoryId, Product newProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long categoryId, Long productId, Product updateProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if(!product.getCategory().getId().equals(categoryId)){
            throw new RuntimeException("Category and product not belong to each other");
        }
        product.setName(updateProduct.getName());
        product.setImage(updateProduct.getImage());
        product.setPrice(updateProduct.getPrice());
        product.setDescription(updateProduct.getDescription());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long categoryId, Long productId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if(!product.getCategory().getId().equals(categoryId)){
            throw new RuntimeException("Category and product not belong to each other");
        }
        productRepository.deleteById(productId);
    }


}
