package presentation.console.view;

import business.dto.Product;
import presentation.console.controller.ProductController;
import util.IO;

import java.util.List;

public class ProductMenu {

    private static void getOptions() {
        IO.print("Seleccione una opción");
        IO.print("1. Crear");
        IO.print("2. Listar todos");
        IO.print("3. Buscar por Nombre");
        IO.print("4. Actualizar");
        IO.print("5. Eliminar");
        IO.print("6. Atrás");
    }

    public static int show() {
        boolean status = false;
        int option = 0;

        while (!status) {
            ProductMenu.getOptions();

            option = IO.getInt();

            if (option < 1 || option > 6) {
                IO.print("Opción Inválida <1-6>");

                continue;
            } else {
                ProductController productController = new ProductController();

                if (option == 1) {
                    Product product = ProductMenu.create();

                    if (!productController.create(product)) {
                        IO.print("No se pudo crear");
                    }

                    ProductMenu.print(product);
                } else if (option == 2) {
                    List<Product> products = productController.findAll();

                    if (products.isEmpty()) {
                        IO.print("No se encontraron items");
                    } else {
                        for (Product product : products) {
                            IO.print("---------------");

                            ProductMenu.print(product);
                        }
                    }
                } else if (option == 3) {
                    Product product = productController.findByName(IO.getString("Ingrese el nombre"));

                    if (product == null) {
                        IO.print("Inexistente");
                    } else {
                        ProductMenu.print(product);
                    }
                } else if (option == 4) {
                    Product product = productController.findByName(IO.getString("Ingrese el nombre"));

                    if (product == null) {
                        IO.print("Inexistente");
                    } else {
                        Product productUpdated = ProductMenu.update();

                        if (!productController.update(product, productUpdated)) {
                            IO.print("No se pudo actualizar");
                        } else {
                            ProductMenu.print(productUpdated);
                        }
                    }

                } else if (option == 5) {
                    Product product = productController.findByName(IO.getString("Ingrese el nombre"));

                    if (product == null) {
                        IO.print("Inexistente");
                    } else {
                        if (!productController.delete(product)) {
                            IO.print("No se pudo eliminar");
                        } else {
                            IO.print("Borrado");
                        }
                    }
                } else {
                    status = true;
                }
            }
        }

        return option;
    }

    public static Product create() {
        
    	String n = IO.getString("Ingrese el nombre");
        String d = IO.getString("Ingrese la descripción");
        double p = IO.getDouble("Ingrese el precio");
        int    s = IO.getInt("Ingrese el stock");
    	
    	Product product = new Product(n, d, p, s);
/*
        product.setName(IO.getString("Ingrese el nombre"));
        product.setDescription(IO.getString("Ingrese la descripción"));
        product.setPrice(IO.getDouble("Ingrese el precio"));
        product.setStock(IO.getInt("Ingrese el stock"));
*/
        return product;
    }

    public static Product update() {
    	
    	String n = IO.getString("Ingrese el nombre");
        String d = IO.getString("Ingrese la descripción");
        double p = IO.getDouble("Ingrese el precio");
        int    s = IO.getInt("Ingrese el stock");
    	
    	Product product = new Product(n, d, p, s);
    	
        return product;
    }

    public static void print(Product product) {
        IO.print("Nombre: " + product.getName());
        IO.print("Descripción: " + product.getDescription());
        IO.print("Precio: " + product.getPrice());
        IO.print("Stock: " + product.getStock());
    }

    public static void printSmall(Product product) {
        IO.print("Nombre: " + product.getName());
        IO.print("Descripción: " + product.getDescription());
        IO.print("Precio: " + product.getPrice());
    }
}
