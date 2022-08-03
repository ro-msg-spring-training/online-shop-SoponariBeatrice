package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.ProductLocationQuantity;
import ro.msg.learning.shop.model.QuantityIdProduct;

import java.util.List;

public interface IStrategy {
    List<ProductLocationQuantity> findStrategy(List<OrderDetail> orderDetails);

}
