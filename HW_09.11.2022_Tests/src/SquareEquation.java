public class SquareEquation {

    // Коэффициенты уравнения
    private double a, b, c;

    // Конструктор
    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Метод, решающий квадратное уравнение
    public Roots solution() {
        // Дискриминант
        double d = b * b - 4 * a * c;

// Проверка, имеет ли уравнение корни
        if (d < 0)
            throw new ArithmeticException("Solution has no roots.");

// Вычислить результат
        Roots result = new Roots();
        result.x1 = (-b - Math.sqrt(d)) / (2 * a);
        result.x2 = (-b + Math.sqrt(d)) / (2 * a);

// Вернуть результат
        return result;
    }
}
