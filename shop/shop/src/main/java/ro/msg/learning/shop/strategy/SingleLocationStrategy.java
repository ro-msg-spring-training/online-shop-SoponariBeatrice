package ro.msg.learning.shop.strategy;
import ro.msg.learning.shop.exception.StrategyNotApplicableException;
import ro.msg.learning.shop.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SingleLocationStrategy implements IStrategy{
    @Override
    public List<ProductLocationQuantity> findStrategy(List<OrderDetail> orderDetails) {
        HashMap<Product, Location> locations = new HashMap<>();
        Location location = new Location();
        orderDetails.stream().forEach(orderDetail ->
           orderDetail.getProductorder().getStocks().stream().filter(stock -> stock.getQuantity() >= orderDetail.getQuantity())
                   .forEach( st -> locations.put( orderDetail.getProductorder(), st.getLocation())));

        boolean flag = false;
        for (OrderDetail o : orderDetails
             ) {
            flag = true;
            if(locations.get(o.getProductorder()) != null)
            {
                location = locations.get(o.getProductorder());
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag)
        {

           List<ProductLocationQuantity> productLocationQuantity = new ArrayList<>();
           for (OrderDetail o : orderDetails
           ) {
               productLocationQuantity.add(new ProductLocationQuantity(location, o.getProductorder(), o.getQuantity()));
           }
           return productLocationQuantity;
        }
        else
        {
           throw new StrategyNotApplicableException("Can't complete order because of the strategy used!");
       }

    }
}
