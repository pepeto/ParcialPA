package presentation.console.controller;

import business.dao.factory.InvoiceDaoFactory;
import business.dao.interfaces.InvoiceDao;
import business.dto.Invoice;

import java.util.List;

public class InvoiceController {
    private InvoiceDao factory;

    public InvoiceController() {
        this.factory = InvoiceDaoFactory.get("file");
    }

    public boolean create(Invoice invoice) {
        List<Invoice> invoices = this.factory.findAll();

        if (invoice == null) {
            return false;
        }

        invoices.add(invoice);

        return this.factory.create(invoices);
    }

    public List<Invoice> findAll() {
        return this.factory.findAll();
    }

    public Invoice findById(int id) {
        return this.factory.findById(id);
    }
}
