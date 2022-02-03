package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smarthone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final Product firstProduct = new Product(1,"firstProduct_me",1);
    private final Product secondProduct = new Product(2,"secondProduct_Me",2);
    private final Book firstBook = new Book(3,"firstBook",3, "me");
    private final Book secondBook = new Book(4,"secondBook",4, "you");
    private final Smarthone firstSmarthone = new Smarthone(5,"firstSmarthone",5, "me");
    private final Smarthone secondSmarthone = new Smarthone(6,"secondSmarthone",6, "you");

    private ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setUp(){
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmarthone);
        manager.save(secondSmarthone);
    }
    @Test
    void shouldReturnByText(){
Product[] expected ={firstProduct, firstBook, firstSmarthone};
Product[] actual = manager.searchBy("me");

assertArrayEquals(expected, actual);
    }
}