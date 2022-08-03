package ro.msg.learning.shop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.ProductDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name="Product")
@NoArgsConstructor
public class Product extends BaseEntity {
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnore
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    @JsonIgnore
    private Supplier supplier;
    private String imageUrl;
    @OneToMany(mappedBy = "product")
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "productorder")
    private Set<OrderDetail> orderDetails;

    public Product(String name, String description, BigDecimal price, Double weight, ProductCategory category, Supplier supplier, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.supplier = supplier;
        this.imageUrl = imageUrl;
        this.stocks = stocks;
        this.orderDetails = orderDetails;
    }
    public Product(ProductDto productDto, ProductCategory category, Supplier supplier)
    {
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.weight = productDto.getWeight();
        this.category = category;
        this.supplier = supplier;
        this.imageUrl = productDto.getImageUrl();

    }
}
