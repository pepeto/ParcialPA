package business.dto;

import java.io.Serializable;

public class Item implements Serializable {
    private Integer id;
    private Product product;
    private int quantity;
    private double total;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item product = (Item) o;

        return id.equals(product.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}