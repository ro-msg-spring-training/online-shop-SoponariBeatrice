package ro.msg.learning.shop;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.msg.learning.shop.exception.StrategyNotApplicableException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.strategy.MostAbundantStrategy;
import ro.msg.learning.shop.strategy.SingleLocationStrategy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FindLocationUseCaseTest {
    Product product;
    Product product2;
    OrderE orderE;
    List<OrderDetail> orderDetails = new ArrayList<>();
    ProductCategory category;
    Supplier supplier;
    Customer customer;
    Location location;
    @InjectMocks
    SingleLocationStrategy singleLocationStrategy;

    @InjectMocks
    MostAbundantStrategy mostAbundantStrategy;
    List<ProductLocationQuantity> productLocationQuantities;
    @BeforeEach
    void setUp(){

    }

    @Test
    void shouldFindSingleLocation(){
        product = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product.setId(1);
        product2 = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product2.setId(2);
        location = new Location("locatia1", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        Set<Stock> stocks = new HashSet<>();
        Stock stock = new Stock(1, 1,product, location, 100);
        Stock stock2 = new Stock(2,1,product2, location, 2);
        stocks.add(stock);
        Set<Stock> stocks2 = new HashSet<>();
        stocks2.add(stock2);
        product.setStocks(stocks);
        product2.setStocks(stocks2);
        customer = new Customer("John","Doe", "username01", "password","email");
        orderE = new OrderE(new Timestamp(System.currentTimeMillis()), "Cluj-Napoca","Romania","Campului", customer);
        OrderDetail orderDetail = new OrderDetail(1,1,product, orderE, 22);
        OrderDetail orderDetail2 = new OrderDetail(1,2,product2, orderE, 2);
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
        productLocationQuantities = singleLocationStrategy.findStrategy(orderDetails);
        assertThat(productLocationQuantities).isNotNull();
    }

    @Test
    void shouldNotFindSingleLocation(){
        product = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product.setId(1);
        product2 = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product2.setId(2);
        location = new Location("locatia1", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        Set<Stock> stocks = new HashSet<>();
        Stock stock = new Stock(1, 1,product, location, 100);
        Stock stock2 = new Stock(2,1,product2, location, 2);
        stocks.add(stock);
        Set<Stock> stocks2 = new HashSet<>();
        stocks2.add(stock2);
        product.setStocks(stocks);
        product2.setStocks(stocks2);
        customer = new Customer("John","Doe", "username01", "password","email");
        orderE = new OrderE(new Timestamp(System.currentTimeMillis()), "Cluj-Napoca","Romania","Campului", customer);
        OrderDetail orderDetail = new OrderDetail(1,1,product, orderE, 22);
        OrderDetail orderDetail2 = new OrderDetail(1,2,product2, orderE, 42);
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);

        StrategyNotApplicableException locationNotFoundException = assertThrows(StrategyNotApplicableException.class,
                () -> singleLocationStrategy.findStrategy(this.orderDetails));
        assertEquals("Can't complete order because of the strategy used!", locationNotFoundException.getMessage());
    }

    @Test
    void shouldFindMostAbundantStrategy(){
        product = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product.setId(1);
        product2 = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product2.setId(2);
        location = new Location("locatia1", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        Location location2 = new Location("locatia1", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        location2.setId(2);
        Set<Stock> stocks = new HashSet<>();
        Stock stock = new Stock(1, 1,product, location, 100);
        Stock stock2 = new Stock(2,1,product2, location, 2);
        Stock stock3 = new Stock(1,2,product, location2, 2000);
        stocks.add(stock);
        stocks.add(stock3);
        Set<Stock> stocks2 = new HashSet<>();
        stocks2.add(stock2);
        product.setStocks(stocks);
        product2.setStocks(stocks2);
        customer = new Customer("John","Doe", "username01", "password","email");
        orderE = new OrderE(new Timestamp(System.currentTimeMillis()), "Cluj-Napoca","Romania","Campului", customer);
        OrderDetail orderDetail = new OrderDetail(1,1,product, orderE, 22);
        OrderDetail orderDetail2 = new OrderDetail(1,2,product2, orderE, 2);
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
        productLocationQuantities = mostAbundantStrategy.findStrategy(orderDetails);
        assertThat(productLocationQuantities).isNotNull();
    }

    @Test
    void shouldNotFindMostAbundantStrategy(){
        product = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product.setId(1);
        product2 = new Product("productName", "description", new BigDecimal(100), 1.3, category,supplier,"imageUrl");
        product2.setId(2);
        location = new Location("locatia1", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        Location location2 = new Location("locatia2", "Romania", "Cluj-Napoca", "Cluj","Rapsodiei");
        location2.setId(2);
        Set<Stock> stocks = new HashSet<>();
        Stock stock = new Stock(1, 1,product, location, 100);
        Stock stock2 = new Stock(2,1,product2, location, 2);
        Stock stock3 = new Stock(1,2,product, location2, 2000);
        stocks.add(stock);
        stocks.add(stock3);
        Set<Stock> stocks2 = new HashSet<>();
        stocks2.add(stock2);
        location.setStocks(stocks);
        location2.setStocks(stocks2);
        product.setStocks(stocks);
        product2.setStocks(stocks2);
        customer = new Customer("John","Doe", "username01", "password","email");
        orderE = new OrderE(new Timestamp(System.currentTimeMillis()), "Cluj-Napoca","Romania","Campului", customer);
        OrderDetail orderDetail = new OrderDetail(1,1,product, orderE, 233);
        OrderDetail orderDetail2 = new OrderDetail(1,2,product2, orderE, 122);
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
        StrategyNotApplicableException locationNotFoundException = assertThrows(StrategyNotApplicableException.class,
                () -> mostAbundantStrategy.findStrategy(this.orderDetails));
        assertEquals("This order cannot be completed due to the strategy chosen!", locationNotFoundException.getMessage());

    }

}
