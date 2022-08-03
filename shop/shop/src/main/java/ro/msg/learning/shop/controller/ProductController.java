package ro.msg.learning.shop.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.mapper.Mapper;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.IProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;
    private final Mapper mapper;
    @PostMapping("/products")
    @ResponseBody
    public Product saveProduct(@RequestBody ProductDto productDto)
    {
        Product product = mapper.toProduct(productDto);
        return service.saveProduct(product);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductDto> getProducts()
    {
        return service.getProducts().stream().map(mapper::toDto).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
        service.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Integer id)
    {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Optional<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto)
    {
        return service.updateProduct(id,mapper.toProduct(productDto)).map(mapper::toDto);
    }

}
