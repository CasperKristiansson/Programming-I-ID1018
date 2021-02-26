public class Punkt {

    public String namn;
	String string = "";
    int platsX = 0;
    int platsY = 0;

    public double avstand(Punkt p2) {
        int modifiedX = p2.getX() - platsX;
        int modifiedY = p2.getY() - platsY;
        double d = Math.sqrt(Math.pow(modifiedX, 2) + Math.pow(modifiedY, 2));
        return d;
    }

    Punkt(String a, int i, int j) {
        string = a;
        platsX = i;
        platsY = j;
    }

    public String getNamn() {
        return(string);
    }

    public int getX() {
        return(platsX);
    }

    public int getY() {
        return(platsY);
    }

    public int setX(int i) {
        platsX = i;
        return platsX;
    }

    public int setY(int j) {
        platsY = j;
        return platsY;
    }

    public Punkt(Punkt p) {
        platsX = p.platsX;
        platsY = p.platsY;
        string = p.string;
    }
    public String toString() {
        return "(" + string + " " + platsX + " " + platsY + ")";
    }
}
