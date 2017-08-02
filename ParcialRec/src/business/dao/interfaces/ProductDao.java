package business.dao.interfaces;

import business.dto.Product;

import java.util.List;

public interface ProductDao {
    public boolean create(List<Product> products);

    public List<Product> findAll();

    public Product findByName(String name);

    public boolean update(Product product, Product productUpdated);

    public boolean delete(Product product);
}