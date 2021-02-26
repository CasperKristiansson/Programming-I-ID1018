
import java.util.*; // Scanner, Locale
class Temperaturer
{
 public static void main (String[] args) {
    System.out.println ("TEMPERATURER\n");

     // inmatningsverktyg
    Scanner in = new Scanner (System.in);
    in.useLocale (Locale.US);

    // mata in uppgifter om antalet veckor och antalet mätningar
    System.out.print ("antalet veckor: ");
    int antalVeckor = in.nextInt ();
    System.out.print ("antalet mätningar per vecka: ");
    int antalMatningarPerVecka = in.nextInt ();

    // plats att lagra temperaturer
    double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

    // mata in temperaturerna
    for (int vecka = 1; vecka <= antalVeckor; vecka++) {
        System.out.println ("temperaturer - vecka " + vecka + ":");
        for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
             t[vecka][matning] = in.nextDouble ();
            }
     System.out.println ();
 
     // visa temperaturerna
     System.out.println ("temperaturerna:");
    for (int vecka = 1; vecka <= antalVeckor; vecka++) {
        for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
        System.out.print (t[vecka][matning] + " ");
        System.out.println ();
    }
    System.out.println ();

     // den minsta, den största och medeltemperaturen – veckovis
    double[] minT = new double[antalVeckor + 1];
    double[] maxT = new double[antalVeckor + 1];
    double[] sumT = new double[antalVeckor + 1];
    double[] medelT = new double[antalVeckor + 1];

    // visa den minsta, den största och medeltemperaturen för varje vecka
    for (int i = 1; i <= antalVeckor; i++) {
        minT[i] = t[i][1];
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            if (t[i][x] < minT[i]) {
                minT[i] = t[i][x];
            }
        }
    }
    for (int i = 1; i <= antalVeckor; i++) {
        maxT[i] = t[i][1];
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            if (t[i][x] > maxT[i]) {
                maxT[i] = t[i][x];
            }
        }
    }
    for (int i = 1; i <= antalVeckor; i++) {
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            sumT[i] += t[i][x];
        }
        medelT[i] = sumT[i]/(antalMatningarPerVecka);
    }
    for (int i = 1; i <= antalVeckor; i++) {
        System.out.println("Statistik från vecka " + i);
        System.out.println("Minsta: " + minT[i]);
        System.out.println("Medel: " + medelT[i]);
        System.out.println("Max: " + maxT[i]);
        System.out.println("Summa: " + sumT[i]);
        System.out.println();
    }

    // den minsta, den största och medeltemperaturen - hela mätperioden
    double minTemp = minT[1];
    double maxTemp = maxT[1];
    double sumTemp = sumT[1];
    double medelTemp = 0;

    // visa den minsta, den största och medeltemperaturen i hela mätperioden
    for (int i = 2; i <= antalVeckor; i++) {
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            if (t[i][x] < minTemp) {
                minTemp = t[i][x];
            }
        }
    }
    for (int i = 2; i <= antalVeckor; i++) {
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            if (t[i][x] > maxTemp) {
                maxTemp = t[i][x];
            }
        }
    }
    for (int i = 2; i <= antalVeckor; i++) {
        for (int x = 1; x <= antalMatningarPerVecka; x++) {
            sumTemp += t[i][x];
        }
    }
    medelTemp = sumTemp/(antalMatningarPerVecka * antalVeckor);
    System.out.println("Statistik för alla veckor");
    System.out.println("Max: " + maxTemp);
    System.out.println("Min: " + minTemp);
    System.out.println("Medelvärde: " + medelTemp);
    System.out.println("Summa: " + sumTemp);
    in.close();
    }
}