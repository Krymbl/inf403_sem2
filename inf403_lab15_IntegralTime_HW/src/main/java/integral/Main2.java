package integral;

public class Main2 {
    public static void main(String[] args) {

        Thread task1 = new Thread(new MyTask2(1));
        Thread task2 = new Thread(new MyTask2(2));
        Thread task3 = new Thread(new MyTask2(3));
        Thread task4 = new Thread(new MyTask2(4));
        Thread task5 = new Thread(new MyTask2(5));

        task1.start();
        task2.start();
        task3.start();
        task4.start();
        task5.start();

    }



    //Описать задачу
    static class MyTask2 implements Runnable {
        private int index;

        public MyTask2 (int index) {
            this.index = index;
        }
        //Задача
        public void run()  {
            System.out.println("Привет из параллельной реальности! " + index);
        }
    }
}