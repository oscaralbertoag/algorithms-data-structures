package geeksforgeeks.drawshapes;

public class Circle {

    private static final String DOT = " * ";
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        int xCenter = radius;
        int yCenter = radius;
        System.out.println("-----------------------------");
        for (int x = 0; x < radius * 2; x++) {
            for (int y = 0; y < radius * 2; y++) {
                if (square(x - xCenter) + square(y - yCenter) < square(radius)) {
                    System.out.print(DOT);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    private int square(int i) {
        return i * i;
    }

    public static void main(String args[]) {
        Circle circle = new Circle(20);
        circle.draw();
    }
}
