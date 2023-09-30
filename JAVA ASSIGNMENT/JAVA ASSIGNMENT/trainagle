public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean isRight() {
        return (side1 * side1 + side2 * side2 == side3 * side3) ||
               (side1 * side1 + side3 * side3 == side2 * side2) ||
               (side2 * side2 + side3 * side3 == side1 * side1);
    }

    public boolean isScalene() {
        return !((side1 == side2) || (side1 == side3) || (side2 == side3));
    }

    public boolean isIsosceles() {
        return (side1 == side2 && side1 != side3) ||
               (side1 == side3 && side1 != side2) ||
               (side2 == side3 && side2 != side1);
    }

    public boolean isEquilateral() {
        return (side1 == side2) && (side1 == side3);
    }

    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(5, 5, 5);
        Triangle triangle3 = new Triangle(4, 4, 4);
        Triangle triangle4 = new Triangle(6, 8, 10);

        System.out.println("Triangle 1:");
        System.out.println("Right Triangle: " + triangle1.isRight());
        System.out.println("Scalene Triangle: " + triangle1.isScalene());
        System.out.println("Isosceles Triangle: " + triangle1.isIsosceles());
        System.out.println("Equilateral Triangle: " + triangle1.isEquilateral());

        System.out.println("\nTriangle 2:");
        System.out.println("Right Triangle: " + triangle2.isRight());
        System.out.println("Scalene Triangle: " + triangle2.isScalene());
        System.out.println("Isosceles Triangle: " + triangle2.isIsosceles());
        System.out.println("Equilateral Triangle: " + triangle2.isEquilateral());

        System.out.println("\nTriangle 3:");
        System.out.println("Right Triangle: " + triangle3.isRight());
        System.out.println("Scalene Triangle: " + triangle3.isScalene());
        System.out.println("Isosceles Triangle: " + triangle3.isIsosceles());
        System.out.println("Equilateral Triangle: " + triangle3.isEquilateral());

        System.out.println("\nTriangle 4:");
        System.out.println("Right Triangle: " + triangle4.isRight());
        System.out.println("Scalene Triangle: " + triangle4.isScalene());
        System.out.println("Isosceles Triangle: " + triangle4.isIsosceles());
        System.out.println("Equilateral Triangle: " + triangle4.isEquilateral());
    }
}
