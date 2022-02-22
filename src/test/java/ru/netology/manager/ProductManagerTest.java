package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book = new Book();
    private Book book1 = new Book(1, "book1", 350, "Pushkin");
    private Book book2 = new Book(2, "book1", 350, "Pushkin");
    private Book book3 = new Book(3, "book2", 400, "Dostoevsky");

    private Smartphone smartphone = new Smartphone();
    private Smartphone smartphone1 = new Smartphone(4, "Smartphone1", 5000, "nokia");
    private Smartphone smartphone2 = new Smartphone(5, "Smartphone2", 5500, "lenovo");

    private Product first = new Product(1, "book1", 350);
    private Product second = new Product(2, "book1", 350);
    private Product third = new Product(3, "book2", 400);
    private Product fourth = new Product(4, "Smartphone1", 5000);
    private Product fifth = new Product(5, "Smartphone2", 5500);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldSaveProduct() {

        Product[] expected = {first, second, third, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        repository.findById(4);

        Product expected = fourth;
        Product actual = repository.findById(4);
        assertEquals(expected, actual);
    }

    @Test
    void findByIdAboveArray() {
        repository.findById(6);

        Product expected = null;
        Product actual = null;
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.removeById(3);

        Product[] expected = {first, second, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOneProduct() {
        manager.searchBy("Smartphone1");

        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Smartphone1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTwoProduct() {
        Product[] expected = {first, second};
        Product[] actual = manager.searchBy("book1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNotInArray() {
        manager.searchBy("Smartphone3");

        Product[] expected = {first, second, third, fourth, fifth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}