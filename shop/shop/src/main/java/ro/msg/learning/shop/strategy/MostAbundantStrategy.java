package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.exception.StrategyNotApplicableException;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.ProductLocationQuantity;
import ro.msg.learning.shop.model.Stock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostAbundantStrategy implements IStrategy{
    @Override
    public List<ProductLocationQuantity> findStrategy(List<OrderDetail> orderDetails) {
       List<Stock> stocks = new ArrayList<>();
       List<ProductLocationQuantity> productLocationQuantities = new ArrayList<>();
        for (OrderDetail o : orderDetails
             ) {
            stocks.add(o.getProductorder().getStocks().stream().max(Comparator.comparing(Stock::getQuantity)).get());
            ProductLocationQuantity productLocationQuantity = new ProductLocationQuantity(o.getProductorder().getStocks().stream().max(Comparator.comparing(Stock::getQuantity)).get().getLocation(), o.getProductorder(), o.getQuantity());
            productLocationQuantities.add(productLocationQuantity);
        }
       if(!productLocationQuantities.isEmpty())
       {
           return productLocationQuantities;
       }
       else
       {
           throw new StrategyNotApplicableException("This order cannot be completed due to the strategy chosen!");
       }
    }
}
