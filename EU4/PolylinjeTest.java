public class PolylinjeTest 
{
    public static void main(String[] args) 
    {
        Polylinje poly = null;
        poly = new VPolylinje
        // poly = new NPolylinje
            ((new Punkt[]{
            new Punkt("A", 5, 6),
            new Punkt("B", 1, 2),
            new Punkt("C", 2, 3),
            new Punkt("D", 5, 1)
        }));

        poly.setFarg("red");
        poly.laggTill(new Punkt("E", 5, 8));
        System.out.println(poly.toString());

        poly.laggTillFramfor(new Punkt ("F", 8, 9), "C");
        System.out.println(poly.toString());
        System.out.println(poly.langd());

        poly.taBort("D");
        System.out.println(poly.toString());

        for (Punkt horn : poly)
            System.out.println(horn);
    }
}
