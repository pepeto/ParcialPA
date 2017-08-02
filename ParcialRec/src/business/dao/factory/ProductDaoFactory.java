package business.dao.factory;

import business.dao.implementation.file.ProductDaoImplementationFile;
import business.dao.interfaces.ProductDao;

public class ProductDaoFactory {
    public static ProductDao get(String implementation) {
        if (implementation.equals("file")) {
            return new ProductDaoImplementationFile();
        } else {
            return null;
        }
    }
}