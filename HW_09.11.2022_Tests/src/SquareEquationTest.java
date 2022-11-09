
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SquareEquationTest {

    SquareEquation squareEquation;

    @Test
    void hasNoD() {
       Assertions.assertThrows(ArithmeticException.class, () -> {
           squareEquation = new SquareEquation(1, 2, 3);
           squareEquation.solution();});
    }

    @Test
    void hasTwoD() {
        squareEquation = new SquareEquation(-5, -6, 3);
        Assertions.assertEquals(0.37979589711327116, squareEquation.solution().x1);
        Assertions.assertEquals(-1.579795897113271, squareEquation.solution().x2);
    }

    @Test
    void hasOneD() {
        squareEquation = new SquareEquation(1, -6, 9);
        Assertions.assertEquals(3, squareEquation.solution().x1);
        Assertions.assertEquals(3, squareEquation.solution().x2);
    }

}