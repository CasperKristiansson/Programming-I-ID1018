public class PolylinjeTest {
    public static void main(String[] args) {
        Polylinje p = new Polylinje();
		
		p.laggTill(new Punkt("A", 3, 4));
		p.laggTill(new Punkt("C", 3, 2));
		System.out.println(p.toString());
		
		p.laggTillFramfor((new Punkt("B", 5, 6)),"C");
		System.out.println(p.toString());
		p.laggTill((new Punkt("D", 6, 7)));
		System.out.println(p.toString());
		
		p.setFarg("blå");
		p.setBredd(10);

		p.taBort("C");

		System.out.println(p.toString());
		System.out.println(p.langd());

        Polylinje.PolylinjeIterator iterator = p.new PolylinjeIterator();
        iterator.printPunkt();
    }
}