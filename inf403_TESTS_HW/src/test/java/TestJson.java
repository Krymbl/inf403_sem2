import org.example.Json;
import org.junit.jupiter.api.BeforeAll; // Для инициализации перед всеми тестами
import org.junit.jupiter.api.Test; // Для создания тестовых методов
import org.junit.jupiter.params.ParameterizedTest; // Для параметризованных тестов
import org.junit.jupiter.params.provider.CsvSource; // Для данных тестов в CSV формате


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals; // Для проверки равенства
import static org.junit.jupiter.api.Assertions.assertThrowsExactly; // Для проверки исключений

public class TestJson {
    static Json json;
    @BeforeAll // Выполняется один раз перед всеми тестами
    public static void init(){
        json = new Json();
    }

    @ParameterizedTest // Тест с параметрами
    @CsvSource({
            "bookings.json, 30381", // Имя файла и ожидаемый результат
    })
    void testJsonTrue(String name, int res) throws FileNotFoundException { //Параметризованный тест testJsonTrue()

        assertEquals(res, json.getJsonFile(name)); // проверяет, что метод возвращает ожидаемое значение (30381) для файла bookings.json.

    }
    @Test
    void testJsonException1( ){ //Проверяет, что при отсутствии файла выбрасывается FileNotFoundException.
        assertThrowsExactly(FileNotFoundException.class,
                () -> {json.getJsonFile("simple.json");});
    }
    @Test
    void testJsonException2( ){ //Проверяет, что при пустом имени файла выбрасывается NullPointerException.
        assertThrowsExactly(NullPointerException.class,
                () -> {json.getJsonFile("");});
    }
    @Test
    void testJsonException3( ){ //Проверяет, что происходит передача бинарного файла вместо текстового
        assertThrowsExactly(IllegalArgumentException.class,
                () -> {json.getJsonFile("photo_5253625248421631610_y.bin");});
    }

}
