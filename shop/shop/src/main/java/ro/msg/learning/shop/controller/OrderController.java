package ro.msg.learning.shop.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.mapper.OrderMapper;
import ro.msg.learning.shop.model.OrderE;
import ro.msg.learning.shop.service.IOrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService service;
    private final OrderMapper mapper;
    @PostMapping("/order")
    @ResponseBody
    public OrderE saveOrder(@RequestBody OrderDto orderDto)
    {
        return service.saveOrder(mapper.toOrder(orderDto), orderDto.getProducts());
    }
}
