package geeksforgeeks.drawshapes;

public class Rectangle {

    private static final String DOT = " * ";
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void draw() {
        System.out.println("-----------------------------");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(DOT);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 10);
        rectangle.draw();
    }
}
