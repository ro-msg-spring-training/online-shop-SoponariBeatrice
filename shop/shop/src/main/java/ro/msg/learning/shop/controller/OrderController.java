package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Mapper;
import ro.msg.learning.shop.dto.OrderDto;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.OrderE;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService service;

    Mapper mapper = new Mapper();
    @PostMapping("/add-order")
    @ResponseBody
    public OrderE saveOrder(@RequestBody OrderDto orderDto)
    {
        return service.saveOrder(mapper.toOrder(orderDto), orderDto.getProducts());
    }
}
