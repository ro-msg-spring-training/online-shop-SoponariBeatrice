package ro.msg.learning.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@Data
@IdClass(OrderDetailId.class)
public class OrderDetail{
    @Id
    private Integer orderid;
    @Id
    private Integer productid;
    @ManyToOne
    private Product productorder;
    @ManyToOne
    private Order order;

    private Integer quantity;
}
