package Sandbox;

public class ReferenceTest {

    public static void main(String[] args) {

        Integer[] array = new Integer[10];
        populateArray(array);
        printArray(array);
        increment(array);
        printArray(array);

        Integer myInteger = 1;

        System.out.println(myInteger);
        incrementInteger(myInteger);
        System.out.println(myInteger);

    }

    private static void incrementInteger(Integer myInteger) {
        myInteger++;
    }

    private static void populateArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void increment(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }

    public static void printArray(Integer[] array) {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");
    }

}
