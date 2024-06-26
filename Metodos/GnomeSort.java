package Metodos;

import java.util.Arrays;

//Tomado de: https://github.com/argonautica/sorting-algorithms/blob/master/Java/GnomeSort.java

public class GnomeSort {

    /*public static void main(String[] args){
        int[] arr = {1,6,23,5,8,2,43,35};
        System.out.println(Arrays.toString(arr));
        gnomeSort(arr);
        System.out.println(Arrays.toString(arr));

    }*/


    public static void gnomeSort(int[] arr){
        int pos = 0;
        int size = arr.length;
        while(pos < size){
            if(pos == 0 || arr[pos] >= arr[pos-1]){
                pos ++;
            }
            else{
                swap(arr, pos, pos - 1);
                pos--;
            }
        }
    }

    public static void swap(int[] arr, int p1, int p2){
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}

