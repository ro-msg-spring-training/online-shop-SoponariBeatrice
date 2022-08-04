package ro.msg.learning.shop;

import org.assertj.core.api.AbstractAssert;
import ro.msg.learning.shop.model.OrderE;

public class OrderAssert extends AbstractAssert<OrderAssert, OrderE> {

    protected OrderAssert(OrderE orderE) {
        super(orderE, OrderAssert.class);
    }

    static OrderAssert assertThat(OrderE actual)
    {
        return new OrderAssert(actual);
    }

    OrderAssert hasOrderDetails(){
        isNotNull();
        if(actual.getOrderDetails() == null)
        {
            failWithMessage("Expected order to have details but they are null!");
        }
        return this;
    }
}
