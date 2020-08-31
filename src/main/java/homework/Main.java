package homework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DynamicIntegerArray arr = new DynamicIntegerArrayIml();
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
