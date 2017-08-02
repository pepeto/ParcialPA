package business.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable {
    private Integer id;
    private Date date;
    private String clientName;
    private String clientAddress;
    private String paymentMethod;
    private String POS;
    private String sellerName;
    private double total;
    private ArrayList<Item> items;

    /* XXX
    public Invoice() {
        items = new ArrayList<Item>();
    }
    */
    public Invoice(Integer id, Date date, String clientName, String clientAddress, String paymentMethod, 
    				String POS, String sellerName, double total) {
    	this.id = id;
    	this.date = date;
    	this.clientName = clientName;
    	this.clientAddress = clientAddress;
    	this.paymentMethod = paymentMethod;
    	this.POS = POS;
    	this.sellerName = sellerName;
    	this.total = total;
            	
        items = new ArrayList<Item>();
    }

    public Integer getId() {
        return this.id;
    }

    
    public Date getDate() {
        return date;
    }

    
    public String getClientName() {
        return this.clientName;
    }

    
    public String getClientAddress() {
        return clientAddress;
    }

    
    public String getPaymentMethod() {
        return paymentMethod;
    }

    
    public String getPOS() {
        return POS;
    }

    public String getSellerName() {
        return sellerName;
    }

    
    public double getTotal() {
        return total;
    }

    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        return id.equals(invoice.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    // Revisar XXX
    public void setTotal(double total) {
        this.total = total;
    }
    
  /*  
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
        
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
    
    public void setPaymentMethod(String mode) {
        this.paymentMethod = mode;
    }

    public void setPOS(String POS) {
    	this.POS = POS;
    }
*/
}