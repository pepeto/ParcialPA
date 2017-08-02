package presentation.console.view;

import business.dto.Invoice;
import business.dto.Item;
import business.dto.Product;
import presentation.console.controller.InvoiceController;
import presentation.console.controller.ProductController;
import util.IO;

import java.util.Date;
import java.util.List;

public class InvoiceMenu {


    public static int show() {
        boolean status = false;
        int option = 0;

        while (!status) {
        	IO.print("Seleccione una opción");
            IO.print("1. Crear Factura");
            IO.print("2. Listado de Facturas");
            IO.print("3. Búsqueda de Factura por número");
            IO.print("4. Atrás");

            option = IO.getInt();

            if (option < 1 || option > 4) {
                IO.print("Opción Inválida <1-4>");

                continue;
            } else {
                InvoiceController invoiceController = new InvoiceController();
                ProductController productController = new ProductController();

                if (option == 1) {
                    Invoice invoice = InvoiceMenu.create();

                    ItemMenu.show(invoice);

                    //Me parece que deberia estar en la clase propia de Invoice
                    for (Item item : invoice.getItems()) {
                        invoice.setTotal(invoice.getTotal() + item.getTotal());
                    }

                    if (!invoiceController.create(invoice)) {
                        IO.print("Warning: Número de Factura Existente o Error de Archivo.");
                    }

                    for (Item item : invoice.getItems()) {
                        Product product = productController.findByName(item.getProduct().getName());
                        Product productUpdated = item.getProduct();

                        productUpdated.setStock(product.getStock() - item.getQuantity());

                        productController.update(product, productUpdated);
                    }

                    InvoiceMenu.print(invoice);
                } else if (option == 2) {
                    List<Invoice> invoices = invoiceController.findAll();

                    if (invoices.isEmpty()) {
                        IO.print("No hay items");
                    } else {
                        for (Invoice invoice : invoices) {
                            IO.print("---------------");

                            InvoiceMenu.print(invoice);
                        }
                    }
                } else if (option == 3) {
                    Invoice invoice = invoiceController.findById(IO.getInt("Ingrese ID"));

                    if (invoice == null) {
                        IO.print("Inexistente");
                    } else {
                        InvoiceMenu.print(invoice);
                    }
                } else {
                    status = true;
                }
            }
        }

        return option;
    }

    public static Invoice create() {
    	
    	int   in = IO.getInt("Ingrese Número de Factura");
        Date   d = new Date();
        String n = IO.getString("Ingrese el Nombre del Cliente");
        String a = IO.getString("Ingrese la Dirección del Cliente");
        String p = IO.getString("Ingrese el Forma de Pago");
        String s = IO.getString("Ingrese el Punto de Venta");
        String m = IO.getString("Ingrese el Nombre del Vendedor");
        int    t = 0;
    	
    	
        Invoice invoice = new Invoice(in, d, n, a, p, s, m, t);
/*
        invoice.setId(IO.getInt("Ingrese el numero de factura"));
        invoice.setDate(new Date());
        invoice.setClientName(IO.getString("Ingrese el nombre del cliente"));
        invoice.setClientAddress(IO.getString("Ingrese la dirección del cliente"));
        invoice.setMode(IO.getString("Ingrese el modo de pago"));
        invoice.setPoint(IO.getString("Ingrese el punto de venta"));
        invoice.setSellerName(IO.getString("Ingrese el nombre del vendedor"));
        invoice.setTotal(0);
*/
        return invoice;
    }

    public static void print(Invoice invoice) {
        IO.print("Número de Factura: " + invoice.getId());
        IO.print("Fecha de Venta: " + invoice.getDate());
        IO.print("Nombre del Cliente: " + invoice.getClientName());
        IO.print("Dirección del Cliente: " + invoice.getClientAddress());
        IO.print("Forma de Pago: " + invoice.getPaymentMethod());
        IO.print("Punto de Venta: " + invoice.getPOS());
        IO.print("Nombre del Vendedor: " + invoice.getSellerName());
        IO.print("Total: " + invoice.getTotal());

        for (Item item : invoice.getItems()) {
            IO.print("---------------");
            ItemMenu.print(item);
        }

        IO.print("---------------");
        IO.print(" ");
    }
}
