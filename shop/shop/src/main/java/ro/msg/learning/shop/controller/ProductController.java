package ro.msg.learning.shop.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.mapper.ProductMapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.IProductService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;
    private final ProductMapper mapper;
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
        return service.getProducts().stream().map(mapper::toProductDto).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id)
    {
        service.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable Integer id)
    {
        return service.findById(id).map(mapper::toProductDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Optional<ProductDto> updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto)
    {
        return service.updateProduct(id,mapper.toProduct(productDto)).map(mapper::toProductDto);
    }

}
