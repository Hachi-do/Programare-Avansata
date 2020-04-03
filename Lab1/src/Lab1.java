public class Lab1 {



    public static void main(String[] drodo) {
        System.out.print("Hello, world!\n");
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        int result=n;
        while (result>=10) {
            int suma=0;
            while(result>0){
                suma=suma+result%10;
                result/=10;

            }
            result=suma;
        }

        System.out.print("Willy-nilly, this semester I will learn " + languages[result]);

    }
}

