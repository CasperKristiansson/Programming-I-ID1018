import java.util.Iterator;
import java.util.LinkedList;

public class NPolylinje implements Polylinje {

   private static class Nod {
      public Punkt horn;
      public Nod nastaNod;

      public Nod(Punkt horn) {
         this.horn = horn;
         nastaNod = null;
      }
   }

   private Nod horn;
   private String farg = "svart";
   private int bredd = 1; // pixlar

   LinkedList<Nod> nodLista = new LinkedList<>();

   public NPolylinje() {
      this.horn = null;
   }

   public NPolylinje(Punkt[] horn) {
      if (horn.length > 0) {
         Nod nod = new Nod(new Punkt(horn[0]));
         this.horn = nod;
         nodLista.add(nod);
         int pos = 1;
         while (pos < horn.length) {
            nod.nastaNod = new Nod(new Punkt(horn[pos++]));
            nod = nod.nastaNod;
            nodLista.add(nod);
         }
      }
   }

   @Override
   public Punkt[] getHorn() {
      Punkt[] h = new Punkt[nodLista.size()];

      for (int i = 0; i < nodLista.size(); i++) {
         h[i] = nodLista.get(i).horn;
      }

      return h;
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

      for (int i = 0; i < nodLista.size() - 1; i++) {
         double[] langder = new double[nodLista.size() - 1];

         langder[i] = nodLista.get(i).horn.avstand(nodLista.get(i + 1).horn);

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
      Nod a = new Nod(new Punkt (horn));

      nodLista.addLast(a);
   }

   @Override
   public void laggTillFramfor(Punkt horn, String hornNamn) {
      LinkedList<Nod> lin = new LinkedList<>();
      Nod a = new Nod(new Punkt (horn));
      int pos = 0;

      for(int i = 0; i < nodLista.size(); i++){
         Nod b = new Nod(nodLista.get(i).horn);
         if(hornNamn.equals(nodLista.get(i).horn.getNamn())){
            lin.add(a);
            pos = i;
            break;
         }
         lin.add(b);
      }
      for(int i = pos; i < nodLista.size(); i++){
         Nod b = new Nod(nodLista.get(i).horn);
         lin.add(b);
      }
      nodLista.clear();

      for(int i = 0; i < lin.size(); i++){
         Nod b = new Nod(lin.get(i).horn);
         nodLista.add(b);
      }
   }

   @Override
   public void taBort(String hornNamn) {
      LinkedList<Nod> lin = new LinkedList<>();

      for(int i = 0; i < nodLista.size(); i++){
         if(hornNamn.equals(nodLista.get(i).horn.getNamn())){
            i++;
         }
         Nod b = new Nod(nodLista.get(i).horn);
         lin.add(b);
      }
      nodLista.clear();

      for(int i = 0; i < lin.size(); i++){
         Nod b = new Nod(lin.get(i).horn);
         nodLista.add(b);
      }
   }

   @Override
   public Iterator<Punkt> iterator() {
      LinkedList<Punkt> punktLista = new LinkedList<>();
      for (int i = 0; i < nodLista.size(); i++) {
         punktLista.add(nodLista.get(i).horn);
      }

      Iterator<Punkt> punkter = punktLista.iterator();

      while (punkter.hasNext()) {
         Punkt x = punkter.next();
         System.out.println(x);
      }

      return punkter;
   }

   public String toString() {
      String poly = "[";

      for (int i = 0; i < nodLista.size(); i++) {
         poly = poly + nodLista.get(i).horn;
      }
      poly = poly + "]" + ", " + farg + ", " + bredd;

      return poly;
   }
}
