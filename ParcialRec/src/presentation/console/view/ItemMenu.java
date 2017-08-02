package presentation.console.view;

import business.dto.Invoice;
import business.dto.Item;
import business.dto.Product;
import presentation.console.controller.ProductController;
import util.IO;

import java.util.List;

public class ItemMenu {

    
    public static int show(Invoice invoice) {
        boolean status = false;
        int option = 0;

        while (!status) {
            IO.print("Seleccione una opción");
            IO.print("1. Agregar producto");
            IO.print("2. Terminar");

            option = IO.getInt();

            if (option < 1 || option > 2) {
                IO.print("Opción inválida <1-2>");

                continue;
            } else {
                ProductController productController = new ProductController();

                if (option == 1) {
                    List<Product> products = productController.findAll();

                    if (products.isEmpty()) {
                        IO.print("Listado vacío");
                    } else {
                        for (Product product : products) {
                            IO.print("---------------");

                            ProductMenu.print(product);
                        }

                        Item item = new Item();

                        Product product = productController.findByName(IO.getString("Ingrese el nombre"));

                        if (product == null) {
                            IO.print("No existe");
                        } else {
                            item.setProduct(product);

                            int quantity = IO.getInt("Ingrese la cantidad");

                            if (quantity > product.getStock()) {
                                IO.print("Stock Insuficiente");
                            } else {
                                item.setQuantity(quantity);
                                item.setTotal(item.getQuantity() * product.getPrice());

                                ItemMenu.print(item);

                                invoice.addItem(item);
                            }
                        }
                    }
                } else {
                    status = true;
                }
            }
        }

        return option;
    }

    public static void print(Item item) {
        ProductMenu.printSmall(item.getProduct());
        IO.print("Cantidad: " + item.getQuantity());
        IO.print("Total: " + item.getTotal());
    }
}
