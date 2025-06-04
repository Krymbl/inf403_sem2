package Unknown;

public class Main {
    public static void main(String[] args) {

        Thread task1 = new MyTaskThread(1);
        Thread task2 = new MyTaskThread(2);
        Thread task3 = new MyTaskThread(3);
        Thread task4 = new MyTaskThread(4);
        Thread task5 = new MyTaskThread(5);

        task1.start();
        task2.start();
        task3.start();
        task4.start();
        task5.start();

    }

    //Описать задачу
    static class MyTaskThread extends Thread {
        private int index;

        public MyTaskThread(int index) {
            this.index = index;
        }
        //Задача
        public void run()  {
            System.out.println("Привет из параллельной реальности! " + index);
        }
    }
}