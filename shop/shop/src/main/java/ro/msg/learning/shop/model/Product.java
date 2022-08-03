package ro.msg.learning.shop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name="Product")
@EqualsAndHashCode(exclude = "category")
@ToString(exclude = {"stocks", "orderDetails"})
public class Product extends BaseEntity {
    String name;
    String description;
    BigDecimal price;
    Double weight;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnore
    ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    @JsonIgnore
    Supplier supplier;
    String imageUrl;
    @OneToMany(mappedBy = "product")
    Set<Stock> stocks;

    @OneToMany(mappedBy = "productorder")
    Set<OrderDetail> orderDetails;

    public Product() {
    }

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
}
