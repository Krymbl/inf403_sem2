package mapIterator;

import example.Map;

public class Main {
    public static void main(String[] args) {

        MapImplIterator<Integer, String> map = new MapImplIterator<>();
        map.put(16,"16"); map.put(17,"17"); map.put(18,"18"); map.put(19,"19");
        map.put(20,"20"); map.put(21,"21"); map.put(22,"22"); map.put(23,"23");
        map.put(24,"24"); map.put(25,"25"); map.put(26,"26"); map.put(27,"27");
        map.put(28,"28"); map.put(29,"29"); map.put(30,"30"); map.put(31,"31");
        map.put(32,"32");

//        System.out.println("Получение значение по ключу 25: " + map.get(25));
//        System.out.println("Получение множества ключей: " + map.keySet());
//        System.out.println("Получение множества значений: " + map.values());
//        System.out.println("Получение размера мапы: " + map.size());
//        System.out.println("Есть ли в мапе элемент с ключом 17: " + map.containsKey(17));
//        System.out.println("Пустая ли мапа: " + map.isEmpty());
//        System.out.println("Проверка наличия значения 20: " + map.containsValue("20"));

        for(Map.Entry<Integer, String> n : map) {
            System.out.println("ключ: " + n.getKey() + ", значение: " + n.getValue());
        }

//        System.out.println("Удаление элемента по ключу 17: " + map.remove(17));
//        System.out.println();
//        System.out.println("Есть ли в мапе элемент с ключом 17 после удаления: " + map.containsKey(17));
//        System.out.println("Получение размера мапы после удаления элемента: " + map.size());
//        map.clear();
//        System.out.println("Очистка мапы и пустой ли он теперь: " + map.isEmpty());

    }
}
