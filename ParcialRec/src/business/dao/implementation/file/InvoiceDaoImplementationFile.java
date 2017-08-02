package business.dao.implementation.file;

import business.dao.interfaces.InvoiceDao;
import business.dto.Invoice;
import util.FileIO;
import util.IO;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InvoiceDaoImplementationFile implements InvoiceDao {
    private String path;

    // Constructor. Inicializa root desde el archivo externo de configuracion data.properties
    public InvoiceDaoImplementationFile() {
        this.getRootParameter();
    }

    
    // Lee de disco, del archivo de configuración, la ubicación de los datos
    private void getRootParameter() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("src/data.properties"));
        } catch (Exception e) {
            throw new RuntimeException();
        }

        this.path = properties.getProperty("InvoiceRoot");
    }

    // Abre una instancia de fileIO y escribe las List de registros y cada factura individualmente
    public boolean create(List<Invoice> recList) {
        FileIO fileIO = new FileIO(this.path);
        boolean retValue = true;

        // Levanta la lista de archivos en el directorio especificado
        File[] files = fileIO.readDirectoryFileNames(this.path); 
        IO.printList(files);
        
        // Guarda cada elemento de la List en un archivo diferente segun numero. XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        for(Invoice i : recList){
        	String filename = IO.pathOnly(this.path) + "facturas\\" + i.getId() + ".dat";
        	retValue = fileIO.writeRec(i, filename);
        }
        
        // Guarda la List completa de una en el archivo facturas
        FileIO fileTodo = new FileIO(this.path);
        // return fileTodo.write(recList);
        fileTodo.write(recList);
        
        return retValue;
    }

    
    // Levanta todos los registros a una lista y la devuelve XXX
    public List<Invoice> findAll() {
        FileIO fileIO = new FileIO(this.path);
        Object object;
/* --------------------------------------------------------------ANDA!!!!
        if((object = fileIO.read()) != null){
        	return (ArrayList<Invoice>) object;
        	}
        else
        	return new ArrayList<Invoice>();
*/               
        // Levanta todos los archivos de factura por separado en el ArrayList  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        return (List<Invoice>) fileIO.loadList(IO.pathOnly(this.path) + "facturas/");
    }

    
    // Busqueda de registro por ID, recorriendo la lista y devolviendo el registro particular
    public Invoice findById(int id) {
        List<Invoice> recordList = this.findAll();

        Invoice record = null;

        for (Invoice invoiceRecord : recordList) {
            if (invoiceRecord.getId().equals(id)) {
                record = invoiceRecord;

                break;
            }
        }

        return record;
    }
}