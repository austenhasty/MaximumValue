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
            for (int i = 0; i < weight.length; i++) {
                int bestItem = bestValue(value, weight);
                if (weight[bestItem] <= capacity) {
                    bag += value[bestItem];
                    capacity = capacity - weight[bestItem];
                    weight[bestItem] = -1;
                } else if (weight[bestItem] > capacity) {
                    System.out.println("HITTTT");
                    double frac = (double) capacity/weight[bestItem];
                    bag += value[bestItem] * frac;
                    capacity = 0;
                    weight[bestItem] = -1;
                }
            }
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
