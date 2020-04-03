

public class Lab1T extends Functii {

    public static void main(String arg[]) {
        //initializare variabila pentru calcularea runtime-ului
        long startTime = System.nanoTime();
        if (validareIntregi(arg) && validareLitere(arg)) {
            //initializare variabile
            int n = Integer.parseInt(arg[0]);
            int k = Integer.parseInt(arg[1]);
            //creare arr alfabet
            String[] alfabet = new String[arg.length - 2];
            creareAlf(arg, alfabet);
            //creare cuvinte
            String[] words = new String[n];
            genereazaCuv(words, arg, n, k);
            //afisare cuvinte
            afisare(words);
            //creare matrice de adiacenta
            int[][] adiacenta = new int[n][n];
            creareAdiacenta(adiacenta, words, alfabet);
            //afisare adiacenta
            afisareAdiacenta(adiacenta);
            //afisare numar maxim vecini
            int maxVec = maxVecini(adiacenta);
            System.out.print("Nr minim de vecini este: " + maxVec + "\n");
            //afisare numar minim vecini
            int minVec = minVecini(adiacenta);
            System.out.print("Nr minim de vecini este: " + minVec + "\n");
            if (minVec == maxVec) {
                System.out.print("Cuvintele au acelasi nr de vecini'\n");
            } else System.out.print("Cuvintele nu au acelasi nr de vecini\n");
            //calcularea timpului de executie al aplicatiei
            long endTime = System.nanoTime();
            long timpApp = endTime - startTime;
            System.out.print("Timpul total de rulare al aplicatiei in nanosecunde este: " + timpApp + "\n");
        } else {
            //calcularea timpului de executie al aplicatiei
            long endTime = System.nanoTime();
            long timpApp = endTime - startTime;
            System.out.print("Timpul total de rulare al aplicatiei in nanosecunde este: " + timpApp + "\n");
        }


    }

}
