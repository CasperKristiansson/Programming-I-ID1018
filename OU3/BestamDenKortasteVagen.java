import java.util.*;
class BestamDenKortasteVagen {
    public static void main(String[]args) {

    Scanner in = new Scanner (System.in);
    in.useLocale (Locale.US);

    System.out.println("Hur många stationer finns det för Z2?");
    int Z2 = in.nextInt ();
    System.out.println("Hur många stationer finns det för Z3?");
    int Z3 = in.nextInt ();

    double[][] b = new double[Z2 + 1][Z3 + 1];
    for (int i = 1; i <= Z2; i++) {
        for (int x = 1; x <= Z3; x++) {
            System.out.println ("Distans för Stationer mellan Z2 station " + i + " och Z3 station " + x);
            b[i][x] = in.nextDouble ();
        }
    }

    double[] a = new double[Z2 + 1];
    for (int i = 1; i <= Z2; i++) {
        System.out.println ("Distans för Stationer mellan Z1 och Z2 station " + i);
        a[i] = in.nextDouble();
    }

    double[] c = new double[Z3 + 1];
    for (int i = 1; i <= Z3; i++) {
        System.out.println ("Distans för Stationer mellan Z2 och Z3 station " + i);
        c[i] = in.nextDouble();
    }

    double kortast = DenKortasteVagen.langd(a, b, c);
    int[] stationer = DenKortasteVagen.mellanstationer(a, b, c);

    System.out.println("Den kortaste vägen: " + kortast);
    System.out.println("Mellanstationerna är Z2 Station " + stationer[1] +" och Z3 Station " + stationer[2]);

    in.close();
    }
}