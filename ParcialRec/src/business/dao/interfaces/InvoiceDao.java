package business.dao.interfaces;

import business.dto.Invoice;

import java.util.List;

public interface InvoiceDao {
	
    public boolean create(List<Invoice> invoices);
    public List<Invoice> findAll();
    public Invoice findById(int id);
    
}