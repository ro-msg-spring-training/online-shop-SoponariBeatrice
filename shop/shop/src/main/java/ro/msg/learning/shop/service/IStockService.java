package ro.msg.learning.shop.service;

import ro.msg.learning.shop.model.Stock;

import java.util.Optional;

public interface IStockService {
    Stock createStock(Stock stock);
    Optional<Stock> updateStock(Stock stock);
}
