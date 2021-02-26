import java.util.*;
public class Triangel {
    public static void main (String[] args) {

        TriangelFunktioner x = new TriangelFunktioner();

        Scanner input = new Scanner(System.in);

        System.out.println("Vilken Form, 1,2,3... Rätvinklig, Likbent, Trubb/Spetsig");
        int formTriangel = input.nextInt();

        switch(formTriangel) {
            case 1:
                System.out.println("välj 1,2,3... Hypotenusan, omkrets, Area, bisektris");
                int val = input.nextInt();
                switch(val) {
                    case 1:
                        System.out.println("Skriv in sidorna på olika rader");
                        double kortaSida = input.nextDouble();
                        double kortaSida2 = input.nextDouble();
                        System.out.println(TriangelFunktioner.hypotenusanTriangel(kortaSida, kortaSida2));
                        break;
                    case 2:
                        System.out.println("Skriv in sidorna på olika rader");
                        double sida1 = input.nextDouble();
                        double sida2 = input.nextDouble();
                        double sida3 = input.nextDouble();
                        System.out.println(TriangelFunktioner.omkretsTriangel(sida1, sida2, sida3));
                        break;
                    case 3:
                        System.out.println("Skriv in Bredd och Höjd på olika rader");
                        double hojdTriangel = input.nextDouble();
                        double breddTriangel = input.nextDouble();
                        System.out.println(TriangelFunktioner.areaTriangel(hojdTriangel, breddTriangel));
                        break;
                    case 4:
                        System.out.println("Bisektriserna, Skriv in a, b, c och alfa (b-c), beta (a-c), charlie (b-a)");
                        double a = input.nextDouble();
                        double b = input.nextDouble();
                        double c = input.nextDouble();
                        double alfa = input.nextDouble();
                        double beta = input.nextDouble();
                        double charlie = input.nextDouble();
                        System.out.println(TriangelFunktioner.bisektrisAlfa(b, c, alfa));
                        System.out.println(TriangelFunktioner.bisektrisBeta(a, c, beta));
                        System.out.println(TriangelFunktioner.bisektrisCharlie(a, b, charlie));
                        break;
                }
                break;
            case 2:
                System.out.println("välj 1,2,3... Area, omkrets, bisektris");
                int val2 = input.nextInt();
                switch(val2) {
                    case 1:
                        System.out.println("Skriv in Bredd och Höjd på olika rader");
                        double hojdTriangel = input.nextDouble();
                        double breddTriangel = input.nextDouble();
                        System.out.println(TriangelFunktioner.areaTriangel(hojdTriangel, breddTriangel));
                        break;
                    case 2:
                        System.out.println("Skriv in sidorna på olika rader");
                        double sida1 = input.nextDouble();
                        double sida2 = input.nextDouble();
                        double sida3 = input.nextDouble();
                        System.out.println(TriangelFunktioner.omkretsTriangel(sida1, sida2, sida3));
                        break;
                    case 3:
                        System.out.println("Bisektriserna, Skriv in a, b, c och alfa (b-c), beta (a-c), charlie (b-a)");
                        double a = input.nextDouble();
                        double b = input.nextDouble();
                        double c = input.nextDouble();
                        double alfa = input.nextDouble();
                        double beta = input.nextDouble();
                        double charlie = input.nextDouble();
                        System.out.println(TriangelFunktioner.bisektrisAlfa(b, c, alfa));
                        System.out.println(TriangelFunktioner.bisektrisBeta(a, c, beta));
                        System.out.println(TriangelFunktioner.bisektrisCharlie(a, b, charlie));
                        break;
                }
                break;
            case 3:
                System.out.println("välj 1,2,3... Bisektris");
                int val3 = input.nextInt();
                switch(val3) {
                case 1:
                    System.out.println("Bisektriserna, Skriv in a, b, c och alfa (b-c), beta (a-c), charlie (b-a)");
                    double a = input.nextDouble();
                    double b = input.nextDouble();
                    double c = input.nextDouble();
                    double alfa = input.nextDouble();
                    double beta = input.nextDouble();
                    double charlie = input.nextDouble();
                    System.out.println(TriangelFunktioner.bisektrisAlfa(b, c, alfa));
                    System.out.println(TriangelFunktioner.bisektrisBeta(a, c, beta));
                    System.out.println(TriangelFunktioner.bisektrisCharlie(a, b, charlie));
                    break;
                }
                break;                
        }
        input.close();
    }
}