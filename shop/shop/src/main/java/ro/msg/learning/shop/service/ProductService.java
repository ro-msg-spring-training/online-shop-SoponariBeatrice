package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exception.NoSuchCategoryExistsException;
import ro.msg.learning.shop.exception.NoSuchSupplierExistsException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository repository;
    private final ProductCategoryRepository repositoryCategory;
    private final SupplierRepository repositorySupplier;
    @Override
    public Product saveProduct(Product product) {
        if(!repositoryCategory.findById(product.getCategory().getId()).isPresent())
        {
            throw new NoSuchCategoryExistsException("This category doesn't exist!");
        }
        if(!repositorySupplier.findById(product.getSupplier().getId()).isPresent())
        {
            throw new NoSuchSupplierExistsException("This supplier doesn't exist!");
        }
        return repository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> updateProduct(Integer id, Product product) {
       return repository.findById(id).map(updatedProduct -> {
           updatedProduct.setId(product.getId());
           updatedProduct.setName(product.getName());
           updatedProduct.setCategory(product.getCategory());
           updatedProduct.setDescription(product.getDescription());
           updatedProduct.setImageUrl(product.getImageUrl());
           updatedProduct.setPrice(product.getPrice());
           updatedProduct.setSupplier(product.getSupplier());
           return repository.save(updatedProduct);});
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Integer id) {
         return repository.findById(id);
    }
}
