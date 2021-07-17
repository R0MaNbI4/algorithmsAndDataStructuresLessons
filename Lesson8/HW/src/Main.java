import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        int x = Integer.MIN_VALUE+1;
//        System.out.println(x);
//        System.out.println((x+1) & 0x7fffffff);
//        System.out.println(Math.abs(x));
//        System.out.println(~(x)+1);
//        System.out.println(-x);

//        int capacity = 8;
//        double loadFactor = 1;
//        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(capacity);
//        Random random = new Random();
//        for (int i = 0; i < capacity * loadFactor; i++) {
//            chm.put(random.nextInt(1000), "");
//        }
//        System.out.println(chm);

        ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(4);
        for (int i = 0; i < 8; i++) {
            chm.put(i, "");
        }
        System.out.println(chm);
        chm.delete(0);
        chm.delete(7);
        System.out.println(chm);
    }
}
