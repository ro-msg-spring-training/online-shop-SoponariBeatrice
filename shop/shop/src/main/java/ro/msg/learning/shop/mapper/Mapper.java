package ro.msg.learning.shop;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.*;
import ro.msg.learning.shop.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public
class Mapper {
    public ProductDto toProductDto(Product product) {
        String name = product.getName();
        Integer id = product.getId();
        Integer categoryId = product.getCategory().getId();
        Integer supplierId = product.getSupplier().getId();
        String description = product.getDescription();
        BigDecimal price = product.getPrice();
        Double weight = product.getWeight();
        String categoryName = product.getCategory().getName();
        String categoryDescription = product.getCategory().getDescription();
        String supplierName = product.getSupplier().getName();
        String imageUrl = product.getImageUrl();
        ProductCategoryDto categoryDto = new ProductCategoryDto(categoryId, product.getCategory().getName(), product.getCategory().getDescription());
        SupplierDto supplierDto = new SupplierDto(supplierId, product.getSupplier().getName());
        return new ProductDto(id, categoryId, supplierId, name, description, price, weight, categoryDto, supplierDto, imageUrl);
    }

    public Product toProduct(ProductDto productDto) {
        ProductCategory productCategory = new ProductCategory(productDto.getCategory().getName(), productDto.getCategory().getDescription());
        productCategory.setId(productDto.getCategory().getId());

        Supplier supplier = new Supplier(productDto.getSupplier().getName());
        supplier.setId(productDto.getSupplier().getId());

        Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getPrice(), productDto.getWeight(), productCategory, supplier, productDto.getImageUrl());
        product.setId(productDto.getId());
        return product;
    }

   public OrderE toOrder(OrderDto orderDto)
   {
        return new OrderE(orderDto.getCreatedAt(), orderDto.getCity(), orderDto.getCountry(), orderDto.getStreet());

   }

}