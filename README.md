# Втора лабораториска вежба по Софтверско Инженерство
------------------------------------------------------------
# Ана Стевановска, бр.индекс: 215017
------------------------------------------------------------
# Control Flow Graph

![SLIKA - CFG - KONECNA - LAB2-SI](https://github.com/AnaStevanovskaFINKI215017/SI_2024_lab2_215017/assets/162897048/5db3bc53-11ba-4138-9eb5-bfec5ee055d0)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Цикломатска комплексност

Цикломатската комплексност на графот е 9. Оваа комплексност ја добив со помош на формулата P+1, каде што P е бројот на предикатни јазли(тоа се јазли од каде произлегуваат повеќе разгранувања).

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Тест случаи според критериумот Every Branch:

Every Branch Method - подразбира да се изминат сите ребра во графот.

A-B

B-C

B-D

D-E

E-F

F-G

F-H

H-J

H-I

J-K

K-L

K-M

M-N

N-P

M-O

O-P

P-R

P-Q

Q-R

R-E

E-S

S-T

S-U


1.) Тест случај:

Влез: allItems = null, payment = 100

Очекуван излез: RuntimeException со пораката: "allItems list can't be null"

Опис: Овој тест случај потврдува дека методот дава исклучок кога allItems е нула.

2.) Тест случај:

Влез: allItems = [], payment = 100

Очекуван излез: точно, бидејќи збирот е нула, што е помало или еднакво на payment.

Опис: Овој тест случај го проверува однесувањето кога allItems е празна листа.

3.) Тест случај:

Влез: allItems = [new Item(null, "12345", 100, 0)], payment = 100

Очекуван излез: точно, а името на ставката треба да биде „unknown“.

Опис: Овој тест случај гарантира дека ако името на ставката е нула или празно, тоа е поставено на „unknown“.

4.) Тест случај:

Влез: allItems = [new Item("Item1", "12345", 100, 0)], payment = 100

Очекуван излез: точно

Опис: Овој тест случај гарантира дека предметите со валидни баркодови се обработуваат правилно.

5.) Тест случај:

Влез: allItems = [new Item("Item1", "1234A", 100, 0)], payment = 100

Очекуван излез: RuntimeException со пораката: "Invalid character in item barcode!"

Опис: Овој тест случај потврдува дека методот дава исклучок за ставки со неважечки бар-кодови.

6.) Тест случај:

Влез: allItems = [new Item("Item1", null, 100, 0)], payment = 100

Очекуван излез: RuntimeException со пораката: "No barcode!"

Опис: Овој тест случај гарантира дека методот фрла исклучок кога ставката нема баркод.

7.) Тест случај:

Влез: allItems = [new Item("Item1", "12345", 100, 0.1f)], payment = 100

Очекуван излез: точно

Опис: Овој тест случај потврдува дека артиклите со попусти се правилно обработени.

8.) Тест случај:

Влез: allItems = [new Item("Item1", "01234", 350, 0.1f)], payment = 100

Очекуван излез: неточно (бидејќи збирот ќе биде 350 * 0,1 - 30 = 5, што е помалку од плаќањето)

Опис: Овој тест случај гарантира дека условот за попуст се применува правилно.

9.) Тест случај:

Влез: allItems = [new Item("Item1", "12345", 50, 0)], payment = 100

Очекуван излез: точно

Опис: Овој тест случај проверува дали методот се враќа точно кога вкупната сума е помала или еднаква на уплатата.

10.) Тест случај:

Влез: allItems = [new Item("Item1", "12345", 150, 0)], payment = 100

Очекуван излез: неточно

Опис: Овој тест случај проверува дали методот се враќа неточно кога вкупната сума е поголема од уплатата.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Тест случаи според критериумот Multiple Condition:

Multiple Condition Method - подразбира да се најдат сите можни комбинации за булови изрази поврзани со услов во кој има повеќе логички зависности.

За да ги задоволиме критериумите за повеќекратни услови за условот  if(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'), можни комбинации се: 2^3=8.


1.) Тест случај: price > 300, discount > 0, barcode starts with '0'

Влез: price = 350, discount = 0.1f, barcode = "012345"

Очекуван излез: неточно (збирот е намален за 30)

Опис: Оваа комбинација ги задоволува сите услови во if.


2.) Тест случај: price > 300, discount > 0, barcode does not start with '0'

Влез: price = 350, discount = 0.1f, barcode = "112345"

Очекуван излез: точно

Опис: Оваа комбинација не го исполнува третиот услов.


3.) Тест случај: price > 300, discount = 0, barcode starts with '0'

Влез: price = 350, discount = 0.0f, barcode = "012345"

Очекуван излез: точно

Опис: Оваа комбинација не го исполнува вториот услов.


4.) Тест случај: price > 300, discount = 0, barcode does not start with '0'

Влез: price = 350, discount = 0.0f, barcode = "112345"

Очекуван излез: точно

Опис: Оваа комбинација не ги исполнува вториот и третиот услов.


5.) Тест случај: price <= 300, discount > 0, barcode starts with '0'

Влез: price = 250, discount = 0.1f, barcode = "012345"

Очекуван излез: точно

Опис: Оваа комбинација не го исполнува првиот услов.


6.) Тест случај: price <= 300, discount > 0, barcode does not start with '0'

Влез: price = 250, discount = 0.1f, barcode = "112345"

Очекуван излез: точно

Опис: Оваа комбинација не ги исполнува првиот и третиот услов.


7.) Тест случај: price <= 300, discount = 0, barcode starts with '0'

Влез: price = 250, discount = 0.0f, barcode = "012345"

Очекуван излез: точно

Опис: Оваа комбинација не ги исполнува првиот и вториот услов.


8.) Тест случај: price <= 300, discount = 0, barcode does not start with '0'

Влез: price = 250, discount = 0.0f, barcode = "112345"

Очекуван излез: точно

Опис: Оваа комбинација не ги исполнува првиот, вториот и третиот услов.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# unit-tests:

unit-tests: Multiple Condition Method

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


unit-tests: Every Branch Method

@Test
    void testEveryBranchCriterion() {
        
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
