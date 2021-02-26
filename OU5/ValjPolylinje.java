import java.util.ArrayList;
import java.util.Random;

class ValjPolylinje {
    public static final Random rand = new Random();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main(String[] args) {

        // Skapar slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        ArrayList<Polylinje> kortasteGula = new ArrayList<>();
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje();

            // Printar ut Polylinjen
            System.out.println("Polylinje " + (i + 1) + ": " + polylinjer[i].toString());

            // Lagrar den gula färgen i en arraylista,
            // Kan ändra Storleken av arrayen efter hur mycket som lagras
            if(polylinjer[i].getFarg() == "Yellow") {
                kortasteGula.add(polylinjer[i]);
            }
        }

        Polylinje[] denKortasteGula = new Polylinje[kortasteGula.size()];
        denKortasteGula = kortasteGula.toArray(denKortasteGula);

        // Enkel sortering för att Kolla efter det minsta värdet av langden genom att kalla på funktionen langd()
        // Sparar värdet i första arrayen
        for(int i = 0; i < denKortasteGula.length; i++) {
            if(denKortasteGula[i].langd() < denKortasteGula[0].langd())
                denKortasteGula[0] = denKortasteGula[i];
        }

        // Printar den kortaste av de gula eller om det inte finns en gul polynom
        if(0 < denKortasteGula.length) {
            System.out.println("\nDen Kortaste gula Polylinjen är: " + denKortasteGula[0] + "\n");
        } else 
            System.out.println("\nDet finns inga linjer som är gula");
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor
    // bokstav i det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt() {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);
        return new Punkt(n, x, y);
    }

    public static String slumpFarg() {
        String[] farger={"Red", "Blue", "Yellow"};
      	Random r = new Random();        
      	int SlumpmassigFarg = r.nextInt(farger.length);
        String polynomFarg = farger[SlumpmassigFarg];

        return polynomFarg;
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje() {
        Polylinje polylinje = new Polylinje();
        int antalHorn = 2 + rand.nextInt(7);

        int i = 0;
        boolean[] valdaNamn = new boolean[26];
        Punkt punktlista = null;

        while (i < antalHorn) {
            punktlista = slumpPunkt();
            int valdaVarden = punktlista.string.charAt(0) - 65;

            if(valdaNamn[valdaVarden] == false) {
                valdaNamn[valdaVarden] = true;
                polylinje.laggTill(punktlista);
                i++;
            }
        }
        // sätt färg
        polylinje.setFarg(slumpFarg());
        return polylinje;
    }
}