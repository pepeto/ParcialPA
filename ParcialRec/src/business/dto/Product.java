package business.dto;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product(String n, String d, double p, int s){
    	
    	this.name        = n;
    	this.description = d;
    	this.price       = p;
    	this.stock       = s;
    }
    
    public Integer getId() {
        return this.id;
    }

    
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    /* XXXXXXXXXXXXXXX
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    */
}