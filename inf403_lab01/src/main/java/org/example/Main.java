package org.example;

public class Main {
    public static void main(String[] args) {
        List403Impl arr = new List403Impl();

        //Добавление элемента на последнее место, метод add
        arr.add(1);
        arr.add(5);
        arr.add(2);
        arr.add(7);
        arr.add(8);
        arr.add(3);
        arr.add(9);
        arr.add(0);
        arr.add(10);

        //Добавление элемента на определенную позицию, метод add с позицией
        try {
            arr.add(4, -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы зашли за пределы массива при попытке добавить элемент\n");
        }

        arr.add(5);
        System.out.println("Исходный массив: " + arr);
        //Получаем размер массива, метод size
        System.out.println("Размер массива: " + arr.size());

        //Удаление элемента на определенной позиции, метод remove
        int n = 4;
        Boolean rem = true;
        try {
            arr.remove(n);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Вы зашли за пределы массива при попытке удалить элемент");
            rem = false;
        } finally {
            if (rem) {
                System.out.println("Массив после удаления элемента на " + (int) (n + 1) + " позиции: " + arr);
            }
                }

            //Сортировка по убыванию, метод sort
            arr.sort(false);
            System.out.println("Отсортированный по убыванию: " + arr);

            //Сортировка по возрастанию, метод sort
            arr.sort(true);
            System.out.println("Отсортированный по возрастанию: " + arr + "\n");

            //Получаем элемента массива i индекса
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        }
    }