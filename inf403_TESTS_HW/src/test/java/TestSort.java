import org.example.Sort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSort {
    @ParameterizedTest // Указывает, что это параметризованный тест (будет запущен для каждого набора данных)
    @CsvSource({ // Задает входные данные в формате CSV (каждая строка — отдельный тест)

            "'1 2 4 5 6 9', '1 2 4 5 6 9'", //входной массив и ожидаемый результат
            "'2 1 1 3 4', '1 1 2 3 4'" //входной массив и ожидаемый результат
    })
    void testSort(String arrS, String resS){ // Метод теста, принимает 2 строки: вход и ожидаемый результат
        int[] arr = Arrays.stream(arrS.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] res = Arrays.stream(resS.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertArrayEquals(res, Sort.sort(arr)); // Проверяет, что результат Sort.sort(arr) равен res
    }
}
