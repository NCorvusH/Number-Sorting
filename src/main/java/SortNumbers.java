import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type any letter to finish):");
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num == 4) {
                    System.out.println("Number 4 is not allowed.");
                } else {
                    numbers.add(num);
                }
            } else {
                scanner.next(); // Consume the non-integer input
                break;
            }
        }

        System.out.println("Select the sorting order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int choice = scanner.nextInt();

        quickSort(numbers, 0, numbers.size() - 1);

        if (choice == 2) {
            Collections.reverse(numbers);
        }

        System.out.println("Sorted list: " + numbers);
    }

    // QuickSort algorithm implementation
    public static void quickSort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {
                i++;
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, i + 1, high);
        return i + 1;
    }
}