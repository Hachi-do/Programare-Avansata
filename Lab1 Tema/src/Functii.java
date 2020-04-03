import java.lang.reflect.Array;
import java.util.Arrays;

public class Functii {
    public static void afisare(String arr[]) {
        //afisare cuvinte
        for (int j = 0; j < arr.length; j++) {
            System.out.print("" + arr[j] + "\n");
        }
    }

    public static void genereazaCuv(String words[], String arg[], int n, int k) {
        for (int i = 0; i < n; i++) {
            words[i] = "";
            for (int j = 0; j < k; j++) {
                int randomInt = (int) (10.0 * Math.random());
                while (randomInt < 2 || randomInt > (arg.length - 1)) {
                    randomInt = (int) (10.0 * Math.random());
                }
                words[i] = arg[randomInt] + words[i];
            }

        }
    }

    public static boolean validareIntregi(String arg[]) {
        //verificare daca n si ca sunt intregi
        try {
            int n = Integer.parseInt(arg[0]);
            int k = Integer.parseInt(arg[1]);
            System.out.print("N si K sunt intregi\n");
            return true;
        } catch (NumberFormatException nfe) {
            System.out.print("N si K nu sunt numere intregi " + nfe.getMessage() + "\n");
            return false;
        }
    }

    public static boolean validareLitere(String arg[]) {
        //verificare daca alfabetul este valid
        int verif = -1;
        for (int i = 2; i < arg.length; i++) {
            char litera = arg[i].charAt(0);
            if (!Character.isLetter(litera)) {
                System.out.print("Nu avem un alfabet corect, " + arg[i] + " nu este litera\n");
                break;
            }
            verif = i;
        }
        if (verif == arg.length - 1) {
            System.out.print("Alfabet corect\n");
            return true;
        } else return false;
    }

    public static void creareAlf(String arg[], String alfabet[]) {
        for (int i = 2; i < arg.length; i++) {
            alfabet[i - 2] = "" + arg[i];
        }
    }

    public static void creareAdiacenta(int adiacenta[][], String words[], String alfabet[]) {

        //arr frecv pt alfabetul dat
        int[] frecv = new int[128];
        for (int i = 0; i < words.length - 1; i++) {
            boolean adiacente = false;
            for (int j = i + 1; j < words.length; j++) {
                for (int k = 0; k < alfabet.length; k++) {
                    //daca words de i contine litera de pe pozitia k din alfabet
                    if (new String(words[i]).contains(alfabet[k])) {
                        //daca words de j contine litera de pe pozitia k din alfabet
                        if (new String(words[j]).contains((alfabet[k]))) {
                            adiacente = true;
                        }
                    }
                    if (adiacente) {
                        adiacenta[i][j] = adiacenta[j][i] = 1;
                    }
                }
            }

        }
    }

    public static void afisareAdiacenta(int adiacenta[][]) {
        System.out.println("Matricea de adiacenta este:");
        for (int i = 0; i < adiacenta.length; i++) {
            for (int j = 0; j < adiacenta.length; j++) {
                System.out.print("" + adiacenta[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int maxVecini(int adiacenta[][]) {
        int max = 0;
        for (int i = 0; i < adiacenta.length; i++) {
            int nrVecini = 0;
            for (int j = 0; j < adiacenta.length; j++) {
                nrVecini += adiacenta[i][j];
            }
            if (max < nrVecini) max = nrVecini;
        }

        return max;
    }

    public static int minVecini(int adiacenta[][]) {
        int min = adiacenta.length;
        for (int i = 0; i < adiacenta.length; i++) {
            int nrVecini = 0;
            for (int j = 0; j < adiacenta.length; j++) {
                nrVecini += adiacenta[i][j];
            }
            if (min > nrVecini) min = nrVecini;
        }

        return min;
    }
}
