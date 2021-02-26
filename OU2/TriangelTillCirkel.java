import java.util.*;

class EnTriangelOchDessCirklar {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv in sidorna av Triangeln på olika rader");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        System.out.println(cirkleRuntTriangel(a, b, c));
        System.out.println(cirkelITriangeln(a, b, c));

        input.close();
    }
    static double cirkleRuntTriangel (double a, double b, double c) {
        double s = (a + b + c) / 2;
        double p = 4 * Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double circleRadie = (a * b * c) / p;
        return circleRadie;
    }
    static double cirkelITriangeln (double a, double b, double c) {
        double s = (a + b + c) / 2;
        double circleRadie = Math.sqrt((s - a) * (s - b) * (s - c) / s);
        return circleRadie;
    }
}
