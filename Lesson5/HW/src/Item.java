public class Item {
    private int weight;
    private int value;

    public Item(int value, int mass) {
        this.weight = mass;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "["+value+","+weight+"]";
    }
}
