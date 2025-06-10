package org.example;

import java.lang.reflect.Field;

public class JSONMapper {

    public String toJson(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getFields();
        StringBuilder sb = new StringBuilder("{");
        for (Field f : fields) {
            // "fieldName":
            sb.append("\"").append(f.getName()).append("\":");
            // значение
            if (f.getType().equals(String.class)) {
                sb.append("\"").append(f.get(obj)).append("\"");
            } else if (f.getType().getSuperclass().equals(Number.class)) {
                sb.append(f.get(obj).toString());
            } else {
                sb.append("\"").append(f.get(obj).toString()).append("\"");
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