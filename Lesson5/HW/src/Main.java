import java.util.Random;

import static java.lang.Math.max;

public class Main {
    private static Item[] items;
    private static final int backpackCapacity = 10;

    public static void main(String[] args) {
        System.out.println(power(2,16));

        int numItems = 5;
        int bound = 10;
        items = new Item[numItems];
        Random random = new Random();
        for (int i = 0; i < numItems; i++) {
            items[i] = new Item(random.nextInt(bound) + 1, random.nextInt(bound) + 1);
        }

        for (int i = 0; i < numItems; i++) {
            System.out.print(items[i]);
        }
        System.out.println();
        System.out.println(findMaxValue(items.length - 1, backpackCapacity));
    }

    private static int findMaxValue(int i, int backpackCapacity) {
        if (i < 0) {
            return 0;
        }
        if (items[i].getWeight() > backpackCapacity) {
            return findMaxValue(i - 1, backpackCapacity);
        } else {
            return max(findMaxValue(i - 1, backpackCapacity),
                    findMaxValue(i - 1, backpackCapacity - items[i].getWeight()) + items[i].getValue());
        }
    }

    private static long power(int base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        return power(base, --exponent) * base;
    }


}
