package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private Integer categoryId;
    private Integer supplierId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private ProductCategoryDto category;
    private SupplierDto supplier;
    private String imageUrl;


}
