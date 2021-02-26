public class Punkt
{
    public String namn;
    public int x;
    public int y;

    Punkt(String newNamn, int newX, int newY)
    {
        namn = newNamn;
        x = newX;
        y = newY;
    }

    public String getNamn() 
    {
        return namn;
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }

    public double avstand(Punkt p2)
    {
        int nyX = p2.getX() - x;
        int nyY = p2.getY() - y;

        double distance = Math.sqrt(Math.pow(nyX,2) + Math.pow(nyY, 2));

        return distance;
    }

    public int setX(int nyttX)
    {
        x = nyttX;

        return x;
    }

    public int setY(int nyttY)
    {
        y = nyttY;

        return y;
    }

    Punkt(Punkt nyPunkt)
    {
        namn = nyPunkt.namn;
        x = nyPunkt.x;
        y = nyPunkt.y;
    }

    public String toString() 
    {
        return "(" + this.namn + " " + this.x + " " + this.y + ")";
    }
}
