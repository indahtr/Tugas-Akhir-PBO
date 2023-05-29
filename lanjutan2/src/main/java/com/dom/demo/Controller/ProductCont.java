package com.dom.demo.Controller;

import com.dom.demo.ErorrHandler.NotFound;
import com.dom.demo.model.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.demo.repository.ProductsRepo;

@RestController
@RequestMapping("/api")
public class ProductCont {
    
    @Autowired
    ProductsRepo productsRepository;

    @GetMapping("/Products")
    public List<Products> getAll(){
        return productsRepository.findAll();
    }

    @PostMapping("/Products")
    public Products insertProducts(@Validated @RequestBody Products products){
        return productsRepository.save(products);
    }

    @GetMapping("/Products/{id}")
    public Products getProducts(@PathVariable(value="id") int id){
        return productsRepository.findById(id).orElseThrow(()-> new NotFound("Products", "id", id));
    }

    @PutMapping("/Products/{id}")
    public Products updatProducts(@PathVariable(value="id") int id, @Validated @RequestBody Products productDetail){
        Products products = productsRepository.findById(id).orElseThrow(()-> new NotFound("Products", "id", id));
        products.setId(productDetail.getId());
        products.setSeller(productDetail.getSeller());
        products.setTitle(productDetail.getTitle());
        products.setDescription(productDetail.getDescription());
        products.setPrice(productDetail.getPrice());
        products.setStock(productDetail.getStock());
        Products updateProducts = productsRepository.save(products);
        return updateProducts;
    }

    @DeleteMapping("/Products/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable(value="id") int id){
        Products products = productsRepository.findById(id).orElseThrow(()-> new NotFound("Products", "id", id));
        productsRepository.delete(products);
        return ResponseEntity.ok().build();
    }
}
