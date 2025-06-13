package org.example;

import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать метод, считывающий файл JSON (имя файла передается через аргумент)
 * и определяющий корректность расставленных скобок {{}},
 * [] возвращает 0, если все правильно, или позицию проблемы (начиная с 1)
 * Метод должен бросать исключения
 * NullPointer если передали пустое имя файла
 * Исключение, если файл не найден,
 * Исключение, если файл не текстовый (проверка на буквы, цифры, знаки препинания)
 */

public class Json {



    //private String nameFile;
    public static int getJsonFile(String name) throws FileNotFoundException {
        File file = new File(name);
        if (name == "") { // Проверка на пустое имя файла
            throw new NullPointerException("передали пустое имя файла");
        }
        if (!file.exists()) { // Проверка существования файла
            throw new FileNotFoundException("файл не найден");
        }

        if (!findText(file)) { // Проверка, что файл текстовый
            throw new IllegalArgumentException("файл не текстовый");
        }
        // Чтение файла и извлечение скобок
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String line;
            String res = "";
            while ((line = bf.readLine()) != null){
                for(int i = 0; i < line.length(); i++){
                    // Фильтрация только скобок
                    if (openChar(line.charAt(i)) || closeChar(line.charAt(i))){
                        res += line.charAt(i);
                    }
                }
            }
            return getCheking(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static boolean findText(File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String string;

            // Регулярное выражение для проверки текстового содержимого:
            Pattern pattern = Pattern.compile("^[\\p{L}\\p{N}\\p{P}\\p{Z}\\r\\n\\t]*$");
            // c начала и до конца
            //l - любые буквы
            //n - любые цифры
            //p - любые пунктцации
            //z - любые пробелыые табулция и возврат
            while ((string = bf.readLine()) != null) {
                //Matcher — это "поисковик" для работы с регулярными выражениями.
                Matcher matcher = pattern.matcher(string);
                if (!matcher.find()) { // Если строка не соответствует шаблону
                    return false;
                }
            }
            return true;

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }



    }

    public static int getCheking(String line) {
        Stack<Character> stek = new Stack<>(); // Для отслеживания открывающих скобок
        char[] arr = line.toCharArray(); // Преобразование строки в массив символов
        Stack<Integer> posit = new Stack<>(); // Для хранения позиций скобок
        if (arr.length == 0){
            return 0;
        }

        stek.add(arr[0]);
        posit.add(0);
        for (int i = 1; i < arr.length; i++) {
            char step = arr[i];
            if(openChar(step)){ // Если скобка открывающая
                stek.add(step);
                posit.add(i);
            }else{  // Если скобка закрывающая
                if (!chek(stek.peek(), step)){ // Проверяем соответствие
                    System.out.println(stek);
                    return i; // Возвращаем позицию ошибки
                }
                stek.pop();
                posit.pop();
            }

        }
        if(stek.size() != 0){ // Если остались незакрытые скобки, возвращаем позицию первой незакрытой
            return posit.peek();
        }

        return 0; //Ошибок нет

    }

    public static boolean chek(Character ch1, char ch2) {
        if (ch1 != null && (ch1 - ch2 == '(' - ')' || ch1 - ch2 == '{' - '}' || ch1 - ch2 == '[' - ']')) {
            return true;
        }
        return false;
    }
    public static boolean openChar(Character ch1) {
        if (ch1 != null && (ch1 == '('  || ch1  == '{'  || ch1  == '[' )) {
            return true;
        }
        return false;
    }
    public static boolean closeChar(Character ch1) {
        if (ch1 != null && (ch1 == '('  || ch1  == '{'  || ch1  == '[' )) {
            return true;
        }
        return false;
    }

}

