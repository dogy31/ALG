import java.util.Scanner;

public class ThreeDigitNumber {
    private int digit1;
    private int digit2;
    private int digit3;

    public void init() {
        digit1 = 0; digit2 = 0; digit3 = 0;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую цифру (0-9):");
        digit1 = sc.nextInt();
        System.out.println("Введите вторую цифру (0-9):");
        digit2 = sc.nextInt();
        System.out.println("Введите третью цифру (0-9):");
        digit3 = sc.nextInt();
    }

    public void display() {
        System.out.println("Цифры: " + digit1 + " " + digit2 + " " + digit3);
        System.out.println("Число: " + toNumber());
    }

    public int toNumber() {
        return digit1 * 100 + digit2 * 10 + digit3;
    }

    public int getDigit2() {
        return digit2;
    }

    public void setDigit2(int d) {
        digit2 = d;
    }

    public static ThreeDigitNumber add(ThreeDigitNumber n1, ThreeDigitNumber n2) {
        int sum = n1.toNumber() + n2.toNumber();
        ThreeDigitNumber res = new ThreeDigitNumber();
        if (sum >= 1000) {
            res.init();
        } else {
            res.digit1 = sum / 100;
            res.digit2 = (sum / 10) % 10;
            res.digit3 = sum % 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeDigitNumber num1 = new ThreeDigitNumber();
        ThreeDigitNumber num2 = new ThreeDigitNumber();

        System.out.println("Ввод первого числа:");
        num1.read();

        System.out.println("Ввод второго числа:");
        num2.read();

        System.out.println("Первое число:");
        num1.display();

        System.out.println("Второе число:");
        num2.display();

        ThreeDigitNumber sum = ThreeDigitNumber.add(num1, num2);
        System.out.println("Сумма:");
        sum.display();
    }
}
