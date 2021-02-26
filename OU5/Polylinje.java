public class Polylinje {

    // Temporära värden som kan användas för en polylinje
    private Punkt[] horn;
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje() {
        this.horn = new Punkt[0];
    }
    
    // Lägger till nya hörn
    public Polylinje(Punkt[] horn) {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }

    // Klass som gör om out.print till en Sträng och printar ut
    public String toString() {
        String punkt = "";
        for(int i = 0; i < this.horn.length; i++){
            punkt = punkt + horn[i];
        }
        punkt = punkt + ", " + farg + ", " + bredd;
        return punkt;
    }

    // returnerar de olika hörn Polylinjen har
    public Punkt[] getHorn() {
        Punkt[] h = new Punkt[this.horn.length];
        for (int i = 0; i < this.horn.length; i++){
            h[i] = this.horn[i];
        }
        return h;
    }

    // returnerar färgen Polylinjen genom att sätta ett nytt värde på en variabel
    public String getFarg() {
        String fargen = this.farg;
        return fargen;
    }

    // returnerar bredden för Polylinjen genom att sätta ett nytt värde på en variabel
    public int getBredd() {
        int bredden = this.bredd;
        return bredden;
    }

    // sätter en ny färg på Polylinjen genom att sätta ett nytt värde på en variabel
    public void setFarg(String farg) {
        this.farg = farg;
    }

    //sätter en ny bredd på Polylinje genom att sätta ett nytt värde på en variabel
    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    // Funktion som räknar ut den totala längen av Polylinjen
    // for loppen har minus ett då det befinner sig 3 distanser när det finns fyra punkter
    // Loopen räknar ut langd av den första sträcken och sedan fortsätter med de nästa punkterna
    public double langd() {
        double langd = 0;
        for(int i = 0; i < horn.length - 1; i++) {
            int X = horn[i].getX() - horn[i + 1].getX();
            int Y = horn[i].getY() - horn[i + 1].getY();
            langd += Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        }
        return langd;
    }

    // Funktionen för att lägga till flera hörn i Polylinjen genom att skappa en temporär ny array
    public void laggTill(Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }

    // Funktionen för att lägga till en punkt framför en annan punkt i Polylinjen
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

    // Funktionen tar bort en punkt i Polylinjen genom att skapa en ny temporär array som sedan kopieras över
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

    // Iteration funktionen som går igenom alla de olika punkternas hörn och sedan printar ut deras värde
    public class PolylinjeIterator {
        private int aktuell = -1;

        // Om det finns hörn så blir aktuella värde = 0
        public PolylinjeIterator() {
            if (Polylinje.this.horn.length > 0)
            aktuell = 0;
        }

        // Alltså om det finns hörn så, returneras true
        public boolean finnsHorn (){
            return aktuell != -1;
        }

        // Om det inte finns fler hörn så fortästter detta
        public Punkt horn() throws java.util.NoSuchElementException {
            if (!this.finnsHorn ())
            throw new java.util.NoSuchElementException ("slut av iterationen");
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;
        }

        // Genom att gått igenom nuvarande hörnet så kollar den om det finns flera hörn i arrayen
        public void gaFram() {
            if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1){
            aktuell++;
            } else 
            aktuell = -1;
        }

        // Funktionen för att printa ut den nuvarande hörnet som funtktionen går igenom
        public void printPunkt() {
            while(this.finnsHorn())
            {
                System.out.println(this.horn());
                gaFram();
            }
        }
    }
}