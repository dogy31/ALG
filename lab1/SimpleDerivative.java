import java.util.Scanner;

public class SimpleDerivative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите чётное число N:");
        int N = scanner.nextInt();

        int[] A = new int[N];
        System.out.println("Введите " + N + " чисел:");
        for (int i = 0; i < N; i++) {`
            A[i] = scanner.nextInt();
        }

        int[] B = new int[N - 1];~
        for (int i = 0; i < N - 1; i++) {
            B[i] = (i + 1) * A[i + 1];
        }

        System.out.println("Коэффициенты производного полинома:");
        for (int val : B) {
            System.out.print(val + " ");
        }
        System.out.println();

        scanner.close();
    }
}
