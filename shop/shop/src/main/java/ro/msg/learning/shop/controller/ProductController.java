package ro.msg.learning.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.IProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService service;
    private Mapper mapper = new Mapper();
    @PostMapping("/add-product")
    @ResponseBody
    public Product saveProduct(@RequestBody ProductDto productDto)
    {
        Product product = mapper.toProduct(productDto);
        return service.saveProduct(product);
    }

    @GetMapping("/get-products")
    @ResponseBody
    public List<ProductDto> getProducts()
    {
        return service.getProducts().stream().map(mapper::toDto).toList();
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
        service.deleteProduct(id);
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Integer id)
    {
        return service.findById(id).map(product -> mapper.toDto(product));
    }

    @PutMapping("/update-product")
    @ResponseBody
    public Optional<ProductDto> updateProduct(@RequestBody ProductDto productDto)
    {
        return service.updateProduct(mapper.toProduct(productDto)).map(product -> mapper.toDto(product));
    }

}
