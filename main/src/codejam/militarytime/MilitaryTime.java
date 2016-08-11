package codejam.militarytime;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oscar on 7/6/16.
 */
public class MilitaryTime {
    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/militarytime/input.txt"));
        String timeStr = in.next();
        String amPm = timeStr.substring(timeStr.length()-2, timeStr.length());

        String[] timeElements = timeStr.split(":|[^0-9]");
        int hours = Integer.parseInt(timeElements[0]);
        if(amPm.equalsIgnoreCase("pm")) {
            hours+=12;
            String hoursStr;
            if(hours >=24) {
                hoursStr = "12";
            } else {
                hoursStr = Integer.toString(hours);
            }
            timeElements[0] = hoursStr;
        } else {
            if(hours == 12) {
                timeElements[0] = "00";
            }
        }
        System.out.print(timeElements[0]+":"+timeElements[1]+":"+timeElements[2]);
    }
}
