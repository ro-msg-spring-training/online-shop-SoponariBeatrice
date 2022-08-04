package ro.msg.learning.shop.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Supplier;

import java.math.BigDecimal;

@Component
public class ProductMapper {
    public ProductDto toProductDto(Product product) {
        String name = product.getName();
        Integer id = product.getId();
        Integer categoryId = product.getCategory().getId();
        Integer supplierId = product.getSupplier().getId();
        String description = product.getDescription();
        BigDecimal price = product.getPrice();
        Double weight = product.getWeight();
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

}
