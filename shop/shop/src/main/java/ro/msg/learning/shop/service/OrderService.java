package ro.msg.learning.shop.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.StrategyNotApplicableException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.strategy.StrategyContext;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final StrategyContext strategyContext;

    public List<OrderDetail> createOrderDetailList(OrderE order, List<QuantityIdProduct> quantityIdProducts)
    {
        List<OrderDetail> orderDetails = new ArrayList<>();
        quantityIdProducts.stream().forEach(
                quantityIdProduct -> orderDetails.add(
                        new OrderDetail(productRepository.findById(quantityIdProduct.getId()).get(),order,quantityIdProduct.getQuantity())));

        return orderDetails;
    }
    @Override
    public OrderE saveOrder(OrderE order, List<QuantityIdProduct> quantityIdProducts) {
        List<OrderDetail> orderDetails = createOrderDetailList(order, quantityIdProducts);
       try{
           strategyContext.getStrategy().findStrategy(orderDetails);
           return repository.save(order);
       }catch (StrategyNotApplicableException e){
           System.out.println(e.getMessage());
       }
       return null;
    }

}
