public class TriangelFunktioner {
    public static double  hypotenusanTriangel(double kortaSida, double kortaSida2) {
        double hypotenusan = Math.sqrt(kortaSida*kortaSida+kortaSida2*kortaSida2);
        return hypotenusan;
    }
    public static double areaTriangel(double hojdTriangel, double  breddTriangel) {
        double area = (hojdTriangel*breddTriangel)/2;
        return area;
    }
    public static double omkretsTriangel(double sida1, double sida2, double sida3) {
        double omkrets = sida1 + sida2 + sida3;
        return omkrets;
    }
    public static double bisektrisAlfa (double b, double c, double alfa) {
        double p = 2 * b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);
        return bis;
    }
    public static double bisektrisBeta (double a, double c, double beta) {
        double p = 2 * a * c * Math.cos (beta / 2);
        double bis = p / (a + c);
        return bis;
    }
    public static double bisektrisCharlie (double a, double b, double charlie) {
        double p = 2 * b * a * Math.cos (charlie / 2);
        double bis = p / (b + a);
        return bis;
    }
}
