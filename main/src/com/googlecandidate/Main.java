package com.googlecandidate;

import codejam.oldmagician.OldMagician;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int[] randomArray = {13, 45, 6, 77, 43, 765, 8, 234, 99, 1, 77, 0, 0, 0, 8, 8, 8};
//        ArrayUtil.print(randomArray);
//        // Sort
//        ArrayUtil.print(Merge.sort(randomArray));

        long start = System.currentTimeMillis();

        OldMagician oldMagician;

        Scanner scanner = null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")));){
            scanner = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/oldmagician/largeInput.txt"));

            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int white = scanner.nextInt();
                int black = scanner.nextInt();

                oldMagician = new OldMagician(black, white);
                String color = oldMagician.performTrick().toString();
                writer.write("Case #" + i + ": " + color);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (start-end)/1000 + "seconds");
    }
}
