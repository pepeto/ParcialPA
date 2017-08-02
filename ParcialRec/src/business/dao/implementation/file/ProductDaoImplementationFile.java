package business.dao.implementation.file;

import business.dao.interfaces.ProductDao;
import business.dto.Product;
import util.FileIO;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDaoImplementationFile implements ProductDao {
    private String root;

    public ProductDaoImplementationFile() {
        this.load();
    }

    // Levanta la ubicación de los archivos de datos mediante Properties.
    private void load() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/data.properties"));
        } catch (Exception e) {
            throw new RuntimeException();
        }

        this.root = properties.getProperty("ProductRoot");
    }

    
    public boolean create(List<Product> products) {
        FileIO fileIO = new FileIO(this.root);

        return fileIO.write(products);
    }

    public List<Product> findAll() {
        FileIO fileIO = new FileIO(this.root);

        Object object = fileIO.read();

        if (object == null) {
            return new ArrayList<Product>();
        }

        return (ArrayList<Product>) fileIO.read();
    }

    public Product findByName(String name) {
        List<Product> products = this.findAll();

        Product product = null;

        for (Product productRecord : products) {
            if (productRecord.getName().equals(name)) {
                product = productRecord;

                break;
            }
        }

        return product;
    }

    public boolean update(Product product, Product productUpdated) {
        boolean status = false;

        status = this.delete(product);

        if (!status) {
            return status;
        }

        List<Product> invoices = this.findAll();

        invoices.add(productUpdated);

        status = this.create(invoices);

        if (!status) {
            return status;
        }

        return status;
    }

    public boolean delete(Product product) {
        List<Product> products = this.findAll();

        boolean status = false;

        int i = 0;

        for (Product productRecord : products) {
            if (productRecord.getName().equals(product.getName())) {
                Product productOld = products.remove(i);

                if (productOld != null) {
                    status = true;
                }

                break;
            }

            i++;
        }

        if (status) {
            FileIO fileIO = new FileIO(this.root);

            return fileIO.write(products);
        }

        return status;
    }
}