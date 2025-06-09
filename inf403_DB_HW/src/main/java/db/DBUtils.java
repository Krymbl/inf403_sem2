package db;

import org.example.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Задачи
 * 1. Записать данные в конец файла
 * 2. Прочитать данные с указанным id
 * 3. Изменить флаг актуальности
 * 4. Удалить
 * 5. Сделать индекс:
 */


public class DBUtils {
    public static final String TABLE = "C:\\Users\\dasts\\Desktop\\Itis\\lol\\inf403_sem2\\inf403_DB_HW\\src\\main\\java\\db\\student.tbl";

    public static void appendObject(Student student){
        // Сериализация
        byte[] studentData = null;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(student);
            studentData = bos.toByteArray();



        }catch (IOException e){
            e.printStackTrace();
        }



        File file = new File(TABLE);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true))) {

            dos.writeInt(student.getId());
            dos.writeByte(1);
            dos.writeInt(studentData.length);
            dos.write(studentData);

            dos.flush();

        }catch (IOException e){
            throw new RuntimeException("Не удалось записать данные");

        }
    }

    public static List<Student> readAll(){
        List<Student> res = new ArrayList<>();
        File file = new File(TABLE);

        if (!file.isFile()){
            return null;
        }

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file)
        )){

            while (true){
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                byte[] data = new byte[size];

                dis.read(data);

                if (flag == 1){
                    try (ObjectInputStream ois = new ObjectInputStream(
                            new ByteArrayInputStream(data)
                    )){
                        Student student = (Student) ois.readObject();
                        res.add(student);
                    }
                }
            }

        }catch (EOFException e){
        }
        catch (IOException | ClassNotFoundException  e){
            e.printStackTrace();
        }
        return res;
    }

    public static long findPosition(int searchId) {
        long position = 0;
        boolean searchFlag = false;
        // читаем файл, пока не найдем нужный id
        File file = new File(TABLE);
        if (!file.exists()) {
            return -1;
        }
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))) {
            while (true) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                dis.skipBytes(size);
                if (flag == 1 && id == searchId) {
                    searchFlag = true;
                    break;
                }
                position += 4 + 1 + 4 + size;
            }
        } catch (EOFException e) {}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (searchFlag)
            return position;
        else
            return -1;
    }

    public static void editStudent(Student student) {
        long position = findPosition(student.getId());
        // Меняем 1 байт в файле
        File file = new File(TABLE);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(position + 4);
            raf.write(0); // Write byte 0 (overwrites original byte at this offset).
            //raf.read();
            //raf.readInt();
            //raf.readByte();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        appendObject(student);
    }


//    public static Student readByID(int id){
//        long position = findPosition(id);
//
//        File file = new File(TABLE);
//
//        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}