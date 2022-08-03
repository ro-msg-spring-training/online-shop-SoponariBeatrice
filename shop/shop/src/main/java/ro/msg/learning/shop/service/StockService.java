package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.Optional;

@Service
public class StockService implements IStockService{
    @Autowired
    StockRepository repository;
    @Override
    public Stock createStock(Stock stock) {
        return repository.save(stock);
    }
    @Override
    public Optional<Stock> updateStock(Stock stock) {
        return repository.findById(stock.getProductid()).map(updatedStock -> {
            updatedStock.setProductid(stock.getProductid());
            updatedStock.setLocationid(stock.getLocationid());
            updatedStock.setLocation(stock.getLocation());
            updatedStock.setProduct(stock.getProduct());
            updatedStock.setQuantity(stock.getQuantity());
            return repository.save(updatedStock);});
    }
}
