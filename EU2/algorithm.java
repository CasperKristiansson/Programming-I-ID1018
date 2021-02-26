import static java.lang.System.out; 
import java.util.Arrays;
public class algorithm {
    public static void main(String[] args) {

        int[] lista = new int[] {5, 4, 3, 2, 1};
        out.println(Arrays.toString(lista));
        lista = sort(lista);
        out.println(Arrays.toString(lista));
    }

    public static int[] sort(int[] lista) {
        for(int i = 0; i < lista.length; i++) {
            for(int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[i]) {
                    System.out.println(lista[j]);
                    System.out.println(lista[i]);
                    int b = lista[j];
                    lista[j] = lista[i];
                    lista[i] = b;
                    out.println(Arrays.toString(lista));
                    System.out.println("-------------");
                    
                }
            }
        }
        return lista;
    }
}