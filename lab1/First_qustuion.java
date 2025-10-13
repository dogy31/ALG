import java.util.Scanner;

public class FirstQustuion{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива (предполагается, что N — четное)
        int N = scanner.nextInt();
        int[] A = new int[N];

        // Ввод коэффициентов полинома
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Размер массива производного полинома будет N-1
        int[] B = new int[N - 1];

        // Вычисление коэффициентов производного полинома
        for (int i = 0; i < N - 1; i++) {
            B[i] = (i + 1) * A[i + 1];
        }

        // Вывод коэффициентов производного полинома
        for (int coeff : B) {
            System.out.print(coeff + " ");
        }
    }
}
