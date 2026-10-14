package Lab1;
//Intermediate

public class Rectangle {

    // EXPLAIN: fields = the state of each rectangle
    double width;
    double height;

    // EXPLAIN: returns this rectangle's area
    double area() {
        return width * height;
    }

    // EXPLAIN: returns this rectangle's perimeter
    double perimeter() {
        return 2 * (width + height);
    }

    void display() {
        System.out.println("Width: " + width + ", Height: " + height
                + ", Area: " + area() + ", Perimeter: " + perimeter());
    }

    public static void main(String[] args) {
        // EXPLAIN: this creates 5 empty slots (all null), NOT 5 rectangles yet
        Rectangle[] rects = new Rectangle[5];

        double[][] sizes = {{22, 3}, {4, 5}, {12, 10}, {6, 2}, {35, 3}};

        // EXPLAIN: each slot needs its own 'new Rectangle()'
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();
            rects[i].width = sizes[i][0];
            rects[i].height = sizes[i][1];
            rects[i].display();
        }

        // EXPLAIN: 'largest' holds a reference to the biggest rectangle found so far
        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }

        System.out.println("Largest rectangle:");
        largest.display();
    }

}
