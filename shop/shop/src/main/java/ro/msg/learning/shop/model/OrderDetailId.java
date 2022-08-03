package ro.msg.learning.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class OrderDetailId implements Serializable {
    private Integer orderid;
    private Integer productid;

    public OrderDetailId(Integer orderId, Integer productId) {
        this.orderid = orderId;
        this.productid = productId;
    }
}
