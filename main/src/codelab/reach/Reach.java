package codelab.reach;

import java.util.List;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 *
 * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1), (x-1,y+1), (x+1,y-1)
 *
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which
 * you can achieve it. You start from the first point.
 *
 * Example :
 *
 * Input : [(0, 0), (1, 1), (1, 2)] Output : 2
 *
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 *
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output”
 * section.
 */
public class Reach {
    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public int coverPoints(List<Integer> X, List<Integer> Y) {
        Point current = null;
        Point next = null;
        Point destination;
        int steps = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            if (current == null) { // First iteration only
                current = new Point(X.get(i), Y.get(i));
            } else {
                current = next; // From previous step
            }
            destination = new Point(X.get(i + 1), Y.get(i + 1));

            if (isAdjacent(current, destination)) {
                next = destination;
                steps++;
            } else {
                do {
                    Point delta = delta(current, destination);
                    current = move(current, delta);
                    steps++;
                } while (!isAdjacent(current, destination));
                next = destination;
                steps++;
            }
        }
        return steps;
    }

    private Point move(Point current, Point delta) {
        boolean up = false;
        boolean down = false;
        boolean right = false;
        boolean left = false;

        if (delta.getX() < 0) {
            down = true;
        } else if (delta.getX() > 0) {
            up = true;
        }

        if (delta.getY() < 0) {
            right = true;
        } else if (delta.getY() > 0) {
            left = true;
        }

        Point next;
        if (down && right) {
            next = moveDownRight(current);
        } else if (down && left) {
            next = moveDownLeft(current);
        } else if (up && right) {
            next = moveUpRight(current);
        } else if (up && left) {
            next = moveUpLeft(current);
        } else if (down) {
            next = moveDown(current);
        } else if (up) {
            next = moveUp(current);
        } else if (right) {
            next = moveRight(current);
        } else {
            next = moveLeft(current);
        }
        return next;
    }

    protected boolean isAdjacent(Point current, Point destination) {
        int xDifference = current.getX() - destination.getX();
        int yDifference = current.getY() - destination.getY();

        boolean one_one = Math.abs(xDifference) == 1 && Math.abs(yDifference) == 1;
        boolean one_zero = Math.abs(xDifference) == 1 && yDifference == 0;
        boolean zero_one = xDifference == 0 && Math.abs(yDifference) == 1;

        return one_one || one_zero || zero_one;
    }

    protected boolean isDiagonal(Point current, Point destination) {
        int xDifference = current.getX() - destination.getX();
        int yDifference = current.getY() - destination.getY();

        return xDifference == yDifference;
    }

    protected Point delta(Point current, Point destination) {
        return new Point(current.getX() - destination.getX(), current.getY() - destination.getY());
    }

    protected Point moveUp(Point current) {
        return new Point(current.getX() - 1, current.getY());
    }

    protected Point moveDown(Point current) {
        return new Point(current.getX() + 1, current.getY());
    }

    protected Point moveRight(Point current) {
        return new Point(current.getX(), current.getY() + 1);
    }

    protected Point moveLeft(Point current) {
        return new Point(current.getX(), current.getY() - 1);
    }

    protected Point moveUpLeft(Point current) {
        return new Point(current.getX() - 1, current.getY() - 1);
    }

    protected Point moveDownLeft(Point current) {
        return new Point(current.getX() + 1, current.getY() - 1);
    }

    protected Point moveUpRight(Point current) {
        return new Point(current.getX() - 1, current.getY() + 1);
    }

    protected Point moveDownRight(Point current) {
        return new Point(current.getX() + 1, current.getY() + 1);
    }

}
