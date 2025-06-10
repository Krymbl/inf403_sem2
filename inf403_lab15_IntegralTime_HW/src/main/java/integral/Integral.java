package integral;

import java.util.function.Consumer;

public class Integral implements Consumer<Double> {

    private static int N;
    private volatile double integral = 0;

    @Override
    public synchronized void accept(Double d) {
        integral += d;
    }

    public static void main(String[] args) throws InterruptedException {
        // [1, 3]
        long start1 = System.nanoTime();
        Integral integralObject = new Integral();
        int countProc = Runtime.getRuntime().availableProcessors();; //Определяет количество доступных процессоров
        N = 10000 / countProc; // кол-во "Столбиков" для суммирования задачей
        double h = (3.0 - 1.0) / countProc; //ширина каждого подынтервала, на который разбивается основной интервал интегрирования
        Thread[] t = new Thread[countProc];
        for (int i = 0; i < countProc; i++) {
            t[i] = new Thread(new PartSumCalculate(1 + i * h, 1 + (i + 1) * h, integralObject));
            t[i].start();
        }

        for (int i = 0; i < countProc; i++) {
            t[i].join();
        }

        long end1 = System.nanoTime();
        System.out.println(integralObject.integral);
        System.out.println(end1 - start1);

        long start2 = System.nanoTime();
        Integral integralObject2 = new Integral();
        countProc = Runtime.getRuntime().availableProcessors();; //Определяет количество доступных процессоров
        N = 10000 / countProc; // кол-во "Столбиков" для суммирования задачей
        h = (3.0 - 1.0) / countProc; //ширина каждого подынтервала, на который разбивается основной интервал интегрирования
        Thread[] t1 = new Thread[countProc];
        for (int i = 0; i < countProc; i++) {
            t1[i] = new Thread(new PartSumCalculate(1 + i * h, 1 + (i + 1) * h, integralObject2));
            t1[i].start();
            t1[i].join();
        }
        long end2 = System.nanoTime();
        System.out.println(end2-start2);
        System.out.println(integralObject2.integral);




    }

    public static double func(double x) {
        return Math.exp(-x * x / 2) * Math.sin(x);
    }

    // Частичная сумма, расчитываемая одним потоком
    public static double partSum(double a, double b, int N) {
        double h = (b - a) / N;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += h * (func(a + h * i) + func(a + h * (i + 1))) / 2;
        }
        return sum;
    }

    static class PartSumCalculate implements Runnable {
        private double a;
        private double b;
        private Consumer<Double> consumer;

        public PartSumCalculate (double a, double b, Consumer<Double> consumer) {
            this.a = a;
            this.b = b;
            this.consumer = consumer;
        }

        public void run(){
            double result  = partSum(a, b, N);
            consumer.accept(result);
        }
    }
}
