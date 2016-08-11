package codejam.oldmagician;

import java.io.*;
import java.util.Scanner;

import static codejam.oldmagician.OldMagician.Ball.BLACK;
import static codejam.oldmagician.OldMagician.Ball.WHITE;
import static codejam.oldmagician.OldMagician.Rule.DIFFERENT_COLOR;
import static codejam.oldmagician.OldMagician.Rule.SAME_COLOR;

/**
 * Created by oscar on 6/18/16.
 */
public class OldMagician {
    int[] hat = new int[2];
    private static final int BLACK_INDEX = 0;
    private static final int WHITE_INDEX = 1;
    private int blackCount_hat = 0;
    private int whiteCount_hat = 0;
    private int blackCount_outOfHat = 0;
    private int whiteCount_outOfHat = 0;

    public enum Ball {
        WHITE, BLACK
    }

    protected enum Rule {
        SAME_COLOR, DIFFERENT_COLOR
    }

    private class Pair {
        Ball ballOne;
        Ball ballTwo;

        public Pair(Ball ballOne, Ball ballTwo) {
            this.ballOne = ballOne;
            this.ballTwo = ballTwo;
        }

        public Ball getBallOne() {
            return ballOne;
        }

        public Ball getBallTwo() {
            return ballTwo;
        }
    }

    public OldMagician(int blackBalls, int whiteBalls){
        if(blackBalls >= 0 && whiteBalls >= 0) {
            blackCount_hat = blackBalls;
            whiteCount_hat = whiteBalls;
        }
    }

    private Pair getNextPairFromHat() {
        Pair pair = null;

        // Try to always return black pairs first
        if (blackCount_hat > 1) {
            pair = new Pair(BLACK, BLACK);
            blackCount_hat -=2;
            blackCount_outOfHat +=2;
            returnBallToHat(SAME_COLOR);
        } else if(whiteCount_hat > 1) {
            pair = new Pair(WHITE, WHITE);
            whiteCount_hat -=2;
            whiteCount_outOfHat +=2;
            returnBallToHat(SAME_COLOR);
        } else {
            pair = new Pair(BLACK, WHITE);
            whiteCount_hat--;
            blackCount_hat--;
            whiteCount_outOfHat++;
            blackCount_outOfHat++;
            returnBallToHat(DIFFERENT_COLOR);
        }
            return pair;
    }

    private void returnBallToHat(Rule rule) {
        if(rule.equals(SAME_COLOR)) {
            // Return a white ball to the hat
            whiteCount_hat++;
            whiteCount_outOfHat--;

        } else {
            // Return a black ball to the hat
            blackCount_hat++;
            whiteCount_outOfHat--;
        }
    }

    public Ball performTrick(){
        while(whiteCount_hat + blackCount_hat > 1) {
            getNextPairFromHat();
        }
        if(whiteCount_hat > 0) {
            return WHITE;
        } else {
            return BLACK;
        }
    }

    public Ball performTrickEfficiently(){
        Ball ball = null;

        if(whiteCount_hat%2 == 0 && blackCount_hat%2 == 0) { // Both counts are even
            ball = WHITE;
        } else if(whiteCount_hat%2 != 0 && blackCount_hat%2 != 0) { // Both counts are odd
            ball = BLACK;
        } else if (whiteCount_hat%2 != 0) { // Odd # Whites (more W's and less W's)
            ball = WHITE;
        } else {
            ball = BLACK;
        }


        return ball;
    }

    public static void main(String[] args) {

        String inputPath = "/home/oscar/IdeaProjects/googleinterview/src/codejam/oldmagician/largeInput.txt";
        String outputPath = "/home/oscar/IdeaProjects/googleinterview/src/codejam/oldmagician/output.txt";
        long start = System.currentTimeMillis();

        OldMagician oldMagician;

        Scanner scanner = null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputPath)));){
            scanner = new Scanner(new File(inputPath));

            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int white = scanner.nextInt();
                int black = scanner.nextInt();

                oldMagician = new OldMagician(black, white);
                String color = oldMagician.performTrickEfficiently().toString();
                writer.write("Case #" + i + ": " + color);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start)+ " milliseconds");
    }
}
