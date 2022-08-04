package ro.msg.learning.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@IdClass(OrderDetailId.class)
@NoArgsConstructor
@Table(name = "ORDERDETAILS")
@AllArgsConstructor
public class OrderDetail{
    @Id
    private Integer orderid;
    @Id
    private Integer productid;
    @ManyToOne
    @JoinColumn(name="PRODUCTID")
    @MapsId("productid")
    Product productorder;
    @ManyToOne
    @JoinColumn(name="ORDERID")
    @MapsId("orderid")
    OrderE order;

    @Column(name = "QUANTITY")
    Integer quantity;

    public OrderDetail(Product productorder, OrderE order, Integer quantity) {
        this.productorder = productorder;
        this.order = order;
        this.quantity = quantity;
    }
}
