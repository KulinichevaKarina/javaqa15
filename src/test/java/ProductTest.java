import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    ProductRepository repository = new ProductRepository();

    ProductManager manager;

    ProductTest() {
        this.manager = new ProductManager(repository);
    }

    @Test
    public void add() {
        manager.add(new Book(7, "Test 8", 130, "Ivan"));
        manager.add(new Smartphone(9, "Test 9", 140, "Moscow"));

        Assertions.assertEquals(2, repository.findAll().length);
    }

    @Test
    public void delete() {
        Product item1 = new Book(7, "Test 8", 130, "Ivan");
        Product item2 = new Smartphone(8, "Test 9", 1400, "Moscow");
        Product item3 = new Book(6, "Test 7", 120, "Ivan");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.delete(7);

        Product[] expected = {item2, item3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy() {
        Product searchItem = new Book(7, "Test 8", 130, "Ivan");
        Product searchItem1 = new Smartphone(9, "Test 9", 140, "Moscow");
        manager.add(searchItem);
        manager.add(searchItem1);

        Product[] expected = {searchItem};
        Product[] actual = manager.searchBy("Test 8");

        Assertions.assertArrayEquals(expected, actual);

        Product[] expected1 = {searchItem, searchItem1};
        actual = manager.searchBy("Test");

        Assertions.assertArrayEquals(expected1, actual);
    }

    @Test
    public void matches() {
        Product searchItem = new Book(7, "Test 8", 130, "Ivan");
        manager.add(searchItem);
        manager.add(new Smartphone(9, "Test 9", 140, "Moscow"));

        boolean actual = manager.matches(searchItem, "Test 8");

        Assertions.assertTrue(actual);

        actual = manager.matches(searchItem, "Test 10");

        Assertions.assertFalse(actual);
    }
}
