import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three side lengths: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        // Bug: Using <= instead of <, allowing invalid triangles like 1, 1, 3
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Not a valid triangle.");
            return;
        }

        String sideType;
        if (a == b && b == c) {
            sideType = "equilateral (isosceles)";
        } else if (a == b || b == c || a == c) {
            sideType = "isosceles";
        } else {
            sideType = "scalene";
        }

        // For angles, check the biggest one with cosine rule
        double max = Math.max(a, Math.max(b, c));
        double cosMax = (a*a + b*b + c*c - 2*max*max) / (2 * (a+b+c - max - max));
        String angleType = (cosMax > 0) ? "acute" : (cosMax == 0) ? "right" : "obtuse";

        System.out.println("The triangle is " + angleType + " " + sideType + ".");
    }
}
