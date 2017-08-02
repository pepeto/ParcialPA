package presentation.console.controller;

import business.dao.factory.ProductDaoFactory;
import business.dao.interfaces.ProductDao;
import business.dto.Product;

import java.util.List;

public class ProductController {
    private ProductDao factory;

    public ProductController() {
        this.factory = ProductDaoFactory.get("file");
    }

    public boolean create(Product product) {
        List<Product> products = this.factory.findAll();

        if (product == null) {
            return false;
        }

        products.add(product);

        return this.factory.create(products);
    }

    public List<Product> findAll() {
        return this.factory.findAll();
    }

    public Product findByName(String name) {
        return this.factory.findByName(name);
    }

    public boolean update(Product product, Product productUpdated) {
        return this.factory.update(product, productUpdated);
    }

    public boolean delete(Product product) {
        return this.factory.delete(product);
    }
}
