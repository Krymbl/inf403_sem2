package org.example;

import java.util.*;

public class Graph implements Iterable<Character> {
    private Map<Character, Set<Character>> graph = new HashMap();
    //Граф представлен в виде словаря HashMap, где:
    //Ключ (Character) — вершина графа.
    //Значение (Set<Character>) — множество вершин, от которых зависит текущая вершина.

    public Graph(){
        graph = new HashMap<>();  //Инициализирует граф, задавая зависимости между вершинами.
        graph.put('d', new HashSet<>());
        graph.put('a', new HashSet<>(Set.of('d', 'c')));
        graph.put('f', new HashSet<>(Set.of('d')));
        graph.put('g', new HashSet<>(Set.of('d', 'c', 'f')));
        graph.put('c', new HashSet<>());
        graph.put('b', new HashSet<>(Set.of('g', 'f', 'c', 'a')));
    }

    public Set<Character> topolSort(){
        Set<Character> res = new LinkedHashSet<>(); //результат сортировки (вершины в порядке топологической сортировки)
        Map<Character, Set<Character>> temp = new HashMap<>(); //временная копия графа для работы.

        //копирование графа во временную структуру
        for (Map.Entry<Character, Set<Character>> elem: graph.entrySet()){
            temp.put(elem.getKey(), elem.getValue() == null ? null : new HashSet<>(elem.getValue()));
        }


        // пока HashMap не пустой совершаем итерации
        while (!temp.isEmpty()){
            Character removeChar = null;

            // Поиск вершины без зависимостей
            for (Map.Entry<Character, Set<Character>> etr: temp.entrySet()){
                if (etr.getValue() == null || etr.getValue().isEmpty()) {
                    removeChar = etr.getKey();
                    break;
                }
            }

            //если вершины нет, выбрасываем ошибку, что граф цикличный
            if (removeChar == null){
                throw new RuntimeException("Граф содержит циклы!");
            }

            //добавляем вершину в результат
            res.add(removeChar);
            //удаляем вершину из графа
            temp.remove(removeChar);

            //удаляем вершину из множеств (зависимости других вершин)
            for (Set<Character> set: temp.values()){
                if (set != null){
                    set.remove(removeChar);
                }
            }
        }
        return res;
    }

    @Override
    public Iterator<Character> iterator(){
        Character[] arr = topolSort().toArray(new Character[0]); // преобразует результат сортировки в массив.

        return new Iterator<Character>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public Character next() {
                return arr[index++];
            }
        };
    }

}