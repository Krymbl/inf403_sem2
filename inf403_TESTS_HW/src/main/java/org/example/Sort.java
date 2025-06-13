package org.example;

public class Sort { //Выбором
    public static int[] sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i; j < arr.length; j++){
                min = (arr[min] > arr[j] ? j : min);
            }
            int step = arr[i];
            arr[i] = arr[min];
            arr[min] = step;
        }
        return arr;
    }
}
