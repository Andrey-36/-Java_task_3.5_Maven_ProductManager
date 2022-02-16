package ru.netology.manager;

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
    private Smartphone smartphone = new Smartphone();

//    @Test
//    void shouldCastFromBaseClassOne() {
//        Product product = new Book();
//        if (product instanceof Book) {
//            Book book = (Book) product;
//        }
//    }
//    @Test
//    void shouldCastFromBaseClassTwo() {
//        Product product = new Smartphone();
//        if (product instanceof Smartphone) {


    @Test
    void shouldSaveProduct() {
        Product first = new Product(1, "book1", 350);
        Product second = new Product(2, "book2", 400);
        Product third = new Product(3, "Smartphone1", 5000);
        Product fourth = new Product(4, "Smartphone2", 5500);

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        Product[] expected = {first, second, third, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveBook() {
        Book first = new Book(1, "book1", 350, 200, "Pushkin");
        Book second = new Book(2, "book2", 400, 198, "Dostoevsky");

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);

        Product[] expected = {first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveSmartphone() {
        Smartphone first = new Smartphone(1, "Smartphone1", 5000, "blue", "nokia");
        Smartphone second = new Smartphone(2, "Smartphone2", 5500, "red", "lenovo");

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);

        Product[] expected = {first, second};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllProduct() {
        Product first = new Product(1, "book1", 350);
        Product second = new Product(2, "book2", 400);
        Product third = new Product(3, "Smartphone1", 5000);
        Product fourth = new Product(4, "Smartphone2", 5500);

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.findAll();

        Product[] expected = {first, second, third, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Product first = new Product(1, "book1", 350);
        Product second = new Product(2, "book2", 400);
        Product third = new Product(3, "Smartphone1", 5000);
        Product fourth = new Product(4, "Smartphone2", 5500);

        ProductRepository repository = new ProductRepository();
        repository.save(first);

        repository.findById(1);

        Product[] expected = {first};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findByIdAboveArray() {
        Product first = new Product(1, "book1", 350);
        Product second = new Product(2, "book2", 400);
        Product third = new Product(3, "Smartphone1", 5000);
        Product fourth = new Product(4, "Smartphone2", 5500);

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.findById(5);

        Product[] expected = {first, second, third, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        Product first = new Product(1, "book1", 350);
        Product second = new Product(2, "book2", 400);
        Product third = new Product(3, "Smartphone1", 5000);
        Product fourth = new Product(4, "Smartphone2", 5500);

        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);

        repository.removeById(3);

        Product[] expected = {first, second, fourth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    void add() {
    }

//    @Test
//    void searchByBookOne() {
//        Product first = new Product(1, "book1", 350);
//        Product second = new Product(2, "book2", 400);
//        Product third = new Product(3, "Smartphone1", 5000);
//        Product fourth = new Product(4, "Smartphone2", 5500);
//
//        ProductManager repository = new ProductManager();
//        repository.save(first);
//        repository.save(second);
//        repository.save(third);
//        repository.save(fourth);
//
//        manager.searchBy(String.valueOf(first));
//
//        Product[] expected = {first};
//        Product[] actual = repository.findAll();
//
//        assertArrayEquals(expected, actual);
//
//    }

    @Test
    void matches() {
    }
}