import java.util.ArrayList;
import java.util.Iterator;

public class VPolylinje implements Polylinje {

    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    @Override
    public Punkt[] getHorn() {
        Punkt[] h = new Punkt[this.horn.length];

        for (int i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];
        }

        return h;
    }

    // konstruktorn
    public VPolylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];

        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt(horn[i]);
    }

    @Override
    public String getFarg() {
        String fargen = this.farg;
        return fargen;
    }

    @Override
    public int getBredd() {
        int bredden = this.bredd;
        return bredden;
    }

    @Override
    public double langd() {
        double addera = 0;

        for (int i = 0; i < this.horn.length - 1; i++) {
            double[] langder = new double[this.horn.length - 1];

            langder[i] = this.horn[i].avstand(this.horn[i + 1]);

            addera += langder[i];
        }

        return addera;
    }

    @Override
    public void setFarg(String farg) {
        this.farg = farg;
    }

    @Override
    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    @Override
    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;

        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];

        h[i] = new Punkt(horn);
        this.horn = h;
    }

    @Override
    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int pos = 0;

        for (int i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];
            if (hornNamn == this.horn[i].getNamn()) {
                pos = i;
                h[pos] = horn;
            }
        }

        for (int i = pos + 1; i < this.horn.length + 1; i++) {
            h[i] = this.horn[i - 1];
        }

        this.horn = h;
    }

    @Override
    public void taBort(String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];

        for (int i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];

            if (hornNamn == this.horn[i].getNamn()) {
                for (int j = i; j < this.horn.length - 1; j++) {
                    h[j] = this.horn[j + 1];
                }
                i = this.horn.length;
            }
        }
        this.horn = h;
    }

    @Override
    public Iterator<Punkt> iterator() {
        ArrayList<Punkt> punktLista = new ArrayList<>();
        for (int i = 0; i < this.horn.length; i++) {
            punktLista.add(this.horn[i]);
        }

        Iterator<Punkt> punkter = punktLista.iterator();

        while (punkter.hasNext()) {
            Punkt x = punkter.next();
            System.out.println(x);
        }

        return punkter;
    }

    public String toString() {
        String punkt = "";
        for (int i = 0; i < this.horn.length; i++) {
            punkt = punkt + horn[i];
        }
        punkt = punkt + ", " + farg + ", " + bredd;
        return punkt;
    }
}