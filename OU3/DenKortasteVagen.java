public class DenKortasteVagen  {
    public static int[] mellanstationer(double[] a, double[][] b,double[] c){

        double kortast = DenKortasteVagen.langd(a, b, c);
        int[] mellanstationer = new int[3];
        for (int i = 1; i < a.length; i++) {
            for (int x = 1; x < b[1].length; x++) {
                if (a[i] + b[i][x] + c[i] == kortast) {
                    mellanstationer[2] = i;
                    mellanstationer[1] = x;
                }
            }
        }
    return mellanstationer;
    }

    public static double langd(double[] a, double[][] b, double[] c) {

        double kortast = a[1] + b[1][1] + c[1];
        for (int i = 1; i < a.length; i++) {
            for (int x = 1; x < b[1].length; x++) {
                if (a[i] + b[i][x] + c[i] < kortast) {
                    kortast = a[i] + b[i][x] + c[i];
                }
            }
        }
    return kortast;
    }
}