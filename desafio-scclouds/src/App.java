import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao desafio SCC Clouds!");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite o numero da função que deseja realizar:" + "\n" + "1- Fibonacci Recursivo" + "\n"
                + "2- Fibonacci Linear" + "\n" + "3- Numeros Primos Recursivo" + "\n" + "4- Numeros Primos Lineares");
        int menu = keyboard.nextInt();

        if (menu == 1) {
            System.out.println("Digite o numero que você quer avaliar");
            int n = keyboard.nextInt();
            while (n < 0) {
                System.out.println("Valor inválido, digite um numero maior do que 0");
                n = keyboard.nextInt();
            }
            int valorFiboRec = fiboRec(n);
            System.out.println("fibonacci recursivo é " + valorFiboRec);

        } else if (menu == 2) {
            System.out.println("Digite o numero que você quer avaliar");
            int n = keyboard.nextInt();
            while (n < 0) {
                System.out.println("Valor inválido, digite um numero maior do que 0");
                n = keyboard.nextInt();
            }
            int valorFiboLin = fiboLin(n);
            System.out.println("fibonacci linear é " + valorFiboLin);

        } else if (menu == 3) {
            System.out.println("Digite o numero que você quer avaliar");
            int n = keyboard.nextInt();
            while (n < 2) {
                System.out.println("Valor inválido, digite um numero maior do que 1");
                n = keyboard.nextInt();
            }
            primoRec(n);

        } else if (menu == 4) {
            System.out.println("Digite o numero que você quer avaliar");
            int n = keyboard.nextInt();
            while (n < 2) {
                System.out.println("Valor inválido, digite um numero maior do que 1");
                n = keyboard.nextInt();
            }
            primoLin(n);
        }

    }

    public static int fiboRec(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fiboRec(n - 1) + fiboRec(n - 2);
        }
    }

    public static int fiboLin(int n) {

        int array[] = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        int k = 2;
        while (k < n + 1) {
            array[k] = array[k - 1] + array[k - 2];
            k++;
        }
        return array[n];
    }

    public static void primoRec(int n) {

        if (n < 2) {
            return;
        }

        primoRec(n - 1);
        if (ePrimo(n)) {
            System.out.print(n + " ");
        }

    }

    public static boolean ePrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primoLin(int n) {
        if (n < 2) {
            return;
        }
        boolean[] eComposto = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!eComposto[i]) {
                for (int j = i * i; j <= n; j += i) {
                    eComposto[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!eComposto[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
