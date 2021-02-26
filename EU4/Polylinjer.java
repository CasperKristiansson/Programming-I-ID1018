import java.util.ArrayList;

public class Polylinjer {

    public static Polylinje Sortera(Polylinje[] linjer) {

        ArrayList<Polylinje> kortasteGula = new ArrayList<>();

        for (int i = 0; i < linjer.length; i++) {
            // lagra gula polylinjerna i en arraylist
            if (linjer[i].getFarg().equals("Yellow")) {
                kortasteGula.add(linjer[i]);
            }
        }

        Polylinje[] denKortasteGula = new Polylinje[kortasteGula.size()];
        denKortasteGula = kortasteGula.toArray(denKortasteGula);

        // bestäm den kortaste av de polylinjer som är gula
        for (int i = 0; i < denKortasteGula.length - 1; i++) {
            denKortasteGula[0] = (denKortasteGula[i].langd() < denKortasteGula[i + 1].langd()) ? denKortasteGula[i]
                    : denKortasteGula[i + 1];
        }

        return denKortasteGula[0];
    }
}