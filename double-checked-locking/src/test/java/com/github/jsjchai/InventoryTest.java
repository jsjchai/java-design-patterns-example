package com.github.jsjchai;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    @Test
    public void testUnmodifiableList(){
        Inventory inventory = new Inventory(1);
        inventory.addItem(new Item());

        assertThrows(UnsupportedOperationException.class,()->inventory.getItems().add(new Item()));
    }

    @Test
    public void testAddItem(){

        assertTimeout(ofMillis(10000), () -> {
            // Create a new inventory with a limit of 1000 items and put some load on the add method
            final Inventory inventory = new Inventory(1000);
            final ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 10; i++)
                executorService.execute(() -> {
                    while (inventory.addItem(new Item())) {
                    }
                });

            // Wait until all threads have finished
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);

            // Check the number of items in the inventory. It should not have exceeded the allowed maximum
            final List<Item> items = inventory.getItems();
            assertNotNull(items);
            assertEquals(1000, items.size());
        });
    }
}
