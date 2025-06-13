import org.example.MergeToFile;
import org.junit.jupiter.api.BeforeAll; // Аннотация для инициализации перед тестами
import org.junit.jupiter.api.Test; // Для создания тестовых методов

import java.io.File;


import static org.junit.jupiter.api.Assertions.*; // Статические методы для проверок (assertEquals и др.)

public class TestMergeToFile {
    static String fileTXT = "Texst.txt";
    static String fileBIN = "orig.jpg";
    static long sizeTXT;
    static long sizeBIN;
    static long sizeRES = (new File("res.txt")).length();

    @BeforeAll // Выполняется один раз перед всеми тестами
    static void init() {

        sizeTXT = (new File(fileTXT)).length();
        sizeBIN = (new File(fileBIN)).length();


    }
    @Test
    void testMergeTrue(){ // Проверяет, что размер объединенного файла = сумме исходных
        assertEquals(sizeTXT + sizeBIN, // Ожидаемый размер
                MergeToFile.connectFile("Texst.txt", "orig.jpg")); // Реальный размер
        assertThrows(RuntimeException.class, // Проверяет, что при несуществующем файле выбрасывается исключение
                () -> {MergeToFile.connectFile("te.txt",
                        "full-moon-clouds-pink-sky-scenic-aesthetic-3840x2160-1653.jpg");});
    }
    @Test
    void testCheckArrays() {
        assertArrayEquals(MergeToFile.chekPathFile("res.txt", 0, sizeTXT), // Сравнивает начало файла "res" (первые sizeTXT байт) с "text.txt"
                MergeToFile.chekFile("Texst.txt"));

        assertArrayEquals(MergeToFile.chekPathFile("res.txt", sizeTXT, sizeRES), // Сравнивает вторую часть с бинарными данными
                 MergeToFile.chekFile("orig.jpg"));
    }


}
