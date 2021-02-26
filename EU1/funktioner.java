// min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
import java.util.*;
public class funktioner {

    public static int min (int[] element) throws IllegalArgumentException {

        if (element.length == 0)
            throw new IllegalArgumentException ("tom samling");

        // hör ihop med spårutskriften 2:
        // int antalVarv = 1;
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;
        while (antaletTankbaraElement > 1)
        {
            // skilj ur en delsekvens med de tänkbara elementen
                i = 0;
                j = 0;
            while (j < antaletPar)
            {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[antaletPar*2];
                
            sekvens[0] = (sekvens[0] < sekvens[1])? sekvens[0] : sekvens[1];
            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;
            System.out.println (java.util.Arrays.toString (sekvens));

            // spårutskrift 1 – för att följa sekvensen
            // System.out.println (java.util.Arrays.toString (sekvens));
            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);
        }
        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);

		System.out.println("Läng på Array");
        int antalTal =  input.nextInt();
        
		int [] tal = new int[antalTal];
		System.out.println("Tal:");
		for(int i = 0; i < antalTal; i++) {
			tal[i] = input.nextInt();
        }
        int minsta = min(tal);
        input.close();
        
        System.out.println("Minsta talet" + minsta);        
    }
    public static int minsta (int[]element) {
        int minsta = element[0];

        for(int i = 0; i < element.length; i++) {
            minsta = (element[i] < minsta)? element[i] : minsta;
        }
        return minsta;
    }
}