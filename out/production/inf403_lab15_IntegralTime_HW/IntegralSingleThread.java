package Unknown;

public class IntegralSingleThread {

    public static void main(String[] args) {
        long start = System.nanoTime();
        double a = 1.0; // Начало интервала
        double b = 3.0;  // Конец интервала
        int N = 10000;   // Общее количество разбиений (можно увеличить для большей точности)

        double integral = calculateIntegral(a, b, N);
        System.out.println(integral);
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    // Функция, которую интегрируем
    public static double func(double x) {
        return Math.exp(-x * x / 2) * Math.sin(x);
    }

    // Метод вычисления интеграла методом трапеций (одним потоком)
    public static double calculateIntegral(double a, double b, int N) {
        double h = (b - a) / N; // Шаг разбиения
        double sum = 0;

        for (int i = 0; i < N; i++) {
            double x1 = a + i * h;       // Левая граница трапеции
            double x2 = a + (i + 1) * h; // Правая граница трапеции
            sum += (func(x1) + func(x2)) / 2 * h; // Площадь трапеции
        }

        return sum;
    }
}