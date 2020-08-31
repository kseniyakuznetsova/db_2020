package homework;

public class DynamicIntegerArrayIml implements DynamicIntegerArray {

    private int[] arr;
    private int size;
    private int capacity;
    private int capacityStep = 3;

    public DynamicIntegerArrayIml(){
        arr = new int[capacityStep];
        size = 0;
        capacity = capacityStep;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public void add(int value) {
        if (size == capacity){
            increaseCapacity();
        }
        arr[size] = value;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseCapacity(){
        int[] newArr = new int[capacity * capacityStep];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        capacity *= capacityStep;
    }
}
