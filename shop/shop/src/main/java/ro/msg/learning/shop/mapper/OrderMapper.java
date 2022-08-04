package ro.msg.learning.shop.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.model.OrderE;

@Component
public class OrderMapper {
    public OrderE toOrder(OrderDto orderDto)
    {
        return new OrderE(orderDto.getCreatedAt(), orderDto.getCity(), orderDto.getCountry(), orderDto.getStreet());

    }
}
