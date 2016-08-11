package codejam.simpletexteditor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by oscar on 7/10/16.
 */
public class SimpleTextEditor {

    private StringBuilder stringBuilder;
    private Stack<String> strHistory;
    private String currentString = "";

    public SimpleTextEditor() {
        stringBuilder = new StringBuilder();
        strHistory = new Stack<>();
    }

    public void executeAppend(String string) {
        stringBuilder.append(string);
        strHistory.push(currentString);
        currentString = stringBuilder.toString();
    }

    public void executeDelete(int k) {
        stringBuilder.delete(stringBuilder.length() - k, stringBuilder.length());
        strHistory.push(currentString);
        currentString = stringBuilder.toString();
    }

    public void executePrint(int k) {
        System.out.println(stringBuilder.charAt(k - 1));
    }

    public void executeUndo() {
        if (!strHistory.empty()) {
            currentString = strHistory.pop();
            stringBuilder.replace(0, stringBuilder.length(), currentString);
        }
    }

    private void printString() {
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {
        SimpleTextEditor textEditor = new SimpleTextEditor();
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/simpletexteditor/input.txt"));

        int numOfOperations = in.nextInt();

        int type;
        while (in.hasNextInt()) {
            type = in.nextInt();
            if (type == 1) {
                textEditor.executeAppend(in.next());
            } else if (type == 2) {
                textEditor.executeDelete(in.nextInt());
            } else if (type == 3) {
                textEditor.executePrint(in.nextInt());
            } else if (type == 4) {
                textEditor.executeUndo();
            }
        }
    }
}
