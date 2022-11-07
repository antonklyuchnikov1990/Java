package NewTheme;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class CalculatorTest {

    Calculator calculator;

    // Сюда можно поместить метод
    @BeforeAll
    static void beginAll() {
        // Сюда можно поместить код, который должен быть выполнен перед тестами
    }

    // Метод, помеченный этой аннотацией запускается перед каждым тестом
    @BeforeEach
    void begin() {
        calculator = new Calculator();
    }

    @Test
    void addTest() {
        int result = calculator.add(1, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    @Disabled("This method do not need test for now")
    void addTest2() {
        int result = calculator.add(1, 2);
        Assertions.assertNotEquals(5, result);
    }

    @Test
    void addEven() {
        Assertions.assertTrue(calculator.isEven(4));
    }

    @Test
    @Timeout(1000)  // По истечению 1-й секунды тест считается проваленным
    void subTest() {
        int result = calculator.sub(1, 2);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void mulTest() {
        int result = calculator.mul(1, 2);
        Assertions.assertEquals(2, result);
    }

    @Test
    void getExeption() {
        Assertions.assertThrows(ArithmeticException.class, Executable.class.cast(calculator.add(1,2)));
    }

    @Test
    void divTest() {
        int result = calculator.div(1, 2);
        Assertions.assertEquals(0, result);
    }

    @Test
    void getIntegerTest() {
        Assertions.assertNull(calculator.getInteger(1));
    }

    @AfterEach
    void end() {
        // Сюда можно поместить код, который нужно выполнить после каждого теста
    }

    @AfterAll
    static void all() {
        // Сюда можно поместить код, который нужно выполнить после всех тестов
    }
}