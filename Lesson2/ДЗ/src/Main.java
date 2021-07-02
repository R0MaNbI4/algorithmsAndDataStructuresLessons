import java.lang.reflect.Method;
import java.util.Random;

import static java.lang.Math.ceil;

public class Main {
    private static final int NUMBER_ELEMENTS = 100000;
    private static final double PROPORTION_OF_SORTED_DATA = 0.95; // [0;1]

    private static final MyArrayList<Integer> myArrayList = new MyArrayList<>(NUMBER_ELEMENTS);
    private static long timer;
    private static MyArrayList<Integer> dataset;

    public static void main(String[] args) {
        /*
        Случайный набор данных
        bubbleSort: 47.803 seconds
        selectionSort: 13.481 seconds
        insertionSort: 16.751 seconds

        На 50% отсортированный набор данных
        bubbleSort: 34.514 seconds
        selectionSort: 16.504 seconds
        insertionSort: 8.319 seconds

        На 95% отсортированный набор данных
        bubbleSort: 21.46 seconds
        selectionSort: 16.583 seconds
        insertionSort: 0.754 seconds
         */
        dataset = createDataset(NUMBER_ELEMENTS, PROPORTION_OF_SORTED_DATA);
        System.out.println(getSortingTime("bubbleSort", dataset));
        System.out.println(getSortingTime("selectionSort", dataset));
        System.out.println(getSortingTime("insertionSort", dataset));

    }

    private static String getSortingTime(String sortAlgorithmName, MyArrayList<Integer> dataset) {
        Method sortAlgorithm;
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.set(dataset);
        restartTimer();
        try {
            sortAlgorithm = MyArrayList.class.getMethod(sortAlgorithmName);
            sortAlgorithm.invoke(myArrayList);
        } catch (Exception e) {
            throw new RuntimeException("SWW");
        }
        return String.format("%s: %s seconds", sortAlgorithmName, (double) getTimerTime() / 1000);
    }

    private static void restartTimer() {
        timer = System.currentTimeMillis();
    }

    private static long getTimerTime() {
        return System.currentTimeMillis() - timer;
    }

    private static MyArrayList<Integer> createDataset(int size, double proportionOfSortedData) {
        if (proportionOfSortedData < 0 || proportionOfSortedData > 1) {
            throw new IllegalArgumentException(String.format("proportionOfSortedData: %d. Must be between 0 and 1", proportionOfSortedData));
        }
        int sortedDataSize = (int) (proportionOfSortedData * size);
        int randomDataSize = (int) ceil(((1 - proportionOfSortedData) * size));
        MyArrayList<Integer> dataset = new MyArrayList<>();

        if (sortedDataSize != 0) {
            dataset.add(createSortedDataset(sortedDataSize));
        }

        Random random = new Random();
        for (int i = 0; i < randomDataSize; i++) {
            dataset.add(random.nextInt(dataset.size()), random.nextInt(size * 10));
        }
        return dataset;
    }

    private static MyArrayList<Integer> createSortedDataset(int size) {
        MyArrayList<Integer> dataset = new MyArrayList<>(size);
        Random random = new Random();
        Integer item;
        int idx;
        for (int i = 0; i < size; i++) {
            item = random.nextInt(size * 10);
            idx = 0;
            while (idx < dataset.size() && item.compareTo(dataset.get(idx)) >= 0) {
                idx++;
            }
            dataset.add(idx, item);
        }
        return dataset;
    }
}