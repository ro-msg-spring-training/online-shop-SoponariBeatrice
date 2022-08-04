package ro.msg.learning.shop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name="Stock")
@IdClass(StockId.class)
@EqualsAndHashCode(exclude = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Stock{
    @Id
    private Integer productid;
    @Id
    private Integer locationid;
    @ManyToOne
    @JoinColumn(name="PRODUCTID")
    @MapsId("productid")
    private Product product;
    @ManyToOne
    @JoinColumn(name="LOCATIONID")
    @MapsId("locationid")
    private Location location;

    private Integer quantity;
}
