package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product first = new Product(1, "first", 100);
    Product second = new Product(2, "second", 300);
    Product third = new Product(3, "third", 270);

    @BeforeEach
    public void sitUp() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
    }

    @Test
    public void shouldRemoveByIdExists() {
        manager.removeById(1);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{second,third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNotExists() {
        assertThrows(NotFoundException.class, () -> {manager.removeById(5);});
    }
}