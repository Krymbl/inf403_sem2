package privateVersion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JSONMapper {

    public String toJson(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fields = obj.getClass().getDeclaredFields();
        //Получаем все поля класса
        StringBuilder sb = new StringBuilder("{");
        for (Field f : fields) {
            // "fieldName":
            sb.append("\"").append(f.getName()).append("\":");
            /*f.setAccessible(true);
            f.get(obj);
             */

            //ищем геттер для поля, для получения знаения

            Method getter = obj.getClass().getMethod("get" +
                    f.getName().toUpperCase().charAt(0) +
                    f.getName().substring(1));

            // значение получаем вызовом геттера getter.invoke(obj)
            if (f.getType().equals(String.class)) {
                sb.append("\"").append(getter.invoke(obj)).append("\"");
            } else if (f.getType().getSuperclass().equals(Number.class)) {
                sb.append((getter.invoke(obj)).toString());
            } else {
                sb.append("\"").append(getter.invoke(obj).toString()).append("\"");
            }
            sb.append(',');
        }
        int pos = sb.length();
        sb.replace(pos - 1, pos, "}");
        return sb.toString();
    }

    public Object parseJson(String json, Class clazz) {
        return null;
    }

}