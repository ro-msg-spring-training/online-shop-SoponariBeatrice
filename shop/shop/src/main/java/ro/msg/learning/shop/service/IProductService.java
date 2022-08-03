package ro.msg.learning.shop.service;
import ro.msg.learning.shop.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product saveProduct(Product product);

    List<Product> getProducts();

    Optional<Product> updateProduct(Integer id, Product product);

    void deleteProduct(Integer id);

    Optional<Product> findById(Integer id);

}
