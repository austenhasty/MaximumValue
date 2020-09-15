import java.util.*;

public class MaximumValue {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int items = s.nextInt();
        int capacity = s.nextInt();
        int[] value = new int[items];
        int[] weight = new int[items];
        for (int i = 0; i < value.length; i++) {
            value[i] = s.nextInt();
            weight[i] = s.nextInt();
        }
        System.out.println(getValue(capacity, value, weight));
    }

    public static double getValue(int capacity, int[] value, int[] weight) {
        double bag = 0.00;
//        while (capacity > 0) {
            for (int i = 0; i < weight.length; i++) {
                int bestItem = bestValue(value, weight);
                System.out.println(bestItem);
                if (weight[bestItem] < capacity) {
                    bag = bag + value[bestItem];
                    capacity = capacity - weight[bestItem];
                    weight[bestItem] = 0;
                }
                if (weight[bestItem] > capacity) {
                    value[bestItem] = value[bestItem] * (capacity / weight[bestItem]);
                    bag = bag + value[bestItem];
                    capacity = 0;
                    weight[bestItem] = 0;
                }
            }
 //
        return bag;
    }

    private static int bestValue(int[] value, int[] weight) {
        int max = 0;
        double maxValue = 0;
        for (int i = 0; i < weight.length; i++) {
            if (weight[i] != 0 && (double) value[i] / weight[i] > maxValue) {
                maxValue = (double) value[i] / weight[i];
                max = i;
            }
        }
        return max;
    }
}
