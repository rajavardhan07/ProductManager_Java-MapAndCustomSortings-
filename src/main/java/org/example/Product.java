package org.example;

public class Product implements Comparable<Product> {
    private int pid;
    private String pname;
    private double price;
    private String brand;
    private String category;
    private int rating;
    private int discount;

    public Product(int pid, String pname, double price, String brand, String category, int rating, int discount) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discount = discount;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    public int getDiscount() {
        return discount;
    }


    @Override
    public int compareTo(Product o)
    {
        double price1=this.getPrice();
        double price2=o.getPrice();
        return Double.compare(price2,price1);
    }
}
