package hw2;

import java.util.Arrays;
 
public class countSort
{
    public static void main(String[] args)
    {
        int[] arr = { 7, 3, 0, 9, 8, 4, 7, 5, 3, 2, 1, 10 };
 
        // диапазон элементов массива
        int k = 10;
 
        countsort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    /*
     `arr` ——> входной целочисленный массив для сортировки
       `k` ——> такое число, что все целые числа находятся в диапазоне `0…k-1`
    */
    public static void countsort(int[] arr, int k)
    {
        // создаем целочисленный массив размером `k + 1` для хранения счетчика каждого целого числа
        // во входном массиве
        int[] count = new int[k + 1];
 
        // используя значение каждого элемента входного массива в качестве индекса,
        // сохраняем счетчик каждого целого числа в `count[]`
        for (int i: arr) {
            count[i]++;
        }
 
        // перезаписываем входной массив в порядке сортировки
        int index = 0;
        for (int i = 0; i < k + 1; i++)
        {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
}