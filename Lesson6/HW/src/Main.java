import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, Integer> myTreeMap = new MyTreeMap<>();
//        myTreeMap.put(5, 5);
//        myTreeMap.put(3, 3);
//        myTreeMap.put(7, 7);
//        myTreeMap.put(4, 4);
//        myTreeMap.put(6, 6);
//        myTreeMap.put(8, 8);
//        myTreeMap.put(9, 9);
//        myTreeMap.put(2, 2);
//        myTreeMap.put(1, 1);
//        //myTreeMap.put(10,10);
//        System.out.println(myTreeMap.size());
//        System.out.println(myTreeMap);
//        System.out.println(myTreeMap.isBalanced());

        int balanced = 0;
        int treeNum = 100000;
        for (int i = 0; i < treeNum; i++) {
            MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
            Random random = new Random();
            while (treeMap.height() < 6) {
                treeMap.put(random.nextInt(200) - 100, 0);
            }
            if (treeMap.isBalanced()) {
                balanced++;
            }
        }
        int unbalanced = treeNum - balanced;
        System.out.printf("balanced: %d, unbalanced: %d%n%.2f%%",balanced,unbalanced,(double)balanced/treeNum*100);
    }
}
