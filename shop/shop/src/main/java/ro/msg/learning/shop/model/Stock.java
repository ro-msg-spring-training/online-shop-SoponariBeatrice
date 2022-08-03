package ro.msg.learning.shop.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@IdClass(StockId.class)
public class Stock{
    @Id
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Id
    @Column(name = "LOCATIONID")
    private Integer locationid;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Location location;

    private Integer quantity;
}
