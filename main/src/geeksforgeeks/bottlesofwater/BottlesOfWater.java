package geeksforgeeks.bottlesofwater;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Being greedy for Water
 *
 * You are given container full of water. Container can have limited amount of water. You also have N
 *
 * bottles to fill. You need to find the maximum numbers of bottles you can fill.
 *
 * Input:
 * First line contains one integer, T
 * , number of test cases.
 * First line of each test case contains two integer, N and X, number of bottles and capacity of the container.
 * Second line of each test case contains N
 *
 * space separated integers, capacities of bottles.
 *
 * Output:
 * For each test case print the maximum number of bottles you can fill.
 *
 * Constraints:
 * 1≤T≤100
 *
 * 1≤N≤104
 * 1≤X≤109
 * 1≤capacitiesofbottles≤106
 */
public class BottlesOfWater {

    public int numberOfBottlesFilled(int containerCapacity, int[] bottleSizes) {
        Arrays.sort(bottleSizes);

        int numberOfBottlesFilled = 0;
        int index = 0;
        while (containerCapacity > 0) {
            containerCapacity -= bottleSizes[index++];
            if (containerCapacity > 0) {
                numberOfBottlesFilled++;
            }
        }

        return numberOfBottlesFilled;
    }

    public static void main(String[] args) throws FileNotFoundException {
        BottlesOfWater bottlesOfWater = new BottlesOfWater();

        Scanner scanner = new Scanner(
            new File("C:\\Programming\\algorithms-data-structures\\main\\src\\geeksforgeeks" + "\\bottlesofwater\\input.txt"));

        int testCases = scanner.nextInt();
        while (testCases > 0) {
            int numberOfBottles = scanner.nextInt();
            int capacityOfContainer = scanner.nextInt();
            int[] bottleSizes = new int[numberOfBottles];
            for (int i = 0; i < numberOfBottles; i++) {
                bottleSizes[i] = scanner.nextInt();
            }
            System.out.println(bottlesOfWater.numberOfBottlesFilled(capacityOfContainer, bottleSizes));
            testCases--;
        }
    }
}
