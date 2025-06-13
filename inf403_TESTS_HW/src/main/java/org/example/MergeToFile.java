package org.example;

import java.io.*;

public class MergeToFile {
    public static void main(String[] args) {
        connectFile("Texst.txt", "orig.jpg");
    }
    public static long connectFile(String nameTXT, String nameBIN) { //объединение файлов
        try(InputStream isT = new FileInputStream(nameTXT);
            InputStream isB = new FileInputStream(nameBIN);
            OutputStream os = new FileOutputStream("res.txt")){

            // Чтение и запись текстового файла (nameTXT)
            int r;
            byte[] buffer01 = new byte[1024];
            while ((r = isT.read(buffer01)) > -1){
                os.write(buffer01, 0, r);
            }

            // Чтение и запись бинарного файла (nameBIN)
            byte[] buffer02 = new byte[1024];
            while ((r = isB.read(buffer02)) > -1){
                os.write(buffer02, 0, r);
            }
            File file = new File("res");

            return file.length();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static byte[] chekFile(String nameFile){ //чтение всего файла
        try(InputStream is = new FileInputStream(nameFile)){
            byte[] buffer = is.readAllBytes(); // Читает все байты файла в массив
            return buffer;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static byte[] chekPathFile(String nameFile, long start, long border){ //чтение части файла
        try(FileInputStream is = new FileInputStream(nameFile)){
            is.skip(start); // Пропускаем `start` байт
            byte[] buffer = is.readNBytes((int) (border - start)); // Читаем `border - start` байт
            return buffer;

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }




}
