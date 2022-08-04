package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.exception.StrategyNotApplicableException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.ProductLocationQuantity;
import ro.msg.learning.shop.model.Stock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostAbundantStrategy implements IStrategy{
    @Override
    public List<ProductLocationQuantity> findStrategy(List<OrderDetail> orderDetails) {
        List<Location> possibleLocations = new ArrayList<>();
        List<Location> finalLocations = new ArrayList<>();
        orderDetails.forEach(orderDetail -> orderDetail.getProductorder().getStocks().stream()
                .filter(stock -> stock.getQuantity() >= orderDetail.getQuantity()).forEach( stock -> possibleLocations.add(stock.getLocation())));

            System.out.println(possibleLocations);
            possibleLocations.forEach(location -> finalLocations.add(location.getStocks().stream().max(Comparator.comparing(Stock::getQuantity)).get().getLocation()));

        int index = 0;
        List<ProductLocationQuantity> productLocationQuantities = new ArrayList<>();
        if(finalLocations.size() == orderDetails.size())
        {
            for (OrderDetail o : orderDetails
            ) {
                ProductLocationQuantity productLocationQuantity = new ProductLocationQuantity(finalLocations.get(index), o.getProductorder(), o.getQuantity());
                productLocationQuantities.add(productLocationQuantity);
                index++;
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
        else
        {
            throw new StrategyNotApplicableException("This order cannot be completed due to the strategy chosen!");
        }


    }
}
