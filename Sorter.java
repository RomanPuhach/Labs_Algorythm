package com.company;

import com.company.sorts.Block_merge_sort;
import com.company.sorts.Bucket_sort;
import com.company.sorts.Introsort;
import com.company.sorts.Quicksort_inser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Sorter {
    public long[] sort(int[] input){
        long stats[] = new long[6];
        long start;
        long finish;
        long timeConsumedMillis;
        // Вариант 12, первая сортировка "TimSort"
        Integer [] example1 = IntStream.of(input).boxed().toArray(Integer []::new); //перевод примитивов в обёртку для вызова TimSort сортировки

        System.out.println("TimSort started");
        start = System.currentTimeMillis();

        Arrays.sort(example1); // Алгоритм TimSort используется в стандартном методе Arrays.sort для массива объектов

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("TimSort finished. Time: "+timeConsumedMillis + " ms");
        stats[0] = timeConsumedMillis;


        // Вариант 12, вторая сортировка аналог "STL::stable-sort"
        int [] example2 = input.clone();

        System.out.println("StableSort started");
        start = System.currentTimeMillis();

        Arrays.sort(example2); // Arrays.sort для массива примитивов использует аналог "STL::stable-sort"

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("StableSort finished. Time: "+timeConsumedMillis + " ms");
        stats[1] = timeConsumedMillis;


        // Вариант 12, Третья сортировка PigeonholeSort
        int [] example3 = input.clone();
        System.out.println("Quicksort sort started");
        start = System.currentTimeMillis();


        Bucket_sort.Bucket_sort(example3,Bucket_sort.maxValue(example3));


        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("Quicksort finished. Time: "+timeConsumedMillis + " ms");
        stats[2] = timeConsumedMillis;


        // Вариант 12, четвёртая сортировка Quicksort
        int [] example4 = input.clone();
        System.out.println("QuickSort started");
        start = System.currentTimeMillis();

        Quicksort_inser.quicksort3PivotBasic(example4,Quicksort_inser.minValue(example4) ,Quicksort_inser.maxValue(example4));

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("QuickSort finished. Time: "+timeConsumedMillis + " ms");
        stats[3] = timeConsumedMillis;


        // Вариант 12, пятая сортировка IntroSort
        int [] example5 = input.clone();
        System.out.println("IntroSort started");
        start = System.currentTimeMillis();

        Introsort.sort(example5);

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("IntroSort finished. Time: "+timeConsumedMillis + " ms");
        stats[4] = timeConsumedMillis;


        // Вариант 12, шестая сортировка аналог "STL::sort"
        int [] example6 = input.clone();
        System.out.println("Sort started");
        start = System.currentTimeMillis();

        Block_merge_sort.sort(example6);

        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("Sort finished. Time: "+timeConsumedMillis + " ms");
        stats[5] = timeConsumedMillis;


        return stats;// возврат массива элементов, где каждый элемент обозначает время, затраченное на сортировку
    }

    public static void pigeonhole_sort(int arr[], int n)
    {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for(int a=0; a<=n; a++)
        {
            if(arr[a] >= max)
                max = arr[a];
            if(arr[a] <= min)
                min = arr[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i<=n; i++)
            phole[arr[i] - min]++;


        index = 0;

        for(j = 0; j<=range; j++)
            while(phole[j]==0)
                arr[index++]=j+min;

    }

    public static int maxValue(int[] sequence)
    {
        int maxValue = 0;
        for (int i = 0; i <= sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];

        return maxValue;
    }
}