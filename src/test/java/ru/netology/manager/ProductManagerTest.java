package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smarthone;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final Product firstProduct = new Product(1, "телевизор", 50000);
    private final Product secondProduct = new Product(2, "радио", 1000);
    private final Book firstBook = new Book(3, "Теремок", 120, "Булатов");
    private final Book secondBook = new Book(4, "Колобок", 250, "Ушинский");
    private final Smarthone firstSmarthone = new Smarthone(5, "Apple-iPhone", 100000, "Джон Кейси");
    private final Smarthone secondSmarthone = new Smarthone(6, "Xiaomi ", 20000, "Лэй Цзюнь");

    private ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setUp() {
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmarthone);
        manager.save(secondSmarthone);
    }

    @Test
    void shouldReturnByTextProduck() {
        Product[] expected = {firstProduct};
        Product[] actual = manager.searchBy("телевизор");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnByTextBook() {
        Product[] expected = {firstBook};
        Product[] actual = manager.searchBy("Булатов");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldReturnBySmarthone() {
        Product[] expected = {firstSmarthone};
        Product[] actual = manager.searchBy("Джон Кейси");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Лэй Цзюнь");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }
}