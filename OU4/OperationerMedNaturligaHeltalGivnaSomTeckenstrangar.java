import java.util.*;
import static java.lang.System.out;
class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
    public static void main(String[] args) {

        System.out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);

        System.out.println("Addera(1) eller subtrahera(2)");
        int operation = in.nextInt();

        // addera heltalen och visa resultatet
        if(operation == 1) {
        System.out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        System.out.println();

        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');
        }

        // subtrahera heltalen och visa resultatet
        if(operation == 2) {
            System.out.println("två naturliga heltal:");
            String tal1 = in.next();
            String tal2 = in.next();
            System.out.println();

            String summa = subtrahera(tal1, tal2);
            visa(tal1, tal2, summa, '-');
            }
        in.close();
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2) {
        String tal1Omvand = "";
        for(int i = tal1.length() - 1; i >= 0; i--){
            tal1Omvand = tal1Omvand + tal1.charAt(i);
        }
        String tal2Omvand = "";
        for(int i = tal2.length()- 1; i >= 0; i--){
            tal2Omvand = tal2Omvand + tal2.charAt(i);
        }

        int tempVarde = 0;
        String summaString = "";
        if (tal1Omvand.length() >= tal2Omvand.length()) {
            for(int i = 0; i < tal2Omvand.length(); i++) {
                int tal1Int = Integer.parseInt(String.valueOf(tal1Omvand.charAt(i)));
                int tal2Int = Integer.parseInt(String.valueOf(tal2Omvand.charAt(i)));

                int summa = tal1Int + tal2Int + tempVarde;
                tempVarde = 0;

                if(summa >= 10) {
                    summa = summa - 10;
                    tempVarde = 1;
                } else tempVarde = 0;
                summaString = String.valueOf(summa) + summaString;
            }
            for(int j = tal2Omvand.length(); j < tal1Omvand.length(); j++) {
                int tal1Int = Integer.parseInt(String.valueOf(tal1Omvand.charAt(j)));
                int summa = tal1Int + tempVarde;
                tempVarde = 0;

                summaString = String.valueOf(summa) + summaString;
            }
            if(tal1Omvand.length() == tal2Omvand.length()) {
                summaString = tempVarde + summaString;
            }
        } else {
            for(int i = 0; i < tal1Omvand.length(); i++) {
                int tal1Int = Integer.parseInt(String.valueOf(tal1Omvand.charAt(i)));
                int tal2Int = Integer.parseInt(String.valueOf(tal2Omvand.charAt(i)));

                int summa = tal1Int + tal2Int + tempVarde;
                tempVarde = 0;

                if(summa >= 10) {
                    summa = summa - 10;
                    tempVarde = 1;
                } else tempVarde = 0;
                summaString = String.valueOf(summa) + summaString;
            }
            for(int j = tal1Omvand.length(); j < tal2Omvand.length(); j++) {
                int tal2Int = Integer.parseInt(String.valueOf(tal2Omvand.charAt(j)));
                int summa = tal2Int + tempVarde;
                tempVarde = 0;

                summaString = String.valueOf(summa) + summaString;
            }
        }
        return summaString.replaceFirst("0", "");
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera(String tal1, String tal2) {
        String tal1Omvand = "";
        for(int i = tal1.length() - 1; i >= 0; i--){
            tal1Omvand = tal1Omvand + tal1.charAt(i);
        }
        String tal2Omvand = "";
        for(int i = tal2.length()- 1; i >= 0; i--){
            tal2Omvand = tal2Omvand + tal2.charAt(i);
        }

        int tempVarde = 0;
        String summaString = "";

        for(int i = 0; i < tal2Omvand.length(); i++) {
            int tal1Int = Integer.parseInt(String.valueOf(tal1Omvand.charAt(i)));
            int tal2Int = Integer.parseInt(String.valueOf(tal2Omvand.charAt(i)));

            int summa = tal1Int - tal2Int - tempVarde;
            tempVarde = 0;

            if(summa < 0) {
                summa = summa + 10;
                tempVarde = 1;
            } else tempVarde = 0;

            summaString = String.valueOf(summa) + summaString;
        }
        for(int j = tal2Omvand.length(); j < tal1Omvand.length(); j++) {
            int tal1Int = Integer.parseInt(String.valueOf(tal1Omvand.charAt(j)));
            int summa = tal1Int - tempVarde;
            tempVarde = 0;

            if(summa < 0) {
			    summa = summa + 10;
			    tempVarde = 1;
            } else tempVarde = 0;

            summaString = String.valueOf(summa) + summaString;
            summaString = summaString.replace("-", "");
        }
        return summaString.replaceFirst("0", "");
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2, String resultat, char operator) {

        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length ();
        int len2 = tal2.length ();
        int len = resultat.length ();
        int maxLen = Math.max (Math.max (len1, len2), len);

        tal1 = sattLen (tal1, maxLen - len1);
        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);

        // visa heltalen och resultatet
        System.out.println (" " + tal1);
        System.out.println ("" + operator + "" + tal2);

        for (int i = 0; i < maxLen + 2; i++)
            System.out.print ("-");
            System.out.println ();
            System.out.println (" " + resultat + "\n");
    }
    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal) {

    StringBuilder sb = new StringBuilder (s);
    for (int i = 0; i < antal; i++)
    sb.insert (0, " ");

    return sb.toString ();
    }
}