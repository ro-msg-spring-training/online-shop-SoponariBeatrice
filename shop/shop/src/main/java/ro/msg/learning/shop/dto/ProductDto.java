package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    Integer id;
    Integer categoryId;
    Integer supplierId;
    String name;
    String description;
    BigDecimal price;
    Double weight;
    ProductCategoryDto category;
    SupplierDto supplier;
    String imageUrl;


}
