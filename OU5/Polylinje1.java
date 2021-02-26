// {[(A 3 4)(B 1 2)(C 2 3)(D 5 1)], svart, 1}

public class Polylinje1
{
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    // konstruktorn
    public Polylinje1(Punkt[] horn) {
        this.horn = horn;
    }

    public String toString() {
        String punkt = "";
        for(int i = 0; i < this.horn.length; i++){
            punkt = punkt + horn[i];
        }
        punkt = punkt + ", " + farg + ", " + bredd;
        return punkt;
    }

    //returnerar mängden hörn Polylinjen har
    public Punkt[] getHorn() {
        return this.horn;
    }

    //returnerar färgen Polylinjen har
    public String getFarg() {
        return this.farg;
    }

    //returnerar bredden för Polylinjen
    public int getBredd() {
        return this.bredd;
    }

    //sätter en ny färg på Polylinjen
    public void setFarg(String farg) {
        this.farg = farg;
    }

    //sätter en ny bredd på Polylinje
    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    //Funktion som räknar ut den totala längen av Polylinjen
    //for loppen har minus ett då det befinner sig 3 distanser när det finns fyra punkter
    //Loopen räknar ut langd av den första sträcken och sedan fortsätter med de nästa punkterna
    public double langd() {
        double langd = 0;
        for(int i = 0; i < horn.length - 1; i++) {
            int X = horn[i].getX() - horn[i + 1].getX();
            int Y = horn[i].getY() - horn[i + 1].getY();
            langd += Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        }
        return langd;
    }

    //Funktion för att lägga till flera hörn i Polylinjen
    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }

    //Funktion för att lägga till en punkt framför Polylinjen
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int j = 0;
        for(int i = 0; i < this.horn.length; i++) {
            if(this.horn[i].getNamn() == hornNamn) {
                h[j] = horn;
                j++;
            }
            h[j] = this.horn[i];
            j++;
        }
        this.horn = h;
    }

    //Funktion tar bort en punkt i Polylinjen
    public void taBort (String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length - 1];
        int i = 0;
        int j = 0;
        while(i < this.horn.length) {
            if (this.horn[i].getNamn() == hornNamn) {
                i++;
            } else {
                h[j] = this.horn[i];
                i++;
                j++;
            }
        }
        this.horn = h;
    }
}