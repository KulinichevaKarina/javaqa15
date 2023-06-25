package org.example;

public class ProductManager {

    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                result = arrayAdd(result, product);
            }
        }

        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    private Product[] arrayAdd(Product[] products, Product product) {
        Product[] tmp = new Product[products.length + 1];
        int i = 0;
        for (Product item : products) {
            tmp[i] = item;
            i++;
        }
        tmp[i] = product;

        return tmp;
    }
}
