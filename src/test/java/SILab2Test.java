import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SILab2Test {

    List<Item> items;

    @Test
    void checkCart() {
    }

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
    }
    private void testConditionCombination(float price, float discount, String barcode, boolean expected) {
        items.clear();
        items.add(new Item("TestItem", barcode, (int) price, discount));
        int payment = 1000; // Arbitrary large payment to not affect the condition
        assertEquals(expected, SILab2.checkCart(items, payment));
    }

    @Test
    void testConditionCombinations() {
        // Combination 1: price > 300, discount > 0, barcode starts with '0'
        testConditionCombination(350, 0.1f, "012345", true); // sum reduced by 30

        // Combination 2: price > 300, discount > 0, barcode does not start with '0'
        testConditionCombination(350, 0.1f, "112345", true);

        // Combination 3: price > 300, discount = 0, barcode starts with '0'
        testConditionCombination(350, 0.0f, "012345", true);

        // Combination 4: price > 300, discount = 0, barcode does not start with '0'
        testConditionCombination(350, 0.0f, "112345", true);

        // Combination 5: price <= 300, discount > 0, barcode starts with '0'
        testConditionCombination(250, 0.1f, "012345", true);

        // Combination 6: price <= 300, discount > 0, barcode does not start with '0'
        testConditionCombination(250, 0.1f, "112345", true);

        // Combination 7: price <= 300, discount = 0, barcode starts with '0'
        testConditionCombination(250, 0.0f, "012345", true);

        // Combination 8: price <= 300, discount = 0, barcode does not start with '0'
        testConditionCombination(250, 0.0f, "112345", true);
    }

    @Test
    void testEveryBranchCriterion() {
        // Additional test cases for Every Branch Criterion
        items.clear();
        items.add(new Item(null, "123456A", 200, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 500), "Invalid character in item barcode!");

        items.clear();
        items.add(new Item("Item1", null, 200, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 500), "No barcode!");

        items.clear();
        items.add(new Item("Item1", "123456", 200, 0));
        assertTrue(SILab2.checkCart(items, 500));

        items.clear();
        items.add(new Item("Item1", "123456", 400, 0.1f));
        assertFalse(SILab2.checkCart(items, 20));
    }
}