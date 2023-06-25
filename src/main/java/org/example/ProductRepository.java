package org.example;

public class ProductRepository {
    private Product[] items = new Product[0];


    public void add(Product product) {
        Product[] tmp = new Product[items.length + 1];
        int i = 0;
        for (Product item : items) {
            tmp[i] = item;
            i++;
        }
        tmp[i] = product;
        items = tmp;

    }

    public Product[] getProducts() {
        return items;
    }


    public void delete(int id) {
        Product[] change = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (!item.equals(id)) {
                change[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = change;

    }

    public Product[] findAll() {
        return items;
    }
}
