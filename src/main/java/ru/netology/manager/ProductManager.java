package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smarthone;
import ru.netology.repo.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void save(Product product) {
        this.repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] products = this.repo.findAll();
        Product[] result = new Product[0];
        for (Product product : products) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smarthone) {
            Smarthone smarthone = (Smarthone) product;
            if (smarthone.getManufacturer().contains(search)) {
                return true;
            }
        }
        return false;
    }
}

