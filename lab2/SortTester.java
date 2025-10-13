package lab2;

import java.util.Arrays;
import java.util.Random;

public class SortTester {

    public static void main(String[] args) {
        // Размеры тестовых массивов: малый, средний, большой
        int[] sizes = {100, 10_000, 1_000_000};

        // Проходим циклом по каждому размеру массива
        for (int size : sizes) {
            System.out.println("Размер массива: " + size);

            // Генерация массивов разной сложности для данного размера
            int[] randomArray = generateRandomArray(size);                           // Случайный массив (равномерное распределение)
            int[] partiallySorted75 = generatePartiallySortedArray(randomArray, 0.75); // Частично отсортированный массив (75%)
            int[] reverseSorted = generateReverseSortedArray(size);                   // Обратно отсортированный массив
            int[] manyDuplicates = generateArrayWithDuplicates(size, 0.1);            // Массив с множеством дубликатов (10% уникальных)
            int[] partiallySorted90 = generatePartiallySortedArray(randomArray, 0.9);  // Почти отсортированный массив (90%)

            // Тестируем все сортировки на каждом массиве
            testAllSorts("Случайный массив", randomArray);
            testAllSorts("Частично отсортированный (75%)", partiallySorted75);
            testAllSorts("Обратно отсортированный массив", reverseSorted);
            testAllSorts("Массив с множеством дубликатов (10% уникальных)", manyDuplicates);
            testAllSorts("Почти отсортированный массив (90%)", partiallySorted90);

            System.out.println();
        }
    }

    /**
     * Тестирует три алгоритма сортировки на копиях входного массива.
     * Выводит время выполнения в наносекундах и миллисекундах.
     */
    private static void testAllSorts(String description, int[] array) {
        System.out.println(description);

        // Тест сортировки вставками
        int[] arr1 = array.clone();
        long nanoTime1 = measureTimeNano(() -> InsertionSort.sort(arr1));
        System.out.printf("InsertionSort: %d нс (%.3f мс)%n", nanoTime1, nanoTime1 / 1_000_000.0);

        // Тест быстрой сортировки
        int[] arr2 = array.clone();
        long nanoTime2 = measureTimeNano(() -> QuickSort.sort(arr2));
        System.out.printf("QuickSort: %d нс (%.3f мс)%n", nanoTime2, nanoTime2 / 1_000_000.0);

        // Тест пирамидальной сортировки
        int[] arr3 = array.clone();
        long nanoTime3 = measureTimeNano(() -> HeapSort.sort(arr3));
        System.out.printf("HeapSort: %d нс (%.3f мс)%n", nanoTime3, nanoTime3 / 1_000_000.0);

        System.out.println();
    }

    /**
     * Замеряет время выполнения сортировки в наносекундах.
     * Проводит 5 запусков и возвращает лучшее время.
     */
    private static long measureTimeNano(Runnable sortingMethod) {
        long bestTime = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            sortingMethod.run();
            long end = System.nanoTime();
            long elapsed = end - start;
            if (elapsed < bestTime) bestTime = elapsed;
        }
        return bestTime;
    }

    /**
     * Генерирует случайный массив с равномерным распределением целых чисел.
     */
    private static int[] generateRandomArray(int size) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    /**
     * Генерирует частично отсортированный массив:
     * - fractionSorted часть массива будет отсортирована,
     * - оставшаяся часть перемешана случайно.
     */
    private static int[] generatePartiallySortedArray(int[] base, double fractionSorted) {
        int n = base.length;
        int sortedLength = (int)(fractionSorted * n);

        int[] arr = base.clone();             // Копируем базовый массив
        Arrays.sort(arr, 0, sortedLength);   // Сортируем первую часть

        Random rnd = new Random();
        // Перемешиваем остальные элементы после отсортированной части
        for (int i = sortedLength; i < n; i++) {
            int randomIndex = sortedLength + rnd.nextInt(n - sortedLength);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }

    /**
     * Создает обратно отсортированный массив по убыванию (size ... 1).
     */
    private static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    /**
     * Создает массив из size элементов с долей uniqueFraction уникальных случайных значений,
     * остальные — дубликаты этих значений.
     */
    private static int[] generateArrayWithDuplicates(int size, double uniqueFraction) {
        int uniqueCount = (int)(size * uniqueFraction);
        if(uniqueCount < 1) uniqueCount = 1;

        int[] uniqueValues = new int[uniqueCount];
        Random rnd = new Random();
        for (int i = 0; i < uniqueCount; i++) {
            uniqueValues[i] = rnd.nextInt();
        }

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = uniqueValues[rnd.nextInt(uniqueCount)];
        }
        return arr;
    }
}
