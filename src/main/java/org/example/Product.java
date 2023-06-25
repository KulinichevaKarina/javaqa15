package org.example;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    Product(int id, String name, int price) {
        setId(id);
        setName(name);
        setPrice(price);
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(int id) {
        return this.id == id;
    }

}
