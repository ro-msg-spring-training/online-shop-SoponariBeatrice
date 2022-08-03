package ro.msg.learning.shop.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@Data
@Entity
@Table(name="Stock")
@IdClass(StockId.class)
@EqualsAndHashCode(exclude = "product")
public class Stock{
    @Id
    private Integer productid;
    @Id
    private Integer locationid;
    @ManyToOne
    @JoinColumn(name="PRODUCTID")
    @MapsId("productid")
    Product product;
    @ManyToOne
    @JoinColumn(name="LOCATIONID")
    @MapsId("locationid")
    Location location;

    Integer quantity;
}
