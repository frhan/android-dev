package me.farhan.contextualactionbardemo;

public class Laptop {
    private String brand;
 
    public Laptop() {
        super();
    }
    public Laptop(String brand) {
        super();
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return  brand;
    }
}