package business.dao.factory;

import business.dao.implementation.file.InvoiceDaoImplementationFile;
import business.dao.interfaces.InvoiceDao;

public class InvoiceDaoFactory {
    
	public static InvoiceDao get(String implementation) {
    
		if (implementation.equals("file")) {
            return new InvoiceDaoImplementationFile();
        } else {
        	System.out.println("Solo está implementado el uso de archivos planos");
            return null;
        }
    }
}