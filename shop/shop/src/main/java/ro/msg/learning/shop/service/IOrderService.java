package ro.msg.learning.shop.service;
import ro.msg.learning.shop.model.OrderE;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.QuantityIdProduct;

import java.util.List;

public interface IOrderService {
    OrderE saveOrder(OrderE order, List<QuantityIdProduct> orderDetails);
}
